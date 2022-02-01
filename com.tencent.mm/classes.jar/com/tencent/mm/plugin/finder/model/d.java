package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/DiffLiveList;", "", "()V", "incrementList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "getIncrementList", "()Ljava/util/ArrayList;", "setIncrementList", "(Ljava/util/ArrayList;)V", "incrementListUsername", "", "getIncrementListUsername", "()Ljava/lang/String;", "setIncrementListUsername", "(Ljava/lang/String;)V", "removeList", "getRemoveList", "setRemoveList", "removeListUsername", "getRemoveListUsername", "setRemoveListUsername", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a ECf;
  public ArrayList<z> ECg;
  public String ECh;
  public String ECi;
  public ArrayList<z> upm;
  
  static
  {
    AppMethodBeat.i(332164);
    ECf = new a((byte)0);
    AppMethodBeat.o(332164);
  }
  
  public d()
  {
    AppMethodBeat.i(332159);
    this.ECg = new ArrayList();
    this.upm = new ArrayList();
    this.ECh = "";
    this.ECi = "";
    AppMethodBeat.o(332159);
  }
  
  public final void as(ArrayList<z> paramArrayList)
  {
    AppMethodBeat.i(332171);
    s.u(paramArrayList, "<set-?>");
    this.ECg = paramArrayList;
    AppMethodBeat.o(332171);
  }
  
  public final void at(ArrayList<z> paramArrayList)
  {
    AppMethodBeat.i(332178);
    s.u(paramArrayList, "<set-?>");
    this.upm = paramArrayList;
    AppMethodBeat.o(332178);
  }
  
  public final void ayN(String paramString)
  {
    AppMethodBeat.i(332182);
    s.u(paramString, "<set-?>");
    this.ECh = paramString;
    AppMethodBeat.o(332182);
  }
  
  public final void ayO(String paramString)
  {
    AppMethodBeat.i(332188);
    s.u(paramString, "<set-?>");
    this.ECi = paramString;
    AppMethodBeat.o(332188);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/DiffLiveList$Companion;", "", "()V", "diff", "Lcom/tencent/mm/plugin/finder/model/DiffLiveList;", "localList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "remoteList", "getLiveListUsername", "", "list", "parseLiveListUsername", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String au(ArrayList<z> paramArrayList)
    {
      AppMethodBeat.i(331858);
      Object localObject = (Collection)paramArrayList;
      if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(331858);
        return "";
      }
      localObject = new JSONArray();
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      while (localIterator.hasNext())
      {
        paramArrayList = (z)localIterator.next();
        if ((paramArrayList instanceof z))
        {
          paramArrayList = paramArrayList.ECN.contact;
          if (paramArrayList == null) {}
          for (paramArrayList = null;; paramArrayList = paramArrayList.username)
          {
            ((JSONArray)localObject).put(paramArrayList);
            break;
          }
        }
      }
      paramArrayList = ((JSONArray)localObject).toString();
      s.s(paramArrayList, "array.toString()");
      AppMethodBeat.o(331858);
      return paramArrayList;
    }
    
    public static ArrayList<String> ayP(String paramString)
    {
      AppMethodBeat.i(331866);
      s.u(paramString, "list");
      ArrayList localArrayList = new ArrayList();
      try
      {
        localJSONArray = new JSONArray(paramString);
        k = localJSONArray.length();
        i = 0;
        if (k <= 0) {
          break label77;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          JSONArray localJSONArray;
          int k;
          int j;
          String str;
          Log.e("FinderFeedLiveList", paramString.getMessage());
          continue;
          int i = j;
        }
      }
      j = i + 1;
      str = localJSONArray.optString(i);
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      localArrayList.add(paramString);
      if (j >= k)
      {
        label77:
        AppMethodBeat.o(331866);
        return localArrayList;
      }
    }
    
    public static d i(ArrayList<z> paramArrayList1, ArrayList<z> paramArrayList2)
    {
      AppMethodBeat.i(331846);
      d locald = new d();
      if ((paramArrayList1 == null) && (paramArrayList2 == null))
      {
        AppMethodBeat.o(331846);
        return locald;
      }
      if ((paramArrayList1 == null) && (paramArrayList2 != null))
      {
        locald.as(paramArrayList2);
        locald.ayN(au(paramArrayList2));
        Log.i("FinderFeedLiveList", s.X("[updateLiveList]increment list:", paramArrayList2));
        AppMethodBeat.o(331846);
        return locald;
      }
      if ((paramArrayList1 != null) && (paramArrayList2 == null))
      {
        locald.at(paramArrayList1);
        locald.ayO(au(paramArrayList1));
        Log.i("FinderFeedLiveList", s.X("[updateLiveList]remove list:", paramArrayList1));
        AppMethodBeat.o(331846);
        return locald;
      }
      s.checkNotNull(paramArrayList1);
      ArrayList localArrayList = new ArrayList((Collection)paramArrayList1);
      paramArrayList1 = new ArrayList((Collection)paramArrayList1);
      s.checkNotNull(paramArrayList2);
      paramArrayList2 = new ArrayList((Collection)paramArrayList2);
      localArrayList.retainAll((Collection)paramArrayList2);
      paramArrayList1.removeAll((Collection)localArrayList);
      paramArrayList2.removeAll((Collection)localArrayList);
      Log.i("FinderFeedLiveList", s.X("[updateLiveList]mix list:", localArrayList));
      Log.i("FinderFeedLiveList", s.X("[updateLiveList]remove list:", paramArrayList1));
      Log.i("FinderFeedLiveList", s.X("[updateLiveList]increment list:", paramArrayList2));
      locald.at(paramArrayList1);
      locald.as(paramArrayList2);
      locald.ayO(au(paramArrayList1));
      locald.ayN(au(paramArrayList2));
      AppMethodBeat.o(331846);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.d
 * JD-Core Version:    0.7.0.1
 */