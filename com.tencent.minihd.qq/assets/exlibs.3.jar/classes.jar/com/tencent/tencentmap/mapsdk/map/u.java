package com.tencent.tencentmap.mapsdk.map;

import java.util.ArrayList;

class u
  extends c<ArrayList<v.a>, Boolean>
{
  public q.b d = q.b.a;
  private w e = null;
  private byte[] f = new byte[1024];
  
  public u(ArrayList<v.a> paramArrayList)
  {
    super(paramArrayList);
  }
  
  private boolean a(byte[] paramArrayOfByte, v.a parama)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    if (paramArrayOfByte.length <= 0) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parama.a);
    localStringBuilder.append("-");
    localStringBuilder.append(parama.b);
    localStringBuilder.append("-");
    localStringBuilder.append(parama.c);
    if (!this.e.u.a(paramArrayOfByte, localStringBuilder.toString())) {
      return false;
    }
    if (this.e != null) {
      this.e.a(parama);
    }
    if ((this.e.m == true) && (this.e != null) && (this.e.v != null)) {
      this.e.v.a(paramArrayOfByte, parama.a, parama.b, parama.c);
    }
    return true;
  }
  
  private boolean c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    if ((this.d == q.b.b) || (this.d == q.b.d)) {
      return a(paramArrayOfByte, (v.a)((ArrayList)this.a).get(0));
    }
    if (paramArrayOfByte.length <= 0) {
      return false;
    }
    System.arraycopy(paramArrayOfByte, 0, this.f, 0, 4);
    int k = (this.f[0] + 256) % 256 | (this.f[1] + 256) % 256 << 8 | (this.f[2] + 256) % 256 << 16 | (this.f[3] + 256) % 256 << 24;
    if (k != ((ArrayList)this.a).size()) {
      return false;
    }
    int[] arrayOfInt = new int[k];
    System.arraycopy(paramArrayOfByte, 4, this.f, 4, k * 4);
    int i = 0;
    while (i < k)
    {
      j = i * 4 + 4;
      arrayOfInt[i] = ((this.f[j] + 256) % 256 | (this.f[(j + 1)] + 256) % 256 << 8 | (this.f[(j + 2)] + 256) % 256 << 16 | (this.f[(j + 3)] + 256) % 256 << 24);
      i += 1;
    }
    int j = (k + 1) * 4;
    i = 0;
    while (i < k)
    {
      byte[] arrayOfByte = a(paramArrayOfByte, arrayOfInt[i], j);
      j += arrayOfInt[i];
      if (!a(arrayOfByte, (v.a)((ArrayList)this.a).get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  protected String a()
  {
    int j = ((ArrayList)this.a).size();
    if (j <= 0) {
      return null;
    }
    int[] arrayOfInt = new int[((ArrayList)this.a).size() * 3];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[(i * 3)] = ((v.a)((ArrayList)this.a).get(i)).a;
      arrayOfInt[(i * 3 + 1)] = ((v.a)((ArrayList)this.a).get(i)).b;
      arrayOfInt[(i * 3 + 2)] = ((v.a)((ArrayList)this.a).get(i)).c;
      i += 1;
    }
    return this.e.t.a(this.e.f(), arrayOfInt);
  }
  
  public void a(w paramw)
  {
    this.e = paramw;
  }
  
  byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {}
    while (paramInt1 <= 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramInt1];
    System.arraycopy(paramArrayOfByte, paramInt2, arrayOfByte, 0, paramInt1);
    return arrayOfByte;
  }
  
  protected Boolean b(byte[] paramArrayOfByte)
  {
    if (this.a == null) {}
    while (paramArrayOfByte == null) {
      return null;
    }
    boolean bool = c(paramArrayOfByte);
    if (paramArrayOfByte != null) {}
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.u
 * JD-Core Version:    0.7.0.1
 */