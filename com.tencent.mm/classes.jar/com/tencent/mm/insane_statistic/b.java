package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.av.u.a;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qf.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.net.URLEncoder;
import java.util.Map;

public final class b
  implements u.a
{
  public final void a(long paramLong, bv parambv, com.tencent.mm.ak.b paramb, int paramInt, boolean paramBoolean, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(20225);
    paramb = new a(paramLong, parambv, paramb, paramBoolean, paramInt);
    parambv = com.tencent.mm.model.c.d.aDI().xi("100131");
    if (parambv.isValid()) {
      paramb.gzC = af.getInt((String)parambv.fsy().get("needUploadData"), 1);
    }
    if ((paramb.gzA) || ((!paramb.gzE) && (paramb.gzC == 0)))
    {
      AppMethodBeat.o(20225);
      return;
    }
    paramb.gzD = paramd;
    paramb.gzA = true;
    parambv = (dtw)paramb.rr.hQD.hQJ;
    if (parambv.FNH != null)
    {
      parambv = parambv.FNH.HId;
      if ((bu.isNullOrNil(parambv)) || (!x.wb(parambv))) {
        break label328;
      }
      paramInt = 1;
      label156:
      parambv = new StringBuilder("2,");
      if (paramInt == 0) {
        break label334;
      }
    }
    label328:
    label334:
    for (paramInt = 2;; paramInt = 1)
    {
      paramb.gzz = (paramInt + ",,");
      if (paramb.gzy == null) {
        paramb.gzy = q.aIX().c(Long.valueOf(paramb.gzw));
      }
      parambv = paramb.gzy;
      if (parambv != null)
      {
        paramd = new qd();
        a.IvT.c(paramb.gzF);
        a.IvT.c(paramb.gzG);
        paramb.gzB = q.aIX().o(parambv.ico, "", "");
        paramd.dFH.dmK = System.currentTimeMillis();
        paramd.dFH.filePath = paramb.gzB;
        a.IvT.l(paramd);
      }
      AppMethodBeat.o(20225);
      return;
      parambv = "";
      break;
      paramInt = 0;
      break label156;
    }
  }
  
  static final class a
  {
    bv dlw;
    boolean gzA;
    String gzB;
    int gzC;
    com.tencent.mm.i.d gzD;
    boolean gzE;
    com.tencent.mm.sdk.b.c gzF;
    com.tencent.mm.sdk.b.c gzG;
    long gzw;
    int gzx;
    com.tencent.mm.av.g gzy;
    String gzz;
    final com.tencent.mm.ak.b rr;
    
    a(long paramLong, bv parambv, com.tencent.mm.ak.b paramb, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(20223);
      this.dlw = null;
      this.gzA = false;
      this.gzC = 0;
      this.gzE = false;
      this.gzF = new com.tencent.mm.sdk.b.c()
      {
        private boolean a(qf paramAnonymousqf)
        {
          AppMethodBeat.i(20220);
          if ((bu.V(new String[] { b.a.this.gzB, paramAnonymousqf.dFM.filePath })) || (!paramAnonymousqf.dFM.filePath.equals(b.a.this.gzB)))
          {
            AppMethodBeat.o(20220);
            return false;
          }
          try
          {
            Object localObject1 = URLEncoder.encode(paramAnonymousqf.dFM.result, "UTF-8");
            Object localObject2;
            if (b.a.this.gzE)
            {
              localObject2 = b.a.this.gzz + (String)localObject1;
              ae.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", new Object[] { Long.valueOf(b.a.this.gzw), Integer.valueOf(b.a.this.hashCode()), localObject2, paramAnonymousqf.dFM.filePath });
              com.tencent.mm.plugin.report.service.g.yxI.kvStat(13717, (String)localObject2);
            }
            if (b.a.this.gzC == 1)
            {
              com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
              dtw localdtw = (dtw)b.a.this.rr.hQD.hQJ;
              localg.m("20toUser", localdtw.FNH.HId + ",");
              localg.m("21source", b.a.this.gzx + ",");
              localg.m("22qrUrl", (String)localObject1 + ",");
              localObject2 = new StringBuilder();
              if (b.a.this.gzD == null)
              {
                localObject1 = "";
                localg.m("23md5", (String)localObject1 + ",");
                localObject2 = new StringBuilder();
                if (b.a.this.gzD != null) {
                  break label637;
                }
                localObject1 = "";
                localg.m("24cdnFileId", (String)localObject1 + ",");
                localObject2 = new StringBuilder();
                if (b.a.this.gzD != null) {
                  break label651;
                }
                localObject1 = "";
                localg.m("25cdnAesKey", (String)localObject1 + ",");
                localObject2 = "";
                localObject1 = localObject2;
                if (b.a.this.dlw.cVH())
                {
                  k.b localb = k.b.zb(b.a.this.dlw.field_content);
                  localObject1 = localObject2;
                  if (localb != null) {
                    localObject1 = localb.appId;
                  }
                }
                localg.m("26appip", (String)localObject1 + ",");
                localg.m("27toUsersCount", r.zC(localdtw.FNH.HId) + ",");
                localg.m("28codeType", Integer.valueOf(paramAnonymousqf.dFM.dov));
                ae.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + localg.RD());
                o.L(13628, localg.toString());
              }
            }
            else
            {
              b.a.a(b.a.this);
              AppMethodBeat.o(20220);
              return false;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", localException, "", new Object[0]);
              String str = "";
              continue;
              str = b.a.this.gzD.field_filemd5;
              continue;
              label637:
              str = b.a.this.gzD.field_fileId;
              continue;
              label651:
              str = b.a.this.gzD.field_aesKey;
            }
          }
        }
      };
      this.gzG = new com.tencent.mm.sdk.b.c() {};
      this.gzw = paramLong;
      this.dlw = parambv;
      this.rr = paramb;
      this.gzx = paramInt;
      this.gzE = paramBoolean;
      AppMethodBeat.o(20223);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.b
 * JD-Core Version:    0.7.0.1
 */