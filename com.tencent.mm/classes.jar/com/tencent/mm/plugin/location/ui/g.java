package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.p.d;

public final class g
  extends FrameLayout
{
  public boolean lFf = false;
  private ImageView lFx;
  public d lFy;
  private Context mContext;
  
  public g(Context paramContext, d paramd)
  {
    super(paramContext);
    this.lFy = paramd;
    this.mContext = paramContext;
    this.lFx = ((ImageView)View.inflate(this.mContext, a.f.poi_point, this).findViewById(a.e.point_iv));
  }
  
  public final void remove()
  {
    if (this.lFf) {
      this.lFy.removeView(this);
    }
    this.lFf = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.g
 * JD-Core Version:    0.7.0.1
 */