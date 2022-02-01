package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static final c bqu;
  public final int bottom;
  public final int left;
  public final int right;
  public final int top;
  
  static
  {
    AppMethodBeat.i(196123);
    bqu = new c(0, 0, 0, 0);
    AppMethodBeat.o(196123);
  }
  
  private c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.left = paramInt1;
    this.top = paramInt2;
    this.right = paramInt3;
    this.bottom = paramInt4;
  }
  
  public static c a(Insets paramInsets)
  {
    AppMethodBeat.i(196112);
    paramInsets = m(paramInsets.left, paramInsets.top, paramInsets.right, paramInsets.bottom);
    AppMethodBeat.o(196112);
    return paramInsets;
  }
  
  public static c a(c paramc1, c paramc2)
  {
    AppMethodBeat.i(196104);
    paramc1 = m(Math.max(paramc1.left, paramc2.left), Math.max(paramc1.top, paramc2.top), Math.max(paramc1.right, paramc2.right), Math.max(paramc1.bottom, paramc2.bottom));
    AppMethodBeat.o(196104);
    return paramc1;
  }
  
  public static c i(Rect paramRect)
  {
    AppMethodBeat.i(196091);
    paramRect = m(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(196091);
    return paramRect;
  }
  
  public static c m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196083);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))
    {
      localc = bqu;
      AppMethodBeat.o(196083);
      return localc;
    }
    c localc = new c(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(196083);
    return localc;
  }
  
  public final Insets DG()
  {
    AppMethodBeat.i(196155);
    Insets localInsets = Insets.of(this.left, this.top, this.right, this.bottom);
    AppMethodBeat.o(196155);
    return localInsets;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196132);
    if (this == paramObject)
    {
      AppMethodBeat.o(196132);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(196132);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.bottom != paramObject.bottom)
    {
      AppMethodBeat.o(196132);
      return false;
    }
    if (this.left != paramObject.left)
    {
      AppMethodBeat.o(196132);
      return false;
    }
    if (this.right != paramObject.right)
    {
      AppMethodBeat.o(196132);
      return false;
    }
    if (this.top != paramObject.top)
    {
      AppMethodBeat.o(196132);
      return false;
    }
    AppMethodBeat.o(196132);
    return true;
  }
  
  public final int hashCode()
  {
    return ((this.left * 31 + this.top) * 31 + this.right) * 31 + this.bottom;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196151);
    String str = "Insets{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    AppMethodBeat.o(196151);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.graphics.c
 * JD-Core Version:    0.7.0.1
 */