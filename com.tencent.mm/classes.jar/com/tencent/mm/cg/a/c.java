package com.tencent.mm.cg.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;

public final class c
  extends AbstractCursor
{
  final int columnCount;
  private final String[] columnNames;
  SparseArray<Object[]> yRn;
  public int yRo;
  int yRp;
  
  private c(String[] paramArrayOfString)
  {
    AppMethodBeat.i(59136);
    this.yRo = 3000;
    this.columnNames = paramArrayOfString;
    this.columnCount = paramArrayOfString.length;
    this.yRn = new SparseArray();
    AppMethodBeat.o(59136);
  }
  
  public c(String[] paramArrayOfString, byte paramByte)
  {
    this(paramArrayOfString);
  }
  
  private Object get(int paramInt)
  {
    AppMethodBeat.i(59137);
    if ((paramInt < 0) || (paramInt >= this.columnCount))
    {
      localObject = new CursorIndexOutOfBoundsException("Requested column: " + paramInt + ", # of columns: " + this.columnCount);
      AppMethodBeat.o(59137);
      throw ((Throwable)localObject);
    }
    if (this.mPos < 0)
    {
      localObject = new CursorIndexOutOfBoundsException("Before first row.");
      AppMethodBeat.o(59137);
      throw ((Throwable)localObject);
    }
    if (this.mPos >= this.yRp)
    {
      localObject = new CursorIndexOutOfBoundsException("After last row.");
      AppMethodBeat.o(59137);
      throw ((Throwable)localObject);
    }
    int i = this.mPos / this.yRo;
    int j = this.mPos;
    int k = this.yRo;
    int m = this.columnCount;
    Object localObject = ((Object[])this.yRn.get(i))[(j % k * m + paramInt)];
    AppMethodBeat.o(59137);
    return localObject;
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(59145);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59145);
      return null;
    }
    localObject = (byte[])localObject;
    AppMethodBeat.o(59145);
    return localObject;
  }
  
  public final String[] getColumnNames()
  {
    return this.columnNames;
  }
  
  public final int getCount()
  {
    return this.yRp;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(59143);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59143);
      return 0.0D;
    }
    if ((localObject instanceof Number))
    {
      d = ((Number)localObject).doubleValue();
      AppMethodBeat.o(59143);
      return d;
    }
    double d = Double.parseDouble(localObject.toString());
    AppMethodBeat.o(59143);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(59142);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59142);
      return 0.0F;
    }
    if ((localObject instanceof Number))
    {
      f = ((Number)localObject).floatValue();
      AppMethodBeat.o(59142);
      return f;
    }
    float f = Float.parseFloat(localObject.toString());
    AppMethodBeat.o(59142);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(59140);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59140);
      return 0;
    }
    if ((localObject instanceof Number))
    {
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(59140);
      return paramInt;
    }
    paramInt = Integer.parseInt(localObject.toString());
    AppMethodBeat.o(59140);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(59141);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59141);
      return 0L;
    }
    if ((localObject instanceof Number))
    {
      l = ((Number)localObject).longValue();
      AppMethodBeat.o(59141);
      return l;
    }
    long l = Long.parseLong(localObject.toString());
    AppMethodBeat.o(59141);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(59139);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59139);
      return 0;
    }
    if ((localObject instanceof Number))
    {
      s = ((Number)localObject).shortValue();
      AppMethodBeat.o(59139);
      return s;
    }
    short s = Short.parseShort(localObject.toString());
    AppMethodBeat.o(59139);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(59138);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59138);
      return null;
    }
    localObject = localObject.toString();
    AppMethodBeat.o(59138);
    return localObject;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(59144);
    if (get(paramInt) == null)
    {
      AppMethodBeat.o(59144);
      return true;
    }
    AppMethodBeat.o(59144);
    return false;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final class a
  {
    final int endIndex;
    int index;
    Object[] yRq;
    
    a(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
    {
      this.index = paramInt1;
      this.endIndex = paramInt2;
      this.yRq = paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cg.a.c
 * JD-Core Version:    0.7.0.1
 */