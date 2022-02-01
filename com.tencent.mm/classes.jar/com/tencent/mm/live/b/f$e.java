package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveConstants$MMKV;", "", "()V", "ANCHOR_VERIFY", "", "getANCHOR_VERIFY", "()Ljava/lang/String;", "KEY_ANCHOR_LIVE_ID", "getKEY_ANCHOR_LIVE_ID", "KEY_VISITOR_MIC_DIALOG", "getKEY_VISITOR_MIC_DIALOG", "TAG_LIVE_CORE", "getTAG_LIVE_CORE", "plugin-logic_release"})
public final class f$e
{
  private static final String gPQ = "tag_live_core";
  private static final String gPR = "key_anchor_live_id";
  private static final String gPS = "anchor_verify";
  private static final String gPT = "key_visitor_mic_dialog";
  public static final e gPU;
  
  static
  {
    AppMethodBeat.i(215662);
    gPU = new e();
    gPQ = "tag_live_core";
    gPR = "key_anchor_live_id";
    gPS = "anchor_verify";
    gPT = "key_visitor_mic_dialog";
    AppMethodBeat.o(215662);
  }
  
  public static String anq()
  {
    return gPQ;
  }
  
  public static String ans()
  {
    return gPS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.f.e
 * JD-Core Version:    0.7.0.1
 */