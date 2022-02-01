package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/AsyncCallbackStore;", "CALLBACK", "", "()V", "callBackMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getCallBackMap", "()Ljava/util/HashMap;", "getAndRemoveCallback", "identity", "(Ljava/lang/String;)Ljava/lang/Object;", "setCallback", "callback", "(Ljava/lang/Object;)Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b<CALLBACK>
{
  public final HashMap<String, CALLBACK> GfR;
  
  public b()
  {
    AppMethodBeat.i(333736);
    this.GfR = new HashMap();
    AppMethodBeat.o(333736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.b
 * JD-Core Version:    0.7.0.1
 */