package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n
{
  private final Map<String, Map<String, List<Pair<String, String>>>> sAz;
  private final com.tencent.mm.hellhoundlib.a.c sGp;
  
  public n()
  {
    AppMethodBeat.i(220528);
    this.sAz = new HashMap();
    this.sGp = new com.tencent.mm.hellhoundlib.a.c()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(220527);
        if ((TextUtils.isEmpty(paramAnonymousString1)) || (!paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$")))
        {
          AppMethodBeat.o(220527);
          return;
        }
        if ((!"onMMMenuItemSelected".equals(paramAnonymousString2)) || (!"(Landroid/view/MenuItem;I)V".equals(paramAnonymousString3)))
        {
          AppMethodBeat.o(220527);
          return;
        }
        Log.i("HABBYGE-MALI.SnsFinderMonitor", "mSnsFinderListener, runOnExit: %b", new Object[] { Boolean.valueOf(c.sEl) });
        AppMethodBeat.o(220527);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(220526);
        if ((TextUtils.isEmpty(paramAnonymousString1)) || (!paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$")))
        {
          AppMethodBeat.o(220526);
          return;
        }
        if ((!"onMMMenuItemSelected".equals(paramAnonymousString2)) || (!"(Landroid/view/MenuItem;I)V".equals(paramAnonymousString3)))
        {
          AppMethodBeat.o(220526);
          return;
        }
        if ((paramAnonymousArrayOfObject == null) || (paramAnonymousArrayOfObject.length < 2))
        {
          AppMethodBeat.o(220526);
          return;
        }
        if (!(paramAnonymousArrayOfObject[0] instanceof MenuItem))
        {
          AppMethodBeat.o(220526);
          return;
        }
        int i = ((MenuItem)paramAnonymousArrayOfObject[0]).getItemId();
        if (i == 6) {}
        for (boolean bool = true;; bool = false)
        {
          c.sEl = bool;
          Log.i("HABBYGE-MALI.SnsFinderMonitor", "mSnsFinderListener, runOnEnter: itemId=%d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(c.sEl) });
          AppMethodBeat.o(220526);
          return;
        }
      }
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener", localArrayList);
    this.sAz.put("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$", localHashMap);
    AppMethodBeat.o(220528);
  }
  
  static void c(cyl paramcyl)
  {
    AppMethodBeat.i(220531);
    if (paramcyl == null)
    {
      AppMethodBeat.o(220531);
      return;
    }
    if (("143".equals(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcyl.sessionId))) && (c.sEl)) {
      Log.d("HABBYGE-MALI.SnsFinderMonitor", "begin19943, sessionId=%s, startTime=%s, endTime=%s", new Object[] { paramcyl.sessionId, Long.valueOf(paramcyl.startTime), Long.valueOf(paramcyl.endTime) });
    }
    AppMethodBeat.o(220531);
  }
  
  static void d(cyl paramcyl)
  {
    AppMethodBeat.i(220532);
    if (paramcyl == null)
    {
      AppMethodBeat.o(220532);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcyl.sessionId);
    if (("143".equals(str)) && (c.sEl))
    {
      Log.d("HABBYGE-MALI.SnsFinderMonitor", "stop19943, sessionId=%s, startTime=%s, endTime=%s", new Object[] { paramcyl.sessionId, Long.valueOf(paramcyl.startTime), Long.valueOf(paramcyl.endTime) });
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte)0);
      localb.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
      localb.dMl = "All-Sns";
      localb.sGC = paramcyl.startTime;
      localb.sGD = paramcyl.endTime;
      localb.sGB = (paramcyl.endTime - paramcyl.startTime);
      localb.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
      localb.sGF = str;
      localb.dYn = c.b.sFc.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(localb);
    }
    AppMethodBeat.o(220532);
  }
  
  public final void cMH()
  {
    AppMethodBeat.i(220529);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.e(this.sAz, this.sGp);
    AppMethodBeat.o(220529);
  }
  
  public final void cOG()
  {
    AppMethodBeat.i(220530);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.f(this.sAz, this.sGp);
    AppMethodBeat.o(220530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.n
 * JD-Core Version:    0.7.0.1
 */