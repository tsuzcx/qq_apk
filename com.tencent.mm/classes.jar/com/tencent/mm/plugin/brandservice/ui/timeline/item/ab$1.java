package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import java.util.LinkedList;

final class ab$1
  implements DialogInterface.OnClickListener
{
  ab$1(ab paramab, w paramw) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(6035);
    Object localObject;
    aig localaig;
    if (this.ofI.fpe())
    {
      ag.aGf().Dv(this.ofI.field_msgId);
      j.a(3, this.ofI.fpm(), null);
      paramDialogInterface = this.ofJ.ofm.oaB;
      localObject = this.ofI;
      if (!((w)localObject).fpe()) {
        break label289;
      }
      localObject = ((w)localObject).fpm();
      if ((localObject == null) || (((dlt)localObject).style != 101)) {
        break label176;
      }
      localaig = ((dlt)localObject).HAf;
      paramDialogInterface.a(((ok)localaig.FHP.get(0)).nDo, 0L, 0, 3, ((dlt)localObject).Hki, "", 0, localaig.FHY, ((dlt)localObject).dln, localaig.FHU, 0, ((dlt)localObject).style, "");
    }
    label287:
    label289:
    for (;;)
    {
      this.ofJ.ofm.oar.i(this.ofI);
      AppMethodBeat.o(6035);
      return;
      bj.rJ(this.ofI.field_msgId);
      break;
      label176:
      if ((localObject != null) && (((dlt)localObject).style == 102))
      {
        paramInt = 0;
        for (;;)
        {
          if (paramInt >= ((dlt)localObject).HAf.FHP.size()) {
            break label287;
          }
          localaig = ((dlt)localObject).HAf;
          if (((ok)localaig.FHP.get(paramInt)).FuX == 0)
          {
            paramDialogInterface.a(((ok)localaig.FHP.get(paramInt)).nDo, 0L, 0, 3, ((dlt)localObject).Hki, "", 0, localaig.FHY, ((dlt)localObject).dln, localaig.FHU, 0, ((dlt)localObject).style, "");
            break;
          }
          paramInt += 1;
        }
        continue;
        paramDialogInterface.d((w)localObject, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.1
 * JD-Core Version:    0.7.0.1
 */