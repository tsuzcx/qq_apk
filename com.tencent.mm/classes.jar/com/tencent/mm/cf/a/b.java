package com.tencent.mm.cf.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a>
  extends SQLiteClosable
{
  int mStartPos = 0;
  SparseArray<Object> uEA = new SparseArray();
  int uEB;
  HashMap<Object, T> uEC = new HashMap();
  ArrayList<Object> uED;
  T uEE;
  
  public final boolean FE(int paramInt)
  {
    return this.uEA.indexOfKey(paramInt) >= 0;
  }
  
  public final void adg()
  {
    y.i("MicroMsg.CursorDataWindow", "clearData");
    this.uEA.clear();
    this.uEC.clear();
  }
  
  public abstract ArrayList<T> ag(ArrayList<Object> paramArrayList);
  
  final void b(Object paramObject, T paramT)
  {
    this.uEC.put(paramObject, paramT);
  }
  
  public final boolean bY(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 1) {
        return (this.uEC != null) && (this.uEC.containsKey(arrayOfObject[0]));
      }
    }
    return (this.uEC != null) && (this.uEC.containsKey(paramObject));
  }
  
  public abstract T cxi();
  
  public final void fi(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      y.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.uEA.remove(paramInt1);
    }
    while (this.uEE == null) {
      return;
    }
    Object localObject = this.uEE.getKey();
    b(localObject, this.uEE);
    this.uEA.put(paramInt1, localObject);
  }
  
  protected void onAllReferencesReleased()
  {
    adg();
  }
  
  final void v(Object[] paramArrayOfObject)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = 0;
    if (i < this.uEA.size())
    {
      int i2 = this.uEA.keyAt(i);
      Object localObject = this.uEA.valueAt(i);
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
        y.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i + " obj : " + localObject);
      }
    }
    if (this.uEA.size() != localSparseArray.size()) {
      y.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.uEA.size() + " newposistion Size : " + localSparseArray.size());
    }
    this.uEA = localSparseArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.a.b
 * JD-Core Version:    0.7.0.1
 */