package com.tencent.mm.plugin.expt.hellhound.core.b.b.a;

import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  private static b pFd;
  public int hHC;
  private c pEV;
  private a pFe;
  private Map<String, Map<String, List<Pair<String, String>>>> pFf;
  
  private b()
  {
    AppMethodBeat.i(177362);
    this.hHC = -1;
    this.pEV = new c()
    {
      public final void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184336);
        if ("onPostOpen".equals(paramAnonymousString2))
        {
          if (paramAnonymousArrayOfObject.length > 0)
          {
            ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, onPostOpen: %b", new Object[] { paramAnonymousArrayOfObject[0] });
            b.a(b.this, 0, System.currentTimeMillis());
            AppMethodBeat.o(184336);
          }
        }
        else if ("onPostClose".equals(paramAnonymousString2))
        {
          ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, onPostClose:");
          b.a(b.this, 1, System.currentTimeMillis());
        }
        AppMethodBeat.o(184336);
      }
      
      public final void g(String paramAnonymousString, Object paramAnonymousObject) {}
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onPostOpen", "(Z)V"));
    localArrayList.add(Pair.create("onPostClose", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", localArrayList);
    this.pFf = new HashMap();
    this.pFf.put("com/tencent/mm/ui/MoreTabUI$", localHashMap);
    AppMethodBeat.o(177362);
  }
  
  public static int Bs(int paramInt)
  {
    if (paramInt == 0) {
      return 300;
    }
    if (paramInt == 1) {
      return 301;
    }
    return -1;
  }
  
  public static int Bt(int paramInt)
  {
    if (paramInt == 300) {
      return 0;
    }
    if (paramInt == 301) {
      return 1;
    }
    return -1;
  }
  
  private void V(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184337);
    this.hHC = paramInt;
    if (this.pFe != null) {
      this.pFe.U(paramInt, paramLong);
    }
    AppMethodBeat.o(184337);
  }
  
  public static b cbX()
  {
    AppMethodBeat.i(122022);
    if (pFd == null) {}
    try
    {
      if (pFd == null) {
        pFd = new b();
      }
      b localb = pFd;
      AppMethodBeat.o(122022);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122022);
    }
  }
  
  private void cbY()
  {
    AppMethodBeat.i(177363);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.e(this.pFf, this.pEV);
    AppMethodBeat.o(177363);
  }
  
  public final void Z(String paramString, long paramLong)
  {
    AppMethodBeat.i(184338);
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "_finishMMFecordUI: %s", new Object[] { paramString });
    if ("com.tencent.mm.plugin.recordvideo.activity.MMRecordUI".equals(paramString)) {
      V(1, paramLong);
    }
    AppMethodBeat.o(184338);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, a parama)
  {
    AppMethodBeat.i(122023);
    if (!com.tencent.mm.plugin.expt.hellhound.a.cbn())
    {
      ad.w("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, startHook, fetchHellhoundConfig: FALSE");
      AppMethodBeat.o(122023);
      return;
    }
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook");
    paramFragmentActivity = g.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.pDX);
    if (paramFragmentActivity == null)
    {
      ad.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook: curFragment == null");
      AppMethodBeat.o(122023);
      return;
    }
    paramFragmentActivity = paramFragmentActivity.getClass().getCanonicalName();
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook-2: %s", new Object[] { paramFragmentActivity });
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.pDX.equals(paramFragmentActivity))
    {
      ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook Fail: %s", new Object[] { paramFragmentActivity });
      AppMethodBeat.o(122023);
      return;
    }
    this.pFe = parama;
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook real: %s", new Object[] { paramFragmentActivity });
    cbY();
    AppMethodBeat.o(122023);
  }
  
  public final void d(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(122024);
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, endHook");
    paramFragmentActivity = g.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.pDX);
    if (paramFragmentActivity == null)
    {
      ad.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, curFragment == null");
      AppMethodBeat.o(122024);
      return;
    }
    paramFragmentActivity = paramFragmentActivity.getClass().getCanonicalName();
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.pDX.equals(paramFragmentActivity))
    {
      ad.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor endHook FALSE: %s", new Object[] { paramFragmentActivity });
      AppMethodBeat.o(122024);
      return;
    }
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor endHook real: %s", new Object[] { paramFragmentActivity });
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.f(this.pFf, this.pEV);
    AppMethodBeat.o(122024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b
 * JD-Core Version:    0.7.0.1
 */