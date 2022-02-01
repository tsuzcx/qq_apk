package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.al;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.storage.bo.d;
import java.util.LinkedList;

public final class f
  extends al
{
  public final String getTag()
  {
    return "MicroMsg.FMessageDataTransfer";
  }
  
  public final boolean nP(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604307701);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20481);
    if ((paramInt != 0) && (paramInt < 604307701))
    {
      com.tencent.mm.plugin.report.service.h.wUl.dB(336, 11);
      az.ayM();
      Object localObject1 = c.awD().dV("fmessage", 20);
      if (localObject1 == null)
      {
        ac.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
        AppMethodBeat.o(20481);
        return;
      }
      d.aJe();
      ac.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + localObject1.length);
      int i = localObject1.length;
      paramInt = 0;
      if (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if ((localObject2 == null) || (localObject2.field_msgId == 0L)) {
          ac.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
        }
        Object localObject3;
        for (;;)
        {
          paramInt += 1;
          break;
          ac.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + localObject2.getType());
          localObject3 = localObject2.field_content;
          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
            ac.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + localObject2.field_msgId);
          } else {
            switch (localObject2.getType())
            {
            case 38: 
            case 39: 
            default: 
              ac.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + localObject2.getType());
              break;
            case 40: 
              ac.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + localObject2.field_content);
              localObject3 = bo.a.aOk(localObject2.field_content);
              localbd = new bd();
              localbd.field_createTime = localObject2.field_createTime;
              localbd.field_isSend = 0;
              localbd.field_msgContent = localObject2.field_content;
              localbd.field_svrId = localObject2.field_msgSvrId;
              localbd.field_talker = ((bo.a)localObject3).zTO;
              localbd.field_type = 0;
              d.aJd().b(localbd);
              break;
            case 37: 
              ac.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + localObject2.field_content);
              localObject3 = bo.d.aOn(localObject2.field_content);
              if ((bs.isNullOrNil(((bo.d)localObject3).zTO)) || ((((bo.d)localObject3).scene != 18) && (!bi.nX(((bo.d)localObject3).scene)))) {
                break label471;
              }
              ac.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + ((bo.d)localObject3).scene);
            }
          }
        }
        label471:
        bd localbd = new bd();
        localbd.field_createTime = localObject2.field_createTime;
        localbd.field_isSend = 0;
        localbd.field_msgContent = localObject2.field_content;
        localbd.field_svrId = localObject2.field_msgSvrId;
        localbd.field_talker = ((bo.d)localObject3).zTO;
        switch (((bo.d)localObject3).dgL)
        {
        case 3: 
        case 4: 
        default: 
          localbd.field_type = 1;
        }
        for (;;)
        {
          d.aJd().b(localbd);
          break;
          localbd.field_type = 1;
          continue;
          localbd.field_type = 2;
          continue;
          localbd.field_type = 3;
        }
      }
      az.ayM();
      c.agA().set(143618, Integer.valueOf(0));
      d.aJe().fbg();
      ac.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
      az.ayM();
      c.awB().aNA("fmessage");
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add("fmessage");
      az.ayM();
      c.awG().bl((LinkedList)localObject1);
    }
    AppMethodBeat.o(20481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ao.f
 * JD-Core Version:    0.7.0.1
 */