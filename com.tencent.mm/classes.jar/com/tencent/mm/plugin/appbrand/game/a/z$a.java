package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z$a
{
  public static void a(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(50391);
    s.u(paramContext, "context");
    s.u(paramArrayOfString, "args");
    if (paramArrayOfString.length >= 3) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50391);
      throw paramContext;
    }
    if ((paramArrayOfString[1] != null) && (paramArrayOfString[0] != null)) {}
    for (i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50391);
      throw paramContext;
    }
    boolean bool = n.T("//wagame", paramArrayOfString[0], true);
    if ((ak.aiuY) && (!bool))
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50391);
      throw paramContext;
    }
    Iterator localIterator = ((Iterable)z.coQ().getValue()).iterator();
    Object localObject;
    z localz;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
      localz = (z)localObject;
    } while (!n.T(paramArrayOfString[1], localz.coJ(), false));
    for (;;)
    {
      localObject = (z)localObject;
      if (localObject != null) {
        break;
      }
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)s.X("Unknown config name ", paramArrayOfString[1]), 0).show();
      AppMethodBeat.o(50391);
      return;
      localObject = null;
    }
    ((z)localObject).Z(paramContext, paramArrayOfString[2]);
    AppMethodBeat.o(50391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.z.a
 * JD-Core Version:    0.7.0.1
 */