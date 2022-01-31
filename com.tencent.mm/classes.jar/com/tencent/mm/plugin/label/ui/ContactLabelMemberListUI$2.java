package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class ContactLabelMemberListUI$2
  implements m.b
{
  ContactLabelMemberListUI$2(ContactLabelMemberListUI paramContactLabelMemberListUI) {}
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    y.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramInt), paramObject });
    if (ContactLabelMemberListUI.b(this.lBO) != null)
    {
      ContactLabelMemberListUI.b(this.lBO).removeMessages(5001);
      ContactLabelMemberListUI.b(this.lBO).sendEmptyMessageDelayed(5001, 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.2
 * JD-Core Version:    0.7.0.1
 */