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
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
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
    AppMethodBeat.i(17961);
    if (paramT1 == null)
    {
      if (paramT2 == null)
      {
        AppMethodBeat.o(17961);
        return true;
      }
      AppMethodBeat.o(17961);
      return false;
    }
    boolean bool = paramT1.equals(paramT2);
    AppMethodBeat.o(17961);
    return bool;
  }
  
  public static <T> ArrayList<T> arrayList(T... paramVarArgs)
  {
    AppMethodBeat.i(17934);
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(17934);
    return localArrayList;
  }
  
  public static <T> List<T> asListNoNulls(T... paramVarArgs)
  {
    AppMethodBeat.i(17968);
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
    AppMethodBeat.o(17968);
    return localArrayList;
  }
  
  public static JSONObject awaitGetGraphMeRequestWithCache(String paramString)
  {
    AppMethodBeat.i(17989);
    JSONObject localJSONObject = ProfileInformationCache.getProfileInformation(paramString);
    if (localJSONObject != null)
    {
      AppMethodBeat.o(17989);
      return localJSONObject;
    }
    paramString = getGraphMeRequestWithCache(paramString).executeAndWait();
    if (paramString.getError() != null)
    {
      AppMethodBeat.o(17989);
      return null;
    }
    paramString = paramString.getJSONObject();
    AppMethodBeat.o(17989);
    return paramString;
  }
  
  public static Uri buildUri(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(17942);
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
    AppMethodBeat.o(17942);
    return paramString1;
  }
  
  public static void clearCaches(Context paramContext)
  {
    AppMethodBeat.i(17966);
    ImageDownloader.clearCache(paramContext);
    AppMethodBeat.o(17966);
  }
  
  private static void clearCookiesForDomain(Context paramContext, String paramString)
  {
    AppMethodBeat.i(17956);
    CookieSyncManager.createInstance(paramContext).sync();
    paramContext = CookieManager.getInstance();
    Object localObject = paramContext.getCookie(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(17956);
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
    AppMethodBeat.o(17956);
  }
  
  public static void clearFacebookCookies(Context paramContext)
  {
    AppMethodBeat.i(17957);
    clearCookiesForDomain(paramContext, "facebook.com");
    clearCookiesForDomain(paramContext, ".facebook.com");
    clearCookiesForDomain(paramContext, "https://facebook.com");
    clearCookiesForDomain(paramContext, "https://.facebook.com");
    AppMethodBeat.o(17957);
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(17948);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(17948);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(17948);
    }
  }
  
  public static String coerceValueIfNullOrEmpty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17932);
    if (isNullOrEmpty(paramString1))
    {
      AppMethodBeat.o(17932);
      return paramString2;
    }
    AppMethodBeat.o(17932);
    return paramString1;
  }
  
  private static long convertBytesToGB(double paramDouble)
  {
    AppMethodBeat.i(17998);
    long l = Math.round(paramDouble / 1073741824.0D);
    AppMethodBeat.o(17998);
    return l;
  }
  
  static Map<String, Object> convertJSONObjectToHashMap(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(17951);
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
    AppMethodBeat.o(17951);
    return localHashMap;
  }
  
  public static int copyAndCloseInputStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    int i = 0;
    AppMethodBeat.i(17954);
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
        AppMethodBeat.o(17954);
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
    AppMethodBeat.o(17954);
    throw paramOutputStream;
  }
  
  public static void deleteDirectory(File paramFile)
  {
    AppMethodBeat.i(17967);
    if (!paramFile.exists())
    {
      AppMethodBeat.o(17967);
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
    AppMethodBeat.o(17967);
  }
  
  public static void disconnectQuietly(URLConnection paramURLConnection)
  {
    AppMethodBeat.i(17949);
    if ((paramURLConnection != null) && ((paramURLConnection instanceof HttpURLConnection))) {
      ((HttpURLConnection)paramURLConnection).disconnect();
    }
    AppMethodBeat.o(17949);
  }
  
  private static boolean externalStorageExists()
  {
    AppMethodBeat.i(17995);
    boolean bool = "mounted".equals(Environment.getExternalStorageState());
    AppMethodBeat.o(17995);
    return bool;
  }
  
  public static <T> List<T> filter(List<T> paramList, Predicate<T> paramPredicate)
  {
    AppMethodBeat.i(17977);
    if (paramList == null)
    {
      AppMethodBeat.o(17977);
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
      AppMethodBeat.o(17977);
      return null;
    }
    AppMethodBeat.o(17977);
    return localArrayList;
  }
  
  public static String generateRandomString(int paramInt)
  {
    AppMethodBeat.i(18000);
    String str = new BigInteger(paramInt * 5, new Random()).toString(32);
    AppMethodBeat.o(18000);
    return str;
  }
  
  public static String getActivityName(Context paramContext)
  {
    AppMethodBeat.i(17976);
    if (paramContext == null)
    {
      AppMethodBeat.o(17976);
      return "null";
    }
    if (paramContext == paramContext.getApplicationContext())
    {
      AppMethodBeat.o(17976);
      return "unknown";
    }
    paramContext = paramContext.getClass().getSimpleName();
    AppMethodBeat.o(17976);
    return paramContext;
  }
  
  public static Date getBundleLongAsDate(Bundle paramBundle, String paramString, Date paramDate)
  {
    AppMethodBeat.i(17984);
    if (paramBundle == null)
    {
      AppMethodBeat.o(17984);
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
      AppMethodBeat.o(17984);
      return paramBundle;
      if ((paramBundle instanceof String)) {
        try
        {
          l = Long.parseLong((String)paramBundle);
        }
        catch (NumberFormatException paramBundle)
        {
          AppMethodBeat.o(17984);
          return null;
        }
      }
    }
    AppMethodBeat.o(17984);
    return null;
    label99:
    paramBundle = new Date(l * 1000L + paramDate.getTime());
    AppMethodBeat.o(17984);
    return paramBundle;
  }
  
  public static long getContentSize(Uri paramUri)
  {
    AppMethodBeat.i(17983);
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
        AppMethodBeat.o(17983);
        return l;
      }
      finally {}
      localObject1 = finally;
      paramUri = null;
    }
    paramUri.close();
    label78:
    AppMethodBeat.o(17983);
    throw localObject1;
  }
  
  public static Locale getCurrentLocale()
  {
    AppMethodBeat.i(18004);
    try
    {
      Locale localLocale1 = FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
      AppMethodBeat.o(18004);
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
    AppMethodBeat.i(17990);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
    localBundle.putString("access_token", paramString);
    paramString = new GraphRequest(null, "me", localBundle, HttpMethod.GET, null);
    AppMethodBeat.o(17990);
    return paramString;
  }
  
  public static void getGraphMeRequestWithCacheAsync(final String paramString, GraphMeRequestWithCacheCallback paramGraphMeRequestWithCacheCallback)
  {
    AppMethodBeat.i(17988);
    JSONObject localJSONObject = ProfileInformationCache.getProfileInformation(paramString);
    if (localJSONObject != null)
    {
      paramGraphMeRequestWithCacheCallback.onSuccess(localJSONObject);
      AppMethodBeat.o(17988);
      return;
    }
    paramGraphMeRequestWithCacheCallback = new GraphRequest.Callback()
    {
      public final void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(17926);
        if (paramAnonymousGraphResponse.getError() != null)
        {
          this.val$callback.onFailure(paramAnonymousGraphResponse.getError().getException());
          AppMethodBeat.o(17926);
          return;
        }
        ProfileInformationCache.putProfileInformation(paramString, paramAnonymousGraphResponse.getJSONObject());
        this.val$callback.onSuccess(paramAnonymousGraphResponse.getJSONObject());
        AppMethodBeat.o(17926);
      }
    };
    paramString = getGraphMeRequestWithCache(paramString);
    paramString.setCallback(paramGraphMeRequestWithCacheCallback);
    paramString.executeAsync();
    AppMethodBeat.o(17988);
  }
  
  public static String getMetadataApplicationId(Context paramContext)
  {
    AppMethodBeat.i(17950);
    Validate.notNull(paramContext, "context");
    FacebookSdk.sdkInitialize(paramContext);
    paramContext = FacebookSdk.getApplicationId();
    AppMethodBeat.o(17950);
    return paramContext;
  }
  
  public static Method getMethodQuietly(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(17973);
    try
    {
      paramClass = paramClass.getMethod(paramString, paramVarArgs);
      AppMethodBeat.o(17973);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      AppMethodBeat.o(17973);
    }
    return null;
  }
  
  public static Method getMethodQuietly(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(17974);
    try
    {
      paramString1 = getMethodQuietly(Class.forName(paramString1), paramString2, paramVarArgs);
      AppMethodBeat.o(17974);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      AppMethodBeat.o(17974);
    }
    return null;
  }
  
  public static Object getStringPropertyAsJSON(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(17952);
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
          AppMethodBeat.o(17952);
          return paramString1;
        }
        paramJSONObject = new FacebookException("Got an unexpected non-JSON object.");
        AppMethodBeat.o(17952);
        throw paramJSONObject;
      }
      AppMethodBeat.o(17952);
      return paramJSONObject;
    }
  }
  
  public static String getUriString(Uri paramUri)
  {
    AppMethodBeat.i(17979);
    if (paramUri == null)
    {
      AppMethodBeat.o(17979);
      return null;
    }
    paramUri = paramUri.toString();
    AppMethodBeat.o(17979);
    return paramUri;
  }
  
  public static PermissionsPair handlePermissionResponse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(17999);
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
    paramJSONObject = new PermissionsPair(localArrayList1, localArrayList2);
    AppMethodBeat.o(17999);
    return paramJSONObject;
  }
  
  public static boolean hasSameId(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    AppMethodBeat.i(17962);
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null) || (!paramJSONObject1.has("id")) || (!paramJSONObject2.has("id")))
    {
      AppMethodBeat.o(17962);
      return false;
    }
    if (paramJSONObject1.equals(paramJSONObject2))
    {
      AppMethodBeat.o(17962);
      return true;
    }
    paramJSONObject1 = paramJSONObject1.optString("id");
    paramJSONObject2 = paramJSONObject2.optString("id");
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null))
    {
      AppMethodBeat.o(17962);
      return false;
    }
    boolean bool = paramJSONObject1.equals(paramJSONObject2);
    AppMethodBeat.o(17962);
    return bool;
  }
  
  private static String hashBytes(MessageDigest paramMessageDigest, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17941);
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
    AppMethodBeat.o(17941);
    return paramMessageDigest;
  }
  
  public static <T> HashSet<T> hashSet(T... paramVarArgs)
  {
    AppMethodBeat.i(17935);
    HashSet localHashSet = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(17935);
    return localHashSet;
  }
  
  private static String hashWithAlgorithm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17939);
    paramString1 = hashWithAlgorithm(paramString1, paramString2.getBytes());
    AppMethodBeat.o(17939);
    return paramString1;
  }
  
  private static String hashWithAlgorithm(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17940);
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      paramString = hashBytes(paramString, paramArrayOfByte);
      AppMethodBeat.o(17940);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      AppMethodBeat.o(17940);
    }
    return null;
  }
  
  public static int[] intersectRanges(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(17928);
    if (paramArrayOfInt1 == null)
    {
      AppMethodBeat.o(17928);
      return paramArrayOfInt2;
    }
    if (paramArrayOfInt2 == null)
    {
      AppMethodBeat.o(17928);
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
            AppMethodBeat.o(17928);
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
    AppMethodBeat.i(17975);
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramVarArgs);
      AppMethodBeat.o(17975);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(17975);
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      AppMethodBeat.o(17975);
    }
    return null;
  }
  
  public static boolean isAutofillAvailable(Context paramContext)
  {
    AppMethodBeat.i(18002);
    if (Build.VERSION.SDK_INT < 26)
    {
      AppMethodBeat.o(18002);
      return false;
    }
    paramContext = (AutofillManager)paramContext.getSystemService(AutofillManager.class);
    if ((paramContext != null) && (paramContext.isAutofillSupported()) && (paramContext.isEnabled()))
    {
      AppMethodBeat.o(18002);
      return true;
    }
    AppMethodBeat.o(18002);
    return false;
  }
  
  public static boolean isChromeOS(Context paramContext)
  {
    AppMethodBeat.i(18003);
    if (Build.VERSION.SDK_INT >= 27)
    {
      boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.type.pc");
      AppMethodBeat.o(18003);
      return bool;
    }
    if ((Build.DEVICE != null) && (Build.DEVICE.matches(".+_cheets|cheets_.+")))
    {
      AppMethodBeat.o(18003);
      return true;
    }
    AppMethodBeat.o(18003);
    return false;
  }
  
  public static boolean isContentUri(Uri paramUri)
  {
    AppMethodBeat.i(17981);
    if ((paramUri != null) && ("content".equalsIgnoreCase(paramUri.getScheme())))
    {
      AppMethodBeat.o(17981);
      return true;
    }
    AppMethodBeat.o(17981);
    return false;
  }
  
  public static boolean isCurrentAccessToken(AccessToken paramAccessToken)
  {
    AppMethodBeat.i(17987);
    if ((paramAccessToken != null) && (paramAccessToken.equals(AccessToken.getCurrentAccessToken())))
    {
      AppMethodBeat.o(17987);
      return true;
    }
    AppMethodBeat.o(17987);
    return false;
  }
  
  public static boolean isFileUri(Uri paramUri)
  {
    AppMethodBeat.i(17982);
    if ((paramUri != null) && ("file".equalsIgnoreCase(paramUri.getScheme())))
    {
      AppMethodBeat.o(17982);
      return true;
    }
    AppMethodBeat.o(17982);
    return false;
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    AppMethodBeat.i(17931);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(17931);
      return true;
    }
    AppMethodBeat.o(17931);
    return false;
  }
  
  public static <T> boolean isNullOrEmpty(Collection<T> paramCollection)
  {
    AppMethodBeat.i(17930);
    if ((paramCollection == null) || (paramCollection.size() == 0))
    {
      AppMethodBeat.o(17930);
      return true;
    }
    AppMethodBeat.o(17930);
    return false;
  }
  
  public static <T> boolean isSubset(Collection<T> paramCollection1, Collection<T> paramCollection2)
  {
    AppMethodBeat.i(17929);
    if ((paramCollection2 == null) || (paramCollection2.size() == 0))
    {
      if ((paramCollection1 == null) || (paramCollection1.size() == 0))
      {
        AppMethodBeat.o(17929);
        return true;
      }
      AppMethodBeat.o(17929);
      return false;
    }
    paramCollection2 = new HashSet(paramCollection2);
    paramCollection1 = paramCollection1.iterator();
    while (paramCollection1.hasNext()) {
      if (!paramCollection2.contains(paramCollection1.next()))
      {
        AppMethodBeat.o(17929);
        return false;
      }
    }
    AppMethodBeat.o(17929);
    return true;
  }
  
  public static boolean isWebUri(Uri paramUri)
  {
    AppMethodBeat.i(17980);
    if ((paramUri != null) && (("http".equalsIgnoreCase(paramUri.getScheme())) || ("https".equalsIgnoreCase(paramUri.getScheme())) || ("fbstaging".equalsIgnoreCase(paramUri.getScheme()))))
    {
      AppMethodBeat.o(17980);
      return true;
    }
    AppMethodBeat.o(17980);
    return false;
  }
  
  public static Set<String> jsonArrayToSet(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(17970);
    HashSet localHashSet = new HashSet();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localHashSet.add(paramJSONArray.getString(i));
      i += 1;
    }
    AppMethodBeat.o(17970);
    return localHashSet;
  }
  
  public static List<String> jsonArrayToStringList(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(17969);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(paramJSONArray.getString(i));
      i += 1;
    }
    AppMethodBeat.o(17969);
    return localArrayList;
  }
  
  public static void logd(String paramString, Exception paramException)
  {
    AppMethodBeat.i(17958);
    if ((FacebookSdk.isDebugEnabled()) && (paramString != null) && (paramException != null)) {
      new StringBuilder().append(paramException.getClass().getSimpleName()).append(": ").append(paramException.getMessage());
    }
    AppMethodBeat.o(17958);
  }
  
  public static void logd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17959);
    FacebookSdk.isDebugEnabled();
    AppMethodBeat.o(17959);
  }
  
  public static void logd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(17960);
    if (FacebookSdk.isDebugEnabled()) {
      isNullOrEmpty(paramString1);
    }
    AppMethodBeat.o(17960);
  }
  
  public static <T, K> List<K> map(List<T> paramList, Mapper<T, K> paramMapper)
  {
    AppMethodBeat.i(17978);
    if (paramList == null)
    {
      AppMethodBeat.o(17978);
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
      AppMethodBeat.o(17978);
      return null;
    }
    AppMethodBeat.o(17978);
    return localArrayList;
  }
  
  public static String md5hash(String paramString)
  {
    AppMethodBeat.i(17936);
    paramString = hashWithAlgorithm("MD5", paramString);
    AppMethodBeat.o(17936);
    return paramString;
  }
  
  public static boolean mustFixWindowParamsForAutofill(Context paramContext)
  {
    AppMethodBeat.i(18001);
    boolean bool = isAutofillAvailable(paramContext);
    AppMethodBeat.o(18001);
    return bool;
  }
  
  public static Bundle parseUrlQueryString(String paramString)
  {
    AppMethodBeat.i(17943);
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
        AppMethodBeat.o(17943);
        return localBundle;
      }
      i += 1;
    }
  }
  
  public static void putCommaSeparatedStringList(Bundle paramBundle, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(17945);
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
    AppMethodBeat.o(17945);
  }
  
  public static boolean putJSONValueInBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    AppMethodBeat.i(17947);
    if (paramObject == null) {
      paramBundle.remove(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(17947);
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
    AppMethodBeat.o(17947);
    return false;
  }
  
  public static void putNonEmptyString(Bundle paramBundle, String paramString1, String paramString2)
  {
    AppMethodBeat.i(17944);
    if (!isNullOrEmpty(paramString2)) {
      paramBundle.putString(paramString1, paramString2);
    }
    AppMethodBeat.o(17944);
  }
  
  public static void putUri(Bundle paramBundle, String paramString, Uri paramUri)
  {
    AppMethodBeat.i(17946);
    if (paramUri != null) {
      putNonEmptyString(paramBundle, paramString, paramUri.toString());
    }
    AppMethodBeat.o(17946);
  }
  
  /* Error */
  public static String readStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 17953
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 322	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 325	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   14: astore_3
    //   15: new 906	java/io/InputStreamReader
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 907	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: astore_2
    //   24: new 231	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   31: astore_0
    //   32: sipush 2048
    //   35: newarray char
    //   37: astore 4
    //   39: aload_2
    //   40: aload 4
    //   42: invokevirtual 910	java/io/InputStreamReader:read	([C)I
    //   45: istore_1
    //   46: iload_1
    //   47: iconst_m1
    //   48: if_icmpeq +32 -> 80
    //   51: aload_0
    //   52: aload 4
    //   54: iconst_0
    //   55: iload_1
    //   56: invokevirtual 913	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: goto -21 -> 39
    //   63: astore_0
    //   64: aload_3
    //   65: invokestatic 915	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   68: aload_2
    //   69: invokestatic 915	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   72: sipush 17953
    //   75: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: athrow
    //   80: aload_0
    //   81: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_3
    //   86: invokestatic 915	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   89: aload_2
    //   90: invokestatic 915	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   93: sipush 17953
    //   96: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(17986);
    int j = paramParcel.readInt();
    if (j < 0)
    {
      AppMethodBeat.o(17986);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < j)
    {
      localHashMap.put(paramParcel.readString(), paramParcel.readString());
      i += 1;
    }
    AppMethodBeat.o(17986);
    return localHashMap;
  }
  
  private static void refreshAvailableExternalStorage()
  {
    AppMethodBeat.i(17996);
    try
    {
      if (externalStorageExists())
      {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l = localStatFs.getAvailableBlocks();
        availableExternalStorageGB = localStatFs.getBlockSize() * l;
      }
      availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
      AppMethodBeat.o(17996);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(17996);
    }
  }
  
  private static int refreshBestGuessNumberOfCPUCores()
  {
    AppMethodBeat.i(17991);
    if (numCPUCores > 0)
    {
      i = numCPUCores;
      AppMethodBeat.o(17991);
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
    AppMethodBeat.o(17991);
    return i;
  }
  
  private static void refreshCarrierName(Context paramContext)
  {
    AppMethodBeat.i(17994);
    if (carrierName.equals("NoCarrier")) {
      try
      {
        carrierName = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
        AppMethodBeat.o(17994);
        return;
      }
      catch (Exception paramContext) {}
    }
    AppMethodBeat.o(17994);
  }
  
  private static void refreshPeriodicExtendedDeviceInfo(Context paramContext)
  {
    AppMethodBeat.i(17992);
    if ((timestampOfLastCheck == -1L) || (System.currentTimeMillis() - timestampOfLastCheck >= 1800000L))
    {
      timestampOfLastCheck = System.currentTimeMillis();
      refreshTimezone();
      refreshCarrierName(paramContext);
      refreshTotalExternalStorage();
      refreshAvailableExternalStorage();
    }
    AppMethodBeat.o(17992);
  }
  
  private static void refreshTimezone()
  {
    AppMethodBeat.i(17993);
    try
    {
      TimeZone localTimeZone = TimeZone.getDefault();
      deviceTimezoneAbbreviation = localTimeZone.getDisplayName(localTimeZone.inDaylightTime(new Date()), 0);
      deviceTimeZoneName = localTimeZone.getID();
      AppMethodBeat.o(17993);
      return;
    }
    catch (AssertionError localAssertionError)
    {
      AppMethodBeat.o(17993);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(17993);
    }
  }
  
  private static void refreshTotalExternalStorage()
  {
    AppMethodBeat.i(17997);
    try
    {
      if (externalStorageExists())
      {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l = localStatFs.getBlockCount();
        totalExternalStorageGB = localStatFs.getBlockSize() * l;
      }
      totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
      AppMethodBeat.o(17997);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(17997);
    }
  }
  
  public static String safeGetStringFromResponse(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(17963);
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString(paramString, "");
      AppMethodBeat.o(17963);
      return paramJSONObject;
    }
    AppMethodBeat.o(17963);
    return "";
  }
  
  public static void setAppEventAttributionParameters(JSONObject paramJSONObject, AttributionIdentifiers paramAttributionIdentifiers, String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(17971);
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
      AppMethodBeat.o(17971);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void setAppEventExtendedDeviceInfoParameters(JSONObject paramJSONObject, Context paramContext)
  {
    AppMethodBeat.i(17972);
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
          AppMethodBeat.o(17972);
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
    AppMethodBeat.i(17937);
    paramString = hashWithAlgorithm("SHA-1", paramString);
    AppMethodBeat.o(17937);
    return paramString;
  }
  
  public static String sha1hash(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17938);
    paramArrayOfByte = hashWithAlgorithm("SHA-1", paramArrayOfByte);
    AppMethodBeat.o(17938);
    return paramArrayOfByte;
  }
  
  public static boolean stringsEqualOrEmpty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17955);
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(17955);
      return true;
    }
    if ((!bool1) && (!bool2))
    {
      bool1 = paramString1.equals(paramString2);
      AppMethodBeat.o(17955);
      return bool1;
    }
    AppMethodBeat.o(17955);
    return false;
  }
  
  public static JSONArray tryGetJSONArrayFromResponse(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(17965);
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
      AppMethodBeat.o(17965);
      return paramJSONObject;
    }
    AppMethodBeat.o(17965);
    return null;
  }
  
  public static JSONObject tryGetJSONObjectFromResponse(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(17964);
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject(paramString);
      AppMethodBeat.o(17964);
      return paramJSONObject;
    }
    AppMethodBeat.o(17964);
    return null;
  }
  
  public static <T> Collection<T> unmodifiableCollection(T... paramVarArgs)
  {
    AppMethodBeat.i(17933);
    paramVarArgs = Collections.unmodifiableCollection(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(17933);
    return paramVarArgs;
  }
  
  public static void writeStringMapToParcel(Parcel paramParcel, Map<String, String> paramMap)
  {
    AppMethodBeat.i(17985);
    if (paramMap == null)
    {
      paramParcel.writeInt(-1);
      AppMethodBeat.o(17985);
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
    AppMethodBeat.o(17985);
  }
  
  public static abstract interface GraphMeRequestWithCacheCallback
  {
    public abstract void onFailure(FacebookException paramFacebookException);
    
    public abstract void onSuccess(JSONObject paramJSONObject);
  }
  
  public static abstract interface Mapper<T, K>
  {
    public abstract K apply(T paramT);
  }
  
  public static class PermissionsPair
  {
    List<String> declinedPermissions;
    List<String> grantedPermissions;
    
    public PermissionsPair(List<String> paramList1, List<String> paramList2)
    {
      this.grantedPermissions = paramList1;
      this.declinedPermissions = paramList2;
    }
    
    public List<String> getDeclinedPermissions()
    {
      return this.declinedPermissions;
    }
    
    public List<String> getGrantedPermissions()
    {
      return this.grantedPermissions;
    }
  }
  
  public static abstract interface Predicate<T>
  {
    public abstract boolean apply(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.Utility
 * JD-Core Version:    0.7.0.1
 */