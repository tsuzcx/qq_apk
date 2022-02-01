package com.tencent.mm.plugin.expt.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ne;
import com.tencent.mm.hellhoundlib.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final Map<String, List<Pair<String, String>>> zxJ;
  private static final com.tencent.mm.hellhoundlib.a.b zxK;
  
  static
  {
    AppMethodBeat.i(299563);
    zxJ = new HashMap();
    zxK = new com.tencent.mm.hellhoundlib.a.b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(299544);
        paramAnonymousString1 = new ne();
        paramAnonymousString1.hPu.action = 1;
        paramAnonymousString1.publish();
        AppMethodBeat.o(299544);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(299535);
        paramAnonymousString1 = new ne();
        paramAnonymousString1.hPu.action = 0;
        paramAnonymousString1.publish();
        AppMethodBeat.o(299535);
      }
    };
    AppMethodBeat.o(299563);
  }
  
  public static void ayW()
  {
    AppMethodBeat.i(299557);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("killProcess", "(I)V"));
    zxJ.put("android/os/Process", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("exit", "(I)V"));
    zxJ.put("java/lang/System", localArrayList);
    a.aYh();
    a.a(zxJ, zxK);
    AppMethodBeat.o(299557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b
 * JD-Core Version:    0.7.0.1
 */