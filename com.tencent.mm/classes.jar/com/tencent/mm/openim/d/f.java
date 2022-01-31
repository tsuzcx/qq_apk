package com.tencent.mm.openim.d;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends i<e>
{
  public static final String[] dXp = { i.a(e.buS, "OpenIMWordingInfo") };
  public h dXo;
  
  public f(h paramh)
  {
    super(paramh, e.buS, "OpenIMWordingInfo", null);
    this.dXo = paramh;
  }
  
  public final boolean a(e parame)
  {
    parame.field_updateTime = bk.UX();
    return super.a(parame);
  }
  
  public final List<String> v(int paramInt, String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = " select wordingId from OpenIMWordingInfo where language='" + paramString + "' order by updateTime limit " + paramInt;
    y.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording sql:%s", new Object[] { localObject });
    localObject = this.dXo.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        String str = ((Cursor)localObject).getString(0);
        if (!bk.bl(str)) {
          localLinkedList.add(str);
        }
      } while (((Cursor)localObject).moveToNext());
    }
    y.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording result cnt: %d, language:%s", new Object[] { Integer.valueOf(localLinkedList.size()), paramString });
    ((Cursor)localObject).close();
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.openim.d.f
 * JD-Core Version:    0.7.0.1
 */