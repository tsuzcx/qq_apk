package com.tencent.mm.openim.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.a.l;
import com.tencent.mm.openim.api.c;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/util/OpenIMProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final a.a pvL;
  
  static
  {
    AppMethodBeat.i(235733);
    pvL = new a.a((byte)0);
    AppMethodBeat.o(235733);
  }
  
  public static final void init()
  {
    AppMethodBeat.i(235731);
    b.a((com.tencent.mm.pluginsdk.cmd.a)new a(), new String[] { "//im" });
    AppMethodBeat.o(235731);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(235735);
    if ((paramArrayOfString != null) && (s.p("//im", paramArrayOfString[0])) && (s.p("clearContact", paramArrayOfString[1])))
    {
      ((c)h.ax(c.class)).bRW();
      AppMethodBeat.o(235735);
      return true;
    }
    if ((paramArrayOfString != null) && (s.p("//im", paramArrayOfString[0])) && (s.p("testCard", paramArrayOfString[1])))
    {
      paramContext = (c)h.ax(c.class);
      if (Util.safeParseInt(paramArrayOfString[2]) == 1) {
        bool = true;
      }
      paramContext.aj(paramString, bool);
      AppMethodBeat.o(235735);
      return true;
    }
    if ((paramArrayOfString != null) && (s.p("//im", paramArrayOfString[0])) && (s.p("confirm", paramArrayOfString[1])))
    {
      int i = Util.getInt(paramArrayOfString[2], 3);
      paramContext = l.psh;
      l.xG(i);
      AppMethodBeat.o(235735);
      return true;
    }
    AppMethodBeat.o(235735);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.f.a
 * JD-Core Version:    0.7.0.1
 */