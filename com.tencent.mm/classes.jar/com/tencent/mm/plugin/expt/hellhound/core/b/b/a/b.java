package com.tencent.mm.plugin.expt.hellhound.core.b.b.a;

import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  private static b qjR;
  public int iie;
  private c qjI;
  private a qjS;
  private Map<String, Map<String, List<Pair<String, String>>>> qjT;
  
  private b()
  {
    AppMethodBeat.i(177362);
    this.iie = -1;
    this.qjI = new b.1(this);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onPostOpen", "(Z)V"));
    localArrayList.add(Pair.create("onPostClose", "()V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", localArrayList);
    this.qjT = new HashMap();
    this.qjT.put("com/tencent/mm/ui/MoreTabUI$", localHashMap);
    AppMethodBeat.o(177362);
  }
  
  public static int Ck(int paramInt)
  {
    if (paramInt == 0) {
      return 300;
    }
    if (paramInt == 1) {
      return 301;
    }
    return -1;
  }
  
  public static int Cl(int paramInt)
  {
    if (paramInt == 300) {
      return 0;
    }
    if (paramInt == 301) {
      return 1;
    }
    return -1;
  }
  
  private void U(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184337);
    this.iie = paramInt;
    if (this.qjS != null) {
      this.qjS.T(paramInt, paramLong);
    }
    AppMethodBeat.o(184337);
  }
  
  public static b cjj()
  {
    AppMethodBeat.i(122022);
    if (qjR == null) {}
    try
    {
      if (qjR == null) {
        qjR = new b();
      }
      b localb = qjR;
      AppMethodBeat.o(122022);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122022);
    }
  }
  
  private void cjk()
  {
    AppMethodBeat.i(177363);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.e(this.qjT, this.qjI);
    AppMethodBeat.o(177363);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, a parama)
  {
    AppMethodBeat.i(122023);
    if (!com.tencent.mm.plugin.expt.hellhound.a.ciw())
    {
      ac.w("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, startHook, fetchHellhoundConfig: FALSE");
      AppMethodBeat.o(122023);
      return;
    }
    ac.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook");
    paramFragmentActivity = g.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.qiK);
    if (paramFragmentActivity == null)
    {
      ac.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook: curFragment == null");
      AppMethodBeat.o(122023);
      return;
    }
    paramFragmentActivity = paramFragmentActivity.getClass().getCanonicalName();
    ac.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook-2: %s", new Object[] { paramFragmentActivity });
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.qiK.equals(paramFragmentActivity))
    {
      ac.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook Fail: %s", new Object[] { paramFragmentActivity });
      AppMethodBeat.o(122023);
      return;
    }
    this.qjS = parama;
    ac.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook real: %s", new Object[] { paramFragmentActivity });
    cjk();
    AppMethodBeat.o(122023);
  }
  
  public final void aa(String paramString, long paramLong)
  {
    AppMethodBeat.i(184338);
    ac.i("HABBYGE-MALI.StoryGalleryMonitor", "_finishMMFecordUI: %s", new Object[] { paramString });
    if ("com.tencent.mm.plugin.recordvideo.activity.MMRecordUI".equals(paramString)) {
      U(1, paramLong);
    }
    AppMethodBeat.o(184338);
  }
  
  public final void e(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(122024);
    ac.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, endHook");
    paramFragmentActivity = g.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.qiK);
    if (paramFragmentActivity == null)
    {
      ac.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, curFragment == null");
      AppMethodBeat.o(122024);
      return;
    }
    paramFragmentActivity = paramFragmentActivity.getClass().getCanonicalName();
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.qiK.equals(paramFragmentActivity))
    {
      ac.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor endHook FALSE: %s", new Object[] { paramFragmentActivity });
      AppMethodBeat.o(122024);
      return;
    }
    ac.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor endHook real: %s", new Object[] { paramFragmentActivity });
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.f(this.qjT, this.qjI);
    AppMethodBeat.o(122024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b
 * JD-Core Version:    0.7.0.1
 */