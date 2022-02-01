package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.plugin.gif.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", "encoder", "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a yhN;
  private final String TAG;
  private final int height;
  private long nAj;
  private final String outputPath;
  private final int width;
  private MMHandler yhO;
  private com.tencent.mm.plugin.gif.a yhP;
  private int yhQ;
  
  static
  {
    AppMethodBeat.i(269);
    yhN = new c.a((byte)0);
    AppMethodBeat.o(269);
  }
  
  public c(String paramString, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(268);
    this.outputPath = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiMixGifEncoder";
    this.yhQ = 30;
    this.yhO = new MMHandler("EmojiMixer_gifEncode");
    if (paramBoolean) {}
    for (paramString = (com.tencent.mm.plugin.gif.a)new g(this.outputPath, this.width, this.height, paramLong);; paramString = (com.tencent.mm.plugin.gif.a)new i(this.outputPath, this.width, this.height, paramLong))
    {
      this.yhP = paramString;
      this.yhO.post(new c..ExternalSyntheticLambda1(this, paramBoolean));
      AppMethodBeat.o(268);
      return;
    }
  }
  
  private static final void a(c paramc, kotlin.g.a.a parama)
  {
    AppMethodBeat.i(269391);
    s.u(paramc, "this$0");
    long l = Util.currentTicks();
    boolean bool = paramc.yhP.fIZ();
    Log.i(paramc.TAG, "finishEncode used " + Util.ticksToNow(l) + ", ret:" + bool + ", totally used " + Util.ticksToNow(paramc.nAj) + "ms");
    paramc.yhO.quit();
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(269391);
  }
  
  private static final void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(269387);
    s.u(paramc, "this$0");
    boolean bool = paramc.yhP.init();
    Log.i(paramc.TAG, "init encoder, outputGif: " + paramBoolean + " ret: " + bool);
    e locale;
    if (!bool)
    {
      if (!paramBoolean) {
        break label81;
      }
      locale = e.ygT;
      e.dEd();
    }
    for (;;)
    {
      paramc.nAj = Util.currentTicks();
      AppMethodBeat.o(269387);
      return;
      label81:
      locale = e.ygT;
      e.dEc();
    }
  }
  
  private static final void a(c paramc, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(269389);
    s.u(paramc, "this$0");
    s.u(paramArrayOfByte, "$data");
    long l = Util.currentTicks();
    boolean bool = paramc.yhP.e(paramArrayOfByte, paramLong);
    Log.i(paramc.TAG, "encodeRgbaFrame used " + Util.ticksToNow(l) + ", ret:" + bool);
    AppMethodBeat.o(269389);
  }
  
  public final void aL(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(269395);
    this.yhO.post(new c..ExternalSyntheticLambda0(this, parama));
    AppMethodBeat.o(269395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.c
 * JD-Core Version:    0.7.0.1
 */