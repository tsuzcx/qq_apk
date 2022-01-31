package com.tencent.mm.plugin.appbrand.appusage.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public class b
  extends j<a>
{
  public static final String[] fkl;
  private e db;
  
  static
  {
    AppMethodBeat.i(129737);
    fkl = new String[] { j.getCreateSQLs(a.info, "AppBrandRecommendCard") };
    AppMethodBeat.o(129737);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "AppBrandRecommendCard", null);
    this.db = parame;
  }
  
  public final void axH()
  {
    AppMethodBeat.i(129734);
    this.db.execSQL("AppBrandRecommendCard", "delete from AppBrandRecommendCard");
    AppMethodBeat.o(129734);
  }
  
  public final LinkedList<bsi> axI()
  {
    AppMethodBeat.i(129736);
    Cursor localCursor = this.db.rawQuery("select * from AppBrandRecommendCard LIMIT 100", null);
    if (localCursor == null)
    {
      AppMethodBeat.o(129736);
      return null;
    }
    ab.i("MicroMsg.Recommend.AppBrandRecommendCardStorage", "getRecommendWxaList()");
    LinkedList localLinkedList = new LinkedList();
    while (localCursor.moveToNext())
    {
      a locala = new a();
      locala.convertFrom(localCursor);
      localLinkedList.add(locala.field_recommendCard);
    }
    localCursor.close();
    AppMethodBeat.o(129736);
    return localLinkedList;
  }
  
  public final void t(LinkedList<bsi> paramLinkedList)
  {
    AppMethodBeat.i(129735);
    ab.i("MicroMsg.Recommend.AppBrandRecommendCardStorage", "addRecommendWxaList()");
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(paramLinkedList);
    paramLinkedList = ((LinkedList)localObject).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (bsi)paramLinkedList.next();
      a locala = new a();
      locala.field_appId = ((bsi)localObject).xFL;
      locala.field_recommendCard = ((bsi)localObject);
      insert(locala);
    }
    AppMethodBeat.o(129735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.b
 * JD-Core Version:    0.7.0.1
 */