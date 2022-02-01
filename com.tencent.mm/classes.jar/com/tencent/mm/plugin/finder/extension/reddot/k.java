package com.tencent.mm.plugin.finder.extension.reddot;

import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.nearby.abtest.a;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManagerOnTab;", "", "()V", "actionCallBack", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManagerOnTab$FinderRedDotActionCallBack;", "getActionCallBack", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManagerOnTab$FinderRedDotActionCallBack;", "setActionCallBack", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManagerOnTab$FinderRedDotActionCallBack;)V", "mBusinessType", "", "mCurrentPosition", "getMCurrentPosition", "()I", "setMCurrentPosition", "(I)V", "mLastResult", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "mOnShowResult", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManagerOnTab$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManagerOnTab$mainUiIndexChangeListener$1;", "resultObserver", "Landroidx/lifecycle/Observer;", "disposeDiscovery", "", "isFriendTab", "", "result", "isDisableRedDotForFinder", "isRedDotNotifyEnable", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "onChanged", "onPause", "onResume", "registerDiscoveryObserver", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "reportByTabClick", "reportDiscoveryTabRedDot", "action", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "Companion", "FinderRedDotActionCallBack", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k.a ARs;
  public l.a ARt;
  private l.a ARu;
  private int ARv;
  public b ARw;
  public final y<l.a> ARx;
  public final FinderRedDotManagerOnTab.mainUiIndexChangeListener.1 DWR;
  public int bXr;
  
  static
  {
    AppMethodBeat.i(366811);
    ARs = new k.a((byte)0);
    AppMethodBeat.o(366811);
  }
  
  public k()
  {
    AppMethodBeat.i(366759);
    this.ARv = -1;
    this.bXr = -1;
    this.DWR = new FinderRedDotManagerOnTab.mainUiIndexChangeListener.1(f.hfK);
    this.ARx = ((y)new c(this));
    AppMethodBeat.o(366759);
  }
  
  public final void a(int paramInt, p paramp, bxq parambxq)
  {
    AppMethodBeat.i(366829);
    w localw = w.FrV;
    w.a(paramInt, this.ARv, paramp, parambxq);
    AppMethodBeat.o(366829);
  }
  
  public final boolean f(p paramp)
  {
    AppMethodBeat.i(366821);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramp != null)
    {
      if (!paramp.avJ("FinderEntrance")) {
        break label65;
      }
      bool1 = ((cn)h.az(cn.class)).getRedDotManager().dZs();
      this.ARv = 1;
      Log.i("FinderRedDotManagerOnTab", "[FinderDiscoveryTab] FINDER_ENTRANCE");
    }
    for (;;)
    {
      AppMethodBeat.o(366821);
      return bool1;
      label65:
      if (paramp.avJ("FinderLiveEntrance"))
      {
        paramp = a.EHr;
        if (a.eEl()) {}
        for (int i = 5;; i = 2)
        {
          this.ARv = i;
          bool1 = ((cn)h.az(cn.class)).getRedDotManager().dZv();
          Log.i("FinderRedDotManagerOnTab", "[FinderDiscoveryTab] FINDER_LIVE_ENTRANCE");
          break;
        }
      }
      bool1 = bool2;
      if (paramp.avJ("NearbyEntrance"))
      {
        this.ARv = 3;
        bool1 = ((cn)h.az(cn.class)).getRedDotManager().dZt();
        Log.i("FinderRedDotManagerOnTab", "[FinderDiscoveryTab] NEARBY_ENTRANCE");
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManagerOnTab$FinderRedDotActionCallBack;", "", "isCanShowFriendPoint", "", "isCanShowFriendTextPoint", "setFinderRedDotGone", "", "setFinderRedDotShow", "setFinderTextRedDotShow", "text", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void avo(String paramString);
    
    public abstract boolean dZA();
    
    public abstract void dZy();
    
    public abstract void dZz();
    
    public abstract boolean eFN();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManagerOnTab$resultObserver$1", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "isFinderRedDotExpose", "", "onChanged", "", "result", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements y<l.a>
  {
    private boolean ARy;
    
    c(k paramk) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.k
 * JD-Core Version:    0.7.0.1
 */