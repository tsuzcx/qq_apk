package com.tencent.mm.as;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.a;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.s;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.aho;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  String TAG = "MicroMsg.NetSceneGetMsgImg";
  bi bFH = null;
  private long bIt = -1L;
  long dFT;
  private final com.tencent.mm.ah.b dmK;
  com.tencent.mm.ah.f dmL;
  int ebK = 0;
  private int ent;
  final com.tencent.mm.ah.g eoM;
  public final long eoN;
  private int eoO;
  private com.tencent.mm.modelstat.h eoP = null;
  String eoQ = "";
  int eoR = 0;
  private String eoS = "";
  public String eoT = "";
  int eoU = -1;
  public boolean eoV = false;
  private int eoW = -1;
  private String eoX = null;
  private int eoY = 0;
  boolean eoZ = false;
  private f.a epa = new k.2(this);
  private int startOffset = -1;
  long startTime = 0L;
  private int token = -1;
  
  public k(long paramLong1, long paramLong2, int paramInt, com.tencent.mm.ah.g paramg)
  {
    this(paramLong1, paramLong2, paramInt, paramg, -1);
  }
  
  public k(long paramLong1, long paramLong2, int paramInt1, com.tencent.mm.ah.g paramg, int paramInt2)
  {
    boolean bool;
    e locale;
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (paramg != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.eoM = paramg;
      this.ent = paramInt1;
      this.eoN = paramLong1;
      this.dFT = paramLong1;
      this.bIt = paramLong2;
      this.eoW = paramInt2;
      locale = o.OJ().b(Long.valueOf(this.dFT));
      if (paramInt1 != 1) {
        break label566;
      }
      this.dFT = locale.enz;
      locale = o.OJ().b(Long.valueOf(this.dFT));
    }
    label566:
    for (;;)
    {
      this.TAG = (this.TAG + "[" + this.dFT + "]");
      Object localObject = new b.a();
      ((b.a)localObject).ecH = new ahn();
      ((b.a)localObject).ecI = new aho();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getmsgimg";
      ((b.a)localObject).ecG = 109;
      ((b.a)localObject).ecJ = 10;
      ((b.a)localObject).ecK = 1000000010;
      this.dmK = ((b.a)localObject).Kt();
      localObject = (ahn)this.dmK.ecE.ecN;
      this.bFH = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramLong2);
      ((ahn)localObject).ndg = locale.offset;
      ((ahn)localObject).ndf = locale.ebK;
      y.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[] { Integer.valueOf(locale.offset), Integer.valueOf(locale.ebK), bk.csb() });
      ((ahn)localObject).ndp = this.bFH.field_msgSvrId;
      ((ahn)localObject).svF = new bml().YI(this.bFH.field_talker);
      ((ahn)localObject).svG = new bml().YI((String)com.tencent.mm.kernel.g.DP().Dz().get(2, null));
      ((ahn)localObject).tfc = paramInt1;
      if (locale.offset == 0) {
        this.eoP = new com.tencent.mm.modelstat.h(109, false, locale.ebK);
      }
      this.eoO = 8192;
      if (paramg != null) {
        ai.d(new k.1(this, paramg, locale.offset, locale.ebK));
      }
      return;
      bool = false;
      break;
    }
  }
  
  private boolean a(e parame, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    parame.iC(paramInt1);
    parame.setOffset(paramInt2 + paramInt3);
    this.eoO = paramInt3;
    if (paramArrayOfByte != null) {
      com.tencent.mm.vfs.e.a(this.eoT, paramArrayOfByte, paramArrayOfByte.length);
    }
    y.d(this.TAG, "onGYNetEnd : offset = " + parame.offset + " totalLen = " + parame.ebK + " stack:[%s]", new Object[] { bk.csb() });
    Object localObject;
    boolean bool1;
    String str1;
    com.tencent.mm.vfs.b localb;
    boolean bool2;
    if (parame.Oq())
    {
      paramArrayOfByte = com.tencent.mm.sdk.platformtools.o.Zc(this.eoT);
      localObject = new MMBitmapFactory.DecodeResultLogger();
      bool1 = MMBitmapFactory.checkIsImageLegal(this.eoT, (MMBitmapFactory.DecodeResultLogger)localObject);
      str1 = this.eoT + "_hevc";
      localb = new com.tencent.mm.vfs.b(this.eoT);
      bool2 = com.tencent.mm.sdk.platformtools.o.Zb(this.eoT);
      if (!bool2) {
        break label908;
      }
      localb.n(new com.tencent.mm.vfs.b(str1));
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(str1, this.eoT) != 0)
      {
        y.w(this.TAG, "download hevc decode failed");
        bool1 = false;
        y.d(this.TAG, "hevc download is hevc %b", new Object[] { Boolean.valueOf(true) });
      }
    }
    label908:
    for (;;)
    {
      if (bool1)
      {
        localObject = o.OJ().o(this.eoS, null, paramArrayOfByte);
        y.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[] { paramArrayOfByte, this.eoS, this.eoT, localObject });
        if (bool2)
        {
          String str2 = (String)localObject + "_hevc";
          new com.tencent.mm.vfs.b(str1).n(new com.tencent.mm.vfs.b(str2));
          localb.n(new com.tencent.mm.vfs.b((String)localObject));
          label376:
          parame.lX(this.eoS + paramArrayOfByte);
          parame.lW(f.mc((String)localObject));
          parame.iG(this.ent);
        }
      }
      for (paramArrayOfByte = (byte[])localObject;; paramArrayOfByte = null)
      {
        if (o.OJ().a(Long.valueOf(this.dFT), parame) >= 0) {
          break label542;
        }
        y.e(this.TAG, "onGYNetEnd : update img fail");
        this.dmL.onSceneEnd(3, -1, "", this);
        return false;
        paramArrayOfByte = com.tencent.mm.sdk.platformtools.o.Zc(this.eoT);
        break;
        localb.n(new com.tencent.mm.vfs.b((String)localObject));
        break label376;
        localb.delete();
        if (((MMBitmapFactory.DecodeResultLogger)localObject).getDecodeResult() >= 2000)
        {
          paramArrayOfByte = MMBitmapFactory.KVStatHelper.getKVStatString(this.eoT, 2, (MMBitmapFactory.DecodeResultLogger)localObject);
          com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, paramArrayOfByte);
        }
      }
      label542:
      if (this.eoM != null) {
        ai.d(new k.3(this, parame));
      }
      y.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[] { Boolean.valueOf(parame.Oq()), this.eoQ });
      if (parame.Oq())
      {
        if (bk.bl(this.eoQ)) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(this.eoR), Integer.valueOf(paramInt1 - this.startOffset) });
        }
        bool1 = false;
        if (this.eoU > 0) {
          bool1 = o.OJ().a(paramArrayOfByte, parame.ens, this.eoU, 1, this.bFH.cQG, this.bFH.cQH);
        }
        if (bool1)
        {
          parame.cQK = 1;
          parame.enQ = true;
          ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.bFH.field_msgId, this.bFH);
        }
        o.OJ().a(Long.valueOf(this.dFT), parame);
        y.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[] { this.eoT, paramArrayOfByte, parame.enq, this.eoX });
        if (this.eoP != null) {
          this.eoP.cg(parame.ebK);
        }
        if ((!bk.bl(this.eoX)) && (this.eoY > 0))
        {
          com.tencent.mm.plugin.n.b.bbs();
          com.tencent.mm.plugin.n.b.FD().A(this.eoX, this.eoY, paramArrayOfByte);
        }
        this.dmL.onSceneEnd(0, 0, "", this);
        return false;
      }
      return true;
    }
  }
  
  protected final int Ka()
  {
    if (this.ent == 0) {
      return 100;
    }
    return 1280;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    ahn localahn = (ahn)this.dmK.ecE.ecN;
    e locale = o.OJ().b(Long.valueOf(this.dFT));
    if (locale.enp == 0L)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 195L, 1L, false);
      y.e(this.TAG, "doScene id:%d  img:%s", new Object[] { Long.valueOf(this.dFT), locale });
      return -1;
    }
    if (locale.status != 0)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 194L, 1L, false);
      y.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[] { Long.valueOf(locale.enp), Integer.valueOf(locale.status) });
      return -1;
    }
    paramf = locale.enq;
    int i;
    if (paramf.startsWith("SERVERID://"))
    {
      this.eoS = com.tencent.mm.a.g.o(locale.enq.getBytes());
      this.eoT = o.OJ().o(this.eoS, null, ".temp");
      locale.lX(this.eoS + ".temp");
      o.OJ().a(Long.valueOf(this.dFT), locale);
      y.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[] { Long.valueOf(locale.enp), Integer.valueOf(this.ent), Integer.valueOf(locale.offset), Integer.valueOf(locale.ebK), paramf, this.eoS, this.eoT });
      if (this.startTime == 0L)
      {
        this.startTime = bk.UY();
        this.startOffset = locale.offset;
        if (this.ent != 1) {
          break label450;
        }
        i = a.MediaType_FULLSIZEIMAGE;
        label360:
        this.eoR = i;
      }
      paramf = localahn.svF.tFO;
      long l = localahn.ndp;
      if (!bk.bl(locale.enA)) {
        break label457;
      }
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label1764;
      }
      y.d(this.TAG, "cdntra this img use cdn : %s", new Object[] { this.eoQ });
      return 0;
      this.eoS = locale.enq;
      this.eoT = o.OJ().o(this.eoS, null, "");
      break;
      label450:
      i = a.MediaType_IMAGE;
      break label360;
      label457:
      Map localMap = bn.s(locale.enA, "msg");
      if (localMap == null)
      {
        y.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { locale.enA });
        i = 0;
      }
      else
      {
        this.ebK = 0;
        String str1;
        if (this.ent != 1)
        {
          str1 = (String)localMap.get(".msg.img.$cdnmidimgurl");
          this.ebK = bk.getInt((String)localMap.get(".msg.img.$length"), 0);
          label551:
          if (this.ent == 1) {
            break label721;
          }
          str2 = (String)localMap.get(".msg.img.$tpurl");
          paramf = str2;
          if (bk.bl(str2)) {
            break label771;
          }
          this.ebK = bk.getInt((String)localMap.get(".msg.img.$tplength"), 0);
          paramf = str2;
        }
        label771:
        for (;;)
        {
          y.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", new Object[] { Integer.valueOf(this.ent), Integer.valueOf(this.ebK), str1, paramf });
          if ((!bk.bl(str1)) || (!bk.bl(paramf))) {
            break label774;
          }
          y.e(this.TAG, "cdntra get cdnUrlfailed.");
          i = 0;
          break;
          str1 = (String)localMap.get(".msg.img.$cdnbigimgurl");
          this.ebK = bk.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
          break label551;
          label721:
          str2 = (String)localMap.get(".msg.img.$tphdurl");
          paramf = str2;
          if (!bk.bl(str2))
          {
            this.ebK = bk.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
            paramf = str2;
          }
        }
        label774:
        String str2 = (String)localMap.get(".msg.img.$aeskey");
        if (bk.bl(str2))
        {
          y.e(this.TAG, "cdntra get aes key failed.");
          i = 0;
        }
        else
        {
          this.eoQ = com.tencent.mm.ak.c.a("downimg", locale.enw, this.bFH.field_talker, this.bFH.field_msgId);
          if (bk.bl(this.eoQ))
          {
            y.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.dFT) });
            i = 0;
          }
          else
          {
            Object localObject1 = (String)localMap.get(".msg.img.$md5");
            if ((bk.bl(paramf)) && (!bk.bl((String)localObject1)) && ((bk.bl((String)localMap.get(".msg.img.$cdnbigimgurl"))) || (this.ent == 1)))
            {
              com.tencent.mm.plugin.n.b.bbs();
              String str3 = com.tencent.mm.plugin.n.b.FD().dx((String)localObject1, this.ebK);
              i = (int)com.tencent.mm.vfs.e.aeQ(str3);
              int j = this.ebK - i;
              String str4 = this.TAG;
              int k = this.ebK;
              Object localObject2 = localMap.get(".msg.img.$cdnbigimgurl");
              if (this.ent == 1)
              {
                bool = true;
                label1019:
                y.i(str4, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", new Object[] { Integer.valueOf(k), localObject1, localObject2, Boolean.valueOf(bool), Integer.valueOf(i), str3, Integer.valueOf(j), this.eoT });
                if (bk.bl(str3)) {
                  break label1332;
                }
                if ((j < 0) || (j > 16)) {
                  break label1346;
                }
                bool = false;
                if (!bk.isEqual(str3, this.eoT)) {
                  if (com.tencent.mm.vfs.e.r(str3, this.eoT) < 0L) {
                    break label1326;
                  }
                }
              }
              label1326:
              for (boolean bool = true;; bool = false)
              {
                y.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[] { str3, this.eoT, Boolean.valueOf(bool) });
                a(locale, this.ebK, this.ebK, 0, null);
                if (this.bFH != null) {
                  ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(new g.c(this.bFH.field_talker, "update", this.bFH));
                }
                com.tencent.mm.plugin.report.service.h.nFQ.f(13267, new Object[] { str1, Long.valueOf(this.bFH.field_msgSvrId), localObject1, Long.valueOf(this.bFH.field_createTime / 1000L), this.bFH.field_talker, Integer.valueOf(3), Integer.valueOf(i) });
                i = 1;
                break;
                bool = false;
                break label1019;
              }
              label1332:
              this.eoX = ((String)localObject1);
              this.eoY = this.ebK;
            }
            label1346:
            localObject1 = new com.tencent.mm.j.f();
            ((com.tencent.mm.j.f)localObject1).field_mediaId = this.eoQ;
            ((com.tencent.mm.j.f)localObject1).field_fullpath = this.eoT;
            ((com.tencent.mm.j.f)localObject1).field_fileType = this.eoR;
            ((com.tencent.mm.j.f)localObject1).field_totalLen = this.ebK;
            ((com.tencent.mm.j.f)localObject1).field_aesKey = str2;
            ((com.tencent.mm.j.f)localObject1).field_fileId = str1;
            ((com.tencent.mm.j.f)localObject1).field_priority = a.dlk;
            ((com.tencent.mm.j.f)localObject1).dlP = this.epa;
            if (s.fn(this.bFH.field_talker))
            {
              i = 1;
              label1437:
              ((com.tencent.mm.j.f)localObject1).field_chattype = i;
              if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.c.class)).aGx()) {
                break label1735;
              }
              i = 2;
              label1462:
              ((com.tencent.mm.j.f)localObject1).expectImageFormat = i;
              if (!bk.bl(paramf))
              {
                str1 = (String)localMap.get(".msg.img.$tpauthkey");
                ((com.tencent.mm.j.f)localObject1).field_fileType = 19;
                ((com.tencent.mm.j.f)localObject1).field_authKey = str1;
                ((com.tencent.mm.j.f)localObject1).dlQ = paramf;
                ((com.tencent.mm.j.f)localObject1).field_fileId = "";
              }
              y.i(this.TAG, "cdnautostart %s %b", new Object[] { "image_" + this.bFH.field_msgId, Boolean.valueOf(com.tencent.mm.ak.f.Nd().eiM.contains("image_" + this.bFH.field_msgId)) });
              if (!com.tencent.mm.ak.f.Nd().eiM.contains("image_" + this.bFH.field_msgId)) {
                break label1740;
              }
              com.tencent.mm.ak.f.Nd().eiM.remove("image_" + this.bFH.field_msgId);
            }
            label1735:
            label1740:
            for (((com.tencent.mm.j.f)localObject1).field_autostart = true;; ((com.tencent.mm.j.f)localObject1).field_autostart = false)
            {
              if (com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject1, this.eoW)) {
                break label1749;
              }
              com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 196L, 1L, false);
              y.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.eoQ });
              this.eoQ = "";
              i = 0;
              break;
              i = 0;
              break label1437;
              i = 1;
              break label1462;
            }
            label1749:
            y.d(this.TAG, "add recv task");
            i = 1;
          }
        }
      }
    }
    label1764:
    y.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[] { this.eoQ });
    locale.ma("");
    locale.bcw = 4096;
    o.OJ().a(Long.valueOf(this.dFT), locale);
    localahn.ndg = locale.offset;
    localahn.ndh = this.eoO;
    localahn.ndf = locale.ebK;
    if (this.eoP != null) {
      this.eoP.Ru();
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bk.bl(this.eoQ))) {
      y.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.eoQ });
    }
    do
    {
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (paramInt2 == 4)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 193L, 1L, false);
          com.tencent.mm.plugin.report.service.h.nFQ.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(this.eoR), Integer.valueOf(this.ebK - this.startOffset) });
        }
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      paramString = (aho)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      paramq = o.OJ().b(Long.valueOf(this.dFT));
      paramInt1 = 0;
      if (paramString.ndh <= 0)
      {
        y.e(this.TAG, "flood control, malformed data_len");
        paramInt1 = -1;
      }
      while (paramInt1 != 0)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 192L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.f(10420, new Object[] { Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(this.eoR), Integer.valueOf(this.ebK - this.startOffset) });
        this.dmL.onSceneEnd(4, -1, "", this);
        return;
        if ((paramString.ndi == null) || (paramString.ndh != paramString.ndi.tFK))
        {
          y.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
          paramInt1 = -1;
        }
        else if ((paramString.ndg < 0) || (paramString.ndg + paramString.ndh > paramString.ndf))
        {
          y.e(this.TAG, "flood control, malformed start pos");
          paramInt1 = -1;
        }
        else if (paramString.ndg != paramq.offset)
        {
          y.e(this.TAG, "flood control, malformed start_pos");
          paramInt1 = -1;
        }
        else if (paramString.ndf <= 0)
        {
          y.e(this.TAG, "flood control, malformed total_len");
          paramInt1 = -1;
        }
      }
    } while ((!a(paramq, paramString.ndf, paramString.ndg, paramString.ndh, paramString.ndi.tFM.oY)) || (a(this.edc, this.dmL) >= 0));
    this.dmL.onSceneEnd(3, -1, "", this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  protected final void cancel()
  {
    if ((!bk.bl(this.eoQ)) && (com.tencent.mm.ak.f.Nd() != null))
    {
      y.d(this.TAG, "cancel recv task");
      com.tencent.mm.ak.f.Nd().lM(this.eoQ);
    }
    super.cancel();
  }
  
  public final int getType()
  {
    return 109;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.as.k
 * JD-Core Version:    0.7.0.1
 */