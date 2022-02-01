package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.cgi.p;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostStickerWidget;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "stickerLayout", "Landroid/view/ViewGroup;", "appid", "", "scene", "", "refreshCallback", "Lkotlin/Function2;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Ljava/lang/String;ILkotlin/jvm/functions/Function2;)V", "TAG", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getAppid", "()Ljava/lang/String;", "descTv", "Landroid/widget/TextView;", "hasJumpWebView", "getRefreshCallback", "()Lkotlin/jvm/functions/Function2;", "getScene", "()I", "getStickerLayout", "()Landroid/view/ViewGroup;", "onResume", "refresh", "url", "hasSetSticker", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private final ViewGroup ElE;
  private final m<String, Boolean, ah> ElF;
  private boolean ElG;
  private final String TAG;
  private final MMActivity activity;
  public final String appid;
  private final TextView descTv;
  private final int scene;
  
  public c(MMActivity paramMMActivity, ViewGroup paramViewGroup, String paramString, int paramInt, m<? super String, ? super Boolean, ah> paramm)
  {
    AppMethodBeat.i(361011);
    this.activity = paramMMActivity;
    this.ElE = paramViewGroup;
    this.appid = paramString;
    this.scene = paramInt;
    this.ElF = paramm;
    this.TAG = "Finder.FinderGameLivePostStickerWidget";
    this.descTv = ((TextView)this.ElE.findViewById(p.e.BVt));
    AppMethodBeat.o(361011);
  }
  
  private static final ah a(c paramc, b.a parama)
  {
    cbb localcbb = null;
    AppMethodBeat.i(361033);
    kotlin.g.b.s.u(paramc, "this$0");
    Object localObject2;
    Object localObject1;
    Object localObject3;
    label94:
    label113:
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = ((bil)parama.ott).ZRA;
      kotlin.g.b.s.s(parama, "it.resp.game_user_info_list");
      localObject2 = ((Iterable)parama).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        localObject3 = (ccb)localObject1;
        parama = ((ccb)localObject3).aals;
        if (parama == null)
        {
          parama = null;
          if (Util.isNullOrNil(parama)) {
            break label180;
          }
          parama = ((ccb)localObject3).aals;
          if (parama != null) {
            break label172;
          }
          parama = null;
          if (!kotlin.g.b.s.p(parama, paramc.appid)) {
            break label180;
          }
          i = 1;
          label126:
          if (i == 0) {
            break label183;
          }
          parama = (b.a)localObject1;
          label133:
          localObject1 = (ccb)parama;
          if (localObject1 != null) {
            break label190;
          }
          Log.i(paramc.TAG, "no game match");
        }
      }
    }
    for (;;)
    {
      paramc = ah.aiuX;
      AppMethodBeat.o(361033);
      return paramc;
      parama = parama.app_id;
      break label94;
      label172:
      parama = parama.app_id;
      break label113;
      label180:
      i = 0;
      break label126;
      label183:
      break;
      parama = null;
      break label133;
      label190:
      localObject2 = paramc.TAG;
      localObject3 = new StringBuilder("refresh url:");
      parama = ((ccb)localObject1).aals;
      if (parama == null)
      {
        parama = null;
        label219:
        localObject3 = ((StringBuilder)localObject3).append(parama).append(", hasSet:");
        parama = ((ccb)localObject1).aals;
        if (parama != null) {
          break label311;
        }
        parama = null;
        label244:
        Log.i((String)localObject2, parama);
        parama = ((ccb)localObject1).aals;
        if (parama != null) {
          break label322;
        }
        parama = localcbb;
        label271:
        localcbb = ((ccb)localObject1).aals;
        if ((localcbb == null) || (localcbb.ZXv != true)) {
          break label330;
        }
      }
      label311:
      label322:
      label330:
      for (boolean bool = true;; bool = false)
      {
        paramc.bD(parama, bool);
        break;
        parama = parama.aakm;
        break label219;
        parama = Boolean.valueOf(parama.ZXv);
        break label244;
        parama = parama.aakm;
        break label271;
      }
      Log.i(paramc.TAG, "CGI error");
    }
  }
  
  private static final void a(c paramc, String paramString, View paramView)
  {
    AppMethodBeat.i(361020);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramString);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderGameLivePostStickerWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
    com.tencent.mm.plugin.finder.utils.s.bF(10, "{\"gameappid\":\"" + paramc.appid + "\"}");
    paramView = (CharSequence)paramString;
    int i;
    if ((paramView == null) || (paramView.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label167;
      }
      Log.i(paramc.TAG, kotlin.g.b.s.X("url empty:", paramString));
    }
    for (;;)
    {
      a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderGameLivePostStickerWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361020);
      return;
      i = 0;
      break;
      label167:
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramString);
      paramView.putExtra("show_full_screen", true);
      com.tencent.mm.br.c.b((Context)paramc.activity, "webview", ".ui.tools.WebViewUI", paramView);
      paramc.ElG = true;
    }
  }
  
  public final void bD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(361055);
    this.ElF.invoke(paramString, Boolean.valueOf(paramBoolean));
    TextView localTextView = this.descTv;
    Resources localResources;
    if (localTextView != null)
    {
      localResources = this.activity.getResources();
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (int i = p.h.CgD;; i = p.h.CgC)
    {
      localTextView.setText(localResources.getText(i));
      this.ElE.setOnClickListener(new c..ExternalSyntheticLambda0(this, paramString));
      AppMethodBeat.o(361055);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(361062);
    if (this.ElG) {
      new p(this.appid, this.scene).e((Context)this.activity, this.activity.getResources().getString(p.h.finder_waiting), 500L).bFJ().a((com.tencent.mm.vending.e.b)this.activity).g(new c..ExternalSyntheticLambda1(this));
    }
    this.ElG = false;
    AppMethodBeat.o(361062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.c
 * JD-Core Version:    0.7.0.1
 */