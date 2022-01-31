package com.tencent.mm.cf.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

public final class e
  extends AbstractCursor
  implements d
{
  private DataSetObserver mObserver = new e.1(this);
  private d uEK;
  public d[] uEL;
  
  public e(d[] paramArrayOfd)
  {
    this.uEL = paramArrayOfd;
    this.uEK = paramArrayOfd[0];
    while (i < this.uEL.length)
    {
      if (this.uEL[i] != null) {
        this.uEL[i].registerDataSetObserver(this.mObserver);
      }
      i += 1;
    }
  }
  
  public final boolean FB(int paramInt)
  {
    int j = this.uEL.length;
    boolean bool1 = true;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.uEL[i] != null)
      {
        bool2 = bool1;
        if (!this.uEL[i].FB(paramInt)) {
          bool2 = false;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    return bool1;
  }
  
  public final a FC(int paramInt)
  {
    int k = this.uEL.length;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      j = this.uEL[paramInt].getCount();
      if (i < j) {
        return this.uEL[paramInt].FC(i);
      }
      i -= j;
      paramInt += 1;
    }
    return null;
  }
  
  public final void FD(int paramInt)
  {
    int j = this.uEL.length;
    int i = 0;
    while (i < j)
    {
      if (this.uEL[i] != null) {
        this.uEL[i].FD(paramInt);
      }
      i += 1;
    }
  }
  
  public final void a(f.a parama)
  {
    int j = this.uEL.length;
    int i = 0;
    while (i < j)
    {
      if (this.uEL[i] != null) {
        this.uEL[i].a(parama);
      }
      i += 1;
    }
  }
  
  public final boolean a(Object paramObject, a parama)
  {
    int j = this.uEL.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      bool2 = bool1;
      if (this.uEL[i] != null)
      {
        bool2 = bool1;
        if (this.uEL[i].a(paramObject, parama)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public final boolean bY(Object paramObject)
  {
    int j = this.uEL.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      bool2 = bool1;
      if (this.uEL[i] != null)
      {
        bool2 = bool1;
        if (this.uEL[i].bY(paramObject)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public final a bZ(Object paramObject)
  {
    return this.uEK.bZ(paramObject);
  }
  
  public final void close()
  {
    int j = this.uEL.length;
    int i = 0;
    while (i < j)
    {
      if (this.uEL[i] != null) {
        this.uEL[i].close();
      }
      i += 1;
    }
    super.close();
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final SparseArray<Object>[] cwY()
  {
    int j = this.uEL.length;
    SparseArray[] arrayOfSparseArray = new SparseArray[j];
    int i = 0;
    if (i < j)
    {
      Object localObject = this.uEL[i].cwY();
      if (localObject != null) {}
      for (localObject = localObject[0];; localObject = null)
      {
        arrayOfSparseArray[i] = localObject;
        i += 1;
        break;
      }
    }
    return arrayOfSparseArray;
  }
  
  public final HashMap cwZ()
  {
    return null;
  }
  
  public final boolean cxa()
  {
    int j = this.uEL.length;
    boolean bool1 = true;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.uEL[i] != null)
      {
        bool2 = bool1;
        if (!this.uEL[i].cxa()) {
          bool2 = false;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    return bool1;
  }
  
  public final void deactivate()
  {
    int j = this.uEL.length;
    int i = 0;
    while (i < j)
    {
      if (this.uEL[i] != null) {
        this.uEL[i].deactivate();
      }
      i += 1;
    }
    super.deactivate();
  }
  
  public final byte[] getBlob(int paramInt)
  {
    return this.uEK.getBlob(paramInt);
  }
  
  public final String[] getColumnNames()
  {
    if (this.uEK != null) {
      return this.uEK.getColumnNames();
    }
    return new String[0];
  }
  
  public final int getCount()
  {
    int m = this.uEL.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (this.uEL[i] != null) {
        k = j + this.uEL[i].getCount();
      }
      i += 1;
    }
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    return this.uEK.getDouble(paramInt);
  }
  
  public final float getFloat(int paramInt)
  {
    return this.uEK.getFloat(paramInt);
  }
  
  public final int getInt(int paramInt)
  {
    return this.uEK.getInt(paramInt);
  }
  
  public final long getLong(int paramInt)
  {
    return this.uEK.getLong(paramInt);
  }
  
  public final short getShort(int paramInt)
  {
    return this.uEK.getShort(paramInt);
  }
  
  public final String getString(int paramInt)
  {
    return this.uEK.getString(paramInt);
  }
  
  public final boolean isNull(int paramInt)
  {
    return this.uEK.isNull(paramInt);
  }
  
  public final void mD(boolean paramBoolean)
  {
    int j = this.uEL.length;
    int i = 0;
    while (i < j)
    {
      if (this.uEL[i] != null) {
        this.uEL[i].mD(paramBoolean);
      }
      i += 1;
    }
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    this.uEK = null;
    int k = this.uEL.length;
    paramInt1 = 0;
    int j;
    for (int i = 0;; i = j)
    {
      if (paramInt1 < k)
      {
        j = i;
        if (this.uEL[paramInt1] == null) {
          break label96;
        }
        if (paramInt2 < this.uEL[paramInt1].getCount() + i) {
          this.uEK = this.uEL[paramInt1];
        }
      }
      else
      {
        if (this.uEK == null) {
          break;
        }
        return this.uEK.moveToPosition(paramInt2 - i);
      }
      j = i + this.uEL[paramInt1].getCount();
      label96:
      paramInt1 += 1;
    }
    return false;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    int j = this.uEL.length;
    int i = 0;
    while (i < j)
    {
      if (this.uEL[i] != null) {
        this.uEL[i].registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    int j = this.uEL.length;
    int i = 0;
    while (i < j)
    {
      if (this.uEL[i] != null) {
        this.uEL[i].registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
  }
  
  public final boolean requery()
  {
    int j = this.uEL.length;
    int i = 0;
    while (i < j)
    {
      if ((this.uEL[i] != null) && (!this.uEL[i].requery())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    int j = this.uEL.length;
    int i = 0;
    while (i < j)
    {
      if (this.uEL[i] != null) {
        this.uEL[i].unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    int j = this.uEL.length;
    int i = 0;
    while (i < j)
    {
      if (this.uEL[i] != null) {
        this.uEL[i].unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cf.a.e
 * JD-Core Version:    0.7.0.1
 */