package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.view.span.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemComboLiveReward;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "GIFT_ICON_SIZE", "", "getGIFT_ICON_SIZE", "()I", "GIFT_ICON_SIZE$delegate", "Lkotlin/Lazy;", "TAG", "", "giftStr", "getGiftStr", "()Ljava/lang/String;", "giftStr$delegate", "lineMaxWidth", "getLineMaxWidth", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "rewardImageSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "getRewardImageSpan", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "rewardImageSpan$delegate", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "giftSingleLine", "", "", "tv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "maxIndex", "matchRules", "msgType", "onBindComboLiveRewardMsg", "commentData", "payloadContent", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "onCleared", "Companion", "plugin-finder-live_release", "contentStyleCutGiftName", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "contentStyleCutName", "contentStyleCutTwoName"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.b
{
  public static final h.a CLk;
  private static boolean CLo;
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final j CLl;
  private final j CLm;
  private final j CLn;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(360022);
    CLk = new h.a((byte)0);
    AppMethodBeat.o(360022);
  }
  
  public h(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359938);
    this.CBK = parama;
    this.TAG = "CommentItemComboLiveReward";
    this.CLl = kotlin.k.cm((kotlin.g.a.a)h.c.CLq);
    this.CLm = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.CLn = kotlin.k.cm((kotlin.g.a.a)h.b.CLp);
    AppMethodBeat.o(359938);
  }
  
  private static final q a(j<? extends q> paramj)
  {
    AppMethodBeat.i(359984);
    paramj = (q)paramj.getValue();
    AppMethodBeat.o(359984);
    return paramj;
  }
  
  private static final void a(h paramh, q paramq, List<? extends ImageSpan> paramList)
  {
    AppMethodBeat.i(359975);
    paramq.a((f)paramh.CLm.getValue(), (CharSequence)paramh.emP(), 0);
    int i = paramh.emP().length();
    if (paramList != null)
    {
      paramh = ((Iterable)paramList).iterator();
      while (paramh.hasNext())
      {
        paramList = (ImageSpan)paramh.next();
        int j = i + 1;
        paramq.setSpan(paramList, i, j, 33);
        i = j;
      }
    }
    AppMethodBeat.o(359975);
  }
  
  private static final void a(final k.a parama, beb parambeb, final h paramh, Context paramContext, final ah.f paramf, final ah.d paramd, com.tencent.mm.loader.g.a.a parama1, g paramg, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(360006);
    s.u(parama, "$holder");
    s.u(parambeb, "$payloadContent");
    s.u(paramh, "this$0");
    s.u(paramContext, "$context");
    s.u(paramf, "$userMessage");
    s.u(paramd, "$startIndex");
    if (!s.p(parama.caK.getTag(), parambeb.ZOF))
    {
      Log.i(paramh.TAG, "onBindComboLiveRewardMsg tag:" + parama.caK.getTag() + ",payload id:" + parambeb.ZOF);
      AppMethodBeat.o(360006);
      return;
    }
    if (paramBitmap != null)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramContext, paramBitmap, paramh, paramf, paramd, parama));
      AppMethodBeat.o(360006);
      return;
    }
    Log.i(paramh.TAG, "onBindComboLiveRewardMsg resource is null!");
    AppMethodBeat.o(360006);
  }
  
  private final boolean a(CharSequence paramCharSequence, NeatTextView paramNeatTextView)
  {
    AppMethodBeat.i(359958);
    int k = emR();
    int m = paramNeatTextView.getPaddingLeft();
    int n = paramNeatTextView.getPaddingRight();
    Object localObject = paramNeatTextView.getParent();
    int i;
    if ((localObject instanceof ViewGroup))
    {
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        break label159;
      }
      i = 0;
      label51:
      localObject = paramNeatTextView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label168;
      }
      localObject = (ViewGroup)localObject;
      label72:
      if (localObject != null) {
        break label174;
      }
    }
    label159:
    label168:
    label174:
    for (int j = 0;; j = ((ViewGroup)localObject).getPaddingRight())
    {
      i = k - m - n - i - j;
      if (i <= 0) {
        break label233;
      }
      j = paramNeatTextView.getMaxLines();
      paramNeatTextView.setMaxLines(2147483647);
      paramNeatTextView.aZ(paramCharSequence);
      paramCharSequence = paramNeatTextView.pE(i, 2147483647);
      k = paramCharSequence.jQH();
      paramNeatTextView.setMaxLines(j);
      if (k > 1) {
        break label184;
      }
      AppMethodBeat.o(359958);
      return true;
      localObject = null;
      break;
      i = ((ViewGroup)localObject).getPaddingLeft();
      break label51;
      localObject = null;
      break label72;
    }
    label184:
    if (k <= 2)
    {
      if (i - paramCharSequence.aGK(1) > emQ())
      {
        AppMethodBeat.o(359958);
        return true;
      }
      AppMethodBeat.o(359958);
      return false;
    }
    AppMethodBeat.o(359958);
    return false;
    label233:
    Log.i(this.TAG, "matchRules " + i + ", " + paramCharSequence);
    AppMethodBeat.o(359958);
    return true;
  }
  
  private final boolean a(CharSequence paramCharSequence, NeatTextView paramNeatTextView, int paramInt)
  {
    AppMethodBeat.i(359967);
    Object localObject;
    label71:
    int i;
    int j;
    for (;;)
    {
      try
      {
        k = emR();
        m = paramNeatTextView.getPaddingLeft();
        n = paramNeatTextView.getPaddingRight();
        localObject = paramNeatTextView.getParent();
        if (!(localObject instanceof ViewGroup)) {
          break label293;
        }
        localObject = (ViewGroup)localObject;
      }
      finally
      {
        int k;
        int m;
        int n;
        label176:
        Log.printErrStackTrace(this.TAG, paramCharSequence, "", new Object[0]);
        AppMethodBeat.o(359967);
        return false;
      }
      localObject = paramNeatTextView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label299;
      }
      localObject = (ViewGroup)localObject;
      break label282;
      j = k - m - n - i - j - 6;
      if ((j <= 0) || (j <= emQ())) {
        continue;
      }
      i = paramNeatTextView.getMaxLines();
      paramNeatTextView.setMaxLines(2147483647);
      paramNeatTextView.aZ(paramCharSequence);
      paramCharSequence = paramNeatTextView.pE(j - emQ(), 2147483647);
      j = paramCharSequence.jQH();
      paramNeatTextView.setMaxLines(i);
      if ((j <= 1) || (paramCharSequence.dk(1) <= paramInt)) {
        continue;
      }
      AppMethodBeat.o(359967);
      return true;
      i = ((ViewGroup)localObject).getPaddingLeft();
    }
    label271:
    label282:
    label293:
    label299:
    label303:
    for (;;)
    {
      j = ((ViewGroup)localObject).getPaddingRight();
      break label71;
      AppMethodBeat.o(359967);
      return false;
      Log.i(this.TAG, "giftSingleLine " + j + ", " + paramCharSequence);
      AppMethodBeat.o(359967);
      return false;
      if (localObject == null)
      {
        i = 0;
        break;
      }
      for (;;)
      {
        if (localObject != null) {
          break label303;
        }
        j = 0;
        break;
        localObject = null;
        break label271;
        break label176;
        localObject = null;
      }
    }
  }
  
  private static final q b(j<? extends q> paramj)
  {
    AppMethodBeat.i(359989);
    paramj = (q)paramj.getValue();
    AppMethodBeat.o(359989);
    return paramj;
  }
  
  private static final q c(j<? extends q> paramj)
  {
    AppMethodBeat.i(359994);
    paramj = (q)paramj.getValue();
    AppMethodBeat.o(359994);
    return paramj;
  }
  
  private static int emR()
  {
    int i = 1;
    AppMethodBeat.i(359946);
    Object localObject = aj.CGT;
    localObject = aj.elk();
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.view.a)localObject).isLandscape() == true)) {}
    while (i != 0)
    {
      i = (int)(bf.bf(MMApplicationContext.getContext()).x * 0.4D);
      AppMethodBeat.o(359946);
      return i;
      i = 0;
    }
    float f = bf.bf(MMApplicationContext.getContext()).x - MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.finder_live_last_option_margin);
    localObject = com.tencent.mm.plugin.finder.live.plugin.ah.CXJ;
    i = (int)(f - com.tencent.mm.plugin.finder.live.plugin.ah.epT());
    AppMethodBeat.o(359946);
    return i;
  }
  
  public final aq a(bdm parambdm)
  {
    AppMethodBeat.i(360056);
    s.u(parambdm, "msg");
    parambdm = (aq)new com.tencent.mm.plugin.finder.live.model.k(parambdm);
    AppMethodBeat.o(360056);
    return parambdm;
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(360108);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    super.a(paramContext, parama, paramaq, paramInt);
    Object localObject1 = paramaq.ekF();
    if (!(localObject1 instanceof beb))
    {
      Log.e(this.TAG, "onBindComboLiveRewardMsg payloadContent isn't FinderLiveAppMsgComboLiveRewardInfo");
      parama.caK.setVisibility(8);
      AppMethodBeat.o(360108);
      return;
    }
    parama.caK.setTag(((beb)localObject1).ZOF);
    beb localbeb = (beb)localObject1;
    localObject1 = paramaq.eku();
    Object localObject6;
    Object localObject3;
    label145:
    int i;
    Object localObject4;
    label167:
    Object localObject5;
    boolean bool;
    label215:
    final ah.f localf1;
    label310:
    final ah.f localf2;
    String str1;
    String str2;
    final ah.f localf5;
    final ah.f localf4;
    ah.d locald;
    ah.f localf3;
    final List localList;
    Object localObject7;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject6 = (List)localObject1;
      localObject1 = localbeb.content;
      localObject3 = localbeb.ZOD;
      if (localObject3 != null) {
        break label1163;
      }
      localObject3 = null;
      i = localbeb.ZOE;
      localObject4 = localbeb.ZOD;
      if (localObject4 != null) {
        break label1173;
      }
      localObject4 = null;
      localObject5 = this.TAG;
      localObject1 = new StringBuilder("onBindComboLiveRewardMsg giftContent ").append(localObject1).append(",comboCount:").append(i).append(",giftThumbUrl is empty:");
      if (localObject4 != null) {
        break label1183;
      }
      bool = true;
      Log.i((String)localObject5, bool);
      localf1 = new ah.f();
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localf1.aqH = com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.djQ(), paramaq.ekt());
      if (((e)this.CBK.business(e.class)).Ecv)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.util.u.DJC;
        if (!com.tencent.mm.plugin.finder.live.util.u.bUx())
        {
          localObject1 = paramaq.eku();
          if (localObject1 != null) {
            break label1189;
          }
          localObject1 = null;
          localObject1 = r.io((String)localObject1, (String)localf1.aqH);
          s.s(localObject1, "makeAnonymousNameIfIsMyS…  vNickname\n            )");
          localf1.aqH = localObject1;
        }
      }
      localf2 = new ah.f();
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(localObject1, "service(IFinderCommonService::class.java)");
      localObject1 = (com.tencent.mm.plugin.h)localObject1;
      localObject5 = parama.DQt.getPaint();
      s.s(localObject5, "holder.contentTv.paint");
      localf2.aqH = com.tencent.mm.plugin.h.a.a((com.tencent.mm.plugin.h)localObject1, paramContext, (TextPaint)localObject5, (CharSequence)localf1.aqH);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      str1 = com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.ekw(), paramaq.ekx());
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(localObject1, "service(IFinderCommonService::class.java)");
      localObject1 = (com.tencent.mm.plugin.h)localObject1;
      localObject5 = parama.DQt.getPaint();
      s.s(localObject5, "holder.contentTv.paint");
      localObject1 = com.tencent.mm.plugin.h.a.a((com.tencent.mm.plugin.h)localObject1, paramContext, (TextPaint)localObject5, (CharSequence)str1);
      str2 = paramContext.getString(p.h.CoA, new Object[] { localObject3 });
      s.s(str2, "context.getString(R.stri…sg_gift_prefix, giftName)");
      localf5 = new ah.f();
      localObject5 = paramContext.getString(p.h.CoB);
      s.s(localObject5, "context.getString(R.stri…er_live_msg_gift_prefix2)");
      localf5.aqH = localObject5;
      localf4 = new ah.f();
      localf4.aqH = s.X("x", Integer.valueOf(i));
      locald = new ah.d();
      localf3 = new ah.f();
      localObject5 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
      localObject5 = (View)parama.DQt;
      localList = com.tencent.mm.plugin.finder.live.view.span.h.a((List)localObject6, new int[] { 2, 4, 6 }, 0, 0, 4, (View)localObject5, 12);
      localObject5 = emP();
      localObject7 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
      localObject7 = s.X((String)localObject5, com.tencent.mm.plugin.finder.live.view.span.h.gQ(localList));
      parama.DQt.setTag(p.e.BEo, emP());
    }
    for (;;)
    {
      try
      {
        if (CLo)
        {
          if (((CharSequence)str1).length() != 0) {
            continue;
          }
          paramInt = 1;
          break label2405;
        }
        localObject5 = new q(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)((String)localObject7 + (String)localf1.aqH + ' ' + str2 + ' ' + (String)localf4.aqH)));
        a(this, (q)localObject5, localList);
        localObject1 = kotlin.ah.aiuX;
        localObject1 = kotlin.k.cm((kotlin.g.a.a)new e(paramContext, (String)localObject7, localf1, localf5, localf4, localList, (List)localObject6, this));
        localObject6 = kotlin.k.cm((kotlin.g.a.a)new g(paramContext, (String)localObject7, localf2, localf5, localf4, localList, (List)localObject6, this));
        parama.DQt.setTag(p.e.BEl, paramContext.getString(p.h.finder_live_comment_for_gift_desc, new Object[] { localf1.aqH, str2, String.valueOf(i) }));
        if (!a((CharSequence)localObject5, (NeatTextView)parama.DQt)) {
          continue;
        }
        paramInt = ((String)localObject7).length();
        locald.aixb = (((String)localf1.aqH).length() + paramInt + 1 + str2.length());
        localObject1 = localObject5;
        if (a((CharSequence)localObject5, (NeatTextView)parama.DQt, locald.aixb))
        {
          localObject1 = new q(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)((String)localObject7 + (String)localf1.aqH + ' ' + str2 + "\n " + (String)localf4.aqH)));
          a(this, (q)localObject1, localList);
          localObject5 = kotlin.ah.aiuX;
          locald.aixb += 1;
        }
      }
      finally
      {
        label1163:
        label1173:
        label1183:
        label1189:
        localf3.aqH = new q(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)((String)localObject7 + localf2.aqH + ' ' + str2 + ' ' + (String)localf4.aqH)));
        a(this, (q)localf3.aqH, localList);
        paramInt = ((String)localObject7).length();
        locald.aixb = (((CharSequence)localf2.aqH).length() + paramInt + str2.length() + 1);
        parama.DQt.setTag(p.e.BEl, paramContext.getString(p.h.finder_live_comment_for_gift_desc, new Object[] { localf2.aqH, str2, String.valueOf(i) }));
        Log.printErrStackTrace(this.TAG, localThrowable, "", new Object[0]);
        Log.e(this.TAG, "onBindComboLiveRewardMsg exception for:" + (String)localf1.aqH + ", " + str1 + ", " + localObject3 + ", fromUsername: " + paramaq.djQ());
        continue;
        Object localObject2 = (q)((j)localObject6).getValue();
        paramInt = ((String)localObject7).length();
        int j = ((CharSequence)localf2.aqH).length();
        locald.aixb = (((String)localf5.aqH).length() + (j + paramInt + 1));
        continue;
        final String str3 = paramContext.getString(p.h.Coz, new Object[] { str1 });
        s.s(str3, "context.getString(R.stri…_msg_gift_for, aNickname)");
        final String str4 = paramContext.getString(p.h.Coz, new Object[] { localObject2 });
        s.s(str4, "context.getString(R.stri…g_gift_for, aNicknameElp)");
        localObject5 = new q(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)((String)localObject7 + (String)localf1.aqH + ' ' + str3 + str2 + ' ' + (String)localf4.aqH)));
        a(this, (q)localObject5, localList);
        localObject2 = kotlin.ah.aiuX;
        localObject2 = kotlin.k.cm((kotlin.g.a.a)new f(paramContext, (String)localObject7, localf1, str3, localf5, localf4, localList, (List)localObject6, this));
        j localj = kotlin.k.cm((kotlin.g.a.a)new h(paramContext, (String)localObject7, localf2, str3, localf5, localf4, localList, (List)localObject6, this));
        localObject6 = kotlin.k.cm((kotlin.g.a.a)new i(paramContext, (String)localObject7, localf2, str4, localf5, localf4, localList, (List)localObject6, this));
        parama.DQt.setTag(p.e.BEl, paramContext.getString(p.h.finder_live_comment_for_gift_desc, new Object[] { localf1.aqH, s.X(str3, str2), String.valueOf(i) }));
        if (!a((CharSequence)localObject5, (NeatTextView)parama.DQt)) {
          continue;
        }
        paramInt = ((String)localObject7).length();
        locald.aixb = (((String)localf1.aqH).length() + paramInt + 1 + str3.length() + str2.length());
        localObject2 = localObject5;
        if (!a((CharSequence)localObject5, (NeatTextView)parama.DQt, locald.aixb)) {
          continue;
        }
        localObject2 = new q(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)((String)localObject7 + (String)localf1.aqH + ' ' + str3 + str2 + "\n " + (String)localf4.aqH)));
        a(this, (q)localObject2, localList);
        localObject5 = kotlin.ah.aiuX;
        locald.aixb += 1;
        localf3.aqH = localObject2;
        continue;
        if (!a((CharSequence)b((j)localObject2), (NeatTextView)parama.DQt)) {
          continue;
        }
        localObject2 = b((j)localObject2);
        paramInt = ((String)localObject7).length();
        j = ((String)localf1.aqH).length();
        int k = str3.length();
        locald.aixb = (((String)localf5.aqH).length() + (k + (j + paramInt + 1)));
        continue;
        if (!a((CharSequence)c(localj), (NeatTextView)parama.DQt)) {
          continue;
        }
        localObject2 = c(localj);
        paramInt = ((String)localObject7).length();
        j = ((CharSequence)localf2.aqH).length();
        k = str3.length();
        locald.aixb = (((String)localf5.aqH).length() + (k + (j + paramInt + 1)));
        continue;
        localObject2 = (q)((j)localObject6).getValue();
        paramInt = ((String)localObject7).length();
        j = ((CharSequence)localf2.aqH).length();
        k = str4.length();
        locald.aixb = (((String)localf5.aqH).length() + (k + (j + paramInt + 1)));
        continue;
        paramaq = (RelativeLayout)paramaq;
        paramaq.setPadding(0, paramaq.getPaddingTop(), paramaq.getPaddingRight(), paramaq.getPaddingBottom());
        paramaq = kotlin.ah.aiuX;
        parama.DQt.aZ((CharSequence)localf3.aqH);
        parama.DQt.setTextSize(ejf());
        parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
        AppMethodBeat.o(360108);
        return;
      }
      localf3.aqH = localObject1;
      parama.DQt.setMaxLines(2);
      if (localObject4 != null)
      {
        paramaq = com.tencent.mm.plugin.finder.loader.p.ExI;
        com.tencent.mm.plugin.finder.loader.p.eCl().dk(new com.tencent.mm.plugin.finder.loader.b((String)localObject4)).a(new h..ExternalSyntheticLambda0(parama, localbeb, this, paramContext, localf3, locald)).Td();
        paramaq = kotlin.ah.aiuX;
        paramaq = kotlin.ah.aiuX;
      }
      paramaq = parama.DQt.getParent();
      if (paramaq == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(360108);
        throw paramContext;
        localObject1 = ((bgh)localObject1).ZKa;
        break;
        localObject3 = ((bim)localObject3).name;
        break label145;
        localObject4 = ((bim)localObject4).ZRC;
        break label167;
        bool = false;
        break label215;
        localObject1 = ((bgh)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label310;
        }
        localObject1 = ((FinderContact)localObject1).username;
        break label310;
        paramInt = 0;
        break label2405;
        if (a((CharSequence)a((j)localObject1), (NeatTextView)parama.DQt))
        {
          localObject1 = a((j)localObject1);
          paramInt = ((String)localObject7).length();
          j = ((String)localf1.aqH).length();
          locald.aixb = (((String)localf5.aqH).length() + (j + paramInt + 1));
          continue;
        }
      }
      label2405:
      if (paramInt == 0) {}
    }
  }
  
  public final int eiV()
  {
    return 20013;
  }
  
  public final String emP()
  {
    AppMethodBeat.i(360038);
    String str = (String)this.CLl.getValue();
    AppMethodBeat.o(360038);
    return str;
  }
  
  public final int emQ()
  {
    AppMethodBeat.i(360042);
    int i = ((Number)this.CLn.getValue()).intValue();
    AppMethodBeat.o(360042);
    return i;
  }
  
  public final void onCleared()
  {
    CLo = false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(Context paramContext, Bitmap paramBitmap, h paramh, ah.f<q> paramf, ah.d paramd, k.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<q>
  {
    e(Context paramContext, String paramString, ah.f<String> paramf1, ah.f<String> paramf2, ah.f<String> paramf3, List<? extends ImageSpan> paramList, List<? extends bfl> paramList1, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<q>
  {
    f(Context paramContext, String paramString1, ah.f<String> paramf1, String paramString2, ah.f<String> paramf2, ah.f<String> paramf3, List<? extends ImageSpan> paramList, List<? extends bfl> paramList1, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<q>
  {
    g(Context paramContext, String paramString, ah.f<CharSequence> paramf, ah.f<String> paramf1, ah.f<String> paramf2, List<? extends ImageSpan> paramList, List<? extends bfl> paramList1, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<q>
  {
    h(Context paramContext, String paramString1, ah.f<CharSequence> paramf, String paramString2, ah.f<String> paramf1, ah.f<String> paramf2, List<? extends ImageSpan> paramList, List<? extends bfl> paramList1, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<q>
  {
    i(Context paramContext, String paramString1, ah.f<CharSequence> paramf, String paramString2, ah.f<String> paramf1, ah.f<String> paramf2, List<? extends ImageSpan> paramList, List<? extends bfl> paramList1, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<f>
  {
    j(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.h
 * JD-Core Version:    0.7.0.1
 */