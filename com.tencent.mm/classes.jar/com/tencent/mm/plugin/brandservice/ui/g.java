package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class g
  extends a
{
  private static a.b icr;
  
  public g(Object paramObject)
  {
    super(0, paramObject);
    this.vdV = true;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs) {}
  
  public final a.b axw()
  {
    if (icr == null) {
      icr = new g.1(this);
    }
    return icr;
  }
  
  public final a.a axx()
  {
    return new g.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.g
 * JD-Core Version:    0.7.0.1
 */