package com.tencent.mm.plugin.appbrand.appusage.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public class b
  extends j<a>
{
  public static final String[] hGX;
  private e db;
  
  static
  {
    AppMethodBeat.i(44668);
    hGX = new String[] { j.getCreateSQLs(a.info, "AppBrandRecommendCard") };
    AppMethodBeat.o(44668);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "AppBrandRecommendCard", null);
    this.db = parame;
  }
  
  public final void bdi()
  {
    AppMethodBeat.i(44665);
    this.db.execSQL("AppBrandRecommendCard", "delete from AppBrandRecommendCard");
    AppMethodBeat.o(44665);
  }
  
  public final LinkedList<csl> bdj()
  {
    AppMethodBeat.i(44667);
    Cursor localCursor = this.db.rawQuery("select * from AppBrandRecommendCard LIMIT 100", null);
    if (localCursor == null)
    {
      AppMethodBeat.o(44667);
      return null;
    }
    ae.i("MicroMsg.Recommend.AppBrandRecommendCardStorage", "getRecommendWxaList()");
    LinkedList localLinkedList = new LinkedList();
    while (localCursor.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(localCursor);
      localLinkedList.add(locala.field_recommendCard);
    }
    localCursor.close();
    AppMethodBeat.o(44667);
    return localLinkedList;
  }
  
  public final void u(LinkedList<csl> paramLinkedList)
  {
    AppMethodBeat.i(44666);
    ae.i("MicroMsg.Recommend.AppBrandRecommendCardStorage", "addRecommendWxaList()");
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(paramLinkedList);
    paramLinkedList = ((LinkedList)localObject).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (csl)paramLinkedList.next();
      a locala = new a();
      locala.field_appId = ((csl)localObject).Hgn;
      locala.field_recommendCard = ((csl)localObject);
      insert(locala);
    }
    AppMethodBeat.o(44666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.b
 * JD-Core Version:    0.7.0.1
 */