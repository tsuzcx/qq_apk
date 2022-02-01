package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.av.r.a;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pu.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.net.URLEncoder;
import java.util.Map;

public final class b
  implements r.a
{
  public final void a(long paramLong, bo parambo, com.tencent.mm.ak.b paramb, int paramInt, boolean paramBoolean, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(20225);
    parambo = new a(paramLong, parambo, paramb, paramBoolean, paramInt);
    paramb = com.tencent.mm.model.c.d.aAp().tJ("100131");
    if (paramb.isValid()) {
      parambo.gdl = ae.getInt((String)paramb.eYV().get("needUploadData"), 1);
    }
    if ((parambo.gdj) || ((!parambo.gdn) && (parambo.gdl == 0)))
    {
      AppMethodBeat.o(20225);
      return;
    }
    parambo.gdm = paramd;
    parambo.gdj = true;
    paramb = ((dni)parambo.rr.hvr.hvw).DPU.FEm;
    if ((!bs.isNullOrNil(paramb)) && (w.sQ(paramb)))
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
      parambo.gdi = (paramInt + ",,");
      if (parambo.gdh == null) {
        parambo.gdh = com.tencent.mm.av.o.aFx().c(Long.valueOf(parambo.gdf));
      }
      paramb = parambo.gdh;
      if (paramb != null)
      {
        paramd = new ps();
        a.GpY.c(parambo.gdo);
        a.GpY.c(parambo.gdp);
        parambo.gdk = com.tencent.mm.av.o.aFx().p(paramb.hGM, "", "");
        paramd.dsJ.dao = System.currentTimeMillis();
        paramd.dsJ.filePath = parambo.gdk;
        a.GpY.l(paramd);
      }
      AppMethodBeat.o(20225);
      return;
      paramInt = 0;
      break;
    }
  }
  
  static final class a
  {
    bo cZc;
    long gdf;
    int gdg;
    e gdh;
    String gdi;
    boolean gdj;
    String gdk;
    int gdl;
    com.tencent.mm.i.d gdm;
    boolean gdn;
    com.tencent.mm.sdk.b.c gdo;
    com.tencent.mm.sdk.b.c gdp;
    final com.tencent.mm.ak.b rr;
    
    a(long paramLong, bo parambo, com.tencent.mm.ak.b paramb, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(20223);
      this.cZc = null;
      this.gdj = false;
      this.gdl = 0;
      this.gdn = false;
      this.gdo = new com.tencent.mm.sdk.b.c()
      {
        private boolean a(pu paramAnonymouspu)
        {
          AppMethodBeat.i(20220);
          if ((bs.T(new String[] { b.a.this.gdk, paramAnonymouspu.dsM.filePath })) || (!paramAnonymouspu.dsM.filePath.equals(b.a.this.gdk)))
          {
            AppMethodBeat.o(20220);
            return false;
          }
          try
          {
            Object localObject1 = URLEncoder.encode(paramAnonymouspu.dsM.result, "UTF-8");
            Object localObject2;
            if (b.a.this.gdn)
            {
              localObject2 = b.a.this.gdi + (String)localObject1;
              ac.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", new Object[] { Long.valueOf(b.a.this.gdf), Integer.valueOf(b.a.this.hashCode()), localObject2, paramAnonymouspu.dsM.filePath });
              h.wUl.kvStat(13717, (String)localObject2);
            }
            if (b.a.this.gdl == 1)
            {
              f localf = new f();
              dni localdni = (dni)b.a.this.rr.hvr.hvw;
              localf.n("20toUser", localdni.DPU.FEm + ",");
              localf.n("21source", b.a.this.gdg + ",");
              localf.n("22qrUrl", (String)localObject1 + ",");
              localObject2 = new StringBuilder();
              if (b.a.this.gdm == null)
              {
                localObject1 = "";
                localf.n("23md5", (String)localObject1 + ",");
                localObject2 = new StringBuilder();
                if (b.a.this.gdm != null) {
                  break label637;
                }
                localObject1 = "";
                localf.n("24cdnFileId", (String)localObject1 + ",");
                localObject2 = new StringBuilder();
                if (b.a.this.gdm != null) {
                  break label651;
                }
                localObject1 = "";
                localf.n("25cdnAesKey", (String)localObject1 + ",");
                localObject2 = "";
                localObject1 = localObject2;
                if (b.a.this.cZc.cKN())
                {
                  k.b localb = k.b.vA(b.a.this.cZc.field_content);
                  localObject1 = localObject2;
                  if (localb != null) {
                    localObject1 = localb.appId;
                  }
                }
                localf.n("26appip", (String)localObject1 + ",");
                localf.n("27toUsersCount", q.wb(localdni.DPU.FEm) + ",");
                localf.n("28codeType", Integer.valueOf(paramAnonymouspu.dsM.dbX));
                ac.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + localf.PS());
                com.tencent.mm.modelstat.o.K(13628, localf.toString());
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
              ac.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", localException, "", new Object[0]);
              String str = "";
              continue;
              str = b.a.this.gdm.field_filemd5;
              continue;
              label637:
              str = b.a.this.gdm.field_fileId;
              continue;
              label651:
              str = b.a.this.gdm.field_aesKey;
            }
          }
        }
      };
      this.gdp = new com.tencent.mm.sdk.b.c() {};
      this.gdf = paramLong;
      this.cZc = parambo;
      this.rr = paramb;
      this.gdg = paramInt;
      this.gdn = paramBoolean;
      AppMethodBeat.o(20223);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.b
 * JD-Core Version:    0.7.0.1
 */