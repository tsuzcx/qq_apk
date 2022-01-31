package com.tencent.mm.plugin.messenger.foundation;

import android.database.Cursor;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.d;
import com.tencent.mm.at.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.be;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.List;

public final class c
  implements r
{
  public static e.b a(e.a parama, t paramt)
  {
    cd localcd = parama.dBs;
    if ((10008 == ae.eSP) && (ae.eSQ != 0))
    {
      y.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(localcd.ndp), Integer.valueOf(ae.eSQ) });
      localcd.ndp = Long.valueOf(ae.eSQ).longValue();
      ae.eSQ = 0;
    }
    if (((j)com.tencent.mm.kernel.g.r(j.class)).bhO().ff(localcd.ndp))
    {
      y.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
      parama = null;
      return parama;
    }
    String str = aa.a(localcd.svF);
    Object localObject2 = aa.a(localcd.svG);
    if ((str.equals(q.Gj())) && (((String)localObject2).equals("newsapp")) && (localcd.kSW != 51))
    {
      y.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[] { Long.valueOf(localcd.ndp), Integer.valueOf(localcd.kSW) });
      return null;
    }
    long l1 = localcd.ndp;
    int i = localcd.ndm;
    int j = localcd.svM;
    int k = localcd.hQq;
    int m = localcd.kSW;
    int n = localcd.mPL;
    Object localObject3 = bk.hs(localcd.mPL);
    long l2 = bk.UX();
    long l3 = localcd.mPL;
    int i1 = localcd.svI;
    int i2 = aa.a(localcd.svJ, new byte[0]).length;
    int i3 = bk.pm(localcd.svK).length();
    int i4 = bk.pm(localcd.svL).length();
    bml localbml = localcd.svH;
    Object localObject1 = "";
    if (localbml == null)
    {
      label321:
      y.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", new Object[] { str, localObject2, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), localObject3, Long.valueOf(l2 - l3), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bk.aac((String)localObject1) });
      y.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { localcd.svK, "" });
      u.h(localcd);
      if (str.equals("readerapp"))
      {
        localcd.svF = aa.pj("newsapp");
        localcd.kSW = 12399999;
      }
      if (((str.equals("blogapp")) || (str.equals("newsapp"))) && (localcd.kSW != 10002)) {
        localcd.kSW = 12399999;
      }
      if (localcd.kSW == 52) {
        localcd.kSW = 1000052;
      }
      if (localcd.kSW == 53) {
        localcd.kSW = 1000053;
      }
      if ((parama != null) && (parama.dBs != null)) {
        break label768;
      }
      label593:
      i = 0;
      localObject1 = null;
      localObject3 = e.d.aB(Integer.valueOf(localcd.kSW));
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = e.d.aB(str);
      }
      if (localObject2 != null)
      {
        localObject2 = ((e)localObject2).b(parama);
        if (localObject2 != null) {
          break label983;
        }
        localObject1 = null;
        label650:
        if (localObject1 != null) {
          break label993;
        }
        y.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[] { Integer.valueOf(localcd.kSW), Long.valueOf(localcd.ndp), Integer.valueOf(localcd.svM), Integer.valueOf(localcd.mPL), parama });
      }
    }
    label768:
    label1087:
    for (;;)
    {
      i = 1;
      localObject1 = localObject2;
      u.b(5, localcd);
      parama = (e.a)localObject1;
      if (i != 0) {
        break;
      }
      y.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[] { Integer.valueOf(localcd.kSW) });
      return localObject1;
      localObject1 = localbml.tFO;
      break label321;
      localObject1 = parama.dBs;
      localObject2 = aa.a(((cd)localObject1).svF);
      localObject2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().O((String)localObject2, ((cd)localObject1).ndp);
      if ((((cs)localObject2).field_msgId == 0L) || ((((cs)localObject2).field_isSend != 0) && (((cd)localObject1).svM == 0))) {
        break label593;
      }
      i = ((cs)localObject2).field_flag;
      if (parama.ecS)
      {
        i |= 0x2;
        label854:
        if (!parama.ecT) {
          break label967;
        }
        i |= 0x1;
        label865:
        if (!parama.ecU) {
          break label975;
        }
        i |= 0x4;
      }
      for (;;)
      {
        if (i == ((cs)localObject2).field_flag) {
          break label981;
        }
        y.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", new Object[] { Integer.valueOf(((cd)localObject1).kSW), Integer.valueOf(i), Integer.valueOf(((cs)localObject2).field_flag) });
        ((bi)localObject2).fJ(i);
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().b(((cs)localObject2).field_msgSvrId, (bi)localObject2);
        break;
        i &= 0xFFFFFFFD;
        break label854;
        label967:
        i &= 0xFFFFFFFE;
        break label865;
        label975:
        i &= 0xFFFFFFFB;
      }
      label981:
      break label593;
      label983:
      localObject1 = ((e.b)localObject2).bFH;
      break label650;
      label993:
      if ((s.hp(str)) && (!b.Pf())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1087;
        }
        y.d("MicroMsg.MessageSyncExtension", " msg , id =" + ((cs)localObject1).field_msgId + "  " + paramt);
        if ((((cs)localObject1).field_msgId <= 0L) || (paramt == null) || (!((e.b)localObject2).ecX)) {
          break;
        }
        paramt.a((bi)localObject1, localcd);
        break;
      }
    }
  }
  
  public final void a(qv paramqv, byte[] paramArrayOfByte, boolean paramBoolean, t paramt)
  {
    switch (paramqv.sOA)
    {
    }
    for (;;)
    {
      return;
      paramqv = (cd)new cd().aH(paramArrayOfByte);
      if (paramqv != null)
      {
        paramArrayOfByte = new e.a(paramqv, false, false, false);
        a(paramArrayOfByte, paramt);
        if (!paramArrayOfByte.ecS)
        {
          be.a(aa.a(paramqv.svF), paramqv.ndp, paramqv.mPL * 1000L, paramqv.kSW);
          return;
          paramArrayOfByte = (su)new su().aH(paramArrayOfByte);
          paramqv = aa.a(paramArrayOfByte.sQs);
          int i = paramArrayOfByte.sQv;
          paramArrayOfByte = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().bR(paramqv, i);
          if (paramArrayOfByte.moveToFirst()) {
            while (!paramArrayOfByte.isAfterLast())
            {
              paramt = new bi();
              paramt.d(paramArrayOfByte);
              bd.i(paramt);
              paramArrayOfByte.moveToNext();
            }
          }
          paramArrayOfByte.close();
          ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().bQ(paramqv, i);
          return;
          paramqv = (ta)new ta().aH(paramArrayOfByte);
          paramArrayOfByte = paramqv.sQy;
          i = 0;
          while (i < paramArrayOfByte.size())
          {
            bd.p(aa.a(paramqv.sQs), ((Integer)paramArrayOfByte.get(i)).intValue());
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.c
 * JD-Core Version:    0.7.0.1
 */