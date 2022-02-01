package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/StgUtil;", "", "()V", "Companion", "plugin-finder_release"})
public final class ao
{
  public static final a AmN;
  
  static
  {
    AppMethodBeat.i(167041);
    AmN = new a((byte)0);
    AppMethodBeat.o(167041);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/StgUtil$Companion;", "", "()V", "buildLimitString", "", "data", "", "", "col", "reverse", "", "createLocalMediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getORIntRange", "Ljava/util/ArrayList;", "plugin-finder_release"})
  public static final class a
  {
    public static ArrayList<Integer> eO(List<Integer> paramList)
    {
      AppMethodBeat.i(269558);
      p.k(paramList, "data");
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
          p.j(localInteger, "i");
          localArrayList2.add(Integer.valueOf(i | localInteger.intValue()));
        }
        paramList.addAll((Collection)new HashSet((Collection)localArrayList2));
        paramList.add(localInteger);
      }
      paramList.add(Integer.valueOf(0));
      localArrayList1.addAll((Collection)paramList);
      AppMethodBeat.o(269558);
      return localArrayList1;
    }
    
    public static String m(List<Integer> paramList, String paramString)
    {
      AppMethodBeat.i(167039);
      p.k(paramList, "data");
      p.k(paramString, "col");
      paramList = n(paramList, paramString);
      AppMethodBeat.o(167039);
      return paramList;
    }
    
    private static String n(List<Integer> paramList, String paramString)
    {
      AppMethodBeat.i(167040);
      p.k(paramList, "data");
      p.k(paramString, "col");
      StringBuilder localStringBuilder = new StringBuilder("(");
      localStringBuilder.append(paramString + " in (");
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
      p.j(paramList, "sb.toString()");
      AppMethodBeat.o(167040);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ao
 * JD-Core Version:    0.7.0.1
 */