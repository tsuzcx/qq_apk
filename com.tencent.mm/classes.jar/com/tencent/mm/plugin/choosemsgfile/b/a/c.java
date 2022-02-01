package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vending.e.b;

public abstract class c
  implements com.tencent.mm.vending.e.a, Runnable
{
  private static long oRP = 2000L;
  private int hMP;
  protected com.tencent.mm.plugin.choosemsgfile.b.b.a oRN;
  protected a oRO;
  private boolean oRQ = false;
  private Runnable oRR = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(123227);
      c.a(c.this);
      if (c.this.oRO != null) {
        c.this.oRO.eW(c.b(c.this), c.c(c.this));
      }
      AppMethodBeat.o(123227);
    }
  };
  private int offset;
  
  public c(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    this.oRN = parama;
    this.oRO = parama1;
    if (paramb != null) {
      paramb.keep(this);
    }
  }
  
  protected final void b(MsgFile paramMsgFile)
  {
    try
    {
      ad.i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", new Object[] { paramMsgFile });
      if (this.oRO != null)
      {
        this.oRO.a(paramMsgFile);
        this.oRO = null;
      }
      return;
    }
    finally
    {
      paramMsgFile = finally;
      throw paramMsgFile;
    }
  }
  
  protected abstract boolean bZh();
  
  protected final void bZi()
  {
    try
    {
      ad.i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
      if (this.oRO != null)
      {
        this.oRO.bZf();
        this.oRO = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void bZj()
  {
    try
    {
      ad.i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
      if (this.oRO != null)
      {
        this.oRO.bZe();
        this.oRO = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected abstract void btu();
  
  protected abstract boolean checkValid();
  
  public void dead() {}
  
  protected final void eX(int paramInt1, int paramInt2)
  {
    try
    {
      ad.v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.offset = paramInt1;
      this.hMP = paramInt2;
      if ((this.oRQ) && (this.oRO != null)) {
        this.oRO.eW(paramInt1, paramInt2);
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
    aq.o(this.oRR, oRP);
    btu();
  }
  
  public String toString()
  {
    return "MsgFileWorker_Base{mMsgItem=" + this.oRN + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.c
 * JD-Core Version:    0.7.0.1
 */