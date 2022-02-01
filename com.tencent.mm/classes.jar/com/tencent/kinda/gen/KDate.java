package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class KDate
{
  public int mDay;
  public int mMonth;
  public int mYear;
  
  public KDate() {}
  
  public KDate(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mYear = paramInt1;
    this.mMonth = paramInt2;
    this.mDay = paramInt3;
  }
  
  public final int getDay()
  {
    return this.mDay;
  }
  
  public final int getMonth()
  {
    return this.mMonth;
  }
  
  public final int getYear()
  {
    return this.mYear;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190325);
    String str = "KDate{mYear=" + this.mYear + ",mMonth=" + this.mMonth + ",mDay=" + this.mDay + "}";
    AppMethodBeat.o(190325);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KDate
 * JD-Core Version:    0.7.0.1
 */