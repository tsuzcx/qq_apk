package com.tencent.mm.plugin.finder.replay.shopping;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.plugin.by;
import com.tencent.mm.plugin.finder.live.view.convert.j;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.live.widget.az;
import com.tencent.mm.plugin.finder.model.aq;
import com.tencent.mm.plugin.finder.replay.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayDecorateUIC;", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "shoppintBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "getShoppintBubblePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "setShoppintBubblePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;)V", "activate", "", "deactivate", "gotoFinderLive", "initLogic", "initPlugins", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends l
{
  private by Fmq;
  private final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(332570);
    this.TAG = "FinderLiveShoppingReplayDecorateUIC";
    AppMethodBeat.o(332570);
  }
  
  private static final void G(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(332578);
    s.u(paramViewGroup, "$this_apply");
    Object localObject1 = paramViewGroup.getLayoutParams();
    Object localObject2;
    if ((localObject1 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      if (localObject1 != null)
      {
        localObject2 = paramViewGroup.getLayoutParams();
        if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
          break label74;
        }
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        label49:
        if (localObject2 != null) {
          break label79;
        }
      }
    }
    label74:
    label79:
    for (paramViewGroup = null;; paramViewGroup = Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject2).topMargin + bf.getStatusBarHeight(paramViewGroup.getContext())))
    {
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramViewGroup.intValue();
      AppMethodBeat.o(332578);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label49;
    }
  }
  
  private static final void a(a parama, com.tencent.mm.plugin.finder.live.view.a parama1, View paramView)
  {
    AppMethodBeat.i(332588);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayDecorateUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(parama, "this$0");
    s.u(parama1, "$_basePluginLayout");
    FinderObject localFinderObject = ((e)parama.business(e.class)).Eco;
    if (localFinderObject == null)
    {
      paramView = null;
      if (paramView == null) {
        Log.e(parama.TAG, "gotoFinderLive error finderObject is null!");
      }
      parama = parama.FkM;
      if (parama != null) {
        parama.finish();
      }
      if (!(parama1 instanceof FinderLiveShoppingReplayPluginLayout)) {
        break label527;
      }
    }
    label519:
    label527:
    for (parama = (FinderLiveShoppingReplayPluginLayout)parama1;; parama = null)
    {
      if (parama != null)
      {
        parama = parama.getUiClickListener();
        if (parama != null) {
          parama.eqV();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayDecorateUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332588);
      return;
      long l;
      if (Util.isEqual(localFinderObject.username, z.bAW()))
      {
        paramView = h.ax(f.class);
        s.s(paramView, "service(IActivityRouter::class.java)");
        localObject3 = (f)paramView;
        Context localContext = (Context)parama.CCa;
        l = localFinderObject.id;
        localObject1 = localFinderObject.objectNonceId;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        localObject2 = localFinderObject.liveInfo;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new bip();
        }
        com.tencent.mm.plugin.f.a.a((f)localObject3, localContext, l, paramView, (bip)localObject1, null, null, null, null, null, localFinderObject.sessionBuffer, null, null, 7152);
        paramView = ah.aiuX;
        break;
      }
      localObject2 = new FinderLiveBundle();
      Object localObject3 = new LiveConfig.a();
      ((LiveConfig.a)localObject3).mIy = LiveConfig.mIt;
      paramView = localFinderObject.liveInfo;
      if (paramView == null)
      {
        l = 0L;
        label334:
        ((LiveConfig.a)localObject3).liveId = l;
        localObject1 = localFinderObject.objectNonceId;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        ((LiveConfig.a)localObject3).nonceId = paramView;
        ((LiveConfig.a)localObject3).mIE = "";
        ((LiveConfig.a)localObject3).mIH = localFinderObject.id;
        localObject1 = localFinderObject.username;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        ((LiveConfig.a)localObject3).mIC = paramView;
        paramView = localFinderObject.objectDesc;
        if (paramView != null) {
          break label519;
        }
      }
      for (paramView = null;; paramView = paramView.description)
      {
        ((LiveConfig.a)localObject3).desc = paramView;
        ((LiveConfig.a)localObject3).sessionBuffer = localFinderObject.sessionBuffer;
        paramView = ((LiveConfig.a)localObject3).bcd();
        s.s(paramView, "builder.toWhere(LiveConf…                 .build()");
        ((FinderLiveBundle)localObject2).CEY = 0;
        ((FinderLiveBundle)localObject2).CFa.clear();
        ((FinderLiveBundle)localObject2).CFa.add(paramView);
        paramView = h.ax(f.class);
        s.s(paramView, "service(IActivityRouter::class.java)");
        paramView = Integer.valueOf(com.tencent.mm.plugin.f.a.a((f)paramView, (Context)parama.CCa, (FinderLiveBundle)localObject2, null, null, null, false, 60));
        break;
        l = paramView.liveId;
        break label334;
      }
    }
  }
  
  public final void c(com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(332605);
    s.u(parama, "baseRouter");
    super.c(parama);
    parama = this.FkM;
    if (parama != null)
    {
      ViewGroup localViewGroup = (ViewGroup)parama.findViewById(p.e.title_container);
      if (localViewGroup != null)
      {
        localViewGroup.post(new a..ExternalSyntheticLambda1(localViewGroup));
        localViewGroup.setOnClickListener(new a..ExternalSyntheticLambda0(this, parama));
      }
      localViewGroup = (ViewGroup)parama.findViewById(p.e.bubble_container);
      if (localViewGroup != null) {
        this.Fmq = new by((ViewGroup)new FrameLayout((Context)this.CCa), localViewGroup, (com.tencent.mm.live.b.b)parama);
      }
    }
    AppMethodBeat.o(332605);
  }
  
  public final void deactivate() {}
  
  public final void eBc()
  {
    AppMethodBeat.i(332615);
    ((e)business(e.class)).EcT = 2;
    Object localObject1 = d.AwY;
    localObject1 = ((e)business(e.class)).Eco;
    label58:
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = null;
      Object localObject2 = d.a.auT((String)localObject1);
      localObject1 = this.FkM;
      if (localObject1 != null) {
        break label267;
      }
      localObject1 = null;
      if ((localObject2 != null) && (localObject1 != null)) {
        ((TextView)localObject1).setText((CharSequence)p.b((Context)this.CCa, (CharSequence)((m)localObject2).dUr(), ((TextView)localObject1).getTextSize()));
      }
      localObject1 = ((q)business(q.class)).Eie;
      if (!(localObject1 instanceof k)) {
        break label281;
      }
      bool = true;
      label117:
      if (!bool) {
        break label289;
      }
      localObject1 = this.Fmq;
      if (localObject1 != null) {
        ((by)localObject1).tO(0);
      }
      localObject1 = ((q)business(q.class)).Eie;
      if (localObject1 != null)
      {
        localObject2 = this.Fmq;
        if (localObject2 != null)
        {
          aq localaq = new aq();
          localaq.EDd = true;
          localaq.EDc = false;
          localaq.EDb = false;
          ah localah = ah.aiuX;
          s.u(localaq, "config");
          ((by)localObject2).erU().setShoppingUIConfig(localaq);
        }
        localObject2 = this.Fmq;
        if (localObject2 != null) {
          ((by)localObject2).ft(localObject1);
        }
      }
    }
    for (;;)
    {
      localObject1 = this.FkM;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.view.a)localObject1).fillBlurBg(((e)business(e.class)).mIC, true);
      }
      AppMethodBeat.o(332615);
      return;
      localObject1 = ((FinderObject)localObject1).username;
      break;
      label267:
      localObject1 = (TextView)((com.tencent.mm.plugin.finder.live.view.a)localObject1).findViewById(p.e.nick_name_tv);
      break label58;
      label281:
      bool = localObject1 instanceof j;
      break label117;
      label289:
      if ((localObject1 instanceof j))
      {
        localObject1 = this.FkM;
        if (localObject1 != null) {
          b.b.a((com.tencent.mm.live.b.b)localObject1, b.c.ndG);
        }
        localObject1 = this.Fmq;
        if (localObject1 != null) {
          ((by)localObject1).tO(0);
        }
      }
      else
      {
        localObject1 = this.Fmq;
        if (localObject1 != null) {
          ((by)localObject1).tO(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.shopping.a
 * JD-Core Version:    0.7.0.1
 */