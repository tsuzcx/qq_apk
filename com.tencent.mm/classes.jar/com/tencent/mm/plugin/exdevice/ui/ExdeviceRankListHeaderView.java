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
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public class ExdeviceRankListHeaderView
  extends RelativeLayout
{
  private View.OnClickListener gst;
  private Context mContext;
  private Runnable mHideRunnable;
  private TextView pJt;
  private Animation pJu;
  private Animation pJv;
  private boolean pJw;
  
  public ExdeviceRankListHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(24281);
    this.pJw = true;
    aM(paramContext);
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
    this.pJw = true;
    aM(paramContext);
    AppMethodBeat.o(24280);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(24282);
    this.mContext = paramContext;
    this.pJt = ((TextView)LayoutInflater.from(this.mContext).inflate(2131493886, this, true).findViewById(2131297946));
    this.pJt.setVisibility(4);
    byn();
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
  
  private void byn()
  {
    AppMethodBeat.i(24283);
    this.pJu = AnimationUtils.loadAnimation(this.mContext, 2130771968);
    this.pJv = AnimationUtils.loadAnimation(this.mContext, 2130771969);
    this.mHideRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24275);
        ExdeviceRankListHeaderView.e(ExdeviceRankListHeaderView.this).startAnimation(ExdeviceRankListHeaderView.d(ExdeviceRankListHeaderView.this));
        AppMethodBeat.o(24275);
      }
    };
    this.pJu.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(24277);
        ExdeviceRankListHeaderView.d(ExdeviceRankListHeaderView.this).reset();
        ap.n(ExdeviceRankListHeaderView.f(ExdeviceRankListHeaderView.this), 4000L);
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
    this.pJv.setAnimationListener(new Animation.AnimationListener()
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
    this.pJu.setFillAfter(true);
    this.pJu.setFillEnabled(true);
    this.pJv.setFillAfter(true);
    this.pJv.setFillAfter(true);
    AppMethodBeat.o(24283);
  }
  
  public String getMotto()
  {
    AppMethodBeat.i(24285);
    String str = bs.bG(this.pJt.getText().toString(), "");
    AppMethodBeat.o(24285);
    return str;
  }
  
  public void setIsShowTip(boolean paramBoolean)
  {
    this.pJw = paramBoolean;
  }
  
  public void setMotto(String paramString)
  {
    AppMethodBeat.i(24284);
    this.pJt.setText(paramString);
    AppMethodBeat.o(24284);
  }
  
  public void setOnViewClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gst = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView
 * JD-Core Version:    0.7.0.1
 */