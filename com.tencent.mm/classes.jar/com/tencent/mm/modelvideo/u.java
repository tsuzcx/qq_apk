package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;

public final class u
{
  public static int AL(long paramLong)
  {
    AppMethodBeat.i(126999);
    Object localObject = o.bhj().AK(paramLong).iterator();
    while (((Iterator)localObject).hasNext())
    {
      s locals = (s)((Iterator)localObject).next();
      int i = locals.status;
      locals.status = 200;
      Log.d("MicroMsg.VideoLogic", f.apq() + "startSend file:" + locals.getFileName() + " status:[" + i + "->" + locals.status + "]");
      locals.jsn = Util.nowSecond();
      locals.jsm = Util.nowSecond();
      locals.cSx = 3328;
      if (!f(locals))
      {
        Log.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + f.apq() + " update failed: " + locals.getFileName());
        i = f.getLine();
        AppMethodBeat.o(126999);
        return 0 - i;
      }
    }
    localObject = o.bhp();
    g.aAk().postToWorker(new m.3((m)localObject));
    AppMethodBeat.o(126999);
    return 0;
  }
  
  public static int Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(127015);
    long l = Util.currentTicks();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if ((o.bhm().b(paramString, localPInt1, localPInt2)) && (Util.secondsToNow(localPInt1.value) < 300L)) {}
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
  
  public static boolean QD(String paramString)
  {
    AppMethodBeat.i(126988);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString = QN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    if (paramString.jsp >= 2500)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString.jsp += 1;
    paramString.cSx = 16384;
    boolean bool = f(paramString);
    AppMethodBeat.o(126988);
    return bool;
  }
  
  public static boolean QE(String paramString)
  {
    AppMethodBeat.i(126989);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 218L, 1L, false);
    Log.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[] { paramString, Util.getStack() });
    o.bho().QV(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126989);
      return false;
    }
    s locals = QN(paramString);
    if (locals == null)
    {
      Log.e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(126989);
      return false;
    }
    locals.status = 198;
    locals.jsm = (System.currentTimeMillis() / 1000L);
    locals.cSx = 1280;
    cly localcly = locals.jsx;
    localcly.vUh = 0;
    locals.jsx = localcly;
    boolean bool = f(locals);
    Log.d("MicroMsg.VideoLogic", "setError file:" + paramString + " msgid:" + locals.jso + " old stat:" + locals.status);
    if ((locals == null) || (locals.jso == 0))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    paramString = ((l)g.af(l.class)).eiy().Hb(locals.jso);
    int i = paramString.getType();
    Log.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(111L, 32L, 1L, true);
    paramString.Cy(locals.getUser());
    paramString.setContent(q.b(locals.bhs(), -1L, true));
    Log.d("MicroMsg.VideoLogic", "[oneliang][setError]");
    ((l)g.af(l.class)).eiy().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(126989);
    return bool;
  }
  
  public static boolean QF(String paramString)
  {
    AppMethodBeat.i(126990);
    paramString = QN(paramString);
    if ((paramString == null) || (paramString.jso == 0))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    ca localca = ((l)g.af(l.class)).eiy().Hb(paramString.jso);
    int i = localca.getType();
    Log.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    localca.setContent(q.b(paramString.bhs(), paramString.iFw, false));
    localca.setStatus(2);
    ((l)g.af(l.class)).eiy().a(paramString.jso, localca);
    paramString.status = 197;
    paramString.jsm = Util.nowSecond();
    paramString.cSx = 1280;
    Log.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
    boolean bool = f(paramString);
    AppMethodBeat.o(126990);
    return bool;
  }
  
  public static int QG(String paramString)
  {
    AppMethodBeat.i(126998);
    s locals = QN(paramString);
    if (locals == null)
    {
      Log.e("MicroMsg.VideoLogic", "SENDERR:" + f.apq() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    if ((locals.status != 102) && (locals.status != 105))
    {
      Log.e("MicroMsg.VideoLogic", "SENDERR:" + f.apq() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    int i = locals.status;
    if ((locals.status != 102) && (locals.jsl == locals.jsk)) {}
    for (locals.status = 104;; locals.status = 103)
    {
      Log.i("MicroMsg.VideoLogic", f.apq() + "startSend file:" + paramString + " status:[" + i + "->" + locals.status + "]");
      locals.jsn = Util.nowSecond();
      locals.jsm = Util.nowSecond();
      locals.cSx = 3328;
      if (f(locals)) {
        break;
      }
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    o.bho().run();
    AppMethodBeat.o(126998);
    return 0;
  }
  
  public static int QH(String paramString)
  {
    AppMethodBeat.i(127000);
    s locals = QN(paramString);
    int i;
    if (locals == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    if ((locals.status != 104) && (locals.status != 103))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    locals.status = 105;
    locals.jsm = Util.nowSecond();
    locals.cSx = 1280;
    if (!f(locals))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    AppMethodBeat.o(127000);
    return 0;
  }
  
  public static int QI(String paramString)
  {
    AppMethodBeat.i(127003);
    s locals = QN(paramString);
    int i;
    if (locals == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    locals.status = 112;
    locals.jsn = Util.nowSecond();
    locals.jsm = Util.nowSecond();
    locals.cSx = 3328;
    if (!f(locals))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    o.bho().bhG();
    o.bho().run();
    AppMethodBeat.o(127003);
    return 0;
  }
  
  public static int QJ(String paramString)
  {
    AppMethodBeat.i(127004);
    s locals = QN(paramString);
    int i;
    if (locals == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    if ((locals.status != 112) && (locals.status != 120) && (locals.status != 122) && (locals.status != 123))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    locals.status = 113;
    locals.jsm = Util.nowSecond();
    locals.cSx = 1280;
    if (!f(locals))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    AppMethodBeat.o(127004);
    return 0;
  }
  
  public static boolean QK(String paramString)
  {
    AppMethodBeat.i(127006);
    Log.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(paramString)));
    s locals = new s();
    locals.status = 112;
    locals.jsm = Util.nowSecond();
    locals.jsn = Util.nowSecond();
    locals.fileName = paramString;
    locals.cSx = 3328;
    if (!f(locals))
    {
      AppMethodBeat.o(127006);
      return false;
    }
    o.bho().run();
    AppMethodBeat.o(127006);
    return true;
  }
  
  public static boolean QL(String paramString)
  {
    AppMethodBeat.i(127007);
    s locals = QN(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(127007);
      return false;
    }
    Log.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[] { paramString });
    paramString = locals.jsx;
    if (paramString != null)
    {
      paramString.vUh = 0;
      locals.jsx = paramString;
    }
    if (locals.jsk < locals.jsl) {}
    for (locals.status = 103;; locals.status = 104)
    {
      locals.createTime = Util.nowSecond();
      locals.jsm = Util.nowSecond();
      locals.jsn = Util.nowSecond();
      locals.cSx = 536874752;
      if (f(locals)) {
        break;
      }
      AppMethodBeat.o(127007);
      return false;
    }
    o.bho().run();
    AppMethodBeat.o(127007);
    return true;
  }
  
  public static void QM(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(127008);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127008);
      return;
    }
    t localt = o.bhj();
    if (localt.iFy.delete(t.d.QC(paramString), "filename= ?", new String[] { String.valueOf(paramString) }) > 0)
    {
      t.a.a locala = new t.a.a(paramString, t.a.b.jsK, t.a.c.jsN, 1, -1L);
      localt.iKx.event(locala);
      localt.iKx.doNotify();
    }
    while (i == 0)
    {
      AppMethodBeat.o(127008);
      return;
      i = 0;
    }
    try
    {
      o.bhj();
      new com.tencent.mm.vfs.o(t.Qx(paramString)).delete();
      o.bhj();
      new com.tencent.mm.vfs.o(t.Qw(paramString)).delete();
      AppMethodBeat.o(127008);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + f.apq() + " file:" + paramString + " msg:" + localException.getMessage());
      AppMethodBeat.o(127008);
    }
  }
  
  public static s QN(String paramString)
  {
    AppMethodBeat.i(127009);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127009);
      return null;
    }
    paramString = o.bhj().Qq(paramString);
    AppMethodBeat.o(127009);
    return paramString;
  }
  
  public static boolean QO(String paramString)
  {
    AppMethodBeat.i(127014);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
      AppMethodBeat.o(127014);
      return false;
    }
    Log.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(paramString)));
    Object localObject = QN(paramString);
    if ((localObject != null) && (((s)localObject).status == 199))
    {
      int i = ((s)localObject).iKP;
      o.bhj();
      int j = (int)com.tencent.mm.vfs.s.boW(t.Qw(paramString));
      Log.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j > 0) && (Math.abs(j - i) > 16))
      {
        Log.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramString = ((s)localObject).getFileName();
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 217L, 1L, false);
        paramString = QN(paramString);
        if (paramString != null)
        {
          localObject = ((l)g.af(l.class)).eiy().Hb(paramString.jso);
          i = ((ca)localObject).getType();
          Log.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[] { Integer.valueOf(i) });
          if ((43 == i) || (62 == i))
          {
            ((ca)localObject).setContent(q.b(paramString.bhs(), paramString.iFw, false));
            ((ca)localObject).setStatus(2);
            ((l)g.af(l.class)).eiy().a(paramString.jso, (ca)localObject);
            paramString.status = 196;
            paramString.jsm = Util.nowSecond();
            paramString.cSx = 1280;
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
  
  public static void QP(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127017);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127017);
      return;
    }
    if (o.bhm().db.delete("VideoPlayHistory", "filename= ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      Log.d("MicroMsg.VideoLogic", "delete video play history ret : " + bool + " filename : " + paramString);
      AppMethodBeat.o(127017);
      return;
      bool = false;
    }
  }
  
  public static boolean QQ(String paramString)
  {
    AppMethodBeat.i(127021);
    s locals = QN(paramString);
    if (locals != null)
    {
      locals.videoFormat = 2;
      locals.cSx = 2;
      boolean bool = o.bhj().c(locals);
      Log.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(2) });
      AppMethodBeat.o(127021);
      return bool;
    }
    AppMethodBeat.o(127021);
    return false;
  }
  
  public static boolean QR(String paramString)
  {
    AppMethodBeat.i(127022);
    paramString = QN(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.status = 199;
      paramString.jsn = Util.nowSecond();
      paramString.jsm = Util.nowSecond();
      paramString.gqW = 19;
      paramString.cSx = 268438786;
      boolean bool = o.bhj().c(paramString);
      Log.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127022);
      return bool;
    }
    AppMethodBeat.o(127022);
    return false;
  }
  
  public static boolean QS(String paramString)
  {
    AppMethodBeat.i(127023);
    paramString = QN(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.cSx = 2;
      boolean bool = o.bhj().c(paramString);
      Log.i("MicroMsg.VideoLogic", "set hevc video format ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127023);
      return bool;
    }
    AppMethodBeat.o(127023);
    return false;
  }
  
  public static int QT(String paramString)
  {
    AppMethodBeat.i(127024);
    s locals = QN(paramString);
    if (locals == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    boolean bool;
    if (((l)g.af(l.class)).eiy().Hb(locals.jso).cWK())
    {
      bool = true;
      Log.i("MicroMsg.VideoLogic", " is mp video :%b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.modelcontrol.e.baZ();
      if ((!com.tencent.mm.modelcontrol.e.bbk()) || (bool)) {
        break label330;
      }
      locals.status = 122;
    }
    for (int i = 256;; i = 272)
    {
      locals.jsn = Util.nowSecond();
      locals.jsm = Util.nowSecond();
      locals.cSx = (i | 0x800 | 0x400);
      if (f(locals)) {
        break label356;
      }
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
      bool = false;
      break;
      label330:
      Log.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
      locals.status = 112;
      locals.jsj = 0;
    }
    label356:
    o.bho().bhG();
    o.bho().run();
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
    s locals = new s();
    locals.fileName = paramString1;
    locals.iFw = 1;
    locals.dWq = paramString2;
    locals.jsh = ((String)g.aAh().azQ().get(2, ""));
    locals.createTime = Util.nowSecond();
    locals.jsm = Util.nowSecond();
    locals.jst = null;
    locals.jpP = paramString3;
    if (!Util.isNullOrNil(paramString3)) {
      locals.jsr = 1;
    }
    int i;
    if (62 == paramInt)
    {
      locals.jsr = 0;
      i = 3;
    }
    for (;;)
    {
      locals.jsu = i;
      locals.iKP = 0;
      locals.status = 106;
      paramString2 = new ca();
      paramString2.Cy(locals.getUser());
      paramString2.setType(paramInt);
      paramString2.nv(1);
      paramString2.Cz(paramString1);
      paramString2.setStatus(8);
      paramString2.setCreateTime(bp.Kw(locals.getUser()));
      long l = bp.x(paramString2);
      locals.jso = ((int)l);
      if (!o.bhj().b(locals)) {
        break;
      }
      AppMethodBeat.o(126995);
      return l;
      if (locals.jsr == 0) {
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
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, eeq parameeq, String paramString5, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(169103);
    s locals = new s();
    locals.fileName = paramString1;
    locals.iFw = paramInt1;
    locals.dWq = paramString2;
    locals.jsh = ((String)g.aAh().azQ().get(2, ""));
    locals.createTime = Util.nowSecond();
    locals.jsm = Util.nowSecond();
    locals.jst = paramString4;
    locals.jpP = paramString3;
    locals.jsw = parameeq;
    locals.ean = paramString5;
    locals.ue(paramInt4);
    locals.Qo(paramString6);
    if (!Util.isNullOrNil(paramString3)) {
      locals.jsr = 1;
    }
    if (paramInt2 > 0) {
      locals.jsr = 1;
    }
    if (62 == paramInt3) {
      locals.jsu = 3;
    }
    for (;;)
    {
      o.bhj();
      paramInt1 = t.Qy(t.Qw(paramString1));
      if (paramInt1 > 0) {
        break;
      }
      Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(169103);
      return false;
      if (paramInt2 > 0) {
        locals.jsu = 2;
      } else {
        locals.jsu = 1;
      }
    }
    locals.iKP = paramInt1;
    o.bhj();
    paramString2 = t.Qx(paramString1);
    paramInt1 = t.Qy(paramString2);
    if (paramInt1 <= 0)
    {
      Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + paramString2 + " size:" + paramInt1);
      AppMethodBeat.o(169103);
      return false;
    }
    locals.jsl = paramInt1;
    Log.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.jsl + " videosize:" + locals.iKP + " msgType:" + paramInt3 + " forwardMsgId: " + paramInt4);
    locals.status = 102;
    paramString2 = new ca();
    paramString2.Cy(locals.getUser());
    paramString2.setType(paramInt3);
    paramString2.nv(1);
    paramString2.Cz(paramString1);
    paramString2.setStatus(1);
    paramString2.setCreateTime(bp.Kw(locals.getUser()));
    locals.jso = ((int)bp.x(paramString2));
    boolean bool = o.bhj().b(locals);
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
    //   18: invokestatic 484	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public static boolean aA(String paramString, int paramInt)
  {
    AppMethodBeat.i(127025);
    boolean bool = b(QN(paramString), paramInt);
    AppMethodBeat.o(127025);
    return bool;
  }
  
  public static boolean ay(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(127005);
    s locals = QN(paramString);
    if (locals == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " getinfo failed: " + paramString);
      AppMethodBeat.o(127005);
      return false;
    }
    if (paramInt != locals.iKP)
    {
      Log.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locals.iKP) });
      locals.iKP = paramInt;
      i = 32;
    }
    locals.jsj = paramInt;
    locals.jsm = Util.nowSecond();
    e(locals);
    locals.status = 199;
    locals.cSx = (i | 0x510);
    boolean bool = f(locals);
    Log.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + locals.iKP + " status:" + locals.status + " netTimes:" + locals.jsp + " update ret: " + bool);
    AppMethodBeat.o(127005);
    return bool;
  }
  
  public static void az(String paramString, int paramInt)
  {
    AppMethodBeat.i(127020);
    paramString = QN(paramString);
    if (paramString != null)
    {
      if (((l)g.af(l.class)).eiy().Hb(paramString.jso).cWK())
      {
        Log.i("MicroMsg.VideoLogic", "jump mp video");
        AppMethodBeat.o(127020);
        return;
      }
      paramString.status = 122;
      paramString.jsn = Util.nowSecond();
      paramString.jsm = Util.nowSecond();
      paramString.gqW = paramInt;
      paramString.cSx = 268438784;
      boolean bool = o.bhj().c(paramString);
      Log.i("MicroMsg.VideoLogic", "set online video Completion ret: " + bool + " status: " + paramString.status);
    }
    AppMethodBeat.o(127020);
  }
  
  public static boolean b(s params, int paramInt)
  {
    AppMethodBeat.i(127026);
    if (params != null)
    {
      params.gqW = paramInt;
      params.cSx = 268435456;
      boolean bool = f(params);
      AppMethodBeat.o(127026);
      return bool;
    }
    AppMethodBeat.o(127026);
    return false;
  }
  
  public static boolean b(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(169104);
    s locals = new s();
    locals.fileName = paramString1;
    locals.iFw = paramInt1;
    locals.dWq = paramString2;
    locals.jsh = ((String)g.aAh().azQ().get(2, ""));
    locals.createTime = Util.nowSecond();
    locals.jsm = Util.nowSecond();
    locals.jst = paramString3;
    locals.ue(paramInt2);
    locals.jsu = 1;
    o.bhj();
    locals.iKP = t.Qy(t.Qw(paramString1));
    o.bhj();
    locals.jsl = t.Qy(t.Qx(paramString1));
    Log.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.jsl + " videosize:" + locals.iKP + " msgType:43 forwardMsgId: " + paramInt2);
    locals.status = 102;
    paramString2 = new ca();
    paramString2.Cy(locals.getUser());
    paramString2.setType(43);
    paramString2.nv(1);
    paramString2.Cz(paramString1);
    paramString2.setStatus(1);
    paramString2.setCreateTime(bp.Kw(locals.getUser()));
    locals.jso = ((int)bp.x(paramString2));
    boolean bool = o.bhj().b(locals);
    AppMethodBeat.o(169104);
    return bool;
  }
  
  public static boolean c(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(126991);
    boolean bool = a(paramString1, paramInt, paramString2, paramString3, 0, "", 43, 0);
    AppMethodBeat.o(126991);
    return bool;
  }
  
  public static void d(s params)
  {
    AppMethodBeat.i(127001);
    if (params == null)
    {
      Log.e("MicroMsg.VideoLogic", "video info is null");
      AppMethodBeat.o(127001);
      return;
    }
    ca localca = ((l)g.af(l.class)).eiy().Hb(params.jso);
    int i = localca.getType();
    Log.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127001);
      return;
    }
    localca.nv(1);
    localca.Cy(params.getUser());
    localca.yF(params.dTS);
    localca.setStatus(2);
    localca.setContent(q.b(params.bhs(), params.iFw, false));
    ((l)g.af(l.class)).eiy().a(params.jso, localca);
    Log.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localca.field_msgId) });
    AppMethodBeat.o(127001);
  }
  
  static boolean e(s params)
  {
    AppMethodBeat.i(127002);
    ca localca = ((l)g.af(l.class)).eiy().Hb(params.jso);
    int i = localca.getType();
    Log.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127002);
      return false;
    }
    localca.yF(params.dTS);
    localca.setContent(q.b(params.bhs(), params.iFw, false));
    localca.Cy(params.getUser());
    Log.d("MicroMsg.VideoLogic", "set msg content :" + localca.field_content);
    ((l)g.af(l.class)).eiy().b(params.dTS, localca);
    Log.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localca.field_msgId) });
    if (localca.cWL()) {
      Log.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[] { Integer.valueOf(params.iKP) });
    }
    AppMethodBeat.o(127002);
    return true;
  }
  
  public static String f(long paramLong, int paramInt)
  {
    AppMethodBeat.i(127018);
    String str = paramLong + "_" + paramInt;
    AppMethodBeat.o(127018);
    return str;
  }
  
  public static void f(String paramString, int paramInt, boolean paramBoolean)
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
    x localx;
    ContentValues localContentValues;
    long l2;
    boolean bool;
    if (!o.bhm().QU(paramString))
    {
      localx = o.bhm();
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
        l2 = localx.db.insert("VideoPlayHistory", "filename", localContentValues);
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
      localx = o.bhm();
      paramInt = (int)(Util.nowMilliSecond() / 1000L);
      if (!Util.isNullOrNil(paramString))
      {
        localContentValues = new ContentValues();
        localContentValues.put("starttime", Integer.valueOf(paramInt));
        localContentValues.put("playduration", Integer.valueOf(i));
        l2 = localx.db.update("VideoPlayHistory", localContentValues, "filename=?", new String[] { paramString });
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
  
  public static boolean f(s params)
  {
    AppMethodBeat.i(127010);
    if (params == null)
    {
      AppMethodBeat.o(127010);
      return false;
    }
    if (((params.getFileName() == null) || (params.getFileName().length() <= 0)) && (params.cSx == -1))
    {
      AppMethodBeat.o(127010);
      return false;
    }
    boolean bool = o.bhj().c(params);
    AppMethodBeat.o(127010);
    return bool;
  }
  
  public static int g(long paramLong, String paramString)
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
  
  public static int g(s params)
  {
    AppMethodBeat.i(127012);
    if (params.iKP == 0)
    {
      AppMethodBeat.o(127012);
      return 0;
    }
    Log.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + params.jsj + " " + params.iKP);
    int i = params.jsj * 100 / params.iKP;
    AppMethodBeat.o(127012);
    return i;
  }
  
  public static int h(s params)
  {
    AppMethodBeat.i(127013);
    if (params.iKP == 0)
    {
      AppMethodBeat.o(127013);
      return 0;
    }
    Log.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + params.jqP + " " + params.iKP);
    int i = params.jqP * 100 / params.iKP;
    AppMethodBeat.o(127013);
    return i;
  }
  
  public static long r(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(126996);
    long l = a(paramString1, paramString2, paramString3, 43);
    AppMethodBeat.o(126996);
    return l;
  }
  
  public static void u(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126997);
    s locals = QN(paramString);
    if (locals == null)
    {
      Log.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(126997);
      return;
    }
    o.bhj();
    int i = t.Qy(t.Qw(paramString));
    Log.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    locals.iKP = i;
    locals.iFw = paramInt1;
    Object localObject = locals.jsx;
    ((cly)localObject).Mrm = false;
    locals.jsx = ((cly)localObject);
    locals.status = 102;
    o.bhj();
    locals.jsl = t.Qy(t.Qx(paramString));
    Log.i("MicroMsg.VideoLogic", "update prepare:" + paramString + " thumbsize:" + locals.jsl);
    locals.cSx = 4512;
    Log.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[] { Boolean.valueOf(f(locals)), Integer.valueOf(paramInt2) });
    localObject = ((l)g.af(l.class)).eiy().Hb(locals.jso);
    Log.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((eo)localObject).field_msgId), Long.valueOf(((eo)localObject).field_msgSvrId), ((eo)localObject).field_talker, Integer.valueOf(((ca)localObject).getType()), Integer.valueOf(((eo)localObject).field_isSend), ((eo)localObject).field_imgPath, Integer.valueOf(((eo)localObject).field_status), Long.valueOf(((eo)localObject).field_createTime) });
    ((ca)localObject).Cy(locals.getUser());
    ((ca)localObject).setType(paramInt2);
    ((ca)localObject).nv(1);
    ((ca)localObject).Cz(paramString);
    ((ca)localObject).setStatus(1);
    Log.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((eo)localObject).field_msgId), Long.valueOf(((eo)localObject).field_msgSvrId), ((eo)localObject).field_talker, Integer.valueOf(((ca)localObject).getType()), Integer.valueOf(((eo)localObject).field_isSend), ((eo)localObject).field_imgPath, Integer.valueOf(((eo)localObject).field_status), Long.valueOf(((eo)localObject).field_createTime) });
    ((l)g.af(l.class)).eiy().a(locals.jso, (ca)localObject);
    AppMethodBeat.o(126997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.u
 * JD-Core Version:    0.7.0.1
 */