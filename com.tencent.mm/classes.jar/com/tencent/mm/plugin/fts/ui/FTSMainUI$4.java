package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.d;
import com.tencent.mm.plugin.fts.ui.widget.d.3;
import com.tencent.mm.plugin.websearch.api.i;
import org.json.JSONObject;

final class FTSMainUI$4
  implements View.OnClickListener
{
  FTSMainUI$4(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111964);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    try
    {
      if (paramView.getTag() != null)
      {
        i = ((JSONObject)paramView.getTag()).optInt("businessType");
        if (i != 0) {
          break label194;
        }
        paramView = ((TextView)paramView).getText().toString();
        if (!paramView.equals(this.tLh.getString(2131762938))) {
          break label151;
        }
        i = 2;
        if (i != 0)
        {
          paramView = FTSMainUI.b(this.tLh);
          ((i)g.ab(i.class)).a(paramView.tOM, new d.3(paramView, i));
        }
        a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(111964);
      }
    }
    catch (Exception localException)
    {
      label151:
      label194:
      for (;;)
      {
        int i = 0;
        continue;
        if (paramView.equals(this.tLh.getString(2131762942))) {
          i = 8;
        } else if (paramView.equals(this.tLh.getString(2131762939))) {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.4
 * JD-Core Version:    0.7.0.1
 */