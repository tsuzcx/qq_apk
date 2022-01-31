package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(22036);
    if (this.nRH.nRy.xj(paramInt))
    {
      AppMethodBeat.o(22036);
      return;
    }
    Intent localIntent;
    if ((paramAdapterView instanceof ListView))
    {
      paramView = this.nRH.nRy.xS(paramInt - ((ListView)paramAdapterView).getHeaderViewsCount());
      if (paramView == null)
      {
        AppMethodBeat.o(22036);
        return;
      }
      paramAdapterView = null;
      if (paramView.field_addressId > 0L) {
        paramAdapterView = i.bJt().kq(paramView.field_addressId);
      }
      localIntent = new Intent(this.nRH.nRA, IPCallUserProfileUI.class);
      if (paramAdapterView == null) {
        break label173;
      }
      localIntent.putExtra("IPCallProfileUI_contactid", paramAdapterView.field_contactId);
      localIntent.putExtra("IPCallProfileUI_systemUsername", paramAdapterView.field_systemAddressBookUsername);
      localIntent.putExtra("IPCallProfileUI_wechatUsername", paramAdapterView.field_wechatUsername);
    }
    for (;;)
    {
      localIntent.putExtra("IPCallProfileUI_isNeedShowRecord", true);
      this.nRH.nRA.startActivity(localIntent);
      AppMethodBeat.o(22036);
      return;
      label173:
      localIntent.putExtra("IPCallProfileUI_phonenumber", paramView.field_phonenumber);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.4
 * JD-Core Version:    0.7.0.1
 */