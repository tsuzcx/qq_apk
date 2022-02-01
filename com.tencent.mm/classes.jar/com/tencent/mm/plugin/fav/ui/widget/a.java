package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

public final class a
{
  public Button kjo;
  public TextView qqI;
  public long tml;
  public boolean tmn;
  public View tmo;
  public a tmp;
  
  public a()
  {
    AppMethodBeat.i(107507);
    this.tmn = false;
    this.tml = com.tencent.mm.plugin.fav.a.b.cUh();
    AppMethodBeat.o(107507);
  }
  
  public final void cWQ()
  {
    AppMethodBeat.i(107510);
    this.qqI.setText(this.qqI.getContext().getString(2131759144, new Object[] { com.tencent.mm.plugin.fav.a.b.DP(this.tml) }));
    this.kjo.setEnabled(false);
    AppMethodBeat.o(107510);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107509);
    if (!this.tmn)
    {
      AppMethodBeat.o(107509);
      return;
    }
    if (this.tmo.getVisibility() != 8)
    {
      this.tmo.setVisibility(8);
      this.tmo.startAnimation(AnimationUtils.loadAnimation(this.tmo.getContext(), 2130772060));
    }
    AppMethodBeat.o(107509);
  }
  
  public final void show()
  {
    AppMethodBeat.i(107508);
    if (!this.tmn)
    {
      if (this.tmo == null)
      {
        AppMethodBeat.o(107508);
        return;
      }
      if ((this.tmo instanceof ViewStub)) {
        this.tmo = ((ViewStub)this.tmo).inflate();
      }
      this.qqI = ((TextView)this.tmo.findViewById(2131300444));
      if (!LocaleUtil.isChineseAppLang()) {
        this.qqI.setTextSize(1, 14.0F);
      }
      this.kjo = ((Button)this.tmo.findViewById(2131300443));
      cWQ();
      this.kjo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107506);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (a.this.tmp == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107506);
            return;
          }
          a.this.tmp.cVF();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCleanFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107506);
        }
      });
      this.tmn = true;
    }
    if (this.tmo.getVisibility() != 0)
    {
      this.tmo.setVisibility(0);
      this.tmo.startAnimation(AnimationUtils.loadAnimation(this.tmo.getContext(), 2130772059));
    }
    AppMethodBeat.o(107508);
  }
  
  public static abstract interface a
  {
    public abstract void cVF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */