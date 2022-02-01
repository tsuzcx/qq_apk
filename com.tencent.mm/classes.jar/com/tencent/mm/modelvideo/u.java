package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.k;
import java.util.Iterator;
import java.util.List;

public final class u
{
  public static boolean HQ(String paramString)
  {
    AppMethodBeat.i(126988);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString = Ia(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    if (paramString.ixa >= 2500)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString.ixa += 1;
    paramString.dEu = 16384;
    boolean bool = f(paramString);
    AppMethodBeat.o(126988);
    return bool;
  }
  
  public static boolean HR(String paramString)
  {
    AppMethodBeat.i(126989);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 218L, 1L, false);
    ae.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[] { paramString, bu.fpN() });
    o.aNm().Ij(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126989);
      return false;
    }
    s locals = Ia(paramString);
    if (locals == null)
    {
      ae.e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(126989);
      return false;
    }
    locals.status = 198;
    locals.iwX = (System.currentTimeMillis() / 1000L);
    locals.dEu = 1280;
    byg localbyg = locals.ixi;
    localbyg.sVm = 0;
    locals.ixi = localbyg;
    boolean bool = f(locals);
    ae.d("MicroMsg.VideoLogic", "setError file:" + paramString + " msgid:" + locals.iwZ + " old stat:" + locals.status);
    if ((locals == null) || (locals.iwZ == 0))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(locals.iwZ);
    int i = paramString.getType();
    ae.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 32L, 1L, true);
    paramString.ui(locals.getUser());
    paramString.setContent(q.b(locals.aNq(), -1L, true));
    ae.d("MicroMsg.VideoLogic", "[oneliang][setError]");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(126989);
    return bool;
  }
  
  public static boolean HS(String paramString)
  {
    AppMethodBeat.i(126990);
    paramString = Ia(paramString);
    if ((paramString == null) || (paramString.iwZ == 0))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramString.iwZ);
    int i = localbv.getType();
    ae.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    localbv.setContent(q.b(paramString.aNq(), paramString.hKI, false));
    localbv.setStatus(2);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramString.iwZ, localbv);
    paramString.status = 197;
    paramString.iwX = bu.aRi();
    paramString.dEu = 1280;
    ae.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
    boolean bool = f(paramString);
    AppMethodBeat.o(126990);
    return bool;
  }
  
  public static int HT(String paramString)
  {
    AppMethodBeat.i(126998);
    s locals = Ia(paramString);
    if (locals == null)
    {
      ae.e("MicroMsg.VideoLogic", "SENDERR:" + f.abr() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    if ((locals.status != 102) && (locals.status != 105))
    {
      ae.e("MicroMsg.VideoLogic", "SENDERR:" + f.abr() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    int i = locals.status;
    if ((locals.status != 102) && (locals.iwW == locals.iwV)) {}
    for (locals.status = 104;; locals.status = 103)
    {
      ae.i("MicroMsg.VideoLogic", f.abr() + "startSend file:" + paramString + " status:[" + i + "->" + locals.status + "]");
      locals.iwY = bu.aRi();
      locals.iwX = bu.aRi();
      locals.dEu = 3328;
      if (f(locals)) {
        break;
      }
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    o.aNm().run();
    AppMethodBeat.o(126998);
    return 0;
  }
  
  public static int HU(String paramString)
  {
    AppMethodBeat.i(127000);
    s locals = Ia(paramString);
    int i;
    if (locals == null)
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    if ((locals.status != 104) && (locals.status != 103))
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    locals.status = 105;
    locals.iwX = bu.aRi();
    locals.dEu = 1280;
    if (!f(locals))
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    AppMethodBeat.o(127000);
    return 0;
  }
  
  public static int HV(String paramString)
  {
    AppMethodBeat.i(127003);
    s locals = Ia(paramString);
    int i;
    if (locals == null)
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    locals.status = 112;
    locals.iwY = bu.aRi();
    locals.iwX = bu.aRi();
    locals.dEu = 3328;
    if (!f(locals))
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    o.aNm().aND();
    o.aNm().run();
    AppMethodBeat.o(127003);
    return 0;
  }
  
  public static int HW(String paramString)
  {
    AppMethodBeat.i(127004);
    s locals = Ia(paramString);
    int i;
    if (locals == null)
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    if ((locals.status != 112) && (locals.status != 120) && (locals.status != 122) && (locals.status != 123))
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    locals.status = 113;
    locals.iwX = bu.aRi();
    locals.dEu = 1280;
    if (!f(locals))
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    AppMethodBeat.o(127004);
    return 0;
  }
  
  public static boolean HX(String paramString)
  {
    AppMethodBeat.i(127006);
    ae.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(paramString)));
    s locals = new s();
    locals.status = 112;
    locals.iwX = bu.aRi();
    locals.iwY = bu.aRi();
    locals.fileName = paramString;
    locals.dEu = 3328;
    if (!f(locals))
    {
      AppMethodBeat.o(127006);
      return false;
    }
    o.aNm().run();
    AppMethodBeat.o(127006);
    return true;
  }
  
  public static boolean HY(String paramString)
  {
    AppMethodBeat.i(127007);
    s locals = Ia(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(127007);
      return false;
    }
    ae.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[] { paramString });
    paramString = locals.ixi;
    if (paramString != null)
    {
      paramString.sVm = 0;
      locals.ixi = paramString;
    }
    if (locals.iwV < locals.iwW) {}
    for (locals.status = 103;; locals.status = 104)
    {
      locals.createTime = bu.aRi();
      locals.iwX = bu.aRi();
      locals.iwY = bu.aRi();
      locals.dEu = 536874752;
      if (f(locals)) {
        break;
      }
      AppMethodBeat.o(127007);
      return false;
    }
    o.aNm().run();
    AppMethodBeat.o(127007);
    return true;
  }
  
  public static void HZ(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(127008);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127008);
      return;
    }
    t localt = o.aNh();
    if (localt.hKK.delete(t.d.HP(paramString), "filename= ?", new String[] { String.valueOf(paramString) }) > 0)
    {
      t.a.a locala = new t.a.a(paramString, t.a.b.ixv, t.a.c.ixy, 1, -1L);
      localt.hPq.dW(locala);
      localt.hPq.doNotify();
    }
    while (i == 0)
    {
      AppMethodBeat.o(127008);
      return;
      i = 0;
    }
    try
    {
      o.aNh();
      new k(t.HK(paramString)).delete();
      o.aNh();
      new k(t.HJ(paramString)).delete();
      AppMethodBeat.o(127008);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + f.abr() + " file:" + paramString + " msg:" + localException.getMessage());
      AppMethodBeat.o(127008);
    }
  }
  
  public static s Ia(String paramString)
  {
    AppMethodBeat.i(127009);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127009);
      return null;
    }
    paramString = o.aNh().HD(paramString);
    AppMethodBeat.o(127009);
    return paramString;
  }
  
  public static String Ib(String paramString)
  {
    AppMethodBeat.i(127011);
    String str = b.asv() + bu.fpO() + ".mp4";
    if (com.tencent.mm.vfs.o.mF(paramString, str) < 0L)
    {
      AppMethodBeat.o(127011);
      return null;
    }
    AppMethodBeat.o(127011);
    return str;
  }
  
  public static boolean Ic(String paramString)
  {
    AppMethodBeat.i(127014);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
      AppMethodBeat.o(127014);
      return false;
    }
    ae.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(paramString)));
    Object localObject = Ia(paramString);
    if ((localObject != null) && (((s)localObject).status == 199))
    {
      int i = ((s)localObject).hPI;
      o.aNh();
      int j = (int)com.tencent.mm.vfs.o.aZR(t.HJ(paramString));
      ae.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j > 0) && (Math.abs(j - i) > 16))
      {
        ae.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramString = ((s)localObject).getFileName();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 217L, 1L, false);
        paramString = Ia(paramString);
        if (paramString != null)
        {
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramString.iwZ);
          i = ((bv)localObject).getType();
          ae.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[] { Integer.valueOf(i) });
          if ((43 == i) || (62 == i))
          {
            ((bv)localObject).setContent(q.b(paramString.aNq(), paramString.hKI, false));
            ((bv)localObject).setStatus(2);
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramString.iwZ, (bv)localObject);
            paramString.status = 196;
            paramString.iwX = bu.aRi();
            paramString.dEu = 1280;
            ae.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
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
  
  public static void Id(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127017);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127017);
      return;
    }
    if (o.aNk().db.delete("VideoPlayHistory", "filename= ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      ae.d("MicroMsg.VideoLogic", "delete video play history ret : " + bool + " filename : " + paramString);
      AppMethodBeat.o(127017);
      return;
      bool = false;
    }
  }
  
  public static boolean Ie(String paramString)
  {
    AppMethodBeat.i(127021);
    s locals = Ia(paramString);
    if (locals != null)
    {
      locals.videoFormat = 2;
      locals.dEu = 2;
      boolean bool = o.aNh().c(locals);
      ae.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(2) });
      AppMethodBeat.o(127021);
      return bool;
    }
    AppMethodBeat.o(127021);
    return false;
  }
  
  public static boolean If(String paramString)
  {
    AppMethodBeat.i(127022);
    paramString = Ia(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.status = 199;
      paramString.iwY = bu.aRi();
      paramString.iwX = bu.aRi();
      paramString.fLK = 19;
      paramString.dEu = 268438786;
      boolean bool = o.aNh().c(paramString);
      ae.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127022);
      return bool;
    }
    AppMethodBeat.o(127022);
    return false;
  }
  
  public static boolean Ig(String paramString)
  {
    AppMethodBeat.i(127023);
    paramString = Ia(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.dEu = 2;
      boolean bool = o.aNh().c(paramString);
      ae.i("MicroMsg.VideoLogic", "set hevc video format ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127023);
      return bool;
    }
    AppMethodBeat.o(127023);
    return false;
  }
  
  public static int Ih(String paramString)
  {
    AppMethodBeat.i(127024);
    s locals = Ia(paramString);
    if (locals == null)
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    boolean bool;
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(locals.iwZ).cyH())
    {
      bool = true;
      ae.i("MicroMsg.VideoLogic", " is mp video :%b", new Object[] { Boolean.valueOf(bool) });
      d.aHh();
      if ((!d.aHr()) || (bool)) {
        break label327;
      }
      locals.status = 122;
    }
    for (int i = 256;; i = 272)
    {
      locals.iwY = bu.aRi();
      locals.iwX = bu.aRi();
      locals.dEu = (i | 0x800 | 0x400);
      if (f(locals)) {
        break label353;
      }
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
      bool = false;
      break;
      label327:
      ae.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
      locals.status = 112;
      locals.iwU = 0;
    }
    label353:
    o.aNm().aND();
    o.aNm().run();
    AppMethodBeat.o(127024);
    return 0;
  }
  
  public static int N(int paramInt, String paramString)
  {
    AppMethodBeat.i(127015);
    long l = bu.HQ();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if ((o.aNk().b(paramString, localPInt1, localPInt2)) && (bu.rZ(localPInt1.value) < 300L)) {}
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
      ae.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localPInt1.value), paramString, Long.valueOf(bu.aO(l)) });
      AppMethodBeat.o(127015);
      return j;
    }
  }
  
  public static long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(126995);
    if (bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126995);
      return -1L;
    }
    if (bu.isNullOrNil(paramString2))
    {
      ae.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126995);
      return -1L;
    }
    s locals = new s();
    locals.fileName = paramString1;
    locals.hKI = 1;
    locals.dED = paramString2;
    locals.iwS = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, ""));
    locals.createTime = bu.aRi();
    locals.iwX = bu.aRi();
    locals.ixe = null;
    locals.iuC = paramString3;
    if (!bu.isNullOrNil(paramString3)) {
      locals.ixc = 1;
    }
    int i;
    if (62 == paramInt)
    {
      locals.ixc = 0;
      i = 3;
    }
    for (;;)
    {
      locals.ixf = i;
      locals.hPI = 0;
      locals.status = 106;
      paramString2 = new bv();
      paramString2.ui(locals.getUser());
      paramString2.setType(paramInt);
      paramString2.kt(1);
      paramString2.uj(paramString1);
      paramString2.setStatus(8);
      paramString2.qN(bl.BQ(locals.getUser()));
      long l = bl.v(paramString2);
      locals.iwZ = ((int)l);
      if (!o.aNh().b(locals)) {
        break;
      }
      AppMethodBeat.o(126995);
      return l;
      if (locals.ixc == 0) {
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
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, dld paramdld, String paramString5, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(169103);
    s locals = new s();
    locals.fileName = paramString1;
    locals.hKI = paramInt1;
    locals.dED = paramString2;
    locals.iwS = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, ""));
    locals.createTime = bu.aRi();
    locals.iwX = bu.aRi();
    locals.ixe = paramString4;
    locals.iuC = paramString3;
    locals.ixh = paramdld;
    locals.dIA = paramString5;
    locals.qo(paramInt4);
    locals.HB(paramString6);
    if (!bu.isNullOrNil(paramString3)) {
      locals.ixc = 1;
    }
    if (paramInt2 > 0) {
      locals.ixc = 1;
    }
    if (62 == paramInt3) {
      locals.ixf = 3;
    }
    for (;;)
    {
      o.aNh();
      paramInt1 = t.HL(t.HJ(paramString1));
      if (paramInt1 > 0) {
        break;
      }
      ae.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(169103);
      return false;
      if (paramInt2 > 0) {
        locals.ixf = 2;
      } else {
        locals.ixf = 1;
      }
    }
    locals.hPI = paramInt1;
    o.aNh();
    paramString2 = t.HK(paramString1);
    paramInt1 = t.HL(paramString2);
    if (paramInt1 <= 0)
    {
      ae.e("MicroMsg.VideoLogic", "get Thumb size failed :" + paramString2 + " size:" + paramInt1);
      AppMethodBeat.o(169103);
      return false;
    }
    locals.iwW = paramInt1;
    ae.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.iwW + " videosize:" + locals.hPI + " msgType:" + paramInt3 + " forwardMsgId: " + paramInt4);
    locals.status = 102;
    paramString2 = new bv();
    paramString2.ui(locals.getUser());
    paramString2.setType(paramInt3);
    paramString2.kt(1);
    paramString2.uj(paramString1);
    paramString2.setStatus(1);
    paramString2.qN(bl.BQ(locals.getUser()));
    locals.iwZ = ((int)bl.v(paramString2));
    boolean bool = o.aNh().b(locals);
    AppMethodBeat.o(169103);
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: ldc_w 662
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 316	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 52
    //   15: ldc_w 664
    //   18: invokestatic 420	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 662
    //   24: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokestatic 669	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4InfoVFS	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_3
    //   34: ldc 52
    //   36: ldc_w 671
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_3
    //   46: aastore
    //   47: invokestatic 433	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: new 673	org/json/JSONObject
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 674	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_1
    //   60: aload_3
    //   61: ldc_w 676
    //   64: invokevirtual 679	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   67: i2l
    //   68: invokestatic 683	com/tencent/mm/sdk/platformtools/bu:DE	(J)I
    //   71: putfield 538	com/tencent/mm/pointers/PInt:value	I
    //   74: aload_2
    //   75: aload_3
    //   76: ldc_w 685
    //   79: invokevirtual 679	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   82: sipush 1000
    //   85: idiv
    //   86: putfield 538	com/tencent/mm/pointers/PInt:value	I
    //   89: ldc 52
    //   91: ldc_w 687
    //   94: iconst_3
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_2
    //   101: getfield 538	com/tencent/mm/pointers/PInt:value	I
    //   104: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_1
    //   111: getfield 538	com/tencent/mm/pointers/PInt:value	I
    //   114: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_0
    //   121: aastore
    //   122: invokestatic 433	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: ldc_w 662
    //   128: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_3
    //   134: new 689	com/tencent/mm/compatible/h/d
    //   137: dup
    //   138: invokespecial 690	com/tencent/mm/compatible/h/d:<init>	()V
    //   141: astore 4
    //   143: aload 4
    //   145: astore_3
    //   146: aload 4
    //   148: aload_0
    //   149: invokevirtual 695	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   152: aload 4
    //   154: astore_3
    //   155: aload_1
    //   156: aload 4
    //   158: bipush 9
    //   160: invokevirtual 699	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   163: iconst_0
    //   164: invokestatic 702	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   167: i2l
    //   168: invokestatic 683	com/tencent/mm/sdk/platformtools/bu:DE	(J)I
    //   171: putfield 538	com/tencent/mm/pointers/PInt:value	I
    //   174: aload 4
    //   176: astore_3
    //   177: aload_2
    //   178: aload 4
    //   180: bipush 20
    //   182: invokevirtual 699	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   185: iconst_0
    //   186: invokestatic 702	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   189: sipush 1000
    //   192: idiv
    //   193: putfield 538	com/tencent/mm/pointers/PInt:value	I
    //   196: aload 4
    //   198: invokevirtual 705	android/media/MediaMetadataRetriever:release	()V
    //   201: ldc 52
    //   203: ldc_w 707
    //   206: iconst_3
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_2
    //   213: getfield 538	com/tencent/mm/pointers/PInt:value	I
    //   216: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_1
    //   223: getfield 538	com/tencent/mm/pointers/PInt:value	I
    //   226: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_2
    //   232: aload_0
    //   233: aastore
    //   234: invokestatic 433	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 662
    //   240: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: iconst_1
    //   244: ireturn
    //   245: astore 5
    //   247: aconst_null
    //   248: astore 4
    //   250: aload 4
    //   252: astore_3
    //   253: ldc 52
    //   255: aload 5
    //   257: ldc_w 709
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_0
    //   267: aastore
    //   268: invokestatic 713	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 4
    //   273: ifnull -72 -> 201
    //   276: aload 4
    //   278: invokevirtual 705	android/media/MediaMetadataRetriever:release	()V
    //   281: goto -80 -> 201
    //   284: astore_0
    //   285: aconst_null
    //   286: astore_3
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 705	android/media/MediaMetadataRetriever:release	()V
    //   295: ldc_w 662
    //   298: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   141	136	4	locald	com.tencent.mm.compatible.h.d
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
  
  public static boolean au(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(127005);
    s locals = Ia(paramString);
    if (locals == null)
    {
      ae.e("MicroMsg.VideoLogic", "ERR:" + f.abr() + " getinfo failed: " + paramString);
      AppMethodBeat.o(127005);
      return false;
    }
    if (paramInt != locals.hPI)
    {
      ae.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locals.hPI) });
      locals.hPI = paramInt;
      i = 32;
    }
    locals.iwU = paramInt;
    locals.iwX = bu.aRi();
    e(locals);
    locals.status = 199;
    locals.dEu = (i | 0x510);
    boolean bool = f(locals);
    ae.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + locals.hPI + " status:" + locals.status + " netTimes:" + locals.ixa + " update ret: " + bool);
    AppMethodBeat.o(127005);
    return bool;
  }
  
  public static void av(String paramString, int paramInt)
  {
    AppMethodBeat.i(127020);
    paramString = Ia(paramString);
    if (paramString != null)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramString.iwZ).cyH())
      {
        ae.i("MicroMsg.VideoLogic", "jump mp video");
        AppMethodBeat.o(127020);
        return;
      }
      paramString.status = 122;
      paramString.iwY = bu.aRi();
      paramString.iwX = bu.aRi();
      paramString.fLK = paramInt;
      paramString.dEu = 268438784;
      boolean bool = o.aNh().c(paramString);
      ae.i("MicroMsg.VideoLogic", "set online video Completion ret: " + bool + " status: " + paramString.status);
    }
    AppMethodBeat.o(127020);
  }
  
  public static boolean aw(String paramString, int paramInt)
  {
    AppMethodBeat.i(127025);
    boolean bool = b(Ia(paramString), paramInt);
    AppMethodBeat.o(127025);
    return bool;
  }
  
  public static boolean b(s params, int paramInt)
  {
    AppMethodBeat.i(127026);
    if (params != null)
    {
      params.fLK = paramInt;
      params.dEu = 268435456;
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
    locals.hKI = paramInt1;
    locals.dED = paramString2;
    locals.iwS = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, ""));
    locals.createTime = bu.aRi();
    locals.iwX = bu.aRi();
    locals.ixe = paramString3;
    locals.qo(paramInt2);
    locals.ixf = 1;
    o.aNh();
    locals.hPI = t.HL(t.HJ(paramString1));
    o.aNh();
    locals.iwW = t.HL(t.HK(paramString1));
    ae.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.iwW + " videosize:" + locals.hPI + " msgType:43 forwardMsgId: " + paramInt2);
    locals.status = 102;
    paramString2 = new bv();
    paramString2.ui(locals.getUser());
    paramString2.setType(43);
    paramString2.kt(1);
    paramString2.uj(paramString1);
    paramString2.setStatus(1);
    paramString2.qN(bl.BQ(locals.getUser()));
    locals.iwZ = ((int)bl.v(paramString2));
    boolean bool = o.aNh().b(locals);
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
      ae.e("MicroMsg.VideoLogic", "video info is null");
      AppMethodBeat.o(127001);
      return;
    }
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(params.iwZ);
    int i = localbv.getType();
    ae.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127001);
      return;
    }
    localbv.kt(1);
    localbv.ui(params.getUser());
    localbv.qM(params.dCd);
    localbv.setStatus(2);
    localbv.setContent(q.b(params.aNq(), params.hKI, false));
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(params.iwZ, localbv);
    ae.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbv.field_msgId) });
    AppMethodBeat.o(127001);
  }
  
  public static void e(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(127016);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", new Object[] { paramString });
      AppMethodBeat.o(127016);
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    i /= 1000;
    long l1 = bu.HQ();
    x localx;
    ContentValues localContentValues;
    long l2;
    boolean bool;
    if (!o.aNk().Ii(paramString))
    {
      localx = o.aNk();
      int j = (int)(bu.fpO() / 1000L);
      if (paramBoolean)
      {
        paramInt = 1;
        if (bu.isNullOrNil(paramString)) {
          break label256;
        }
        localContentValues = new ContentValues();
        localContentValues.put("filename", paramString);
        localContentValues.put("starttime", Integer.valueOf(j));
        localContentValues.put("playduration", Integer.valueOf(i));
        localContentValues.put("downloadway", Integer.valueOf(paramInt));
        l2 = localx.db.insert("VideoPlayHistory", "filename", localContentValues);
        ae.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : ".concat(String.valueOf(l2)));
        if (l2 <= 0L) {
          break label256;
        }
        bool = true;
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean), Long.valueOf(bu.aO(l1)) });
      AppMethodBeat.o(127016);
      return;
      paramInt = 0;
      break;
      label256:
      bool = false;
      continue;
      localx = o.aNk();
      paramInt = (int)(bu.fpO() / 1000L);
      if (!bu.isNullOrNil(paramString))
      {
        localContentValues = new ContentValues();
        localContentValues.put("starttime", Integer.valueOf(paramInt));
        localContentValues.put("playduration", Integer.valueOf(i));
        l2 = localx.db.update("VideoPlayHistory", localContentValues, "filename=?", new String[] { paramString });
        ae.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : ".concat(String.valueOf(l2)));
        if (l2 > 0L)
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
  }
  
  static boolean e(s params)
  {
    AppMethodBeat.i(127002);
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(params.iwZ);
    int i = localbv.getType();
    ae.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127002);
      return false;
    }
    localbv.qM(params.dCd);
    localbv.setContent(q.b(params.aNq(), params.hKI, false));
    localbv.ui(params.getUser());
    ae.d("MicroMsg.VideoLogic", "set msg content :" + localbv.field_content);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().b(params.dCd, localbv);
    ae.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbv.field_msgId) });
    if (localbv.cyI()) {
      ae.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[] { Integer.valueOf(params.hPI) });
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
  
  public static boolean f(s params)
  {
    AppMethodBeat.i(127010);
    if (params == null)
    {
      AppMethodBeat.o(127010);
      return false;
    }
    if (((params.getFileName() == null) || (params.getFileName().length() <= 0)) && (params.dEu == -1))
    {
      AppMethodBeat.o(127010);
      return false;
    }
    boolean bool = o.aNh().c(params);
    AppMethodBeat.o(127010);
    return bool;
  }
  
  public static int g(long paramLong, String paramString)
  {
    AppMethodBeat.i(127019);
    if (bu.isNullOrNil(paramString))
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
      if (bu.getLong(paramString[0], 0L) == paramLong)
      {
        i = bu.getInt(paramString[1], 0);
        AppMethodBeat.o(127019);
        return i;
      }
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + paramString.toString());
      AppMethodBeat.o(127019);
    }
    return -1;
  }
  
  public static int g(s params)
  {
    AppMethodBeat.i(127012);
    if (params.hPI == 0)
    {
      AppMethodBeat.o(127012);
      return 0;
    }
    ae.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + params.iwU + " " + params.hPI);
    int i = params.iwU * 100 / params.hPI;
    AppMethodBeat.o(127012);
    return i;
  }
  
  public static int h(s params)
  {
    AppMethodBeat.i(127013);
    if (params.hPI == 0)
    {
      AppMethodBeat.o(127013);
      return 0;
    }
    ae.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + params.ivD + " " + params.hPI);
    int i = params.ivD * 100 / params.hPI;
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
  
  public static int sF(long paramLong)
  {
    AppMethodBeat.i(126999);
    Object localObject = o.aNh().sE(paramLong).iterator();
    while (((Iterator)localObject).hasNext())
    {
      s locals = (s)((Iterator)localObject).next();
      int i = locals.status;
      locals.status = 200;
      ae.d("MicroMsg.VideoLogic", f.abr() + "startSend file:" + locals.getFileName() + " status:[" + i + "->" + locals.status + "]");
      locals.iwY = bu.aRi();
      locals.iwX = bu.aRi();
      locals.dEu = 3328;
      if (!f(locals))
      {
        ae.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + f.abr() + " update failed: " + locals.getFileName());
        i = f.getLine();
        AppMethodBeat.o(126999);
        return 0 - i;
      }
    }
    localObject = o.aNn();
    com.tencent.mm.kernel.g.ajU().aw(new m.3((m)localObject));
    AppMethodBeat.o(126999);
    return 0;
  }
  
  public static void u(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126997);
    s locals = Ia(paramString);
    if (locals == null)
    {
      ae.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(126997);
      return;
    }
    o.aNh();
    int i = t.HL(t.HJ(paramString));
    ae.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    locals.hPI = i;
    locals.hKI = paramInt1;
    Object localObject = locals.ixi;
    ((byg)localObject).Hla = false;
    locals.ixi = ((byg)localObject);
    locals.status = 102;
    o.aNh();
    locals.iwW = t.HL(t.HK(paramString));
    ae.i("MicroMsg.VideoLogic", "update prepare:" + paramString + " thumbsize:" + locals.iwW);
    locals.dEu = 4512;
    ae.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[] { Boolean.valueOf(f(locals)), Integer.valueOf(paramInt2) });
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(locals.iwZ);
    ae.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_msgSvrId), ((ei)localObject).field_talker, Integer.valueOf(((bv)localObject).getType()), Integer.valueOf(((ei)localObject).field_isSend), ((ei)localObject).field_imgPath, Integer.valueOf(((ei)localObject).field_status), Long.valueOf(((ei)localObject).field_createTime) });
    ((bv)localObject).ui(locals.getUser());
    ((bv)localObject).setType(paramInt2);
    ((bv)localObject).kt(1);
    ((bv)localObject).uj(paramString);
    ((bv)localObject).setStatus(1);
    ae.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_msgSvrId), ((ei)localObject).field_talker, Integer.valueOf(((bv)localObject).getType()), Integer.valueOf(((ei)localObject).field_isSend), ((ei)localObject).field_imgPath, Integer.valueOf(((ei)localObject).field_status), Long.valueOf(((ei)localObject).field_createTime) });
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(locals.iwZ, (bv)localObject);
    AppMethodBeat.o(126997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.u
 * JD-Core Version:    0.7.0.1
 */