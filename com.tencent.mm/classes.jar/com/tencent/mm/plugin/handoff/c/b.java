package com.tencent.mm.plugin.handoff.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"bundle", "Landroid/os/Bundle;", "initFun", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "bundleOf", "pairs", "", "Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "([Lcom/tencent/mm/plugin/handoff/service/BundlePair;)Landroid/os/Bundle;", "bundleTo", "", "value", "Landroid/os/Parcelable;", "n", "Ljava/lang/Void;", "(Ljava/lang/String;[Landroid/os/Parcelable;)Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "", "(Ljava/lang/String;[Ljava/lang/CharSequence;)Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "set", "key", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/CharSequence;)V", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/String;)V", "", "plugin-handoff_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final Bundle a(c... paramVarArgs)
  {
    AppMethodBeat.i(266227);
    s.u(paramVarArgs, "pairs");
    Bundle localBundle = new Bundle();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      c localc = paramVarArgs[i];
      s.u(localBundle, "bundle");
      localc.auu.invoke(localBundle);
      i += 1;
    }
    AppMethodBeat.o(266227);
    return localBundle;
  }
  
  public static final void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    AppMethodBeat.i(266237);
    s.u(paramBundle, "<this>");
    s.u(paramString1, "key");
    s.u(paramString2, "value");
    paramBundle.putString(paramString1, paramString2);
    AppMethodBeat.o(266237);
  }
  
  public static final c jw(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(266233);
    s.u(paramString1, "<this>");
    s.u(paramString2, "value");
    paramString1 = new c((kotlin.g.a.b)new c(paramString1, paramString2));
    AppMethodBeat.o(266233);
    return paramString1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/os/Bundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Bundle, ah>
  {
    c(String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.b
 * JD-Core Version:    0.7.0.1
 */