package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class InAppPurchaseEventManager
{
  private static final String AS_INTERFACE = "asInterface";
  private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
  private static final String DETAILS_LIST = "DETAILS_LIST";
  private static final String GET_PURCHASES = "getPurchases";
  private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
  private static final String GET_SKU_DETAILS = "getSkuDetails";
  private static final String INAPP = "inapp";
  private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
  private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
  private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
  private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
  private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
  private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
  private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
  private static final String LAST_LOGGED_TIME_SEC = "LAST_LOGGED_TIME_SEC";
  private static final int MAX_QUERY_PURCHASE_NUM = 30;
  private static final String PACKAGE_NAME;
  private static final int PURCHASE_EXPIRE_TIME_SEC = 43200;
  private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
  private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
  private static final String PURCHASE_SUBS_STORE = "com.facebook.internal.PURCHASE_SUBS";
  private static final String RESPONSE_CODE = "RESPONSE_CODE";
  private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
  private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
  private static final String SUBSCRIPTION = "subs";
  private static final long SUBSCRIPTION_HARTBEAT_INTERVAL = 86400L;
  private static final String TAG;
  private static final HashMap<String, Class<?>> classMap;
  private static final HashMap<String, Method> methodMap;
  private static final SharedPreferences purchaseInappSharedPrefs;
  private static final SharedPreferences purchaseSubsSharedPrefs;
  private static final SharedPreferences skuDetailSharedPrefs;
  
  static
  {
    AppMethodBeat.i(17646);
    TAG = InAppPurchaseEventManager.class.getCanonicalName();
    methodMap = new HashMap();
    classMap = new HashMap();
    PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
    purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
    purchaseSubsSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE_SUBS", 0);
    AppMethodBeat.o(17646);
  }
  
  public static Object asInterface(Context paramContext, IBinder paramIBinder)
  {
    AppMethodBeat.i(17628);
    paramContext = invokeMethod(paramContext, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[] { paramIBinder });
    AppMethodBeat.o(17628);
    return paramContext;
  }
  
  public static void clearSkuDetailsCache()
  {
    AppMethodBeat.i(17645);
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = skuDetailSharedPrefs.getLong("LAST_CLEARED_TIME", 0L);
    if (l2 == 0L)
    {
      skuDetailSharedPrefs.edit().putLong("LAST_CLEARED_TIME", l1).apply();
      AppMethodBeat.o(17645);
      return;
    }
    if (l1 - l2 > 604800L) {
      skuDetailSharedPrefs.edit().clear().putLong("LAST_CLEARED_TIME", l1).apply();
    }
    AppMethodBeat.o(17645);
  }
  
  private static ArrayList<String> filterPurchasesInapp(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(17641);
    ArrayList localArrayList = new ArrayList();
    SharedPreferences.Editor localEditor = purchaseInappSharedPrefs.edit();
    long l1 = System.currentTimeMillis() / 1000L;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str1 = (String)paramArrayList.next();
      try
      {
        Object localObject = new JSONObject(str1);
        String str2 = ((JSONObject)localObject).getString("productId");
        long l2 = ((JSONObject)localObject).getLong("purchaseTime");
        localObject = ((JSONObject)localObject).getString("purchaseToken");
        if ((l1 - l2 / 1000L <= 43200L) && (!purchaseInappSharedPrefs.getString(str2, "").equals(localObject)))
        {
          localEditor.putString(str2, (String)localObject);
          localArrayList.add(str1);
        }
      }
      catch (JSONException localJSONException) {}
    }
    localEditor.apply();
    AppMethodBeat.o(17641);
    return localArrayList;
  }
  
  private static Class<?> getClass(Context paramContext, String paramString)
  {
    AppMethodBeat.i(17643);
    localObject = (Class)classMap.get(paramString);
    if (localObject != null)
    {
      AppMethodBeat.o(17643);
      return localObject;
    }
    try
    {
      paramContext = paramContext.getClassLoader().loadClass(paramString);
      localObject = paramContext;
      classMap.put(paramString, paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        new StringBuilder().append(paramString).append(" is not available, please add ").append(paramString).append(" to the project.");
        paramContext = (Context)localObject;
      }
    }
    AppMethodBeat.o(17643);
    return paramContext;
  }
  
  private static Method getMethod(Class<?> paramClass, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(17642);
    Method localMethod = (Method)methodMap.get(paramString);
    if (localMethod != null)
    {
      AppMethodBeat.o(17642);
      return localMethod;
    }
    Object localObject1 = null;
    Object localObject3 = localMethod;
    try
    {
      switch (paramString.hashCode())
      {
      case -1123215065: 
      case -573310373: 
      case -1450694211: 
      case -1801122596: 
      case -594356707: 
        for (;;)
        {
          localObject3 = localMethod;
          localObject1 = paramClass.getDeclaredMethod(paramString, (Class[])localObject1);
          localObject3 = localObject1;
          methodMap.put(paramString, localObject1);
          AppMethodBeat.o(17642);
          return localObject1;
          localObject3 = localMethod;
          if (!paramString.equals("asInterface")) {
            break;
          }
          break label423;
          localObject3 = localMethod;
          if (!paramString.equals("getSkuDetails")) {
            break;
          }
          i = 1;
          break label423;
          localObject3 = localMethod;
          if (!paramString.equals("isBillingSupported")) {
            break;
          }
          i = 2;
          break label423;
          localObject3 = localMethod;
          if (!paramString.equals("getPurchases")) {
            break;
          }
          i = 3;
          break label423;
          localObject3 = localMethod;
          if (!paramString.equals("getPurchaseHistory")) {
            break;
          }
          i = 4;
          break label423;
          localObject3 = localMethod;
          localObject1 = new Class[1];
          localObject1[0] = IBinder.class;
        }
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        new StringBuilder().append(paramClass.getName()).append(".").append(paramString).append(" method not found");
        Object localObject2 = localObject3;
        continue;
        localObject3 = localMethod;
        localObject2 = new Class[4];
        localObject3 = localMethod;
        localObject2[0] = Integer.TYPE;
        localObject2[1] = String.class;
        localObject2[2] = String.class;
        localObject2[3] = Bundle.class;
        continue;
        localObject3 = localMethod;
        localObject2 = new Class[3];
        localObject3 = localMethod;
        localObject2[0] = Integer.TYPE;
        localObject2[1] = String.class;
        localObject2[2] = String.class;
        continue;
        localObject3 = localMethod;
        localObject2 = new Class[4];
        localObject3 = localMethod;
        localObject2[0] = Integer.TYPE;
        localObject2[1] = String.class;
        localObject2[2] = String.class;
        localObject2[3] = String.class;
        continue;
        localObject3 = localMethod;
        localObject2 = new Class[5];
        localObject3 = localMethod;
        localObject2[0] = Integer.TYPE;
        localObject2[1] = String.class;
        localObject2[2] = String.class;
        localObject2[3] = String.class;
        localObject2[4] = Bundle.class;
        continue;
        i = -1;
        label423:
        switch (i)
        {
        }
      }
    }
  }
  
  private static ArrayList<String> getPurchaseHistory(Context paramContext, Object paramObject, String paramString)
  {
    AppMethodBeat.i(17640);
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    Iterator localIterator;
    long l;
    if (isBillingSupported(paramContext, paramObject, paramString).booleanValue())
    {
      i = 0;
      localObject1 = Boolean.FALSE;
      localObject2 = null;
      localObject4 = PACKAGE_NAME;
      Bundle localBundle = new Bundle();
      localIterator = null;
      localObject2 = invokeMethod(paramContext, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", paramObject, new Object[] { Integer.valueOf(6), localObject4, paramString, localObject2, localBundle });
      if (localObject2 == null) {
        break label277;
      }
      l = System.currentTimeMillis() / 1000L;
      localObject4 = (Bundle)localObject2;
      if (((Bundle)localObject4).getInt("RESPONSE_CODE") != 0) {
        break label277;
      }
      localIterator = ((Bundle)localObject4).getStringArrayList("INAPP_PURCHASE_DATA_LIST").iterator();
      label139:
      if (!localIterator.hasNext()) {
        break label274;
      }
      localObject2 = (String)localIterator.next();
    }
    for (;;)
    {
      try
      {
        if (l - new JSONObject((String)localObject2).getLong("purchaseTime") / 1000L > 1200L)
        {
          localObject2 = Boolean.TRUE;
          localObject1 = localObject2;
          localObject2 = ((Bundle)localObject4).getString("INAPP_CONTINUATION_TOKEN");
          localObject4 = localObject1;
          localObject1 = localObject2;
          if ((i < 30) && (localObject1 != null) && (!((Boolean)localObject4).booleanValue())) {
            break label263;
          }
          AppMethodBeat.o(17640);
          return localArrayList;
        }
        localArrayList.add(localObject2);
        i += 1;
      }
      catch (JSONException localJSONException) {}
      break label139;
      label263:
      Object localObject3 = localObject1;
      localObject1 = localObject4;
      break;
      label274:
      continue;
      label277:
      localObject4 = localObject1;
      localObject1 = localIterator;
    }
  }
  
  public static ArrayList<String> getPurchaseHistoryInapp(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(17639);
    ArrayList localArrayList = new ArrayList();
    if (paramObject == null)
    {
      AppMethodBeat.o(17639);
      return localArrayList;
    }
    Class localClass = getClass(paramContext, "com.android.vending.billing.IInAppBillingService");
    if (localClass == null)
    {
      AppMethodBeat.o(17639);
      return localArrayList;
    }
    if (getMethod(localClass, "getPurchaseHistory") == null)
    {
      AppMethodBeat.o(17639);
      return localArrayList;
    }
    paramContext = filterPurchasesInapp(getPurchaseHistory(paramContext, paramObject, "inapp"));
    AppMethodBeat.o(17639);
    return paramContext;
  }
  
  private static ArrayList<String> getPurchases(Context paramContext, Object paramObject, String paramString)
  {
    AppMethodBeat.i(17638);
    ArrayList localArrayList1 = new ArrayList();
    if (paramObject == null)
    {
      AppMethodBeat.o(17638);
      return localArrayList1;
    }
    int i;
    Object localObject;
    if (isBillingSupported(paramContext, paramObject, paramString).booleanValue())
    {
      i = 0;
      localObject = null;
      localObject = invokeMethod(paramContext, "com.android.vending.billing.IInAppBillingService", "getPurchases", paramObject, new Object[] { Integer.valueOf(3), PACKAGE_NAME, paramString, localObject });
      if (localObject == null) {
        break label170;
      }
      localObject = (Bundle)localObject;
      if (((Bundle)localObject).getInt("RESPONSE_CODE") != 0) {
        break label170;
      }
      ArrayList localArrayList2 = ((Bundle)localObject).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      if (localArrayList2 != null)
      {
        int j = localArrayList2.size();
        localArrayList1.addAll(localArrayList2);
        localObject = ((Bundle)localObject).getString("INAPP_CONTINUATION_TOKEN");
        i += j;
      }
    }
    for (;;)
    {
      if ((i >= 30) || (localObject == null))
      {
        AppMethodBeat.o(17638);
        return localArrayList1;
      }
      break;
      label170:
      localObject = null;
    }
  }
  
  public static ArrayList<String> getPurchasesInapp(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(17634);
    paramContext = filterPurchasesInapp(getPurchases(paramContext, paramObject, "inapp"));
    AppMethodBeat.o(17634);
    return paramContext;
  }
  
  public static Map<String, SubscriptionType> getPurchasesSubs(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(17636);
    HashMap localHashMap = new HashMap();
    paramContext = getPurchases(paramContext, paramObject, "subs").iterator();
    while (paramContext.hasNext())
    {
      paramObject = (String)paramContext.next();
      SubscriptionType localSubscriptionType = getSubsType(paramObject);
      if ((localSubscriptionType != SubscriptionType.DUPLICATED) && (localSubscriptionType != SubscriptionType.UNKNOWN)) {
        localHashMap.put(paramObject, localSubscriptionType);
      }
    }
    AppMethodBeat.o(17636);
    return localHashMap;
  }
  
  public static ArrayList<String> getPurchasesSubsExpire(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(17635);
    ArrayList localArrayList = new ArrayList();
    Object localObject = purchaseSubsSharedPrefs.getAll();
    if (((Map)localObject).isEmpty())
    {
      AppMethodBeat.o(17635);
      return localArrayList;
    }
    paramObject = getPurchases(paramContext, paramObject, "subs");
    paramContext = new HashSet();
    paramObject = paramObject.iterator();
    while (paramObject.hasNext())
    {
      String str1 = (String)paramObject.next();
      try
      {
        paramContext.add(new JSONObject(str1).getString("productId"));
      }
      catch (JSONException localJSONException) {}
    }
    paramObject = new HashSet();
    localObject = ((Map)localObject).entrySet().iterator();
    String str2;
    while (((Iterator)localObject).hasNext())
    {
      str2 = (String)((Map.Entry)((Iterator)localObject).next()).getKey();
      if (!paramContext.contains(str2)) {
        paramObject.add(str2);
      }
    }
    paramContext = purchaseSubsSharedPrefs.edit();
    paramObject = paramObject.iterator();
    while (paramObject.hasNext())
    {
      localObject = (String)paramObject.next();
      str2 = purchaseSubsSharedPrefs.getString((String)localObject, "");
      paramContext.remove((String)localObject);
      if (!str2.isEmpty()) {
        localArrayList.add(purchaseSubsSharedPrefs.getString((String)localObject, ""));
      }
    }
    paramContext.apply();
    AppMethodBeat.o(17635);
    return localArrayList;
  }
  
  public static Map<String, String> getSkuDetails(Context paramContext, ArrayList<String> paramArrayList, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(17629);
    Map localMap = readSkuDetailsFromCache(paramArrayList);
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!localMap.containsKey(str)) {
        localArrayList.add(str);
      }
    }
    localMap.putAll(getSkuDetailsFromGoogle(paramContext, localArrayList, paramObject, paramBoolean));
    AppMethodBeat.o(17629);
    return localMap;
  }
  
  private static Map<String, String> getSkuDetailsFromGoogle(Context paramContext, ArrayList<String> paramArrayList, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(17630);
    HashMap localHashMap = new HashMap();
    if ((paramObject == null) || (paramArrayList.isEmpty()))
    {
      AppMethodBeat.o(17630);
      return localHashMap;
    }
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("ITEM_ID_LIST", paramArrayList);
    String str2 = PACKAGE_NAME;
    if (paramBoolean) {}
    for (String str1 = "subs";; str1 = "inapp")
    {
      paramContext = invokeMethod(paramContext, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", paramObject, new Object[] { Integer.valueOf(3), str2, str1, localBundle });
      if (paramContext == null) {
        break label194;
      }
      paramContext = (Bundle)paramContext;
      if (paramContext.getInt("RESPONSE_CODE") != 0) {
        break label194;
      }
      paramContext = paramContext.getStringArrayList("DETAILS_LIST");
      if ((paramContext == null) || (paramArrayList.size() != paramContext.size())) {
        break;
      }
      int i = 0;
      while (i < paramArrayList.size())
      {
        localHashMap.put(paramArrayList.get(i), paramContext.get(i));
        i += 1;
      }
    }
    writeSkuDetailsToCache(localHashMap);
    label194:
    AppMethodBeat.o(17630);
    return localHashMap;
  }
  
  private static SubscriptionType getSubsType(String paramString)
  {
    AppMethodBeat.i(17637);
    Object localObject = null;
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      try
      {
        long l = System.currentTimeMillis() / 1000L;
        JSONObject localJSONObject2 = new JSONObject(paramString);
        String str1 = localJSONObject2.getString("productId");
        String str2 = purchaseSubsSharedPrefs.getString(str1, "");
        JSONObject localJSONObject1;
        if (str2.isEmpty())
        {
          localJSONObject1 = new JSONObject();
          if (!localJSONObject1.optString("purchaseToken").equals(localJSONObject2.get("purchaseToken")))
          {
            if (l - localJSONObject2.getLong("purchaseTime") / 1000L < 43200L) {
              localObject = SubscriptionType.NEW;
            }
          }
          else
          {
            paramString = (String)localObject;
            if (localObject == null)
            {
              paramString = (String)localObject;
              if (!str2.isEmpty())
              {
                bool1 = localJSONObject1.getBoolean("autoRenewing");
                bool2 = localJSONObject2.getBoolean("autoRenewing");
                if ((bool2) || (!bool1)) {
                  break label288;
                }
                paramString = SubscriptionType.CANCEL;
              }
            }
            localObject = paramString;
            if (paramString == null)
            {
              localObject = paramString;
              if (!str2.isEmpty())
              {
                if (l - localJSONObject1.getLong("LAST_LOGGED_TIME_SEC") <= 86400L) {
                  break label310;
                }
                localObject = SubscriptionType.HEARTBEAT;
              }
            }
            if (localObject != SubscriptionType.DUPLICATED)
            {
              localJSONObject2.put("LAST_LOGGED_TIME_SEC", l);
              purchaseSubsSharedPrefs.edit().putString(str1, localJSONObject2.toString()).apply();
            }
            AppMethodBeat.o(17637);
            return localObject;
          }
        }
        else
        {
          localJSONObject1 = new JSONObject(str2);
          continue;
        }
        localObject = SubscriptionType.HEARTBEAT;
      }
      catch (JSONException paramString)
      {
        paramString = SubscriptionType.UNKNOWN;
        AppMethodBeat.o(17637);
        return paramString;
      }
      continue;
      label288:
      paramString = (String)localObject;
      if (!bool1)
      {
        paramString = (String)localObject;
        if (bool2)
        {
          paramString = SubscriptionType.RESTORE;
          continue;
          label310:
          localObject = SubscriptionType.DUPLICATED;
        }
      }
    }
  }
  
  private static Object invokeMethod(Context paramContext, String paramString1, String paramString2, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(17644);
    paramString1 = getClass(paramContext, paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(17644);
      return null;
    }
    paramString2 = getMethod(paramString1, paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(17644);
      return null;
    }
    paramContext = paramObject;
    if (paramObject != null) {
      paramContext = paramString1.cast(paramObject);
    }
    try
    {
      paramContext = paramString2.invoke(paramContext, paramArrayOfObject);
      AppMethodBeat.o(17644);
      return paramContext;
    }
    catch (IllegalAccessException paramContext)
    {
      new StringBuilder("Illegal access to method ").append(paramString1.getName()).append(".").append(paramString2.getName());
      AppMethodBeat.o(17644);
      return null;
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        new StringBuilder("Invocation target exception in ").append(paramString1.getName()).append(".").append(paramString2.getName());
      }
    }
  }
  
  private static Boolean isBillingSupported(Context paramContext, Object paramObject, String paramString)
  {
    AppMethodBeat.i(17633);
    if (paramObject == null)
    {
      paramContext = Boolean.FALSE;
      AppMethodBeat.o(17633);
      return paramContext;
    }
    paramContext = invokeMethod(paramContext, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", paramObject, new Object[] { Integer.valueOf(3), PACKAGE_NAME, paramString });
    if ((paramContext != null) && (((Integer)paramContext).intValue() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(17633);
      return Boolean.valueOf(bool);
    }
  }
  
  private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(17631);
    HashMap localHashMap = new HashMap();
    long l = System.currentTimeMillis() / 1000L;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      Object localObject = skuDetailSharedPrefs.getString(str, null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split(";", 2);
        if (l - Long.parseLong(localObject[0]) < 43200L) {
          localHashMap.put(str, localObject[1]);
        }
      }
    }
    AppMethodBeat.o(17631);
    return localHashMap;
  }
  
  private static void writeSkuDetailsToCache(Map<String, String> paramMap)
  {
    AppMethodBeat.i(17632);
    long l = System.currentTimeMillis() / 1000L;
    SharedPreferences.Editor localEditor = skuDetailSharedPrefs.edit();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localEditor.putString((String)localEntry.getKey(), l + ";" + (String)localEntry.getValue());
    }
    localEditor.apply();
    AppMethodBeat.o(17632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.internal.InAppPurchaseEventManager
 * JD-Core Version:    0.7.0.1
 */