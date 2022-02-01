package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.av.g;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.av.u.a;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.ca;
import java.net.URLEncoder;
import java.util.Map;

public final class b
  implements u.a
{
  public final void a(long paramLong, ca paramca, com.tencent.mm.ak.d paramd, int paramInt, boolean paramBoolean, com.tencent.mm.i.d paramd1, String paramString)
  {
    AppMethodBeat.i(231533);
    paramd = new a(paramLong, paramca, paramd, paramBoolean, paramInt, paramString);
    paramca = com.tencent.mm.model.c.d.aXu().Fu("100131");
    if (paramca.isValid()) {
      paramd.hmp = af.getInt((String)paramca.gzz().get("needUploadData"), 1);
    }
    if ((paramd.hmn) || ((!paramd.hmr) && (paramd.hmp == 0)))
    {
      AppMethodBeat.o(231533);
      return;
    }
    paramd.hmq = paramd1;
    paramd.hmn = true;
    paramca = (enu)paramd.rr.iLK.iLR;
    if (paramca.KHm != null)
    {
      paramca = paramca.KHm.MTo;
      if ((Util.isNullOrNil(paramca)) || (!ab.Eq(paramca))) {
        break label327;
      }
      paramInt = 1;
      label156:
      paramca = new StringBuilder("2,");
      if (paramInt == 0) {
        break label333;
      }
    }
    label327:
    label333:
    for (paramInt = 2;; paramInt = 1)
    {
      paramd.hmm = (paramInt + ",,");
      if (paramd.hml == null) {
        paramd.hml = q.bcR().c(Long.valueOf(paramd.hmj));
      }
      paramca = paramd.hml;
      if (paramca != null)
      {
        paramd1 = new qx();
        EventCenter.instance.addListener(paramd.hms);
        EventCenter.instance.addListener(paramd.hmt);
        paramd.hmo = q.bcR().o(paramca.iXm, "", "");
        paramd1.dXu.dDZ = System.nanoTime();
        paramd1.dXu.filePath = paramd.hmo;
        EventCenter.instance.publish(paramd1);
      }
      AppMethodBeat.o(231533);
      return;
      paramca = "";
      break;
      paramInt = 0;
      break label156;
    }
  }
  
  static final class a
  {
    ca dCM;
    long hmj;
    int hmk;
    g hml;
    String hmm;
    boolean hmn;
    String hmo;
    int hmp;
    com.tencent.mm.i.d hmq;
    boolean hmr;
    IListener hms;
    IListener hmt;
    final com.tencent.mm.ak.d rr;
    private String uuid;
    
    a(long paramLong, ca paramca, com.tencent.mm.ak.d paramd, boolean paramBoolean, int paramInt, String paramString)
    {
      AppMethodBeat.i(231531);
      this.dCM = null;
      this.hmn = false;
      this.hmp = 0;
      this.hmr = false;
      this.hms = new IListener()
      {
        private boolean a(qz paramAnonymousqz)
        {
          AppMethodBeat.i(20220);
          if ((Util.isNullOrNil(new String[] { b.a.this.hmo, paramAnonymousqz.dXz.filePath })) || (!paramAnonymousqz.dXz.filePath.equals(b.a.this.hmo)))
          {
            AppMethodBeat.o(20220);
            return false;
          }
          try
          {
            Object localObject1 = URLEncoder.encode(paramAnonymousqz.dXz.result, "UTF-8");
            Object localObject2;
            if (b.a.this.hmr)
            {
              localObject2 = b.a.this.hmm + (String)localObject1;
              Log.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", new Object[] { Long.valueOf(b.a.this.hmj), Integer.valueOf(b.a.this.hashCode()), localObject2, paramAnonymousqz.dXz.filePath });
              h.CyF.kvStat(13717, (String)localObject2);
            }
            if (b.a.this.hmp == 1)
            {
              m localm = new m();
              enu localenu = (enu)b.a.this.rr.iLK.iLR;
              localm.n("20toUser", localenu.KHm.MTo + ",");
              localm.n("21source", b.a.this.hmk + ",");
              localm.n("22qrUrl", (String)localObject1 + ",");
              localObject2 = new StringBuilder();
              if (b.a.this.hmq == null)
              {
                localObject1 = "";
                localm.n("23md5", (String)localObject1 + ",");
                localObject2 = new StringBuilder();
                if (b.a.this.hmq != null) {
                  break label651;
                }
                localObject1 = "";
                localm.n("24cdnFileId", (String)localObject1 + ",");
                localObject2 = new StringBuilder();
                if (b.a.this.hmq != null) {
                  break label665;
                }
                localObject1 = "";
                localm.n("25cdnAesKey", (String)localObject1 + ",");
                localObject2 = "";
                localObject1 = localObject2;
                if (b.a.this.dCM.dOQ())
                {
                  k.b localb = k.b.HD(b.a.this.dCM.field_content);
                  localObject1 = localObject2;
                  if (localb != null) {
                    localObject1 = localb.appId;
                  }
                }
                localm.n("26appip", (String)localObject1 + ",");
                localm.n("27toUsersCount", v.Ie(localenu.KHm.MTo) + ",");
                localm.n("28codeType", Integer.valueOf(paramAnonymousqz.dXz.dFL));
                Log.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + localm.abW());
                o.O(13628, localm.toString());
              }
            }
            else
            {
              b.a.a(b.a.this);
              b.a.a(b.a.this, paramAnonymousqz.dXz.result);
              AppMethodBeat.o(20220);
              return false;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", localException, "", new Object[0]);
              String str = "";
              continue;
              str = b.a.this.hmq.field_filemd5;
              continue;
              label651:
              str = b.a.this.hmq.field_fileId;
              continue;
              label665:
              str = b.a.this.hmq.field_aesKey;
            }
          }
        }
      };
      this.hmt = new IListener() {};
      this.hmj = paramLong;
      this.dCM = paramca;
      this.rr = paramd;
      this.hmk = paramInt;
      this.hmr = paramBoolean;
      this.uuid = paramString;
      AppMethodBeat.o(231531);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.b
 * JD-Core Version:    0.7.0.1
 */