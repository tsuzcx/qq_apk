package androidx.recyclerview.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$b
{
  int Vh;
  int afG;
  Object afH;
  int afI;
  
  a$b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    this.Vh = paramInt1;
    this.afG = paramInt2;
    this.afI = paramInt3;
    this.afH = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260654);
    if (this == paramObject)
    {
      AppMethodBeat.o(260654);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(260654);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.Vh != paramObject.Vh)
    {
      AppMethodBeat.o(260654);
      return false;
    }
    if ((this.Vh == 8) && (Math.abs(this.afI - this.afG) == 1) && (this.afI == paramObject.afG) && (this.afG == paramObject.afI))
    {
      AppMethodBeat.o(260654);
      return true;
    }
    if (this.afI != paramObject.afI)
    {
      AppMethodBeat.o(260654);
      return false;
    }
    if (this.afG != paramObject.afG)
    {
      AppMethodBeat.o(260654);
      return false;
    }
    if (this.afH != null)
    {
      if (!this.afH.equals(paramObject.afH))
      {
        AppMethodBeat.o(260654);
        return false;
      }
    }
    else if (paramObject.afH != null)
    {
      AppMethodBeat.o(260654);
      return false;
    }
    AppMethodBeat.o(260654);
    return true;
  }
  
  public final int hashCode()
  {
    return (this.Vh * 31 + this.afG) * 31 + this.afI;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(260652);
    StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
    String str;
    switch (this.Vh)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      str = "??";
    }
    for (;;)
    {
      str = str + ",s:" + this.afG + "c:" + this.afI + ",p:" + this.afH + "]";
      AppMethodBeat.o(260652);
      return str;
      str = "add";
      continue;
      str = "rm";
      continue;
      str = "up";
      continue;
      str = "mv";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.recyclerview.widget.a.b
 * JD-Core Version:    0.7.0.1
 */