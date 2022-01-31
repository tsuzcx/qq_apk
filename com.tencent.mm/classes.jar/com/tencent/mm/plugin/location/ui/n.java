package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.p.d;

public final class n
  implements c
{
  public boolean bMo = false;
  public boolean isVisible = true;
  private String lCF;
  public double lCJ = 1000000.0D;
  public double lCK = 1000000.0D;
  private TextView lEG;
  private ProgressBar lEH;
  private String lEK = "";
  public boolean lFk = true;
  private View lFl;
  public String lFn;
  public final String lHO = "info_window_tag";
  public ImageView lHP;
  public FrameLayout lHQ;
  private TextView lHR;
  public boolean lHS;
  private Context mContext;
  public ViewManager mViewManager;
  
  public n(d paramd, Context paramContext)
  {
    this.mContext = paramContext;
    this.lHS = false;
    this.lHP = new ImageView(paramContext);
    this.lHP.setBackgroundResource(a.d.mm_trans);
    this.lHP.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.lHQ = ((FrameLayout)View.inflate(paramContext, a.f.map_overlay_layout, null));
    this.lHP.setImageResource(a.d.location_artboard1);
    this.lFl = this.lHQ;
    this.mViewManager = ((ViewManager)paramd.getViewManager());
  }
  
  public final String getPreText()
  {
    return this.lEK;
  }
  
  public final void setText(String paramString)
  {
    this.lCF = paramString;
    paramString = this.lCF;
    this.lEG = ((TextView)this.lHQ.findViewById(a.e.location_tips));
    this.lEH = ((ProgressBar)this.lHQ.findViewById(a.e.location_load_progress));
    this.lHR = ((TextView)this.lHQ.findViewById(a.e.location_poiname));
    if ((paramString == null) || (paramString.equals("")))
    {
      this.lEH.setVisibility(0);
      if ((this.lFn == null) || (this.lFn.equals(""))) {
        break label194;
      }
      this.lHR.setVisibility(0);
      this.lHR.setText(this.lFn);
    }
    for (;;)
    {
      if (this.lFk)
      {
        this.mViewManager.updateViewLayout(this.lHP, this.lCJ, this.lCK, false);
        if (this.lHS) {
          this.mViewManager.showInfoWindowByView(this.lHP);
        }
      }
      return;
      this.lEH.setVisibility(8);
      this.lEG.setVisibility(0);
      this.lEG.setText(paramString);
      break;
      label194:
      this.lHR.setText("");
      this.lHR.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.n
 * JD-Core Version:    0.7.0.1
 */