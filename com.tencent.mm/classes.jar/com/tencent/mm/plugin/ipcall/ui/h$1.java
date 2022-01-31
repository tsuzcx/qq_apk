package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import java.util.HashMap;

final class h$1
  implements View.OnClickListener
{
  h$1(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22238);
    if ((paramView.getTag() instanceof Integer))
    {
      int i = ((Integer)paramView.getTag()).intValue();
      if (!com.tencent.mm.plugin.ipcall.b.c.es(h.a(this.nUD)))
      {
        AppMethodBeat.o(22238);
        return;
      }
      k localk = this.nUD.xS(i);
      View localView = null;
      if (localk.field_addressId > 0L) {
        if (!h.b(this.nUD).containsKey(Long.valueOf(localk.field_addressId))) {
          break label286;
        }
      }
      label286:
      for (paramView = (com.tencent.mm.plugin.ipcall.a.g.c)h.b(this.nUD).get(Long.valueOf(localk.field_addressId));; paramView = i.bJt().kq(localk.field_addressId))
      {
        localView = paramView;
        if (paramView != null)
        {
          h.b(this.nUD).put(Long.valueOf(localk.field_addressId), paramView);
          localView = paramView;
        }
        if (localView == null) {
          break;
        }
        paramView = new Intent(h.c(this.nUD), IPCallTalkUI.class);
        paramView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
        paramView.putExtra("IPCallTalkUI_contactId", localView.field_contactId);
        paramView.putExtra("IPCallTalkUI_nickname", localView.field_systemAddressBookUsername);
        paramView.putExtra("IPCallTalkUI_toWechatUsername", localView.field_wechatUsername);
        paramView.putExtra("IPCallTalkUI_dialScene", 3);
        com.tencent.mm.plugin.report.service.h.qsU.e(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
        ((FragmentActivity)h.d(this.nUD)).startActivityForResult(paramView, 1001);
        AppMethodBeat.o(22238);
        return;
      }
      paramView = new Intent(h.e(this.nUD), IPCallTalkUI.class);
      paramView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
      paramView.putExtra("IPCallTalkUI_dialScene", 3);
      com.tencent.mm.plugin.report.service.h.qsU.e(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
      ((FragmentActivity)h.f(this.nUD)).startActivityForResult(paramView, 1001);
    }
    AppMethodBeat.o(22238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h.1
 * JD-Core Version:    0.7.0.1
 */