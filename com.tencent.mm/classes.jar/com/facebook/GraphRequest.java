package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
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
  private GraphRequest.Callback callback;
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
    AppMethodBeat.i(71723);
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
    AppMethodBeat.o(71723);
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
  
  public GraphRequest(AccessToken paramAccessToken, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod, GraphRequest.Callback paramCallback)
  {
    this(paramAccessToken, paramString, paramBundle, paramHttpMethod, paramCallback, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString1, Bundle paramBundle, HttpMethod paramHttpMethod, GraphRequest.Callback paramCallback, String paramString2)
  {
    AppMethodBeat.i(71664);
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
      AppMethodBeat.o(71664);
      return;
    }
  }
  
  GraphRequest(AccessToken paramAccessToken, URL paramURL)
  {
    AppMethodBeat.i(71665);
    this.batchEntryOmitResultOnSuccess = true;
    this.skipClientToken = false;
    this.accessToken = paramAccessToken;
    this.overriddenURL = paramURL.toString();
    setHttpMethod(HttpMethod.GET);
    this.parameters = new Bundle();
    AppMethodBeat.o(71665);
  }
  
  private void addCommonParameters()
  {
    AppMethodBeat.i(71698);
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
      AppMethodBeat.o(71698);
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
    AppMethodBeat.o(71698);
  }
  
  private String appendParametersToBaseUrl(String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(71699);
    if ((!paramBoolean.booleanValue()) && (this.httpMethod == HttpMethod.POST))
    {
      AppMethodBeat.o(71699);
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
        AppMethodBeat.o(71699);
        throw paramString;
      }
    }
    paramString = localBuilder.toString();
    AppMethodBeat.o(71699);
    return paramString;
  }
  
  private static HttpURLConnection createConnection(URL paramURL)
  {
    AppMethodBeat.i(71697);
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setRequestProperty("User-Agent", getUserAgent());
    paramURL.setRequestProperty("Accept-Language", Locale.getDefault().toString());
    paramURL.setChunkedStreamingMode(0);
    AppMethodBeat.o(71697);
    return paramURL;
  }
  
  public static GraphResponse executeAndWait(GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(71684);
    paramGraphRequest = executeBatchAndWait(new GraphRequest[] { paramGraphRequest });
    if ((paramGraphRequest == null) || (paramGraphRequest.size() != 1))
    {
      paramGraphRequest = new FacebookException("invalid state: expected a single response");
      AppMethodBeat.o(71684);
      throw paramGraphRequest;
    }
    paramGraphRequest = (GraphResponse)paramGraphRequest.get(0);
    AppMethodBeat.o(71684);
    return paramGraphRequest;
  }
  
  public static List<GraphResponse> executeBatchAndWait(GraphRequestBatch paramGraphRequestBatch)
  {
    Object localObject2 = null;
    AppMethodBeat.i(71687);
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
      AppMethodBeat.o(71687);
      return localList;
    }
    finally
    {
      Utility.disconnectQuietly(localObject1);
      AppMethodBeat.o(71687);
    }
  }
  
  public static List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> paramCollection)
  {
    AppMethodBeat.i(71686);
    paramCollection = executeBatchAndWait(new GraphRequestBatch(paramCollection));
    AppMethodBeat.o(71686);
    return paramCollection;
  }
  
  public static List<GraphResponse> executeBatchAndWait(GraphRequest... paramVarArgs)
  {
    AppMethodBeat.i(71685);
    Validate.notNull(paramVarArgs, "requests");
    paramVarArgs = executeBatchAndWait(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(71685);
    return paramVarArgs;
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71690);
    Validate.notEmptyAndContainsNoNulls(paramGraphRequestBatch, "requests");
    paramGraphRequestBatch = new GraphRequestAsyncTask(paramGraphRequestBatch);
    paramGraphRequestBatch.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
    AppMethodBeat.o(71690);
    return paramGraphRequestBatch;
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> paramCollection)
  {
    AppMethodBeat.i(71689);
    paramCollection = executeBatchAsync(new GraphRequestBatch(paramCollection));
    AppMethodBeat.o(71689);
    return paramCollection;
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... paramVarArgs)
  {
    AppMethodBeat.i(71688);
    Validate.notNull(paramVarArgs, "requests");
    paramVarArgs = executeBatchAsync(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(71688);
    return paramVarArgs;
  }
  
  public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71692);
    List localList = GraphResponse.fromHttpConnection(paramHttpURLConnection, paramGraphRequestBatch);
    Utility.disconnectQuietly(paramHttpURLConnection);
    int i = paramGraphRequestBatch.size();
    if (i != localList.size())
    {
      paramHttpURLConnection = new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i) }));
      AppMethodBeat.o(71692);
      throw paramHttpURLConnection;
    }
    runCallbacks(paramGraphRequestBatch, localList);
    AccessTokenManager.getInstance().extendAccessTokenIfNeeded();
    AppMethodBeat.o(71692);
    return localList;
  }
  
  public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, Collection<GraphRequest> paramCollection)
  {
    AppMethodBeat.i(71691);
    paramHttpURLConnection = executeConnectionAndWait(paramHttpURLConnection, new GraphRequestBatch(paramCollection));
    AppMethodBeat.o(71691);
    return paramHttpURLConnection;
  }
  
  public static GraphRequestAsyncTask executeConnectionAsync(Handler paramHandler, HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71694);
    Validate.notNull(paramHttpURLConnection, "connection");
    paramHttpURLConnection = new GraphRequestAsyncTask(paramHttpURLConnection, paramGraphRequestBatch);
    paramGraphRequestBatch.setCallbackHandler(paramHandler);
    paramHttpURLConnection.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
    AppMethodBeat.o(71694);
    return paramHttpURLConnection;
  }
  
  public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71693);
    paramHttpURLConnection = executeConnectionAsync(null, paramHttpURLConnection, paramGraphRequestBatch);
    AppMethodBeat.o(71693);
    return paramHttpURLConnection;
  }
  
  private static String getBatchAppId(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71719);
    if (!Utility.isNullOrEmpty(paramGraphRequestBatch.getBatchApplicationId()))
    {
      paramGraphRequestBatch = paramGraphRequestBatch.getBatchApplicationId();
      AppMethodBeat.o(71719);
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
          AppMethodBeat.o(71719);
          return localObject;
        }
      }
    }
    if (!Utility.isNullOrEmpty(defaultBatchApplicationId))
    {
      paramGraphRequestBatch = defaultBatchApplicationId;
      AppMethodBeat.o(71719);
      return paramGraphRequestBatch;
    }
    paramGraphRequestBatch = FacebookSdk.getApplicationId();
    AppMethodBeat.o(71719);
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
    AppMethodBeat.i(71702);
    if (versionPattern.matcher(this.graphPath).matches())
    {
      str = this.graphPath;
      AppMethodBeat.o(71702);
      return str;
    }
    String str = String.format("%s/%s", new Object[] { this.version, this.graphPath });
    AppMethodBeat.o(71702);
    return str;
  }
  
  private static String getMimeContentType()
  {
    AppMethodBeat.i(71717);
    String str = String.format("multipart/form-data; boundary=%s", new Object[] { MIME_BOUNDARY });
    AppMethodBeat.o(71717);
    return str;
  }
  
  private static String getUserAgent()
  {
    AppMethodBeat.i(71718);
    if (userAgent == null)
    {
      userAgent = String.format("%s.%s", new Object[] { "FBAndroidSDK", "4.38.1" });
      str = InternalSettings.getCustomUserAgent();
      if (!Utility.isNullOrEmpty(str)) {
        userAgent = String.format(Locale.ROOT, "%s/%s", new Object[] { userAgent, str });
      }
    }
    String str = userAgent;
    AppMethodBeat.o(71718);
    return str;
  }
  
  private static boolean hasOnProgressCallbacks(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71704);
    Iterator localIterator = paramGraphRequestBatch.getCallbacks().iterator();
    while (localIterator.hasNext()) {
      if (((GraphRequestBatch.Callback)localIterator.next() instanceof GraphRequestBatch.OnProgressCallback))
      {
        AppMethodBeat.o(71704);
        return true;
      }
    }
    paramGraphRequestBatch = paramGraphRequestBatch.iterator();
    while (paramGraphRequestBatch.hasNext()) {
      if ((((GraphRequest)paramGraphRequestBatch.next()).getCallback() instanceof GraphRequest.OnProgressCallback))
      {
        AppMethodBeat.o(71704);
        return true;
      }
    }
    AppMethodBeat.o(71704);
    return false;
  }
  
  private static boolean isGzipCompressible(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71706);
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
    AppMethodBeat.o(71706);
    return false;
    AppMethodBeat.o(71706);
    return true;
  }
  
  private static boolean isMeRequest(String paramString)
  {
    AppMethodBeat.i(71711);
    Matcher localMatcher = versionPattern.matcher(paramString);
    if (localMatcher.matches()) {
      paramString = localMatcher.group(1);
    }
    if ((paramString.startsWith("me/")) || (paramString.startsWith("/me/")))
    {
      AppMethodBeat.o(71711);
      return true;
    }
    AppMethodBeat.o(71711);
    return false;
  }
  
  private static boolean isSupportedAttachmentType(Object paramObject)
  {
    return ((paramObject instanceof Bitmap)) || ((paramObject instanceof byte[])) || ((paramObject instanceof Uri)) || ((paramObject instanceof ParcelFileDescriptor)) || ((paramObject instanceof GraphRequest.ParcelableResourceWithMimeType));
  }
  
  private static boolean isSupportedParameterType(Object paramObject)
  {
    return ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Number)) || ((paramObject instanceof Date));
  }
  
  public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken paramAccessToken, Context paramContext, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71676);
    paramAccessToken = newCustomAudienceThirdPartyIdRequest(paramAccessToken, paramContext, null, paramCallback);
    AppMethodBeat.o(71676);
    return paramAccessToken;
  }
  
  public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken paramAccessToken, Context paramContext, String paramString, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71675);
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
        AppMethodBeat.o(71675);
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
          AppMethodBeat.o(71675);
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
        AppMethodBeat.o(71675);
        return paramAccessToken;
      }
    }
  }
  
  public static GraphRequest newDeleteObjectRequest(AccessToken paramAccessToken, String paramString, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71666);
    paramAccessToken = new GraphRequest(paramAccessToken, paramString, null, HttpMethod.DELETE, paramCallback);
    AppMethodBeat.o(71666);
    return paramAccessToken;
  }
  
  public static GraphRequest newGraphPathRequest(AccessToken paramAccessToken, String paramString, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71670);
    paramAccessToken = new GraphRequest(paramAccessToken, paramString, null, null, paramCallback);
    AppMethodBeat.o(71670);
    return paramAccessToken;
  }
  
  public static GraphRequest newMeRequest(AccessToken paramAccessToken, GraphRequest.GraphJSONObjectCallback paramGraphJSONObjectCallback)
  {
    AppMethodBeat.i(71667);
    paramAccessToken = new GraphRequest(paramAccessToken, "me", null, null, new GraphRequest.Callback()
    {
      public final void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(71640);
        if (this.val$callback != null) {
          this.val$callback.onCompleted(paramAnonymousGraphResponse.getJSONObject(), paramAnonymousGraphResponse);
        }
        AppMethodBeat.o(71640);
      }
    });
    AppMethodBeat.o(71667);
    return paramAccessToken;
  }
  
  public static GraphRequest newMyFriendsRequest(AccessToken paramAccessToken, GraphRequest.GraphJSONArrayCallback paramGraphJSONArrayCallback)
  {
    AppMethodBeat.i(71669);
    paramAccessToken = new GraphRequest(paramAccessToken, "me/friends", null, null, new GraphRequest.Callback()
    {
      public final void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(71641);
        if (this.val$callback != null)
        {
          localObject = paramAnonymousGraphResponse.getJSONObject();
          if (localObject == null) {
            break label45;
          }
        }
        label45:
        for (Object localObject = ((JSONObject)localObject).optJSONArray("data");; localObject = null)
        {
          this.val$callback.onCompleted((JSONArray)localObject, paramAnonymousGraphResponse);
          AppMethodBeat.o(71641);
          return;
        }
      }
    });
    AppMethodBeat.o(71669);
    return paramAccessToken;
  }
  
  public static GraphRequest newPlacesSearchRequest(AccessToken paramAccessToken, Location paramLocation, int paramInt1, int paramInt2, String paramString, GraphRequest.GraphJSONArrayCallback paramGraphJSONArrayCallback)
  {
    AppMethodBeat.i(71671);
    if ((paramLocation == null) && (Utility.isNullOrEmpty(paramString)))
    {
      paramAccessToken = new FacebookException("Either location or searchText must be specified.");
      AppMethodBeat.o(71671);
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
    paramLocation = new GraphRequest.Callback()
    {
      public final void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(71642);
        if (this.val$callback != null)
        {
          localObject = paramAnonymousGraphResponse.getJSONObject();
          if (localObject == null) {
            break label45;
          }
        }
        label45:
        for (Object localObject = ((JSONObject)localObject).optJSONArray("data");; localObject = null)
        {
          this.val$callback.onCompleted((JSONArray)localObject, paramAnonymousGraphResponse);
          AppMethodBeat.o(71642);
          return;
        }
      }
    };
    paramAccessToken = new GraphRequest(paramAccessToken, "search", localBundle, HttpMethod.GET, paramLocation);
    AppMethodBeat.o(71671);
    return paramAccessToken;
  }
  
  public static GraphRequest newPostRequest(AccessToken paramAccessToken, String paramString, JSONObject paramJSONObject, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71668);
    paramAccessToken = new GraphRequest(paramAccessToken, paramString, null, HttpMethod.POST, paramCallback);
    paramAccessToken.setGraphObject(paramJSONObject);
    AppMethodBeat.o(71668);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, Bitmap paramBitmap, String paramString2, Bundle paramBundle, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71672);
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
    AppMethodBeat.o(71672);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, Uri paramUri, String paramString2, Bundle paramBundle, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71674);
    paramString1 = getDefaultPhotoPathIfNull(paramString1);
    if (Utility.isFileUri(paramUri))
    {
      paramAccessToken = newUploadPhotoRequest(paramAccessToken, paramString1, new File(paramUri.getPath()), paramString2, paramBundle, paramCallback);
      AppMethodBeat.o(71674);
      return paramAccessToken;
    }
    if (!Utility.isContentUri(paramUri))
    {
      paramAccessToken = new FacebookException("The photo Uri must be either a file:// or content:// Uri");
      AppMethodBeat.o(71674);
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
    AppMethodBeat.o(71674);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, File paramFile, String paramString2, Bundle paramBundle, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71673);
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
    AppMethodBeat.o(71673);
    return paramAccessToken;
  }
  
  private static String parameterToString(Object paramObject)
  {
    AppMethodBeat.i(71720);
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      AppMethodBeat.o(71720);
      return paramObject;
    }
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof Number)))
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(71720);
      return paramObject;
    }
    if ((paramObject instanceof Date))
    {
      paramObject = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(paramObject);
      AppMethodBeat.o(71720);
      return paramObject;
    }
    paramObject = new IllegalArgumentException("Unsupported parameter type.");
    AppMethodBeat.o(71720);
    throw paramObject;
  }
  
  private static void processGraphObject(JSONObject paramJSONObject, String paramString, GraphRequest.KeyValueSerializer paramKeyValueSerializer)
  {
    AppMethodBeat.i(71712);
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
      AppMethodBeat.o(71712);
      return;
      i = 0;
    }
  }
  
  private static void processGraphObjectProperty(String paramString, Object paramObject, GraphRequest.KeyValueSerializer paramKeyValueSerializer, boolean paramBoolean)
  {
    AppMethodBeat.i(71713);
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
        AppMethodBeat.o(71713);
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
    AppMethodBeat.o(71713);
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
      AppMethodBeat.o(71713);
      return;
    }
    if ((String.class.isAssignableFrom((Class)localObject)) || (Number.class.isAssignableFrom((Class)localObject)) || (Boolean.class.isAssignableFrom((Class)localObject)))
    {
      paramKeyValueSerializer.writeString(paramString, paramObject.toString());
      AppMethodBeat.o(71713);
      return;
    }
    if (Date.class.isAssignableFrom((Class)localObject))
    {
      paramObject = (Date)paramObject;
      paramKeyValueSerializer.writeString(paramString, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(paramObject));
    }
    AppMethodBeat.o(71713);
  }
  
  private static void processRequest(GraphRequestBatch paramGraphRequestBatch, Logger paramLogger, int paramInt, URL paramURL, OutputStream paramOutputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(71710);
    paramOutputStream = new GraphRequest.Serializer(paramOutputStream, paramLogger, paramBoolean);
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
          localHashMap.put(str, new GraphRequest.Attachment(paramGraphRequestBatch, localObject));
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
      AppMethodBeat.o(71710);
      return;
    }
    paramURL = getBatchAppId(paramGraphRequestBatch);
    if (Utility.isNullOrEmpty(paramURL))
    {
      paramGraphRequestBatch = new FacebookException("App ID was not specified at the request or Settings.");
      AppMethodBeat.o(71710);
      throw paramGraphRequestBatch;
    }
    paramOutputStream.writeString("batch_app_id", paramURL);
    paramURL = new HashMap();
    serializeRequestsAsJSON(paramOutputStream, paramGraphRequestBatch, paramURL);
    if (paramLogger != null) {
      paramLogger.append("  Attachments:\n");
    }
    serializeAttachments(paramURL, paramOutputStream);
    AppMethodBeat.o(71710);
  }
  
  static void runCallbacks(final GraphRequestBatch paramGraphRequestBatch, List<GraphResponse> paramList)
  {
    AppMethodBeat.i(71696);
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
          AppMethodBeat.i(71644);
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
          AppMethodBeat.o(71644);
        }
      };
      paramGraphRequestBatch = paramGraphRequestBatch.getCallbackHandler();
      if (paramGraphRequestBatch == null)
      {
        paramList.run();
        AppMethodBeat.o(71696);
        return;
      }
      paramGraphRequestBatch.post(paramList);
    }
    AppMethodBeat.o(71696);
  }
  
  private static void serializeAttachments(Map<String, GraphRequest.Attachment> paramMap, GraphRequest.Serializer paramSerializer)
  {
    AppMethodBeat.i(71715);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      GraphRequest.Attachment localAttachment = (GraphRequest.Attachment)paramMap.get(str);
      if (isSupportedAttachmentType(localAttachment.getValue())) {
        paramSerializer.writeObject(str, localAttachment.getValue(), localAttachment.getRequest());
      }
    }
    AppMethodBeat.o(71715);
  }
  
  private static void serializeParameters(Bundle paramBundle, GraphRequest.Serializer paramSerializer, GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(71714);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (isSupportedParameterType(localObject)) {
        paramSerializer.writeObject(str, localObject, paramGraphRequest);
      }
    }
    AppMethodBeat.o(71714);
  }
  
  private static void serializeRequestsAsJSON(GraphRequest.Serializer paramSerializer, Collection<GraphRequest> paramCollection, Map<String, GraphRequest.Attachment> paramMap)
  {
    AppMethodBeat.i(71716);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      ((GraphRequest)localIterator.next()).serializeToBatch(localJSONArray, paramMap);
    }
    paramSerializer.writeRequestsAsJson("batch", localJSONArray, paramCollection);
    AppMethodBeat.o(71716);
  }
  
  private void serializeToBatch(JSONArray paramJSONArray, Map<String, GraphRequest.Attachment> paramMap)
  {
    AppMethodBeat.i(71703);
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
        paramMap.put(str2, new GraphRequest.Attachment(this, localObject));
      }
    }
    if (!localArrayList.isEmpty()) {
      localJSONObject.put("attached_files", TextUtils.join(",", localArrayList));
    }
    if (this.graphObject != null)
    {
      paramMap = new ArrayList();
      processGraphObject(this.graphObject, str1, new GraphRequest.6(this, paramMap));
      localJSONObject.put("body", TextUtils.join("&", paramMap));
    }
    paramJSONArray.put(localJSONObject);
    AppMethodBeat.o(71703);
  }
  
  /* Error */
  static final void serializeToUrlConnection(GraphRequestBatch paramGraphRequestBatch, HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc_w 1077
    //   3: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 311	com/facebook/internal/Logger
    //   9: dup
    //   10: getstatic 1080	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   13: ldc_w 1082
    //   16: invokespecial 1085	com/facebook/internal/Logger:<init>	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V
    //   19: astore 7
    //   21: aload_0
    //   22: invokevirtual 572	com/facebook/GraphRequestBatch:size	()I
    //   25: istore_3
    //   26: aload_0
    //   27: invokestatic 1087	com/facebook/GraphRequest:isGzipCompressible	(Lcom/facebook/GraphRequestBatch;)Z
    //   30: istore 4
    //   32: iload_3
    //   33: iconst_1
    //   34: if_icmpne +144 -> 178
    //   37: aload_0
    //   38: iconst_0
    //   39: invokevirtual 930	com/facebook/GraphRequestBatch:get	(I)Lcom/facebook/GraphRequest;
    //   42: getfield 364	com/facebook/GraphRequest:httpMethod	Lcom/facebook/HttpMethod;
    //   45: astore 5
    //   47: aload_1
    //   48: aload 5
    //   50: invokevirtual 1089	com/facebook/HttpMethod:name	()Ljava/lang/String;
    //   53: invokevirtual 1092	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   56: aload_1
    //   57: iload 4
    //   59: invokestatic 1096	com/facebook/GraphRequest:setConnectionContentType	(Ljava/net/HttpURLConnection;Z)V
    //   62: aload_1
    //   63: invokevirtual 1100	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   66: astore 8
    //   68: aload 7
    //   70: ldc_w 1102
    //   73: invokevirtual 946	com/facebook/internal/Logger:append	(Ljava/lang/String;)V
    //   76: aload 7
    //   78: ldc_w 1104
    //   81: aload_0
    //   82: invokevirtual 1107	com/facebook/GraphRequestBatch:getId	()Ljava/lang/String;
    //   85: invokevirtual 1111	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: aload 7
    //   90: ldc_w 1113
    //   93: aload 8
    //   95: invokevirtual 1111	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   98: aload 7
    //   100: ldc_w 1115
    //   103: aload_1
    //   104: invokevirtual 1118	java/net/HttpURLConnection:getRequestMethod	()Ljava/lang/String;
    //   107: invokevirtual 1111	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   110: aload 7
    //   112: ldc 145
    //   114: aload_1
    //   115: ldc 145
    //   117: invokevirtual 1121	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokevirtual 1111	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   123: aload 7
    //   125: ldc 74
    //   127: aload_1
    //   128: ldc 74
    //   130: invokevirtual 1121	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokevirtual 1111	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   136: aload_1
    //   137: aload_0
    //   138: invokevirtual 1124	com/facebook/GraphRequestBatch:getTimeout	()I
    //   141: invokevirtual 1127	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   144: aload_1
    //   145: aload_0
    //   146: invokevirtual 1124	com/facebook/GraphRequestBatch:getTimeout	()I
    //   149: invokevirtual 1130	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   152: aload 5
    //   154: getstatic 367	com/facebook/HttpMethod:POST	Lcom/facebook/HttpMethod;
    //   157: if_acmpne +29 -> 186
    //   160: iconst_1
    //   161: istore_2
    //   162: iload_2
    //   163: ifne +28 -> 191
    //   166: aload 7
    //   168: invokevirtual 1133	com/facebook/internal/Logger:log	()V
    //   171: ldc_w 1077
    //   174: invokestatic 231	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: return
    //   178: getstatic 367	com/facebook/HttpMethod:POST	Lcom/facebook/HttpMethod;
    //   181: astore 5
    //   183: goto -136 -> 47
    //   186: iconst_0
    //   187: istore_2
    //   188: goto -26 -> 162
    //   191: aload_1
    //   192: iconst_1
    //   193: invokevirtual 1137	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   196: new 1139	java/io/BufferedOutputStream
    //   199: dup
    //   200: aload_1
    //   201: invokevirtual 1143	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   204: invokespecial 1146	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   207: astore 6
    //   209: aload 6
    //   211: astore_1
    //   212: iload 4
    //   214: ifeq +17 -> 231
    //   217: aload 6
    //   219: astore 5
    //   221: new 1148	java/util/zip/GZIPOutputStream
    //   224: dup
    //   225: aload 6
    //   227: invokespecial 1149	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   230: astore_1
    //   231: aload_1
    //   232: astore 5
    //   234: aload_0
    //   235: invokestatic 1151	com/facebook/GraphRequest:hasOnProgressCallbacks	(Lcom/facebook/GraphRequestBatch;)Z
    //   238: ifeq +124 -> 362
    //   241: aload_1
    //   242: astore 5
    //   244: new 1153	com/facebook/ProgressNoopOutputStream
    //   247: dup
    //   248: aload_0
    //   249: invokevirtual 992	com/facebook/GraphRequestBatch:getCallbackHandler	()Landroid/os/Handler;
    //   252: invokespecial 1155	com/facebook/ProgressNoopOutputStream:<init>	(Landroid/os/Handler;)V
    //   255: astore 6
    //   257: aload_1
    //   258: astore 5
    //   260: aload_0
    //   261: aconst_null
    //   262: iload_3
    //   263: aload 8
    //   265: aload 6
    //   267: iload 4
    //   269: invokestatic 1157	com/facebook/GraphRequest:processRequest	(Lcom/facebook/GraphRequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;Z)V
    //   272: aload_1
    //   273: astore 5
    //   275: aload 6
    //   277: invokevirtual 1160	com/facebook/ProgressNoopOutputStream:getMaxProgress	()I
    //   280: istore_2
    //   281: aload_1
    //   282: astore 5
    //   284: new 1162	com/facebook/ProgressOutputStream
    //   287: dup
    //   288: aload_1
    //   289: aload_0
    //   290: aload 6
    //   292: invokevirtual 1166	com/facebook/ProgressNoopOutputStream:getProgressMap	()Ljava/util/Map;
    //   295: iload_2
    //   296: i2l
    //   297: invokespecial 1169	com/facebook/ProgressOutputStream:<init>	(Ljava/io/OutputStream;Lcom/facebook/GraphRequestBatch;Ljava/util/Map;J)V
    //   300: astore_1
    //   301: aload_0
    //   302: aload 7
    //   304: iload_3
    //   305: aload 8
    //   307: aload_1
    //   308: iload 4
    //   310: invokestatic 1157	com/facebook/GraphRequest:processRequest	(Lcom/facebook/GraphRequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;Z)V
    //   313: aload_1
    //   314: invokevirtual 1174	java/io/OutputStream:close	()V
    //   317: aload 7
    //   319: invokevirtual 1133	com/facebook/internal/Logger:log	()V
    //   322: ldc_w 1077
    //   325: invokestatic 231	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: return
    //   329: astore_0
    //   330: aconst_null
    //   331: astore 5
    //   333: aload 5
    //   335: ifnull +8 -> 343
    //   338: aload 5
    //   340: invokevirtual 1174	java/io/OutputStream:close	()V
    //   343: ldc_w 1077
    //   346: invokestatic 231	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(71705);
    if (paramBoolean)
    {
      paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      paramHttpURLConnection.setRequestProperty("Content-Encoding", "gzip");
      AppMethodBeat.o(71705);
      return;
    }
    paramHttpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
    AppMethodBeat.o(71705);
  }
  
  public static final void setDefaultBatchApplicationId(String paramString)
  {
    defaultBatchApplicationId = paramString;
  }
  
  static final boolean shouldWarnOnMissingFieldsParam(GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(71707);
    String str = paramGraphRequest.getVersion();
    if (Utility.isNullOrEmpty(str))
    {
      AppMethodBeat.o(71707);
      return true;
    }
    paramGraphRequest = str;
    if (str.startsWith("v")) {
      paramGraphRequest = str.substring(1);
    }
    paramGraphRequest = paramGraphRequest.split("\\.");
    if (((paramGraphRequest.length >= 2) && (Integer.parseInt(paramGraphRequest[0]) > 2)) || ((Integer.parseInt(paramGraphRequest[0]) >= 2) && (Integer.parseInt(paramGraphRequest[1]) >= 4)))
    {
      AppMethodBeat.o(71707);
      return true;
    }
    AppMethodBeat.o(71707);
    return false;
  }
  
  public static HttpURLConnection toHttpConnection(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71683);
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
        AppMethodBeat.o(71683);
        throw paramGraphRequestBatch;
      }
      try
      {
        localObject3 = createConnection((URL)localObject3);
        localObject1 = localObject3;
        localObject2 = localObject3;
        serializeToUrlConnection(paramGraphRequestBatch, (HttpURLConnection)localObject3);
        AppMethodBeat.o(71683);
        return localObject3;
      }
      catch (JSONException paramGraphRequestBatch)
      {
        Utility.disconnectQuietly(localObject1);
        paramGraphRequestBatch = new FacebookException("could not construct request body", paramGraphRequestBatch);
        AppMethodBeat.o(71683);
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
    AppMethodBeat.i(71682);
    Validate.notEmptyAndContainsNoNulls(paramCollection, "requests");
    paramCollection = toHttpConnection(new GraphRequestBatch(paramCollection));
    AppMethodBeat.o(71682);
    return paramCollection;
  }
  
  public static HttpURLConnection toHttpConnection(GraphRequest... paramVarArgs)
  {
    AppMethodBeat.i(71681);
    paramVarArgs = toHttpConnection(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(71681);
    return paramVarArgs;
  }
  
  static final void validateFieldsParamForGetRequests(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71708);
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
    AppMethodBeat.o(71708);
  }
  
  public final GraphResponse executeAndWait()
  {
    AppMethodBeat.i(71679);
    GraphResponse localGraphResponse = executeAndWait(this);
    AppMethodBeat.o(71679);
    return localGraphResponse;
  }
  
  public final GraphRequestAsyncTask executeAsync()
  {
    AppMethodBeat.i(71680);
    GraphRequestAsyncTask localGraphRequestAsyncTask = executeBatchAsync(new GraphRequest[] { this });
    AppMethodBeat.o(71680);
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
  
  public final GraphRequest.Callback getCallback()
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
    AppMethodBeat.i(71700);
    if (this.overriddenURL != null)
    {
      localObject = new FacebookException("Can't override URL for a batch request");
      AppMethodBeat.o(71700);
      throw ((Throwable)localObject);
    }
    Object localObject = String.format("%s/%s", new Object[] { ServerProtocol.getGraphUrlBase(), getGraphPathWithVersion() });
    addCommonParameters();
    localObject = Uri.parse(appendParametersToBaseUrl((String)localObject, Boolean.TRUE));
    localObject = String.format("%s?%s", new Object[] { ((Uri)localObject).getPath(), ((Uri)localObject).getQuery() });
    AppMethodBeat.o(71700);
    return localObject;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  final String getUrlForSingleRequest()
  {
    AppMethodBeat.i(71701);
    if (this.overriddenURL != null)
    {
      str = this.overriddenURL.toString();
      AppMethodBeat.o(71701);
      return str;
    }
    if ((getHttpMethod() == HttpMethod.POST) && (this.graphPath != null) && (this.graphPath.endsWith("/videos"))) {}
    for (String str = ServerProtocol.getGraphVideoUrlBase();; str = ServerProtocol.getGraphUrlBase())
    {
      str = String.format("%s/%s", new Object[] { str, getGraphPathWithVersion() });
      addCommonParameters();
      str = appendParametersToBaseUrl(str, Boolean.FALSE);
      AppMethodBeat.o(71701);
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
  
  public final void setCallback(GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(71678);
    if ((FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) || (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)))
    {
      this.callback = new GraphRequest.4(this, paramCallback);
      AppMethodBeat.o(71678);
      return;
    }
    this.callback = paramCallback;
    AppMethodBeat.o(71678);
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
    AppMethodBeat.i(71677);
    if ((this.overriddenURL != null) && (paramHttpMethod != HttpMethod.GET))
    {
      paramHttpMethod = new FacebookException("Can't change HTTP method on request with overridden URL.");
      AppMethodBeat.o(71677);
      throw paramHttpMethod;
    }
    if (paramHttpMethod != null) {}
    for (;;)
    {
      this.httpMethod = paramHttpMethod;
      AppMethodBeat.o(71677);
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
    AppMethodBeat.i(71695);
    StringBuilder localStringBuilder = new StringBuilder("{Request:  accessToken: ");
    if (this.accessToken == null) {}
    for (Object localObject = "null";; localObject = this.accessToken)
    {
      localObject = localObject + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
      AppMethodBeat.o(71695);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.GraphRequest
 * JD-Core Version:    0.7.0.1
 */