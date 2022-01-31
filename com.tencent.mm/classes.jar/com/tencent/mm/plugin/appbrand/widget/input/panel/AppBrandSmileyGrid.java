package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class AppBrandSmileyGrid
  extends GridView
{
  AdapterView.OnItemClickListener ajR = new AppBrandSmileyGrid.1(this);
  private c hxA;
  AppBrandSmileyGrid.a hxE;
  int hxF;
  int hxG = 0;
  int hxH;
  int hxI = 0;
  int hxJ = 0;
  int hxK = 0;
  
  public AppBrandSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  int getRowSpacing()
  {
    return this.hxI;
  }
  
  public void setPanelManager(c paramc)
  {
    this.hxA = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid
 * JD-Core Version:    0.7.0.1
 */