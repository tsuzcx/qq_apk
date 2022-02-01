package com.tencent.mm.plugin.finder.live.viewmodel.state.anchor;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.plugin.al;
import com.tencent.mm.plugin.finder.live.widget.af;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.Calendar;
import java.util.Date;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorPrepareUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveAnchorStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "finderLiveBeforePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin;", "getFinderLiveBeforePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin;", "setFinderLiveBeforePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin;)V", "initPlugins", "", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "onLiveEnd", "onLivePrepare", "onLiveStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "prepareLive", "isFromFloat", "", "plugin-finder_release"})
public final class e
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.a
{
  public final String TAG;
  public al zke;
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(279728);
    this.TAG = "FinderLiveAnchorPrepareUIC";
    AppMethodBeat.o(279728);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.a parama)
  {
    AppMethodBeat.i(279727);
    p.k(parama, "baseRouter");
    super.a(parama);
    Object localObject1;
    Object localObject2;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvS == null)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      localObject2 = new com.tencent.mm.live.core.core.model.f(null, 0L, 0, null, 0L, 0L, null, null, 0L, null, 8191);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).b(new g(new TRTCCloudDef.TRTCParams(), (com.tencent.mm.live.core.core.model.f)localObject2, new com.tencent.mm.live.core.core.model.c("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI")));
    }
    long l;
    int i;
    label215:
    Object localObject3;
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted())
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zgp = d.a.aAK(z.bdh());
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgp;
      if (localObject2 != null)
      {
        l = ((com.tencent.mm.plugin.finder.api.i)localObject2).field_liveAnchorStatusFlag;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zfa = ((int)l);
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa, 256)) {
          break label900;
        }
        i = 1;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zgm = i;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        localObject2 = new cxh();
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgp;
        if (localObject3 == null) {
          break label905;
        }
        l = ((com.tencent.mm.plugin.finder.api.i)localObject3).field_liveMicSetting;
        label267:
        ((cxh)localObject2).TFP = l;
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgp;
        if (localObject3 == null) {
          break label911;
        }
        l = ((com.tencent.mm.plugin.finder.api.i)localObject3).field_liveMicSettingSwitch;
        label300:
        ((cxh)localObject2).TFQ = l;
        p.k(localObject2, "<set-?>");
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).zhx = ((cxh)localObject2);
      }
    }
    else
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      localObject2 = z.bdh();
      p.j(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).aCW((String)localObject2);
      com.tencent.mm.plugin.finder.live.view.a.fillBlurBg$default(parama, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, false, 2, null);
      parama = this.ycU;
      if (parama != null)
      {
        localObject1 = parama.findViewById(b.f.finder_live_post_layout);
        p.j(localObject1, "it.findViewById(R.id.finder_live_post_layout)");
        this.zke = new al((ViewGroup)localObject1, (com.tencent.mm.live.c.b)parama);
        parama = this.zke;
        if (parama != null) {
          parama.tU(8);
        }
        localObject1 = this.zke;
        if (localObject1 != null)
        {
          parama = this.buContext;
          p.k(parama, "data");
          localObject1 = ((al)localObject1).yor;
          parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).xUD;
          label730:
          label734:
          if (parama != null)
          {
            localObject2 = (CharSequence)parama.fwt;
            if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
              break label917;
            }
            i = 1;
            label503:
            if ((i == 0) && ((parama.SNd & 0x1) == 1))
            {
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.i)localObject1).zcz;
              if (localObject2 != null) {
                ((View)localObject2).setVisibility(0);
              }
              localObject2 = new Date(parama.fod * 1000L);
              localObject3 = Calendar.getInstance();
              p.j(localObject3, "date");
              ((Calendar)localObject3).setTime((Date)localObject2);
              i = ((Calendar)localObject3).get(2);
              int j = ((Calendar)localObject3).get(5);
              localObject2 = aj.AGc;
              localObject2 = aj.Rl(((Calendar)localObject3).get(11));
              Object localObject4 = aj.AGc;
              localObject3 = aj.Rl(((Calendar)localObject3).get(12));
              localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.i)localObject1).zcC;
              if (localObject4 != null)
              {
                Context localContext = ((com.tencent.mm.plugin.finder.live.viewmodel.i)localObject1).getRootView().getContext();
                p.j(localContext, "rootView.context");
                ((TextView)localObject4).setText((CharSequence)localContext.getResources().getString(b.j.finder_live_notice_start_live_time, new Object[] { Integer.valueOf(i + 1), Integer.valueOf(j), localObject2, localObject3 }));
              }
              parama = parama.SNb;
              if (parama != null)
              {
                p.j(parama, "desc");
                if (((CharSequence)parama).length() <= 0) {
                  break label922;
                }
                i = 1;
                if (i == 0) {
                  break label927;
                }
                if (parama != null)
                {
                  localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.i)localObject1).zcv;
                  if (localObject1 != null)
                  {
                    localObject1 = ((af)localObject1).zbm;
                    if (localObject1 != null) {
                      ((MMEditText)localObject1).setText((CharSequence)parama);
                    }
                  }
                }
              }
            }
          }
        }
      }
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("bindData liveData.business(LiveCommonSlice::class.java).isLiveStarted():").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()).append(" liveMicSetting:");
      parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgp;
      if (parama == null) {
        break label932;
      }
      parama = Long.valueOf(parama.field_liveMicSetting);
      label835:
      localObject2 = ((StringBuilder)localObject2).append(parama).append(" liveMicSettingSwitch:");
      parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgp;
      if (parama == null) {
        break label937;
      }
    }
    label900:
    label905:
    label911:
    label917:
    label922:
    label927:
    label932:
    label937:
    for (parama = Long.valueOf(parama.field_liveMicSettingSwitch);; parama = null)
    {
      Log.i((String)localObject1, parama);
      AppMethodBeat.o(279727);
      return;
      l = 0L;
      break;
      i = 0;
      break label215;
      l = 0L;
      break label267;
      l = 0L;
      break label300;
      i = 0;
      break label503;
      i = 0;
      break label730;
      parama = null;
      break label734;
      parama = null;
      break label835;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.e
 * JD-Core Version:    0.7.0.1
 */