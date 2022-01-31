package com.tencent.mm.plugin.account.security.a;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends i<d>
{
  public static final String[] dXp = { i.a(d.buS, "SafeDeviceInfo") };
  h fjS = null;
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.buS, "SafeDeviceInfo", null);
    if ((parame instanceof h)) {
      this.fjS = ((h)parame);
    }
  }
  
  public final List<d> Xy()
  {
    LinkedList localLinkedList = new LinkedList();
    if (getCount() > 0)
    {
      Cursor localCursor = super.aAn();
      while (localCursor.moveToNext())
      {
        d locald = new d();
        locald.d(localCursor);
        localLinkedList.add(locald);
      }
      localCursor.close();
    }
    return localLinkedList;
  }
  
  public final boolean a(d paramd)
  {
    return super.b(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.e
 * JD-Core Version:    0.7.0.1
 */