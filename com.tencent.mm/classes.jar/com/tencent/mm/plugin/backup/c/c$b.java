package com.tencent.mm.plugin.backup.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

final class c$b
{
  String TAG;
  String blZ;
  boolean hmf;
  int jyZ;
  LinkedBlockingQueue<Runnable> jzK;
  c.a jzL;
  private long jzM;
  String jzN;
  Vector<String> jzO;
  private Vector<gx> jzP;
  HashMap<Long, h.a> jzQ;
  long jzR;
  private final com.tencent.mm.plugin.backup.g.c.b jzS;
  private final Runnable jzT;
  final Runnable jzU;
  long jzb;
  long jzc;
  String talker;
  
  public c$b(c paramc, c.a parama, f.a parama1)
  {
    AppMethodBeat.i(17187);
    this.TAG = "";
    this.jzK = new LinkedBlockingQueue();
    this.jzb = 0L;
    this.jzc = 0L;
    this.jzM = 0L;
    this.jzN = "";
    this.jzO = new Vector();
    this.jzP = new Vector();
    this.jzQ = new HashMap();
    this.jzR = 0L;
    this.hmf = false;
    this.jzS = new c.b.1(this);
    this.jzT = new c.b.3(this);
    this.jzU = new c.b.4(this);
    this.jzR = bo.aoy();
    this.jzL = parama;
    this.talker = parama1.jyY;
    this.jyZ = parama1.jyZ;
    if (t.lA(this.talker))
    {
      paramc = s.getDisplayName(this.talker, this.talker);
      this.blZ = paramc;
      parama = new StringBuilder("MicroMsg.BackupPackAndSend.tag.");
      if (!this.hmf) {
        break label299;
      }
    }
    label299:
    for (paramc = "S.";; paramc = "W.")
    {
      this.TAG = (paramc + this.jyZ + "." + this.blZ);
      ab.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[] { Integer.valueOf(this.jyZ), this.blZ, this.talker, an.dtg() });
      AppMethodBeat.o(17187);
      return;
      paramc = s.nE(this.talker);
      break;
    }
  }
  
  public final boolean a(gx paramgx, long paramLong1, long paramLong2, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap)
  {
    AppMethodBeat.i(17188);
    this.jzP.add(paramgx);
    long l2 = this.jzM;
    if (paramLong1 > 0L) {}
    for (long l1 = paramLong1;; l1 = 0L)
    {
      this.jzM = (l1 + l2);
      if (this.jzb == 0L) {
        this.jzb = paramLong2;
      }
      this.jzc = paramLong2;
      this.jzQ.putAll(paramHashMap);
      paramgx = paramLinkedList.iterator();
      while (paramgx.hasNext())
      {
        paramHashMap = (u)paramgx.next();
        m(paramHashMap.cBO, paramHashMap.path, false);
      }
    }
    ab.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[] { Long.valueOf(this.jzb), Long.valueOf(this.jzc), Long.valueOf(paramLong1), Long.valueOf(this.jzM), Integer.valueOf(this.jzP.size()), Integer.valueOf(paramLinkedList.size()), Long.valueOf(bo.hl(this.jzR)) });
    if ((this.jzM > 83886080L) || (this.jzP.size() > 80))
    {
      aTb();
      AppMethodBeat.o(17188);
      return true;
    }
    AppMethodBeat.o(17188);
    return false;
  }
  
  public final void aTb()
  {
    AppMethodBeat.i(17189);
    this.jzN = ("MSG_" + this.jzP.size() + "_" + this.talker + "_" + bo.aoy());
    ab.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[] { Long.valueOf(this.jzb), Long.valueOf(this.jzc), Long.valueOf(this.jzM), Integer.valueOf(this.jzP.size()), Integer.valueOf(this.jzQ.size()), this.jzN, Long.valueOf(bo.hl(this.jzR)) });
    if (this.jzP.size() > 0)
    {
      m(this.jzN, null, false);
      if (this.jzQ.isEmpty())
      {
        this.jzK.offer(this.jzU);
        AppMethodBeat.o(17189);
        return;
      }
      this.jzK.offer(this.jzT);
      AppMethodBeat.o(17189);
      return;
    }
    ab.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[] { Integer.valueOf(this.jzP.size()), Integer.valueOf(this.jzO.size()), Integer.valueOf(this.jzQ.size()) });
    Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.jzP.isEmpty());
    Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.jzO.isEmpty());
    Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.jzQ.isEmpty());
    this.jzK.offer(this.jzU);
    AppMethodBeat.o(17189);
  }
  
  final void m(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(17190);
    c.b.2 local2 = new c.b.2(this);
    ab.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jzP.size()), paramString1, paramString2 });
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jzO.add(paramString1);
      if (paramString1 != null)
      {
        com.tencent.mm.plugin.backup.g.c.a(this.jzS, local2, paramString1, paramString2, this.jzG.jzA.jyL);
        AppMethodBeat.o(17190);
      }
    }
    else
    {
      if (this.jzP.isEmpty()) {
        break label171;
      }
    }
    label171:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      Assert.assertTrue("chatMsgList should not empty", paramBoolean);
      if (paramString1 != null) {
        com.tencent.mm.plugin.backup.g.c.a(this.jzS, local2, paramString1, new LinkedList(this.jzP), this.jzG.jzA.jyL);
      }
      AppMethodBeat.o(17190);
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