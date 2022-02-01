package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.u.a;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.w;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.net.URLEncoder;
import java.util.Map;

public final class b
  implements u.a
{
  public final void a(long paramLong, bu parambu, com.tencent.mm.al.b paramb, int paramInt, boolean paramBoolean, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(20225);
    paramb = new a(paramLong, parambu, paramb, paramBoolean, paramInt);
    parambu = com.tencent.mm.model.c.d.aDs().wz("100131");
    if (parambu.isValid()) {
      paramb.gwV = af.getInt((String)parambu.foF().get("needUploadData"), 1);
    }
    if ((paramb.gwT) || ((!paramb.gwX) && (paramb.gwV == 0)))
    {
      AppMethodBeat.o(20225);
      return;
    }
    paramb.gwW = paramd;
    paramb.gwT = true;
    parambu = (dsz)paramb.rr.hNK.hNQ;
    if (parambu.Fvj != null)
    {
      parambu = parambu.Fvj.HoB;
      if ((bt.isNullOrNil(parambu)) || (!w.vF(parambu))) {
        break label328;
      }
      paramInt = 1;
      label156:
      parambu = new StringBuilder("2,");
      if (paramInt == 0) {
        break label334;
      }
    }
    label328:
    label334:
    for (paramInt = 2;; paramInt = 1)
    {
      paramb.gwS = (paramInt + ",,");
      if (paramb.gwR == null) {
        paramb.gwR = com.tencent.mm.aw.q.aIF().c(Long.valueOf(paramb.gwP));
      }
      parambu = paramb.gwR;
      if (parambu != null)
      {
        paramd = new qc();
        a.IbL.c(paramb.gwY);
        a.IbL.c(paramb.gwZ);
        paramb.gwU = com.tencent.mm.aw.q.aIF().o(parambu.hZw, "", "");
        paramd.dEC.dlI = System.currentTimeMillis();
        paramd.dEC.filePath = paramb.gwU;
        a.IbL.l(paramd);
      }
      AppMethodBeat.o(20225);
      return;
      parambu = "";
      break;
      paramInt = 0;
      break label156;
    }
  }
  
  static final class a
  {
    bu dku;
    long gwP;
    int gwQ;
    com.tencent.mm.aw.g gwR;
    String gwS;
    boolean gwT;
    String gwU;
    int gwV;
    com.tencent.mm.i.d gwW;
    boolean gwX;
    com.tencent.mm.sdk.b.c gwY;
    com.tencent.mm.sdk.b.c gwZ;
    final com.tencent.mm.al.b rr;
    
    a(long paramLong, bu parambu, com.tencent.mm.al.b paramb, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(20223);
      this.dku = null;
      this.gwT = false;
      this.gwV = 0;
      this.gwX = false;
      this.gwY = new com.tencent.mm.sdk.b.c()
      {
        private boolean a(qe paramAnonymousqe)
        {
          AppMethodBeat.i(20220);
          if ((bt.V(new String[] { b.a.this.gwU, paramAnonymousqe.dEH.filePath })) || (!paramAnonymousqe.dEH.filePath.equals(b.a.this.gwU)))
          {
            AppMethodBeat.o(20220);
            return false;
          }
          try
          {
            Object localObject1 = URLEncoder.encode(paramAnonymousqe.dEH.result, "UTF-8");
            Object localObject2;
            if (b.a.this.gwX)
            {
              localObject2 = b.a.this.gwS + (String)localObject1;
              ad.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", new Object[] { Long.valueOf(b.a.this.gwP), Integer.valueOf(b.a.this.hashCode()), localObject2, paramAnonymousqe.dEH.filePath });
              com.tencent.mm.plugin.report.service.g.yhR.kvStat(13717, (String)localObject2);
            }
            if (b.a.this.gwV == 1)
            {
              com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
              dsz localdsz = (dsz)b.a.this.rr.hNK.hNQ;
              localg.m("20toUser", localdsz.Fvj.HoB + ",");
              localg.m("21source", b.a.this.gwQ + ",");
              localg.m("22qrUrl", (String)localObject1 + ",");
              localObject2 = new StringBuilder();
              if (b.a.this.gwW == null)
              {
                localObject1 = "";
                localg.m("23md5", (String)localObject1 + ",");
                localObject2 = new StringBuilder();
                if (b.a.this.gwW != null) {
                  break label637;
                }
                localObject1 = "";
                localg.m("24cdnFileId", (String)localObject1 + ",");
                localObject2 = new StringBuilder();
                if (b.a.this.gwW != null) {
                  break label651;
                }
                localObject1 = "";
                localg.m("25cdnAesKey", (String)localObject1 + ",");
                localObject2 = "";
                localObject1 = localObject2;
                if (b.a.this.dku.cTc())
                {
                  k.b localb = k.b.yr(b.a.this.dku.field_content);
                  localObject1 = localObject2;
                  if (localb != null) {
                    localObject1 = localb.appId;
                  }
                }
                localg.m("26appip", (String)localObject1 + ",");
                localg.m("27toUsersCount", com.tencent.mm.model.q.yS(localdsz.Fvj.HoB) + ",");
                localg.m("28codeType", Integer.valueOf(paramAnonymousqe.dEH.dnt));
                ad.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + localg.RE());
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
              ad.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", localException, "", new Object[0]);
              String str = "";
              continue;
              str = b.a.this.gwW.field_filemd5;
              continue;
              label637:
              str = b.a.this.gwW.field_fileId;
              continue;
              label651:
              str = b.a.this.gwW.field_aesKey;
            }
          }
        }
      };
      this.gwZ = new com.tencent.mm.sdk.b.c() {};
      this.gwP = paramLong;
      this.dku = parambu;
      this.rr = paramb;
      this.gwQ = paramInt;
      this.gwX = paramBoolean;
      AppMethodBeat.o(20223);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.b
 * JD-Core Version:    0.7.0.1
 */