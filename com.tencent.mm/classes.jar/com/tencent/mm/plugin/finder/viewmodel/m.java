package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.protocal.protobuf.bxq;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderWxMessageTabStateCacheVM;", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStateCacheVM;", "()V", "getEnterTabIndex", "", "type", "setRedDotFlags", "", "redDotFlags", "", "", "([Ljava/lang/Boolean;)V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends g
{
  public static final a GLD;
  
  static
  {
    AppMethodBeat.i(337170);
    GLD = new a((byte)0);
    AppMethodBeat.o(337170);
  }
  
  public final int Va(int paramInt)
  {
    AppMethodBeat.i(337187);
    paramInt = super.Va(paramInt);
    AppMethodBeat.o(337187);
    return paramInt;
  }
  
  protected final void a(Boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(337208);
    s.u(paramArrayOfBoolean, "redDotFlags");
    bxq localbxq1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("WxMessageLike");
    bxq localbxq2 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("WxMessageComment");
    paramArrayOfBoolean[0] = Boolean.valueOf(c(localbxq1));
    paramArrayOfBoolean[1] = Boolean.valueOf(c(localbxq2));
    AppMethodBeat.o(337208);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderWxMessageTabStateCacheVM$Companion;", "", "()V", "TAG", "", "TYPE_NOTIFY_TAB", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.m
 * JD-Core Version:    0.7.0.1
 */