package com.tencent.mm.plugin.expt.hellhound.core.b.b.a;

import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  private static b qRY;
  public int iBy;
  private final c qRO;
  private a qRZ;
  private final Map<String, Map<String, List<Pair<String, String>>>> qSa;
  
  private b()
  {
    AppMethodBeat.i(177362);
    this.iBy = -1;
    this.qRO = new c()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184336);
        if ("onPostOpen".equals(paramAnonymousString2))
        {
          if (paramAnonymousArrayOfObject.length > 0)
          {
            ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, onPostOpen: %b", new Object[] { paramAnonymousArrayOfObject[0] });
            b.a(b.this, 0, System.currentTimeMillis());
            b.f(paramAnonymousObject, true);
            AppMethodBeat.o(184336);
          }
        }
        else if ("onPostClose".equals(paramAnonymousString2))
        {
          ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, onPostClose:");
          b.a(b.this, 1, System.currentTimeMillis());
          b.f(paramAnonymousObject, false);
        }
        AppMethodBeat.o(184336);
      }
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onPostOpen", "(Z)V"));
    localArrayList.add(Pair.create("onPostClose", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", localArrayList);
    this.qSa = new HashMap();
    this.qSa.put("com/tencent/mm/ui/MoreTabUI$", localHashMap);
    AppMethodBeat.o(177362);
  }
  
  public static int CW(int paramInt)
  {
    if (paramInt == 0) {
      return 300;
    }
    if (paramInt == 1) {
      return 301;
    }
    return -1;
  }
  
  public static int CX(int paramInt)
  {
    if (paramInt == 300) {
      return 0;
    }
    if (paramInt == 301) {
      return 1;
    }
    return -1;
  }
  
  private void W(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184337);
    this.iBy = paramInt;
    if (this.qRZ != null) {
      this.qRZ.V(paramInt, paramLong);
    }
    AppMethodBeat.o(184337);
  }
  
  public static b coq()
  {
    AppMethodBeat.i(122022);
    if (qRY == null) {}
    try
    {
      if (qRY == null) {
        qRY = new b();
      }
      b localb = qRY;
      AppMethodBeat.o(122022);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122022);
    }
  }
  
  private void cor()
  {
    AppMethodBeat.i(177363);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.e(this.qSa, this.qRO);
    AppMethodBeat.o(177363);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, a parama)
  {
    AppMethodBeat.i(122023);
    if (!com.tencent.mm.plugin.expt.hellhound.a.cnt())
    {
      ad.w("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, startHook, fetchHellhoundConfig: FALSE");
      AppMethodBeat.o(122023);
      return;
    }
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook");
    paramFragmentActivity = h.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.qQK);
    if (paramFragmentActivity == null)
    {
      ad.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook: curFragment == null");
      AppMethodBeat.o(122023);
      return;
    }
    paramFragmentActivity = paramFragmentActivity.getClass().getCanonicalName();
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook-2: %s", new Object[] { paramFragmentActivity });
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.qQK.equals(paramFragmentActivity))
    {
      ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook Fail: %s", new Object[] { paramFragmentActivity });
      AppMethodBeat.o(122023);
      return;
    }
    this.qRZ = parama;
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook real: %s", new Object[] { paramFragmentActivity });
    cor();
    AppMethodBeat.o(122023);
  }
  
  public final void ag(String paramString, long paramLong)
  {
    AppMethodBeat.i(184338);
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "_finishMMFecordUI: %s", new Object[] { paramString });
    if ("com.tencent.mm.plugin.recordvideo.activity.MMRecordUI".equals(paramString)) {
      W(1, paramLong);
    }
    AppMethodBeat.o(184338);
  }
  
  public final void e(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(122024);
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, endHook");
    paramFragmentActivity = h.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.qQK);
    if (paramFragmentActivity == null)
    {
      ad.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, curFragment == null");
      AppMethodBeat.o(122024);
      return;
    }
    paramFragmentActivity = paramFragmentActivity.getClass().getCanonicalName();
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.qQK.equals(paramFragmentActivity))
    {
      ad.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor endHook FALSE: %s", new Object[] { paramFragmentActivity });
      AppMethodBeat.o(122024);
      return;
    }
    ad.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor endHook real: %s", new Object[] { paramFragmentActivity });
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.f(this.qSa, this.qRO);
    AppMethodBeat.o(122024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b
 * JD-Core Version:    0.7.0.1
 */