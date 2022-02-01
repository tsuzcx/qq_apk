package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.b;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.t;
import com.tencent.mm.plugin.finder.live.p.d;
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
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemReply;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msgType", "onBindAtMsg", "commentData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends b
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  
  public s(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359909);
    this.CBK = parama;
    AppMethodBeat.o(359909);
  }
  
  public final aq a(bdm parambdm)
  {
    AppMethodBeat.i(359921);
    kotlin.g.b.s.u(parambdm, "msg");
    parambdm = (aq)new t(parambdm);
    AppMethodBeat.o(359921);
    return parambdm;
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359947);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "holder");
    kotlin.g.b.s.u(paramaq, "msg");
    int i;
    label84:
    Object localObject2;
    label117:
    Object localObject3;
    label140:
    label166:
    Object localObject4;
    label213:
    Object localObject5;
    if (((e)this.CBK.business(e.class)).Ecv)
    {
      localObject1 = u.DJC;
      if (!u.bUx())
      {
        i = 1;
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.c(paramaq)) {
          break label674;
        }
        parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.BzL));
        if (!kotlin.g.b.s.p(((e)this.CBK.business(e.class)).mIC, paramaq.djQ())) {
          break label694;
        }
        localObject2 = eiY();
        kotlin.g.b.s.s(localObject2, "if (liveContext.business…orTag\n            else \"\"");
        if (((CharSequence)localObject2).length() != 0) {
          break label702;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label718;
        }
        localObject1 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
        localObject1 = paramaq.eku();
        if (localObject1 != null) {
          break label708;
        }
        localObject1 = null;
        localObject3 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
        localObject3 = k.z(k.z(com.tencent.mm.plugin.finder.live.view.span.h.ewL(), 6), 3);
        localObject4 = parama.DQt;
        localObject3 = com.tencent.mm.plugin.finder.live.view.span.h.a((List)localObject1, (int[])localObject3, 0, 0, 4, (View)localObject4, 12);
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject4 = com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.djQ(), paramaq.ekt());
        localObject1 = localObject4;
        if (i != 0)
        {
          localObject1 = paramaq.eku();
          if (localObject1 != null) {
            break label724;
          }
          localObject1 = null;
          label260:
          localObject1 = r.io((String)localObject1, (String)localObject4);
          kotlin.g.b.s.s(localObject1, "makeAnonymousNameIfIsMyS…romNickname\n            )");
        }
        localObject4 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        kotlin.g.b.s.s(localObject4, "service(IFinderCommonService::class.java)");
        localObject4 = (com.tencent.mm.plugin.h)localObject4;
        localObject5 = parama.DQt.getPaint();
        kotlin.g.b.s.s(localObject5, "holder.contentTv.paint");
        localObject5 = h.a.a((com.tencent.mm.plugin.h)localObject4, paramContext, (TextPaint)localObject5, (CharSequence)localObject1);
        if ((!au.bwV(paramaq.djQ())) || (i != 0)) {
          break label752;
        }
        localObject4 = (CharSequence)(localObject5 + eja());
        label372:
        localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        kotlin.g.b.s.s(localObject1, "service(IFinderCommonService::class.java)");
        com.tencent.mm.plugin.h localh = (com.tencent.mm.plugin.h)localObject1;
        TextPaint localTextPaint = parama.DQt.getPaint();
        kotlin.g.b.s.s(localTextPaint, "holder.contentTv.paint");
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject1 = paramaq.ekv();
        if (localObject1 != null) {
          break label759;
        }
        localObject1 = null;
        label430:
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject1 = h.a.a(localh, paramContext, localTextPaint, (CharSequence)com.tencent.mm.plugin.finder.live.utils.a.hR((String)localObject1, com.tencent.mm.plugin.finder.live.utils.a.e(paramaq)));
        localObject1 = paramContext.getString(p.h.Cta, new Object[] { localObject4, localObject1 });
        kotlin.g.b.s.s(localObject1, "context.getString(R.stri…lFromUserName,toUserName)");
        localObject4 = paramaq.getContent();
        localObject1 = paramContext.getString(p.h.live_comment_row_content_tmpl, new Object[] { localObject1 });
        kotlin.g.b.s.s(localObject1, "context.getString(R.stri…w_content_tmpl, userName)");
        paramContext = new q(p.b(paramContext, (CharSequence)b((String)localObject2, (List)localObject3, (String)localObject1, (String)localObject4)));
        paramInt = 0;
        if (((CharSequence)localObject2).length() <= 0) {
          break label787;
        }
      }
    }
    label787:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        paramContext.a(ejb(), (CharSequence)eiY(), 0);
        paramInt = eiY().length() + 0;
      }
      if (localObject3 == null) {
        break label793;
      }
      localObject2 = ((Iterable)localObject3).iterator();
      for (;;)
      {
        j = paramInt;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (ImageSpan)((Iterator)localObject2).next();
        j = paramInt + 1;
        paramContext.setSpan(localObject3, paramInt, j, 33);
        paramInt = j;
      }
      i = 0;
      break;
      label674:
      parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
      break label84;
      label694:
      localObject2 = "";
      break label117;
      label702:
      paramInt = 0;
      break label140;
      label708:
      localObject1 = ((bgh)localObject1).ZKa;
      break label166;
      label718:
      localObject3 = null;
      break label213;
      label724:
      localObject1 = ((bgh)localObject1).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label260;
      }
      localObject1 = ((FinderContact)localObject1).username;
      break label260;
      label752:
      localObject4 = localObject5;
      break label372;
      label759:
      localObject1 = ((bgh)localObject1).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label430;
      }
      localObject1 = ((FinderContact)localObject1).username;
      break label430;
    }
    label793:
    j = paramInt;
    paramContext.a(ejc(), (CharSequence)localObject1, j);
    if ((au.bwV(paramaq.djQ())) && (i == 0))
    {
      paramaq = eje();
      paramInt = n.a((CharSequence)paramContext, localObject5.toString(), 0, false);
      paramContext.setSpan(paramaq, ((CharSequence)localObject5).length() + paramInt, n.a((CharSequence)paramContext, localObject5.toString(), 0, false) + ((CharSequence)localObject5).length() + eja().length(), 33);
    }
    parama.DQt.aZ((CharSequence)paramContext);
    paramaq = parama.DQt.getParent();
    if (paramaq == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(359947);
      throw paramContext;
    }
    paramaq = (RelativeLayout)paramaq;
    Object localObject1 = parama.DQt.getParent();
    if (localObject1 == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(359947);
      throw paramContext;
    }
    ((RelativeLayout)localObject1).setPadding(eiZ(), paramaq.getPaddingTop(), paramaq.getPaddingRight(), paramaq.getPaddingBottom());
    parama.DQt.aZ((CharSequence)paramContext);
    parama.DQt.setTextSize(ejf());
    paramContext = parama.DQt.getParent();
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(359947);
      throw paramContext;
    }
    paramContext = (RelativeLayout)paramContext;
    if (j == 0) {}
    for (paramInt = eiZ();; paramInt = 0)
    {
      paramContext.setPadding(paramInt, paramContext.getPaddingTop(), paramContext.getPaddingRight(), paramContext.getPaddingBottom());
      AppMethodBeat.o(359947);
      return;
    }
  }
  
  public final int eiV()
  {
    return 20002;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.s
 * JD-Core Version:    0.7.0.1
 */