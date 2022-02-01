package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.vending.e.b;

public abstract class c
  implements com.tencent.mm.vending.e.a, Runnable
{
  private static long oYr = 2000L;
  private int hPI;
  protected com.tencent.mm.plugin.choosemsgfile.b.b.a oYp;
  protected a oYq;
  private boolean oYs = false;
  private Runnable oYt = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(123227);
      c.a(c.this);
      if (c.this.oYq != null) {
        c.this.oYq.eX(c.b(c.this), c.c(c.this));
      }
      AppMethodBeat.o(123227);
    }
  };
  private int offset;
  
  public c(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    this.oYp = parama;
    this.oYq = parama1;
    if (paramb != null) {
      paramb.keep(this);
    }
  }
  
  protected final void b(MsgFile paramMsgFile)
  {
    try
    {
      ae.i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", new Object[] { paramMsgFile });
      if (this.oYq != null)
      {
        this.oYq.a(paramMsgFile);
        this.oYq = null;
      }
      return;
    }
    finally
    {
      paramMsgFile = finally;
      throw paramMsgFile;
    }
  }
  
  protected abstract void buf();
  
  protected abstract boolean caw();
  
  protected final void cax()
  {
    try
    {
      ae.i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
      if (this.oYq != null)
      {
        this.oYq.cau();
        this.oYq = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void cay()
  {
    try
    {
      ae.i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
      if (this.oYq != null)
      {
        this.oYq.cat();
        this.oYq = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected abstract boolean checkValid();
  
  public void dead() {}
  
  protected final void eY(int paramInt1, int paramInt2)
  {
    try
    {
      ae.v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.offset = paramInt1;
      this.hPI = paramInt2;
      if ((this.oYs) && (this.oYq != null)) {
        this.oYq.eX(paramInt1, paramInt2);
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
    ar.o(this.oYt, oYr);
    buf();
  }
  
  public String toString()
  {
    return "MsgFileWorker_Base{mMsgItem=" + this.oYp + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.c
 * JD-Core Version:    0.7.0.1
 */