package com.tencent.mm.plugin.emojicapture.model.c;

import a.d.b.g;
import android.os.HandlerThread;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.f.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.plugin.mmsight.model.a.n
{
  public final String TAG = "MicroMsg.EmojiCaptureMP4Recorder";
  private final HandlerThread jlH = e.aap("EmojiCaptureMP4Recorder_readDrawFrameThread");
  ah jlI;
  int[] jlJ = new int[0];
  public long jlK;
  public com.tencent.mm.plugin.emojicapture.ui.a.a jlL;
  
  public a(VideoTransPara paramVideoTransPara)
  {
    super(paramVideoTransPara);
    bjG();
    u(640, 640, 640, 640);
    if (!ua(0))
    {
      paramVideoTransPara = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      a.a.cG(10, 1);
    }
    this.jlH.start();
    paramVideoTransPara = this.jlH;
    g.j(paramVideoTransPara, "readDrawFrameThread");
    this.jlI = new ah(paramVideoTransPara.getLooper(), (ah.a)new a.1(this));
  }
  
  public final void a(a.d.a.a<a.n> parama)
  {
    g.k(parama, "stopCallback");
    y.i(this.TAG, "stop");
    com.tencent.mm.plugin.emojicapture.ui.a.a locala = this.jlL;
    if (locala != null) {
      locala.d(null);
    }
    this.jlH.quit();
    super.M((Runnable)new b(parama));
    y.i(this.TAG, "stop " + getFrameCount() + ' ' + bjn());
    parama = com.tencent.mm.plugin.emojicapture.f.a.jnW;
    a.a.cG(14, getFrameCount());
    parama = com.tencent.mm.plugin.emojicapture.f.a.jnW;
    a.a.cG(15, (int)this.jlK);
  }
  
  public final void cancel()
  {
    y.i(this.TAG, "cancel");
    super.cancel();
    com.tencent.mm.plugin.emojicapture.ui.a.a locala = this.jlL;
    if (locala != null) {
      locala.d(null);
    }
    this.jlH.quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.a
 * JD-Core Version:    0.7.0.1
 */