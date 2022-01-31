package com.tencent.mm.plugin.emojicapture.model.b;

import android.os.HandlerThread;
import com.tencent.mm.plugin.gif.a;
import com.tencent.mm.plugin.gif.j;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  public static final d.a jkP = new d.a((byte)0);
  private final String TAG;
  private final int height;
  private HandlerThread jkJ;
  ah jkK;
  private a jkL;
  private long jkM;
  private int jkN;
  private final String jkO;
  private final int width;
  
  public d(String paramString, int paramInt1, int paramInt2, long paramLong, final boolean paramBoolean)
  {
    this.jkO = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiMixGifEncoder";
    paramString = e.aap("EmojiMixer_gifEncode");
    a.d.b.g.j(paramString, "ThreadPool.newFreeHandle…d(\"EmojiMixer_gifEncode\")");
    this.jkJ = paramString;
    this.jkN = 30;
    this.jkJ.start();
    this.jkK = new ah(this.jkJ.getLooper());
    if (paramBoolean) {}
    for (paramString = (a)new com.tencent.mm.plugin.gif.g(this.jkO, this.width, this.height, paramLong);; paramString = (a)new j(this.jkO, this.width, this.height, paramLong))
    {
      this.jkL = paramString;
      this.jkK.post((Runnable)new Runnable()
      {
        public final void run()
        {
          boolean bool = d.a(this.jkQ).init();
          y.i(d.b(this.jkQ), "init encoder, outputGif: " + paramBoolean + " ret: " + bool);
          d.a(this.jkQ, bk.UZ());
        }
      });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.d
 * JD-Core Version:    0.7.0.1
 */