package com.tencent.mm.plugin.handoff.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"bundle", "Landroid/os/Bundle;", "initFun", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "bundleOf", "pairs", "", "Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "([Lcom/tencent/mm/plugin/handoff/service/BundlePair;)Landroid/os/Bundle;", "bundleTo", "", "value", "Landroid/os/Parcelable;", "n", "Ljava/lang/Void;", "(Ljava/lang/String;[Landroid/os/Parcelable;)Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "", "(Ljava/lang/String;[Ljava/lang/CharSequence;)Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "set", "key", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/CharSequence;)V", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/String;)V", "", "plugin-handoff_release"})
public final class b
{
  public static final Bundle a(c... paramVarArgs)
  {
    AppMethodBeat.i(199154);
    p.h(paramVarArgs, "pairs");
    Bundle localBundle = new Bundle();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      c localc = paramVarArgs[i];
      p.h(localBundle, "bundle");
      localc.yhT.invoke(localBundle);
      i += 1;
    }
    AppMethodBeat.o(199154);
    return localBundle;
  }
  
  public static final void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    AppMethodBeat.i(199156);
    p.h(paramBundle, "$this$set");
    p.h(paramString1, "key");
    p.h(paramString2, "value");
    paramBundle.putString(paramString1, paramString2);
    AppMethodBeat.o(199156);
  }
  
  public static final c ig(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(199155);
    p.h(paramString1, "$this$bundleTo");
    p.h(paramString2, "value");
    paramString1 = new c((kotlin.g.a.b)new c(paramString1, paramString2));
    AppMethodBeat.o(199155);
    return paramString1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Bundle, x>
  {
    c(String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.b
 * JD-Core Version:    0.7.0.1
 */