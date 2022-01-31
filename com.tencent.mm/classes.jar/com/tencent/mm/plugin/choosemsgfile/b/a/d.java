package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.e;
import com.tencent.mm.plugin.choosemsgfile.b.b.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.vending.e.b;

public final class d
  extends c
{
  private int Fb;
  private int agc;
  private ap bAz;
  
  public d(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    super(parama, parama1, paramb);
    AppMethodBeat.i(54257);
    this.Fb = 0;
    this.agc = parama.bgn();
    AppMethodBeat.o(54257);
  }
  
  private boolean bgj()
  {
    if ((this.kEs instanceof j)) {
      return ((j)this.kEs).kEP;
    }
    if ((this.kEs instanceof e)) {
      return ((e)this.kEs).kEP;
    }
    return false;
  }
  
  private boolean bgk()
  {
    if ((this.kEs instanceof j)) {
      return ((j)this.kEs).kER;
    }
    if ((this.kEs instanceof e)) {
      return ((e)this.kEs).kER;
    }
    return false;
  }
  
  private void tU()
  {
    AppMethodBeat.i(54260);
    if (bgk())
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.kEs.bgn();
      localMsgFile.filePath = "only for test";
      localMsgFile.fileName = (this.kEs.getFileName() + "." + localMsgFile.elt);
      localMsgFile.type = "file";
      localMsgFile.elt = this.kEs.bgm();
      localMsgFile.timeStamp = this.kEs.getTimeStamp();
      b(localMsgFile);
      AppMethodBeat.o(54260);
      return;
    }
    bgi();
    AppMethodBeat.o(54260);
  }
  
  protected final boolean bgf()
  {
    AppMethodBeat.i(54258);
    if (bgj()) {
      tU();
    }
    boolean bool = bgj();
    AppMethodBeat.o(54258);
    return bool;
  }
  
  protected final void bgg()
  {
    AppMethodBeat.i(54259);
    boolean bool;
    ap localap;
    long l;
    if ((this.kEs instanceof j))
    {
      bool = ((j)this.kEs).kEQ;
      if (!bool) {
        break label166;
      }
      if (this.bAz == null) {
        this.bAz = new ap(g.RO().oNc.getLooper(), new ap.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(54256);
            d.a(d.this, d.a(d.this) + 1048576);
            if (d.a(d.this) > d.b(d.this)) {
              d.a(d.this, d.b(d.this));
            }
            d.this.dU(d.a(d.this), d.b(d.this));
            if (d.a(d.this) == d.b(d.this))
            {
              d.c(d.this);
              d.d(d.this).stopTimer();
              d.e(d.this);
            }
            AppMethodBeat.o(54256);
            return true;
          }
        }, true);
      }
      localap = this.bAz;
      if (!(this.kEs instanceof j)) {
        break label135;
      }
      l = ((j)this.kEs).kES;
    }
    for (;;)
    {
      localap.ag(l, l);
      AppMethodBeat.o(54259);
      return;
      if ((this.kEs instanceof e))
      {
        bool = ((e)this.kEs).kEQ;
        break;
      }
      bool = false;
      break;
      label135:
      if ((this.kEs instanceof e)) {
        l = ((e)this.kEs).kES;
      } else {
        l = 1000L;
      }
    }
    label166:
    tU();
    AppMethodBeat.o(54259);
  }
  
  protected final boolean checkValid()
  {
    if ((this.kEs instanceof j)) {
      return ((j)this.kEs).kEO;
    }
    if ((this.kEs instanceof e)) {
      return ((e)this.kEs).kEO;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.d
 * JD-Core Version:    0.7.0.1
 */