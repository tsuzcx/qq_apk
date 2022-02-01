package com.tencent.luggage.sdk.processes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "", "appId", "", "debugType", "", "status", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;", "isPersistentApp", "", "(Ljava/lang/String;ILcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;Z)V", "getAppId", "()Ljava/lang/String;", "getDebugType", "()I", "setDebugType", "(I)V", "instanceId", "getInstanceId", "setInstanceId", "(Ljava/lang/String;)V", "()Z", "setPersistentApp", "(Z)V", "preRendered", "getPreRendered", "setPreRendered", "startingTimestamp", "", "getStartingTimestamp", "()J", "toString", "writeStatus", "", "Companion", "luggage-wechat-full-sdk_release"})
public class e
{
  @Deprecated
  public static final e.a cBK;
  public final String appId;
  private boolean cBF;
  final long cBG;
  public String cBH;
  public int cBI;
  public f cBJ;
  public boolean cxb;
  
  static
  {
    AppMethodBeat.i(243231);
    cBK = new e.a((byte)0);
    AppMethodBeat.o(243231);
  }
  
  public e(String paramString, int paramInt, f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(243229);
    this.appId = paramString;
    this.cBI = paramInt;
    this.cBJ = paramf;
    this.cxb = paramBoolean;
    if ((this.cBJ == f.cBM) || (this.cBJ == f.cBN)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.cBF = paramBoolean;
      this.cBG = System.currentTimeMillis();
      this.cBH = "";
      AppMethodBeat.o(243229);
      return;
    }
  }
  
  public final void ei(String paramString)
  {
    AppMethodBeat.i(243227);
    p.k(paramString, "<set-?>");
    this.cBH = paramString;
    AppMethodBeat.o(243227);
  }
  
  public String toString()
  {
    AppMethodBeat.i(243228);
    String str = "LuggageMiniProgramRecord(appId='" + this.appId + "', debugType=" + this.cBI + ", status=" + this.cBJ + ", isPersistent=" + this.cxb + ", preRendered=" + this.cBF + ", startingTimestamp=" + this.cBG + ')';
    AppMethodBeat.o(243228);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.e
 * JD-Core Version:    0.7.0.1
 */