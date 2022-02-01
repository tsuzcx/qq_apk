package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class m
  extends n
  implements com.tencent.mm.network.k
{
  String TAG;
  com.tencent.mm.ak.f callback;
  bv dlw;
  int glf;
  long gzw;
  int hPI;
  private boolean hPz;
  private int icr;
  final com.tencent.mm.ak.g idS;
  public final long idT;
  private long idU;
  private int idV;
  private com.tencent.mm.modelstat.h idW;
  String idX;
  private String idY;
  public String idZ;
  int iea;
  public boolean ieb;
  private int iec;
  private String ied;
  private int iee;
  boolean ief;
  private g.a ieg;
  private long msgId;
  private final com.tencent.mm.ak.b rr;
  private int startOffset;
  long startTime;
  private int token;
  
  public m(long paramLong1, long paramLong2, int paramInt, com.tencent.mm.ak.g paramg)
  {
    this(paramLong1, paramLong2, paramInt, paramg, -1);
  }
  
  public m(long paramLong1, long paramLong2, int paramInt1, final com.tencent.mm.ak.g paramg, int paramInt2)
  {
    AppMethodBeat.i(150673);
    this.TAG = "MicroMsg.NetSceneGetMsgImg";
    this.idU = -1L;
    this.idW = null;
    this.msgId = -1L;
    this.dlw = null;
    this.idX = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.glf = 0;
    this.hPz = true;
    this.idY = "";
    this.idZ = "";
    this.hPI = 0;
    this.iea = -1;
    this.ieb = false;
    this.iec = -1;
    this.ied = null;
    this.iee = 0;
    this.token = -1;
    this.ief = false;
    this.ieg = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150671);
        if (paramAnonymousInt == -21006)
        {
          ae.i(m.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { m.this.idX });
          AppMethodBeat.o(150671);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        int k;
        if (paramAnonymousInt != 0)
        {
          k.pB((int)m.this.idT);
          k.pA((int)m.this.idT);
          l1 = m.this.startTime;
          l2 = com.tencent.mm.sdk.platformtools.bu.fpO();
          i = com.tencent.mm.an.c.cC(ak.getContext());
          j = m.this.glf;
          k = m.this.hPI;
          if (paramAnonymousd == null)
          {
            paramAnonymousString = "";
            if (paramAnonymousd != null) {
              break label304;
            }
          }
          label304:
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fKX)
          {
            paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc });
            new j(paramAnonymousString).aLH();
            new com.tencent.mm.g.b.a.h(paramAnonymousString).aLH();
            m.this.callback.onSceneEnd(3, paramAnonymousInt, "", m.this);
            AppMethodBeat.o(150671);
            return 0;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break;
          }
        }
        g localg = q.aIX().c(Long.valueOf(m.this.gzw));
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == m.this.hPI)
          {
            ae.d(m.this.TAG, "cdntra ignore progress 100%");
            AppMethodBeat.o(150671);
            return 0;
          }
          m.this.ief = true;
          if (!m.this.ieb) {
            m.this.ieb = paramAnonymousc.field_mtlnotify;
          }
          ae.i(m.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[] { m.this.idX, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), Boolean.valueOf(m.this.ieb) });
          m.a(m.this, localg, m.this.hPI, localg.offset, (int)paramAnonymousc.field_finishedLength - localg.offset);
          AppMethodBeat.o(150671);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label965;
          }
          k.pA((int)m.this.idT);
          ae.e(m.this.TAG, "cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          m.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", m.this);
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = m.this.startTime;
          l2 = com.tencent.mm.sdk.platformtools.bu.fpO();
          i = com.tencent.mm.an.c.cC(ak.getContext());
          j = m.this.glf;
          k = m.this.hPI;
          if (paramAnonymousd != null) {
            break label1338;
          }
          paramAnonymousString = "";
          label628:
          if (paramAnonymousd != null) {
            break label1347;
          }
          paramAnonymousc = "";
          label636:
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aLH();
          if (paramAnonymousd.field_retCode != 0)
          {
            paramAnonymousInt = paramAnonymousd.field_retCode;
            l1 = m.this.startTime;
            l2 = com.tencent.mm.sdk.platformtools.bu.fpO();
            i = com.tencent.mm.an.c.cC(ak.getContext());
            j = m.this.glf;
            k = m.this.hPI;
            if (paramAnonymousd != null) {
              break label1356;
            }
            paramAnonymousString = "";
            label824:
            if (paramAnonymousd != null) {
              break label1365;
            }
          }
        }
        label965:
        label1356:
        label1365:
        for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fKX)
        {
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aLH();
          AppMethodBeat.o(150671);
          return 0;
          ae.i(m.this.TAG, "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramAnonymousd.field_convert2baseline) });
          if (localg.icr == 1)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 26L, localg.hPI, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 27L, 1L, false);
            paramAnonymousc = com.tencent.mm.plugin.report.service.g.yxI;
            if (m.this.dlw != null)
            {
              paramAnonymousString = m.this.dlw.field_talker;
              if (!x.wb(paramAnonymousString)) {
                break label1194;
              }
            }
            for (l1 = 29L;; l1 = 28L)
            {
              paramAnonymousc.idkeyStat(198L, l1, 1L, false);
              if (paramAnonymousd.field_convert2baseline)
              {
                ae.i(m.this.TAG, "cdntra need convert2baseline. file:%s", new Object[] { m.this.idZ });
                paramAnonymousBoolean = MMNativeJpeg.Convert2Baseline(m.this.idZ, 60);
                ae.i(m.this.TAG, "convert result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              }
              if (!m.this.ief) {
                break label1300;
              }
              m.a(m.this, localg, localg.offset, localg.offset, 0);
              break;
              paramAnonymousString = "";
              break label1059;
            }
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 21L, localg.hPI, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 22L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.g.yxI;
          if (m.this.dlw != null)
          {
            paramAnonymousString = m.this.dlw.field_talker;
            label1260:
            if (!x.wb(paramAnonymousString)) {
              break label1292;
            }
          }
          for (l1 = 24L;; l1 = 23L)
          {
            paramAnonymousc.idkeyStat(198L, l1, 1L, false);
            break;
            paramAnonymousString = "";
            break label1260;
          }
          m.a(m.this, localg, m.this.hPI, localg.offset, m.this.hPI - localg.offset);
          break;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label628;
          paramAnonymousc = paramAnonymousd.fKX;
          break label636;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label824;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    boolean bool;
    g localg;
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (paramg != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.idS = paramg;
      this.icr = paramInt1;
      this.idT = paramLong1;
      this.idU = paramLong1;
      this.gzw = paramLong1;
      this.msgId = paramLong2;
      this.iec = paramInt2;
      localg = q.aIX().c(Long.valueOf(this.gzw));
      if (paramInt1 != 1) {
        break label595;
      }
      this.gzw = localg.icz;
      localg = q.aIX().c(Long.valueOf(this.gzw));
    }
    label595:
    for (;;)
    {
      this.TAG = (this.TAG + "[" + this.gzw + "]");
      Object localObject = new b.a();
      ((b.a)localObject).hQF = new bez();
      ((b.a)localObject).hQG = new bfa();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getmsgimg";
      ((b.a)localObject).funcId = 109;
      ((b.a)localObject).hQH = 10;
      ((b.a)localObject).respCmdId = 1000000010;
      this.rr = ((b.a)localObject).aDS();
      localObject = (bez)this.rr.hQD.hQJ;
      this.dlw = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramLong2);
      ((bez)localObject).xsC = localg.offset;
      ((bez)localObject).xsB = localg.hPI;
      ae.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[] { Integer.valueOf(localg.offset), Integer.valueOf(localg.hPI), com.tencent.mm.sdk.platformtools.bu.fpN() });
      ((bez)localObject).xrk = this.dlw.field_msgSvrId;
      ((bez)localObject).FNG = new cxn().aQV(this.dlw.field_talker);
      ((bez)localObject).FNH = new cxn().aQV((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, null));
      ((bez)localObject).GUb = paramInt1;
      if (localg.offset == 0) {
        this.idW = new com.tencent.mm.modelstat.h(getType(), false, localg.hPI);
      }
      this.idV = 8192;
      if (paramg != null) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150670);
            paramg.a(this.iei, this.iej, m.this);
            AppMethodBeat.o(150670);
          }
        });
      }
      AppMethodBeat.o(150673);
      return;
      bool = false;
      break;
    }
  }
  
  private boolean a(final g paramg, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150678);
    paramg.pq(paramInt1);
    paramg.setOffset(paramInt2 + paramInt3);
    this.idV = paramInt3;
    if (paramArrayOfByte != null) {
      o.e(this.idZ, paramArrayOfByte, paramArrayOfByte.length);
    }
    ae.d(this.TAG, "onGYNetEnd : offset = " + paramg.offset + " totalLen = " + paramg.hPI + " stack:[%s]", new Object[] { com.tencent.mm.sdk.platformtools.bu.fpN() });
    String str2 = null;
    paramArrayOfByte = str2;
    String str1;
    boolean bool1;
    String str3;
    com.tencent.mm.vfs.k localk;
    String str4;
    if (paramg.aIA())
    {
      str1 = u.aRI(this.idZ);
      bool1 = u.aRF(this.idZ);
      str3 = this.idZ + "_hevc";
      localk = new com.tencent.mm.vfs.k(this.idZ);
      boolean bool2 = u.aRH(this.idZ);
      paramArrayOfByte = str1;
      if (!bool2) {
        break label563;
      }
      if (this.hPz) {
        break label453;
      }
      ae.e(this.TAG, "sceneEndproc: download jpg get hevc");
      bool1 = false;
      paramArrayOfByte = str1;
      if (!bool1) {
        break label611;
      }
      str2 = this.idY + paramArrayOfByte;
      str1 = q.aIX().o(this.idY, null, paramArrayOfByte);
      ae.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[] { paramArrayOfByte, this.idY, this.idZ, str1 });
      paramArrayOfByte = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abV(str2);
      str4 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abV(str1);
      if (!bool2) {
        break label566;
      }
      new com.tencent.mm.vfs.k(str3).ag(new com.tencent.mm.vfs.k(str4));
      localk.ag(new com.tencent.mm.vfs.k(str1));
      label371:
      paramg.FF(str2);
      paramg.FJ(paramArrayOfByte);
      paramg.FE(h.FL(str1));
      paramg.pv(this.icr);
    }
    for (paramArrayOfByte = str1;; paramArrayOfByte = str2)
    {
      if (q.aIX().a(Long.valueOf(this.gzw), paramg) >= 0) {
        break label669;
      }
      ae.e(this.TAG, "onGYNetEnd : update img fail");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150678);
      return false;
      label453:
      localk.ag(new com.tencent.mm.vfs.k(str3));
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(str3, this.idZ) != 0)
      {
        ae.w(this.TAG, "download hevc decode failed");
        this.hPz = false;
        o.deleteFile(str3);
        o.deleteFile(this.idZ);
        d(paramg);
        AppMethodBeat.o(150678);
        return false;
      }
      paramArrayOfByte = u.aRI(this.idZ);
      ae.i(this.TAG, "hevc download is hevc %b", new Object[] { Boolean.TRUE });
      label563:
      break;
      label566:
      if (o.aZR(str4) > 0L)
      {
        o.deleteFile(str4);
        com.tencent.mm.plugin.report.service.g.yxI.dD(944, 10);
      }
      localk.ag(new com.tencent.mm.vfs.k(str1));
      break label371;
      label611:
      if (this.icr == 1)
      {
        paramArrayOfByte = q.aIX().c(Long.valueOf(this.idU));
        paramArrayOfByte.pr(0);
        q.aIX().a(Long.valueOf(this.idU), paramArrayOfByte);
      }
      localk.delete();
    }
    label669:
    if (this.idS != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150672);
          m.this.idS.a(paramg.offset, paramg.hPI, m.this);
          AppMethodBeat.o(150672);
        }
      });
    }
    ae.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[] { Boolean.valueOf(paramg.aIA()), this.idX });
    if (paramg.aIA())
    {
      if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(this.idX)) {
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.glf), Integer.valueOf(paramInt1 - this.startOffset) });
      }
      bool1 = false;
      if (this.iea > 0) {
        bool1 = q.aIX().a(paramArrayOfByte, paramg.icq, this.iea, 1, this.dlw.fmo, this.dlw.fmp);
      }
      if (bool1)
      {
        paramg.aIC();
        ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.dlw.field_msgId, this.dlw);
      }
      q.aIX().a(Long.valueOf(this.gzw), paramg);
      ae.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[] { this.idZ, paramArrayOfByte, paramg.ico, this.ied });
      if (this.idW != null) {
        this.idW.sB(paramg.hPI);
      }
      if ((!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(this.ied)) && (this.iee > 0))
      {
        com.tencent.mm.plugin.image.c.dfJ();
        com.tencent.mm.plugin.image.c.azN().G(this.ied, this.iee, paramArrayOfByte);
      }
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(150678);
      return false;
    }
    AppMethodBeat.o(150678);
    return true;
  }
  
  private boolean d(g paramg)
  {
    AppMethodBeat.i(150674);
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramg.icA))
    {
      AppMethodBeat.o(150674);
      return false;
    }
    Map localMap = bx.M(paramg.icA, "msg");
    if (localMap == null)
    {
      ae.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { paramg.icA });
      AppMethodBeat.o(150674);
      return false;
    }
    this.hPI = 0;
    String str2;
    String str1;
    if (this.icr != 1)
    {
      str2 = (String)localMap.get(".msg.img.$cdnmidimgurl");
      this.hPI = com.tencent.mm.sdk.platformtools.bu.getInt((String)localMap.get(".msg.img.$length"), 0);
      if (this.icr == 1) {
        break label296;
      }
      str3 = (String)localMap.get(".msg.img.$tpurl");
      str1 = str3;
      if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str3)) {
        break label348;
      }
      this.hPI = com.tencent.mm.sdk.platformtools.bu.getInt((String)localMap.get(".msg.img.$tplength"), 0);
      str1 = str3;
    }
    label296:
    label348:
    for (;;)
    {
      ae.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", new Object[] { Integer.valueOf(this.icr), Integer.valueOf(this.hPI), str2, str1 });
      if ((!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str2)) || (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str1))) {
        break label351;
      }
      ae.e(this.TAG, "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(150674);
      return false;
      str2 = (String)localMap.get(".msg.img.$cdnbigimgurl");
      this.hPI = com.tencent.mm.sdk.platformtools.bu.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
      break;
      str3 = (String)localMap.get(".msg.img.$tphdurl");
      str1 = str3;
      if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str3))
      {
        this.hPI = com.tencent.mm.sdk.platformtools.bu.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
        str1 = str3;
      }
    }
    label351:
    String str3 = (String)localMap.get(".msg.img.$aeskey");
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str3))
    {
      ae.e(this.TAG, "cdntra get aes key failed.");
      AppMethodBeat.o(150674);
      return false;
    }
    this.idX = com.tencent.mm.an.c.a("downimg", paramg.icw, this.dlw.field_talker, this.dlw.field_msgId);
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(this.idX))
    {
      ae.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.gzw) });
      AppMethodBeat.o(150674);
      return false;
    }
    String str4 = (String)localMap.get(".msg.img.$md5");
    int i;
    boolean bool;
    if ((com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str1)) && (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str4)) && ((com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localMap.get(".msg.img.$cdnbigimgurl"))) || (this.icr == 1)))
    {
      com.tencent.mm.plugin.image.c.dfJ();
      String str5 = com.tencent.mm.plugin.image.c.azN().gz(str4, this.hPI);
      i = (int)o.aZR(str5);
      int j = this.hPI - i;
      String str6 = this.TAG;
      int k = this.hPI;
      Object localObject = localMap.get(".msg.img.$cdnbigimgurl");
      if (this.icr == 1)
      {
        bool = true;
        ae.i(str6, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", new Object[] { Integer.valueOf(k), str4, localObject, Boolean.valueOf(bool), Integer.valueOf(i), str5, Integer.valueOf(j), this.idZ });
        if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str5)) {
          break label913;
        }
        if ((j < 0) || (j > 16)) {
          break label927;
        }
        bool = false;
        if (!com.tencent.mm.sdk.platformtools.bu.lX(str5, this.idZ)) {
          if (o.mF(str5, this.idZ) < 0L) {
            break label907;
          }
        }
      }
      label907:
      for (bool = true;; bool = false)
      {
        ae.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[] { str5, this.idZ, Boolean.valueOf(bool) });
        a(paramg, this.hPI, this.hPI, 0, null);
        if (this.dlw != null) {
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(new i.c(this.dlw.field_talker, "update", this.dlw));
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(13267, new Object[] { str2, Long.valueOf(this.dlw.field_msgSvrId), str4, Long.valueOf(this.dlw.field_createTime / 1000L), this.dlw.field_talker, Integer.valueOf(3), Integer.valueOf(i) });
        AppMethodBeat.o(150674);
        return true;
        bool = false;
        break;
      }
      label913:
      this.ied = str4;
      this.iee = this.hPI;
    }
    label927:
    if ((this.hPz) && (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).chd()))
    {
      bool = true;
      ae.i(this.TAG, "checkUseCdn: %s, %s", new Object[] { Boolean.valueOf(this.hPz), Boolean.valueOf(bool) });
      paramg = new com.tencent.mm.i.g();
      if (!bool) {
        break label1364;
      }
      paramg.fLl = "task_NetSceneGetMsgImg_1";
      paramg.field_mediaId = this.idX;
      label1014:
      paramg.field_fullpath = this.idZ;
      paramg.field_fileType = this.glf;
      paramg.field_totalLen = this.hPI;
      paramg.field_aesKey = str3;
      paramg.field_fileId = str2;
      paramg.field_priority = com.tencent.mm.i.a.fKA;
      paramg.fLm = this.ieg;
      if (!x.wb(this.dlw.field_talker)) {
        break label1401;
      }
      i = 1;
      label1080:
      paramg.field_chattype = i;
      if (!bool) {
        break label1406;
      }
      i = 2;
      label1092:
      paramg.expectImageFormat = i;
      if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str1))
      {
        str2 = (String)localMap.get(".msg.img.$tpauthkey");
        paramg.field_fileType = 19;
        paramg.field_authKey = str2;
        paramg.fLp = str1;
        paramg.field_fileId = "";
      }
      ae.i(this.TAG, "cdnautostart %s %b", new Object[] { "image_" + this.dlw.field_msgId, Boolean.valueOf(com.tencent.mm.an.f.aGZ().hWG.contains("image_" + this.dlw.field_msgId)) });
      if (!com.tencent.mm.an.f.aGZ().hWG.contains("image_" + this.dlw.field_msgId)) {
        break label1411;
      }
      com.tencent.mm.an.f.aGZ().hWG.remove("image_" + this.dlw.field_msgId);
    }
    label1411:
    for (paramg.field_autostart = true;; paramg.field_autostart = false)
    {
      if (com.tencent.mm.an.f.aGZ().b(paramg, this.iec)) {
        break label1419;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 196L, 1L, false);
      ae.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.idX });
      this.idX = "";
      AppMethodBeat.o(150674);
      return false;
      bool = false;
      break;
      label1364:
      paramg.fLl = "task_NetSceneGetMsgImg_2";
      paramg.field_mediaId = (this.idX + "_hevc");
      break label1014;
      label1401:
      i = 0;
      break label1080;
      label1406:
      i = 1;
      break label1092;
    }
    label1419:
    ae.i(this.TAG, "add recv task");
    AppMethodBeat.o(150674);
    return true;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150675);
    if ((!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(this.idX)) && (com.tencent.mm.an.f.aGZ() != null))
    {
      ae.d(this.TAG, "cancel recv task");
      com.tencent.mm.an.f.aGZ().Fs(this.idX);
    }
    super.cancel();
    AppMethodBeat.o(150675);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(150676);
    this.callback = paramf;
    paramf = (bez)this.rr.hQD.hQJ;
    g localg = q.aIX().c(Long.valueOf(this.gzw));
    if (localg.doE == 0L)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 195L, 1L, false);
      ae.e(this.TAG, "doScene id:%d  img:%s", new Object[] { Long.valueOf(this.gzw), localg });
      AppMethodBeat.o(150676);
      return -1;
    }
    if (localg.status != 0)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 194L, 1L, false);
      ae.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[] { Long.valueOf(localg.doE), Integer.valueOf(localg.status) });
      AppMethodBeat.o(150676);
      return -1;
    }
    String str = localg.ico;
    if (str.startsWith("SERVERID://"))
    {
      this.idY = com.tencent.mm.b.g.getMessageDigest(localg.ico.getBytes());
      this.idZ = q.aIX().o(this.idY, null, ".temp");
      localg.FF(this.idY + ".temp");
      q.aIX().a(Long.valueOf(this.gzw), localg);
      ae.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[] { Long.valueOf(localg.doE), Integer.valueOf(this.icr), Integer.valueOf(localg.offset), Integer.valueOf(localg.hPI), str, this.idY, this.idZ });
      if (this.startTime == 0L)
      {
        this.startTime = com.tencent.mm.sdk.platformtools.bu.fpO();
        this.startOffset = localg.offset;
        if (this.icr != 1) {
          break label452;
        }
      }
    }
    label452:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.glf = i;
      if (!d(localg)) {
        break label459;
      }
      ae.d(this.TAG, "cdntra this img use cdn : %s", new Object[] { this.idX });
      AppMethodBeat.o(150676);
      return 0;
      this.idY = localg.ico;
      this.idZ = q.aIX().o(this.idY, null, "");
      break;
    }
    label459:
    ae.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[] { this.idX });
    localg.FI("");
    localg.dEu = 4096;
    q.aIX().a(Long.valueOf(this.gzw), localg);
    paramf.xsC = localg.offset;
    paramf.xsD = this.idV;
    paramf.xsB = localg.hPI;
    if (this.idW != null) {
      this.idW.aMf();
    }
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150676);
    return i;
  }
  
  public final int getType()
  {
    return 109;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150677);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(this.idX)))
    {
      ae.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.idX });
      AppMethodBeat.o(150677);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 193L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.glf), Integer.valueOf(this.hPI - this.startOffset) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150677);
      return;
    }
    paramString = (bfa)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    paramq = q.aIX().c(Long.valueOf(this.gzw));
    paramInt1 = 0;
    if (paramString.xsD <= 0)
    {
      ae.e(this.TAG, "flood control, malformed data_len");
      paramInt1 = -1;
    }
    while (paramInt1 != 0)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 192L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.glf), Integer.valueOf(this.hPI - this.startOffset) });
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(150677);
      return;
      if ((paramString.xsE == null) || (paramString.xsD != paramString.xsE.getILen()))
      {
        ae.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
        paramInt1 = -1;
      }
      else if ((paramString.xsC < 0) || (paramString.xsC + paramString.xsD > paramString.xsB))
      {
        ae.e(this.TAG, "flood control, malformed start pos");
        paramInt1 = -1;
      }
      else if (paramString.xsC != paramq.offset)
      {
        ae.e(this.TAG, "flood control, malformed start_pos");
        paramInt1 = -1;
      }
      else if (paramString.xsB <= 0)
      {
        ae.e(this.TAG, "flood control, malformed total_len");
        paramInt1 = -1;
      }
    }
    if ((a(paramq, paramString.xsB, paramString.xsC, paramString.xsD, paramString.xsE.getBuffer().zr)) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(150677);
  }
  
  public final int securityLimitCount()
  {
    if (this.icr == 0) {
      return 100;
    }
    return 1280;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.m
 * JD-Core Version:    0.7.0.1
 */