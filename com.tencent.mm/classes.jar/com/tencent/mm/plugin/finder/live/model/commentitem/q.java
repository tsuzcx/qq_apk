package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.y;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.ber;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemRecvRedPacket;", "Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemRedPacket;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msgType", "onBindRecvLuckyMoneyMsg", "commentData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends r
{
  public q(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359919);
    AppMethodBeat.o(359919);
  }
  
  public final aq a(bdm parambdm)
  {
    AppMethodBeat.i(359931);
    s.u(parambdm, "msg");
    parambdm = (aq)new y(parambdm);
    AppMethodBeat.o(359931);
    return parambdm;
  }
  
  public final void a(final Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359950);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    int i;
    Object localObject;
    SpannableStringBuilder localSpannableStringBuilder;
    label155:
    String str2;
    String str1;
    if ((Util.isEqual(paramaq.djQ(), z.bAM())) || (Util.isEqual(paramaq.djQ(), z.bAW())))
    {
      i = 1;
      localObject = paramContext.getResources().getDrawable(p.d.BzW);
      ((Drawable)localObject).setBounds(0, 0, eiW(), eiX());
      localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
      localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)"  ");
      localSpannableStringBuilder.setSpan(localObject, 0, 1, 33);
      if (i == 0) {
        break label545;
      }
      if (!s.p(paramaq.djQ(), paramaq.ekw())) {
        break label474;
      }
      localObject = paramContext.getString(p.h.Cnd);
      paramInt = 0;
      s.s(localObject, "if (isFromSelf) {\n      …UserNickName())\n        }");
      str2 = paramContext.getResources().getString(p.h.CmW);
      s.s(str2, "context.resources.getStr….finder_live_lucky_money)");
      if (i == 0) {
        break label602;
      }
      if (!s.p(((String)localObject).toString(), paramContext.getString(p.h.Cnd))) {
        break label573;
      }
      str1 = paramContext.getResources().getString(p.h.Cnb, new Object[] { str2 });
    }
    for (;;)
    {
      s.s(str1, "if (isFromSelf) {\n      …e,luckMoneyStr)\n        }");
      SpannableString localSpannableString = new SpannableString((CharSequence)str1);
      parama.DQt.setTag(p.e.BEl, localSpannableString);
      parama.DQt.setTag(p.e.BEo, str2);
      if (paramInt != 0)
      {
        paramInt = n.a((CharSequence)str1, (String)localObject, 0, false, 6);
        if ((paramInt >= 0) && (((String)localObject).length() + paramInt <= str1.length())) {
          localSpannableString.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(p.b.half_alpha_white)), paramInt, ((String)localObject).length() + paramInt, 33);
        }
      }
      paramInt = n.a((CharSequence)str1, str2, 0, false, 6);
      if ((paramInt >= 0) && (str2.length() + paramInt <= str1.length())) {
        localSpannableString.setSpan(new a(paramaq, this, paramContext), paramInt, str2.length() + paramInt, 33);
      }
      localSpannableStringBuilder.append((CharSequence)localSpannableString);
      parama.DQt.aZ((CharSequence)localSpannableStringBuilder);
      parama.DQt.setTextSize(ejf());
      parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
      AppMethodBeat.o(359950);
      return;
      i = 0;
      break;
      label474:
      if (s.p(((e)this.CBK.business(e.class)).mIC, paramaq.ekw()))
      {
        localObject = paramContext.getString(p.h.CmX);
        paramInt = 1;
        break label155;
      }
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject = com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.ekw(), paramaq.ekx());
      paramInt = 1;
      break label155;
      label545:
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject = com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.djQ(), paramaq.ekt());
      paramInt = 1;
      break label155;
      label573:
      str1 = paramContext.getResources().getString(p.h.Cna, new Object[] { localObject, str2 });
      continue;
      label602:
      str1 = paramContext.getResources().getString(p.h.CmZ, new Object[] { localObject, str2 });
    }
  }
  
  public final int eiV()
  {
    return 20020;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/commentitem/CommentItemRecvRedPacket$onBindRecvLuckyMoneyMsg$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ClickableSpan
  {
    a(aq paramaq, q paramq, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(360017);
      s.u(paramView, "widget");
      if ((this.CMb instanceof y))
      {
        paramView = this.CMb.ekF();
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAppMsgRecvRedPacketInfo");
          AppMethodBeat.o(360017);
          throw paramView;
        }
        paramView = ((ber)paramView).ZOX;
        if (paramView != null) {
          jdField_this.aC(paramContext, paramView);
        }
      }
      AppMethodBeat.o(360017);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(360023);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(paramContext.getResources().getColor(p.b.ByT));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(360023);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.q
 * JD-Core Version:    0.7.0.1
 */