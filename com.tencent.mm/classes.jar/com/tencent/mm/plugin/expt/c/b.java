package com.tencent.mm.plugin.expt.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ly;
import com.tencent.mm.hellhoundlib.a;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final Map<String, List<Pair<String, String>>> wcO;
  private static final com.tencent.mm.hellhoundlib.a.b wcP;
  
  static
  {
    AppMethodBeat.i(254158);
    wcO = new HashMap();
    wcP = new com.tencent.mm.hellhoundlib.a.b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject)
      {
        AppMethodBeat.i(251152);
        paramAnonymousString1 = new ly();
        paramAnonymousString1.fJO.action = 1;
        EventCenter.instance.publish(paramAnonymousString1);
        AppMethodBeat.o(251152);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(251151);
        paramAnonymousString1 = new ly();
        paramAnonymousString1.fJO.action = 0;
        EventCenter.instance.publish(paramAnonymousString1);
        AppMethodBeat.o(251151);
      }
    };
    AppMethodBeat.o(254158);
  }
  
  public static void Xr()
  {
    AppMethodBeat.i(254157);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("killProcess", "(I)V"));
    wcO.put("android/os/Process", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("exit", "(I)V"));
    wcO.put("java/lang/System", localArrayList);
    a.aFg();
    a.a(wcO, wcP);
    AppMethodBeat.o(254157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.b
 * JD-Core Version:    0.7.0.1
 */