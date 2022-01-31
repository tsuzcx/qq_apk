package com.tencent.mm.plugin.gallery.model;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    Object localObject = a.a(this.kGm);
    if (((b)localObject).kGt != null)
    {
      localObject = ((b)localObject).kGt;
      if (((d)localObject).dirty)
      {
        ((d)localObject).dirty = false;
        ((d)localObject).aXk();
        ((d)localObject).aXl();
        ((d)localObject).rJ(-1);
        ((d)localObject).aXn();
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|tryStartDocode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.a.1
 * JD-Core Version:    0.7.0.1
 */