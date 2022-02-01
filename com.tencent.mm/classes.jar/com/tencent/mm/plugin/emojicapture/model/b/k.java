package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "gifPath", "videoPlayRate", "", "removeBackground", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "outputGif", "timeEnter", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;Ljava/lang/String;IZLcom/tencent/mm/sticker/StickerPack;ZJ)V", "getEmojiFrameRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "frameCount", "gifEncoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "getGifPath", "()Ljava/lang/String;", "mixPixelBuffer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "mixTime", "onMixFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "startTick", "syncMgr", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "getTimeEnter", "()J", "videoDecoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "finishMix", "mixVideoFrame", "start", "mixFinish", "Companion", "plugin-emojicapture_release"})
public final class k
{
  public static final k.a ppn;
  long fQT;
  private final long fWr;
  int frameCount;
  final String kal;
  final int poH;
  final com.tencent.mm.sticker.f poJ;
  final boolean poK;
  private l ppf;
  com.tencent.mm.plugin.emojicapture.ui.b.c ppg;
  com.tencent.mm.media.g.f pph;
  c ppi;
  b<? super Boolean, y> ppj;
  private long ppk;
  final a ppl;
  final boolean ppm;
  final String videoPath;
  
  static
  {
    AppMethodBeat.i(310);
    ppn = new k.a((byte)0);
    AppMethodBeat.o(310);
  }
  
  public k(String paramString1, a parama, String paramString2, int paramInt, boolean paramBoolean1, com.tencent.mm.sticker.f paramf, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(309);
    this.videoPath = paramString1;
    this.ppl = parama;
    this.kal = paramString2;
    this.poH = paramInt;
    this.ppm = paramBoolean1;
    this.poJ = paramf;
    this.poK = paramBoolean2;
    this.fWr = paramLong;
    AppMethodBeat.o(309);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(k paramk, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "skipFrame", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<Boolean, y>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.k
 * JD-Core Version:    0.7.0.1
 */