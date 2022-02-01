package com.tencent.mm.plugin.finder.live.viewmodel.state.anchor;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ad;
import com.tencent.mm.plugin.finder.live.util.u;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.k;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorPrepareUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveAnchorStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "finderLiveBeforePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin;", "getFinderLiveBeforePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin;", "setFinderLiveBeforePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin;)V", "initPlugins", "", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "onLiveEnd", "onLivePrepare", "onLiveStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "prepareLive", "isFromFloat", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.a
{
  public ad EjT;
  public final String TAG;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(357251);
    this.TAG = "FinderLiveAnchorPrepareUIC";
    AppMethodBeat.o(357251);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.a parama)
  {
    AppMethodBeat.i(357272);
    s.u(parama, "baseRouter");
    super.a(parama);
    Object localObject1;
    Object localObject2;
    if (((f)business(f.class)).mZu == null)
    {
      localObject1 = (f)business(f.class);
      localObject2 = new g(null, 0L, 0, null, 0L, 0L, null, 0, null, 0L, null, null, 131071);
      ((f)localObject1).b(new h(new TRTCCloudDef.TRTCParams(), (g)localObject2, new com.tencent.mm.live.core.core.model.d("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")));
    }
    long l;
    int i;
    label234:
    Object localObject3;
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted())
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Eej = d.a.auT(z.bAW());
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eej;
      if (localObject2 == null)
      {
        l = 0L;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Ecp = ((int)l);
        localObject1 = u.DJC;
        u.ey("onBindData", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (!com.tencent.mm.ae.d.ee(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp, 256)) {
          break label869;
        }
        i = 1;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Eeh = i;
        localObject1 = (j)business(j.class);
        localObject2 = new dom();
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eej;
        if (localObject3 != null) {
          break label874;
        }
        l = 0L;
        label282:
        ((dom)localObject2).CJK = l;
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eej;
        if (localObject3 != null) {
          break label884;
        }
        l = 0L;
        label311:
        ((dom)localObject2).aaVw = l;
        localObject3 = ah.aiuX;
        s.u(localObject2, "<set-?>");
        ((j)localObject1).Cvf = ((dom)localObject2);
      }
    }
    else
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      localObject2 = z.bAW();
      s.s(localObject2, "getMyFinderUsername()");
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).setAnchorUsername((String)localObject2);
      com.tencent.mm.plugin.finder.live.view.a.fillBlurBg$default((com.tencent.mm.plugin.finder.live.view.a)parama, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, false, 2, null);
      parama = this.CCb;
      if (parama != null)
      {
        localObject1 = parama.findViewById(p.e.BQJ);
        s.s(localObject1, "it.findViewById(R.id.finder_live_post_layout)");
        this.EjT = new ad((ViewGroup)localObject1, (b)parama);
        parama = this.EjT;
        if (parama != null) {
          parama.tO(8);
        }
        localObject1 = this.EjT;
        if (localObject1 != null)
        {
          parama = this.buContext;
          s.u(parama, "data");
          localObject1 = ((ad)localObject1).CXk;
          parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).BvE;
          if (parama != null)
          {
            localObject2 = (CharSequence)parama.hAR;
            if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
              break label894;
            }
            i = 1;
            label522:
            if ((i == 0) && ((parama.ZTH & 0x1) == 1))
            {
              localObject2 = ((k)localObject1).DYS;
              if (localObject2 != null) {
                ((View)localObject2).setVisibility(0);
              }
              localObject3 = new Date(parama.startTime * 1000L);
              localObject2 = Calendar.getInstance();
              ((Calendar)localObject2).setTime((Date)localObject3);
              i = ((Calendar)localObject2).get(2);
              int j = ((Calendar)localObject2).get(5);
              localObject3 = aw.Gjk;
              localObject3 = aw.Uv(((Calendar)localObject2).get(11));
              Object localObject4 = aw.Gjk;
              localObject2 = aw.Uv(((Calendar)localObject2).get(12));
              localObject4 = ((k)localObject1).DYV;
              if (localObject4 != null) {
                ((TextView)localObject4).setText((CharSequence)((k)localObject1).getRootView().getContext().getResources().getString(p.h.Cpe, new Object[] { Integer.valueOf(i + 1), Integer.valueOf(j), localObject3, localObject2 }));
              }
              parama = parama.YSR;
              if (parama != null)
              {
                if (((CharSequence)parama).length() <= 0) {
                  break label899;
                }
                i = 1;
                label722:
                if (i == 0) {
                  break label904;
                }
                label726:
                if (parama != null)
                {
                  localObject1 = ((k)localObject1).DZf;
                  if (localObject1 != null) {
                    ((MMEditText)localObject1).bDt(parama);
                  }
                }
              }
            }
          }
        }
      }
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("bindData liveData.business(LiveCommonSlice::class.java).isLiveStarted():").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted()).append(" liveMicSetting:");
      parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eej;
      if (parama != null) {
        break label909;
      }
      parama = null;
      label806:
      localObject2 = ((StringBuilder)localObject2).append(parama).append(" liveMicSettingSwitch:");
      parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eej;
      if (parama != null) {
        break label920;
      }
    }
    label899:
    label904:
    label909:
    label920:
    for (parama = null;; parama = Long.valueOf(parama.field_liveMicSettingSwitch))
    {
      Log.i((String)localObject1, parama);
      AppMethodBeat.o(357272);
      return;
      l = ((m)localObject2).field_liveAnchorStatusFlag;
      break;
      label869:
      i = 0;
      break label234;
      label874:
      l = ((m)localObject3).field_liveMicSetting;
      break label282;
      label884:
      l = ((m)localObject3).field_liveMicSettingSwitch;
      break label311;
      label894:
      i = 0;
      break label522;
      i = 0;
      break label722;
      parama = null;
      break label726;
      parama = Long.valueOf(parama.field_liveMicSetting);
      break label806;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.c
 * JD-Core Version:    0.7.0.1
 */