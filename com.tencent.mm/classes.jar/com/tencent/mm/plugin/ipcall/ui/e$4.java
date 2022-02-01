package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.model.h.c;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.i;

final class e$4
  implements AdapterView.OnItemClickListener
{
  e$4(e parame) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25652);
    Object localObject = new b();
    ((b)localObject).bd(paramAdapterView);
    ((b)localObject).bd(paramView);
    ((b)localObject).mu(paramInt);
    ((b)localObject).rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahF());
    if (this.vbI.vbz.Iw(paramInt))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(25652);
      return;
    }
    if ((paramAdapterView instanceof ListView))
    {
      paramView = this.vbI.vbz.Jj(paramInt - ((ListView)paramAdapterView).getHeaderViewsCount());
      if (paramView == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(25652);
        return;
      }
      paramAdapterView = null;
      if (paramView.field_addressId > 0L) {
        paramAdapterView = i.dgE().yh(paramView.field_addressId);
      }
      localObject = new Intent(this.vbI.vbB, IPCallUserProfileUI.class);
      if (paramAdapterView == null) {
        break label317;
      }
      ((Intent)localObject).putExtra("IPCallProfileUI_contactid", paramAdapterView.field_contactId);
      ((Intent)localObject).putExtra("IPCallProfileUI_systemUsername", paramAdapterView.field_systemAddressBookUsername);
      ((Intent)localObject).putExtra("IPCallProfileUI_wechatUsername", paramAdapterView.field_wechatUsername);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("IPCallProfileUI_isNeedShowRecord", true);
      paramAdapterView = this.vbI.vbB;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramAdapterView.startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressController$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(25652);
      return;
      label317:
      ((Intent)localObject).putExtra("IPCallProfileUI_phonenumber", paramView.field_phonenumber);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.4
 * JD-Core Version:    0.7.0.1
 */