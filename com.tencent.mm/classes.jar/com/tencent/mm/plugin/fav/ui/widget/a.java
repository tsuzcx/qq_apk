package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.s.a;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

public final class a
{
  public Button nbe;
  public TextView tPq;
  public long wSJ;
  public boolean wSL;
  public View wSM;
  public a wSN;
  
  public a()
  {
    AppMethodBeat.i(107507);
    this.wSL = false;
    this.wSJ = com.tencent.mm.plugin.fav.a.b.djn();
    AppMethodBeat.o(107507);
  }
  
  public final void dlY()
  {
    AppMethodBeat.i(107510);
    this.tPq.setText(this.tPq.getContext().getString(s.i.fav_clean_capacity_info, new Object[] { com.tencent.mm.plugin.fav.a.b.Kd(this.wSJ) }));
    this.nbe.setEnabled(false);
    AppMethodBeat.o(107510);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107509);
    if (!this.wSL)
    {
      AppMethodBeat.o(107509);
      return;
    }
    if (this.wSM.getVisibility() != 8)
    {
      this.wSM.setVisibility(8);
      this.wSM.startAnimation(AnimationUtils.loadAnimation(this.wSM.getContext(), s.a.fast_faded_out));
    }
    AppMethodBeat.o(107509);
  }
  
  public final void show()
  {
    AppMethodBeat.i(107508);
    if (!this.wSL)
    {
      if (this.wSM == null)
      {
        AppMethodBeat.o(107508);
        return;
      }
      if ((this.wSM instanceof ViewStub)) {
        this.wSM = ((ViewStub)this.wSM).inflate();
      }
      this.tPq = ((TextView)this.wSM.findViewById(s.e.fav_clean_delete_info_tv));
      if (!LocaleUtil.isChineseAppLang()) {
        this.tPq.setTextSize(1, 14.0F);
      }
      this.nbe = ((Button)this.wSM.findViewById(s.e.fav_clean_del_btn));
      dlY();
      this.nbe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107506);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (a.this.wSN == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107506);
            return;
          }
          a.this.wSN.dkL();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107506);
        }
      });
      this.wSL = true;
    }
    if (this.wSM.getVisibility() != 0)
    {
      this.wSM.setVisibility(0);
      this.wSM.startAnimation(AnimationUtils.loadAnimation(this.wSM.getContext(), s.a.fast_faded_in));
    }
    AppMethodBeat.o(107508);
  }
  
  public static abstract interface a
  {
    public abstract void dkL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */