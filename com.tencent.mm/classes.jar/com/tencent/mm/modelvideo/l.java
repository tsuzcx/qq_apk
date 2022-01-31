package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends i<j>
{
  public static final String[] dXp = { i.a(j.buS, "SightDraftInfo") };
  public e dXw;
  
  public l(e parame)
  {
    super(parame, j.buS, "SightDraftInfo", null);
    this.dXw = parame;
  }
  
  public final List<j> Sm()
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC " + new StringBuilder(" LIMIT 5").toString();
    localObject = this.dXw.a((String)localObject, new String[] { "7" }, 2);
    if (localObject == null) {
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      j localj = new j();
      localj.d((Cursor)localObject);
      localLinkedList.add(localj);
    }
    ((Cursor)localObject).close();
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.l
 * JD-Core Version:    0.7.0.1
 */