package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest
{
  private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
  public static final String ACCESS_TOKEN_PARAM = "access_token";
  private static final String ATTACHED_FILES_PARAM = "attached_files";
  private static final String ATTACHMENT_FILENAME_PREFIX = "file";
  private static final String BATCH_APP_ID_PARAM = "batch_app_id";
  private static final String BATCH_BODY_PARAM = "body";
  private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
  private static final String BATCH_ENTRY_NAME_PARAM = "name";
  private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
  private static final String BATCH_METHOD_PARAM = "method";
  private static final String BATCH_PARAM = "batch";
  private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
  private static final String CAPTION_PARAM = "caption";
  private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
  private static final String CONTENT_TYPE_HEADER = "Content-Type";
  private static final String DEBUG_KEY = "__debug__";
  private static final String DEBUG_MESSAGES_KEY = "messages";
  private static final String DEBUG_MESSAGE_KEY = "message";
  private static final String DEBUG_MESSAGE_LINK_KEY = "link";
  private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
  private static final String DEBUG_PARAM = "debug";
  private static final String DEBUG_SEVERITY_INFO = "info";
  private static final String DEBUG_SEVERITY_WARNING = "warning";
  public static final String FIELDS_PARAM = "fields";
  private static final String FORMAT_JSON = "json";
  private static final String FORMAT_PARAM = "format";
  private static final String GRAPH_PATH_FORMAT = "%s/%s";
  private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
  public static final int MAXIMUM_BATCH_SIZE = 50;
  private static final String ME = "me";
  private static final String MIME_BOUNDARY;
  private static final String MY_FRIENDS = "me/friends";
  private static final String MY_PHOTOS = "me/photos";
  private static final String PICTURE_PARAM = "picture";
  private static final String SDK_ANDROID = "android";
  private static final String SDK_PARAM = "sdk";
  private static final String SEARCH = "search";
  public static final String TAG;
  private static final String USER_AGENT_BASE = "FBAndroidSDK";
  private static final String USER_AGENT_HEADER = "User-Agent";
  private static final String VIDEOS_SUFFIX = "/videos";
  private static String defaultBatchApplicationId;
  private static volatile String userAgent;
  private static Pattern versionPattern;
  private AccessToken accessToken;
  private String batchEntryDependsOn;
  private String batchEntryName;
  private boolean batchEntryOmitResultOnSuccess;
  private Callback callback;
  private JSONObject graphObject;
  private String graphPath;
  private HttpMethod httpMethod;
  private String overriddenURL;
  private Bundle parameters;
  private boolean skipClientToken;
  private Object tag;
  private String version;
  
  static
  {
    AppMethodBeat.i(17159);
    TAG = GraphRequest.class.getSimpleName();
    versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    char[] arrayOfChar = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    StringBuilder localStringBuilder = new StringBuilder();
    SecureRandom localSecureRandom = new SecureRandom();
    int j = localSecureRandom.nextInt(11);
    int i = 0;
    while (i < j + 30)
    {
      localStringBuilder.append(arrayOfChar[localSecureRandom.nextInt(arrayOfChar.length)]);
      i += 1;
    }
    MIME_BOUNDARY = localStringBuilder.toString();
    AppMethodBeat.o(17159);
  }
  
  public GraphRequest()
  {
    this(null, null, null, null, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString)
  {
    this(paramAccessToken, paramString, null, null, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod)
  {
    this(paramAccessToken, paramString, paramBundle, paramHttpMethod, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod, Callback paramCallback)
  {
    this(paramAccessToken, paramString, paramBundle, paramHttpMethod, paramCallback, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString1, Bundle paramBundle, HttpMethod paramHttpMethod, Callback paramCallback, String paramString2)
  {
    AppMethodBeat.i(17100);
    this.batchEntryOmitResultOnSuccess = true;
    this.skipClientToken = false;
    this.accessToken = paramAccessToken;
    this.graphPath = paramString1;
    this.version = paramString2;
    setCallback(paramCallback);
    setHttpMethod(paramHttpMethod);
    if (paramBundle != null) {}
    for (this.parameters = new Bundle(paramBundle);; this.parameters = new Bundle())
    {
      if (this.version == null) {
        this.version = FacebookSdk.getGraphApiVersion();
      }
      AppMethodBeat.o(17100);
      return;
    }
  }
  
  GraphRequest(AccessToken paramAccessToken, URL paramURL)
  {
    AppMethodBeat.i(17101);
    this.batchEntryOmitResultOnSuccess = true;
    this.skipClientToken = false;
    this.accessToken = paramAccessToken;
    this.overriddenURL = paramURL.toString();
    setHttpMethod(HttpMethod.GET);
    this.parameters = new Bundle();
    AppMethodBeat.o(17101);
  }
  
  private void addCommonParameters()
  {
    AppMethodBeat.i(17134);
    String str1;
    if (this.accessToken != null) {
      if (!this.parameters.containsKey("access_token"))
      {
        str1 = this.accessToken.getToken();
        Logger.registerAccessToken(str1);
        this.parameters.putString("access_token", str1);
      }
    }
    for (;;)
    {
      this.parameters.putString("sdk", "android");
      this.parameters.putString("format", "json");
      if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
        break;
      }
      this.parameters.putString("debug", "info");
      AppMethodBeat.o(17134);
      return;
      if ((!this.skipClientToken) && (!this.parameters.containsKey("access_token")))
      {
        str1 = FacebookSdk.getApplicationId();
        String str2 = FacebookSdk.getClientToken();
        if ((!Utility.isNullOrEmpty(str1)) && (!Utility.isNullOrEmpty(str2)))
        {
          str1 = str1 + "|" + str2;
          this.parameters.putString("access_token", str1);
        }
        else
        {
          Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
        }
      }
    }
    if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
      this.parameters.putString("debug", "warning");
    }
    AppMethodBeat.o(17134);
  }
  
  private String appendParametersToBaseUrl(String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(17135);
    if ((!paramBoolean.booleanValue()) && (this.httpMethod == HttpMethod.POST))
    {
      AppMethodBeat.o(17135);
      return paramString;
    }
    Uri.Builder localBuilder = Uri.parse(paramString).buildUpon();
    Iterator localIterator = this.parameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramBoolean = this.parameters.get(str);
      paramString = paramBoolean;
      if (paramBoolean == null) {
        paramString = "";
      }
      if (isSupportedParameterType(paramString))
      {
        localBuilder.appendQueryParameter(str, parameterToString(paramString).toString());
      }
      else if (this.httpMethod == HttpMethod.GET)
      {
        paramString = new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[] { paramString.getClass().getSimpleName() }));
        AppMethodBeat.o(17135);
        throw paramString;
      }
    }
    paramString = localBuilder.toString();
    AppMethodBeat.o(17135);
    return paramString;
  }
  
  private static HttpURLConnection createConnection(URL paramURL)
  {
    AppMethodBeat.i(17133);
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setRequestProperty("User-Agent", getUserAgent());
    paramURL.setRequestProperty("Accept-Language", Locale.getDefault().toString());
    paramURL.setChunkedStreamingMode(0);
    AppMethodBeat.o(17133);
    return paramURL;
  }
  
  public static GraphResponse executeAndWait(GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(17120);
    paramGraphRequest = executeBatchAndWait(new GraphRequest[] { paramGraphRequest });
    if ((paramGraphRequest == null) || (paramGraphRequest.size() != 1))
    {
      paramGraphRequest = new FacebookException("invalid state: expected a single response");
      AppMethodBeat.o(17120);
      throw paramGraphRequest;
    }
    paramGraphRequest = (GraphResponse)paramGraphRequest.get(0);
    AppMethodBeat.o(17120);
    return paramGraphRequest;
  }
  
  public static List<GraphResponse> executeBatchAndWait(GraphRequestBatch paramGraphRequestBatch)
  {
    Object localObject2 = null;
    AppMethodBeat.i(17123);
    Validate.notEmptyAndContainsNoNulls(paramGraphRequestBatch, "requests");
    Object localObject1 = localObject2;
    try
    {
      HttpURLConnection localHttpURLConnection = toHttpConnection(paramGraphRequestBatch);
      localObject2 = localHttpURLConnection;
      localObject1 = localObject2;
      paramGraphRequestBatch = executeConnectionAndWait(localObject2, paramGraphRequestBatch);
      return paramGraphRequestBatch;
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      List localList = GraphResponse.constructErrorResponses(paramGraphRequestBatch.getRequests(), null, new FacebookException(localException));
      localObject1 = localObject2;
      runCallbacks(paramGraphRequestBatch, localList);
      Utility.disconnectQuietly(null);
      AppMethodBeat.o(17123);
      return localList;
    }
    finally
    {
      Utility.disconnectQuietly(localObject1);
      AppMethodBeat.o(17123);
    }
  }
  
  public static List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> paramCollection)
  {
    AppMethodBeat.i(17122);
    paramCollection = executeBatchAndWait(new GraphRequestBatch(paramCollection));
    AppMethodBeat.o(17122);
    return paramCollection;
  }
  
  public static List<GraphResponse> executeBatchAndWait(GraphRequest... paramVarArgs)
  {
    AppMethodBeat.i(17121);
    Validate.notNull(paramVarArgs, "requests");
    paramVarArgs = executeBatchAndWait(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(17121);
    return paramVarArgs;
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17126);
    Validate.notEmptyAndContainsNoNulls(paramGraphRequestBatch, "requests");
    paramGraphRequestBatch = new GraphRequestAsyncTask(paramGraphRequestBatch);
    paramGraphRequestBatch.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
    AppMethodBeat.o(17126);
    return paramGraphRequestBatch;
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> paramCollection)
  {
    AppMethodBeat.i(17125);
    paramCollection = executeBatchAsync(new GraphRequestBatch(paramCollection));
    AppMethodBeat.o(17125);
    return paramCollection;
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... paramVarArgs)
  {
    AppMethodBeat.i(17124);
    Validate.notNull(paramVarArgs, "requests");
    paramVarArgs = executeBatchAsync(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(17124);
    return paramVarArgs;
  }
  
  public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17128);
    List localList = GraphResponse.fromHttpConnection(paramHttpURLConnection, paramGraphRequestBatch);
    Utility.disconnectQuietly(paramHttpURLConnection);
    int i = paramGraphRequestBatch.size();
    if (i != localList.size())
    {
      paramHttpURLConnection = new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i) }));
      AppMethodBeat.o(17128);
      throw paramHttpURLConnection;
    }
    runCallbacks(paramGraphRequestBatch, localList);
    AccessTokenManager.getInstance().extendAccessTokenIfNeeded();
    AppMethodBeat.o(17128);
    return localList;
  }
  
  public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, Collection<GraphRequest> paramCollection)
  {
    AppMethodBeat.i(17127);
    paramHttpURLConnection = executeConnectionAndWait(paramHttpURLConnection, new GraphRequestBatch(paramCollection));
    AppMethodBeat.o(17127);
    return paramHttpURLConnection;
  }
  
  public static GraphRequestAsyncTask executeConnectionAsync(Handler paramHandler, HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17130);
    Validate.notNull(paramHttpURLConnection, "connection");
    paramHttpURLConnection = new GraphRequestAsyncTask(paramHttpURLConnection, paramGraphRequestBatch);
    paramGraphRequestBatch.setCallbackHandler(paramHandler);
    paramHttpURLConnection.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
    AppMethodBeat.o(17130);
    return paramHttpURLConnection;
  }
  
  public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17129);
    paramHttpURLConnection = executeConnectionAsync(null, paramHttpURLConnection, paramGraphRequestBatch);
    AppMethodBeat.o(17129);
    return paramHttpURLConnection;
  }
  
  private static String getBatchAppId(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17155);
    if (!Utility.isNullOrEmpty(paramGraphRequestBatch.getBatchApplicationId()))
    {
      paramGraphRequestBatch = paramGraphRequestBatch.getBatchApplicationId();
      AppMethodBeat.o(17155);
      return paramGraphRequestBatch;
    }
    paramGraphRequestBatch = paramGraphRequestBatch.iterator();
    while (paramGraphRequestBatch.hasNext())
    {
      Object localObject = ((GraphRequest)paramGraphRequestBatch.next()).accessToken;
      if (localObject != null)
      {
        localObject = ((AccessToken)localObject).getApplicationId();
        if (localObject != null)
        {
          AppMethodBeat.o(17155);
          return localObject;
        }
      }
    }
    if (!Utility.isNullOrEmpty(defaultBatchApplicationId))
    {
      paramGraphRequestBatch = defaultBatchApplicationId;
      AppMethodBeat.o(17155);
      return paramGraphRequestBatch;
    }
    paramGraphRequestBatch = FacebookSdk.getApplicationId();
    AppMethodBeat.o(17155);
    return paramGraphRequestBatch;
  }
  
  public static final String getDefaultBatchApplicationId()
  {
    return defaultBatchApplicationId;
  }
  
  private static String getDefaultPhotoPathIfNull(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "me/photos";
    }
    return str;
  }
  
  private String getGraphPathWithVersion()
  {
    AppMethodBeat.i(17138);
    if (versionPattern.matcher(this.graphPath).matches())
    {
      str = this.graphPath;
      AppMethodBeat.o(17138);
      return str;
    }
    String str = String.format("%s/%s", new Object[] { this.version, this.graphPath });
    AppMethodBeat.o(17138);
    return str;
  }
  
  private static String getMimeContentType()
  {
    AppMethodBeat.i(17153);
    String str = String.format("multipart/form-data; boundary=%s", new Object[] { MIME_BOUNDARY });
    AppMethodBeat.o(17153);
    return str;
  }
  
  private static String getUserAgent()
  {
    AppMethodBeat.i(17154);
    if (userAgent == null)
    {
      userAgent = String.format("%s.%s", new Object[] { "FBAndroidSDK", "4.38.1" });
      str = InternalSettings.getCustomUserAgent();
      if (!Utility.isNullOrEmpty(str)) {
        userAgent = String.format(Locale.ROOT, "%s/%s", new Object[] { userAgent, str });
      }
    }
    String str = userAgent;
    AppMethodBeat.o(17154);
    return str;
  }
  
  private static boolean hasOnProgressCallbacks(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17140);
    Iterator localIterator = paramGraphRequestBatch.getCallbacks().iterator();
    while (localIterator.hasNext()) {
      if (((GraphRequestBatch.Callback)localIterator.next() instanceof GraphRequestBatch.OnProgressCallback))
      {
        AppMethodBeat.o(17140);
        return true;
      }
    }
    paramGraphRequestBatch = paramGraphRequestBatch.iterator();
    while (paramGraphRequestBatch.hasNext()) {
      if ((((GraphRequest)paramGraphRequestBatch.next()).getCallback() instanceof OnProgressCallback))
      {
        AppMethodBeat.o(17140);
        return true;
      }
    }
    AppMethodBeat.o(17140);
    return false;
  }
  
  private static boolean isGzipCompressible(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17142);
    GraphRequest localGraphRequest;
    String str;
    do
    {
      paramGraphRequestBatch = paramGraphRequestBatch.iterator();
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        if (!paramGraphRequestBatch.hasNext()) {
          break;
        }
        localGraphRequest = (GraphRequest)paramGraphRequestBatch.next();
        localIterator = localGraphRequest.parameters.keySet().iterator();
      }
      str = (String)localIterator.next();
    } while (!isSupportedAttachmentType(localGraphRequest.parameters.get(str)));
    AppMethodBeat.o(17142);
    return false;
    AppMethodBeat.o(17142);
    return true;
  }
  
  private static boolean isMeRequest(String paramString)
  {
    AppMethodBeat.i(17147);
    Matcher localMatcher = versionPattern.matcher(paramString);
    if (localMatcher.matches()) {
      paramString = localMatcher.group(1);
    }
    if ((paramString.startsWith("me/")) || (paramString.startsWith("/me/")))
    {
      AppMethodBeat.o(17147);
      return true;
    }
    AppMethodBeat.o(17147);
    return false;
  }
  
  private static boolean isSupportedAttachmentType(Object paramObject)
  {
    return ((paramObject instanceof Bitmap)) || ((paramObject instanceof byte[])) || ((paramObject instanceof Uri)) || ((paramObject instanceof ParcelFileDescriptor)) || ((paramObject instanceof ParcelableResourceWithMimeType));
  }
  
  private static boolean isSupportedParameterType(Object paramObject)
  {
    return ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Number)) || ((paramObject instanceof Date));
  }
  
  public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken paramAccessToken, Context paramContext, Callback paramCallback)
  {
    AppMethodBeat.i(17112);
    paramAccessToken = newCustomAudienceThirdPartyIdRequest(paramAccessToken, paramContext, null, paramCallback);
    AppMethodBeat.o(17112);
    return paramAccessToken;
  }
  
  public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken paramAccessToken, Context paramContext, String paramString, Callback paramCallback)
  {
    AppMethodBeat.i(17111);
    if ((paramString == null) && (paramAccessToken != null)) {
      paramString = paramAccessToken.getApplicationId();
    }
    for (;;)
    {
      String str = paramString;
      if (paramString == null) {
        str = Utility.getMetadataApplicationId(paramContext);
      }
      if (str == null)
      {
        paramAccessToken = new FacebookException("Facebook App ID cannot be determined");
        AppMethodBeat.o(17111);
        throw paramAccessToken;
      }
      str = str + "/custom_audience_third_party_id";
      AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(paramContext);
      Bundle localBundle = new Bundle();
      if (paramAccessToken == null)
      {
        if (localAttributionIdentifiers == null)
        {
          paramAccessToken = new FacebookException("There is no access token and attribution identifiers could not be retrieved");
          AppMethodBeat.o(17111);
          throw paramAccessToken;
        }
        if (localAttributionIdentifiers.getAttributionId() == null) {
          break label209;
        }
      }
      label209:
      for (paramString = localAttributionIdentifiers.getAttributionId();; paramString = localAttributionIdentifiers.getAndroidAdvertiserId())
      {
        if (localAttributionIdentifiers.getAttributionId() != null) {
          localBundle.putString("udid", paramString);
        }
        if ((FacebookSdk.getLimitEventAndDataUsage(paramContext)) || ((localAttributionIdentifiers != null) && (localAttributionIdentifiers.isTrackingLimited()))) {
          localBundle.putString("limit_event_usage", "1");
        }
        paramAccessToken = new GraphRequest(paramAccessToken, str, localBundle, HttpMethod.GET, paramCallback);
        AppMethodBeat.o(17111);
        return paramAccessToken;
      }
    }
  }
  
  public static GraphRequest newDeleteObjectRequest(AccessToken paramAccessToken, String paramString, Callback paramCallback)
  {
    AppMethodBeat.i(17102);
    paramAccessToken = new GraphRequest(paramAccessToken, paramString, null, HttpMethod.DELETE, paramCallback);
    AppMethodBeat.o(17102);
    return paramAccessToken;
  }
  
  public static GraphRequest newGraphPathRequest(AccessToken paramAccessToken, String paramString, Callback paramCallback)
  {
    AppMethodBeat.i(17106);
    paramAccessToken = new GraphRequest(paramAccessToken, paramString, null, null, paramCallback);
    AppMethodBeat.o(17106);
    return paramAccessToken;
  }
  
  public static GraphRequest newMeRequest(AccessToken paramAccessToken, GraphJSONObjectCallback paramGraphJSONObjectCallback)
  {
    AppMethodBeat.i(17103);
    paramAccessToken = new GraphRequest(paramAccessToken, "me", null, null, new Callback()
    {
      public final void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(17076);
        if (this.val$callback != null) {
          this.val$callback.onCompleted(paramAnonymousGraphResponse.getJSONObject(), paramAnonymousGraphResponse);
        }
        AppMethodBeat.o(17076);
      }
    });
    AppMethodBeat.o(17103);
    return paramAccessToken;
  }
  
  public static GraphRequest newMyFriendsRequest(AccessToken paramAccessToken, GraphJSONArrayCallback paramGraphJSONArrayCallback)
  {
    AppMethodBeat.i(17105);
    paramAccessToken = new GraphRequest(paramAccessToken, "me/friends", null, null, new Callback()
    {
      public final void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(17077);
        if (this.val$callback != null)
        {
          localObject = paramAnonymousGraphResponse.getJSONObject();
          if (localObject == null) {
            break label47;
          }
        }
        label47:
        for (Object localObject = ((JSONObject)localObject).optJSONArray("data");; localObject = null)
        {
          this.val$callback.onCompleted((JSONArray)localObject, paramAnonymousGraphResponse);
          AppMethodBeat.o(17077);
          return;
        }
      }
    });
    AppMethodBeat.o(17105);
    return paramAccessToken;
  }
  
  public static GraphRequest newPlacesSearchRequest(AccessToken paramAccessToken, Location paramLocation, int paramInt1, int paramInt2, String paramString, GraphJSONArrayCallback paramGraphJSONArrayCallback)
  {
    AppMethodBeat.i(17107);
    if ((paramLocation == null) && (Utility.isNullOrEmpty(paramString)))
    {
      paramAccessToken = new FacebookException("Either location or searchText must be specified.");
      AppMethodBeat.o(17107);
      throw paramAccessToken;
    }
    Bundle localBundle = new Bundle(5);
    localBundle.putString("type", "place");
    localBundle.putInt("limit", paramInt2);
    if (paramLocation != null)
    {
      localBundle.putString("center", String.format(Locale.US, "%f,%f", new Object[] { Double.valueOf(paramLocation.getLatitude()), Double.valueOf(paramLocation.getLongitude()) }));
      localBundle.putInt("distance", paramInt1);
    }
    if (!Utility.isNullOrEmpty(paramString)) {
      localBundle.putString("q", paramString);
    }
    paramLocation = new Callback()
    {
      public final void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(17078);
        if (this.val$callback != null)
        {
          localObject = paramAnonymousGraphResponse.getJSONObject();
          if (localObject == null) {
            break label47;
          }
        }
        label47:
        for (Object localObject = ((JSONObject)localObject).optJSONArray("data");; localObject = null)
        {
          this.val$callback.onCompleted((JSONArray)localObject, paramAnonymousGraphResponse);
          AppMethodBeat.o(17078);
          return;
        }
      }
    };
    paramAccessToken = new GraphRequest(paramAccessToken, "search", localBundle, HttpMethod.GET, paramLocation);
    AppMethodBeat.o(17107);
    return paramAccessToken;
  }
  
  public static GraphRequest newPostRequest(AccessToken paramAccessToken, String paramString, JSONObject paramJSONObject, Callback paramCallback)
  {
    AppMethodBeat.i(17104);
    paramAccessToken = new GraphRequest(paramAccessToken, paramString, null, HttpMethod.POST, paramCallback);
    paramAccessToken.setGraphObject(paramJSONObject);
    AppMethodBeat.o(17104);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, Bitmap paramBitmap, String paramString2, Bundle paramBundle, Callback paramCallback)
  {
    AppMethodBeat.i(17108);
    paramString1 = getDefaultPhotoPathIfNull(paramString1);
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putParcelable("picture", paramBitmap);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      localBundle.putString("caption", paramString2);
    }
    paramAccessToken = new GraphRequest(paramAccessToken, paramString1, localBundle, HttpMethod.POST, paramCallback);
    AppMethodBeat.o(17108);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, Uri paramUri, String paramString2, Bundle paramBundle, Callback paramCallback)
  {
    AppMethodBeat.i(17110);
    paramString1 = getDefaultPhotoPathIfNull(paramString1);
    if (Utility.isFileUri(paramUri))
    {
      paramAccessToken = newUploadPhotoRequest(paramAccessToken, paramString1, new File(paramUri.getPath()), paramString2, paramBundle, paramCallback);
      AppMethodBeat.o(17110);
      return paramAccessToken;
    }
    if (!Utility.isContentUri(paramUri))
    {
      paramAccessToken = new FacebookException("The photo Uri must be either a file:// or content:// Uri");
      AppMethodBeat.o(17110);
      throw paramAccessToken;
    }
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putParcelable("picture", paramUri);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      localBundle.putString("caption", paramString2);
    }
    paramAccessToken = new GraphRequest(paramAccessToken, paramString1, localBundle, HttpMethod.POST, paramCallback);
    AppMethodBeat.o(17110);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, File paramFile, String paramString2, Bundle paramBundle, Callback paramCallback)
  {
    AppMethodBeat.i(17109);
    paramString1 = getDefaultPhotoPathIfNull(paramString1);
    paramFile = ParcelFileDescriptor.open(paramFile, 268435456);
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putParcelable("picture", paramFile);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      localBundle.putString("caption", paramString2);
    }
    paramAccessToken = new GraphRequest(paramAccessToken, paramString1, localBundle, HttpMethod.POST, paramCallback);
    AppMethodBeat.o(17109);
    return paramAccessToken;
  }
  
  private static String parameterToString(Object paramObject)
  {
    AppMethodBeat.i(17156);
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      AppMethodBeat.o(17156);
      return paramObject;
    }
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof Number)))
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(17156);
      return paramObject;
    }
    if ((paramObject instanceof Date))
    {
      paramObject = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(paramObject);
      AppMethodBeat.o(17156);
      return paramObject;
    }
    paramObject = new IllegalArgumentException("Unsupported parameter type.");
    AppMethodBeat.o(17156);
    throw paramObject;
  }
  
  private static void processGraphObject(JSONObject paramJSONObject, String paramString, KeyValueSerializer paramKeyValueSerializer)
  {
    AppMethodBeat.i(17148);
    int i;
    if (isMeRequest(paramString))
    {
      i = paramString.indexOf(":");
      int j = paramString.indexOf("?");
      if ((i > 3) && ((j == -1) || (i < j))) {
        i = 1;
      }
    }
    for (;;)
    {
      paramString = paramJSONObject.keys();
      label54:
      if (paramString.hasNext())
      {
        String str = (String)paramString.next();
        Object localObject = paramJSONObject.opt(str);
        if ((i != 0) && (str.equalsIgnoreCase("image"))) {}
        for (boolean bool = true;; bool = false)
        {
          processGraphObjectProperty(str, localObject, paramKeyValueSerializer, bool);
          break label54;
          i = 0;
          break;
        }
      }
      AppMethodBeat.o(17148);
      return;
      i = 0;
    }
  }
  
  private static void processGraphObjectProperty(String paramString, Object paramObject, KeyValueSerializer paramKeyValueSerializer, boolean paramBoolean)
  {
    AppMethodBeat.i(17149);
    Object localObject;
    for (;;)
    {
      localObject = paramObject.getClass();
      if (!JSONObject.class.isAssignableFrom((Class)localObject)) {
        break label167;
      }
      paramObject = (JSONObject)paramObject;
      if (paramBoolean)
      {
        localObject = paramObject.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          processGraphObjectProperty(String.format("%s[%s]", new Object[] { paramString, str }), paramObject.opt(str), paramKeyValueSerializer, paramBoolean);
        }
        AppMethodBeat.o(17149);
        return;
      }
      if (paramObject.has("id"))
      {
        paramObject = paramObject.optString("id");
      }
      else if (paramObject.has("url"))
      {
        paramObject = paramObject.optString("url");
      }
      else
      {
        if (!paramObject.has("fbsdk:create_object")) {
          break;
        }
        paramObject = paramObject.toString();
      }
    }
    AppMethodBeat.o(17149);
    return;
    label167:
    if (JSONArray.class.isAssignableFrom((Class)localObject))
    {
      paramObject = (JSONArray)paramObject;
      int j = paramObject.length();
      int i = 0;
      while (i < j)
      {
        processGraphObjectProperty(String.format(Locale.ROOT, "%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), paramObject.opt(i), paramKeyValueSerializer, paramBoolean);
        i += 1;
      }
      AppMethodBeat.o(17149);
      return;
    }
    if ((String.class.isAssignableFrom((Class)localObject)) || (Number.class.isAssignableFrom((Class)localObject)) || (Boolean.class.isAssignableFrom((Class)localObject)))
    {
      paramKeyValueSerializer.writeString(paramString, paramObject.toString());
      AppMethodBeat.o(17149);
      return;
    }
    if (Date.class.isAssignableFrom((Class)localObject))
    {
      paramObject = (Date)paramObject;
      paramKeyValueSerializer.writeString(paramString, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(paramObject));
    }
    AppMethodBeat.o(17149);
  }
  
  private static void processRequest(GraphRequestBatch paramGraphRequestBatch, Logger paramLogger, int paramInt, URL paramURL, OutputStream paramOutputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(17146);
    paramOutputStream = new Serializer(paramOutputStream, paramLogger, paramBoolean);
    if (paramInt == 1)
    {
      paramGraphRequestBatch = paramGraphRequestBatch.get(0);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramGraphRequestBatch.parameters.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramGraphRequestBatch.parameters.get(str);
        if (isSupportedAttachmentType(localObject)) {
          localHashMap.put(str, new Attachment(paramGraphRequestBatch, localObject));
        }
      }
      if (paramLogger != null) {
        paramLogger.append("  Parameters:\n");
      }
      serializeParameters(paramGraphRequestBatch.parameters, paramOutputStream, paramGraphRequestBatch);
      if (paramLogger != null) {
        paramLogger.append("  Attachments:\n");
      }
      serializeAttachments(localHashMap, paramOutputStream);
      if (paramGraphRequestBatch.graphObject != null) {
        processGraphObject(paramGraphRequestBatch.graphObject, paramURL.getPath(), paramOutputStream);
      }
      AppMethodBeat.o(17146);
      return;
    }
    paramURL = getBatchAppId(paramGraphRequestBatch);
    if (Utility.isNullOrEmpty(paramURL))
    {
      paramGraphRequestBatch = new FacebookException("App ID was not specified at the request or Settings.");
      AppMethodBeat.o(17146);
      throw paramGraphRequestBatch;
    }
    paramOutputStream.writeString("batch_app_id", paramURL);
    paramURL = new HashMap();
    serializeRequestsAsJSON(paramOutputStream, paramGraphRequestBatch, paramURL);
    if (paramLogger != null) {
      paramLogger.append("  Attachments:\n");
    }
    serializeAttachments(paramURL, paramOutputStream);
    AppMethodBeat.o(17146);
  }
  
  static void runCallbacks(final GraphRequestBatch paramGraphRequestBatch, List<GraphResponse> paramList)
  {
    AppMethodBeat.i(17132);
    int j = paramGraphRequestBatch.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      GraphRequest localGraphRequest = paramGraphRequestBatch.get(i);
      if (localGraphRequest.callback != null) {
        localArrayList.add(new Pair(localGraphRequest.callback, paramList.get(i)));
      }
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramList = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(17080);
          Iterator localIterator = this.val$callbacks.iterator();
          while (localIterator.hasNext())
          {
            Pair localPair = (Pair)localIterator.next();
            ((GraphRequest.Callback)localPair.first).onCompleted((GraphResponse)localPair.second);
          }
          localIterator = paramGraphRequestBatch.getCallbacks().iterator();
          while (localIterator.hasNext()) {
            ((GraphRequestBatch.Callback)localIterator.next()).onBatchCompleted(paramGraphRequestBatch);
          }
          AppMethodBeat.o(17080);
        }
      };
      paramGraphRequestBatch = paramGraphRequestBatch.getCallbackHandler();
      if (paramGraphRequestBatch == null)
      {
        paramList.run();
        AppMethodBeat.o(17132);
        return;
      }
      paramGraphRequestBatch.post(paramList);
    }
    AppMethodBeat.o(17132);
  }
  
  private static void serializeAttachments(Map<String, Attachment> paramMap, Serializer paramSerializer)
  {
    AppMethodBeat.i(17151);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Attachment localAttachment = (Attachment)paramMap.get(str);
      if (isSupportedAttachmentType(localAttachment.getValue())) {
        paramSerializer.writeObject(str, localAttachment.getValue(), localAttachment.getRequest());
      }
    }
    AppMethodBeat.o(17151);
  }
  
  private static void serializeParameters(Bundle paramBundle, Serializer paramSerializer, GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(17150);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (isSupportedParameterType(localObject)) {
        paramSerializer.writeObject(str, localObject, paramGraphRequest);
      }
    }
    AppMethodBeat.o(17150);
  }
  
  private static void serializeRequestsAsJSON(Serializer paramSerializer, Collection<GraphRequest> paramCollection, Map<String, Attachment> paramMap)
  {
    AppMethodBeat.i(17152);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      ((GraphRequest)localIterator.next()).serializeToBatch(localJSONArray, paramMap);
    }
    paramSerializer.writeRequestsAsJson("batch", localJSONArray, paramCollection);
    AppMethodBeat.o(17152);
  }
  
  private void serializeToBatch(JSONArray paramJSONArray, final Map<String, Attachment> paramMap)
  {
    AppMethodBeat.i(17139);
    JSONObject localJSONObject = new JSONObject();
    if (this.batchEntryName != null)
    {
      localJSONObject.put("name", this.batchEntryName);
      localJSONObject.put("omit_response_on_success", this.batchEntryOmitResultOnSuccess);
    }
    if (this.batchEntryDependsOn != null) {
      localJSONObject.put("depends_on", this.batchEntryDependsOn);
    }
    String str1 = getRelativeUrlForBatchedRequest();
    localJSONObject.put("relative_url", str1);
    localJSONObject.put("method", this.httpMethod);
    if (this.accessToken != null) {
      Logger.registerAccessToken(this.accessToken.getToken());
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.parameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = this.parameters.get((String)localObject);
      if (isSupportedAttachmentType(localObject))
      {
        String str2 = String.format(Locale.ROOT, "%s%d", new Object[] { "file", Integer.valueOf(paramMap.size()) });
        localArrayList.add(str2);
        paramMap.put(str2, new Attachment(this, localObject));
      }
    }
    if (!localArrayList.isEmpty()) {
      localJSONObject.put("attached_files", TextUtils.join(",", localArrayList));
    }
    if (this.graphObject != null)
    {
      paramMap = new ArrayList();
      processGraphObject(this.graphObject, str1, new KeyValueSerializer()
      {
        public void writeString(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(17081);
          paramMap.add(String.format(Locale.US, "%s=%s", new Object[] { paramAnonymousString1, URLEncoder.encode(paramAnonymousString2, "UTF-8") }));
          AppMethodBeat.o(17081);
        }
      });
      localJSONObject.put("body", TextUtils.join("&", paramMap));
    }
    paramJSONArray.put(localJSONObject);
    AppMethodBeat.o(17139);
  }
  
  /* Error */
  static final void serializeToUrlConnection(GraphRequestBatch paramGraphRequestBatch, HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: sipush 17145
    //   3: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 319	com/facebook/internal/Logger
    //   9: dup
    //   10: getstatic 1045	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   13: ldc_w 1047
    //   16: invokespecial 1050	com/facebook/internal/Logger:<init>	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V
    //   19: astore 7
    //   21: aload_0
    //   22: invokevirtual 570	com/facebook/GraphRequestBatch:size	()I
    //   25: istore_3
    //   26: aload_0
    //   27: invokestatic 1052	com/facebook/GraphRequest:isGzipCompressible	(Lcom/facebook/GraphRequestBatch;)Z
    //   30: istore 4
    //   32: iload_3
    //   33: iconst_1
    //   34: if_icmpne +144 -> 178
    //   37: aload_0
    //   38: iconst_0
    //   39: invokevirtual 903	com/facebook/GraphRequestBatch:get	(I)Lcom/facebook/GraphRequest;
    //   42: getfield 371	com/facebook/GraphRequest:httpMethod	Lcom/facebook/HttpMethod;
    //   45: astore 5
    //   47: aload_1
    //   48: aload 5
    //   50: invokevirtual 1054	com/facebook/HttpMethod:name	()Ljava/lang/String;
    //   53: invokevirtual 1057	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   56: aload_1
    //   57: iload 4
    //   59: invokestatic 1061	com/facebook/GraphRequest:setConnectionContentType	(Ljava/net/HttpURLConnection;Z)V
    //   62: aload_1
    //   63: invokevirtual 1065	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   66: astore 8
    //   68: aload 7
    //   70: ldc_w 1067
    //   73: invokevirtual 919	com/facebook/internal/Logger:append	(Ljava/lang/String;)V
    //   76: aload 7
    //   78: ldc_w 1069
    //   81: aload_0
    //   82: invokevirtual 1072	com/facebook/GraphRequestBatch:getId	()Ljava/lang/String;
    //   85: invokevirtual 1076	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: aload 7
    //   90: ldc_w 1078
    //   93: aload 8
    //   95: invokevirtual 1076	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   98: aload 7
    //   100: ldc_w 1080
    //   103: aload_1
    //   104: invokevirtual 1083	java/net/HttpURLConnection:getRequestMethod	()Ljava/lang/String;
    //   107: invokevirtual 1076	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   110: aload 7
    //   112: ldc 159
    //   114: aload_1
    //   115: ldc 159
    //   117: invokevirtual 1086	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokevirtual 1076	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   123: aload 7
    //   125: ldc 88
    //   127: aload_1
    //   128: ldc 88
    //   130: invokevirtual 1086	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokevirtual 1076	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   136: aload_1
    //   137: aload_0
    //   138: invokevirtual 1089	com/facebook/GraphRequestBatch:getTimeout	()I
    //   141: invokevirtual 1092	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   144: aload_1
    //   145: aload_0
    //   146: invokevirtual 1089	com/facebook/GraphRequestBatch:getTimeout	()I
    //   149: invokevirtual 1095	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   152: aload 5
    //   154: getstatic 374	com/facebook/HttpMethod:POST	Lcom/facebook/HttpMethod;
    //   157: if_acmpne +29 -> 186
    //   160: iconst_1
    //   161: istore_2
    //   162: iload_2
    //   163: ifne +28 -> 191
    //   166: aload 7
    //   168: invokevirtual 1098	com/facebook/internal/Logger:log	()V
    //   171: sipush 17145
    //   174: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: return
    //   178: getstatic 374	com/facebook/HttpMethod:POST	Lcom/facebook/HttpMethod;
    //   181: astore 5
    //   183: goto -136 -> 47
    //   186: iconst_0
    //   187: istore_2
    //   188: goto -26 -> 162
    //   191: aload_1
    //   192: iconst_1
    //   193: invokevirtual 1102	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   196: new 1104	java/io/BufferedOutputStream
    //   199: dup
    //   200: aload_1
    //   201: invokevirtual 1108	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   204: invokespecial 1111	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   207: astore 6
    //   209: aload 6
    //   211: astore_1
    //   212: iload 4
    //   214: ifeq +17 -> 231
    //   217: aload 6
    //   219: astore 5
    //   221: new 1113	java/util/zip/GZIPOutputStream
    //   224: dup
    //   225: aload 6
    //   227: invokespecial 1114	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   230: astore_1
    //   231: aload_1
    //   232: astore 5
    //   234: aload_0
    //   235: invokestatic 1116	com/facebook/GraphRequest:hasOnProgressCallbacks	(Lcom/facebook/GraphRequestBatch;)Z
    //   238: ifeq +124 -> 362
    //   241: aload_1
    //   242: astore 5
    //   244: new 1118	com/facebook/ProgressNoopOutputStream
    //   247: dup
    //   248: aload_0
    //   249: invokevirtual 964	com/facebook/GraphRequestBatch:getCallbackHandler	()Landroid/os/Handler;
    //   252: invokespecial 1120	com/facebook/ProgressNoopOutputStream:<init>	(Landroid/os/Handler;)V
    //   255: astore 6
    //   257: aload_1
    //   258: astore 5
    //   260: aload_0
    //   261: aconst_null
    //   262: iload_3
    //   263: aload 8
    //   265: aload 6
    //   267: iload 4
    //   269: invokestatic 1122	com/facebook/GraphRequest:processRequest	(Lcom/facebook/GraphRequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;Z)V
    //   272: aload_1
    //   273: astore 5
    //   275: aload 6
    //   277: invokevirtual 1125	com/facebook/ProgressNoopOutputStream:getMaxProgress	()I
    //   280: istore_2
    //   281: aload_1
    //   282: astore 5
    //   284: new 1127	com/facebook/ProgressOutputStream
    //   287: dup
    //   288: aload_1
    //   289: aload_0
    //   290: aload 6
    //   292: invokevirtual 1131	com/facebook/ProgressNoopOutputStream:getProgressMap	()Ljava/util/Map;
    //   295: iload_2
    //   296: i2l
    //   297: invokespecial 1134	com/facebook/ProgressOutputStream:<init>	(Ljava/io/OutputStream;Lcom/facebook/GraphRequestBatch;Ljava/util/Map;J)V
    //   300: astore_1
    //   301: aload_0
    //   302: aload 7
    //   304: iload_3
    //   305: aload 8
    //   307: aload_1
    //   308: iload 4
    //   310: invokestatic 1122	com/facebook/GraphRequest:processRequest	(Lcom/facebook/GraphRequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;Z)V
    //   313: aload_1
    //   314: invokevirtual 1139	java/io/OutputStream:close	()V
    //   317: aload 7
    //   319: invokevirtual 1098	com/facebook/internal/Logger:log	()V
    //   322: sipush 17145
    //   325: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: return
    //   329: astore_0
    //   330: aconst_null
    //   331: astore 5
    //   333: aload 5
    //   335: ifnull +8 -> 343
    //   338: aload 5
    //   340: invokevirtual 1139	java/io/OutputStream:close	()V
    //   343: sipush 17145
    //   346: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aload_0
    //   350: athrow
    //   351: astore_0
    //   352: goto -19 -> 333
    //   355: astore_0
    //   356: aload_1
    //   357: astore 5
    //   359: goto -26 -> 333
    //   362: goto -61 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramGraphRequestBatch	GraphRequestBatch
    //   0	365	1	paramHttpURLConnection	HttpURLConnection
    //   161	135	2	i	int
    //   25	280	3	j	int
    //   30	279	4	bool	boolean
    //   45	313	5	localObject1	Object
    //   207	84	6	localObject2	Object
    //   19	299	7	localLogger	Logger
    //   66	240	8	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   196	209	329	finally
    //   221	231	351	finally
    //   234	241	351	finally
    //   244	257	351	finally
    //   260	272	351	finally
    //   275	281	351	finally
    //   284	301	351	finally
    //   301	313	355	finally
  }
  
  private static void setConnectionContentType(HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    AppMethodBeat.i(17141);
    if (paramBoolean)
    {
      paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      paramHttpURLConnection.setRequestProperty("Content-Encoding", "gzip");
      AppMethodBeat.o(17141);
      return;
    }
    paramHttpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
    AppMethodBeat.o(17141);
  }
  
  public static final void setDefaultBatchApplicationId(String paramString)
  {
    defaultBatchApplicationId = paramString;
  }
  
  static final boolean shouldWarnOnMissingFieldsParam(GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(17143);
    String str = paramGraphRequest.getVersion();
    if (Utility.isNullOrEmpty(str))
    {
      AppMethodBeat.o(17143);
      return true;
    }
    paramGraphRequest = str;
    if (str.startsWith("v")) {
      paramGraphRequest = str.substring(1);
    }
    paramGraphRequest = paramGraphRequest.split("\\.");
    if (((paramGraphRequest.length >= 2) && (Integer.parseInt(paramGraphRequest[0]) > 2)) || ((Integer.parseInt(paramGraphRequest[0]) >= 2) && (Integer.parseInt(paramGraphRequest[1]) >= 4)))
    {
      AppMethodBeat.o(17143);
      return true;
    }
    AppMethodBeat.o(17143);
    return false;
  }
  
  public static HttpURLConnection toHttpConnection(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17119);
    validateFieldsParamForGetRequests(paramGraphRequestBatch);
    for (;;)
    {
      try
      {
        if (paramGraphRequestBatch.size() == 1)
        {
          localObject3 = new URL(paramGraphRequestBatch.get(0).getUrlForSingleRequest());
          localObject2 = null;
          localObject1 = null;
        }
      }
      catch (MalformedURLException paramGraphRequestBatch)
      {
        Object localObject3;
        paramGraphRequestBatch = new FacebookException("could not construct URL for request", paramGraphRequestBatch);
        AppMethodBeat.o(17119);
        throw paramGraphRequestBatch;
      }
      try
      {
        localObject3 = createConnection((URL)localObject3);
        localObject1 = localObject3;
        localObject2 = localObject3;
        serializeToUrlConnection(paramGraphRequestBatch, (HttpURLConnection)localObject3);
        AppMethodBeat.o(17119);
        return localObject3;
      }
      catch (JSONException paramGraphRequestBatch)
      {
        Utility.disconnectQuietly(localObject1);
        paramGraphRequestBatch = new FacebookException("could not construct request body", paramGraphRequestBatch);
        AppMethodBeat.o(17119);
        throw paramGraphRequestBatch;
      }
      catch (IOException paramGraphRequestBatch)
      {
        for (;;)
        {
          localObject1 = localObject2;
        }
      }
      localObject3 = new URL(ServerProtocol.getGraphUrlBase());
    }
  }
  
  public static HttpURLConnection toHttpConnection(Collection<GraphRequest> paramCollection)
  {
    AppMethodBeat.i(17118);
    Validate.notEmptyAndContainsNoNulls(paramCollection, "requests");
    paramCollection = toHttpConnection(new GraphRequestBatch(paramCollection));
    AppMethodBeat.o(17118);
    return paramCollection;
  }
  
  public static HttpURLConnection toHttpConnection(GraphRequest... paramVarArgs)
  {
    AppMethodBeat.i(17117);
    paramVarArgs = toHttpConnection(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(17117);
    return paramVarArgs;
  }
  
  static final void validateFieldsParamForGetRequests(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17144);
    paramGraphRequestBatch = paramGraphRequestBatch.iterator();
    while (paramGraphRequestBatch.hasNext())
    {
      GraphRequest localGraphRequest = (GraphRequest)paramGraphRequestBatch.next();
      if ((HttpMethod.GET.equals(localGraphRequest.getHttpMethod())) && (shouldWarnOnMissingFieldsParam(localGraphRequest)))
      {
        Bundle localBundle = localGraphRequest.getParameters();
        if ((!localBundle.containsKey("fields")) || (Utility.isNullOrEmpty(localBundle.getString("fields")))) {
          Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", new Object[] { localGraphRequest.getGraphPath() });
        }
      }
    }
    AppMethodBeat.o(17144);
  }
  
  public final GraphResponse executeAndWait()
  {
    AppMethodBeat.i(17115);
    GraphResponse localGraphResponse = executeAndWait(this);
    AppMethodBeat.o(17115);
    return localGraphResponse;
  }
  
  public final GraphRequestAsyncTask executeAsync()
  {
    AppMethodBeat.i(17116);
    GraphRequestAsyncTask localGraphRequestAsyncTask = executeBatchAsync(new GraphRequest[] { this });
    AppMethodBeat.o(17116);
    return localGraphRequestAsyncTask;
  }
  
  public final AccessToken getAccessToken()
  {
    return this.accessToken;
  }
  
  public final String getBatchEntryDependsOn()
  {
    return this.batchEntryDependsOn;
  }
  
  public final String getBatchEntryName()
  {
    return this.batchEntryName;
  }
  
  public final boolean getBatchEntryOmitResultOnSuccess()
  {
    return this.batchEntryOmitResultOnSuccess;
  }
  
  public final Callback getCallback()
  {
    return this.callback;
  }
  
  public final JSONObject getGraphObject()
  {
    return this.graphObject;
  }
  
  public final String getGraphPath()
  {
    return this.graphPath;
  }
  
  public final HttpMethod getHttpMethod()
  {
    return this.httpMethod;
  }
  
  public final Bundle getParameters()
  {
    return this.parameters;
  }
  
  final String getRelativeUrlForBatchedRequest()
  {
    AppMethodBeat.i(17136);
    if (this.overriddenURL != null)
    {
      localObject = new FacebookException("Can't override URL for a batch request");
      AppMethodBeat.o(17136);
      throw ((Throwable)localObject);
    }
    Object localObject = String.format("%s/%s", new Object[] { ServerProtocol.getGraphUrlBase(), getGraphPathWithVersion() });
    addCommonParameters();
    localObject = Uri.parse(appendParametersToBaseUrl((String)localObject, Boolean.TRUE));
    localObject = String.format("%s?%s", new Object[] { ((Uri)localObject).getPath(), ((Uri)localObject).getQuery() });
    AppMethodBeat.o(17136);
    return localObject;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  final String getUrlForSingleRequest()
  {
    AppMethodBeat.i(17137);
    if (this.overriddenURL != null)
    {
      str = this.overriddenURL.toString();
      AppMethodBeat.o(17137);
      return str;
    }
    if ((getHttpMethod() == HttpMethod.POST) && (this.graphPath != null) && (this.graphPath.endsWith("/videos"))) {}
    for (String str = ServerProtocol.getGraphVideoUrlBase();; str = ServerProtocol.getGraphUrlBase())
    {
      str = String.format("%s/%s", new Object[] { str, getGraphPathWithVersion() });
      addCommonParameters();
      str = appendParametersToBaseUrl(str, Boolean.FALSE);
      AppMethodBeat.o(17137);
      return str;
    }
  }
  
  public final String getVersion()
  {
    return this.version;
  }
  
  public final void setAccessToken(AccessToken paramAccessToken)
  {
    this.accessToken = paramAccessToken;
  }
  
  public final void setBatchEntryDependsOn(String paramString)
  {
    this.batchEntryDependsOn = paramString;
  }
  
  public final void setBatchEntryName(String paramString)
  {
    this.batchEntryName = paramString;
  }
  
  public final void setBatchEntryOmitResultOnSuccess(boolean paramBoolean)
  {
    this.batchEntryOmitResultOnSuccess = paramBoolean;
  }
  
  public final void setCallback(final Callback paramCallback)
  {
    AppMethodBeat.i(17114);
    if ((FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) || (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)))
    {
      this.callback = new Callback()
      {
        public void onCompleted(GraphResponse paramAnonymousGraphResponse)
        {
          AppMethodBeat.i(17079);
          Object localObject1 = paramAnonymousGraphResponse.getJSONObject();
          JSONArray localJSONArray;
          label34:
          int i;
          label41:
          label71:
          Object localObject2;
          if (localObject1 != null)
          {
            localObject1 = ((JSONObject)localObject1).optJSONObject("__debug__");
            if (localObject1 == null) {
              break label187;
            }
            localJSONArray = ((JSONObject)localObject1).optJSONArray("messages");
            if (localJSONArray == null) {
              break label210;
            }
            i = 0;
            if (i >= localJSONArray.length()) {
              break label210;
            }
            localObject3 = localJSONArray.optJSONObject(i);
            if (localObject3 == null) {
              break label193;
            }
            localObject1 = ((JSONObject)localObject3).optString("message");
            if (localObject3 == null) {
              break label198;
            }
            localObject2 = ((JSONObject)localObject3).optString("type");
            label85:
            if (localObject3 == null) {
              break label204;
            }
          }
          label187:
          label193:
          label198:
          label204:
          for (Object localObject3 = ((JSONObject)localObject3).optString("link");; localObject3 = null)
          {
            if ((localObject1 != null) && (localObject2 != null))
            {
              LoggingBehavior localLoggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
              if (((String)localObject2).equals("warning")) {
                localLoggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
              }
              localObject2 = localObject1;
              if (!Utility.isNullOrEmpty((String)localObject3)) {
                localObject2 = (String)localObject1 + " Link: " + (String)localObject3;
              }
              Logger.log(localLoggingBehavior, GraphRequest.TAG, (String)localObject2);
            }
            i += 1;
            break label41;
            localObject1 = null;
            break;
            localJSONArray = null;
            break label34;
            localObject1 = null;
            break label71;
            localObject2 = null;
            break label85;
          }
          label210:
          if (paramCallback != null) {
            paramCallback.onCompleted(paramAnonymousGraphResponse);
          }
          AppMethodBeat.o(17079);
        }
      };
      AppMethodBeat.o(17114);
      return;
    }
    this.callback = paramCallback;
    AppMethodBeat.o(17114);
  }
  
  public final void setGraphObject(JSONObject paramJSONObject)
  {
    this.graphObject = paramJSONObject;
  }
  
  public final void setGraphPath(String paramString)
  {
    this.graphPath = paramString;
  }
  
  public final void setHttpMethod(HttpMethod paramHttpMethod)
  {
    AppMethodBeat.i(17113);
    if ((this.overriddenURL != null) && (paramHttpMethod != HttpMethod.GET))
    {
      paramHttpMethod = new FacebookException("Can't change HTTP method on request with overridden URL.");
      AppMethodBeat.o(17113);
      throw paramHttpMethod;
    }
    if (paramHttpMethod != null) {}
    for (;;)
    {
      this.httpMethod = paramHttpMethod;
      AppMethodBeat.o(17113);
      return;
      paramHttpMethod = HttpMethod.GET;
    }
  }
  
  public final void setParameters(Bundle paramBundle)
  {
    this.parameters = paramBundle;
  }
  
  public final void setSkipClientToken(boolean paramBoolean)
  {
    this.skipClientToken = paramBoolean;
  }
  
  public final void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public final void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public String toString()
  {
    AppMethodBeat.i(17131);
    StringBuilder localStringBuilder = new StringBuilder("{Request:  accessToken: ");
    if (this.accessToken == null) {}
    for (Object localObject = "null";; localObject = this.accessToken)
    {
      localObject = localObject + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
      AppMethodBeat.o(17131);
      return localObject;
    }
  }
  
  static class Attachment
  {
    private final GraphRequest request;
    private final Object value;
    
    public Attachment(GraphRequest paramGraphRequest, Object paramObject)
    {
      this.request = paramGraphRequest;
      this.value = paramObject;
    }
    
    public GraphRequest getRequest()
    {
      return this.request;
    }
    
    public Object getValue()
    {
      return this.value;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onCompleted(GraphResponse paramGraphResponse);
  }
  
  public static abstract interface GraphJSONArrayCallback
  {
    public abstract void onCompleted(JSONArray paramJSONArray, GraphResponse paramGraphResponse);
  }
  
  public static abstract interface GraphJSONObjectCallback
  {
    public abstract void onCompleted(JSONObject paramJSONObject, GraphResponse paramGraphResponse);
  }
  
  static abstract interface KeyValueSerializer
  {
    public abstract void writeString(String paramString1, String paramString2);
  }
  
  public static abstract interface OnProgressCallback
    extends GraphRequest.Callback
  {
    public abstract void onProgress(long paramLong1, long paramLong2);
  }
  
  public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable>
    implements Parcelable
  {
    public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR;
    private final String mimeType;
    private final RESOURCE resource;
    
    static
    {
      AppMethodBeat.i(17087);
      CREATOR = new Parcelable.Creator()
      {
        public final GraphRequest.ParcelableResourceWithMimeType createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(17082);
          paramAnonymousParcel = new GraphRequest.ParcelableResourceWithMimeType(paramAnonymousParcel, null);
          AppMethodBeat.o(17082);
          return paramAnonymousParcel;
        }
        
        public final GraphRequest.ParcelableResourceWithMimeType[] newArray(int paramAnonymousInt)
        {
          return new GraphRequest.ParcelableResourceWithMimeType[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(17087);
    }
    
    private ParcelableResourceWithMimeType(Parcel paramParcel)
    {
      AppMethodBeat.i(17086);
      this.mimeType = paramParcel.readString();
      this.resource = paramParcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
      AppMethodBeat.o(17086);
    }
    
    public ParcelableResourceWithMimeType(RESOURCE paramRESOURCE, String paramString)
    {
      this.mimeType = paramString;
      this.resource = paramRESOURCE;
    }
    
    public int describeContents()
    {
      return 1;
    }
    
    public String getMimeType()
    {
      return this.mimeType;
    }
    
    public RESOURCE getResource()
    {
      return this.resource;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(17085);
      paramParcel.writeString(this.mimeType);
      paramParcel.writeParcelable(this.resource, paramInt);
      AppMethodBeat.o(17085);
    }
  }
  
  static class Serializer
    implements GraphRequest.KeyValueSerializer
  {
    private boolean firstWrite = true;
    private final Logger logger;
    private final OutputStream outputStream;
    private boolean useUrlEncode = false;
    
    public Serializer(OutputStream paramOutputStream, Logger paramLogger, boolean paramBoolean)
    {
      this.outputStream = paramOutputStream;
      this.logger = paramLogger;
      this.useUrlEncode = paramBoolean;
    }
    
    private RuntimeException getInvalidTypeError()
    {
      AppMethodBeat.i(17089);
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("value is not a supported type.");
      AppMethodBeat.o(17089);
      return localIllegalArgumentException;
    }
    
    public void write(String paramString, Object... paramVarArgs)
    {
      AppMethodBeat.i(17098);
      if (!this.useUrlEncode)
      {
        if (this.firstWrite)
        {
          this.outputStream.write("--".getBytes());
          this.outputStream.write(GraphRequest.MIME_BOUNDARY.getBytes());
          this.outputStream.write("\r\n".getBytes());
          this.firstWrite = false;
        }
        this.outputStream.write(String.format(paramString, paramVarArgs).getBytes());
        AppMethodBeat.o(17098);
        return;
      }
      this.outputStream.write(URLEncoder.encode(String.format(Locale.US, paramString, paramVarArgs), "UTF-8").getBytes());
      AppMethodBeat.o(17098);
    }
    
    public void writeBitmap(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(17092);
      writeContentDisposition(paramString, paramString, "image/png");
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
      writeLine("", new Object[0]);
      writeRecordBoundary();
      if (this.logger != null) {
        this.logger.appendKeyValue("    ".concat(String.valueOf(paramString)), "<Image>");
      }
      AppMethodBeat.o(17092);
    }
    
    public void writeBytes(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(17093);
      writeContentDisposition(paramString, paramString, "content/unknown");
      this.outputStream.write(paramArrayOfByte);
      writeLine("", new Object[0]);
      writeRecordBoundary();
      if (this.logger != null) {
        this.logger.appendKeyValue("    ".concat(String.valueOf(paramString)), String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(paramArrayOfByte.length) }));
      }
      AppMethodBeat.o(17093);
    }
    
    public void writeContentDisposition(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(17097);
      if (!this.useUrlEncode)
      {
        write("Content-Disposition: form-data; name=\"%s\"", new Object[] { paramString1 });
        if (paramString2 != null) {
          write("; filename=\"%s\"", new Object[] { paramString2 });
        }
        writeLine("", new Object[0]);
        if (paramString3 != null) {
          writeLine("%s: %s", new Object[] { "Content-Type", paramString3 });
        }
        writeLine("", new Object[0]);
        AppMethodBeat.o(17097);
        return;
      }
      this.outputStream.write(String.format("%s=", new Object[] { paramString1 }).getBytes());
      AppMethodBeat.o(17097);
    }
    
    public void writeContentUri(String paramString1, Uri paramUri, String paramString2)
    {
      AppMethodBeat.i(17094);
      String str = paramString2;
      if (paramString2 == null) {
        str = "content/unknown";
      }
      writeContentDisposition(paramString1, paramString1, str);
      if ((this.outputStream instanceof ProgressNoopOutputStream))
      {
        long l = Utility.getContentSize(paramUri);
        ((ProgressNoopOutputStream)this.outputStream).addProgress(l);
      }
      for (int i = 0;; i = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(paramUri), this.outputStream) + 0)
      {
        writeLine("", new Object[0]);
        writeRecordBoundary();
        if (this.logger != null) {
          this.logger.appendKeyValue("    ".concat(String.valueOf(paramString1)), String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(i) }));
        }
        AppMethodBeat.o(17094);
        return;
      }
    }
    
    public void writeFile(String paramString1, ParcelFileDescriptor paramParcelFileDescriptor, String paramString2)
    {
      AppMethodBeat.i(17095);
      String str = paramString2;
      if (paramString2 == null) {
        str = "content/unknown";
      }
      writeContentDisposition(paramString1, paramString1, str);
      if ((this.outputStream instanceof ProgressNoopOutputStream)) {
        ((ProgressNoopOutputStream)this.outputStream).addProgress(paramParcelFileDescriptor.getStatSize());
      }
      for (int i = 0;; i = Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor), this.outputStream) + 0)
      {
        writeLine("", new Object[0]);
        writeRecordBoundary();
        if (this.logger != null) {
          this.logger.appendKeyValue("    ".concat(String.valueOf(paramString1)), String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(i) }));
        }
        AppMethodBeat.o(17095);
        return;
      }
    }
    
    public void writeLine(String paramString, Object... paramVarArgs)
    {
      AppMethodBeat.i(17099);
      write(paramString, paramVarArgs);
      if (!this.useUrlEncode) {
        write("\r\n", new Object[0]);
      }
      AppMethodBeat.o(17099);
    }
    
    public void writeObject(String paramString, Object paramObject, GraphRequest paramGraphRequest)
    {
      AppMethodBeat.i(17088);
      if ((this.outputStream instanceof RequestOutputStream)) {
        ((RequestOutputStream)this.outputStream).setCurrentRequest(paramGraphRequest);
      }
      if (GraphRequest.access$000(paramObject))
      {
        writeString(paramString, GraphRequest.access$100(paramObject));
        AppMethodBeat.o(17088);
        return;
      }
      if ((paramObject instanceof Bitmap))
      {
        writeBitmap(paramString, (Bitmap)paramObject);
        AppMethodBeat.o(17088);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        writeBytes(paramString, (byte[])paramObject);
        AppMethodBeat.o(17088);
        return;
      }
      if ((paramObject instanceof Uri))
      {
        writeContentUri(paramString, (Uri)paramObject, null);
        AppMethodBeat.o(17088);
        return;
      }
      if ((paramObject instanceof ParcelFileDescriptor))
      {
        writeFile(paramString, (ParcelFileDescriptor)paramObject, null);
        AppMethodBeat.o(17088);
        return;
      }
      if ((paramObject instanceof GraphRequest.ParcelableResourceWithMimeType))
      {
        paramGraphRequest = (GraphRequest.ParcelableResourceWithMimeType)paramObject;
        paramObject = paramGraphRequest.getResource();
        paramGraphRequest = paramGraphRequest.getMimeType();
        if ((paramObject instanceof ParcelFileDescriptor))
        {
          writeFile(paramString, (ParcelFileDescriptor)paramObject, paramGraphRequest);
          AppMethodBeat.o(17088);
          return;
        }
        if ((paramObject instanceof Uri))
        {
          writeContentUri(paramString, (Uri)paramObject, paramGraphRequest);
          AppMethodBeat.o(17088);
          return;
        }
        paramString = getInvalidTypeError();
        AppMethodBeat.o(17088);
        throw paramString;
      }
      paramString = getInvalidTypeError();
      AppMethodBeat.o(17088);
      throw paramString;
    }
    
    public void writeRecordBoundary()
    {
      AppMethodBeat.i(17096);
      if (!this.useUrlEncode)
      {
        writeLine("--%s", new Object[] { GraphRequest.MIME_BOUNDARY });
        AppMethodBeat.o(17096);
        return;
      }
      this.outputStream.write("&".getBytes());
      AppMethodBeat.o(17096);
    }
    
    public void writeRequestsAsJson(String paramString, JSONArray paramJSONArray, Collection<GraphRequest> paramCollection)
    {
      AppMethodBeat.i(17090);
      if (!(this.outputStream instanceof RequestOutputStream))
      {
        writeString(paramString, paramJSONArray.toString());
        AppMethodBeat.o(17090);
        return;
      }
      RequestOutputStream localRequestOutputStream = (RequestOutputStream)this.outputStream;
      writeContentDisposition(paramString, null, null);
      write("[", new Object[0]);
      paramCollection = paramCollection.iterator();
      int i = 0;
      if (paramCollection.hasNext())
      {
        GraphRequest localGraphRequest = (GraphRequest)paramCollection.next();
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        localRequestOutputStream.setCurrentRequest(localGraphRequest);
        if (i > 0) {
          write(",%s", new Object[] { localJSONObject.toString() });
        }
        for (;;)
        {
          i += 1;
          break;
          write("%s", new Object[] { localJSONObject.toString() });
        }
      }
      write("]", new Object[0]);
      if (this.logger != null) {
        this.logger.appendKeyValue("    ".concat(String.valueOf(paramString)), paramJSONArray.toString());
      }
      AppMethodBeat.o(17090);
    }
    
    public void writeString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(17091);
      writeContentDisposition(paramString1, null, null);
      writeLine("%s", new Object[] { paramString2 });
      writeRecordBoundary();
      if (this.logger != null) {
        this.logger.appendKeyValue("    ".concat(String.valueOf(paramString1)), paramString2);
      }
      AppMethodBeat.o(17091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.GraphRequest
 * JD-Core Version:    0.7.0.1
 */