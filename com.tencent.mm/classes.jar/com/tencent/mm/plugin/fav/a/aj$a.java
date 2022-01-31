package com.tencent.mm.plugin.fav.a;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.yq;
import com.tencent.mm.protocal.c.yr;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

final class aj$a
{
  LinkedList<qv> jZU;
  com.tencent.mm.sdk.platformtools.ah jZV = new com.tencent.mm.sdk.platformtools.ah(com.tencent.mm.kernel.g.DS().mnU.getLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if ((aj.a.this.jZU == null) || (aj.a.this.jZU.isEmpty()))
      {
        aj localaj = aj.a.this.jZW;
        paramAnonymousMessage = (yq)localaj.dmK.ecE.ecN;
        localObject = (yr)localaj.dmK.ecF.ecN;
        byte[] arrayOfByte = ((yr)localObject).sIi.tFM.toByteArray();
        arrayOfByte = com.tencent.mm.protocal.z.g(paramAnonymousMessage.sIi.tFM.toByteArray(), arrayOfByte);
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavConfigStorage().ay(arrayOfByte);
        }
        paramAnonymousMessage.sIi = aa.I(arrayOfByte);
        i = ((yr)localObject).sFD;
        if ((paramAnonymousMessage.sIh & i) == 0)
        {
          y.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[] { Long.valueOf(localaj.jZS) });
          com.tencent.mm.kernel.g.DP().Dz().o(8217, Integer.valueOf(1));
          if (localaj.jZS > 0L)
          {
            localObject = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().s(localaj.jZS, -1);
            if (((LinkedList)localObject).size() > 0)
            {
              paramAnonymousMessage = (Message)localObject;
              if (((LinkedList)localObject).size() > 40)
              {
                localObject = ((LinkedList)localObject).subList(0, 40);
                paramAnonymousMessage = new LinkedList();
                paramAnonymousMessage.addAll((Collection)localObject);
              }
              localaj.jZT = true;
              y.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[] { Integer.valueOf(paramAnonymousMessage.size()) });
              paramAnonymousMessage = new ah(paramAnonymousMessage);
              if (!com.tencent.mm.kernel.g.Dk().a(paramAnonymousMessage, 0))
              {
                y.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                ah.aQG();
              }
            }
          }
          localaj.dmL.onSceneEnd(0, 0, "", localaj);
          return;
        }
        y.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", new Object[] { Integer.valueOf(((yr)localObject).sFD) });
        localaj.a(localaj.edc, localaj.dmL);
        return;
      }
      paramAnonymousMessage = (qv)aj.a.this.jZU.getFirst();
      y.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + paramAnonymousMessage.sOA);
      aj.a.this.jZU.removeFirst();
      switch (paramAnonymousMessage.sOA)
      {
      default: 
        return;
      }
      Object localObject = aa.a(paramAnonymousMessage.sOB);
      if (localObject == null)
      {
        y.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
        sendEmptyMessage(0);
        return;
      }
      paramAnonymousMessage = aj.a.this.jZW;
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          i = localObject.length;
          y.i("MicroMsg.Fav.NetSceneFavSync", "processAddItem bufSize=%d", new Object[] { Integer.valueOf(i) });
          localObject = (by)new by().aH((byte[])localObject);
          if (localObject != null) {
            continue;
          }
          y.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
        }
        catch (IOException paramAnonymousMessage)
        {
          y.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", paramAnonymousMessage, "", new Object[0]);
          continue;
          if ((paramAnonymousMessage.jZS >= 0L) && (((by)localObject).svy >= paramAnonymousMessage.jZS)) {
            continue;
          }
          paramAnonymousMessage.jZS = ((by)localObject).svy;
          paramAnonymousMessage = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(((by)localObject).svw);
          if (paramAnonymousMessage != null) {
            break;
          }
        }
        sendEmptyMessage(0);
        return;
        i = 0;
        continue;
        y.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[] { Integer.valueOf(((by)localObject).svw), Integer.valueOf(((by)localObject).svx), Integer.valueOf(((by)localObject).svz), Integer.valueOf(((by)localObject).svy) });
        if ((((by)localObject).svx & 0x1) != 0)
        {
          b.a(((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(((by)localObject).svw), false, null);
        }
        else
        {
          paramAnonymousMessage = new g();
          paramAnonymousMessage.field_updateTime = (((by)localObject).svy * 1000L);
        }
      }
      for (int i = 1;; i = 0)
      {
        paramAnonymousMessage.field_id = ((by)localObject).svw;
        paramAnonymousMessage.field_updateSeq = ((by)localObject).svz;
        if (paramAnonymousMessage.field_localSeq == ((by)localObject).svz) {
          paramAnonymousMessage.field_updateTime = (((by)localObject).svy * 1000L);
        }
        paramAnonymousMessage.field_flag = ((by)localObject).svx;
        paramAnonymousMessage.field_type = ((by)localObject).hQR;
        if (i != 0)
        {
          paramAnonymousMessage.field_localId = System.currentTimeMillis();
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().y(paramAnonymousMessage);
          break;
        }
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(paramAnonymousMessage, new String[] { "localId" });
        break;
      }
    }
  };
  
  aj$a(aj paramaj) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj.a
 * JD-Core Version:    0.7.0.1
 */