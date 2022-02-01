package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private boolean qUc = false;
  private View qUd;
  private ImageButton qUh;
  private ImageButton qUi;
  private ImageButton qUj;
  private View qUk;
  private View qUl;
  private View qUm;
  public a qUn;
  
  public final void dT(View paramView)
  {
    this.qUc = false;
    this.qUd = paramView;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(107518);
    if (!this.qUc)
    {
      AppMethodBeat.o(107518);
      return;
    }
    if (this.qUd.getVisibility() != 8)
    {
      this.qUd.setVisibility(8);
      this.qUd.startAnimation(AnimationUtils.loadAnimation(this.qUd.getContext(), 2130772048));
    }
    AppMethodBeat.o(107518);
  }
  
  public final void lm(boolean paramBoolean)
  {
    AppMethodBeat.i(107517);
    if (!this.qUc)
    {
      if (this.qUd == null)
      {
        AppMethodBeat.o(107517);
        return;
      }
      if ((this.qUd instanceof ViewStub)) {
        this.qUd = ((ViewStub)this.qUd).inflate();
      }
      this.qUk = this.qUd.findViewById(2131299826);
      this.qUl = this.qUd.findViewById(2131299827);
      this.qUm = this.qUd.findViewById(2131299828);
      this.qUh = ((ImageButton)this.qUd.findViewById(2131299787));
      this.qUh.setEnabled(false);
      this.qUh.setContentDescription(this.qUh.getContext().getString(2131764539));
      this.qUh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107514);
          if (b.this.qUn == null)
          {
            AppMethodBeat.o(107514);
            return;
          }
          b.this.qUn.cqD();
          AppMethodBeat.o(107514);
        }
      });
      this.qUi = ((ImageButton)this.qUd.findViewById(2131299784));
      this.qUi.setEnabled(false);
      this.qUi.setContentDescription(this.qUi.getContext().getString(2131758179));
      this.qUi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107515);
          if (b.this.qUn == null)
          {
            AppMethodBeat.o(107515);
            return;
          }
          b.this.qUn.cqE();
          AppMethodBeat.o(107515);
        }
      });
      if (paramBoolean)
      {
        this.qUl.setVisibility(8);
        this.qUi.setVisibility(8);
      }
      this.qUj = ((ImageButton)this.qUd.findViewById(2131299785));
      this.qUj.setEnabled(false);
      this.qUj.setContentDescription(this.qUj.getContext().getString(2131758030));
      this.qUj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107516);
          if (b.this.qUn == null)
          {
            AppMethodBeat.o(107516);
            return;
          }
          b.this.qUn.cqv();
          AppMethodBeat.o(107516);
        }
      });
      this.qUc = true;
    }
    if (this.qUd.getVisibility() != 0)
    {
      this.qUd.setVisibility(0);
      this.qUd.startAnimation(AnimationUtils.loadAnimation(this.qUd.getContext(), 2130772047));
    }
    AppMethodBeat.o(107517);
  }
  
  public final void ln(boolean paramBoolean)
  {
    AppMethodBeat.i(107519);
    if (!this.qUc)
    {
      AppMethodBeat.o(107519);
      return;
    }
    this.qUh.setEnabled(paramBoolean);
    this.qUi.setEnabled(paramBoolean);
    this.qUj.setEnabled(paramBoolean);
    AppMethodBeat.o(107519);
  }
  
  public static abstract interface a
  {
    public abstract void cqD();
    
    public abstract void cqE();
    
    public abstract void cqv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */