package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.List;

public final class u
{
  public static boolean DZ(String paramString)
  {
    AppMethodBeat.i(126988);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString = Ej(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    if (paramString.iaK >= 2500)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString.iaK += 1;
    paramString.drx = 16384;
    boolean bool = f(paramString);
    AppMethodBeat.o(126988);
    return bool;
  }
  
  public static boolean Ea(String paramString)
  {
    AppMethodBeat.i(126989);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 218L, 1L, false);
    ac.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[] { paramString, bs.eWi() });
    o.aJD().Es(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126989);
      return false;
    }
    s locals = Ej(paramString);
    if (locals == null)
    {
      ac.e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(126989);
      return false;
    }
    locals.status = 198;
    locals.iaH = (System.currentTimeMillis() / 1000L);
    locals.drx = 1280;
    bsz localbsz = locals.iaS;
    localbsz.rNU = 0;
    locals.iaS = localbsz;
    boolean bool = f(locals);
    ac.d("MicroMsg.VideoLogic", "setError file:" + paramString + " msgid:" + locals.iaJ + " old stat:" + locals.status);
    if ((locals == null) || (locals.iaJ == 0))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    paramString = ((k)g.ab(k.class)).dcr().vP(locals.iaJ);
    int i = paramString.getType();
    ac.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 32L, 1L, true);
    paramString.re(locals.getUser());
    paramString.setContent(q.b(locals.aJH(), -1L, true));
    ac.d("MicroMsg.VideoLogic", "[oneliang][setError]");
    ((k)g.ab(k.class)).dcr().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(126989);
    return bool;
  }
  
  public static boolean Eb(String paramString)
  {
    AppMethodBeat.i(126990);
    paramString = Ej(paramString);
    if ((paramString == null) || (paramString.iaJ == 0))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    bo localbo = ((k)g.ab(k.class)).dcr().vP(paramString.iaJ);
    int i = localbo.getType();
    ac.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    localbo.setContent(q.b(paramString.aJH(), paramString.hpy, false));
    localbo.setStatus(2);
    ((k)g.ab(k.class)).dcr().a(paramString.iaJ, localbo);
    paramString.status = 197;
    paramString.iaH = bs.aNx();
    paramString.drx = 1280;
    ac.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
    boolean bool = f(paramString);
    AppMethodBeat.o(126990);
    return bool;
  }
  
  public static int Ec(String paramString)
  {
    AppMethodBeat.i(126998);
    s locals = Ej(paramString);
    if (locals == null)
    {
      ac.e("MicroMsg.VideoLogic", "SENDERR:" + f.YG() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    if ((locals.status != 102) && (locals.status != 105))
    {
      ac.e("MicroMsg.VideoLogic", "SENDERR:" + f.YG() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    int i = locals.status;
    if ((locals.status != 102) && (locals.iaG == locals.iaF)) {}
    for (locals.status = 104;; locals.status = 103)
    {
      ac.i("MicroMsg.VideoLogic", f.YG() + "startSend file:" + paramString + " status:[" + i + "->" + locals.status + "]");
      locals.iaI = bs.aNx();
      locals.iaH = bs.aNx();
      locals.drx = 3328;
      if (f(locals)) {
        break;
      }
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    o.aJD().run();
    AppMethodBeat.o(126998);
    return 0;
  }
  
  public static int Ed(String paramString)
  {
    AppMethodBeat.i(127000);
    s locals = Ej(paramString);
    int i;
    if (locals == null)
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    if ((locals.status != 104) && (locals.status != 103))
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    locals.status = 105;
    locals.iaH = bs.aNx();
    locals.drx = 1280;
    if (!f(locals))
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    AppMethodBeat.o(127000);
    return 0;
  }
  
  public static int Ee(String paramString)
  {
    AppMethodBeat.i(127003);
    s locals = Ej(paramString);
    int i;
    if (locals == null)
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    locals.status = 112;
    locals.iaI = bs.aNx();
    locals.iaH = bs.aNx();
    locals.drx = 3328;
    if (!f(locals))
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    o.aJD().aJV();
    o.aJD().run();
    AppMethodBeat.o(127003);
    return 0;
  }
  
  public static int Ef(String paramString)
  {
    AppMethodBeat.i(127004);
    s locals = Ej(paramString);
    int i;
    if (locals == null)
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    if ((locals.status != 112) && (locals.status != 120) && (locals.status != 122) && (locals.status != 123))
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    locals.status = 113;
    locals.iaH = bs.aNx();
    locals.drx = 1280;
    if (!f(locals))
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    AppMethodBeat.o(127004);
    return 0;
  }
  
  public static boolean Eg(String paramString)
  {
    AppMethodBeat.i(127006);
    ac.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(paramString)));
    s locals = new s();
    locals.status = 112;
    locals.iaH = bs.aNx();
    locals.iaI = bs.aNx();
    locals.fileName = paramString;
    locals.drx = 3328;
    if (!f(locals))
    {
      AppMethodBeat.o(127006);
      return false;
    }
    o.aJD().run();
    AppMethodBeat.o(127006);
    return true;
  }
  
  public static boolean Eh(String paramString)
  {
    AppMethodBeat.i(127007);
    s locals = Ej(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(127007);
      return false;
    }
    ac.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[] { paramString });
    paramString = locals.iaS;
    if (paramString != null)
    {
      paramString.rNU = 0;
      locals.iaS = paramString;
    }
    if (locals.iaF < locals.iaG) {}
    for (locals.status = 103;; locals.status = 104)
    {
      locals.createTime = bs.aNx();
      locals.iaH = bs.aNx();
      locals.iaI = bs.aNx();
      locals.drx = 536874752;
      if (f(locals)) {
        break;
      }
      AppMethodBeat.o(127007);
      return false;
    }
    o.aJD().run();
    AppMethodBeat.o(127007);
    return true;
  }
  
  public static void Ei(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(127008);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127008);
      return;
    }
    t localt = o.aJy();
    if (localt.hpA.delete("videoinfo2", "filename= ?", new String[] { String.valueOf(paramString) }) > 0)
    {
      t.a.a locala = new t.a.a(paramString, t.a.b.ibf, t.a.c.ibi, 1, -1L);
      localt.huf.dS(locala);
      localt.huf.doNotify();
    }
    while (i == 0)
    {
      AppMethodBeat.o(127008);
      return;
      i = 0;
    }
    try
    {
      o.aJy();
      new com.tencent.mm.vfs.e(t.DW(paramString)).delete();
      o.aJy();
      new com.tencent.mm.vfs.e(t.DV(paramString)).delete();
      AppMethodBeat.o(127008);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + f.YG() + " file:" + paramString + " msg:" + localException.getMessage());
      AppMethodBeat.o(127008);
    }
  }
  
  public static s Ej(String paramString)
  {
    AppMethodBeat.i(127009);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127009);
      return null;
    }
    paramString = o.aJy().DT(paramString);
    AppMethodBeat.o(127009);
    return paramString;
  }
  
  public static String Ek(String paramString)
  {
    AppMethodBeat.i(127011);
    String str = b.aps() + bs.eWj() + ".mp4";
    if (i.lZ(paramString, str) < 0L)
    {
      AppMethodBeat.o(127011);
      return null;
    }
    AppMethodBeat.o(127011);
    return str;
  }
  
  public static boolean El(String paramString)
  {
    AppMethodBeat.i(127014);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
      AppMethodBeat.o(127014);
      return false;
    }
    ac.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(paramString)));
    Object localObject = Ej(paramString);
    if ((localObject != null) && (((s)localObject).status == 199))
    {
      int i = ((s)localObject).hux;
      o.aJy();
      int j = (int)i.aSp(t.DV(paramString));
      ac.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j > 0) && (Math.abs(j - i) > 16))
      {
        ac.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramString = ((s)localObject).getFileName();
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 217L, 1L, false);
        paramString = Ej(paramString);
        if (paramString != null)
        {
          localObject = ((k)g.ab(k.class)).dcr().vP(paramString.iaJ);
          i = ((bo)localObject).getType();
          ac.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[] { Integer.valueOf(i) });
          if ((43 == i) || (62 == i))
          {
            ((bo)localObject).setContent(q.b(paramString.aJH(), paramString.hpy, false));
            ((bo)localObject).setStatus(2);
            ((k)g.ab(k.class)).dcr().a(paramString.iaJ, (bo)localObject);
            paramString.status = 196;
            paramString.iaH = bs.aNx();
            paramString.drx = 1280;
            ac.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
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
  
  public static void Em(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127017);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127017);
      return;
    }
    if (o.aJB().db.delete("VideoPlayHistory", "filename= ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      ac.d("MicroMsg.VideoLogic", "delete video play history ret : " + bool + " filename : " + paramString);
      AppMethodBeat.o(127017);
      return;
      bool = false;
    }
  }
  
  public static boolean En(String paramString)
  {
    AppMethodBeat.i(127021);
    s locals = Ej(paramString);
    if (locals != null)
    {
      locals.videoFormat = 2;
      locals.drx = 2;
      boolean bool = o.aJy().c(locals);
      ac.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(2) });
      AppMethodBeat.o(127021);
      return bool;
    }
    AppMethodBeat.o(127021);
    return false;
  }
  
  public static boolean Eo(String paramString)
  {
    AppMethodBeat.i(127022);
    paramString = Ej(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.status = 199;
      paramString.iaI = bs.aNx();
      paramString.iaH = bs.aNx();
      paramString.fry = 19;
      paramString.drx = 268438786;
      boolean bool = o.aJy().c(paramString);
      ac.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127022);
      return bool;
    }
    AppMethodBeat.o(127022);
    return false;
  }
  
  public static boolean Ep(String paramString)
  {
    AppMethodBeat.i(127023);
    paramString = Ej(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.drx = 2;
      boolean bool = o.aJy().c(paramString);
      ac.i("MicroMsg.VideoLogic", "set hevc video format ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127023);
      return bool;
    }
    AppMethodBeat.o(127023);
    return false;
  }
  
  public static int Eq(String paramString)
  {
    AppMethodBeat.i(127024);
    s locals = Ej(paramString);
    if (locals == null)
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    boolean bool;
    if (((k)g.ab(k.class)).dcr().vP(locals.iaJ).cru())
    {
      bool = true;
      ac.i("MicroMsg.VideoLogic", " is mp video :%b", new Object[] { Boolean.valueOf(bool) });
      d.aDL();
      if ((!d.aDV()) || (bool)) {
        break label327;
      }
      locals.status = 122;
    }
    for (int i = 256;; i = 272)
    {
      locals.iaI = bs.aNx();
      locals.iaH = bs.aNx();
      locals.drx = (i | 0x800 | 0x400);
      if (f(locals)) {
        break label353;
      }
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
      bool = false;
      break;
      label327:
      ac.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
      locals.status = 112;
      locals.iaE = 0;
    }
    label353:
    o.aJD().aJV();
    o.aJD().run();
    AppMethodBeat.o(127024);
    return 0;
  }
  
  public static int M(int paramInt, String paramString)
  {
    AppMethodBeat.i(127015);
    long l = bs.Gn();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if ((o.aJB().b(paramString, localPInt1, localPInt2)) && (bs.pN(localPInt1.value) < 300L)) {}
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
      ac.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localPInt1.value), paramString, Long.valueOf(bs.aO(l)) });
      AppMethodBeat.o(127015);
      return j;
    }
  }
  
  public static long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(126995);
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126995);
      return -1L;
    }
    if (bs.isNullOrNil(paramString2))
    {
      ac.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126995);
      return -1L;
    }
    s locals = new s();
    locals.fileName = paramString1;
    locals.hpy = 1;
    locals.drG = paramString2;
    locals.iaC = ((String)g.agR().agA().get(2, ""));
    locals.createTime = bs.aNx();
    locals.iaH = bs.aNx();
    locals.iaO = null;
    locals.hYm = paramString3;
    if (!bs.isNullOrNil(paramString3)) {
      locals.iaM = 1;
    }
    int i;
    if (62 == paramInt)
    {
      locals.iaM = 0;
      i = 3;
    }
    for (;;)
    {
      locals.iaP = i;
      locals.hux = 0;
      locals.status = 106;
      paramString2 = new bo();
      paramString2.re(locals.getUser());
      paramString2.setType(paramInt);
      paramString2.jT(1);
      paramString2.rf(paramString1);
      paramString2.setStatus(8);
      paramString2.oA(bi.yp(locals.getUser()));
      long l = bi.u(paramString2);
      locals.iaJ = ((int)l);
      if (!o.aJy().b(locals)) {
        break;
      }
      AppMethodBeat.o(126995);
      return l;
      if (locals.iaM == 0) {
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
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, dev paramdev, String paramString5, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(169103);
    s locals = new s();
    locals.fileName = paramString1;
    locals.hpy = paramInt1;
    locals.drG = paramString2;
    locals.iaC = ((String)g.agR().agA().get(2, ""));
    locals.createTime = bs.aNx();
    locals.iaH = bs.aNx();
    locals.iaO = paramString4;
    locals.hYm = paramString3;
    locals.iaR = paramdev;
    locals.dvs = paramString5;
    locals.pJ(paramInt4);
    locals.DS(paramString6);
    if (!bs.isNullOrNil(paramString3)) {
      locals.iaM = 1;
    }
    if (paramInt2 > 0) {
      locals.iaM = 1;
    }
    if (62 == paramInt3) {
      locals.iaP = 3;
    }
    for (;;)
    {
      o.aJy();
      paramInt1 = t.DX(t.DV(paramString1));
      if (paramInt1 > 0) {
        break;
      }
      ac.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(169103);
      return false;
      if (paramInt2 > 0) {
        locals.iaP = 2;
      } else {
        locals.iaP = 1;
      }
    }
    locals.hux = paramInt1;
    o.aJy();
    paramString2 = t.DW(paramString1);
    paramInt1 = t.DX(paramString2);
    if (paramInt1 <= 0)
    {
      ac.e("MicroMsg.VideoLogic", "get Thumb size failed :" + paramString2 + " size:" + paramInt1);
      AppMethodBeat.o(169103);
      return false;
    }
    locals.iaG = paramInt1;
    ac.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.iaG + " videosize:" + locals.hux + " msgType:" + paramInt3 + " forwardMsgId: " + paramInt4);
    locals.status = 102;
    paramString2 = new bo();
    paramString2.re(locals.getUser());
    paramString2.setType(paramInt3);
    paramString2.jT(1);
    paramString2.rf(paramString1);
    paramString2.setStatus(1);
    paramString2.oA(bi.yp(locals.getUser()));
    locals.iaJ = ((int)bi.u(paramString2));
    boolean bool = o.aJy().b(locals);
    AppMethodBeat.o(169103);
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: ldc_w 660
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 316	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 52
    //   15: ldc_w 662
    //   18: invokestatic 417	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 660
    //   24: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokestatic 667	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4InfoVFS	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_3
    //   34: ldc 52
    //   36: ldc_w 669
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_3
    //   46: aastore
    //   47: invokestatic 430	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: new 671	org/json/JSONObject
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 672	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_1
    //   60: aload_3
    //   61: ldc_w 674
    //   64: invokevirtual 677	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   67: i2l
    //   68: invokestatic 681	com/tencent/mm/sdk/platformtools/bs:Aq	(J)I
    //   71: putfield 536	com/tencent/mm/pointers/PInt:value	I
    //   74: aload_2
    //   75: aload_3
    //   76: ldc_w 683
    //   79: invokevirtual 677	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   82: sipush 1000
    //   85: idiv
    //   86: putfield 536	com/tencent/mm/pointers/PInt:value	I
    //   89: ldc 52
    //   91: ldc_w 685
    //   94: iconst_3
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_2
    //   101: getfield 536	com/tencent/mm/pointers/PInt:value	I
    //   104: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_1
    //   111: getfield 536	com/tencent/mm/pointers/PInt:value	I
    //   114: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_0
    //   121: aastore
    //   122: invokestatic 430	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: ldc_w 660
    //   128: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_3
    //   134: new 687	com/tencent/mm/compatible/h/d
    //   137: dup
    //   138: invokespecial 688	com/tencent/mm/compatible/h/d:<init>	()V
    //   141: astore 4
    //   143: aload 4
    //   145: astore_3
    //   146: aload 4
    //   148: aload_0
    //   149: invokevirtual 693	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   152: aload 4
    //   154: astore_3
    //   155: aload_1
    //   156: aload 4
    //   158: bipush 9
    //   160: invokevirtual 697	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   163: iconst_0
    //   164: invokestatic 700	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   167: i2l
    //   168: invokestatic 681	com/tencent/mm/sdk/platformtools/bs:Aq	(J)I
    //   171: putfield 536	com/tencent/mm/pointers/PInt:value	I
    //   174: aload 4
    //   176: astore_3
    //   177: aload_2
    //   178: aload 4
    //   180: bipush 20
    //   182: invokevirtual 697	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   185: iconst_0
    //   186: invokestatic 700	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   189: sipush 1000
    //   192: idiv
    //   193: putfield 536	com/tencent/mm/pointers/PInt:value	I
    //   196: aload 4
    //   198: invokevirtual 703	android/media/MediaMetadataRetriever:release	()V
    //   201: ldc 52
    //   203: ldc_w 705
    //   206: iconst_3
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_2
    //   213: getfield 536	com/tencent/mm/pointers/PInt:value	I
    //   216: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_1
    //   223: getfield 536	com/tencent/mm/pointers/PInt:value	I
    //   226: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_2
    //   232: aload_0
    //   233: aastore
    //   234: invokestatic 430	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 660
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
    //   257: ldc_w 707
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_0
    //   267: aastore
    //   268: invokestatic 711	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 4
    //   273: ifnull -72 -> 201
    //   276: aload 4
    //   278: invokevirtual 703	android/media/MediaMetadataRetriever:release	()V
    //   281: goto -80 -> 201
    //   284: astore_0
    //   285: aconst_null
    //   286: astore_3
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 703	android/media/MediaMetadataRetriever:release	()V
    //   295: ldc_w 660
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
  
  public static boolean ar(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(127005);
    s locals = Ej(paramString);
    if (locals == null)
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + f.YG() + " getinfo failed: " + paramString);
      AppMethodBeat.o(127005);
      return false;
    }
    if (paramInt != locals.hux)
    {
      ac.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locals.hux) });
      locals.hux = paramInt;
      i = 32;
    }
    locals.iaE = paramInt;
    locals.iaH = bs.aNx();
    e(locals);
    locals.status = 199;
    locals.drx = (i | 0x510);
    boolean bool = f(locals);
    ac.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + locals.hux + " status:" + locals.status + " netTimes:" + locals.iaK + " update ret: " + bool);
    AppMethodBeat.o(127005);
    return bool;
  }
  
  public static void as(String paramString, int paramInt)
  {
    AppMethodBeat.i(127020);
    paramString = Ej(paramString);
    if (paramString != null)
    {
      if (((k)g.ab(k.class)).dcr().vP(paramString.iaJ).cru())
      {
        ac.i("MicroMsg.VideoLogic", "jump mp video");
        AppMethodBeat.o(127020);
        return;
      }
      paramString.status = 122;
      paramString.iaI = bs.aNx();
      paramString.iaH = bs.aNx();
      paramString.fry = paramInt;
      paramString.drx = 268438784;
      boolean bool = o.aJy().c(paramString);
      ac.i("MicroMsg.VideoLogic", "set online video Completion ret: " + bool + " status: " + paramString.status);
    }
    AppMethodBeat.o(127020);
  }
  
  public static boolean at(String paramString, int paramInt)
  {
    AppMethodBeat.i(127025);
    boolean bool = b(Ej(paramString), paramInt);
    AppMethodBeat.o(127025);
    return bool;
  }
  
  public static boolean b(s params, int paramInt)
  {
    AppMethodBeat.i(127026);
    if (params != null)
    {
      params.fry = paramInt;
      params.drx = 268435456;
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
    locals.hpy = paramInt1;
    locals.drG = paramString2;
    locals.iaC = ((String)g.agR().agA().get(2, ""));
    locals.createTime = bs.aNx();
    locals.iaH = bs.aNx();
    locals.iaO = paramString3;
    locals.pJ(paramInt2);
    locals.iaP = 1;
    o.aJy();
    locals.hux = t.DX(t.DV(paramString1));
    o.aJy();
    locals.iaG = t.DX(t.DW(paramString1));
    ac.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.iaG + " videosize:" + locals.hux + " msgType:43 forwardMsgId: " + paramInt2);
    locals.status = 102;
    paramString2 = new bo();
    paramString2.re(locals.getUser());
    paramString2.setType(43);
    paramString2.jT(1);
    paramString2.rf(paramString1);
    paramString2.setStatus(1);
    paramString2.oA(bi.yp(locals.getUser()));
    locals.iaJ = ((int)bi.u(paramString2));
    boolean bool = o.aJy().b(locals);
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
      ac.e("MicroMsg.VideoLogic", "video info is null");
      AppMethodBeat.o(127001);
      return;
    }
    bo localbo = ((k)g.ab(k.class)).dcr().vP(params.iaJ);
    int i = localbo.getType();
    ac.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127001);
      return;
    }
    localbo.jT(1);
    localbo.re(params.getUser());
    localbo.oz(params.dpl);
    localbo.setStatus(2);
    localbo.setContent(q.b(params.aJH(), params.hpy, false));
    ((k)g.ab(k.class)).dcr().a(params.iaJ, localbo);
    ac.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbo.field_msgId) });
    AppMethodBeat.o(127001);
  }
  
  public static void e(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(127016);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", new Object[] { paramString });
      AppMethodBeat.o(127016);
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    i /= 1000;
    long l1 = bs.Gn();
    x localx;
    ContentValues localContentValues;
    long l2;
    boolean bool;
    if (!o.aJB().Er(paramString))
    {
      localx = o.aJB();
      int j = (int)(bs.eWj() / 1000L);
      if (paramBoolean)
      {
        paramInt = 1;
        if (bs.isNullOrNil(paramString)) {
          break label256;
        }
        localContentValues = new ContentValues();
        localContentValues.put("filename", paramString);
        localContentValues.put("starttime", Integer.valueOf(j));
        localContentValues.put("playduration", Integer.valueOf(i));
        localContentValues.put("downloadway", Integer.valueOf(paramInt));
        l2 = localx.db.insert("VideoPlayHistory", "filename", localContentValues);
        ac.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : ".concat(String.valueOf(l2)));
        if (l2 <= 0L) {
          break label256;
        }
        bool = true;
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean), Long.valueOf(bs.aO(l1)) });
      AppMethodBeat.o(127016);
      return;
      paramInt = 0;
      break;
      label256:
      bool = false;
      continue;
      localx = o.aJB();
      paramInt = (int)(bs.eWj() / 1000L);
      if (!bs.isNullOrNil(paramString))
      {
        localContentValues = new ContentValues();
        localContentValues.put("starttime", Integer.valueOf(paramInt));
        localContentValues.put("playduration", Integer.valueOf(i));
        l2 = localx.db.update("VideoPlayHistory", localContentValues, "filename=?", new String[] { paramString });
        ac.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : ".concat(String.valueOf(l2)));
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
    bo localbo = ((k)g.ab(k.class)).dcr().vP(params.iaJ);
    int i = localbo.getType();
    ac.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127002);
      return false;
    }
    localbo.oz(params.dpl);
    localbo.setContent(q.b(params.aJH(), params.hpy, false));
    localbo.re(params.getUser());
    ac.d("MicroMsg.VideoLogic", "set msg content :" + localbo.field_content);
    ((k)g.ab(k.class)).dcr().b(params.dpl, localbo);
    ac.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbo.field_msgId) });
    if (localbo.crv()) {
      ac.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[] { Integer.valueOf(params.hux) });
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
    if (((params.getFileName() == null) || (params.getFileName().length() <= 0)) && (params.drx == -1))
    {
      AppMethodBeat.o(127010);
      return false;
    }
    boolean bool = o.aJy().c(params);
    AppMethodBeat.o(127010);
    return bool;
  }
  
  public static int g(long paramLong, String paramString)
  {
    AppMethodBeat.i(127019);
    if (bs.isNullOrNil(paramString))
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
      if (bs.getLong(paramString[0], 0L) == paramLong)
      {
        i = bs.getInt(paramString[1], 0);
        AppMethodBeat.o(127019);
        return i;
      }
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + paramString.toString());
      AppMethodBeat.o(127019);
    }
    return -1;
  }
  
  public static int g(s params)
  {
    AppMethodBeat.i(127012);
    if (params.hux == 0)
    {
      AppMethodBeat.o(127012);
      return 0;
    }
    ac.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + params.iaE + " " + params.hux);
    int i = params.iaE * 100 / params.hux;
    AppMethodBeat.o(127012);
    return i;
  }
  
  public static int h(s params)
  {
    AppMethodBeat.i(127013);
    if (params.hux == 0)
    {
      AppMethodBeat.o(127013);
      return 0;
    }
    ac.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + params.hZn + " " + params.hux);
    int i = params.hZn * 100 / params.hux;
    AppMethodBeat.o(127013);
    return i;
  }
  
  public static int qt(long paramLong)
  {
    AppMethodBeat.i(126999);
    Object localObject = o.aJy().qs(paramLong).iterator();
    while (((Iterator)localObject).hasNext())
    {
      s locals = (s)((Iterator)localObject).next();
      int i = locals.status;
      locals.status = 200;
      ac.d("MicroMsg.VideoLogic", f.YG() + "startSend file:" + locals.getFileName() + " status:[" + i + "->" + locals.status + "]");
      locals.iaI = bs.aNx();
      locals.iaH = bs.aNx();
      locals.drx = 3328;
      if (!f(locals))
      {
        ac.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + f.YG() + " update failed: " + locals.getFileName());
        i = f.getLine();
        AppMethodBeat.o(126999);
        return 0 - i;
      }
    }
    localObject = o.aJE();
    g.agU().az(new m.3((m)localObject));
    AppMethodBeat.o(126999);
    return 0;
  }
  
  public static long s(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(126996);
    long l = a(paramString1, paramString2, paramString3, 43);
    AppMethodBeat.o(126996);
    return l;
  }
  
  public static void s(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126997);
    s locals = Ej(paramString);
    if (locals == null)
    {
      ac.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(126997);
      return;
    }
    o.aJy();
    int i = t.DX(t.DV(paramString));
    ac.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    locals.hux = i;
    locals.hpy = paramInt1;
    Object localObject = locals.iaS;
    ((bsz)localObject).FhY = false;
    locals.iaS = ((bsz)localObject);
    locals.status = 102;
    o.aJy();
    locals.iaG = t.DX(t.DW(paramString));
    ac.i("MicroMsg.VideoLogic", "update prepare:" + paramString + " thumbsize:" + locals.iaG);
    locals.drx = 4512;
    ac.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[] { Boolean.valueOf(f(locals)), Integer.valueOf(paramInt2) });
    localObject = ((k)g.ab(k.class)).dcr().vP(locals.iaJ);
    ac.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((dy)localObject).field_msgId), Long.valueOf(((dy)localObject).field_msgSvrId), ((dy)localObject).field_talker, Integer.valueOf(((bo)localObject).getType()), Integer.valueOf(((dy)localObject).field_isSend), ((dy)localObject).field_imgPath, Integer.valueOf(((dy)localObject).field_status), Long.valueOf(((dy)localObject).field_createTime) });
    ((bo)localObject).re(locals.getUser());
    ((bo)localObject).setType(paramInt2);
    ((bo)localObject).jT(1);
    ((bo)localObject).rf(paramString);
    ((bo)localObject).setStatus(1);
    ac.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((dy)localObject).field_msgId), Long.valueOf(((dy)localObject).field_msgSvrId), ((dy)localObject).field_talker, Integer.valueOf(((bo)localObject).getType()), Integer.valueOf(((dy)localObject).field_isSend), ((dy)localObject).field_imgPath, Integer.valueOf(((dy)localObject).field_status), Long.valueOf(((dy)localObject).field_createTime) });
    ((k)g.ab(k.class)).dcr().a(locals.iaJ, (bo)localObject);
    AppMethodBeat.o(126997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.u
 * JD-Core Version:    0.7.0.1
 */