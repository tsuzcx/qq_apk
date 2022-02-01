package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.b;
import com.tencent.mm.plugin.finder.live.model.ae;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.util.u;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemLocation;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "POI_ICON_HEIGHT_SIZE", "", "getPOI_ICON_HEIGHT_SIZE", "()I", "POI_ICON_HEIGHT_SIZE$delegate", "Lkotlin/Lazy;", "POI_ICON_WIDTH_SIZE", "getPOI_ICON_WIDTH_SIZE", "POI_ICON_WIDTH_SIZE$delegate", "TAG", "", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msgType", "onBindPoiMsg", "commentData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends b
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final j CLS;
  private final j CLT;
  private final String TAG;
  
  public o(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359890);
    this.CBK = parama;
    this.TAG = "CommentItemLocation";
    this.CLS = kotlin.k.cm((kotlin.g.a.a)o.b.CLV);
    this.CLT = kotlin.k.cm((kotlin.g.a.a)o.a.CLU);
    AppMethodBeat.o(359890);
  }
  
  public final aq a(bdm parambdm)
  {
    AppMethodBeat.i(359910);
    s.u(parambdm, "msg");
    parambdm = (aq)new ae(parambdm);
    AppMethodBeat.o(359910);
    return parambdm;
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359937);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    super.a(paramContext, parama, paramaq, paramInt);
    int i;
    if (((e)this.CBK.business(e.class)).Ecv)
    {
      localObject1 = u.DJC;
      if (!u.bUx())
      {
        i = 1;
        localObject1 = paramaq.ekF();
        if (!(localObject1 instanceof bel)) {
          break label114;
        }
      }
    }
    label114:
    for (final bel localbel = (bel)localObject1;; localbel = null)
    {
      if (localbel != null) {
        break label120;
      }
      Log.i(this.TAG, "[onBindPoiMsg]: payload is not FinderLiveAppMsgLocationInfo");
      AppMethodBeat.o(359937);
      return;
      i = 0;
      break;
    }
    label120:
    Object localObject1 = localbel.location;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      localObject1 = (CharSequence)localObject2;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label196;
      }
    }
    label196:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label202;
      }
      Log.i(this.TAG, s.X("[onBindPoiMsg]: city is null or empty:", localObject2));
      AppMethodBeat.o(359937);
      return;
      localObject2 = ((boi)localObject1).city;
      break;
    }
    label202:
    localObject1 = paramaq.eku();
    label226:
    Object localObject3;
    Object localObject4;
    label279:
    label341:
    Object localObject5;
    label456:
    String str;
    label536:
    int j;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label694;
      }
      paramInt = 0;
      if (paramInt <= 0) {
        break label704;
      }
      localObject3 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
      localObject3 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
      localObject3 = kotlin.a.k.z(com.tencent.mm.plugin.finder.live.view.span.h.ewL(), 6);
      localObject4 = parama.DQt;
      localObject3 = com.tencent.mm.plugin.finder.live.view.span.h.a((List)localObject1, (int[])localObject3, 0, 0, 4, (View)localObject4, 12);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject4 = com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.djQ(), paramaq.ekt());
      localObject1 = localObject4;
      if (i != 0)
      {
        localObject1 = u.DJC;
        localObject1 = localObject4;
        if (!u.bUx())
        {
          localObject1 = paramaq.eku();
          if (localObject1 != null) {
            break label710;
          }
          localObject1 = null;
          localObject1 = r.io((String)localObject1, (String)localObject4);
          s.s(localObject1, "makeAnonymousNameIfIsMyS…romNickname\n            )");
        }
      }
      localObject4 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(localObject4, "service(IFinderCommonService::class.java)");
      localObject4 = (com.tencent.mm.plugin.h)localObject4;
      localObject5 = parama.DQt.getPaint();
      s.s(localObject5, "holder.contentTv.paint");
      localObject4 = h.a.a((com.tencent.mm.plugin.h)localObject4, paramContext, (TextPaint)localObject5, (CharSequence)localObject1);
      if ((!au.bwV(paramaq.djQ())) || (i != 0)) {
        break label738;
      }
      localObject1 = (CharSequence)(localObject4 + eja());
      str = paramContext.getString(p.h.live_comment_row_content_tmpl, new Object[] { localObject1 });
      s.s(str, "context.getString(\n     …romUserNickName\n        )");
      localObject1 = paramContext.getString(p.h.finder_live_comment_i_am_in_the_specified_city, new Object[] { localObject2 });
      s.s(localObject1, "context.getString(R.stri…the_specified_city, city)");
      localObject5 = (CharSequence)localbel.content;
      if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
        break label745;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label751;
      }
      j = 1;
      label544:
      if (j == 0) {
        break label1170;
      }
      localObject5 = localbel.content;
      localObject1 = localObject5;
      if (localObject5 == null) {
        localObject1 = "";
      }
    }
    label1170:
    for (;;)
    {
      parama.DQt.setTag(p.e.BEl, localObject1);
      localObject1 = new q(p.d(paramContext, (CharSequence)b("", (List)localObject3, str, (String)localObject1), 0.0F));
      if (localObject3 != null)
      {
        localObject3 = ((Iterable)localObject3).iterator();
        for (paramInt = 0;; paramInt = k)
        {
          k = paramInt;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject5 = (ImageSpan)((Iterator)localObject3).next();
          k = paramInt + 1;
          ((q)localObject1).setSpan(localObject5, paramInt, k, 33);
        }
        localObject1 = ((bgh)localObject1).ZKa;
        break;
        label694:
        paramInt = ((LinkedList)localObject1).size();
        break label226;
        label704:
        localObject3 = null;
        break label279;
        label710:
        localObject1 = ((bgh)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label341;
        }
        localObject1 = ((FinderContact)localObject1).username;
        break label341;
        label738:
        localObject1 = localObject4;
        break label456;
        label745:
        paramInt = 0;
        break label536;
        label751:
        j = 0;
        break label544;
      }
      int k = 0;
      ((q)localObject1).a(ejc(), (CharSequence)str, k);
      paramInt = n.a((CharSequence)localObject1, (String)localObject2, 0, false, 6);
      if ((paramInt >= 0) && (((String)localObject2).length() + paramInt <= ((q)localObject1).length())) {
        ((q)localObject1).setSpan(new c(paramContext, localbel), paramInt, ((String)localObject2).length() + paramInt, 33);
      }
      if (j == 0)
      {
        localObject2 = bb.e(paramContext.getResources().getDrawable(p.g.icons_filled_location), paramContext.getResources().getColor(p.b.ByV));
        ((Drawable)localObject2).setBounds(0, 0, ((Number)this.CLS.getValue()).intValue(), ((Number)this.CLT.getValue()).intValue());
        ((q)localObject1).setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject2, 1), ((q)localObject1).length() - 1, ((q)localObject1).length(), 33);
        ((q)localObject1).setSpan(new d(paramContext, localbel), ((q)localObject1).length() - 1, ((q)localObject1).length(), 33);
      }
      if ((au.bwV(paramaq.djQ())) && (i == 0))
      {
        paramaq = eje();
        paramInt = n.a((CharSequence)localObject1, localObject4.toString(), 0, false);
        ((q)localObject1).setSpan(paramaq, ((CharSequence)localObject4).length() + paramInt, n.a((CharSequence)localObject1, localObject4.toString(), 0, false) + ((CharSequence)localObject4).length() + eja().length(), 33);
      }
      parama.DQt.aZ((CharSequence)localObject1);
      parama.DQt.setTextSize(ejf());
      parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
      paramContext = parama.DQt.getParent();
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(359937);
        throw paramContext;
      }
      paramContext = (RelativeLayout)paramContext;
      if (k == 0) {}
      for (paramInt = eiZ();; paramInt = 0)
      {
        paramContext.setPadding(paramInt, paramContext.getPaddingTop(), paramContext.getPaddingRight(), paramContext.getPaddingBottom());
        AppMethodBeat.o(359937);
        return;
      }
    }
  }
  
  public final int eiV()
  {
    return 20035;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/commentitem/CommentItemLocation$onBindPoiMsg$2", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends ClickableSpan
  {
    c(Context paramContext, bel parambel) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(360004);
      s.u(paramView, "widget");
      o.a(this.$context, localbel);
      AppMethodBeat.o(360004);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(360015);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(this.$context.getResources().getColor(p.b.ByU));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(360015);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/commentitem/CommentItemLocation$onBindPoiMsg$3", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends ClickableSpan
  {
    d(Context paramContext, bel parambel) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(360003);
      s.u(paramView, "widget");
      o.a(this.$context, localbel);
      AppMethodBeat.o(360003);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(360012);
      s.u(paramTextPaint, "ds");
      AppMethodBeat.o(360012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.o
 * JD-Core Version:    0.7.0.1
 */