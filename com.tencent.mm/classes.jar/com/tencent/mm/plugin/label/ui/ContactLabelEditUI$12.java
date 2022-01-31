package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;

final class ContactLabelEditUI$12
  implements Runnable
{
  ContactLabelEditUI$12(ContactLabelEditUI paramContactLabelEditUI) {}
  
  public final void run()
  {
    ArrayList localArrayList = e.bdz().aba(ContactLabelEditUI.i(this.lBl));
    if (localArrayList == null)
    {
      y.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
      return;
    }
    if (localArrayList != null)
    {
      ContactLabelEditUI.a(this.lBl, localArrayList);
      if (ContactLabelEditUI.j(this.lBl) != null) {
        break label101;
      }
      ContactLabelEditUI.b(this.lBl, new ArrayList());
    }
    for (;;)
    {
      ContactLabelEditUI.j(this.lBl).addAll(localArrayList);
      if (ContactLabelEditUI.k(this.lBl) == null) {
        break;
      }
      ContactLabelEditUI.k(this.lBl).sendEmptyMessage(6001);
      return;
      label101:
      ContactLabelEditUI.j(this.lBl).clear();
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|initView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.12
 * JD-Core Version:    0.7.0.1
 */