package com.tencent.mm.plugin.account.bind.ui;

import android.widget.EditText;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bk;

final class BindMContactUI$2
  implements ai.a
{
  String dqb;
  
  BindMContactUI$2(BindMContactUI paramBindMContactUI) {}
  
  public final boolean JS()
  {
    this.dqb = ((a)g.t(a.class)).getPhoneNum(this.fcb, BindMContactUI.c(this.fcb));
    return true;
  }
  
  public final boolean JT()
  {
    if (bk.bl(BindMContactUI.b(this.fcb).getText().trim()))
    {
      if (bk.bl(this.dqb)) {
        break label75;
      }
      BindMContactUI.b(this.fcb).setText(this.dqb);
      BindMContactUI.b(this.fcb).setSelection(this.dqb.length());
    }
    for (;;)
    {
      return true;
      label75:
      BindMContactUI.b(this.fcb).setText("");
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|initView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI.2
 * JD-Core Version:    0.7.0.1
 */