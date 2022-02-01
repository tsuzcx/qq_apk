package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.plugin.gif.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", "encoder", "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"})
public final class c
{
  public static final c.a pYI;
  private final String TAG;
  private final int height;
  aq pYD;
  private com.tencent.mm.plugin.gif.a pYE;
  private long pYF;
  private int pYG;
  private final String pYH;
  private final int width;
  
  static
  {
    AppMethodBeat.i(269);
    pYI = new c.a((byte)0);
    AppMethodBeat.o(269);
  }
  
  public c(String paramString, int paramInt1, int paramInt2, long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(268);
    this.pYH = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiMixGifEncoder";
    this.pYG = 30;
    this.pYD = new aq("EmojiMixer_gifEncode");
    if (paramBoolean) {}
    for (paramString = (com.tencent.mm.plugin.gif.a)new g(this.pYH, this.width, this.height, paramLong);; paramString = (com.tencent.mm.plugin.gif.a)new j(this.pYH, this.width, this.height, paramLong))
    {
      this.pYE = paramString;
      this.pYD.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264);
          boolean bool = c.a(this.pYJ).init();
          ae.i(c.b(this.pYJ), "init encoder, outputGif: " + paramBoolean + " ret: " + bool);
          e locale;
          if (!bool)
          {
            if (!paramBoolean) {
              break label92;
            }
            locale = e.pXD;
            e.clc();
          }
          for (;;)
          {
            c.a(this.pYJ, bu.HQ());
            AppMethodBeat.o(264);
            return;
            label92:
            locale = e.pXD;
            e.clb();
          }
        }
      });
      AppMethodBeat.o(268);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(265);
      long l = bu.HQ();
      boolean bool = c.a(this.pYJ).c(this.hog, this.pYL);
      ae.i(c.b(this.pYJ), "encodeRgbaFrame used " + bu.aO(l) + ", ret:" + bool);
      AppMethodBeat.o(265);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(266);
      long l = bu.HQ();
      boolean bool = c.a(this.pYJ).ddN();
      ae.i(c.b(this.pYJ), "finishEncode used " + bu.aO(l) + ", ret:" + bool + ", totally used " + bu.aO(c.c(this.pYJ)) + "ms");
      c.d(this.pYJ).quit();
      d.g.a.a locala = this.hok;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.c
 * JD-Core Version:    0.7.0.1
 */