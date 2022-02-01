package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.e;
import com.tencent.mm.plugin.choosemsgfile.b.b.j;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.vending.e.b;

public final class d
  extends c
{
  private int LZ;
  private int anj;
  private av cbR;
  
  public d(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    super(parama, parama1, paramb);
    AppMethodBeat.i(123229);
    this.LZ = 0;
    this.anj = parama.bNy();
    AppMethodBeat.o(123229);
  }
  
  private void AI()
  {
    AppMethodBeat.i(123232);
    if (bNv())
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.nLs.bNy();
      localMsgFile.filePath = "only for test";
      localMsgFile.fileName = (this.nLs.getFileName() + "." + localMsgFile.fyk);
      localMsgFile.type = "file";
      localMsgFile.fyk = this.nLs.bNx();
      localMsgFile.timeStamp = this.nLs.getTimeStamp();
      b(localMsgFile);
      AppMethodBeat.o(123232);
      return;
    }
    bNt();
    AppMethodBeat.o(123232);
  }
  
  private boolean bNu()
  {
    if ((this.nLs instanceof j)) {
      return ((j)this.nLs).nLQ;
    }
    if ((this.nLs instanceof e)) {
      return ((e)this.nLs).nLQ;
    }
    return false;
  }
  
  private boolean bNv()
  {
    if ((this.nLs instanceof j)) {
      return ((j)this.nLs).nLS;
    }
    if ((this.nLs instanceof e)) {
      return ((e)this.nLs).nLS;
    }
    return false;
  }
  
  protected final boolean bNr()
  {
    AppMethodBeat.i(123230);
    if (bNu()) {
      AI();
    }
    boolean bool = bNu();
    AppMethodBeat.o(123230);
    return bool;
  }
  
  protected final void biB()
  {
    AppMethodBeat.i(123231);
    boolean bool;
    av localav;
    long l;
    if ((this.nLs instanceof j))
    {
      bool = ((j)this.nLs).nLR;
      if (!bool) {
        break label166;
      }
      if (this.cbR == null) {
        this.cbR = new av(g.afE().EUN.getLooper(), new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(123228);
            d.a(d.this, d.a(d.this) + 1048576);
            if (d.a(d.this) > d.b(d.this)) {
              d.a(d.this, d.b(d.this));
            }
            d.this.eQ(d.a(d.this), d.b(d.this));
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
      localav = this.cbR;
      if (!(this.nLs instanceof j)) {
        break label135;
      }
      l = ((j)this.nLs).nLT;
    }
    for (;;)
    {
      localav.av(l, l);
      AppMethodBeat.o(123231);
      return;
      if ((this.nLs instanceof e))
      {
        bool = ((e)this.nLs).nLR;
        break;
      }
      bool = false;
      break;
      label135:
      if ((this.nLs instanceof e)) {
        l = ((e)this.nLs).nLT;
      } else {
        l = 1000L;
      }
    }
    label166:
    AI();
    AppMethodBeat.o(123231);
  }
  
  protected final boolean checkValid()
  {
    if ((this.nLs instanceof j)) {
      return ((j)this.nLs).nLP;
    }
    if ((this.nLs instanceof e)) {
      return ((e)this.nLs).nLP;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.d
 * JD-Core Version:    0.7.0.1
 */