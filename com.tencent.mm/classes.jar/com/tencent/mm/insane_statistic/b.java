package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.g;
import com.tencent.mm.aw.r.a;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pl.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.net.URLEncoder;
import java.util.Map;

public final class b
  implements r.a
{
  public final void a(long paramLong, bl parambl, com.tencent.mm.al.b paramb, int paramInt, boolean paramBoolean, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(20225);
    parambl = new a(paramLong, parambl, paramb, paramBoolean, paramInt);
    paramb = com.tencent.mm.model.c.d.aty().qu("100131");
    if (paramb.isValid()) {
      parambl.fYF = ae.getInt((String)paramb.eJy().get("needUploadData"), 1);
    }
    if ((parambl.fYD) || ((!parambl.fYH) && (parambl.fYF == 0)))
    {
      AppMethodBeat.o(20225);
      return;
    }
    parambl.fYG = paramd;
    parambl.fYD = true;
    paramb = ((dht)parambl.rr.gUS.gUX).Cxy.Ehn;
    if ((!bt.isNullOrNil(paramb)) && (w.pF(paramb)))
    {
      paramInt = 1;
      paramb = new StringBuilder("2,");
      if (paramInt == 0) {
        break label313;
      }
    }
    label313:
    for (paramInt = 2;; paramInt = 1)
    {
      parambl.fYC = (paramInt + ",,");
      if (parambl.fYB == null) {
        parambl.fYB = com.tencent.mm.aw.o.ayF().b(Long.valueOf(parambl.fYz));
      }
      paramb = parambl.fYB;
      if (paramb != null)
      {
        paramd = new pj();
        a.ESL.c(parambl.fYI);
        a.ESL.c(parambl.fYJ);
        parambl.fYE = com.tencent.mm.aw.o.ayF().p(paramb.hgj, "", "");
        paramd.duX.dcQ = System.currentTimeMillis();
        paramd.duX.filePath = parambl.fYE;
        a.ESL.l(paramd);
      }
      AppMethodBeat.o(20225);
      return;
      paramInt = 0;
      break;
    }
  }
  
  static final class a
  {
    bl dbD;
    int fYA;
    e fYB;
    String fYC;
    boolean fYD;
    String fYE;
    int fYF;
    com.tencent.mm.i.d fYG;
    boolean fYH;
    com.tencent.mm.sdk.b.c fYI;
    com.tencent.mm.sdk.b.c fYJ;
    long fYz;
    final com.tencent.mm.al.b rr;
    
    a(long paramLong, bl parambl, com.tencent.mm.al.b paramb, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(20223);
      this.dbD = null;
      this.fYD = false;
      this.fYF = 0;
      this.fYH = false;
      this.fYI = new com.tencent.mm.sdk.b.c()
      {
        private boolean a(pl paramAnonymouspl)
        {
          AppMethodBeat.i(20220);
          if ((bt.T(new String[] { b.a.this.fYE, paramAnonymouspl.dva.filePath })) || (!paramAnonymouspl.dva.filePath.equals(b.a.this.fYE)))
          {
            AppMethodBeat.o(20220);
            return false;
          }
          try
          {
            Object localObject1 = URLEncoder.encode(paramAnonymouspl.dva.result, "UTF-8");
            Object localObject2;
            if (b.a.this.fYH)
            {
              localObject2 = b.a.this.fYC + (String)localObject1;
              ad.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", new Object[] { Long.valueOf(b.a.this.fYz), Integer.valueOf(b.a.this.hashCode()), localObject2, paramAnonymouspl.dva.filePath });
              h.vKh.kvStat(13717, (String)localObject2);
            }
            if (b.a.this.fYF == 1)
            {
              f localf = new f();
              dht localdht = (dht)b.a.this.rr.gUS.gUX;
              localf.o("20toUser", localdht.Cxy.Ehn + ",");
              localf.o("21source", b.a.this.fYA + ",");
              localf.o("22qrUrl", (String)localObject1 + ",");
              localObject2 = new StringBuilder();
              if (b.a.this.fYG == null)
              {
                localObject1 = "";
                localf.o("23md5", (String)localObject1 + ",");
                localObject2 = new StringBuilder();
                if (b.a.this.fYG != null) {
                  break label637;
                }
                localObject1 = "";
                localf.o("24cdnFileId", (String)localObject1 + ",");
                localObject2 = new StringBuilder();
                if (b.a.this.fYG != null) {
                  break label651;
                }
                localObject1 = "";
                localf.o("25cdnAesKey", (String)localObject1 + ",");
                localObject2 = "";
                localObject1 = localObject2;
                if (b.a.this.dbD.cxB())
                {
                  k.b localb = k.b.rx(b.a.this.dbD.field_content);
                  localObject1 = localObject2;
                  if (localb != null) {
                    localObject1 = localb.appId;
                  }
                }
                localf.o("26appip", (String)localObject1 + ",");
                localf.o("27toUsersCount", q.rY(localdht.Cxy.Ehn) + ",");
                localf.o("28codeType", Integer.valueOf(paramAnonymouspl.dva.deB));
                ad.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + localf.PW());
                com.tencent.mm.modelstat.o.J(13628, localf.toString());
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
              str = b.a.this.fYG.field_filemd5;
              continue;
              label637:
              str = b.a.this.fYG.field_fileId;
              continue;
              label651:
              str = b.a.this.fYG.field_aesKey;
            }
          }
        }
      };
      this.fYJ = new com.tencent.mm.sdk.b.c() {};
      this.fYz = paramLong;
      this.dbD = parambl;
      this.rr = paramb;
      this.fYA = paramInt;
      this.fYH = paramBoolean;
      AppMethodBeat.o(20223);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.b
 * JD-Core Version:    0.7.0.1
 */