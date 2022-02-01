package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.e.b;

public abstract class c
  implements com.tencent.mm.vending.e.a, Runnable
{
  private static long tMe = 2000L;
  private int lAW;
  private int offset;
  protected com.tencent.mm.plugin.choosemsgfile.b.b.a tMc;
  protected a tMd;
  private boolean tMf = false;
  private Runnable tMg = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(123227);
      c.a(c.this);
      if (c.this.tMd != null) {
        c.this.tMd.fH(c.b(c.this), c.c(c.this));
      }
      AppMethodBeat.o(123227);
    }
  };
  
  public c(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    this.tMc = parama;
    this.tMd = parama1;
    if (paramb != null) {
      paramb.keep(this);
    }
  }
  
  protected final void b(MsgFile paramMsgFile)
  {
    try
    {
      Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", new Object[] { paramMsgFile });
      if (this.tMd != null)
      {
        this.tMd.a(paramMsgFile);
        this.tMd = null;
      }
      return;
    }
    finally
    {
      paramMsgFile = finally;
      throw paramMsgFile;
    }
  }
  
  protected abstract boolean cMI();
  
  protected final void cMJ()
  {
    try
    {
      Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
      if (this.tMd != null)
      {
        this.tMd.cMG();
        this.tMd = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void cMK()
  {
    try
    {
      Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
      if (this.tMd != null)
      {
        this.tMd.cMF();
        this.tMd = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected abstract void ccd();
  
  protected abstract boolean checkValid();
  
  public void dead() {}
  
  protected final void fI(int paramInt1, int paramInt2)
  {
    try
    {
      Log.v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.offset = paramInt1;
      this.lAW = paramInt2;
      if ((this.tMf) && (this.tMd != null)) {
        this.tMd.fH(paramInt1, paramInt2);
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
    MMHandlerThread.postToMainThreadDelayed(this.tMg, tMe);
    ccd();
  }
  
  public String toString()
  {
    return "MsgFileWorker_Base{mMsgItem=" + this.tMc + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.c
 * JD-Core Version:    0.7.0.1
 */