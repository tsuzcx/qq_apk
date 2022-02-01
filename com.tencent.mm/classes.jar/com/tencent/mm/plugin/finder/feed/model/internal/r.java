package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "cmd", "", "insList", "", "isNeedClear", "", "request", "(ILjava/util/List;ZLjava/lang/Object;)V", "getCmd", "()I", "getInsList", "()Ljava/util/List;", "()Z", "getRequest", "()Ljava/lang/Object;", "setRequest", "(Ljava/lang/Object;)V", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r<T extends k>
{
  public static final a BkP;
  final List<T> BkQ;
  final int bUl;
  final boolean isNeedClear;
  Object request;
  
  static
  {
    AppMethodBeat.i(166126);
    BkP = new a((byte)0);
    AppMethodBeat.o(166126);
  }
  
  private r(int paramInt, List<? extends T> paramList, boolean paramBoolean)
  {
    this.bUl = paramInt;
    this.BkQ = paramList;
    this.isNeedClear = paramBoolean;
    this.request = null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp$Companion;", "", "()V", "ADD_LOADMORE", "", "ADD_REFRESH", "ALL_REFRESH", "CLEAN_REFRESH", "INIT", "INSERT", "LOADMORE_THAT_ALL", "PART_REFRESH", "REFRESH_THAT_ALL", "cmd2String", "", "cmd", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String Oe(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.r
 * JD-Core Version:    0.7.0.1
 */