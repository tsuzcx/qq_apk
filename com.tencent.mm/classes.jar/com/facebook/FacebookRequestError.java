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
  static final Range HTTP_RANGE_SUCCESS;
  public static final int INVALID_ERROR_CODE = -1;
  public static final int INVALID_HTTP_STATUS_CODE = -1;
  private final Object batchRequestResult;
  private final Category category;
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
    AppMethodBeat.i(17032);
    HTTP_RANGE_SUCCESS = new Range(200, 299, null);
    CREATOR = new Parcelable.Creator()
    {
      public final FacebookRequestError createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(17018);
        paramAnonymousParcel = new FacebookRequestError(paramAnonymousParcel, null);
        AppMethodBeat.o(17018);
        return paramAnonymousParcel;
      }
      
      public final FacebookRequestError[] newArray(int paramAnonymousInt)
      {
        return new FacebookRequestError[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(17032);
  }
  
  private FacebookRequestError(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, JSONObject paramJSONObject1, JSONObject paramJSONObject2, Object paramObject, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(17024);
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
        break label145;
      }
    }
    label145:
    for (paramString1 = Category.OTHER;; paramString1 = paramString2.classify(paramInt2, paramInt3, paramBoolean))
    {
      this.category = paramString1;
      this.errorRecoveryMessage = paramString2.getRecoveryMessage(this.category);
      AppMethodBeat.o(17024);
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
    AppMethodBeat.i(17031);
    AppMethodBeat.o(17031);
  }
  
  FacebookRequestError(HttpURLConnection paramHttpURLConnection, Exception paramException) {}
  
  static FacebookRequestError checkResponseAndCreateError(JSONObject paramJSONObject, Object paramObject, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(17028);
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
            AppMethodBeat.o(17028);
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
            AppMethodBeat.o(17028);
            return paramJSONObject;
          }
        }
      }
      return null;
    }
    catch (JSONException paramJSONObject)
    {
      AppMethodBeat.o(17028);
    }
  }
  
  /* Error */
  static FacebookRequestErrorClassification getErrorClassification()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 17029
    //   6: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 220	com/facebook/FacebookSdk:getApplicationId	()Ljava/lang/String;
    //   12: invokestatic 226	com/facebook/internal/FetchedAppSettingsManager:getAppSettingsWithoutQuery	(Ljava/lang/String;)Lcom/facebook/internal/FetchedAppSettings;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnonnull +18 -> 35
    //   20: invokestatic 229	com/facebook/internal/FacebookRequestErrorClassification:getDefaultErrorClassification	()Lcom/facebook/internal/FacebookRequestErrorClassification;
    //   23: astore_0
    //   24: sipush 17029
    //   27: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 232	com/facebook/internal/FetchedAppSettings:getErrorClassification	()Lcom/facebook/internal/FacebookRequestErrorClassification;
    //   39: astore_0
    //   40: sipush 17029
    //   43: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -16 -> 30
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	25	0	localObject1	Object
    //   49	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	49	finally
    //   20	30	49	finally
    //   35	46	49	finally
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Object getBatchRequestResult()
  {
    return this.batchRequestResult;
  }
  
  public final Category getCategory()
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
    AppMethodBeat.i(17026);
    if (this.errorMessage != null)
    {
      str = this.errorMessage;
      AppMethodBeat.o(17026);
      return str;
    }
    String str = this.exception.getLocalizedMessage();
    AppMethodBeat.o(17026);
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
    AppMethodBeat.i(17027);
    String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
    AppMethodBeat.o(17027);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(17030);
    paramParcel.writeInt(this.requestStatusCode);
    paramParcel.writeInt(this.errorCode);
    paramParcel.writeInt(this.subErrorCode);
    paramParcel.writeString(this.errorType);
    paramParcel.writeString(this.errorMessage);
    paramParcel.writeString(this.errorUserTitle);
    paramParcel.writeString(this.errorUserMessage);
    AppMethodBeat.o(17030);
  }
  
  public static enum Category
  {
    static
    {
      AppMethodBeat.i(17023);
      LOGIN_RECOVERABLE = new Category("LOGIN_RECOVERABLE", 0);
      OTHER = new Category("OTHER", 1);
      TRANSIENT = new Category("TRANSIENT", 2);
      $VALUES = new Category[] { LOGIN_RECOVERABLE, OTHER, TRANSIENT };
      AppMethodBeat.o(17023);
    }
    
    private Category() {}
  }
  
  static class Range
  {
    private final int end;
    private final int start;
    
    private Range(int paramInt1, int paramInt2)
    {
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    boolean contains(int paramInt)
    {
      return (this.start <= paramInt) && (paramInt <= this.end);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.FacebookRequestError
 * JD-Core Version:    0.7.0.1
 */