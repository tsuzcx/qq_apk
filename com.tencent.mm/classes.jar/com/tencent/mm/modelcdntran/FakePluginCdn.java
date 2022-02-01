package com.tencent.mm.modelcdntran;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.mvvm.MvvmPlugin;
import com.tencent.mm.kernel.mvvm.e;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelcdntran/FakePluginCdn;", "Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;", "()V", "getLogTag", "", "importPluginComponents", "", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/kernel/mvvm/PluginComponent;", "Lkotlin/collections/HashSet;", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FakePluginCdn
  extends MvvmPlugin
{
  public static final a oAV;
  
  static
  {
    AppMethodBeat.i(237864);
    oAV = new a((byte)0);
    AppMethodBeat.o(237864);
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Cdn.FakePluginCdn";
  }
  
  public final void importPluginComponents(HashSet<Class<? extends e>> paramHashSet)
  {
    AppMethodBeat.i(237869);
    s.u(paramHashSet, "set");
    super.importPluginComponents(paramHashSet);
    paramHashSet.add(a.class);
    AppMethodBeat.o(237869);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelcdntran/FakePluginCdn$Companion;", "", "()V", "TAG", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.FakePluginCdn
 * JD-Core Version:    0.7.0.1
 */