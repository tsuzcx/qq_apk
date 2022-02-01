package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.plugin.gif.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", "encoder", "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"})
public final class c
{
  public static final c.a poC;
  private final String TAG;
  private final int height;
  private int poA;
  private final String poB;
  ao pox;
  private com.tencent.mm.plugin.gif.a poy;
  private long poz;
  private final int width;
  
  static
  {
    AppMethodBeat.i(269);
    poC = new c.a((byte)0);
    AppMethodBeat.o(269);
  }
  
  public c(String paramString, int paramInt1, int paramInt2, long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(268);
    this.poB = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiMixGifEncoder";
    this.poA = 30;
    this.pox = new ao("EmojiMixer_gifEncode");
    if (paramBoolean) {}
    for (paramString = (com.tencent.mm.plugin.gif.a)new g(this.poB, this.width, this.height, paramLong);; paramString = (com.tencent.mm.plugin.gif.a)new j(this.poB, this.width, this.height, paramLong))
    {
      this.poy = paramString;
      this.pox.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264);
          boolean bool = c.a(this.poD).init();
          ac.i(c.b(this.poD), "init encoder, outputGif: " + paramBoolean + " ret: " + bool);
          e locale;
          if (!bool)
          {
            if (!paramBoolean) {
              break label92;
            }
            locale = e.pny;
            e.cfj();
          }
          for (;;)
          {
            c.a(this.poD, bs.Gn());
            AppMethodBeat.o(264);
            return;
            label92:
            locale = e.pny;
            e.cfi();
          }
        }
      });
      AppMethodBeat.o(268);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(265);
      long l = bs.Gn();
      boolean bool = c.a(this.poD).c(this.gTq, this.poF);
      ac.i(c.b(this.poD), "encodeRgbaFrame used " + bs.aO(l) + ", ret:" + bool);
      AppMethodBeat.o(265);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(266);
      long l = bs.Gn();
      boolean bool = c.a(this.poD).cRQ();
      ac.i(c.b(this.poD), "finishEncode used " + bs.aO(l) + ", ret:" + bool + ", totally used " + bs.aO(c.c(this.poD)) + "ms");
      c.d(this.poD).quit();
      d.g.a.a locala = this.gTu;
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