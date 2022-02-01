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
  private int apW;
  private av cjg;
  private int fq;
  
  public d(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    super(parama, parama1, paramb);
    AppMethodBeat.i(123229);
    this.fq = 0;
    this.apW = parama.bZo();
    AppMethodBeat.o(123229);
  }
  
  private void BJ()
  {
    AppMethodBeat.i(123232);
    if (bZl())
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.oRN.bZo();
      localMsgFile.filePath = "only for test";
      localMsgFile.fileName = (this.oRN.getFileName() + "." + localMsgFile.fVf);
      localMsgFile.type = "file";
      localMsgFile.fVf = this.oRN.bZn();
      localMsgFile.timeStamp = this.oRN.getTimeStamp();
      b(localMsgFile);
      AppMethodBeat.o(123232);
      return;
    }
    bZj();
    AppMethodBeat.o(123232);
  }
  
  private boolean bZk()
  {
    if ((this.oRN instanceof j)) {
      return ((j)this.oRN).oSl;
    }
    if ((this.oRN instanceof e)) {
      return ((e)this.oRN).oSl;
    }
    return false;
  }
  
  private boolean bZl()
  {
    if ((this.oRN instanceof j)) {
      return ((j)this.oRN).oSn;
    }
    if ((this.oRN instanceof e)) {
      return ((e)this.oRN).oSn;
    }
    return false;
  }
  
  protected final boolean bZh()
  {
    AppMethodBeat.i(123230);
    if (bZk()) {
      BJ();
    }
    boolean bool = bZk();
    AppMethodBeat.o(123230);
    return bool;
  }
  
  protected final void btu()
  {
    AppMethodBeat.i(123231);
    boolean bool;
    av localav;
    long l;
    if ((this.oRN instanceof j))
    {
      bool = ((j)this.oRN).oSm;
      if (!bool) {
        break label166;
      }
      if (this.cjg == null) {
        this.cjg = new av(g.ajF().IdO.getLooper(), new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(123228);
            d.a(d.this, d.a(d.this) + 1048576);
            if (d.a(d.this) > d.b(d.this)) {
              d.a(d.this, d.b(d.this));
            }
            d.this.eX(d.a(d.this), d.b(d.this));
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
      localav = this.cjg;
      if (!(this.oRN instanceof j)) {
        break label135;
      }
      l = ((j)this.oRN).oSo;
    }
    for (;;)
    {
      localav.az(l, l);
      AppMethodBeat.o(123231);
      return;
      if ((this.oRN instanceof e))
      {
        bool = ((e)this.oRN).oSm;
        break;
      }
      bool = false;
      break;
      label135:
      if ((this.oRN instanceof e)) {
        l = ((e)this.oRN).oSo;
      } else {
        l = 1000L;
      }
    }
    label166:
    BJ();
    AppMethodBeat.o(123231);
  }
  
  protected final boolean checkValid()
  {
    if ((this.oRN instanceof j)) {
      return ((j)this.oRN).oSk;
    }
    if ((this.oRN instanceof e)) {
      return ((e)this.oRN).oSk;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.d
 * JD-Core Version:    0.7.0.1
 */