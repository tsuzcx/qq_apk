package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.a.b;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.e;
import com.tencent.mm.plugin.emojicapture.ui.b.d;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixer;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "gifPath", "videoPlayRate", "", "removeBackground", "", "hasSticker", "outputGif", "timeEnter", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;Ljava/lang/String;IZZZJ)V", "getEmojiFrameRetriever", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "frameCount", "gifEncoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "getGifPath", "()Ljava/lang/String;", "mixPixelBuffer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "mixTime", "onMixFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "startTick", "syncMgr", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "getTimeEnter", "()J", "videoDecoder", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "finishMix", "mixVideoFrame", "start", "mixFinish", "Companion", "plugin-emojicapture_release"})
public final class k
{
  public static final k.a lvb;
  long ewN;
  private final long eyh;
  int frameCount;
  final String hAr;
  private l luT;
  d luU;
  e luV;
  c luW;
  b<? super Boolean, y> luX;
  private long luY;
  final a luZ;
  final int luw;
  final boolean luy;
  final boolean luz;
  final boolean lva;
  final String videoPath;
  
  static
  {
    AppMethodBeat.i(2707);
    lvb = new k.a((byte)0);
    AppMethodBeat.o(2707);
  }
  
  public k(String paramString1, a parama, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    AppMethodBeat.i(2706);
    this.videoPath = paramString1;
    this.luZ = parama;
    this.hAr = paramString2;
    this.luw = paramInt;
    this.lva = paramBoolean1;
    this.luy = paramBoolean2;
    this.luz = paramBoolean3;
    this.eyh = paramLong;
    AppMethodBeat.o(2706);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class e
    extends a.f.b.k
    implements a.f.a.a<y>
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