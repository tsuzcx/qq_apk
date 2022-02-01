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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public class ExdeviceRankListHeaderView
  extends RelativeLayout
{
  private Context mContext;
  private Runnable mHideRunnable;
  private TextView pgi;
  private View.OnClickListener pgj;
  private Animation pgk;
  private Animation pgl;
  private boolean pgm;
  
  public ExdeviceRankListHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(24281);
    this.pgm = true;
    aL(paramContext);
    AppMethodBeat.o(24281);
  }
  
  public ExdeviceRankListHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceRankListHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24280);
    this.pgm = true;
    aL(paramContext);
    AppMethodBeat.o(24280);
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(24282);
    this.mContext = paramContext;
    this.pgi = ((TextView)LayoutInflater.from(this.mContext).inflate(2131493886, this, true).findViewById(2131297946));
    this.pgi.setVisibility(4);
    brn();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24274);
        if (ExdeviceRankListHeaderView.a(ExdeviceRankListHeaderView.this)) {
          ExdeviceRankListHeaderView.b(ExdeviceRankListHeaderView.this);
        }
        if (ExdeviceRankListHeaderView.c(ExdeviceRankListHeaderView.this) != null) {
          ExdeviceRankListHeaderView.c(ExdeviceRankListHeaderView.this).onClick(ExdeviceRankListHeaderView.this);
        }
        AppMethodBeat.o(24274);
      }
    });
    AppMethodBeat.o(24282);
  }
  
  private void brn()
  {
    AppMethodBeat.i(24283);
    this.pgk = AnimationUtils.loadAnimation(this.mContext, 2130771968);
    this.pgl = AnimationUtils.loadAnimation(this.mContext, 2130771969);
    this.mHideRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24275);
        ExdeviceRankListHeaderView.e(ExdeviceRankListHeaderView.this).startAnimation(ExdeviceRankListHeaderView.d(ExdeviceRankListHeaderView.this));
        AppMethodBeat.o(24275);
      }
    };
    this.pgk.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(24277);
        ExdeviceRankListHeaderView.d(ExdeviceRankListHeaderView.this).reset();
        aq.n(ExdeviceRankListHeaderView.f(ExdeviceRankListHeaderView.this), 4000L);
        AppMethodBeat.o(24277);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(24276);
        ExdeviceRankListHeaderView.e(ExdeviceRankListHeaderView.this).setVisibility(0);
        AppMethodBeat.o(24276);
      }
    });
    this.pgl.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(24279);
        ExdeviceRankListHeaderView.e(ExdeviceRankListHeaderView.this).setVisibility(4);
        AppMethodBeat.o(24279);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(24278);
        ExdeviceRankListHeaderView.e(ExdeviceRankListHeaderView.this).setVisibility(0);
        AppMethodBeat.o(24278);
      }
    });
    this.pgk.setFillAfter(true);
    this.pgk.setFillEnabled(true);
    this.pgl.setFillAfter(true);
    this.pgl.setFillAfter(true);
    AppMethodBeat.o(24283);
  }
  
  public String getMotto()
  {
    AppMethodBeat.i(24285);
    String str = bt.by(this.pgi.getText().toString(), "");
    AppMethodBeat.o(24285);
    return str;
  }
  
  public void setIsShowTip(boolean paramBoolean)
  {
    this.pgm = paramBoolean;
  }
  
  public void setMotto(String paramString)
  {
    AppMethodBeat.i(24284);
    this.pgi.setText(paramString);
    AppMethodBeat.o(24284);
  }
  
  public void setOnViewClickListener(View.OnClickListener paramOnClickListener)
  {
    this.pgj = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView
 * JD-Core Version:    0.7.0.1
 */