package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.e.b;

public abstract class c
  implements com.tencent.mm.vending.e.a, Runnable
{
  private static long qnq = 2000L;
  private int iKP;
  private int offset;
  protected com.tencent.mm.plugin.choosemsgfile.b.b.a qno;
  protected a qnp;
  private boolean qnr = false;
  private Runnable qns = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(123227);
      c.a(c.this);
      if (c.this.qnp != null) {
        c.this.qnp.fk(c.b(c.this), c.c(c.this));
      }
      AppMethodBeat.o(123227);
    }
  };
  
  public c(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    this.qno = parama;
    this.qnp = parama1;
    if (paramb != null) {
      paramb.keep(this);
    }
  }
  
  protected final void b(MsgFile paramMsgFile)
  {
    try
    {
      Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", new Object[] { paramMsgFile });
      if (this.qnp != null)
      {
        this.qnp.a(paramMsgFile);
        this.qnp = null;
      }
      return;
    }
    finally
    {
      paramMsgFile = finally;
      throw paramMsgFile;
    }
  }
  
  protected abstract void bPM();
  
  protected abstract boolean checkValid();
  
  protected abstract boolean cyn();
  
  protected final void cyo()
  {
    try
    {
      Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
      if (this.qnp != null)
      {
        this.qnp.cyl();
        this.qnp = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void cyp()
  {
    try
    {
      Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
      if (this.qnp != null)
      {
        this.qnp.cyk();
        this.qnp = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void dead() {}
  
  protected final void fl(int paramInt1, int paramInt2)
  {
    try
    {
      Log.v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.offset = paramInt1;
      this.iKP = paramInt2;
      if ((this.qnr) && (this.qnp != null)) {
        this.qnp.fk(paramInt1, paramInt2);
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
    MMHandlerThread.postToMainThreadDelayed(this.qns, qnq);
    bPM();
  }
  
  public String toString()
  {
    return "MsgFileWorker_Base{mMsgItem=" + this.qno + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.c
 * JD-Core Version:    0.7.0.1
 */