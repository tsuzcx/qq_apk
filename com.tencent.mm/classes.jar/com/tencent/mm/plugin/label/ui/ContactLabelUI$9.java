package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.sdk.platformtools.bk;

final class ContactLabelUI$9
  implements AdapterView.OnItemClickListener
{
  ContactLabelUI$9(ContactLabelUI paramContactLabelUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (ContactLabelUI.f(this.lCj) == null) {}
    do
    {
      return;
      paramAdapterView = ContactLabelUI.f(this.lCj).ke(paramInt);
    } while ((bk.bl(paramAdapterView)) || (ContactLabelUI.b(this.lCj) == null));
    ContactLabelUI.b(this.lCj).cAZ();
    ContactLabelUI.b(this.lCj).bH(paramAdapterView, true);
    ContactLabelUI.c(this.lCj).bI(paramAdapterView, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.9
 * JD-Core Version:    0.7.0.1
 */