package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ExdeviceAddDataSourceUI$6
  implements AdapterView.OnItemClickListener
{
  ExdeviceAddDataSourceUI$6(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(19780);
    int i = ((ListView)paramAdapterView).getHeaderViewsCount();
    paramAdapterView = ExdeviceAddDataSourceUI.c(this.lKc).uZ(paramInt - i);
    if (paramAdapterView.lKj != ExdeviceAddDataSourceUI.c.lKk)
    {
      AppMethodBeat.o(19780);
      return;
    }
    if (!ExdeviceAddDataSourceUI.LM(paramAdapterView.mac))
    {
      ab.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
      AppMethodBeat.o(19780);
      return;
    }
    ExdeviceAddDataSourceUI.a(this.lKc, paramAdapterView.mac);
    paramAdapterView.lKj = ExdeviceAddDataSourceUI.c.lKl;
    ExdeviceAddDataSourceUI.c(this.lKc).notifyDataSetChanged();
    AppMethodBeat.o(19780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.6
 * JD-Core Version:    0.7.0.1
 */