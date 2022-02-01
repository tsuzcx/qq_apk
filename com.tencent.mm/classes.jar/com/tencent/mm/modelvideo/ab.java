package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.util.b.a;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;

public final class ab
{
  public static boolean Qe(String paramString)
  {
    AppMethodBeat.i(126988);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString = Qo(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    if (paramString.pbd >= 2500)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString.pbd += 1;
    paramString.eQp = 16384;
    boolean bool = f(paramString);
    AppMethodBeat.o(126988);
    return bool;
  }
  
  public static boolean Qf(String paramString)
  {
    AppMethodBeat.i(126989);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 218L, 1L, false);
    Log.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[] { paramString, Util.getStack() });
    v.bOm().Qx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126989);
      return false;
    }
    z localz = Qo(paramString);
    if (localz == null)
    {
      Log.e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(126989);
      return false;
    }
    localz.status = 198;
    localz.pba = (System.currentTimeMillis() / 1000L);
    localz.eQp = 1280;
    dmb localdmb = localz.pbl;
    localdmb.Gad = 0;
    localz.pbl = localdmb;
    boolean bool = f(localz);
    Log.d("MicroMsg.VideoLogic", "setError file:" + paramString + " msgid:" + localz.pbc + " old stat:" + localz.status);
    if ((localz == null) || (localz.pbc == 0))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localz.pbc);
    int i = paramString.getType();
    Log.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 32L, 1L, true);
    paramString.BS(localz.bOs());
    paramString.setContent(x.a(localz.bOq(), -1L, true));
    Log.d("MicroMsg.VideoLogic", "[oneliang][setError]");
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(126989);
    return bool;
  }
  
  public static boolean Qg(String paramString)
  {
    AppMethodBeat.i(126990);
    paramString = Qo(paramString);
    if ((paramString == null) || (paramString.pbc == 0))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramString.pbc);
    int i = localcc.getType();
    Log.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    localcc.setContent(x.a(paramString.bOq(), paramString.omT, false));
    localcc.setStatus(2);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramString.pbc, localcc);
    paramString.status = 197;
    paramString.pba = Util.nowSecond();
    paramString.eQp = 1280;
    Log.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
    boolean bool = f(paramString);
    AppMethodBeat.o(126990);
    return bool;
  }
  
  public static int Qh(String paramString)
  {
    AppMethodBeat.i(126998);
    z localz = Qo(paramString);
    if (localz == null)
    {
      Log.e("MicroMsg.VideoLogic", "SENDERR:" + com.tencent.mm.compatible.util.f.aPX() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    if ((localz.status != 102) && (localz.status != 105))
    {
      Log.e("MicroMsg.VideoLogic", "SENDERR:" + com.tencent.mm.compatible.util.f.aPX() + " get status failed: " + paramString + " status:" + localz.status);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    int i = localz.status;
    if ((localz.status != 102) && (localz.paZ == localz.paY)) {}
    for (localz.status = 104;; localz.status = 103)
    {
      Log.i("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.f.aPX() + "startSend file:" + paramString + " status:[" + i + "->" + localz.status + "]");
      localz.pbb = Util.nowSecond();
      localz.pba = Util.nowSecond();
      localz.eQp = 3328;
      if (f(localz)) {
        break;
      }
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    v.bOm().run();
    AppMethodBeat.o(126998);
    return 0;
  }
  
  public static int Qi(String paramString)
  {
    AppMethodBeat.i(127000);
    z localz = Qo(paramString);
    int i;
    if (localz == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    if ((localz.status != 104) && (localz.status != 103))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " get status failed: " + paramString + " status:" + localz.status);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    localz.status = 105;
    localz.pba = Util.nowSecond();
    localz.eQp = 1280;
    if (!f(localz))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    AppMethodBeat.o(127000);
    return 0;
  }
  
  public static int Qj(String paramString)
  {
    AppMethodBeat.i(127003);
    z localz = Qo(paramString);
    int i;
    if (localz == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    if ((localz.status != 111) && (localz.status != 113) && (localz.status != 121) && (localz.status != 122) && (localz.status != 123))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " get status failed: " + paramString + " status:" + localz.status);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    localz.status = 112;
    localz.pbb = Util.nowSecond();
    localz.pba = Util.nowSecond();
    localz.eQp = 3328;
    if (!f(localz))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    v.bOm().bOJ();
    v.bOm().run();
    AppMethodBeat.o(127003);
    return 0;
  }
  
  public static int Qk(String paramString)
  {
    AppMethodBeat.i(127004);
    z localz = Qo(paramString);
    int i;
    if (localz == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    if ((localz.status != 112) && (localz.status != 120) && (localz.status != 122) && (localz.status != 123))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " get status failed: " + paramString + " status:" + localz.status);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    localz.status = 113;
    localz.pba = Util.nowSecond();
    localz.eQp = 1280;
    if (!f(localz))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    AppMethodBeat.o(127004);
    return 0;
  }
  
  public static boolean Ql(String paramString)
  {
    AppMethodBeat.i(127006);
    Log.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(paramString)));
    z localz = new z();
    localz.status = 112;
    localz.pba = Util.nowSecond();
    localz.pbb = Util.nowSecond();
    localz.fileName = paramString;
    localz.eQp = 3328;
    if (!f(localz))
    {
      AppMethodBeat.o(127006);
      return false;
    }
    v.bOm().run();
    AppMethodBeat.o(127006);
    return true;
  }
  
  public static boolean Qm(String paramString)
  {
    AppMethodBeat.i(127007);
    z localz = Qo(paramString);
    if (localz == null)
    {
      AppMethodBeat.o(127007);
      return false;
    }
    Log.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[] { paramString });
    paramString = localz.pbl;
    if (paramString != null)
    {
      paramString.Gad = 0;
      localz.pbl = paramString;
    }
    if (localz.paY < localz.paZ) {}
    for (localz.status = 103;; localz.status = 104)
    {
      localz.createTime = Util.nowSecond();
      localz.pba = Util.nowSecond();
      localz.pbb = Util.nowSecond();
      localz.eQp = 536874752;
      if (f(localz)) {
        break;
      }
      AppMethodBeat.o(127007);
      return false;
    }
    v.bOm().run();
    AppMethodBeat.o(127007);
    return true;
  }
  
  public static void Qn(String paramString)
  {
    AppMethodBeat.i(127008);
    String str = paramString;
    for (;;)
    {
      if (Util.isNullOrNil(str))
      {
        AppMethodBeat.o(127008);
        return;
      }
      Object localObject = Qo(str);
      paramString = null;
      if (localObject != null) {
        paramString = ((z)localObject).oYk;
      }
      localObject = v.bOh();
      if (((aa)localObject).omV.delete(aa.d.Qd(str), "filename= ?", new String[] { String.valueOf(str) }) > 0)
      {
        aa.a.a locala = new aa.a.a(str, aa.a.b.pbD, aa.a.c.pbG, 1, -1L);
        ((aa)localObject).ose.event(locala);
        ((aa)localObject).ose.doNotify();
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(127008);
        return;
      }
      try
      {
        v.bOh();
        new u(aa.PY(str)).diJ();
        v.bOh();
        new u(aa.PX(str)).diJ();
        if (!Util.isNullOrNil(paramString)) {
          str = paramString;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + com.tencent.mm.compatible.util.f.aPX() + " file:" + str + " msg:" + localException.getMessage());
        }
        AppMethodBeat.o(127008);
      }
    }
  }
  
  public static z Qo(String paramString)
  {
    AppMethodBeat.i(127009);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127009);
      return null;
    }
    paramString = v.bOh().PR(paramString);
    AppMethodBeat.o(127009);
    return paramString;
  }
  
  public static boolean Qp(String paramString)
  {
    AppMethodBeat.i(127014);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
      AppMethodBeat.o(127014);
      return false;
    }
    Log.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(paramString)));
    Object localObject = Qo(paramString);
    if ((localObject != null) && (((z)localObject).status == 199))
    {
      int i = ((z)localObject).osy;
      v.bOh();
      int j = (int)y.bEl(aa.PX(paramString));
      Log.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j > 0) && (Math.abs(j - i) > 16))
      {
        Log.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramString = ((z)localObject).getFileName();
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 217L, 1L, false);
        paramString = Qo(paramString);
        if (paramString != null)
        {
          localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramString.pbc);
          i = ((cc)localObject).getType();
          Log.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[] { Integer.valueOf(i) });
          if ((43 == i) || (62 == i))
          {
            ((cc)localObject).setContent(x.a(paramString.bOq(), paramString.omT, false));
            ((cc)localObject).setStatus(2);
            ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramString.pbc, (cc)localObject);
            paramString.status = 196;
            paramString.pba = Util.nowSecond();
            paramString.eQp = 1280;
            Log.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
            f(paramString);
          }
        }
        AppMethodBeat.o(127014);
        return true;
      }
    }
    AppMethodBeat.o(127014);
    return false;
  }
  
  public static void Qq(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127017);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127017);
      return;
    }
    if (v.bOk().db.delete("VideoPlayHistory", "filename= ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      Log.d("MicroMsg.VideoLogic", "delete video play history ret : " + bool + " filename : " + paramString);
      AppMethodBeat.o(127017);
      return;
      bool = false;
    }
  }
  
  public static boolean Qr(String paramString)
  {
    AppMethodBeat.i(127021);
    z localz = Qo(paramString);
    if (localz != null)
    {
      localz.videoFormat = 2;
      localz.eQp = 2;
      boolean bool = v.bOh().c(localz);
      Log.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(2) });
      AppMethodBeat.o(127021);
      return bool;
    }
    AppMethodBeat.o(127021);
    return false;
  }
  
  public static boolean Qs(String paramString)
  {
    AppMethodBeat.i(127022);
    paramString = Qo(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.status = 199;
      paramString.pbb = Util.nowSecond();
      paramString.pba = Util.nowSecond();
      paramString.lxk = 19;
      paramString.eQp = 268438786;
      boolean bool = v.bOh().c(paramString);
      Log.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127022);
      return bool;
    }
    AppMethodBeat.o(127022);
    return false;
  }
  
  public static boolean Qt(String paramString)
  {
    AppMethodBeat.i(127023);
    paramString = Qo(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.eQp = 2;
      boolean bool = v.bOh().c(paramString);
      Log.i("MicroMsg.VideoLogic", "set hevc video format ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127023);
      return bool;
    }
    AppMethodBeat.o(127023);
    return false;
  }
  
  public static int Qu(String paramString)
  {
    AppMethodBeat.i(127024);
    z localz = Qo(paramString);
    if (localz == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    if ((localz.status != 111) && (localz.status != 113) && (localz.status != 121) && (localz.status != 122) && (localz.status != 123))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " get status failed: " + paramString + " status:" + localz.status);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localz.pbc);
    boolean bool;
    if ((localcc != null) && (localcc.dSI()))
    {
      bool = true;
      Log.i("MicroMsg.VideoLogic", " is mp video :%b", new Object[] { Boolean.valueOf(bool) });
      e.bIg();
      if ((!e.bIt()) || (bool)) {
        break label336;
      }
      localz.status = 122;
    }
    for (int i = 256;; i = 272)
    {
      localz.pbb = Util.nowSecond();
      localz.pba = Util.nowSecond();
      localz.eQp = (i | 0x800 | 0x400);
      if (f(localz)) {
        break label362;
      }
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
      bool = false;
      break;
      label336:
      Log.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
      localz.status = 112;
      localz.paX = 0;
    }
    label362:
    v.bOm().bOJ();
    v.bOm().run();
    AppMethodBeat.o(127024);
    return 0;
  }
  
  public static int X(int paramInt, String paramString)
  {
    AppMethodBeat.i(127015);
    long l = Util.currentTicks();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if ((v.bOk().b(paramString, localPInt1, localPInt2)) && (Util.secondsToNow(localPInt1.value) < 300L)) {}
    for (int i = localPInt2.value;; i = 0)
    {
      int j;
      if (i >= 0)
      {
        j = i;
        if (i < paramInt - 1) {}
      }
      else
      {
        j = 0;
      }
      Log.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localPInt1.value), paramString, Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(127015);
      return j;
    }
  }
  
  public static long a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(241240);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(241240);
      return -1L;
    }
    if (Util.isNullOrNil(paramString2))
    {
      Log.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(241240);
      return -1L;
    }
    if (paramInt1 <= 0)
    {
      Log.w("MicroMsg.VideoLogic", "do prepare, but video len error, type %d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(241240);
      return -1L;
    }
    z localz = new z();
    long l;
    if (paramBoolean)
    {
      String str1 = paramString1 + "origin";
      v.bOh();
      String str2 = aa.PY(str1);
      v.bOh();
      y.O(aa.PY(paramString1), str2, false);
      v.bOh();
      str2 = aa.PX(str1);
      y.O(paramString3, str2, false);
      if (y.ZC(str2))
      {
        l = y.bEl(str2);
        paramBoolean = SightVideoJNI.optimizeMP4VFS(str2);
        l = Math.abs(y.bEl(str2) - l);
        if ((!paramBoolean) || (l > 1048576L))
        {
          y.deleteFile(str2);
          y.O(paramString3, str2, false);
          Log.w("MicroMsg.VideoLogic", "do prepare, modify moov fail, copy origin video again, optimize ret = " + paramBoolean + " file length diff = " + l);
        }
      }
      a(str1, null, paramInt1, paramString2, paramString3, 0, "", 43, null, "", 0, null, null, true);
      localz.PP(str1);
    }
    localz.fileName = paramString1;
    localz.omT = paramInt1;
    localz.hVQ = paramString2;
    localz.paV = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
    localz.createTime = Util.nowSecond();
    localz.pba = Util.nowSecond();
    localz.pbh = null;
    localz.oYj = paramString3;
    localz.PO(Util.nullAs(paramString4, ""));
    if (!Util.isNullOrNil(paramString3)) {
      localz.pbf = 1;
    }
    if (62 == paramInt2)
    {
      localz.pbf = 0;
      paramInt1 = 3;
    }
    for (;;)
    {
      localz.pbi = paramInt1;
      localz.osy = 0;
      localz.status = 106;
      paramString2 = new cc();
      paramString2.BS(localz.bOs());
      paramString2.setType(paramInt2);
      paramString2.pI(1);
      paramString2.BT(paramString1);
      paramString2.setStatus(8);
      paramString2.setCreateTime(br.JN(localz.bOs()));
      l = br.B(paramString2);
      localz.pbc = ((int)l);
      if (!v.bOh().b(localz)) {
        break;
      }
      AppMethodBeat.o(241240);
      return l;
      if (localz.pbf == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = -1;
      }
    }
    AppMethodBeat.o(241240);
    return -1L;
  }
  
  public static long a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(241244);
    long l = a(paramString1, paramInt, paramString2, paramString3, 43, paramString4, paramBoolean);
    AppMethodBeat.o(241244);
    return l;
  }
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, String paramString4)
  {
    AppMethodBeat.i(241220);
    boolean bool = a(paramString1, null, paramInt1, paramString2, null, paramInt2, paramString3, paramInt3, null, "", paramInt4, null, paramString4);
    AppMethodBeat.o(241220);
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: ldc_w 661
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 315	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 52
    //   15: ldc_w 663
    //   18: invokestatic 402	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 661
    //   24: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokestatic 666	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4InfoVFS	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnonnull +11 -> 46
    //   38: ldc_w 661
    //   41: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: ldc 52
    //   48: ldc_w 668
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_3
    //   58: aastore
    //   59: invokestatic 417	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: new 670	org/json/JSONObject
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 671	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   70: astore_3
    //   71: aload_1
    //   72: aload_3
    //   73: ldc_w 673
    //   76: invokevirtual 676	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   79: i2l
    //   80: invokestatic 680	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   83: putfield 524	com/tencent/mm/pointers/PInt:value	I
    //   86: aload_2
    //   87: aload_3
    //   88: ldc_w 682
    //   91: invokevirtual 676	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   94: sipush 1000
    //   97: idiv
    //   98: putfield 524	com/tencent/mm/pointers/PInt:value	I
    //   101: ldc 52
    //   103: ldc_w 684
    //   106: iconst_3
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_2
    //   113: getfield 524	com/tencent/mm/pointers/PInt:value	I
    //   116: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: aload_1
    //   123: getfield 524	com/tencent/mm/pointers/PInt:value	I
    //   126: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aastore
    //   130: dup
    //   131: iconst_2
    //   132: aload_0
    //   133: aastore
    //   134: invokestatic 417	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: ldc_w 661
    //   140: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: iconst_1
    //   144: ireturn
    //   145: astore_3
    //   146: new 686	com/tencent/mm/compatible/i/d
    //   149: dup
    //   150: invokespecial 687	com/tencent/mm/compatible/i/d:<init>	()V
    //   153: astore 4
    //   155: aload 4
    //   157: astore_3
    //   158: aload 4
    //   160: aload_0
    //   161: invokevirtual 692	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   164: aload 4
    //   166: astore_3
    //   167: aload_1
    //   168: aload 4
    //   170: bipush 9
    //   172: invokevirtual 696	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   175: iconst_0
    //   176: invokestatic 699	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   179: i2l
    //   180: invokestatic 680	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   183: putfield 524	com/tencent/mm/pointers/PInt:value	I
    //   186: aload 4
    //   188: astore_3
    //   189: aload_2
    //   190: aload 4
    //   192: bipush 20
    //   194: invokevirtual 696	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   197: iconst_0
    //   198: invokestatic 699	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   201: sipush 1000
    //   204: idiv
    //   205: putfield 524	com/tencent/mm/pointers/PInt:value	I
    //   208: aload 4
    //   210: invokevirtual 702	android/media/MediaMetadataRetriever:release	()V
    //   213: ldc 52
    //   215: ldc_w 704
    //   218: iconst_3
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_2
    //   225: getfield 524	com/tencent/mm/pointers/PInt:value	I
    //   228: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: aload_1
    //   235: getfield 524	com/tencent/mm/pointers/PInt:value	I
    //   238: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   241: aastore
    //   242: dup
    //   243: iconst_2
    //   244: aload_0
    //   245: aastore
    //   246: invokestatic 417	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: ldc_w 661
    //   252: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: iconst_1
    //   256: ireturn
    //   257: astore 5
    //   259: aconst_null
    //   260: astore 4
    //   262: aload 4
    //   264: astore_3
    //   265: ldc 52
    //   267: aload 5
    //   269: ldc_w 706
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload_0
    //   279: aastore
    //   280: invokestatic 710	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: aload 4
    //   285: ifnull -72 -> 213
    //   288: aload 4
    //   290: invokevirtual 702	android/media/MediaMetadataRetriever:release	()V
    //   293: goto -80 -> 213
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_3
    //   299: aload_3
    //   300: ifnull +7 -> 307
    //   303: aload_3
    //   304: invokevirtual 702	android/media/MediaMetadataRetriever:release	()V
    //   307: ldc_w 661
    //   310: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   313: aload_0
    //   314: athrow
    //   315: astore_0
    //   316: goto -17 -> 299
    //   319: astore 5
    //   321: goto -59 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramString	String
    //   0	324	1	paramPInt1	PInt
    //   0	324	2	paramPInt2	PInt
    //   33	55	3	localObject1	Object
    //   145	1	3	localJSONException	org.json.JSONException
    //   157	147	3	localObject2	Object
    //   153	136	4	locald	com.tencent.mm.compatible.i.d
    //   257	11	5	localException1	Exception
    //   319	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   29	34	145	org/json/JSONException
    //   46	137	145	org/json/JSONException
    //   146	155	257	java/lang/Exception
    //   146	155	296	finally
    //   158	164	315	finally
    //   167	186	315	finally
    //   189	208	315	finally
    //   265	283	315	finally
    //   158	164	319	java/lang/Exception
    //   167	186	319	java/lang/Exception
    //   189	208	319	java/lang/Exception
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, int paramInt3, fjp paramfjp, String paramString6, int paramInt4, String paramString7, String paramString8)
  {
    AppMethodBeat.i(241224);
    boolean bool = a(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramString5, paramInt3, paramfjp, paramString6, paramInt4, paramString7, paramString8, false);
    AppMethodBeat.o(241224);
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, int paramInt3, fjp paramfjp, String paramString6, int paramInt4, String paramString7, String paramString8, boolean paramBoolean)
  {
    AppMethodBeat.i(241230);
    z localz = new z();
    localz.fileName = paramString1;
    localz.omT = paramInt1;
    localz.hVQ = paramString3;
    localz.paV = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
    localz.createTime = Util.nowSecond();
    localz.pba = Util.nowSecond();
    localz.pbh = paramString5;
    localz.oYj = paramString4;
    localz.pbk = paramfjp;
    localz.iah = paramString6;
    localz.xd(paramInt4);
    localz.PN(paramString7);
    localz.PO(Util.nullAs(paramString8, ""));
    if (!Util.isNullOrNil(paramString2)) {
      localz.PP(paramString2);
    }
    if (!Util.isNullOrNil(paramString4)) {
      localz.pbf = 1;
    }
    if (paramInt2 > 0) {
      localz.pbf = 1;
    }
    if (62 == paramInt3) {
      localz.pbi = 3;
    }
    for (;;)
    {
      v.bOh();
      paramInt1 = aa.PZ(aa.PX(paramString1));
      if (paramInt1 > 0) {
        break;
      }
      Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(241230);
      return false;
      if (paramInt2 > 0) {
        localz.pbi = 2;
      } else {
        localz.pbi = 1;
      }
    }
    localz.osy = paramInt1;
    v.bOh();
    paramString2 = aa.PY(paramString1);
    paramInt1 = aa.PZ(paramString2);
    if (paramInt1 <= 0)
    {
      Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + paramString2 + " size:" + paramInt1);
      AppMethodBeat.o(241230);
      return false;
    }
    localz.paZ = paramInt1;
    Log.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + localz.paZ + " videosize:" + localz.osy + " msgType:" + paramInt3 + " forwardMsgId: " + paramInt4);
    localz.status = 102;
    if (!paramBoolean)
    {
      paramString2 = new cc();
      paramString2.BS(localz.bOs());
      paramString2.setType(paramInt3);
      paramString2.pI(1);
      paramString2.BT(paramString1);
      paramString2.setStatus(1);
      paramString2.setCreateTime(br.JN(localz.bOs()));
      localz.pbc = ((int)br.B(paramString2));
    }
    paramBoolean = v.bOh().b(localz);
    AppMethodBeat.o(241230);
    return paramBoolean;
  }
  
  public static boolean b(z paramz, int paramInt)
  {
    AppMethodBeat.i(127026);
    if (paramz != null)
    {
      paramz.lxk = paramInt;
      paramz.eQp = 268435456;
      boolean bool = f(paramz);
      AppMethodBeat.o(127026);
      return bool;
    }
    AppMethodBeat.o(127026);
    return false;
  }
  
  public static boolean b(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(169104);
    z localz = new z();
    localz.fileName = paramString1;
    localz.omT = paramInt1;
    localz.hVQ = paramString2;
    localz.paV = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
    localz.createTime = Util.nowSecond();
    localz.pba = Util.nowSecond();
    localz.pbh = paramString3;
    localz.xd(paramInt2);
    localz.pbi = 1;
    v.bOh();
    localz.osy = aa.PZ(aa.PX(paramString1));
    v.bOh();
    localz.paZ = aa.PZ(aa.PY(paramString1));
    Log.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + localz.paZ + " videosize:" + localz.osy + " msgType:43 forwardMsgId: " + paramInt2);
    localz.status = 102;
    paramString2 = new cc();
    paramString2.BS(localz.bOs());
    paramString2.setType(43);
    paramString2.pI(1);
    paramString2.BT(paramString1);
    paramString2.setStatus(1);
    paramString2.setCreateTime(br.JN(localz.bOs()));
    localz.pbc = ((int)br.B(paramString2));
    boolean bool = v.bOh().b(localz);
    AppMethodBeat.o(169104);
    return bool;
  }
  
  public static boolean bOG()
  {
    AppMethodBeat.i(241203);
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yQC, b.a.agrc, 0) == 1)
    {
      AppMethodBeat.o(241203);
      return true;
    }
    AppMethodBeat.o(241203);
    return false;
  }
  
  public static boolean be(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(127005);
    z localz = Qo(paramString);
    if (localz == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.aPX() + " getinfo failed: " + paramString);
      AppMethodBeat.o(127005);
      return false;
    }
    if (paramInt != localz.osy)
    {
      Log.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localz.osy) });
      localz.osy = paramInt;
      i = 32;
    }
    localz.paX = paramInt;
    localz.pba = Util.nowSecond();
    e(localz);
    localz.status = 199;
    localz.eQp = (i | 0x510);
    boolean bool = f(localz);
    Log.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localz.osy + " status:" + localz.status + " netTimes:" + localz.pbd + " update ret: " + bool);
    AppMethodBeat.o(127005);
    return bool;
  }
  
  public static void bf(String paramString, int paramInt)
  {
    AppMethodBeat.i(127020);
    paramString = Qo(paramString);
    if (paramString != null)
    {
      cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramString.pbc);
      if ((localcc != null) && (localcc.dSI()))
      {
        Log.i("MicroMsg.VideoLogic", "jump mp video");
        AppMethodBeat.o(127020);
        return;
      }
      paramString.status = 122;
      paramString.pbb = Util.nowSecond();
      paramString.pba = Util.nowSecond();
      paramString.lxk = paramInt;
      paramString.eQp = 268438784;
      boolean bool = v.bOh().c(paramString);
      Log.i("MicroMsg.VideoLogic", "set online video Completion ret: " + bool + " status: " + paramString.status);
    }
    AppMethodBeat.o(127020);
  }
  
  public static void bg(String paramString, int paramInt)
  {
    AppMethodBeat.i(241395);
    paramString = Qo(paramString);
    if (paramString != null)
    {
      int i = paramString.omT;
      if ((i <= 0) || (Math.abs(i - paramInt) > 2))
      {
        paramString.omT = paramInt;
        paramString.eQp = 4096;
        Log.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[] { Boolean.valueOf(f(paramString)), Integer.valueOf(i), Integer.valueOf(paramInt) });
      }
    }
    AppMethodBeat.o(241395);
  }
  
  public static boolean bh(String paramString, int paramInt)
  {
    AppMethodBeat.i(127025);
    boolean bool = b(Qo(paramString), paramInt);
    AppMethodBeat.o(127025);
    return bool;
  }
  
  public static void d(z paramz)
  {
    AppMethodBeat.i(127001);
    if (paramz == null)
    {
      Log.e("MicroMsg.VideoLogic", "video info is null");
      AppMethodBeat.o(127001);
      return;
    }
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramz.pbc);
    int i = localcc.getType();
    Log.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127001);
      return;
    }
    localcc.pI(1);
    localcc.BS(paramz.bOs());
    localcc.gX(paramz.hTh);
    localcc.setStatus(2);
    localcc.setContent(x.a(paramz.bOq(), paramz.omT, false));
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramz.pbc, localcc);
    Log.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localcc.field_msgId) });
    AppMethodBeat.o(127001);
  }
  
  static boolean e(z paramz)
  {
    AppMethodBeat.i(127002);
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramz.pbc);
    int i = localcc.getType();
    Log.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127002);
      return false;
    }
    localcc.gX(paramz.hTh);
    localcc.setContent(x.a(paramz.bOq(), paramz.omT, false));
    localcc.BS(paramz.bOs());
    Log.d("MicroMsg.VideoLogic", "set msg content :" + localcc.field_content);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().b(paramz.hTh, localcc);
    Log.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localcc.field_msgId) });
    if (localcc.dSJ()) {
      Log.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[] { Integer.valueOf(paramz.osy) });
    }
    AppMethodBeat.o(127002);
    return true;
  }
  
  public static boolean f(z paramz)
  {
    AppMethodBeat.i(127010);
    if (paramz == null)
    {
      AppMethodBeat.o(127010);
      return false;
    }
    if (((paramz.getFileName() == null) || (paramz.getFileName().length() <= 0)) && (paramz.eQp == -1))
    {
      AppMethodBeat.o(127010);
      return false;
    }
    boolean bool = v.bOh().c(paramz);
    AppMethodBeat.o(127010);
    return bool;
  }
  
  public static int g(z paramz)
  {
    AppMethodBeat.i(127012);
    if (paramz.osy == 0)
    {
      AppMethodBeat.o(127012);
      return 0;
    }
    Log.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + paramz.paX + " " + paramz.osy);
    int i = (int)(paramz.paX * 100L / paramz.osy);
    AppMethodBeat.o(127012);
    return i;
  }
  
  public static int h(z paramz)
  {
    AppMethodBeat.i(241297);
    if (paramz.osy == 0)
    {
      AppMethodBeat.o(241297);
      return 0;
    }
    long l2;
    long l1;
    if (!Util.isNullOrNil(paramz.oYk))
    {
      z localz = Qo(paramz.oYk);
      if (localz != null)
      {
        l2 = localz.paX;
        l1 = localz.osy;
      }
    }
    for (;;)
    {
      if (l1 == 0L)
      {
        AppMethodBeat.o(241297);
        return 0;
      }
      Log.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + paramz.paX + " " + paramz.osy);
      int i = (int)(100L * l2 / l1);
      AppMethodBeat.o(241297);
      return i;
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public static int i(long paramLong, String paramString)
  {
    AppMethodBeat.i(127019);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127019);
      return -1;
    }
    try
    {
      paramString = paramString.split("_");
      int i;
      if (paramString != null)
      {
        i = paramString.length;
        if (i == 2) {}
      }
      else
      {
        AppMethodBeat.o(127019);
        return -1;
      }
      if (Util.getLong(paramString[0], 0L) == paramLong)
      {
        i = Util.getInt(paramString[1], 0);
        AppMethodBeat.o(127019);
        return i;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + paramString.toString());
      AppMethodBeat.o(127019);
    }
    return -1;
  }
  
  public static int i(z paramz)
  {
    AppMethodBeat.i(127013);
    if (paramz.osy == 0)
    {
      AppMethodBeat.o(127013);
      return 0;
    }
    Log.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + paramz.oZm + " " + paramz.osy);
    int i = (int)(paramz.oZm * 100L / paramz.osy);
    AppMethodBeat.o(127013);
    return i;
  }
  
  public static int j(z paramz)
  {
    AppMethodBeat.i(241308);
    if (paramz.osy == 0)
    {
      AppMethodBeat.o(241308);
      return 0;
    }
    long l2;
    long l1;
    if ((bOG()) && (!Util.isNullOrNil(paramz.oYk)))
    {
      z localz = Qo(paramz.oYk);
      if (localz != null)
      {
        l2 = localz.oZm;
        l1 = localz.osy;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + paramz.oZm + " " + paramz.osy + " origin offset = " + l2 + " origin total len = " + l1);
      int i = (int)((paramz.oZm * 100L + l2 * 100L) / (l1 + paramz.osy));
      AppMethodBeat.o(241308);
      return i;
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public static int je(long paramLong)
  {
    AppMethodBeat.i(126999);
    Object localObject = v.bOh().jd(paramLong).iterator();
    while (((Iterator)localObject).hasNext())
    {
      z localz = (z)((Iterator)localObject).next();
      int i = localz.status;
      localz.status = 200;
      Log.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.f.aPX() + "startSend file:" + localz.getFileName() + " status:[" + i + "->" + localz.status + "]");
      localz.pbb = Util.nowSecond();
      localz.pba = Util.nowSecond();
      localz.eQp = 3328;
      if (!f(localz))
      {
        Log.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.f.aPX() + " update failed: " + localz.getFileName());
        i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(126999);
        return 0 - i;
      }
    }
    localObject = v.bOn();
    com.tencent.mm.kernel.h.baH().postToWorker(new t.3((t)localObject));
    AppMethodBeat.o(126999);
    return 0;
  }
  
  public static void k(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(127016);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", new Object[] { paramString });
      AppMethodBeat.o(127016);
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    i /= 1000;
    long l1 = Util.currentTicks();
    af localaf;
    ContentValues localContentValues;
    long l2;
    boolean bool;
    if (!v.bOk().Qw(paramString))
    {
      localaf = v.bOk();
      int j = (int)(Util.nowMilliSecond() / 1000L);
      if (paramBoolean)
      {
        paramInt = 1;
        if (Util.isNullOrNil(paramString)) {
          break label256;
        }
        localContentValues = new ContentValues();
        localContentValues.put("filename", paramString);
        localContentValues.put("starttime", Integer.valueOf(j));
        localContentValues.put("playduration", Integer.valueOf(i));
        localContentValues.put("downloadway", Integer.valueOf(paramInt));
        l2 = localaf.db.insert("VideoPlayHistory", "filename", localContentValues);
        Log.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : ".concat(String.valueOf(l2)));
        if (l2 <= 0L) {
          break label256;
        }
        bool = true;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean), Long.valueOf(Util.ticksToNow(l1)) });
      AppMethodBeat.o(127016);
      return;
      paramInt = 0;
      break;
      label256:
      bool = false;
      continue;
      localaf = v.bOk();
      paramInt = (int)(Util.nowMilliSecond() / 1000L);
      if (!Util.isNullOrNil(paramString))
      {
        localContentValues = new ContentValues();
        localContentValues.put("starttime", Integer.valueOf(paramInt));
        localContentValues.put("playduration", Integer.valueOf(i));
        l2 = localaf.db.update("VideoPlayHistory", localContentValues, "filename=?", new String[] { paramString });
        Log.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : ".concat(String.valueOf(l2)));
        if (l2 > 0L)
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
  }
  
  public static String o(long paramLong, int paramInt)
  {
    AppMethodBeat.i(127018);
    String str = paramLong + "_" + paramInt;
    AppMethodBeat.o(127018);
    return str;
  }
  
  public static void y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126997);
    z localz = Qo(paramString);
    if (localz == null)
    {
      Log.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(126997);
      return;
    }
    v.bOh();
    int i = aa.PZ(aa.PX(paramString));
    Log.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d, fileName: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), paramString });
    localz.osy = i;
    localz.omT = paramInt1;
    Object localObject = localz.pbl;
    ((dmb)localObject).aaSf = false;
    localz.pbl = ((dmb)localObject);
    localz.status = 102;
    v.bOh();
    localz.paZ = aa.PZ(aa.PY(paramString));
    Log.i("MicroMsg.VideoLogic", "update prepare:" + paramString + " thumbsize:" + localz.paZ);
    localz.eQp = 4512;
    Log.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[] { Boolean.valueOf(f(localz)), Integer.valueOf(paramInt2) });
    localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localz.pbc);
    Log.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((fi)localObject).field_msgId), Long.valueOf(((fi)localObject).field_msgSvrId), ((fi)localObject).field_talker, Integer.valueOf(((cc)localObject).getType()), Integer.valueOf(((fi)localObject).field_isSend), ((fi)localObject).field_imgPath, Integer.valueOf(((fi)localObject).field_status), Long.valueOf(((cc)localObject).getCreateTime()) });
    ((cc)localObject).BS(localz.bOs());
    ((cc)localObject).setType(paramInt2);
    ((cc)localObject).pI(1);
    ((cc)localObject).BT(paramString);
    ((cc)localObject).setStatus(1);
    Log.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((fi)localObject).field_msgId), Long.valueOf(((fi)localObject).field_msgSvrId), ((fi)localObject).field_talker, Integer.valueOf(((cc)localObject).getType()), Integer.valueOf(((fi)localObject).field_isSend), ((fi)localObject).field_imgPath, Integer.valueOf(((fi)localObject).field_status), Long.valueOf(((cc)localObject).getCreateTime()) });
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(localz.pbc, (cc)localObject);
    AppMethodBeat.o(126997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.ab
 * JD-Core Version:    0.7.0.1
 */