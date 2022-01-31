package com.tencent.mm.plugin.label.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class ContactLabelEditUI$13
  implements AbsListView.OnScrollListener
{
  ContactLabelEditUI$13(ContactLabelEditUI paramContactLabelEditUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1)) {
      this.lBl.XM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.13
 * JD-Core Version:    0.7.0.1
 */