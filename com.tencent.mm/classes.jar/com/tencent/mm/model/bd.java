package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.e.d;
import com.tencent.mm.h.a.cf;
import com.tencent.mm.h.a.jt;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class bd
{
  public static long HM()
  {
    long l1 = System.currentTimeMillis();
    long l2 = bz.It();
    if (Math.abs(l1 - l2) > 300000L) {
      y.w("MicroMsg.MsgInfoStorageLogic", "[getFixTime] nowServer:" + l2 + " now:" + l1);
    }
    return l2;
  }
  
  public static void HN()
  {
    List localList = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HD("bottlemessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        i((bi)localList.get(i));
        i += 1;
      }
    }
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HF("bottlemessage");
  }
  
  public static void HO()
  {
    List localList = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HD("qmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        i((bi)localList.get(i));
        i += 1;
      }
    }
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HF("qmessage");
  }
  
  public static void HP()
  {
    List localList = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HD("tmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        i((bi)localList.get(i));
        i += 1;
      }
    }
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HF("tmessage");
  }
  
  public static void N(List<Long> paramList)
  {
    if (paramList.size() == 0) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        bC(((Long)paramList.next()).longValue());
      }
    }
  }
  
  public static String Z(String paramString1, String paramString2)
  {
    String str;
    if (bk.bl(paramString1)) {
      str = null;
    }
    do
    {
      return str;
      str = paramString1;
    } while (bk.bl(paramString2));
    return paramString2 + ": " + paramString1;
  }
  
  public static int a(String paramString, a parama)
  {
    y.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", new Object[] { paramString, bk.csb() });
    bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HA(paramString);
    if (localbi == null) {}
    for (final long l = 9223372036854775807L;; l = localbi.field_createTime)
    {
      if ((localbi != null) && (localbi.field_createTime > 0L)) {
        ((j)com.tencent.mm.kernel.g.r(j.class)).Gb().M(paramString, l);
      }
      com.tencent.mm.sdk.f.e.post(new Runnable()
      {
        final int dWn = 200;
        final int dWo = 30;
        final int dWp = 5;
        int dWq = 100;
        
        public final void run()
        {
          label405:
          for (;;)
          {
            try
            {
              y.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), this.dWs, Long.valueOf(l) });
              long l4 = bk.UY();
              long l1 = 0L;
              int i = 0;
              long l5;
              Cursor localCursor;
              long l2;
              if ((this.dWq < 200) && (this.dWq > 30))
              {
                if (l1 > 500L)
                {
                  j = this.dWq - 5;
                  this.dWq = j;
                }
              }
              else
              {
                l5 = bk.UY();
                localCursor = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().f(this.dAA, this.dWq, l);
                l1 = 0L;
                l2 = 0L;
                if (!localCursor.moveToNext()) {
                  continue;
                }
                bi localbi = new bi();
                localbi.d(localCursor);
                if (l1 >= localbi.field_createTime) {
                  break label405;
                }
                l1 = localbi.field_createTime;
                l2 += 1L;
                bd.i(localbi);
                continue;
              }
              int j = this.dWq + 5;
              continue;
              localCursor.close();
              long l6 = bk.UY();
              if ((l1 > 0L) && (l2 > 0L)) {
                ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().Z(this.dAA, l1);
              }
              i = (int)(i + l2);
              long l7 = bk.UY();
              long l3 = l7 - l5;
              y.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", new Object[] { bk.aac(this.dAA), Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l - l1), Long.valueOf(l), Long.valueOf(l7 - l6), Long.valueOf(l7 - l5), Long.valueOf(l7 - l4), Integer.valueOf(this.dWq) });
              l1 = l3;
              if (l2 <= 0L) {
                return;
              }
            }
            catch (b localb)
            {
              y.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", localb, "", new Object[0]);
              return;
            }
          }
        }
      }, "deleteMsgByTalker");
      ai.d(new Runnable()
      {
        public final void run()
        {
          if (this.dUJ != null) {
            this.dUJ.xA();
          }
        }
      });
      return 0;
    }
  }
  
  public static void a(a parama)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new Runnable()
    {
      public final void run()
      {
        if ((this.dUJ == null) || (!this.dUJ.xz()))
        {
          ((j)com.tencent.mm.kernel.g.r(j.class)).FB().cuC();
          if ((this.dUJ == null) || (!this.dUJ.xz()))
          {
            bd.HO();
            if ((this.dUJ == null) || (!this.dUJ.xz()))
            {
              bd.HP();
              if ((this.dUJ == null) || (!this.dUJ.xz()))
              {
                bd.HN();
                if ((this.dUJ == null) || (!this.dUJ.xz()))
                {
                  List localList = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HD("message");
                  if (localList != null)
                  {
                    int i = 0;
                    while (i < localList.size())
                    {
                      bd.i((bi)localList.get(i));
                      i += 1;
                    }
                  }
                  ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HF("message");
                }
              }
            }
          }
        }
        if (this.dUJ != null) {
          ai.d(new Runnable()
          {
            public final void run()
            {
              bd.4.this.dUJ.xA();
            }
          });
        }
      }
      
      public final String toString()
      {
        return super.toString() + "|deleteAllMsg";
      }
    });
  }
  
  public static void a(bi parambi, e.a parama)
  {
    if ((parambi == null) || (parama == null) || (parama.dBs == null)) {
      y.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", new Object[] { bk.csb() });
    }
    cd localcd;
    do
    {
      do
      {
        return;
      } while (parambi.field_msgSvrId != parama.dBs.ndp);
      localcd = parama.dBs;
    } while ((parambi.field_isSend != 0) && (localcd.svM == 0));
    if ((parambi.field_msgSeq == 0L) && (localcd.svM != 0)) {
      parambi.bi(localcd.svM);
    }
    int i = parambi.field_flag;
    if (parama.ecS)
    {
      i |= 0x2;
      label108:
      if (!parama.ecT) {
        break label168;
      }
      i |= 0x1;
      label119:
      if (!parama.ecU) {
        break label176;
      }
      i |= 0x4;
    }
    for (;;)
    {
      parambi.fJ(i);
      if ((parambi.field_msgId != 0L) || (!parama.ecS)) {
        break;
      }
      parambi.bg(parama.ecV);
      return;
      i &= 0xFFFFFFFD;
      break label108;
      label168:
      i &= 0xFFFFFFFE;
      break label119;
      label176:
      i &= 0xFFFFFFFB;
    }
  }
  
  public static String b(boolean paramBoolean, String paramString, int paramInt)
  {
    String str = paramString;
    if (paramBoolean)
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = iJ(paramString);
        }
      }
    }
    return str;
  }
  
  public static int bC(long paramLong)
  {
    bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramLong);
    if (localbi.field_msgId != paramLong) {
      return 0;
    }
    i(localbi);
    return ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fe(paramLong);
  }
  
  public static int c(e.a parama)
  {
    int j = 0;
    if (parama.ecS) {
      j = 2;
    }
    int i = j;
    if (parama.ecT) {
      i = j | 0x1;
    }
    j = i;
    if (parama.ecU) {
      j = i | 0x4;
    }
    return j;
  }
  
  public static long h(bi parambi)
  {
    ad localad = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(parambi.field_talker);
    if ((localad == null) || ((int)localad.dBe == 0))
    {
      localad = new ad(parambi.field_talker);
      localad.setType(2);
      jt localjt = new jt();
      localjt.bSf.bSg = localad;
      com.tencent.mm.sdk.b.a.udP.m(localjt);
      ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().V(localad);
    }
    return ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(parambi);
  }
  
  public static boolean hR(int paramInt)
  {
    switch (paramInt)
    {
    case 25: 
    default: 
      return false;
    }
    return true;
  }
  
  public static void i(bi parambi)
  {
    if (parambi == null) {
      return;
    }
    int i = parambi.getType();
    switch (i)
    {
    }
    for (;;)
    {
      Object localObject = e.d.aB(Integer.valueOf(i));
      if (localObject != null) {
        ((com.tencent.mm.ah.e)localObject).a(new e.c(parambi));
      }
      localObject = new cf();
      ((cf)localObject).bIs.bIt = parambi.field_msgId;
      ((cf)localObject).bIs.talker = parambi.field_talker;
      ((cf)localObject).bIs.msgType = parambi.getType();
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      return;
      i = 49;
    }
  }
  
  public static int iH(String paramString)
  {
    if (paramString == null)
    {
      y.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
      return -1;
    }
    if (paramString.length() <= 0)
    {
      y.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
      return -1;
    }
    if (paramString.startsWith("~SEMI_XML~"))
    {
      y.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
      return -1;
    }
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.substring(0, i).contains("<")))
    {
      y.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
      return -1;
    }
    return i;
  }
  
  public static String iI(String paramString)
  {
    int i = iH(paramString);
    if (i == -1) {
      return null;
    }
    return paramString.substring(0, i);
  }
  
  public static String iJ(String paramString)
  {
    int i = iH(paramString);
    if (i == -1) {}
    while (i + 2 >= paramString.length()) {
      return paramString;
    }
    return paramString.substring(i + 2);
  }
  
  public static long iK(String paramString)
  {
    long l = HM();
    y.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", new Object[] { Long.valueOf(l) });
    if (paramString != null)
    {
      paramString = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HA(paramString);
      if (paramString != null)
      {
        y.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(l) });
        if (paramString.field_createTime + 1L > l) {
          return paramString.field_createTime + 1L;
        }
      }
    }
    return l;
  }
  
  public static int iL(String paramString)
  {
    return ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HG(paramString);
  }
  
  public static b iM(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    try
    {
      paramString = bn.s(paramString, "msgsource");
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        b localb = new b();
        localb.dWv = ((String)paramString.get(".msgsource.bizmsg.msgcluster"));
        localb.dWA = ((String)paramString.get(".msgsource.kf.kf_worker"));
        localb.dWz = bk.pm((String)paramString.get(".msgsource.bizmsg.bizclientmsgid"));
        localb.dWE = bk.pm((String)paramString.get(".msgsource.enterprise_info.qy_msg_type"));
        localb.dWF = bk.pm((String)paramString.get(".msgsource.enterprise_info.bizchat_id"));
        localb.dWG = bk.pm((String)paramString.get(".msgsource.enterprise_info.bizchat_ver"));
        localb.userId = bk.pm((String)paramString.get(".msgsource.enterprise_info.user_id"));
        localb.dWH = bk.pm((String)paramString.get(".msgsource.enterprise_info.user_nickname"));
        localb.dWI = bk.pm((String)paramString.get(".msgsource.enterprise_info.sync_from_qy_im"));
        localb.dWD = ((String)paramString.get(".msgsource.strangerantispamticket.$ticket"));
        localb.scene = bk.getInt((String)paramString.get(".msgsource.strangerantispamticket.$scene"), 0);
        localb.dWJ = ((String)paramString.get(".msgsource.NotAutoDownloadRange"));
        localb.dWK = bk.getInt((String)paramString.get(".msgsource.DownloadLimitKbps"), 0);
        localb.dWL = bk.getInt((String)paramString.get(".msgsource.videopreloadlen"), 0);
        localb.dWM = bk.getInt((String)paramString.get(".msgsource.PreDownload"), 0);
        localb.dWN = bk.getInt((String)paramString.get(".msgsource.PreDownloadNetType"), 0);
        localb.dWO = ((String)paramString.get(".msgsource.NoPreDownloadRange"));
        localb.dWw = bk.getInt((String)paramString.get(".msgsource.msg_cluster_type"), -1);
        localb.dWx = bk.getInt((String)paramString.get(".msgsource.service_type"), -1);
        localb.dWy = bk.getInt((String)paramString.get(".msgsource.scene"), -1);
        localb.dWB = bk.getInt((String)paramString.get(".msgsource.bizmsg.msg_predict"), 0);
        localb.dWC = bk.getLong((String)paramString.get(".msgsource.bizflag"), 0L);
        return localb;
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", new Object[] { bk.j(paramString) });
      y.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", new Object[] { paramString.getMessage() });
      return null;
    }
    return null;
  }
  
  public static String iN(String paramString)
  {
    paramString = iM(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.dWA;
  }
  
  public static long o(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      paramString = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HA(paramString);
      if (paramString == null) {}
    }
    for (long l = paramString.field_createTime + 1L;; l = 0L)
    {
      if (l > paramLong * 1000L) {
        return l;
      }
      return paramLong * 1000L;
    }
  }
  
  public static int p(String paramString, long paramLong)
  {
    bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().O(paramString, paramLong);
    if (localbi.field_msgSvrId != paramLong) {
      return 0;
    }
    i(localbi);
    return ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().Y(paramString, paramLong);
  }
  
  public static abstract interface a
  {
    public abstract void xA();
    
    public abstract boolean xz();
  }
  
  public static final class b
  {
    public String dWA;
    public int dWB;
    public long dWC;
    public String dWD;
    public String dWE;
    public String dWF;
    public String dWG;
    public String dWH;
    public String dWI;
    public String dWJ;
    public int dWK;
    public int dWL;
    public int dWM;
    public int dWN;
    public String dWO;
    public String dWv;
    public int dWw;
    public int dWx;
    public int dWy;
    public String dWz;
    public int scene = 0;
    public String userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bd
 * JD-Core Version:    0.7.0.1
 */