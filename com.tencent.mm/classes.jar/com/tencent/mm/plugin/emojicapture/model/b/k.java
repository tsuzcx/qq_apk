package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.sticker.f;
import d.g.a.b;
import d.g.b.q;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "gifPath", "videoPlayRate", "", "removeBackground", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "outputGif", "timeEnter", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;Ljava/lang/String;IZLcom/tencent/mm/sticker/StickerPack;ZJ)V", "getEmojiFrameRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "frameCount", "gifEncoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "getGifPath", "()Ljava/lang/String;", "mixPixelBuffer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "mixTime", "onMixFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "startTick", "syncMgr", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "getTimeEnter", "()J", "videoDecoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "finishMix", "mixVideoFrame", "start", "mixFinish", "Companion", "plugin-emojicapture_release"})
public final class k
{
  public static final k.a pZt;
  int frameCount;
  long gmN;
  private final long gsp;
  final String kxX;
  final int pYN;
  final f pYP;
  final boolean pYQ;
  private l pZl;
  com.tencent.mm.plugin.emojicapture.ui.b.c pZm;
  g pZn;
  c pZo;
  b<? super Boolean, z> pZp;
  private long pZq;
  final a pZr;
  final boolean pZs;
  final String videoPath;
  
  static
  {
    AppMethodBeat.i(310);
    pZt = new k.a((byte)0);
    AppMethodBeat.o(310);
  }
  
  public k(String paramString1, a parama, String paramString2, int paramInt, boolean paramBoolean1, f paramf, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(309);
    this.videoPath = paramString1;
    this.pZr = parama;
    this.kxX = paramString2;
    this.pYN = paramInt;
    this.pZs = paramBoolean1;
    this.pYP = paramf;
    this.pYQ = paramBoolean2;
    this.gsp = paramLong;
    AppMethodBeat.o(309);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(k paramk, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "skipFrame", "", "invoke"})
  static final class c
    extends q
    implements b<Boolean, z>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(k paramk, com.tencent.mm.plugin.sight.base.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.k
 * JD-Core Version:    0.7.0.1
 */