package com.tencent.mm.plugin.appbrand.game.a;

import a.aa;
import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.j.k;
import a.l;
import a.l.m;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
public final class g$a
{
  static
  {
    AppMethodBeat.i(134631);
    eOJ = new k[] { (k)v.a(new t(v.aG(a.class), "mCommandProcessor", "getMCommandProcessor()Ljava/util/List;")) };
    AppMethodBeat.o(134631);
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(134632);
    j.q(paramContext, "context");
    j.q(paramArrayOfString, "args");
    if (paramArrayOfString.length >= 3) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(134632);
      throw paramContext;
    }
    if ((paramArrayOfString[1] != null) && (paramArrayOfString[0] != null)) {}
    for (i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(134632);
      throw paramContext;
    }
    boolean bool = m.I("//wagame", paramArrayOfString[0], true);
    if ((aa.BMh) && (!bool))
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(134632);
      throw paramContext;
    }
    Iterator localIterator = ((Iterable)g.aAz().getValue()).iterator();
    Object localObject;
    g localg;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
      localg = (g)localObject;
    } while (!m.I(paramArrayOfString[1], localg.aAs(), false));
    for (;;)
    {
      localObject = (g)localObject;
      if (localObject != null) {
        break;
      }
      Toast.makeText(ah.getContext(), (CharSequence)("Unknown config name " + paramArrayOfString[1]), 0).show();
      AppMethodBeat.o(134632);
      return;
      localObject = null;
    }
    ((g)localObject).V(paramContext, paramArrayOfString[2]);
    AppMethodBeat.o(134632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.g.a
 * JD-Core Version:    0.7.0.1
 */