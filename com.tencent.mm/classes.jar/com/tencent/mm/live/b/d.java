package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePlayer;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveCdnPlayerManager;", "", "()V", "Companion", "plugin-logic_release"})
public final class d
{
  private static final String TAG = "MicroMsg.LiveCdnPlayerManager";
  private static TXLivePlayer gte;
  public static final a gtf;
  
  static
  {
    AppMethodBeat.i(189750);
    gtf = new a((byte)0);
    TAG = "MicroMsg.LiveCdnPlayerManager";
    AppMethodBeat.o(189750);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveCdnPlayerManager$Companion;", "", "()V", "TAG", "", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "getTXLivePlayer", "context", "Landroid/content/Context;", "playListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "startPlay", "", "url", "streamType", "", "playerView", "Lcom/tencent/mm/live/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "stopPlay", "keepLastFrame", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.d
 * JD-Core Version:    0.7.0.1
 */