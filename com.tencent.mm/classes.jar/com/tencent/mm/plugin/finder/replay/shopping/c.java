package com.tencent.mm.plugin.finder.replay.shopping;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.aw;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.convert.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.replay.k.a;
import com.tencent.mm.plugin.finder.replay.viewmodel.c.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "baseData", "Lcom/tencent/mm/protocal/protobuf/FinderShoppingReplayBase;", "pluginLayout", "Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayPluginLayout;", "getPluginLayout", "()Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayPluginLayout;", "setPluginLayout", "(Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayPluginLayout;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "parseData1", "parseData2", "replayReady", "", "setWindowStyle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  private bvp Fmv;
  private FinderLiveShoppingReplayPluginLayout Fmw;
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(332572);
    AppMethodBeat.o(332572);
  }
  
  public final int getLayoutId()
  {
    return p.f.CfJ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(332603);
    super.onCreate(paramBundle);
    if ((getActivity() instanceof MMActivity)) {
      ((MMActivity)getActivity()).setSelfNavigationBarVisible(8);
    }
    getActivity().getWindow().addFlags(2097280);
    getActivity().getWindow().addFlags(67108864);
    Object localObject2;
    label227:
    int i;
    label251:
    Object localObject3;
    if (Build.VERSION.SDK_INT >= 21)
    {
      getActivity().getWindow().clearFlags(1024);
      getActivity().getWindow().clearFlags(512);
      getActivity().getWindow().clearFlags(67108864);
      if (getContext().getResources().getConfiguration().orientation == 2)
      {
        getActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
        getActivity().getWindow().addFlags(1024);
        getActivity().getWindow().addFlags(-2147483648);
        getActivity().getWindow().setStatusBarColor(0);
        getActivity().getWindow().setNavigationBarColor(0);
      }
    }
    else
    {
      getActivity().getWindow().setFormat(-3);
      getActivity().getWindow().setSoftInputMode(51);
      localObject2 = getIntent().getByteArrayExtra("KEY_PARAMS_KEY_VALUE");
      if (localObject2 != null) {
        break label342;
      }
      paramBundle = null;
      this.Fmv = paramBundle;
      paramBundle = this.Fmv;
      if ((paramBundle == null) || (paramBundle.replay_status != 1)) {
        break label360;
      }
      i = 1;
      if (i != 0) {
        break label376;
      }
      paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject2 = (Context)getActivity();
      localObject3 = new StringBuilder("(Debug)回放状态(");
      paramBundle = this.Fmv;
      if (paramBundle != null) {
        break label365;
      }
    }
    label342:
    label360:
    label365:
    for (paramBundle = (Bundle)localObject1;; paramBundle = Integer.valueOf(paramBundle.replay_status))
    {
      com.tencent.mm.plugin.finder.live.utils.a.aD((Context)localObject2, paramBundle + ")错误！");
      getActivity().finish();
      AppMethodBeat.o(332603);
      return;
      getActivity().getWindow().getDecorView().setSystemUiVisibility(1792);
      break;
      paramBundle = new bvp();
      paramBundle.parseFrom((byte[])localObject2);
      break label227;
      i = 0;
      break label251;
    }
    label376:
    paramBundle = this.Fmv;
    label407:
    label435:
    Object localObject4;
    label544:
    Object localObject5;
    label592:
    int j;
    label604:
    label745:
    Object localObject6;
    if (paramBundle == null)
    {
      paramBundle = null;
      paramBundle = (CharSequence)paramBundle;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label1417;
      }
      i = 1;
      if (i != 0)
      {
        paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject1 = (Context)getActivity();
        paramBundle = this.Fmv;
        if (paramBundle != null) {
          break label1422;
        }
        paramBundle = null;
        com.tencent.mm.plugin.finder.live.utils.a.aD((Context)localObject1, s.X("(Debug)回放url: ", paramBundle));
      }
      this.Fmw = new FinderLiveShoppingReplayPluginLayout((Context)getActivity(), null);
      ((ViewGroup)findViewById(p.e.Cba)).addView((View)this.Fmw);
      localObject3 = this.Fmv;
      if (localObject3 != null)
      {
        paramBundle = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        localObject4 = com.tencent.mm.plugin.finder.live.view.convert.a.k(((bvp)localObject3).aadr);
        if (localObject4 != null)
        {
          paramBundle = (com.tencent.mm.plugin.finder.replay.viewmodel.c)((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4).BxG.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
          localObject1 = ((bvp)localObject3).aadr;
          if (localObject1 != null) {
            break label1430;
          }
          i = 0;
          paramBundle.a(i, Boolean.TRUE);
          paramBundle = "";
          localObject5 = (q)((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4).BxG.business(q.class);
          if (((bvp)localObject3).aads == null) {
            break label1553;
          }
          paramBundle = ((bvp)localObject3).aads;
          if (paramBundle != null) {
            break label1473;
          }
          i = 0;
          paramBundle = ((bvp)localObject3).aadr;
          if (paramBundle != null) {
            break label1495;
          }
          j = 0;
          if (i > j) {
            ((com.tencent.mm.plugin.finder.replay.viewmodel.c)((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4).BxG.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).Sa(i - j);
          }
          localObject1 = new StringBuilder("initReplayStartOffset replayBeginTime:").append(i).append(",liveStartTime:").append(j).append(",replayStartOffset").append(((com.tencent.mm.plugin.finder.replay.viewmodel.c)((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4).BxG.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmL).append(",replayId:").append(d.hF(((bvp)localObject3).ZRl)).append(",product_id:");
          paramBundle = ((bvp)localObject3).aads;
          if (paramBundle != null) {
            break label1517;
          }
          paramBundle = null;
          label716:
          Log.i("SimpleUIComponent", paramBundle);
          paramBundle = ((bvp)localObject3).aads;
          if (paramBundle != null) {
            break label1528;
          }
          paramBundle = "";
          localObject1 = ((bvp)localObject3).aads;
          s.checkNotNull(localObject1);
          s.s(localObject1, "_baseData.promoting_info!!");
          localObject6 = new com.tencent.mm.plugin.finder.live.view.convert.k((bzc)localObject1);
          localObject2 = ((bvp)localObject3).DUN;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject6).ayc((String)localObject1);
          localObject1 = ah.aiuX;
          localObject1 = (cc)localObject6;
        }
      }
    }
    for (;;)
    {
      ((q)localObject5).d((cc)localObject1);
      localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4).BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
      localObject2 = ((bvp)localObject3).ZRm;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((bip)localObject5).ZRm = ((String)localObject1);
      localObject1 = this.Fmw;
      if (localObject1 != null) {
        ((FinderLiveShoppingReplayPluginLayout)localObject1).bindData((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4);
      }
      localObject1 = this.Fmw;
      if (localObject1 != null)
      {
        localObject1 = ((FinderLiveShoppingReplayPluginLayout)localObject1).getBuContext();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.replay.k.Fky.eLF();
          localObject5 = new com.tencent.mm.plugin.finder.replay.model.a();
          ((com.tencent.mm.plugin.finder.replay.model.a)localObject5).FlP = false;
          ((com.tencent.mm.plugin.finder.replay.model.a)localObject5).FlQ = false;
          localObject6 = ah.aiuX;
          ((com.tencent.mm.plugin.finder.replay.k)localObject2).a((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, (com.tencent.mm.plugin.finder.replay.model.a)localObject5);
        }
      }
      localObject1 = this.Fmw;
      if (localObject1 != null)
      {
        com.tencent.mm.plugin.finder.replay.k.Fky.eLF().a((aw)((FinderLiveShoppingReplayPluginLayout)localObject1).getSeiProcessViewCallbackProxy());
        com.tencent.mm.plugin.finder.replay.k.a(com.tencent.mm.plugin.finder.replay.k.Fky.eLF(), -1, null, false, 6);
        if (((com.tencent.mm.plugin.finder.replay.viewmodel.c)((FinderLiveShoppingReplayPluginLayout)localObject1).business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmL > 0)
        {
          localObject2 = (com.tencent.mm.plugin.finder.replay.viewmodel.a)((FinderLiveShoppingReplayPluginLayout)localObject1).business(com.tencent.mm.plugin.finder.replay.viewmodel.a.class);
          i = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)((FinderLiveShoppingReplayPluginLayout)localObject1).business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmL;
          if (i != ((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject2).FmD)
          {
            Log.i("LiveMsgOffsetSlice", "startOffsetSec from:" + ((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject2).FmD + " to " + i);
            ((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject2).FmD = i;
          }
          com.tencent.mm.plugin.finder.replay.k.Fky.eLF().a(new com.tencent.mm.plugin.finder.replay.c(com.tencent.mm.plugin.finder.replay.k.Fky.eLF(), new com.tencent.mm.plugin.finder.replay.model.f(3)).eLt());
        }
        ((FinderLiveShoppingReplayPluginLayout)localObject1).getShoppingReplayBaseUIC().eBc();
        ((FinderLiveShoppingReplayPluginLayout)localObject1).getShoppingReplayDecorateUIC().eBc();
      }
      localObject1 = this.Fmw;
      if (localObject1 != null) {
        ((FinderLiveShoppingReplayPluginLayout)localObject1).mount();
      }
      com.tencent.mm.plugin.finder.replay.k.Fky.eLF().a((com.tencent.mm.plugin.finder.replay.widget.e)this.Fmw);
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("type", 12);
      ((JSONObject)localObject2).put("sessionid", ((bvp)localObject3).hQR);
      ((JSONObject)localObject2).put("productid", paramBundle);
      localObject5 = ah.aiuX;
      localObject5 = new JSONObject();
      ((JSONObject)localObject5).put("entrance", ((bvp)localObject3).source);
      localObject6 = ah.aiuX;
      ((com.tencent.mm.plugin.finder.live.report.k)localObject1).b((JSONObject)localObject2, (JSONObject)localObject5);
      ((com.tencent.mm.plugin.finder.replay.viewmodel.c)((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4).BxG.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).enterTime = SystemClock.elapsedRealtime();
      localObject4 = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject4).BxG.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).eLZ();
      localObject2 = ((bvp)localObject3).hQR;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      s.u(localObject1, "<set-?>");
      ((c.b)localObject4).hQR = ((String)localObject1);
      localObject2 = ((bvp)localObject3).source;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      s.u(localObject1, "<set-?>");
      ((c.b)localObject4).source = ((String)localObject1);
      s.u(paramBundle, "<set-?>");
      ((c.b)localObject4).productId = paramBundle;
      Log.i("SimpleUIComponent", s.X("shoppingReport:", localObject4));
      AppMethodBeat.o(332603);
      return;
      paramBundle = paramBundle.ZRm;
      break;
      label1417:
      i = 0;
      break label407;
      label1422:
      paramBundle = paramBundle.ZRm;
      break label435;
      label1430:
      localObject1 = ((FinderObject)localObject1).liveInfo;
      if (localObject1 == null)
      {
        i = 0;
        break label544;
      }
      localObject1 = ((bip)localObject1).ZSm;
      if (localObject1 == null)
      {
        i = 0;
        break label544;
      }
      i = ((blz)localObject1).ZUJ;
      break label544;
      label1473:
      paramBundle = paramBundle.aaij;
      if (paramBundle == null)
      {
        i = 0;
        break label592;
      }
      i = paramBundle.ftu;
      break label592;
      label1495:
      paramBundle = paramBundle.liveInfo;
      if (paramBundle == null)
      {
        j = 0;
        break label604;
      }
      j = paramBundle.startTime;
      break label604;
      label1517:
      paramBundle = Long.valueOf(paramBundle.DVk);
      break label716;
      label1528:
      paramBundle = Long.valueOf(paramBundle.DVk).toString();
      if (paramBundle == null)
      {
        paramBundle = "";
        break label745;
      }
      break label745;
      label1553:
      if (((bvp)localObject3).aadt != null)
      {
        paramBundle = ((bvp)localObject3).aadt;
        if (paramBundle == null) {
          paramBundle = "";
        }
        for (;;)
        {
          localObject1 = ((bvp)localObject3).aadt;
          s.checkNotNull(localObject1);
          s.s(localObject1, "_baseData.coupon_info!!");
          localObject1 = (cc)new j((bvo)localObject1);
          break;
          paramBundle = paramBundle.aadf;
          if (paramBundle == null) {
            paramBundle = "";
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(332610);
    Object localObject1 = this.Fmw;
    if (localObject1 != null)
    {
      localObject1 = ((FinderLiveShoppingReplayPluginLayout)localObject1).getData();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject1).BxG;
        if (localObject1 != null)
        {
          Object localObject2 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
          if (localObject2 != null)
          {
            localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("type", 13);
            localJSONObject.put("sessionid", ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject2).eLZ().hQR);
            localJSONObject.put("productid", ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject2).eLZ().productId);
            Object localObject3 = ah.aiuX;
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("during", SystemClock.elapsedRealtime() - ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject2).enterTime);
            localObject2 = ah.aiuX;
            ((com.tencent.mm.plugin.finder.live.report.k)localObject1).b(localJSONObject, (JSONObject)localObject3);
          }
        }
      }
    }
    localObject1 = this.Fmw;
    if (localObject1 != null)
    {
      ((FinderLiveShoppingReplayPluginLayout)localObject1).getShoppingReplayBaseUIC().deactivate();
      ((FinderLiveShoppingReplayPluginLayout)localObject1).getShoppingReplayDecorateUIC();
      com.tencent.mm.plugin.finder.replay.k.Fky.eLF().b((aw)((FinderLiveShoppingReplayPluginLayout)localObject1).getSeiProcessViewCallbackProxy());
    }
    localObject1 = this.Fmw;
    if (localObject1 != null) {
      ((FinderLiveShoppingReplayPluginLayout)localObject1).unMount();
    }
    super.onDestroy();
    AppMethodBeat.o(332610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.shopping.c
 * JD-Core Version:    0.7.0.1
 */