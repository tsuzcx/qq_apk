package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g
  extends m
  implements k
{
  private static int fVY = 32000;
  private final int MAX_TIMES;
  private String cHH;
  private com.tencent.mm.ai.f callback;
  boolean cgX;
  com.tencent.mm.compatible.util.g.a eMo;
  private boolean fFG;
  private String fFo;
  private com.tencent.mm.i.g.a fFy;
  public s fVD;
  private int fVF;
  private boolean fVG;
  private final long fVZ;
  private int fWa;
  private boolean fWb;
  private boolean fWc;
  private int fWd;
  private int fWe;
  int fWf;
  public String fileName;
  ap frx;
  int retCode;
  private com.tencent.mm.ai.b rr;
  private long startTime;
  
  public g(String paramString)
  {
    AppMethodBeat.i(50699);
    this.cHH = "";
    this.fVZ = 1800000L;
    this.retCode = 0;
    this.fVG = false;
    this.cgX = false;
    this.eMo = null;
    this.fFG = true;
    this.fFo = "";
    this.startTime = 0L;
    this.fWa = -1;
    this.fVF = com.tencent.mm.i.a.MediaType_VIDEO;
    this.fWb = false;
    this.fWc = false;
    this.fWd = 0;
    this.fWe = 0;
    this.fFy = new g.1(this);
    this.fWf = 0;
    this.frx = new ap(new g.2(this), true);
    boolean bool;
    if (paramString != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      ab.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      this.fVD = u.vr(paramString);
      if (this.fVD == null) {
        break label253;
      }
    }
    label253:
    for (this.MAX_TIMES = 2500;; this.MAX_TIMES = 0)
    {
      this.eMo = new com.tencent.mm.compatible.util.g.a();
      if ((this.fVD != null) && (3 == this.fVD.fXE)) {
        this.fVF = com.tencent.mm.i.a.MediaType_TinyVideo;
      }
      ab.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", new Object[] { alu(), Integer.valueOf(this.fVF) });
      AppMethodBeat.o(50699);
      return;
      bool = false;
      break;
    }
  }
  
  private boolean alt()
  {
    AppMethodBeat.i(50698);
    if (com.tencent.mm.model.t.oE(this.fVD.getUser()))
    {
      ab.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", new Object[] { alu(), this.fVD.getUser() });
      AppMethodBeat.o(50698);
      return false;
    }
    com.tencent.mm.al.f.afO();
    if ((!com.tencent.mm.al.b.lc(2)) && (this.fVD.fXC != 1))
    {
      localObject1 = alu();
      com.tencent.mm.al.f.afO();
      ab.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { localObject1, Boolean.valueOf(com.tencent.mm.al.b.lc(2)), Integer.valueOf(this.fVD.fXC) });
      AppMethodBeat.o(50698);
      return false;
    }
    this.fFo = com.tencent.mm.al.c.a("upvideo", this.fVD.createTime, this.fVD.getUser(), this.fVD.getFileName());
    if (bo.isNullOrNil(this.fFo))
    {
      ab.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { alu(), this.fVD.getFileName() });
      AppMethodBeat.o(50698);
      return false;
    }
    o.alE();
    Object localObject1 = t.vg(this.fileName);
    o.alE();
    String str2 = t.vf(this.fileName);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.edp = this.fFy;
    localg.field_mediaId = this.fFo;
    localg.field_fullpath = str2;
    localg.field_thumbpath = uU((String)localObject1);
    localg.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
    localg.field_enable_hitcheck = this.fFG;
    boolean bool1;
    label357:
    String str1;
    Object localObject3;
    if (com.tencent.mm.modelcontrol.d.afW().sO(str2))
    {
      i = 1;
      localg.field_largesvideo = i;
      if ((this.fVD != null) && (3 == this.fVD.fXE)) {
        localg.field_smallVideoFlag = 1;
      }
      localObject1 = alu();
      if (this.fVD.fXH != null) {
        break label718;
      }
      bool1 = true;
      ab.i("MicroMsg.NetSceneUploadVideo", "%s upload video MMSightExtInfo is null? %b %s", new Object[] { localObject1, Boolean.valueOf(bool1), this.fileName });
      if ((this.fVD.fXH != null) && (this.fVD.fXH.xra))
      {
        ab.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", new Object[] { alu() });
        localObject1 = n.alC();
        o.alE();
        ((n)localObject1).a("", t.vf(this.fileName), this.fVD.getUser(), "", "", 2, 2);
        com.tencent.mm.modelcontrol.d.afW();
        localg.field_largesvideo = com.tencent.mm.modelcontrol.d.b(com.tencent.mm.modelcontrol.d.afW().afX());
      }
      str1 = alu();
      localObject3 = this.fVD.getFileName();
      if (this.fVD.fXG != null) {
        break label724;
      }
      localObject1 = "null";
      label515:
      ab.i("MicroMsg.NetSceneUploadVideo", "%s checkAD file:%s adinfo:%s", new Object[] { str1, localObject3, localObject1 });
      if ((this.fVD.fXG != null) && (!bo.isNullOrNil(this.fVD.fXG.fiU))) {
        localg.field_advideoflag = 1;
      }
      localg.field_talker = this.fVD.getUser();
      if (!com.tencent.mm.model.t.lA(this.fVD.getUser())) {
        break label739;
      }
    }
    label718:
    label724:
    label739:
    for (int i = 1;; i = 0)
    {
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.ecF;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_trysafecdn = true;
      this.fWe = ((int)com.tencent.mm.vfs.e.avI(localg.field_fullpath));
      this.fWd = ((int)com.tencent.mm.vfs.e.avI(localg.field_thumbpath));
      if (this.fWd < com.tencent.mm.i.a.ecZ) {
        break label744;
      }
      ab.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { alu(), localg.field_thumbpath, Integer.valueOf(this.fWd) });
      AppMethodBeat.o(50698);
      return false;
      i = 0;
      break;
      bool1 = false;
      break label357;
      localObject1 = this.fVD.fXG.fiU;
      break label515;
    }
    label744:
    localObject1 = br.F(this.fVD.alP(), "msg");
    boolean bool2;
    label1179:
    int m;
    long l1;
    label1266:
    Object localObject2;
    label1284:
    label1439:
    label1445:
    label1451:
    label1457:
    label1463:
    label1469:
    label1475:
    Object localObject5;
    Object localObject4;
    label1885:
    int k;
    int j;
    label1948:
    int i2;
    if (localObject1 != null)
    {
      localg.field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localg.field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
      this.fWc = true;
      localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
      if (this.fWb)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).e(12696, new Object[] { Integer.valueOf(i + 700), Integer.valueOf(this.fVD.fsd) });
        if ((bo.isNullOrNil(localg.field_aesKey)) || (bo.isNullOrNil(localg.field_aesKey)))
        {
          localg.field_aesKey = "";
          localg.field_fileId = "";
        }
        ab.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", new Object[] { alu(), localg.field_mediaId, localg.field_fileId, localg.field_aesKey, Boolean.valueOf(this.fFG), Integer.valueOf(localg.field_largesvideo) });
        if (com.tencent.mm.al.f.afO().e(localg)) {
          break label2866;
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 226L, 1L, false);
        ab.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", new Object[] { alu() });
        this.fFo = "";
        AppMethodBeat.o(50698);
        return false;
      }
    }
    else
    {
      ab.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", new Object[] { alu() });
      int n;
      int i1;
      Vector localVector2;
      for (;;)
      {
        try
        {
          str1 = bo.nullAsNil(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("UseVideoHash"));
          localObject1 = str1.split(",");
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RJ();
          i = i.bQ(com.tencent.mm.kernel.a.getUin(), 100);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1445;
          }
          if (bo.getInt(localObject1[0], 0) < i) {
            break label1439;
          }
          bool1 = true;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label1457;
          }
          if (bo.getInt(localObject1[1], 0) < i) {
            break label1451;
          }
          bool2 = true;
          if ((localObject1 == null) || (localObject1.length < 3)) {
            break label1469;
          }
          if (bo.getInt(localObject1[2], 0) < i) {
            break label1463;
          }
          bool3 = true;
          if (!com.tencent.mm.sdk.a.b.dsf()) {
            break label2939;
          }
          bool1 = true;
          bool2 = true;
          bool3 = true;
          if (!bool2) {
            break label2843;
          }
          localObject3 = o.alE();
          m = bo.getInt(localObject1[2], 0);
          ab.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", new Object[] { Integer.valueOf(m), str2, bo.dtY() });
          l1 = bo.aoy();
          if (!bo.isNullOrNil(str2)) {
            break label1475;
          }
          ab.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", new Object[] { str2 });
          localObject1 = "";
          if (bo.isNullOrNil((String)localObject1)) {
            break label2843;
          }
          localObject1 = ((String)localObject1).split("##");
          if ((bool1) && (localObject1 != null) && (localObject1.length == 2))
          {
            localg.field_fileId = localObject1[0];
            localg.field_aesKey = localObject1[1];
            this.fWb = true;
          }
          ab.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", new Object[] { alu(), Boolean.valueOf(com.tencent.mm.sdk.a.b.dsf()), str1, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(this.fWb), localg.field_fileId, localg.field_aesKey });
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", new Object[] { bo.l(localException) });
        }
        break;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool2 = false;
        continue;
        bool2 = false;
        continue;
        boolean bool3 = false;
        continue;
        bool3 = false;
        continue;
        localObject2 = t.vi(str2);
        if ((localObject2 == null) || (localObject2.length < 33))
        {
          ab.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", new Object[] { str2 });
          localObject2 = "";
        }
        else
        {
          ((t)localObject3).fnw.execSQL("VideoHash", "delete from VideoHash where CreateTime < " + (bo.aox() - 432000L));
          n = localObject2[32];
          StringBuffer localStringBuffer = new StringBuffer();
          i = 0;
          while (i < 32)
          {
            localStringBuffer.append(Integer.toHexString(localObject2[i]));
            i += 1;
          }
          i1 = localStringBuffer.length();
          localObject5 = new Vector();
          localObject4 = new Vector();
          Vector localVector1 = new Vector();
          localVector2 = new Vector();
          i = -1;
          Cursor localCursor = ((t)localObject3).fnw.a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = ".concat(String.valueOf(n)), null, 0);
          while (localCursor.moveToNext())
          {
            l2 = localCursor.getLong(1);
            String str3 = localCursor.getString(2);
            String str4 = localCursor.getString(3);
            String str5 = localCursor.getString(4);
            ab.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", new Object[] { str3, str4 });
            if ((bo.isNullOrNil(str3)) || (bo.isNullOrNil(str4)))
            {
              com.tencent.mm.plugin.report.service.h.qsU.e(12696, new Object[] { Integer.valueOf(104), Integer.valueOf(n) });
              ab.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", new Object[] { str3, str4 });
            }
            else
            {
              if (i1 == str3.length()) {
                break label2954;
              }
              com.tencent.mm.plugin.report.service.h.qsU.e(12696, new Object[] { Integer.valueOf(105), Integer.valueOf(n) });
              ab.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(str3.length()) });
              continue;
              if (k < i1)
              {
                if (localStringBuffer.charAt(k) != str3.charAt(k)) {
                  break label2936;
                }
                j += 1;
                break label2961;
              }
              if ((i >= 0) && (localVector1.size() > i) && (((Integer)localVector1.get(i)).intValue() >= j)) {
                break label2933;
              }
              i = localVector1.size();
              localVector1.add(Integer.valueOf(j));
              ((Vector)localObject5).add(str4);
              ((Vector)localObject4).add(str5);
              localVector2.add(Long.valueOf(l2));
              ab.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i1), localVector1.get(i), Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            }
          }
          localCursor.close();
          if ((i < 0) || (localVector1.size() <= 0))
          {
            com.tencent.mm.plugin.report.service.h.qsU.e(12696, new Object[] { Integer.valueOf(201), Integer.valueOf(n) });
            ab.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            localObject2 = "";
          }
          else
          {
            i1 = ((Integer)localVector1.get(i)).intValue();
            i2 = i1 * 100 / 256;
            if (i2 < 77)
            {
              com.tencent.mm.plugin.report.service.h.qsU.e(12696, new Object[] { Integer.valueOf(202), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()) });
              ab.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", new Object[] { Long.valueOf(bo.hl(l1)), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(localObject2.length - 1), str2 });
              localObject2 = "";
            }
            else
            {
              localObject2 = bo.nullAsNil((String)((Vector)localObject5).get(i));
              j = 0;
              k = 0;
              label2299:
              if (k < localVector1.size())
              {
                if ((k == i) || (((Integer)localVector1.get(k)).intValue() < i1) || (((String)localObject2).hashCode() == ((String)((Vector)localObject5).get(k)).hashCode())) {
                  break label2930;
                }
                j += 1;
                break label2968;
              }
              if (j <= 0) {
                break label2506;
              }
              ((t)localObject3).fnw.execSQL("VideoHash", "delete from VideoHash where size = ".concat(String.valueOf(n)));
              com.tencent.mm.plugin.report.service.h.qsU.e(12696, new Object[] { Integer.valueOf(203), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(j) });
              ab.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", new Object[] { Integer.valueOf(j), str2 });
              localObject2 = "";
            }
          }
        }
      }
      label2506:
      l1 = bo.hl(l1);
      long l2 = bo.a((Long)localVector2.get(i), 0L);
      localObject5 = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(localVector2.size()), Long.valueOf(l1) });
      com.tencent.mm.plugin.report.service.h.qsU.e(12696, new Object[] { Integer.valueOf(300), localObject5 });
      com.tencent.mm.plugin.report.service.h.qsU.e(12696, new Object[] { Integer.valueOf(i2 + 3000), localObject5 });
      ab.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Long.valueOf(l2), str2, localObject2, ((Vector)localObject4).get(i) });
      localObject4 = (String)((Vector)localObject4).get(i);
      l1 = bo.aoy() % 1000L;
      if (l1 < m * 10) {
        break label2975;
      }
      if (i2 < 90) {
        break label2975;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", new Object[] { Boolean.valueOf(bool4), Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(i2), Boolean.valueOf(com.tencent.mm.sdk.a.b.dsf()) });
      if ((bool4) || (com.tencent.mm.sdk.a.b.dsf())) {
        com.tencent.mm.sdk.g.d.f(new t.2((t)localObject3, str2, (String)localObject4, (String)localObject5), "checkVideoHashByteDiff");
      }
      break label1266;
      boolean bool4 = false;
      continue;
      label2843:
      localObject2 = null;
      break label1284;
      if (this.fWc)
      {
        i = 2;
        break;
      }
      i = 0;
      break;
      label2866:
      if (this.fVD.fXC != 1)
      {
        this.fVD.fXC = 1;
        this.fVD.status = 104;
        this.fVD.clientId = this.fFo;
        this.fVD.bsY = 524544;
        u.f(this.fVD);
      }
      AppMethodBeat.o(50698);
      return true;
      label2930:
      break label2968;
      label2933:
      break label1948;
      label2936:
      break label2961;
      label2939:
      bool4 = bool1;
      bool1 = bool2;
      bool2 = bool4;
      break label1179;
      label2954:
      j = 0;
      k = 0;
      break label1885;
      label2961:
      k += 1;
      break label1885;
      label2968:
      k += 1;
      break label2299;
      label2975:
      bool4 = true;
    }
  }
  
  private String alu()
  {
    AppMethodBeat.i(50706);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(50706);
    return str;
  }
  
  /* Error */
  private String uU(String paramString)
  {
    // Byte code:
    //   0: ldc_w 759
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 761	com/tencent/mm/vfs/b
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 762	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   14: astore 9
    //   16: new 761	com/tencent/mm/vfs/b
    //   19: dup
    //   20: aload 9
    //   22: invokevirtual 766	com/tencent/mm/vfs/b:dQI	()Lcom/tencent/mm/vfs/b;
    //   25: new 541	java/lang/StringBuilder
    //   28: dup
    //   29: ldc_w 768
    //   32: invokespecial 545	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload 9
    //   37: invokevirtual 771	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   40: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 557	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 774	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 7
    //   54: aconst_null
    //   55: astore 8
    //   57: aconst_null
    //   58: astore 5
    //   60: aconst_null
    //   61: astore 6
    //   63: ldc 122
    //   65: ldc_w 776
    //   68: iconst_1
    //   69: anewarray 167	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload 9
    //   76: invokevirtual 778	com/tencent/mm/vfs/b:length	()J
    //   79: invokestatic 631	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   82: aastore
    //   83: invokestatic 635	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload 9
    //   88: invokevirtual 778	com/tencent/mm/vfs/b:length	()J
    //   91: ldc2_w 779
    //   94: lcmp
    //   95: ifle +584 -> 679
    //   98: aload 10
    //   100: invokevirtual 783	com/tencent/mm/vfs/b:exists	()Z
    //   103: ifeq +122 -> 225
    //   106: ldc 122
    //   108: ldc_w 785
    //   111: iconst_1
    //   112: anewarray 167	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload 10
    //   119: invokevirtual 789	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   122: invokestatic 795	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   125: aastore
    //   126: invokestatic 635	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: iconst_1
    //   130: istore_2
    //   131: aload 8
    //   133: astore 4
    //   135: aload 6
    //   137: astore 5
    //   139: aload 4
    //   141: ifnull +8 -> 149
    //   144: aload 4
    //   146: invokevirtual 798	java/io/InputStream:close	()V
    //   149: iload_2
    //   150: istore_3
    //   151: aload 5
    //   153: ifnull +10 -> 163
    //   156: aload 5
    //   158: invokevirtual 801	java/io/OutputStream:close	()V
    //   161: iload_2
    //   162: istore_3
    //   163: iload_3
    //   164: ifeq +396 -> 560
    //   167: ldc 122
    //   169: ldc_w 803
    //   172: iconst_3
    //   173: anewarray 167	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokespecial 171	com/tencent/mm/modelvideo/g:alu	()Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload 10
    //   187: invokevirtual 778	com/tencent/mm/vfs/b:length	()J
    //   190: invokestatic 631	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   193: aastore
    //   194: dup
    //   195: iconst_2
    //   196: aload 10
    //   198: invokevirtual 789	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   201: invokestatic 795	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   204: aastore
    //   205: invokestatic 179	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload 10
    //   210: invokevirtual 789	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   213: invokestatic 795	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   216: astore_1
    //   217: ldc_w 759
    //   220: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload_1
    //   224: areturn
    //   225: aload 9
    //   227: invokevirtual 789	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   230: invokestatic 795	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   233: invokestatic 809	com/tencent/mm/sdk/platformtools/d:aoT	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   236: astore 11
    //   238: aload 11
    //   240: ifnonnull +121 -> 361
    //   243: ldc_w 342
    //   246: astore 4
    //   248: ldc 122
    //   250: ldc_w 811
    //   253: iconst_1
    //   254: anewarray 167	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload 4
    //   261: aastore
    //   262: invokestatic 179	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload 11
    //   267: ifnull +131 -> 398
    //   270: aload 11
    //   272: getfield 816	android/graphics/BitmapFactory$Options:outWidth	I
    //   275: sipush 288
    //   278: if_icmpgt +14 -> 292
    //   281: aload 11
    //   283: getfield 819	android/graphics/BitmapFactory$Options:outHeight	I
    //   286: sipush 288
    //   289: if_icmple +109 -> 398
    //   292: aload 9
    //   294: invokevirtual 789	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   297: invokestatic 795	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   300: sipush 288
    //   303: sipush 288
    //   306: getstatic 825	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   309: bipush 60
    //   311: new 541	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 696	java/lang/StringBuilder:<init>	()V
    //   318: aload 10
    //   320: invokevirtual 766	com/tencent/mm/vfs/b:dQI	()Lcom/tencent/mm/vfs/b;
    //   323: invokevirtual 789	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   326: invokestatic 795	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   329: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc_w 827
    //   335: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 557	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: aload 10
    //   343: invokevirtual 771	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   346: invokestatic 830	com/tencent/mm/sdk/platformtools/d:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   349: istore_2
    //   350: aload 6
    //   352: astore 5
    //   354: aload 8
    //   356: astore 4
    //   358: goto -219 -> 139
    //   361: new 541	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 696	java/lang/StringBuilder:<init>	()V
    //   368: aload 11
    //   370: getfield 816	android/graphics/BitmapFactory$Options:outWidth	I
    //   373: invokevirtual 705	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 832
    //   379: invokevirtual 699	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload 11
    //   384: getfield 819	android/graphics/BitmapFactory$Options:outHeight	I
    //   387: invokevirtual 705	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: invokevirtual 557	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: astore 4
    //   395: goto -147 -> 248
    //   398: aload 9
    //   400: invokestatic 836	com/tencent/mm/vfs/e:q	(Lcom/tencent/mm/vfs/b;)Ljava/io/InputStream;
    //   403: astore 4
    //   405: aload 4
    //   407: fconst_0
    //   408: sipush 288
    //   411: sipush 288
    //   414: invokestatic 839	com/tencent/mm/sdk/platformtools/d:a	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   417: astore 8
    //   419: aload 8
    //   421: ifnull +249 -> 670
    //   424: aload 10
    //   426: invokestatic 843	com/tencent/mm/vfs/e:r	(Lcom/tencent/mm/vfs/b;)Ljava/io/OutputStream;
    //   429: astore 6
    //   431: aload 6
    //   433: astore 5
    //   435: aload 5
    //   437: astore 7
    //   439: aload 4
    //   441: astore 6
    //   443: aload 8
    //   445: getstatic 825	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   448: bipush 60
    //   450: aload 5
    //   452: invokevirtual 849	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   455: istore_2
    //   456: goto -317 -> 139
    //   459: astore 8
    //   461: aconst_null
    //   462: astore 5
    //   464: aconst_null
    //   465: astore 4
    //   467: aload 5
    //   469: astore 7
    //   471: aload 4
    //   473: astore 6
    //   475: ldc 122
    //   477: ldc_w 851
    //   480: iconst_1
    //   481: anewarray 167	java/lang/Object
    //   484: dup
    //   485: iconst_0
    //   486: aload 8
    //   488: invokestatic 527	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   491: aastore
    //   492: invokestatic 444	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: aload 4
    //   497: ifnull +8 -> 505
    //   500: aload 4
    //   502: invokevirtual 798	java/io/InputStream:close	()V
    //   505: aload 5
    //   507: ifnull +158 -> 665
    //   510: aload 5
    //   512: invokevirtual 801	java/io/OutputStream:close	()V
    //   515: iconst_0
    //   516: istore_3
    //   517: goto -354 -> 163
    //   520: astore 4
    //   522: iconst_0
    //   523: istore_3
    //   524: goto -361 -> 163
    //   527: astore_1
    //   528: aload 7
    //   530: astore 4
    //   532: aload 4
    //   534: ifnull +8 -> 542
    //   537: aload 4
    //   539: invokevirtual 798	java/io/InputStream:close	()V
    //   542: aload 5
    //   544: ifnull +8 -> 552
    //   547: aload 5
    //   549: invokevirtual 801	java/io/OutputStream:close	()V
    //   552: ldc_w 759
    //   555: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: aload_1
    //   559: athrow
    //   560: ldc 122
    //   562: ldc_w 853
    //   565: iconst_3
    //   566: anewarray 167	java/lang/Object
    //   569: dup
    //   570: iconst_0
    //   571: aload_0
    //   572: invokespecial 171	com/tencent/mm/modelvideo/g:alu	()Ljava/lang/String;
    //   575: aastore
    //   576: dup
    //   577: iconst_1
    //   578: aload 9
    //   580: invokevirtual 778	com/tencent/mm/vfs/b:length	()J
    //   583: invokestatic 631	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   586: aastore
    //   587: dup
    //   588: iconst_2
    //   589: aload 9
    //   591: invokevirtual 789	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   594: invokestatic 795	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   597: aastore
    //   598: invokestatic 179	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   601: ldc_w 759
    //   604: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   607: aload_1
    //   608: areturn
    //   609: astore 4
    //   611: goto -462 -> 149
    //   614: astore 4
    //   616: iload_2
    //   617: istore_3
    //   618: goto -455 -> 163
    //   621: astore 4
    //   623: goto -118 -> 505
    //   626: astore 4
    //   628: goto -86 -> 542
    //   631: astore 4
    //   633: goto -81 -> 552
    //   636: astore_1
    //   637: goto -105 -> 532
    //   640: astore_1
    //   641: aload 7
    //   643: astore 5
    //   645: aload 6
    //   647: astore 4
    //   649: goto -117 -> 532
    //   652: astore 8
    //   654: aconst_null
    //   655: astore 5
    //   657: goto -190 -> 467
    //   660: astore 8
    //   662: goto -195 -> 467
    //   665: iconst_0
    //   666: istore_3
    //   667: goto -504 -> 163
    //   670: iconst_0
    //   671: istore_2
    //   672: aload 6
    //   674: astore 5
    //   676: goto -537 -> 139
    //   679: iconst_0
    //   680: istore_2
    //   681: aload 6
    //   683: astore 5
    //   685: aload 8
    //   687: astore 4
    //   689: goto -550 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	692	0	this	g
    //   0	692	1	paramString	String
    //   130	551	2	bool1	boolean
    //   150	517	3	bool2	boolean
    //   133	368	4	localObject1	Object
    //   520	1	4	localIOException1	java.io.IOException
    //   530	8	4	localObject2	Object
    //   609	1	4	localIOException2	java.io.IOException
    //   614	1	4	localIOException3	java.io.IOException
    //   621	1	4	localIOException4	java.io.IOException
    //   626	1	4	localIOException5	java.io.IOException
    //   631	1	4	localIOException6	java.io.IOException
    //   647	41	4	localObject3	Object
    //   58	626	5	localObject4	Object
    //   61	621	6	localObject5	Object
    //   52	590	7	localObject6	Object
    //   55	389	8	localBitmap	android.graphics.Bitmap
    //   459	28	8	localException1	Exception
    //   652	1	8	localException2	Exception
    //   660	26	8	localException3	Exception
    //   14	576	9	localb1	com.tencent.mm.vfs.b
    //   49	376	10	localb2	com.tencent.mm.vfs.b
    //   236	147	11	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   86	129	459	java/lang/Exception
    //   225	238	459	java/lang/Exception
    //   248	265	459	java/lang/Exception
    //   270	292	459	java/lang/Exception
    //   292	350	459	java/lang/Exception
    //   361	395	459	java/lang/Exception
    //   398	405	459	java/lang/Exception
    //   510	515	520	java/io/IOException
    //   86	129	527	finally
    //   225	238	527	finally
    //   248	265	527	finally
    //   270	292	527	finally
    //   292	350	527	finally
    //   361	395	527	finally
    //   398	405	527	finally
    //   144	149	609	java/io/IOException
    //   156	161	614	java/io/IOException
    //   500	505	621	java/io/IOException
    //   537	542	626	java/io/IOException
    //   547	552	631	java/io/IOException
    //   405	419	636	finally
    //   424	431	636	finally
    //   443	456	640	finally
    //   475	495	640	finally
    //   405	419	652	java/lang/Exception
    //   424	431	652	java/lang/Exception
    //   443	456	660	java/lang/Exception
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(50697);
    ab.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", new Object[] { alu(), this.fFo });
    if (!bo.isNullOrNil(this.fFo)) {
      com.tencent.mm.al.f.afO().sI(this.fFo);
    }
    this.fVG = true;
    super.cancel();
    AppMethodBeat.o(50697);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(50700);
    this.callback = paramf;
    this.fVD = u.vr(this.fileName);
    if ((this.fVD == null) || ((this.fVD.status != 104) && (this.fVD.status != 103)))
    {
      ab.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", new Object[] { alu(), this.fileName });
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(50700);
      return -1;
    }
    paramf = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.fVD.status).append(" [").append(this.fVD.fXt).append(",").append(this.fVD.fXu).append("] [").append(this.fVD.fWa).append(",").append(this.fVD.fsd).append("]  netTimes:").append(this.fVD.fXz).append(" times:");
    int i = this.fWf;
    this.fWf = (i + 1);
    ab.d("MicroMsg.NetSceneUploadVideo", i);
    if (this.startTime == 0L)
    {
      this.startTime = bo.aoy();
      this.fWa = this.fVD.fWa;
    }
    o.alE();
    if (r.uZ(t.vf(this.fileName)))
    {
      ab.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", new Object[] { alu(), this.fVD.alP() });
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 139L, 1L, false);
    }
    if (alt())
    {
      ab.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(50700);
      return 0;
    }
    cov localcov;
    if (this.fVD.fXB == 1)
    {
      this.cgX = true;
      paramf = new b.a();
      paramf.fsX = new cov();
      paramf.fsY = new cow();
      paramf.uri = "/cgi-bin/micromsg-bin/uploadvideo";
      paramf.funcId = 149;
      paramf.reqCmdId = 39;
      paramf.respCmdId = 1000000039;
      this.rr = paramf.ado();
      localcov = (cov)this.rr.fsV.fta;
      localcov.num = ((String)com.tencent.mm.kernel.g.RL().Ru().get(2, ""));
      localcov.nul = this.fVD.getUser();
      localcov.wpS = this.fileName;
      if (this.cgX) {
        localcov.wxV = 2;
      }
      if (this.fVD.fXE == 3) {
        localcov.wxV = 3;
      }
      localcov.xMz = this.fVD.fXx;
      localcov.xrD = this.fVD.fXu;
      localcov.xXy = this.fVD.fsd;
      if (!ac.cm(ah.getContext())) {
        break label1190;
      }
      i = 1;
      label583:
      localcov.wPR = i;
      localcov.xrG = 2;
      localcov.xXz = 0;
      localcov.xXA = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      localcov.xrF = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      if (!bo.isNullOrNil(this.cHH)) {
        break label1195;
      }
      o.alE();
      paramf = com.tencent.mm.vfs.e.avP(t.vf(this.fileName));
      this.cHH = paramf;
      label667:
      localcov.xXD = paramf;
      localcov.woU = bh.aaQ();
      localcov.xXM = this.fVD.cGU;
      paramf = this.fVD.fXG;
      if ((paramf == null) || (bo.isNullOrNil(paramf.fiO))) {
        break label1203;
      }
      localcov.xXE = bo.bf(paramf.fiO, "");
      localcov.xXF = paramf.wUJ;
      localcov.xXG = bo.bf(paramf.fiQ, "");
      localcov.xXI = bo.bf(paramf.fiS, "");
      localcov.xXH = bo.bf(paramf.fiR, "");
      localcov.xXJ = bo.bf(paramf.fiT, "");
    }
    for (;;)
    {
      if (paramf != null)
      {
        localcov.xXL = bo.bf(paramf.fiU, "");
        localcov.xXK = bo.bf(paramf.fiV, "");
      }
      ab.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", new Object[] { Integer.valueOf(localcov.xMz), Integer.valueOf(localcov.xrE), Integer.valueOf(localcov.xXy), Integer.valueOf(localcov.wxV), localcov.xXD, localcov.xXE, Integer.valueOf(localcov.xXF), localcov.xXG, localcov.xXJ });
      if (this.fVD.status != 103) {
        break label1496;
      }
      o.alE();
      paramf = t.u(t.vg(this.fileName), this.fVD.fXt, fVY);
      if ((paramf.ret >= 0) && (paramf.ckj != 0)) {
        break label1248;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 225L, 1L, false);
      u.vk(this.fileName);
      ab.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(50700);
      return -1;
      if (this.fVD.createTime + 600L < bo.aox())
      {
        ab.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
        u.vk(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        AppMethodBeat.o(50700);
        return -1;
      }
      if (u.vj(this.fileName)) {
        break;
      }
      ab.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
      u.vk(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(50700);
      return -1;
      label1190:
      i = 2;
      break label583;
      label1195:
      paramf = this.cHH;
      break label667;
      label1203:
      if ((paramf != null) && (!bo.isNullOrNil(paramf.fiS)) && (!bo.isNullOrNil(paramf.fiR)))
      {
        localcov.xXI = paramf.fiS;
        localcov.xXH = paramf.fiR;
      }
    }
    label1248:
    ab.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.ckj + " newOff:" + paramf.fXX + " netOff:" + this.fVD.fXt);
    if (paramf.fXX < this.fVD.fXt)
    {
      ab.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + paramf.fXX + " OldtOff:" + this.fVD.fXt);
      u.vk(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(50700);
      return -1;
    }
    byte[] arrayOfByte = new byte[paramf.ckj];
    System.arraycopy(paramf.buf, 0, arrayOfByte, 0, paramf.ckj);
    localcov.xrE = this.fVD.fXt;
    localcov.xrF = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    for (;;)
    {
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(50700);
      return i;
      label1496:
      o.alE();
      paramf = t.u(t.vf(this.fileName), this.fVD.fWa, fVY);
      if ((paramf.ret < 0) || (paramf.ckj == 0))
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 224L, 1L, false);
        u.vk(this.fileName);
        ab.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        AppMethodBeat.o(50700);
        return -1;
      }
      ab.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.ckj + " newOff:" + paramf.fXX + " netOff:" + this.fVD.fWa);
      if (paramf.fXX < this.fVD.fWa)
      {
        ab.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + paramf.fXX + " OldtOff:" + this.fVD.fWa);
        u.vk(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        AppMethodBeat.o(50700);
        return -1;
      }
      if (paramf.fXX >= c.fUY)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 222L, 1L, false);
        ab.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.fUY);
        u.vk(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        AppMethodBeat.o(50700);
        return -1;
      }
      arrayOfByte = new byte[paramf.ckj];
      System.arraycopy(paramf.buf, 0, arrayOfByte, 0, paramf.ckj);
      localcov.xXz = this.fVD.fWa;
      localcov.xrE = this.fVD.fXt;
      localcov.xXA = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
    }
  }
  
  public final long getReturnTimeout()
  {
    return 1800000L;
  }
  
  public final int getType()
  {
    return 149;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50704);
    ab.d("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.fFo);
    if (this.fVG)
    {
      ab.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.fVD.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bo.isNullOrNil(this.fFo)))
    {
      ab.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.fFo });
      AppMethodBeat.o(50704);
      return;
    }
    paramArrayOfByte = (cow)((com.tencent.mm.ai.b)paramq).fsW.fta;
    paramq = (cov)((com.tencent.mm.ai.b)paramq).fsV.fta;
    this.fVD = u.vr(this.fileName);
    if (this.fVD == null)
    {
      ab.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
    }
    if (this.fVD.status == 105)
    {
      ab.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
    }
    if ((this.fVD.status != 104) && (this.fVD.status != 103))
    {
      ab.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.fVD.status + " [" + this.fileName + "," + this.fVD.cFn + "," + this.fVD.alM() + "," + this.fVD.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      ab.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.fVD.getUser());
      u.vl(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 220L, 1L, false);
      ab.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.fVD.getUser());
      u.vk(this.fileName);
      com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fVF), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 219L, 1L, false);
      ab.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.fVD.getUser());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
    }
    if ((!bo.ce(paramq.xrF.getBuffer().pW)) && (paramq.xrE != paramArrayOfByte.xrE - paramq.xrF.getILen()))
    {
      ab.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramq.xrE + "," + paramq.xrF.getILen() + "," + paramArrayOfByte.xrE + "] file:" + this.fileName + " user:" + paramq.nul);
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
    }
    if ((!bo.ce(paramq.xXA.getBuffer().pW)) && (paramq.xXz != paramArrayOfByte.xXz - paramq.xXA.getILen()))
    {
      ab.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramq.xXz + "," + paramq.xXA.getILen() + "," + paramArrayOfByte.xXz + "] file:" + this.fileName + " user:" + paramq.nul);
      u.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
    }
    this.fVD.fXv = bo.aox();
    this.fVD.cFn = paramArrayOfByte.pIG;
    this.fVD.bsY = 1028;
    ab.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(this.fVD.cFn), Integer.valueOf(ae.gkL) });
    if ((10007 == ae.gkK) && (ae.gkL != 0) && (this.fVD.cFn != 0L))
    {
      this.fVD.cFn = ae.gkL;
      ae.gkL = 0;
    }
    int i = 0;
    paramInt1 = this.fVD.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.fVD;
      paramInt1 = paramq.xrE;
      paramArrayOfByte.fXt = (paramq.xrF.getILen() + paramInt1);
      this.fVD.bsY |= 0x40;
      paramInt1 = i;
      if (this.fVD.fXt >= this.fVD.fXu)
      {
        this.fVD.status = 104;
        this.fVD.bsY |= 0x100;
        paramInt1 = i;
      }
    }
    for (;;)
    {
      u.f(this.fVD);
      if (!this.fVG) {
        break label1669;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
      if (paramInt1 != 104) {
        break;
      }
      paramArrayOfByte = this.fVD;
      paramInt1 = paramq.xXz;
      paramArrayOfByte.fWa = (paramq.xXA.getILen() + paramInt1);
      this.fVD.bsY |= 0x8;
      paramInt1 = i;
      if (this.fVD.fWa >= this.fVD.fsd)
      {
        this.fVD.status = 199;
        this.fVD.bsY |= 0x100;
        u.d(this.fVD);
        paramInt1 = 1;
      }
    }
    ab.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + paramInt1 + " file:" + this.fileName + " user:" + paramq.nul);
    u.vk(this.fileName);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(50704);
    return;
    label1669:
    if (paramInt1 == 0)
    {
      this.frx.ag(10L, 10L);
      AppMethodBeat.o(50704);
      return;
    }
    paramq = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.fVD.fXy);
    com.tencent.mm.modelstat.b.fRu.j(paramq);
    com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fVF), Integer.valueOf(this.fVD.fsd - this.fWa) });
    boolean bool;
    if (this.fVD == null)
    {
      bool = false;
      if ((!bool) && (!com.tencent.mm.model.t.og(this.fVD.getUser()))) {
        break label2212;
      }
      ab.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", new Object[] { this.fVD.getUser() });
      if (this.fVD.cFn < 0L)
      {
        ab.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.fVD.cFn + " file:" + this.fileName + " toUser:" + this.fVD.getUser());
        u.vk(this.fileName);
      }
      label1945:
      if (this.eMo == null) {
        break label2300;
      }
    }
    label2212:
    label2300:
    for (long l = this.eMo.Mm();; l = 0L)
    {
      ab.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.fVD.getUser() + " msgsvrid:" + this.fVD.cFn + " thumbsize:" + this.fVD.fXu + " videosize:" + this.fVD.fsd + " useTime:" + l);
      ab.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + fVY + " filesize:" + this.fVD.fsd + " useTime:" + l);
      a.a(this.fVD, 0);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(50704);
      return;
      paramq = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(this.fVD.getUser());
      if ((paramq == null) || ((int)paramq.euF <= 0))
      {
        bool = false;
        break;
      }
      bool = paramq.dwz();
      break;
      ab.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
      if (this.fVD.cFn > 0L) {
        break label1945;
      }
      ab.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.fVD.cFn + " file:" + this.fileName + " toUser:" + this.fVD.getUser());
      u.vk(this.fileName);
      break label1945;
    }
  }
  
  public final int securityLimitCount()
  {
    return this.MAX_TIMES;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(50703);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(50703);
    return bool;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(50701);
    paramq = (cov)((com.tencent.mm.ai.b)paramq).fsV.fta;
    if ((bo.isNullOrNil(paramq.wpS)) || (paramq.xrG <= 0) || (bo.isNullOrNil(paramq.num)) || (bo.isNullOrNil(paramq.nul)) || (paramq.wPR <= 0) || (paramq.xrE > paramq.xrD) || (paramq.xrE < 0) || (paramq.xXz > paramq.xXy) || (paramq.xXz < 0) || ((paramq.xXz == paramq.xXy) && (paramq.xrE == paramq.xrD)) || (paramq.xrD <= 0) || (paramq.xXy <= 0) || ((paramq.xXA.getILen() <= 0) && (paramq.xrF.getILen() <= 0)))
    {
      ab.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + paramq.nul);
      paramq = m.b.ftv;
      AppMethodBeat.o(50701);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(50701);
    return paramq;
  }
  
  public final void setSecurityCheckError(m.a parama)
  {
    AppMethodBeat.i(50702);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 221L, 1L, false);
    u.vk(this.fileName);
    AppMethodBeat.o(50702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g
 * JD-Core Version:    0.7.0.1
 */