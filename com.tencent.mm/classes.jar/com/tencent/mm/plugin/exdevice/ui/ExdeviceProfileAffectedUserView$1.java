package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class ExdeviceProfileAffectedUserView$1
  implements AdapterView.OnItemClickListener
{
  ExdeviceProfileAffectedUserView$1(ExdeviceProfileAffectedUserView paramExdeviceProfileAffectedUserView, Context paramContext) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(24079);
    paramView = (String)paramAdapterView.getAdapter().getItem(paramInt);
    ad.d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", new Object[] { paramView });
    if (bt.isNullOrNil(paramView))
    {
      ad.w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
      AppMethodBeat.o(24079);
      return;
    }
    paramAdapterView = new Intent(this.val$context, ExdeviceProfileUI.class);
    paramAdapterView.putExtra("username", paramView);
    paramView = this.val$context;
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAdapterView);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramAdapterView.adn(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)paramAdapterView.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.1
 * JD-Core Version:    0.7.0.1
 */