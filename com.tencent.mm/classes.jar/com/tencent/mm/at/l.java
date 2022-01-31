package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.t;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import java.util.Map;
import junit.framework.Assert;

public final class l
  extends m
  implements k
{
  public static boolean DEBUG = true;
  private static long fFR;
  private String TAG;
  public String cGY;
  private com.tencent.mm.ai.f callback;
  public bi cmQ;
  private float cyV;
  private boolean eDD;
  private long eDv;
  private int eDw;
  private e eDx;
  private int fDP;
  private long fDU;
  private String fFE;
  private String fFF;
  private boolean fFG;
  private e fFH;
  private int fFI;
  l.b fFJ;
  private String fFK;
  public String fFL;
  public boolean fFM;
  private float fFN;
  private String fFO;
  private String fFP;
  public String fFQ;
  private final com.tencent.mm.ai.g fFj;
  public long fFk;
  private com.tencent.mm.modelstat.h fFn;
  private String fFo;
  private int fFp;
  private int fFs;
  private g.a fFy;
  private final com.tencent.mm.ai.b rr;
  private int scene;
  private int startOffset;
  private long startTime;
  
  public l(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78337);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.fFE = "";
    this.fFF = "";
    this.fFG = true;
    this.fFI = 16384;
    this.fDP = 0;
    this.cmQ = null;
    this.fFn = null;
    this.fFo = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fFp = 0;
    this.fFJ = new l.b(this, null);
    this.fFy = new l.4(this);
    this.eDD = false;
    ab.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bo.dtY() });
    this.fFk = paramInt1;
    this.eDv = paramInt1;
    this.fDP = paramInt2;
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new con();
    ((b.a)localObject1).fsY = new coo();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((b.a)localObject1).funcId = 110;
    ((b.a)localObject1).reqCmdId = 9;
    ((b.a)localObject1).respCmdId = 1000000009;
    this.rr = ((b.a)localObject1).ado();
    this.fFj = null;
    ab.d(this.TAG, "FROM B SERVICE:" + this.fFk);
    if (!i.lx((int)this.fFk))
    {
      this.fFk = -1L;
      AppMethodBeat.o(78337);
      return;
    }
    localObject1 = o.ahC().b(Long.valueOf(this.fFk));
    this.fDU = ((e)localObject1).fDU;
    if (paramInt2 == 1)
    {
      this.eDv = ((e)localObject1).fDW;
      localObject1 = o.ahC().b(Long.valueOf(this.eDv));
    }
    for (;;)
    {
      Object localObject2 = o.ahC().lw((int)((e)localObject1).fDL);
      if (localObject2 != null) {
        this.fDU = ((e)localObject2).fDU;
      }
      this.cmQ = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.fDU);
      if ((this.cmQ != null) && (this.cmQ.field_msgId != this.fDU))
      {
        ab.w(this.TAG, "init get msg by id failed:%d", new Object[] { Long.valueOf(this.fDU) });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 206L, 1L, false);
        this.cmQ = null;
        AppMethodBeat.o(78337);
        return;
      }
      if (this.cmQ != null)
      {
        localObject2 = (con)this.rr.fsV.fta;
        ((con)localObject2).woP = new bwc().aoF(com.tencent.mm.model.r.Zn());
        ((con)localObject2).woQ = new bwc().aoF(this.cmQ.field_talker);
        ((con)localObject2).pIy = ((e)localObject1).offset;
        ((con)localObject2).pIx = ((e)localObject1).fsd;
        ((con)localObject2).nqW = this.cmQ.getType();
        ((con)localObject2).xdn = paramInt2;
        if (!ac.cm(ah.getContext())) {
          break label807;
        }
      }
      label807:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((con)localObject2).wLO = paramInt1;
        ((con)localObject2).xPK = ((e)localObject1).cpt;
        ((con)localObject2).wDr = ((e)localObject1).fDQ;
        ((con)localObject2).wDr = ((e)localObject1).fDQ;
        ((con)localObject2).xXr = this.cmQ.dGT;
        ((con)localObject2).xXs = this.cmQ.dGS;
        a locala = f.tb(this.cmQ.field_content);
        if ((locala != null) && (!bo.isNullOrNil(locala.appId)))
        {
          this.eDw = ((e)localObject1).cpt;
          ((con)localObject2).fKw = locala.appId;
          ((con)localObject2).wmD = locala.mediaTagName;
          ((con)localObject2).wmF = locala.messageAction;
          ((con)localObject2).wmE = locala.messageExt;
          this.fFK = this.cmQ.field_content;
        }
        ab.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((con)localObject2).xXr), Integer.valueOf(((con)localObject2).xXs) });
        ab.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((e)localObject1).cpt), Integer.valueOf(((con)localObject2).wDr) });
        if (((e)localObject1).offset == 0) {
          this.fFn = new com.tencent.mm.modelstat.h(getType(), true, ((e)localObject1).fsd);
        }
        AppMethodBeat.o(78337);
        return;
      }
    }
  }
  
  public l(int paramInt1, int paramInt2, byte paramByte)
  {
    AppMethodBeat.i(78338);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.fFE = "";
    this.fFF = "";
    this.fFG = true;
    this.fFI = 16384;
    this.fDP = 0;
    this.cmQ = null;
    this.fFn = null;
    this.fFo = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fFp = 0;
    this.fFJ = new l.b(this, null);
    this.fFy = new l.4(this);
    this.eDD = false;
    ab.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null, bo.dtY() });
    this.fFk = paramInt1;
    this.eDv = paramInt1;
    this.fDP = paramInt2;
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new con();
    ((b.a)localObject1).fsY = new coo();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((b.a)localObject1).funcId = 110;
    ((b.a)localObject1).reqCmdId = 9;
    ((b.a)localObject1).respCmdId = 1000000009;
    this.rr = ((b.a)localObject1).ado();
    this.fFj = null;
    ab.d(this.TAG, "FROM C SERVICE:" + this.fFk);
    if (!i.lx((int)this.fFk))
    {
      this.fFk = -1L;
      AppMethodBeat.o(78338);
      return;
    }
    localObject1 = o.ahC().b(Long.valueOf(this.fFk));
    this.fDU = ((e)localObject1).fDU;
    ((e)localObject1).setStatus(0);
    ((e)localObject1).fP(0L);
    ((e)localObject1).setOffset(0);
    o.ahC().a((int)this.eDv, (e)localObject1);
    if (paramInt2 == 1)
    {
      this.eDv = ((e)localObject1).fDW;
      localObject1 = o.ahC().b(Long.valueOf(this.eDv));
    }
    for (;;)
    {
      this.cmQ = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.fDU);
      Object localObject2;
      if (this.cmQ != null)
      {
        this.cmQ.setStatus(1);
        localObject2 = ((e)localObject1).fDO;
        if ((localObject2 == null) || (!((String)localObject2).startsWith("THUMBNAIL_DIRPATH://"))) {
          break label739;
        }
        this.cmQ.kk((String)localObject2);
        ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.fDU, this.cmQ);
        localObject2 = (con)this.rr.fsV.fta;
        ((con)localObject2).woP = new bwc().aoF(com.tencent.mm.model.r.Zn());
        ((con)localObject2).woQ = new bwc().aoF(this.cmQ.field_talker);
        ((con)localObject2).pIy = ((e)localObject1).offset;
        ((con)localObject2).pIx = ((e)localObject1).fsd;
        ((con)localObject2).nqW = this.cmQ.getType();
        ((con)localObject2).xdn = paramInt2;
        if (!ac.cm(ah.getContext())) {
          break label770;
        }
      }
      label770:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((con)localObject2).wLO = paramInt1;
        ((con)localObject2).xPK = ((e)localObject1).cpt;
        ((con)localObject2).wDr = ((e)localObject1).fDQ;
        ((con)localObject2).xXr = this.cmQ.dGT;
        ((con)localObject2).xXs = this.cmQ.dGS;
        ab.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((con)localObject2).xXr), Integer.valueOf(((con)localObject2).xXs) });
        ab.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((e)localObject1).cpt), Integer.valueOf(((con)localObject2).wDr) });
        if (((e)localObject1).offset == 0) {
          this.fFn = new com.tencent.mm.modelstat.h(getType(), true, ((e)localObject1).fsd);
        }
        AppMethodBeat.o(78338);
        return;
        label739:
        this.cmQ.kk("THUMBNAIL://" + ((e)localObject1).fDL);
        break;
      }
    }
  }
  
  public l(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.ai.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, 0, -1000.0F, -1000.0F, -1L);
  }
  
  public l(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.ai.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(78334);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.fFE = "";
    this.fFF = "";
    this.fFG = true;
    this.fFI = 16384;
    this.fDP = 0;
    this.cmQ = null;
    this.fFn = null;
    this.fFo = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fFp = 0;
    this.fFJ = new l.b(this, null);
    this.fFy = new l.4(this);
    this.eDD = false;
    ab.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramg, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt4), Boolean.TRUE, bo.dtY(), Integer.valueOf(paramInt5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.fFM = paramBoolean;
    this.fFs = paramInt4;
    this.fFj = paramg;
    this.fDP = paramInt2;
    this.scene = paramInt5;
    this.cyV = paramFloat2;
    this.fFN = paramFloat1;
    this.eDw = paramInt1;
    this.fFQ = paramString3;
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    this.fFK = paramString4;
    localPString.value = paramString5;
    paramString5 = null;
    if (paramLong > 0L)
    {
      paramString5 = o.ahC().b(Long.valueOf(paramLong));
      paramString5 = o.ahC().q(paramString5.fDR, "", "");
    }
    this.fFk = o.ahC().a(paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2, "", "", -1L, null, null, null);
    this.eDv = this.fFk;
    ab.i(this.TAG, "FROM A UI :" + paramString2 + " " + this.fFk);
    if ((this.fFk < 0L) || (!i.lx((int)this.fFk)))
    {
      ab.e(this.TAG, "insert to img storage failed id:" + this.fFk);
      this.fDU = -1L;
      this.rr = null;
      AppMethodBeat.o(78334);
      return;
    }
    if (this.fFk >= 0L)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      paramString3 = new b.a();
      paramString3.fsX = new con();
      paramString3.fsY = new coo();
      paramString3.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
      paramString3.funcId = 110;
      paramString3.reqCmdId = 9;
      paramString3.respCmdId = 1000000009;
      this.rr = paramString3.ado();
      this.cGY = paramString2;
      this.cmQ = new bi();
      this.cmQ.setType(t.oG(paramString2));
      this.cmQ.kj(paramString2);
      this.cmQ.hL(1);
      this.cmQ.setStatus(1);
      this.cmQ.kk(localPString.value);
      this.cmQ.hW(localPInt1.value);
      this.cmQ.hX(localPInt2.value);
      this.cmQ.fQ(bf.py(this.cmQ.field_talker));
      this.cmQ.setContent(paramString4);
      a.a.Ky().g(this.cmQ);
      this.fDU = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Z(this.cmQ);
      if (this.fDU < 0L) {
        break label1335;
      }
      paramBoolean = true;
      label763:
      Assert.assertTrue(paramBoolean);
      ab.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.fDU);
      paramString3 = ahq();
      paramString3.gQ((int)this.fDU);
      o.ahC().a(Long.valueOf(this.fFk), paramString3);
      if (paramInt2 != 1) {
        break label1352;
      }
      this.eDv = paramString3.fDW;
      paramString3 = ahp();
    }
    label1031:
    label1335:
    label1347:
    label1352:
    for (;;)
    {
      paramString3.lq(com.tencent.mm.a.e.cM(o.ahC().q(paramString3.fDM, "", "")));
      o.ahC().a(Long.valueOf(this.eDv), paramString3);
      ab.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.eDv + " img len = " + paramString3.fsd);
      paramString5 = (con)this.rr.fsV.fta;
      paramString5.woP = new bwc().aoF(paramString1);
      paramString5.woQ = new bwc().aoF(paramString2);
      paramString5.pIy = paramString3.offset;
      paramString5.pIx = paramString3.fsd;
      paramString5.nqW = this.cmQ.getType();
      paramString5.xdn = paramInt2;
      if (ac.cm(ah.getContext()))
      {
        paramInt3 = 1;
        paramString5.wLO = paramInt3;
        paramString5.xPK = paramString3.cpt;
        paramString5.wDr = paramString3.fDQ;
        paramString5.xXr = localPInt2.value;
        paramString5.xXs = localPInt1.value;
        paramString1 = f.tb(paramString4);
        if ((paramString1 != null) && (!bo.isNullOrNil(paramString1.appId)))
        {
          paramString5.fKw = paramString1.appId;
          paramString5.wmD = paramString1.mediaTagName;
          paramString5.wmF = paramString1.messageAction;
          paramString5.wmE = paramString1.messageExt;
        }
        ab.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString5.xXr), Integer.valueOf(paramString5.xXs) });
        if (paramString5.wDr == 0) {
          if (paramInt1 != 4) {
            break label1347;
          }
        }
      }
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        paramString5.wDr = paramInt1;
        ab.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.cpt), Integer.valueOf(paramString5.wDr) });
        if (paramString3.offset == 0) {
          this.fFn = new com.tencent.mm.modelstat.h(getType(), true, paramString3.fsd);
        }
        paramLong = System.currentTimeMillis();
        lA(paramInt2);
        ab.d(this.TAG, "hy: create HDThumb using %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
        if (paramg != null) {
          al.d(new l.2(this, paramg, paramString3.offset, paramString3.fsd));
        }
        AppMethodBeat.o(78334);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label763;
        paramInt3 = 2;
        break label1031;
      }
    }
  }
  
  public l(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, com.tencent.mm.ai.g paramg, int paramInt2, String paramString4, String paramString5)
  {
    AppMethodBeat.i(78335);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.fFE = "";
    this.fFF = "";
    this.fFG = true;
    this.fFI = 16384;
    this.fDP = 0;
    this.cmQ = null;
    this.fFn = null;
    this.fFo = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fFp = 0;
    this.fFJ = new l.b(this, null);
    this.fFy = new l.4(this);
    this.eDD = false;
    ab.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(3), paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), paramg, Integer.valueOf(paramInt2), paramString4, paramString5, Boolean.TRUE, Integer.valueOf(2130838228), Boolean.TRUE, bo.dtY() });
    this.fFM = true;
    this.fFs = 2130838228;
    this.fFj = paramg;
    this.fDP = paramInt1;
    this.eDw = 3;
    this.fFQ = paramString3;
    paramString5 = new PInt();
    PInt localPInt = new PInt();
    this.fFK = paramString4;
    this.fFk = paramLong;
    this.eDv = this.fFk;
    paramString3 = ahq();
    this.cmQ = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(paramString3.fDU);
    this.fDU = this.cmQ.field_msgId;
    localPInt.value = this.cmQ.dGT;
    paramString5.value = this.cmQ.dGS;
    if (paramInt1 == 1)
    {
      this.eDv = paramString3.fDW;
      this.eDx = null;
      paramString3 = ahp();
    }
    for (;;)
    {
      if ((this.cmQ.field_talker != null) && (!this.cmQ.field_talker.equals(paramString2)))
      {
        ab.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString2, this.cmQ.field_talker });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(594L, 4L, 1L, true);
      }
      for (paramString4 = this.cmQ.field_talker;; paramString4 = paramString2)
      {
        ab.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.cmQ.field_msgId);
        ab.d(this.TAG, "FROM A UI :" + paramString2 + "   msg:" + paramString4 + this.fFk);
        if ((this.fFk < 0L) || (!i.lx((int)this.fFk)))
        {
          ab.e(this.TAG, "insert to img storage failed id:" + this.fFk);
          this.fDU = -1L;
          this.rr = null;
          AppMethodBeat.o(78335);
          return;
        }
        boolean bool;
        if (this.fFk >= 0L)
        {
          bool = true;
          Assert.assertTrue(bool);
          paramString2 = new b.a();
          paramString2.fsX = new con();
          paramString2.fsY = new coo();
          paramString2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
          paramString2.funcId = 110;
          paramString2.reqCmdId = 9;
          paramString2.respCmdId = 1000000009;
          this.rr = paramString2.ado();
          ab.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.eDv + " img len = " + paramString3.fsd);
          paramString2 = (con)this.rr.fsV.fta;
          paramString2.woP = new bwc().aoF(paramString1);
          paramString2.woQ = new bwc().aoF(paramString4);
          paramString2.pIy = paramString3.offset;
          paramString2.pIx = paramString3.fsd;
          paramString2.nqW = this.cmQ.getType();
          paramString2.xdn = paramInt1;
          if (!ac.cm(ah.getContext())) {
            break label1027;
          }
        }
        label1027:
        for (paramInt1 = 1;; paramInt1 = 2)
        {
          paramString2.wLO = paramInt1;
          paramString2.xPK = paramString3.cpt;
          paramString2.wDr = paramString3.fDQ;
          paramString2.xXr = localPInt.value;
          paramString2.xXs = paramString5.value;
          ab.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString2.xXr), Integer.valueOf(paramString2.xXs) });
          if (paramString2.wDr == 0) {
            paramString2.wDr = 1;
          }
          ab.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.cpt), Integer.valueOf(paramString2.wDr) });
          if (paramString3.offset == 0) {
            this.fFn = new com.tencent.mm.modelstat.h(getType(), true, paramString3.fsd);
          }
          al.d(new l.3(this, paramg, paramString3.offset, paramString3.fsd));
          AppMethodBeat.o(78335);
          return;
          bool = false;
          break;
        }
      }
    }
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramInt, "", "");
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt1, com.tencent.mm.ai.g paramg, int paramInt2, l.a parama)
  {
    this(3, paramString1, paramString2, paramString3, paramInt1, paramg, paramInt2, "", "", true, 2130838228);
    AppMethodBeat.i(78333);
    this.fFJ = new l.b(this, parama);
    AppMethodBeat.o(78333);
  }
  
  private l(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    this(4, paramString1, paramString2, paramString3, paramInt, null, 0, paramString4, paramString5, false, -1);
  }
  
  private boolean a(e parame, int paramInt)
  {
    AppMethodBeat.i(78339);
    if (t.oE(this.cmQ.field_talker))
    {
      ab.w(this.TAG, "cdntra not use cdn user:%s", new Object[] { this.cmQ.field_talker });
      AppMethodBeat.o(78339);
      return false;
    }
    com.tencent.mm.al.f.afO();
    if ((!com.tencent.mm.al.b.lc(1)) && (bo.isNullOrNil(parame.fDX)))
    {
      localObject = this.TAG;
      com.tencent.mm.al.f.afO();
      ab.w((String)localObject, "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.al.b.lc(1)), parame.fDX });
      AppMethodBeat.o(78339);
      return false;
    }
    if (bo.isNullOrNil(this.fFo))
    {
      ab.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.eDv) });
      AppMethodBeat.o(78339);
      return false;
    }
    String str2 = o.ahC().q(parame.fDM, "", "");
    String str1 = o.ahC().q(parame.fDN, "", "");
    String str4 = o.ahC().q(parame.fDO, "", "");
    Object localObject = o.ahC().q(parame.fDR, "", "");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.edp = this.fFy;
    localg.field_mediaId = this.fFo;
    localg.field_fileType = this.fFp;
    localg.field_talker = this.cmQ.field_talker;
    int i;
    if (t.lA(this.cmQ.field_talker))
    {
      i = 1;
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.ecF;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_sendmsg_viacdn = true;
      localg.field_enable_hitcheck = this.fFG;
      localg.field_force_aeskeycdn = false;
      localg.field_trysafecdn = true;
      if (paramInt != -5103237) {
        break label870;
      }
      this.fFo = com.tencent.mm.al.c.a("upimgjpg", this.cmQ.field_createTime, this.cmQ.field_talker, this.cmQ.field_msgId + "_" + this.eDv + "_" + this.fDP);
      localg.field_fullpath = str2;
      localg.field_thumbpath = str4;
      localg.field_midimgpath = str1;
      localg.lastError = paramInt;
      localg.field_mediaId = this.fFo;
      if ((localg.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) && (bo.isNullOrNil(localg.field_midimgpath)))
      {
        com.tencent.mm.al.f.afO();
        if (com.tencent.mm.al.b.lc(256))
        {
          ab.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
          localg.field_force_aeskeycdn = true;
          localg.field_trysafecdn = false;
        }
      }
      localObject = br.F(this.fFK, "msg");
      if (localObject == null) {
        break label1202;
      }
      if (this.fDP == 1) {
        break label1153;
      }
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"));
      localg.field_midFileLength = bo.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      label582:
      localg.field_aesKey = ((String)((Map)localObject).get(".msg.img.$aeskey"));
    }
    for (;;)
    {
      if (bo.isNullOrNil(localg.field_aesKey))
      {
        com.tencent.mm.al.f.afP();
        localg.field_aesKey = com.tencent.mm.al.a.afG();
        ab.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[] { localg.field_aesKey });
      }
      ab.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[] { Integer.valueOf(parame.cpt), localg.field_fileId });
      this.fFE = localg.field_fileId;
      this.fFF = localg.field_aesKey;
      ab.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[] { Boolean.valueOf(localg.field_enable_hitcheck), Integer.valueOf(localg.field_fileType), localg.field_midimgpath, localg.field_fullpath, localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn) });
      this.fFP = null;
      if (com.tencent.mm.al.f.afO().e(localg)) {
        break label1226;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 205L, 1L, false);
      ab.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.fFo });
      this.fFo = "";
      AppMethodBeat.o(78339);
      return false;
      i = 0;
      break;
      label870:
      boolean bool2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).bkf();
      String str3;
      boolean bool3;
      if ((this.eDw == 4) && (com.tencent.mm.vfs.e.cN((String)localObject)))
      {
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).Kf(str1);
        bool3 = aO(str1, str3);
        if (!bool2) {
          break label1133;
        }
        label935:
        localg.field_fullpath = ((String)localObject);
        localg.field_thumbpath = str4;
        if (!bool3) {
          break label1140;
        }
        localObject = str3;
        label958:
        localg.field_midimgpath = ((String)localObject);
        localObject = this.TAG;
        if (localg.field_fileType != com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) {
          break label1147;
        }
      }
      label1133:
      label1140:
      label1147:
      for (boolean bool1 = true;; bool1 = false)
      {
        ab.d((String)localObject, "hevc upload full size %b, use hevc %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        break;
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).Kf(str2);
        bool1 = com.tencent.mm.sdk.platformtools.r.apa(str2).equals(".png");
        if ((this.fDP == 0) && (!bool1) && (aO(str2, str3))) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          localObject = str3;
          if (!bool1) {
            break;
          }
          parame.ta(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).Kf(parame.fDM));
          bool2 = bool1;
          localObject = str3;
          break;
        }
        localObject = str2;
        break label935;
        localObject = str1;
        break label958;
      }
      label1153:
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"));
      localg.field_midFileLength = bo.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      break label582;
      label1202:
      ab.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { parame.fDX });
    }
    label1226:
    if (bo.nullAsNil(parame.fDX).length() <= 0)
    {
      parame.sZ("CDNINFO_SEND");
      parame.bsY = 4096;
    }
    AppMethodBeat.o(78339);
    return true;
  }
  
  private boolean a(e parame, int paramInt1, long paramLong, int paramInt2, d paramd)
  {
    AppMethodBeat.i(78345);
    ab.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[] { this.fFo, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    ab.i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(ae.gkL), Long.valueOf(this.fFk), Long.valueOf(this.eDv) });
    long l = paramLong;
    if (10007 == ae.gkK)
    {
      l = paramLong;
      if (ae.gkL != 0)
      {
        l = ae.gkL;
        ae.gkL = 0;
      }
    }
    b(parame.fDL, paramInt1, parame.fsd);
    parame.setOffset(paramInt1);
    parame.fP(l);
    if ((f.b(parame)) && (this.fFk != this.eDv))
    {
      e locale = o.ahC().b(Long.valueOf(this.fFk));
      locale.fP(l);
      locale.lq(parame.fsd);
      locale.setOffset(parame.fsd);
      o.ahC().a(Long.valueOf(this.fFk), locale);
    }
    if (f.b(parame))
    {
      if (bo.isNullOrNil(this.fFo)) {
        com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fFp), Integer.valueOf(parame.fsd - this.startOffset) });
      }
      this.cmQ.setStatus(2);
      this.cmQ.fP(l);
      ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.fDU, this.cmQ);
      if (com.tencent.mm.modelstat.r.fUK != null) {
        com.tencent.mm.modelstat.r.fUK.j(this.cmQ);
      }
      if (this.fFn != null) {
        this.fFn.hc(0L);
      }
      if (r.fGU != null) {
        r.fGU.a(this.eDv, this.cmQ, this.rr, this.eDw, this.eDD, paramd);
      }
      if (this.fFJ != null) {
        this.fFJ.aho();
      }
      this.callback.onSceneEnd(0, 0, "", this);
      i.ly((int)this.fFk);
      AppMethodBeat.o(78345);
      return false;
    }
    AppMethodBeat.o(78345);
    return true;
  }
  
  private boolean aO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78340);
    if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).bkf())
    {
      AppMethodBeat.o(78340);
      return false;
    }
    if (com.tencent.mm.vfs.e.avI(paramString1) > 0L)
    {
      if (com.tencent.mm.vfs.e.avI(paramString2) > 0L)
      {
        com.tencent.mm.plugin.report.service.h.qsU.cT(944, 9);
        com.tencent.mm.vfs.e.deleteFile(paramString2);
      }
      if (!com.tencent.mm.vfs.e.cN(paramString2)) {
        com.tencent.mm.vfs.e.avL(paramString2);
      }
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).dI(paramString1, paramString2) == 0)
      {
        AppMethodBeat.o(78340);
        return true;
      }
      ab.w(this.TAG, "file to hevc failed %s", new Object[] { paramString1 });
    }
    AppMethodBeat.o(78340);
    return false;
  }
  
  private e ahp()
  {
    AppMethodBeat.i(78331);
    if (this.eDx == null) {
      this.eDx = o.ahC().b(Long.valueOf(this.eDv));
    }
    e locale = this.eDx;
    AppMethodBeat.o(78331);
    return locale;
  }
  
  private e ahq()
  {
    AppMethodBeat.i(78332);
    if (this.fFH == null) {
      this.fFH = o.ahC().b(Long.valueOf(this.fFk));
    }
    e locale = this.fFH;
    AppMethodBeat.o(78332);
    return locale;
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78346);
    if (this.fFj != null) {
      al.d(new l.6(this, paramLong, paramInt2, paramInt1));
    }
    AppMethodBeat.o(78346);
  }
  
  public static void gU(long paramLong)
  {
    fFR = paramLong;
  }
  
  private int lB(int paramInt)
  {
    AppMethodBeat.i(78342);
    ab.e(this.TAG, "do Scene error code : " + paramInt + " hashcode : " + hashCode());
    if (this.fFJ != null) {
      this.fFJ.aho();
    }
    AppMethodBeat.o(78342);
    return -1;
  }
  
  public static String tk(String paramString)
  {
    AppMethodBeat.i(78347);
    try
    {
      boolean bool = bo.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(78347);
        return paramString;
      }
      Object localObject = paramString.split(",");
      if ((localObject != null) && (localObject.length > 19))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        long l = fFR;
        fFR = -1L;
        localObject[19] = l;
        localObject = bo.d(bo.P((String[])localObject), ",");
        AppMethodBeat.o(78347);
        return localObject;
      }
      AppMethodBeat.o(78347);
      return paramString;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(78347);
    }
    return paramString;
  }
  
  public final void ahr()
  {
    AppMethodBeat.i(78344);
    ab.i(this.TAG, "send img from system");
    this.eDD = true;
    AppMethodBeat.o(78344);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(78341);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().o(new l.5(this), 100L);
    if (this.eDv < 0L)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 204L, 1L, false);
      ab.e(this.TAG, "doScene invalid imgLocalId:" + this.eDv);
      i = lB(-1);
      AppMethodBeat.o(78341);
      return i;
    }
    if (this.cmQ == null)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 203L, 1L, false);
      ab.e(this.TAG, "doScene msg is null imgid:%d", new Object[] { Long.valueOf(this.eDv) });
      i.lz((int)this.fFk);
      i = lB(-2);
      AppMethodBeat.o(78341);
      return i;
    }
    this.callback = paramf;
    prepareDispatcher(parame);
    paramf = (con)this.rr.fsV.fta;
    e locale = ahp();
    Object localObject = o.ahC().lw((int)locale.fDL);
    if (localObject != null)
    {
      if (((e)localObject).status == -1)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 202L, 1L, false);
        ab.e(this.TAG, "doScene hd img info is null or error.");
        i = lB(-3);
        AppMethodBeat.o(78341);
        return i;
      }
    }
    else if ((locale == null) || (locale.status == -1))
    {
      ab.e(this.TAG, "doScene img info is null or error.");
      i = lB(-4);
      AppMethodBeat.o(78341);
      return i;
    }
    if (a.a.Ky().lg(this.cmQ.field_talker)) {}
    String str;
    for (paramf.woU = a.a.Ky().h(this.cmQ);; paramf.woU = this.cmQ.dns)
    {
      localObject = o.ahC().q(locale.fDM, "", "");
      str = o.ahC().q(locale.fDO, "", "");
      if (!bo.isNullOrNil(locale.fDN)) {
        o.ahC().q(locale.fDN, "", "");
      }
      if ((com.tencent.mm.a.e.cM((String)localObject) > 0) && (com.tencent.mm.a.e.cM(str) > 0)) {
        break;
      }
      ab.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[] { Long.valueOf(this.eDv), Integer.valueOf(com.tencent.mm.a.e.cM((String)localObject)), Integer.valueOf(com.tencent.mm.a.e.cM(str)), localObject, str });
      i = lB(-5);
      AppMethodBeat.o(78341);
      return i;
      localObject = bh.aaQ();
      if (((localObject != null) && (!((String)localObject).equals(this.cmQ.dns))) || ((localObject == null) && (!bo.isNullOrNil(this.cmQ.dns))))
      {
        this.cmQ.jl((String)localObject);
        ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.cmQ.field_msgId, this.cmQ);
      }
    }
    if ((paramf.xXk == null) || (bo.isNullOrNil(paramf.xXk.xJE)))
    {
      if (bo.isNullOrNil(this.fFo))
      {
        ab.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[] { Long.valueOf(this.cmQ.field_createTime), this.cmQ.field_talker, Long.valueOf(this.cmQ.field_msgId), Long.valueOf(this.eDv), Integer.valueOf(this.fDP) });
        this.fFo = com.tencent.mm.al.c.a("upimg", this.cmQ.field_createTime, this.cmQ.field_talker, this.cmQ.field_msgId + "_" + this.eDv + "_" + this.fDP);
      }
      paramf.xXk = new bwc().aoF(this.fFo);
      bi localbi = this.cmQ;
      localbi.dGY = this.fFo;
      localbi.dmY = true;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bo.aoy();
      this.startOffset = locale.offset;
      if (this.fDP != 1) {
        break label901;
      }
    }
    label901:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.fFp = i;
      ab.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", new Object[] { localObject, str, locale.fDM });
      if (!a(locale, 0)) {
        break;
      }
      ab.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { paramf.xXk.xJE });
      AppMethodBeat.o(78341);
      return 0;
    }
    ab.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
    i = locale.fDV;
    if (i >= securityLimitCount())
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 201L, 1L, false);
      ab.e(this.TAG, "doScene limit net time:".concat(String.valueOf(i)));
      i.lz((int)this.fFk);
      i = lB(-6);
      AppMethodBeat.o(78341);
      return i;
    }
    locale.lo(i + 1);
    locale.bsY = 512;
    o.ahC().a(Long.valueOf(this.eDv), locale);
    int j = locale.fsd - locale.offset;
    i = j;
    if (j > this.fFI) {
      i = this.fFI;
    }
    com.tencent.mm.a.e.cM((String)localObject);
    localObject = com.tencent.mm.a.e.i((String)localObject, locale.offset, i);
    if ((localObject == null) || (localObject.length <= 0))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 199L, 1L, false);
      ab.e(this.TAG, "doScene, file read buf error.");
      i = lB(-8);
      AppMethodBeat.o(78341);
      return i;
    }
    paramf.pIz = localObject.length;
    paramf.pIy = locale.offset;
    paramf.pIA = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
    if (this.fFn != null) {
      this.fFn.akD();
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0)
    {
      ab.e(this.TAG, "doScene netId error");
      i.lz((int)this.fFk);
      i = lB(-9);
      AppMethodBeat.o(78341);
      return i;
    }
    AppMethodBeat.o(78341);
    return i;
  }
  
  public final int getType()
  {
    return 110;
  }
  
  public final void lA(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(78336);
    if (this.cmQ == null)
    {
      ab.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[] { Long.valueOf(this.fDU), Integer.valueOf(paramInt) });
      AppMethodBeat.o(78336);
      return;
    }
    if (this.fFM)
    {
      if (this.cmQ.dGW == 0)
      {
        boolean bool = o.ahC().a(this.cmQ, this.fFs, paramInt);
        bi localbi = this.cmQ;
        if (bool) {}
        for (paramInt = i;; paramInt = 0)
        {
          localbi.hZ(paramInt);
          ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.fDU, this.cmQ);
          AppMethodBeat.o(78336);
          return;
        }
      }
    }
    else {
      o.ahC().a(this.cmQ.field_imgPath, com.tencent.mm.cb.a.getDensity(ah.getContext()), true);
    }
    AppMethodBeat.o(78336);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78343);
    paramq = (coo)((com.tencent.mm.ai.b)paramq).fsW.fta;
    ab.i(this.TAG, "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.fFo);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bo.isNullOrNil(this.fFo)))
    {
      ab.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.fFo });
      AppMethodBeat.o(78343);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e(this.TAG, "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 198L, 1L, false);
      i.lz((int)this.fFk);
      i.ly((int)this.fFk);
      com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fFp), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.fFJ != null) {
        this.fFJ.aho();
      }
      AppMethodBeat.o(78343);
      return;
    }
    this.fFI = paramq.pIz;
    if (this.fFI > 16384) {
      this.fFI = 16384;
    }
    paramString = ahp();
    ab.v(this.TAG, "onGYNetEnd localId:" + this.eDv + "  totalLen:" + paramString.fsd + " offSet:" + paramString.offset);
    if ((paramq.pIy < 0) || ((paramq.pIy > paramString.fsd) && (paramString.fsd > 0)))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 197L, 1L, false);
      ab.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + paramq.pIy + " img totalLen = " + paramString.fsd);
      i.lz((int)this.fFk);
      i.ly((int)this.fFk);
      com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fFp), Integer.valueOf(0) });
      this.callback.onSceneEnd(4, -2, "", this);
      if (this.fFJ != null) {
        this.fFJ.aho();
      }
      AppMethodBeat.o(78343);
      return;
    }
    if ((paramq.pIy < paramString.offset) || ((f.b(paramString)) && (this.fFI <= 0)))
    {
      ab.e(this.TAG, "onGYNetEnd invalid data startPos = " + paramq.pIy + " totalLen = " + paramString.fsd + " off:" + paramString.offset);
      i.lz((int)this.fFk);
      i.ly((int)this.fFk);
      this.callback.onSceneEnd(4, -1, "", this);
      if (this.fFJ != null) {
        this.fFJ.aho();
      }
      AppMethodBeat.o(78343);
      return;
    }
    ab.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + paramq.pIy);
    if ((a(paramString, paramq.pIy, paramq.pIG, paramq.CreateTime, null)) && (doScene(dispatcher(), this.callback) < 0))
    {
      i.ly((int)this.fFk);
      this.callback.onSceneEnd(3, -1, "", this);
      if (this.fFJ != null) {
        this.fFJ.aho();
      }
    }
    AppMethodBeat.o(78343);
  }
  
  public final int securityLimitCount()
  {
    if (this.fDP == 0) {
      return 100;
    }
    return 1350;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.at.l
 * JD-Core Version:    0.7.0.1
 */