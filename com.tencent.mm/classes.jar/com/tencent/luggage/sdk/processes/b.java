package com.tencent.luggage.sdk.processes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/KillType;", "", "(Ljava/lang/String;I)V", "KILL_TYPE_SILENT", "KILL_TYPE_NOTIFY_ACCOUNT_RELEASE", "KILL_TYPE_SILENT_IF_INACTIVE", "KILL_TYPE_SILENT_ACCOUNT_LOGOUT", "KILL_TYPE_API_FORCE_KILL_ALL", "luggage-wechat-full-sdk_release"})
public enum b
{
  static
  {
    AppMethodBeat.i(242154);
    b localb1 = new b("KILL_TYPE_SILENT", 0);
    cBi = localb1;
    b localb2 = new b("KILL_TYPE_NOTIFY_ACCOUNT_RELEASE", 1);
    cBj = localb2;
    b localb3 = new b("KILL_TYPE_SILENT_IF_INACTIVE", 2);
    cBk = localb3;
    b localb4 = new b("KILL_TYPE_SILENT_ACCOUNT_LOGOUT", 3);
    cBl = localb4;
    b localb5 = new b("KILL_TYPE_API_FORCE_KILL_ALL", 4);
    cBm = localb5;
    cBn = new b[] { localb1, localb2, localb3, localb4, localb5 };
    AppMethodBeat.o(242154);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.b
 * JD-Core Version:    0.7.0.1
 */