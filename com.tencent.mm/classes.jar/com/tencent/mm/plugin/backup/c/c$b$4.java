package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Vector;
import junit.framework.Assert;

final class c$b$4
  implements Runnable
{
  c$b$4(c.b paramb) {}
  
  public final void run()
  {
    Assert.assertTrue(toString() + ", check running. ", this.hGz.fSF);
    boolean bool1;
    switch (com.tencent.mm.plugin.backup.b.d.atq())
    {
    default: 
      if (this.hGz.hFC == this.hGz.hGk.hGe.atn().hFw - 1)
      {
        bool1 = true;
        label98:
        if (bool1) {
          break label753;
        }
      }
      break;
    }
    label753:
    for (boolean bool2 = true;; bool2 = false)
    {
      Object localObject = new af(bool2);
      c.b.4.1 local1 = new c.b.4.1(this, bool1, (af)localObject);
      new com.tencent.mm.plugin.backup.g.d(this.hGz.talker, this.hGz.hFE, this.hGz.hFF, this.hGz.hGr, this.hGz.aVr, new LinkedList(this.hGz.hGs), local1).auT();
      if (bool1)
      {
        y.w(this.hGz.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", new Object[] { Integer.valueOf(this.hGz.hFC), Integer.valueOf(this.hGz.hGk.hGe.atn().hFw - 1) });
        ((af)localObject).block();
      }
      this.hGz.fSF = false;
      return;
      y.i(this.hGz.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(this.hGz.hGk.hGe.atn().hFv), Long.valueOf(this.hGz.hFE), Long.valueOf(this.hGz.hFF), Integer.valueOf(this.hGz.hGs.size()), this.hGz.aVr, this.hGz.hGr, Long.valueOf(bk.co(this.hGz.hGv)) });
      if (this.hGz.hGk.hGe.atn().hFv >= this.hGz.hFC + 1) {
        break;
      }
      int i = this.hGz.hGk.hGe.atn().hFw;
      localObject = this.hGz.hGk.hGe.atn();
      if (this.hGz.hFC + 1 > i) {}
      for (;;)
      {
        ((e)localObject).hFv = i;
        this.hGz.hGk.hGd.nt(this.hGz.hGk.hGe.atn().hFu);
        break;
        i = this.hGz.hFC + 1;
      }
      y.i(this.hGz.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(this.hGz.hGk.hGe.atn().hFv), Long.valueOf(this.hGz.hFE), Long.valueOf(this.hGz.hFF), Integer.valueOf(this.hGz.hGs.size()), this.hGz.aVr, this.hGz.hGr, Long.valueOf(bk.co(this.hGz.hGv)) });
      if (this.hGz.hGk.hGe.atn().hFv >= this.hGz.hFC + 1) {
        break;
      }
      i = this.hGz.hGk.hGe.atn().hFw;
      localObject = this.hGz.hGk.hGe.atn();
      if (this.hGz.hFC + 1 > i) {}
      for (;;)
      {
        ((e)localObject).hFv = i;
        this.hGz.hGk.hGd.nt(this.hGz.hGk.hGe.atn().hFu);
        break;
        i = this.hGz.hFC + 1;
      }
      bool1 = false;
      break label98;
    }
  }
  
  public final String toString()
  {
    return this.hGz.TAG + ".sendTag";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.4
 * JD-Core Version:    0.7.0.1
 */