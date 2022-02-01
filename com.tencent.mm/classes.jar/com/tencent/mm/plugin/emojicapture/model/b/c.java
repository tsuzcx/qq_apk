package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.plugin.gif.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", "encoder", "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"})
public final class c
{
  public static final c.a pSd;
  private final String TAG;
  private final int height;
  ap pRY;
  private com.tencent.mm.plugin.gif.a pRZ;
  private long pSa;
  private int pSb;
  private final String pSc;
  private final int width;
  
  static
  {
    AppMethodBeat.i(269);
    pSd = new c.a((byte)0);
    AppMethodBeat.o(269);
  }
  
  public c(String paramString, int paramInt1, int paramInt2, long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(268);
    this.pSc = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiMixGifEncoder";
    this.pSb = 30;
    this.pRY = new ap("EmojiMixer_gifEncode");
    if (paramBoolean) {}
    for (paramString = (com.tencent.mm.plugin.gif.a)new g(this.pSc, this.width, this.height, paramLong);; paramString = (com.tencent.mm.plugin.gif.a)new j(this.pSc, this.width, this.height, paramLong))
    {
      this.pRZ = paramString;
      this.pRY.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264);
          boolean bool = c.a(this.pSe).init();
          ad.i(c.b(this.pSe), "init encoder, outputGif: " + paramBoolean + " ret: " + bool);
          e locale;
          if (!bool)
          {
            if (!paramBoolean) {
              break label92;
            }
            locale = e.pQY;
            e.cjM();
          }
          for (;;)
          {
            c.a(this.pSe, bt.HI());
            AppMethodBeat.o(264);
            return;
            label92:
            locale = e.pQY;
            e.cjL();
          }
        }
      });
      AppMethodBeat.o(268);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(265);
      long l = bt.HI();
      boolean bool = c.a(this.pSe).c(this.hlr, this.pSg);
      ad.i(c.b(this.pSe), "encodeRgbaFrame used " + bt.aO(l) + ", ret:" + bool);
      AppMethodBeat.o(265);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(266);
      long l = bt.HI();
      boolean bool = c.a(this.pSe).daW();
      ad.i(c.b(this.pSe), "finishEncode used " + bt.aO(l) + ", ret:" + bool + ", totally used " + bt.aO(c.c(this.pSe)) + "ms");
      c.d(this.pSe).quit();
      d.g.a.a locala = this.hlv;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.c
 * JD-Core Version:    0.7.0.1
 */