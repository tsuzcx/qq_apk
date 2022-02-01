package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vending.e.b;

public abstract class c
  implements com.tencent.mm.vending.e.a, Runnable
{
  private static long nLu = 2000L;
  private int gTY;
  protected com.tencent.mm.plugin.choosemsgfile.b.b.a nLs;
  protected a nLt;
  private boolean nLv = false;
  private Runnable nLw = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(123227);
      c.a(c.this);
      if (c.this.nLt != null) {
        c.this.nLt.eP(c.b(c.this), c.c(c.this));
      }
      AppMethodBeat.o(123227);
    }
  };
  private int offset;
  
  public c(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    this.nLs = parama;
    this.nLt = parama1;
    if (paramb != null) {
      paramb.keep(this);
    }
  }
  
  protected final void b(MsgFile paramMsgFile)
  {
    try
    {
      ad.i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", new Object[] { paramMsgFile });
      if (this.nLt != null)
      {
        this.nLt.a(paramMsgFile);
        this.nLt = null;
      }
      return;
    }
    finally
    {
      paramMsgFile = finally;
      throw paramMsgFile;
    }
  }
  
  protected abstract boolean bNr();
  
  protected final void bNs()
  {
    try
    {
      ad.i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
      if (this.nLt != null)
      {
        this.nLt.bNp();
        this.nLt = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void bNt()
  {
    try
    {
      ad.i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
      if (this.nLt != null)
      {
        this.nLt.bNo();
        this.nLt = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected abstract void biB();
  
  protected abstract boolean checkValid();
  
  public void dead() {}
  
  protected final void eQ(int paramInt1, int paramInt2)
  {
    try
    {
      ad.v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.offset = paramInt1;
      this.gTY = paramInt2;
      if ((this.nLv) && (this.nLt != null)) {
        this.nLt.eP(paramInt1, paramInt2);
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
    aq.n(this.nLw, nLu);
    biB();
  }
  
  public String toString()
  {
    return "MsgFileWorker_Base{mMsgItem=" + this.nLs + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.c
 * JD-Core Version:    0.7.0.1
 */