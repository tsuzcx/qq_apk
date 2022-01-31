package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.bk;

public class ExdeviceRankListHeaderView
  extends RelativeLayout
{
  private Runnable acP;
  private TextView jFY;
  private View.OnClickListener jFZ;
  private Animation jGa;
  private Animation jGb;
  private boolean jGc = true;
  private Context mContext;
  
  public ExdeviceRankListHeaderView(Context paramContext)
  {
    super(paramContext);
    ca(paramContext);
  }
  
  public ExdeviceRankListHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceRankListHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    ca(paramContext);
  }
  
  private void ca(Context paramContext)
  {
    this.mContext = paramContext;
    this.jFY = ((TextView)LayoutInflater.from(this.mContext).inflate(R.i.exdevice_rank_header_view, this, true).findViewById(R.h.champion_motto));
    this.jFY.setVisibility(4);
    this.jGa = AnimationUtils.loadAnimation(this.mContext, R.a.abc_fade_in);
    this.jGb = AnimationUtils.loadAnimation(this.mContext, R.a.abc_fade_out);
    this.acP = new ExdeviceRankListHeaderView.2(this);
    this.jGa.setAnimationListener(new ExdeviceRankListHeaderView.3(this));
    this.jGb.setAnimationListener(new ExdeviceRankListHeaderView.4(this));
    this.jGa.setFillAfter(true);
    this.jGa.setFillEnabled(true);
    this.jGb.setFillAfter(true);
    this.jGb.setFillAfter(true);
    setOnClickListener(new ExdeviceRankListHeaderView.1(this));
  }
  
  public String getMotto()
  {
    return bk.aM(this.jFY.getText().toString(), "");
  }
  
  public void setIsShowTip(boolean paramBoolean)
  {
    this.jGc = paramBoolean;
  }
  
  public void setMotto(String paramString)
  {
    this.jFY.setText(paramString);
  }
  
  public void setOnViewClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jFZ = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView
 * JD-Core Version:    0.7.0.1
 */