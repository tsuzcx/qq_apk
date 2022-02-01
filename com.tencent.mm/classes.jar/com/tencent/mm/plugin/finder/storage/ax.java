package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/StgUtil;", "", "()V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
{
  public static final a FMH;
  
  static
  {
    AppMethodBeat.i(167041);
    FMH = new a((byte)0);
    AppMethodBeat.o(167041);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/StgUtil$Companion;", "", "()V", "buildLimitString", "", "data", "", "", "col", "reverse", "", "createLocalMediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getORIntRange", "Ljava/util/ArrayList;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static ArrayList<Integer> hA(List<Integer> paramList)
    {
      AppMethodBeat.i(339008);
      s.u(paramList, "data");
      Object localObject = new ArrayList((Collection)paramList);
      paramList = new HashSet();
      ArrayList localArrayList1 = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          int i = ((Integer)localIterator.next()).intValue();
          s.s(localInteger, "i");
          localArrayList2.add(Integer.valueOf(i | localInteger.intValue()));
        }
        paramList.addAll((Collection)new HashSet((Collection)localArrayList2));
        paramList.add(localInteger);
      }
      paramList.add(Integer.valueOf(0));
      localArrayList1.addAll((Collection)paramList);
      AppMethodBeat.o(339008);
      return localArrayList1;
    }
    
    public static String t(List<Integer> paramList, String paramString)
    {
      AppMethodBeat.i(167039);
      s.u(paramList, "data");
      s.u(paramString, "col");
      paramList = u(paramList, paramString);
      AppMethodBeat.o(167039);
      return paramList;
    }
    
    private static String u(List<Integer> paramList, String paramString)
    {
      AppMethodBeat.i(167040);
      s.u(paramList, "data");
      s.u(paramString, "col");
      StringBuilder localStringBuilder = new StringBuilder("(");
      localStringBuilder.append(s.X(paramString, " in ("));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localStringBuilder.append(((Number)paramList.next()).intValue());
        if (paramList.hasNext()) {
          localStringBuilder.append(",");
        }
      }
      localStringBuilder.append(")");
      localStringBuilder.append(")");
      paramList = localStringBuilder.toString();
      s.s(paramList, "sb.toString()");
      AppMethodBeat.o(167040);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ax
 * JD-Core Version:    0.7.0.1
 */