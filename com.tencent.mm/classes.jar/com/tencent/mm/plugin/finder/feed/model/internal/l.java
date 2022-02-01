package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "cmd", "", "insList", "", "isNeedClear", "", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "(ILjava/util/List;ZLcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;)V", "getCmd", "()I", "getInsList", "()Ljava/util/List;", "()Z", "getRequest", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "setRequest", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;)V", "Companion", "plugin-finder_release"})
public final class l<T extends i>
{
  public static final a qzA;
  final int BX;
  final boolean isNeedClear;
  final List<T> qzz;
  j request;
  
  static
  {
    AppMethodBeat.i(166126);
    qzA = new a((byte)0);
    AppMethodBeat.o(166126);
  }
  
  private l(int paramInt, List<? extends T> paramList, boolean paramBoolean)
  {
    this.BX = paramInt;
    this.qzz = paramList;
    this.isNeedClear = paramBoolean;
    this.request = null;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp$Companion;", "", "()V", "ADD_LOADMORE", "", "ADD_REFRESH", "ALL_REFRESH", "CLEAN_REFRESH", "INIT", "INSERT", "LOADMORE_THAT_ALL", "REFRESH_THAT_ALL", "cmd2String", "", "cmd", "plugin-finder_release"})
  public static final class a
  {
    public static String CI(int paramInt)
    {
      switch (paramInt)
      {
      case 7: 
      default: 
        return "UNKNOWN";
      case 1: 
        return "ADD_LOADMORE";
      case 2: 
        return "ADD_REFRESH";
      case 3: 
        return "INIT";
      case 4: 
        return "CLEAN_REFRESH";
      case 5: 
        return "LOADMORE_THAT_ALL";
      case 6: 
        return "REFRESH_THAT_ALL";
      }
      return "INSERT";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.l
 * JD-Core Version:    0.7.0.1
 */