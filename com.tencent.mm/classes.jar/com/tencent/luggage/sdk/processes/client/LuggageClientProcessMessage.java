package com.tencent.luggage.sdk.processes.client;

import android.os.Parcelable;
import com.tencent.luggage.sdk.e.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "RUNTIME", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "Landroid/os/Parcelable;", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "runInLuggageProcess", "", "runtime", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class LuggageClientProcessMessage<RUNTIME extends d>
  implements Parcelable
{
  private final String appId;
  
  public LuggageClientProcessMessage(String paramString)
  {
    this.appId = paramString;
  }
  
  public abstract void a(RUNTIME paramRUNTIME);
  
  public String getAppId()
  {
    return this.appId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage
 * JD-Core Version:    0.7.0.1
 */