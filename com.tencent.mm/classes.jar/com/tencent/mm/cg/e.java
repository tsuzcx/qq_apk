package com.tencent.mm.cg;

import android.database.AbstractCursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends AbstractCursor
{
  private final int columnCount;
  private final String[] columnNames;
  private Object[] data;
  private int rowCount;
  
  private e(String[] paramArrayOfString)
  {
    AppMethodBeat.i(59038);
    this.rowCount = 0;
    this.columnNames = paramArrayOfString;
    this.columnCount = paramArrayOfString.length;
    this.data = new Object[this.columnCount * 16];
    AppMethodBeat.o(59038);
  }
  
  public e(String[] paramArrayOfString, byte paramByte)
  {
    this(paramArrayOfString);
  }
  
  private static int cF(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof byte[])) {
      return 4;
    }
    if (((paramObject instanceof Float)) || ((paramObject instanceof Double))) {
      return 2;
    }
    if (((paramObject instanceof Long)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte))) {
      return 1;
    }
    return 3;
  }
  
  private void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(59041);
    Object[] arrayOfObject;
    int i;
    if (paramInt > this.data.length)
    {
      arrayOfObject = this.data;
      i = this.data.length * 2;
      if (i >= paramInt) {
        break label58;
      }
    }
    for (;;)
    {
      this.data = new Object[paramInt];
      System.arraycopy(arrayOfObject, 0, this.data, 0, arrayOfObject.length);
      AppMethodBeat.o(59041);
      return;
      label58:
      paramInt = i;
    }
  }
  
  private Object get(int paramInt)
  {
    AppMethodBeat.i(59039);
    if ((paramInt < 0) || (paramInt >= this.columnCount))
    {
      localObject = new CursorIndexOutOfBoundsException("Requested column: " + paramInt + ", # of columns: " + this.columnCount);
      AppMethodBeat.o(59039);
      throw ((Throwable)localObject);
    }
    if (this.mPos < 0)
    {
      localObject = new CursorIndexOutOfBoundsException("Before first row.");
      AppMethodBeat.o(59039);
      throw ((Throwable)localObject);
    }
    if (this.mPos >= this.rowCount)
    {
      localObject = new CursorIndexOutOfBoundsException("After last row.");
      AppMethodBeat.o(59039);
      throw ((Throwable)localObject);
    }
    Object localObject = this.data[(this.mPos * this.columnCount + paramInt)];
    AppMethodBeat.o(59039);
    return localObject;
  }
  
  public final void addRow(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(59040);
    if (paramArrayOfObject.length != this.columnCount)
    {
      paramArrayOfObject = new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + paramArrayOfObject.length);
      AppMethodBeat.o(59040);
      throw paramArrayOfObject;
    }
    int i = this.rowCount;
    this.rowCount = (i + 1);
    i *= this.columnCount;
    ensureCapacity(this.columnCount + i);
    System.arraycopy(paramArrayOfObject, 0, this.data, i, this.columnCount);
    AppMethodBeat.o(59040);
  }
  
  public final void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    AppMethodBeat.i(59051);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(59051);
      return;
    }
    paramCursorWindow.acquireReference();
    try
    {
      int j = getPosition();
      int k = getColumnCount();
      paramCursorWindow.clear();
      paramCursorWindow.setStartPosition(paramInt);
      paramCursorWindow.setNumColumns(k);
      int i;
      if (moveToPosition(paramInt)) {
        if (paramCursorWindow.allocRow())
        {
          i = 0;
          label72:
          if (i < k) {
            switch (cF(get(i)))
            {
            }
          }
        }
      }
      for (;;)
      {
        Object localObject1 = getString(i);
        boolean bool;
        if (localObject1 != null) {
          bool = paramCursorWindow.putString((String)localObject1, paramInt, i);
        }
        for (;;)
        {
          if (bool) {
            break label269;
          }
          paramCursorWindow.freeLastRow();
          paramInt += 1;
          if (moveToNext()) {
            break;
          }
          moveToPosition(j);
          return;
          bool = paramCursorWindow.putNull(paramInt, i);
          continue;
          bool = paramCursorWindow.putLong(getLong(i), paramInt, i);
          continue;
          bool = paramCursorWindow.putDouble(getDouble(i), paramInt, i);
          continue;
          localObject1 = getBlob(i);
          if (localObject1 != null)
          {
            bool = paramCursorWindow.putBlob((byte[])localObject1, paramInt, i);
          }
          else
          {
            bool = paramCursorWindow.putNull(paramInt, i);
            continue;
            bool = paramCursorWindow.putNull(paramInt, i);
          }
        }
        label269:
        i += 1;
        break label72;
      }
    }
    catch (IllegalStateException localIllegalStateException) {}finally
    {
      paramCursorWindow.releaseReference();
      AppMethodBeat.o(59051);
    }
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(59048);
    byte[] arrayOfByte = (byte[])get(paramInt);
    AppMethodBeat.o(59048);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    return this.columnNames;
  }
  
  public final int getCount()
  {
    return this.rowCount;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(59047);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59047);
      return 0.0D;
    }
    if ((localObject instanceof Number))
    {
      d = ((Number)localObject).doubleValue();
      AppMethodBeat.o(59047);
      return d;
    }
    double d = bo.getDouble(localObject.toString(), 0.0D);
    AppMethodBeat.o(59047);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(59046);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59046);
      return 0.0F;
    }
    if ((localObject instanceof Number))
    {
      f = ((Number)localObject).floatValue();
      AppMethodBeat.o(59046);
      return f;
    }
    float f = bo.getFloat(localObject.toString(), 0.0F);
    AppMethodBeat.o(59046);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(59044);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59044);
      return 0;
    }
    if ((localObject instanceof Number))
    {
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(59044);
      return paramInt;
    }
    paramInt = bo.getInt(localObject.toString(), 0);
    AppMethodBeat.o(59044);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(59045);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59045);
      return 0L;
    }
    if ((localObject instanceof Number))
    {
      l = ((Number)localObject).longValue();
      AppMethodBeat.o(59045);
      return l;
    }
    long l = bo.getLong(localObject.toString(), 0L);
    AppMethodBeat.o(59045);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(59043);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59043);
      return 0;
    }
    if ((localObject instanceof Number))
    {
      s = ((Number)localObject).shortValue();
      AppMethodBeat.o(59043);
      return s;
    }
    short s = Short.parseShort(localObject.toString());
    AppMethodBeat.o(59043);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(59042);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(59042);
      return null;
    }
    localObject = localObject.toString();
    AppMethodBeat.o(59042);
    return localObject;
  }
  
  public final int getType(int paramInt)
  {
    AppMethodBeat.i(59049);
    paramInt = cF(get(paramInt));
    AppMethodBeat.o(59049);
    return paramInt;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(59050);
    if (get(paramInt) == null)
    {
      AppMethodBeat.o(59050);
      return true;
    }
    AppMethodBeat.o(59050);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cg.e
 * JD-Core Version:    0.7.0.1
 */