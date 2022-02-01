package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.plugin.gif.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", "encoder", "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"})
public final class c
{
  public static final a uVl;
  private final String TAG;
  private final int height;
  private long kUE;
  MMHandler uVh;
  private com.tencent.mm.plugin.gif.a uVi;
  private int uVj;
  private final String uVk;
  private final int width;
  
  static
  {
    AppMethodBeat.i(269);
    uVl = new a((byte)0);
    AppMethodBeat.o(269);
  }
  
  public c(String paramString, int paramInt1, int paramInt2, long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(268);
    this.uVk = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiMixGifEncoder";
    this.uVj = 30;
    this.uVh = new MMHandler("EmojiMixer_gifEncode");
    if (paramBoolean) {}
    for (paramString = (com.tencent.mm.plugin.gif.a)new g(this.uVk, this.width, this.height, paramLong);; paramString = (com.tencent.mm.plugin.gif.a)new i(this.uVk, this.width, this.height, paramLong))
    {
      this.uVi = paramString;
      this.uVh.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264);
          boolean bool = c.a(this.uVm).init();
          Log.i(c.b(this.uVm), "init encoder, outputGif: " + paramBoolean + " ret: " + bool);
          e locale;
          if (!bool)
          {
            if (!paramBoolean) {
              break label92;
            }
            locale = e.uUh;
            e.cXN();
          }
          for (;;)
          {
            c.a(this.uVm, Util.currentTicks());
            AppMethodBeat.o(264);
            return;
            label92:
            locale = e.uUh;
            e.cXM();
          }
        }
      });
      AppMethodBeat.o(268);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder$Companion;", "", "()V", "EMOJI_MIX_WXAM_QP", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(265);
      long l = Util.currentTicks();
      boolean bool = c.a(this.uVm).e(this.kWo, this.uVo);
      Log.i(c.b(this.uVm), "encodeRgbaFrame used " + Util.ticksToNow(l) + ", ret:" + bool);
      AppMethodBeat.o(265);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(266);
      long l = Util.currentTicks();
      boolean bool = c.a(this.uVm).eAU();
      Log.i(c.b(this.uVm), "finishEncode used " + Util.ticksToNow(l) + ", ret:" + bool + ", totally used " + Util.ticksToNow(c.c(this.uVm)) + "ms");
      c.d(this.uVm).quit();
      kotlin.g.a.a locala = this.kWs;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(266);
        return;
      }
      AppMethodBeat.o(266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.c
 * JD-Core Version:    0.7.0.1
 */