package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;

public final class y
{
  public static int GT(long paramLong)
  {
    AppMethodBeat.i(126999);
    Object localObject = s.bqB().GS(paramLong).iterator();
    while (((Iterator)localObject).hasNext())
    {
      w localw = (w)((Iterator)localObject).next();
      int i = localw.status;
      localw.status = 200;
      Log.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.f.avD() + "startSend file:" + localw.getFileName() + " status:[" + i + "->" + localw.status + "]");
      localw.mhQ = Util.nowSecond();
      localw.mhP = Util.nowSecond();
      localw.cUP = 3328;
      if (!f(localw))
      {
        Log.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.f.avD() + " update failed: " + localw.getFileName());
        i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(126999);
        return 0 - i;
      }
    }
    localObject = s.bqH();
    com.tencent.mm.kernel.h.aHJ().postToWorker(new q.3((q)localObject));
    AppMethodBeat.o(126999);
    return 0;
  }
  
  public static int S(int paramInt, String paramString)
  {
    AppMethodBeat.i(127015);
    long l = Util.currentTicks();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if ((s.bqE().b(paramString, localPInt1, localPInt2)) && (Util.secondsToNow(localPInt1.value) < 300L)) {}
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
  
  public static boolean Ya(String paramString)
  {
    AppMethodBeat.i(126988);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString = Yk(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    if (paramString.mhS >= 2500)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString.mhS += 1;
    paramString.cUP = 16384;
    boolean bool = f(paramString);
    AppMethodBeat.o(126988);
    return bool;
  }
  
  public static boolean Yb(String paramString)
  {
    AppMethodBeat.i(126989);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 218L, 1L, false);
    Log.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[] { paramString, Util.getStack() });
    s.bqG().Ys(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126989);
      return false;
    }
    w localw = Yk(paramString);
    if (localw == null)
    {
      Log.e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(126989);
      return false;
    }
    localw.status = 198;
    localw.mhP = (System.currentTimeMillis() / 1000L);
    localw.cUP = 1280;
    cuv localcuv = localw.mia;
    localcuv.ABK = 0;
    localw.mia = localcuv;
    boolean bool = f(localw);
    Log.d("MicroMsg.VideoLogic", "setError file:" + paramString + " msgid:" + localw.mhR + " old stat:" + localw.status);
    if ((localw == null) || (localw.mhR == 0))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(localw.mhR);
    int i = paramString.getType();
    Log.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 32L, 1L, true);
    paramString.Jm(localw.bqM());
    paramString.setContent(u.a(localw.bqK(), -1L, true));
    Log.d("MicroMsg.VideoLogic", "[oneliang][setError]");
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(126989);
    return bool;
  }
  
  public static boolean Yc(String paramString)
  {
    AppMethodBeat.i(126990);
    paramString = Yk(paramString);
    if ((paramString == null) || (paramString.mhR == 0))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramString.mhR);
    int i = localca.getType();
    Log.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    localca.setContent(u.a(paramString.bqK(), paramString.lvw, false));
    localca.setStatus(2);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramString.mhR, localca);
    paramString.status = 197;
    paramString.mhP = Util.nowSecond();
    paramString.cUP = 1280;
    Log.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
    boolean bool = f(paramString);
    AppMethodBeat.o(126990);
    return bool;
  }
  
  public static int Yd(String paramString)
  {
    AppMethodBeat.i(126998);
    w localw = Yk(paramString);
    if (localw == null)
    {
      Log.e("MicroMsg.VideoLogic", "SENDERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    if ((localw.status != 102) && (localw.status != 105))
    {
      Log.e("MicroMsg.VideoLogic", "SENDERR:" + com.tencent.mm.compatible.util.f.avD() + " get status failed: " + paramString + " status:" + localw.status);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    int i = localw.status;
    if ((localw.status != 102) && (localw.mhO == localw.mhN)) {}
    for (localw.status = 104;; localw.status = 103)
    {
      Log.i("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.f.avD() + "startSend file:" + paramString + " status:[" + i + "->" + localw.status + "]");
      localw.mhQ = Util.nowSecond();
      localw.mhP = Util.nowSecond();
      localw.cUP = 3328;
      if (f(localw)) {
        break;
      }
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    s.bqG().run();
    AppMethodBeat.o(126998);
    return 0;
  }
  
  public static int Ye(String paramString)
  {
    AppMethodBeat.i(127000);
    w localw = Yk(paramString);
    int i;
    if (localw == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    if ((localw.status != 104) && (localw.status != 103))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " get status failed: " + paramString + " status:" + localw.status);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    localw.status = 105;
    localw.mhP = Util.nowSecond();
    localw.cUP = 1280;
    if (!f(localw))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    AppMethodBeat.o(127000);
    return 0;
  }
  
  public static int Yf(String paramString)
  {
    AppMethodBeat.i(127003);
    w localw = Yk(paramString);
    int i;
    if (localw == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    if ((localw.status != 111) && (localw.status != 113) && (localw.status != 121) && (localw.status != 122) && (localw.status != 123))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " get status failed: " + paramString + " status:" + localw.status);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    localw.status = 112;
    localw.mhQ = Util.nowSecond();
    localw.mhP = Util.nowSecond();
    localw.cUP = 3328;
    if (!f(localw))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    s.bqG().brd();
    s.bqG().run();
    AppMethodBeat.o(127003);
    return 0;
  }
  
  public static int Yg(String paramString)
  {
    AppMethodBeat.i(127004);
    w localw = Yk(paramString);
    int i;
    if (localw == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    if ((localw.status != 112) && (localw.status != 120) && (localw.status != 122) && (localw.status != 123))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " get status failed: " + paramString + " status:" + localw.status);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    localw.status = 113;
    localw.mhP = Util.nowSecond();
    localw.cUP = 1280;
    if (!f(localw))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    AppMethodBeat.o(127004);
    return 0;
  }
  
  public static boolean Yh(String paramString)
  {
    AppMethodBeat.i(127006);
    Log.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(paramString)));
    w localw = new w();
    localw.status = 112;
    localw.mhP = Util.nowSecond();
    localw.mhQ = Util.nowSecond();
    localw.fileName = paramString;
    localw.cUP = 3328;
    if (!f(localw))
    {
      AppMethodBeat.o(127006);
      return false;
    }
    s.bqG().run();
    AppMethodBeat.o(127006);
    return true;
  }
  
  public static boolean Yi(String paramString)
  {
    AppMethodBeat.i(127007);
    w localw = Yk(paramString);
    if (localw == null)
    {
      AppMethodBeat.o(127007);
      return false;
    }
    Log.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[] { paramString });
    paramString = localw.mia;
    if (paramString != null)
    {
      paramString.ABK = 0;
      localw.mia = paramString;
    }
    if (localw.mhN < localw.mhO) {}
    for (localw.status = 103;; localw.status = 104)
    {
      localw.createTime = Util.nowSecond();
      localw.mhP = Util.nowSecond();
      localw.mhQ = Util.nowSecond();
      localw.cUP = 536874752;
      if (f(localw)) {
        break;
      }
      AppMethodBeat.o(127007);
      return false;
    }
    s.bqG().run();
    AppMethodBeat.o(127007);
    return true;
  }
  
  public static void Yj(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(127008);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127008);
      return;
    }
    x localx = s.bqB();
    if (localx.lvy.delete(x.d.XZ(paramString), "filename= ?", new String[] { String.valueOf(paramString) }) > 0)
    {
      x.a.a locala = new x.a.a(paramString, x.a.b.mio, x.a.c.mir, 1, -1L);
      localx.lAD.event(locala);
      localx.lAD.doNotify();
    }
    while (i == 0)
    {
      AppMethodBeat.o(127008);
      return;
      i = 0;
    }
    try
    {
      s.bqB();
      new com.tencent.mm.vfs.q(x.XU(paramString)).cFq();
      s.bqB();
      new com.tencent.mm.vfs.q(x.XT(paramString)).cFq();
      AppMethodBeat.o(127008);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + com.tencent.mm.compatible.util.f.avD() + " file:" + paramString + " msg:" + localException.getMessage());
      AppMethodBeat.o(127008);
    }
  }
  
  public static w Yk(String paramString)
  {
    AppMethodBeat.i(127009);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127009);
      return null;
    }
    paramString = s.bqB().XN(paramString);
    AppMethodBeat.o(127009);
    return paramString;
  }
  
  public static boolean Yl(String paramString)
  {
    AppMethodBeat.i(127014);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
      AppMethodBeat.o(127014);
      return false;
    }
    Log.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(paramString)));
    Object localObject = Yk(paramString);
    if ((localObject != null) && (((w)localObject).status == 199))
    {
      int i = ((w)localObject).lAW;
      s.bqB();
      int j = (int)com.tencent.mm.vfs.u.bBQ(x.XT(paramString));
      Log.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j > 0) && (Math.abs(j - i) > 16))
      {
        Log.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramString = ((w)localObject).getFileName();
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 217L, 1L, false);
        paramString = Yk(paramString);
        if (paramString != null)
        {
          localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramString.mhR);
          i = ((ca)localObject).getType();
          Log.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[] { Integer.valueOf(i) });
          if ((43 == i) || (62 == i))
          {
            ((ca)localObject).setContent(u.a(paramString.bqK(), paramString.lvw, false));
            ((ca)localObject).setStatus(2);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramString.mhR, (ca)localObject);
            paramString.status = 196;
            paramString.mhP = Util.nowSecond();
            paramString.cUP = 1280;
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
  
  public static void Ym(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127017);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127017);
      return;
    }
    if (s.bqE().db.delete("VideoPlayHistory", "filename= ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      Log.d("MicroMsg.VideoLogic", "delete video play history ret : " + bool + " filename : " + paramString);
      AppMethodBeat.o(127017);
      return;
      bool = false;
    }
  }
  
  public static boolean Yn(String paramString)
  {
    AppMethodBeat.i(127021);
    w localw = Yk(paramString);
    if (localw != null)
    {
      localw.videoFormat = 2;
      localw.cUP = 2;
      boolean bool = s.bqB().c(localw);
      Log.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(2) });
      AppMethodBeat.o(127021);
      return bool;
    }
    AppMethodBeat.o(127021);
    return false;
  }
  
  public static boolean Yo(String paramString)
  {
    AppMethodBeat.i(127022);
    paramString = Yk(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.status = 199;
      paramString.mhQ = Util.nowSecond();
      paramString.mhP = Util.nowSecond();
      paramString.iVf = 19;
      paramString.cUP = 268438786;
      boolean bool = s.bqB().c(paramString);
      Log.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127022);
      return bool;
    }
    AppMethodBeat.o(127022);
    return false;
  }
  
  public static boolean Yp(String paramString)
  {
    AppMethodBeat.i(127023);
    paramString = Yk(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.cUP = 2;
      boolean bool = s.bqB().c(paramString);
      Log.i("MicroMsg.VideoLogic", "set hevc video format ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127023);
      return bool;
    }
    AppMethodBeat.o(127023);
    return false;
  }
  
  public static int Yq(String paramString)
  {
    AppMethodBeat.i(127024);
    w localw = Yk(paramString);
    if (localw == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    if ((localw.status != 111) && (localw.status != 113) && (localw.status != 121) && (localw.status != 122) && (localw.status != 123))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " get status failed: " + paramString + " status:" + localw.status);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    boolean bool;
    if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(localw.mhR).dlS())
    {
      bool = true;
      Log.i("MicroMsg.VideoLogic", " is mp video :%b", new Object[] { Boolean.valueOf(bool) });
      e.bkp();
      if ((!e.bkz()) || (bool)) {
        break label330;
      }
      localw.status = 122;
    }
    for (int i = 256;; i = 272)
    {
      localw.mhQ = Util.nowSecond();
      localw.mhP = Util.nowSecond();
      localw.cUP = (i | 0x800 | 0x400);
      if (f(localw)) {
        break label356;
      }
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
      bool = false;
      break;
      label330:
      Log.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
      localw.status = 112;
      localw.mhM = 0;
    }
    label356:
    s.bqG().brd();
    s.bqG().run();
    AppMethodBeat.o(127024);
    return 0;
  }
  
  public static long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(126995);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126995);
      return -1L;
    }
    if (Util.isNullOrNil(paramString2))
    {
      Log.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126995);
      return -1L;
    }
    w localw = new w();
    localw.fileName = paramString1;
    localw.lvw = 1;
    localw.fPV = paramString2;
    localw.mhK = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, ""));
    localw.createTime = Util.nowSecond();
    localw.mhP = Util.nowSecond();
    localw.mhW = null;
    localw.mfq = paramString3;
    if (!Util.isNullOrNil(paramString3)) {
      localw.mhU = 1;
    }
    int i;
    if (62 == paramInt)
    {
      localw.mhU = 0;
      i = 3;
    }
    for (;;)
    {
      localw.mhX = i;
      localw.lAW = 0;
      localw.status = 106;
      paramString2 = new ca();
      paramString2.Jm(localw.bqM());
      paramString2.setType(paramInt);
      paramString2.pJ(1);
      paramString2.Jn(paramString1);
      paramString2.setStatus(8);
      paramString2.setCreateTime(bq.RP(localw.bqM()));
      long l = bq.z(paramString2);
      localw.mhR = ((int)l);
      if (!s.bqB().b(localw)) {
        break;
      }
      AppMethodBeat.o(126995);
      return l;
      if (localw.mhU == 0) {
        i = 1;
      } else {
        i = -1;
      }
    }
    AppMethodBeat.o(126995);
    return -1L;
  }
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(169102);
    boolean bool = a(paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramInt3, null, "", paramInt4, null);
    AppMethodBeat.o(169102);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, eor parameor, String paramString5, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(169103);
    w localw = new w();
    localw.fileName = paramString1;
    localw.lvw = paramInt1;
    localw.fPV = paramString2;
    localw.mhK = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, ""));
    localw.createTime = Util.nowSecond();
    localw.mhP = Util.nowSecond();
    localw.mhW = paramString4;
    localw.mfq = paramString3;
    localw.mhZ = parameor;
    localw.fUk = paramString5;
    localw.xd(paramInt4);
    localw.XL(paramString6);
    if (!Util.isNullOrNil(paramString3)) {
      localw.mhU = 1;
    }
    if (paramInt2 > 0) {
      localw.mhU = 1;
    }
    if (62 == paramInt3) {
      localw.mhX = 3;
    }
    for (;;)
    {
      s.bqB();
      paramInt1 = x.XV(x.XT(paramString1));
      if (paramInt1 > 0) {
        break;
      }
      Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(169103);
      return false;
      if (paramInt2 > 0) {
        localw.mhX = 2;
      } else {
        localw.mhX = 1;
      }
    }
    localw.lAW = paramInt1;
    s.bqB();
    paramString2 = x.XU(paramString1);
    paramInt1 = x.XV(paramString2);
    if (paramInt1 <= 0)
    {
      Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + paramString2 + " size:" + paramInt1);
      AppMethodBeat.o(169103);
      return false;
    }
    localw.mhO = paramInt1;
    Log.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + localw.mhO + " videosize:" + localw.lAW + " msgType:" + paramInt3 + " forwardMsgId: " + paramInt4);
    localw.status = 102;
    paramString2 = new ca();
    paramString2.Jm(localw.bqM());
    paramString2.setType(paramInt3);
    paramString2.pJ(1);
    paramString2.Jn(paramString1);
    paramString2.setStatus(1);
    paramString2.setCreateTime(bq.RP(localw.bqM()));
    localw.mhR = ((int)bq.z(paramString2));
    boolean bool = s.bqB().b(localw);
    AppMethodBeat.o(169103);
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: ldc_w 687
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 407	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 49
    //   15: ldc_w 689
    //   18: invokestatic 485	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 687
    //   24: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokestatic 694	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4InfoVFS	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_3
    //   34: ldc 49
    //   36: ldc_w 696
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_3
    //   46: aastore
    //   47: invokestatic 194	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: new 698	org/json/JSONObject
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 699	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_1
    //   60: aload_3
    //   61: ldc_w 701
    //   64: invokevirtual 704	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   67: i2l
    //   68: invokestatic 707	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   71: putfield 169	com/tencent/mm/pointers/PInt:value	I
    //   74: aload_2
    //   75: aload_3
    //   76: ldc_w 709
    //   79: invokevirtual 704	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   82: sipush 1000
    //   85: idiv
    //   86: putfield 169	com/tencent/mm/pointers/PInt:value	I
    //   89: ldc 49
    //   91: ldc_w 711
    //   94: iconst_3
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_2
    //   101: getfield 169	com/tencent/mm/pointers/PInt:value	I
    //   104: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_1
    //   111: getfield 169	com/tencent/mm/pointers/PInt:value	I
    //   114: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_0
    //   121: aastore
    //   122: invokestatic 194	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: ldc_w 687
    //   128: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_3
    //   134: new 713	com/tencent/mm/compatible/i/d
    //   137: dup
    //   138: invokespecial 714	com/tencent/mm/compatible/i/d:<init>	()V
    //   141: astore 4
    //   143: aload 4
    //   145: astore_3
    //   146: aload 4
    //   148: aload_0
    //   149: invokevirtual 719	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   152: aload 4
    //   154: astore_3
    //   155: aload_1
    //   156: aload 4
    //   158: bipush 9
    //   160: invokevirtual 723	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   163: iconst_0
    //   164: invokestatic 726	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   167: i2l
    //   168: invokestatic 707	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   171: putfield 169	com/tencent/mm/pointers/PInt:value	I
    //   174: aload 4
    //   176: astore_3
    //   177: aload_2
    //   178: aload 4
    //   180: bipush 20
    //   182: invokevirtual 723	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   185: iconst_0
    //   186: invokestatic 726	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   189: sipush 1000
    //   192: idiv
    //   193: putfield 169	com/tencent/mm/pointers/PInt:value	I
    //   196: aload 4
    //   198: invokevirtual 729	android/media/MediaMetadataRetriever:release	()V
    //   201: ldc 49
    //   203: ldc_w 731
    //   206: iconst_3
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_2
    //   213: getfield 169	com/tencent/mm/pointers/PInt:value	I
    //   216: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_1
    //   223: getfield 169	com/tencent/mm/pointers/PInt:value	I
    //   226: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_2
    //   232: aload_0
    //   233: aastore
    //   234: invokestatic 194	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 687
    //   240: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: iconst_1
    //   244: ireturn
    //   245: astore 5
    //   247: aconst_null
    //   248: astore 4
    //   250: aload 4
    //   252: astore_3
    //   253: ldc 49
    //   255: aload 5
    //   257: ldc_w 733
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_0
    //   267: aastore
    //   268: invokestatic 737	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 4
    //   273: ifnull -72 -> 201
    //   276: aload 4
    //   278: invokevirtual 729	android/media/MediaMetadataRetriever:release	()V
    //   281: goto -80 -> 201
    //   284: astore_0
    //   285: aconst_null
    //   286: astore_3
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 729	android/media/MediaMetadataRetriever:release	()V
    //   295: ldc_w 687
    //   298: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_0
    //   302: athrow
    //   303: astore_0
    //   304: goto -17 -> 287
    //   307: astore 5
    //   309: goto -59 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramString	String
    //   0	312	1	paramPInt1	PInt
    //   0	312	2	paramPInt2	PInt
    //   33	43	3	localObject1	Object
    //   133	1	3	localJSONException	org.json.JSONException
    //   145	147	3	localObject2	Object
    //   141	136	4	locald	com.tencent.mm.compatible.i.d
    //   245	11	5	localException1	Exception
    //   307	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   29	125	133	org/json/JSONException
    //   134	143	245	java/lang/Exception
    //   134	143	284	finally
    //   146	152	303	finally
    //   155	174	303	finally
    //   177	196	303	finally
    //   253	271	303	finally
    //   146	152	307	java/lang/Exception
    //   155	174	307	java/lang/Exception
    //   177	196	307	java/lang/Exception
  }
  
  public static boolean aQ(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(127005);
    w localw = Yk(paramString);
    if (localw == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + paramString);
      AppMethodBeat.o(127005);
      return false;
    }
    if (paramInt != localw.lAW)
    {
      Log.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localw.lAW) });
      localw.lAW = paramInt;
      i = 32;
    }
    localw.mhM = paramInt;
    localw.mhP = Util.nowSecond();
    e(localw);
    localw.status = 199;
    localw.cUP = (i | 0x510);
    boolean bool = f(localw);
    Log.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localw.lAW + " status:" + localw.status + " netTimes:" + localw.mhS + " update ret: " + bool);
    AppMethodBeat.o(127005);
    return bool;
  }
  
  public static void aR(String paramString, int paramInt)
  {
    AppMethodBeat.i(127020);
    paramString = Yk(paramString);
    if (paramString != null)
    {
      if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramString.mhR).dlS())
      {
        Log.i("MicroMsg.VideoLogic", "jump mp video");
        AppMethodBeat.o(127020);
        return;
      }
      paramString.status = 122;
      paramString.mhQ = Util.nowSecond();
      paramString.mhP = Util.nowSecond();
      paramString.iVf = paramInt;
      paramString.cUP = 268438784;
      boolean bool = s.bqB().c(paramString);
      Log.i("MicroMsg.VideoLogic", "set online video Completion ret: " + bool + " status: " + paramString.status);
    }
    AppMethodBeat.o(127020);
  }
  
  public static void aS(String paramString, int paramInt)
  {
    AppMethodBeat.i(215586);
    paramString = Yk(paramString);
    if (paramString != null)
    {
      int i = paramString.lvw;
      if ((i <= 0) || (Math.abs(i - paramInt) > 2))
      {
        paramString.lvw = paramInt;
        paramString.cUP = 4096;
        Log.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[] { Boolean.valueOf(f(paramString)), Integer.valueOf(i), Integer.valueOf(paramInt) });
      }
    }
    AppMethodBeat.o(215586);
  }
  
  public static boolean aT(String paramString, int paramInt)
  {
    AppMethodBeat.i(127025);
    boolean bool = b(Yk(paramString), paramInt);
    AppMethodBeat.o(127025);
    return bool;
  }
  
  public static boolean b(w paramw, int paramInt)
  {
    AppMethodBeat.i(127026);
    if (paramw != null)
    {
      paramw.iVf = paramInt;
      paramw.cUP = 268435456;
      boolean bool = f(paramw);
      AppMethodBeat.o(127026);
      return bool;
    }
    AppMethodBeat.o(127026);
    return false;
  }
  
  public static boolean b(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(169104);
    w localw = new w();
    localw.fileName = paramString1;
    localw.lvw = paramInt1;
    localw.fPV = paramString2;
    localw.mhK = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, ""));
    localw.createTime = Util.nowSecond();
    localw.mhP = Util.nowSecond();
    localw.mhW = paramString3;
    localw.xd(paramInt2);
    localw.mhX = 1;
    s.bqB();
    localw.lAW = x.XV(x.XT(paramString1));
    s.bqB();
    localw.mhO = x.XV(x.XU(paramString1));
    Log.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + localw.mhO + " videosize:" + localw.lAW + " msgType:43 forwardMsgId: " + paramInt2);
    localw.status = 102;
    paramString2 = new ca();
    paramString2.Jm(localw.bqM());
    paramString2.setType(43);
    paramString2.pJ(1);
    paramString2.Jn(paramString1);
    paramString2.setStatus(1);
    paramString2.setCreateTime(bq.RP(localw.bqM()));
    localw.mhR = ((int)bq.z(paramString2));
    boolean bool = s.bqB().b(localw);
    AppMethodBeat.o(169104);
    return bool;
  }
  
  public static boolean brb()
  {
    AppMethodBeat.i(215581);
    e.bkp();
    boolean bool = e.bkz();
    AppMethodBeat.o(215581);
    return bool;
  }
  
  public static boolean c(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(126991);
    boolean bool = a(paramString1, paramInt, paramString2, paramString3, 0, "", 43, 0);
    AppMethodBeat.o(126991);
    return bool;
  }
  
  public static void d(w paramw)
  {
    AppMethodBeat.i(127001);
    if (paramw == null)
    {
      Log.e("MicroMsg.VideoLogic", "video info is null");
      AppMethodBeat.o(127001);
      return;
    }
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramw.mhR);
    int i = localca.getType();
    Log.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127001);
      return;
    }
    localca.pJ(1);
    localca.Jm(paramw.bqM());
    localca.EG(paramw.fNu);
    localca.setStatus(2);
    localca.setContent(u.a(paramw.bqK(), paramw.lvw, false));
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramw.mhR, localca);
    Log.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localca.field_msgId) });
    AppMethodBeat.o(127001);
  }
  
  static boolean e(w paramw)
  {
    AppMethodBeat.i(127002);
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramw.mhR);
    int i = localca.getType();
    Log.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127002);
      return false;
    }
    localca.EG(paramw.fNu);
    localca.setContent(u.a(paramw.bqK(), paramw.lvw, false));
    localca.Jm(paramw.bqM());
    Log.d("MicroMsg.VideoLogic", "set msg content :" + localca.field_content);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().b(paramw.fNu, localca);
    Log.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localca.field_msgId) });
    if (localca.dlT()) {
      Log.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[] { Integer.valueOf(paramw.lAW) });
    }
    AppMethodBeat.o(127002);
    return true;
  }
  
  public static boolean f(w paramw)
  {
    AppMethodBeat.i(127010);
    if (paramw == null)
    {
      AppMethodBeat.o(127010);
      return false;
    }
    if (((paramw.getFileName() == null) || (paramw.getFileName().length() <= 0)) && (paramw.cUP == -1))
    {
      AppMethodBeat.o(127010);
      return false;
    }
    boolean bool = s.bqB().c(paramw);
    AppMethodBeat.o(127010);
    return bool;
  }
  
  public static int g(w paramw)
  {
    AppMethodBeat.i(127012);
    if (paramw.lAW == 0)
    {
      AppMethodBeat.o(127012);
      return 0;
    }
    Log.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + paramw.mhM + " " + paramw.lAW);
    int i = (int)(paramw.mhM * 100L / paramw.lAW);
    AppMethodBeat.o(127012);
    return i;
  }
  
  public static String g(long paramLong, int paramInt)
  {
    AppMethodBeat.i(127018);
    String str = paramLong + "_" + paramInt;
    AppMethodBeat.o(127018);
    return str;
  }
  
  public static int h(long paramLong, String paramString)
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
  
  public static int h(w paramw)
  {
    AppMethodBeat.i(127013);
    if (paramw.lAW == 0)
    {
      AppMethodBeat.o(127013);
      return 0;
    }
    Log.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + paramw.mgq + " " + paramw.lAW);
    int i = (int)(paramw.mgq * 100L / paramw.lAW);
    AppMethodBeat.o(127013);
    return i;
  }
  
  public static void j(String paramString, int paramInt, boolean paramBoolean)
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
    ab localab;
    ContentValues localContentValues;
    long l2;
    boolean bool;
    if (!s.bqE().Yr(paramString))
    {
      localab = s.bqE();
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
        l2 = localab.db.insert("VideoPlayHistory", "filename", localContentValues);
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
      localab = s.bqE();
      paramInt = (int)(Util.nowMilliSecond() / 1000L);
      if (!Util.isNullOrNil(paramString))
      {
        localContentValues = new ContentValues();
        localContentValues.put("starttime", Integer.valueOf(paramInt));
        localContentValues.put("playduration", Integer.valueOf(i));
        l2 = localab.db.update("VideoPlayHistory", localContentValues, "filename=?", new String[] { paramString });
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
  
  public static long u(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(126996);
    long l = a(paramString1, paramString2, paramString3, 43);
    AppMethodBeat.o(126996);
    return l;
  }
  
  public static void v(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126997);
    w localw = Yk(paramString);
    if (localw == null)
    {
      Log.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(126997);
      return;
    }
    s.bqB();
    int i = x.XV(x.XT(paramString));
    Log.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    localw.lAW = i;
    localw.lvw = paramInt1;
    Object localObject = localw.mia;
    ((cuv)localObject).TCz = false;
    localw.mia = ((cuv)localObject);
    localw.status = 102;
    s.bqB();
    localw.mhO = x.XV(x.XU(paramString));
    Log.i("MicroMsg.VideoLogic", "update prepare:" + paramString + " thumbsize:" + localw.mhO);
    localw.cUP = 4512;
    Log.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[] { Boolean.valueOf(f(localw)), Integer.valueOf(paramInt2) });
    localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(localw.mhR);
    Log.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((et)localObject).field_msgId), Long.valueOf(((et)localObject).field_msgSvrId), ((et)localObject).field_talker, Integer.valueOf(((ca)localObject).getType()), Integer.valueOf(((et)localObject).field_isSend), ((et)localObject).field_imgPath, Integer.valueOf(((et)localObject).field_status), Long.valueOf(((et)localObject).field_createTime) });
    ((ca)localObject).Jm(localw.bqM());
    ((ca)localObject).setType(paramInt2);
    ((ca)localObject).pJ(1);
    ((ca)localObject).Jn(paramString);
    ((ca)localObject).setStatus(1);
    Log.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((et)localObject).field_msgId), Long.valueOf(((et)localObject).field_msgSvrId), ((et)localObject).field_talker, Integer.valueOf(((ca)localObject).getType()), Integer.valueOf(((et)localObject).field_isSend), ((et)localObject).field_imgPath, Integer.valueOf(((et)localObject).field_status), Long.valueOf(((et)localObject).field_createTime) });
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(localw.mhR, (ca)localObject);
    AppMethodBeat.o(126997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y
 * JD-Core Version:    0.7.0.1
 */