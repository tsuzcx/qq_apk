package com.tencent.mm.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
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

public final class bi
{
  private static volatile boolean hol = false;
  
  public static int A(String paramString, long paramLong)
  {
    AppMethodBeat.i(42965);
    bo localbo = ((k)g.ab(k.class)).dcr().aF(paramString, paramLong);
    if (localbo.field_msgSvrId != paramLong)
    {
      AppMethodBeat.o(42965);
      return 0;
    }
    v(localbo);
    int i = ((k)g.ab(k.class)).dcr().aR(paramString, paramLong);
    AppMethodBeat.o(42965);
    return i;
  }
  
  public static int a(String paramString, a parama)
  {
    AppMethodBeat.i(42967);
    ac.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", new Object[] { paramString, bs.eWi() });
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] is null", new Object[] { paramString });
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42942);
          if (this.hmC != null) {
            this.hmC.Ws();
          }
          AppMethodBeat.o(42942);
        }
      });
      AppMethodBeat.o(42967);
      return 0;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      final int hom = 200;
      final int hon = 30;
      final int hoo = 5;
      int hop = 100;
      
      public final void run()
      {
        AppMethodBeat.i(42943);
        label497:
        for (;;)
        {
          try
          {
            Object localObject = ((k)g.ab(k.class)).dcr().alk(this.fLg);
            long l2;
            long l5;
            long l6;
            long l3;
            if (localObject == null)
            {
              l2 = 9223372036854775807L;
              ((k)g.ab(k.class)).axd().aD(this.fLg, l2);
              ac.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), localObject, Long.valueOf(l2) });
              l5 = bs.eWj();
              l1 = 0L;
              i = 0;
              if ((this.hop < 200) && (this.hop > 30))
              {
                if (l1 > 500L)
                {
                  j = this.hop - 5;
                  this.hop = j;
                }
              }
              else
              {
                l6 = bs.eWj();
                localObject = ((k)g.ab(k.class)).dcr().m(this.fLg, this.hop, l2);
                l1 = 0L;
                l3 = 0L;
                if (!((Cursor)localObject).moveToNext()) {
                  continue;
                }
                bo localbo = new bo();
                localbo.convertFrom((Cursor)localObject);
                if (l1 >= localbo.field_createTime) {
                  break label497;
                }
                l1 = localbo.field_createTime;
                l3 += 1L;
                bi.v(localbo);
                continue;
              }
            }
            else
            {
              l2 = ((dy)localObject).field_createTime;
              continue;
            }
            int j = this.hop + 5;
            continue;
            ((Cursor)localObject).close();
            long l7 = bs.eWj();
            if ((l1 > 0L) && (l3 > 0L))
            {
              ((k)g.ab(k.class)).dcr().aS(this.fLg, l1);
              ((an)g.ab(an.class)).x(this.fLg, l1);
            }
            int i = (int)(i + l3);
            long l8 = bs.eWj();
            long l4 = l8 - l6;
            ac.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", new Object[] { bs.aLJ(this.fLg), Integer.valueOf(i), Long.valueOf(l3), Long.valueOf(l2 - l1), Long.valueOf(l2), Long.valueOf(l8 - l7), Long.valueOf(l8 - l6), Long.valueOf(l8 - l5), Integer.valueOf(this.hop) });
            long l1 = l4;
            if (l3 <= 0L)
            {
              AppMethodBeat.o(42943);
              return;
            }
          }
          catch (b localb)
          {
            ac.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", localb, "", new Object[0]);
            AppMethodBeat.o(42943);
            return;
          }
        }
      }
    }, "deleteMsgByTalker");
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42944);
        if (this.hmC != null) {
          this.hmC.Ws();
        }
        AppMethodBeat.o(42944);
      }
    });
    AppMethodBeat.o(42967);
    return 0;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(42968);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42946);
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1333L, 0L, 1L, true);
        long l1 = System.currentTimeMillis();
        ((an)g.ab(an.class)).ayv();
        ((k)g.ab(k.class)).axd().aD("", this.hor);
        ((k)g.ab(k.class)).awG().faI();
        if (this.hmC != null) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42945);
              bi.5.this.hmC.Ws();
              AppMethodBeat.o(42945);
            }
          });
        }
        long l2 = System.currentTimeMillis() - l1;
        ac.i("MicroMsg.MsgInfoStorageLogic", "Delete all messages, synchronized part, time: %d ms", new Object[] { Long.valueOf(l2) });
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1333L, 6L, l2 / 1000L, true);
        if ((this.hmC != null) && (this.hmC.Wr()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        bi.aza();
        if ((this.hmC != null) && (this.hmC.Wr()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        bi.azb();
        if ((this.hmC != null) && (this.hmC.Wr()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        bi.ayZ();
        if ((this.hmC != null) && (this.hmC.Wr()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        bi.d(this.hor, 1);
        ((k)g.ab(k.class)).axd().aD("", 0L);
        ac.i("MicroMsg.MsgInfoStorageLogic", "Delete all messages, asynchronous part, time: %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1 - l2) });
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
  
  public static void a(bo parambo, f.a parama)
  {
    AppMethodBeat.i(42973);
    if ((parambo == null) || (parama == null) || (parama.fXi == null))
    {
      ac.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", new Object[] { bs.eWi() });
      AppMethodBeat.o(42973);
      return;
    }
    if (parambo.field_msgSvrId != parama.fXi.vTQ)
    {
      AppMethodBeat.o(42973);
      return;
    }
    cu localcu = parama.fXi;
    if ((parambo.field_isSend != 0) && (localcu.DQa == 0))
    {
      AppMethodBeat.o(42973);
      return;
    }
    if ((parambo.field_msgSeq == 0L) && (localcu.DQa != 0)) {
      parambo.oC(localcu.DQa);
    }
    int i = parambo.field_flag;
    if (parama.hvF)
    {
      i |= 0x2;
      if (!parama.hvG) {
        break label195;
      }
      i |= 0x1;
      label141:
      if (!parama.hvH) {
        break label203;
      }
      i |= 0x4;
    }
    for (;;)
    {
      parambo.setFlag(i);
      if ((parambo.field_msgId == 0L) && (parama.hvF)) {
        parambo.oA(parama.hvI);
      }
      AppMethodBeat.o(42973);
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
  
  public static String aM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42951);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42951);
      return null;
    }
    if (bs.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(42951);
      return paramString1;
    }
    paramString1 = paramString2 + ": " + paramString1;
    AppMethodBeat.o(42951);
    return paramString1;
  }
  
  public static int ac(String paramString, int paramInt)
  {
    AppMethodBeat.i(174544);
    Cursor localCursor = ((k)g.ab(k.class)).dcr().dR(paramString, paramInt);
    if (localCursor.moveToFirst()) {
      while (!localCursor.isAfterLast())
      {
        bo localbo = new bo();
        localbo.convertFrom(localCursor);
        v(localbo);
        localCursor.moveToNext();
      }
    }
    localCursor.close();
    paramInt = ((k)g.ab(k.class)).dcr().dQ(paramString, paramInt);
    AppMethodBeat.o(174544);
    return paramInt;
  }
  
  public static void ah(List<Long> paramList)
  {
    AppMethodBeat.i(42963);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(42963);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      pK(((Long)paramList.next()).longValue());
    }
    AppMethodBeat.o(42963);
  }
  
  public static void ai(List<String> paramList)
  {
    AppMethodBeat.i(174547);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ac.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
      AppMethodBeat.o(174547);
      return;
    }
    ac.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", new Object[] { bs.eWi() });
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42948);
        ac.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] talkers size:%s", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.hot.size()) });
        Iterator localIterator = this.hot.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = ((k)g.ab(k.class)).dcr().alk(str);
          if (localObject == null) {}
          for (long l1 = 9223372036854775807L;; l1 = ((dy)localObject).field_createTime)
          {
            long l3 = ce.azH();
            long l2 = l1;
            if (l1 > l3)
            {
              ac.w("MicroMsg.MsgInfoStorageLogic", "last message time[%s] is over serverTime[%s]!", new Object[] { Long.valueOf(l1), Long.valueOf(l3) });
              l2 = l3;
            }
            if ((localObject != null) && (((dy)localObject).field_createTime > 0L)) {
              ((k)g.ab(k.class)).axd().aD(str, l2);
            }
            ac.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker talker[%s] lastMsg[%s] lastMsgCreateTime[%s]", new Object[] { str, localObject, Long.valueOf(l2) });
            localObject = ((k)g.ab(k.class)).dcr().als(str);
            if (localObject == null) {
              break;
            }
            if (!((Cursor)localObject).moveToFirst()) {
              break label312;
            }
            while (!((Cursor)localObject).isAfterLast())
            {
              bo localbo = new bo();
              localbo.convertFrom((Cursor)localObject);
              bi.v(localbo);
              ((Cursor)localObject).moveToNext();
            }
          }
          label312:
          ((Cursor)localObject).close();
          ac.i("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", new Object[] { str, Integer.valueOf(((k)g.ab(k.class)).dcr().alq(str)) });
          ((k)g.ab(k.class)).axd().aD(str, 0L);
        }
        AppMethodBeat.o(42948);
      }
    }, "deleteMsgByTalkers");
    AppMethodBeat.o(174547);
  }
  
  public static void ayW()
  {
    AppMethodBeat.i(42955);
    ((k)g.ab(k.class)).dcr().ayW();
    AppMethodBeat.o(42955);
  }
  
  public static long ayX()
  {
    AppMethodBeat.i(42959);
    long l1 = System.currentTimeMillis();
    long l2 = ce.azI();
    if (Math.abs(l1 - l2) > 300000L) {
      ac.w("MicroMsg.MsgInfoStorageLogic", "[getFixTime] nowServer:" + l2 + " now:" + l1);
    }
    AppMethodBeat.o(42959);
    return l2;
  }
  
  public static int ayY()
  {
    AppMethodBeat.i(174543);
    if (hol)
    {
      ac.i("MicroMsg.MsgInfoStorageLogic", "checkUnfinishedDeleteMsgTask already started.");
      AppMethodBeat.o(174543);
      return -1;
    }
    Map localMap = ((k)g.ab(k.class)).axd().dcv();
    if (localMap.isEmpty())
    {
      ac.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
      AppMethodBeat.o(174543);
      return 0;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      final int hom = 200;
      final int hon = 30;
      final int hoo = 5;
      int hop = 100;
      
      public final void run()
      {
        AppMethodBeat.i(42941);
        bi.access$002(true);
        ac.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask run currentThread[%s, %d] talkers size:%s", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.hoq.size()) });
        if (this.hoq.containsKey(""))
        {
          bi.d(((Long)this.hoq.get("")).longValue(), 2);
          this.hoq.remove("");
          ((k)g.ab(k.class)).axd().aD("", 0L);
        }
        Iterator localIterator = this.hoq.entrySet().iterator();
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
            l5 = bs.eWj();
            l1 = 0L;
            i = 0;
          }
        }
        for (;;)
        {
          if ((this.hop < 200) && (this.hop > 30)) {
            if (l1 <= 500L) {
              break label348;
            }
          }
          long l6;
          long l2;
          label348:
          for (int j = this.hop - 5;; j = this.hop + 5)
          {
            this.hop = j;
            l6 = bs.eWj();
            localObject = ((k)g.ab(k.class)).dcr().m(str, this.hop, l4);
            l2 = 0L;
            l1 = 0L;
            while (((Cursor)localObject).moveToNext())
            {
              bo localbo = new bo();
              localbo.convertFrom((Cursor)localObject);
              l3 = l2;
              if (l2 < localbo.field_createTime) {
                l3 = localbo.field_createTime;
              }
              bi.v(localbo);
              l1 = 1L + l1;
              l2 = l3;
            }
          }
          ((Cursor)localObject).close();
          long l7 = bs.eWj();
          if ((l2 > 0L) && (l1 > 0L))
          {
            ((k)g.ab(k.class)).dcr().aS(str, l2);
            ((an)g.ab(an.class)).x(str, l2);
          }
          i = (int)(i + l1);
          long l8 = bs.eWj();
          long l3 = l8 - l6;
          ac.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", new Object[] { bs.aLJ(str), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l4 - l2), Long.valueOf(l4), Long.valueOf(l8 - l7), Long.valueOf(l8 - l6), Long.valueOf(l8 - l5), Integer.valueOf(this.hop) });
          if (l1 <= 0L)
          {
            ((k)g.ab(k.class)).axd().aD(str, 0L);
            break;
            ac.i("MicroMsg.MsgInfoStorageLogic", "Done checkUnfinishedDeleteMsgTask");
            bi.access$002(false);
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
  
  public static void ayZ()
  {
    AppMethodBeat.i(174545);
    List localList = ((k)g.ab(k.class)).dcr().aln("bottlemessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        v((bo)localList.get(i));
        i += 1;
      }
    }
    ((k)g.ab(k.class)).dcr().alp("bottlemessage");
    AppMethodBeat.o(174545);
  }
  
  public static void aza()
  {
    AppMethodBeat.i(42969);
    List localList = ((k)g.ab(k.class)).dcr().aln("qmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        v((bo)localList.get(i));
        i += 1;
      }
    }
    ((k)g.ab(k.class)).dcr().alp("qmessage");
    AppMethodBeat.o(42969);
  }
  
  public static void azb()
  {
    AppMethodBeat.i(42970);
    List localList = ((k)g.ab(k.class)).dcr().aln("tmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        v((bo)localList.get(i));
        i += 1;
      }
    }
    ((k)g.ab(k.class)).dcr().alp("tmessage");
    AppMethodBeat.o(42970);
  }
  
  public static String b(boolean paramBoolean, String paramString, int paramInt)
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
          str = ym(paramString);
        }
      }
    }
    AppMethodBeat.o(42975);
    return str;
  }
  
  public static boolean c(f.a parama)
  {
    AppMethodBeat.i(42974);
    if ((parama == null) || (parama.fXi == null))
    {
      AppMethodBeat.o(42974);
      return false;
    }
    cu localcu = parama.fXi;
    Object localObject = z.a(localcu.DPT);
    localObject = ((k)g.ab(k.class)).dcr().aF((String)localObject, localcu.vTQ);
    if (((dy)localObject).field_msgId == 0L)
    {
      AppMethodBeat.o(42974);
      return false;
    }
    if ((((dy)localObject).field_isSend != 0) && (localcu.DQa == 0))
    {
      AppMethodBeat.o(42974);
      return false;
    }
    int i = ((dy)localObject).field_flag;
    if (parama.hvF)
    {
      i |= 0x2;
      if (!parama.hvG) {
        break label230;
      }
      i |= 0x1;
      label128:
      if (!parama.hvH) {
        break label238;
      }
      i |= 0x4;
    }
    for (;;)
    {
      if (i == ((dy)localObject).field_flag) {
        break label246;
      }
      ac.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", new Object[] { Integer.valueOf(localcu.tit), Integer.valueOf(i), Integer.valueOf(((dy)localObject).field_flag) });
      ((bo)localObject).setFlag(i);
      ((k)g.ab(k.class)).dcr().b(((dy)localObject).field_msgSvrId, (bo)localObject);
      AppMethodBeat.o(42974);
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
    AppMethodBeat.o(42974);
    return false;
  }
  
  public static int d(f.a parama)
  {
    int j = 0;
    if (parama.hvF) {
      j = 2;
    }
    int i = j;
    if (parama.hvG) {
      i = j | 0x1;
    }
    j = i;
    if (parama.hvH) {
      j = i | 0x4;
    }
    return j;
  }
  
  /* Error */
  public static void d(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 408
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 299	java/lang/System:currentTimeMillis	()J
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
    //   26: invokestatic 411	com/tencent/mm/model/bi$c:reset	()V
    //   29: new 26	com/tencent/mm/model/bi$c
    //   32: dup
    //   33: invokespecial 412	com/tencent/mm/model/bi$c:<init>	()V
    //   36: astore 13
    //   38: ldc 45
    //   40: invokestatic 51	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   43: checkcast 45	com/tencent/mm/plugin/messenger/foundation/a/k
    //   46: invokeinterface 55 1 0
    //   51: ldc_w 414
    //   54: lload_0
    //   55: invokeinterface 418 4 0
    //   60: astore 14
    //   62: aconst_null
    //   63: astore 12
    //   65: aload 13
    //   67: invokestatic 299	java/lang/System:currentTimeMillis	()J
    //   70: putfield 421	com/tencent/mm/model/bi$c:hoS	J
    //   73: iconst_0
    //   74: istore 7
    //   76: iconst_0
    //   77: istore 8
    //   79: aload 14
    //   81: invokeinterface 232 1 0
    //   86: ifeq +283 -> 369
    //   89: new 163	com/tencent/mm/storage/bo
    //   92: dup
    //   93: invokespecial 225	com/tencent/mm/storage/bo:<init>	()V
    //   96: astore 11
    //   98: aload 11
    //   100: aload 14
    //   102: invokevirtual 229	com/tencent/mm/storage/bo:convertFrom	(Landroid/database/Cursor;)V
    //   105: aload 11
    //   107: invokevirtual 424	com/tencent/mm/storage/bo:getType	()I
    //   110: invokestatic 428	com/tencent/mm/model/bi:nY	(I)I
    //   113: lookupswitch	default:+853->966, 3:+171->284, 23:+171->284, 34:+225->338, 43:+198->311, 44:+198->311, 49:+144->257, 62:+198->311, 486539313:+198->311
    //   189: fconst_0
    //   190: invokestatic 74	com/tencent/mm/model/bi:v	(Lcom/tencent/mm/storage/bo;)V
    //   193: iload 7
    //   195: iconst_1
    //   196: iadd
    //   197: istore 9
    //   199: iload 9
    //   201: istore 7
    //   203: iload 9
    //   205: bipush 100
    //   207: if_icmplt +19 -> 226
    //   210: aload 13
    //   212: invokevirtual 431	com/tencent/mm/model/bi$c:end	()V
    //   215: aload 13
    //   217: invokestatic 299	java/lang/System:currentTimeMillis	()J
    //   220: putfield 421	com/tencent/mm/model/bi$c:hoS	J
    //   223: iconst_0
    //   224: istore 7
    //   226: iload 5
    //   228: istore 9
    //   230: iload 6
    //   232: istore 10
    //   234: iload 8
    //   236: iconst_1
    //   237: iadd
    //   238: istore 8
    //   240: iload_3
    //   241: istore 6
    //   243: iload 4
    //   245: istore 5
    //   247: iload 9
    //   249: istore 4
    //   251: iload 10
    //   253: istore_3
    //   254: goto -175 -> 79
    //   257: iload 4
    //   259: istore 9
    //   261: iload_3
    //   262: iconst_1
    //   263: iadd
    //   264: istore 10
    //   266: iload 6
    //   268: istore_3
    //   269: iload 5
    //   271: istore 4
    //   273: iload 9
    //   275: istore 5
    //   277: iload 10
    //   279: istore 6
    //   281: goto -93 -> 188
    //   284: iload 4
    //   286: iconst_1
    //   287: iadd
    //   288: istore 10
    //   290: iload_3
    //   291: istore 9
    //   293: iload 6
    //   295: istore_3
    //   296: iload 5
    //   298: istore 4
    //   300: iload 10
    //   302: istore 5
    //   304: iload 9
    //   306: istore 6
    //   308: goto -120 -> 188
    //   311: iload 5
    //   313: iconst_1
    //   314: iadd
    //   315: istore 10
    //   317: iload 4
    //   319: istore 5
    //   321: iload_3
    //   322: istore 9
    //   324: iload 6
    //   326: istore_3
    //   327: iload 10
    //   329: istore 4
    //   331: iload 9
    //   333: istore 6
    //   335: goto -147 -> 188
    //   338: iload 6
    //   340: iconst_1
    //   341: iadd
    //   342: istore 10
    //   344: iload 4
    //   346: istore 6
    //   348: iload_3
    //   349: istore 9
    //   351: iload 10
    //   353: istore_3
    //   354: iload 5
    //   356: istore 4
    //   358: iload 6
    //   360: istore 5
    //   362: iload 9
    //   364: istore 6
    //   366: goto -178 -> 188
    //   369: aload 14
    //   371: ifnull +10 -> 381
    //   374: aload 14
    //   376: invokeinterface 235 1 0
    //   381: aload 13
    //   383: invokevirtual 431	com/tencent/mm/model/bi$c:end	()V
    //   386: aload 13
    //   388: invokestatic 299	java/lang/System:currentTimeMillis	()J
    //   391: putfield 421	com/tencent/mm/model/bi$c:hoS	J
    //   394: ldc 45
    //   396: invokestatic 51	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   399: checkcast 45	com/tencent/mm/plugin/messenger/foundation/a/k
    //   402: invokeinterface 55 1 0
    //   407: ldc_w 414
    //   410: lload_0
    //   411: invokeinterface 434 4 0
    //   416: istore 9
    //   418: aload 13
    //   420: invokevirtual 431	com/tencent/mm/model/bi$c:end	()V
    //   423: getstatic 440	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   426: sipush 1333
    //   429: bipush 10
    //   431: iconst_3
    //   432: iload 9
    //   434: iconst_1
    //   435: invokevirtual 443	com/tencent/mm/plugin/report/e:c	(IIIIZ)V
    //   438: aload 13
    //   440: getfield 446	com/tencent/mm/model/bi$c:hoR	J
    //   443: lstore_0
    //   444: getstatic 440	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   447: ldc2_w 447
    //   450: ldc2_w 449
    //   453: lload_0
    //   454: ldc2_w 451
    //   457: ldiv
    //   458: iconst_1
    //   459: invokevirtual 456	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   462: iload_2
    //   463: iconst_1
    //   464: if_icmpne +527 -> 991
    //   467: getstatic 440	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   470: ldc2_w 447
    //   473: lconst_1
    //   474: lconst_1
    //   475: iconst_1
    //   476: invokevirtual 456	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   479: goto +512 -> 991
    //   482: getstatic 440	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   485: ldc2_w 447
    //   488: iload 7
    //   490: i2l
    //   491: lconst_1
    //   492: iconst_1
    //   493: invokevirtual 456	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   496: lload_0
    //   497: ldc2_w 457
    //   500: lcmp
    //   501: iflt +373 -> 874
    //   504: bipush 36
    //   506: istore 7
    //   508: getstatic 440	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   511: ldc2_w 447
    //   514: iload 7
    //   516: i2l
    //   517: lconst_1
    //   518: iconst_1
    //   519: invokevirtual 456	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   522: iload 9
    //   524: ifle +21 -> 545
    //   527: getstatic 440	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   530: ldc2_w 447
    //   533: ldc2_w 459
    //   536: lload_0
    //   537: iload 9
    //   539: i2l
    //   540: ldiv
    //   541: iconst_1
    //   542: invokevirtual 456	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   545: getstatic 440	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   548: sipush 18923
    //   551: bipush 8
    //   553: anewarray 4	java/lang/Object
    //   556: dup
    //   557: iconst_0
    //   558: lload_0
    //   559: invokestatic 463	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   562: aastore
    //   563: dup
    //   564: iconst_1
    //   565: iload_2
    //   566: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   569: aastore
    //   570: dup
    //   571: iconst_2
    //   572: iconst_0
    //   573: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   576: aastore
    //   577: dup
    //   578: iconst_3
    //   579: iload 8
    //   581: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   584: aastore
    //   585: dup
    //   586: iconst_4
    //   587: iload_3
    //   588: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   591: aastore
    //   592: dup
    //   593: iconst_5
    //   594: iload 4
    //   596: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   599: aastore
    //   600: dup
    //   601: bipush 6
    //   603: iload 5
    //   605: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   608: aastore
    //   609: dup
    //   610: bipush 7
    //   612: iload 6
    //   614: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   617: aastore
    //   618: invokevirtual 466	com/tencent/mm/plugin/report/e:f	(I[Ljava/lang/Object;)V
    //   621: ldc 81
    //   623: ldc_w 468
    //   626: bipush 6
    //   628: anewarray 4	java/lang/Object
    //   631: dup
    //   632: iconst_0
    //   633: lload_0
    //   634: invokestatic 463	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   637: aastore
    //   638: dup
    //   639: iconst_1
    //   640: iload 8
    //   642: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: aastore
    //   646: dup
    //   647: iconst_2
    //   648: iload_3
    //   649: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: aastore
    //   653: dup
    //   654: iconst_3
    //   655: iload 4
    //   657: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   660: aastore
    //   661: dup
    //   662: iconst_4
    //   663: iload 5
    //   665: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   668: aastore
    //   669: dup
    //   670: iconst_5
    //   671: iload 6
    //   673: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   676: aastore
    //   677: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   680: aload 13
    //   682: invokevirtual 469	com/tencent/mm/model/bi$c:close	()V
    //   685: invokestatic 411	com/tencent/mm/model/bi$c:reset	()V
    //   688: ldc_w 408
    //   691: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   694: return
    //   695: astore 12
    //   697: ldc_w 408
    //   700: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   703: aload 12
    //   705: athrow
    //   706: astore 11
    //   708: aload 14
    //   710: ifnull +15 -> 725
    //   713: aload 12
    //   715: ifnull +82 -> 797
    //   718: aload 14
    //   720: invokeinterface 235 1 0
    //   725: ldc_w 408
    //   728: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   731: aload 11
    //   733: athrow
    //   734: astore 12
    //   736: ldc_w 408
    //   739: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   742: aload 12
    //   744: athrow
    //   745: astore 11
    //   747: aload 12
    //   749: ifnull +204 -> 953
    //   752: aload 13
    //   754: invokevirtual 469	com/tencent/mm/model/bi$c:close	()V
    //   757: ldc_w 408
    //   760: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   763: aload 11
    //   765: athrow
    //   766: astore 11
    //   768: ldc 81
    //   770: aload 11
    //   772: ldc_w 471
    //   775: iconst_0
    //   776: anewarray 4	java/lang/Object
    //   779: invokestatic 475	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   782: goto -97 -> 685
    //   785: astore 14
    //   787: aload 12
    //   789: aload 14
    //   791: invokevirtual 479	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   794: goto -69 -> 725
    //   797: aload 14
    //   799: invokeinterface 235 1 0
    //   804: goto -79 -> 725
    //   807: iload 9
    //   809: ldc_w 480
    //   812: if_icmplt +10 -> 822
    //   815: bipush 25
    //   817: istore 7
    //   819: goto -337 -> 482
    //   822: iload 9
    //   824: ldc_w 481
    //   827: if_icmplt +10 -> 837
    //   830: bipush 24
    //   832: istore 7
    //   834: goto -352 -> 482
    //   837: iload 9
    //   839: sipush 10000
    //   842: if_icmplt +10 -> 852
    //   845: bipush 23
    //   847: istore 7
    //   849: goto -367 -> 482
    //   852: iload 9
    //   854: sipush 1000
    //   857: if_icmplt +10 -> 867
    //   860: bipush 22
    //   862: istore 7
    //   864: goto -382 -> 482
    //   867: bipush 21
    //   869: istore 7
    //   871: goto -389 -> 482
    //   874: lload_0
    //   875: ldc2_w 482
    //   878: lcmp
    //   879: iflt +10 -> 889
    //   882: bipush 35
    //   884: istore 7
    //   886: goto -378 -> 508
    //   889: lload_0
    //   890: ldc2_w 484
    //   893: lcmp
    //   894: iflt +10 -> 904
    //   897: bipush 34
    //   899: istore 7
    //   901: goto -393 -> 508
    //   904: lload_0
    //   905: ldc2_w 486
    //   908: lcmp
    //   909: iflt +10 -> 919
    //   912: bipush 33
    //   914: istore 7
    //   916: goto -408 -> 508
    //   919: lload_0
    //   920: ldc2_w 488
    //   923: lcmp
    //   924: iflt +10 -> 934
    //   927: bipush 32
    //   929: istore 7
    //   931: goto -423 -> 508
    //   934: bipush 31
    //   936: istore 7
    //   938: goto -430 -> 508
    //   941: astore 13
    //   943: aload 12
    //   945: aload 13
    //   947: invokevirtual 479	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   950: goto -193 -> 757
    //   953: aload 13
    //   955: invokevirtual 469	com/tencent/mm/model/bi$c:close	()V
    //   958: goto -201 -> 757
    //   961: astore 11
    //   963: goto -255 -> 708
    //   966: iload 4
    //   968: istore 9
    //   970: iload_3
    //   971: istore 10
    //   973: iload 6
    //   975: istore_3
    //   976: iload 5
    //   978: istore 4
    //   980: iload 9
    //   982: istore 5
    //   984: iload 10
    //   986: istore 6
    //   988: goto -800 -> 188
    //   991: iload 9
    //   993: ldc_w 490
    //   996: if_icmplt -189 -> 807
    //   999: bipush 26
    //   1001: istore 7
    //   1003: goto -521 -> 482
    //   1006: astore 11
    //   1008: aconst_null
    //   1009: astore 12
    //   1011: goto -264 -> 747
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1014	0	paramLong	long
    //   0	1014	2	paramInt	int
    //   11	965	3	i	int
    //   13	966	4	j	int
    //   16	967	5	k	int
    //   19	968	6	m	int
    //   74	928	7	n	int
    //   77	564	8	i1	int
    //   197	800	9	i2	int
    //   232	753	10	i3	int
    //   96	93	11	localbo	bo
    //   706	26	11	localObject1	Object
    //   745	19	11	localObject2	Object
    //   766	5	11	localIOException	IOException
    //   961	1	11	localObject3	Object
    //   1006	1	11	localObject4	Object
    //   63	1	12	localObject5	Object
    //   695	19	12	localThrowable1	java.lang.Throwable
    //   734	210	12	localThrowable2	java.lang.Throwable
    //   1009	1	12	localObject6	Object
    //   36	717	13	localc	c
    //   941	13	13	localThrowable3	java.lang.Throwable
    //   60	659	14	localCursor	Cursor
    //   785	13	14	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   65	73	695	java/lang/Throwable
    //   79	188	695	java/lang/Throwable
    //   188	193	695	java/lang/Throwable
    //   210	223	695	java/lang/Throwable
    //   697	706	706	finally
    //   38	62	734	java/lang/Throwable
    //   374	381	734	java/lang/Throwable
    //   381	462	734	java/lang/Throwable
    //   467	479	734	java/lang/Throwable
    //   482	496	734	java/lang/Throwable
    //   508	522	734	java/lang/Throwable
    //   527	545	734	java/lang/Throwable
    //   545	680	734	java/lang/Throwable
    //   725	734	734	java/lang/Throwable
    //   787	794	734	java/lang/Throwable
    //   797	804	734	java/lang/Throwable
    //   736	745	745	finally
    //   29	38	766	java/io/IOException
    //   680	685	766	java/io/IOException
    //   752	757	766	java/io/IOException
    //   757	766	766	java/io/IOException
    //   943	950	766	java/io/IOException
    //   953	958	766	java/io/IOException
    //   718	725	785	java/lang/Throwable
    //   752	757	941	java/lang/Throwable
    //   65	73	961	finally
    //   79	188	961	finally
    //   188	193	961	finally
    //   210	223	961	finally
    //   38	62	1006	finally
    //   374	381	1006	finally
    //   381	462	1006	finally
    //   467	479	1006	finally
    //   482	496	1006	finally
    //   508	522	1006	finally
    //   527	545	1006	finally
    //   545	680	1006	finally
    //   718	725	1006	finally
    //   725	734	1006	finally
    //   787	794	1006	finally
    //   797	804	1006	finally
  }
  
  public static long l(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(42976);
    long l3 = paramLong1 * 1000L;
    paramLong1 = 0L;
    long l2 = -1L;
    long l1 = paramLong1;
    bo localbo;
    if (paramString != null)
    {
      localbo = ((k)g.ab(k.class)).dcr().alk(paramString);
      if (localbo != null) {
        paramLong1 = localbo.field_createTime;
      }
      l2 = ((k)g.ab(k.class)).dcr().alB(paramString);
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
      localbo = ((k)g.ab(k.class)).dcr().aH(paramString, l3);
      if ((localbo.field_msgSeq != 0L) && (localbo.field_msgSeq != paramLong2))
      {
        ac.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] need fix serverMillTime[%d, %d]", new Object[] { Long.valueOf(localbo.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localbo.field_createTime), Long.valueOf(l3) });
        if (paramLong2 < localbo.field_msgSeq)
        {
          paramString = ((k)g.ab(k.class)).dcr().aL(paramString, l3 - 1000L);
          if ((paramString.field_msgSeq == 0L) || (paramString.field_msgSeq == paramLong2)) {
            break label466;
          }
          if (paramString.field_msgSeq >= paramLong2) {
            break label456;
          }
          paramLong1 = paramString.field_createTime + 1L;
          label350:
          ac.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d, %d] need fix serverMillTime[%d, %d, %d] done", new Object[] { Long.valueOf(localbo.field_msgSeq), Long.valueOf(paramString.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localbo.field_createTime), Long.valueOf(paramString.field_createTime), Long.valueOf(paramLong1) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(42976);
        return paramLong1;
        paramString = ((k)g.ab(k.class)).dcr().aK(paramString, 1000L + l3);
        break;
        label456:
        paramLong1 = paramString.field_createTime - 1L;
        break label350;
        label466:
        ac.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] no need fix serverMillTime[%d, %d]", new Object[] { Long.valueOf(localbo.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localbo.field_createTime), Long.valueOf(l3) });
        paramLong1 = l3;
      }
    }
    ac.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
    AppMethodBeat.o(42976);
    return l3;
  }
  
  public static boolean nX(int paramInt)
  {
    switch (paramInt)
    {
    case 25: 
    default: 
      return false;
    }
    return true;
  }
  
  private static int nY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 49;
  }
  
  public static int pK(long paramLong)
  {
    AppMethodBeat.i(42964);
    bo localbo = ((k)g.ab(k.class)).dcr().vP(paramLong);
    if (localbo.field_msgId != paramLong)
    {
      AppMethodBeat.o(42964);
      return 0;
    }
    v(localbo);
    int i = ((k)g.ab(k.class)).dcr().vQ(paramLong);
    AppMethodBeat.o(42964);
    return i;
  }
  
  public static long u(bo parambo)
  {
    AppMethodBeat.i(42956);
    com.tencent.mm.storage.ai localai = ((k)g.ab(k.class)).awB().aNt(parambo.field_talker);
    if ((localai == null) || ((int)localai.fLJ == 0))
    {
      localai = new com.tencent.mm.storage.ai(parambo.field_talker);
      localai.setType(2);
      lq locallq = new lq();
      locallq.dnA.dnB = localai;
      a.GpY.l(locallq);
      ((k)g.ab(k.class)).awB().ag(localai);
    }
    long l = ((k)g.ab(k.class)).dcr().ap(parambo);
    AppMethodBeat.o(42956);
    return l;
  }
  
  public static void v(bo parambo)
  {
    AppMethodBeat.i(42962);
    if (parambo == null)
    {
      AppMethodBeat.o(42962);
      return;
    }
    Object localObject = f.d.bY(Integer.valueOf(nY(parambo.getType())));
    if (localObject != null) {
      ((f)localObject).b(new f.c(parambo));
    }
    localObject = new co();
    ((co)localObject).dch.msgId = parambo.field_msgId;
    ((co)localObject).dch.talker = parambo.field_talker;
    ((co)localObject).dch.msgType = parambo.getType();
    a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(42962);
  }
  
  @Deprecated
  public static int yi(String paramString)
  {
    AppMethodBeat.i(163509);
    int i = yk(paramString);
    AppMethodBeat.o(163509);
    return i;
  }
  
  public static String yj(String paramString)
  {
    AppMethodBeat.i(42950);
    int i = yk(paramString);
    if (i != -1)
    {
      paramString = paramString.substring(i + 1).trim();
      AppMethodBeat.o(42950);
      return paramString;
    }
    AppMethodBeat.o(42950);
    return paramString;
  }
  
  private static int yk(String paramString)
  {
    AppMethodBeat.i(42952);
    if (paramString == null)
    {
      ac.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
      AppMethodBeat.o(42952);
      return -1;
    }
    if (paramString.length() <= 0)
    {
      ac.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
      AppMethodBeat.o(42952);
      return -1;
    }
    if (paramString.startsWith("~SEMI_XML~"))
    {
      ac.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
      AppMethodBeat.o(42952);
      return -1;
    }
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.substring(0, i).contains("<")))
    {
      ac.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
      AppMethodBeat.o(42952);
      return -1;
    }
    AppMethodBeat.o(42952);
    return i;
  }
  
  public static String yl(String paramString)
  {
    AppMethodBeat.i(42953);
    int i = yk(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(42953);
      return null;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(42953);
    return paramString;
  }
  
  public static String ym(String paramString)
  {
    AppMethodBeat.i(42954);
    int i = yk(paramString);
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
  
  public static int yn(String paramString)
  {
    AppMethodBeat.i(42957);
    int i = ((k)g.ab(k.class)).dcr().yn(paramString);
    AppMethodBeat.o(42957);
    return i;
  }
  
  public static boolean yo(String paramString)
  {
    AppMethodBeat.i(42958);
    boolean bool = ((k)g.ab(k.class)).dcr().yo(paramString);
    AppMethodBeat.o(42958);
    return bool;
  }
  
  public static long yp(String paramString)
  {
    AppMethodBeat.i(42960);
    long l = ayX();
    ac.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", new Object[] { Long.valueOf(l) });
    if (paramString != null)
    {
      paramString = ((k)g.ab(k.class)).dcr().alk(paramString);
      if (paramString != null)
      {
        ac.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(l) });
        if (paramString.field_createTime + 1L > l)
        {
          l = paramString.field_createTime;
          AppMethodBeat.o(42960);
          return l + 1L;
        }
      }
    }
    AppMethodBeat.o(42960);
    return l;
  }
  
  public static int yq(String paramString)
  {
    AppMethodBeat.i(42966);
    int i = ((k)g.ab(k.class)).dcr().alq(paramString);
    AppMethodBeat.o(42966);
    return i;
  }
  
  public static b yr(String paramString)
  {
    AppMethodBeat.i(42971);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42971);
      return null;
    }
    try
    {
      paramString = bv.L(paramString, "msgsource");
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
      localb.hou = ((String)paramString.get(".msgsource.bizmsg.msgcluster"));
      localb.hoy = ((String)paramString.get(".msgsource.kf.kf_worker"));
      localb.hoz = bs.getInt((String)paramString.get(".msgsource.kf.kf_type_new"), 0);
      localb.hox = bs.nullAsNil((String)paramString.get(".msgsource.bizmsg.bizclientmsgid"));
      if (bs.isNullOrNil(localb.hox)) {
        localb.hox = bs.nullAsNil((String)paramString.get(".msgsource.enterprise_info.climsgid"));
      }
      localb.hoD = bs.nullAsNil((String)paramString.get(".msgsource.enterprise_info.qy_msg_type"));
      localb.hoE = bs.nullAsNil((String)paramString.get(".msgsource.enterprise_info.chat_type"));
      localb.hoF = bs.nullAsNil((String)paramString.get(".msgsource.enterprise_info.bizchat_id"));
      localb.hoG = bs.nullAsNil((String)paramString.get(".msgsource.enterprise_info.bizchat_ver"));
      localb.userId = bs.nullAsNil((String)paramString.get(".msgsource.enterprise_info.user_id"));
      localb.hoH = bs.nullAsNil((String)paramString.get(".msgsource.enterprise_info.user_nickname"));
      localb.hoI = bs.nullAsNil((String)paramString.get(".msgsource.enterprise_info.sync_from_qy_im"));
      localb.hoC = ((String)paramString.get(".msgsource.strangerantispamticket.$ticket"));
      localb.scene = bs.getInt((String)paramString.get(".msgsource.strangerantispamticket.$scene"), 0);
      localb.hoJ = ((String)paramString.get(".msgsource.NotAutoDownloadRange"));
      localb.hoK = bs.getInt((String)paramString.get(".msgsource.DownloadLimitKbps"), 0);
      localb.hoL = bs.getInt((String)paramString.get(".msgsource.videopreloadlen"), 0);
      localb.hoM = bs.getInt((String)paramString.get(".msgsource.PreDownload"), 0);
      localb.hoN = bs.getInt((String)paramString.get(".msgsource.PreDownloadNetType"), 0);
      localb.hoO = ((String)paramString.get(".msgsource.NoPreDownloadRange"));
      localb.hov = bs.getInt((String)paramString.get(".msgsource.msg_cluster_type"), -1);
      localb.cFI = bs.getInt((String)paramString.get(".msgsource.service_type"), -1);
      localb.how = bs.getInt((String)paramString.get(".msgsource.scene"), -1);
      localb.hoA = bs.getInt((String)paramString.get(".msgsource.bizmsg.msg_predict"), 0);
      localb.hoB = bs.getLong((String)paramString.get(".msgsource.bizflag"), 0L);
      AppMethodBeat.o(42971);
      return localb;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", new Object[] { bs.m(paramString) });
      ac.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(42971);
    }
    return null;
  }
  
  public static String ys(String paramString)
  {
    AppMethodBeat.i(42972);
    paramString = yr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(42972);
      return null;
    }
    paramString = paramString.hoy;
    AppMethodBeat.o(42972);
    return paramString;
  }
  
  public static long z(String paramString, long paramLong)
  {
    AppMethodBeat.i(42961);
    if (paramString != null)
    {
      paramString = ((k)g.ab(k.class)).dcr().alk(paramString);
      if (paramString == null) {}
    }
    for (long l = paramString.field_createTime + 1L;; l = 0L)
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
  
  public static abstract interface a
  {
    public abstract boolean Wr();
    
    public abstract void Ws();
  }
  
  public static final class b
  {
    public int cFI;
    public int hoA;
    public long hoB;
    public String hoC;
    @Deprecated
    public String hoD;
    public String hoE;
    public String hoF;
    public String hoG;
    public String hoH;
    public String hoI;
    public String hoJ;
    public int hoK;
    public int hoL;
    public int hoM;
    public int hoN;
    public String hoO;
    public String hou;
    public int hov;
    public int how;
    public String hox;
    public String hoy;
    public int hoz;
    public int scene = 0;
    public String userId;
  }
  
  static final class c
    implements Closeable
  {
    FileChannel hoP;
    ByteBuffer hoQ;
    long hoR;
    long hoS;
    
    c()
    {
      AppMethodBeat.i(178869);
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.sdk.platformtools.ai.getContext().getCacheDir(), "asyncClearMsgStat");
      try
      {
        this.hoP = i.a(locale.mUri, true).getChannel();
        this.hoQ = ByteBuffer.allocate(8);
        this.hoP.read(this.hoQ, 0L);
        if (this.hoQ.remaining() == 8) {
          this.hoR = this.hoQ.getLong(0);
        }
        this.hoQ.clear();
        AppMethodBeat.o(178869);
        return;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", localIOException, "Cannot init time statistics", new Object[0]);
        q.closeQuietly(this.hoP);
        this.hoP = null;
        AppMethodBeat.o(178869);
      }
    }
    
    static void reset()
    {
      AppMethodBeat.i(178872);
      new com.tencent.mm.vfs.e(com.tencent.mm.sdk.platformtools.ai.getContext().getCacheDir(), "asyncClearMsgStat").delete();
      AppMethodBeat.o(178872);
    }
    
    public final void close()
    {
      AppMethodBeat.i(178871);
      this.hoP.close();
      AppMethodBeat.o(178871);
    }
    
    final void end()
    {
      AppMethodBeat.i(178870);
      if (this.hoS == 0L)
      {
        AppMethodBeat.o(178870);
        return;
      }
      this.hoR = (System.currentTimeMillis() - this.hoS + this.hoR);
      if (this.hoP != null) {
        this.hoQ.putLong(0, this.hoR);
      }
      try
      {
        this.hoP.write(this.hoQ, 0L);
        this.hoQ.clear();
        this.hoS = 0L;
        AppMethodBeat.o(178870);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.e("MicroMsg.MsgInfoStorageLogic", "Cannot update time statistics: " + localIOException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bi
 * JD-Core Version:    0.7.0.1
 */