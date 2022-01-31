package com.tencent.mm.openim.d;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends i<c>
{
  public static final String[] dXp = { i.a(c.buS, "OpenIMAppIdInfo") };
  public h dXo;
  
  public d(h paramh)
  {
    super(paramh, c.buS, "OpenIMAppIdInfo", null);
    this.dXo = paramh;
  }
  
  public final boolean a(c paramc)
  {
    paramc.field_updateTime = bk.UX();
    return super.a(paramc);
  }
  
  public final List<String> oW(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    paramString = this.dXo.a("select distinct appid from OpenIMAppIdInfo where appid=? ", new String[] { paramString }, 2);
    if (paramString.moveToFirst()) {
      do
      {
        String str = paramString.getString(0);
        if (!bk.bl(str)) {
          localLinkedList.add(str);
        }
      } while (paramString.moveToNext());
    }
    paramString.close();
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.openim.d.d
 * JD-Core Version:    0.7.0.1
 */