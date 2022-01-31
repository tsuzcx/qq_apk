package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public final class a
  extends c.a
{
  private boolean hcl = false;
  
  public a(Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof Activity)) {
      this.hcl = l.c(((Activity)paramContext).getWindow());
    }
  }
  
  public final c aoP()
  {
    c localc = super.aoP();
    l.a(localc.getWindow(), this.hcl);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a
 * JD-Core Version:    0.7.0.1
 */