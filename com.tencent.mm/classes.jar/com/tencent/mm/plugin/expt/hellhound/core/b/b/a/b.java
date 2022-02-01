package com.tencent.mm.plugin.expt.hellhound.core.b.b.a;

import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  private static b zCi;
  private final d zBZ;
  private a zCj;
  public int zCk;
  private final Map<String, Map<String, List<Pair<String, String>>>> zCl;
  
  private b()
  {
    AppMethodBeat.i(177362);
    this.zCk = -1;
    this.zBZ = new d()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184336);
        if ("onPostOpen".equals(paramAnonymousString2))
        {
          if (paramAnonymousArrayOfObject.length > 0)
          {
            Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, onPostOpen: %b", new Object[] { paramAnonymousArrayOfObject[0] });
            b.a(b.this, 0, System.currentTimeMillis());
            b.i(paramAnonymousObject, true);
            AppMethodBeat.o(184336);
          }
        }
        else if ("onPostClose".equals(paramAnonymousString2))
        {
          Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, onPostClose:");
          b.a(b.this, 1, System.currentTimeMillis());
          b.i(paramAnonymousObject, false);
        }
        AppMethodBeat.o(184336);
      }
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onPostOpen", "(Z)V"));
    localArrayList.add(Pair.create("onPostClose", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", localArrayList);
    this.zCl = new HashMap();
    this.zCl.put("com/tencent/mm/ui/MoreTabUI$", localHashMap);
    AppMethodBeat.o(177362);
  }
  
  public static int LD(int paramInt)
  {
    if (paramInt == 0) {
      return 300;
    }
    if (paramInt == 1) {
      return 301;
    }
    return -1;
  }
  
  public static int LE(int paramInt)
  {
    if (paramInt == 300) {
      return 0;
    }
    if (paramInt == 301) {
      return 1;
    }
    return -1;
  }
  
  private void ad(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184337);
    this.zCk = paramInt;
    if (this.zCj != null) {
      this.zCj.ac(paramInt, paramLong);
    }
    AppMethodBeat.o(184337);
  }
  
  public static b dJJ()
  {
    AppMethodBeat.i(122022);
    if (zCi == null) {}
    try
    {
      if (zCi == null) {
        zCi = new b();
      }
      b localb = zCi;
      AppMethodBeat.o(122022);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122022);
    }
  }
  
  private void dJK()
  {
    AppMethodBeat.i(177363);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.e(this.zCl, this.zBZ);
    AppMethodBeat.o(177363);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, a parama)
  {
    AppMethodBeat.i(300001);
    if (!com.tencent.mm.plugin.expt.hellhound.a.dIK())
    {
      Log.w("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, startHook, fetchHellhoundConfig: FALSE");
      AppMethodBeat.o(300001);
      return;
    }
    Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook");
    paramFragmentActivity = h.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.zAU);
    if (paramFragmentActivity == null)
    {
      Log.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook: curFragment == null");
      AppMethodBeat.o(300001);
      return;
    }
    paramFragmentActivity = paramFragmentActivity.getClass().getCanonicalName();
    Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook-2: %s", new Object[] { paramFragmentActivity });
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.zAU.equals(paramFragmentActivity))
    {
      Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook Fail: %s", new Object[] { paramFragmentActivity });
      AppMethodBeat.o(300001);
      return;
    }
    this.zCj = parama;
    Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook real: %s", new Object[] { paramFragmentActivity });
    dJK();
    AppMethodBeat.o(300001);
  }
  
  public final void ao(String paramString, long paramLong)
  {
    AppMethodBeat.i(184338);
    Log.i("HABBYGE-MALI.StoryGalleryMonitor", "_finishMMFecordUI: %s", new Object[] { paramString });
    if ("com.tencent.mm.plugin.recordvideo.activity.MMRecordUI".equals(paramString)) {
      ad(1, paramLong);
    }
    AppMethodBeat.o(184338);
  }
  
  public final void e(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(300003);
    Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, endHook");
    paramFragmentActivity = h.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.zAU);
    if (paramFragmentActivity == null)
    {
      Log.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, curFragment == null");
      AppMethodBeat.o(300003);
      return;
    }
    paramFragmentActivity = paramFragmentActivity.getClass().getCanonicalName();
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.zAU.equals(paramFragmentActivity))
    {
      Log.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor endHook FALSE: %s", new Object[] { paramFragmentActivity });
      AppMethodBeat.o(300003);
      return;
    }
    Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor endHook real: %s", new Object[] { paramFragmentActivity });
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.f(this.zCl, this.zBZ);
    AppMethodBeat.o(300003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b
 * JD-Core Version:    0.7.0.1
 */