package com.tencent.mm.plugin.finder.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderShareJumpData;", "", "()V", "TAG", "", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getCardBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setCardBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "dataList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "tabType", "getTabType", "setTabType", "clear", "", "getShareData", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "handleRedDot", "context", "Landroid/content/Context;", "indexInTimeLine", "objectActions", "objectAction", "position", "report20411", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "currUI", "path", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "report23587", "contextId", "setData", "finerObjects", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "useShareData", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cn
{
  private static b AEA;
  public static final cn AMo;
  private static List<? extends FinderItem> dataList;
  private static int hJx;
  private static int index;
  
  static
  {
    AppMethodBeat.i(350007);
    AMo = new cn();
    hJx = -1;
    index = -1;
    AppMethodBeat.o(350007);
  }
  
  public static boolean Nk(int paramInt)
  {
    AppMethodBeat.i(349989);
    if (hJx == paramInt)
    {
      Collection localCollection = (Collection)dataList;
      if ((localCollection == null) || (localCollection.isEmpty())) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        AppMethodBeat.o(349989);
        return true;
      }
    }
    AppMethodBeat.o(349989);
    return false;
  }
  
  public static void a(i parami, String paramString1, String paramString2)
  {
    AppMethodBeat.i(350001);
    p localp = parami.Su(paramString1);
    parami = parami.avp(paramString1);
    if ((localp != null) && (parami != null))
    {
      paramString1 = w.FrV;
      w.a(localp, parami, 5, paramString2);
    }
    AppMethodBeat.o(350001);
  }
  
  public static void a(List<? extends FinderObject> paramList, List<Integer> paramList1, b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    AppMethodBeat.i(349969);
    s.u(paramList, "finerObjects");
    s.u(paramList1, "objectActions");
    List localList = (List)new ArrayList();
    Object localObject = paramList1.iterator();
    int i = 0;
    for (;;)
    {
      int j;
      if (((Iterator)localObject).hasNext())
      {
        j = i + 1;
        if (((Number)((Iterator)localObject).next()).intValue() == paramInt2)
        {
          localList.add(paramList.get(i));
          i = j;
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        dataList = com.tencent.mm.plugin.finder.storage.logic.d.a.K(localList, 4096);
        index = k(paramList1, paramInt2, paramInt3);
        AEA = paramb;
        hJx = paramInt1;
        paramList1 = new StringBuilder("finerObjects.size=").append(paramList.size()).append(" objectActions.size=").append(paramList1.size()).append(" tabType=").append(paramInt1).append(" position=").append(paramInt3).append(" dataList.size=");
        paramList = dataList;
        if (paramList == null) {}
        for (paramList = null;; paramList = Integer.valueOf(paramList.size()))
        {
          Log.i("Finder.FinderShareJumpData", paramList + " index=" + index);
          paramList = (Collection)dataList;
          if (paramList != null)
          {
            paramInt2 = k;
            if (!paramList.isEmpty()) {}
          }
          else
          {
            paramInt2 = 1;
          }
          if (paramInt2 == 0)
          {
            paramList = k.aeZF;
            paramList = ((com.tencent.mm.plugin.finder.viewmodel.d)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(paramInt1);
            paramList.a(d.d.GKO);
            paramList.GKz = System.currentTimeMillis();
          }
          AppMethodBeat.o(349969);
          return;
        }
      }
      i = j;
    }
  }
  
  public static void clear()
  {
    dataList = null;
    AEA = null;
    hJx = -1;
    index = -1;
  }
  
  public static b dXZ()
  {
    return AEA;
  }
  
  public static void dYa()
  {
    index = 0;
  }
  
  public static List<cc> dYb()
  {
    AppMethodBeat.i(349984);
    List localList = (List)new ArrayList();
    Object localObject = dataList;
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      i = 0;
    }
    for (;;)
    {
      int j;
      if (((Iterator)localObject).hasNext())
      {
        j = i + 1;
        FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
        FinderObjectDesc localFinderObjectDesc = localFinderItem.getFeedObject().objectDesc;
        if (localFinderObjectDesc != null)
        {
          if (2 == localFinderObjectDesc.mediaType)
          {
            localList.add(i, new v(localFinderItem));
            i = j;
            continue;
          }
          localList.add(i, new ah(localFinderItem));
          i = j;
        }
      }
      else
      {
        AppMethodBeat.o(349984);
        return localList;
      }
      i = j;
    }
  }
  
  public static int getIndex()
  {
    return index;
  }
  
  public static int getTabType()
  {
    return hJx;
  }
  
  private static int k(List<Integer> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(349975);
    s.u(paramList, "objectActions");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    int k = -1;
    int j;
    for (int m = 0; paramList.hasNext(); m = j)
    {
      int n = k;
      j = m;
      if (((Number)paramList.next()).intValue() == paramInt1)
      {
        m += 1;
        n = k;
        j = m;
        if (k == -1)
        {
          n = i;
          j = m;
        }
      }
      i += 1;
      k = n;
    }
    switch (m)
    {
    default: 
      AppMethodBeat.o(349975);
      return -1;
    case 1: 
      AppMethodBeat.o(349975);
      return 0;
    case 2: 
      if (k == 0)
      {
        AppMethodBeat.o(349975);
        return paramInt2;
      }
      AppMethodBeat.o(349975);
      return paramInt2 - 1;
    }
    AppMethodBeat.o(349975);
    return paramInt2;
  }
  
  public static void setTabType(int paramInt)
  {
    hJx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cn
 * JD-Core Version:    0.7.0.1
 */