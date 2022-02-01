package com.tencent.mm.plugin.finder.live.olympic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.fgz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsRunnerFramgent;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "activityInfo", "Lcom/tencent/mm/protocal/protobuf/SportActivity;", "(Lcom/tencent/mm/protocal/protobuf/SportActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "value", "getActivityInfo", "()Lcom/tencent/mm/protocal/protobuf/SportActivity;", "setActivityInfo", "", "boardScene", "getBoardScene", "()I", "setBoardScene", "(I)V", "focusState", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onUserVisibleFocused", "", "onUserVisibleUnFocused", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveOlympicsRunnerFramgent
  extends MMFinderFragment
{
  int CNG;
  fgz COJ;
  private int COK;
  private final String TAG;
  
  public FinderLiveOlympicsRunnerFramgent(fgz paramfgz)
  {
    AppMethodBeat.i(360416);
    this.TAG = "FinderLiveOlympicsRunnerFramgent";
    String str = this.TAG;
    Object localObject;
    int i;
    if (paramfgz == null)
    {
      localObject = null;
      Log.i(str, s.X("scene:", localObject));
      if (paramfgz != null) {
        break label113;
      }
      i = 0;
    }
    for (;;)
    {
      Log.i(this.TAG, "boardScene from " + this.CNG + " to " + i);
      this.CNG = i;
      this.COJ = paramfgz;
      AppMethodBeat.o(360416);
      return;
      localObject = bj.GlQ;
      localObject = bj.b(paramfgz);
      break;
      label113:
      localObject = paramfgz.abHp;
      if (localObject == null)
      {
        i = 0;
      }
      else
      {
        localObject = (bv)p.oL((List)localObject);
        if (localObject == null)
        {
          i = 0;
        }
        else
        {
          localObject = ((bv)localObject).YDC;
          if (localObject == null)
          {
            i = 0;
          }
          else
          {
            localObject = (bw)p.oL((List)localObject);
            if (localObject == null) {
              i = 0;
            } else {
              i = ((bw)localObject).YDD;
            }
          }
        }
      }
    }
  }
  
  public final int getLayoutId()
  {
    return p.f.CeV;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(360440);
    Set localSet = ar.setOf(h.class);
    AppMethodBeat.o(360440);
    return localSet;
  }
  
  public final void onUserVisibleFocused()
  {
    long l2 = 0L;
    AppMethodBeat.i(360428);
    super.onUserVisibleFocused();
    Map localMap;
    Object localObject;
    long l1;
    if (this.COK != 1)
    {
      this.COK = 1;
      localMap = (Map)new LinkedHashMap();
      localObject = a.CMm;
      localObject = a.emY();
      if (localObject != null) {
        break label101;
      }
      l1 = l2;
    }
    for (;;)
    {
      localMap.put("liveid", d.hF(l1));
      localMap.put("tab_type", String.valueOf(this.CNG));
      j.Dob.a(q.t.Dwx, localMap);
      AppMethodBeat.o(360428);
      return;
      label101:
      localObject = (f)((a)localObject).business(f.class);
      l1 = l2;
      if (localObject != null)
      {
        localObject = ((f)localObject).liveInfo;
        l1 = l2;
        if (localObject != null) {
          l1 = ((bip)localObject).liveId;
        }
      }
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(360433);
    super.onUserVisibleUnFocused();
    if (this.COK != 2) {
      this.COK = 2;
    }
    AppMethodBeat.o(360433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.FinderLiveOlympicsRunnerFramgent
 * JD-Core Version:    0.7.0.1
 */