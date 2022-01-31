package com.tencent.mm.plugin.brandservice.ui;

import android.os.Message;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

final class EnterpriseBizContactListUI$3
  extends ah
{
  EnterpriseBizContactListUI$3(EnterpriseBizContactListUI paramEnterpriseBizContactListUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 1) && (this.ids != null) && (!this.ids.isFinishing()))
    {
      z.MK().kC(this.ids.ido);
      z.My();
      paramMessage = e.kS(this.ids.ido);
      int i = 0;
      while (i < paramMessage.size())
      {
        String str = (String)paramMessage.get(i);
        if ((s.hk(str)) && ((f.ld(str)) || (f.eW(str)))) {
          z.MK().kC(str);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.3
 * JD-Core Version:    0.7.0.1
 */