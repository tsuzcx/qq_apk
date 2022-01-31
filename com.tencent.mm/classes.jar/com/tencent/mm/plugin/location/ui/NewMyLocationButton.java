package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.p.d;

public class NewMyLocationButton
  extends FrameLayout
{
  private Context context;
  private a.a dig = new NewMyLocationButton.1(this);
  private ImageButton lES;
  private LinearLayout lET;
  private d lEU;
  private boolean lEV = true;
  
  public NewMyLocationButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  public NewMyLocationButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = View.inflate(this.context, a.f.new_my_location_btn, this);
    this.lES = ((ImageButton)localView.findViewById(a.e.new_locate_btn));
    this.lET = ((LinearLayout)localView.findViewById(a.e.new_progress_bar));
  }
  
  public void setAnimToSelf(boolean paramBoolean)
  {
    this.lEV = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.lES.setOnClickListener(paramOnClickListener);
  }
  
  public void setProgressBar(d paramd)
  {
    this.lEU = paramd;
    this.lET.setVisibility(0);
    this.lES.setVisibility(8);
    c.Ob().b(this.dig, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.NewMyLocationButton
 * JD-Core Version:    0.7.0.1
 */