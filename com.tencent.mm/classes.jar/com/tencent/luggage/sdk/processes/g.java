package com.tencent.luggage.sdk.processes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "", "appId", "", "isGame", "", "versionType", "", "(Ljava/lang/String;ZI)V", "getAppId", "()Ljava/lang/String;", "()Z", "getVersionType", "()I", "luggage-wechat-full-sdk_release"})
public class g
{
  public final String appId;
  final int cBU;
  final boolean csz;
  
  public g(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(234844);
    this.appId = paramString;
    this.csz = paramBoolean;
    this.cBU = paramInt;
    AppMethodBeat.o(234844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.g
 * JD-Core Version:    0.7.0.1
 */