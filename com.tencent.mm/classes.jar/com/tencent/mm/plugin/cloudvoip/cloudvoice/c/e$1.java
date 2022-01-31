package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  implements c.a
{
  e$1(e parame) {}
  
  public final void bS(int paramInt1, int paramInt2) {}
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    int i = -1;
    int j = 0;
    AppMethodBeat.i(135468);
    for (;;)
    {
      synchronized (e.k(this.kJQ))
      {
        if (e.a(this.kJQ) % 50 == 0)
        {
          e.b(this.kJQ);
          ab.v("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
        }
        if (e.c(this.kJQ) == 2)
        {
          paramInt = j;
          if (e.d(this.kJQ).kJR == null) {
            break label401;
          }
          paramInt = 1;
          break label401;
        }
        AppMethodBeat.o(135468);
        return;
        if (e.e(this.kJQ) <= 10) {
          e.a(this.kJQ, 92);
        }
        Object localObject2 = e.d(this.kJQ);
        if (((f)localObject2).kJR != null)
        {
          paramInt = ((f)localObject2).kJR.cLI();
          e.a(this.kJQ, (paramInt + 24 + e.e(this.kJQ) * 3) / 4);
          if (e.f(this.kJQ) != 1) {
            break label335;
          }
          localObject2 = e.d(this.kJQ);
          paramInt = i;
          if (((f)localObject2).kJR != null) {
            paramInt = ((f)localObject2).kJR.cLF();
          }
          i = paramInt;
          if (paramInt >= e.e(this.kJQ)) {
            i = paramInt - e.e(this.kJQ);
          }
          e.a(this.kJQ, i);
          e.g(this.kJQ);
          if (1 != e.h(this.kJQ)) {
            break label347;
          }
          e.i(this.kJQ);
          e.a(this.kJQ, System.currentTimeMillis());
          ab.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,first record");
          localObject2 = o.kKN;
          o.u(paramArrayOfByte, paramArrayOfByte.length, e.e(this.kJQ));
        }
      }
      paramInt = -1;
      continue;
      label335:
      e.a(this.kJQ, 0);
      continue;
      label347:
      long l1 = System.currentTimeMillis();
      long l2 = l1 - e.j(this.kJQ);
      if (l2 > 1000L) {
        ab.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
      }
      e.a(this.kJQ, l1);
      continue;
      label401:
      if (paramInt != 0) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.e.1
 * JD-Core Version:    0.7.0.1
 */