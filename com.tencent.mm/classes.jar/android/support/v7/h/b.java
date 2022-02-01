package android.support.v7.h;

public final class b
  implements d
{
  final d acX;
  int acY = 0;
  int acZ = -1;
  int ada = -1;
  Object adb = null;
  
  public b(d paramd)
  {
    this.acX = paramd;
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.acY == 3) && (paramInt1 <= this.acZ + this.ada) && (paramInt1 + paramInt2 >= this.acZ) && (this.adb == paramObject))
    {
      int i = this.acZ;
      int j = this.ada;
      this.acZ = Math.min(paramInt1, this.acZ);
      this.ada = (Math.max(i + j, paramInt1 + paramInt2) - this.acZ);
      return;
    }
    hq();
    this.acZ = paramInt1;
    this.ada = paramInt2;
    this.adb = paramObject;
    this.acY = 3;
  }
  
  public final void f(int paramInt1, int paramInt2)
  {
    if ((this.acY == 1) && (paramInt1 >= this.acZ) && (paramInt1 <= this.acZ + this.ada))
    {
      this.ada += paramInt2;
      this.acZ = Math.min(paramInt1, this.acZ);
      return;
    }
    hq();
    this.acZ = paramInt1;
    this.ada = paramInt2;
    this.acY = 1;
  }
  
  public final void hq()
  {
    if (this.acY == 0) {
      return;
    }
    switch (this.acY)
    {
    }
    for (;;)
    {
      this.adb = null;
      this.acY = 0;
      return;
      this.acX.f(this.acZ, this.ada);
      continue;
      this.acX.k(this.acZ, this.ada);
      continue;
      this.acX.c(this.acZ, this.ada, this.adb);
    }
  }
  
  public final void k(int paramInt1, int paramInt2)
  {
    if ((this.acY == 2) && (this.acZ >= paramInt1) && (this.acZ <= paramInt1 + paramInt2))
    {
      this.ada += paramInt2;
      this.acZ = paramInt1;
      return;
    }
    hq();
    this.acZ = paramInt1;
    this.ada = paramInt2;
    this.acY = 2;
  }
  
  public final void l(int paramInt1, int paramInt2)
  {
    hq();
    this.acX.l(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.h.b
 * JD-Core Version:    0.7.0.1
 */