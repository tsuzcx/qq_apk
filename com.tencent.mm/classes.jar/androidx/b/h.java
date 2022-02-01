package androidx.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class h<E>
  implements Cloneable
{
  private static final Object zI;
  private int mSize;
  private boolean zJ;
  private Object[] zL;
  private int[] zX;
  
  static
  {
    AppMethodBeat.i(210416);
    zI = new Object();
    AppMethodBeat.o(210416);
  }
  
  public h()
  {
    this(10);
  }
  
  public h(int paramInt)
  {
    AppMethodBeat.i(210391);
    this.zJ = false;
    if (paramInt == 0) {
      this.zX = c.zF;
    }
    for (this.zL = c.zH;; this.zL = new Object[paramInt])
    {
      this.mSize = 0;
      AppMethodBeat.o(210391);
      return;
      paramInt = c.idealIntArraySize(paramInt);
      this.zX = new int[paramInt];
    }
  }
  
  private void ff()
  {
    int m = this.mSize;
    int[] arrayOfInt = this.zX;
    Object[] arrayOfObject = this.zL;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != zI)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.zJ = false;
    this.mSize = j;
  }
  
  public final E aM(int paramInt)
  {
    AppMethodBeat.i(210405);
    if (this.zJ) {
      ff();
    }
    Object localObject = this.zL[paramInt];
    AppMethodBeat.o(210405);
    return localObject;
  }
  
  public final int aP(int paramInt)
  {
    AppMethodBeat.i(210403);
    if (this.zJ) {
      ff();
    }
    paramInt = this.zX[paramInt];
    AppMethodBeat.o(210403);
    return paramInt;
  }
  
  public final int aQ(int paramInt)
  {
    AppMethodBeat.i(210406);
    if (this.zJ) {
      ff();
    }
    paramInt = c.a(this.zX, this.mSize, paramInt);
    AppMethodBeat.o(210406);
    return paramInt;
  }
  
  public final E b(int paramInt, E paramE)
  {
    AppMethodBeat.i(210394);
    paramInt = c.a(this.zX, this.mSize, paramInt);
    if ((paramInt < 0) || (this.zL[paramInt] == zI))
    {
      AppMethodBeat.o(210394);
      return paramE;
    }
    paramE = this.zL[paramInt];
    AppMethodBeat.o(210394);
    return paramE;
  }
  
  public final void c(int paramInt, E paramE)
  {
    AppMethodBeat.i(210409);
    if ((this.mSize != 0) && (paramInt <= this.zX[(this.mSize - 1)]))
    {
      put(paramInt, paramE);
      AppMethodBeat.o(210409);
      return;
    }
    if ((this.zJ) && (this.mSize >= this.zX.length)) {
      ff();
    }
    int i = this.mSize;
    if (i >= this.zX.length)
    {
      int j = c.idealIntArraySize(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.zX, 0, arrayOfInt, 0, this.zX.length);
      System.arraycopy(this.zL, 0, arrayOfObject, 0, this.zL.length);
      this.zX = arrayOfInt;
      this.zL = arrayOfObject;
    }
    this.zX[i] = paramInt;
    this.zL[i] = paramE;
    this.mSize = (i + 1);
    AppMethodBeat.o(210409);
  }
  
  public final void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.zL;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.mSize = 0;
    this.zJ = false;
  }
  
  public final h<E> fg()
  {
    AppMethodBeat.i(210392);
    try
    {
      h localh = (h)super.clone();
      localh.zX = ((int[])this.zX.clone());
      localh.zL = ((Object[])this.zL.clone());
      AppMethodBeat.o(210392);
      return localh;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AssertionError localAssertionError = new AssertionError(localCloneNotSupportedException);
      AppMethodBeat.o(210392);
      throw localAssertionError;
    }
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(292890);
    Object localObject = b(paramInt, null);
    AppMethodBeat.o(292890);
    return localObject;
  }
  
  public final void put(int paramInt, E paramE)
  {
    AppMethodBeat.i(210400);
    int i = c.a(this.zX, this.mSize, paramInt);
    if (i >= 0)
    {
      this.zL[i] = paramE;
      AppMethodBeat.o(210400);
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.zL[j] == zI))
    {
      this.zX[j] = paramInt;
      this.zL[j] = paramE;
      AppMethodBeat.o(210400);
      return;
    }
    i = j;
    if (this.zJ)
    {
      i = j;
      if (this.mSize >= this.zX.length)
      {
        ff();
        i = c.a(this.zX, this.mSize, paramInt) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.zX.length)
    {
      j = c.idealIntArraySize(this.mSize + 1);
      localObject = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.zX, 0, localObject, 0, this.zX.length);
      System.arraycopy(this.zL, 0, arrayOfObject, 0, this.zL.length);
      this.zX = ((int[])localObject);
      this.zL = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.zX;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.zL;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.zX[i] = paramInt;
    this.zL[i] = paramE;
    this.mSize += 1;
    AppMethodBeat.o(210400);
  }
  
  public final int r(E paramE)
  {
    AppMethodBeat.i(210408);
    if (this.zJ) {
      ff();
    }
    int i = 0;
    while (i < this.mSize)
    {
      if (this.zL[i] == paramE)
      {
        AppMethodBeat.o(210408);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(210408);
    return -1;
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(210396);
    paramInt = c.a(this.zX, this.mSize, paramInt);
    if ((paramInt >= 0) && (this.zL[paramInt] != zI))
    {
      this.zL[paramInt] = zI;
      this.zJ = true;
    }
    AppMethodBeat.o(210396);
  }
  
  public final int size()
  {
    AppMethodBeat.i(210401);
    if (this.zJ) {
      ff();
    }
    int i = this.mSize;
    AppMethodBeat.o(210401);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(210410);
    if (size() <= 0)
    {
      AppMethodBeat.o(210410);
      return "{}";
    }
    Object localObject1 = new StringBuilder(this.mSize * 28);
    ((StringBuilder)localObject1).append('{');
    int i = 0;
    if (i < this.mSize)
    {
      if (i > 0) {
        ((StringBuilder)localObject1).append(", ");
      }
      ((StringBuilder)localObject1).append(aP(i));
      ((StringBuilder)localObject1).append('=');
      Object localObject2 = aM(i);
      if (localObject2 != this) {
        ((StringBuilder)localObject1).append(localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject1).append("(this Map)");
      }
    }
    ((StringBuilder)localObject1).append('}');
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(210410);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.b.h
 * JD-Core Version:    0.7.0.1
 */