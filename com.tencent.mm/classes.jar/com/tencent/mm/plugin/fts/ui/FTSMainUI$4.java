package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.i.3;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import org.json.JSONObject;

final class FTSMainUI$4
  implements View.OnClickListener
{
  FTSMainUI$4(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111964);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    int j = 0;
    try
    {
      if (paramView.getTag() != null)
      {
        i = ((JSONObject)paramView.getTag()).optInt("businessType");
        j = i;
        i = j;
        if (j == 0)
        {
          localObject = ((TextView)paramView).getText().toString();
          if (!((String)localObject).equals(this.xci.getString(2131765074))) {
            break label140;
          }
          i = 2;
        }
        while (i != 0) {
          if ((i == 2) && (!WeChatBrands.Business.Entries.HomeServiceMp.checkAvailable(paramView.getContext())))
          {
            a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111964);
            return;
            label140:
            if (((String)localObject).equals(this.xci.getString(2131765078)))
            {
              i = 8;
            }
            else
            {
              i = j;
              if (((String)localObject).equals(this.xci.getString(2131765075))) {
                i = 1;
              }
            }
          }
          else
          {
            if ((i == 1) && (!WeChatBrands.Business.Entries.HomeServiceMp.checkAvailable(paramView.getContext())))
            {
              a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111964);
              return;
            }
            if ((i == 512) && (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramView.getContext())))
            {
              a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111964);
              return;
            }
            if (((i == 64) || (i == 262208)) && (!WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailable(paramView.getContext())))
            {
              a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111964);
              return;
            }
            paramView = FTSMainUI.c(this.xci);
            ((com.tencent.mm.plugin.websearch.api.i)g.af(com.tencent.mm.plugin.websearch.api.i.class)).a(paramView.xfV, new i.3(paramView, i));
          }
        }
        a.a(this, "com/tencent/mm/plugin/fts/ui/FTSMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(111964);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.4
 * JD-Core Version:    0.7.0.1
 */