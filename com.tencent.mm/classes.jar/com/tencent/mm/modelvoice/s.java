package com.tencent.mm.modelvoice;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  private static final HashMap<String, WeakReference<com.tencent.mm.ai.j>> gaH;
  public static volatile HashMap<String, Integer> gaI;
  public static volatile HashMap<String, Integer> gaJ;
  public static volatile HashMap<String, Integer> gaK;
  
  static
  {
    AppMethodBeat.i(116651);
    gaH = new HashMap();
    gaI = new HashMap();
    gaJ = new HashMap();
    gaK = new HashMap();
    AppMethodBeat.o(116651);
  }
  
  public static boolean K(bi parambi)
  {
    AppMethodBeat.i(116645);
    if ((parambi == null) || (!parambi.dvW()))
    {
      AppMethodBeat.o(116645);
      return false;
    }
    boolean bool = new p(parambi.field_content).fXr;
    AppMethodBeat.o(116645);
    return bool;
  }
  
  public static boolean L(bi parambi)
  {
    AppMethodBeat.i(116646);
    if ((parambi == null) || (!parambi.dvW()) || (parambi.field_isSend == 1))
    {
      AppMethodBeat.o(116646);
      return false;
    }
    if (new p(parambi.field_content).time == 0L)
    {
      AppMethodBeat.o(116646);
      return true;
    }
    AppMethodBeat.o(116646);
    return false;
  }
  
  public static void M(bi parambi)
  {
    AppMethodBeat.i(116647);
    if ((parambi == null) || (!parambi.dvW()))
    {
      AppMethodBeat.o(116647);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(parambi.field_msgId);
    if (((dd)localObject).field_msgId != parambi.field_msgId)
    {
      AppMethodBeat.o(116647);
      return;
    }
    localObject = new p(((dd)localObject).field_content);
    if (((p)localObject).fXr)
    {
      AppMethodBeat.o(116647);
      return;
    }
    ((p)localObject).fXr = true;
    StringBuilder localStringBuilder = new StringBuilder().append(((p)localObject).fXq).append(":").append(((p)localObject).time).append(":");
    if (((p)localObject).fXr) {}
    for (int i = 1;; i = 0)
    {
      parambi.setContent(i + "\n");
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(parambi.field_msgId, parambi);
      AppMethodBeat.o(116647);
      return;
    }
  }
  
  public static String V(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(116619);
    g.a locala = new g.a();
    String str = com.tencent.mm.sdk.platformtools.j.b(YM(), "msg_", paramString, ".amr", 2);
    ab.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + locala.Mm() + " " + str);
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(116619);
      return null;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(116619);
      return str;
    }
    if (new com.tencent.mm.vfs.b(str).exists())
    {
      AppMethodBeat.o(116619);
      return str;
    }
    paramString = amy() + paramString;
    if (new com.tencent.mm.vfs.b(paramString + ".amr").exists()) {
      com.tencent.mm.vfs.e.aT(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(116619);
      return str;
      if (new com.tencent.mm.vfs.b(paramString).exists()) {
        com.tencent.mm.vfs.e.aT(paramString, str);
      }
    }
  }
  
  public static String YM()
  {
    AppMethodBeat.i(116650);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().eHR + "voice2/";
    AppMethodBeat.o(116650);
    return localObject;
  }
  
  public static int a(r paramr, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, e.a parama)
  {
    AppMethodBeat.i(116632);
    g.a locala = new g.a();
    r localr = o.ams().hj(paramr.cFn);
    if ((localr != null) && (localr.status == 99))
    {
      AppMethodBeat.o(116632);
      return 0;
    }
    if ((((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().ag(paramr.cDt, paramr.cFn).field_msgSvrId == paramr.cFn) && (localr == null))
    {
      AppMethodBeat.o(116632);
      return 0;
    }
    boolean bool1;
    String str1;
    String str2;
    int i;
    if (localr != null)
    {
      paramr.fileName = localr.fileName;
      paramr.bsY |= 0x1;
      ab.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Ml() + "checktime :" + locala.Mm());
      boolean bool2 = false;
      bool1 = bool2;
      if (paramArrayOfByte != null)
      {
        bool1 = bool2;
        if (paramArrayOfByte.length > 1)
        {
          if (localr != null) {
            ab.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
          }
          str1 = paramr.fZr;
          str2 = paramr.fileName;
          i = bb(str1, str2).write(paramArrayOfByte, paramArrayOfByte.length, 0);
          if (i >= 0) {
            break label636;
          }
          ab.e("MicroMsg.VoiceLogic", "Write Failed File:" + str2 + " newOffset:" + i + " voiceFormat:" + str1);
          bool1 = false;
          label271:
          paramr.gaG = c(paramr.gaG, paramArrayOfByte, paramArrayOfByte.length);
          paramr.bsY |= 0x80000;
        }
      }
      ab.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Ml() + "checktime :" + locala.Mm());
      paramr.fXv = (System.currentTimeMillis() / 1000L);
      paramr.bsY |= 0x100;
      if (!bool1) {
        break label761;
      }
      paramr.status = 99;
    }
    for (;;)
    {
      paramr.bsY |= 0x40;
      if (localr != null) {
        break label831;
      }
      if (bool1) {
        paramr.fXy = ((int)a(paramr, bool1, paramInt, paramString1, paramString2, parama));
      }
      if (parama != null)
      {
        paramr.dnr = bf.d(parama);
        if (parama.eyJ != null) {
          paramr.gaE = parama.eyJ.woW;
        }
      }
      ab.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Ml() + "checktime :" + locala.Mm());
      paramr.bsY = -1;
      ab.d("MicroMsg.VoiceLogic", "Insert fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.fWa + " total:" + paramr.fsd);
      if (o.ams().b(paramr)) {
        break label785;
      }
      ab.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.fWa + " total:" + paramr.fsd);
      AppMethodBeat.o(116632);
      return -2;
      paramr.fileName = w.vV(paramr.fXq);
      break;
      label636:
      if (paramArrayOfByte.length != i)
      {
        ab.e("MicroMsg.VoiceLogic", "Write File:" + str2 + " fileOff:" + i + " bufLen:" + paramArrayOfByte.length + " voiceFormat:" + str1);
        bool1 = false;
        break label271;
      }
      ab.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str2 + "] + buf:" + paramArrayOfByte.length + " voiceFormat:" + str1);
      vL(str2);
      bool1 = true;
      break label271;
      label761:
      if (paramr.fsd == 0) {
        paramr.status = 5;
      } else {
        paramr.status = 6;
      }
    }
    label785:
    ab.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Ml() + "checktime :" + locala.Mm());
    if (bool1)
    {
      AppMethodBeat.o(116632);
      return 1;
      label831:
      ab.d("MicroMsg.VoiceLogic", "Sync Update file:" + paramr.fileName + " stat:" + paramr.status);
      if (!a(paramr))
      {
        AppMethodBeat.o(116632);
        return -44;
      }
      if (bool1)
      {
        a(paramr, parama);
        AppMethodBeat.o(116632);
        return 1;
      }
    }
    if ((localr != null) && (localr.fXs == paramr.fsd))
    {
      a(localr.fileName, localr.fXs, parama);
      ab.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + localr.fileName);
    }
    ab.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[] { parama, Boolean.valueOf(bool1), bo.dtY() });
    o.amu().run();
    AppMethodBeat.o(116632);
    return 0;
  }
  
  public static int a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(116628);
    if (paramString1 == null)
    {
      AppMethodBeat.o(116628);
      return -1;
    }
    ab.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + paramString1 + "] newOff:" + paramInt1 + " SvrID:" + paramLong + " clientID:" + paramString2 + " hasSendEndFlag " + paramInt2);
    r localr = o.ams().vW(paramString1);
    if (localr == null)
    {
      AppMethodBeat.o(116628);
      return -1;
    }
    localr.fWa = paramInt1;
    localr.fXv = (System.currentTimeMillis() / 1000L);
    localr.bsY = 264;
    if ((bo.isNullOrNil(localr.clientId)) && (paramString2 != null))
    {
      localr.clientId = paramString2;
      localr.bsY |= 0x200;
    }
    if ((localr.cFn == 0L) && (paramLong != 0L))
    {
      localr.cFn = paramLong;
      localr.bsY |= 0x4;
    }
    int j = 0;
    int i = j;
    if (localr.fsd <= paramInt1)
    {
      i = j;
      if (localr.status == 3)
      {
        i = j;
        if (paramInt2 == 1)
        {
          localr.status = 99;
          localr.bsY |= 0x40;
          paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(localr.fXy);
          paramString2.kj(localr.cDt);
          paramString2.fP(localr.cFn);
          paramString2.setStatus(2);
          paramString2.setContent(p.d(localr.fXq, localr.gaD, false));
          paramString2.Nx(paramInt3);
          Integer localInteger = (Integer)gaI.get(getFullPath(paramString1));
          if (localInteger != null)
          {
            localr.gaG = localInteger.intValue();
            localr.bsY |= 0x80000;
          }
          ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(localr.fXy, paramString2);
          ab.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + paramString1 + " total:" + localr.fsd + " status:" + localr.status + " netTimes:" + localr.fXz + " msgId:" + paramString2.field_msgId);
          i = 1;
          vL(paramString1);
        }
      }
    }
    if (!a(localr))
    {
      AppMethodBeat.o(116628);
      return -4;
    }
    AppMethodBeat.o(116628);
    return i;
  }
  
  public static int a(String paramString, int paramInt, e.a parama)
  {
    AppMethodBeat.i(116635);
    if (paramString == null)
    {
      AppMethodBeat.o(116635);
      return -1;
    }
    r localr = o.ams().vW(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(116635);
      return -1;
    }
    localr.fXs = paramInt;
    localr.fXv = (System.currentTimeMillis() / 1000L);
    localr.bsY = 272;
    int j = 0;
    int i = j;
    if (localr.fsd > 0)
    {
      i = j;
      if (paramInt >= localr.fsd)
      {
        a(localr, parama);
        localr.status = 99;
        localr.bsY |= 0x40;
        ab.d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localr.fsd + " status:" + localr.status + " netTimes:" + localr.fXz);
        i = 1;
        vL(paramString);
      }
    }
    ab.d("MicroMsg.VoiceLogic", "updateRecv file:" + paramString + " newsize:" + paramInt + " total:" + localr.fsd + " status:" + localr.status);
    if (!a(localr))
    {
      AppMethodBeat.o(116635);
      return -3;
    }
    AppMethodBeat.o(116635);
    return i;
  }
  
  private static long a(r paramr, boolean paramBoolean, int paramInt, String paramString1, String paramString2, e.a parama)
  {
    AppMethodBeat.i(116634);
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kD(paramr.cFn))
    {
      ab.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(paramr.cFn) });
      if (bo.nullAsNil(paramr.fileName).length() > 0) {
        o.ams().qD(paramr.fileName);
      }
      for (;;)
      {
        AppMethodBeat.o(116634);
        return -1L;
        ab.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
      }
    }
    bi localbi = new bi();
    localbi.fP(paramr.cFn);
    localbi.kk(paramr.fileName);
    localbi.fQ(bf.x(paramr.cDt, paramr.createTime));
    localbi.kj(paramr.cDt);
    int i;
    if (com.tencent.mm.model.r.nB(paramr.fXq))
    {
      i = 1;
      localbi.hL(i);
      localbi.setType(34);
      localbi.ko(paramString1);
      localbi.Nx(paramr.fZy);
      localbi.setStatus(paramInt);
      if (parama != null) {
        break label557;
      }
      paramInt = paramr.dnr;
      if (paramInt != 0)
      {
        ab.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[] { Integer.valueOf(paramInt) });
        localbi.hV(paramInt);
        if ((localbi.field_msgId == 0L) && (localbi.field_isSend == 0) && ((paramInt & 0x2) != 0)) {
          localbi.fQ(bf.n(localbi.field_talker, paramr.createTime, localbi.field_msgSeq));
        }
      }
      if (paramr.gaE != 0) {
        localbi.fS(paramr.gaE);
      }
      ab.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramr.gaE) });
      label329:
      ab.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[] { paramString2 });
      if (!bo.isNullOrNil(paramString2))
      {
        localbi.jl(paramString2);
        localbi.kp(bf.pB(paramString2));
      }
      if (paramBoolean) {
        break label567;
      }
      localbi.setContent(p.d(paramr.fXq, 0L, false));
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramString2))
      {
        localbi.jl(paramString2);
        localbi.kp(bf.pB(paramString2));
        paramr = bf.pA(paramString2);
        if (paramr != null)
        {
          localbi.kp(paramr.fmI);
          localbi.kn(paramr.fmH);
          ab.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[] { paramr.fmH });
          if (paramr.fmL != null)
          {
            paramString1 = new ji();
            paramString1.cyM.cmQ = localbi;
            paramString1.cyM.cyN = paramr;
            com.tencent.mm.sdk.b.a.ymk.l(paramString1);
          }
        }
      }
      ab.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[] { Long.valueOf(localbi.field_msgSvrId), Long.valueOf(localbi.field_msgSeq) });
      long l = bf.l(localbi);
      AppMethodBeat.o(116634);
      return l;
      i = 0;
      break;
      label557:
      bf.a(localbi, parama);
      break label329;
      label567:
      localbi.setContent(p.d(paramr.fXq, paramr.gaD, false));
    }
  }
  
  private static boolean a(r paramr)
  {
    AppMethodBeat.i(116643);
    if (paramr == null)
    {
      AppMethodBeat.o(116643);
      return false;
    }
    if (paramr.bsY == -1)
    {
      AppMethodBeat.o(116643);
      return false;
    }
    boolean bool = o.ams().a(paramr.fileName, paramr);
    AppMethodBeat.o(116643);
    return bool;
  }
  
  private static boolean a(r paramr, e.a parama)
  {
    AppMethodBeat.i(116633);
    try
    {
      paramr.fXy = ((int)a(paramr, true, 3, "", paramr.dns, parama));
      paramr.bsY |= 0x800;
      boolean bool = a(paramr);
      AppMethodBeat.o(116633);
      return bool;
    }
    catch (Exception paramr)
    {
      ab.e("MicroMsg.VoiceLogic", "exception:%s", new Object[] { bo.l(paramr) });
      AppMethodBeat.o(116633);
    }
    return false;
  }
  
  public static boolean a(String paramString, com.tencent.mm.ai.j paramj)
  {
    AppMethodBeat.i(116621);
    if (paramString == null)
    {
      AppMethodBeat.o(116621);
      return false;
    }
    r localr = o.ams().vW(paramString);
    if (localr == null)
    {
      ab.d("MicroMsg.VoiceLogic", "startSend null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(116621);
      return false;
    }
    if (localr.status != 1)
    {
      AppMethodBeat.o(116621);
      return false;
    }
    localr.status = 2;
    localr.bsY = 64;
    synchronized (gaH)
    {
      gaH.put(paramString, new WeakReference(paramj));
      boolean bool = a(localr);
      AppMethodBeat.o(116621);
      return bool;
    }
  }
  
  public static boolean ah(String paramString, int paramInt)
  {
    AppMethodBeat.i(116626);
    boolean bool = w(paramString, paramInt, 0);
    AppMethodBeat.o(116626);
    return bool;
  }
  
  public static List<r> amx()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(116642);
    Object localObject1 = o.ams();
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo";
    localObject2 = (String)localObject2 + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime";
    localObject1 = ((w)localObject1).fnw.a((String)localObject2, null, 2);
    int j = 0;
    int i = 0;
    if (((Cursor)localObject1).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        localObject2 = new r();
        ((r)localObject2).convertFrom((Cursor)localObject1);
        localArrayList.add(localObject2);
        j = i + 1;
        i = j;
      } while (((Cursor)localObject1).moveToNext());
    }
    ab.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:".concat(String.valueOf(j)));
    ((Cursor)localObject1).close();
    AppMethodBeat.o(116642);
    return localArrayList;
  }
  
  public static String amy()
  {
    AppMethodBeat.i(116649);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().eHR + "voice/";
    AppMethodBeat.o(116649);
    return localObject;
  }
  
  /* Error */
  public static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
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
  
  public static b bb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116615);
    w localw = o.ams();
    paramString2 = getFullPath(paramString2);
    switch (bo.getInt(paramString1, -1))
    {
    case 2: 
    case 3: 
    default: 
      if (localw.gaT.get(paramString2) == null) {
        localw.gaT.put(paramString2, new a(paramString2));
      }
      paramString1 = (b)localw.gaT.get(paramString2);
      AppMethodBeat.o(116615);
      return paramString1;
    case 4: 
      if (localw.gaV.get(paramString2) == null) {
        localw.gaV.put(paramString2, new j(paramString2));
      }
      paramString1 = (b)localw.gaV.get(paramString2);
      AppMethodBeat.o(116615);
      return paramString1;
    }
    if (localw.gaU.get(paramString2) == null) {
      localw.gaU.put(paramString2, new n(paramString2));
    }
    paramString1 = (b)localw.gaU.get(paramString2);
    AppMethodBeat.o(116615);
    return paramString1;
  }
  
  public static int c(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(116629);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(116629);
      return paramInt1;
    }
    if (paramInt1 == 0) {
      paramInt1 = paramArrayOfByte.hashCode() & 0xFF;
    }
    int j;
    for (int i = paramInt1;; i = paramInt1 & 0xFF)
    {
      int k = 0;
      j = paramInt1;
      paramInt1 = k;
      while (paramInt1 < paramInt2)
      {
        j += (paramArrayOfByte[(paramInt1 + 0)] & i) * 256;
        paramInt1 += 1;
      }
    }
    AppMethodBeat.o(116629);
    return j;
  }
  
  public static int c(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(116630);
    paramString = o.ams().vW(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(116630);
      return -1;
    }
    paramString.gaG = c(paramString.gaG, paramArrayOfByte, paramInt);
    paramString.bsY |= 0x80000;
    if (a(paramString))
    {
      paramInt = paramString.gaG;
      AppMethodBeat.o(116630);
      return paramInt;
    }
    AppMethodBeat.o(116630);
    return 0;
  }
  
  public static String getFullPath(String paramString)
  {
    AppMethodBeat.i(116618);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116618);
      return null;
    }
    paramString = V(paramString, false);
    AppMethodBeat.o(116618);
    return paramString;
  }
  
  public static float hi(long paramLong)
  {
    float f2 = 60.0F;
    float f1 = 1.0F;
    AppMethodBeat.i(116644);
    float f3 = (float)paramLong / 1000.0F;
    if (f3 < 1.0F) {}
    for (;;)
    {
      if (f1 > 60.0F) {
        f1 = f2;
      }
      for (;;)
      {
        f1 = Math.round(f1);
        AppMethodBeat.o(116644);
        return f1;
      }
      f1 = f3;
    }
  }
  
  public static String i(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(116638);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(116638);
      return null;
    }
    if ((!bo.isNullOrNil(paramString2)) && (!paramString2.startsWith("amr_")) && (!paramString2.startsWith("spx_"))) {
      paramString2.startsWith("silk_");
    }
    paramString1 = vM(paramString1);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(116638);
      return null;
    }
    if (com.tencent.mm.vfs.e.C(getFullPath(paramString2), getFullPath(paramString1)) < 0L)
    {
      AppMethodBeat.o(116638);
      return null;
    }
    w(paramString1, paramInt, 1);
    AppMethodBeat.o(116638);
    return paramString1;
  }
  
  public static int mq(int paramInt)
  {
    return (paramInt - 6) / 32 * 20;
  }
  
  public static boolean mr(int paramInt)
  {
    AppMethodBeat.i(116637);
    bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(paramInt);
    if ((localbi.field_msgId == 0L) || (localbi.field_imgPath == null))
    {
      AppMethodBeat.o(116637);
      return false;
    }
    if (bo.isNullOrNil(localbi.field_imgPath))
    {
      AppMethodBeat.o(116637);
      return false;
    }
    Object localObject = localbi.field_imgPath;
    localObject = o.ams().vW((String)localObject);
    if ((localObject == null) || (bo.isNullOrNil(((r)localObject).fileName)))
    {
      AppMethodBeat.o(116637);
      return false;
    }
    ((r)localObject).status = 3;
    ((r)localObject).fWa = 0;
    ((r)localObject).createTime = (System.currentTimeMillis() / 1000L);
    ((r)localObject).fXv = (System.currentTimeMillis() / 1000L);
    ((r)localObject).bsY = 8648;
    boolean bool = a((r)localObject);
    ab.d("MicroMsg.VoiceLogic", " file:" + ((r)localObject).fileName + " msgid:" + ((r)localObject).fXy + "  stat:" + ((r)localObject).status);
    if ((((r)localObject).fXy == 0) || (bo.isNullOrNil(((r)localObject).cDt)))
    {
      ab.e("MicroMsg.VoiceLogic", " failed msg id:" + ((r)localObject).fXy + " user:" + ((r)localObject).cDt);
      AppMethodBeat.o(116637);
      return bool;
    }
    localbi.setStatus(1);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(localbi.field_msgId, localbi);
    o.amu().run();
    AppMethodBeat.o(116637);
    return true;
  }
  
  public static boolean vJ(String paramString)
  {
    AppMethodBeat.i(116614);
    if (paramString == null)
    {
      AppMethodBeat.o(116614);
      return false;
    }
    paramString = o.ams().vW(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(116614);
      return false;
    }
    if (paramString.fXz >= 250)
    {
      AppMethodBeat.o(116614);
      return false;
    }
    paramString.fXz += 1;
    paramString.bsY = 8192;
    boolean bool = a(paramString);
    AppMethodBeat.o(116614);
    return bool;
  }
  
  public static b vK(String paramString)
  {
    AppMethodBeat.i(116616);
    w localw = o.ams();
    String str = getFullPath(paramString);
    switch (q.vH(paramString))
    {
    default: 
      if (localw.gaT.get(str) == null) {
        localw.gaT.put(str, new a(str));
      }
      paramString = (b)localw.gaT.get(str);
      AppMethodBeat.o(116616);
      return paramString;
    case 0: 
      if (localw.gaT.get(str) == null) {
        localw.gaT.put(str, new a(str));
      }
      paramString = (b)localw.gaT.get(str);
      AppMethodBeat.o(116616);
      return paramString;
    case 1: 
      if (localw.gaU.get(str) == null) {
        localw.gaU.put(str, new n(str));
      }
      paramString = (b)localw.gaU.get(str);
      AppMethodBeat.o(116616);
      return paramString;
    }
    if (localw.gaV.get(str) == null) {
      localw.gaV.put(str, new j(str));
    }
    paramString = (b)localw.gaV.get(str);
    AppMethodBeat.o(116616);
    return paramString;
  }
  
  private static void vL(String paramString)
  {
    AppMethodBeat.i(116617);
    w localw = o.ams();
    String str = getFullPath(paramString);
    switch (q.vH(paramString))
    {
    default: 
      paramString = (a)localw.gaT.get(str);
      if (paramString != null)
      {
        paramString.amh();
        localw.gaT.remove(str);
      }
      AppMethodBeat.o(116617);
      return;
    case 0: 
      paramString = (a)localw.gaT.get(str);
      if (paramString != null)
      {
        paramString.amh();
        localw.gaT.remove(str);
      }
      AppMethodBeat.o(116617);
      return;
    case 1: 
      paramString = (n)localw.gaU.get(str);
      if (paramString != null)
      {
        paramString.amh();
        localw.gaU.remove(str);
      }
      AppMethodBeat.o(116617);
      return;
    }
    paramString = (j)localw.gaV.get(str);
    if (paramString != null)
    {
      paramString.amh();
      localw.gaV.remove(str);
    }
    AppMethodBeat.o(116617);
  }
  
  public static String vM(String paramString)
  {
    AppMethodBeat.i(116620);
    String str = w.vV(com.tencent.mm.model.r.Zn());
    r localr = new r();
    localr.fileName = str;
    localr.cDt = paramString;
    localr.createTime = (System.currentTimeMillis() / 1000L);
    localr.clientId = str;
    localr.fXv = (System.currentTimeMillis() / 1000L);
    localr.status = 1;
    localr.fXq = com.tencent.mm.model.r.Zn();
    localr.bsY = -1;
    if (!o.ams().b(localr))
    {
      AppMethodBeat.o(116620);
      return null;
    }
    ab.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
    AppMethodBeat.o(116620);
    return str;
  }
  
  public static boolean vN(String paramString)
  {
    AppMethodBeat.i(116622);
    if (paramString == null)
    {
      AppMethodBeat.o(116622);
      return false;
    }
    ab.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + paramString + "]");
    r localr = o.ams().vW(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(116622);
      return false;
    }
    localr.status = 8;
    localr.fsd = q.vh(paramString);
    localr.bsY = 96;
    boolean bool = a(localr);
    AppMethodBeat.o(116622);
    return bool;
  }
  
  public static boolean vO(String paramString)
  {
    AppMethodBeat.i(116623);
    if (paramString == null)
    {
      AppMethodBeat.o(116623);
      return false;
    }
    r localr = o.ams().vW(paramString);
    if (localr == null)
    {
      ab.d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(116623);
      return true;
    }
    ab.d("MicroMsg.VoiceLogic", "cancel download : " + paramString + " SvrlId:" + localr.cFn);
    if (localr.cFn != 0L) {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().aq(localr.cDt, localr.cFn);
    }
    boolean bool = vQ(paramString);
    AppMethodBeat.o(116623);
    return bool;
  }
  
  public static boolean vP(String paramString)
  {
    AppMethodBeat.i(116624);
    if (paramString == null)
    {
      AppMethodBeat.o(116624);
      return false;
    }
    r localr = o.ams().vW(paramString);
    if (localr == null)
    {
      ab.i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(116624);
      return true;
    }
    ab.i("MicroMsg.VoiceLogic", "cancel record : " + paramString + " LocalId:" + localr.fXy);
    if (localr.fXy != 0) {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kC(localr.fXy);
    }
    boolean bool = vQ(paramString);
    AppMethodBeat.o(116624);
    return bool;
  }
  
  public static boolean vQ(String paramString)
  {
    AppMethodBeat.i(116625);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116625);
      return false;
    }
    o.ams().qD(paramString);
    vL(paramString);
    boolean bool = new com.tencent.mm.vfs.b(getFullPath(paramString)).delete();
    AppMethodBeat.o(116625);
    return bool;
  }
  
  public static boolean vR(String paramString)
  {
    AppMethodBeat.i(116631);
    r localr = o.ams().vW(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(116631);
      return true;
    }
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(getFullPath(paramString));
    paramString = vK(paramString);
    if ((paramString != null) && ((paramString instanceof a)) && (Math.abs(localb.length() - localr.fsd) == 6L))
    {
      ab.i("MicroMsg.VoiceLogic", "maybe amr, ignore for the moment. %d %d", new Object[] { Long.valueOf(localb.length()), Integer.valueOf(localr.fsd) });
      AppMethodBeat.o(116631);
      return true;
    }
    if (localb.length() != localr.fsd)
    {
      ab.e("MicroMsg.VoiceLogic", "checkChecksum fail. %d, %d", new Object[] { Long.valueOf(localb.length()), Integer.valueOf(localr.fsd) });
      AppMethodBeat.o(116631);
      return false;
    }
    paramString = paramString.cJ(0, localr.fsd);
    if ((paramString.ret == 0) && (localr.gaG != 0) && (localr.gaG != c(localr.gaG & 0xFF, paramString.buf, paramString.ckj)))
    {
      ab.e("MicroMsg.VoiceLogic", "checkChecksum fail2. %d", new Object[] { Integer.valueOf(localr.gaG) });
      AppMethodBeat.o(116631);
      return false;
    }
    AppMethodBeat.o(116631);
    return true;
  }
  
  public static bi vS(String paramString)
  {
    AppMethodBeat.i(116640);
    if (paramString == null)
    {
      AppMethodBeat.o(116640);
      return null;
    }
    paramString = o.ams().vW(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(116640);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(paramString.fXy);
    AppMethodBeat.o(116640);
    return paramString;
  }
  
  public static r vT(String paramString)
  {
    AppMethodBeat.i(156818);
    paramString = o.ams().vW(paramString);
    AppMethodBeat.o(156818);
    return paramString;
  }
  
  public static int vU(String paramString)
  {
    AppMethodBeat.i(116648);
    synchronized (gaH)
    {
      if (gaH.get(paramString) != null)
      {
        paramString = (com.tencent.mm.ai.j)((WeakReference)gaH.get(paramString)).get();
        if (paramString != null)
        {
          int i = (int)paramString.EN();
          AppMethodBeat.o(116648);
          return i;
        }
      }
      AppMethodBeat.o(116648);
      return -1;
    }
  }
  
  public static boolean vk(String paramString)
  {
    AppMethodBeat.i(116639);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 234L, 1L, false);
    if (paramString == null)
    {
      AppMethodBeat.o(116639);
      return false;
    }
    r localr = o.ams().vW(paramString);
    if (localr == null)
    {
      ab.e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(116639);
      return false;
    }
    localr.status = 98;
    localr.fXv = (System.currentTimeMillis() / 1000L);
    localr.bsY = 320;
    boolean bool = a(localr);
    ab.d("MicroMsg.VoiceLogic", "setError file:" + paramString + " msgid:" + localr.fXy + " old stat:" + localr.status);
    if ((localr.fXy == 0) || (bo.isNullOrNil(localr.cDt)))
    {
      ab.e("MicroMsg.VoiceLogic", "setError failed msg id:" + localr.fXy + " user:" + localr.cDt);
      AppMethodBeat.o(116639);
      return bool;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(localr.fXy);
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 33L, 1L, true);
    paramString.setMsgId(localr.fXy);
    paramString.setStatus(5);
    paramString.kj(localr.cDt);
    paramString.setContent(p.d(localr.fXq, -1L, true));
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(116639);
    return bool;
  }
  
  public static boolean vl(String paramString)
  {
    AppMethodBeat.i(116636);
    paramString = o.ams().vW(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(116636);
      return false;
    }
    if (paramString.status == 3)
    {
      bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(paramString.fXy);
      localbi.setContent(p.d(paramString.fXq, paramString.gaD, false));
      localbi.setStatus(2);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(paramString.fXy, localbi);
    }
    paramString.status = 97;
    paramString.fXv = (System.currentTimeMillis() / 1000L);
    paramString.bsY = 320;
    boolean bool = a(paramString);
    AppMethodBeat.o(116636);
    return bool;
  }
  
  private static boolean w(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116627);
    if (paramString == null)
    {
      AppMethodBeat.o(116627);
      return false;
    }
    ab.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + paramString + "], fullPath[" + getFullPath(paramString) + "]");
    ??? = o.ams().vW(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(116627);
      return false;
    }
    if ((((r)???).status != 97) && (((r)???).status != 98)) {
      ((r)???).status = 3;
    }
    ((r)???).fsd = q.vh(paramString);
    if (((r)???).fsd <= 0)
    {
      vk(paramString);
      AppMethodBeat.o(116627);
      return false;
    }
    ((r)???).fXv = (System.currentTimeMillis() / 1000L);
    ((r)???).gaD = paramInt1;
    ((r)???).bsY = 3424;
    bi localbi = new bi();
    localbi.kj(((r)???).cDt);
    localbi.setType(34);
    localbi.hL(1);
    localbi.kk(paramString);
    if (((r)???).status == 97)
    {
      localbi.setStatus(2);
      localbi.setContent(p.d(((r)???).fXq, ((r)???).gaD, false));
    }
    for (;;)
    {
      localbi.fQ(bf.py(((r)???).cDt));
      localbi.Nx(paramInt2);
      a.a.Ky().g(localbi);
      ((r)???).fXy = ((int)bf.l(localbi));
      boolean bool = a((r)???);
      synchronized (gaH)
      {
        gaH.remove(paramString);
        AppMethodBeat.o(116627);
        return bool;
        if (((r)???).status == 98)
        {
          localbi.setStatus(5);
          localbi.setContent(p.d(((r)???).fXq, -1L, true));
          continue;
        }
        localbi.setStatus(1);
        localbi.setContent(p.d(((r)???).fXq, ((r)???).gaD, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s
 * JD-Core Version:    0.7.0.1
 */