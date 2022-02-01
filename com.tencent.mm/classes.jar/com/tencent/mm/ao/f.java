package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.ca.d;
import java.util.LinkedList;

public final class f
  extends as
{
  public final String getTag()
  {
    return "MicroMsg.FMessageDataTransfer";
  }
  
  public final boolean rT(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604307701);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20481);
    if ((paramInt != 0) && (paramInt < 604307701))
    {
      h.CyF.dN(336, 11);
      bg.aVF();
      Object localObject1 = c.aSQ().eH("fmessage", 20);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
        AppMethodBeat.o(20481);
        return;
      }
      d.bgN();
      Log.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + localObject1.length);
      int i = localObject1.length;
      paramInt = 0;
      if (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if ((localObject2 == null) || (localObject2.field_msgId == 0L)) {
          Log.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
        }
        Object localObject3;
        for (;;)
        {
          paramInt += 1;
          break;
          Log.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + localObject2.getType());
          localObject3 = localObject2.field_content;
          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
            Log.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + localObject2.field_msgId);
          } else {
            switch (localObject2.getType())
            {
            case 38: 
            case 39: 
            default: 
              Log.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + localObject2.getType());
              break;
            case 40: 
              Log.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + localObject2.field_content);
              localObject3 = ca.a.bkA(localObject2.field_content);
              localbn = new bn();
              localbn.field_createTime = localObject2.field_createTime;
              localbn.field_isSend = 0;
              localbn.field_msgContent = localObject2.field_content;
              localbn.field_svrId = localObject2.field_msgSvrId;
              localbn.field_talker = ((ca.a)localObject3).dkU;
              localbn.field_type = 0;
              d.bgM().b(localbn);
              break;
            case 37: 
              Log.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + localObject2.field_content);
              localObject3 = ca.d.bkD(localObject2.field_content);
              if ((Util.isNullOrNil(((ca.d)localObject3).dkU)) || ((((ca.d)localObject3).scene != 18) && (!bp.sb(((ca.d)localObject3).scene)))) {
                break label471;
              }
              Log.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + ((ca.d)localObject3).scene);
            }
          }
        }
        label471:
        bn localbn = new bn();
        localbn.field_createTime = localObject2.field_createTime;
        localbn.field_isSend = 0;
        localbn.field_msgContent = localObject2.field_content;
        localbn.field_svrId = localObject2.field_msgSvrId;
        localbn.field_talker = ((ca.d)localObject3).dkU;
        switch (((ca.d)localObject3).dKy)
        {
        case 3: 
        case 4: 
        default: 
          localbn.field_type = 1;
        }
        for (;;)
        {
          d.bgM().b(localbn);
          break;
          localbn.field_type = 1;
          continue;
          localbn.field_type = 2;
          continue;
          localbn.field_type = 3;
        }
      }
      bg.aVF();
      c.azQ().set(143618, Integer.valueOf(0));
      d.bgN().gCQ();
      Log.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
      bg.aVF();
      c.aSN().aNa("fmessage");
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add("fmessage");
      bg.aVF();
      c.aST().bI((LinkedList)localObject1);
    }
    AppMethodBeat.o(20481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.f
 * JD-Core Version:    0.7.0.1
 */