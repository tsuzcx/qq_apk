package com.facebook;

import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GraphResponse
{
  private static final String BODY_KEY = "body";
  private static final String CODE_KEY = "code";
  public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
  private static final String RESPONSE_LOG_TAG = "Response";
  public static final String SUCCESS_KEY = "success";
  private static final String TAG;
  private final HttpURLConnection connection;
  private final FacebookRequestError error;
  private final JSONObject graphObject;
  private final JSONArray graphObjectArray;
  private final String rawResponse;
  private final GraphRequest request;
  
  static
  {
    AppMethodBeat.i(17206);
    TAG = GraphResponse.class.getSimpleName();
    AppMethodBeat.o(17206);
  }
  
  GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, FacebookRequestError paramFacebookRequestError)
  {
    this(paramGraphRequest, paramHttpURLConnection, null, null, null, paramFacebookRequestError);
  }
  
  GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, String paramString, JSONArray paramJSONArray)
  {
    this(paramGraphRequest, paramHttpURLConnection, paramString, null, paramJSONArray, null);
  }
  
  GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, String paramString, JSONObject paramJSONObject)
  {
    this(paramGraphRequest, paramHttpURLConnection, paramString, paramJSONObject, null, null);
  }
  
  GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, String paramString, JSONObject paramJSONObject, JSONArray paramJSONArray, FacebookRequestError paramFacebookRequestError)
  {
    this.request = paramGraphRequest;
    this.connection = paramHttpURLConnection;
    this.rawResponse = paramString;
    this.graphObject = paramJSONObject;
    this.graphObjectArray = paramJSONArray;
    this.error = paramFacebookRequestError;
  }
  
  static List<GraphResponse> constructErrorResponses(List<GraphRequest> paramList, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(17205);
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new GraphResponse((GraphRequest)paramList.get(i), paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, paramFacebookException)));
      i += 1;
    }
    AppMethodBeat.o(17205);
    return localArrayList;
  }
  
  private static GraphResponse createResponseFromObject(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(17204);
    Object localObject = paramObject1;
    if ((paramObject1 instanceof JSONObject))
    {
      paramObject1 = (JSONObject)paramObject1;
      paramObject2 = FacebookRequestError.checkResponseAndCreateError(paramObject1, paramObject2, paramHttpURLConnection);
      if (paramObject2 != null)
      {
        if ((paramObject2.getErrorCode() == 190) && (Utility.isCurrentAccessToken(paramGraphRequest.getAccessToken())))
        {
          if (paramObject2.getSubErrorCode() == 493) {
            break label85;
          }
          AccessToken.setCurrentAccessToken(null);
        }
        for (;;)
        {
          paramGraphRequest = new GraphResponse(paramGraphRequest, paramHttpURLConnection, paramObject2);
          AppMethodBeat.o(17204);
          return paramGraphRequest;
          label85:
          if (!AccessToken.getCurrentAccessToken().isExpired()) {
            AccessToken.expireCurrentAccessToken();
          }
        }
      }
      paramObject1 = Utility.getStringPropertyAsJSON(paramObject1, "body", "FACEBOOK_NON_JSON_RESULT");
      if ((paramObject1 instanceof JSONObject))
      {
        paramGraphRequest = new GraphResponse(paramGraphRequest, paramHttpURLConnection, paramObject1.toString(), (JSONObject)paramObject1);
        AppMethodBeat.o(17204);
        return paramGraphRequest;
      }
      if ((paramObject1 instanceof JSONArray))
      {
        paramGraphRequest = new GraphResponse(paramGraphRequest, paramHttpURLConnection, paramObject1.toString(), (JSONArray)paramObject1);
        AppMethodBeat.o(17204);
        return paramGraphRequest;
      }
      localObject = JSONObject.NULL;
    }
    if (localObject == JSONObject.NULL)
    {
      paramGraphRequest = new GraphResponse(paramGraphRequest, paramHttpURLConnection, localObject.toString(), null);
      AppMethodBeat.o(17204);
      return paramGraphRequest;
    }
    paramGraphRequest = new FacebookException("Got unexpected object type in response, class: " + localObject.getClass().getSimpleName());
    AppMethodBeat.o(17204);
    throw paramGraphRequest;
  }
  
  private static List<GraphResponse> createResponsesFromObject(HttpURLConnection paramHttpURLConnection, List<GraphRequest> paramList, Object paramObject)
  {
    int j = 0;
    AppMethodBeat.i(17203);
    int k = paramList.size();
    ArrayList localArrayList = new ArrayList(k);
    GraphRequest localGraphRequest;
    if (k == 1) {
      localGraphRequest = (GraphRequest)paramList.get(0);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("body", paramObject);
        if (paramHttpURLConnection == null) {
          continue;
        }
        i = paramHttpURLConnection.getResponseCode();
        localJSONObject.put("code", i);
        localJSONArray = new JSONArray();
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException1)
      {
        JSONArray localJSONArray;
        localArrayList.add(new GraphResponse(localGraphRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException1)));
        Object localObject1 = paramObject;
        continue;
      }
      catch (IOException localIOException)
      {
        localArrayList.add(new GraphResponse(localGraphRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localIOException)));
      }
      if (((localJSONArray instanceof JSONArray)) && (((JSONArray)localJSONArray).length() == k)) {
        break;
      }
      paramHttpURLConnection = new FacebookException("Unexpected number of results");
      AppMethodBeat.o(17203);
      throw paramHttpURLConnection;
      i = 200;
      continue;
      localObject2 = paramObject;
    }
    Object localObject2 = (JSONArray)localObject2;
    int i = j;
    for (;;)
    {
      if (i < ((JSONArray)localObject2).length())
      {
        localGraphRequest = (GraphRequest)paramList.get(i);
        try
        {
          localArrayList.add(createResponseFromObject(localGraphRequest, paramHttpURLConnection, ((JSONArray)localObject2).get(i), paramObject));
          i += 1;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localArrayList.add(new GraphResponse(localGraphRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException2)));
          }
        }
        catch (FacebookException localFacebookException)
        {
          for (;;)
          {
            localArrayList.add(new GraphResponse(localGraphRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localFacebookException)));
          }
        }
      }
    }
    AppMethodBeat.o(17203);
    return localArrayList;
  }
  
  static List<GraphResponse> createResponsesFromStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17201);
    paramInputStream = Utility.readStreamToString(paramInputStream);
    Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[] { Integer.valueOf(paramInputStream.length()), paramInputStream });
    paramInputStream = createResponsesFromString(paramInputStream, paramHttpURLConnection, paramGraphRequestBatch);
    AppMethodBeat.o(17201);
    return paramInputStream;
  }
  
  static List<GraphResponse> createResponsesFromString(String paramString, HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(17202);
    paramHttpURLConnection = createResponsesFromObject(paramHttpURLConnection, paramGraphRequestBatch, new JSONTokener(paramString).nextValue());
    Logger.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[] { paramGraphRequestBatch.getId(), Integer.valueOf(paramString.length()), paramHttpURLConnection });
    AppMethodBeat.o(17202);
    return paramHttpURLConnection;
  }
  
  /* Error */
  static List<GraphResponse> fromHttpConnection(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    // Byte code:
    //   0: sipush 17200
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore_2
    //   14: aload_2
    //   15: astore 4
    //   17: aload 6
    //   19: astore 5
    //   21: aload 7
    //   23: astore_3
    //   24: aload_0
    //   25: invokevirtual 198	java/net/HttpURLConnection:getResponseCode	()I
    //   28: sipush 400
    //   31: if_icmplt +47 -> 78
    //   34: aload_2
    //   35: astore 4
    //   37: aload 6
    //   39: astore 5
    //   41: aload 7
    //   43: astore_3
    //   44: aload_0
    //   45: invokevirtual 276	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   48: astore_2
    //   49: aload_2
    //   50: astore 4
    //   52: aload_2
    //   53: astore 5
    //   55: aload_2
    //   56: astore_3
    //   57: aload_2
    //   58: aload_0
    //   59: aload_1
    //   60: invokestatic 278	com/facebook/GraphResponse:createResponsesFromStream	(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)Ljava/util/List;
    //   63: astore 6
    //   65: aload_2
    //   66: invokestatic 282	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   69: sipush 17200
    //   72: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload 6
    //   77: areturn
    //   78: aload_2
    //   79: astore 4
    //   81: aload 6
    //   83: astore 5
    //   85: aload 7
    //   87: astore_3
    //   88: aload_0
    //   89: invokevirtual 285	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   92: astore_2
    //   93: goto -44 -> 49
    //   96: astore_2
    //   97: aload 4
    //   99: astore_3
    //   100: getstatic 260	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   103: ldc 19
    //   105: ldc_w 287
    //   108: iconst_1
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload_2
    //   115: aastore
    //   116: invokestatic 243	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload 4
    //   121: astore_3
    //   122: aload_1
    //   123: aload_0
    //   124: aload_2
    //   125: invokestatic 289	com/facebook/GraphResponse:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   128: astore_0
    //   129: aload 4
    //   131: invokestatic 282	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   134: sipush 17200
    //   137: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_0
    //   141: areturn
    //   142: astore_2
    //   143: aload 5
    //   145: astore_3
    //   146: getstatic 260	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   149: ldc 19
    //   151: ldc_w 287
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_2
    //   161: aastore
    //   162: invokestatic 243	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload 5
    //   167: astore_3
    //   168: aload_1
    //   169: aload_0
    //   170: new 165	com/facebook/FacebookException
    //   173: dup
    //   174: aload_2
    //   175: invokespecial 292	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
    //   178: invokestatic 289	com/facebook/GraphResponse:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   181: astore_0
    //   182: aload 5
    //   184: invokestatic 282	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   187: sipush 17200
    //   190: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_0
    //   194: areturn
    //   195: astore_0
    //   196: aload_3
    //   197: invokestatic 282	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   200: sipush 17200
    //   203: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_0
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramHttpURLConnection	HttpURLConnection
    //   0	208	1	paramGraphRequestBatch	GraphRequestBatch
    //   13	80	2	localInputStream1	InputStream
    //   96	29	2	localFacebookException	FacebookException
    //   142	33	2	localException	java.lang.Exception
    //   23	174	3	localObject1	Object
    //   15	115	4	localInputStream2	InputStream
    //   19	164	5	localObject2	Object
    //   7	75	6	localList	List
    //   10	76	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   24	34	96	com/facebook/FacebookException
    //   44	49	96	com/facebook/FacebookException
    //   57	65	96	com/facebook/FacebookException
    //   88	93	96	com/facebook/FacebookException
    //   24	34	142	java/lang/Exception
    //   44	49	142	java/lang/Exception
    //   57	65	142	java/lang/Exception
    //   88	93	142	java/lang/Exception
    //   24	34	195	finally
    //   44	49	195	finally
    //   57	65	195	finally
    //   88	93	195	finally
    //   100	119	195	finally
    //   122	129	195	finally
    //   146	165	195	finally
    //   168	182	195	finally
  }
  
  public final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public final FacebookRequestError getError()
  {
    return this.error;
  }
  
  public final JSONArray getJSONArray()
  {
    return this.graphObjectArray;
  }
  
  public final JSONObject getJSONObject()
  {
    return this.graphObject;
  }
  
  public String getRawResponse()
  {
    return this.rawResponse;
  }
  
  public GraphRequest getRequest()
  {
    return this.request;
  }
  
  public GraphRequest getRequestForPagedResults(GraphResponse.PagingDirection paramPagingDirection)
  {
    AppMethodBeat.i(17198);
    JSONObject localJSONObject;
    if (this.graphObject != null)
    {
      localJSONObject = this.graphObject.optJSONObject("paging");
      if (localJSONObject != null) {
        if (paramPagingDirection == GraphResponse.PagingDirection.NEXT) {
          paramPagingDirection = localJSONObject.optString("next");
        }
      }
    }
    for (;;)
    {
      if (Utility.isNullOrEmpty(paramPagingDirection))
      {
        AppMethodBeat.o(17198);
        return null;
        paramPagingDirection = localJSONObject.optString("previous");
      }
      else
      {
        if ((paramPagingDirection != null) && (paramPagingDirection.equals(this.request.getUrlForSingleRequest())))
        {
          AppMethodBeat.o(17198);
          return null;
        }
        try
        {
          paramPagingDirection = new GraphRequest(this.request.getAccessToken(), new URL(paramPagingDirection));
          AppMethodBeat.o(17198);
          return paramPagingDirection;
        }
        catch (MalformedURLException paramPagingDirection)
        {
          AppMethodBeat.o(17198);
          return null;
        }
        paramPagingDirection = null;
      }
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(17199);
    for (;;)
    {
      try
      {
        localObject = Locale.US;
        if (this.connection == null) {
          continue;
        }
        i = this.connection.getResponseCode();
        localObject = String.format((Locale)localObject, "%d", new Object[] { Integer.valueOf(i) });
      }
      catch (IOException localIOException)
      {
        Object localObject;
        int i;
        String str = "unknown";
        continue;
      }
      localObject = "{Response:  responseCode: " + (String)localObject + ", graphObject: " + this.graphObject + ", error: " + this.error + "}";
      AppMethodBeat.o(17199);
      return localObject;
      i = 200;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.GraphResponse
 * JD-Core Version:    0.7.0.1
 */