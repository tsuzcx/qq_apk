package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.List;

public final class u
{
  public static int Aa(String paramString)
  {
    AppMethodBeat.i(127004);
    s locals = Ae(paramString);
    int i;
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    if ((locals.status != 112) && (locals.status != 120) && (locals.status != 122) && (locals.status != 123))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    locals.status = 113;
    locals.hAg = bt.aGK();
    locals.dtM = 1280;
    if (!f(locals))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127004);
      return 0 - i;
    }
    AppMethodBeat.o(127004);
    return 0;
  }
  
  public static boolean Ab(String paramString)
  {
    AppMethodBeat.i(127006);
    ad.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(paramString)));
    s locals = new s();
    locals.status = 112;
    locals.hAg = bt.aGK();
    locals.hAh = bt.aGK();
    locals.fileName = paramString;
    locals.dtM = 3328;
    if (!f(locals))
    {
      AppMethodBeat.o(127006);
      return false;
    }
    o.aCN().run();
    AppMethodBeat.o(127006);
    return true;
  }
  
  public static boolean Ac(String paramString)
  {
    AppMethodBeat.i(127007);
    s locals = Ae(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(127007);
      return false;
    }
    ad.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[] { paramString });
    paramString = locals.hAr;
    if (paramString != null)
    {
      paramString.qRG = 0;
      locals.hAr = paramString;
    }
    if (locals.hAe < locals.hAf) {}
    for (locals.status = 103;; locals.status = 104)
    {
      locals.createTime = bt.aGK();
      locals.hAg = bt.aGK();
      locals.hAh = bt.aGK();
      locals.dtM = 536874752;
      if (f(locals)) {
        break;
      }
      AppMethodBeat.o(127007);
      return false;
    }
    o.aCN().run();
    AppMethodBeat.o(127007);
    return true;
  }
  
  public static void Ad(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(127008);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127008);
      return;
    }
    t localt = o.aCI();
    if (localt.gPa.delete("videoinfo2", "filename= ?", new String[] { String.valueOf(paramString) }) > 0)
    {
      t.a.a locala = new t.a.a(paramString, t.a.b.hAE, t.a.c.hAH, 1, -1L);
      localt.gTG.dR(locala);
      localt.gTG.doNotify();
    }
    while (i == 0)
    {
      AppMethodBeat.o(127008);
      return;
      i = 0;
    }
    try
    {
      o.aCI();
      new com.tencent.mm.vfs.e(t.zR(paramString)).delete();
      o.aCI();
      new com.tencent.mm.vfs.e(t.zQ(paramString)).delete();
      AppMethodBeat.o(127008);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + f.XJ() + " file:" + paramString + " msg:" + localException.getMessage());
      AppMethodBeat.o(127008);
    }
  }
  
  public static s Ae(String paramString)
  {
    AppMethodBeat.i(127009);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127009);
      return null;
    }
    paramString = o.aCI().zO(paramString);
    AppMethodBeat.o(127009);
    return paramString;
  }
  
  public static String Af(String paramString)
  {
    AppMethodBeat.i(127011);
    String str = b.ais() + bt.eGO() + ".mp4";
    if (i.lC(paramString, str) < 0L)
    {
      AppMethodBeat.o(127011);
      return null;
    }
    AppMethodBeat.o(127011);
    return str;
  }
  
  public static boolean Ag(String paramString)
  {
    AppMethodBeat.i(127014);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
      AppMethodBeat.o(127014);
      return false;
    }
    ad.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(paramString)));
    Object localObject = Ae(paramString);
    if ((localObject != null) && (((s)localObject).status == 199))
    {
      int i = ((s)localObject).gTY;
      o.aCI();
      int j = (int)i.aMN(t.zQ(paramString));
      ad.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j > 0) && (Math.abs(j - i) > 16))
      {
        ad.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramString = ((s)localObject).getFileName();
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 217L, 1L, false);
        paramString = Ae(paramString);
        if (paramString != null)
        {
          localObject = ((k)g.ab(k.class)).cOI().rm(paramString.hAi);
          i = ((bl)localObject).getType();
          ad.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[] { Integer.valueOf(i) });
          if ((43 == i) || (62 == i))
          {
            ((bl)localObject).setContent(q.b(paramString.aCQ(), paramString.gOY, false));
            ((bl)localObject).setStatus(2);
            ((k)g.ab(k.class)).cOI().a(paramString.hAi, (bl)localObject);
            paramString.status = 196;
            paramString.hAg = bt.aGK();
            paramString.dtM = 1280;
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
  
  public static void Ah(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(127017);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(127017);
      return;
    }
    if (o.aCL().db.delete("VideoPlayHistory", "filename= ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      ad.d("MicroMsg.VideoLogic", "delete video play history ret : " + bool + " filename : " + paramString);
      AppMethodBeat.o(127017);
      return;
      bool = false;
    }
  }
  
  public static boolean Ai(String paramString)
  {
    AppMethodBeat.i(127021);
    s locals = Ae(paramString);
    if (locals != null)
    {
      locals.videoFormat = 2;
      locals.dtM = 2;
      boolean bool = o.aCI().c(locals);
      ad.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(2) });
      AppMethodBeat.o(127021);
      return bool;
    }
    AppMethodBeat.o(127021);
    return false;
  }
  
  public static boolean Aj(String paramString)
  {
    AppMethodBeat.i(127022);
    paramString = Ae(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.status = 199;
      paramString.hAh = bt.aGK();
      paramString.hAg = bt.aGK();
      paramString.foe = 19;
      paramString.dtM = 268438786;
      boolean bool = o.aCI().c(paramString);
      ad.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127022);
      return bool;
    }
    AppMethodBeat.o(127022);
    return false;
  }
  
  public static boolean Ak(String paramString)
  {
    AppMethodBeat.i(127023);
    paramString = Ae(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.dtM = 2;
      boolean bool = o.aCI().c(paramString);
      ad.i("MicroMsg.VideoLogic", "set hevc video format ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(127023);
      return bool;
    }
    AppMethodBeat.o(127023);
    return false;
  }
  
  public static int Al(String paramString)
  {
    AppMethodBeat.i(127024);
    s locals = Ae(paramString);
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
    }
    boolean bool;
    if (((k)g.ab(k.class)).cOI().rm(locals.hAi).cjN())
    {
      bool = true;
      ad.i("MicroMsg.VideoLogic", " is mp video :%b", new Object[] { Boolean.valueOf(bool) });
      d.awT();
      if ((!d.axd()) || (bool)) {
        break label324;
      }
      locals.status = 122;
    }
    for (int i = 256;; i = 272)
    {
      locals.hAh = bt.aGK();
      locals.hAg = bt.aGK();
      locals.dtM = (i | 0x800 | 0x400);
      if (f(locals)) {
        break label350;
      }
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127024);
      return 0 - i;
      bool = false;
      break;
      label324:
      ad.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
      locals.status = 112;
      locals.hAd = 0;
    }
    label350:
    o.aCN().aDe();
    o.aCN().run();
    AppMethodBeat.o(127024);
    return 0;
  }
  
  public static int L(int paramInt, String paramString)
  {
    AppMethodBeat.i(127015);
    long l = bt.GC();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if ((o.aCL().b(paramString, localPInt1, localPInt2)) && (bt.lZ(localPInt1.value) < 300L)) {}
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
      ad.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localPInt1.value), paramString, Long.valueOf(bt.aS(l)) });
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
    locals.gOY = 1;
    locals.dtV = paramString2;
    locals.hAb = ((String)g.afB().afk().get(2, ""));
    locals.createTime = bt.aGK();
    locals.hAg = bt.aGK();
    locals.hAn = null;
    locals.hxL = paramString3;
    if (!bt.isNullOrNil(paramString3)) {
      locals.hAl = 1;
    }
    int i;
    if (62 == paramInt)
    {
      locals.hAl = 0;
      i = 3;
    }
    for (;;)
    {
      locals.hAo = i;
      locals.gTY = 0;
      locals.status = 106;
      paramString2 = new bl();
      paramString2.nY(locals.getUser());
      paramString2.setType(paramInt);
      paramString2.jV(1);
      paramString2.nZ(paramString1);
      paramString2.setStatus(8);
      paramString2.kY(bi.uj(locals.getUser()));
      long l = bi.u(paramString2);
      locals.hAi = ((int)l);
      if (!o.aCI().b(locals)) {
        break;
      }
      AppMethodBeat.o(126995);
      return l;
      if (locals.hAl == 0) {
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
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, czj paramczj, String paramString5, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(169103);
    s locals = new s();
    locals.fileName = paramString1;
    locals.gOY = paramInt1;
    locals.dtV = paramString2;
    locals.hAb = ((String)g.afB().afk().get(2, ""));
    locals.createTime = bt.aGK();
    locals.hAg = bt.aGK();
    locals.hAn = paramString4;
    locals.hxL = paramString3;
    locals.hAq = paramczj;
    locals.dxG = paramString5;
    locals.oU(paramInt4);
    locals.zN(paramString6);
    if (!bt.isNullOrNil(paramString3)) {
      locals.hAl = 1;
    }
    if (paramInt2 > 0) {
      locals.hAl = 1;
    }
    if (62 == paramInt3) {
      locals.hAo = 3;
    }
    for (;;)
    {
      o.aCI();
      paramInt1 = t.zS(t.zQ(paramString1));
      if (paramInt1 > 0) {
        break;
      }
      ad.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(169103);
      return false;
      if (paramInt2 > 0) {
        locals.hAo = 2;
      } else {
        locals.hAo = 1;
      }
    }
    locals.gTY = paramInt1;
    o.aCI();
    paramString2 = t.zR(paramString1);
    paramInt1 = t.zS(paramString2);
    if (paramInt1 <= 0)
    {
      ad.e("MicroMsg.VideoLogic", "get Thumb size failed :" + paramString2 + " size:" + paramInt1);
      AppMethodBeat.o(169103);
      return false;
    }
    locals.hAf = paramInt1;
    ad.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.hAf + " videosize:" + locals.gTY + " msgType:" + paramInt3 + " forwardMsgId: " + paramInt4);
    locals.status = 102;
    paramString2 = new bl();
    paramString2.nY(locals.getUser());
    paramString2.setType(paramInt3);
    paramString2.jV(1);
    paramString2.nZ(paramString1);
    paramString2.setStatus(1);
    paramString2.kY(bi.uj(locals.getUser()));
    locals.hAi = ((int)bi.u(paramString2));
    boolean bool = o.aCI().b(locals);
    AppMethodBeat.o(169103);
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: ldc_w 587
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 159	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 19
    //   15: ldc_w 589
    //   18: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 587
    //   24: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokestatic 594	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4InfoVFS	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_3
    //   34: ldc 19
    //   36: ldc_w 596
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_3
    //   46: aastore
    //   47: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: new 598	org/json/JSONObject
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 599	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_1
    //   60: aload_3
    //   61: ldc_w 601
    //   64: invokevirtual 604	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   67: i2l
    //   68: invokestatic 608	com/tencent/mm/sdk/platformtools/bt:vN	(J)I
    //   71: putfield 457	com/tencent/mm/pointers/PInt:value	I
    //   74: aload_2
    //   75: aload_3
    //   76: ldc_w 610
    //   79: invokevirtual 604	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   82: sipush 1000
    //   85: idiv
    //   86: putfield 457	com/tencent/mm/pointers/PInt:value	I
    //   89: ldc 19
    //   91: ldc_w 612
    //   94: iconst_3
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_2
    //   101: getfield 457	com/tencent/mm/pointers/PInt:value	I
    //   104: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_1
    //   111: getfield 457	com/tencent/mm/pointers/PInt:value	I
    //   114: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_0
    //   121: aastore
    //   122: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: ldc_w 587
    //   128: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_3
    //   134: new 614	com/tencent/mm/compatible/h/d
    //   137: dup
    //   138: invokespecial 615	com/tencent/mm/compatible/h/d:<init>	()V
    //   141: astore 4
    //   143: aload 4
    //   145: astore_3
    //   146: aload 4
    //   148: aload_0
    //   149: invokevirtual 620	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   152: aload 4
    //   154: astore_3
    //   155: aload_1
    //   156: aload 4
    //   158: bipush 9
    //   160: invokevirtual 624	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   163: iconst_0
    //   164: invokestatic 627	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   167: i2l
    //   168: invokestatic 608	com/tencent/mm/sdk/platformtools/bt:vN	(J)I
    //   171: putfield 457	com/tencent/mm/pointers/PInt:value	I
    //   174: aload 4
    //   176: astore_3
    //   177: aload_2
    //   178: aload 4
    //   180: bipush 20
    //   182: invokevirtual 624	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   185: iconst_0
    //   186: invokestatic 627	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   189: sipush 1000
    //   192: idiv
    //   193: putfield 457	com/tencent/mm/pointers/PInt:value	I
    //   196: aload 4
    //   198: invokevirtual 630	android/media/MediaMetadataRetriever:release	()V
    //   201: ldc 19
    //   203: ldc_w 632
    //   206: iconst_3
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_2
    //   213: getfield 457	com/tencent/mm/pointers/PInt:value	I
    //   216: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_1
    //   223: getfield 457	com/tencent/mm/pointers/PInt:value	I
    //   226: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_2
    //   232: aload_0
    //   233: aastore
    //   234: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 587
    //   240: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: iconst_1
    //   244: ireturn
    //   245: astore 5
    //   247: aconst_null
    //   248: astore 4
    //   250: aload 4
    //   252: astore_3
    //   253: ldc 19
    //   255: aload 5
    //   257: ldc_w 634
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_0
    //   267: aastore
    //   268: invokestatic 638	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 4
    //   273: ifnull -72 -> 201
    //   276: aload 4
    //   278: invokevirtual 630	android/media/MediaMetadataRetriever:release	()V
    //   281: goto -80 -> 201
    //   284: astore_0
    //   285: aconst_null
    //   286: astore_3
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 630	android/media/MediaMetadataRetriever:release	()V
    //   295: ldc_w 587
    //   298: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean an(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(127005);
    s locals = Ae(paramString);
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " getinfo failed: " + paramString);
      AppMethodBeat.o(127005);
      return false;
    }
    if (paramInt != locals.gTY)
    {
      ad.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locals.gTY) });
      locals.gTY = paramInt;
      i = 32;
    }
    locals.hAd = paramInt;
    locals.hAg = bt.aGK();
    e(locals);
    locals.status = 199;
    locals.dtM = (i | 0x510);
    boolean bool = f(locals);
    ad.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + locals.gTY + " status:" + locals.status + " netTimes:" + locals.hAj + " update ret: " + bool);
    AppMethodBeat.o(127005);
    return bool;
  }
  
  public static void ao(String paramString, int paramInt)
  {
    AppMethodBeat.i(127020);
    paramString = Ae(paramString);
    if (paramString != null)
    {
      if (((k)g.ab(k.class)).cOI().rm(paramString.hAi).cjN())
      {
        ad.i("MicroMsg.VideoLogic", "jump mp video");
        AppMethodBeat.o(127020);
        return;
      }
      paramString.status = 122;
      paramString.hAh = bt.aGK();
      paramString.hAg = bt.aGK();
      paramString.foe = paramInt;
      paramString.dtM = 268438784;
      boolean bool = o.aCI().c(paramString);
      ad.i("MicroMsg.VideoLogic", "set online video Completion ret: " + bool + " status: " + paramString.status);
    }
    AppMethodBeat.o(127020);
  }
  
  public static boolean ap(String paramString, int paramInt)
  {
    AppMethodBeat.i(127025);
    boolean bool = b(Ae(paramString), paramInt);
    AppMethodBeat.o(127025);
    return bool;
  }
  
  public static boolean b(s params, int paramInt)
  {
    AppMethodBeat.i(127026);
    if (params != null)
    {
      params.foe = paramInt;
      params.dtM = 268435456;
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
    locals.gOY = paramInt1;
    locals.dtV = paramString2;
    locals.hAb = ((String)g.afB().afk().get(2, ""));
    locals.createTime = bt.aGK();
    locals.hAg = bt.aGK();
    locals.hAn = paramString3;
    locals.oU(paramInt2);
    locals.hAo = 1;
    o.aCI();
    locals.gTY = t.zS(t.zQ(paramString1));
    o.aCI();
    locals.hAf = t.zS(t.zR(paramString1));
    ad.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.hAf + " videosize:" + locals.gTY + " msgType:43 forwardMsgId: " + paramInt2);
    locals.status = 102;
    paramString2 = new bl();
    paramString2.nY(locals.getUser());
    paramString2.setType(43);
    paramString2.jV(1);
    paramString2.nZ(paramString1);
    paramString2.setStatus(1);
    paramString2.kY(bi.uj(locals.getUser()));
    locals.hAi = ((int)bi.u(paramString2));
    boolean bool = o.aCI().b(locals);
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
    bl localbl = ((k)g.ab(k.class)).cOI().rm(params.hAi);
    int i = localbl.getType();
    ad.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127001);
      return;
    }
    localbl.jV(1);
    localbl.nY(params.getUser());
    localbl.kX(params.drA);
    localbl.setStatus(2);
    localbl.setContent(q.b(params.aCQ(), params.gOY, false));
    ((k)g.ab(k.class)).cOI().a(params.hAi, localbl);
    ad.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbl.field_msgId) });
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
    long l1 = bt.GC();
    x localx;
    ContentValues localContentValues;
    long l2;
    boolean bool;
    if (!o.aCL().Am(paramString))
    {
      localx = o.aCL();
      int j = (int)(bt.eGO() / 1000L);
      if (paramBoolean)
      {
        paramInt = 1;
        if (bt.isNullOrNil(paramString)) {
          break label256;
        }
        localContentValues = new ContentValues();
        localContentValues.put("filename", paramString);
        localContentValues.put("starttime", Integer.valueOf(j));
        localContentValues.put("playduration", Integer.valueOf(i));
        localContentValues.put("downloadway", Integer.valueOf(paramInt));
        l2 = localx.db.insert("VideoPlayHistory", "filename", localContentValues);
        ad.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : ".concat(String.valueOf(l2)));
        if (l2 <= 0L) {
          break label256;
        }
        bool = true;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean), Long.valueOf(bt.aS(l1)) });
      AppMethodBeat.o(127016);
      return;
      paramInt = 0;
      break;
      label256:
      bool = false;
      continue;
      localx = o.aCL();
      paramInt = (int)(bt.eGO() / 1000L);
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
    bl localbl = ((k)g.ab(k.class)).cOI().rm(params.hAi);
    int i = localbl.getType();
    ad.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(127002);
      return false;
    }
    localbl.kX(params.drA);
    localbl.setContent(q.b(params.aCQ(), params.gOY, false));
    localbl.nY(params.getUser());
    ad.d("MicroMsg.VideoLogic", "set msg content :" + localbl.field_content);
    ((k)g.ab(k.class)).cOI().b(params.drA, localbl);
    ad.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbl.field_msgId) });
    if (localbl.cjO()) {
      ad.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[] { Integer.valueOf(params.gTY) });
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
    if (((params.getFileName() == null) || (params.getFileName().length() <= 0)) && (params.dtM == -1))
    {
      AppMethodBeat.o(127010);
      return false;
    }
    boolean bool = o.aCI().c(params);
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
    if (params.gTY == 0)
    {
      AppMethodBeat.o(127012);
      return 0;
    }
    ad.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + params.hAd + " " + params.gTY);
    int i = params.hAd * 100 / params.gTY;
    AppMethodBeat.o(127012);
    return i;
  }
  
  public static int h(s params)
  {
    AppMethodBeat.i(127013);
    if (params.gTY == 0)
    {
      AppMethodBeat.o(127013);
      return 0;
    }
    ad.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + params.hyM + " " + params.gTY);
    int i = params.hyM * 100 / params.gTY;
    AppMethodBeat.o(127013);
    return i;
  }
  
  public static int mF(long paramLong)
  {
    AppMethodBeat.i(126999);
    Object localObject = o.aCI().mE(paramLong).iterator();
    while (((Iterator)localObject).hasNext())
    {
      s locals = (s)((Iterator)localObject).next();
      int i = locals.status;
      locals.status = 200;
      ad.d("MicroMsg.VideoLogic", f.XJ() + "startSend file:" + locals.getFileName() + " status:[" + i + "->" + locals.status + "]");
      locals.hAh = bt.aGK();
      locals.hAg = bt.aGK();
      locals.dtM = 3328;
      if (!f(locals))
      {
        ad.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + f.XJ() + " update failed: " + locals.getFileName());
        i = f.getLine();
        AppMethodBeat.o(126999);
        return 0 - i;
      }
    }
    localObject = o.aCO();
    g.afE().ax(new m.3((m)localObject));
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
  
  public static void t(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126997);
    s locals = Ae(paramString);
    if (locals == null)
    {
      ad.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(126997);
      return;
    }
    o.aCI();
    int i = t.zS(t.zQ(paramString));
    ad.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    locals.gTY = i;
    locals.gOY = paramInt1;
    Object localObject = locals.hAr;
    ((boj)localObject).DLJ = false;
    locals.hAr = ((boj)localObject);
    locals.status = 102;
    o.aCI();
    locals.hAf = t.zS(t.zR(paramString));
    ad.i("MicroMsg.VideoLogic", "update prepare:" + paramString + " thumbsize:" + locals.hAf);
    locals.dtM = 4512;
    ad.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[] { Boolean.valueOf(f(locals)), Integer.valueOf(paramInt2) });
    localObject = ((k)g.ab(k.class)).cOI().rm(locals.hAi);
    ad.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((du)localObject).field_msgId), Long.valueOf(((du)localObject).field_msgSvrId), ((du)localObject).field_talker, Integer.valueOf(((bl)localObject).getType()), Integer.valueOf(((du)localObject).field_isSend), ((du)localObject).field_imgPath, Integer.valueOf(((du)localObject).field_status), Long.valueOf(((du)localObject).field_createTime) });
    ((bl)localObject).nY(locals.getUser());
    ((bl)localObject).setType(paramInt2);
    ((bl)localObject).jV(1);
    ((bl)localObject).nZ(paramString);
    ((bl)localObject).setStatus(1);
    ad.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((du)localObject).field_msgId), Long.valueOf(((du)localObject).field_msgSvrId), ((du)localObject).field_talker, Integer.valueOf(((bl)localObject).getType()), Integer.valueOf(((du)localObject).field_isSend), ((du)localObject).field_imgPath, Integer.valueOf(((du)localObject).field_status), Long.valueOf(((du)localObject).field_createTime) });
    ((k)g.ab(k.class)).cOI().a(locals.hAi, (bl)localObject);
    AppMethodBeat.o(126997);
  }
  
  public static boolean zU(String paramString)
  {
    AppMethodBeat.i(126988);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString = Ae(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    if (paramString.hAj >= 2500)
    {
      AppMethodBeat.o(126988);
      return false;
    }
    paramString.hAj += 1;
    paramString.dtM = 16384;
    boolean bool = f(paramString);
    AppMethodBeat.o(126988);
    return bool;
  }
  
  public static boolean zV(String paramString)
  {
    AppMethodBeat.i(126989);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 218L, 1L, false);
    ad.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[] { paramString, bt.eGN() });
    o.aCN().An(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(126989);
      return false;
    }
    s locals = Ae(paramString);
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(126989);
      return false;
    }
    locals.status = 198;
    locals.hAg = (System.currentTimeMillis() / 1000L);
    locals.dtM = 1280;
    boj localboj = locals.hAr;
    localboj.qRG = 0;
    locals.hAr = localboj;
    boolean bool = f(locals);
    ad.d("MicroMsg.VideoLogic", "setError file:" + paramString + " msgid:" + locals.hAi + " old stat:" + locals.status);
    if ((locals == null) || (locals.hAi == 0))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    paramString = ((k)g.ab(k.class)).cOI().rm(locals.hAi);
    int i = paramString.getType();
    ad.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126989);
      return bool;
    }
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 32L, 1L, true);
    paramString.nY(locals.getUser());
    paramString.setContent(q.b(locals.aCQ(), -1L, true));
    ad.d("MicroMsg.VideoLogic", "[oneliang][setError]");
    ((k)g.ab(k.class)).cOI().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(126989);
    return bool;
  }
  
  public static boolean zW(String paramString)
  {
    AppMethodBeat.i(126990);
    paramString = Ae(paramString);
    if ((paramString == null) || (paramString.hAi == 0))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    bl localbl = ((k)g.ab(k.class)).cOI().rm(paramString.hAi);
    int i = localbl.getType();
    ad.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(126990);
      return false;
    }
    localbl.setContent(q.b(paramString.aCQ(), paramString.gOY, false));
    localbl.setStatus(2);
    ((k)g.ab(k.class)).cOI().a(paramString.hAi, localbl);
    paramString.status = 197;
    paramString.hAg = bt.aGK();
    paramString.dtM = 1280;
    ad.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
    boolean bool = f(paramString);
    AppMethodBeat.o(126990);
    return bool;
  }
  
  public static int zX(String paramString)
  {
    AppMethodBeat.i(126998);
    s locals = Ae(paramString);
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "SENDERR:" + f.XJ() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    if ((locals.status != 102) && (locals.status != 105))
    {
      ad.e("MicroMsg.VideoLogic", "SENDERR:" + f.XJ() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    int i = locals.status;
    if ((locals.status != 102) && (locals.hAf == locals.hAe)) {}
    for (locals.status = 104;; locals.status = 103)
    {
      ad.i("MicroMsg.VideoLogic", f.XJ() + "startSend file:" + paramString + " status:[" + i + "->" + locals.status + "]");
      locals.hAh = bt.aGK();
      locals.hAg = bt.aGK();
      locals.dtM = 3328;
      if (f(locals)) {
        break;
      }
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(126998);
      return 0 - i;
    }
    o.aCN().run();
    AppMethodBeat.o(126998);
    return 0;
  }
  
  public static int zY(String paramString)
  {
    AppMethodBeat.i(127000);
    s locals = Ae(paramString);
    int i;
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    if ((locals.status != 104) && (locals.status != 103))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    locals.status = 105;
    locals.hAg = bt.aGK();
    locals.dtM = 1280;
    if (!f(locals))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127000);
      return 0 - i;
    }
    AppMethodBeat.o(127000);
    return 0;
  }
  
  public static int zZ(String paramString)
  {
    AppMethodBeat.i(127003);
    s locals = Ae(paramString);
    int i;
    if (locals == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " getinfo failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " get status failed: " + paramString + " status:" + locals.status);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    locals.status = 112;
    locals.hAh = bt.aGK();
    locals.hAg = bt.aGK();
    locals.dtM = 3328;
    if (!f(locals))
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + f.XJ() + " update failed: " + paramString);
      i = f.getLine();
      AppMethodBeat.o(127003);
      return 0 - i;
    }
    o.aCN().aDe();
    o.aCN().run();
    AppMethodBeat.o(127003);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.u
 * JD-Core Version:    0.7.0.1
 */