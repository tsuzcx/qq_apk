package com.tencent.mm.ap;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.am;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.storage.bu.d;
import java.util.LinkedList;

public final class f
  extends am
{
  public final String getTag()
  {
    return "MicroMsg.FMessageDataTransfer";
  }
  
  public final boolean op(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604307701);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20481);
    if ((paramInt != 0) && (paramInt < 604307701))
    {
      g.yhR.dD(336, 11);
      ba.aBQ();
      Object localObject1 = c.azs().em("fmessage", 20);
      if (localObject1 == null)
      {
        ad.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
        AppMethodBeat.o(20481);
        return;
      }
      d.aMo();
      ad.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + localObject1.length);
      int i = localObject1.length;
      paramInt = 0;
      if (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if ((localObject2 == null) || (localObject2.field_msgId == 0L)) {
          ad.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
        }
        Object localObject3;
        for (;;)
        {
          paramInt += 1;
          break;
          ad.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + localObject2.getType());
          localObject3 = localObject2.field_content;
          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
            ad.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + localObject2.field_msgId);
          } else {
            switch (localObject2.getType())
            {
            case 38: 
            case 39: 
            default: 
              ad.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + localObject2.getType());
              break;
            case 40: 
              ad.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + localObject2.field_content);
              localObject3 = bu.a.aUb(localObject2.field_content);
              localbh = new bh();
              localbh.field_createTime = localObject2.field_createTime;
              localbh.field_isSend = 0;
              localbh.field_msgContent = localObject2.field_content;
              localbh.field_svrId = localObject2.field_msgSvrId;
              localbh.field_talker = ((bu.a)localObject3).dHm;
              localbh.field_type = 0;
              d.aMn().b(localbh);
              break;
            case 37: 
              ad.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + localObject2.field_content);
              localObject3 = bu.d.aUe(localObject2.field_content);
              if ((bt.isNullOrNil(((bu.d)localObject3).dHm)) || ((((bu.d)localObject3).scene != 18) && (!bj.ox(((bu.d)localObject3).scene)))) {
                break label471;
              }
              ad.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + ((bu.d)localObject3).scene);
            }
          }
        }
        label471:
        bh localbh = new bh();
        localbh.field_createTime = localObject2.field_createTime;
        localbh.field_isSend = 0;
        localbh.field_msgContent = localObject2.field_content;
        localbh.field_svrId = localObject2.field_msgSvrId;
        localbh.field_talker = ((bu.d)localObject3).dHm;
        switch (((bu.d)localObject3).dsi)
        {
        case 3: 
        case 4: 
        default: 
          localbh.field_type = 1;
        }
        for (;;)
        {
          d.aMn().b(localbh);
          break;
          localbh.field_type = 1;
          continue;
          localbh.field_type = 2;
          continue;
          localbh.field_type = 3;
        }
      }
      ba.aBQ();
      c.ajl().set(143618, Integer.valueOf(0));
      d.aMo().frj();
      ad.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
      ba.aBQ();
      c.azp().aTr("fmessage");
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add("fmessage");
      ba.aBQ();
      c.azv().bm((LinkedList)localObject1);
    }
    AppMethodBeat.o(20481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ap.f
 * JD-Core Version:    0.7.0.1
 */