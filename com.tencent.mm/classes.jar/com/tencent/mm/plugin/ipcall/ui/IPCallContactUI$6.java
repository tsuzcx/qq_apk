package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class IPCallContactUI$6
  implements AdapterView.OnItemClickListener
{
  IPCallContactUI$6(IPCallContactUI paramIPCallContactUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22080);
    if (IPCallContactUI.d(this.nSm).xj(paramInt))
    {
      AppMethodBeat.o(22080);
      return;
    }
    paramAdapterView = IPCallContactUI.d(this.nSm).xM(paramInt);
    if (paramAdapterView != null)
    {
      if (!IPCallContactUI.e(this.nSm)) {
        h.qsU.e(12767, new Object[] { Integer.valueOf(2) });
      }
      paramView = new Intent(this.nSm.getContext(), IPCallUserProfileUI.class);
      paramView.putExtra("IPCallProfileUI_contactid", paramAdapterView.field_contactId);
      paramView.putExtra("IPCallProfileUI_systemUsername", paramAdapterView.field_systemAddressBookUsername);
      paramView.putExtra("IPCallProfileUI_wechatUsername", paramAdapterView.field_wechatUsername);
      this.nSm.getContext().startActivity(paramView);
    }
    AppMethodBeat.o(22080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.6
 * JD-Core Version:    0.7.0.1
 */