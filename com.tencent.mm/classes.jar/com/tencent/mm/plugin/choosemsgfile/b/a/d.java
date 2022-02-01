package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.e;
import com.tencent.mm.plugin.choosemsgfile.b.b.j;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.vending.e.b;

public final class d
  extends c
{
  private int aqi;
  private MTimerHandler cve;
  private int fs;
  
  public d(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    super(parama, parama1, paramb);
    AppMethodBeat.i(123229);
    this.fs = 0;
    this.aqi = parama.cyt();
    AppMethodBeat.o(123229);
  }
  
  private void callback()
  {
    AppMethodBeat.i(123232);
    if (cyr())
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.qno.cyt();
      localMsgFile.filePath = "only for test";
      localMsgFile.fileName = (this.qno.getFileName() + "." + localMsgFile.gCr);
      localMsgFile.type = "file";
      localMsgFile.gCr = this.qno.getFileExt();
      localMsgFile.timeStamp = this.qno.getTimeStamp();
      b(localMsgFile);
      AppMethodBeat.o(123232);
      return;
    }
    cyp();
    AppMethodBeat.o(123232);
  }
  
  private boolean cyq()
  {
    if ((this.qno instanceof j)) {
      return ((j)this.qno).qnM;
    }
    if ((this.qno instanceof e)) {
      return ((e)this.qno).qnM;
    }
    return false;
  }
  
  private boolean cyr()
  {
    if ((this.qno instanceof j)) {
      return ((j)this.qno).qnO;
    }
    if ((this.qno instanceof e)) {
      return ((e)this.qno).qnO;
    }
    return false;
  }
  
  protected final void bPM()
  {
    AppMethodBeat.i(123231);
    boolean bool;
    MTimerHandler localMTimerHandler;
    long l;
    if ((this.qno instanceof j))
    {
      bool = ((j)this.qno).qnN;
      if (!bool) {
        break label162;
      }
      if (this.cve == null) {
        this.cve = new MTimerHandler(g.aAk().getLooper(), new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(123228);
            d.a(d.this, d.a(d.this) + 1048576);
            if (d.a(d.this) > d.b(d.this)) {
              d.a(d.this, d.b(d.this));
            }
            d.this.fl(d.a(d.this), d.b(d.this));
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
      localMTimerHandler = this.cve;
      if (!(this.qno instanceof j)) {
        break label131;
      }
      l = ((j)this.qno).qnP;
    }
    for (;;)
    {
      localMTimerHandler.startTimer(l);
      AppMethodBeat.o(123231);
      return;
      if ((this.qno instanceof e))
      {
        bool = ((e)this.qno).qnN;
        break;
      }
      bool = false;
      break;
      label131:
      if ((this.qno instanceof e)) {
        l = ((e)this.qno).qnP;
      } else {
        l = 1000L;
      }
    }
    label162:
    callback();
    AppMethodBeat.o(123231);
  }
  
  protected final boolean checkValid()
  {
    if ((this.qno instanceof j)) {
      return ((j)this.qno).qnL;
    }
    if ((this.qno instanceof e)) {
      return ((e)this.qno).qnL;
    }
    return false;
  }
  
  protected final boolean cyn()
  {
    AppMethodBeat.i(123230);
    if (cyq()) {
      callback();
    }
    boolean bool = cyq();
    AppMethodBeat.o(123230);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.d
 * JD-Core Version:    0.7.0.1
 */