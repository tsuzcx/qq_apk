package com.tencent.mm.f.a;

import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$4$1
  implements Runnable
{
  a$4$1(a.4 param4) {}
  
  public final void run()
  {
    try
    {
      if (q.dye.duW == 1) {
        Thread.sleep(300L);
      }
      y.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[] { a.i(this.bBK.bBH), Boolean.valueOf(a.j(this.bBK.bBH)) });
      ai.d(new a.4.1.1(this));
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.a.4.1
 * JD-Core Version:    0.7.0.1
 */