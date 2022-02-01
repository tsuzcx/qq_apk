package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.d;
import com.tencent.mm.plugin.fts.ui.widget.d.3;
import com.tencent.mm.plugin.websearch.api.h;
import org.json.JSONObject;

final class FTSMainUI$4
  implements View.OnClickListener
{
  FTSMainUI$4(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111964);
    try
    {
      if (paramView.getTag() != null)
      {
        i = ((JSONObject)paramView.getTag()).optInt("businessType");
        if (i != 0) {
          break label153;
        }
        paramView = ((TextView)paramView).getText().toString();
        if (!paramView.equals(this.sDB.getString(2131762938))) {
          break label110;
        }
        i = 2;
        if (i != 0)
        {
          paramView = FTSMainUI.b(this.sDB);
          ((h)g.ab(h.class)).a(paramView.sHc, new d.3(paramView, i));
        }
        AppMethodBeat.o(111964);
      }
    }
    catch (Exception localException)
    {
      label153:
      for (;;)
      {
        int i = 0;
        continue;
        label110:
        if (paramView.equals(this.sDB.getString(2131762942))) {
          i = 8;
        } else if (paramView.equals(this.sDB.getString(2131762939))) {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.4
 * JD-Core Version:    0.7.0.1
 */