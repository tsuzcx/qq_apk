package com.tencent.mm.cg.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

public final class e
  extends AbstractCursor
  implements d
{
  private DataSetObserver mObserver;
  private d yRs;
  public d[] yRt;
  
  public e(d[] paramArrayOfd)
  {
    AppMethodBeat.i(59148);
    this.mObserver = new e.1(this);
    this.yRt = paramArrayOfd;
    this.yRs = paramArrayOfd[0];
    while (i < this.yRt.length)
    {
      if (this.yRt[i] != null) {
        this.yRt[i].registerDataSetObserver(this.mObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(59148);
  }
  
  public final boolean NL(int paramInt)
  {
    AppMethodBeat.i(59173);
    int j = this.yRt.length;
    boolean bool1 = true;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.yRt[i] != null)
      {
        bool2 = bool1;
        if (!this.yRt[i].NL(paramInt)) {
          bool2 = false;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    AppMethodBeat.o(59173);
    return bool1;
  }
  
  public final a NM(int paramInt)
  {
    AppMethodBeat.i(59170);
    int k = this.yRt.length;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      j = this.yRt[paramInt].getCount();
      if (i < j)
      {
        a locala = this.yRt[paramInt].NM(i);
        AppMethodBeat.o(59170);
        return locala;
      }
      i -= j;
      paramInt += 1;
    }
    AppMethodBeat.o(59170);
    return null;
  }
  
  public final void NN(int paramInt)
  {
    AppMethodBeat.i(59176);
    int j = this.yRt.length;
    int i = 0;
    while (i < j)
    {
      if (this.yRt[i] != null) {
        this.yRt[i].NN(paramInt);
      }
      i += 1;
    }
    AppMethodBeat.o(59176);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(59167);
    int j = this.yRt.length;
    int i = 0;
    while (i < j)
    {
      if (this.yRt[i] != null) {
        this.yRt[i].a(parama);
      }
      i += 1;
    }
    AppMethodBeat.o(59167);
  }
  
  public final boolean a(Object paramObject, a parama)
  {
    AppMethodBeat.i(59171);
    int j = this.yRt.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      bool2 = bool1;
      if (this.yRt[i] != null)
      {
        bool2 = bool1;
        if (this.yRt[i].a(paramObject, parama)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(59171);
    return bool1;
  }
  
  public final boolean cD(Object paramObject)
  {
    AppMethodBeat.i(59174);
    int j = this.yRt.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      bool2 = bool1;
      if (this.yRt[i] != null)
      {
        bool2 = bool1;
        if (this.yRt[i].cD(paramObject)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(59174);
    return bool1;
  }
  
  public final a cE(Object paramObject)
  {
    AppMethodBeat.i(59175);
    paramObject = this.yRs.cE(paramObject);
    AppMethodBeat.o(59175);
    return paramObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(59161);
    int j = this.yRt.length;
    int i = 0;
    while (i < j)
    {
      if (this.yRt[i] != null) {
        this.yRt[i].close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(59161);
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final void deactivate()
  {
    AppMethodBeat.i(59160);
    int j = this.yRt.length;
    int i = 0;
    while (i < j)
    {
      if (this.yRt[i] != null) {
        this.yRt[i].deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(59160);
  }
  
  public final SparseArray<Object>[] dzK()
  {
    AppMethodBeat.i(59172);
    int j = this.yRt.length;
    SparseArray[] arrayOfSparseArray = new SparseArray[j];
    int i = 0;
    if (i < j)
    {
      Object localObject = this.yRt[i].dzK();
      if (localObject != null) {}
      for (localObject = localObject[0];; localObject = null)
      {
        arrayOfSparseArray[i] = localObject;
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(59172);
    return arrayOfSparseArray;
  }
  
  public final HashMap dzL()
  {
    return null;
  }
  
  public final boolean dzM()
  {
    AppMethodBeat.i(59169);
    int j = this.yRt.length;
    boolean bool1 = true;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.yRt[i] != null)
      {
        bool2 = bool1;
        if (!this.yRt[i].dzM()) {
          bool2 = false;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    AppMethodBeat.o(59169);
    return bool1;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(59158);
    byte[] arrayOfByte = this.yRs.getBlob(paramInt);
    AppMethodBeat.o(59158);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(59159);
    if (this.yRs != null)
    {
      String[] arrayOfString = this.yRs.getColumnNames();
      AppMethodBeat.o(59159);
      return arrayOfString;
    }
    AppMethodBeat.o(59159);
    return new String[0];
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(59149);
    int m = this.yRt.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (this.yRt[i] != null) {
        k = j + this.yRt[i].getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(59149);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(59156);
    double d = this.yRs.getDouble(paramInt);
    AppMethodBeat.o(59156);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(59155);
    float f = this.yRs.getFloat(paramInt);
    AppMethodBeat.o(59155);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(59153);
    paramInt = this.yRs.getInt(paramInt);
    AppMethodBeat.o(59153);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(59154);
    long l = this.yRs.getLong(paramInt);
    AppMethodBeat.o(59154);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(59152);
    short s = this.yRs.getShort(paramInt);
    AppMethodBeat.o(59152);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(59151);
    String str = this.yRs.getString(paramInt);
    AppMethodBeat.o(59151);
    return str;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(59157);
    boolean bool = this.yRs.isNull(paramInt);
    AppMethodBeat.o(59157);
    return bool;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59150);
    this.yRs = null;
    int k = this.yRt.length;
    paramInt1 = 0;
    int j;
    for (int i = 0;; i = j)
    {
      if (paramInt1 < k)
      {
        j = i;
        if (this.yRt[paramInt1] == null) {
          break label110;
        }
        if (paramInt2 < this.yRt[paramInt1].getCount() + i) {
          this.yRs = this.yRt[paramInt1];
        }
      }
      else
      {
        if (this.yRs == null) {
          break;
        }
        boolean bool = this.yRs.moveToPosition(paramInt2 - i);
        AppMethodBeat.o(59150);
        return bool;
      }
      j = i + this.yRt[paramInt1].getCount();
      label110:
      paramInt1 += 1;
    }
    AppMethodBeat.o(59150);
    return false;
  }
  
  public final void pV(boolean paramBoolean)
  {
    AppMethodBeat.i(59168);
    int j = this.yRt.length;
    int i = 0;
    while (i < j)
    {
      if (this.yRt[i] != null) {
        this.yRt[i].pV(paramBoolean);
      }
      i += 1;
    }
    AppMethodBeat.o(59168);
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(59162);
    int j = this.yRt.length;
    int i = 0;
    while (i < j)
    {
      if (this.yRt[i] != null) {
        this.yRt[i].registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(59162);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(59164);
    int j = this.yRt.length;
    int i = 0;
    while (i < j)
    {
      if (this.yRt[i] != null) {
        this.yRt[i].registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(59164);
  }
  
  public final boolean requery()
  {
    AppMethodBeat.i(59166);
    int j = this.yRt.length;
    int i = 0;
    while (i < j)
    {
      if ((this.yRt[i] != null) && (!this.yRt[i].requery()))
      {
        AppMethodBeat.o(59166);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(59166);
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(59163);
    int j = this.yRt.length;
    int i = 0;
    while (i < j)
    {
      if (this.yRt[i] != null) {
        this.yRt[i].unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(59163);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(59165);
    int j = this.yRt.length;
    int i = 0;
    while (i < j)
    {
      if (this.yRt[i] != null) {
        this.yRt[i].unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(59165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cg.a.e
 * JD-Core Version:    0.7.0.1
 */