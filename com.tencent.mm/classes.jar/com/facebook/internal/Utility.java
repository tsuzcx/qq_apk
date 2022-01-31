package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility
{
  private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
  public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
  private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
  private static final int GINGERBREAD_MR1 = 10;
  private static final String HASH_ALGORITHM_MD5 = "MD5";
  private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
  static final String LOG_TAG = "FacebookSDK";
  private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
  private static final String URL_SCHEME = "https";
  private static final String UTF8 = "UTF-8";
  private static long availableExternalStorageGB = 0L;
  private static String carrierName = "NoCarrier";
  private static String deviceTimeZoneName;
  private static String deviceTimezoneAbbreviation;
  private static final String noCarrierConstant = "NoCarrier";
  private static int numCPUCores = 0;
  private static long timestampOfLastCheck = -1L;
  private static long totalExternalStorageGB = -1L;
  
  static
  {
    availableExternalStorageGB = -1L;
    deviceTimezoneAbbreviation = "";
    deviceTimeZoneName = "";
  }
  
  public static <T> boolean areObjectsEqual(T paramT1, T paramT2)
  {
    AppMethodBeat.i(72525);
    if (paramT1 == null)
    {
      if (paramT2 == null)
      {
        AppMethodBeat.o(72525);
        return true;
      }
      AppMethodBeat.o(72525);
      return false;
    }
    boolean bool = paramT1.equals(paramT2);
    AppMethodBeat.o(72525);
    return bool;
  }
  
  public static <T> ArrayList<T> arrayList(T... paramVarArgs)
  {
    AppMethodBeat.i(72498);
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(72498);
    return localArrayList;
  }
  
  public static <T> List<T> asListNoNulls(T... paramVarArgs)
  {
    AppMethodBeat.i(72532);
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramVarArgs[i];
      if (? != null) {
        localArrayList.add(?);
      }
      i += 1;
    }
    AppMethodBeat.o(72532);
    return localArrayList;
  }
  
  public static JSONObject awaitGetGraphMeRequestWithCache(String paramString)
  {
    AppMethodBeat.i(72553);
    JSONObject localJSONObject = ProfileInformationCache.getProfileInformation(paramString);
    if (localJSONObject != null)
    {
      AppMethodBeat.o(72553);
      return localJSONObject;
    }
    paramString = getGraphMeRequestWithCache(paramString).executeAndWait();
    if (paramString.getError() != null)
    {
      AppMethodBeat.o(72553);
      return null;
    }
    paramString = paramString.getJSONObject();
    AppMethodBeat.o(72553);
    return paramString;
  }
  
  public static Uri buildUri(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(72506);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https");
    localBuilder.authority(paramString1);
    localBuilder.path(paramString2);
    if (paramBundle != null)
    {
      paramString1 = paramBundle.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        Object localObject = paramBundle.get(paramString2);
        if ((localObject instanceof String)) {
          localBuilder.appendQueryParameter(paramString2, (String)localObject);
        }
      }
    }
    paramString1 = localBuilder.build();
    AppMethodBeat.o(72506);
    return paramString1;
  }
  
  public static void clearCaches(Context paramContext)
  {
    AppMethodBeat.i(72530);
    ImageDownloader.clearCache(paramContext);
    AppMethodBeat.o(72530);
  }
  
  private static void clearCookiesForDomain(Context paramContext, String paramString)
  {
    AppMethodBeat.i(72520);
    CookieSyncManager.createInstance(paramContext).sync();
    paramContext = CookieManager.getInstance();
    Object localObject = paramContext.getCookie(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(72520);
      return;
    }
    localObject = ((String)localObject).split(";");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = localObject[i].split("=");
      if (arrayOfString.length > 0) {
        paramContext.setCookie(paramString, arrayOfString[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
      }
      i += 1;
    }
    paramContext.removeExpiredCookie();
    AppMethodBeat.o(72520);
  }
  
  public static void clearFacebookCookies(Context paramContext)
  {
    AppMethodBeat.i(72521);
    clearCookiesForDomain(paramContext, "facebook.com");
    clearCookiesForDomain(paramContext, ".facebook.com");
    clearCookiesForDomain(paramContext, "https://facebook.com");
    clearCookiesForDomain(paramContext, "https://.facebook.com");
    AppMethodBeat.o(72521);
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(72512);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(72512);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(72512);
    }
  }
  
  public static String coerceValueIfNullOrEmpty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72496);
    if (isNullOrEmpty(paramString1))
    {
      AppMethodBeat.o(72496);
      return paramString2;
    }
    AppMethodBeat.o(72496);
    return paramString1;
  }
  
  private static long convertBytesToGB(double paramDouble)
  {
    AppMethodBeat.i(72562);
    long l = Math.round(paramDouble / 1073741824.0D);
    AppMethodBeat.o(72562);
    return l;
  }
  
  static Map<String, Object> convertJSONObjectToHashMap(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72515);
    HashMap localHashMap = new HashMap();
    JSONArray localJSONArray = paramJSONObject.names();
    int i = 0;
    while (i < localJSONArray.length())
    {
      try
      {
        String str = localJSONArray.getString(i);
        Object localObject2 = paramJSONObject.get(str);
        Object localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = convertJSONObjectToHashMap((JSONObject)localObject2);
        }
        localHashMap.put(str, localObject1);
      }
      catch (JSONException localJSONException)
      {
        label73:
        break label73;
      }
      i += 1;
    }
    AppMethodBeat.o(72515);
    return localHashMap;
  }
  
  public static int copyAndCloseInputStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    int i = 0;
    AppMethodBeat.i(72518);
    try
    {
      localBufferedInputStream = new BufferedInputStream(paramInputStream);
      byte[] arrayOfByte;
      int j;
      if (localBufferedInputStream == null) {
        break label88;
      }
    }
    finally
    {
      try
      {
        arrayOfByte = new byte[8192];
        for (;;)
        {
          j = localBufferedInputStream.read(arrayOfByte);
          if (j == -1) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, j);
          i += j;
        }
        localBufferedInputStream.close();
        if (paramInputStream != null) {
          paramInputStream.close();
        }
        AppMethodBeat.o(72518);
        return i;
      }
      finally
      {
        BufferedInputStream localBufferedInputStream;
        break label78;
      }
      paramOutputStream = finally;
      localBufferedInputStream = null;
    }
    label78:
    localBufferedInputStream.close();
    label88:
    if (paramInputStream != null) {
      paramInputStream.close();
    }
    AppMethodBeat.o(72518);
    throw paramOutputStream;
  }
  
  public static void deleteDirectory(File paramFile)
  {
    AppMethodBeat.i(72531);
    if (!paramFile.exists())
    {
      AppMethodBeat.o(72531);
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          deleteDirectory(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    paramFile.delete();
    AppMethodBeat.o(72531);
  }
  
  public static void disconnectQuietly(URLConnection paramURLConnection)
  {
    AppMethodBeat.i(72513);
    if ((paramURLConnection != null) && ((paramURLConnection instanceof HttpURLConnection))) {
      ((HttpURLConnection)paramURLConnection).disconnect();
    }
    AppMethodBeat.o(72513);
  }
  
  private static boolean externalStorageExists()
  {
    AppMethodBeat.i(72559);
    boolean bool = "mounted".equals(Environment.getExternalStorageState());
    AppMethodBeat.o(72559);
    return bool;
  }
  
  public static <T> List<T> filter(List<T> paramList, Utility.Predicate<T> paramPredicate)
  {
    AppMethodBeat.i(72541);
    if (paramList == null)
    {
      AppMethodBeat.o(72541);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (paramPredicate.apply(localObject)) {
        localArrayList.add(localObject);
      }
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(72541);
      return null;
    }
    AppMethodBeat.o(72541);
    return localArrayList;
  }
  
  public static String generateRandomString(int paramInt)
  {
    AppMethodBeat.i(72564);
    String str = new BigInteger(paramInt * 5, new Random()).toString(32);
    AppMethodBeat.o(72564);
    return str;
  }
  
  public static String getActivityName(Context paramContext)
  {
    AppMethodBeat.i(72540);
    if (paramContext == null)
    {
      AppMethodBeat.o(72540);
      return "null";
    }
    if (paramContext == paramContext.getApplicationContext())
    {
      AppMethodBeat.o(72540);
      return "unknown";
    }
    paramContext = paramContext.getClass().getSimpleName();
    AppMethodBeat.o(72540);
    return paramContext;
  }
  
  public static Date getBundleLongAsDate(Bundle paramBundle, String paramString, Date paramDate)
  {
    AppMethodBeat.i(72548);
    if (paramBundle == null)
    {
      AppMethodBeat.o(72548);
      return null;
    }
    paramBundle = paramBundle.get(paramString);
    long l;
    if ((paramBundle instanceof Long)) {
      l = ((Long)paramBundle).longValue();
    }
    for (;;)
    {
      if (l != 0L) {
        break label99;
      }
      paramBundle = new Date(9223372036854775807L);
      AppMethodBeat.o(72548);
      return paramBundle;
      if ((paramBundle instanceof String)) {
        try
        {
          l = Long.parseLong((String)paramBundle);
        }
        catch (NumberFormatException paramBundle)
        {
          AppMethodBeat.o(72548);
          return null;
        }
      }
    }
    AppMethodBeat.o(72548);
    return null;
    label99:
    paramBundle = new Date(l * 1000L + paramDate.getTime());
    AppMethodBeat.o(72548);
    return paramBundle;
  }
  
  public static long getContentSize(Uri paramUri)
  {
    AppMethodBeat.i(72547);
    try
    {
      paramUri = FacebookSdk.getApplicationContext().getContentResolver().query(paramUri, null, null, null, null);
      int i;
      long l;
      if (paramUri == null) {
        break label78;
      }
    }
    finally
    {
      try
      {
        i = paramUri.getColumnIndex("_size");
        paramUri.moveToFirst();
        l = paramUri.getLong(i);
        if (paramUri != null) {
          paramUri.close();
        }
        AppMethodBeat.o(72547);
        return l;
      }
      finally {}
      localObject1 = finally;
      paramUri = null;
    }
    paramUri.close();
    label78:
    AppMethodBeat.o(72547);
    throw localObject1;
  }
  
  public static Locale getCurrentLocale()
  {
    AppMethodBeat.i(72568);
    try
    {
      Locale localLocale1 = FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
      AppMethodBeat.o(72568);
      return localLocale1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Locale localLocale2 = Locale.getDefault();
      }
    }
  }
  
  private static GraphRequest getGraphMeRequestWithCache(String paramString)
  {
    AppMethodBeat.i(72554);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
    localBundle.putString("access_token", paramString);
    paramString = new GraphRequest(null, "me", localBundle, HttpMethod.GET, null);
    AppMethodBeat.o(72554);
    return paramString;
  }
  
  public static void getGraphMeRequestWithCacheAsync(String paramString, Utility.GraphMeRequestWithCacheCallback paramGraphMeRequestWithCacheCallback)
  {
    AppMethodBeat.i(72552);
    JSONObject localJSONObject = ProfileInformationCache.getProfileInformation(paramString);
    if (localJSONObject != null)
    {
      paramGraphMeRequestWithCacheCallback.onSuccess(localJSONObject);
      AppMethodBeat.o(72552);
      return;
    }
    paramGraphMeRequestWithCacheCallback = new Utility.1(paramGraphMeRequestWithCacheCallback, paramString);
    paramString = getGraphMeRequestWithCache(paramString);
    paramString.setCallback(paramGraphMeRequestWithCacheCallback);
    paramString.executeAsync();
    AppMethodBeat.o(72552);
  }
  
  public static String getMetadataApplicationId(Context paramContext)
  {
    AppMethodBeat.i(72514);
    Validate.notNull(paramContext, "context");
    FacebookSdk.sdkInitialize(paramContext);
    paramContext = FacebookSdk.getApplicationId();
    AppMethodBeat.o(72514);
    return paramContext;
  }
  
  public static Method getMethodQuietly(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(72537);
    try
    {
      paramClass = paramClass.getMethod(paramString, paramVarArgs);
      AppMethodBeat.o(72537);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      AppMethodBeat.o(72537);
    }
    return null;
  }
  
  public static Method getMethodQuietly(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(72538);
    try
    {
      paramString1 = getMethodQuietly(Class.forName(paramString1), paramString2, paramVarArgs);
      AppMethodBeat.o(72538);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      AppMethodBeat.o(72538);
    }
    return null;
  }
  
  public static Object getStringPropertyAsJSON(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(72516);
    paramJSONObject = paramJSONObject.opt(paramString1);
    if ((paramJSONObject != null) && ((paramJSONObject instanceof String))) {
      paramJSONObject = new JSONTokener((String)paramJSONObject).nextValue();
    }
    for (;;)
    {
      if ((paramJSONObject != null) && (!(paramJSONObject instanceof JSONObject)) && (!(paramJSONObject instanceof JSONArray)))
      {
        if (paramString2 != null)
        {
          paramString1 = new JSONObject();
          paramString1.putOpt(paramString2, paramJSONObject);
          AppMethodBeat.o(72516);
          return paramString1;
        }
        paramJSONObject = new FacebookException("Got an unexpected non-JSON object.");
        AppMethodBeat.o(72516);
        throw paramJSONObject;
      }
      AppMethodBeat.o(72516);
      return paramJSONObject;
    }
  }
  
  public static String getUriString(Uri paramUri)
  {
    AppMethodBeat.i(72543);
    if (paramUri == null)
    {
      AppMethodBeat.o(72543);
      return null;
    }
    paramUri = paramUri.toString();
    AppMethodBeat.o(72543);
    return paramUri;
  }
  
  public static Utility.PermissionsPair handlePermissionResponse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72563);
    paramJSONObject = paramJSONObject.getJSONObject("permissions").getJSONArray("data");
    ArrayList localArrayList1 = new ArrayList(paramJSONObject.length());
    ArrayList localArrayList2 = new ArrayList(paramJSONObject.length());
    int i = 0;
    if (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.optJSONObject(i);
      String str = ((JSONObject)localObject).optString("permission");
      if ((str != null) && (!str.equals("installed")))
      {
        localObject = ((JSONObject)localObject).optString("status");
        if (localObject != null)
        {
          if (!((String)localObject).equals("granted")) {
            break label129;
          }
          localArrayList1.add(str);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label129:
        if (((String)localObject).equals("declined")) {
          localArrayList2.add(str);
        }
      }
    }
    paramJSONObject = new Utility.PermissionsPair(localArrayList1, localArrayList2);
    AppMethodBeat.o(72563);
    return paramJSONObject;
  }
  
  public static boolean hasSameId(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    AppMethodBeat.i(72526);
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null) || (!paramJSONObject1.has("id")) || (!paramJSONObject2.has("id")))
    {
      AppMethodBeat.o(72526);
      return false;
    }
    if (paramJSONObject1.equals(paramJSONObject2))
    {
      AppMethodBeat.o(72526);
      return true;
    }
    paramJSONObject1 = paramJSONObject1.optString("id");
    paramJSONObject2 = paramJSONObject2.optString("id");
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null))
    {
      AppMethodBeat.o(72526);
      return false;
    }
    boolean bool = paramJSONObject1.equals(paramJSONObject2);
    AppMethodBeat.o(72526);
    return bool;
  }
  
  private static String hashBytes(MessageDigest paramMessageDigest, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72505);
    paramMessageDigest.update(paramArrayOfByte);
    paramMessageDigest = paramMessageDigest.digest();
    paramArrayOfByte = new StringBuilder();
    int j = paramMessageDigest.length;
    int i = 0;
    while (i < j)
    {
      int k = paramMessageDigest[i];
      paramArrayOfByte.append(Integer.toHexString(k >> 4 & 0xF));
      paramArrayOfByte.append(Integer.toHexString(k >> 0 & 0xF));
      i += 1;
    }
    paramMessageDigest = paramArrayOfByte.toString();
    AppMethodBeat.o(72505);
    return paramMessageDigest;
  }
  
  public static <T> HashSet<T> hashSet(T... paramVarArgs)
  {
    AppMethodBeat.i(72499);
    HashSet localHashSet = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(72499);
    return localHashSet;
  }
  
  private static String hashWithAlgorithm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72503);
    paramString1 = hashWithAlgorithm(paramString1, paramString2.getBytes());
    AppMethodBeat.o(72503);
    return paramString1;
  }
  
  private static String hashWithAlgorithm(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72504);
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      paramString = hashBytes(paramString, paramArrayOfByte);
      AppMethodBeat.o(72504);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      AppMethodBeat.o(72504);
    }
    return null;
  }
  
  public static int[] intersectRanges(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(72492);
    if (paramArrayOfInt1 == null)
    {
      AppMethodBeat.o(72492);
      return paramArrayOfInt2;
    }
    if (paramArrayOfInt2 == null)
    {
      AppMethodBeat.o(72492);
      return paramArrayOfInt1;
    }
    int[] arrayOfInt = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
    int n = 0;
    int i = 0;
    int k = 0;
    int j = k;
    int i1;
    int i2;
    if (i < paramArrayOfInt1.length)
    {
      j = k;
      if (n < paramArrayOfInt2.length)
      {
        i1 = paramArrayOfInt1[i];
        i2 = paramArrayOfInt2[n];
        if (i >= paramArrayOfInt1.length - 1) {
          break label293;
        }
      }
    }
    label267:
    label279:
    label293:
    for (int m = paramArrayOfInt1[(i + 1)];; m = 2147483647)
    {
      if (n < paramArrayOfInt2.length - 1) {}
      for (j = paramArrayOfInt2[(n + 1)];; j = 2147483647)
      {
        if (i1 < i2) {
          if (m > i2)
          {
            if (m > j) {
              break label279;
            }
            i += 2;
            j = i2;
          }
        }
        for (;;)
        {
          i1 = k;
          if (j != -2147483648)
          {
            i1 = k + 1;
            arrayOfInt[k] = j;
            if (m == 2147483647) {
              break label249;
            }
            j = i1 + 1;
            arrayOfInt[i1] = m;
            i1 = j;
          }
          k = i1;
          break;
          i += 2;
          m = 2147483647;
          j = -2147483648;
          continue;
          if (j <= i1) {
            break label267;
          }
          if (j <= m) {
            break label226;
          }
          i += 2;
          j = i1;
        }
        label226:
        for (m = i1;; m = i2)
        {
          i1 = j;
          j = m;
          m = i1;
          for (;;)
          {
            n += 2;
            break;
            label249:
            j = i1;
            paramArrayOfInt1 = Arrays.copyOf(arrayOfInt, j);
            AppMethodBeat.o(72492);
            return paramArrayOfInt1;
            m = 2147483647;
            j = -2147483648;
          }
        }
      }
    }
  }
  
  public static Object invokeMethodQuietly(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    AppMethodBeat.i(72539);
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramVarArgs);
      AppMethodBeat.o(72539);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(72539);
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      AppMethodBeat.o(72539);
    }
    return null;
  }
  
  public static boolean isAutofillAvailable(Context paramContext)
  {
    AppMethodBeat.i(72566);
    if (Build.VERSION.SDK_INT < 26)
    {
      AppMethodBeat.o(72566);
      return false;
    }
    paramContext = (AutofillManager)paramContext.getSystemService(AutofillManager.class);
    if ((paramContext != null) && (paramContext.isAutofillSupported()) && (paramContext.isEnabled()))
    {
      AppMethodBeat.o(72566);
      return true;
    }
    AppMethodBeat.o(72566);
    return false;
  }
  
  public static boolean isChromeOS(Context paramContext)
  {
    AppMethodBeat.i(72567);
    if (Build.VERSION.SDK_INT >= 27)
    {
      boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.type.pc");
      AppMethodBeat.o(72567);
      return bool;
    }
    if ((Build.DEVICE != null) && (Build.DEVICE.matches(".+_cheets|cheets_.+")))
    {
      AppMethodBeat.o(72567);
      return true;
    }
    AppMethodBeat.o(72567);
    return false;
  }
  
  public static boolean isContentUri(Uri paramUri)
  {
    AppMethodBeat.i(72545);
    if ((paramUri != null) && ("content".equalsIgnoreCase(paramUri.getScheme())))
    {
      AppMethodBeat.o(72545);
      return true;
    }
    AppMethodBeat.o(72545);
    return false;
  }
  
  public static boolean isCurrentAccessToken(AccessToken paramAccessToken)
  {
    AppMethodBeat.i(72551);
    if ((paramAccessToken != null) && (paramAccessToken.equals(AccessToken.getCurrentAccessToken())))
    {
      AppMethodBeat.o(72551);
      return true;
    }
    AppMethodBeat.o(72551);
    return false;
  }
  
  public static boolean isFileUri(Uri paramUri)
  {
    AppMethodBeat.i(72546);
    if ((paramUri != null) && ("file".equalsIgnoreCase(paramUri.getScheme())))
    {
      AppMethodBeat.o(72546);
      return true;
    }
    AppMethodBeat.o(72546);
    return false;
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    AppMethodBeat.i(72495);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(72495);
      return true;
    }
    AppMethodBeat.o(72495);
    return false;
  }
  
  public static <T> boolean isNullOrEmpty(Collection<T> paramCollection)
  {
    AppMethodBeat.i(72494);
    if ((paramCollection == null) || (paramCollection.size() == 0))
    {
      AppMethodBeat.o(72494);
      return true;
    }
    AppMethodBeat.o(72494);
    return false;
  }
  
  public static <T> boolean isSubset(Collection<T> paramCollection1, Collection<T> paramCollection2)
  {
    AppMethodBeat.i(72493);
    if ((paramCollection2 == null) || (paramCollection2.size() == 0))
    {
      if ((paramCollection1 == null) || (paramCollection1.size() == 0))
      {
        AppMethodBeat.o(72493);
        return true;
      }
      AppMethodBeat.o(72493);
      return false;
    }
    paramCollection2 = new HashSet(paramCollection2);
    paramCollection1 = paramCollection1.iterator();
    while (paramCollection1.hasNext()) {
      if (!paramCollection2.contains(paramCollection1.next()))
      {
        AppMethodBeat.o(72493);
        return false;
      }
    }
    AppMethodBeat.o(72493);
    return true;
  }
  
  public static boolean isWebUri(Uri paramUri)
  {
    AppMethodBeat.i(72544);
    if ((paramUri != null) && (("http".equalsIgnoreCase(paramUri.getScheme())) || ("https".equalsIgnoreCase(paramUri.getScheme())) || ("fbstaging".equalsIgnoreCase(paramUri.getScheme()))))
    {
      AppMethodBeat.o(72544);
      return true;
    }
    AppMethodBeat.o(72544);
    return false;
  }
  
  public static Set<String> jsonArrayToSet(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(72534);
    HashSet localHashSet = new HashSet();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localHashSet.add(paramJSONArray.getString(i));
      i += 1;
    }
    AppMethodBeat.o(72534);
    return localHashSet;
  }
  
  public static List<String> jsonArrayToStringList(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(72533);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(paramJSONArray.getString(i));
      i += 1;
    }
    AppMethodBeat.o(72533);
    return localArrayList;
  }
  
  public static void logd(String paramString, Exception paramException)
  {
    AppMethodBeat.i(72522);
    if ((FacebookSdk.isDebugEnabled()) && (paramString != null) && (paramException != null)) {
      new StringBuilder().append(paramException.getClass().getSimpleName()).append(": ").append(paramException.getMessage());
    }
    AppMethodBeat.o(72522);
  }
  
  public static void logd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72523);
    FacebookSdk.isDebugEnabled();
    AppMethodBeat.o(72523);
  }
  
  public static void logd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(72524);
    if (FacebookSdk.isDebugEnabled()) {
      isNullOrEmpty(paramString1);
    }
    AppMethodBeat.o(72524);
  }
  
  public static <T, K> List<K> map(List<T> paramList, Utility.Mapper<T, K> paramMapper)
  {
    AppMethodBeat.i(72542);
    if (paramList == null)
    {
      AppMethodBeat.o(72542);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramMapper.apply(paramList.next());
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(72542);
      return null;
    }
    AppMethodBeat.o(72542);
    return localArrayList;
  }
  
  public static String md5hash(String paramString)
  {
    AppMethodBeat.i(72500);
    paramString = hashWithAlgorithm("MD5", paramString);
    AppMethodBeat.o(72500);
    return paramString;
  }
  
  public static boolean mustFixWindowParamsForAutofill(Context paramContext)
  {
    AppMethodBeat.i(72565);
    boolean bool = isAutofillAvailable(paramContext);
    AppMethodBeat.o(72565);
    return bool;
  }
  
  public static Bundle parseUrlQueryString(String paramString)
  {
    AppMethodBeat.i(72507);
    Bundle localBundle = new Bundle();
    int j;
    int i;
    if (!isNullOrEmpty(paramString))
    {
      paramString = paramString.split("&");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        try
        {
          if (arrayOfString.length == 2) {
            localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
          } else if (arrayOfString.length == 1) {
            localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), "");
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          logd("FacebookSDK", localUnsupportedEncodingException);
        }
      }
      else
      {
        AppMethodBeat.o(72507);
        return localBundle;
      }
      i += 1;
    }
  }
  
  public static void putCommaSeparatedStringList(Bundle paramBundle, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(72509);
    if (paramList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localStringBuilder.append((String)paramList.next());
        localStringBuilder.append(",");
      }
      paramList = "";
      if (localStringBuilder.length() > 0) {
        paramList = localStringBuilder.substring(0, localStringBuilder.length() - 1);
      }
      paramBundle.putString(paramString, paramList);
    }
    AppMethodBeat.o(72509);
  }
  
  public static boolean putJSONValueInBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    AppMethodBeat.i(72511);
    if (paramObject == null) {
      paramBundle.remove(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(72511);
      return true;
      if ((paramObject instanceof Boolean))
      {
        paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      }
      else if ((paramObject instanceof boolean[]))
      {
        paramBundle.putBooleanArray(paramString, (boolean[])paramObject);
      }
      else if ((paramObject instanceof Double))
      {
        paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
      }
      else if ((paramObject instanceof double[]))
      {
        paramBundle.putDoubleArray(paramString, (double[])paramObject);
      }
      else if ((paramObject instanceof Integer))
      {
        paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
      }
      else if ((paramObject instanceof int[]))
      {
        paramBundle.putIntArray(paramString, (int[])paramObject);
      }
      else if ((paramObject instanceof Long))
      {
        paramBundle.putLong(paramString, ((Long)paramObject).longValue());
      }
      else if ((paramObject instanceof long[]))
      {
        paramBundle.putLongArray(paramString, (long[])paramObject);
      }
      else if ((paramObject instanceof String))
      {
        paramBundle.putString(paramString, (String)paramObject);
      }
      else if ((paramObject instanceof JSONArray))
      {
        paramBundle.putString(paramString, paramObject.toString());
      }
      else
      {
        if (!(paramObject instanceof JSONObject)) {
          break;
        }
        paramBundle.putString(paramString, paramObject.toString());
      }
    }
    AppMethodBeat.o(72511);
    return false;
  }
  
  public static void putNonEmptyString(Bundle paramBundle, String paramString1, String paramString2)
  {
    AppMethodBeat.i(72508);
    if (!isNullOrEmpty(paramString2)) {
      paramBundle.putString(paramString1, paramString2);
    }
    AppMethodBeat.o(72508);
  }
  
  public static void putUri(Bundle paramBundle, String paramString, Uri paramUri)
  {
    AppMethodBeat.i(72510);
    if (paramUri != null) {
      putNonEmptyString(paramBundle, paramString, paramUri.toString());
    }
    AppMethodBeat.o(72510);
  }
  
  /* Error */
  public static String readStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc_w 960
    //   3: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 329	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 332	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   14: astore_3
    //   15: new 962	java/io/InputStreamReader
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 963	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: astore_2
    //   24: new 232	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   31: astore_0
    //   32: sipush 2048
    //   35: newarray char
    //   37: astore 4
    //   39: aload_2
    //   40: aload 4
    //   42: invokevirtual 966	java/io/InputStreamReader:read	([C)I
    //   45: istore_1
    //   46: iload_1
    //   47: iconst_m1
    //   48: if_icmpeq +32 -> 80
    //   51: aload_0
    //   52: aload 4
    //   54: iconst_0
    //   55: iload_1
    //   56: invokevirtual 969	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: goto -21 -> 39
    //   63: astore_0
    //   64: aload_3
    //   65: invokestatic 971	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   68: aload_2
    //   69: invokestatic 971	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   72: ldc_w 960
    //   75: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: athrow
    //   80: aload_0
    //   81: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_3
    //   86: invokestatic 971	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   89: aload_2
    //   90: invokestatic 971	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   93: ldc_w 960
    //   96: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_3
    //   106: goto -42 -> 64
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_2
    //   112: goto -48 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramInputStream	InputStream
    //   45	11	1	i	int
    //   23	89	2	localInputStreamReader	java.io.InputStreamReader
    //   14	92	3	localBufferedInputStream	BufferedInputStream
    //   37	16	4	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   24	39	63	finally
    //   39	46	63	finally
    //   51	60	63	finally
    //   80	85	63	finally
    //   6	15	101	finally
    //   15	24	109	finally
  }
  
  public static Map<String, String> readStringMapFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(72550);
    int j = paramParcel.readInt();
    if (j < 0)
    {
      AppMethodBeat.o(72550);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < j)
    {
      localHashMap.put(paramParcel.readString(), paramParcel.readString());
      i += 1;
    }
    AppMethodBeat.o(72550);
    return localHashMap;
  }
  
  private static void refreshAvailableExternalStorage()
  {
    AppMethodBeat.i(72560);
    try
    {
      if (externalStorageExists())
      {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l = localStatFs.getAvailableBlocks();
        availableExternalStorageGB = localStatFs.getBlockSize() * l;
      }
      availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
      AppMethodBeat.o(72560);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(72560);
    }
  }
  
  private static int refreshBestGuessNumberOfCPUCores()
  {
    AppMethodBeat.i(72555);
    if (numCPUCores > 0)
    {
      i = numCPUCores;
      AppMethodBeat.o(72555);
      return i;
    }
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new Utility.2());
      if (arrayOfFile != null) {
        numCPUCores = arrayOfFile.length;
      }
    }
    catch (Exception localException)
    {
      label54:
      break label54;
    }
    if (numCPUCores <= 0) {
      numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }
    int i = numCPUCores;
    AppMethodBeat.o(72555);
    return i;
  }
  
  private static void refreshCarrierName(Context paramContext)
  {
    AppMethodBeat.i(72558);
    if (carrierName.equals("NoCarrier")) {
      try
      {
        carrierName = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
        AppMethodBeat.o(72558);
        return;
      }
      catch (Exception paramContext) {}
    }
    AppMethodBeat.o(72558);
  }
  
  private static void refreshPeriodicExtendedDeviceInfo(Context paramContext)
  {
    AppMethodBeat.i(72556);
    if ((timestampOfLastCheck == -1L) || (System.currentTimeMillis() - timestampOfLastCheck >= 1800000L))
    {
      timestampOfLastCheck = System.currentTimeMillis();
      refreshTimezone();
      refreshCarrierName(paramContext);
      refreshTotalExternalStorage();
      refreshAvailableExternalStorage();
    }
    AppMethodBeat.o(72556);
  }
  
  private static void refreshTimezone()
  {
    AppMethodBeat.i(72557);
    try
    {
      TimeZone localTimeZone = TimeZone.getDefault();
      deviceTimezoneAbbreviation = localTimeZone.getDisplayName(localTimeZone.inDaylightTime(new Date()), 0);
      deviceTimeZoneName = localTimeZone.getID();
      AppMethodBeat.o(72557);
      return;
    }
    catch (AssertionError localAssertionError)
    {
      AppMethodBeat.o(72557);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(72557);
    }
  }
  
  private static void refreshTotalExternalStorage()
  {
    AppMethodBeat.i(72561);
    try
    {
      if (externalStorageExists())
      {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l = localStatFs.getBlockCount();
        totalExternalStorageGB = localStatFs.getBlockSize() * l;
      }
      totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
      AppMethodBeat.o(72561);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(72561);
    }
  }
  
  public static String safeGetStringFromResponse(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(72527);
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString(paramString, "");
      AppMethodBeat.o(72527);
      return paramJSONObject;
    }
    AppMethodBeat.o(72527);
    return "";
  }
  
  public static void setAppEventAttributionParameters(JSONObject paramJSONObject, AttributionIdentifiers paramAttributionIdentifiers, String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(72535);
    if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAttributionId() != null)) {
      paramJSONObject.put("attribution", paramAttributionIdentifiers.getAttributionId());
    }
    boolean bool1;
    if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAndroidAdvertiserId() != null))
    {
      paramJSONObject.put("advertiser_id", paramAttributionIdentifiers.getAndroidAdvertiserId());
      if (!paramAttributionIdentifiers.isTrackingLimited())
      {
        bool1 = true;
        paramJSONObject.put("advertiser_tracking_enabled", bool1);
      }
    }
    else
    {
      if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAndroidInstallerPackage() != null)) {
        paramJSONObject.put("installer_package", paramAttributionIdentifiers.getAndroidInstallerPackage());
      }
      paramJSONObject.put("anon_id", paramString);
      if (paramBoolean) {
        break label136;
      }
    }
    label136:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramJSONObject.put("application_tracking_enabled", paramBoolean);
      AppMethodBeat.o(72535);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void setAppEventExtendedDeviceInfoParameters(JSONObject paramJSONObject, Context paramContext)
  {
    AppMethodBeat.i(72536);
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put("a2");
    refreshPeriodicExtendedDeviceInfo(paramContext);
    String str = paramContext.getPackageName();
    j = -1;
    Object localObject1 = "";
    i = j;
    try
    {
      Object localObject2 = paramContext.getPackageManager().getPackageInfo(str, 0);
      i = j;
      j = ((PackageInfo)localObject2).versionCode;
      i = j;
      localObject2 = ((PackageInfo)localObject2).versionName;
      i = j;
      localObject1 = localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        continue;
        double d = 0.0D;
        i = 0;
        j = 0;
      }
    }
    localJSONArray.put(str);
    localJSONArray.put(i);
    localJSONArray.put(localObject1);
    localJSONArray.put(Build.VERSION.RELEASE);
    localJSONArray.put(Build.MODEL);
    try
    {
      localObject1 = paramContext.getResources().getConfiguration().locale;
      localJSONArray.put(((Locale)localObject1).getLanguage() + "_" + ((Locale)localObject1).getCountry());
      localJSONArray.put(deviceTimezoneAbbreviation);
      localJSONArray.put(carrierName);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramContext = (WindowManager)paramContext.getSystemService("window");
          if (paramContext == null) {
            break label391;
          }
          paramContext = paramContext.getDefaultDisplay();
          localObject1 = new DisplayMetrics();
          paramContext.getMetrics((DisplayMetrics)localObject1);
          j = ((DisplayMetrics)localObject1).widthPixels;
        }
        catch (Exception paramContext)
        {
          float f;
          Locale localLocale;
          i = 0;
          j = 0;
          d = 0.0D;
          continue;
        }
        try
        {
          i = ((DisplayMetrics)localObject1).heightPixels;
        }
        catch (Exception paramContext)
        {
          i = 0;
          continue;
        }
        try
        {
          f = ((DisplayMetrics)localObject1).density;
          d = f;
          localJSONArray.put(j);
          localJSONArray.put(i);
          localJSONArray.put(String.format("%.2f", new Object[] { Double.valueOf(d) }));
          localJSONArray.put(refreshBestGuessNumberOfCPUCores());
          localJSONArray.put(totalExternalStorageGB);
          localJSONArray.put(availableExternalStorageGB);
          localJSONArray.put(deviceTimeZoneName);
          paramJSONObject.put("extinfo", localJSONArray.toString());
          AppMethodBeat.o(72536);
          return;
        }
        catch (Exception paramContext)
        {
          continue;
        }
        localException = localException;
        localLocale = Locale.getDefault();
      }
    }
  }
  
  public static String sha1hash(String paramString)
  {
    AppMethodBeat.i(72501);
    paramString = hashWithAlgorithm("SHA-1", paramString);
    AppMethodBeat.o(72501);
    return paramString;
  }
  
  public static String sha1hash(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72502);
    paramArrayOfByte = hashWithAlgorithm("SHA-1", paramArrayOfByte);
    AppMethodBeat.o(72502);
    return paramArrayOfByte;
  }
  
  public static boolean stringsEqualOrEmpty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72519);
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(72519);
      return true;
    }
    if ((!bool1) && (!bool2))
    {
      bool1 = paramString1.equals(paramString2);
      AppMethodBeat.o(72519);
      return bool1;
    }
    AppMethodBeat.o(72519);
    return false;
  }
  
  public static JSONArray tryGetJSONArrayFromResponse(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(72529);
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
      AppMethodBeat.o(72529);
      return paramJSONObject;
    }
    AppMethodBeat.o(72529);
    return null;
  }
  
  public static JSONObject tryGetJSONObjectFromResponse(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(72528);
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject(paramString);
      AppMethodBeat.o(72528);
      return paramJSONObject;
    }
    AppMethodBeat.o(72528);
    return null;
  }
  
  public static <T> Collection<T> unmodifiableCollection(T... paramVarArgs)
  {
    AppMethodBeat.i(72497);
    paramVarArgs = Collections.unmodifiableCollection(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(72497);
    return paramVarArgs;
  }
  
  public static void writeStringMapToParcel(Parcel paramParcel, Map<String, String> paramMap)
  {
    AppMethodBeat.i(72549);
    if (paramMap == null)
    {
      paramParcel.writeInt(-1);
      AppMethodBeat.o(72549);
      return;
    }
    paramParcel.writeInt(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeString((String)localEntry.getValue());
    }
    AppMethodBeat.o(72549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.internal.Utility
 * JD-Core Version:    0.7.0.1
 */