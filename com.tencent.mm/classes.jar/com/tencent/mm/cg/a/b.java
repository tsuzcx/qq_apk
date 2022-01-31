package com.tencent.mm.cg.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a>
  extends SQLiteClosable
{
  int mStartPos = 0;
  SparseArray<Object> yRi = new SparseArray();
  int yRj;
  HashMap<Object, T> yRk = new HashMap();
  ArrayList<Object> yRl;
  T yRm;
  
  final void A(Object[] paramArrayOfObject)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = 0;
    if (i < this.yRi.size())
    {
      int i2 = this.yRi.keyAt(i);
      Object localObject = this.yRi.valueAt(i);
      int i1 = 1;
      int i3 = paramArrayOfObject.length;
      int n = 0;
      label54:
      int k = j;
      int m = i1;
      if (n < i3)
      {
        if (paramArrayOfObject[n].equals(localObject))
        {
          k = j + 1;
          m = 0;
        }
      }
      else
      {
        if (m == 0) {
          break label124;
        }
        localSparseArray.put(i2 - k, localObject);
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        n += 1;
        break label54;
        label124:
        ab.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i + " obj : " + localObject);
      }
    }
    if (this.yRi.size() != localSparseArray.size()) {
      ab.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.yRi.size() + " newposistion Size : " + localSparseArray.size());
    }
    this.yRi = localSparseArray;
  }
  
  public final boolean NO(int paramInt)
  {
    return this.yRi.indexOfKey(paramInt) >= 0;
  }
  
  public abstract ArrayList<T> ap(ArrayList<Object> paramArrayList);
  
  final void b(Object paramObject, T paramT)
  {
    this.yRk.put(paramObject, paramT);
  }
  
  public final boolean cD(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 1) {
        return (this.yRk != null) && (this.yRk.containsKey(arrayOfObject[0]));
      }
    }
    return (this.yRk != null) && (this.yRk.containsKey(paramObject));
  }
  
  public final void clearData()
  {
    ab.i("MicroMsg.CursorDataWindow", "clearData");
    this.yRi.clear();
    this.yRk.clear();
  }
  
  public abstract T dzX();
  
  public final void hp(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      ab.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.yRi.remove(paramInt1);
    }
    while (this.yRm == null) {
      return;
    }
    Object localObject = this.yRm.getKey();
    b(localObject, this.yRm);
    this.yRi.put(paramInt1, localObject);
  }
  
  protected void onAllReferencesReleased()
  {
    clearData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cg.a.b
 * JD-Core Version:    0.7.0.1
 */