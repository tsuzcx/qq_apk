package com.tencent.mm.as;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.s;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cbh;
import com.tencent.mm.protocal.c.cbi;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Map;
import junit.framework.Assert;

public final class l
  extends m
  implements k
{
  public static boolean DEBUG = true;
  private static long epr;
  private String TAG = "MicroMsg.NetSceneUploadMsgImg";
  public bi bFH = null;
  private float bRt;
  public String bYR;
  private long dFT;
  private int dFU;
  private e dFV;
  private boolean dGb = false;
  private final com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private int ent = 0;
  private long enx;
  private final com.tencent.mm.ah.g eoM;
  public long eoN;
  private com.tencent.mm.modelstat.h eoP = null;
  private String eoQ = "";
  private int eoR = 0;
  private int eoU;
  private f.a epa = new l.4(this);
  private String epg = "";
  private String eph = "";
  private boolean epi = true;
  private e epj;
  private int epk = 16384;
  l.b epl = new l.b(this, null);
  private String epm;
  private boolean epn;
  private float epo;
  private String epp;
  private String epq;
  private int scene;
  private int startOffset = -1;
  private long startTime = 0L;
  
  public l(int paramInt1, int paramInt2)
  {
    y.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bk.csb() });
    this.eoN = paramInt1;
    this.dFT = paramInt1;
    this.ent = paramInt2;
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new cbh();
    ((b.a)localObject1).ecI = new cbi();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((b.a)localObject1).ecG = 110;
    ((b.a)localObject1).ecJ = 9;
    ((b.a)localObject1).ecK = 1000000009;
    this.dmK = ((b.a)localObject1).Kt();
    this.eoM = null;
    y.d(this.TAG, "FROM B SERVICE:" + this.eoN);
    if (!i.iJ((int)this.eoN))
    {
      this.eoN = -1L;
      return;
    }
    localObject1 = o.OJ().b(Long.valueOf(this.eoN));
    this.enx = ((e)localObject1).enx;
    if (paramInt2 == 1)
    {
      this.dFT = ((e)localObject1).enz;
      localObject1 = o.OJ().b(Long.valueOf(this.dFT));
    }
    for (;;)
    {
      Object localObject2 = o.OJ().iI((int)((e)localObject1).enp);
      if (localObject2 != null) {
        this.enx = ((e)localObject2).enx;
      }
      this.bFH = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.enx);
      if ((this.bFH != null) && (this.bFH.field_msgId != this.enx))
      {
        y.w(this.TAG, "init get msg by id failed:%d", new Object[] { Long.valueOf(this.enx) });
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 206L, 1L, false);
        this.bFH = null;
        return;
      }
      if (this.bFH == null) {
        break;
      }
      localObject2 = (cbh)this.dmK.ecE.ecN;
      ((cbh)localObject2).svF = new bml().YI(com.tencent.mm.model.q.Gj());
      ((cbh)localObject2).svG = new bml().YI(this.bFH.field_talker);
      ((cbh)localObject2).ndg = ((e)localObject1).offset;
      ((cbh)localObject2).ndf = ((e)localObject1).ebK;
      ((cbh)localObject2).kSW = this.bFH.getType();
      ((cbh)localObject2).tfc = paramInt2;
      if (ab.bG(com.tencent.mm.sdk.platformtools.ae.getContext())) {}
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((cbh)localObject2).sNU = paramInt1;
        ((cbh)localObject2).tLm = ((e)localObject1).source;
        ((cbh)localObject2).sGT = ((e)localObject1).enu;
        ((cbh)localObject2).sGT = ((e)localObject1).enu;
        ((cbh)localObject2).tQw = this.bFH.cQH;
        ((cbh)localObject2).tQx = this.bFH.cQG;
        a locala = f.mb(this.bFH.field_content);
        if ((locala != null) && (!bk.bl(locala.appId)))
        {
          this.dFU = ((e)localObject1).source;
          ((cbh)localObject2).euK = locala.appId;
          ((cbh)localObject2).sua = locala.mediaTagName;
          ((cbh)localObject2).suc = locala.messageAction;
          ((cbh)localObject2).sub = locala.messageExt;
          this.epm = this.bFH.field_content;
        }
        y.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((cbh)localObject2).tQw), Integer.valueOf(((cbh)localObject2).tQx) });
        y.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((e)localObject1).source), Integer.valueOf(((cbh)localObject2).sGT) });
        if (((e)localObject1).offset != 0) {
          break;
        }
        this.eoP = new com.tencent.mm.modelstat.h(110, true, ((e)localObject1).ebK);
        return;
      }
    }
  }
  
  public l(int paramInt1, int paramInt2, byte paramByte)
  {
    y.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null, bk.csb() });
    this.eoN = paramInt1;
    this.dFT = paramInt1;
    this.ent = paramInt2;
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new cbh();
    ((b.a)localObject1).ecI = new cbi();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((b.a)localObject1).ecG = 110;
    ((b.a)localObject1).ecJ = 9;
    ((b.a)localObject1).ecK = 1000000009;
    this.dmK = ((b.a)localObject1).Kt();
    this.eoM = null;
    y.d(this.TAG, "FROM C SERVICE:" + this.eoN);
    if (!i.iJ((int)this.eoN))
    {
      this.eoN = -1L;
      return;
    }
    localObject1 = o.OJ().b(Long.valueOf(this.eoN));
    this.enx = ((e)localObject1).enx;
    ((e)localObject1).setStatus(0);
    ((e)localObject1).bf(0L);
    ((e)localObject1).setOffset(0);
    o.OJ().a((int)this.dFT, (e)localObject1);
    if (paramInt2 == 1)
    {
      this.dFT = ((e)localObject1).enz;
      localObject1 = o.OJ().b(Long.valueOf(this.dFT));
    }
    for (;;)
    {
      this.bFH = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.enx);
      if (this.bFH == null) {
        break;
      }
      this.bFH.setStatus(1);
      Object localObject2 = ((e)localObject1).ens;
      if ((localObject2 != null) && (((String)localObject2).startsWith("THUMBNAIL_DIRPATH://")))
      {
        this.bFH.ed((String)localObject2);
        label435:
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.enx, this.bFH);
        localObject2 = (cbh)this.dmK.ecE.ecN;
        ((cbh)localObject2).svF = new bml().YI(com.tencent.mm.model.q.Gj());
        ((cbh)localObject2).svG = new bml().YI(this.bFH.field_talker);
        ((cbh)localObject2).ndg = ((e)localObject1).offset;
        ((cbh)localObject2).ndf = ((e)localObject1).ebK;
        ((cbh)localObject2).kSW = this.bFH.getType();
        ((cbh)localObject2).tfc = paramInt2;
        if (!ab.bG(com.tencent.mm.sdk.platformtools.ae.getContext())) {
          break label750;
        }
      }
      label750:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((cbh)localObject2).sNU = paramInt1;
        ((cbh)localObject2).tLm = ((e)localObject1).source;
        ((cbh)localObject2).sGT = ((e)localObject1).enu;
        ((cbh)localObject2).tQw = this.bFH.cQH;
        ((cbh)localObject2).tQx = this.bFH.cQG;
        y.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((cbh)localObject2).tQw), Integer.valueOf(((cbh)localObject2).tQx) });
        y.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((e)localObject1).source), Integer.valueOf(((cbh)localObject2).sGT) });
        if (((e)localObject1).offset != 0) {
          break;
        }
        this.eoP = new com.tencent.mm.modelstat.h(110, true, ((e)localObject1).ebK);
        return;
        this.bFH.ed("THUMBNAIL://" + ((e)localObject1).enp);
        break label435;
      }
    }
  }
  
  public l(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.ah.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, 0, -1000.0F, -1000.0F);
  }
  
  public l(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.ah.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2)
  {
    y.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramg, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt4), Boolean.valueOf(true), bk.csb(), Integer.valueOf(paramInt5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.epn = paramBoolean;
    this.eoU = paramInt4;
    this.eoM = paramg;
    this.ent = paramInt2;
    this.scene = paramInt5;
    this.bRt = paramFloat2;
    this.epo = paramFloat1;
    this.dFU = paramInt1;
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    this.epm = paramString4;
    localPString.value = paramString5;
    this.eoN = o.OJ().a(paramString3, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
    this.dFT = this.eoN;
    y.i(this.TAG, "FROM A UI :" + paramString2 + " " + this.eoN);
    if ((this.eoN < 0L) || (!i.iJ((int)this.eoN)))
    {
      y.e(this.TAG, "insert to img storage failed id:" + this.eoN);
      this.enx = -1L;
      this.dmK = null;
      return;
    }
    if (this.eoN >= 0L)
    {
      paramBoolean = true;
      label456:
      Assert.assertTrue(paramBoolean);
      paramString3 = new b.a();
      paramString3.ecH = new cbh();
      paramString3.ecI = new cbi();
      paramString3.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
      paramString3.ecG = 110;
      paramString3.ecJ = 9;
      paramString3.ecK = 1000000009;
      this.dmK = paramString3.Kt();
      this.bYR = paramString2;
      this.bFH = new bi();
      this.bFH.setType(s.hX(paramString2));
      this.bFH.ec(paramString2);
      this.bFH.fA(1);
      this.bFH.setStatus(1);
      this.bFH.ed(localPString.value);
      this.bFH.fK(localPInt1.value);
      this.bFH.fL(localPInt2.value);
      this.bFH.bg(bd.iK(this.bFH.field_talker));
      this.bFH.setContent(paramString4);
      a.a.yf().c(this.bFH);
      this.enx = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(this.bFH);
      if (this.enx < 0L) {
        break label1258;
      }
      paramBoolean = true;
      label694:
      Assert.assertTrue(paramBoolean);
      y.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.enx);
      paramString3 = Oy();
      paramString3.bV((int)this.enx);
      o.OJ().a(Long.valueOf(this.eoN), paramString3);
      if (paramInt2 != 1) {
        break label1275;
      }
      this.dFT = paramString3.enz;
      paramString3 = Ox();
    }
    label962:
    label1258:
    label1270:
    label1275:
    for (;;)
    {
      paramString3.iC(com.tencent.mm.a.e.bJ(o.OJ().o(paramString3.enq, "", "")));
      o.OJ().a(Long.valueOf(this.dFT), paramString3);
      y.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.dFT + " img len = " + paramString3.ebK);
      paramString5 = (cbh)this.dmK.ecE.ecN;
      paramString5.svF = new bml().YI(paramString1);
      paramString5.svG = new bml().YI(paramString2);
      paramString5.ndg = paramString3.offset;
      paramString5.ndf = paramString3.ebK;
      paramString5.kSW = this.bFH.getType();
      paramString5.tfc = paramInt2;
      if (ab.bG(com.tencent.mm.sdk.platformtools.ae.getContext()))
      {
        paramInt3 = 1;
        paramString5.sNU = paramInt3;
        paramString5.tLm = paramString3.source;
        paramString5.sGT = paramString3.enu;
        paramString5.tQw = localPInt2.value;
        paramString5.tQx = localPInt1.value;
        paramString1 = f.mb(paramString4);
        if ((paramString1 != null) && (!bk.bl(paramString1.appId)))
        {
          paramString5.euK = paramString1.appId;
          paramString5.sua = paramString1.mediaTagName;
          paramString5.suc = paramString1.messageAction;
          paramString5.sub = paramString1.messageExt;
        }
        y.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString5.tQw), Integer.valueOf(paramString5.tQx) });
        if (paramString5.sGT == 0) {
          if (paramInt1 != 4) {
            break label1270;
          }
        }
      }
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        paramString5.sGT = paramInt1;
        y.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.source), Integer.valueOf(paramString5.sGT) });
        if (paramString3.offset == 0) {
          this.eoP = new com.tencent.mm.modelstat.h(110, true, paramString3.ebK);
        }
        long l = System.currentTimeMillis();
        iM(paramInt2);
        y.d(this.TAG, "hy: create HDThumb using %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        if (paramg == null) {
          break;
        }
        ai.d(new l.2(this, paramg, paramString3.offset, paramString3.ebK));
        return;
        paramBoolean = false;
        break label456;
        paramBoolean = false;
        break label694;
        paramInt3 = 2;
        break label962;
      }
    }
  }
  
  public l(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, com.tencent.mm.ah.g paramg, int paramInt2, String paramString4, String paramString5, int paramInt3)
  {
    y.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(3), paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), paramg, Integer.valueOf(paramInt2), paramString4, paramString5, Boolean.valueOf(true), Integer.valueOf(paramInt3), Boolean.valueOf(true), bk.csb() });
    this.epn = true;
    this.eoU = paramInt3;
    this.eoM = paramg;
    this.ent = paramInt1;
    this.dFU = 3;
    paramString5 = new PInt();
    PInt localPInt = new PInt();
    this.epm = paramString4;
    this.eoN = paramLong;
    this.dFT = this.eoN;
    paramString3 = Oy();
    this.bFH = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramString3.enx);
    this.enx = this.bFH.field_msgId;
    localPInt.value = this.bFH.cQH;
    paramString5.value = this.bFH.cQG;
    if (paramInt1 == 1)
    {
      this.dFT = paramString3.enz;
      this.dFV = null;
      paramString3 = Ox();
    }
    for (;;)
    {
      if (!this.bFH.field_talker.equals(paramString2))
      {
        y.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString2, this.bFH.field_talker });
        com.tencent.mm.plugin.report.service.h.nFQ.a(594L, 4L, 1L, true);
      }
      for (paramString4 = this.bFH.field_talker;; paramString4 = paramString2)
      {
        y.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.bFH.field_msgId);
        y.d(this.TAG, "FROM A UI :" + paramString2 + "   msg:" + paramString4 + this.eoN);
        if ((this.eoN < 0L) || (!i.iJ((int)this.eoN)))
        {
          y.e(this.TAG, "insert to img storage failed id:" + this.eoN);
          this.enx = -1L;
          this.dmK = null;
          return;
        }
        boolean bool;
        if (this.eoN >= 0L)
        {
          bool = true;
          label582:
          Assert.assertTrue(bool);
          paramString2 = new b.a();
          paramString2.ecH = new cbh();
          paramString2.ecI = new cbi();
          paramString2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
          paramString2.ecG = 110;
          paramString2.ecJ = 9;
          paramString2.ecK = 1000000009;
          this.dmK = paramString2.Kt();
          y.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.dFT + " img len = " + paramString3.ebK);
          paramString2 = (cbh)this.dmK.ecE.ecN;
          paramString2.svF = new bml().YI(paramString1);
          paramString2.svG = new bml().YI(paramString4);
          paramString2.ndg = paramString3.offset;
          paramString2.ndf = paramString3.ebK;
          paramString2.kSW = this.bFH.getType();
          paramString2.tfc = paramInt1;
          if (!ab.bG(com.tencent.mm.sdk.platformtools.ae.getContext())) {
            break label996;
          }
        }
        label996:
        for (paramInt1 = 1;; paramInt1 = 2)
        {
          paramString2.sNU = paramInt1;
          paramString2.tLm = paramString3.source;
          paramString2.sGT = paramString3.enu;
          paramString2.tQw = localPInt.value;
          paramString2.tQx = paramString5.value;
          y.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString2.tQw), Integer.valueOf(paramString2.tQx) });
          if (paramString2.sGT == 0) {
            paramString2.sGT = 1;
          }
          y.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.source), Integer.valueOf(paramString2.sGT) });
          if (paramString3.offset == 0) {
            this.eoP = new com.tencent.mm.modelstat.h(110, true, paramString3.ebK);
          }
          if (paramg == null) {
            break;
          }
          ai.d(new l.3(this, paramg, paramString3.offset, paramString3.ebK));
          return;
          bool = false;
          break label582;
        }
      }
    }
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramInt, "", "");
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt1, com.tencent.mm.ah.g paramg, int paramInt2, l.a parama, int paramInt3)
  {
    this(3, paramString1, paramString2, paramString3, paramInt1, paramg, paramInt2, "", "", true, paramInt3);
    this.epl = new l.b(this, parama);
  }
  
  private l(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    this(4, paramString1, paramString2, paramString3, paramInt, null, 0, paramString4, paramString5, false, -1);
  }
  
  private e Ox()
  {
    if (this.dFV == null) {
      this.dFV = o.OJ().b(Long.valueOf(this.dFT));
    }
    return this.dFV;
  }
  
  private e Oy()
  {
    if (this.epj == null) {
      this.epj = o.OJ().b(Long.valueOf(this.eoN));
    }
    return this.epj;
  }
  
  private boolean a(e parame, int paramInt)
  {
    if (s.hV(this.bFH.field_talker))
    {
      y.w(this.TAG, "cdntra not use cdn user:%s", new Object[] { this.bFH.field_talker });
      return false;
    }
    com.tencent.mm.ak.f.Nd();
    if ((!com.tencent.mm.ak.b.iq(1)) && (bk.bl(parame.enA)))
    {
      localObject = this.TAG;
      com.tencent.mm.ak.f.Nd();
      y.w((String)localObject, "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.ak.b.iq(1)), parame.enA });
      return false;
    }
    if (bk.bl(this.eoQ))
    {
      y.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.dFT) });
      return false;
    }
    Object localObject = o.OJ().o(parame.enq, "", "");
    String str1 = o.OJ().o(parame.enr, "", "");
    String str4 = o.OJ().o(parame.ens, "", "");
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.dlP = this.epa;
    localf.field_mediaId = this.eoQ;
    localf.field_fileType = this.eoR;
    localf.field_talker = this.bFH.field_talker;
    int i;
    if (s.fn(this.bFH.field_talker))
    {
      i = 1;
      localf.field_chattype = i;
      localf.field_priority = com.tencent.mm.j.a.dlk;
      localf.field_needStorage = false;
      localf.field_isStreamMedia = false;
      localf.field_sendmsg_viacdn = true;
      localf.field_enable_hitcheck = this.epi;
      localf.field_force_aeskeycdn = false;
      localf.field_trysafecdn = true;
      if (paramInt != -5103237) {
        break label824;
      }
      this.eoQ = com.tencent.mm.ak.c.a("upimgjpg", this.bFH.field_createTime, this.bFH.field_talker, this.bFH.field_msgId + "_" + this.dFT + "_" + this.ent);
      localf.field_fullpath = ((String)localObject);
      localf.field_thumbpath = str4;
      localf.field_midimgpath = str1;
      localf.lastError = paramInt;
      localf.field_mediaId = this.eoQ;
      if ((localf.field_fileType == com.tencent.mm.j.a.MediaType_FULLSIZEIMAGE) && (bk.bl(localf.field_midimgpath)))
      {
        com.tencent.mm.ak.f.Nd();
        if (com.tencent.mm.ak.b.iq(256))
        {
          y.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
          localf.field_force_aeskeycdn = true;
          localf.field_trysafecdn = false;
        }
      }
      localObject = bn.s(this.epm, "msg");
      if (localObject == null) {
        break label1086;
      }
      if (this.ent == 1) {
        break label1037;
      }
      localf.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"));
      localf.field_midFileLength = bk.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localf.field_totalLen = 0;
      label542:
      localf.field_aesKey = ((String)((Map)localObject).get(".msg.img.$aeskey"));
    }
    for (;;)
    {
      if (bk.bl(localf.field_aesKey))
      {
        com.tencent.mm.ak.f.Ne();
        localf.field_aesKey = com.tencent.mm.ak.a.MW();
        y.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[] { localf.field_aesKey });
      }
      y.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[] { Integer.valueOf(parame.source), localf.field_fileId });
      this.epg = localf.field_fileId;
      this.eph = localf.field_aesKey;
      y.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[] { Boolean.valueOf(localf.field_enable_hitcheck), Integer.valueOf(localf.field_fileType), localf.field_midimgpath, localf.field_fullpath, localf.field_aesKey, localf.field_fileId, Boolean.valueOf(localf.field_enable_hitcheck), Boolean.valueOf(localf.field_force_aeskeycdn), Boolean.valueOf(localf.field_trysafecdn) });
      this.epq = null;
      if (com.tencent.mm.ak.f.Nd().c(localf)) {
        break label1110;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 205L, 1L, false);
      y.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.eoQ });
      this.eoQ = "";
      return false;
      i = 0;
      break;
      label824:
      String str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.c.class)).Ah((String)localObject);
      boolean bool3 = com.tencent.mm.sdk.platformtools.o.Zc((String)localObject).equals(".png");
      boolean bool1;
      label881:
      boolean bool4;
      if ((this.ent == 0) && (!bool3) && (av((String)localObject, str3)))
      {
        bool1 = true;
        String str2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.c.class)).Ah(str1);
        bool4 = av(str1, str2);
        if (!bool1) {
          break label1021;
        }
        localObject = str3;
        label918:
        localf.field_fullpath = ((String)localObject);
        localf.field_thumbpath = str4;
        if (!bool4) {
          break label1024;
        }
        localObject = str2;
        label941:
        localf.field_midimgpath = ((String)localObject);
        localObject = this.TAG;
        if (localf.field_fileType != com.tencent.mm.j.a.MediaType_FULLSIZEIMAGE) {
          break label1031;
        }
      }
      label1024:
      label1031:
      for (boolean bool2 = true;; bool2 = false)
      {
        y.d((String)localObject, "hevc upload full size %b, isPng %b, use hevc %b, %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool4) });
        break;
        bool1 = false;
        break label881;
        label1021:
        break label918;
        localObject = str1;
        break label941;
      }
      label1037:
      localf.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"));
      localf.field_midFileLength = bk.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localf.field_totalLen = 0;
      break label542;
      label1086:
      y.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { parame.enA });
    }
    label1110:
    if (bk.pm(parame.enA).length() <= 0)
    {
      parame.ma("CDNINFO_SEND");
      parame.bcw = 4096;
    }
    return true;
  }
  
  private boolean a(e parame, int paramInt1, long paramLong, int paramInt2, d paramd)
  {
    y.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[] { this.eoQ, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    y.d(this.TAG, "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(com.tencent.mm.platformtools.ae.eSQ) });
    long l = paramLong;
    if (10007 == com.tencent.mm.platformtools.ae.eSP)
    {
      l = paramLong;
      if (com.tencent.mm.platformtools.ae.eSQ != 0)
      {
        l = com.tencent.mm.platformtools.ae.eSQ;
        com.tencent.mm.platformtools.ae.eSQ = 0;
      }
    }
    paramLong = parame.enp;
    paramInt2 = parame.ebK;
    if (this.eoM != null) {
      ai.d(new l.6(this, paramLong, paramInt2, paramInt1));
    }
    parame.setOffset(paramInt1);
    parame.bf(l);
    if ((f.b(parame)) && (this.eoN != this.dFT))
    {
      e locale = o.OJ().b(Long.valueOf(this.eoN));
      locale.bf(l);
      locale.iC(parame.ebK);
      locale.setOffset(parame.ebK);
      o.OJ().a(Long.valueOf(this.eoN), locale);
    }
    if (f.b(parame))
    {
      if (bk.bl(this.eoQ)) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext())), Integer.valueOf(this.eoR), Integer.valueOf(parame.ebK - this.startOffset) });
      }
      this.bFH.setStatus(2);
      this.bFH.bf(l);
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.enx, this.bFH);
      if (com.tencent.mm.modelstat.r.eET != null) {
        com.tencent.mm.modelstat.r.eET.f(this.bFH);
      }
      i.iK((int)this.eoN);
      if (this.eoP != null) {
        this.eoP.cg(0L);
      }
      this.dmL.onSceneEnd(0, 0, "", this);
      if (r.eqt != null) {
        r.eqt.a(this.dFT, this.bFH, this.dmK, this.dFU, this.dGb, paramd);
      }
      if (this.epl != null) {
        this.epl.Ow();
      }
      return false;
    }
    return true;
  }
  
  private boolean av(String paramString1, String paramString2)
  {
    if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.c.class)).aGw()) {
      return false;
    }
    if (com.tencent.mm.vfs.e.aeQ(paramString1) > 0L)
    {
      if (com.tencent.mm.vfs.e.aeQ(paramString2) <= 0L)
      {
        if (!com.tencent.mm.vfs.e.bK(paramString2)) {
          com.tencent.mm.vfs.e.aeU(paramString2);
        }
        if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.c.class)).cH(paramString1, paramString2) == 0) {
          return true;
        }
        y.w(this.TAG, "file to hevc failed %s", new Object[] { paramString1 });
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  public static void bZ(long paramLong)
  {
    epr = paramLong;
  }
  
  private int iN(int paramInt)
  {
    y.e(this.TAG, "do Scene error code : " + paramInt + " hashcode : " + hashCode());
    if (this.epl != null) {
      this.epl.Ow();
    }
    return -1;
  }
  
  public static String mf(String paramString)
  {
    try
    {
      if (bk.bl(paramString)) {
        return paramString;
      }
      Object localObject = paramString.split(",");
      if ((localObject != null) && (localObject.length > 19))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        long l = epr;
        epr = -1L;
        localObject[19] = l;
        localObject = bk.c(bk.G((String[])localObject), ",");
        return localObject;
      }
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  protected final int Ka()
  {
    if (this.ent == 0) {
      return 100;
    }
    return 1350;
  }
  
  public final void Oz()
  {
    y.i(this.TAG, "send img from system");
    this.dGb = true;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().k(new l.5(this), 100L);
    int i;
    if (this.dFT < 0L)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 204L, 1L, false);
      y.e(this.TAG, "doScene invalid imgLocalId:" + this.dFT);
      i = iN(-1);
    }
    label851:
    int j;
    do
    {
      return i;
      if (this.bFH == null)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 203L, 1L, false);
        y.e(this.TAG, "doScene msg is null imgid:%d", new Object[] { Long.valueOf(this.dFT) });
        i.iL((int)this.eoN);
        return iN(-2);
      }
      this.dmL = paramf;
      c(parame);
      paramf = (cbh)this.dmK.ecE.ecN;
      e locale = Ox();
      Object localObject = o.OJ().iI((int)locale.enp);
      if (localObject != null)
      {
        if (((e)localObject).status == -1)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 202L, 1L, false);
          y.e(this.TAG, "doScene hd img info is null or error.");
          return iN(-3);
        }
      }
      else if ((locale == null) || (locale.status == -1))
      {
        y.e(this.TAG, "doScene img info is null or error.");
        return iN(-4);
      }
      if (a.a.yf().eW(this.bFH.field_talker)) {}
      String str;
      for (paramf.svK = a.a.yf().d(this.bFH);; paramf.svK = this.bFH.czr)
      {
        localObject = o.OJ().o(locale.enq, "", "");
        str = o.OJ().o(locale.ens, "", "");
        if (!bk.bl(locale.enr)) {
          o.OJ().o(locale.enr, "", "");
        }
        if ((com.tencent.mm.a.e.bJ((String)localObject) > 0) && (com.tencent.mm.a.e.bJ(str) > 0)) {
          break;
        }
        y.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[] { Long.valueOf(this.dFT), Integer.valueOf(com.tencent.mm.a.e.bJ((String)localObject)), Integer.valueOf(com.tencent.mm.a.e.bJ(str)), localObject, str });
        return iN(-5);
        localObject = bf.HR();
        if (((localObject != null) && (!((String)localObject).equals(this.bFH.czr))) || ((localObject == null) && (!bk.bl(this.bFH.czr))))
        {
          this.bFH.cY((String)localObject);
          ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.bFH.field_msgId, this.bFH);
        }
      }
      if ((paramf.tQp == null) || (bk.bl(paramf.tQp.tFO)))
      {
        if (bk.bl(this.eoQ))
        {
          y.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[] { Long.valueOf(this.bFH.field_createTime), this.bFH.field_talker, Long.valueOf(this.bFH.field_msgId), Long.valueOf(this.dFT), Integer.valueOf(this.ent) });
          this.eoQ = com.tencent.mm.ak.c.a("upimg", this.bFH.field_createTime, this.bFH.field_talker, this.bFH.field_msgId + "_" + this.dFT + "_" + this.ent);
        }
        paramf.tQp = new bml().YI(this.eoQ);
        bi localbi = this.bFH;
        localbi.cQM = this.eoQ;
        localbi.cyX = true;
      }
      if (this.startTime == 0L)
      {
        this.startTime = bk.UY();
        this.startOffset = locale.offset;
        if (this.ent != 1) {
          break label851;
        }
      }
      for (i = com.tencent.mm.j.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.j.a.MediaType_IMAGE)
      {
        this.eoR = i;
        y.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", new Object[] { localObject, str, locale.enq });
        if (!a(locale, 0)) {
          break;
        }
        y.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { paramf.tQp.tFO });
        return 0;
      }
      y.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
      i = locale.eny;
      if (i >= Ka())
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 201L, 1L, false);
        y.e(this.TAG, "doScene limit net time:" + i);
        i.iL((int)this.eoN);
        return iN(-6);
      }
      locale.iA(i + 1);
      locale.bcw = 512;
      o.OJ().a(Long.valueOf(this.dFT), locale);
      j = locale.ebK - locale.offset;
      i = j;
      if (j > this.epk) {
        i = this.epk;
      }
      if (com.tencent.mm.a.e.bJ((String)localObject) > 10485760)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 200L, 1L, false);
        y.e(this.TAG, "doScene, file size is too large");
        return iN(-7);
      }
      localObject = com.tencent.mm.a.e.c((String)localObject, locale.offset, i);
      if ((localObject == null) || (localObject.length <= 0))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 199L, 1L, false);
        y.e(this.TAG, "doScene, file read buf error.");
        return iN(-8);
      }
      paramf.ndh = localObject.length;
      paramf.ndg = locale.offset;
      paramf.ndi = new bmk().bs((byte[])localObject);
      if (this.eoP != null) {
        this.eoP.Ru();
      }
      j = a(parame, this.dmK, this);
      i = j;
    } while (j >= 0);
    y.e(this.TAG, "doScene netId error");
    i.iL((int)this.eoN);
    return iN(-9);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    paramq = (cbi)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    y.i(this.TAG, "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.eoQ);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bk.bl(this.eoQ))) {
      y.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.eoQ });
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if ((paramInt2 == 0) && (paramInt3 == 0)) {
                break;
              }
              y.e(this.TAG, "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
              com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 198L, 1L, false);
              i.iL((int)this.eoN);
              i.iK((int)this.eoN);
              com.tencent.mm.plugin.report.service.h.nFQ.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext())), Integer.valueOf(this.eoR), Integer.valueOf(0) });
              this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
            } while (this.epl == null);
            this.epl.Ow();
            return;
            this.epk = paramq.ndh;
            if (this.epk > 16384) {
              this.epk = 16384;
            }
            paramString = Ox();
            y.v(this.TAG, "onGYNetEnd localId:" + this.dFT + "  totalLen:" + paramString.ebK + " offSet:" + paramString.offset);
            if ((paramq.ndg >= 0) && ((paramq.ndg <= paramString.ebK) || (paramString.ebK <= 0))) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 197L, 1L, false);
            y.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + paramq.ndg + " img totalLen = " + paramString.ebK);
            i.iL((int)this.eoN);
            i.iK((int)this.eoN);
            com.tencent.mm.plugin.report.service.h.nFQ.f(10420, new Object[] { Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(com.tencent.mm.sdk.platformtools.ae.getContext())), Integer.valueOf(this.eoR), Integer.valueOf(0) });
            this.dmL.onSceneEnd(4, -2, "", this);
          } while (this.epl == null);
          this.epl.Ow();
          return;
          if ((paramq.ndg >= paramString.offset) && ((!f.b(paramString)) || (this.epk > 0))) {
            break;
          }
          y.e(this.TAG, "onGYNetEnd invalid data startPos = " + paramq.ndg + " totalLen = " + paramString.ebK + " off:" + paramString.offset);
          i.iL((int)this.eoN);
          i.iK((int)this.eoN);
          this.dmL.onSceneEnd(4, -1, "", this);
        } while (this.epl == null);
        this.epl.Ow();
        return;
        y.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + paramq.ndg);
      } while ((!a(paramString, paramq.ndg, paramq.ndp, paramq.mPL, null)) || (a(this.edc, this.dmL) >= 0));
      i.iK((int)this.eoN);
      this.dmL.onSceneEnd(3, -1, "", this);
    } while (this.epl == null);
    this.epl.Ow();
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 110;
  }
  
  public final void iM(int paramInt)
  {
    int i = 0;
    if (this.bFH == null) {
      y.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[] { Long.valueOf(this.enx), Integer.valueOf(paramInt) });
    }
    do
    {
      return;
      if (!this.epn) {
        break;
      }
    } while (this.bFH.cQK != 0);
    Object localObject = o.OJ();
    bi localbi = this.bFH;
    int j = this.eoU;
    String str = g.s(localbi);
    if (!bk.bl(str)) {}
    for (boolean bool = ((g)localObject).a(str, localbi.field_imgPath, j, paramInt, 0, 0);; bool = false)
    {
      localObject = this.bFH;
      paramInt = i;
      if (bool) {
        paramInt = 1;
      }
      ((cs)localObject).cQK = paramInt;
      ((cs)localObject).cyX = true;
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.enx, this.bFH);
      return;
    }
    o.OJ().a(this.bFH.field_imgPath, com.tencent.mm.cb.a.getDensity(com.tencent.mm.sdk.platformtools.ae.getContext()), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.as.l
 * JD-Core Version:    0.7.0.1
 */