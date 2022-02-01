package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.b;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.model.aq;
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
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemText;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveBuContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getLiveBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "msgType", "onBindTextMsg", "commentData", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class x
  extends b
{
  public static final x.a CMk;
  private final com.tencent.mm.plugin.finder.live.model.context.a CMl;
  
  static
  {
    AppMethodBeat.i(359880);
    CMk = new x.a((byte)0);
    AppMethodBeat.o(359880);
  }
  
  public x(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359876);
    this.CMl = parama;
    AppMethodBeat.o(359876);
  }
  
  public final aq a(bke parambke)
  {
    AppMethodBeat.i(359893);
    s.u(parambke, "msg");
    parambke = (aq)new am(parambke);
    AppMethodBeat.o(359893);
    return parambke;
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359913);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    super.a(paramContext, parama, paramaq, paramInt);
    Object localObject1;
    int i;
    Object localObject2;
    label97:
    label120:
    Object localObject3;
    label136:
    label149:
    Object localObject4;
    label206:
    label253:
    Object localObject5;
    if (((e)this.CMl.business(e.class)).Ecv)
    {
      localObject1 = u.DJC;
      if (!u.bUx())
      {
        i = 1;
        if (!s.p(((e)this.CMl.business(e.class)).mIC, paramaq.djQ())) {
          break label540;
        }
        localObject2 = eiY();
        s.s(localObject2, "if (liveBuContext.busine…orTag\n            else \"\"");
        localObject1 = paramaq.eku();
        if (localObject1 != null) {
          break label548;
        }
        localObject1 = null;
        if (((CharSequence)localObject2).length() != 0) {
          break label558;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label574;
        }
        if (localObject1 != null) {
          break label564;
        }
        paramInt = 0;
        if (paramInt <= 0) {
          break label574;
        }
        localObject3 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
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
            break label580;
          }
          localObject1 = null;
          localObject1 = r.io((String)localObject1, (String)localObject4);
          s.s(localObject1, "makeAnonymousNameIfIsMyS…displayName\n            )");
        }
        localObject4 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        s.s(localObject4, "service(IFinderCommonService::class.java)");
        localObject4 = (com.tencent.mm.plugin.h)localObject4;
        localObject5 = parama.DQt.getPaint();
        s.s(localObject5, "holder.contentTv.paint");
        localObject4 = h.a.a((com.tencent.mm.plugin.h)localObject4, paramContext, (TextPaint)localObject5, (CharSequence)localObject1).toString();
        if ((!au.bwV(paramaq.djQ())) || (i != 0)) {
          break label608;
        }
        localObject1 = s.X((String)localObject4, eja());
        label352:
        localObject1 = paramContext.getString(p.h.live_comment_row_content_tmpl, new Object[] { localObject1 });
        s.s(localObject1, "context.getString(\n     …romUserNickName\n        )");
        localObject5 = b((String)localObject2, (List)localObject3, (String)localObject1, paramaq.getContent());
        paramInt = 0;
        localObject5 = new q(p.b(paramContext, (CharSequence)localObject5));
        if (((CharSequence)localObject2).length() <= 0) {
          break label615;
        }
      }
    }
    label540:
    label548:
    label558:
    label564:
    label574:
    label580:
    label608:
    label615:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        ((q)localObject5).a(ejb(), (CharSequence)eiY(), 0);
        paramInt = eiY().length() + 0;
      }
      if (localObject3 == null) {
        break label621;
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
        ((q)localObject5).setSpan(localObject3, paramInt, j, 33);
        paramInt = j;
      }
      i = 0;
      break;
      localObject2 = "";
      break label97;
      localObject1 = ((bgh)localObject1).ZKa;
      break label120;
      paramInt = 0;
      break label136;
      paramInt = ((LinkedList)localObject1).size();
      break label149;
      localObject3 = null;
      break label206;
      localObject1 = ((bgh)localObject1).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label253;
      }
      localObject1 = ((FinderContact)localObject1).username;
      break label253;
      localObject1 = localObject4;
      break label352;
    }
    label621:
    j = paramInt;
    ((q)localObject5).a(ejc(), (CharSequence)localObject1, j);
    if ((au.bwV(paramaq.djQ())) && (i == 0))
    {
      paramaq = eje();
      paramInt = n.a((CharSequence)localObject5, ((String)localObject4).toString(), 0, false);
      ((q)localObject5).setSpan(paramaq, ((String)localObject4).length() + paramInt, n.a((CharSequence)localObject5, ((String)localObject4).toString(), 0, false) + ((String)localObject4).length() + eja().length(), 33);
    }
    parama.DQt.aZ((CharSequence)localObject5);
    parama.DQt.setTextSize(ejf());
    parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
    paramContext = parama.DQt.getParent();
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(359913);
      throw paramContext;
    }
    paramContext = (RelativeLayout)paramContext;
    if (j == 0) {}
    for (paramInt = eiZ();; paramInt = 0)
    {
      paramContext.setPadding(paramInt, paramContext.getPaddingTop(), paramContext.getPaddingRight(), paramContext.getPaddingBottom());
      AppMethodBeat.o(359913);
      return;
    }
  }
  
  public int eiV()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.x
 * JD-Core Version:    0.7.0.1
 */