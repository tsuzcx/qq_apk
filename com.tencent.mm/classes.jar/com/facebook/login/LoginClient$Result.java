package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class LoginClient$Result
  implements Parcelable
{
  public static final Parcelable.Creator<Result> CREATOR;
  final LoginClient.Result.Code code;
  final String errorCode;
  final String errorMessage;
  public Map<String, String> extraData;
  public Map<String, String> loggingExtras;
  final LoginClient.Request request;
  final AccessToken token;
  
  static
  {
    AppMethodBeat.i(96814);
    CREATOR = new LoginClient.Result.1();
    AppMethodBeat.o(96814);
  }
  
  private LoginClient$Result(Parcel paramParcel)
  {
    AppMethodBeat.i(96812);
    this.code = LoginClient.Result.Code.valueOf(paramParcel.readString());
    this.token = ((AccessToken)paramParcel.readParcelable(AccessToken.class.getClassLoader()));
    this.errorMessage = paramParcel.readString();
    this.errorCode = paramParcel.readString();
    this.request = ((LoginClient.Request)paramParcel.readParcelable(LoginClient.Request.class.getClassLoader()));
    this.loggingExtras = Utility.readStringMapFromParcel(paramParcel);
    this.extraData = Utility.readStringMapFromParcel(paramParcel);
    AppMethodBeat.o(96812);
  }
  
  LoginClient$Result(LoginClient.Request paramRequest, LoginClient.Result.Code paramCode, AccessToken paramAccessToken, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96807);
    Validate.notNull(paramCode, "code");
    this.request = paramRequest;
    this.token = paramAccessToken;
    this.errorMessage = paramString1;
    this.code = paramCode;
    this.errorCode = paramString2;
    AppMethodBeat.o(96807);
  }
  
  static Result createCancelResult(LoginClient.Request paramRequest, String paramString)
  {
    AppMethodBeat.i(96809);
    paramRequest = new Result(paramRequest, LoginClient.Result.Code.CANCEL, null, paramString, null);
    AppMethodBeat.o(96809);
    return paramRequest;
  }
  
  static Result createErrorResult(LoginClient.Request paramRequest, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96810);
    paramRequest = createErrorResult(paramRequest, paramString1, paramString2, null);
    AppMethodBeat.o(96810);
    return paramRequest;
  }
  
  static Result createErrorResult(LoginClient.Request paramRequest, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96811);
    paramString1 = TextUtils.join(": ", Utility.asListNoNulls(new String[] { paramString1, paramString2 }));
    paramRequest = new Result(paramRequest, LoginClient.Result.Code.ERROR, null, paramString1, paramString3);
    AppMethodBeat.o(96811);
    return paramRequest;
  }
  
  static Result createTokenResult(LoginClient.Request paramRequest, AccessToken paramAccessToken)
  {
    AppMethodBeat.i(96808);
    paramRequest = new Result(paramRequest, LoginClient.Result.Code.SUCCESS, paramAccessToken, null, null);
    AppMethodBeat.o(96808);
    return paramRequest;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96813);
    paramParcel.writeString(this.code.name());
    paramParcel.writeParcelable(this.token, paramInt);
    paramParcel.writeString(this.errorMessage);
    paramParcel.writeString(this.errorCode);
    paramParcel.writeParcelable(this.request, paramInt);
    Utility.writeStringMapToParcel(paramParcel, this.loggingExtras);
    Utility.writeStringMapToParcel(paramParcel, this.extraData);
    AppMethodBeat.o(96813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.login.LoginClient.Result
 * JD-Core Version:    0.7.0.1
 */