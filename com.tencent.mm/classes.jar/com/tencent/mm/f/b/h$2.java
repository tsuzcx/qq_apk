package com.tencent.mm.f.b;

import com.tencent.mm.sdk.platformtools.y;

final class h$2
  implements Runnable
{
  h$2(h paramh) {}
  
  public final void run()
  {
    if (!h.k(this.bDP))
    {
      y.d("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
      h.l(this.bDP);
      return;
    }
    y.e("MicroMsg.SceneVoice.Recorder", "mHasBeginRec is true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.h.2
 * JD-Core Version:    0.7.0.1
 */