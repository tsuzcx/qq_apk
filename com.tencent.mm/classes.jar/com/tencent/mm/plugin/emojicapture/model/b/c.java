package com.tencent.mm.plugin.emojicapture.model.b;

import a.l;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.a;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixGifEncoder;", "", "outputPath", "", "width", "", "height", "frameDurationMs", "", "outputGif", "", "(Ljava/lang/String;IIJZ)V", "TAG", "encoder", "Lcom/tencent/mm/plugin/gif/IAnimFileEncoder;", "gifEncodeThread", "Landroid/os/HandlerThread;", "gifEncoderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "saveRgbFrameCount", "startEncodeTick", "encodeFrame", "", "data", "", "finishEncode", "callback", "Lkotlin/Function0;", "Companion", "plugin-emojicapture_release"})
public final class c
{
  public static final c.a luq;
  private final String TAG;
  private final int height;
  private HandlerThread luk;
  ak lul;
  private a lum;
  private long lun;
  private int luo;
  private final String lup;
  private final int width;
  
  static
  {
    AppMethodBeat.i(2669);
    luq = new c.a((byte)0);
    AppMethodBeat.o(2669);
  }
  
  public c(String paramString, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(2668);
    this.lup = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiMixGifEncoder";
    paramString = d.aqu("EmojiMixer_gifEncode");
    a.f.b.j.p(paramString, "ThreadPool.newFreeHandle…d(\"EmojiMixer_gifEncode\")");
    this.luk = paramString;
    this.luo = 30;
    this.luk.start();
    this.lul = new ak(this.luk.getLooper());
    if (paramBoolean) {}
    for (paramString = (a)new g(this.lup, this.width, this.height, paramLong);; paramString = (a)new com.tencent.mm.plugin.gif.j(this.lup, this.width, this.height, paramLong))
    {
      this.lum = paramString;
      this.lul.post((Runnable)new c.1(this, paramBoolean));
      AppMethodBeat.o(2668);
      return;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(2665);
      long l = bo.yB();
      boolean bool = c.a(this.lur).c(this.eWq, this.lut);
      ab.i(c.b(this.lur), "encodeRgbaFrame used " + bo.av(l) + ", ret:" + bool);
      AppMethodBeat.o(2665);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.c
 * JD-Core Version:    0.7.0.1
 */