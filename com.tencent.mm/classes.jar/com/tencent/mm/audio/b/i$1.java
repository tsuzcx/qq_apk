package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Map;

final class i$1
  implements Runnable
{
  i$1(i parami, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(116517);
    i.EU();
    String str;
    int i;
    if (this.ckS.getType() == 128)
    {
      i.a(this.ckT);
      str = ((e)this.ckS).fileName;
      i = ((e)this.ckS).retCode;
      long l2 = 0L;
      long l1 = l2;
      if (str != null)
      {
        l1 = l2;
        if (this.ckT.ckJ.get(str) != null)
        {
          l1 = ((g.a)this.ckT.ckJ.get(str)).Mm();
          this.ckT.ckJ.remove(str);
        }
      }
      ab.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + this.ckS.getType() + " errtype:" + this.val$errType + " errCode:" + this.val$errCode + " retCode:" + i + " file:" + str + " time:" + l1);
      if ((this.val$errType != 3) || (i == 0)) {
        break label412;
      }
      i.c(this.ckT);
      label219:
      ab.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.access$000() + " stop:" + i.d(this.ckT) + " running:" + i.e(this.ckT) + " recving:" + i.f(this.ckT) + " sending:" + i.g(this.ckT));
      if (i.d(this.ckT) <= 0) {
        break label431;
      }
      i.h(this.ckT);
    }
    for (;;)
    {
      i.EV();
      AppMethodBeat.o(116517);
      return;
      if (this.ckS.getType() == 127)
      {
        i.b(this.ckT);
        str = ((f)this.ckS).fileName;
        i = ((f)this.ckS).retCode;
        break;
      }
      ab.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + this.ckS.getType());
      i.EV();
      AppMethodBeat.o(116517);
      return;
      label412:
      if (this.val$errType == 0) {
        break label219;
      }
      i.a(this.ckT, 0);
      break label219;
      label431:
      if ((!i.g(this.ckT)) && (!i.f(this.ckT)))
      {
        i.i(this.ckT);
        ab.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[] { Integer.valueOf(this.val$errType), Integer.valueOf(i), Boolean.valueOf(i.ckP) });
        if ((i.ckP) && (this.val$errType == 4)) {
          g.RO().o(new i.1.1(this), 10000L);
        }
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(116518);
    String str = super.toString() + "|onSceneEnd";
    AppMethodBeat.o(116518);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.b.i.1
 * JD-Core Version:    0.7.0.1
 */