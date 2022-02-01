package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.sticker.f;
import d.g.a.b;
import d.g.b.q;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "gifPath", "videoPlayRate", "", "removeBackground", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "outputGif", "timeEnter", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;Ljava/lang/String;IZLcom/tencent/mm/sticker/StickerPack;ZJ)V", "getEmojiFrameRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "frameCount", "gifEncoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "getGifPath", "()Ljava/lang/String;", "mixPixelBuffer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "mixTime", "onMixFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "startTick", "syncMgr", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "getTimeEnter", "()J", "videoDecoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "finishMix", "mixVideoFrame", "start", "mixFinish", "Companion", "plugin-emojicapture_release"})
public final class k
{
  public static final k.a pSO;
  int frameCount;
  long gkt;
  private final long gpU;
  final String kuH;
  private l pSG;
  com.tencent.mm.plugin.emojicapture.ui.b.c pSH;
  g pSI;
  c pSJ;
  b<? super Boolean, z> pSK;
  private long pSL;
  final a pSM;
  final boolean pSN;
  final int pSi;
  final f pSk;
  final boolean pSl;
  final String videoPath;
  
  static
  {
    AppMethodBeat.i(310);
    pSO = new k.a((byte)0);
    AppMethodBeat.o(310);
  }
  
  public k(String paramString1, a parama, String paramString2, int paramInt, boolean paramBoolean1, f paramf, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(309);
    this.videoPath = paramString1;
    this.pSM = parama;
    this.kuH = paramString2;
    this.pSi = paramInt;
    this.pSN = paramBoolean1;
    this.pSk = paramf;
    this.pSl = paramBoolean2;
    this.gpU = paramLong;
    AppMethodBeat.o(309);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(k paramk, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "skipFrame", "", "invoke"})
  static final class c
    extends q
    implements b<Boolean, z>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.k
 * JD-Core Version:    0.7.0.1
 */