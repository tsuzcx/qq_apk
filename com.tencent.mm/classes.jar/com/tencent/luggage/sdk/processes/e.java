package com.tencent.luggage.sdk.processes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "", "appId", "", "debugType", "", "status", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;", "isPersistentApp", "", "(Ljava/lang/String;ILcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;Z)V", "getAppId", "()Ljava/lang/String;", "getDebugType", "()I", "setDebugType", "(I)V", "instanceId", "getInstanceId", "setInstanceId", "(Ljava/lang/String;)V", "()Z", "setPersistentApp", "(Z)V", "preRendered", "getPreRendered", "setPreRendered", "startingTimestamp", "", "getStartingTimestamp", "()J", "toString", "writeStatus", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e
{
  private static final e.a euk;
  public final String appId;
  public boolean epd;
  public int eul;
  public f eum;
  private boolean eun;
  final long euo;
  public String eup;
  
  static
  {
    AppMethodBeat.i(220454);
    euk = new e.a((byte)0);
    AppMethodBeat.o(220454);
  }
  
  public e(String paramString, int paramInt, f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(220449);
    this.appId = paramString;
    this.eul = paramInt;
    this.eum = paramf;
    this.epd = paramBoolean;
    if ((this.eum == f.eur) || (this.eum == f.eus)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.eun = paramBoolean;
      this.euo = System.currentTimeMillis();
      this.eup = "";
      AppMethodBeat.o(220449);
      return;
    }
  }
  
  public final void fB(String paramString)
  {
    AppMethodBeat.i(220459);
    s.u(paramString, "<set-?>");
    this.eup = paramString;
    AppMethodBeat.o(220459);
  }
  
  public String toString()
  {
    AppMethodBeat.i(220467);
    String str = "LuggageMiniProgramRecord(appId='" + this.appId + "', debugType=" + this.eul + ", status=" + this.eum + ", isPersistent=" + this.epd + ", preRendered=" + this.eun + ", startingTimestamp=" + this.euo + ')';
    AppMethodBeat.o(220467);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.e
 * JD-Core Version:    0.7.0.1
 */