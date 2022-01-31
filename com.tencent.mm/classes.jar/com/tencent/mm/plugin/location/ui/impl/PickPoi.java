package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.map.a.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.h;

public class PickPoi
  extends RelativeLayout
{
  private Context context;
  View lEI;
  protected b lIe;
  public b.a lIl = new PickPoi.1(this);
  private double lJs;
  private double lJt;
  private f lJu = new f();
  boolean lJv = true;
  private e lJw = null;
  Animation wb;
  
  public PickPoi(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    init();
  }
  
  public PickPoi(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  public PickPoi(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    init();
  }
  
  private void init()
  {
    this.lIe = b.NZ();
    this.wb = AnimationUtils.loadAnimation(this.context, a.a.translate_map);
    this.lEI = LayoutInflater.from(this.context).inflate(a.f.location_poi_pick, this, true).findViewById(a.e.location_here);
  }
  
  public f getPoi()
  {
    return this.lJu;
  }
  
  public final void j(double paramDouble1, double paramDouble2)
  {
    this.lJs = paramDouble1;
    this.lJt = paramDouble2;
    this.lJu = new f();
    this.lJu.type = 3;
    this.lJu.mName = this.context.getResources().getString(a.h.location_selected);
    this.lJu.aWE = paramDouble1;
    this.lJu.aWF = paramDouble2;
    this.lJu.lJE = "";
    this.lIe.a(this.lIl);
    this.lIe.a(paramDouble1, paramDouble2, this.lIl);
    this.lJv = true;
  }
  
  public void setAdapter(e parame)
  {
    this.lJw = parame;
  }
  
  public void setLocationArrow(int paramInt)
  {
    ((ImageView)this.lEI).setImageResource(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.PickPoi
 * JD-Core Version:    0.7.0.1
 */