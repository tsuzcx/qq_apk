package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.a.e;
import com.tencent.mm.f.b.g.a;
import com.tencent.mm.f.c.a;
import com.tencent.mm.modelvoiceaddr.a.c.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

final class g$2
  implements c.a
{
  byte[] eMc;
  
  g$2(g paramg) {}
  
  public final void TA()
  {
    y.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
    int i;
    if ((g.k(this.eMb) instanceof c)) {
      i = e.bJ(g.Tz());
    }
    try
    {
      ((c)g.k(this.eMb)).jA(i);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "cutShortSentence error", new Object[0]);
      this.eMb.bA(6, -1);
    }
  }
  
  public final void TB()
  {
    y.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
    if ((g.k(this.eMb) instanceof c)) {}
    try
    {
      h localh = ((c)g.k(this.eMb)).eLp;
      y.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
      localh.eMl.writeLock().lock();
      h.a locala = new h.a(localh);
      localh.eMk.put(locala.eMn, locala);
      localh.eMl.writeLock().unlock();
      if (!g.b(this.eMb).uF()) {
        this.eMb.bA(5, -1);
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "createShortSentence error", new Object[0]);
      this.eMb.bA(6, -1);
    }
  }
  
  public final void b(short[] paramArrayOfShort, int paramInt)
  {
    if (paramArrayOfShort == null) {
      return;
    }
    if ((this.eMc == null) || (this.eMc.length < paramInt * 2)) {
      this.eMc = new byte[paramInt * 2];
    }
    int i = 0;
    while (i < paramInt)
    {
      this.eMc[(i * 2)] = ((byte)(paramArrayOfShort[i] & 0xFF));
      this.eMc[(i * 2 + 1)] = ((byte)((paramArrayOfShort[i] & 0xFF00) >> 8));
      i += 1;
    }
    if (g.b(this.eMb) != null) {}
    for (paramInt = g.b(this.eMb).a(new g.a(this.eMc, paramInt * 2), 0, true);; paramInt = -1)
    {
      if (-1 == paramInt)
      {
        this.eMb.bA(4, -1);
        y.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
        return;
      }
      g.a(this.eMb, paramInt + g.h(this.eMb));
      if ((g.i(this.eMb)) || (g.h(this.eMb) <= 200) || (g.j(this.eMb))) {
        break;
      }
      com.tencent.mm.kernel.g.DS().O(new g.2.1(this));
      g.l(this.eMb);
      return;
    }
  }
  
  public final void tW()
  {
    y.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    this.eMb.stop(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g.2
 * JD-Core Version:    0.7.0.1
 */