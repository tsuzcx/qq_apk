package com.tencent.mm.modelvoice;

import android.database.Cursor;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.f.b.i;
import com.tencent.mm.h.a.iz;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class q
{
  private static final HashMap<String, WeakReference<com.tencent.mm.ah.j>> eLa = new HashMap();
  public static volatile HashMap<String, Integer> eLb = new HashMap();
  public static volatile HashMap<String, Integer> eLc = new HashMap();
  public static volatile HashMap<String, Integer> eLd = new HashMap();
  
  public static float E(bi parambi)
  {
    if ((parambi != null) && (parambi.ctA())) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      float f2 = (float)new n(parambi.field_content).time / 1000.0F;
      float f1 = f2;
      if (f2 < 1.0F) {
        f1 = 1.0F;
      }
      return Math.round(f1 * 10.0F) / 10.0F;
    }
  }
  
  public static boolean F(bi parambi)
  {
    if ((parambi == null) || (!parambi.ctA())) {
      return false;
    }
    return new n(parambi.field_content).eHB;
  }
  
  public static String FI()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt + "voice2/";
  }
  
  public static boolean G(bi parambi)
  {
    boolean bool = true;
    if ((parambi == null) || (!parambi.ctA()) || (parambi.field_isSend == 1)) {
      bool = false;
    }
    while (new n(parambi.field_content).time == 0L) {
      return bool;
    }
    return false;
  }
  
  public static void H(bi parambi)
  {
    if ((parambi == null) || (!parambi.ctA())) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(parambi.field_msgId);
      } while (((cs)localObject).field_msgId != parambi.field_msgId);
      localObject = new n(((cs)localObject).field_content);
    } while (((n)localObject).eHB);
    ((n)localObject).eHB = true;
    StringBuilder localStringBuilder = new StringBuilder().append(((n)localObject).eHA).append(":").append(((n)localObject).time).append(":");
    if (((n)localObject).eHB) {}
    for (int i = 1;; i = 0)
    {
      parambi.setContent(i + "\n");
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(parambi.field_msgId, parambi);
      return;
    }
  }
  
  public static String R(String paramString, boolean paramBoolean)
  {
    Object localObject = new g.a();
    String str = com.tencent.mm.sdk.platformtools.h.b(FI(), "msg_", paramString, ".amr", 2);
    y.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + ((g.a)localObject).zJ() + " " + str);
    if (bk.bl(str)) {
      localObject = null;
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = str;
        } while (paramBoolean);
        localObject = str;
      } while (new com.tencent.mm.vfs.b(str).exists());
      paramString = Tm() + paramString;
      if (new com.tencent.mm.vfs.b(paramString + ".amr").exists())
      {
        com.tencent.mm.vfs.e.aA(paramString + ".amr", str);
        return str;
      }
      localObject = str;
    } while (!new com.tencent.mm.vfs.b(paramString).exists());
    com.tencent.mm.vfs.e.aA(paramString, str);
    return str;
  }
  
  public static List<p> Tl()
  {
    ArrayList localArrayList = null;
    Object localObject1 = m.Tg();
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo";
    localObject2 = (String)localObject2 + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime";
    localObject1 = ((u)localObject1).dXo.a((String)localObject2, null, 2);
    int j = 0;
    int i = 0;
    if (((Cursor)localObject1).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        localObject2 = new p();
        ((p)localObject2).d((Cursor)localObject1);
        localArrayList.add(localObject2);
        j = i + 1;
        i = j;
      } while (((Cursor)localObject1).moveToNext());
    }
    y.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:" + j);
    ((Cursor)localObject1).close();
    return localArrayList;
  }
  
  public static String Tm()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt + "voice/";
  }
  
  public static boolean Z(String paramString, int paramInt)
  {
    return m(paramString, paramInt, 0);
  }
  
  /* Error */
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_1
    //   6: ifnull +12 -> 18
    //   9: aload_1
    //   10: arraylength
    //   11: istore 4
    //   13: iload 4
    //   15: ifne +12 -> 27
    //   18: iconst_0
    //   19: istore 4
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload 4
    //   26: ireturn
    //   27: iload_0
    //   28: istore 4
    //   30: iload_3
    //   31: iload_2
    //   32: if_icmpge -11 -> 21
    //   35: iload_0
    //   36: aload_1
    //   37: iload_3
    //   38: iconst_0
    //   39: iadd
    //   40: baload
    //   41: iadd
    //   42: istore_0
    //   43: iload_3
    //   44: iconst_1
    //   45: iadd
    //   46: istore_3
    //   47: goto -20 -> 27
    //   50: astore_1
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramInt1	int
    //   0	56	1	paramArrayOfByte	byte[]
    //   0	56	2	paramInt2	int
    //   1	46	3	i	int
    //   11	18	4	j	int
    // Exception table:
    //   from	to	target	type
    //   9	13	50	finally
  }
  
  public static int a(p paramp, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, e.a parama)
  {
    g.a locala = new g.a();
    p localp = m.Tg().cl(paramp.bXr);
    if ((localp != null) && (localp.status == 99)) {
      return 0;
    }
    if ((((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().O(paramp.bVI, paramp.bXr).field_msgSvrId == paramp.bXr) && (localp == null)) {
      return 0;
    }
    boolean bool1;
    String str1;
    String str2;
    int i;
    if (localp != null)
    {
      paramp.fileName = localp.fileName;
      paramp.bcw |= 0x1;
      y.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zI() + "checktime :" + locala.zJ());
      boolean bool2 = false;
      bool1 = bool2;
      if (paramArrayOfByte != null)
      {
        bool1 = bool2;
        if (paramArrayOfByte.length > 1)
        {
          if (localp != null) {
            y.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
          }
          str1 = paramp.eJP;
          str2 = paramp.fileName;
          i = aI(str1, str2).write(paramArrayOfByte, paramArrayOfByte.length, 0);
          if (i >= 0) {
            break label620;
          }
          y.e("MicroMsg.VoiceLogic", "Write Failed File:" + str2 + " newOffset:" + i + " voiceFormat:" + str1);
          bool1 = false;
          label258:
          paramp.eKZ = b(paramp.eKZ, paramArrayOfByte, paramArrayOfByte.length);
          paramp.bcw |= 0x80000;
        }
      }
      y.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zI() + "checktime :" + locala.zJ());
      paramp.eHF = (System.currentTimeMillis() / 1000L);
      paramp.bcw |= 0x100;
      if (!bool1) {
        break label745;
      }
      paramp.status = 99;
    }
    for (;;)
    {
      paramp.bcw |= 0x40;
      if (localp != null) {
        break label811;
      }
      if (bool1) {
        paramp.eHI = ((int)a(paramp, bool1, paramInt, paramString1, paramString2, parama));
      }
      if (parama != null)
      {
        paramp.czq = bd.c(parama);
        if (parama.dBs != null) {
          paramp.eKX = parama.dBs.svM;
        }
      }
      y.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zI() + "checktime :" + locala.zJ());
      paramp.bcw = -1;
      y.d("MicroMsg.VoiceLogic", "Insert fileName:" + paramp.fileName + " stat:" + paramp.status + " net:" + paramp.eGk + " total:" + paramp.ebK);
      if (m.Tg().b(paramp)) {
        break label769;
      }
      y.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + paramp.fileName + " stat:" + paramp.status + " net:" + paramp.eGk + " total:" + paramp.ebK);
      return -2;
      paramp.fileName = u.oI(paramp.eHA);
      break;
      label620:
      if (paramArrayOfByte.length != i)
      {
        y.e("MicroMsg.VoiceLogic", "Write File:" + str2 + " fileOff:" + i + " bufLen:" + paramArrayOfByte.length + " voiceFormat:" + str1);
        bool1 = false;
        break label258;
      }
      y.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str2 + "] + buf:" + paramArrayOfByte.length + " voiceFormat:" + str1);
      oy(str2);
      bool1 = true;
      break label258;
      label745:
      if (paramp.ebK == 0) {
        paramp.status = 5;
      } else {
        paramp.status = 6;
      }
    }
    label769:
    y.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zI() + "checktime :" + locala.zJ());
    if (bool1)
    {
      return 1;
      label811:
      y.d("MicroMsg.VoiceLogic", "Sync Update file:" + paramp.fileName + " stat:" + paramp.status);
      if (!a(paramp)) {
        return -44;
      }
      if (bool1)
      {
        a(paramp, parama);
        return 1;
      }
    }
    if ((localp != null) && (localp.eHC == paramp.ebK))
    {
      a(localp.fileName, localp.eHC, parama);
      y.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + localp.fileName);
    }
    y.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[] { parama, Boolean.valueOf(bool1), bk.csb() });
    m.Ti().run();
    return 0;
  }
  
  public static int a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, int paramInt3)
  {
    int i;
    if (paramString1 == null) {
      i = -1;
    }
    p localp;
    do
    {
      return i;
      y.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + paramString1 + "] newOff:" + paramInt1 + " SvrID:" + paramLong + " clientID:" + paramString2 + " hasSendEndFlag " + paramInt2);
      localp = m.Tg().oJ(paramString1);
      if (localp == null) {
        return -1;
      }
      localp.eGk = paramInt1;
      localp.eHF = (System.currentTimeMillis() / 1000L);
      localp.bcw = 264;
      if ((bk.bl(localp.clientId)) && (paramString2 != null))
      {
        localp.clientId = paramString2;
        localp.bcw |= 0x200;
      }
      if ((localp.bXr == 0L) && (paramLong != 0L))
      {
        localp.bXr = paramLong;
        localp.bcw |= 0x4;
      }
      int j = 0;
      i = j;
      if (localp.ebK <= paramInt1)
      {
        i = j;
        if (localp.status == 3)
        {
          i = j;
          if (paramInt2 == 1)
          {
            localp.status = 99;
            localp.bcw |= 0x40;
            paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(localp.eHI);
            paramString2.ec(localp.bVI);
            paramString2.bf(localp.bXr);
            paramString2.setStatus(2);
            paramString2.setContent(n.d(localp.eHA, localp.eKW, false));
            paramString2.Fq(paramInt3);
            Integer localInteger = (Integer)eLb.get(getFullPath(paramString1));
            if (localInteger != null)
            {
              localp.eKZ = localInteger.intValue();
              localp.bcw |= 0x80000;
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(localp.eHI, paramString2);
            y.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + paramString1 + " total:" + localp.ebK + " status:" + localp.status + " netTimes:" + localp.eHJ + " msgId:" + paramString2.field_msgId);
            i = 1;
            oy(paramString1);
          }
        }
      }
    } while (a(localp));
    return -4;
  }
  
  public static int a(String paramString, int paramInt, e.a parama)
  {
    int i = -1;
    if (paramString == null) {}
    p localp;
    do
    {
      do
      {
        return i;
        localp = m.Tg().oJ(paramString);
      } while (localp == null);
      localp.eHC = paramInt;
      localp.eHF = (System.currentTimeMillis() / 1000L);
      localp.bcw = 272;
      int j = 0;
      i = j;
      if (localp.ebK > 0)
      {
        i = j;
        if (paramInt >= localp.ebK)
        {
          a(localp, parama);
          localp.status = 99;
          localp.bcw |= 0x40;
          y.d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localp.ebK + " status:" + localp.status + " netTimes:" + localp.eHJ);
          i = 1;
          oy(paramString);
        }
      }
      y.d("MicroMsg.VoiceLogic", "updateRecv file:" + paramString + " newsize:" + paramInt + " total:" + localp.ebK + " status:" + localp.status);
    } while (a(localp));
    return -3;
  }
  
  private static long a(p paramp, boolean paramBoolean, int paramInt, String paramString1, String paramString2, e.a parama)
  {
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().ff(paramp.bXr))
    {
      y.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(paramp.bXr) });
      if (bk.pm(paramp.fileName).length() > 0) {
        m.Tg().jJ(paramp.fileName);
      }
      for (;;)
      {
        return -1L;
        y.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
      }
    }
    bi localbi = new bi();
    localbi.bf(paramp.bXr);
    localbi.ed(paramp.fileName);
    localbi.bg(bd.o(paramp.bVI, paramp.createTime));
    localbi.ec(paramp.bVI);
    int i;
    long l1;
    long l5;
    long l2;
    long l4;
    long l3;
    if (com.tencent.mm.model.q.gS(paramp.eHA))
    {
      i = 1;
      localbi.fA(i);
      localbi.setType(34);
      localbi.eh(paramString1);
      localbi.Fq(paramp.eJW);
      localbi.setStatus(paramInt);
      if (parama != null) {
        break label1098;
      }
      paramInt = paramp.czq;
      if (paramInt != 0)
      {
        y.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[] { Integer.valueOf(paramInt) });
        localbi.fJ(paramInt);
        if ((localbi.field_msgId == 0L) && (localbi.field_isSend == 0) && ((paramInt & 0x2) != 0))
        {
          paramString1 = localbi.field_talker;
          l1 = paramp.createTime;
          l5 = localbi.field_msgSeq;
          l2 = l1 * 1000L;
          l1 = 0L;
          l4 = -1L;
          l3 = l1;
          if (paramString1 != null)
          {
            parama = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HA(paramString1);
            if (parama != null) {
              l1 = parama.field_createTime;
            }
            l4 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HU(paramString1);
            l3 = l1;
          }
          if (l4 != l3) {
            break label647;
          }
          l1 = l2;
          if (l2 == l3) {
            l1 = l2 + 1L;
          }
          label376:
          localbi.bg(l1);
        }
      }
      if (paramp.eKX != 0) {
        localbi.bi(paramp.eKX);
      }
      y.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramp.eKX) });
      label429:
      y.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[] { paramString2 });
      if (!bk.bl(paramString2))
      {
        localbi.cY(paramString2);
        localbi.ei(bd.iN(paramString2));
      }
      if (paramBoolean) {
        break label1108;
      }
      localbi.setContent(n.d(paramp.eHA, 0L, false));
    }
    for (;;)
    {
      if (!bk.bl(paramString2))
      {
        localbi.cY(paramString2);
        localbi.ei(bd.iN(paramString2));
        paramp = bd.iM(paramString2);
        if (paramp != null)
        {
          localbi.ei(paramp.dWA);
          localbi.eg(paramp.dWz);
          y.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[] { paramp.dWz });
          if (paramp.dWD != null)
          {
            paramString1 = new iz();
            paramString1.bRk.bFH = localbi;
            paramString1.bRk.bRl = paramp;
            com.tencent.mm.sdk.b.a.udP.m(paramString1);
          }
        }
      }
      y.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[] { Long.valueOf(localbi.field_msgSvrId), Long.valueOf(localbi.field_msgSeq) });
      return bd.h(localbi);
      i = 0;
      break;
      label647:
      if (l4 < l3)
      {
        if (l2 == l4)
        {
          l1 = l2 - 1L;
          break label376;
        }
        if (l2 == l3)
        {
          l1 = l2 + 1L;
          break label376;
        }
        l1 = l2;
        if (l5 == 0L) {
          break label376;
        }
        l1 = l2;
        if (l2 > l3) {
          break label376;
        }
        parama = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Q(paramString1, l2);
        if ((parama.field_msgSeq != 0L) && (parama.field_msgSeq != l5))
        {
          y.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] need fix serverMillTime[%d, %d]", new Object[] { Long.valueOf(parama.field_msgSeq), Long.valueOf(l5), Long.valueOf(parama.field_createTime), Long.valueOf(l2) });
          if (l5 < parama.field_msgSeq)
          {
            paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().U(paramString1, l2 - 1000L);
            label844:
            if ((paramString1.field_msgSeq == 0L) || (paramString1.field_msgSeq == l5)) {
              break label996;
            }
            if (paramString1.field_msgSeq >= l5) {
              break label985;
            }
            l1 = paramString1.field_createTime + 1L;
            label881:
            y.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d, %d] need fix serverMillTime[%d, %d, %d] done", new Object[] { Long.valueOf(parama.field_msgSeq), Long.valueOf(paramString1.field_msgSeq), Long.valueOf(l5), Long.valueOf(parama.field_createTime), Long.valueOf(paramString1.field_createTime), Long.valueOf(l1) });
          }
        }
        for (;;)
        {
          break;
          paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().T(paramString1, 1000L + l2);
          break label844;
          label985:
          l1 = paramString1.field_createTime - 1L;
          break label881;
          label996:
          y.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] no need fix serverMillTime[%d, %d]", new Object[] { Long.valueOf(parama.field_msgSeq), Long.valueOf(l5), Long.valueOf(parama.field_createTime), Long.valueOf(l2) });
          l1 = l2;
        }
      }
      y.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", new Object[] { Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2) });
      l1 = l2;
      break label376;
      label1098:
      bd.a(localbi, parama);
      break label429;
      label1108:
      localbi.setContent(n.d(paramp.eHA, paramp.eKW, false));
    }
  }
  
  private static boolean a(p paramp)
  {
    if (paramp == null) {}
    while (paramp.bcw == -1) {
      return false;
    }
    return m.Tg().a(paramp.fileName, paramp);
  }
  
  private static boolean a(p paramp, e.a parama)
  {
    try
    {
      paramp.eHI = ((int)a(paramp, true, 3, "", paramp.czr, parama));
      paramp.bcw |= 0x800;
      boolean bool = a(paramp);
      return bool;
    }
    catch (Exception paramp)
    {
      y.e("MicroMsg.VoiceLogic", "exception:%s", new Object[] { bk.j(paramp) });
    }
    return false;
  }
  
  public static boolean a(String paramString, com.tencent.mm.ah.j paramj)
  {
    if (paramString == null) {}
    p localp;
    do
    {
      return false;
      localp = m.Tg().oJ(paramString);
      if (localp == null)
      {
        y.d("MicroMsg.VoiceLogic", "startSend null record : " + paramString);
        return false;
      }
    } while (localp.status != 1);
    localp.status = 2;
    localp.bcw = 64;
    synchronized (eLa)
    {
      eLa.put(paramString, new WeakReference(paramj));
      return a(localp);
    }
  }
  
  public static b aI(String paramString1, String paramString2)
  {
    u localu = m.Tg();
    paramString2 = getFullPath(paramString2);
    switch (bk.getInt(paramString1, -1))
    {
    case 2: 
    case 3: 
    default: 
      if (localu.eLm.get(paramString2) == null) {
        localu.eLm.put(paramString2, new a(paramString2));
      }
      return (b)localu.eLm.get(paramString2);
    case 4: 
      if (localu.eLo.get(paramString2) == null) {
        localu.eLo.put(paramString2, new h(paramString2));
      }
      return (b)localu.eLo.get(paramString2);
    }
    if (localu.eLn.get(paramString2) == null) {
      localu.eLn.put(paramString2, new l(paramString2));
    }
    return (b)localu.eLn.get(paramString2);
  }
  
  public static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int j = paramInt1;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        j = paramInt1;
      }
    }
    else {
      return j;
    }
    if (paramInt1 == 0) {
      paramInt1 = paramArrayOfByte.hashCode() & 0xFF;
    }
    for (int i = paramInt1;; i = paramInt1 & 0xFF)
    {
      int k = 0;
      for (;;)
      {
        j = paramInt1;
        if (k >= paramInt2) {
          break;
        }
        paramInt1 += (paramArrayOfByte[(k + 0)] & i) * 256;
        k += 1;
      }
    }
  }
  
  public static int c(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = m.Tg().oJ(paramString);
    if (paramString == null) {
      return -1;
    }
    paramString.eKZ = b(paramString.eKZ, paramArrayOfByte, paramInt);
    paramString.bcw |= 0x80000;
    if (a(paramString)) {
      return paramString.eKZ;
    }
    return 0;
  }
  
  public static float ck(long paramLong)
  {
    float f2 = 60.0F;
    float f1 = 1.0F;
    float f3 = (float)paramLong / 1000.0F;
    if (f3 < 1.0F) {}
    for (;;)
    {
      if (f1 > 60.0F) {
        f1 = f2;
      }
      for (;;)
      {
        return Math.round(f1);
      }
      f1 = f3;
    }
  }
  
  public static String g(String paramString1, String paramString2, int paramInt)
  {
    if (bk.bl(paramString1)) {}
    do
    {
      return null;
      if ((!bk.bl(paramString2)) && (!paramString2.startsWith("amr_")) && (!paramString2.startsWith("spx_"))) {
        paramString2.startsWith("silk_");
      }
      paramString1 = oz(paramString1);
    } while ((bk.bl(paramString1)) || (com.tencent.mm.vfs.e.r(getFullPath(paramString2), getFullPath(paramString1)) < 0L));
    m(paramString1, paramInt, 1);
    return paramString1;
  }
  
  public static String getFullPath(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return R(paramString, false);
  }
  
  public static int jx(int paramInt)
  {
    return (paramInt - 6) / 32 * 20;
  }
  
  public static boolean jy(int paramInt)
  {
    bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(paramInt);
    if ((localbi.field_msgId == 0L) || (localbi.field_imgPath == null)) {
      return false;
    }
    if (bk.bl(localbi.field_imgPath)) {
      return false;
    }
    Object localObject = localbi.field_imgPath;
    localObject = m.Tg().oJ((String)localObject);
    if ((localObject == null) || (bk.bl(((p)localObject).fileName))) {
      return false;
    }
    ((p)localObject).status = 3;
    ((p)localObject).eGk = 0;
    ((p)localObject).createTime = (System.currentTimeMillis() / 1000L);
    ((p)localObject).eHF = (System.currentTimeMillis() / 1000L);
    ((p)localObject).bcw = 8648;
    boolean bool = a((p)localObject);
    y.d("MicroMsg.VoiceLogic", " file:" + ((p)localObject).fileName + " msgid:" + ((p)localObject).eHI + "  stat:" + ((p)localObject).status);
    if ((((p)localObject).eHI == 0) || (bk.bl(((p)localObject).bVI)))
    {
      y.e("MicroMsg.VoiceLogic", " failed msg id:" + ((p)localObject).eHI + " user:" + ((p)localObject).bVI);
      return bool;
    }
    localbi.setStatus(1);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(localbi.field_msgId, localbi);
    m.Ti().run();
    return true;
  }
  
  private static boolean m(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    do
    {
      return false;
      y.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + paramString + "], fullPath[" + getFullPath(paramString) + "]");
      ??? = m.Tg().oJ(paramString);
    } while (??? == null);
    if ((((p)???).status != 97) && (((p)???).status != 98)) {
      ((p)???).status = 3;
    }
    ((p)???).ebK = o.nU(paramString);
    if (((p)???).ebK <= 0)
    {
      nX(paramString);
      return false;
    }
    ((p)???).eHF = (System.currentTimeMillis() / 1000L);
    ((p)???).eKW = paramInt1;
    ((p)???).bcw = 3424;
    bi localbi = new bi();
    localbi.ec(((p)???).bVI);
    localbi.setType(34);
    localbi.fA(1);
    localbi.ed(paramString);
    if (((p)???).status == 97)
    {
      localbi.setStatus(2);
      localbi.setContent(n.d(((p)???).eHA, ((p)???).eKW, false));
    }
    for (;;)
    {
      localbi.bg(bd.iK(((p)???).bVI));
      localbi.Fq(paramInt2);
      a.a.yf().c(localbi);
      ((p)???).eHI = ((int)bd.h(localbi));
      boolean bool = a((p)???);
      synchronized (eLa)
      {
        eLa.remove(paramString);
        return bool;
      }
      if (((p)???).status == 98)
      {
        localbi.setStatus(5);
        localbi.setContent(n.d(((p)???).eHA, -1L, true));
      }
      else
      {
        localbi.setStatus(1);
        localbi.setContent(n.d(((p)???).eHA, ((p)???).eKW, false));
      }
    }
  }
  
  public static boolean nX(String paramString)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 234L, 1L, false);
    if (paramString == null) {
      return false;
    }
    p localp = m.Tg().oJ(paramString);
    if (localp == null)
    {
      y.e("MicroMsg.VoiceLogic", "Set error failed file:" + paramString);
      return false;
    }
    localp.status = 98;
    localp.eHF = (System.currentTimeMillis() / 1000L);
    localp.bcw = 320;
    boolean bool = a(localp);
    y.d("MicroMsg.VoiceLogic", "setError file:" + paramString + " msgid:" + localp.eHI + " old stat:" + localp.status);
    if ((localp.eHI == 0) || (bk.bl(localp.bVI)))
    {
      y.e("MicroMsg.VoiceLogic", "setError failed msg id:" + localp.eHI + " user:" + localp.bVI);
      return bool;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(localp.eHI);
    f.nEG.a(111L, 33L, 1L, true);
    paramString.setMsgId(localp.eHI);
    paramString.setStatus(5);
    paramString.ec(localp.bVI);
    paramString.setContent(n.d(localp.eHA, -1L, true));
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(paramString.field_msgId, paramString);
    return bool;
  }
  
  public static boolean nY(String paramString)
  {
    paramString = m.Tg().oJ(paramString);
    if (paramString == null) {
      return false;
    }
    if (paramString.status == 3)
    {
      bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(paramString.eHI);
      localbi.setContent(n.d(paramString.eHA, paramString.eKW, false));
      localbi.setStatus(2);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(paramString.eHI, localbi);
    }
    paramString.status = 97;
    paramString.eHF = (System.currentTimeMillis() / 1000L);
    paramString.bcw = 320;
    return a(paramString);
  }
  
  public static boolean oA(String paramString)
  {
    if (paramString == null) {}
    p localp;
    do
    {
      return false;
      y.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + paramString + "]");
      localp = m.Tg().oJ(paramString);
    } while (localp == null);
    localp.status = 8;
    localp.ebK = o.nU(paramString);
    localp.bcw = 96;
    return a(localp);
  }
  
  public static boolean oB(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    p localp = m.Tg().oJ(paramString);
    if (localp == null)
    {
      y.d("MicroMsg.VoiceLogic", "cancel null download : " + paramString);
      return true;
    }
    y.d("MicroMsg.VoiceLogic", "cancel download : " + paramString + " SvrlId:" + localp.bXr);
    if (localp.bXr != 0L) {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Y(localp.bVI, localp.bXr);
    }
    return oD(paramString);
  }
  
  public static boolean oC(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    p localp = m.Tg().oJ(paramString);
    if (localp == null)
    {
      y.i("MicroMsg.VoiceLogic", "cancel null record : " + paramString);
      return true;
    }
    y.i("MicroMsg.VoiceLogic", "cancel record : " + paramString + " LocalId:" + localp.eHI);
    if (localp.eHI != 0) {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fe(localp.eHI);
    }
    return oD(paramString);
  }
  
  public static boolean oD(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    m.Tg().jJ(paramString);
    oy(paramString);
    return new com.tencent.mm.vfs.b(getFullPath(paramString)).delete();
  }
  
  public static boolean oE(String paramString)
  {
    p localp = m.Tg().oJ(paramString);
    if (localp == null) {}
    do
    {
      return true;
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(getFullPath(paramString));
      paramString = ox(paramString);
      if ((paramString != null) && ((paramString instanceof a)) && (Math.abs(localb.length() - localp.ebK) == 6L))
      {
        y.i("MicroMsg.VoiceLogic", "maybe amr, ignore for the moment. %d %d", new Object[] { Long.valueOf(localb.length()), Integer.valueOf(localp.ebK) });
        return true;
      }
      if (localb.length() != localp.ebK)
      {
        y.e("MicroMsg.VoiceLogic", "checkChecksum fail. %d, %d", new Object[] { Long.valueOf(localb.length()), Integer.valueOf(localp.ebK) });
        return false;
      }
      paramString = paramString.bz(0, localp.ebK);
    } while ((paramString.ret != 0) || (localp.eKZ == 0) || (localp.eKZ == b(localp.eKZ & 0xFF, paramString.buf, paramString.bDu)));
    y.e("MicroMsg.VoiceLogic", "checkChecksum fail2. %d", new Object[] { Integer.valueOf(localp.eKZ) });
    return false;
  }
  
  public static bi oF(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = m.Tg().oJ(paramString);
    } while (paramString == null);
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(paramString.eHI);
  }
  
  public static p oG(String paramString)
  {
    return m.Tg().oJ(paramString);
  }
  
  public static int oH(String paramString)
  {
    synchronized (eLa)
    {
      if (eLa.get(paramString) != null)
      {
        paramString = (com.tencent.mm.ah.j)((WeakReference)eLa.get(paramString)).get();
        if (paramString != null)
        {
          int i = (int)paramString.uy();
          return i;
        }
      }
      return -1;
    }
  }
  
  public static boolean ow(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = m.Tg().oJ(paramString);
    } while ((paramString == null) || (paramString.eHJ >= 250));
    paramString.eHJ += 1;
    paramString.bcw = 8192;
    return a(paramString);
  }
  
  public static b ox(String paramString)
  {
    u localu = m.Tg();
    String str = getFullPath(paramString);
    switch (o.ou(paramString))
    {
    default: 
      if (localu.eLm.get(str) == null) {
        localu.eLm.put(str, new a(str));
      }
      return (b)localu.eLm.get(str);
    case 0: 
      if (localu.eLm.get(str) == null) {
        localu.eLm.put(str, new a(str));
      }
      return (b)localu.eLm.get(str);
    case 1: 
      if (localu.eLn.get(str) == null) {
        localu.eLn.put(str, new l(str));
      }
      return (b)localu.eLn.get(str);
    }
    if (localu.eLo.get(str) == null) {
      localu.eLo.put(str, new h(str));
    }
    return (b)localu.eLo.get(str);
  }
  
  public static void oy(String paramString)
  {
    u localu = m.Tg();
    String str = getFullPath(paramString);
    switch (o.ou(paramString))
    {
    default: 
      paramString = (a)localu.eLm.get(str);
      if (paramString != null)
      {
        paramString.SW();
        localu.eLm.remove(str);
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          return;
          paramString = (a)localu.eLm.get(str);
        } while (paramString == null);
        paramString.SW();
        localu.eLm.remove(str);
        return;
        paramString = (l)localu.eLn.get(str);
      } while (paramString == null);
      paramString.SW();
      localu.eLn.remove(str);
      return;
      paramString = (h)localu.eLo.get(str);
    } while (paramString == null);
    paramString.SW();
    localu.eLo.remove(str);
  }
  
  public static String oz(String paramString)
  {
    String str = u.oI(com.tencent.mm.model.q.Gj());
    p localp = new p();
    localp.fileName = str;
    localp.bVI = paramString;
    localp.createTime = (System.currentTimeMillis() / 1000L);
    localp.clientId = str;
    localp.eHF = (System.currentTimeMillis() / 1000L);
    localp.status = 1;
    localp.eHA = com.tencent.mm.model.q.Gj();
    localp.bcw = -1;
    if (!m.Tg().b(localp)) {
      return null;
    }
    y.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.q
 * JD-Core Version:    0.7.0.1
 */