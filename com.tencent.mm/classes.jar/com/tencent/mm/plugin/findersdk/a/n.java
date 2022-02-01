package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/ConstantsOccupyFinderUI13;", "", "()V", "KEY_FINDER_OBJECT", "", "KEY_JUMP_HOT_INTENT", "KEY_JUMP_INFO", "KEY_JUMP_TYPE_CODE", "KEY_OBJECT_ID", "KEY_OBJECT_NONCE_ID", "KEY_PUSH_CTRL_FLAG", "KEY_PUSH_DEMOTION_FLAG", "KEY_PUSH_FAIL_RETURN_READY", "KEY_PUSH_FAIL_RETURN_TO", "KEY_PUSH_LEVEL", "KEY_REPORT_EXT_INFO", "KEY_ROUTE_TYPE", "KEY_SESSION_ID", "KEY_TASK_ID", "KEY_UDF_KV", "TAG", "clickNotificationTime", "", "getClickNotificationTime", "()J", "setClickNotificationTime", "(J)V", "clickTaskId", "getClickTaskId", "()Ljava/lang/String;", "setClickTaskId", "(Ljava/lang/String;)V", "lastClickTaskId", "getLastClickTaskId", "setLastClickTaskId", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n Hcg;
  private static String Hch;
  private static String Hci;
  private static long Hcj;
  
  static
  {
    AppMethodBeat.i(274003);
    Hcg = new n();
    Hch = "";
    Hci = "";
    AppMethodBeat.o(274003);
  }
  
  public static void aDc(String paramString)
  {
    AppMethodBeat.i(273977);
    s.u(paramString, "<set-?>");
    Hch = paramString;
    AppMethodBeat.o(273977);
  }
  
  public static void aDd(String paramString)
  {
    AppMethodBeat.i(273984);
    s.u(paramString, "<set-?>");
    Hci = paramString;
    AppMethodBeat.o(273984);
  }
  
  public static String frC()
  {
    return Hch;
  }
  
  public static String frD()
  {
    return Hci;
  }
  
  public static long frE()
  {
    return Hcj;
  }
  
  public static void rk(long paramLong)
  {
    Hcj = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.n
 * JD-Core Version:    0.7.0.1
 */