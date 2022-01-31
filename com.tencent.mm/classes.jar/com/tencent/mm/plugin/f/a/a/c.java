package com.tencent.mm.plugin.f.a.a;

import java.util.Arrays;

public final class c
{
  public String btt = "";
  String hTd = null;
  public e hTe = null;
  public double hTf = 0.0D;
  
  public final boolean equals(Object paramObject)
  {
    if ((this.hTe == null) || (paramObject == null)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return Arrays.equals(((c)paramObject).hTe.hTi.hTJ, this.hTe.hTi.hTJ);
  }
  
  public final int hashCode()
  {
    if (this.hTe == null) {
      return 0;
    }
    return Arrays.hashCode(this.hTe.hTi.hTJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.c
 * JD-Core Version:    0.7.0.1
 */