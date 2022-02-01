package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.activity.b;
import com.tencent.mm.plugin.finder.activity.view.a.g;
import com.tencent.mm.plugin.finder.activity.view.a.h;
import com.tencent.mm.plugin.finder.activity.view.a.i;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderNewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "headerManager", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "headerView", "Landroid/view/View;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderActivityHeaderNewUIC
  extends UIComponent
{
  private View kgo;
  private com.tencent.mm.plugin.finder.activity.view.a trc;
  
  public FinderActivityHeaderNewUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(242067);
    AppMethodBeat.o(242067);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(242066);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 20000))
    {
      com.tencent.mm.plugin.finder.activity.view.a locala = this.trc;
      if (locala != null)
      {
        paramIntent = k.vfA;
        paramIntent = locala.tqo;
        Object localObject1;
        if (paramIntent != null)
        {
          paramIntent = Long.valueOf(paramIntent.twd);
          localObject1 = String.valueOf(paramIntent);
          paramIntent = FinderReporterUIC.wzC;
          paramIntent = FinderReporterUIC.a.fH((Context)locala.gte);
          if (paramIntent == null) {
            break label462;
          }
          paramIntent = paramIntent.dIx();
          label88:
          k.a(2L, (String)localObject1, paramIntent);
          paramIntent = new StringBuilder();
          p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
          localObject1 = com.tencent.mm.kernel.a.ayV() + '_' + Util.nowMilliSecond();
          paramIntent = b.tqg;
          paramIntent = locala.tqo;
          if (paramIntent == null) {
            break label467;
          }
        }
        label462:
        label467:
        for (paramIntent = Long.valueOf(paramIntent.twd);; paramIntent = null)
        {
          if (b.b(paramIntent, 9))
          {
            paramIntent = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fr((Context)locala.gte);
          }
          paramIntent = i.vfo;
          i.as(9, false);
          paramIntent = i.vfo;
          i.auI((String)localObject1);
          if (locala.tsf == null)
          {
            paramIntent = new e((Context)locala.gte, 1, true);
            localObject1 = aa.jQ((Context)locala.gte).inflate(2131494632, null);
            Object localObject3 = (TextView)((View)localObject1).findViewById(2131305436);
            ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131297119);
            Object localObject2 = c.tsp;
            localObject2 = c.a.asG(z.aUg());
            if (localObject2 != null)
            {
              p.g(localObject3, "nicknameTv");
              ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)locala.gte, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject2).getNickname()));
              localObject3 = m.uJa;
              localObject3 = m.dka();
              localObject2 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject2).field_avatarUrl);
              p.g(localImageView, "avatarIv");
              m localm = m.uJa;
              ((d)localObject3).a(localObject2, localImageView, m.a(m.a.uJe));
            }
            paramIntent.V((View)localObject1, true);
            paramIntent.a((o.f)a.i.tsm);
            paramIntent.a((o.g)new a.g(locala));
            paramIntent.b((e.b)new a.h(locala));
            locala.tsf = paramIntent;
          }
          paramIntent = locala.tsf;
          if (paramIntent == null) {
            break label472;
          }
          if (!paramIntent.isShowing()) {
            paramIntent.dGm();
          }
          AppMethodBeat.o(242066);
          return;
          paramIntent = null;
          break;
          paramIntent = null;
          break label88;
        }
        label472:
        AppMethodBeat.o(242066);
        return;
      }
    }
    AppMethodBeat.o(242066);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(242064);
    super.onCreate(paramBundle);
    this.kgo = getActivity().findViewById(2131296471);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242064);
      throw paramBundle;
    }
    paramBundle = new com.tencent.mm.plugin.finder.activity.view.a((MMActivity)paramBundle);
    paramBundle.dR(this.kgo);
    this.trc = paramBundle;
    AppMethodBeat.o(242064);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(242065);
    super.onDestroy();
    com.tencent.mm.plugin.finder.activity.view.a locala = this.trc;
    if (locala != null)
    {
      locala.destroy();
      AppMethodBeat.o(242065);
      return;
    }
    AppMethodBeat.o(242065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityHeaderNewUIC
 * JD-Core Version:    0.7.0.1
 */