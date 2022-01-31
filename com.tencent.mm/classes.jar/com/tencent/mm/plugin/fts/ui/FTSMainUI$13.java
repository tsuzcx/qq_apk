package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.m;
import org.json.JSONObject;

final class FTSMainUI$13
  implements View.OnClickListener
{
  FTSMainUI$13(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(61882);
    try
    {
      if (paramView.getTag() != null)
      {
        i = ((JSONObject)paramView.getTag()).optInt("businessType");
        if (i != 0) {
          break label147;
        }
        paramView = ((TextView)paramView).getText().toString();
        if (!paramView.equals(this.mYi.getString(2131302999))) {
          break label104;
        }
        i = 2;
        if (i != 0)
        {
          paramView = this.mYi;
          ((m)g.E(m.class)).a(paramView, new FTSMainUI.11(paramView, i));
        }
        AppMethodBeat.o(61882);
      }
    }
    catch (Exception localException)
    {
      label147:
      for (;;)
      {
        int i = 0;
        continue;
        label104:
        if (paramView.equals(this.mYi.getString(2131303003))) {
          i = 8;
        } else if (paramView.equals(this.mYi.getString(2131303000))) {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.13
 * JD-Core Version:    0.7.0.1
 */