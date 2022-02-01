package com.tencent.matrix.e;

import android.content.Context;

public class a
  implements c
{
  private final Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void a(com.tencent.matrix.report.c paramc)
  {
    Object localObject = paramc;
    if (paramc == null) {
      localObject = "";
    }
    com.tencent.matrix.g.c.i("Matrix.DefaultPluginListener", "report issue content: %s", new Object[] { localObject });
  }
  
  public final void b(b paramb)
  {
    com.tencent.matrix.g.c.i("Matrix.DefaultPluginListener", "%s plugin is inited", new Object[] { paramb.getTag() });
  }
  
  public final void c(b paramb)
  {
    com.tencent.matrix.g.c.i("Matrix.DefaultPluginListener", "%s plugin is started", new Object[] { paramb.getTag() });
  }
  
  public final void d(b paramb)
  {
    com.tencent.matrix.g.c.i("Matrix.DefaultPluginListener", "%s plugin is stopped", new Object[] { paramb.getTag() });
  }
  
  public final void e(b paramb)
  {
    com.tencent.matrix.g.c.i("Matrix.DefaultPluginListener", "%s plugin is destroyed", new Object[] { paramb.getTag() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.e.a
 * JD-Core Version:    0.7.0.1
 */