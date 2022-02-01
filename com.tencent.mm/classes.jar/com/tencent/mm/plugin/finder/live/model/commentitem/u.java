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
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemSendRedPacket;", "Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemRedPacket;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msgType", "onBindSendLuckyMoneyMsg", "commentData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends r
{
  private final String TAG;
  
  public u(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359904);
    this.TAG = "CommentItemSendRedPacket";
    AppMethodBeat.o(359904);
  }
  
  public final aq a(bdm parambdm)
  {
    AppMethodBeat.i(359916);
    s.u(parambdm, "msg");
    parambdm = (aq)new com.tencent.mm.plugin.finder.live.model.z(parambdm);
    AppMethodBeat.o(359916);
    return parambdm;
  }
  
  public final void a(final Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359933);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    Object localObject;
    SpannableStringBuilder localSpannableStringBuilder;
    String str;
    if ((Util.isEqual(paramaq.djQ(), com.tencent.mm.model.z.bAM())) || (Util.isEqual(paramaq.djQ(), com.tencent.mm.model.z.bAW())))
    {
      paramInt = 1;
      localObject = paramContext.getResources().getDrawable(p.d.BzW);
      ((Drawable)localObject).setBounds(0, 0, eiW(), eiX());
      localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
      localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)"  ");
      localSpannableStringBuilder.setSpan(localObject, 0, 1, 33);
      int i = 0;
      if (paramInt == 0) {
        break label450;
      }
      localObject = paramContext.getResources().getString(p.h.Cng);
      s.s(localObject, "context.resources.getStr…der_live_lucky_money_you)");
      paramInt = i;
      str = paramContext.getResources().getString(p.h.CmW);
      s.s(str, "context.resources.getStr….finder_live_lucky_money)");
      if (!s.p(localObject, paramContext.getResources().getString(p.h.Cng))) {
        break label526;
      }
      paramInt = 0;
    }
    label526:
    for (SpannableString localSpannableString = new SpannableString((CharSequence)paramContext.getResources().getString(p.h.Cnf, new Object[] { str }));; localSpannableString = new SpannableString((CharSequence)paramContext.getResources().getString(p.h.Cne, new Object[] { localObject, str })))
    {
      parama.DQt.setTag(p.e.BEl, localSpannableString);
      parama.DQt.setTag(p.e.BEo, str);
      if (paramInt != 0)
      {
        paramInt = n.a((CharSequence)localSpannableString, (String)localObject, 0, false, 6);
        if ((paramInt >= 0) && (((String)localObject).length() + paramInt <= localSpannableString.length())) {
          localSpannableString.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(p.b.half_alpha_white)), paramInt, ((String)localObject).length() + paramInt, 33);
        }
      }
      paramInt = n.a((CharSequence)localSpannableString, str, 0, false, 6);
      if ((paramInt >= 0) && (str.length() + paramInt <= localSpannableString.length())) {
        localSpannableString.setSpan(new a(paramaq, this, paramContext), paramInt, str.length() + paramInt, 33);
      }
      localSpannableStringBuilder.append((CharSequence)localSpannableString);
      parama.DQt.aZ((CharSequence)localSpannableStringBuilder);
      parama.DQt.setTextSize(ejf());
      parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
      AppMethodBeat.o(359933);
      return;
      paramInt = 0;
      break;
      label450:
      if (s.p(((e)this.CBK.business(e.class)).mIC, paramaq.djQ())) {}
      for (localObject = paramContext.getString(p.h.CmX);; localObject = com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.djQ(), paramaq.ekt()))
      {
        s.s(localObject, "if(liveContext.business(…NickName())\n            }");
        paramInt = 1;
        break;
        localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      }
    }
  }
  
  public final int eiV()
  {
    return 20019;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/commentitem/CommentItemSendRedPacket$onBindSendLuckyMoneyMsg$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ClickableSpan
  {
    a(aq paramaq, u paramu, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(359997);
      s.u(paramView, "widget");
      if ((this.CMb instanceof com.tencent.mm.plugin.finder.live.model.z))
      {
        paramView = this.CMb.ekF();
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAppMsgSendRedPacketInfo");
          AppMethodBeat.o(359997);
          throw paramView;
        }
        paramView = ((beu)paramView).ZOX;
        if (paramView != null) {
          jdField_this.aC(paramContext, paramView);
        }
      }
      AppMethodBeat.o(359997);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(360007);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(paramContext.getResources().getColor(p.b.ByT));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(360007);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.u
 * JD-Core Version:    0.7.0.1
 */