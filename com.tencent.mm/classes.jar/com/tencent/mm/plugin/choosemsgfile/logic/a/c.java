package com.tencent.mm.plugin.choosemsgfile.logic.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.e.b;

public abstract class c
  implements com.tencent.mm.vending.e.a, Runnable
{
  private static long wPu = 2000L;
  private int offset;
  private int osy;
  protected com.tencent.mm.plugin.choosemsgfile.logic.b.a wPs;
  protected a wPt;
  private boolean wPv = false;
  private Runnable wPw = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(123227);
      c.a(c.this);
      if (c.this.wPt != null) {
        c.this.wPt.gz(c.b(c.this), c.c(c.this));
      }
      AppMethodBeat.o(123227);
    }
  };
  
  public c(com.tencent.mm.plugin.choosemsgfile.logic.b.a parama, a parama1, b paramb)
  {
    this.wPs = parama;
    this.wPt = parama1;
    if (paramb != null) {
      paramb.keep(this);
    }
  }
  
  protected final void b(MsgFile paramMsgFile)
  {
    try
    {
      Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", new Object[] { paramMsgFile });
      if (this.wPt != null)
      {
        this.wPt.a(paramMsgFile);
        this.wPt = null;
      }
      return;
    }
    finally
    {
      paramMsgFile = finally;
      throw paramMsgFile;
    }
  }
  
  protected abstract void cCw();
  
  protected abstract boolean checkValid();
  
  public void dead() {}
  
  protected abstract boolean dqm();
  
  protected final void dqn()
  {
    try
    {
      Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
      if (this.wPt != null)
      {
        this.wPt.dqk();
        this.wPt = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void dqo()
  {
    try
    {
      Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
      if (this.wPt != null)
      {
        this.wPt.dqj();
        this.wPt = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void gA(int paramInt1, int paramInt2)
  {
    try
    {
      Log.v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.offset = paramInt1;
      this.osy = paramInt2;
      if ((this.wPv) && (this.wPt != null)) {
        this.wPt.gz(paramInt1, paramInt2);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    MMHandlerThread.postToMainThreadDelayed(this.wPw, wPu);
    cCw();
  }
  
  public String toString()
  {
    return "MsgFileWorker_Base{mMsgItem=" + this.wPs + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.a.c
 * JD-Core Version:    0.7.0.1
 */