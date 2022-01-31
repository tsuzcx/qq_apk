package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewParent;

abstract class ag$a<Source extends View, Target extends View>
{
  private Target Iy;
  
  abstract boolean cp(View paramView);
  
  abstract Target cq(View paramView);
  
  final Target cr(Source paramSource)
  {
    if ((this.Iy != null) && (q.ao(this.Iy))) {
      return this.Iy;
    }
    if ((paramSource == null) || (!q.ao(paramSource))) {
      return null;
    }
    for (paramSource = paramSource.getParent(); (paramSource instanceof View); paramSource = paramSource.getParent()) {
      if (cp((View)paramSource)) {
        break label70;
      }
    }
    return null;
    label70:
    paramSource = cq((View)paramSource);
    this.Iy = paramSource;
    return paramSource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ag.a
 * JD-Core Version:    0.7.0.1
 */