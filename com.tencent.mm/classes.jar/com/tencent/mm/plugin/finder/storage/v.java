package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/StgUtil;", "", "()V", "Companion", "plugin-finder_release"})
public final class v
{
  public static final a rEz;
  
  static
  {
    AppMethodBeat.i(167041);
    rEz = new a((byte)0);
    AppMethodBeat.o(167041);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/StgUtil$Companion;", "", "()V", "buildLimitString", "", "data", "", "", "col", "reverse", "", "createLocalMediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getORIntRange", "Ljava/util/ArrayList;", "plugin-finder_release"})
  public static final class a
  {
    public static String j(List<Integer> paramList, String paramString)
    {
      AppMethodBeat.i(167039);
      k.h(paramList, "data");
      k.h(paramString, "col");
      paramList = k(paramList, paramString);
      AppMethodBeat.o(167039);
      return paramList;
    }
    
    private static String k(List<Integer> paramList, String paramString)
    {
      AppMethodBeat.i(167040);
      k.h(paramList, "data");
      k.h(paramString, "col");
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
      k.g(paramList, "sb.toString()");
      AppMethodBeat.o(167040);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.v
 * JD-Core Version:    0.7.0.1
 */