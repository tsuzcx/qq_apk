package com.tencent.luggage.sdk.processes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/KillType;", "", "(Ljava/lang/String;I)V", "KILL_TYPE_SILENT", "KILL_TYPE_NOTIFY_ACCOUNT_RELEASE", "KILL_TYPE_SILENT_IF_INACTIVE", "KILL_TYPE_SILENT_ACCOUNT_LOGOUT", "KILL_TYPE_API_FORCE_KILL_ALL", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  static
  {
    AppMethodBeat.i(220462);
    etO = new b("KILL_TYPE_SILENT", 0);
    etP = new b("KILL_TYPE_NOTIFY_ACCOUNT_RELEASE", 1);
    etQ = new b("KILL_TYPE_SILENT_IF_INACTIVE", 2);
    etR = new b("KILL_TYPE_SILENT_ACCOUNT_LOGOUT", 3);
    etS = new b("KILL_TYPE_API_FORCE_KILL_ALL", 4);
    etT = new b[] { etO, etP, etQ, etR, etS };
    AppMethodBeat.o(220462);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.b
 * JD-Core Version:    0.7.0.1
 */