package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterOriginalPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "hasExposeOriginalTips", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements i
{
  private final com.tencent.mm.ui.base.preference.f Gmr;
  private String Gmw;
  private final Context context;
  private final String name;
  
  public f(String paramString, com.tencent.mm.ui.base.preference.f paramf, Context paramContext)
  {
    AppMethodBeat.i(333843);
    this.name = paramString;
    this.Gmr = paramf;
    this.context = paramContext;
    this.Gmw = "";
    AppMethodBeat.o(333843);
  }
  
  private static final void a(f paramf, l.a parama)
  {
    AppMethodBeat.i(333856);
    s.u(paramf, "this$0");
    Object localObject = paramf.Gmr.bAi(paramf.name);
    if (localObject == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.newtips.NewTipPreference");
      AppMethodBeat.o(333856);
      throw paramf;
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
        break label211;
      }
      i = 1;
      if (i != 0)
      {
        localbxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("OriginalEntrance");
        localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("OriginalEntrance");
        if (localp != null) {
          break label216;
        }
        parama = "";
        label130:
        if (!s.p(parama, paramf.Gmw))
        {
          paramf.Gmw = parama;
          if ((localp != null) && (localbxq != null))
          {
            parama = w.FrV;
            localObject = as.GSQ;
            paramf = as.a.hu(paramf.context);
            if (paramf != null) {
              break label252;
            }
          }
        }
      }
    }
    label211:
    label216:
    label252:
    for (paramf = null;; paramf = paramf.fou())
    {
      w.a(parama, "10", localp, localbxq, 1, paramf, 0, null, 0, 480);
      AppMethodBeat.o(333856);
      return;
      bool = parama.hBY;
      break;
      i = 0;
      break label82;
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
    AppMethodBeat.i(333890);
    this.Gmr.eh(this.name, true);
    Object localObject = ac.Ghd;
    if (ac.ffa())
    {
      this.Gmr.eh(this.name, false);
      localObject = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.dZG(), (q)this.context, new f..ExternalSyntheticLambda0(this));
      if (paramBoolean)
      {
        localObject = z.FrZ;
        z.b(this.context, 6L, 2L);
      }
    }
    AppMethodBeat.o(333890);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(333901);
    Object localObject1 = this.Gmr.bAi(this.name);
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.newtips.NewTipPreference");
      AppMethodBeat.o(333901);
      throw ((Throwable)localObject1);
    }
    localObject1 = (NewTipPreference)localObject1;
    Object localObject2 = z.FrZ;
    localObject2 = this.context;
    boolean bool;
    p localp;
    w localw;
    if ((((NewTipPreference)localObject1).mlS != null) && (((NewTipPreference)localObject1).mlS.getVisibility() == 0))
    {
      bool = true;
      z.a((Context)localObject2, 6L, 1L, bool);
      localObject2 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("OriginalEntrance");
      localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("OriginalEntrance");
      if ((localp != null) && (localObject2 != null))
      {
        localw = w.FrV;
        localObject1 = as.GSQ;
        localObject1 = as.a.hu(this.context);
        if (localObject1 != null) {
          break label259;
        }
      }
    }
    label259:
    for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
    {
      w.a(localw, "10", localp, (bxq)localObject2, 2, (bui)localObject1, 0, null, 0, 480);
      ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().TL("OriginalEntrance");
      ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().d("FinderPosterEntrance", new int[] { 1000 });
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      localObject1 = com.tencent.mm.plugin.finder.storage.d.eUl();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      c.b(this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(333901);
      return;
      bool = false;
      break;
    }
  }
  
  public final void onCreate() {}
  
  public final void onResume() {}
  
  public final void onStop()
  {
    this.Gmw = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.f
 * JD-Core Version:    0.7.0.1
 */