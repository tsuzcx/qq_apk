package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.tencent.d.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterLiveIncomePref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "Lcom/tencent/mm/plugin/finder/utils/pref/WithPrepareResp;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "TAG", "getContext", "()Landroid/content/Context;", "hasExposeLiveIncomeEntranceTips", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updatePrepareResp", "updateView", "isFromSceneEnd", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements i, j
{
  private bys AwM;
  private final f Gmr;
  private String Gms;
  private final String TAG;
  private final Context context;
  private final String name;
  
  public b(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(333879);
    this.name = paramString;
    this.Gmr = paramf;
    this.context = paramContext;
    this.TAG = "Finder.PosterCenterLiveIncomePref";
    this.Gms = "";
    AppMethodBeat.o(333879);
  }
  
  private static final void a(b paramb, l.a parama)
  {
    AppMethodBeat.i(333895);
    s.u(paramb, "this$0");
    Object localObject = paramb.Gmr.bAi(paramb.name);
    if (localObject == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.newtips.NewTipPreference");
      AppMethodBeat.o(333895);
      throw paramb;
    }
    localObject = (NewTipPreference)localObject;
    boolean bool;
    int i;
    if (parama == null)
    {
      bool = false;
      ((NewTipPreference)localObject).yn(bool);
      if ((parama == null) || (parama.hBY != true)) {
        break label178;
      }
      i = 1;
    }
    bxq localbxq;
    p localp;
    for (;;)
    {
      if (i != 0)
      {
        localbxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("FinderLiveIncomeEntrance");
        localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderLiveIncomeEntrance");
        if ((localbxq != null) && (localp != null))
        {
          localObject = localp.field_ctrInfo.ZYN;
          parama = (l.a)localObject;
          if (localObject == null) {
            parama = "";
          }
          if (s.p(parama, paramb.Gms))
          {
            AppMethodBeat.o(333895);
            return;
            bool = parama.hBY;
            break;
            label178:
            i = 0;
            continue;
          }
          paramb.Gms = parama;
          parama = w.FrV;
          localObject = as.GSQ;
          paramb = as.a.hu(paramb.context);
          if (paramb != null) {
            break label235;
          }
        }
      }
    }
    label235:
    for (paramb = null;; paramb = paramb.fou())
    {
      w.a(parama, "4", localp, localbxq, 1, paramb, 0, null, 0, 480);
      AppMethodBeat.o(333895);
      return;
    }
  }
  
  public final void b(bys parambys)
  {
    AppMethodBeat.i(334003);
    s.u(parambys, "prepareResp");
    this.AwM = parambys;
    AppMethodBeat.o(334003);
  }
  
  public final String fiv()
  {
    return this.name;
  }
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(333959);
    if (this.AwM == null) {
      this.Gmr.eh(this.name, true);
    }
    Object localObject1 = this.AwM;
    if (localObject1 != null)
    {
      paramBoolean = com.tencent.mm.ae.d.ee(((bys)localObject1).aahC, 1);
      boolean bool1 = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      Object localObject2 = (g)h.ax(g.class);
      Object localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject3 = d.a.auT(com.tencent.mm.model.z.bAW());
      if (localObject3 == null) {}
      for (long l = 0L;; l = ((m)localObject3).field_liveSwitchFlag)
      {
        boolean bool2 = ((g)localObject2).jq(l);
        localObject2 = this.TAG;
        localObject3 = new StringBuilder("initLiveIncomeCell FinderLive.entrance,xLab enable live:");
        a locala = a.ahiX;
        Log.i((String)localObject2, a.jTq() + ", server flag:" + ((bys)localObject1).aahC + ", server enable live:" + paramBoolean + " rewardGainEnable:" + bool2);
        localObject1 = av.GiL;
        if (!av.bgV())
        {
          localObject1 = a.ahiX;
          if ((!a.jTq()) && (!paramBoolean)) {
            break;
          }
        }
        if ((!bool2) || (bool1)) {
          break;
        }
        this.Gmr.eh(this.name, false);
        localObject1 = l.ARA;
        com.tencent.mm.ae.d.a((LiveData)l.dZZ(), (q)this.context, new b..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(333959);
        return;
      }
      this.Gmr.eh(this.name, true);
    }
    AppMethodBeat.o(333959);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(333973);
    bxq localbxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("FinderLiveIncomeEntrance");
    p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderLiveIncomeEntrance");
    w localw;
    if ((localbxq != null) && (localp != null))
    {
      localw = w.FrV;
      localObject = as.GSQ;
      localObject = as.a.hu(this.context);
      if (localObject != null) {
        break label155;
      }
    }
    label155:
    for (Object localObject = null;; localObject = ((as)localObject).fou())
    {
      w.a(localw, "4", localp, localbxq, 2, (bui)localObject, 0, null, 0, 480);
      ((cn)h.az(cn.class)).getRedDotManager().TL("FinderLiveIncomeEntrance");
      localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.a(this.context, 0L, false, 2L, 9L, false, 0L);
      ((cn)h.az(cn.class)).getIncomePageInfoAndEnterIncome(this.context);
      AppMethodBeat.o(333973);
      return;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(333924);
    this.Gmr.eh(this.name, true);
    AppMethodBeat.o(333924);
  }
  
  public final void onResume() {}
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.b
 * JD-Core Version:    0.7.0.1
 */