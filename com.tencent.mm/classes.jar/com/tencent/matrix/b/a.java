package com.tencent.matrix.b;

import android.content.Context;

public class a
  implements c
{
  private final Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void b(b paramb)
  {
    com.tencent.matrix.d.b.i("Matrix.DefaultPluginListener", "%s plugin is inited", new Object[] { paramb.getTag() });
  }
  
  public void b(com.tencent.matrix.c.b paramb)
  {
    com.tencent.matrix.d.b.e("Matrix.DefaultPluginListener", "report issue content: %s", new Object[] { paramb });
  }
  
  public final void c(b paramb)
  {
    com.tencent.matrix.d.b.i("Matrix.DefaultPluginListener", "%s plugin is started", new Object[] { paramb.getTag() });
  }
  
  public final void d(b paramb)
  {
    com.tencent.matrix.d.b.i("Matrix.DefaultPluginListener", "%s plugin is stopped", new Object[] { paramb.getTag() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.b.a
 * JD-Core Version:    0.7.0.1
 */