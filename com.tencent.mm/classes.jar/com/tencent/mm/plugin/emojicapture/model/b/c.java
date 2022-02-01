package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.plugin.gif.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", "encoder", "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"})
public final class c
{
  public static final c.a rpF;
  private final String TAG;
  private final int height;
  private long ifQ;
  MMHandler rpB;
  private com.tencent.mm.plugin.gif.a rpC;
  private int rpD;
  private final String rpE;
  private final int width;
  
  static
  {
    AppMethodBeat.i(269);
    rpF = new c.a((byte)0);
    AppMethodBeat.o(269);
  }
  
  public c(String paramString, int paramInt1, int paramInt2, long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(268);
    this.rpE = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiMixGifEncoder";
    this.rpD = 30;
    this.rpB = new MMHandler("EmojiMixer_gifEncode");
    if (paramBoolean) {}
    for (paramString = (com.tencent.mm.plugin.gif.a)new g(this.rpE, this.width, this.height, paramLong);; paramString = (com.tencent.mm.plugin.gif.a)new j(this.rpE, this.width, this.height, paramLong))
    {
      this.rpC = paramString;
      this.rpB.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264);
          boolean bool = c.a(this.rpG).init();
          Log.i(c.b(this.rpG), "init encoder, outputGif: " + paramBoolean + " ret: " + bool);
          e locale;
          if (!bool)
          {
            if (!paramBoolean) {
              break label92;
            }
            locale = e.roB;
            e.cJe();
          }
          for (;;)
          {
            c.a(this.rpG, Util.currentTicks());
            AppMethodBeat.o(264);
            return;
            label92:
            locale = e.roB;
            e.cJd();
          }
        }
      });
      AppMethodBeat.o(268);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(265);
      long l = Util.currentTicks();
      boolean bool = c.a(this.rpG).d(this.ihA, this.rpI);
      Log.i(c.b(this.rpG), "encodeRgbaFrame used " + Util.ticksToNow(l) + ", ret:" + bool);
      AppMethodBeat.o(265);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(266);
      long l = Util.currentTicks();
      boolean bool = c.a(this.rpG).dXw();
      Log.i(c.b(this.rpG), "finishEncode used " + Util.ticksToNow(l) + ", ret:" + bool + ", totally used " + Util.ticksToNow(c.c(this.rpG)) + "ms");
      c.d(this.rpG).quit();
      kotlin.g.a.a locala = this.ihE;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.c
 * JD-Core Version:    0.7.0.1
 */