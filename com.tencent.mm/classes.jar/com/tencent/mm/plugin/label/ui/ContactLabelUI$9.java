package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.sdk.platformtools.bo;

final class ContactLabelUI$9
  implements AdapterView.OnItemClickListener
{
  ContactLabelUI$9(ContactLabelUI paramContactLabelUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22673);
    if (ContactLabelUI.f(this.nZv) == null)
    {
      AppMethodBeat.o(22673);
      return;
    }
    paramAdapterView = ContactLabelUI.f(this.nZv).getItem(paramInt);
    if ((!bo.isNullOrNil(paramAdapterView)) && (ContactLabelUI.b(this.nZv) != null))
    {
      ContactLabelUI.b(this.nZv).dEm();
      ContactLabelUI.b(this.nZv).cj(paramAdapterView, true);
      ContactLabelUI.c(this.nZv).ck(paramAdapterView, true);
    }
    AppMethodBeat.o(22673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.9
 * JD-Core Version:    0.7.0.1
 */