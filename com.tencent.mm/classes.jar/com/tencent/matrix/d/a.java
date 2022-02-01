package com.tencent.matrix.d;

import android.content.Context;
import com.tencent.matrix.report.g;

public class a
  implements c
{
  private final Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void a(g paramg)
  {
    Object localObject = paramg;
    if (paramg == null) {
      localObject = "";
    }
    com.tencent.matrix.e.c.i("Matrix.DefaultPluginListener", "report issue content: %s", new Object[] { localObject });
  }
  
  public final void b(b paramb)
  {
    com.tencent.matrix.e.c.i("Matrix.DefaultPluginListener", "%s plugin is inited", new Object[] { paramb.getTag() });
  }
  
  public final void c(b paramb)
  {
    com.tencent.matrix.e.c.i("Matrix.DefaultPluginListener", "%s plugin is started", new Object[] { paramb.getTag() });
  }
  
  public final void d(b paramb)
  {
    com.tencent.matrix.e.c.i("Matrix.DefaultPluginListener", "%s plugin is stopped", new Object[] { paramb.getTag() });
  }
  
  public final void e(b paramb)
  {
    com.tencent.matrix.e.c.i("Matrix.DefaultPluginListener", "%s plugin is destroyed", new Object[] { paramb.getTag() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.d.a
 * JD-Core Version:    0.7.0.1
 */