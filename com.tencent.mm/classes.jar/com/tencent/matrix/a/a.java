package com.tencent.matrix.a;

import android.os.Handler;
import com.tencent.matrix.a.a.a.g;
import com.tencent.matrix.a.a.a.g.1;
import com.tencent.matrix.a.a.a.g.b;
import com.tencent.matrix.a.a.a.j;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.a.d.b;
import com.tencent.matrix.b;

public final class a
{
  public static <T extends j> T Z(Class<T> paramClass)
  {
    if (b.Vt())
    {
      c localc = (c)b.Vu().Y(c.class);
      if (localc != null) {
        return localc.cSM.Z(paramClass);
      }
    }
    return null;
  }
  
  public static void a(d.b<g.b> paramb)
  {
    if (b.Vt())
    {
      Object localObject = (c)b.Vu().Y(c.class);
      if (localObject != null)
      {
        localObject = (g)((c)localObject).cSM.Z(g.class);
        if (localObject != null) {
          ((g)localObject).cSI.mHandler.post(new g.1((g)localObject, paramb));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a
 * JD-Core Version:    0.7.0.1
 */