package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.b;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.t;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.util.u;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemAtWx;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "onBindAtWxMsg", "commentData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends b
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  
  public c(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    this.CBK = parama;
  }
  
  public final aq a(bdm parambdm)
  {
    s.u(parambdm, "msg");
    parambdm = new t(parambdm);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.d((aq)parambdm)) {
      ((l)this.CBK.business(l.class)).EgM = true;
    }
    return (aq)parambdm;
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    TextPaint localTextPaint = null;
    int j = 0;
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    super.a(paramContext, parama, paramaq, paramInt);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    String str;
    label95:
    label118:
    Object localObject2;
    label134:
    Object localObject3;
    if (com.tencent.mm.plugin.finder.live.utils.a.d(paramaq))
    {
      parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.BzL));
      if (!s.p(((e)this.CBK.business(e.class)).mIC, paramaq.djQ())) {
        break label545;
      }
      str = eiY();
      s.s(str, "if (liveContext.business…orTag\n            else \"\"");
      localObject1 = paramaq.eku();
      if (localObject1 != null) {
        break label553;
      }
      localObject1 = null;
      if (((CharSequence)str).length() != 0) {
        break label563;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label569;
      }
      localObject2 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
      localObject2 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
      localObject2 = k.z(com.tencent.mm.plugin.finder.live.view.span.h.ewL(), 6);
      localObject3 = parama.DQt;
      localObject3 = com.tencent.mm.plugin.finder.live.view.span.h.a((List)localObject1, (int[])localObject2, 0, 0, 4, (View)localObject3, 12);
      label187:
      localObject2 = paramaq.ekt();
      if (localObject2 != null) {
        break label575;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label637;
      }
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.djQ(), paramaq.ekt());
      label230:
      localObject2 = localObject1;
      if (((e)this.CBK.business(e.class)).Ecv)
      {
        localObject2 = u.DJC;
        localObject2 = localObject1;
        if (!u.bUx())
        {
          localObject2 = paramaq.eku();
          if (localObject2 != null) {
            break label640;
          }
          localObject2 = localTextPaint;
          label284:
          localObject2 = r.io((String)localObject2, (String)localObject1);
          s.s(localObject2, "makeAnonymousNameIfIsMyS…    nameStr\n            )");
        }
      }
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(localObject1, "service(IFinderCommonService::class.java)");
      localObject1 = (com.tencent.mm.plugin.h)localObject1;
      localTextPaint = parama.DQt.getPaint();
      s.s(localTextPaint, "holder.contentTv.paint");
      localObject1 = h.a.a((com.tencent.mm.plugin.h)localObject1, paramContext, localTextPaint, (CharSequence)localObject2);
      localObject2 = paramaq.getContent();
      paramaq = paramContext.getString(p.h.live_comment_row_content_tmpl, new Object[] { localObject1 });
      s.s(paramaq, "context.getString(R.stri…w_content_tmpl, userName)");
      paramContext = new q(p.b(paramContext, (CharSequence)b(str, (List)localObject3, paramaq, (String)localObject2)));
      if (((CharSequence)str).length() <= 0) {
        break label666;
      }
      paramInt = 1;
      label425:
      if (paramInt == 0) {
        break label863;
      }
      paramContext.a(ejb(), (CharSequence)eiY(), 0);
    }
    label545:
    label553:
    label563:
    label569:
    label575:
    label591:
    label599:
    label863:
    for (paramInt = eiY().length() + 0;; paramInt = 0)
    {
      if (localObject3 != null)
      {
        localObject1 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          i = paramInt;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ImageSpan)((Iterator)localObject1).next();
          i = paramInt + 1;
          paramContext.setSpan(localObject2, paramInt, i, 33);
          paramInt = i;
        }
        parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
        break;
        str = "";
        break label95;
        localObject1 = ((bgh)localObject1).ZKa;
        break label118;
        paramInt = 0;
        break label134;
        localObject3 = null;
        break label187;
        if (((CharSequence)localObject2).length() == 0)
        {
          paramInt = 1;
          if (paramInt != 0) {
            break label625;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label631;
          }
        }
        for (;;)
        {
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = null;
          break;
          paramInt = 0;
          break label591;
          label625:
          paramInt = 0;
          break label599;
          label631:
          localObject2 = null;
        }
        label637:
        break label230;
        FinderContact localFinderContact = ((bgh)localObject2).contact;
        localObject2 = localTextPaint;
        if (localFinderContact == null) {
          break label284;
        }
        localObject2 = localFinderContact.username;
        break label284;
        paramInt = 0;
        break label425;
      }
      int i = paramInt;
      paramContext.a(ejc(), (CharSequence)paramaq, i);
      parama.DQt.aZ((CharSequence)paramContext);
      paramaq = parama.DQt.getParent();
      if (paramaq == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      }
      paramaq = (RelativeLayout)paramaq;
      localObject1 = parama.DQt.getParent();
      if (localObject1 == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      }
      ((RelativeLayout)localObject1).setPadding(eiZ(), paramaq.getPaddingTop(), paramaq.getPaddingRight(), paramaq.getPaddingBottom());
      parama.DQt.aZ((CharSequence)paramContext);
      parama.DQt.setTextSize(ejf());
      paramContext = parama.DQt.getParent();
      if (paramContext == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      }
      paramContext = (RelativeLayout)paramContext;
      paramInt = j;
      if (i == 0) {
        paramInt = eiZ();
      }
      paramContext.setPadding(paramInt, paramContext.getPaddingTop(), paramContext.getPaddingRight(), paramContext.getPaddingBottom());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.c
 * JD-Core Version:    0.7.0.1
 */