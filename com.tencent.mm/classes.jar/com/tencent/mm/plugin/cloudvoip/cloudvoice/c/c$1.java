package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements c.a
{
  c$1(c paramc) {}
  
  public final void aU(int paramInt1, int paramInt2) {}
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = 0;
    for (;;)
    {
      synchronized (c.i(this.iEE))
      {
        if (c.a(this.iEE) == 2)
        {
          if (c.b(this.iEE).iEF == null) {
            break label309;
          }
          paramInt = 1;
          break label309;
        }
        return;
        if (c.c(this.iEE) <= 10) {
          c.a(this.iEE, 92);
        }
        paramInt = c.b(this.iEE).iEF.bPE();
        c.a(this.iEE, (paramInt + 24 + c.c(this.iEE) * 3) / 4);
        if (c.d(this.iEE) == 1)
        {
          int i = c.b(this.iEE).iEF.bPB();
          paramInt = i;
          if (i >= c.c(this.iEE)) {
            paramInt = i - c.c(this.iEE);
          }
          c.a(this.iEE, paramInt);
          c.e(this.iEE);
          if (1 != c.f(this.iEE)) {
            break label248;
          }
          c.g(this.iEE);
          c.a(this.iEE, System.currentTimeMillis());
          y.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,first record");
          j localj = j.iFl;
          j.q(paramArrayOfByte, paramArrayOfByte.length, c.c(this.iEE));
        }
      }
      c.a(this.iEE, 0);
      continue;
      label248:
      long l1 = System.currentTimeMillis();
      long l2 = l1 - c.h(this.iEE);
      if (l2 > 1000L) {
        y.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:" + l2);
      }
      c.a(this.iEE, l1);
      continue;
      label309:
      if (paramInt != 0) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c.1
 * JD-Core Version:    0.7.0.1
 */