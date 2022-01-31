package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class ExdeviceRankListHeaderView
  extends RelativeLayout
{
  private boolean lPA;
  private TextView lPw;
  private View.OnClickListener lPx;
  private Animation lPy;
  private Animation lPz;
  private Context mContext;
  private Runnable mHideRunnable;
  
  public ExdeviceRankListHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(20209);
    this.lPA = true;
    aA(paramContext);
    AppMethodBeat.o(20209);
  }
  
  public ExdeviceRankListHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceRankListHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(20208);
    this.lPA = true;
    aA(paramContext);
    AppMethodBeat.o(20208);
  }
  
  private void aA(Context paramContext)
  {
    AppMethodBeat.i(20210);
    this.mContext = paramContext;
    this.lPw = ((TextView)LayoutInflater.from(this.mContext).inflate(2130969474, this, true).findViewById(2131823825));
    this.lPw.setVisibility(4);
    aOQ();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20202);
        if (ExdeviceRankListHeaderView.a(ExdeviceRankListHeaderView.this)) {
          ExdeviceRankListHeaderView.b(ExdeviceRankListHeaderView.this);
        }
        if (ExdeviceRankListHeaderView.c(ExdeviceRankListHeaderView.this) != null) {
          ExdeviceRankListHeaderView.c(ExdeviceRankListHeaderView.this).onClick(ExdeviceRankListHeaderView.this);
        }
        AppMethodBeat.o(20202);
      }
    });
    AppMethodBeat.o(20210);
  }
  
  private void aOQ()
  {
    AppMethodBeat.i(20211);
    this.lPy = AnimationUtils.loadAnimation(this.mContext, 2131034112);
    this.lPz = AnimationUtils.loadAnimation(this.mContext, 2131034113);
    this.mHideRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20203);
        ExdeviceRankListHeaderView.e(ExdeviceRankListHeaderView.this).startAnimation(ExdeviceRankListHeaderView.d(ExdeviceRankListHeaderView.this));
        AppMethodBeat.o(20203);
      }
    };
    this.lPy.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(20205);
        ExdeviceRankListHeaderView.d(ExdeviceRankListHeaderView.this).reset();
        al.p(ExdeviceRankListHeaderView.f(ExdeviceRankListHeaderView.this), 4000L);
        AppMethodBeat.o(20205);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(20204);
        ExdeviceRankListHeaderView.e(ExdeviceRankListHeaderView.this).setVisibility(0);
        AppMethodBeat.o(20204);
      }
    });
    this.lPz.setAnimationListener(new ExdeviceRankListHeaderView.4(this));
    this.lPy.setFillAfter(true);
    this.lPy.setFillEnabled(true);
    this.lPz.setFillAfter(true);
    this.lPz.setFillAfter(true);
    AppMethodBeat.o(20211);
  }
  
  public String getMotto()
  {
    AppMethodBeat.i(20213);
    String str = bo.bf(this.lPw.getText().toString(), "");
    AppMethodBeat.o(20213);
    return str;
  }
  
  public void setIsShowTip(boolean paramBoolean)
  {
    this.lPA = paramBoolean;
  }
  
  public void setMotto(String paramString)
  {
    AppMethodBeat.i(20212);
    this.lPw.setText(paramString);
    AppMethodBeat.o(20212);
  }
  
  public void setOnViewClickListener(View.OnClickListener paramOnClickListener)
  {
    this.lPx = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView
 * JD-Core Version:    0.7.0.1
 */