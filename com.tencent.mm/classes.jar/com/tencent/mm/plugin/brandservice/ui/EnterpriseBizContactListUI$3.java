package com.tencent.mm.plugin.brandservice.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.List;

final class EnterpriseBizContactListUI$3
  extends ak
{
  EnterpriseBizContactListUI$3(EnterpriseBizContactListUI paramEnterpriseBizContactListUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(13946);
    if ((paramMessage != null) && (paramMessage.what == 1) && (this.jUg != null) && (!this.jUg.isFinishing()))
    {
      z.afu().rw(this.jUg.jUc);
      z.afi();
      paramMessage = e.rN(this.jUg.jUc);
      int i = 0;
      while (i < paramMessage.size())
      {
        String str = (String)paramMessage.get(i);
        if ((t.nT(str)) && ((f.rY(str)) || (f.lg(str)))) {
          z.afu().rw(str);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(13946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.3
 * JD-Core Version:    0.7.0.1
 */