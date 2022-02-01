package com.tencent.mm.ap;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.modelverify.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.cc.f;
import java.util.LinkedList;

public final class f
  extends au
{
  public final String getTag()
  {
    return "MicroMsg.FMessageDataTransfer";
  }
  
  public final void vb(int paramInt)
  {
    AppMethodBeat.i(20481);
    if ((paramInt != 0) && (paramInt < 604307701))
    {
      h.OAn.kJ(336, 11);
      bh.bCz();
      Object localObject1 = c.bzD().gb("fmessage", 20);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
        AppMethodBeat.o(20481);
        return;
      }
      d.bNI();
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
              Log.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + Util.secPrint(localObject2.field_content));
              localObject3 = cc.a.bys(localObject2.field_content);
              localbp = new bp();
              localbp.field_createTime = localObject2.getCreateTime();
              localbp.field_isSend = 0;
              localbp.field_msgContent = localObject2.field_content;
              localbp.field_svrId = localObject2.field_msgSvrId;
              localbp.field_talker = ((cc.a)localObject3).hgk;
              localbp.field_type = 0;
              d.bNH().b(localbp);
              break;
            case 37: 
              Log.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + Util.secPrint(localObject2.field_content));
              localObject3 = cc.f.byv(localObject2.field_content);
              if ((Util.isNullOrNil(((cc.f)localObject3).hgk)) || ((((cc.f)localObject3).scene != 18) && (!br.vj(((cc.f)localObject3).scene)))) {
                break label477;
              }
              Log.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + ((cc.f)localObject3).scene);
            }
          }
        }
        label477:
        bp localbp = new bp();
        localbp.field_createTime = localObject2.getCreateTime();
        localbp.field_isSend = 0;
        localbp.field_msgContent = localObject2.field_content;
        localbp.field_svrId = localObject2.field_msgSvrId;
        localbp.field_talker = ((cc.f)localObject3).hgk;
        switch (((cc.f)localObject3).hId)
        {
        case 3: 
        case 4: 
        default: 
          localbp.field_type = 1;
        }
        for (;;)
        {
          d.bNH().b(localbp);
          break;
          localbp.field_type = 1;
          continue;
          localbp.field_type = 2;
          continue;
          localbp.field_type = 3;
        }
      }
      bh.bCz();
      c.ban().B(143618, Integer.valueOf(0));
      d.bNI().jbd();
      Log.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
      bh.bCz();
      c.bzA().bxC("fmessage");
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add("fmessage");
      bh.bCz();
      c.bzG().cv((LinkedList)localObject1);
    }
    AppMethodBeat.o(20481);
  }
  
  public final boolean vc(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604307701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ap.f
 * JD-Core Version:    0.7.0.1
 */