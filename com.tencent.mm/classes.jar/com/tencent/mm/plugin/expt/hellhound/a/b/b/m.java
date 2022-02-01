package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m
{
  private Map<String, Map<String, List<Pair<String, String>>>> rai;
  private final com.tencent.mm.hellhoundlib.a.c reZ;
  
  public m()
  {
    AppMethodBeat.i(196098);
    this.rai = new HashMap();
    this.reZ = new com.tencent.mm.hellhoundlib.a.c()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(196097);
        if ((TextUtils.isEmpty(paramAnonymousString1)) || (!paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$")))
        {
          AppMethodBeat.o(196097);
          return;
        }
        if ((!"onMMMenuItemSelected".equals(paramAnonymousString2)) || (!"(Landroid/view/MenuItem;I)V".equals(paramAnonymousString3)))
        {
          AppMethodBeat.o(196097);
          return;
        }
        ae.i("HABBYGE-MALI.SnsFinderMonitor", "mSnsFinderListener, runOnExit: %b", new Object[] { Boolean.valueOf(c.rdE) });
        AppMethodBeat.o(196097);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(196096);
        if ((TextUtils.isEmpty(paramAnonymousString1)) || (!paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$")))
        {
          AppMethodBeat.o(196096);
          return;
        }
        if ((!"onMMMenuItemSelected".equals(paramAnonymousString2)) || (!"(Landroid/view/MenuItem;I)V".equals(paramAnonymousString3)))
        {
          AppMethodBeat.o(196096);
          return;
        }
        if ((paramAnonymousArrayOfObject == null) || (paramAnonymousArrayOfObject.length < 2))
        {
          AppMethodBeat.o(196096);
          return;
        }
        if (!(paramAnonymousArrayOfObject[0] instanceof MenuItem))
        {
          AppMethodBeat.o(196096);
          return;
        }
        int i = ((MenuItem)paramAnonymousArrayOfObject[0]).getItemId();
        if (i == 6) {}
        for (boolean bool = true;; bool = false)
        {
          c.rdE = bool;
          ae.i("HABBYGE-MALI.SnsFinderMonitor", "mSnsFinderListener, runOnEnter: itemId=%d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(c.rdE) });
          AppMethodBeat.o(196096);
          return;
        }
      }
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener", localArrayList);
    this.rai.put("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$", localHashMap);
    AppMethodBeat.o(196098);
  }
  
  static void c(cie paramcie)
  {
    AppMethodBeat.i(196101);
    if (paramcie == null)
    {
      AppMethodBeat.o(196101);
      return;
    }
    if (("143".equals(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramcie.sessionId))) && (c.rdE)) {
      ae.d("HABBYGE-MALI.SnsFinderMonitor", "begin19943, sessionId=%s, startTime=%s, endTime=%s", new Object[] { paramcie.sessionId, Long.valueOf(paramcie.startTime), Long.valueOf(paramcie.endTime) });
    }
    AppMethodBeat.o(196101);
  }
  
  static void d(cie paramcie)
  {
    AppMethodBeat.i(196102);
    if (paramcie == null)
    {
      AppMethodBeat.o(196102);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramcie.sessionId);
    if (("143".equals(str)) && (c.rdE))
    {
      ae.d("HABBYGE-MALI.SnsFinderMonitor", "stop19943, sessionId=%s, startTime=%s, endTime=%s", new Object[] { paramcie.sessionId, Long.valueOf(paramcie.startTime), Long.valueOf(paramcie.endTime) });
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte)0);
      localb.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
      localb.duQ = "All-Sns";
      localb.rfm = paramcie.startTime;
      localb.rfn = paramcie.endTime;
      localb.rfl = (paramcie.endTime - paramcie.startTime);
      localb.rfo = com.tencent.mm.plugin.expt.hellhound.core.b.cpi();
      localb.rfp = str;
      localb.dGC = c.b.rdZ.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(localb);
    }
    AppMethodBeat.o(196102);
  }
  
  public final void cov()
  {
    AppMethodBeat.i(196099);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.e(this.rai, this.reZ);
    AppMethodBeat.o(196099);
  }
  
  public final void cqo()
  {
    AppMethodBeat.i(196100);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.f(this.rai, this.reZ);
    AppMethodBeat.o(196100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.m
 * JD-Core Version:    0.7.0.1
 */