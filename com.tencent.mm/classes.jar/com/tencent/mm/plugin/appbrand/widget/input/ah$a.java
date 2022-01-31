package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.t;
import android.view.View;
import android.view.ViewParent;

abstract class ah$a<Source extends View, Target extends View>
{
  private Target Ij;
  
  abstract boolean cS(View paramView);
  
  abstract Target cT(View paramView);
  
  final Target cU(Source paramSource)
  {
    if ((this.Ij != null) && (t.aw(this.Ij))) {
      return this.Ij;
    }
    if ((paramSource == null) || (!t.aw(paramSource))) {
      return null;
    }
    for (paramSource = paramSource.getParent(); (paramSource instanceof View); paramSource = paramSource.getParent()) {
      if (cS((View)paramSource)) {
        break label70;
      }
    }
    return null;
    label70:
    paramSource = cT((View)paramSource);
    this.Ij = paramSource;
    return paramSource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ah.a
 * JD-Core Version:    0.7.0.1
 */