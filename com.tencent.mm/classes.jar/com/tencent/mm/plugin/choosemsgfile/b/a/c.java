package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.e.b;

public abstract class c
  implements com.tencent.mm.vending.e.a, Runnable
{
  private static long kEu = 2000L;
  private int fsd;
  protected com.tencent.mm.plugin.choosemsgfile.b.b.a kEs;
  protected a kEt;
  private boolean kEv = false;
  private Runnable kEw = new c.1(this);
  private int offset;
  
  public c(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    this.kEs = parama;
    this.kEt = parama1;
    if (paramb != null) {
      paramb.keep(this);
    }
  }
  
  protected final void b(MsgFile paramMsgFile)
  {
    try
    {
      ab.i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", new Object[] { paramMsgFile });
      if (this.kEt != null)
      {
        this.kEt.a(paramMsgFile);
        this.kEt = null;
      }
      return;
    }
    finally
    {
      paramMsgFile = finally;
      throw paramMsgFile;
    }
  }
  
  protected abstract boolean bgf();
  
  protected abstract void bgg();
  
  protected final void bgh()
  {
    try
    {
      ab.i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
      if (this.kEt != null)
      {
        this.kEt.bgd();
        this.kEt = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void bgi()
  {
    try
    {
      ab.i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
      if (this.kEt != null)
      {
        this.kEt.bgc();
        this.kEt = null;
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
  
  protected final void dU(int paramInt1, int paramInt2)
  {
    try
    {
      ab.v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.offset = paramInt1;
      this.fsd = paramInt2;
      if ((this.kEv) && (this.kEt != null)) {
        this.kEt.dT(paramInt1, paramInt2);
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
  
  public void run()
  {
    al.p(this.kEw, kEu);
    bgg();
  }
  
  public String toString()
  {
    return "MsgFileWorker_Base{mMsgItem=" + this.kEs + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.c
 * JD-Core Version:    0.7.0.1
 */