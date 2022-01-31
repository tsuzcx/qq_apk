package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceProfileAffectedUserView$1
  implements AdapterView.OnItemClickListener
{
  ExdeviceProfileAffectedUserView$1(ExdeviceProfileAffectedUserView paramExdeviceProfileAffectedUserView, Context paramContext) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)paramAdapterView.getAdapter().getItem(paramInt);
    y.d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", new Object[] { paramAdapterView });
    if (bk.bl(paramAdapterView))
    {
      y.w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
      return;
    }
    paramView = new Intent(this.val$context, ExdeviceProfileUI.class);
    paramView.putExtra("username", paramAdapterView);
    this.val$context.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.1
 * JD-Core Version:    0.7.0.1
 */