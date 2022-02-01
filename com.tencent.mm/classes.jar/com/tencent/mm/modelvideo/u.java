package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bj;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;

public final class u
{
  public static boolean HA(String paramString)
  {
    AppMethodBeat.i(127014);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
      AppMethodBeat.o(127014);
      return false;
    }
    ad.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(paramString)));
    Object localObject = Hy(paramString);
    if ((localObject != null) && (((s)localObject).status == 199))
    {
      int i = ((s)localObject).hMP;
      o.aMJ();
      int j = (int)com.tencent.mm.vfs.i.aYo(t.Hh(paramString));
      ad.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j > 0) && (Math.abs(j - i) > 16))
      {
        ad.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramString = ((s)localObject).getFileName();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 217L, 1L, false);
        paramString = Hy(paramString);
        if (paramString != null)
        {
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramString.iuf);
          i = ((bu)localObject).getType();
          ad.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[] { Integer.valueOf(i) });
          if ((43 == i) || (62 == i))
          {
            ((bu)localObject).setContent(q.b(paramString.aMS(), paramString.hHQ, false));
            ((bu)localObject).setStatus(2);
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramString.iuf, (bu)localObject);
            paramString.status = 196;
            paramString.iud = bt.aQJ();
            paramString.dDp = 1280;
            ad.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
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
  
  public static void HB(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127017);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127017);
      return;
    }
    if (o.aMM().db.delete("VideoPlayHistory", "filename= ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      ad.d("MicroMsg.VideoLogic", "delete video play history ret : " + bool + " filename : " + paramString);
      AppMethodBeat.o(127017);
      return;
      bool = false;
    }
  }
  
  public static boolean HC(String paramString)
  {
    AppMethodBeat.i(127021);
    s locals = Hy(paramString);
    if (locals != null)
    {
      locals.videoFormat = 2;
      locals.dDp = 2;
      boolean bool = o.aMJ().c(locals);
      ad.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(2) });
      AppMethodBeat.o(127021);
      return bool;
    }
    AppMethodBeat.o(127021);
    return false;
  }
  
  public static boolean HD(String paramString)
  {
    AppMethodBeat.i(127022);
    paramString = Hy(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.status = 199;
      paramString.iue = bt.aQJ();
      paramString.iud = bt.aQJ();
      paramString.fJH = 19;
      paramString.dDp = 268438786;
      boolean bool = o.aMJ().c(paramString);
      ad.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127022);
      return bool;
    }
    AppMethodBeat.o(127022);
    return false;
  }
  
  public static boolean HE(String paramString)
  {
    AppMethodBeat.i(127023);
    paramString = Hy(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.dDp = 2;
      boolean bool = o.aMJ().c(paramString);
      ad.i("MicroMsg.VideoLogic", "set hevc video format ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127023);
      return bool;
    }
    AppMethodBeat.o(127023);
    return false;
  }
  
  public static int HF(String paramString)
  {
    AppMethodBeat.i(127024);
    s locals = Hy(paramString);
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    boolean bool;
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(locals.iuf).cxg())
    {
      bool = true;
      ad.i("MicroMsg.VideoLogic", " is mp video :%b", new Object[] { Boolean.valueOf(bool) });
      d.aGQ();
      if ((!d.aHa()) || (bool)) {
        break label330;
      }
      locals.status = 122;
    }
    for (int i = 256;; i = 272)
    {
      locals.iue = bt.aQJ();
      locals.iud = bt.aQJ();
      locals.dDp = (i | 0x800 | 0x400);
      if (f(locals)) {
        break label356;
      }
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
      bool = false;
      break;
      label330:
      ad.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
      locals.status = 112;
      locals.iua = 0;
    }
    label356:
    o.aMO().aNf();
    o.aMO().run();
    AppMethodBeat.o(127024);
    return 0;
  }
  
  public static boolean Ho(String paramString)
  {
    AppMethodBeat.i(126988);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString = Hy(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    if (paramString.iug >= 2500)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString.iug += 1;
    paramString.dDp = 16384;
    boolean bool = f(paramString);
    AppMethodBeat.o(126988);
    return bool;
  }
  
  public static boolean Hp(String paramString)
  {
    AppMethodBeat.i(126989);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 218L, 1L, false);
    ad.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[] { paramString, bt.flS() });
    o.aMO().HH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126989);
      return false;
    }
    s locals = Hy(paramString);
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(126989);
      return false;
    }
    locals.status = 198;
    locals.iud = (System.currentTimeMillis() / 1000L);
    locals.dDp = 1280;
    bxm localbxm = locals.iuo;
    localbxm.sJZ = 0;
    locals.iuo = localbxm;
    boolean bool = f(locals);
    ad.d("MicroMsg.VideoLogic", "setError file:" + paramString + " msgid:" + locals.iuf + " old stat:" + locals.status);
    if ((locals == null) || (locals.iuf == 0))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(locals.iuf);
    int i = paramString.getType();
    ad.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 32L, 1L, true);
    paramString.tN(locals.getUser());
    paramString.setContent(q.b(locals.aMS(), -1L, true));
    ad.d("MicroMsg.VideoLogic", "[oneliang][setError]");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(126989);
    return bool;
  }
  
  public static boolean Hq(String paramString)
  {
    AppMethodBeat.i(126990);
    paramString = Hy(paramString);
    if ((paramString == null) || (paramString.iuf == 0))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramString.iuf);
    int i = localbu.getType();
    ad.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    localbu.setContent(q.b(paramString.aMS(), paramString.hHQ, false));
    localbu.setStatus(2);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramString.iuf, localbu);
    paramString.status = 197;
    paramString.iud = bt.aQJ();
    paramString.dDp = 1280;
    ad.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
    boolean bool = f(paramString);
    AppMethodBeat.o(126990);
    return bool;
  }
  
  public static int Hr(String paramString)
  {
    AppMethodBeat.i(126998);
    s locals = Hy(paramString);
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "SENDERR:" + f.abi() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    if ((locals.status != 102) && (locals.status != 105))
    {
      ad.e("MicroMsg.VideoLogic", "SENDERR:" + f.abi() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    int i = locals.status;
    if ((locals.status != 102) && (locals.iuc == locals.iub)) {}
    for (locals.status = 104;; locals.status = 103)
    {
      ad.i("MicroMsg.VideoLogic", f.abi() + "startSend file:" + paramString + " status:[" + i + "->" + locals.status + "]");
      locals.iue = bt.aQJ();
      locals.iud = bt.aQJ();
      locals.dDp = 3328;
      if (f(locals)) {
        break;
      }
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    o.aMO().run();
    AppMethodBeat.o(126998);
    return 0;
  }
  
  public static int Hs(String paramString)
  {
    AppMethodBeat.i(127000);
    s locals = Hy(paramString);
    int i;
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    if ((locals.status != 104) && (locals.status != 103))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    locals.status = 105;
    locals.iud = bt.aQJ();
    locals.dDp = 1280;
    if (!f(locals))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    AppMethodBeat.o(127000);
    return 0;
  }
  
  public static int Ht(String paramString)
  {
    AppMethodBeat.i(127003);
    s locals = Hy(paramString);
    int i;
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    locals.status = 112;
    locals.iue = bt.aQJ();
    locals.iud = bt.aQJ();
    locals.dDp = 3328;
    if (!f(locals))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    o.aMO().aNf();
    o.aMO().run();
    AppMethodBeat.o(127003);
    return 0;
  }
  
  public static int Hu(String paramString)
  {
    AppMethodBeat.i(127004);
    s locals = Hy(paramString);
    int i;
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    if ((locals.status != 112) && (locals.status != 120) && (locals.status != 122) && (locals.status != 123))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    locals.status = 113;
    locals.iud = bt.aQJ();
    locals.dDp = 1280;
    if (!f(locals))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    AppMethodBeat.o(127004);
    return 0;
  }
  
  public static boolean Hv(String paramString)
  {
    AppMethodBeat.i(127006);
    ad.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(paramString)));
    s locals = new s();
    locals.status = 112;
    locals.iud = bt.aQJ();
    locals.iue = bt.aQJ();
    locals.fileName = paramString;
    locals.dDp = 3328;
    if (!f(locals))
    {
      AppMethodBeat.o(127006);
      return false;
    }
    o.aMO().run();
    AppMethodBeat.o(127006);
    return true;
  }
  
  public static boolean Hw(String paramString)
  {
    AppMethodBeat.i(127007);
    s locals = Hy(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(127007);
      return false;
    }
    ad.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[] { paramString });
    paramString = locals.iuo;
    if (paramString != null)
    {
      paramString.sJZ = 0;
      locals.iuo = paramString;
    }
    if (locals.iub < locals.iuc) {}
    for (locals.status = 103;; locals.status = 104)
    {
      locals.createTime = bt.aQJ();
      locals.iud = bt.aQJ();
      locals.iue = bt.aQJ();
      locals.dDp = 536874752;
      if (f(locals)) {
        break;
      }
      AppMethodBeat.o(127007);
      return false;
    }
    o.aMO().run();
    AppMethodBeat.o(127007);
    return true;
  }
  
  public static void Hx(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(127008);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127008);
      return;
    }
    t localt = o.aMJ();
    if (localt.hHS.delete(t.d.Hn(paramString), "filename= ?", new String[] { String.valueOf(paramString) }) > 0)
    {
      t.a.a locala = new t.a.a(paramString, t.a.b.iuB, t.a.c.iuE, 1, -1L);
      localt.hMx.dV(locala);
      localt.hMx.doNotify();
    }
    while (i == 0)
    {
      AppMethodBeat.o(127008);
      return;
      i = 0;
    }
    try
    {
      o.aMJ();
      new com.tencent.mm.vfs.e(t.Hi(paramString)).delete();
      o.aMJ();
      new com.tencent.mm.vfs.e(t.Hh(paramString)).delete();
      AppMethodBeat.o(127008);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + f.abi() + " file:" + paramString + " msg:" + localException.getMessage());
      AppMethodBeat.o(127008);
    }
  }
  
  public static s Hy(String paramString)
  {
    AppMethodBeat.i(127009);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127009);
      return null;
    }
    paramString = o.aMJ().Hb(paramString);
    AppMethodBeat.o(127009);
    return paramString;
  }
  
  public static String Hz(String paramString)
  {
    AppMethodBeat.i(127011);
    String str = b.asg() + bt.flT() + ".mp4";
    if (com.tencent.mm.vfs.i.mz(paramString, str) < 0L)
    {
      AppMethodBeat.o(127011);
      return null;
    }
    AppMethodBeat.o(127011);
    return str;
  }
  
  public static int N(int paramInt, String paramString)
  {
    AppMethodBeat.i(127015);
    long l = bt.HI();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if ((o.aMM().b(paramString, localPInt1, localPInt2)) && (bt.rM(localPInt1.value) < 300L)) {}
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
      ad.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localPInt1.value), paramString, Long.valueOf(bt.aO(l)) });
      AppMethodBeat.o(127015);
      return j;
    }
  }
  
  public static long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(126995);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126995);
      return -1L;
    }
    if (bt.isNullOrNil(paramString2))
    {
      ad.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126995);
      return -1L;
    }
    s locals = new s();
    locals.fileName = paramString1;
    locals.hHQ = 1;
    locals.dDy = paramString2;
    locals.itY = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, ""));
    locals.createTime = bt.aQJ();
    locals.iud = bt.aQJ();
    locals.iuk = null;
    locals.irI = paramString3;
    if (!bt.isNullOrNil(paramString3)) {
      locals.iui = 1;
    }
    int i;
    if (62 == paramInt)
    {
      locals.iui = 0;
      i = 3;
    }
    for (;;)
    {
      locals.iul = i;
      locals.hMP = 0;
      locals.status = 106;
      paramString2 = new bu();
      paramString2.tN(locals.getUser());
      paramString2.setType(paramInt);
      paramString2.kr(1);
      paramString2.tO(paramString1);
      paramString2.setStatus(8);
      paramString2.qA(bj.Bo(locals.getUser()));
      long l = bj.v(paramString2);
      locals.iuf = ((int)l);
      if (!o.aMJ().b(locals)) {
        break;
      }
      AppMethodBeat.o(126995);
      return l;
      if (locals.iui == 0) {
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
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, dki paramdki, String paramString5, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(169103);
    s locals = new s();
    locals.fileName = paramString1;
    locals.hHQ = paramInt1;
    locals.dDy = paramString2;
    locals.itY = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, ""));
    locals.createTime = bt.aQJ();
    locals.iud = bt.aQJ();
    locals.iuk = paramString4;
    locals.irI = paramString3;
    locals.iun = paramdki;
    locals.dHv = paramString5;
    locals.ql(paramInt4);
    locals.GZ(paramString6);
    if (!bt.isNullOrNil(paramString3)) {
      locals.iui = 1;
    }
    if (paramInt2 > 0) {
      locals.iui = 1;
    }
    if (62 == paramInt3) {
      locals.iul = 3;
    }
    for (;;)
    {
      o.aMJ();
      paramInt1 = t.Hj(t.Hh(paramString1));
      if (paramInt1 > 0) {
        break;
      }
      ad.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(169103);
      return false;
      if (paramInt2 > 0) {
        locals.iul = 2;
      } else {
        locals.iul = 1;
      }
    }
    locals.hMP = paramInt1;
    o.aMJ();
    paramString2 = t.Hi(paramString1);
    paramInt1 = t.Hj(paramString2);
    if (paramInt1 <= 0)
    {
      ad.e("MicroMsg.VideoLogic", "get Thumb size failed :" + paramString2 + " size:" + paramInt1);
      AppMethodBeat.o(169103);
      return false;
    }
    locals.iuc = paramInt1;
    ad.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.iuc + " videosize:" + locals.hMP + " msgType:" + paramInt3 + " forwardMsgId: " + paramInt4);
    locals.status = 102;
    paramString2 = new bu();
    paramString2.tN(locals.getUser());
    paramString2.setType(paramInt3);
    paramString2.kr(1);
    paramString2.tO(paramString1);
    paramString2.setStatus(1);
    paramString2.qA(bj.Bo(locals.getUser()));
    locals.iuf = ((int)bj.v(paramString2));
    boolean bool = o.aMJ().b(locals);
    AppMethodBeat.o(169103);
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: ldc_w 663
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 18	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 20
    //   15: ldc_w 665
    //   18: invokestatic 28	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 663
    //   24: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokestatic 670	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4InfoVFS	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_3
    //   34: ldc 20
    //   36: ldc_w 672
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_3
    //   46: aastore
    //   47: invokestatic 86	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: new 674	org/json/JSONObject
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 675	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_1
    //   60: aload_3
    //   61: ldc_w 677
    //   64: invokevirtual 680	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   67: i2l
    //   68: invokestatic 684	com/tencent/mm/sdk/platformtools/bt:Dg	(J)I
    //   71: putfield 539	com/tencent/mm/pointers/PInt:value	I
    //   74: aload_2
    //   75: aload_3
    //   76: ldc_w 686
    //   79: invokevirtual 680	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   82: sipush 1000
    //   85: idiv
    //   86: putfield 539	com/tencent/mm/pointers/PInt:value	I
    //   89: ldc 20
    //   91: ldc_w 688
    //   94: iconst_3
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_2
    //   101: getfield 539	com/tencent/mm/pointers/PInt:value	I
    //   104: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_1
    //   111: getfield 539	com/tencent/mm/pointers/PInt:value	I
    //   114: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_0
    //   121: aastore
    //   122: invokestatic 86	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: ldc_w 663
    //   128: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_3
    //   134: new 690	com/tencent/mm/compatible/h/d
    //   137: dup
    //   138: invokespecial 691	com/tencent/mm/compatible/h/d:<init>	()V
    //   141: astore 4
    //   143: aload 4
    //   145: astore_3
    //   146: aload 4
    //   148: aload_0
    //   149: invokevirtual 696	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   152: aload 4
    //   154: astore_3
    //   155: aload_1
    //   156: aload 4
    //   158: bipush 9
    //   160: invokevirtual 700	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   163: iconst_0
    //   164: invokestatic 703	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   167: i2l
    //   168: invokestatic 684	com/tencent/mm/sdk/platformtools/bt:Dg	(J)I
    //   171: putfield 539	com/tencent/mm/pointers/PInt:value	I
    //   174: aload 4
    //   176: astore_3
    //   177: aload_2
    //   178: aload 4
    //   180: bipush 20
    //   182: invokevirtual 700	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   185: iconst_0
    //   186: invokestatic 703	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   189: sipush 1000
    //   192: idiv
    //   193: putfield 539	com/tencent/mm/pointers/PInt:value	I
    //   196: aload 4
    //   198: invokevirtual 706	android/media/MediaMetadataRetriever:release	()V
    //   201: ldc 20
    //   203: ldc_w 708
    //   206: iconst_3
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_2
    //   213: getfield 539	com/tencent/mm/pointers/PInt:value	I
    //   216: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_1
    //   223: getfield 539	com/tencent/mm/pointers/PInt:value	I
    //   226: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_2
    //   232: aload_0
    //   233: aastore
    //   234: invokestatic 86	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 663
    //   240: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: iconst_1
    //   244: ireturn
    //   245: astore 5
    //   247: aconst_null
    //   248: astore 4
    //   250: aload 4
    //   252: astore_3
    //   253: ldc 20
    //   255: aload 5
    //   257: ldc_w 710
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_0
    //   267: aastore
    //   268: invokestatic 714	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 4
    //   273: ifnull -72 -> 201
    //   276: aload 4
    //   278: invokevirtual 706	android/media/MediaMetadataRetriever:release	()V
    //   281: goto -80 -> 201
    //   284: astore_0
    //   285: aconst_null
    //   286: astore_3
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 706	android/media/MediaMetadataRetriever:release	()V
    //   295: ldc_w 663
    //   298: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean at(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(127005);
    s locals = Hy(paramString);
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.abi() + " getinfo failed: " + paramString);
      AppMethodBeat.o(127005);
      return false;
    }
    if (paramInt != locals.hMP)
    {
      ad.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locals.hMP) });
      locals.hMP = paramInt;
      i = 32;
    }
    locals.iua = paramInt;
    locals.iud = bt.aQJ();
    e(locals);
    locals.status = 199;
    locals.dDp = (i | 0x510);
    boolean bool = f(locals);
    ad.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + locals.hMP + " status:" + locals.status + " netTimes:" + locals.iug + " update ret: " + bool);
    AppMethodBeat.o(127005);
    return bool;
  }
  
  public static void au(String paramString, int paramInt)
  {
    AppMethodBeat.i(127020);
    paramString = Hy(paramString);
    if (paramString != null)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramString.iuf).cxg())
      {
        ad.i("MicroMsg.VideoLogic", "jump mp video");
        AppMethodBeat.o(127020);
        return;
      }
      paramString.status = 122;
      paramString.iue = bt.aQJ();
      paramString.iud = bt.aQJ();
      paramString.fJH = paramInt;
      paramString.dDp = 268438784;
      boolean bool = o.aMJ().c(paramString);
      ad.i("MicroMsg.VideoLogic", "set online video Completion ret: " + bool + " status: " + paramString.status);
    }
    AppMethodBeat.o(127020);
  }
  
  public static boolean av(String paramString, int paramInt)
  {
    AppMethodBeat.i(127025);
    boolean bool = b(Hy(paramString), paramInt);
    AppMethodBeat.o(127025);
    return bool;
  }
  
  public static boolean b(s params, int paramInt)
  {
    AppMethodBeat.i(127026);
    if (params != null)
    {
      params.fJH = paramInt;
      params.dDp = 268435456;
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
    locals.hHQ = paramInt1;
    locals.dDy = paramString2;
    locals.itY = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, ""));
    locals.createTime = bt.aQJ();
    locals.iud = bt.aQJ();
    locals.iuk = paramString3;
    locals.ql(paramInt2);
    locals.iul = 1;
    o.aMJ();
    locals.hMP = t.Hj(t.Hh(paramString1));
    o.aMJ();
    locals.iuc = t.Hj(t.Hi(paramString1));
    ad.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.iuc + " videosize:" + locals.hMP + " msgType:43 forwardMsgId: " + paramInt2);
    locals.status = 102;
    paramString2 = new bu();
    paramString2.tN(locals.getUser());
    paramString2.setType(43);
    paramString2.kr(1);
    paramString2.tO(paramString1);
    paramString2.setStatus(1);
    paramString2.qA(bj.Bo(locals.getUser()));
    locals.iuf = ((int)bj.v(paramString2));
    boolean bool = o.aMJ().b(locals);
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
      ad.e("MicroMsg.VideoLogic", "video info is null");
      AppMethodBeat.o(127001);
      return;
    }
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(params.iuf);
    int i = localbu.getType();
    ad.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127001);
      return;
    }
    localbu.kr(1);
    localbu.tN(params.getUser());
    localbu.qz(params.dAY);
    localbu.setStatus(2);
    localbu.setContent(q.b(params.aMS(), params.hHQ, false));
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(params.iuf, localbu);
    ad.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbu.field_msgId) });
    AppMethodBeat.o(127001);
  }
  
  public static void e(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(127016);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", new Object[] { paramString });
      AppMethodBeat.o(127016);
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    i /= 1000;
    long l1 = bt.HI();
    x localx;
    ContentValues localContentValues;
    long l2;
    boolean bool;
    if (!o.aMM().HG(paramString))
    {
      localx = o.aMM();
      int j = (int)(bt.flT() / 1000L);
      if (paramBoolean)
      {
        paramInt = 1;
        if (bt.isNullOrNil(paramString)) {
          break label255;
        }
        localContentValues = new ContentValues();
        localContentValues.put("filename", paramString);
        localContentValues.put("starttime", Integer.valueOf(j));
        localContentValues.put("playduration", Integer.valueOf(i));
        localContentValues.put("downloadway", Integer.valueOf(paramInt));
        l2 = localx.db.insert("VideoPlayHistory", "filename", localContentValues);
        ad.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : ".concat(String.valueOf(l2)));
        if (l2 <= 0L) {
          break label255;
        }
        bool = true;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean), Long.valueOf(bt.aO(l1)) });
      AppMethodBeat.o(127016);
      return;
      paramInt = 0;
      break;
      label255:
      bool = false;
      continue;
      localx = o.aMM();
      paramInt = (int)(bt.flT() / 1000L);
      if (!bt.isNullOrNil(paramString))
      {
        localContentValues = new ContentValues();
        localContentValues.put("starttime", Integer.valueOf(paramInt));
        localContentValues.put("playduration", Integer.valueOf(i));
        l2 = localx.db.update("VideoPlayHistory", localContentValues, "filename=?", new String[] { paramString });
        ad.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : ".concat(String.valueOf(l2)));
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
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(params.iuf);
    int i = localbu.getType();
    ad.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127002);
      return false;
    }
    localbu.qz(params.dAY);
    localbu.setContent(q.b(params.aMS(), params.hHQ, false));
    localbu.tN(params.getUser());
    ad.d("MicroMsg.VideoLogic", "set msg content :" + localbu.field_content);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().b(params.dAY, localbu);
    ad.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbu.field_msgId) });
    if (localbu.cxh()) {
      ad.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[] { Integer.valueOf(params.hMP) });
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
    if (((params.getFileName() == null) || (params.getFileName().length() <= 0)) && (params.dDp == -1))
    {
      AppMethodBeat.o(127010);
      return false;
    }
    boolean bool = o.aMJ().c(params);
    AppMethodBeat.o(127010);
    return bool;
  }
  
  public static int g(long paramLong, String paramString)
  {
    AppMethodBeat.i(127019);
    if (bt.isNullOrNil(paramString))
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
      if (bt.getLong(paramString[0], 0L) == paramLong)
      {
        i = bt.getInt(paramString[1], 0);
        AppMethodBeat.o(127019);
        return i;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + paramString.toString());
      AppMethodBeat.o(127019);
    }
    return -1;
  }
  
  public static int g(s params)
  {
    AppMethodBeat.i(127012);
    if (params.hMP == 0)
    {
      AppMethodBeat.o(127012);
      return 0;
    }
    ad.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + params.iua + " " + params.hMP);
    int i = params.iua * 100 / params.hMP;
    AppMethodBeat.o(127012);
    return i;
  }
  
  public static int h(s params)
  {
    AppMethodBeat.i(127013);
    if (params.hMP == 0)
    {
      AppMethodBeat.o(127013);
      return 0;
    }
    ad.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + params.isJ + " " + params.hMP);
    int i = params.isJ * 100 / params.hMP;
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
  
  public static int ss(long paramLong)
  {
    AppMethodBeat.i(126999);
    Object localObject = o.aMJ().sr(paramLong).iterator();
    while (((Iterator)localObject).hasNext())
    {
      s locals = (s)((Iterator)localObject).next();
      int i = locals.status;
      locals.status = 200;
      ad.d("MicroMsg.VideoLogic", f.abi() + "startSend file:" + locals.getFileName() + " status:[" + i + "->" + locals.status + "]");
      locals.iue = bt.aQJ();
      locals.iud = bt.aQJ();
      locals.dDp = 3328;
      if (!f(locals))
      {
        ad.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + f.abi() + " update failed: " + locals.getFileName());
        i = f.getLine();
        AppMethodBeat.o(126999);
        return 0 - i;
      }
    }
    localObject = o.aMP();
    com.tencent.mm.kernel.g.ajF().ay(new m.3((m)localObject));
    AppMethodBeat.o(126999);
    return 0;
  }
  
  public static void u(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126997);
    s locals = Hy(paramString);
    if (locals == null)
    {
      ad.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(126997);
      return;
    }
    o.aMJ();
    int i = t.Hj(t.Hh(paramString));
    ad.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    locals.hMP = i;
    locals.hHQ = paramInt1;
    Object localObject = locals.iuo;
    ((bxm)localObject).GRz = false;
    locals.iuo = ((bxm)localObject);
    locals.status = 102;
    o.aMJ();
    locals.iuc = t.Hj(t.Hi(paramString));
    ad.i("MicroMsg.VideoLogic", "update prepare:" + paramString + " thumbsize:" + locals.iuc);
    locals.dDp = 4512;
    ad.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[] { Boolean.valueOf(f(locals)), Integer.valueOf(paramInt2) });
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(locals.iuf);
    ad.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_msgSvrId), ((ei)localObject).field_talker, Integer.valueOf(((bu)localObject).getType()), Integer.valueOf(((ei)localObject).field_isSend), ((ei)localObject).field_imgPath, Integer.valueOf(((ei)localObject).field_status), Long.valueOf(((ei)localObject).field_createTime) });
    ((bu)localObject).tN(locals.getUser());
    ((bu)localObject).setType(paramInt2);
    ((bu)localObject).kr(1);
    ((bu)localObject).tO(paramString);
    ((bu)localObject).setStatus(1);
    ad.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_msgSvrId), ((ei)localObject).field_talker, Integer.valueOf(((bu)localObject).getType()), Integer.valueOf(((ei)localObject).field_isSend), ((ei)localObject).field_imgPath, Integer.valueOf(((ei)localObject).field_status), Long.valueOf(((ei)localObject).field_createTime) });
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(locals.iuf, (bu)localObject);
    AppMethodBeat.o(126997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.u
 * JD-Core Version:    0.7.0.1
 */