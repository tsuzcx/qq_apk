package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;

public final class e
  extends com.tencent.mm.sdk.e.j<com.tencent.mm.plugin.fav.a.j>
  implements aa
{
  private com.tencent.mm.sdk.e.e db;
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, com.tencent.mm.plugin.fav.a.j.info, "FavSearchInfo", null);
    this.db = parame;
  }
  
  private static List<Integer> bI(List<Integer> paramList)
  {
    AppMethodBeat.i(5461);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(5461);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      switch (((Integer)paramList.next()).intValue())
      {
      case 2: 
      case 20: 
      default: 
        break;
      case 1: 
        localArrayList.add(Integer.valueOf(1));
        break;
      case 3: 
        localArrayList.add(Integer.valueOf(3));
        break;
      case 4: 
        localArrayList.add(Integer.valueOf(4));
        break;
      case 5: 
        localArrayList.add(Integer.valueOf(5));
        break;
      case 6: 
        localArrayList.add(Integer.valueOf(6));
        break;
      case 7: 
        localArrayList.add(Integer.valueOf(7));
        break;
      case 8: 
        localArrayList.add(Integer.valueOf(8));
        break;
      case 9: 
        localArrayList.add(Integer.valueOf(9));
        break;
      case 10: 
        localArrayList.add(Integer.valueOf(10));
        break;
      case 11: 
        localArrayList.add(Integer.valueOf(11));
        break;
      case 12: 
        localArrayList.add(Integer.valueOf(12));
        break;
      case 13: 
        localArrayList.add(Integer.valueOf(13));
        break;
      case 14: 
        localArrayList.add(Integer.valueOf(15));
        break;
      case 15: 
        localArrayList.add(Integer.valueOf(16));
        break;
      case 16: 
        localArrayList.add(Integer.valueOf(17));
        break;
      case 17: 
        localArrayList.add(Integer.valueOf(14));
        break;
      case 18: 
        localArrayList.add(Integer.valueOf(18));
        break;
      case 19: 
        localArrayList.add(Integer.valueOf(19));
        break;
      case 21: 
        localArrayList.add(Integer.valueOf(2));
        localArrayList.add(Integer.valueOf(4));
      }
    }
    AppMethodBeat.o(5461);
    return localArrayList;
  }
  
  private static List<Integer> bJ(List<Integer> paramList)
  {
    AppMethodBeat.i(5462);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(5462);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      switch (((Integer)paramList.next()).intValue())
      {
      case 2: 
      case 18: 
      case 20: 
      default: 
        break;
      case 1: 
        localArrayList.add(Integer.valueOf(1));
        break;
      case 3: 
        localArrayList.add(Integer.valueOf(3));
        break;
      case 4: 
        localArrayList.add(Integer.valueOf(4));
        break;
      case 5: 
        localArrayList.add(Integer.valueOf(5));
        break;
      case 6: 
        localArrayList.add(Integer.valueOf(6));
        break;
      case 7: 
        localArrayList.add(Integer.valueOf(7));
        break;
      case 8: 
        localArrayList.add(Integer.valueOf(8));
        break;
      case 9: 
        localArrayList.add(Integer.valueOf(9));
        break;
      case 10: 
        localArrayList.add(Integer.valueOf(10));
        break;
      case 11: 
        localArrayList.add(Integer.valueOf(11));
        break;
      case 12: 
        localArrayList.add(Integer.valueOf(12));
        break;
      case 13: 
        localArrayList.add(Integer.valueOf(13));
        break;
      case 14: 
        localArrayList.add(Integer.valueOf(14));
        break;
      case 15: 
        localArrayList.add(Integer.valueOf(15));
        break;
      case 16: 
        localArrayList.add(Integer.valueOf(16));
        break;
      case 17: 
        localArrayList.add(Integer.valueOf(17));
        break;
      case 19: 
        localArrayList.add(Integer.valueOf(19));
        break;
      case 21: 
        localArrayList.add(Integer.valueOf(2));
        localArrayList.add(Integer.valueOf(4));
      }
    }
    AppMethodBeat.o(5462);
    return localArrayList;
  }
  
  public final boolean NR(String paramString)
  {
    AppMethodBeat.i(5463);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5463);
      return false;
    }
    paramString = "select count(localId) from FavSearchInfo where tagContent like '%" + paramString + "%'";
    ab.d("MicroMsg.FavSearchStorage", "is tag exist sql {%s}", new Object[] { paramString });
    paramString = this.db.a(paramString, null, 2);
    if ((paramString != null) && (paramString.moveToFirst())) {}
    for (int i = paramString.getInt(0);; i = 0)
    {
      if (paramString != null) {
        paramString.close();
      }
      if (i > 0)
      {
        AppMethodBeat.o(5463);
        return true;
      }
      AppMethodBeat.o(5463);
      return false;
    }
  }
  
  public final ArrayList<Long> b(List<String> paramList1, List<String> paramList2, List<Integer> paramList)
  {
    AppMethodBeat.i(5460);
    ArrayList localArrayList = new ArrayList();
    String str = " 1=1 ";
    Object localObject = str;
    if (paramList1 != null)
    {
      localObject = str;
      if (!paramList1.isEmpty())
      {
        localObject = paramList1.iterator();
        for (paramList1 = " 1=1 "; ((Iterator)localObject).hasNext(); paramList1 = paramList1 + " and content like '%" + str + "%'") {
          str = (String)((Iterator)localObject).next();
        }
        localObject = paramList1;
      }
    }
    paramList1 = (List<String>)localObject;
    if (paramList2 != null)
    {
      paramList1 = (List<String>)localObject;
      if (!paramList2.isEmpty())
      {
        paramList2 = paramList2.iterator();
        for (paramList1 = (List<String>)localObject; paramList2.hasNext(); paramList1 = paramList1 + " and tagContent like '%" + (String)localObject + "%'") {
          localObject = (String)paramList2.next();
        }
      }
    }
    paramList2 = "select localId from FavSearchInfo" + " where " + paramList1;
    localObject = bI(paramList);
    paramList = bJ(paramList);
    if (bo.es((List)localObject))
    {
      paramList1 = paramList2;
      if (bo.es(paramList)) {}
    }
    else
    {
      paramList2 = paramList2 + " and (";
      paramList1 = paramList2;
      int i;
      int j;
      if (!bo.es((List)localObject))
      {
        paramList2 = paramList2 + "type = " + ((List)localObject).get(0);
        i = 1;
        for (;;)
        {
          paramList1 = paramList2;
          if (i >= ((List)localObject).size()) {
            break;
          }
          j = ((Integer)((List)localObject).get(i)).intValue();
          paramList2 = paramList2 + " or type = " + j;
          i += 1;
        }
      }
      paramList2 = paramList1;
      if (!bo.es(paramList))
      {
        paramList2 = paramList1;
        if (!bo.es((List)localObject)) {
          paramList2 = paramList1 + " or ";
        }
        paramList1 = paramList2 + "subtype & " + com.tencent.mm.plugin.fav.a.j.vS(((Integer)paramList.get(0)).intValue()) + " != 0";
        i = 1;
        for (;;)
        {
          paramList2 = paramList1;
          if (i >= paramList.size()) {
            break;
          }
          j = ((Integer)paramList.get(i)).intValue();
          paramList1 = paramList1 + " or subtype & " + com.tencent.mm.plugin.fav.a.j.vS(j) + " != 0";
          i += 1;
        }
      }
      paramList1 = paramList2 + ")";
    }
    paramList1 = paramList1 + " order by time desc";
    ab.d("MicroMsg.FavSearchStorage", "search id sql {%s}", new Object[] { paramList1 });
    paramList1 = this.db.a(paramList1, null, 2);
    if (paramList1 == null)
    {
      AppMethodBeat.o(5460);
      return localArrayList;
    }
    while (paramList1.moveToNext()) {
      localArrayList.add(Long.valueOf(paramList1.getLong(0)));
    }
    paramList1.close();
    AppMethodBeat.o(5460);
    return localArrayList;
  }
  
  public final void kd(long paramLong)
  {
    AppMethodBeat.i(5464);
    String str = "delete from FavSearchInfo where localId = ".concat(String.valueOf(paramLong));
    this.db.execSQL("FavSearchInfo", str);
    AppMethodBeat.o(5464);
  }
  
  public final com.tencent.mm.plugin.fav.a.j ke(long paramLong)
  {
    com.tencent.mm.plugin.fav.a.j localj = null;
    AppMethodBeat.i(5465);
    Object localObject = "select * from FavSearchInfo where localId = ".concat(String.valueOf(paramLong));
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(5465);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localj = new com.tencent.mm.plugin.fav.a.j();
      localj.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(5465);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.e
 * JD-Core Version:    0.7.0.1
 */