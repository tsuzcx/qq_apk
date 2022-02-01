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
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class ExdeviceRankListHeaderView
  extends RelativeLayout
{
  private Context mContext;
  private Runnable mHideRunnable;
  private View.OnClickListener mWW;
  private TextView yCL;
  private Animation yCM;
  private Animation yCN;
  private boolean yCO;
  
  public ExdeviceRankListHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(24281);
    this.yCO = true;
    ci(paramContext);
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
    this.yCO = true;
    ci(paramContext);
    AppMethodBeat.o(24280);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(24282);
    this.mContext = paramContext;
    this.yCL = ((TextView)LayoutInflater.from(this.mContext).inflate(R.i.gjI, this, true).findViewById(R.h.fvD));
    this.yCL.setVisibility(4);
    dHj();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24274);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankListHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ExdeviceRankListHeaderView.a(ExdeviceRankListHeaderView.this)) {
          ExdeviceRankListHeaderView.b(ExdeviceRankListHeaderView.this);
        }
        if (ExdeviceRankListHeaderView.c(ExdeviceRankListHeaderView.this) != null) {
          ExdeviceRankListHeaderView.c(ExdeviceRankListHeaderView.this).onClick(ExdeviceRankListHeaderView.this);
        }
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankListHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24274);
      }
    });
    AppMethodBeat.o(24282);
  }
  
  private void dHj()
  {
    AppMethodBeat.i(24283);
    this.yCM = AnimationUtils.loadAnimation(this.mContext, R.a.abc_fade_in);
    this.yCN = AnimationUtils.loadAnimation(this.mContext, R.a.abc_fade_out);
    this.mHideRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24275);
        ExdeviceRankListHeaderView.e(ExdeviceRankListHeaderView.this).startAnimation(ExdeviceRankListHeaderView.d(ExdeviceRankListHeaderView.this));
        AppMethodBeat.o(24275);
      }
    };
    this.yCM.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(24277);
        ExdeviceRankListHeaderView.d(ExdeviceRankListHeaderView.this).reset();
        MMHandlerThread.postToMainThreadDelayed(ExdeviceRankListHeaderView.f(ExdeviceRankListHeaderView.this), 4000L);
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
    this.yCN.setAnimationListener(new Animation.AnimationListener()
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
    this.yCM.setFillAfter(true);
    this.yCM.setFillEnabled(true);
    this.yCN.setFillAfter(true);
    this.yCN.setFillAfter(true);
    AppMethodBeat.o(24283);
  }
  
  public String getMotto()
  {
    AppMethodBeat.i(24285);
    String str = Util.nullAs(this.yCL.getText().toString(), "");
    AppMethodBeat.o(24285);
    return str;
  }
  
  public void setIsShowTip(boolean paramBoolean)
  {
    this.yCO = paramBoolean;
  }
  
  public void setMotto(String paramString)
  {
    AppMethodBeat.i(24284);
    this.yCL.setText(paramString);
    AppMethodBeat.o(24284);
  }
  
  public void setOnViewClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mWW = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView
 * JD-Core Version:    0.7.0.1
 */