package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

final class j$6
  implements Runnable
{
  j$6(j paramj, j.a parama, a parama1) {}
  
  public final void run()
  {
    int i = j.a(this.iFU, this.iFX);
    if (this.iFY != null)
    {
      if (i == 0) {
        this.iFY.a(0, 0, "", "");
      }
    }
    else {
      return;
    }
    this.iFY.a(-10086, -17, "exit failed", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.6
 * JD-Core Version:    0.7.0.1
 */