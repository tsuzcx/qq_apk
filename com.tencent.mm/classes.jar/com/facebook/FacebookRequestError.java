package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError
  implements Parcelable
{
  private static final String BODY_KEY = "body";
  private static final String CODE_KEY = "code";
  public static final Parcelable.Creator<FacebookRequestError> CREATOR;
  private static final String ERROR_CODE_FIELD_KEY = "code";
  private static final String ERROR_CODE_KEY = "error_code";
  private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
  private static final String ERROR_KEY = "error";
  private static final String ERROR_MESSAGE_FIELD_KEY = "message";
  private static final String ERROR_MSG_KEY = "error_msg";
  private static final String ERROR_REASON_KEY = "error_reason";
  private static final String ERROR_SUB_CODE_KEY = "error_subcode";
  private static final String ERROR_TYPE_FIELD_KEY = "type";
  private static final String ERROR_USER_MSG_KEY = "error_user_msg";
  private static final String ERROR_USER_TITLE_KEY = "error_user_title";
  static final FacebookRequestError.Range HTTP_RANGE_SUCCESS;
  public static final int INVALID_ERROR_CODE = -1;
  public static final int INVALID_HTTP_STATUS_CODE = -1;
  private final Object batchRequestResult;
  private final FacebookRequestError.Category category;
  private final HttpURLConnection connection;
  private final int errorCode;
  private final String errorMessage;
  private final String errorRecoveryMessage;
  private final String errorType;
  private final String errorUserMessage;
  private final String errorUserTitle;
  private final FacebookException exception;
  private final JSONObject requestResult;
  private final JSONObject requestResultBody;
  private final int requestStatusCode;
  private final int subErrorCode;
  
  static
  {
    AppMethodBeat.i(71596);
    HTTP_RANGE_SUCCESS = new FacebookRequestError.Range(200, 299, null);
    CREATOR = new FacebookRequestError.1();
    AppMethodBeat.o(71596);
  }
  
  private FacebookRequestError(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, JSONObject paramJSONObject1, JSONObject paramJSONObject2, Object paramObject, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(71588);
    this.requestStatusCode = paramInt1;
    this.errorCode = paramInt2;
    this.subErrorCode = paramInt3;
    this.errorType = paramString1;
    this.errorMessage = paramString2;
    this.requestResultBody = paramJSONObject1;
    this.requestResult = paramJSONObject2;
    this.batchRequestResult = paramObject;
    this.connection = paramHttpURLConnection;
    this.errorUserTitle = paramString3;
    this.errorUserMessage = paramString4;
    paramInt1 = 0;
    if (paramFacebookException != null)
    {
      this.exception = paramFacebookException;
      paramInt1 = 1;
      paramString2 = getErrorClassification();
      if (paramInt1 == 0) {
        break label143;
      }
    }
    label143:
    for (paramString1 = FacebookRequestError.Category.OTHER;; paramString1 = paramString2.classify(paramInt2, paramInt3, paramBoolean))
    {
      this.category = paramString1;
      this.errorRecoveryMessage = paramString2.getRecoveryMessage(this.category);
      AppMethodBeat.o(71588);
      return;
      this.exception = new FacebookServiceException(this, paramString2);
      break;
    }
  }
  
  public FacebookRequestError(int paramInt, String paramString1, String paramString2)
  {
    this(-1, paramInt, -1, paramString1, paramString2, null, null, false, null, null, null, null, null);
  }
  
  private FacebookRequestError(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), false, null, null, null, null, null);
    AppMethodBeat.i(71595);
    AppMethodBeat.o(71595);
  }
  
  FacebookRequestError(HttpURLConnection paramHttpURLConnection, Exception paramException) {}
  
  static FacebookRequestError checkResponseAndCreateError(JSONObject paramJSONObject, Object paramObject, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(71592);
    try
    {
      if (paramJSONObject.has("code"))
      {
        int m = paramJSONObject.getInt("code");
        Object localObject1 = Utility.getStringPropertyAsJSON(paramJSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
        if ((localObject1 != null) && ((localObject1 instanceof JSONObject)))
        {
          JSONObject localJSONObject2 = (JSONObject)localObject1;
          localObject1 = null;
          String str = null;
          JSONObject localJSONObject1 = null;
          Object localObject4 = null;
          boolean bool2 = false;
          int j = 0;
          int k = 0;
          int i = 0;
          Object localObject2;
          Object localObject3;
          boolean bool1;
          if (localJSONObject2.has("error"))
          {
            localJSONObject1 = (JSONObject)Utility.getStringPropertyAsJSON(localJSONObject2, "error", null);
            localObject1 = localJSONObject1.optString("type", null);
            str = localJSONObject1.optString("message", null);
            j = localJSONObject1.optInt("code", -1);
            k = localJSONObject1.optInt("error_subcode", -1);
            localObject2 = localJSONObject1.optString("error_user_msg", null);
            localObject3 = localJSONObject1.optString("error_user_title", null);
            bool1 = localJSONObject1.optBoolean("is_transient", false);
            i = 1;
          }
          while (i != 0)
          {
            paramJSONObject = new FacebookRequestError(m, j, k, (String)localObject1, str, (String)localObject3, (String)localObject2, bool1, localJSONObject2, paramJSONObject, paramObject, paramHttpURLConnection, null);
            AppMethodBeat.o(71592);
            return paramJSONObject;
            if ((!localJSONObject2.has("error_code")) && (!localJSONObject2.has("error_msg")))
            {
              localObject3 = localObject4;
              localObject2 = localJSONObject1;
              bool1 = bool2;
              if (!localJSONObject2.has("error_reason")) {}
            }
            else
            {
              localObject1 = localJSONObject2.optString("error_reason", null);
              str = localJSONObject2.optString("error_msg", null);
              j = localJSONObject2.optInt("error_code", -1);
              k = localJSONObject2.optInt("error_subcode", -1);
              i = 1;
              localObject3 = localObject4;
              localObject2 = localJSONObject1;
              bool1 = bool2;
            }
          }
        }
        if (!HTTP_RANGE_SUCCESS.contains(m))
        {
          if (paramJSONObject.has("body")) {}
          for (localObject1 = (JSONObject)Utility.getStringPropertyAsJSON(paramJSONObject, "body", "FACEBOOK_NON_JSON_RESULT");; localObject1 = null)
          {
            paramJSONObject = new FacebookRequestError(m, -1, -1, null, null, null, null, false, (JSONObject)localObject1, paramJSONObject, paramObject, paramHttpURLConnection, null);
            AppMethodBeat.o(71592);
            return paramJSONObject;
          }
        }
      }
      return null;
    }
    catch (JSONException paramJSONObject)
    {
      AppMethodBeat.o(71592);
    }
  }
  
  /* Error */
  static FacebookRequestErrorClassification getErrorClassification()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 219
    //   5: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 224	com/facebook/FacebookSdk:getApplicationId	()Ljava/lang/String;
    //   11: invokestatic 230	com/facebook/internal/FetchedAppSettingsManager:getAppSettingsWithoutQuery	(Ljava/lang/String;)Lcom/facebook/internal/FetchedAppSettings;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnonnull +17 -> 33
    //   19: invokestatic 233	com/facebook/internal/FacebookRequestErrorClassification:getDefaultErrorClassification	()Lcom/facebook/internal/FacebookRequestErrorClassification;
    //   22: astore_0
    //   23: ldc 219
    //   25: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: aload_0
    //   34: invokevirtual 236	com/facebook/internal/FetchedAppSettings:getErrorClassification	()Lcom/facebook/internal/FacebookRequestErrorClassification;
    //   37: astore_0
    //   38: ldc 219
    //   40: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -15 -> 28
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	24	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	46	finally
    //   19	28	46	finally
    //   33	43	46	finally
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Object getBatchRequestResult()
  {
    return this.batchRequestResult;
  }
  
  public final FacebookRequestError.Category getCategory()
  {
    return this.category;
  }
  
  public final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public final int getErrorCode()
  {
    return this.errorCode;
  }
  
  public final String getErrorMessage()
  {
    AppMethodBeat.i(71590);
    if (this.errorMessage != null)
    {
      str = this.errorMessage;
      AppMethodBeat.o(71590);
      return str;
    }
    String str = this.exception.getLocalizedMessage();
    AppMethodBeat.o(71590);
    return str;
  }
  
  public final String getErrorRecoveryMessage()
  {
    return this.errorRecoveryMessage;
  }
  
  public final String getErrorType()
  {
    return this.errorType;
  }
  
  public final String getErrorUserMessage()
  {
    return this.errorUserMessage;
  }
  
  public final String getErrorUserTitle()
  {
    return this.errorUserTitle;
  }
  
  public final FacebookException getException()
  {
    return this.exception;
  }
  
  public final JSONObject getRequestResult()
  {
    return this.requestResult;
  }
  
  public final JSONObject getRequestResultBody()
  {
    return this.requestResultBody;
  }
  
  public final int getRequestStatusCode()
  {
    return this.requestStatusCode;
  }
  
  public final int getSubErrorCode()
  {
    return this.subErrorCode;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(71591);
    String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
    AppMethodBeat.o(71591);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(71594);
    paramParcel.writeInt(this.requestStatusCode);
    paramParcel.writeInt(this.errorCode);
    paramParcel.writeInt(this.subErrorCode);
    paramParcel.writeString(this.errorType);
    paramParcel.writeString(this.errorMessage);
    paramParcel.writeString(this.errorUserTitle);
    paramParcel.writeString(this.errorUserMessage);
    AppMethodBeat.o(71594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.FacebookRequestError
 * JD-Core Version:    0.7.0.1
 */