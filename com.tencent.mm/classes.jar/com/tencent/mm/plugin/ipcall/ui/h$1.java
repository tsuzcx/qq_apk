package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
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
    int i;
    if ((paramView.getTag() instanceof Integer))
    {
      i = ((Integer)paramView.getTag()).intValue();
      if (com.tencent.mm.plugin.ipcall.b.c.dG(h.a(this.lxq))) {}
    }
    else
    {
      return;
    }
    k localk = this.lxq.sQ(i);
    View localView = null;
    if (localk.field_addressId > 0L) {
      if (!h.b(this.lxq).containsKey(Long.valueOf(localk.field_addressId))) {
        break label268;
      }
    }
    label268:
    for (paramView = (com.tencent.mm.plugin.ipcall.a.g.c)h.b(this.lxq).get(Long.valueOf(localk.field_addressId));; paramView = i.bcm().eU(localk.field_addressId))
    {
      localView = paramView;
      if (paramView != null)
      {
        h.b(this.lxq).put(Long.valueOf(localk.field_addressId), paramView);
        localView = paramView;
      }
      if (localView == null) {
        break;
      }
      paramView = new Intent(h.c(this.lxq), IPCallTalkUI.class);
      paramView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
      paramView.putExtra("IPCallTalkUI_contactId", localView.field_contactId);
      paramView.putExtra("IPCallTalkUI_nickname", localView.field_systemAddressBookUsername);
      paramView.putExtra("IPCallTalkUI_toWechatUsername", localView.field_wechatUsername);
      paramView.putExtra("IPCallTalkUI_dialScene", 3);
      com.tencent.mm.plugin.report.service.h.nFQ.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
      ((FragmentActivity)h.d(this.lxq)).startActivityForResult(paramView, 1001);
      return;
    }
    paramView = new Intent(h.e(this.lxq), IPCallTalkUI.class);
    paramView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
    paramView.putExtra("IPCallTalkUI_dialScene", 3);
    com.tencent.mm.plugin.report.service.h.nFQ.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    ((FragmentActivity)h.f(this.lxq)).startActivityForResult(paramView, 1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h.1
 * JD-Core Version:    0.7.0.1
 */