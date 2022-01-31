package com.tencent.mm.f.b;

import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class i$1
  implements Runnable
{
  i$1(i parami, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    i.uC();
    String str;
    int i;
    if (this.bEe.getType() == 128)
    {
      i.a(this.bEh);
      str = ((e)this.bEe).fileName;
      i = ((e)this.bEe).retCode;
      long l2 = 0L;
      long l1 = l2;
      if (str != null)
      {
        l1 = l2;
        if (this.bEh.bDU.get(str) != null)
        {
          l1 = ((g.a)this.bEh.bDU.get(str)).zJ();
          this.bEh.bDU.remove(str);
        }
      }
      y.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + this.bEe.getType() + " errtype:" + this.bEf + " errCode:" + this.bEg + " retCode:" + i + " file:" + str + " time:" + l1);
      if ((this.bEf != 3) || (i == 0)) {
        break label397;
      }
      i.c(this.bEh);
      label214:
      y.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.access$000() + " stop:" + i.d(this.bEh) + " running:" + i.e(this.bEh) + " recving:" + i.f(this.bEh) + " sending:" + i.g(this.bEh));
      if (i.d(this.bEh) <= 0) {
        break label416;
      }
      i.h(this.bEh);
    }
    for (;;)
    {
      i.uD();
      return;
      if (this.bEe.getType() == 127)
      {
        i.b(this.bEh);
        str = ((f)this.bEe).fileName;
        i = ((f)this.bEe).retCode;
        break;
      }
      y.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + this.bEe.getType());
      i.uD();
      return;
      label397:
      if (this.bEf == 0) {
        break label214;
      }
      i.a(this.bEh, 0);
      break label214;
      label416:
      if ((!i.g(this.bEh)) && (!i.f(this.bEh)))
      {
        i.i(this.bEh);
        y.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[] { Integer.valueOf(this.bEf), Integer.valueOf(i), Boolean.valueOf(i.bEb) });
        if ((i.bEb) && (this.bEf == 4)) {
          g.DS().k(new i.1.1(this), 10000L);
        }
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|onSceneEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.i.1
 * JD-Core Version:    0.7.0.1
 */