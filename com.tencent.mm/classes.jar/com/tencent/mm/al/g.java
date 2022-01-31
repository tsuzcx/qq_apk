package com.tencent.mm.al;

import com.tencent.mm.bh.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.model.ah
{
  public final String getTag()
  {
    return "MicroMsg.FMessageDataTransfer";
  }
  
  public final boolean hJ(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604307701);
  }
  
  public final void transfer(int paramInt)
  {
    if ((paramInt != 0) && (paramInt < 604307701))
    {
      h.nFQ.h(336L, 11L, 1L);
      au.Hx();
      localObject1 = c.Fy().bV("fmessage", 20);
      if (localObject1 == null) {
        y.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
      }
    }
    else
    {
      return;
    }
    d.RY();
    y.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + localObject1.length);
    int i = localObject1.length;
    paramInt = 0;
    if (paramInt < i)
    {
      Object localObject2 = localObject1[paramInt];
      if ((localObject2 == null) || (localObject2.field_msgId == 0L)) {
        y.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
      }
      Object localObject3;
      for (;;)
      {
        paramInt += 1;
        break;
        y.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + localObject2.getType());
        localObject3 = localObject2.field_content;
        if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
          y.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + localObject2.field_msgId);
        } else {
          switch (localObject2.getType())
          {
          case 38: 
          case 39: 
          default: 
            y.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + localObject2.getType());
            break;
          case 40: 
            y.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + localObject2.field_content);
            localObject3 = bi.a.abZ(localObject2.field_content);
            localax = new ax();
            localax.field_createTime = localObject2.field_createTime;
            localax.field_isSend = 0;
            localax.field_msgContent = localObject2.field_content;
            localax.field_svrId = localObject2.field_msgSvrId;
            localax.field_talker = ((bi.a)localObject3).pyp;
            localax.field_type = 0;
            d.RX().b(localax);
            break;
          case 37: 
            y.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + localObject2.field_content);
            localObject3 = bi.d.acc(localObject2.field_content);
            if ((com.tencent.mm.platformtools.ah.bl(((bi.d)localObject3).pyp)) || ((((bi.d)localObject3).scene != 18) && (!com.tencent.mm.model.bd.hR(((bi.d)localObject3).scene)))) {
              break label463;
            }
            y.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + ((bi.d)localObject3).scene);
          }
        }
      }
      label463:
      ax localax = new ax();
      localax.field_createTime = localObject2.field_createTime;
      localax.field_isSend = 0;
      localax.field_msgContent = localObject2.field_content;
      localax.field_svrId = localObject2.field_msgSvrId;
      localax.field_talker = ((bi.d)localObject3).pyp;
      switch (((bi.d)localObject3).bNb)
      {
      case 3: 
      case 4: 
      default: 
        localax.field_type = 1;
      }
      for (;;)
      {
        d.RX().b(localax);
        break;
        localax.field_type = 1;
        continue;
        localax.field_type = 2;
        continue;
        localax.field_type = 3;
      }
    }
    au.Hx();
    c.Dz().o(143618, Integer.valueOf(0));
    d.RY().cuT();
    y.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
    au.Hx();
    c.Fw().abr("fmessage");
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add("fmessage");
    au.Hx();
    c.FB().aA((LinkedList)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.al.g
 * JD-Core Version:    0.7.0.1
 */