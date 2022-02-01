package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.e;
import com.tencent.mm.plugin.choosemsgfile.b.b.j;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.vending.e.b;

public final class d
  extends c
{
  private int apW;
  private aw cji;
  private int fq;
  
  public d(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    super(parama, parama1, paramb);
    AppMethodBeat.i(123229);
    this.fq = 0;
    this.apW = parama.caD();
    AppMethodBeat.o(123229);
  }
  
  private void BK()
  {
    AppMethodBeat.i(123232);
    if (caA())
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.oYp.caD();
      localMsgFile.filePath = "only for test";
      localMsgFile.fileName = (this.oYp.getFileName() + "." + localMsgFile.fXl);
      localMsgFile.type = "file";
      localMsgFile.fXl = this.oYp.caC();
      localMsgFile.timeStamp = this.oYp.getTimeStamp();
      b(localMsgFile);
      AppMethodBeat.o(123232);
      return;
    }
    cay();
    AppMethodBeat.o(123232);
  }
  
  private boolean caA()
  {
    if ((this.oYp instanceof j)) {
      return ((j)this.oYp).oYP;
    }
    if ((this.oYp instanceof e)) {
      return ((e)this.oYp).oYP;
    }
    return false;
  }
  
  private boolean caz()
  {
    if ((this.oYp instanceof j)) {
      return ((j)this.oYp).oYN;
    }
    if ((this.oYp instanceof e)) {
      return ((e)this.oYp).oYN;
    }
    return false;
  }
  
  protected final void buf()
  {
    AppMethodBeat.i(123231);
    boolean bool;
    aw localaw;
    long l;
    if ((this.oYp instanceof j))
    {
      bool = ((j)this.oYp).oYO;
      if (!bool) {
        break label166;
      }
      if (this.cji == null) {
        this.cji = new aw(g.ajU().IxZ.getLooper(), new aw.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(123228);
            d.a(d.this, d.a(d.this) + 1048576);
            if (d.a(d.this) > d.b(d.this)) {
              d.a(d.this, d.b(d.this));
            }
            d.this.eY(d.a(d.this), d.b(d.this));
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
      localaw = this.cji;
      if (!(this.oYp instanceof j)) {
        break label135;
      }
      l = ((j)this.oYp).oYQ;
    }
    for (;;)
    {
      localaw.ay(l, l);
      AppMethodBeat.o(123231);
      return;
      if ((this.oYp instanceof e))
      {
        bool = ((e)this.oYp).oYO;
        break;
      }
      bool = false;
      break;
      label135:
      if ((this.oYp instanceof e)) {
        l = ((e)this.oYp).oYQ;
      } else {
        l = 1000L;
      }
    }
    label166:
    BK();
    AppMethodBeat.o(123231);
  }
  
  protected final boolean caw()
  {
    AppMethodBeat.i(123230);
    if (caz()) {
      BK();
    }
    boolean bool = caz();
    AppMethodBeat.o(123230);
    return bool;
  }
  
  protected final boolean checkValid()
  {
    if ((this.oYp instanceof j)) {
      return ((j)this.oYp).oYM;
    }
    if ((this.oYp instanceof e)) {
      return ((e)this.oYp).oYM;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.d
 * JD-Core Version:    0.7.0.1
 */