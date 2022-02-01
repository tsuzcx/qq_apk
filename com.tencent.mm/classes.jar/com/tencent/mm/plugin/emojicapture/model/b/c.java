package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.plugin.gif.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", "encoder", "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"})
public final class c
{
  public static final a oLi;
  private final String TAG;
  private final int height;
  ap oLd;
  private com.tencent.mm.plugin.gif.a oLe;
  private long oLf;
  private int oLg;
  private final String oLh;
  private final int width;
  
  static
  {
    AppMethodBeat.i(269);
    oLi = new a((byte)0);
    AppMethodBeat.o(269);
  }
  
  public c(String paramString, int paramInt1, int paramInt2, long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(268);
    this.oLh = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiMixGifEncoder";
    this.oLg = 30;
    this.oLd = new ap("EmojiMixer_gifEncode");
    if (paramBoolean) {}
    for (paramString = (com.tencent.mm.plugin.gif.a)new g(this.oLh, this.width, this.height, paramLong);; paramString = (com.tencent.mm.plugin.gif.a)new j(this.oLh, this.width, this.height, paramLong))
    {
      this.oLe = paramString;
      this.oLd.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264);
          boolean bool = c.a(this.oLj).init();
          ad.i(c.b(this.oLj), "init encoder, outputGif: " + paramBoolean + " ret: " + bool);
          e locale;
          if (!bool)
          {
            if (!paramBoolean) {
              break label92;
            }
            locale = e.oKa;
            e.bXW();
          }
          for (;;)
          {
            c.a(this.oLj, bt.GC());
            AppMethodBeat.o(264);
            return;
            label92:
            locale = e.oKa;
            e.bXV();
          }
        }
      });
      AppMethodBeat.o(268);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder$Companion;", "", "()V", "EMOJI_MIX_WXAM_QP", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(265);
      long l = bt.GC();
      boolean bool = c.a(this.oLj).c(this.gsJ, this.oLl);
      ad.i(c.b(this.oLj), "encodeRgbaFrame used " + bt.aS(l) + ", ret:" + bool);
      AppMethodBeat.o(265);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(266);
      long l = bt.GC();
      boolean bool = c.a(this.oLj).cEG();
      ad.i(c.b(this.oLj), "finishEncode used " + bt.aS(l) + ", ret:" + bool + ", totally used " + bt.aS(c.c(this.oLj)) + "ms");
      c.d(this.oLj).quit();
      d.g.a.a locala = this.jQC;
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