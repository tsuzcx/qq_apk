package com.tencent.mm.plugin.boots;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.a;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.boots.a.f;
import java.util.List;

public final class b
  implements c
{
  public final List<a> awD()
  {
    if (((e)g.t(e.class)).getTinkerLogic() != null) {
      return ((e)g.t(e.class)).getTinkerLogic().awD();
    }
    return null;
  }
  
  public final void cr(int paramInt1, int paramInt2)
  {
    if (((e)g.t(e.class)).getTinkerLogic() != null) {
      ((e)g.t(e.class)).getTinkerLogic().c(paramInt1, true, paramInt2);
    }
  }
  
  public final void oc(int paramInt)
  {
    if (((e)g.t(e.class)).getTinkerLogic() != null) {
      ((e)g.t(e.class)).getTinkerLogic().c(paramInt, false, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.b
 * JD-Core Version:    0.7.0.1
 */