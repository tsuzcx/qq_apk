package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.protocal.c.cbp;
import com.tencent.mm.protocal.c.cbq;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
  private static int eGh = 32000;
  private final int MAX_TIMES;
  private String bZs = "";
  private com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private s eFM;
  private int eFO = com.tencent.mm.j.a.MediaType_VIDEO;
  private boolean eFP = false;
  private final long eGi = 1800000L;
  boolean eGj = false;
  private int eGk = -1;
  private boolean eGl = false;
  private boolean eGm = false;
  private int eGn = 0;
  private int eGo = 0;
  int eGp = 0;
  am ebj = new am(new g.2(this), true);
  private String eoQ = "";
  private f.a epa = new g.1(this);
  private boolean epi = true;
  g.a esm = null;
  String fileName;
  int retCode = 0;
  private long startTime = 0L;
  
  public g(String paramString)
  {
    boolean bool;
    if (paramString != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      y.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:" + paramString);
      this.fileName = paramString;
      this.eFM = u.oe(paramString);
      if (this.eFM == null) {
        break label250;
      }
    }
    label250:
    for (this.MAX_TIMES = 2500;; this.MAX_TIMES = 0)
    {
      this.esm = new g.a();
      if ((this.eFM != null) && (3 == this.eFM.eHO)) {
        this.eFO = com.tencent.mm.j.a.MediaType_TinyVideo;
      }
      y.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", new Object[] { Sj(), Integer.valueOf(this.eFO) });
      return;
      bool = false;
      break;
    }
  }
  
  private boolean Si()
  {
    if (com.tencent.mm.model.s.hV(this.eFM.SA()))
    {
      y.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", new Object[] { Sj(), this.eFM.SA() });
      return false;
    }
    com.tencent.mm.ak.f.Nd();
    if ((!com.tencent.mm.ak.b.iq(2)) && (this.eFM.eHM != 1))
    {
      localObject1 = Sj();
      com.tencent.mm.ak.f.Nd();
      y.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { localObject1, Boolean.valueOf(com.tencent.mm.ak.b.iq(2)), Integer.valueOf(this.eFM.eHM) });
      return false;
    }
    this.eoQ = com.tencent.mm.ak.c.a("upvideo", this.eFM.createTime, this.eFM.SA(), this.eFM.getFileName());
    if (bk.bl(this.eoQ))
    {
      y.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { Sj(), this.eFM.getFileName() });
      return false;
    }
    o.Sr();
    Object localObject1 = t.nT(this.fileName);
    o.Sr();
    String str2 = t.nS(this.fileName);
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.dlP = this.epa;
    localf.field_mediaId = this.eoQ;
    localf.field_fullpath = str2;
    localf.field_thumbpath = nH((String)localObject1);
    localf.field_fileType = com.tencent.mm.j.a.MediaType_VIDEO;
    localf.field_enable_hitcheck = this.epi;
    boolean bool1;
    label336:
    String str1;
    Object localObject3;
    if (d.Nl().lQ(str2))
    {
      i = 1;
      localf.field_largesvideo = i;
      if ((this.eFM != null) && (3 == this.eFM.eHO)) {
        localf.field_smallVideoFlag = 1;
      }
      localObject1 = Sj();
      if (this.eFM.eHR != null) {
        break label692;
      }
      bool1 = true;
      y.i("MicroMsg.NetSceneUploadVideo", "%s upload video MMSightExtInfo is null? %b %s", new Object[] { localObject1, Boolean.valueOf(bool1), this.fileName });
      if ((this.eFM.eHR != null) && (this.eFM.eHR.tra))
      {
        y.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", new Object[] { Sj() });
        localObject1 = n.Sp();
        o.Sr();
        ((n)localObject1).a("", t.nS(this.fileName), this.eFM.SA(), "", "", 2, 2);
        d.Nl();
        localf.field_largesvideo = d.a(d.Nl().Nm());
      }
      str1 = Sj();
      localObject3 = this.eFM.getFileName();
      if (this.eFM.eHQ != null) {
        break label698;
      }
      localObject1 = "null";
      label494:
      y.i("MicroMsg.NetSceneUploadVideo", "%s checkAD file:%s adinfo:%s", new Object[] { str1, localObject3, localObject1 });
      if ((this.eFM.eHQ != null) && (!bk.bl(this.eFM.eHQ.dSV))) {
        localf.field_advideoflag = 1;
      }
      localf.field_talker = this.eFM.SA();
      if (!com.tencent.mm.model.s.fn(this.eFM.SA())) {
        break label713;
      }
    }
    label692:
    label698:
    label713:
    for (int i = 1;; i = 0)
    {
      localf.field_chattype = i;
      localf.field_priority = com.tencent.mm.j.a.dlk;
      localf.field_needStorage = false;
      localf.field_isStreamMedia = false;
      localf.field_trysafecdn = true;
      this.eGo = ((int)com.tencent.mm.vfs.e.aeQ(localf.field_fullpath));
      this.eGn = ((int)com.tencent.mm.vfs.e.aeQ(localf.field_thumbpath));
      if (this.eGn < com.tencent.mm.j.a.dlE) {
        break label718;
      }
      y.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { Sj(), localf.field_thumbpath, Integer.valueOf(this.eGn) });
      return false;
      i = 0;
      break;
      bool1 = false;
      break label336;
      localObject1 = this.eFM.eHQ.dSV;
      break label494;
    }
    label718:
    localObject1 = bn.s(this.eFM.SD(), "msg");
    boolean bool2;
    label1148:
    int m;
    long l1;
    label1235:
    label1253:
    Object localObject2;
    label1408:
    label1414:
    label1420:
    label1426:
    label1432:
    label1438:
    label1444:
    Object localObject5;
    Object localObject4;
    label1861:
    int k;
    int j;
    label1924:
    int i2;
    if (localObject1 != null)
    {
      localf.field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localf.field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
      this.eGm = true;
      localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
      if (this.eGl)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(12696, new Object[] { Integer.valueOf(i + 700), Integer.valueOf(this.eFM.ebK) });
        if ((bk.bl(localf.field_aesKey)) || (bk.bl(localf.field_aesKey)))
        {
          localf.field_aesKey = "";
          localf.field_fileId = "";
        }
        y.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", new Object[] { Sj(), localf.field_mediaId, localf.field_fileId, localf.field_aesKey, Boolean.valueOf(this.epi), Integer.valueOf(localf.field_largesvideo) });
        if (com.tencent.mm.ak.f.Nd().c(localf)) {
          break label2850;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 226L, 1L, false);
        y.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", new Object[] { Sj() });
        this.eoQ = "";
        return false;
      }
    }
    else
    {
      y.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", new Object[] { Sj() });
      int n;
      int i1;
      Vector localVector2;
      for (;;)
      {
        try
        {
          str1 = bk.pm(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("UseVideoHash"));
          localObject1 = str1.split(",");
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DN();
          i = com.tencent.mm.a.h.aT(com.tencent.mm.kernel.a.CK(), 100);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1414;
          }
          if (bk.getInt(localObject1[0], 0) < i) {
            break label1408;
          }
          bool1 = true;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label1426;
          }
          if (bk.getInt(localObject1[1], 0) < i) {
            break label1420;
          }
          bool2 = true;
          if ((localObject1 == null) || (localObject1.length < 3)) {
            break label1438;
          }
          if (bk.getInt(localObject1[2], 0) < i) {
            break label1432;
          }
          bool3 = true;
          if (!com.tencent.mm.sdk.a.b.cqk()) {
            break label2918;
          }
          bool1 = true;
          bool2 = true;
          bool3 = true;
          if (!bool2) {
            break label2827;
          }
          localObject3 = o.Sr();
          m = bk.getInt(localObject1[2], 0);
          y.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", new Object[] { Integer.valueOf(m), str2, bk.csb() });
          l1 = bk.UY();
          if (!bk.bl(str2)) {
            break label1444;
          }
          y.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", new Object[] { str2 });
          localObject1 = "";
          if (bk.bl((String)localObject1)) {
            break label2827;
          }
          localObject1 = ((String)localObject1).split("##");
          if ((bool1) && (localObject1 != null) && (localObject1.length == 2))
          {
            localf.field_fileId = localObject1[0];
            localf.field_aesKey = localObject1[1];
            this.eGl = true;
          }
          y.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", new Object[] { Sj(), Boolean.valueOf(com.tencent.mm.sdk.a.b.cqk()), str1, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(this.eGl), localf.field_fileId, localf.field_aesKey });
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", new Object[] { bk.j(localException) });
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
        localObject2 = t.nV(str2);
        if ((localObject2 == null) || (localObject2.length < 33))
        {
          y.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", new Object[] { str2 });
          localObject2 = "";
        }
        else
        {
          ((t)localObject3).dXo.gk("VideoHash", "delete from VideoHash where CreateTime < " + (bk.UX() - 432000L));
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
          Cursor localCursor = ((t)localObject3).dXo.a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = " + n, null, 0);
          while (localCursor.moveToNext())
          {
            l2 = localCursor.getLong(1);
            String str3 = localCursor.getString(2);
            String str4 = localCursor.getString(3);
            String str5 = localCursor.getString(4);
            y.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", new Object[] { str3, str4 });
            if ((bk.bl(str3)) || (bk.bl(str4)))
            {
              com.tencent.mm.plugin.report.service.h.nFQ.f(12696, new Object[] { Integer.valueOf(104), Integer.valueOf(n) });
              y.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", new Object[] { str3, str4 });
            }
            else
            {
              if (i1 == str3.length()) {
                break label2933;
              }
              com.tencent.mm.plugin.report.service.h.nFQ.f(12696, new Object[] { Integer.valueOf(105), Integer.valueOf(n) });
              y.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(str3.length()) });
              continue;
              if (k < i1)
              {
                if (localStringBuffer.charAt(k) != str3.charAt(k)) {
                  break label2915;
                }
                j += 1;
                break label2940;
              }
              if ((i >= 0) && (localVector1.size() > i) && (((Integer)localVector1.get(i)).intValue() >= j)) {
                break label2912;
              }
              i = localVector1.size();
              localVector1.add(Integer.valueOf(j));
              ((Vector)localObject5).add(str4);
              ((Vector)localObject4).add(str5);
              localVector2.add(Long.valueOf(l2));
              y.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i1), localVector1.get(i), Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            }
          }
          localCursor.close();
          if ((i < 0) || (localVector1.size() <= 0))
          {
            com.tencent.mm.plugin.report.service.h.nFQ.f(12696, new Object[] { Integer.valueOf(201), Integer.valueOf(n) });
            y.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localVector1.size()) });
            localObject2 = "";
          }
          else
          {
            i1 = ((Integer)localVector1.get(i)).intValue();
            i2 = i1 * 100 / 256;
            if (i2 < 77)
            {
              com.tencent.mm.plugin.report.service.h.nFQ.f(12696, new Object[] { Integer.valueOf(202), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()) });
              y.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", new Object[] { Long.valueOf(bk.co(l1)), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(localObject2.length - 1), str2 });
              localObject2 = "";
            }
            else
            {
              localObject2 = bk.pm((String)((Vector)localObject5).get(i));
              j = 0;
              k = 0;
              label2275:
              if (k < localVector1.size())
              {
                if ((k == i) || (((Integer)localVector1.get(k)).intValue() < i1) || (((String)localObject2).hashCode() == ((String)((Vector)localObject5).get(k)).hashCode())) {
                  break label2909;
                }
                j += 1;
                break label2947;
              }
              if (j <= 0) {
                break label2489;
              }
              ((t)localObject3).dXo.gk("VideoHash", "delete from VideoHash where size = " + n);
              com.tencent.mm.plugin.report.service.h.nFQ.f(12696, new Object[] { Integer.valueOf(203), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(0), Integer.valueOf(localVector2.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(j) });
              y.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", new Object[] { Integer.valueOf(j), str2 });
              localObject2 = "";
            }
          }
        }
      }
      label2489:
      l1 = bk.co(l1);
      long l2 = bk.a((Long)localVector2.get(i), 0L);
      localObject5 = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(localVector2.size()), Long.valueOf(l1) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(12696, new Object[] { Integer.valueOf(300), localObject5 });
      com.tencent.mm.plugin.report.service.h.nFQ.f(12696, new Object[] { Integer.valueOf(i2 + 3000), localObject5 });
      y.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Long.valueOf(l2), str2, localObject2, ((Vector)localObject4).get(i) });
      localObject4 = (String)((Vector)localObject4).get(i);
      l1 = bk.UY() % 1000L;
      if (l1 < m * 10) {
        break label2954;
      }
      if (i2 < 90) {
        break label2954;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", new Object[] { Boolean.valueOf(bool4), Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(i2), Boolean.valueOf(com.tencent.mm.sdk.a.b.cqk()) });
      if ((bool4) || (com.tencent.mm.sdk.a.b.cqk())) {
        com.tencent.mm.sdk.f.e.a(new t.2((t)localObject3, str2, (String)localObject4, (String)localObject5), "checkVideoHashByteDiff", 1);
      }
      break label1235;
      boolean bool4 = false;
      continue;
      label2827:
      localObject2 = null;
      break label1253;
      if (this.eGm)
      {
        i = 2;
        break;
      }
      i = 0;
      break;
      label2850:
      if (this.eFM.eHM != 1)
      {
        this.eFM.eHM = 1;
        this.eFM.status = 104;
        this.eFM.clientId = this.eoQ;
        this.eFM.bcw = 524544;
        u.f(this.eFM);
      }
      return true;
      label2909:
      break label2947;
      label2912:
      break label1924;
      label2915:
      break label2940;
      label2918:
      bool4 = bool1;
      bool1 = bool2;
      bool2 = bool4;
      break label1148;
      label2933:
      j = 0;
      k = 0;
      break label1861;
      label2940:
      k += 1;
      break label1861;
      label2947:
      k += 1;
      break label2275;
      label2954:
      bool4 = true;
    }
  }
  
  private String Sj()
  {
    return this.fileName + "_" + hashCode();
  }
  
  /* Error */
  private String nH(String paramString)
  {
    // Byte code:
    //   0: new 735	com/tencent/mm/vfs/b
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 736	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   8: astore 9
    //   10: new 735	com/tencent/mm/vfs/b
    //   13: dup
    //   14: aload 9
    //   16: invokevirtual 740	com/tencent/mm/vfs/b:cLq	()Lcom/tencent/mm/vfs/b;
    //   19: new 117	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 742
    //   26: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: aload 9
    //   31: invokevirtual 745	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   34: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 748	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   43: astore 10
    //   45: aconst_null
    //   46: astore 7
    //   48: aconst_null
    //   49: astore 8
    //   51: aconst_null
    //   52: astore 5
    //   54: aconst_null
    //   55: astore 6
    //   57: ldc 115
    //   59: ldc_w 750
    //   62: iconst_1
    //   63: anewarray 162	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload 9
    //   70: invokevirtual 752	com/tencent/mm/vfs/b:length	()J
    //   73: invokestatic 610	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: aastore
    //   77: invokestatic 614	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload 9
    //   82: invokevirtual 752	com/tencent/mm/vfs/b:length	()J
    //   85: ldc2_w 753
    //   88: lcmp
    //   89: ifle +564 -> 653
    //   92: aload 10
    //   94: invokevirtual 757	com/tencent/mm/vfs/b:exists	()Z
    //   97: ifeq +114 -> 211
    //   100: ldc 115
    //   102: ldc_w 759
    //   105: iconst_1
    //   106: anewarray 162	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload 10
    //   113: invokevirtual 763	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   116: invokestatic 768	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   119: aastore
    //   120: invokestatic 614	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: iconst_1
    //   124: istore_2
    //   125: aload 8
    //   127: astore 4
    //   129: aload 6
    //   131: astore 5
    //   133: aload 4
    //   135: ifnull +8 -> 143
    //   138: aload 4
    //   140: invokevirtual 771	java/io/InputStream:close	()V
    //   143: iload_2
    //   144: istore_3
    //   145: aload 5
    //   147: ifnull +10 -> 157
    //   150: aload 5
    //   152: invokevirtual 774	java/io/OutputStream:close	()V
    //   155: iload_2
    //   156: istore_3
    //   157: iload_3
    //   158: ifeq +382 -> 540
    //   161: ldc 115
    //   163: ldc_w 776
    //   166: iconst_3
    //   167: anewarray 162	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_0
    //   173: invokespecial 165	com/tencent/mm/modelvideo/g:Sj	()Ljava/lang/String;
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: aload 10
    //   181: invokevirtual 752	com/tencent/mm/vfs/b:length	()J
    //   184: invokestatic 610	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   187: aastore
    //   188: dup
    //   189: iconst_2
    //   190: aload 10
    //   192: invokevirtual 763	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   195: invokestatic 768	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   198: aastore
    //   199: invokestatic 175	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: aload 10
    //   204: invokevirtual 763	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   207: invokestatic 768	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   210: areturn
    //   211: aload 9
    //   213: invokevirtual 763	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   216: invokestatic 768	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   219: invokestatic 782	com/tencent/mm/sdk/platformtools/c:YU	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   222: astore 11
    //   224: aload 11
    //   226: ifnonnull +121 -> 347
    //   229: ldc_w 325
    //   232: astore 4
    //   234: ldc 115
    //   236: ldc_w 784
    //   239: iconst_1
    //   240: anewarray 162	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload 4
    //   247: aastore
    //   248: invokestatic 175	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: aload 11
    //   253: ifnull +131 -> 384
    //   256: aload 11
    //   258: getfield 789	android/graphics/BitmapFactory$Options:outWidth	I
    //   261: sipush 288
    //   264: if_icmpgt +14 -> 278
    //   267: aload 11
    //   269: getfield 792	android/graphics/BitmapFactory$Options:outHeight	I
    //   272: sipush 288
    //   275: if_icmple +109 -> 384
    //   278: aload 9
    //   280: invokevirtual 763	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   283: invokestatic 768	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   286: sipush 288
    //   289: sipush 288
    //   292: getstatic 798	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   295: bipush 60
    //   297: new 117	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 673	java/lang/StringBuilder:<init>	()V
    //   304: aload 10
    //   306: invokevirtual 740	com/tencent/mm/vfs/b:cLq	()Lcom/tencent/mm/vfs/b;
    //   309: invokevirtual 763	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   312: invokestatic 768	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   315: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc_w 800
    //   321: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: aload 10
    //   329: invokevirtual 745	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   332: invokestatic 803	com/tencent/mm/sdk/platformtools/c:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   335: istore_2
    //   336: aload 6
    //   338: astore 5
    //   340: aload 8
    //   342: astore 4
    //   344: goto -211 -> 133
    //   347: new 117	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 673	java/lang/StringBuilder:<init>	()V
    //   354: aload 11
    //   356: getfield 789	android/graphics/BitmapFactory$Options:outWidth	I
    //   359: invokevirtual 562	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc_w 805
    //   365: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload 11
    //   370: getfield 792	android/graphics/BitmapFactory$Options:outHeight	I
    //   373: invokevirtual 562	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: astore 4
    //   381: goto -147 -> 234
    //   384: aload 9
    //   386: invokestatic 809	com/tencent/mm/vfs/e:o	(Lcom/tencent/mm/vfs/b;)Ljava/io/InputStream;
    //   389: astore 4
    //   391: aload 4
    //   393: fconst_0
    //   394: sipush 288
    //   397: sipush 288
    //   400: invokestatic 812	com/tencent/mm/sdk/platformtools/c:a	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   403: astore 8
    //   405: aload 8
    //   407: ifnull +237 -> 644
    //   410: aload 10
    //   412: invokestatic 816	com/tencent/mm/vfs/e:p	(Lcom/tencent/mm/vfs/b;)Ljava/io/OutputStream;
    //   415: astore 6
    //   417: aload 6
    //   419: astore 5
    //   421: aload 5
    //   423: astore 7
    //   425: aload 4
    //   427: astore 6
    //   429: aload 8
    //   431: getstatic 798	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   434: bipush 60
    //   436: aload 5
    //   438: invokevirtual 822	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   441: istore_2
    //   442: goto -309 -> 133
    //   445: astore 8
    //   447: aconst_null
    //   448: astore 5
    //   450: aconst_null
    //   451: astore 4
    //   453: aload 5
    //   455: astore 7
    //   457: aload 4
    //   459: astore 6
    //   461: ldc 115
    //   463: ldc_w 824
    //   466: iconst_1
    //   467: anewarray 162	java/lang/Object
    //   470: dup
    //   471: iconst_0
    //   472: aload 8
    //   474: invokestatic 513	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   477: aastore
    //   478: invokestatic 430	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   481: aload 4
    //   483: ifnull +8 -> 491
    //   486: aload 4
    //   488: invokevirtual 771	java/io/InputStream:close	()V
    //   491: aload 5
    //   493: ifnull +146 -> 639
    //   496: aload 5
    //   498: invokevirtual 774	java/io/OutputStream:close	()V
    //   501: iconst_0
    //   502: istore_3
    //   503: goto -346 -> 157
    //   506: astore 4
    //   508: iconst_0
    //   509: istore_3
    //   510: goto -353 -> 157
    //   513: astore_1
    //   514: aload 7
    //   516: astore 4
    //   518: aload 4
    //   520: ifnull +8 -> 528
    //   523: aload 4
    //   525: invokevirtual 771	java/io/InputStream:close	()V
    //   528: aload 5
    //   530: ifnull +8 -> 538
    //   533: aload 5
    //   535: invokevirtual 774	java/io/OutputStream:close	()V
    //   538: aload_1
    //   539: athrow
    //   540: ldc 115
    //   542: ldc_w 826
    //   545: iconst_3
    //   546: anewarray 162	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_0
    //   552: invokespecial 165	com/tencent/mm/modelvideo/g:Sj	()Ljava/lang/String;
    //   555: aastore
    //   556: dup
    //   557: iconst_1
    //   558: aload 9
    //   560: invokevirtual 752	com/tencent/mm/vfs/b:length	()J
    //   563: invokestatic 610	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   566: aastore
    //   567: dup
    //   568: iconst_2
    //   569: aload 9
    //   571: invokevirtual 763	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   574: invokestatic 768	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   577: aastore
    //   578: invokestatic 175	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   581: aload_1
    //   582: areturn
    //   583: astore 4
    //   585: goto -442 -> 143
    //   588: astore 4
    //   590: iload_2
    //   591: istore_3
    //   592: goto -435 -> 157
    //   595: astore 4
    //   597: goto -106 -> 491
    //   600: astore 4
    //   602: goto -74 -> 528
    //   605: astore 4
    //   607: goto -69 -> 538
    //   610: astore_1
    //   611: goto -93 -> 518
    //   614: astore_1
    //   615: aload 7
    //   617: astore 5
    //   619: aload 6
    //   621: astore 4
    //   623: goto -105 -> 518
    //   626: astore 8
    //   628: aconst_null
    //   629: astore 5
    //   631: goto -178 -> 453
    //   634: astore 8
    //   636: goto -183 -> 453
    //   639: iconst_0
    //   640: istore_3
    //   641: goto -484 -> 157
    //   644: iconst_0
    //   645: istore_2
    //   646: aload 6
    //   648: astore 5
    //   650: goto -517 -> 133
    //   653: iconst_0
    //   654: istore_2
    //   655: aload 6
    //   657: astore 5
    //   659: aload 8
    //   661: astore 4
    //   663: goto -530 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	this	g
    //   0	666	1	paramString	String
    //   124	531	2	bool1	boolean
    //   144	497	3	bool2	boolean
    //   127	360	4	localObject1	Object
    //   506	1	4	localIOException1	java.io.IOException
    //   516	8	4	localObject2	Object
    //   583	1	4	localIOException2	java.io.IOException
    //   588	1	4	localIOException3	java.io.IOException
    //   595	1	4	localIOException4	java.io.IOException
    //   600	1	4	localIOException5	java.io.IOException
    //   605	1	4	localIOException6	java.io.IOException
    //   621	41	4	localObject3	Object
    //   52	606	5	localObject4	Object
    //   55	601	6	localObject5	Object
    //   46	570	7	localObject6	Object
    //   49	381	8	localBitmap	android.graphics.Bitmap
    //   445	28	8	localException1	Exception
    //   626	1	8	localException2	Exception
    //   634	26	8	localException3	Exception
    //   8	562	9	localb1	com.tencent.mm.vfs.b
    //   43	368	10	localb2	com.tencent.mm.vfs.b
    //   222	147	11	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   80	123	445	java/lang/Exception
    //   211	224	445	java/lang/Exception
    //   234	251	445	java/lang/Exception
    //   256	278	445	java/lang/Exception
    //   278	336	445	java/lang/Exception
    //   347	381	445	java/lang/Exception
    //   384	391	445	java/lang/Exception
    //   496	501	506	java/io/IOException
    //   80	123	513	finally
    //   211	224	513	finally
    //   234	251	513	finally
    //   256	278	513	finally
    //   278	336	513	finally
    //   347	381	513	finally
    //   384	391	513	finally
    //   138	143	583	java/io/IOException
    //   150	155	588	java/io/IOException
    //   486	491	595	java/io/IOException
    //   523	528	600	java/io/IOException
    //   533	538	605	java/io/IOException
    //   391	405	610	finally
    //   410	417	610	finally
    //   429	442	614	finally
    //   461	481	614	finally
    //   391	405	626	java/lang/Exception
    //   410	417	626	java/lang/Exception
    //   429	442	634	java/lang/Exception
  }
  
  protected final int Ka()
  {
    return this.MAX_TIMES;
  }
  
  public final boolean Ky()
  {
    boolean bool = super.Ky();
    if (bool) {
      com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 210L, 1L, false);
    }
    return bool;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    this.eFM = u.oe(this.fileName);
    if ((this.eFM == null) || ((this.eFM.status != 104) && (this.eFM.status != 103)))
    {
      y.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", new Object[] { Sj(), this.fileName });
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      return -1;
    }
    paramf = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.eFM.status).append(" [").append(this.eFM.eHD).append(",").append(this.eFM.eHE).append("] [").append(this.eFM.eGk).append(",").append(this.eFM.ebK).append("]  netTimes:").append(this.eFM.eHJ).append(" times:");
    int i = this.eGp;
    this.eGp = (i + 1);
    y.d("MicroMsg.NetSceneUploadVideo", i);
    if (this.startTime == 0L)
    {
      this.startTime = bk.UY();
      this.eGk = this.eFM.eGk;
    }
    o.Sr();
    if (r.nM(t.nS(this.fileName)))
    {
      y.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", new Object[] { Sj(), this.eFM.SD() });
      com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 139L, 1L, false);
    }
    if (Si())
    {
      y.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      return 0;
    }
    cbp localcbp;
    if (this.eFM.eHL == 1)
    {
      this.eGj = true;
      paramf = new b.a();
      paramf.ecH = new cbp();
      paramf.ecI = new cbq();
      paramf.uri = "/cgi-bin/micromsg-bin/uploadvideo";
      paramf.ecG = 149;
      paramf.ecJ = 39;
      paramf.ecK = 1000000039;
      this.dmK = paramf.Kt();
      localcbp = (cbp)this.dmK.ecE.ecN;
      localcbp.kWn = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""));
      localcbp.kWm = this.eFM.SA();
      localcbp.swQ = this.fileName;
      if (this.eGj) {
        localcbp.tQG = 2;
      }
      if (this.eFM.eHO == 3) {
        localcbp.tQG = 3;
      }
      localcbp.tIl = this.eFM.eHH;
      localcbp.trA = this.eFM.eHE;
      localcbp.tQD = this.eFM.ebK;
      if (!ab.bG(com.tencent.mm.sdk.platformtools.ae.getContext())) {
        break label1154;
      }
      i = 1;
      label565:
      localcbp.sRb = i;
      localcbp.trD = 2;
      localcbp.tQE = 0;
      localcbp.tQF = new bmk().bs(new byte[0]);
      localcbp.trC = new bmk().bs(new byte[0]);
      if (!bk.bl(this.bZs)) {
        break label1159;
      }
      o.Sr();
      paramf = com.tencent.mm.vfs.e.aeY(t.nS(this.fileName));
      this.bZs = paramf;
      label649:
      localcbp.tQJ = paramf;
      localcbp.svK = bf.HR();
      localcbp.tQS = this.eFM.bYN;
      paramf = this.eFM.eHQ;
      if ((paramf == null) || (bk.bl(paramf.dSP))) {
        break label1167;
      }
      localcbp.tQK = bk.aM(paramf.dSP, "");
      localcbp.tQL = paramf.sWK;
      localcbp.tQM = bk.aM(paramf.dSR, "");
      localcbp.tQO = bk.aM(paramf.dST, "");
      localcbp.tQN = bk.aM(paramf.dSS, "");
      localcbp.tQP = bk.aM(paramf.dSU, "");
    }
    for (;;)
    {
      if (paramf != null)
      {
        localcbp.tQR = bk.aM(paramf.dSV, "");
        localcbp.tQQ = bk.aM(paramf.dSW, "");
      }
      y.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", new Object[] { Integer.valueOf(localcbp.tIl), Integer.valueOf(localcbp.trB), Integer.valueOf(localcbp.tQD), Integer.valueOf(localcbp.tQG), localcbp.tQJ, localcbp.tQK, Integer.valueOf(localcbp.tQL), localcbp.tQM, localcbp.tQP });
      if (this.eFM.status != 103) {
        break label1446;
      }
      o.Sr();
      paramf = t.k(t.nT(this.fileName), this.eFM.eHD, eGh);
      if ((paramf.ret >= 0) && (paramf.bDu != 0)) {
        break label1212;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 225L, 1L, false);
      u.nX(this.fileName);
      y.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      return -1;
      if (this.eFM.createTime + 600L < bk.UX())
      {
        y.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
        u.nX(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      if (u.nW(this.fileName)) {
        break;
      }
      y.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
      u.nX(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      return -1;
      label1154:
      i = 2;
      break label565;
      label1159:
      paramf = this.bZs;
      break label649;
      label1167:
      if ((paramf != null) && (!bk.bl(paramf.dST)) && (!bk.bl(paramf.dSS)))
      {
        localcbp.tQO = paramf.dST;
        localcbp.tQN = paramf.dSS;
      }
    }
    label1212:
    y.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.bDu + " newOff:" + paramf.eIh + " netOff:" + this.eFM.eHD);
    if (paramf.eIh < this.eFM.eHD)
    {
      y.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + paramf.eIh + " OldtOff:" + this.eFM.eHD);
      u.nX(this.fileName);
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      return -1;
    }
    byte[] arrayOfByte = new byte[paramf.bDu];
    System.arraycopy(paramf.buf, 0, arrayOfByte, 0, paramf.bDu);
    localcbp.trB = this.eFM.eHD;
    localcbp.trC = new bmk().bs(arrayOfByte);
    for (;;)
    {
      return a(parame, this.dmK, this);
      label1446:
      o.Sr();
      paramf = t.k(t.nS(this.fileName), this.eFM.eGk, eGh);
      if ((paramf.ret < 0) || (paramf.bDu == 0))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 224L, 1L, false);
        u.nX(this.fileName);
        y.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      y.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.bDu + " newOff:" + paramf.eIh + " netOff:" + this.eFM.eGk);
      if (paramf.eIh < this.eFM.eGk)
      {
        y.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + paramf.eIh + " OldtOff:" + this.eFM.eGk);
        u.nX(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      if (paramf.eIh >= c.eFh)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 222L, 1L, false);
        y.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.eFh);
        u.nX(this.fileName);
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      arrayOfByte = new byte[paramf.bDu];
      System.arraycopy(paramf.buf, 0, arrayOfByte, 0, paramf.bDu);
      localcbp.tQE = this.eFM.eGk;
      localcbp.trB = this.eFM.eHD;
      localcbp.tQF = new bmk().bs(arrayOfByte);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.eoQ);
    if (this.eFP)
    {
      y.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.eFM.SA());
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bk.bl(this.eoQ)))
    {
      y.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.eoQ });
      return;
    }
    paramArrayOfByte = (cbq)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    paramq = (cbp)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    this.eFM = u.oe(this.fileName);
    if (this.eFM == null)
    {
      y.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (this.eFM.status == 105)
    {
      y.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((this.eFM.status != 104) && (this.eFM.status != 103))
    {
      y.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.eFM.status + " [" + this.fileName + "," + this.eFM.bXr + "," + this.eFM.SB() + "," + this.eFM.SA() + "] ");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      y.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.eFM.SA());
      u.nY(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 220L, 1L, false);
      y.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.eFM.SA());
      u.nX(this.fileName);
      com.tencent.mm.plugin.report.service.h.nFQ.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext())), Integer.valueOf(this.eFO), Integer.valueOf(0) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 219L, 1L, false);
      y.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.eFM.SA());
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((!bk.bE(paramq.trC.tFM.oY)) && (paramq.trB != paramArrayOfByte.trB - paramq.trC.tFK))
    {
      y.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramq.trB + "," + paramq.trC.tFK + "," + paramArrayOfByte.trB + "] file:" + this.fileName + " user:" + paramq.kWm);
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((!bk.bE(paramq.tQF.tFM.oY)) && (paramq.tQE != paramArrayOfByte.tQE - paramq.tQF.tFK))
    {
      y.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + paramq.tQE + "," + paramq.tQF.tFK + "," + paramArrayOfByte.tQE + "] file:" + this.fileName + " user:" + paramq.kWm);
      u.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.eFM.eHF = bk.UX();
    this.eFM.bXr = paramArrayOfByte.ndp;
    this.eFM.bcw = 1028;
    y.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(this.eFM.bXr), Integer.valueOf(com.tencent.mm.platformtools.ae.eSQ) });
    if ((10007 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.platformtools.ae.eSQ != 0) && (this.eFM.bXr != 0L))
    {
      this.eFM.bXr = com.tencent.mm.platformtools.ae.eSQ;
      com.tencent.mm.platformtools.ae.eSQ = 0;
    }
    int i = 0;
    paramInt1 = this.eFM.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.eFM;
      paramInt1 = paramq.trB;
      paramArrayOfByte.eHD = (paramq.trC.tFK + paramInt1);
      this.eFM.bcw |= 0x40;
      paramInt1 = i;
      if (this.eFM.eHD >= this.eFM.eHE)
      {
        this.eFM.status = 104;
        this.eFM.bcw |= 0x100;
        paramInt1 = i;
      }
    }
    for (;;)
    {
      u.f(this.eFM);
      if (!this.eFP) {
        break label1591;
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      if (paramInt1 != 104) {
        break;
      }
      paramArrayOfByte = this.eFM;
      paramInt1 = paramq.tQE;
      paramArrayOfByte.eGk = (paramq.tQF.tFK + paramInt1);
      this.eFM.bcw |= 0x8;
      paramInt1 = i;
      if (this.eFM.eGk >= this.eFM.ebK)
      {
        this.eFM.status = 199;
        this.eFM.bcw |= 0x100;
        u.d(this.eFM);
        paramInt1 = 1;
      }
    }
    y.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + paramInt1 + " file:" + this.fileName + " user:" + paramq.kWm);
    u.nX(this.fileName);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    return;
    label1591:
    if (paramInt1 == 0)
    {
      this.ebj.S(10L, 10L);
      return;
    }
    paramq = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.eFM.eHI);
    com.tencent.mm.modelstat.b.eBD.f(paramq);
    com.tencent.mm.plugin.report.service.h.nFQ.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext())), Integer.valueOf(this.eFO), Integer.valueOf(this.eFM.ebK - this.eGk) });
    boolean bool;
    if (this.eFM == null)
    {
      bool = false;
      if ((!bool) && (!com.tencent.mm.model.s.hx(this.eFM.SA()))) {
        break label2122;
      }
      y.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", new Object[] { this.eFM.SA() });
      if (this.eFM.bXr < 0L)
      {
        y.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.eFM.bXr + " file:" + this.fileName + " toUser:" + this.eFM.SA());
        u.nX(this.fileName);
      }
      label1861:
      if (this.esm == null) {
        break label2210;
      }
    }
    label2210:
    for (long l = this.esm.zJ();; l = 0L)
    {
      y.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.eFM.SA() + " msgsvrid:" + this.eFM.bXr + " thumbsize:" + this.eFM.eHE + " videosize:" + this.eFM.ebK + " useTime:" + l);
      y.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + eGh + " filesize:" + this.eFM.ebK + " useTime:" + l);
      a.a(this.eFM, 0);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      paramq = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(this.eFM.SA());
      if ((paramq == null) || ((int)paramq.dBe <= 0))
      {
        bool = false;
        break;
      }
      bool = paramq.cua();
      break;
      label2122:
      y.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
      if (this.eFM.bXr > 0L) {
        break label1861;
      }
      y.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.eFM.bXr + " file:" + this.fileName + " toUser:" + this.eFM.SA());
      u.nX(this.fileName);
      break label1861;
    }
  }
  
  protected final void a(m.a parama)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 221L, 1L, false);
    u.nX(this.fileName);
  }
  
  protected final m.b b(q paramq)
  {
    paramq = (cbp)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    if ((bk.bl(paramq.swQ)) || (paramq.trD <= 0) || (bk.bl(paramq.kWn)) || (bk.bl(paramq.kWm)) || (paramq.sRb <= 0) || (paramq.trB > paramq.trA) || (paramq.trB < 0) || (paramq.tQE > paramq.tQD) || (paramq.tQE < 0) || ((paramq.tQE == paramq.tQD) && (paramq.trB == paramq.trA)) || (paramq.trA <= 0) || (paramq.tQD <= 0) || ((paramq.tQF.tFK <= 0) && (paramq.trC.tFK <= 0)))
    {
      y.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + paramq.kWm);
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  protected final void cancel()
  {
    y.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", new Object[] { Sj(), this.eoQ });
    if (!bk.bl(this.eoQ)) {
      com.tencent.mm.ak.f.Nd().lL(this.eoQ);
    }
    this.eFP = true;
    super.cancel();
  }
  
  public final int getType()
  {
    return 149;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g
 * JD-Core Version:    0.7.0.1
 */