package com.tencent.mm.cf.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.wcdb.AbstractCursor;

public final class c
  extends AbstractCursor
{
  final int columnCount;
  private final String[] columnNames;
  SparseArray<Object[]> uEF;
  public int uEG = 3000;
  int uEH;
  
  private c(String[] paramArrayOfString)
  {
    this.columnNames = paramArrayOfString;
    this.columnCount = paramArrayOfString.length;
    this.uEF = new SparseArray();
  }
  
  public c(String[] paramArrayOfString, byte paramByte)
  {
    this(paramArrayOfString);
  }
  
  private Object get(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.columnCount)) {
      throw new CursorIndexOutOfBoundsException("Requested column: " + paramInt + ", # of columns: " + this.columnCount);
    }
    if (this.mPos < 0) {
      throw new CursorIndexOutOfBoundsException("Before first row.");
    }
    if (this.mPos >= this.uEH) {
      throw new CursorIndexOutOfBoundsException("After last row.");
    }
    int i = this.mPos / this.uEG;
    int j = this.mPos;
    int k = this.uEG;
    int m = this.columnCount;
    return ((Object[])this.uEF.get(i))[(j % k * m + paramInt)];
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final byte[] getBlob(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return null;
    }
    return (byte[])localObject;
  }
  
  public final String[] getColumnNames()
  {
    return this.columnNames;
  }
  
  public final int getCount()
  {
    return this.uEH;
  }
  
  public final double getDouble(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0.0D;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).doubleValue();
    }
    return Double.parseDouble(localObject.toString());
  }
  
  public final float getFloat(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0.0F;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).floatValue();
    }
    return Float.parseFloat(localObject.toString());
  }
  
  public final int getInt(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).intValue();
    }
    return Integer.parseInt(localObject.toString());
  }
  
  public final long getLong(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0L;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).longValue();
    }
    return Long.parseLong(localObject.toString());
  }
  
  public final short getShort(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).shortValue();
    }
    return Short.parseShort(localObject.toString());
  }
  
  public final String getString(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  public final boolean isNull(int paramInt)
  {
    return get(paramInt) == null;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final class a
  {
    final int endIndex;
    int index;
    Object[] uEI;
    
    a(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
    {
      this.index = paramInt1;
      this.endIndex = paramInt2;
      this.uEI = paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.a.c
 * JD-Core Version:    0.7.0.1
 */