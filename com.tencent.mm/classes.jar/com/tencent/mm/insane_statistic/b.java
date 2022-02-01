package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.d.b;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.ay.u.a;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.rz.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eyc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.net.URLEncoder;

public final class b
  implements u.a
{
  public final void a(long paramLong, ca paramca, com.tencent.mm.an.d paramd, int paramInt, boolean paramBoolean, com.tencent.mm.i.d paramd1, String paramString)
  {
    AppMethodBeat.i(269383);
    paramd = new a(paramLong, paramca, paramd, paramBoolean, paramInt, paramString);
    paramd.jXZ = 1;
    if ((paramd.jXX) || ((!paramd.jYb) && (paramd.jXZ == 0)))
    {
      AppMethodBeat.o(269383);
      return;
    }
    paramd.jYa = paramd1;
    paramd.jXX = true;
    paramca = (eyc)d.b.b(paramd.rr.lBR);
    if (paramca.RIE != null)
    {
      paramca = paramca.RIE.Ufy;
      if ((Util.isNullOrNil(paramca)) || (!ab.Lj(paramca))) {
        break label294;
      }
      paramInt = 1;
      label123:
      paramca = new StringBuilder("2,");
      if (paramInt == 0) {
        break label300;
      }
    }
    label294:
    label300:
    for (paramInt = 2;; paramInt = 1)
    {
      paramd.jXW = (paramInt + ",,");
      if (paramd.jXV == null) {
        paramd.jXV = q.bmh().b(Long.valueOf(paramd.jXT));
      }
      paramca = paramd.jXV;
      if (paramca != null)
      {
        paramd1 = new rx();
        EventCenter.instance.addListener(paramd.jYc);
        EventCenter.instance.addListener(paramd.jYd);
        paramd.jXY = q.bmh().r(paramca.lNH, "", "");
        paramd1.fRg.fwK = System.nanoTime();
        paramd1.fRg.filePath = paramd.jXY;
        EventCenter.instance.publish(paramd1);
      }
      AppMethodBeat.o(269383);
      return;
      paramca = "";
      break;
      paramInt = 0;
      break label123;
    }
  }
  
  static final class a
  {
    ca fvt;
    long jXT;
    int jXU;
    g jXV;
    String jXW;
    boolean jXX;
    String jXY;
    int jXZ;
    com.tencent.mm.i.d jYa;
    boolean jYb;
    IListener jYc;
    IListener jYd;
    final com.tencent.mm.an.d rr;
    private String uuid;
    
    a(long paramLong, ca paramca, com.tencent.mm.an.d paramd, boolean paramBoolean, int paramInt, String paramString)
    {
      AppMethodBeat.i(275096);
      this.fvt = null;
      this.jXX = false;
      this.jXZ = 0;
      this.jYb = false;
      this.jYc = new IListener()
      {
        private boolean a(rz paramAnonymousrz)
        {
          AppMethodBeat.i(20220);
          if ((Util.isNullOrNil(new String[] { b.a.this.jXY, paramAnonymousrz.fRl.filePath })) || (!paramAnonymousrz.fRl.filePath.equals(b.a.this.jXY)))
          {
            AppMethodBeat.o(20220);
            return false;
          }
          Object localObject3 = "";
          Object localObject1 = "";
          Object localObject2 = localObject1;
          for (;;)
          {
            try
            {
              Object localObject4 = p.RxG;
              localObject2 = localObject1;
              localObject1 = p.d(paramAnonymousrz);
              localObject2 = localObject1;
              localObject4 = p.RxG;
              localObject2 = localObject1;
              int i = p.e(paramAnonymousrz);
              k.b localb;
              Log.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", (Throwable)localObject2, "", new Object[0]);
            }
            catch (Exception localException2)
            {
              try
              {
                localObject2 = URLEncoder.encode((String)localObject1, "UTF-8");
                if (b.a.this.jYb)
                {
                  localObject3 = b.a.this.jXW + (String)localObject2;
                  Log.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", new Object[] { Long.valueOf(b.a.this.jXT), Integer.valueOf(b.a.this.hashCode()), localObject3, paramAnonymousrz.fRl.filePath });
                  h.IzE.kvStat(13717, (String)localObject3);
                }
                if (b.a.this.jXZ == 1)
                {
                  localObject3 = new com.tencent.mm.modelsns.n();
                  localObject4 = (eyc)d.b.b(b.a.this.rr.lBR);
                  ((com.tencent.mm.modelsns.n)localObject3).m("20toUser", ((eyc)localObject4).RIE.Ufy + ",");
                  ((com.tencent.mm.modelsns.n)localObject3).m("21source", b.a.this.jXU + ",");
                  ((com.tencent.mm.modelsns.n)localObject3).m("22qrUrl", (String)localObject2 + ",");
                  localObject2 = new StringBuilder();
                  if (b.a.this.jYa != null) {
                    break label685;
                  }
                  paramAnonymousrz = "";
                  ((com.tencent.mm.modelsns.n)localObject3).m("23md5", paramAnonymousrz + ",");
                  localObject2 = new StringBuilder();
                  if (b.a.this.jYa != null) {
                    break label699;
                  }
                  paramAnonymousrz = "";
                  ((com.tencent.mm.modelsns.n)localObject3).m("24cdnFileId", paramAnonymousrz + ",");
                  localObject2 = new StringBuilder();
                  if (b.a.this.jYa != null) {
                    break label713;
                  }
                  paramAnonymousrz = "";
                  ((com.tencent.mm.modelsns.n)localObject3).m("25cdnAesKey", paramAnonymousrz + ",");
                  localObject2 = "";
                  paramAnonymousrz = (rz)localObject2;
                  if (b.a.this.fvt.erk())
                  {
                    localb = k.b.OQ(b.a.this.fvt.field_content);
                    paramAnonymousrz = (rz)localObject2;
                    if (localb != null) {
                      paramAnonymousrz = localb.appId;
                    }
                  }
                  ((com.tencent.mm.modelsns.n)localObject3).m("26appip", paramAnonymousrz + ",");
                  ((com.tencent.mm.modelsns.n)localObject3).m("27toUsersCount", v.Pu(((eyc)localObject4).RIE.Ufy) + ",");
                  ((com.tencent.mm.modelsns.n)localObject3).m("28codeType", Integer.valueOf(i));
                  Log.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + ((com.tencent.mm.modelsns.n)localObject3).agI());
                  com.tencent.mm.modelstat.n.Q(13628, ((com.tencent.mm.modelsns.n)localObject3).toString());
                }
                b.a.a(b.a.this);
                b.a.a(b.a.this, (String)localObject1);
                AppMethodBeat.o(20220);
                return false;
              }
              catch (Exception localException1)
              {
                break label665;
              }
              localException2 = localException2;
              i = 0;
              localObject1 = localObject2;
              localObject2 = localException2;
            }
            label665:
            localObject2 = localObject3;
            continue;
            label685:
            paramAnonymousrz = b.a.this.jYa.field_filemd5;
            continue;
            label699:
            paramAnonymousrz = b.a.this.jYa.field_fileId;
            continue;
            label713:
            paramAnonymousrz = b.a.this.jYa.field_aesKey;
          }
        }
      };
      this.jYd = new IListener() {};
      this.jXT = paramLong;
      this.fvt = paramca;
      this.rr = paramd;
      this.jXU = paramInt;
      this.jYb = paramBoolean;
      this.uuid = paramString;
      AppMethodBeat.o(275096);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.b
 * JD-Core Version:    0.7.0.1
 */