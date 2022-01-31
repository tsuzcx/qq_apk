package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class b$1
  implements f
{
  b$1(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(22488);
    ab.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
    switch (paramm.getType())
    {
    case 636: 
    case 637: 
    default: 
      AppMethodBeat.o(22488);
      return;
    case 635: 
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        b.i(this.nXT.username, this.nXT.nXQ);
        AppMethodBeat.o(22488);
        return;
      }
      this.nXT.bKR();
      ab.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
      AppMethodBeat.o(22488);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((this.nXT.nXR == null) || (this.nXT.nXR.isEmpty())) {
        break label281;
      }
    }
    label281:
    for (paramInt1 = this.nXT.nXR.size();; paramInt1 = 0)
    {
      if ((this.nXT.nXQ != null) && (!this.nXT.nXQ.isEmpty())) {}
      for (paramInt2 = this.nXT.nXQ.size() - paramInt1;; paramInt2 = 0)
      {
        if ((paramInt1 > 0) || (paramInt2 > 0))
        {
          ab.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          h.qsU.e(11220, new Object[] { r.Zn(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0) });
        }
        this.nXT.bKR();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.1
 * JD-Core Version:    0.7.0.1
 */