package com.tencent.mm.insane_statistic;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.to.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ftv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.net.URLEncoder;

class OnNetSceneUploadMsgImgEnd$ProcessOnNetSceneUploadMsgImgEnd$1
  extends IListener<to>
{
  OnNetSceneUploadMsgImgEnd$ProcessOnNetSceneUploadMsgImgEnd$1(b.a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(231505);
    this.__eventId = to.class.getName().hashCode();
    AppMethodBeat.o(231505);
  }
  
  private boolean a(to paramto)
  {
    AppMethodBeat.i(20220);
    if ((Util.isNullOrNil(new String[] { this.mxY.mxS, paramto.hXi.filePath })) || (!paramto.hXi.filePath.equals(this.mxY.mxS)))
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
        Object localObject4 = o.YtW;
        localObject2 = localObject1;
        localObject1 = o.d(paramto);
        localObject2 = localObject1;
        localObject4 = o.YtW;
        localObject2 = localObject1;
        int i = o.e(paramto);
        k.b localb;
        Log.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", (Throwable)localObject2, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        try
        {
          localObject2 = URLEncoder.encode((String)localObject1, "UTF-8");
          if (this.mxY.mxV)
          {
            localObject3 = this.mxY.mxQ + (String)localObject2;
            Log.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", new Object[] { Long.valueOf(this.mxY.mxN), Integer.valueOf(this.mxY.hashCode()), localObject3, paramto.hXi.filePath });
            h.OAn.kvStat(13717, (String)localObject3);
          }
          if (this.mxY.mxT == 1)
          {
            localObject3 = new com.tencent.mm.modelsns.n();
            localObject4 = (ftv)c.b.b(this.mxY.rr.otB);
            ((com.tencent.mm.modelsns.n)localObject3).s("20toUser", ((ftv)localObject4).YFF.abwM + ",");
            ((com.tencent.mm.modelsns.n)localObject3).s("21source", this.mxY.mxO + ",");
            ((com.tencent.mm.modelsns.n)localObject3).s("22qrUrl", (String)localObject2 + ",");
            localObject2 = new StringBuilder();
            if (this.mxY.mxU != null) {
              break label682;
            }
            paramto = "";
            ((com.tencent.mm.modelsns.n)localObject3).s("23md5", paramto + ",");
            localObject2 = new StringBuilder();
            if (this.mxY.mxU != null) {
              break label696;
            }
            paramto = "";
            ((com.tencent.mm.modelsns.n)localObject3).s("24cdnFileId", paramto + ",");
            localObject2 = new StringBuilder();
            if (this.mxY.mxU != null) {
              break label710;
            }
            paramto = "";
            ((com.tencent.mm.modelsns.n)localObject3).s("25cdnAesKey", paramto + ",");
            localObject2 = "";
            paramto = (to)localObject2;
            if (this.mxY.hzO.fxR())
            {
              localb = k.b.Hf(this.mxY.hzO.field_content);
              paramto = (to)localObject2;
              if (localb != null) {
                paramto = localb.appId;
              }
            }
            ((com.tencent.mm.modelsns.n)localObject3).s("26appip", paramto + ",");
            ((com.tencent.mm.modelsns.n)localObject3).s("27toUsersCount", v.getMembersCountByChatRoomName(((ftv)localObject4).YFF.abwM) + ",");
            ((com.tencent.mm.modelsns.n)localObject3).s("28codeType", Integer.valueOf(i));
            Log.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + ((com.tencent.mm.modelsns.n)localObject3).aIF());
            com.tencent.mm.modelstat.n.V(13628, ((com.tencent.mm.modelsns.n)localObject3).toString());
          }
          b.a.a(this.mxY);
          b.a.a(this.mxY, (String)localObject1);
          AppMethodBeat.o(20220);
          return false;
        }
        catch (Exception localException1)
        {
          break label662;
        }
        localException2 = localException2;
        i = 0;
        localObject1 = localObject2;
        localObject2 = localException2;
      }
      label662:
      localObject2 = localObject3;
      continue;
      label682:
      paramto = this.mxY.mxU.field_filemd5;
      continue;
      label696:
      paramto = this.mxY.mxU.field_fileId;
      continue;
      label710:
      paramto = this.mxY.mxU.field_aesKey;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.OnNetSceneUploadMsgImgEnd.ProcessOnNetSceneUploadMsgImgEnd.1
 * JD-Core Version:    0.7.0.1
 */