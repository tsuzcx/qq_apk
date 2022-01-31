package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.j;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;

public final class e
  extends i<j>
  implements aa
{
  private com.tencent.mm.sdk.e.e dXw;
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, j.buS, "FavSearchInfo", null);
    this.dXw = parame;
  }
  
  private static List<Integer> bp(List<Integer> paramList)
  {
    if (bk.dk(paramList)) {
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
    return localArrayList;
  }
  
  private static List<Integer> bq(List<Integer> paramList)
  {
    if (bk.dk(paramList)) {
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
    return localArrayList;
  }
  
  public final boolean CP(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    paramString = "select count(localId) from FavSearchInfo where tagContent like '%" + paramString + "%'";
    y.d("MicroMsg.FavSearchStorage", "is tag exist sql {%s}", new Object[] { paramString });
    paramString = this.dXw.a(paramString, null, 2);
    if ((paramString != null) && (paramString.moveToFirst())) {}
    for (int i = paramString.getInt(0);; i = 0)
    {
      if (paramString != null) {
        paramString.close();
      }
      if (i <= 0) {
        break;
      }
      return true;
    }
  }
  
  public final ArrayList<Long> a(List<String> paramList1, List<String> paramList2, List<Integer> paramList)
  {
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
    localObject = bp(paramList);
    paramList = bq(paramList);
    if (bk.dk((List)localObject))
    {
      paramList1 = paramList2;
      if (bk.dk(paramList)) {}
    }
    else
    {
      paramList2 = paramList2 + " and (";
      paramList1 = paramList2;
      int i;
      int j;
      if (!bk.dk((List)localObject))
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
      if (!bk.dk(paramList))
      {
        paramList2 = paramList1;
        if (!bk.dk((List)localObject)) {
          paramList2 = paramList1 + " or ";
        }
        paramList1 = paramList2 + "subtype & " + j.qX(((Integer)paramList.get(0)).intValue()) + " != 0";
        i = 1;
        for (;;)
        {
          paramList2 = paramList1;
          if (i >= paramList.size()) {
            break;
          }
          j = ((Integer)paramList.get(i)).intValue();
          paramList1 = paramList1 + " or subtype & " + j.qX(j) + " != 0";
          i += 1;
        }
      }
      paramList1 = paramList2 + ")";
    }
    paramList1 = paramList1 + " order by time desc";
    y.d("MicroMsg.FavSearchStorage", "search id sql {%s}", new Object[] { paramList1 });
    paramList1 = this.dXw.a(paramList1, null, 2);
    if (paramList1 == null) {
      return localArrayList;
    }
    while (paramList1.moveToNext()) {
      localArrayList.add(Long.valueOf(paramList1.getLong(0)));
    }
    paramList1.close();
    return localArrayList;
  }
  
  public final void eG(long paramLong)
  {
    String str = "delete from FavSearchInfo where localId = " + paramLong;
    this.dXw.gk("FavSearchInfo", str);
  }
  
  public final j eH(long paramLong)
  {
    j localj = null;
    Object localObject = "select * from FavSearchInfo where localId = " + paramLong;
    localObject = this.dXw.a((String)localObject, null, 2);
    if (localObject == null) {
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localj = new j();
      localj.d((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.e
 * JD-Core Version:    0.7.0.1
 */