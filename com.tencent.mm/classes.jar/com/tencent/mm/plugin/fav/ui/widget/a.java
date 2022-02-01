package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.q.a;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

public final class a
{
  public long Apm;
  public boolean Apo;
  public View App;
  public a Apq;
  public Button pYm;
  public TextView wSG;
  
  public a()
  {
    AppMethodBeat.i(107507);
    this.Apo = false;
    this.Apm = com.tencent.mm.plugin.fav.a.b.dPY();
    AppMethodBeat.o(107507);
  }
  
  public final void dSO()
  {
    AppMethodBeat.i(107510);
    this.wSG.setText(this.wSG.getContext().getString(q.i.fav_clean_capacity_info, new Object[] { com.tencent.mm.plugin.fav.a.b.mB(this.Apm) }));
    this.pYm.setEnabled(false);
    AppMethodBeat.o(107510);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107509);
    if (!this.Apo)
    {
      AppMethodBeat.o(107509);
      return;
    }
    if (this.App.getVisibility() != 8)
    {
      this.App.setVisibility(8);
      this.App.startAnimation(AnimationUtils.loadAnimation(this.App.getContext(), q.a.fast_faded_out));
    }
    AppMethodBeat.o(107509);
  }
  
  public final void show()
  {
    AppMethodBeat.i(107508);
    if (!this.Apo)
    {
      if (this.App == null)
      {
        AppMethodBeat.o(107508);
        return;
      }
      if ((this.App instanceof ViewStub)) {
        this.App = ((ViewStub)this.App).inflate();
      }
      this.wSG = ((TextView)this.App.findViewById(q.e.fav_clean_delete_info_tv));
      if (!LocaleUtil.isChineseAppLang()) {
        this.wSG.setTextSize(1, 14.0F);
      }
      this.pYm = ((Button)this.App.findViewById(q.e.fav_clean_del_btn));
      dSO();
      this.pYm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107506);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (a.this.Apq == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107506);
            return;
          }
          a.this.Apq.dRB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107506);
        }
      });
      this.Apo = true;
    }
    if (this.App.getVisibility() != 0)
    {
      this.App.setVisibility(0);
      this.App.startAnimation(AnimationUtils.loadAnimation(this.App.getContext(), q.a.fast_faded_in));
    }
    AppMethodBeat.o(107508);
  }
  
  public static abstract interface a
  {
    public abstract void dRB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */