package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "gifPath", "videoPlayRate", "", "removeBackground", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "outputGif", "timeEnter", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;Ljava/lang/String;IZLcom/tencent/mm/sticker/StickerPack;ZJ)V", "getEmojiFrameRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "frameCount", "gifEncoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "getGifPath", "()Ljava/lang/String;", "mixPixelBuffer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "mixTime", "onMixFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "startTick", "syncMgr", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "getTimeEnter", "()J", "videoDecoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "finishMix", "mixVideoFrame", "start", "mixFinish", "Companion", "plugin-emojicapture_release"})
public final class k
{
  public static final a oLT;
  long fNi;
  private final long fSw;
  int frameCount;
  final String jzP;
  private l oLL;
  com.tencent.mm.plugin.emojicapture.ui.b.c oLM;
  com.tencent.mm.media.g.e oLN;
  c oLO;
  b<? super Boolean, y> oLP;
  private long oLQ;
  final a oLR;
  final boolean oLS;
  final int oLn;
  final com.tencent.mm.sticker.e oLp;
  final boolean oLq;
  final String videoPath;
  
  static
  {
    AppMethodBeat.i(310);
    oLT = new a((byte)0);
    AppMethodBeat.o(310);
  }
  
  public k(String paramString1, a parama, String paramString2, int paramInt, boolean paramBoolean1, com.tencent.mm.sticker.e parame, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(309);
    this.videoPath = paramString1;
    this.oLR = parama;
    this.jzP = paramString2;
    this.oLn = paramInt;
    this.oLS = paramBoolean1;
    this.oLp = parame;
    this.oLq = paramBoolean2;
    this.fSw = paramLong;
    AppMethodBeat.o(309);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(k paramk, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "skipFrame", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<Boolean, y>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(k paramk, com.tencent.mm.plugin.sight.base.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.k
 * JD-Core Version:    0.7.0.1
 */