package com.tencent.mm.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.g.d;
import com.tencent.mm.autogen.a.dj;
import com.tencent.mm.autogen.a.oo;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class br
{
  private static volatile boolean olF = false;
  
  public static long B(cc paramcc)
  {
    AppMethodBeat.i(42956);
    au localau = ((n)h.ax(n.class)).bzA().JE(paramcc.field_talker);
    if ((localau == null) || ((int)localau.maN == 0))
    {
      localau = new au(paramcc.field_talker);
      localau.setType(2);
      oo localoo = new oo();
      localoo.hRl.hRm = localau;
      localoo.publish();
      ((n)h.ax(n.class)).bzA().aB(localau);
    }
    long l = ((n)h.ax(n.class)).gaZ().ba(paramcc);
    AppMethodBeat.o(42956);
    return l;
  }
  
  public static void C(cc paramcc)
  {
    AppMethodBeat.i(241958);
    au localau = ((n)h.ax(n.class)).bzA().JE(paramcc.field_talker);
    if ((localau == null) || ((int)localau.maN == 0))
    {
      localau = new au(paramcc.field_talker);
      localau.setType(2);
      oo localoo = new oo();
      localoo.hRl.hRm = localau;
      localoo.publish();
      ((n)h.ax(n.class)).bzA().aB(localau);
    }
    ((n)h.ax(n.class)).gaZ().a(paramcc.field_msgId, paramcc);
    AppMethodBeat.o(241958);
  }
  
  public static long D(String paramString, long paramLong)
  {
    AppMethodBeat.i(42961);
    if (paramString != null)
    {
      paramString = ((n)h.ax(n.class)).gaZ().aLG(paramString);
      if (paramString == null) {}
    }
    for (long l = paramString.getCreateTime() + 1L;; l = 0L)
    {
      if (l > paramLong * 1000L)
      {
        AppMethodBeat.o(42961);
        return l;
      }
      AppMethodBeat.o(42961);
      return paramLong * 1000L;
    }
  }
  
  public static void D(cc paramcc)
  {
    AppMethodBeat.i(42962);
    if (paramcc == null)
    {
      AppMethodBeat.o(42962);
      return;
    }
    Object localObject = g.d.dB(Integer.valueOf(((an)h.ax(an.class)).va(paramcc.getType())));
    if (localObject != null) {
      ((g)localObject).b(new g.c(paramcc));
    }
    localObject = new dj();
    ((dj)localObject).hDo.msgId = paramcc.field_msgId;
    ((dj)localObject).hDo.talker = paramcc.field_talker;
    ((dj)localObject).hDo.msgType = paramcc.getType();
    ((dj)localObject).publish();
    AppMethodBeat.o(42962);
  }
  
  public static int E(String paramString, long paramLong)
  {
    AppMethodBeat.i(42965);
    cc localcc = ((n)h.ax(n.class)).gaZ().aU(paramString, paramLong);
    if ((localcc == null) || (localcc.field_msgSvrId != paramLong))
    {
      AppMethodBeat.o(42965);
      return 0;
    }
    D(localcc);
    int i = ((n)h.ax(n.class)).gaZ().be(paramString, paramLong);
    AppMethodBeat.o(42965);
    return i;
  }
  
  @Deprecated
  public static int JG(String paramString)
  {
    AppMethodBeat.i(163509);
    int i = JI(paramString);
    AppMethodBeat.o(163509);
    return i;
  }
  
  public static String JH(String paramString)
  {
    AppMethodBeat.i(42950);
    int i = JI(paramString);
    if (i != -1)
    {
      paramString = paramString.substring(i + 1).trim();
      AppMethodBeat.o(42950);
      return paramString;
    }
    AppMethodBeat.o(42950);
    return paramString;
  }
  
  private static int JI(String paramString)
  {
    AppMethodBeat.i(42952);
    if (paramString == null)
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
      AppMethodBeat.o(42952);
      return -1;
    }
    if (paramString.length() <= 0)
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
      AppMethodBeat.o(42952);
      return -1;
    }
    if (paramString.startsWith("~SEMI_XML~"))
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
      AppMethodBeat.o(42952);
      return -1;
    }
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.substring(0, i).contains("<")))
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
      AppMethodBeat.o(42952);
      return -1;
    }
    AppMethodBeat.o(42952);
    return i;
  }
  
  public static String JJ(String paramString)
  {
    AppMethodBeat.i(42953);
    int i = JI(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(42953);
      return null;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(42953);
    return paramString;
  }
  
  public static String JK(String paramString)
  {
    AppMethodBeat.i(42954);
    int i = JI(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(42954);
      return paramString;
    }
    if (i + 2 >= paramString.length())
    {
      AppMethodBeat.o(42954);
      return paramString;
    }
    paramString = paramString.substring(i + 2);
    AppMethodBeat.o(42954);
    return paramString;
  }
  
  public static int JL(String paramString)
  {
    AppMethodBeat.i(42957);
    int i = ((n)h.ax(n.class)).gaZ().JL(paramString);
    AppMethodBeat.o(42957);
    return i;
  }
  
  public static boolean JM(String paramString)
  {
    AppMethodBeat.i(42958);
    boolean bool = ((n)h.ax(n.class)).gaZ().JM(paramString);
    AppMethodBeat.o(42958);
    return bool;
  }
  
  public static long JN(String paramString)
  {
    AppMethodBeat.i(42960);
    long l = bCJ();
    Log.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", new Object[] { Long.valueOf(l) });
    if (paramString != null)
    {
      paramString = ((n)h.ax(n.class)).gaZ().aLG(paramString);
      if (paramString != null)
      {
        Log.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(l) });
        if (paramString.getCreateTime() + 1L > l)
        {
          l = paramString.getCreateTime();
          AppMethodBeat.o(42960);
          return l + 1L;
        }
      }
    }
    AppMethodBeat.o(42960);
    return l;
  }
  
  public static int JO(String paramString)
  {
    AppMethodBeat.i(42966);
    int i = ((n)h.ax(n.class)).gaZ().aLO(paramString);
    AppMethodBeat.o(42966);
    return i;
  }
  
  public static b JP(String paramString)
  {
    AppMethodBeat.i(42971);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42971);
      return null;
    }
    try
    {
      paramString = XmlParser.parseXml(paramString, "msgsource", null);
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(42971);
        return null;
      }
      b localb = new b();
      localb.olO = ((String)paramString.get(".msgsource.bizmsg.msgcluster"));
      localb.olS = ((String)paramString.get(".msgsource.kf.kf_worker"));
      localb.olT = Util.getInt((String)paramString.get(".msgsource.kf.kf_type_new"), 0);
      localb.olR = Util.nullAsNil((String)paramString.get(".msgsource.bizmsg.bizclientmsgid"));
      if (Util.isNullOrNil(localb.olR)) {
        localb.olR = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.climsgid"));
      }
      localb.olX = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.qy_msg_type"));
      localb.olY = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.chat_type"));
      localb.olZ = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.bizchat_id"));
      localb.oma = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.bizchat_ver"));
      localb.userId = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.user_id"));
      localb.omb = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.user_nickname"));
      localb.omc = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.sync_from_qy_im"));
      localb.olW = ((String)paramString.get(".msgsource.strangerantispamticket.$ticket"));
      localb.scene = Util.getInt((String)paramString.get(".msgsource.strangerantispamticket.$scene"), 0);
      localb.omd = ((String)paramString.get(".msgsource.NotAutoDownloadRange"));
      localb.ome = Util.getInt((String)paramString.get(".msgsource.DownloadLimitKbps"), 0);
      localb.omf = Util.getInt((String)paramString.get(".msgsource.videopreloadlen"), 0);
      localb.omg = Util.getInt((String)paramString.get(".msgsource.PreDownload"), 0);
      localb.omh = Util.getInt((String)paramString.get(".msgsource.PreDownloadNetType"), 0);
      localb.omi = ((String)paramString.get(".msgsource.NoPreDownloadRange"));
      localb.olP = Util.getInt((String)paramString.get(".msgsource.msg_cluster_type"), -1);
      localb.serviceType = Util.getInt((String)paramString.get(".msgsource.service_type"), -1);
      localb.olQ = Util.getInt((String)paramString.get(".msgsource.scene"), -1);
      localb.olU = Util.getInt((String)paramString.get(".msgsource.bizmsg.msg_predict"), 0);
      localb.olV = Util.getLong((String)paramString.get(".msgsource.bizflag"), 0L);
      AppMethodBeat.o(42971);
      return localb;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      Log.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(42971);
    }
    return null;
  }
  
  public static String JQ(String paramString)
  {
    AppMethodBeat.i(42972);
    paramString = JP(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(42972);
      return null;
    }
    paramString = paramString.olS;
    AppMethodBeat.o(42972);
    return paramString;
  }
  
  public static int a(String paramString, a parama)
  {
    AppMethodBeat.i(42967);
    Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", new Object[] { paramString, Util.getStack() });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] is null", new Object[] { paramString });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42942);
          if (br.this != null) {
            br.this.aMK();
          }
          AppMethodBeat.o(42942);
        }
      });
      AppMethodBeat.o(42967);
      return 0;
    }
    ThreadPool.post(new Runnable()
    {
      final int olG = 200;
      final int olH = 30;
      final int olI = 5;
      int olJ = 100;
      
      public final void run()
      {
        AppMethodBeat.i(42943);
        label497:
        for (;;)
        {
          try
          {
            Object localObject = ((n)h.ax(n.class)).gaZ().aLG(br.this);
            long l2;
            long l5;
            long l6;
            long l3;
            if (localObject == null)
            {
              l2 = 9223372036854775807L;
              ((n)h.ax(n.class)).bAd().aS(br.this, l2);
              Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), localObject, Long.valueOf(l2) });
              l5 = Util.nowMilliSecond();
              l1 = 0L;
              i = 0;
              if ((this.olJ < 200) && (this.olJ > 30))
              {
                if (l1 > 500L)
                {
                  j = this.olJ - 5;
                  this.olJ = j;
                }
              }
              else
              {
                l6 = Util.nowMilliSecond();
                localObject = ((n)h.ax(n.class)).gaZ().I(br.this, this.olJ, l2);
                l1 = 0L;
                l3 = 0L;
                if (!((Cursor)localObject).moveToNext()) {
                  continue;
                }
                cc localcc = new cc();
                localcc.convertFrom((Cursor)localObject);
                if (l1 >= localcc.getCreateTime()) {
                  break label497;
                }
                l1 = localcc.getCreateTime();
                l3 += 1L;
                br.D(localcc);
                continue;
              }
            }
            else
            {
              l2 = ((cc)localObject).getCreateTime();
              continue;
            }
            int j = this.olJ + 5;
            continue;
            ((Cursor)localObject).close();
            long l7 = Util.nowMilliSecond();
            if ((l1 > 0L) && (l3 > 0L))
            {
              ((n)h.ax(n.class)).gaZ().bf(br.this, l1);
              ((aw)h.ax(aw.class)).B(br.this, l1);
            }
            int i = (int)(i + l3);
            long l8 = Util.nowMilliSecond();
            long l4 = l8 - l6;
            Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", new Object[] { Util.secPrint(br.this), Integer.valueOf(i), Long.valueOf(l3), Long.valueOf(l2 - l1), Long.valueOf(l2), Long.valueOf(l8 - l7), Long.valueOf(l8 - l6), Long.valueOf(l8 - l5), Integer.valueOf(this.olJ) });
            long l1 = l4;
            if (l3 <= 0L)
            {
              AppMethodBeat.o(42943);
              return;
            }
          }
          catch (b localb)
          {
            Log.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", localb, "", new Object[0]);
            AppMethodBeat.o(42943);
            return;
          }
        }
      }
    }, "deleteMsgByTalker");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42944);
        if (br.this != null) {
          br.this.aMK();
        }
        AppMethodBeat.o(42944);
      }
    });
    AppMethodBeat.o(42967);
    return 0;
  }
  
  public static String a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(42975);
    String str = paramString;
    if (paramBoolean)
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = JK(paramString);
        }
      }
    }
    AppMethodBeat.o(42975);
    return str;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(42968);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42946);
        f.Ozc.idkeyStat(1333L, 0L, 1L, true);
        long l1 = System.currentTimeMillis();
        ((aw)h.ax(aw.class)).bCj();
        ((n)h.ax(n.class)).bAd().aS("", this.olL);
        ((n)h.ax(n.class)).bzG().jaK();
        if (this.oiY != null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42945);
              br.5.this.oiY.aMK();
              AppMethodBeat.o(42945);
            }
          });
        }
        long l2 = System.currentTimeMillis() - l1;
        Log.i("MicroMsg.MsgInfoStorageLogic", "Delete all messages, synchronized part, time: %d ms", new Object[] { Long.valueOf(l2) });
        f.Ozc.idkeyStat(1333L, 6L, l2 / 1000L, true);
        if ((this.oiY != null) && (this.oiY.aMJ()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        br.bCM();
        if ((this.oiY != null) && (this.oiY.aMJ()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        br.bCN();
        if ((this.oiY != null) && (this.oiY.aMJ()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        br.bCL();
        if ((this.oiY != null) && (this.oiY.aMJ()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        br.m(this.olL, 1);
        ((n)h.ax(n.class)).bAd().aS("", 0L);
        Log.i("MicroMsg.MsgInfoStorageLogic", "Delete all messages, asynchronous part, time: %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1 - l2) });
        AppMethodBeat.o(42946);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(42947);
        String str = super.toString() + "|deleteAllMsg";
        AppMethodBeat.o(42947);
        return str;
      }
    }, "deleteAllMsg");
    AppMethodBeat.o(42968);
  }
  
  public static void a(cc paramcc, g.a parama)
  {
    AppMethodBeat.i(42973);
    if ((paramcc == null) || (parama == null) || (parama.mpN == null))
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", new Object[] { Util.getStack() });
      AppMethodBeat.o(42973);
      return;
    }
    if (paramcc.field_msgSvrId != parama.mpN.Njv)
    {
      AppMethodBeat.o(42973);
      return;
    }
    dl localdl = parama.mpN;
    if ((paramcc.field_isSend != 0) && (localdl.YFL == 0))
    {
      if ((paramcc.field_msgId == 0L) && (parama.otP))
      {
        if (Log.getLogLevel() <= 1) {
          Log.i("MicroMsg.MsgInfoStorageLogic", "fixRecvMsgWithAddMsgInfo fixtime case 1, fixTime:%s content:%s", new Object[] { Long.valueOf(parama.otQ), paramcc.field_content });
        }
        paramcc.setCreateTime(parama.otQ);
      }
      AppMethodBeat.o(42973);
      return;
    }
    if ((paramcc.field_msgSeq == 0L) && (localdl.YFL != 0)) {
      paramcc.gZ(localdl.YFL);
    }
    int i = paramcc.field_flag;
    if (parama.otM)
    {
      i |= 0x2;
      if (!parama.otN) {
        break label304;
      }
      i |= 0x1;
      label206:
      if (!parama.otO) {
        break label312;
      }
      i |= 0x4;
    }
    for (;;)
    {
      paramcc.setFlag(i);
      if ((paramcc.field_msgId == 0L) && ((parama.otM) || (parama.otP)))
      {
        if (Log.getLogLevel() <= 1) {
          Log.i("MicroMsg.MsgInfoStorageLogic", "fixRecvMsgWithAddMsgInfo fixtime case 2 fixTime:%s content:%s", new Object[] { Long.valueOf(parama.otQ), paramcc.field_content });
        }
        paramcc.setCreateTime(parama.otQ);
      }
      AppMethodBeat.o(42973);
      return;
      i &= 0xFFFFFFFD;
      break;
      label304:
      i &= 0xFFFFFFFE;
      break label206;
      label312:
      i &= 0xFFFFFFFB;
    }
  }
  
  public static int aO(String paramString, int paramInt)
  {
    AppMethodBeat.i(174544);
    Cursor localCursor = ((n)h.ax(n.class)).gaZ().fX(paramString, paramInt);
    if (localCursor.moveToFirst()) {
      while (!localCursor.isAfterLast())
      {
        cc localcc = new cc();
        localcc.convertFrom(localCursor);
        D(localcc);
        localCursor.moveToNext();
      }
    }
    localCursor.close();
    paramInt = ((n)h.ax(n.class)).gaZ().fW(paramString, paramInt);
    AppMethodBeat.o(174544);
    return paramInt;
  }
  
  public static void bCI()
  {
    AppMethodBeat.i(42955);
    ((n)h.ax(n.class)).gaZ().bCI();
    AppMethodBeat.o(42955);
  }
  
  public static long bCJ()
  {
    AppMethodBeat.i(42959);
    long l1 = System.currentTimeMillis();
    long l2 = cn.bDv();
    if (Math.abs(l1 - l2) > 300000L) {
      Log.w("MicroMsg.MsgInfoStorageLogic", "[getFixTime] nowServer:" + l2 + " now:" + l1);
    }
    AppMethodBeat.o(42959);
    return l2;
  }
  
  public static int bCK()
  {
    AppMethodBeat.i(174543);
    if (olF)
    {
      Log.i("MicroMsg.MsgInfoStorageLogic", "checkUnfinishedDeleteMsgTask already started.");
      AppMethodBeat.o(174543);
      return -1;
    }
    Map localMap = ((n)h.ax(n.class)).bAd().gbc();
    if (localMap.isEmpty())
    {
      Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
      AppMethodBeat.o(174543);
      return 0;
    }
    ThreadPool.post(new Runnable()
    {
      final int olG = 200;
      final int olH = 30;
      final int olI = 5;
      int olJ = 100;
      
      public final void run()
      {
        AppMethodBeat.i(42941);
        br.access$002(true);
        Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask run currentThread[%s, %d] talkers size:%s", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(br.this.size()) });
        if (br.this.containsKey(""))
        {
          br.m(((Long)br.this.get("")).longValue(), 2);
          br.this.remove("");
          ((n)h.ax(n.class)).bAd().aS("", 0L);
        }
        Iterator localIterator = br.this.entrySet().iterator();
        Object localObject;
        String str;
        long l4;
        long l5;
        long l1;
        int i;
        while (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          str = (String)((Map.Entry)localObject).getKey();
          l4 = ((Long)((Map.Entry)localObject).getValue()).longValue();
          if (l4 > 0L)
          {
            l5 = Util.nowMilliSecond();
            l1 = 0L;
            i = 0;
          }
        }
        for (;;)
        {
          if ((this.olJ < 200) && (this.olJ > 30)) {
            if (l1 <= 500L) {
              break label348;
            }
          }
          long l6;
          long l2;
          label348:
          for (int j = this.olJ - 5;; j = this.olJ + 5)
          {
            this.olJ = j;
            l6 = Util.nowMilliSecond();
            localObject = ((n)h.ax(n.class)).gaZ().I(str, this.olJ, l4);
            l2 = 0L;
            l1 = 0L;
            while (((Cursor)localObject).moveToNext())
            {
              cc localcc = new cc();
              localcc.convertFrom((Cursor)localObject);
              l3 = l2;
              if (l2 < localcc.getCreateTime()) {
                l3 = localcc.getCreateTime();
              }
              br.D(localcc);
              l1 = 1L + l1;
              l2 = l3;
            }
          }
          ((Cursor)localObject).close();
          long l7 = Util.nowMilliSecond();
          if ((l2 > 0L) && (l1 > 0L))
          {
            ((n)h.ax(n.class)).gaZ().bf(str, l2);
            ((aw)h.ax(aw.class)).B(str, l2);
          }
          i = (int)(i + l1);
          long l8 = Util.nowMilliSecond();
          long l3 = l8 - l6;
          Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", new Object[] { Util.secPrint(str), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l4 - l2), Long.valueOf(l4), Long.valueOf(l8 - l7), Long.valueOf(l8 - l6), Long.valueOf(l8 - l5), Integer.valueOf(this.olJ) });
          if (l1 <= 0L)
          {
            ((n)h.ax(n.class)).bAd().aS(str, 0L);
            break;
            Log.i("MicroMsg.MsgInfoStorageLogic", "Done checkUnfinishedDeleteMsgTask");
            br.access$002(false);
            AppMethodBeat.o(42941);
            return;
          }
          l1 = l3;
        }
      }
    }, "checkUnfinishedDeleteMsgTask");
    int i = localMap.size();
    AppMethodBeat.o(174543);
    return i;
  }
  
  public static void bCL()
  {
    AppMethodBeat.i(174545);
    List localList = ((n)h.ax(n.class)).gaZ().aLL("bottlemessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        D((cc)localList.get(i));
        i += 1;
      }
    }
    ((n)h.ax(n.class)).gaZ().aLN("bottlemessage");
    AppMethodBeat.o(174545);
  }
  
  public static void bCM()
  {
    AppMethodBeat.i(42969);
    List localList = ((n)h.ax(n.class)).gaZ().aLL("qmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        D((cc)localList.get(i));
        i += 1;
      }
    }
    ((n)h.ax(n.class)).gaZ().aLN("qmessage");
    AppMethodBeat.o(42969);
  }
  
  public static void bCN()
  {
    AppMethodBeat.i(42970);
    List localList = ((n)h.ax(n.class)).gaZ().aLL("tmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        D((cc)localList.get(i));
        i += 1;
      }
    }
    ((n)h.ax(n.class)).gaZ().aLN("tmessage");
    AppMethodBeat.o(42970);
  }
  
  public static void bU(List<Long> paramList)
  {
    AppMethodBeat.i(42963);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(42963);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      iu(((Long)paramList.next()).longValue());
    }
    AppMethodBeat.o(42963);
  }
  
  public static void bV(List<String> paramList)
  {
    AppMethodBeat.i(174547);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
      AppMethodBeat.o(174547);
      return;
    }
    Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", new Object[] { Util.getStack() });
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42948);
        Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] talkers size:%s", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(br.this.size()) });
        Iterator localIterator = br.this.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = ((n)h.ax(n.class)).gaZ().aLG(str);
          if (localObject == null) {}
          for (long l1 = 9223372036854775807L;; l1 = ((cc)localObject).getCreateTime())
          {
            long l3 = cn.bDu();
            long l2 = l1;
            if (l1 > l3)
            {
              Log.w("MicroMsg.MsgInfoStorageLogic", "last message time[%s] is over serverTime[%s]!", new Object[] { Long.valueOf(l1), Long.valueOf(l3) });
              l2 = l3;
            }
            if ((localObject != null) && (((cc)localObject).getCreateTime() > 0L)) {
              ((n)h.ax(n.class)).bAd().aS(str, l2);
            }
            Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker talker[%s] lastMsg[%s] lastMsgCreateTime[%s]", new Object[] { str, localObject, Long.valueOf(l2) });
            localObject = ((n)h.ax(n.class)).gaZ().aLQ(str);
            if (localObject == null) {
              break;
            }
            if (!((Cursor)localObject).moveToFirst()) {
              break label312;
            }
            while (!((Cursor)localObject).isAfterLast())
            {
              cc localcc = new cc();
              localcc.convertFrom((Cursor)localObject);
              br.D(localcc);
              ((Cursor)localObject).moveToNext();
            }
          }
          label312:
          ((Cursor)localObject).close();
          Log.i("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", new Object[] { str, Integer.valueOf(((n)h.ax(n.class)).gaZ().aLO(str)) });
          ((n)h.ax(n.class)).bAd().aS(str, 0L);
        }
        AppMethodBeat.o(42948);
      }
    }, "deleteMsgByTalkers");
    AppMethodBeat.o(174547);
  }
  
  public static String bd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42951);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42951);
      return null;
    }
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(42951);
      return paramString1;
    }
    paramString1 = paramString2 + ": " + paramString1;
    AppMethodBeat.o(42951);
    return paramString1;
  }
  
  public static boolean c(g.a parama)
  {
    AppMethodBeat.i(42974);
    if ((parama == null) || (parama.mpN == null))
    {
      AppMethodBeat.o(42974);
      return false;
    }
    dl localdl = parama.mpN;
    Object localObject = w.a(localdl.YFE);
    localObject = ((n)h.ax(n.class)).gaZ().aU((String)localObject, localdl.Njv);
    if ((localObject == null) || (((fi)localObject).field_msgId == 0L))
    {
      AppMethodBeat.o(42974);
      return false;
    }
    if ((((fi)localObject).field_isSend != 0) && (localdl.YFL == 0))
    {
      AppMethodBeat.o(42974);
      return false;
    }
    int i = ((fi)localObject).field_flag;
    if (parama.otM)
    {
      i |= 0x2;
      if (!parama.otN) {
        break label234;
      }
      i |= 0x1;
      label132:
      if (!parama.otO) {
        break label242;
      }
      i |= 0x4;
    }
    for (;;)
    {
      if (i == ((fi)localObject).field_flag) {
        break label250;
      }
      Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", new Object[] { Integer.valueOf(localdl.IIs), Integer.valueOf(i), Integer.valueOf(((fi)localObject).field_flag) });
      ((cc)localObject).setFlag(i);
      ((n)h.ax(n.class)).gaZ().b(((fi)localObject).field_msgSvrId, (cc)localObject);
      AppMethodBeat.o(42974);
      return true;
      i &= 0xFFFFFFFD;
      break;
      label234:
      i &= 0xFFFFFFFE;
      break label132;
      label242:
      i &= 0xFFFFFFFB;
    }
    label250:
    AppMethodBeat.o(42974);
    return false;
  }
  
  public static int d(g.a parama)
  {
    int j = 0;
    if (parama.otM) {
      j = 2;
    }
    int i = j;
    if (parama.otN) {
      i = j | 0x1;
    }
    j = i;
    if (parama.otO) {
      j = i | 0x4;
    }
    return j;
  }
  
  public static int iu(long paramLong)
  {
    AppMethodBeat.i(42964);
    cc localcc = ((n)h.ax(n.class)).gaZ().sl(paramLong);
    if ((localcc == null) || (localcc.field_msgId != paramLong))
    {
      AppMethodBeat.o(42964);
      return 0;
    }
    D(localcc);
    int i = ((n)h.ax(n.class)).gaZ().sm(paramLong);
    AppMethodBeat.o(42964);
    return i;
  }
  
  public static long m(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(42976);
    long l3 = paramLong1 * 1000L;
    paramLong1 = 0L;
    long l2 = -1L;
    long l1 = paramLong1;
    cc localcc;
    if (paramString != null)
    {
      localcc = ((n)h.ax(n.class)).gaZ().aLG(paramString);
      if (localcc != null) {
        paramLong1 = localcc.getCreateTime();
      }
      l2 = ((n)h.ax(n.class)).gaZ().aLZ(paramString);
      l1 = paramLong1;
    }
    if (l2 == l1)
    {
      if (l3 == l1)
      {
        AppMethodBeat.o(42976);
        return l3 + 1L;
      }
      AppMethodBeat.o(42976);
      return l3;
    }
    if (l2 < l1)
    {
      if (l3 == l2)
      {
        AppMethodBeat.o(42976);
        return l3 - 1L;
      }
      if (l3 == l1)
      {
        AppMethodBeat.o(42976);
        return l3 + 1L;
      }
      if ((paramLong2 == 0L) || (l3 > l1))
      {
        AppMethodBeat.o(42976);
        return l3;
      }
      localcc = ((n)h.ax(n.class)).gaZ().aW(paramString, l3);
      if ((localcc != null) && (localcc.field_msgSeq != 0L) && (localcc.field_msgSeq != paramLong2))
      {
        Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] need fix serverMillTime[%d, %d]", new Object[] { Long.valueOf(localcc.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localcc.getCreateTime()), Long.valueOf(l3) });
        if (paramLong2 < localcc.field_msgSeq)
        {
          paramString = ((n)h.ax(n.class)).gaZ().aY(paramString, l3 - 1000L);
          if ((paramString == null) || (paramString.field_msgSeq == 0L) || (paramString.field_msgSeq == paramLong2)) {
            break label475;
          }
          if (paramString.field_msgSeq >= paramLong2) {
            break label465;
          }
          paramLong1 = paramString.getCreateTime() + 1L;
          label359:
          Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d, %d] need fix serverMillTime[%d, %d, %d] done", new Object[] { Long.valueOf(localcc.field_msgSeq), Long.valueOf(paramString.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localcc.getCreateTime()), Long.valueOf(paramString.getCreateTime()), Long.valueOf(paramLong1) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(42976);
        return paramLong1;
        paramString = ((n)h.ax(n.class)).gaZ().aX(paramString, 1000L + l3);
        break;
        label465:
        paramLong1 = paramString.getCreateTime() - 1L;
        break label359;
        label475:
        Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] no need fix serverMillTime[%d, %d]", new Object[] { Long.valueOf(localcc.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localcc.getCreateTime()), Long.valueOf(l3) });
        paramLong1 = l3;
      }
    }
    Log.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
    AppMethodBeat.o(42976);
    return l3;
  }
  
  /* Error */
  public static void m(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 806
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 624	java/lang/System:currentTimeMillis	()J
    //   9: pop2
    //   10: iconst_0
    //   11: istore_3
    //   12: iconst_0
    //   13: istore 4
    //   15: iconst_0
    //   16: istore 5
    //   18: iconst_0
    //   19: istore 6
    //   21: iload_2
    //   22: iconst_1
    //   23: if_icmpne +6 -> 29
    //   26: invokestatic 809	com/tencent/mm/model/br$c:reset	()V
    //   29: new 26	com/tencent/mm/model/br$c
    //   32: dup
    //   33: invokespecial 810	com/tencent/mm/model/br$c:<init>	()V
    //   36: astore 11
    //   38: ldc 45
    //   40: invokestatic 51	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   43: checkcast 45	com/tencent/mm/plugin/messenger/foundation/a/n
    //   46: invokeinterface 108 1 0
    //   51: ldc_w 812
    //   54: lload_0
    //   55: invokeinterface 816 4 0
    //   60: astore 12
    //   62: aload 11
    //   64: invokestatic 624	java/lang/System:currentTimeMillis	()J
    //   67: putfield 819	com/tencent/mm/model/br$c:oml	J
    //   70: iconst_0
    //   71: istore 7
    //   73: iconst_0
    //   74: istore 8
    //   76: aload 12
    //   78: invokeinterface 606 1 0
    //   83: ifeq +241 -> 324
    //   86: new 134	com/tencent/mm/storage/cc
    //   89: dup
    //   90: invokespecial 599	com/tencent/mm/storage/cc:<init>	()V
    //   93: astore 13
    //   95: aload 13
    //   97: aload 12
    //   99: invokevirtual 603	com/tencent/mm/storage/cc:convertFrom	(Landroid/database/Cursor;)V
    //   102: aload 13
    //   104: invokevirtual 147	com/tencent/mm/storage/cc:getType	()I
    //   107: istore 9
    //   109: iload 9
    //   111: tableswitch	default:+755 -> 866, -1879048191:+94->205, -1879048190:+94->205, -1879048189:+94->205
    //   137: fconst_2
    //   138: invokestatic 204	com/tencent/mm/model/br:D	(Lcom/tencent/mm/storage/cc;)V
    //   141: iload 7
    //   143: iconst_1
    //   144: iadd
    //   145: istore 9
    //   147: iload 9
    //   149: istore 7
    //   151: iload 9
    //   153: bipush 100
    //   155: if_icmplt +19 -> 174
    //   158: aload 11
    //   160: invokevirtual 822	com/tencent/mm/model/br$c:end	()V
    //   163: aload 11
    //   165: invokestatic 624	java/lang/System:currentTimeMillis	()J
    //   168: putfield 819	com/tencent/mm/model/br$c:oml	J
    //   171: iconst_0
    //   172: istore 7
    //   174: iload 5
    //   176: istore 9
    //   178: iload 6
    //   180: istore 10
    //   182: iload 8
    //   184: iconst_1
    //   185: iadd
    //   186: istore 8
    //   188: iload_3
    //   189: istore 6
    //   191: iload 4
    //   193: istore 5
    //   195: iload 9
    //   197: istore 4
    //   199: iload 10
    //   201: istore_3
    //   202: goto -126 -> 76
    //   205: bipush 49
    //   207: istore 9
    //   209: goto +657 -> 866
    //   212: iload 4
    //   214: istore 9
    //   216: iload_3
    //   217: iconst_1
    //   218: iadd
    //   219: istore 10
    //   221: iload 6
    //   223: istore_3
    //   224: iload 5
    //   226: istore 4
    //   228: iload 9
    //   230: istore 5
    //   232: iload 10
    //   234: istore 6
    //   236: goto -100 -> 136
    //   239: iload 4
    //   241: iconst_1
    //   242: iadd
    //   243: istore 10
    //   245: iload_3
    //   246: istore 9
    //   248: iload 6
    //   250: istore_3
    //   251: iload 5
    //   253: istore 4
    //   255: iload 10
    //   257: istore 5
    //   259: iload 9
    //   261: istore 6
    //   263: goto -127 -> 136
    //   266: iload 5
    //   268: iconst_1
    //   269: iadd
    //   270: istore 10
    //   272: iload 4
    //   274: istore 5
    //   276: iload_3
    //   277: istore 9
    //   279: iload 6
    //   281: istore_3
    //   282: iload 10
    //   284: istore 4
    //   286: iload 9
    //   288: istore 6
    //   290: goto -154 -> 136
    //   293: iload 6
    //   295: iconst_1
    //   296: iadd
    //   297: istore 10
    //   299: iload 4
    //   301: istore 6
    //   303: iload_3
    //   304: istore 9
    //   306: iload 10
    //   308: istore_3
    //   309: iload 5
    //   311: istore 4
    //   313: iload 6
    //   315: istore 5
    //   317: iload 9
    //   319: istore 6
    //   321: goto -185 -> 136
    //   324: aload 12
    //   326: ifnull +10 -> 336
    //   329: aload 12
    //   331: invokeinterface 609 1 0
    //   336: aload 11
    //   338: invokevirtual 822	com/tencent/mm/model/br$c:end	()V
    //   341: aload 11
    //   343: invokestatic 624	java/lang/System:currentTimeMillis	()J
    //   346: putfield 819	com/tencent/mm/model/br$c:oml	J
    //   349: ldc 45
    //   351: invokestatic 51	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   354: checkcast 45	com/tencent/mm/plugin/messenger/foundation/a/n
    //   357: invokeinterface 108 1 0
    //   362: ldc_w 812
    //   365: lload_0
    //   366: invokeinterface 824 4 0
    //   371: istore 9
    //   373: aload 11
    //   375: invokevirtual 822	com/tencent/mm/model/br$c:end	()V
    //   378: getstatic 830	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   381: sipush 1333
    //   384: bipush 10
    //   386: iconst_3
    //   387: iload 9
    //   389: iconst_1
    //   390: invokevirtual 833	com/tencent/mm/plugin/report/f:c	(IIIIZ)V
    //   393: aload 11
    //   395: getfield 836	com/tencent/mm/model/br$c:omk	J
    //   398: lstore_0
    //   399: getstatic 830	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   402: ldc2_w 837
    //   405: ldc2_w 839
    //   408: lload_0
    //   409: ldc2_w 139
    //   412: ldiv
    //   413: iconst_1
    //   414: invokevirtual 844	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   417: iload_2
    //   418: iconst_1
    //   419: if_icmpne +550 -> 969
    //   422: getstatic 830	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   425: ldc2_w 837
    //   428: lconst_1
    //   429: lconst_1
    //   430: iconst_1
    //   431: invokevirtual 844	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   434: goto +535 -> 969
    //   437: getstatic 830	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   440: ldc2_w 837
    //   443: iload 7
    //   445: i2l
    //   446: lconst_1
    //   447: iconst_1
    //   448: invokevirtual 844	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   451: lload_0
    //   452: ldc2_w 845
    //   455: lcmp
    //   456: iflt +331 -> 787
    //   459: bipush 36
    //   461: istore 7
    //   463: getstatic 830	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   466: ldc2_w 837
    //   469: iload 7
    //   471: i2l
    //   472: lconst_1
    //   473: iconst_1
    //   474: invokevirtual 844	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   477: iload 9
    //   479: ifle +21 -> 500
    //   482: getstatic 830	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   485: ldc2_w 837
    //   488: ldc2_w 847
    //   491: lload_0
    //   492: iload 9
    //   494: i2l
    //   495: ldiv
    //   496: iconst_1
    //   497: invokevirtual 844	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   500: getstatic 830	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   503: sipush 18923
    //   506: bipush 8
    //   508: anewarray 4	java/lang/Object
    //   511: dup
    //   512: iconst_0
    //   513: lload_0
    //   514: invokestatic 291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   517: aastore
    //   518: dup
    //   519: iconst_1
    //   520: iload_2
    //   521: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: aastore
    //   525: dup
    //   526: iconst_2
    //   527: iconst_0
    //   528: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   531: aastore
    //   532: dup
    //   533: iconst_3
    //   534: iload 8
    //   536: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   539: aastore
    //   540: dup
    //   541: iconst_4
    //   542: iload_3
    //   543: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: dup
    //   548: iconst_5
    //   549: iload 4
    //   551: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   554: aastore
    //   555: dup
    //   556: bipush 6
    //   558: iload 5
    //   560: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: aastore
    //   564: dup
    //   565: bipush 7
    //   567: iload 6
    //   569: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   572: aastore
    //   573: invokevirtual 851	com/tencent/mm/plugin/report/f:b	(I[Ljava/lang/Object;)V
    //   576: ldc 231
    //   578: ldc_w 853
    //   581: bipush 6
    //   583: anewarray 4	java/lang/Object
    //   586: dup
    //   587: iconst_0
    //   588: lload_0
    //   589: invokestatic 291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   592: aastore
    //   593: dup
    //   594: iconst_1
    //   595: iload 8
    //   597: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   600: aastore
    //   601: dup
    //   602: iconst_2
    //   603: iload_3
    //   604: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   607: aastore
    //   608: dup
    //   609: iconst_3
    //   610: iload 4
    //   612: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: aastore
    //   616: dup
    //   617: iconst_4
    //   618: iload 5
    //   620: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   623: aastore
    //   624: dup
    //   625: iconst_5
    //   626: iload 6
    //   628: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   631: aastore
    //   632: invokestatic 294	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: aload 11
    //   637: invokevirtual 854	com/tencent/mm/model/br$c:close	()V
    //   640: invokestatic 809	com/tencent/mm/model/br$c:reset	()V
    //   643: ldc_w 806
    //   646: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   649: return
    //   650: astore 13
    //   652: aload 12
    //   654: ifnull +10 -> 664
    //   657: aload 12
    //   659: invokeinterface 609 1 0
    //   664: ldc_w 806
    //   667: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   670: aload 13
    //   672: athrow
    //   673: astore 12
    //   675: aload 11
    //   677: invokevirtual 854	com/tencent/mm/model/br$c:close	()V
    //   680: ldc_w 806
    //   683: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   686: aload 12
    //   688: athrow
    //   689: astore 11
    //   691: ldc 231
    //   693: aload 11
    //   695: ldc_w 856
    //   698: iconst_0
    //   699: anewarray 4	java/lang/Object
    //   702: invokestatic 860	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   705: goto -65 -> 640
    //   708: astore 12
    //   710: aload 13
    //   712: aload 12
    //   714: invokevirtual 866	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   717: goto -53 -> 664
    //   720: iload 9
    //   722: ldc_w 867
    //   725: if_icmplt +10 -> 735
    //   728: bipush 25
    //   730: istore 7
    //   732: goto -295 -> 437
    //   735: iload 9
    //   737: ldc_w 868
    //   740: if_icmplt +10 -> 750
    //   743: bipush 24
    //   745: istore 7
    //   747: goto -310 -> 437
    //   750: iload 9
    //   752: sipush 10000
    //   755: if_icmplt +10 -> 765
    //   758: bipush 23
    //   760: istore 7
    //   762: goto -325 -> 437
    //   765: iload 9
    //   767: sipush 1000
    //   770: if_icmplt +10 -> 780
    //   773: bipush 22
    //   775: istore 7
    //   777: goto -340 -> 437
    //   780: bipush 21
    //   782: istore 7
    //   784: goto -347 -> 437
    //   787: lload_0
    //   788: ldc2_w 869
    //   791: lcmp
    //   792: iflt +10 -> 802
    //   795: bipush 35
    //   797: istore 7
    //   799: goto -336 -> 463
    //   802: lload_0
    //   803: ldc2_w 871
    //   806: lcmp
    //   807: iflt +10 -> 817
    //   810: bipush 34
    //   812: istore 7
    //   814: goto -351 -> 463
    //   817: lload_0
    //   818: ldc2_w 873
    //   821: lcmp
    //   822: iflt +10 -> 832
    //   825: bipush 33
    //   827: istore 7
    //   829: goto -366 -> 463
    //   832: lload_0
    //   833: ldc2_w 875
    //   836: lcmp
    //   837: iflt +10 -> 847
    //   840: bipush 32
    //   842: istore 7
    //   844: goto -381 -> 463
    //   847: bipush 31
    //   849: istore 7
    //   851: goto -388 -> 463
    //   854: astore 11
    //   856: aload 12
    //   858: aload 11
    //   860: invokevirtual 866	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   863: goto -183 -> 680
    //   866: iload 9
    //   868: lookupswitch	default:+76->944, 3:+-629->239, 23:+-629->239, 34:+-575->293, 43:+-602->266, 44:+-602->266, 49:+-656->212, 62:+-602->266, 486539313:+-602->266
    //   945: iconst_1
    //   946: istore 9
    //   948: iload_3
    //   949: istore 10
    //   951: iload 6
    //   953: istore_3
    //   954: iload 5
    //   956: istore 4
    //   958: iload 9
    //   960: istore 5
    //   962: iload 10
    //   964: istore 6
    //   966: goto -830 -> 136
    //   969: iload 9
    //   971: ldc_w 877
    //   974: if_icmplt -254 -> 720
    //   977: bipush 26
    //   979: istore 7
    //   981: goto -544 -> 437
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	984	0	paramLong	long
    //   0	984	2	paramInt	int
    //   11	943	3	i	int
    //   13	944	4	j	int
    //   16	945	5	k	int
    //   19	946	6	m	int
    //   71	909	7	n	int
    //   74	522	8	i1	int
    //   107	868	9	i2	int
    //   180	783	10	i3	int
    //   36	640	11	localc	c
    //   689	5	11	localIOException	IOException
    //   854	5	11	localThrowable1	java.lang.Throwable
    //   60	598	12	localCursor	Cursor
    //   673	14	12	localObject1	Object
    //   708	149	12	localThrowable2	java.lang.Throwable
    //   93	44	13	localcc	cc
    //   650	61	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   62	70	650	finally
    //   76	109	650	finally
    //   136	141	650	finally
    //   158	171	650	finally
    //   38	62	673	finally
    //   329	336	673	finally
    //   336	417	673	finally
    //   422	434	673	finally
    //   437	451	673	finally
    //   463	477	673	finally
    //   482	500	673	finally
    //   500	635	673	finally
    //   664	673	673	finally
    //   710	717	673	finally
    //   29	38	689	java/io/IOException
    //   635	640	689	java/io/IOException
    //   680	689	689	java/io/IOException
    //   856	863	689	java/io/IOException
    //   657	664	708	finally
    //   675	680	854	finally
  }
  
  public static boolean vj(int paramInt)
  {
    switch (paramInt)
    {
    case 25: 
    default: 
      return false;
    }
    return true;
  }
  
  public static abstract interface a
  {
    public abstract boolean aMJ();
    
    public abstract void aMK();
  }
  
  public static final class b
  {
    public String olO;
    public int olP;
    public int olQ;
    public String olR;
    public String olS;
    public int olT;
    public int olU;
    public long olV;
    public String olW;
    @Deprecated
    public String olX;
    public String olY;
    public String olZ;
    public String oma;
    public String omb;
    public String omc;
    public String omd;
    public int ome;
    public int omf;
    public int omg;
    public int omh;
    public String omi;
    public int scene = 0;
    public int serviceType;
    public String userId;
  }
  
  static final class c
    implements Closeable
  {
    ByteBuffer OQ;
    FileChannel omj;
    long omk;
    long oml;
    
    c()
    {
      AppMethodBeat.i(178869);
      u localu = new u(MMApplicationContext.getContext().getCacheDir(), "asyncClearMsgStat");
      try
      {
        this.omj = y.a(localu.mUri, true).getChannel();
        this.OQ = ByteBuffer.allocate(8);
        this.omj.read(this.OQ, 0L);
        if (this.OQ.remaining() == 8) {
          this.omk = this.OQ.getLong(0);
        }
        this.OQ.clear();
        AppMethodBeat.o(178869);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", localIOException, "Cannot init time statistics", new Object[0]);
        ah.closeQuietly(this.omj);
        this.omj = null;
        AppMethodBeat.o(178869);
      }
    }
    
    static void reset()
    {
      AppMethodBeat.i(178872);
      new u(MMApplicationContext.getContext().getCacheDir(), "asyncClearMsgStat").diJ();
      AppMethodBeat.o(178872);
    }
    
    public final void close()
    {
      AppMethodBeat.i(178871);
      this.omj.close();
      AppMethodBeat.o(178871);
    }
    
    final void end()
    {
      AppMethodBeat.i(178870);
      if (this.oml == 0L)
      {
        AppMethodBeat.o(178870);
        return;
      }
      this.omk = (System.currentTimeMillis() - this.oml + this.omk);
      if (this.omj != null) {
        this.OQ.putLong(0, this.omk);
      }
      try
      {
        this.omj.write(this.OQ, 0L);
        this.OQ.clear();
        this.oml = 0L;
        AppMethodBeat.o(178870);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MsgInfoStorageLogic", "Cannot update time statistics: " + localIOException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.br
 * JD-Core Version:    0.7.0.1
 */