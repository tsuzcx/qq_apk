package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.ui.MMActivity;

public final class z
  extends i
{
  private View iyK;
  
  public final void aCU()
  {
    if (this.iyK != null) {
      this.iyK.setVisibility(8);
    }
  }
  
  public final void initView() {}
  
  public final void update()
  {
    if (this.iyK == null) {
      this.iyK = ((ViewStub)findViewById(a.d.card_third_field_layout_stub)).inflate();
    }
    ra localra = this.iya.aBE().azy().sHC;
    if (this.iyK != null)
    {
      ((TextView)this.iyK.findViewById(a.d.thid_field_title)).setText(localra.title);
      ((TextView)this.iyK.findViewById(a.d.thid_field_sub_title)).setText(localra.ilq);
      if ((this.iya.aBJ().aCn()) && (this.iya.aBJ().aCo())) {
        break label153;
      }
    }
    label153:
    for (int i = 1; i != 0; i = 0)
    {
      ((LinearLayout.LayoutParams)((LinearLayout)this.iyK).getLayoutParams()).bottomMargin = 0;
      return;
    }
    ((LinearLayout.LayoutParams)((LinearLayout)this.iyK).getLayoutParams()).bottomMargin = this.iya.aBH().getResources().getDimensionPixelSize(a.b.SettingCatalogPadding);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.z
 * JD-Core Version:    0.7.0.1
 */