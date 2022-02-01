package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.e;
import com.tencent.mm.plugin.choosemsgfile.b.b.j;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.vending.e.b;

public final class d
  extends c
{
  private int MW;
  private int aoe;
  private au bYO;
  
  public d(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    super(parama, parama1, paramb);
    AppMethodBeat.i(123229);
    this.MW = 0;
    this.aoe = parama.bUJ();
    AppMethodBeat.o(123229);
  }
  
  private void Am()
  {
    AppMethodBeat.i(123232);
    if (bUG())
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.oos.bUJ();
      localMsgFile.filePath = "only for test";
      localMsgFile.fileName = (this.oos.getFileName() + "." + localMsgFile.fBR);
      localMsgFile.type = "file";
      localMsgFile.fBR = this.oos.bUI();
      localMsgFile.timeStamp = this.oos.getTimeStamp();
      b(localMsgFile);
      AppMethodBeat.o(123232);
      return;
    }
    bUE();
    AppMethodBeat.o(123232);
  }
  
  private boolean bUF()
  {
    if ((this.oos instanceof j)) {
      return ((j)this.oos).ooQ;
    }
    if ((this.oos instanceof e)) {
      return ((e)this.oos).ooQ;
    }
    return false;
  }
  
  private boolean bUG()
  {
    if ((this.oos instanceof j)) {
      return ((j)this.oos).ooS;
    }
    if ((this.oos instanceof e)) {
      return ((e)this.oos).ooS;
    }
    return false;
  }
  
  protected final boolean bUC()
  {
    AppMethodBeat.i(123230);
    if (bUF()) {
      Am();
    }
    boolean bool = bUF();
    AppMethodBeat.o(123230);
    return bool;
  }
  
  protected final void bpv()
  {
    AppMethodBeat.i(123231);
    boolean bool;
    au localau;
    long l;
    if ((this.oos instanceof j))
    {
      bool = ((j)this.oos).ooR;
      if (!bool) {
        break label166;
      }
      if (this.bYO == null) {
        this.bYO = new au(g.agU().GrZ.getLooper(), new au.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(123228);
            d.a(d.this, d.a(d.this) + 1048576);
            if (d.a(d.this) > d.b(d.this)) {
              d.a(d.this, d.b(d.this));
            }
            d.this.eT(d.a(d.this), d.b(d.this));
            if (d.a(d.this) == d.b(d.this))
            {
              d.c(d.this);
              d.d(d.this).stopTimer();
              d.e(d.this);
            }
            AppMethodBeat.o(123228);
            return true;
          }
        }, true);
      }
      localau = this.bYO;
      if (!(this.oos instanceof j)) {
        break label135;
      }
      l = ((j)this.oos).ooT;
    }
    for (;;)
    {
      localau.au(l, l);
      AppMethodBeat.o(123231);
      return;
      if ((this.oos instanceof e))
      {
        bool = ((e)this.oos).ooR;
        break;
      }
      bool = false;
      break;
      label135:
      if ((this.oos instanceof e)) {
        l = ((e)this.oos).ooT;
      } else {
        l = 1000L;
      }
    }
    label166:
    Am();
    AppMethodBeat.o(123231);
  }
  
  protected final boolean checkValid()
  {
    if ((this.oos instanceof j)) {
      return ((j)this.oos).ooP;
    }
    if ((this.oos instanceof e)) {
      return ((e)this.oos).ooP;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.d
 * JD-Core Version:    0.7.0.1
 */