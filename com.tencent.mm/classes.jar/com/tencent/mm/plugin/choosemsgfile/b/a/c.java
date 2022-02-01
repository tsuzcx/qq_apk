package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.e.b;

public abstract class c
  implements com.tencent.mm.vending.e.a, Runnable
{
  private static long oou = 2000L;
  private int hux;
  private int offset;
  protected com.tencent.mm.plugin.choosemsgfile.b.b.a oos;
  protected a oot;
  private boolean oov = false;
  private Runnable oow = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(123227);
      c.a(c.this);
      if (c.this.oot != null) {
        c.this.oot.eS(c.b(c.this), c.c(c.this));
      }
      AppMethodBeat.o(123227);
    }
  };
  
  public c(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, b paramb)
  {
    this.oos = parama;
    this.oot = parama1;
    if (paramb != null) {
      paramb.keep(this);
    }
  }
  
  protected final void b(MsgFile paramMsgFile)
  {
    try
    {
      ac.i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", new Object[] { paramMsgFile });
      if (this.oot != null)
      {
        this.oot.a(paramMsgFile);
        this.oot = null;
      }
      return;
    }
    finally
    {
      paramMsgFile = finally;
      throw paramMsgFile;
    }
  }
  
  protected abstract boolean bUC();
  
  protected final void bUD()
  {
    try
    {
      ac.i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
      if (this.oot != null)
      {
        this.oot.bUA();
        this.oot = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void bUE()
  {
    try
    {
      ac.i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
      if (this.oot != null)
      {
        this.oot.bUz();
        this.oot = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected abstract void bpv();
  
  protected abstract boolean checkValid();
  
  public void dead() {}
  
  protected final void eT(int paramInt1, int paramInt2)
  {
    try
    {
      ac.v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.offset = paramInt1;
      this.hux = paramInt2;
      if ((this.oov) && (this.oot != null)) {
        this.oot.eS(paramInt1, paramInt2);
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
    ap.n(this.oow, oou);
    bpv();
  }
  
  public String toString()
  {
    return "MsgFileWorker_Base{mMsgItem=" + this.oos + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.c
 * JD-Core Version:    0.7.0.1
 */