package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/DiffLiveList;", "", "()V", "incrementList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "getIncrementList", "()Ljava/util/ArrayList;", "setIncrementList", "(Ljava/util/ArrayList;)V", "incrementListUsername", "", "getIncrementListUsername", "()Ljava/lang/String;", "setIncrementListUsername", "(Ljava/lang/String;)V", "removeList", "getRemoveList", "setRemoveList", "removeListUsername", "getRemoveListUsername", "setRemoveListUsername", "Companion", "plugin-finder_release"})
public final class d
{
  public static final a zAb;
  public ArrayList<y> rho;
  public String zAa;
  public ArrayList<y> zzY;
  public String zzZ;
  
  static
  {
    AppMethodBeat.i(284912);
    zAb = new a((byte)0);
    AppMethodBeat.o(284912);
  }
  
  public d()
  {
    AppMethodBeat.i(284911);
    this.zzY = new ArrayList();
    this.rho = new ArrayList();
    this.zzZ = "";
    this.zAa = "";
    AppMethodBeat.o(284911);
  }
  
  public final void aDr(String paramString)
  {
    AppMethodBeat.i(284909);
    p.k(paramString, "<set-?>");
    this.zzZ = paramString;
    AppMethodBeat.o(284909);
  }
  
  public final void aDs(String paramString)
  {
    AppMethodBeat.i(284910);
    p.k(paramString, "<set-?>");
    this.zAa = paramString;
    AppMethodBeat.o(284910);
  }
  
  public final void al(ArrayList<y> paramArrayList)
  {
    AppMethodBeat.i(284907);
    p.k(paramArrayList, "<set-?>");
    this.zzY = paramArrayList;
    AppMethodBeat.o(284907);
  }
  
  public final void am(ArrayList<y> paramArrayList)
  {
    AppMethodBeat.i(284908);
    p.k(paramArrayList, "<set-?>");
    this.rho = paramArrayList;
    AppMethodBeat.o(284908);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/DiffLiveList$Companion;", "", "()V", "diff", "Lcom/tencent/mm/plugin/finder/model/DiffLiveList;", "localList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "remoteList", "getLiveListUsername", "", "list", "parseLiveListUsername", "plugin-finder_release"})
  public static final class a
  {
    public static ArrayList<String> aDt(String paramString)
    {
      AppMethodBeat.i(228974);
      p.k(paramString, "list");
      localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        int j = localJSONArray.length();
        int i = 0;
        while (i < j)
        {
          String str = localJSONArray.optString(i);
          paramString = str;
          if (str == null) {
            paramString = "";
          }
          localArrayList.add(paramString);
          i += 1;
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        Log.e("FinderFeedLiveList", paramString.getMessage());
        AppMethodBeat.o(228974);
      }
    }
    
    public static String an(ArrayList<y> paramArrayList)
    {
      AppMethodBeat.i(228972);
      Object localObject = (Collection)paramArrayList;
      if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(228972);
        return "";
      }
      localObject = new JSONArray();
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      while (localIterator.hasNext())
      {
        paramArrayList = (y)localIterator.next();
        if ((paramArrayList instanceof y))
        {
          paramArrayList = paramArrayList.zAF.contact;
          if (paramArrayList != null) {}
          for (paramArrayList = paramArrayList.username;; paramArrayList = null)
          {
            ((JSONArray)localObject).put(paramArrayList);
            break;
          }
        }
      }
      paramArrayList = ((JSONArray)localObject).toString();
      p.j(paramArrayList, "array.toString()");
      AppMethodBeat.o(228972);
      return paramArrayList;
    }
    
    public static d h(ArrayList<y> paramArrayList1, ArrayList<y> paramArrayList2)
    {
      AppMethodBeat.i(228965);
      d locald = new d();
      if ((paramArrayList1 == null) && (paramArrayList2 == null))
      {
        AppMethodBeat.o(228965);
        return locald;
      }
      if ((paramArrayList1 == null) && (paramArrayList2 != null))
      {
        locald.al(paramArrayList2);
        locald.aDr(an(paramArrayList2));
        Log.i("FinderFeedLiveList", "[updateLiveList]increment list:".concat(String.valueOf(paramArrayList2)));
        AppMethodBeat.o(228965);
        return locald;
      }
      if ((paramArrayList1 != null) && (paramArrayList2 == null))
      {
        locald.am(paramArrayList1);
        locald.aDs(an(paramArrayList1));
        Log.i("FinderFeedLiveList", "[updateLiveList]remove list:".concat(String.valueOf(paramArrayList1)));
        AppMethodBeat.o(228965);
        return locald;
      }
      if (paramArrayList1 == null) {
        p.iCn();
      }
      ArrayList localArrayList = new ArrayList((Collection)paramArrayList1);
      paramArrayList1 = new ArrayList((Collection)paramArrayList1);
      if (paramArrayList2 == null) {
        p.iCn();
      }
      paramArrayList2 = new ArrayList((Collection)paramArrayList2);
      localArrayList.retainAll((Collection)paramArrayList2);
      paramArrayList1.removeAll((Collection)localArrayList);
      paramArrayList2.removeAll((Collection)localArrayList);
      Log.i("FinderFeedLiveList", "[updateLiveList]mix list:".concat(String.valueOf(localArrayList)));
      Log.i("FinderFeedLiveList", "[updateLiveList]remove list:".concat(String.valueOf(paramArrayList1)));
      Log.i("FinderFeedLiveList", "[updateLiveList]increment list:".concat(String.valueOf(paramArrayList2)));
      locald.am(paramArrayList1);
      locald.al(paramArrayList2);
      locald.aDs(an(paramArrayList1));
      locald.aDr(an(paramArrayList2));
      AppMethodBeat.o(228965);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.d
 * JD-Core Version:    0.7.0.1
 */