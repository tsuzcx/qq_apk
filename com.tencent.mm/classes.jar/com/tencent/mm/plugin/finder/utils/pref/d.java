package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterLiveTaskPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "TAG", "getContext", "()Landroid/content/Context;", "hasExposeLiveTaskTips", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements i
{
  private final com.tencent.mm.ui.base.preference.f Gmr;
  private String Gmv;
  private final String TAG;
  private final Context context;
  private final String name;
  
  public d(String paramString, com.tencent.mm.ui.base.preference.f paramf, Context paramContext)
  {
    AppMethodBeat.i(333847);
    this.name = paramString;
    this.Gmr = paramf;
    this.context = paramContext;
    this.TAG = "Finder.PosterCenterLiveTaskPref";
    this.Gmv = "";
    AppMethodBeat.o(333847);
  }
  
  private static final void a(d paramd, l.a parama)
  {
    AppMethodBeat.i(333858);
    s.u(paramd, "this$0");
    Object localObject = paramd.Gmr.bAi(paramd.name);
    if (localObject == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.newtips.NewTipPreference");
      AppMethodBeat.o(333858);
      throw paramd;
    }
    localObject = (NewTipPreference)localObject;
    boolean bool;
    int i;
    label82:
    bxq localbxq;
    p localp;
    if (parama == null)
    {
      bool = false;
      ((NewTipPreference)localObject).yn(bool);
      if ((parama == null) || (parama.hBY != true)) {
        break label217;
      }
      i = 1;
      if (i != 0)
      {
        localbxq = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("FinderSettingLiveTask");
        localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderSettingLiveTask");
        if (localp != null) {
          break label222;
        }
        parama = "";
        label130:
        if (!s.p(parama, paramd.Gmv))
        {
          paramd.Gmv = parama;
          if ((localp != null) && (localbxq != null))
          {
            parama = w.FrV;
            localObject = as.GSQ;
            paramd = as.a.hu((Context)paramd.context);
            if (paramd != null) {
              break label258;
            }
          }
        }
      }
    }
    label258:
    for (paramd = null;; paramd = paramd.fou())
    {
      w.a(parama, "10", localp, localbxq, 1, paramd, 0, null, 0, 480);
      AppMethodBeat.o(333858);
      return;
      bool = parama.hBY;
      break;
      label217:
      i = 0;
      break label82;
      label222:
      parama = localp.field_ctrInfo;
      if (parama == null)
      {
        parama = "";
        break label130;
      }
      localObject = parama.ZYN;
      parama = (l.a)localObject;
      if (localObject != null) {
        break label130;
      }
      parama = "";
      break label130;
    }
  }
  
  public final String fiv()
  {
    return this.name;
  }
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(333893);
    this.Gmr.eh(this.name, true);
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    if (d.a.auX("Entrance_PrimarySetting"))
    {
      this.Gmr.eh(this.name, false);
      localObject = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.eaa(), (q)this.context, new d..ExternalSyntheticLambda0(this));
      if (paramBoolean) {
        com.tencent.mm.plugin.report.service.h.OAn.b(22748, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Long.valueOf(cn.bDw()), z.bAW() });
      }
    }
    AppMethodBeat.o(333893);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(333903);
    bxq localbxq = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("FinderSettingLiveTask");
    p localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderSettingLiveTask");
    w localw;
    if ((localp != null) && (localbxq != null))
    {
      localw = w.FrV;
      localObject = as.GSQ;
      localObject = as.a.hu((Context)this.context);
      if (localObject != null) {
        break label173;
      }
    }
    label173:
    for (Object localObject = null;; localObject = ((as)localObject).fou())
    {
      w.a(localw, "10", localp, localbxq, 2, (bui)localObject, 0, null, 0, 480);
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("FinderSettingLiveTask");
      f.a.a((com.tencent.mm.plugin.f)a.GfO, this.context, 1);
      com.tencent.mm.plugin.report.service.h.OAn.b(22748, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Long.valueOf(cn.bDw()), z.bAW() });
      AppMethodBeat.o(333903);
      return;
    }
  }
  
  public final void onCreate() {}
  
  public final void onResume() {}
  
  public final void onStop()
  {
    this.Gmv = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.d
 * JD-Core Version:    0.7.0.1
 */