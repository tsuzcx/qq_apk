package com.tencent.mm.ap;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.storage.bl.d;
import java.util.LinkedList;

public final class f
  extends al
{
  public final String getTag()
  {
    return "MicroMsg.FMessageDataTransfer";
  }
  
  public final boolean nb(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604307701);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20481);
    if ((paramInt != 0) && (paramInt < 604307701))
    {
      com.tencent.mm.plugin.report.service.h.vKh.dB(336, 11);
      com.tencent.mm.model.az.arV();
      Object localObject1 = c.apO().dO("fmessage", 20);
      if (localObject1 == null)
      {
        ad.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
        AppMethodBeat.o(20481);
        return;
      }
      d.aCo();
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
              localObject3 = bl.a.aIO(localObject2.field_content);
              localba = new ba();
              localba.field_createTime = localObject2.field_createTime;
              localba.field_isSend = 0;
              localba.field_msgContent = localObject2.field_content;
              localba.field_svrId = localObject2.field_msgSvrId;
              localba.field_talker = ((bl.a)localObject3).yGA;
              localba.field_type = 0;
              d.aCn().b(localba);
              break;
            case 37: 
              ad.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + localObject2.field_content);
              localObject3 = bl.d.aIR(localObject2.field_content);
              if ((bt.isNullOrNil(((bl.d)localObject3).yGA)) || ((((bl.d)localObject3).scene != 18) && (!bi.nj(((bl.d)localObject3).scene)))) {
                break label471;
              }
              ad.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + ((bl.d)localObject3).scene);
            }
          }
        }
        label471:
        ba localba = new ba();
        localba.field_createTime = localObject2.field_createTime;
        localba.field_isSend = 0;
        localba.field_msgContent = localObject2.field_content;
        localba.field_svrId = localObject2.field_msgSvrId;
        localba.field_talker = ((bl.d)localObject3).yGA;
        switch (((bl.d)localObject3).djq)
        {
        case 3: 
        case 4: 
        default: 
          localba.field_type = 1;
        }
        for (;;)
        {
          d.aCn().b(localba);
          break;
          localba.field_type = 1;
          continue;
          localba.field_type = 2;
          continue;
          localba.field_type = 3;
        }
      }
      com.tencent.mm.model.az.arV();
      c.afk().set(143618, Integer.valueOf(0));
      d.aCo().eLC();
      ad.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
      com.tencent.mm.model.az.arV();
      c.apM().aIf("fmessage");
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add("fmessage");
      com.tencent.mm.model.az.arV();
      c.apR().be((LinkedList)localObject1);
    }
    AppMethodBeat.o(20481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ap.f
 * JD-Core Version:    0.7.0.1
 */