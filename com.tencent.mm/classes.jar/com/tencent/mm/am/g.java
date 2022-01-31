package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class g
  extends ai
{
  public final String getTag()
  {
    return "MicroMsg.FMessageDataTransfer";
  }
  
  public final boolean kv(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604307701);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(16435);
    if ((paramInt != 0) && (paramInt < 604307701))
    {
      com.tencent.mm.plugin.report.service.h.qsU.cT(336, 11);
      com.tencent.mm.model.aw.aaz();
      Object localObject1 = c.YC().cM("fmessage", 20);
      if (localObject1 == null)
      {
        ab.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
        AppMethodBeat.o(16435);
        return;
      }
      d.ali();
      ab.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + localObject1.length);
      int i = localObject1.length;
      paramInt = 0;
      if (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if ((localObject2 == null) || (localObject2.field_msgId == 0L)) {
          ab.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
        }
        Object localObject3;
        for (;;)
        {
          paramInt += 1;
          break;
          ab.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + localObject2.getType());
          localObject3 = localObject2.field_content;
          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
            ab.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + localObject2.field_msgId);
          } else {
            switch (localObject2.getType())
            {
            case 38: 
            case 39: 
            default: 
              ab.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + localObject2.getType());
              break;
            case 40: 
              ab.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + localObject2.field_content);
              localObject3 = bi.a.asj(localObject2.field_content);
              localax = new ax();
              localax.field_createTime = localObject2.field_createTime;
              localax.field_isSend = 0;
              localax.field_msgContent = localObject2.field_content;
              localax.field_svrId = localObject2.field_msgSvrId;
              localax.field_talker = ((bi.a)localObject3).tac;
              localax.field_type = 0;
              d.alh().b(localax);
              break;
            case 37: 
              ab.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + localObject2.field_content);
              localObject3 = bi.d.asm(localObject2.field_content);
              if ((ah.isNullOrNil(((bi.d)localObject3).tac)) || ((((bi.d)localObject3).scene != 18) && (!bf.kD(((bi.d)localObject3).scene)))) {
                break label471;
              }
              ab.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + ((bi.d)localObject3).scene);
            }
          }
        }
        label471:
        ax localax = new ax();
        localax.field_createTime = localObject2.field_createTime;
        localax.field_isSend = 0;
        localax.field_msgContent = localObject2.field_content;
        localax.field_svrId = localObject2.field_msgSvrId;
        localax.field_talker = ((bi.d)localObject3).tac;
        switch (((bi.d)localObject3).cut)
        {
        case 3: 
        case 4: 
        default: 
          localax.field_type = 1;
        }
        for (;;)
        {
          d.alh().b(localax);
          break;
          localax.field_type = 1;
          continue;
          localax.field_type = 2;
          continue;
          localax.field_type = 3;
        }
      }
      com.tencent.mm.model.aw.aaz();
      c.Ru().set(143618, Integer.valueOf(0));
      d.ali().dxx();
      ab.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
      com.tencent.mm.model.aw.aaz();
      c.YA().arC("fmessage");
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add("fmessage");
      com.tencent.mm.model.aw.aaz();
      c.YF().aK((LinkedList)localObject1);
    }
    AppMethodBeat.o(16435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.g
 * JD-Core Version:    0.7.0.1
 */