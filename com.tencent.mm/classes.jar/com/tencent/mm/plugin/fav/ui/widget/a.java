package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public Button iPj;
  public TextView orK;
  public long qUa;
  public boolean qUc;
  public View qUd;
  public a qUe;
  
  public a()
  {
    AppMethodBeat.i(107507);
    this.qUc = false;
    this.qUa = b.coY();
    AppMethodBeat.o(107507);
  }
  
  public final void crA()
  {
    AppMethodBeat.i(107510);
    this.orK.setText(this.orK.getContext().getString(2131758821, new Object[] { b.ty(this.qUa) }));
    this.iPj.setEnabled(false);
    AppMethodBeat.o(107510);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107509);
    if (!this.qUc)
    {
      AppMethodBeat.o(107509);
      return;
    }
    if (this.qUd.getVisibility() != 8)
    {
      this.qUd.setVisibility(8);
      this.qUd.startAnimation(AnimationUtils.loadAnimation(this.qUd.getContext(), 2130772048));
    }
    AppMethodBeat.o(107509);
  }
  
  public final void show()
  {
    AppMethodBeat.i(107508);
    if (!this.qUc)
    {
      if (this.qUd == null)
      {
        AppMethodBeat.o(107508);
        return;
      }
      if ((this.qUd instanceof ViewStub)) {
        this.qUd = ((ViewStub)this.qUd).inflate();
      }
      this.orK = ((TextView)this.qUd.findViewById(2131299773));
      if (!ab.eUK()) {
        this.orK.setTextSize(1, 14.0F);
      }
      this.iPj = ((Button)this.qUd.findViewById(2131299772));
      crA();
      this.iPj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107506);
          if (a.this.qUe == null)
          {
            AppMethodBeat.o(107506);
            return;
          }
          a.this.qUe.cqv();
          AppMethodBeat.o(107506);
        }
      });
      this.qUc = true;
    }
    if (this.qUd.getVisibility() != 0)
    {
      this.qUd.setVisibility(0);
      this.qUd.startAnimation(AnimationUtils.loadAnimation(this.qUd.getContext(), 2130772047));
    }
    AppMethodBeat.o(107508);
  }
  
  public static abstract interface a
  {
    public abstract void cqv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */