package com.tencent.luggage.sdk.processes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "", "appId", "", "isGame", "", "versionType", "", "(Ljava/lang/String;ZI)V", "getAppId", "()Ljava/lang/String;", "()Z", "getVersionType", "()I", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g
{
  public final String appId;
  final boolean ekt;
  final int euz;
  
  public g(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(220436);
    this.appId = paramString;
    this.ekt = paramBoolean;
    this.euz = paramInt;
    AppMethodBeat.o(220436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.g
 * JD-Core Version:    0.7.0.1
 */