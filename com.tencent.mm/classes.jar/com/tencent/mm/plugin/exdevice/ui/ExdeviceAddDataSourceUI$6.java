package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceAddDataSourceUI$6
  implements AdapterView.OnItemClickListener
{
  ExdeviceAddDataSourceUI$6(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = ((ListView)paramAdapterView).getHeaderViewsCount();
    paramAdapterView = ExdeviceAddDataSourceUI.c(this.jAD).qs(paramInt - i);
    if (paramAdapterView.jAK != ExdeviceAddDataSourceUI.c.jAL) {
      return;
    }
    if (!ExdeviceAddDataSourceUI.BK(paramAdapterView.mac))
    {
      y.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
      return;
    }
    ExdeviceAddDataSourceUI.a(this.jAD, paramAdapterView.mac);
    paramAdapterView.jAK = ExdeviceAddDataSourceUI.c.jAM;
    ExdeviceAddDataSourceUI.c(this.jAD).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.6
 * JD-Core Version:    0.7.0.1
 */