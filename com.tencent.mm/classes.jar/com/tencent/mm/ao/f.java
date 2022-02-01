package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bv.d;
import java.util.LinkedList;

public final class f
  extends ao
{
  public final String getTag()
  {
    return "MicroMsg.FMessageDataTransfer";
  }
  
  public final boolean os(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604307701);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20481);
    if ((paramInt != 0) && (paramInt < 604307701))
    {
      g.yxI.dD(336, 11);
      bc.aCg();
      Object localObject1 = c.azI().et("fmessage", 20);
      if (localObject1 == null)
      {
        ae.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
        AppMethodBeat.o(20481);
        return;
      }
      d.aMM();
      ae.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + localObject1.length);
      int i = localObject1.length;
      paramInt = 0;
      if (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if ((localObject2 == null) || (localObject2.field_msgId == 0L)) {
          ae.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
        }
        Object localObject3;
        for (;;)
        {
          paramInt += 1;
          break;
          ae.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + localObject2.getType());
          localObject3 = localObject2.field_content;
          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
            ae.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + localObject2.field_msgId);
          } else {
            switch (localObject2.getType())
            {
            case 38: 
            case 39: 
            default: 
              ae.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + localObject2.getType());
              break;
            case 40: 
              ae.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + localObject2.field_content);
              localObject3 = bv.a.aVC(localObject2.field_content);
              localbi = new bi();
              localbi.field_createTime = localObject2.field_createTime;
              localbi.field_isSend = 0;
              localbi.field_msgContent = localObject2.field_content;
              localbi.field_svrId = localObject2.field_msgSvrId;
              localbi.field_talker = ((bv.a)localObject3).cUA;
              localbi.field_type = 0;
              d.aML().b(localbi);
              break;
            case 37: 
              ae.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + localObject2.field_content);
              localObject3 = bv.d.aVF(localObject2.field_content);
              if ((bu.isNullOrNil(((bv.d)localObject3).cUA)) || ((((bv.d)localObject3).scene != 18) && (!bl.oA(((bv.d)localObject3).scene)))) {
                break label471;
              }
              ae.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + ((bv.d)localObject3).scene);
            }
          }
        }
        label471:
        bi localbi = new bi();
        localbi.field_createTime = localObject2.field_createTime;
        localbi.field_isSend = 0;
        localbi.field_msgContent = localObject2.field_content;
        localbi.field_svrId = localObject2.field_msgSvrId;
        localbi.field_talker = ((bv.d)localObject3).cUA;
        switch (((bv.d)localObject3).dto)
        {
        case 3: 
        case 4: 
        default: 
          localbi.field_type = 1;
        }
        for (;;)
        {
          d.aML().b(localbi);
          break;
          localbi.field_type = 1;
          continue;
          localbi.field_type = 2;
          continue;
          localbi.field_type = 3;
        }
      }
      bc.aCg();
      c.ajA().set(143618, Integer.valueOf(0));
      d.aMM().fvj();
      ae.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
      bc.aCg();
      c.azF().aUS("fmessage");
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add("fmessage");
      bc.aCg();
      c.azL().bn((LinkedList)localObject1);
    }
    AppMethodBeat.o(20481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ao.f
 * JD-Core Version:    0.7.0.1
 */