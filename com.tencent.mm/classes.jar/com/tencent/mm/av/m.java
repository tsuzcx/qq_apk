package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.an.f;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.protocal.protobuf.bqw;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class m
  extends com.tencent.mm.ak.q
  implements com.tencent.mm.network.m
{
  String TAG;
  com.tencent.mm.ak.i callback;
  ca dCM;
  int gVY;
  long hmj;
  private boolean iKG;
  int iKP;
  private int iXp;
  final j iYO;
  public final long iYP;
  private long iYQ;
  private int iYR;
  private com.tencent.mm.modelstat.h iYS;
  String iYT;
  private String iYU;
  public String iYV;
  int iYW;
  public boolean iYX;
  private int iYY;
  private String iYZ;
  private int iZa;
  boolean iZb;
  private g.a iZc;
  private long msgId;
  private final com.tencent.mm.ak.d rr;
  private int startOffset;
  long startTime;
  private int token;
  
  public m(long paramLong1, long paramLong2, int paramInt, j paramj)
  {
    this(paramLong1, paramLong2, paramInt, paramj, -1);
  }
  
  public m(long paramLong1, long paramLong2, int paramInt1, final j paramj, int paramInt2)
  {
    AppMethodBeat.i(150673);
    this.TAG = "MicroMsg.NetSceneGetMsgImg";
    this.iYQ = -1L;
    this.iYS = null;
    this.msgId = -1L;
    this.dCM = null;
    this.iYT = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.gVY = 0;
    this.iKG = true;
    this.iYU = "";
    this.iYV = "";
    this.iKP = 0;
    this.iYW = -1;
    this.iYX = false;
    this.iYY = -1;
    this.iYZ = null;
    this.iZa = 0;
    this.token = -1;
    this.iZb = false;
    this.iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150671);
        if (paramAnonymousInt == -21006)
        {
          Log.i(m.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { m.this.iYT });
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
          k.tp((int)m.this.iYP);
          k.to((int)m.this.iYP);
          l1 = m.this.startTime;
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
          j = m.this.gVY;
          k = m.this.iKP;
          if (paramAnonymousd == null)
          {
            paramAnonymousString = "";
            if (paramAnonymousd != null) {
              break label304;
            }
          }
          label304:
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.gqk)
          {
            paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc });
            new y(paramAnonymousString).bfK();
            new w(paramAnonymousString).bfK();
            m.this.callback.onSceneEnd(3, paramAnonymousInt, "", m.this);
            AppMethodBeat.o(150671);
            return 0;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break;
          }
        }
        g localg = q.bcR().c(Long.valueOf(m.this.hmj));
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == m.this.iKP)
          {
            Log.d(m.this.TAG, "cdntra ignore progress 100%");
            AppMethodBeat.o(150671);
            return 0;
          }
          m.this.iZb = true;
          if (!m.this.iYX) {
            m.this.iYX = paramAnonymousc.field_mtlnotify;
          }
          Log.i(m.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[] { m.this.iYT, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), Boolean.valueOf(m.this.iYX) });
          m.a(m.this, localg, m.this.iKP, localg.offset, (int)paramAnonymousc.field_finishedLength - localg.offset);
          AppMethodBeat.o(150671);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label965;
          }
          k.to((int)m.this.iYP);
          Log.e(m.this.TAG, "cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          m.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", m.this);
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = m.this.startTime;
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
          j = m.this.gVY;
          k = m.this.iKP;
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
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).bfK();
          if (paramAnonymousd.field_retCode != 0)
          {
            paramAnonymousInt = paramAnonymousd.field_retCode;
            l1 = m.this.startTime;
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
            j = m.this.gVY;
            k = m.this.iKP;
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
        for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.gqk)
        {
          new w(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).bfK();
          AppMethodBeat.o(150671);
          return 0;
          Log.i(m.this.TAG, "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramAnonymousd.field_convert2baseline) });
          if (localg.iXp == 1)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 26L, localg.iKP, false);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 27L, 1L, false);
            paramAnonymousc = com.tencent.mm.plugin.report.service.h.CyF;
            if (m.this.dCM != null)
            {
              paramAnonymousString = m.this.dCM.field_talker;
              if (!ab.Eq(paramAnonymousString)) {
                break label1194;
              }
            }
            for (l1 = 29L;; l1 = 28L)
            {
              paramAnonymousc.idkeyStat(198L, l1, 1L, false);
              if (paramAnonymousd.field_convert2baseline)
              {
                Log.i(m.this.TAG, "cdntra need convert2baseline. file:%s", new Object[] { m.this.iYV });
                paramAnonymousBoolean = MMNativeJpeg.Convert2Baseline(m.this.iYV, 60);
                Log.i(m.this.TAG, "convert result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              }
              if (!m.this.iZb) {
                break label1300;
              }
              m.a(m.this, localg, localg.offset, localg.offset, 0);
              break;
              paramAnonymousString = "";
              break label1059;
            }
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 21L, localg.iKP, false);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 22L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.CyF;
          if (m.this.dCM != null)
          {
            paramAnonymousString = m.this.dCM.field_talker;
            label1260:
            if (!ab.Eq(paramAnonymousString)) {
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
          m.a(m.this, localg, m.this.iKP, localg.offset, m.this.iKP - localg.offset);
          break;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label628;
          paramAnonymousc = paramAnonymousd.gqk;
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
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (paramj != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.iYO = paramj;
      this.iXp = paramInt1;
      this.iYP = paramLong1;
      this.iYQ = paramLong1;
      this.hmj = paramLong1;
      this.msgId = paramLong2;
      this.iYY = paramInt2;
      localg = q.bcR().c(Long.valueOf(this.hmj));
      if (paramInt1 != 1) {
        break label595;
      }
      this.hmj = localg.iXx;
      localg = q.bcR().c(Long.valueOf(this.hmj));
    }
    label595:
    for (;;)
    {
      this.TAG = (this.TAG + "[" + this.hmj + "]");
      Object localObject = new d.a();
      ((d.a)localObject).iLN = new bqv();
      ((d.a)localObject).iLO = new bqw();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getmsgimg";
      ((d.a)localObject).funcId = 109;
      ((d.a)localObject).iLP = 10;
      ((d.a)localObject).respCmdId = 1000000010;
      this.rr = ((d.a)localObject).aXF();
      localObject = (bqv)this.rr.iLK.iLR;
      this.dCM = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(paramLong2);
      ((bqv)localObject).BsG = localg.offset;
      ((bqv)localObject).BsF = localg.iKP;
      Log.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[] { Integer.valueOf(localg.offset), Integer.valueOf(localg.iKP), Util.getStack() });
      ((bqv)localObject).Brn = this.dCM.field_msgSvrId;
      ((bqv)localObject).KHl = new dqi().bhy(this.dCM.field_talker);
      ((bqv)localObject).KHm = new dqi().bhy((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null));
      ((bqv)localObject).LYt = paramInt1;
      if (localg.offset == 0) {
        this.iYS = new com.tencent.mm.modelstat.h(getType(), false, localg.iKP);
      }
      this.iYR = 8192;
      if (paramj != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150670);
            paramj.a(this.iZe, this.iZf, m.this);
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
    paramg.tf(paramInt1);
    paramg.setOffset(paramInt2 + paramInt3);
    this.iYR = paramInt3;
    if (paramArrayOfByte != null) {
      com.tencent.mm.vfs.s.e(this.iYV, paramArrayOfByte, paramArrayOfByte.length);
    }
    Log.d(this.TAG, "onGYNetEnd : offset = " + paramg.offset + " totalLen = " + paramg.iKP + " stack:[%s]", new Object[] { Util.getStack() });
    String str1 = null;
    paramArrayOfByte = str1;
    boolean bool1;
    o localo;
    if (paramg.bcu())
    {
      paramArrayOfByte = ImgUtil.identifyImgType(this.iYV);
      bool1 = ImgUtil.isImgFile(this.iYV);
      localo = new o(this.iYV);
      if (ImgUtil.isWXGF(this.iYV))
      {
        Log.i(this.TAG, "hevc download is hevc %s", new Object[] { Boolean.valueOf(bool1) });
        str2 = com.tencent.mm.vfs.s.k(this.iYV, false);
        str2 = str2 + "_temp";
        paramInt2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(this.iYV, str2);
        paramInt3 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYx, 1);
        Log.i(this.TAG, "convert jpg: %s path %s, config %s", new Object[] { Integer.valueOf(paramInt2), str2, Integer.valueOf(paramInt3) });
        if (paramInt2 != 0) {
          bool1 = false;
        }
        for (;;)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          this.iKG = false;
          com.tencent.mm.vfs.s.deleteFile(this.iYV);
          d(paramg);
          AppMethodBeat.o(150678);
          return false;
          paramArrayOfByte = ImgUtil.identifyImgType(str2);
          if (paramInt3 == 1)
          {
            com.tencent.mm.vfs.s.nx(str2, this.iYV);
          }
          else
          {
            String str3 = q.bcR().o(this.iYU, null, paramArrayOfByte);
            str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(str3);
            com.tencent.mm.vfs.s.nx(this.iYV, str3);
            com.tencent.mm.vfs.s.nx(str2, this.iYV);
            paramg.Ou(str3);
          }
        }
      }
      boolean bool2 = bool1;
      if (!bool2) {
        break label592;
      }
      String str2 = this.iYU + paramArrayOfByte;
      str1 = q.bcR().o(this.iYU, null, paramArrayOfByte);
      Log.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[] { paramArrayOfByte, this.iYU, this.iYV, str1 });
      localo.am(new o(str1));
      paramg.Oq(str2);
      paramg.Op(h.Ow(str1));
      paramg.tk(this.iXp);
    }
    for (paramArrayOfByte = str1; q.bcR().a(Long.valueOf(this.hmj), paramg) < 0; paramArrayOfByte = str1)
    {
      Log.e(this.TAG, "onGYNetEnd : update img fail");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150678);
      return false;
      label592:
      if (this.iXp == 1)
      {
        paramArrayOfByte = q.bcR().c(Long.valueOf(this.iYQ));
        paramArrayOfByte.tg(0);
        q.bcR().a(Long.valueOf(this.iYQ), paramArrayOfByte);
      }
      localo.delete();
    }
    if (this.iYO != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150672);
          m.this.iYO.a(paramg.offset, paramg.iKP, m.this);
          AppMethodBeat.o(150672);
        }
      });
    }
    Log.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[] { Boolean.valueOf(paramg.bcu()), this.iYT });
    if (paramg.bcu())
    {
      if (Util.isNullOrNil(this.iYT)) {
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), Integer.valueOf(paramInt1 - this.startOffset) });
      }
      bool1 = false;
      if (this.iYW > 0) {
        bool1 = q.bcR().a(paramArrayOfByte, paramg.iXo, this.iYW, 1, this.dCM.fQS, this.dCM.fQT);
      }
      if (bool1)
      {
        paramg.bcw();
        ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.dCM.field_msgId, this.dCM);
      }
      q.bcR().a(Long.valueOf(this.hmj), paramg);
      Log.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[] { this.iYV, paramArrayOfByte, paramg.iXm, this.iYZ });
      if (this.iYS != null) {
        this.iYS.AH(paramg.iKP);
      }
      if ((!Util.isNullOrNil(this.iYZ)) && (this.iZa > 0))
      {
        com.tencent.mm.plugin.image.c.dZD();
        com.tencent.mm.plugin.image.c.aSV().P(this.iYZ, this.iZa, paramArrayOfByte);
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
    if (Util.isNullOrNil(paramg.iXy))
    {
      AppMethodBeat.o(150674);
      return false;
    }
    Map localMap = XmlParser.parseXml(paramg.iXy, "msg", null);
    if (localMap == null)
    {
      Log.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { paramg.iXy });
      AppMethodBeat.o(150674);
      return false;
    }
    this.iKP = 0;
    String str2;
    String str1;
    if (this.iXp != 1)
    {
      str2 = (String)localMap.get(".msg.img.$cdnmidimgurl");
      this.iKP = Util.getInt((String)localMap.get(".msg.img.$length"), 0);
      if (this.iXp == 1) {
        break label297;
      }
      str3 = (String)localMap.get(".msg.img.$tpurl");
      str1 = str3;
      if (Util.isNullOrNil(str3)) {
        break label349;
      }
      this.iKP = Util.getInt((String)localMap.get(".msg.img.$tplength"), 0);
      str1 = str3;
    }
    label297:
    label349:
    for (;;)
    {
      Log.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", new Object[] { Integer.valueOf(this.iXp), Integer.valueOf(this.iKP), str2, str1 });
      if ((!Util.isNullOrNil(str2)) || (!Util.isNullOrNil(str1))) {
        break label352;
      }
      Log.e(this.TAG, "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(150674);
      return false;
      str2 = (String)localMap.get(".msg.img.$cdnbigimgurl");
      this.iKP = Util.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
      break;
      str3 = (String)localMap.get(".msg.img.$tphdurl");
      str1 = str3;
      if (!Util.isNullOrNil(str3))
      {
        this.iKP = Util.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
        str1 = str3;
      }
    }
    label352:
    String str3 = (String)localMap.get(".msg.img.$aeskey");
    if (Util.isNullOrNil(str3))
    {
      Log.e(this.TAG, "cdntra get aes key failed.");
      AppMethodBeat.o(150674);
      return false;
    }
    this.iYT = com.tencent.mm.an.c.a("downimg", paramg.iXu, this.dCM.field_talker, this.dCM.field_msgId);
    if (Util.isNullOrNil(this.iYT))
    {
      Log.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.hmj) });
      AppMethodBeat.o(150674);
      return false;
    }
    String str4 = (String)localMap.get(".msg.img.$md5");
    int i;
    boolean bool;
    if ((Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str4)) && ((Util.isNullOrNil((String)localMap.get(".msg.img.$cdnbigimgurl"))) || (this.iXp == 1)))
    {
      com.tencent.mm.plugin.image.c.dZD();
      String str5 = com.tencent.mm.plugin.image.c.aSV().gS(str4, this.iKP);
      i = (int)com.tencent.mm.vfs.s.boW(str5);
      int j = this.iKP - i;
      String str6 = this.TAG;
      int k = this.iKP;
      Object localObject = localMap.get(".msg.img.$cdnbigimgurl");
      if (this.iXp == 1)
      {
        bool = true;
        Log.i(str6, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", new Object[] { Integer.valueOf(k), str4, localObject, Boolean.valueOf(bool), Integer.valueOf(i), str5, Integer.valueOf(j), this.iYV });
        if (Util.isNullOrNil(str5)) {
          break label914;
        }
        if ((j < 0) || (j > 16)) {
          break label928;
        }
        bool = false;
        if (!Util.isEqual(str5, this.iYV)) {
          if (com.tencent.mm.vfs.s.nw(str5, this.iYV) < 0L) {
            break label908;
          }
        }
      }
      label908:
      for (bool = true;; bool = false)
      {
        Log.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[] { str5, this.iYV, Boolean.valueOf(bool) });
        a(paramg, this.iKP, this.iKP, 0, null);
        if (this.dCM != null) {
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(this.dCM.field_talker, "update", this.dCM));
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(13267, new Object[] { str2, Long.valueOf(this.dCM.field_msgSvrId), str4, Long.valueOf(this.dCM.field_createTime / 1000L), this.dCM.field_talker, Integer.valueOf(3), Integer.valueOf(i) });
        AppMethodBeat.o(150674);
        return true;
        bool = false;
        break;
      }
      label914:
      this.iYZ = str4;
      this.iZa = this.iKP;
    }
    label928:
    if ((this.iKG) && (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).cEP()))
    {
      bool = true;
      Log.i(this.TAG, "checkUseCdn: %s, %s", new Object[] { Boolean.valueOf(this.iKG), Boolean.valueOf(bool) });
      paramg = new com.tencent.mm.i.g();
      if (!bool) {
        break label1365;
      }
      paramg.taskName = "task_NetSceneGetMsgImg_1";
      paramg.field_mediaId = this.iYT;
      label1015:
      paramg.field_fullpath = this.iYV;
      paramg.field_fileType = this.gVY;
      paramg.field_totalLen = this.iKP;
      paramg.field_aesKey = str3;
      paramg.field_fileId = str2;
      paramg.field_priority = com.tencent.mm.i.a.gpM;
      paramg.gqy = this.iZc;
      if (!ab.Eq(this.dCM.field_talker)) {
        break label1402;
      }
      i = 1;
      label1081:
      paramg.field_chattype = i;
      if (!bool) {
        break label1407;
      }
      i = 2;
      label1093:
      paramg.expectImageFormat = i;
      if (!Util.isNullOrNil(str1))
      {
        str2 = (String)localMap.get(".msg.img.$tpauthkey");
        paramg.field_fileType = 19;
        paramg.field_authKey = str2;
        paramg.gqB = str1;
        paramg.field_fileId = "";
      }
      Log.i(this.TAG, "cdnautostart %s %b", new Object[] { "image_" + this.dCM.field_msgId, Boolean.valueOf(f.baQ().iRE.contains("image_" + this.dCM.field_msgId)) });
      if (!f.baQ().iRE.contains("image_" + this.dCM.field_msgId)) {
        break label1412;
      }
      f.baQ().iRE.remove("image_" + this.dCM.field_msgId);
    }
    label1412:
    for (paramg.field_autostart = true;; paramg.field_autostart = false)
    {
      if (f.baQ().b(paramg, this.iYY)) {
        break label1420;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 196L, 1L, false);
      Log.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.iYT });
      this.iYT = "";
      AppMethodBeat.o(150674);
      return false;
      bool = false;
      break;
      label1365:
      paramg.taskName = "task_NetSceneGetMsgImg_2";
      paramg.field_mediaId = (this.iYT + "_hevc");
      break label1015;
      label1402:
      i = 0;
      break label1081;
      label1407:
      i = 1;
      break label1093;
    }
    label1420:
    Log.i(this.TAG, "add recv task");
    AppMethodBeat.o(150674);
    return true;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150675);
    if ((!Util.isNullOrNil(this.iYT)) && (f.baQ() != null))
    {
      Log.d(this.TAG, "cancel recv task");
      f.baQ().Oc(this.iYT);
    }
    super.cancel();
    AppMethodBeat.o(150675);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(150676);
    this.callback = parami;
    parami = (bqv)this.rr.iLK.iLR;
    g localg = q.bcR().c(Long.valueOf(this.hmj));
    if (localg.localId == 0L)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 195L, 1L, false);
      Log.e(this.TAG, "doScene id:%d  img:%s", new Object[] { Long.valueOf(this.hmj), localg });
      AppMethodBeat.o(150676);
      return -1;
    }
    if (localg.status != 0)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 194L, 1L, false);
      Log.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[] { Long.valueOf(localg.localId), Integer.valueOf(localg.status) });
      AppMethodBeat.o(150676);
      return -1;
    }
    String str = localg.iXm;
    if (str.startsWith("SERVERID://"))
    {
      this.iYU = com.tencent.mm.b.g.getMessageDigest(localg.iXm.getBytes());
      this.iYV = q.bcR().o(this.iYU, null, ".temp");
      localg.Oq(this.iYU + ".temp");
      q.bcR().a(Long.valueOf(this.hmj), localg);
      Log.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[] { Long.valueOf(localg.localId), Integer.valueOf(this.iXp), Integer.valueOf(localg.offset), Integer.valueOf(localg.iKP), str, this.iYU, this.iYV });
      if (this.startTime == 0L)
      {
        this.startTime = Util.nowMilliSecond();
        this.startOffset = localg.offset;
        if (this.iXp != 1) {
          break label452;
        }
      }
    }
    label452:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.gVY = i;
      if (!d(localg)) {
        break label459;
      }
      Log.d(this.TAG, "cdntra this img use cdn : %s", new Object[] { this.iYT });
      AppMethodBeat.o(150676);
      return 0;
      this.iYU = localg.iXm;
      this.iYV = q.bcR().o(this.iYU, null, "");
      break;
    }
    label459:
    Log.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[] { this.iYT });
    localg.Ot("");
    localg.cSx = 4096;
    q.bcR().a(Long.valueOf(this.hmj), localg);
    parami.BsG = localg.offset;
    parami.BsH = this.iYR;
    parami.BsF = localg.iKP;
    if (this.iYS != null) {
      this.iYS.bgi();
    }
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150676);
    return i;
  }
  
  public final int getType()
  {
    return 109;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150677);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.iYT)))
    {
      Log.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.iYT });
      AppMethodBeat.o(150677);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 193L, 1L, false);
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), Integer.valueOf(this.iKP - this.startOffset) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150677);
      return;
    }
    paramString = (bqw)((com.tencent.mm.ak.d)params).iLL.iLR;
    params = q.bcR().c(Long.valueOf(this.hmj));
    paramInt1 = 0;
    if (paramString.BsH <= 0)
    {
      Log.e(this.TAG, "flood control, malformed data_len");
      paramInt1 = -1;
    }
    while (paramInt1 != 0)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 192L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), Integer.valueOf(this.iKP - this.startOffset) });
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(150677);
      return;
      if ((paramString.BsI == null) || (paramString.BsH != paramString.BsI.getILen()))
      {
        Log.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
        paramInt1 = -1;
      }
      else if ((paramString.BsG < 0) || (paramString.BsG + paramString.BsH > paramString.BsF))
      {
        Log.e(this.TAG, "flood control, malformed start pos");
        paramInt1 = -1;
      }
      else if (paramString.BsG != params.offset)
      {
        Log.e(this.TAG, "flood control, malformed start_pos");
        paramInt1 = -1;
      }
      else if (paramString.BsF <= 0)
      {
        Log.e(this.TAG, "flood control, malformed total_len");
        paramInt1 = -1;
      }
    }
    if ((a(params, paramString.BsF, paramString.BsG, paramString.BsH, paramString.BsI.getBuffer().zy)) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(150677);
  }
  
  public final int securityLimitCount()
  {
    if (this.iXp == 0) {
      return 100;
    }
    return 1280;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.m
 * JD-Core Version:    0.7.0.1
 */