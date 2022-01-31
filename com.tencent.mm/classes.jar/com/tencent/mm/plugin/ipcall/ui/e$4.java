package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;

final class e$4
  implements AdapterView.OnItemClickListener
{
  e$4(e parame) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.lup.lug.sk(paramInt)) {}
    do
    {
      do
      {
        return;
      } while (!(paramAdapterView instanceof ListView));
      paramView = this.lup.lug.sQ(paramInt - ((ListView)paramAdapterView).getHeaderViewsCount());
    } while (paramView == null);
    paramAdapterView = null;
    if (paramView.field_addressId > 0L) {
      paramAdapterView = i.bcm().eU(paramView.field_addressId);
    }
    Intent localIntent = new Intent(this.lup.lui, IPCallUserProfileUI.class);
    if (paramAdapterView != null)
    {
      localIntent.putExtra("IPCallProfileUI_contactid", paramAdapterView.field_contactId);
      localIntent.putExtra("IPCallProfileUI_systemUsername", paramAdapterView.field_systemAddressBookUsername);
      localIntent.putExtra("IPCallProfileUI_wechatUsername", paramAdapterView.field_wechatUsername);
    }
    for (;;)
    {
      localIntent.putExtra("IPCallProfileUI_isNeedShowRecord", true);
      this.lup.lui.startActivity(localIntent);
      return;
      localIntent.putExtra("IPCallProfileUI_phonenumber", paramView.field_phonenumber);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.4
 * JD-Core Version:    0.7.0.1
 */