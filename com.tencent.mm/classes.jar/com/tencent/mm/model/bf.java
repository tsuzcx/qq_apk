package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class bf
{
  public static void U(List<Long> paramList)
  {
    AppMethodBeat.i(59908);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(59908);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      gw(((Long)paramList.next()).longValue());
    }
    AppMethodBeat.o(59908);
  }
  
  public static int a(String paramString, a parama)
  {
    AppMethodBeat.i(59912);
    ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", new Object[] { paramString, bo.dtY() });
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] is null", new Object[] { paramString });
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(59889);
          if (this.fkS != null) {
            this.fkS.JT();
          }
          AppMethodBeat.o(59889);
        }
      });
      AppMethodBeat.o(59912);
      return 0;
    }
    d.post(new Runnable()
    {
      int fmA = 100;
      final int fmx = 200;
      final int fmy = 30;
      final int fmz = 5;
      
      public final void run()
      {
        AppMethodBeat.i(59890);
        label514:
        for (;;)
        {
          try
          {
            Object localObject = ((j)g.E(j.class)).bPQ().Tm(this.euc);
            long l2;
            long l5;
            long l6;
            long l3;
            if (localObject == null)
            {
              l2 = 9223372036854775807L;
              ((j)g.E(j.class)).Zc().ae(this.euc, l2);
              ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), localObject, Long.valueOf(l2) });
              ((ak)g.E(ak.class)).pk(this.euc);
              l5 = bo.aoy();
              l1 = 0L;
              i = 0;
              if ((this.fmA < 200) && (this.fmA > 30))
              {
                if (l1 > 500L)
                {
                  j = this.fmA - 5;
                  this.fmA = j;
                }
              }
              else
              {
                l6 = bo.aoy();
                localObject = ((j)g.E(j.class)).bPQ().j(this.euc, this.fmA, l2);
                l1 = 0L;
                l3 = 0L;
                if (!((Cursor)localObject).moveToNext()) {
                  continue;
                }
                bi localbi = new bi();
                localbi.convertFrom((Cursor)localObject);
                if (l1 >= localbi.field_createTime) {
                  break label514;
                }
                l1 = localbi.field_createTime;
                l3 += 1L;
                bf.m(localbi);
                continue;
              }
            }
            else
            {
              l2 = ((dd)localObject).field_createTime;
              continue;
            }
            int j = this.fmA + 5;
            continue;
            ((Cursor)localObject).close();
            long l7 = bo.aoy();
            if ((l1 > 0L) && (l3 > 0L))
            {
              ((j)g.E(j.class)).bPQ().ar(this.euc, l1);
              ((ak)g.E(ak.class)).v(this.euc, l1);
            }
            int i = (int)(i + l3);
            long l8 = bo.aoy();
            long l4 = l8 - l6;
            ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", new Object[] { bo.aqg(this.euc), Integer.valueOf(i), Long.valueOf(l3), Long.valueOf(l2 - l1), Long.valueOf(l2), Long.valueOf(l8 - l7), Long.valueOf(l8 - l6), Long.valueOf(l8 - l5), Integer.valueOf(this.fmA) });
            long l1 = l4;
            if (l3 <= 0L)
            {
              AppMethodBeat.o(59890);
              return;
            }
          }
          catch (b localb)
          {
            ab.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", localb, "", new Object[0]);
            AppMethodBeat.o(59890);
            return;
          }
        }
      }
    }, "deleteMsgByTalker");
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(59891);
        if (this.fkS != null) {
          this.fkS.JT();
        }
        AppMethodBeat.o(59891);
      }
    });
    AppMethodBeat.o(59912);
    return 0;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(59913);
    g.RM();
    g.RO().ac(new Runnable()
    {
      public final void run()
      {
        int j = 0;
        AppMethodBeat.i(59893);
        if ((this.fkS == null) || (!this.fkS.JS()))
        {
          ((j)g.E(j.class)).YF().dxd();
          if ((this.fkS == null) || (!this.fkS.JS()))
          {
            bf.aaN();
            if ((this.fkS == null) || (!this.fkS.JS()))
            {
              bf.aaO();
              if ((this.fkS == null) || (!this.fkS.JS()))
              {
                List localList = ((j)g.E(j.class)).bPQ().Tp("bottlemessage");
                int i;
                if (localList != null)
                {
                  i = 0;
                  while (i < localList.size())
                  {
                    bf.m((bi)localList.get(i));
                    i += 1;
                  }
                }
                ((j)g.E(j.class)).bPQ().Tr("bottlemessage");
                if ((this.fkS == null) || (!this.fkS.JS()))
                {
                  localList = ((j)g.E(j.class)).bPQ().Tp("message");
                  if (localList != null)
                  {
                    i = j;
                    while (i < localList.size())
                    {
                      bf.m((bi)localList.get(i));
                      i += 1;
                    }
                  }
                  ((j)g.E(j.class)).bPQ().Tr("message");
                }
              }
            }
          }
        }
        if (this.fkS != null) {
          al.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(59892);
              bf.5.this.fkS.JT();
              AppMethodBeat.o(59892);
            }
          });
        }
        AppMethodBeat.o(59893);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(59894);
        String str = super.toString() + "|deleteAllMsg";
        AppMethodBeat.o(59894);
        return str;
      }
    });
    AppMethodBeat.o(59913);
  }
  
  public static void a(bi parambi, e.a parama)
  {
    AppMethodBeat.i(59918);
    if ((parambi == null) || (parama == null) || (parama.eyJ == null))
    {
      ab.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", new Object[] { bo.dtY() });
      AppMethodBeat.o(59918);
      return;
    }
    if (parambi.field_msgSvrId != parama.eyJ.pIG)
    {
      AppMethodBeat.o(59918);
      return;
    }
    cm localcm = parama.eyJ;
    if ((parambi.field_isSend != 0) && (localcm.woW == 0))
    {
      AppMethodBeat.o(59918);
      return;
    }
    if ((parambi.field_msgSeq == 0L) && (localcm.woW != 0)) {
      parambi.fS(localcm.woW);
    }
    int i = parambi.field_flag;
    if (parama.fte)
    {
      i |= 0x2;
      if (!parama.ftf) {
        break label195;
      }
      i |= 0x1;
      label141:
      if (!parama.ftg) {
        break label203;
      }
      i |= 0x4;
    }
    for (;;)
    {
      parambi.hV(i);
      if ((parambi.field_msgId == 0L) && (parama.fte)) {
        parambi.fQ(parama.fth);
      }
      AppMethodBeat.o(59918);
      return;
      i &= 0xFFFFFFFD;
      break;
      label195:
      i &= 0xFFFFFFFE;
      break label141;
      label203:
      i &= 0xFFFFFFFB;
    }
  }
  
  public static void aaL()
  {
    AppMethodBeat.i(141743);
    ((j)g.E(j.class)).bPQ().aaL();
    AppMethodBeat.o(141743);
  }
  
  public static long aaM()
  {
    AppMethodBeat.i(59904);
    long l1 = System.currentTimeMillis();
    long l2 = cb.abq();
    if (Math.abs(l1 - l2) > 300000L) {
      ab.w("MicroMsg.MsgInfoStorageLogic", "[getFixTime] nowServer:" + l2 + " now:" + l1);
    }
    AppMethodBeat.o(59904);
    return l2;
  }
  
  public static void aaN()
  {
    AppMethodBeat.i(59914);
    List localList = ((j)g.E(j.class)).bPQ().Tp("qmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        m((bi)localList.get(i));
        i += 1;
      }
    }
    ((j)g.E(j.class)).bPQ().Tr("qmessage");
    AppMethodBeat.o(59914);
  }
  
  public static void aaO()
  {
    AppMethodBeat.i(59915);
    List localList = ((j)g.E(j.class)).bPQ().Tp("tmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        m((bi)localList.get(i));
        i += 1;
      }
    }
    ((j)g.E(j.class)).bPQ().Tr("tmessage");
    AppMethodBeat.o(59915);
  }
  
  public static String ap(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59897);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(59897);
      return null;
    }
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(59897);
      return paramString1;
    }
    paramString1 = paramString2 + ": " + paramString1;
    AppMethodBeat.o(59897);
    return paramString1;
  }
  
  public static String b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(59920);
    String str = paramString;
    if (paramBoolean)
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = pv(paramString);
        }
      }
    }
    AppMethodBeat.o(59920);
    return str;
  }
  
  public static boolean c(e.a parama)
  {
    AppMethodBeat.i(59919);
    if ((parama == null) || (parama.eyJ == null))
    {
      AppMethodBeat.o(59919);
      return false;
    }
    cm localcm = parama.eyJ;
    Object localObject = aa.a(localcm.woP);
    localObject = ((j)g.E(j.class)).bPQ().ag((String)localObject, localcm.pIG);
    if (((dd)localObject).field_msgId == 0L)
    {
      AppMethodBeat.o(59919);
      return false;
    }
    if ((((dd)localObject).field_isSend != 0) && (localcm.woW == 0))
    {
      AppMethodBeat.o(59919);
      return false;
    }
    int i = ((dd)localObject).field_flag;
    if (parama.fte)
    {
      i |= 0x2;
      if (!parama.ftf) {
        break label230;
      }
      i |= 0x1;
      label128:
      if (!parama.ftg) {
        break label238;
      }
      i |= 0x4;
    }
    for (;;)
    {
      if (i == ((dd)localObject).field_flag) {
        break label246;
      }
      ab.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", new Object[] { Integer.valueOf(localcm.nqW), Integer.valueOf(i), Integer.valueOf(((dd)localObject).field_flag) });
      ((bi)localObject).hV(i);
      ((j)g.E(j.class)).bPQ().b(((dd)localObject).field_msgSvrId, (bi)localObject);
      AppMethodBeat.o(59919);
      return true;
      i &= 0xFFFFFFFD;
      break;
      label230:
      i &= 0xFFFFFFFE;
      break label128;
      label238:
      i &= 0xFFFFFFFB;
    }
    label246:
    AppMethodBeat.o(59919);
    return false;
  }
  
  public static int d(e.a parama)
  {
    int j = 0;
    if (parama.fte) {
      j = 2;
    }
    int i = j;
    if (parama.ftf) {
      i = j | 0x1;
    }
    j = i;
    if (parama.ftg) {
      j = i | 0x4;
    }
    return j;
  }
  
  public static int gw(long paramLong)
  {
    AppMethodBeat.i(59909);
    bi localbi = ((j)g.E(j.class)).bPQ().kB(paramLong);
    if (localbi.field_msgId != paramLong)
    {
      AppMethodBeat.o(59909);
      return 0;
    }
    m(localbi);
    int i = ((j)g.E(j.class)).bPQ().kC(paramLong);
    AppMethodBeat.o(59909);
    return i;
  }
  
  public static boolean kD(int paramInt)
  {
    switch (paramInt)
    {
    case 25: 
    default: 
      return false;
    }
    return true;
  }
  
  private static int kE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 49;
  }
  
  public static long l(bi parambi)
  {
    AppMethodBeat.i(59901);
    ad localad = ((j)g.E(j.class)).YA().arw(parambi.field_talker);
    if ((localad == null) || ((int)localad.euF == 0))
    {
      localad = new ad(parambi.field_talker);
      localad.setType(2);
      kc localkc = new kc();
      localkc.czG.czH = localad;
      com.tencent.mm.sdk.b.a.ymk.l(localkc);
      ((j)g.E(j.class)).YA().Y(localad);
    }
    long l = ((j)g.E(j.class)).bPQ().Z(parambi);
    AppMethodBeat.o(59901);
    return l;
  }
  
  public static void m(bi parambi)
  {
    AppMethodBeat.i(59907);
    if (parambi == null)
    {
      AppMethodBeat.o(59907);
      return;
    }
    Object localObject = e.d.aV(Integer.valueOf(kE(parambi.getType())));
    if (localObject != null) {
      ((e)localObject).a(new e.c(parambi));
    }
    localObject = new ci();
    ((ci)localObject).cpN.cpO = parambi.field_msgId;
    ((ci)localObject).cpN.talker = parambi.field_talker;
    ((ci)localObject).cpN.msgType = parambi.getType();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(59907);
  }
  
  public static long n(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(59921);
    long l3 = paramLong1 * 1000L;
    paramLong1 = 0L;
    long l2 = -1L;
    long l1 = paramLong1;
    bi localbi;
    if (paramString != null)
    {
      localbi = ((j)g.E(j.class)).bPQ().Tm(paramString);
      if (localbi != null) {
        paramLong1 = localbi.field_createTime;
      }
      l2 = ((j)g.E(j.class)).bPQ().TD(paramString);
      l1 = paramLong1;
    }
    if (l2 == l1)
    {
      if (l3 == l1)
      {
        AppMethodBeat.o(59921);
        return l3 + 1L;
      }
      AppMethodBeat.o(59921);
      return l3;
    }
    if (l2 < l1)
    {
      if (l3 == l2)
      {
        AppMethodBeat.o(59921);
        return l3 - 1L;
      }
      if (l3 == l1)
      {
        AppMethodBeat.o(59921);
        return l3 + 1L;
      }
      if ((paramLong2 == 0L) || (l3 > l1))
      {
        AppMethodBeat.o(59921);
        return l3;
      }
      localbi = ((j)g.E(j.class)).bPQ().ai(paramString, l3);
      if ((localbi.field_msgSeq != 0L) && (localbi.field_msgSeq != paramLong2))
      {
        ab.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] need fix serverMillTime[%d, %d]", new Object[] { Long.valueOf(localbi.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localbi.field_createTime), Long.valueOf(l3) });
        if (paramLong2 < localbi.field_msgSeq)
        {
          paramString = ((j)g.E(j.class)).bPQ().am(paramString, l3 - 1000L);
          if ((paramString.field_msgSeq == 0L) || (paramString.field_msgSeq == paramLong2)) {
            break label466;
          }
          if (paramString.field_msgSeq >= paramLong2) {
            break label456;
          }
          paramLong1 = paramString.field_createTime + 1L;
          label350:
          ab.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d, %d] need fix serverMillTime[%d, %d, %d] done", new Object[] { Long.valueOf(localbi.field_msgSeq), Long.valueOf(paramString.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localbi.field_createTime), Long.valueOf(paramString.field_createTime), Long.valueOf(paramLong1) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(59921);
        return paramLong1;
        paramString = ((j)g.E(j.class)).bPQ().al(paramString, 1000L + l3);
        break;
        label456:
        paramLong1 = paramString.field_createTime - 1L;
        break label350;
        label466:
        ab.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] no need fix serverMillTime[%d, %d]", new Object[] { Long.valueOf(localbi.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localbi.field_createTime), Long.valueOf(l3) });
        paramLong1 = l3;
      }
    }
    ab.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
    AppMethodBeat.o(59921);
    return l3;
  }
  
  public static b pA(String paramString)
  {
    AppMethodBeat.i(59916);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(59916);
      return null;
    }
    try
    {
      paramString = br.F(paramString, "msgsource");
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(59916);
        return null;
      }
      b localb = new b();
      localb.fmD = ((String)paramString.get(".msgsource.bizmsg.msgcluster"));
      localb.fmI = ((String)paramString.get(".msgsource.kf.kf_worker"));
      localb.fmH = bo.nullAsNil((String)paramString.get(".msgsource.bizmsg.bizclientmsgid"));
      localb.fmM = bo.nullAsNil((String)paramString.get(".msgsource.enterprise_info.qy_msg_type"));
      localb.fmN = bo.nullAsNil((String)paramString.get(".msgsource.enterprise_info.bizchat_id"));
      localb.fmO = bo.nullAsNil((String)paramString.get(".msgsource.enterprise_info.bizchat_ver"));
      localb.userId = bo.nullAsNil((String)paramString.get(".msgsource.enterprise_info.user_id"));
      localb.fmP = bo.nullAsNil((String)paramString.get(".msgsource.enterprise_info.user_nickname"));
      localb.fmQ = bo.nullAsNil((String)paramString.get(".msgsource.enterprise_info.sync_from_qy_im"));
      localb.fmL = ((String)paramString.get(".msgsource.strangerantispamticket.$ticket"));
      localb.scene = bo.getInt((String)paramString.get(".msgsource.strangerantispamticket.$scene"), 0);
      localb.fmR = ((String)paramString.get(".msgsource.NotAutoDownloadRange"));
      localb.fmS = bo.getInt((String)paramString.get(".msgsource.DownloadLimitKbps"), 0);
      localb.fmT = bo.getInt((String)paramString.get(".msgsource.videopreloadlen"), 0);
      localb.fmU = bo.getInt((String)paramString.get(".msgsource.PreDownload"), 0);
      localb.fmV = bo.getInt((String)paramString.get(".msgsource.PreDownloadNetType"), 0);
      localb.fmW = ((String)paramString.get(".msgsource.NoPreDownloadRange"));
      localb.fmE = bo.getInt((String)paramString.get(".msgsource.msg_cluster_type"), -1);
      localb.fmF = bo.getInt((String)paramString.get(".msgsource.service_type"), -1);
      localb.fmG = bo.getInt((String)paramString.get(".msgsource.scene"), -1);
      localb.fmJ = bo.getInt((String)paramString.get(".msgsource.bizmsg.msg_predict"), 0);
      localb.fmK = bo.getLong((String)paramString.get(".msgsource.bizflag"), 0L);
      AppMethodBeat.o(59916);
      return localb;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", new Object[] { bo.l(paramString) });
      ab.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(59916);
    }
    return null;
  }
  
  public static String pB(String paramString)
  {
    AppMethodBeat.i(59917);
    paramString = pA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(59917);
      return null;
    }
    paramString = paramString.fmI;
    AppMethodBeat.o(59917);
    return paramString;
  }
  
  @Deprecated
  public static int pq(String paramString)
  {
    AppMethodBeat.i(141742);
    int i = pt(paramString);
    AppMethodBeat.o(141742);
    return i;
  }
  
  public static String pr(String paramString)
  {
    AppMethodBeat.i(59896);
    int i = pt(paramString);
    if (i != -1)
    {
      paramString = paramString.substring(i + 1).trim();
      AppMethodBeat.o(59896);
      return paramString;
    }
    AppMethodBeat.o(59896);
    return paramString;
  }
  
  public static int pt(String paramString)
  {
    AppMethodBeat.i(59898);
    if (paramString == null)
    {
      ab.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
      AppMethodBeat.o(59898);
      return -1;
    }
    if (paramString.length() <= 0)
    {
      ab.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
      AppMethodBeat.o(59898);
      return -1;
    }
    if (paramString.startsWith("~SEMI_XML~"))
    {
      ab.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
      AppMethodBeat.o(59898);
      return -1;
    }
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.substring(0, i).contains("<")))
    {
      ab.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
      AppMethodBeat.o(59898);
      return -1;
    }
    AppMethodBeat.o(59898);
    return i;
  }
  
  public static String pu(String paramString)
  {
    AppMethodBeat.i(59899);
    int i = pt(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(59899);
      return null;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(59899);
    return paramString;
  }
  
  public static String pv(String paramString)
  {
    AppMethodBeat.i(59900);
    int i = pt(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(59900);
      return paramString;
    }
    if (i + 2 >= paramString.length())
    {
      AppMethodBeat.o(59900);
      return paramString;
    }
    paramString = paramString.substring(i + 2);
    AppMethodBeat.o(59900);
    return paramString;
  }
  
  public static int pw(String paramString)
  {
    AppMethodBeat.i(59902);
    int i = ((j)g.E(j.class)).bPQ().pw(paramString);
    AppMethodBeat.o(59902);
    return i;
  }
  
  public static boolean px(String paramString)
  {
    AppMethodBeat.i(59903);
    boolean bool = ((j)g.E(j.class)).bPQ().px(paramString);
    AppMethodBeat.o(59903);
    return bool;
  }
  
  public static long py(String paramString)
  {
    AppMethodBeat.i(59905);
    long l = aaM();
    ab.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", new Object[] { Long.valueOf(l) });
    if (paramString != null)
    {
      paramString = ((j)g.E(j.class)).bPQ().Tm(paramString);
      if (paramString != null)
      {
        ab.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(l) });
        if (paramString.field_createTime + 1L > l)
        {
          l = paramString.field_createTime;
          AppMethodBeat.o(59905);
          return l + 1L;
        }
      }
    }
    AppMethodBeat.o(59905);
    return l;
  }
  
  public static int pz(String paramString)
  {
    AppMethodBeat.i(59911);
    int i = ((j)g.E(j.class)).bPQ().Ts(paramString);
    AppMethodBeat.o(59911);
    return i;
  }
  
  public static long x(String paramString, long paramLong)
  {
    AppMethodBeat.i(59906);
    if (paramString != null)
    {
      paramString = ((j)g.E(j.class)).bPQ().Tm(paramString);
      if (paramString == null) {}
    }
    for (long l = paramString.field_createTime + 1L;; l = 0L)
    {
      if (l > paramLong * 1000L)
      {
        AppMethodBeat.o(59906);
        return l;
      }
      AppMethodBeat.o(59906);
      return paramLong * 1000L;
    }
  }
  
  public static int y(String paramString, long paramLong)
  {
    AppMethodBeat.i(59910);
    bi localbi = ((j)g.E(j.class)).bPQ().ag(paramString, paramLong);
    if (localbi.field_msgSvrId != paramLong)
    {
      AppMethodBeat.o(59910);
      return 0;
    }
    m(localbi);
    int i = ((j)g.E(j.class)).bPQ().aq(paramString, paramLong);
    AppMethodBeat.o(59910);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract boolean JS();
    
    public abstract void JT();
  }
  
  public static final class b
  {
    public String fmD;
    public int fmE;
    public int fmF;
    public int fmG;
    public String fmH;
    public String fmI;
    public int fmJ;
    public long fmK;
    public String fmL;
    public String fmM;
    public String fmN;
    public String fmO;
    public String fmP;
    public String fmQ;
    public String fmR;
    public int fmS;
    public int fmT;
    public int fmU;
    public int fmV;
    public String fmW;
    public int scene = 0;
    public String userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bf
 * JD-Core Version:    0.7.0.1
 */