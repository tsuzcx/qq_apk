package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "()V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "item", "itemPosition", "", "observer", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getLayoutId", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class by
  extends f<bs>
{
  public static final a ALD;
  private WxRecyclerAdapter<?> ALE;
  private bs ALF;
  private int dpP;
  private final y<l.a> observer;
  
  static
  {
    AppMethodBeat.i(350330);
    ALD = new a((byte)0);
    AppMethodBeat.o(350330);
  }
  
  public by()
  {
    AppMethodBeat.i(350301);
    this.observer = new by..ExternalSyntheticLambda1(this);
    this.dpP = -1;
    AppMethodBeat.o(350301);
  }
  
  private static final void a(by paramby, l.a parama)
  {
    String str = null;
    AppMethodBeat.i(350305);
    s.u(paramby, "this$0");
    if (parama == null)
    {
      AppMethodBeat.o(350305);
      return;
    }
    bs localbs = paramby.ALF;
    Object localObject;
    if (localbs != null)
    {
      localObject = parama.ASh;
      if (localObject != null) {
        break label125;
      }
    }
    for (;;)
    {
      localbs.sessionId = str;
      Log.i("Finder.PrivateMsgNotifyConvert", "isShow=" + parama.hBY + ' ' + localbs.sessionId);
      parama = paramby.ALE;
      if (parama != null) {
        parama.AQ(localbs.hashCode());
      }
      parama = paramby.ALE;
      if (parama != null) {
        parama.fV(paramby.dpP);
      }
      AppMethodBeat.o(350305);
      return;
      label125:
      localObject = ((p)localObject).avK("TLWxPrivateMsgBubble");
      if (localObject != null) {
        str = ((bxq)localObject).icon_url;
      }
    }
  }
  
  private static final void a(p paramp, bxq parambxq, j paramj, View paramView)
  {
    AppMethodBeat.i(350325);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramp);
    localb.cH(parambxq);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    if ((paramp != null) && (parambxq != null))
    {
      localObject = w.FrV;
      paramView = as.GSQ;
      paramView = paramj.context;
      s.s(paramView, "holder.context");
      paramView = as.a.hu(paramView);
      if (paramView != null) {
        break label170;
      }
    }
    label170:
    for (paramView = null;; paramView = paramView.fou())
    {
      w.a((w)localObject, "7", paramp, parambxq, 2, paramView, 0, null, 0, 480);
      paramp = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramp = paramj.context;
      s.s(paramp, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.hh(paramp);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350325);
      return;
    }
  }
  
  private static final void a(j paramj, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(350315);
    s.u(paramj, "$holder");
    s.u(paramString1, "$name");
    Log.i("Finder.PrivateMsgNotifyConvert", "[getNow] username=" + paramString2 + " succ=" + paramBoolean);
    com.tencent.mm.ui.i.a.a.h((ImageView)paramj.UH(e.e.msg_avatar), paramString1);
    AppMethodBeat.o(350315);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(350352);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    this.ALE = paramWxRecyclerAdapter;
    paramRecyclerView = l.ARA;
    l.dZP().a(this.observer);
    AppMethodBeat.o(350352);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350373);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350373);
  }
  
  public final void a(j paramj, bs parambs, int paramInt)
  {
    AppMethodBeat.i(350368);
    s.u(paramj, "holder");
    s.u(parambs, "item");
    this.ALF = parambs;
    this.dpP = paramInt;
    parambs = l.ARA;
    parambs = (l.a)l.dZP().getValue();
    label151:
    p localp;
    if ((parambs != null) && (parambs.hBY == true))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label287;
      }
      parambs = paramj.UH(e.e.msg_layout);
      parambs.setVisibility(0);
      aw.a((Paint)((TextView)paramj.UH(e.e.message_count)).getPaint(), 0.8F);
      localObject = parambs.getLayoutParams();
      paramInt = ar.Giw.ffL();
      if (((ViewGroup.LayoutParams)localObject).width < paramInt)
      {
        ((ViewGroup.LayoutParams)localObject).width = paramInt;
        parambs.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      parambs = l.ARA;
      parambs = (l.a)l.dZP().getValue();
      if (parambs != null) {
        break label254;
      }
      parambs = null;
      localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("TLWxPrivateMsgBubble");
      if (parambs != null) {
        break label278;
      }
    }
    label278:
    for (Object localObject = null;; localObject = parambs.icon_url)
    {
      localObject = ((bp)h.ax(bp.class)).aAw((String)localObject);
      if (localObject == null) {
        break label305;
      }
      az.a.okP.a((String)localObject, null, new by..ExternalSyntheticLambda2(paramj, (String)localObject));
      paramj.UH(e.e.msg_layout).setOnClickListener(new by..ExternalSyntheticLambda0(localp, parambs, paramj));
      AppMethodBeat.o(350368);
      return;
      paramInt = 0;
      break;
      label254:
      parambs = parambs.ASh;
      if (parambs == null)
      {
        parambs = null;
        break label151;
      }
      parambs = parambs.avK("TLWxPrivateMsgBubble");
      break label151;
    }
    label287:
    paramj = paramj.UH(e.e.msg_layout);
    if (paramj != null) {
      paramj.setVisibility(8);
    }
    label305:
    AppMethodBeat.o(350368);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(350358);
    s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    paramRecyclerView = l.ARA;
    l.dZP().b(this.observer);
    AppMethodBeat.o(350358);
  }
  
  public final int getLayoutId()
  {
    return e.f._feed_header_private_msg_notify_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.by
 * JD-Core Version:    0.7.0.1
 */