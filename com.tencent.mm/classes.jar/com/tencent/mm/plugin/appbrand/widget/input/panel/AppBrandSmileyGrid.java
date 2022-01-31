package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandSmileyGrid
  extends GridView
{
  AdapterView.OnItemClickListener amh;
  private c jpK;
  AppBrandSmileyGrid.a jpO;
  int jpP;
  int jpQ;
  int jpR;
  int jpS;
  int jpT;
  int jpU;
  
  public AppBrandSmileyGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134311);
    this.jpQ = 0;
    this.jpS = 0;
    this.jpT = 0;
    this.jpU = 0;
    this.amh = new AppBrandSmileyGrid.1(this);
    AppMethodBeat.o(134311);
  }
  
  int getRowSpacing()
  {
    return this.jpS;
  }
  
  public void setPanelManager(c paramc)
  {
    this.jpK = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid
 * JD-Core Version:    0.7.0.1
 */