package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class ExdeviceManageDeviceUI$a$2
  implements View.OnClickListener
{
  ExdeviceManageDeviceUI$a$2(ExdeviceManageDeviceUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    if (ExdeviceManageDeviceUI.a.b(this.jDH)) {}
    int i;
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while ((paramView == null) || (!(paramView instanceof Integer)));
      i = ((Integer)paramView).intValue();
    } while ((i < 0) || (i >= this.jDH.getCount()));
    paramView = this.jDH.qy(i);
    Context localContext = (Context)ExdeviceManageDeviceUI.a.c(this.jDH).get();
    if (localContext == null)
    {
      y.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
      return;
    }
    ExdeviceManageDeviceUI.a.a(localContext, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.2
 * JD-Core Version:    0.7.0.1
 */