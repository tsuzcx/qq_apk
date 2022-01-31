package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;

public class AppBrandSmileyViewPager
  extends CustomViewPager
{
  private c jpK;
  private int jqh;
  private int jqi;
  private AppBrandSmileyViewPager.b jqj;
  
  public AppBrandSmileyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134339);
    this.jqh = 0;
    this.jqi = 0;
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
    AppMethodBeat.o(134339);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(134340);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jpK != null) && (((paramInt1 > 0) && (paramInt3 != paramInt1)) || ((paramInt2 > 0) && (paramInt4 != paramInt2) && (((paramInt2 > 0) && (paramInt2 != this.jqh)) || ((paramInt1 > 0) && (paramInt1 != this.jqi))))))
    {
      this.jpK.jqe = paramInt2;
      this.jpK.jqf = paramInt1;
      if (this.jqj != null) {
        this.jqj.aRJ();
      }
    }
    if (paramInt2 > 0) {
      this.jqh = paramInt2;
    }
    if (paramInt1 > 0) {
      this.jqi = paramInt1;
    }
    AppMethodBeat.o(134340);
  }
  
  public void setOnSizeChangedListener(AppBrandSmileyViewPager.b paramb)
  {
    this.jqj = paramb;
  }
  
  public void setPanelManager(c paramc)
  {
    this.jpK = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager
 * JD-Core Version:    0.7.0.1
 */