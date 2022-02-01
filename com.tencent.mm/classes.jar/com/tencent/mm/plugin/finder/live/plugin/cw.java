package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.openim.model.q;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.convert.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveWecomBubble;", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePromoteItem;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "root", "Landroid/view/ViewGroup;", "afterAddAnim", "", "getView", "Landroid/view/View;", "handleSearchContactEnd", "scene", "Lcom/tencent/mm/openim/model/NetSceneSearchOpenIMContact;", "initView", "data", "", "onBubbleDel", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "delayMs", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "Lcom/tencent/mm/plugin/finder/live/view/convert/PromoteLiveWeComItem;", "updateView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cw
  implements com.tencent.mm.am.h, cx
{
  private final String TAG;
  private final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private final Context context;
  private ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  private w rYw;
  
  public cw(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(353805);
    this.context = paramContext;
    this.buContext = parama;
    this.nfT = paramb;
    this.TAG = "FinderLiveWecomBubble";
    paramContext = af.mU(this.context).inflate(p.f.Cgj, null);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(353805);
      throw paramContext;
    }
    this.mJe = ((ViewGroup)paramContext);
    AppMethodBeat.o(353805);
  }
  
  private static final void a(cw paramcw, g paramg, View paramView)
  {
    AppMethodBeat.i(353843);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramcw);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramg);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveWecomBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramcw, "this$0");
    kotlin.g.b.s.u(paramg, "$data");
    kotlin.g.b.s.X("close promote, data:", f.dh(paramg.DUL));
    com.tencent.e.f.h.jXD();
    paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
    com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(paramcw.buContext, 2, 3);
    paramcw = aj.CGT;
    paramcw = aj.elk();
    if (paramcw != null)
    {
      paramView = b.c.ndQ;
      localObject1 = new Bundle();
      localObject2 = new bla();
      ((bla)localObject2).id = paramg.DUI;
      ((bla)localObject2).type = 3;
      ((bla)localObject2).ZTU = new com.tencent.mm.bx.b(paramg.DUL.toByteArray());
      paramg = ah.aiuX;
      ((Bundle)localObject1).putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((bla)localObject2).toByteArray());
      paramg = ah.aiuX;
      paramcw.statusChange(paramView, (Bundle)localObject1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveWecomBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353843);
  }
  
  private final void a(g paramg)
  {
    AppMethodBeat.i(353822);
    Object localObject2 = this.mJe;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    View localView1 = ((ViewGroup)localObject1).findViewById(p.e.BIb);
    localObject2 = this.mJe;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    TextView localTextView = (TextView)((ViewGroup)localObject1).findViewById(p.e.BUq);
    localObject2 = this.mJe;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    View localView2 = ((ViewGroup)localObject1).findViewById(p.e.item_detail_container);
    com.tencent.mm.ui.aw.a((Paint)localTextView.getPaint(), 0.8F);
    localObject2 = this.mJe;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    localObject1 = (TextView)((ViewGroup)localObject1).findViewById(p.e.BUp);
    com.tencent.mm.ui.aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localTextView.setText((CharSequence)paramg.DUL.ZTZ);
    localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.s(this.buContext))
    {
      localView1.setVisibility(4);
      localView2.setOnClickListener(null);
      ((TextView)localObject1).setVisibility(4);
      AppMethodBeat.o(353822);
      return;
    }
    ((TextView)localObject1).setVisibility(0);
    localView1.setVisibility(0);
    localView1.setOnClickListener(new cw..ExternalSyntheticLambda0(this, paramg));
    localView2.setOnClickListener(new cw..ExternalSyntheticLambda1(this, paramg));
    AppMethodBeat.o(353822);
  }
  
  private static final void b(cw paramcw, g paramg, View paramView)
  {
    AppMethodBeat.i(353859);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramcw);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramg);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveWecomBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramcw, "this$0");
    kotlin.g.b.s.u(paramg, "$data");
    com.tencent.mm.kernel.h.aZW().a(372, (com.tencent.mm.am.h)paramcw);
    localObject2 = paramg.DUL.ZUc;
    kotlin.g.b.s.X("click to see wecom : ", localObject2);
    com.tencent.e.f.h.jXD();
    paramView = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.bgV())
    {
      localObject1 = paramcw.mJe;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("root");
        paramView = null;
      }
      aa.makeText(paramView.getContext(), (CharSequence)kotlin.g.b.s.X("contactid:", localObject2), 0).show();
    }
    com.tencent.mm.kernel.h.aZW().a((p)new q((String)localObject2, true), 0);
    paramcw.rYw = w.a(paramcw.context, (CharSequence)paramcw.context.getString(p.h.loading_tips_1), true, 3, null);
    paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
    paramView = paramcw.buContext;
    paramg = paramg.DUL.ZUc;
    paramcw = paramg;
    if (paramg == null) {
      paramcw = "";
    }
    com.tencent.mm.plugin.finder.live.component.statecomponent.b.b(paramView, 5, 3, paramcw);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveWecomBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353859);
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong) {}
  
  public final void eoK() {}
  
  public final void eoL() {}
  
  public final void fs(Object paramObject)
  {
    AppMethodBeat.i(353928);
    kotlin.g.b.s.u(paramObject, "data");
    if ((paramObject instanceof g)) {
      a((g)paramObject);
    }
    AppMethodBeat.o(353928);
  }
  
  public final void ft(Object paramObject)
  {
    AppMethodBeat.i(353942);
    kotlin.g.b.s.u(paramObject, "data");
    if ((paramObject instanceof g))
    {
      a((g)paramObject);
      Object localObject = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      com.tencent.mm.plugin.finder.live.model.context.a locala = this.buContext;
      localObject = ((g)paramObject).DUL.ZUc;
      paramObject = localObject;
      if (localObject == null) {
        paramObject = "";
      }
      com.tencent.mm.plugin.finder.live.component.statecomponent.b.b(locala, 1, 3, paramObject);
    }
    AppMethodBeat.o(353942);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(353953);
    ViewGroup localViewGroup = this.mJe;
    Object localObject = localViewGroup;
    if (localViewGroup == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject = null;
    }
    localObject = (View)localObject;
    AppMethodBeat.o(353953);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(353991);
    paramString = this.rYw;
    if (paramString != null) {
      paramString.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.openim.model.NetSceneSearchOpenIMContact");
        AppMethodBeat.o(353991);
        throw paramString;
      }
      paramString = ((q)paramp).psC;
      if (paramString != null)
      {
        paramp = paramString.UserName;
        Object localObject = Util.nullAsNil(paramp);
        kotlin.g.b.s.s(localObject, "nullAsNil(userName)");
        if (((CharSequence)localObject).length() <= 0) {
          break label206;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label211;
        }
        paramp = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramp);
        localObject = new Intent();
        com.tencent.mm.api.d.a((Intent)localObject, paramString, 161);
        if ((paramp != null) && (!com.tencent.mm.contact.d.rs(paramp.field_type))) {
          ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
        }
        c.b(this.context, "profile", ".ui.ContactInfoUI", (Intent)localObject);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aZW().b(372, (com.tencent.mm.am.h)this);
      AppMethodBeat.o(353991);
      return;
      label206:
      paramInt1 = 0;
      break;
      label211:
      Toast.makeText(this.context, p.h.CrO, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cw
 * JD-Core Version:    0.7.0.1
 */