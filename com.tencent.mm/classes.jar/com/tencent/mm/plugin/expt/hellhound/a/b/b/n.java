package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n
{
  private final Map<String, Map<String, List<Pair<String, String>>>> wgt;
  private final d wmk;
  
  public n()
  {
    AppMethodBeat.i(257049);
    this.wgt = new HashMap();
    this.wmk = new d()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(256299);
        if ((TextUtils.isEmpty(paramAnonymousString1)) || (!paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$")))
        {
          AppMethodBeat.o(256299);
          return;
        }
        if ((!"onMMMenuItemSelected".equals(paramAnonymousString2)) || (!"(Landroid/view/MenuItem;I)V".equals(paramAnonymousString3)))
        {
          AppMethodBeat.o(256299);
          return;
        }
        Log.i("HABBYGE-MALI.SnsFinderMonitor", "mSnsFinderListener, runOnExit: %b", new Object[] { Boolean.valueOf(c.wkg) });
        AppMethodBeat.o(256299);
      }
      
      public final void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(256297);
        if ((TextUtils.isEmpty(paramAnonymousString1)) || (!paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$")))
        {
          AppMethodBeat.o(256297);
          return;
        }
        if ((!"onMMMenuItemSelected".equals(paramAnonymousString2)) || (!"(Landroid/view/MenuItem;I)V".equals(paramAnonymousString3)))
        {
          AppMethodBeat.o(256297);
          return;
        }
        if ((paramAnonymousArrayOfObject == null) || (paramAnonymousArrayOfObject.length < 2))
        {
          AppMethodBeat.o(256297);
          return;
        }
        if (!(paramAnonymousArrayOfObject[0] instanceof MenuItem))
        {
          AppMethodBeat.o(256297);
          return;
        }
        int i = ((MenuItem)paramAnonymousArrayOfObject[0]).getItemId();
        if (i == 6) {}
        for (boolean bool = true;; bool = false)
        {
          c.wkg = bool;
          Log.i("HABBYGE-MALI.SnsFinderMonitor", "mSnsFinderListener, runOnEnter: itemId=%d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(c.wkg) });
          AppMethodBeat.o(256297);
          return;
        }
      }
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener", localArrayList);
    this.wgt.put("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$", localHashMap);
    AppMethodBeat.o(257049);
  }
  
  static void c(dhx paramdhx)
  {
    AppMethodBeat.i(257052);
    if (paramdhx == null)
    {
      AppMethodBeat.o(257052);
      return;
    }
    if (("143".equals(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramdhx.sessionId))) && (c.wkg)) {
      Log.d("HABBYGE-MALI.SnsFinderMonitor", "begin19943, sessionId=%s, startTime=%s, endTime=%s", new Object[] { paramdhx.sessionId, Long.valueOf(paramdhx.startTime), Long.valueOf(paramdhx.endTime) });
    }
    AppMethodBeat.o(257052);
  }
  
  static void d(dhx paramdhx)
  {
    AppMethodBeat.i(257053);
    if (paramdhx == null)
    {
      AppMethodBeat.o(257053);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramdhx.sessionId);
    if (("143".equals(str)) && (c.wkg))
    {
      Log.d("HABBYGE-MALI.SnsFinderMonitor", "stop19943, sessionId=%s, startTime=%s, endTime=%s", new Object[] { paramdhx.sessionId, Long.valueOf(paramdhx.startTime), Long.valueOf(paramdhx.endTime) });
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte)0);
      localb.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
      localb.fFe = "All-Sns";
      localb.wmx = paramdhx.startTime;
      localb.wmy = paramdhx.endTime;
      localb.wmw = (paramdhx.endTime - paramdhx.startTime);
      localb.wmz = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
      localb.wmA = str;
      localb.fSe = c.b.wkX.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(localb);
    }
    AppMethodBeat.o(257053);
  }
  
  public final void Xr()
  {
    AppMethodBeat.i(257050);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.e(this.wgt, this.wmk);
    AppMethodBeat.o(257050);
  }
  
  public final void ddy()
  {
    AppMethodBeat.i(257051);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.f(this.wgt, this.wmk);
    AppMethodBeat.o(257051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.n
 * JD-Core Version:    0.7.0.1
 */