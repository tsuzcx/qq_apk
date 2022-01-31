package com.eclipsesource.a;

import java.io.Writer;

final class k$a
  extends i
{
  private final char[] arZ;
  private int asa;
  
  private k$a(Writer paramWriter, char[] paramArrayOfChar)
  {
    super(paramWriter);
    this.arZ = paramArrayOfChar;
  }
  
  private boolean kj()
  {
    int i = 0;
    if (this.arZ == null) {
      return false;
    }
    this.arY.write(10);
    while (i < this.asa)
    {
      this.arY.write(this.arZ);
      i += 1;
    }
    return true;
  }
  
  protected final void kc()
  {
    this.asa += 1;
    this.arY.write(91);
    kj();
  }
  
  protected final void kd()
  {
    this.asa -= 1;
    kj();
    this.arY.write(93);
  }
  
  protected final void ke()
  {
    this.arY.write(44);
    if (!kj()) {
      this.arY.write(32);
    }
  }
  
  protected final void kf()
  {
    this.asa += 1;
    this.arY.write(123);
    kj();
  }
  
  protected final void kg()
  {
    this.asa -= 1;
    kj();
    this.arY.write(125);
  }
  
  protected final void kh()
  {
    this.arY.write(58);
    this.arY.write(32);
  }
  
  protected final void ki()
  {
    this.arY.write(44);
    if (!kj()) {
      this.arY.write(32);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.a.k.a
 * JD-Core Version:    0.7.0.1
 */