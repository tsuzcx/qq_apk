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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/DiffLiveList;", "", "()V", "incrementList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "getIncrementList", "()Ljava/util/ArrayList;", "setIncrementList", "(Ljava/util/ArrayList;)V", "incrementListUsername", "", "getIncrementListUsername", "()Ljava/lang/String;", "setIncrementListUsername", "(Ljava/lang/String;)V", "removeList", "getRemoveList", "setRemoveList", "removeListUsername", "getRemoveListUsername", "setRemoveListUsername", "Companion", "plugin-finder_release"})
public final class d
{
  public static final a uNN;
  public ArrayList<y> ofD;
  public ArrayList<y> uNK;
  public String uNL;
  public String uNM;
  
  static
  {
    AppMethodBeat.i(248704);
    uNN = new a((byte)0);
    AppMethodBeat.o(248704);
  }
  
  public d()
  {
    AppMethodBeat.i(248703);
    this.uNK = new ArrayList();
    this.ofD = new ArrayList();
    this.uNL = "";
    this.uNM = "";
    AppMethodBeat.o(248703);
  }
  
  public final void ae(ArrayList<y> paramArrayList)
  {
    AppMethodBeat.i(248699);
    p.h(paramArrayList, "<set-?>");
    this.uNK = paramArrayList;
    AppMethodBeat.o(248699);
  }
  
  public final void af(ArrayList<y> paramArrayList)
  {
    AppMethodBeat.i(248700);
    p.h(paramArrayList, "<set-?>");
    this.ofD = paramArrayList;
    AppMethodBeat.o(248700);
  }
  
  public final void auf(String paramString)
  {
    AppMethodBeat.i(248701);
    p.h(paramString, "<set-?>");
    this.uNL = paramString;
    AppMethodBeat.o(248701);
  }
  
  public final void aug(String paramString)
  {
    AppMethodBeat.i(248702);
    p.h(paramString, "<set-?>");
    this.uNM = paramString;
    AppMethodBeat.o(248702);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/DiffLiveList$Companion;", "", "()V", "diff", "Lcom/tencent/mm/plugin/finder/model/DiffLiveList;", "localList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "remoteList", "getLiveListUsername", "", "list", "parseLiveListUsername", "plugin-finder_release"})
  public static final class a
  {
    public static String ag(ArrayList<y> paramArrayList)
    {
      AppMethodBeat.i(248697);
      Object localObject = (Collection)paramArrayList;
      if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(248697);
        return "";
      }
      localObject = new JSONArray();
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      if (localIterator.hasNext())
      {
        paramArrayList = ((y)localIterator.next()).uOo.contact;
        if (paramArrayList != null) {}
        for (paramArrayList = paramArrayList.username;; paramArrayList = null)
        {
          ((JSONArray)localObject).put(paramArrayList);
          break;
        }
      }
      paramArrayList = ((JSONArray)localObject).toString();
      p.g(paramArrayList, "array.toString()");
      AppMethodBeat.o(248697);
      return paramArrayList;
    }
    
    public static ArrayList<String> auh(String paramString)
    {
      AppMethodBeat.i(248698);
      p.h(paramString, "list");
      localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        int j = localJSONArray.length();
        int i = 0;
        Object localObject;
        while (i < j)
        {
          localObject = localJSONArray.optString(i);
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = "";
          }
          localArrayList.add(paramString);
          i += 1;
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        localObject = x.uOn;
        Log.e(x.access$getTAG$cp(), paramString.getMessage());
        AppMethodBeat.o(248698);
      }
    }
    
    public static d f(ArrayList<y> paramArrayList1, ArrayList<y> paramArrayList2)
    {
      AppMethodBeat.i(248696);
      d locald = new d();
      if ((paramArrayList1 == null) && (paramArrayList2 == null))
      {
        AppMethodBeat.o(248696);
        return locald;
      }
      if ((paramArrayList1 == null) && (paramArrayList2 != null))
      {
        locald.ae(paramArrayList2);
        locald.auf(ag(paramArrayList2));
        paramArrayList1 = x.uOn;
        Log.i(x.access$getTAG$cp(), "[updateLiveList]increment list:".concat(String.valueOf(paramArrayList2)));
        AppMethodBeat.o(248696);
        return locald;
      }
      if ((paramArrayList1 != null) && (paramArrayList2 == null))
      {
        locald.af(paramArrayList1);
        locald.aug(ag(paramArrayList1));
        paramArrayList2 = x.uOn;
        Log.i(x.access$getTAG$cp(), "[updateLiveList]remove list:".concat(String.valueOf(paramArrayList1)));
        AppMethodBeat.o(248696);
        return locald;
      }
      if (paramArrayList1 == null) {
        p.hyc();
      }
      Object localObject = new ArrayList((Collection)paramArrayList1);
      paramArrayList1 = new ArrayList((Collection)paramArrayList1);
      if (paramArrayList2 == null) {
        p.hyc();
      }
      paramArrayList2 = new ArrayList((Collection)paramArrayList2);
      ((ArrayList)localObject).retainAll((Collection)paramArrayList2);
      paramArrayList1.removeAll((Collection)localObject);
      paramArrayList2.removeAll((Collection)localObject);
      x.a locala = x.uOn;
      Log.i(x.access$getTAG$cp(), "[updateLiveList]mix list:".concat(String.valueOf(localObject)));
      localObject = x.uOn;
      Log.i(x.access$getTAG$cp(), "[updateLiveList]remove list:".concat(String.valueOf(paramArrayList1)));
      localObject = x.uOn;
      Log.i(x.access$getTAG$cp(), "[updateLiveList]increment list:".concat(String.valueOf(paramArrayList2)));
      locald.af(paramArrayList1);
      locald.ae(paramArrayList2);
      locald.aug(ag(paramArrayList1));
      locald.auf(ag(paramArrayList2));
      AppMethodBeat.o(248696);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.d
 * JD-Core Version:    0.7.0.1
 */