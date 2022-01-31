package com.tencent.mm.f.a;

import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements b.a
{
  a$1(a parama) {}
  
  public final void ex(int paramInt)
  {
    y.i("MicroMsg.SceneVoicePlayer", "on audio focus chage: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == -2) || (paramInt == -3)) {
      if (this.bBH.isPlaying())
      {
        y.v("MicroMsg.SceneVoicePlayer", "alvinluo current fileName: %s, lastFileName: %s", new Object[] { a.a(this.bBH), a.access$100() });
        if ((a.a(this.bBH) == null) || (a.a(this.bBH).equals(a.access$100()))) {
          this.bBH.aU(false);
        }
      }
    }
    do
    {
      return;
      if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3))
      {
        this.bBH.ub();
        return;
      }
    } while (paramInt != -1);
    this.bBH.stop(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.a.a.1
 * JD-Core Version:    0.7.0.1
 */