package com.tencent.mm.plugin.backup.c;

import android.text.TextUtils;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

final class c$b
{
  String TAG = "";
  String aVr;
  boolean fSF = false;
  int hFC;
  long hFE = 0L;
  long hFF = 0L;
  LinkedBlockingQueue<Runnable> hGo = new LinkedBlockingQueue();
  c.a hGp;
  long hGq = 0L;
  String hGr = "";
  Vector<String> hGs = new Vector();
  Vector<fo> hGt = new Vector();
  HashMap<Long, h.a> hGu = new HashMap();
  long hGv = 0L;
  private final com.tencent.mm.plugin.backup.g.c.b hGw = new c.b.1(this);
  private final Runnable hGx = new c.b.3(this);
  final Runnable hGy = new c.b.4(this);
  String talker;
  
  public c$b(c paramc, c.a parama, f.a parama1)
  {
    this.hGp = parama;
    this.talker = parama1.hFB;
    this.hFC = parama1.hFC;
    if (s.fn(this.talker))
    {
      paramc = r.getDisplayName(this.talker, this.talker);
      this.aVr = paramc;
      parama = new StringBuilder("MicroMsg.BackupPackAndSend.tag.");
      if (!this.fSF) {
        break label287;
      }
    }
    label287:
    for (paramc = "S.";; paramc = "W.")
    {
      this.TAG = (paramc + this.hFC + "." + this.aVr);
      y.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[] { Integer.valueOf(this.hFC), this.aVr, this.talker, ak.cri() });
      return;
      paramc = r.gV(this.talker);
      break;
    }
  }
  
  public final boolean a(fo paramfo, long paramLong1, long paramLong2, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap)
  {
    this.hGt.add(paramfo);
    long l2 = this.hGq;
    if (paramLong1 > 0L) {}
    for (long l1 = paramLong1;; l1 = 0L)
    {
      this.hGq = (l1 + l2);
      if (this.hFE == 0L) {
        this.hFE = paramLong2;
      }
      this.hFF = paramLong2;
      this.hGu.putAll(paramHashMap);
      paramfo = paramLinkedList.iterator();
      while (paramfo.hasNext())
      {
        paramHashMap = (u)paramfo.next();
        k(paramHashMap.bUi, paramHashMap.path, false);
      }
    }
    y.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[] { Long.valueOf(this.hFE), Long.valueOf(this.hFF), Long.valueOf(paramLong1), Long.valueOf(this.hGq), Integer.valueOf(this.hGt.size()), Integer.valueOf(paramLinkedList.size()), Long.valueOf(bk.co(this.hGv)) });
    if ((this.hGq > 83886080L) || (this.hGt.size() > 80))
    {
      atD();
      return true;
    }
    return false;
  }
  
  public final void atD()
  {
    this.hGr = ("MSG_" + this.hGt.size() + "_" + this.talker + "_" + bk.UY());
    y.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[] { Long.valueOf(this.hFE), Long.valueOf(this.hFF), Long.valueOf(this.hGq), Integer.valueOf(this.hGt.size()), Integer.valueOf(this.hGu.size()), this.hGr, Long.valueOf(bk.co(this.hGv)) });
    if (this.hGt.size() > 0)
    {
      k(this.hGr, null, false);
      if (this.hGu.isEmpty())
      {
        this.hGo.offer(this.hGy);
        return;
      }
      this.hGo.offer(this.hGx);
      return;
    }
    y.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[] { Integer.valueOf(this.hGt.size()), Integer.valueOf(this.hGs.size()), Integer.valueOf(this.hGu.size()) });
    Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.hGt.isEmpty());
    Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.hGs.isEmpty());
    Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.hGu.isEmpty());
    this.hGo.offer(this.hGy);
  }
  
  final void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = true;
    c.b.2 local2 = new c.b.2(this);
    y.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.hGt.size()), paramString1, paramString2 });
    if (!TextUtils.isEmpty(paramString2))
    {
      this.hGs.add(paramString1);
      if (paramString1 != null) {
        com.tencent.mm.plugin.backup.g.c.a(this.hGw, local2, paramString1, paramString2, this.hGk.hGe.hFs);
      }
      return;
    }
    if (!this.hGt.isEmpty()) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      Assert.assertTrue("chatMsgList should not empty", paramBoolean);
      if (paramString1 == null) {
        break;
      }
      com.tencent.mm.plugin.backup.g.c.a(this.hGw, local2, paramString1, new LinkedList(this.hGt), this.hGk.hGe.hFs);
      return;
    }
  }
  
  public final String toString()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b
 * JD-Core Version:    0.7.0.1
 */