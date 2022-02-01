package androidx.core.graphics;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static final c Kn;
  public final int bottom;
  public final int left;
  public final int right;
  public final int top;
  
  static
  {
    AppMethodBeat.i(250671);
    Kn = new c(0, 0, 0, 0);
    AppMethodBeat.o(250671);
  }
  
  private c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.left = paramInt1;
    this.top = paramInt2;
    this.right = paramInt3;
    this.bottom = paramInt4;
  }
  
  public static c e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(250667);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))
    {
      localc = Kn;
      AppMethodBeat.o(250667);
      return localc;
    }
    c localc = new c(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(250667);
    return localc;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250668);
    if (this == paramObject)
    {
      AppMethodBeat.o(250668);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(250668);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.bottom != paramObject.bottom)
    {
      AppMethodBeat.o(250668);
      return false;
    }
    if (this.left != paramObject.left)
    {
      AppMethodBeat.o(250668);
      return false;
    }
    if (this.right != paramObject.right)
    {
      AppMethodBeat.o(250668);
      return false;
    }
    if (this.top != paramObject.top)
    {
      AppMethodBeat.o(250668);
      return false;
    }
    AppMethodBeat.o(250668);
    return true;
  }
  
  public final int hashCode()
  {
    return ((this.left * 31 + this.top) * 31 + this.right) * 31 + this.bottom;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250670);
    String str = "Insets{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    AppMethodBeat.o(250670);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.graphics.c
 * JD-Core Version:    0.7.0.1
 */