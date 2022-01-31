package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.m;
import org.json.JSONObject;

final class FTSMainUI$14
  implements View.OnClickListener
{
  FTSMainUI$14(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      if (paramView.getTag() != null)
      {
        i = ((JSONObject)paramView.getTag()).optInt("businessType");
        if (i != 0) {
          break label140;
        }
        paramView = ((TextView)paramView).getText().toString();
        if (!paramView.equals(this.kCm.getString(n.g.search_education_article))) {
          break label95;
        }
        i = 2;
        if (i != 0)
        {
          paramView = this.kCm;
          ((m)g.r(m.class)).a(paramView, new FTSMainUI.13(paramView, i));
        }
      }
    }
    catch (Exception localException)
    {
      label140:
      for (;;)
      {
        int i = 0;
        continue;
        label95:
        if (paramView.equals(this.kCm.getString(n.g.search_education_timeline))) {
          i = 8;
        } else if (paramView.equals(this.kCm.getString(n.g.search_education_biz_contact))) {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.14
 * JD-Core Version:    0.7.0.1
 */