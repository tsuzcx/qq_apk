package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.convert.d;
import com.tencent.mm.plugin.finder.live.model.af;
import com.tencent.mm.plugin.finder.live.model.ao;
import com.tencent.mm.plugin.finder.live.model.y;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.c;
import com.tencent.mm.view.HardTouchableLayout.d;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "roomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "GIFT_ICON_SIZE", "", "getGIFT_ICON_SIZE", "()I", "GIFT_ICON_SIZE$delegate", "Lkotlin/Lazy;", "LUCKY_MONEY_HEIGHT_SIZE", "getLUCKY_MONEY_HEIGHT_SIZE", "LUCKY_MONEY_HEIGHT_SIZE$delegate", "LUCKY_MONEY_WIDTH_SIZE", "getLUCKY_MONEY_WIDTH_SIZE", "LUCKY_MONEY_WIDTH_SIZE$delegate", "TAG", "", "TEXT_PADDING_LEFT", "getTEXT_PADDING_LEFT", "TEXT_PADDING_LEFT$delegate", "annoucement", "getAnnoucement", "()Ljava/lang/String;", "annoucement$delegate", "cacheAnchorSpan", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "getCacheAnchorSpan", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "cacheAnchorSpan$delegate", "cacheAnchorTag", "getCacheAnchorTag", "cacheAnchorTag$delegate", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "contentFontSize", "giftStr", "getGiftStr", "giftStr$delegate", "lineMaxWidth", "getLineMaxWidth", "setLineMaxWidth", "(I)V", "locationSpan", "getLocationSpan", "locationSpan$delegate", "locationTag", "getLocationTag", "locationTag$delegate", "luckyMoneyClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sendId", "", "getLuckyMoneyClickListener", "()Lkotlin/jvm/functions/Function1;", "setLuckyMoneyClickListener", "(Lkotlin/jvm/functions/Function1;)V", "micEnable", "", "getMicEnable", "()Z", "setMicEnable", "(Z)V", "officialAccountSpan", "getOfficialAccountSpan", "officialAccountSpan$delegate", "officialAccountTag", "getOfficialAccountTag", "officialAccountTag$delegate", "onItemClickListener", "Lkotlin/Function2;", "msg", "Landroid/view/View;", "view", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemDoubleClickListener", "getOnItemDoubleClickListener", "setOnItemDoubleClickListener", "onItemLongClickListener", "comment", "getOnItemLongClickListener", "setOnItemLongClickListener", "rankNoticeImageSpan", "getRankNoticeImageSpan", "rankNoticeImageSpan$delegate", "rewardImageSpan", "getRewardImageSpan", "rewardImageSpan$delegate", "getRoomData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setRoomData", "runTestCode", "getRunTestCode", "setRunTestCode", "sysAnnoucementImageSpan", "getSysAnnoucementImageSpan", "sysAnnoucementImageSpan$delegate", "userNameSpan", "Landroid/text/style/ForegroundColorSpan;", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "welcomeImageSpan", "getWelcomeImageSpan", "welcomeImageSpan$delegate", "welcomeTag", "getWelcomeTag", "welcomeTag$delegate", "appendComment", "createTextMsg", "anchorTag", "badgeSpans", "", "Landroid/text/style/ImageSpan;", "userTag", "content", "getItemCount", "giftSingleLine", "", "tv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "maxIndex", "matchRules", "onBindAtMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindComboLiveRewardMsg", "payloadContent", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "onBindGlobalLevelUpMsg", "onBindRecvLuckyMoneyMsg", "onBindRewardRankNoticeMsg", "onBindSendLuckyMoneyMsg", "onBindSysMsg", "userMessage", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "sysMsg", "onBindTextMsg", "onBindTickleMsg", "onBindViewHolder", "position", "onBindVisistorJoinLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "onBindWelcomeMsg", "onBinderLocationMsg", "onBinderOfficialAccountMsg", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "setComboLiveRewardSpan", "spanMessage", "globalRewardSpan", "updateComments", "reset", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-finder_release"})
public final class j
  extends RecyclerView.a<d>
{
  private final String TAG;
  public final ArrayList<ao> kMd;
  private final f yWA;
  private final int yWB;
  public int yWC;
  public boolean yWD;
  private final ForegroundColorSpan yWE;
  private final f yWF;
  kotlin.g.a.m<? super ao, ? super String, kotlin.x> yWG;
  public kotlin.g.a.m<? super ao, ? super View, kotlin.x> yWH;
  public kotlin.g.a.b<? super ao, kotlin.x> yWI;
  public kotlin.g.a.b<? super String, kotlin.x> yWJ;
  private final f yWK;
  private final f yWL;
  private final f yWM;
  private final f yWN;
  private final f yWO;
  private final f yWP;
  private final f yWQ;
  private final f yWR;
  private final f yWS;
  private final f yWT;
  private final f yWU;
  private final f yWV;
  private final f yWW;
  private boolean yWX;
  private com.tencent.mm.plugin.finder.live.model.context.a yWY;
  private final f yWx;
  private final f yWy;
  private final f yWz;
  
  public j(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(291452);
    this.yWY = parama;
    this.TAG = "Finder.FinderLiveCommentAdapter";
    this.yWx = g.ar((kotlin.g.a.a)j.e.yXe);
    this.yWy = g.ar((kotlin.g.a.a)j.a.yWZ);
    this.yWz = g.ar((kotlin.g.a.a)j.c.yXb);
    this.yWA = g.ar((kotlin.g.a.a)j.b.yXa);
    this.kMd = new ArrayList();
    parama = MMApplicationContext.getContext();
    p.j(parama, "MMApplicationContext.getContext()");
    this.yWE = new ForegroundColorSpan(parama.getResources().getColor(b.c.half_alpha_white));
    this.yWF = g.ar((kotlin.g.a.a)j.ag.yXC);
    this.yWK = g.ar((kotlin.g.a.a)j.h.yXh);
    this.yWL = g.ar((kotlin.g.a.a)new g(this));
    parama = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {}
    for (int i = 17;; i = 15)
    {
      this.yWB = i;
      this.yWM = g.ar((kotlin.g.a.a)j.f.yXf);
      this.yWN = g.ar((kotlin.g.a.a)new af(this));
      this.yWO = g.ar((kotlin.g.a.a)j.ai.yXD);
      this.yWP = g.ar((kotlin.g.a.a)new ah(this));
      this.yWQ = g.ar((kotlin.g.a.a)j.i.yXi);
      this.yWR = g.ar((kotlin.g.a.a)new ae(this));
      this.yWS = g.ar((kotlin.g.a.a)new ad(this));
      this.yWT = g.ar((kotlin.g.a.a)j.k.yXj);
      this.yWU = g.ar((kotlin.g.a.a)new j(this));
      this.yWV = g.ar((kotlin.g.a.a)j.m.yXk);
      this.yWW = g.ar((kotlin.g.a.a)new l(this));
      this.yWX = true;
      AppMethodBeat.o(291452);
      return;
    }
  }
  
  private final void a(Context paramContext, d paramd, ao paramao)
  {
    Object localObject4 = null;
    AppMethodBeat.i(291436);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    label72:
    label96:
    Object localObject2;
    if (com.tencent.mm.plugin.finder.live.utils.a.a(paramao))
    {
      paramd.cCj.setBackground(paramContext.getResources().getDrawable(b.e.finder_live_at_comment_bg));
      if (!p.h(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yWY.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, paramao.cGy())) {
        break label502;
      }
      localObject1 = dFt();
      p.j(localObject1, "if (roomData.business(Li…orTag\n            else \"\"");
      if (((CharSequence)localObject1).length() != 0) {
        break label510;
      }
      i = 1;
      if (i == 0) {
        break label522;
      }
      localObject2 = r.ADK;
      localObject2 = paramao.dye();
      if (localObject2 == null) {
        break label516;
      }
      localObject2 = ((aza)localObject2).SHe;
      label126:
      localObject2 = r.eV((List)localObject2);
      label136:
      Object localObject3 = d.xgJ;
      localObject3 = paramd.yXc.getPaint();
      p.j(localObject3, "holder.contentTv.paint");
      Object localObject5 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject5 = d.a(paramContext, (TextPaint)localObject3, (CharSequence)com.tencent.mm.plugin.finder.live.utils.a.hb(paramao.cGy(), paramao.dyd()));
      localObject3 = d.xgJ;
      TextPaint localTextPaint = paramd.yXc.getPaint();
      p.j(localTextPaint, "holder.contentTv.paint");
      localObject3 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      Object localObject6 = paramao.dyf();
      localObject3 = localObject4;
      if (localObject6 != null)
      {
        localObject6 = ((aza)localObject6).contact;
        localObject3 = localObject4;
        if (localObject6 != null) {
          localObject3 = ((FinderContact)localObject6).username;
        }
      }
      localObject4 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject3 = d.a(paramContext, localTextPaint, (CharSequence)com.tencent.mm.plugin.finder.live.utils.a.hb((String)localObject3, com.tencent.mm.plugin.finder.live.utils.a.b(paramao)));
      localObject3 = paramContext.getString(b.j.finder_live_someone_reply_someone, new Object[] { localObject5, localObject3 });
      p.j(localObject3, "context.getString(R.stri…,formUserName,toUserName)");
      localObject4 = paramao.getContent();
      paramao = paramContext.getString(b.j.live_comment_row_content_tmpl, new Object[] { localObject3 });
      p.j(paramao, "context.getString(R.stri…w_content_tmpl, userName)");
      paramContext = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, (CharSequence)b((String)localObject1, (List)localObject2, paramao, (String)localObject4)));
      if (((CharSequence)localObject1).length() <= 0) {
        break label528;
      }
      i = 1;
      label386:
      if (i == 0) {
        break label756;
      }
      paramContext.a(dFu(), (CharSequence)dFt(), 0);
    }
    label516:
    label522:
    label528:
    label756:
    for (int i = dFt().length() + 0;; i = 0)
    {
      if (localObject2 != null)
      {
        localObject1 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ImageSpan)((Iterator)localObject1).next();
            int j = i + 1;
            paramContext.setSpan(localObject2, i, j, 33);
            i = j;
            continue;
            paramd.cCj.setBackground(paramContext.getResources().getDrawable(b.e.finder_live_comment_bg));
            break;
            label502:
            localObject1 = "";
            break label72;
            label510:
            i = 0;
            break label96;
            localObject2 = null;
            break label126;
            localObject2 = null;
            break label136;
            i = 0;
            break label386;
          }
        }
      }
      for (;;)
      {
        paramContext.a(this.yWE, (CharSequence)paramao, i);
        paramd.yXc.aL((CharSequence)paramContext);
        paramao = paramd.yXc.getParent();
        if (paramao != null) {
          break;
        }
        paramContext = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(291436);
        throw paramContext;
      }
      paramao = (RelativeLayout)paramao;
      localObject1 = paramd.yXc.getParent();
      if (localObject1 == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(291436);
        throw paramContext;
      }
      ((RelativeLayout)localObject1).setPadding(dFp(), paramao.getPaddingTop(), paramao.getPaddingRight(), paramao.getPaddingBottom());
      paramd.yXc.aL((CharSequence)paramContext);
      paramd.yXc.setTextSize(this.yWB);
      paramContext = paramd.yXc.getParent();
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(291436);
        throw paramContext;
      }
      paramContext = (RelativeLayout)paramContext;
      if (i == 0) {}
      for (i = dFp();; i = 0)
      {
        paramContext.setPadding(i, paramContext.getPaddingTop(), paramContext.getPaddingRight(), paramContext.getPaddingBottom());
        AppMethodBeat.o(291436);
        return;
      }
    }
  }
  
  private final void a(Context paramContext, d paramd, final String paramString)
  {
    AppMethodBeat.i(291438);
    paramString = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, (CharSequence)paramContext.getString(b.j.finder_live_annoucement, new Object[] { paramString })));
    paramString.a((af)this.yWN.getValue(), (CharSequence)dFv(), 0);
    final aa.f localf = new aa.f();
    ViewParent localViewParent = paramd.yXc.getParent();
    if (localViewParent == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(291438);
      throw paramContext;
    }
    localf.aaBC = ((RelativeLayout)localViewParent);
    paramd.yXc.aL((CharSequence)paramString);
    paramd.yXc.setTextSize(this.yWB);
    paramd.yXc.post((Runnable)new v(paramd, localf, paramString));
    paramd.cCj.setBackground(paramContext.getResources().getDrawable(b.e.finder_live_comment_bg));
    AppMethodBeat.o(291438);
  }
  
  private final void a(com.tencent.mm.pluginsdk.ui.span.m paramm, ImageSpan paramImageSpan)
  {
    AppMethodBeat.i(291443);
    if (paramm != null)
    {
      paramm.a((af)this.yWR.getValue(), (CharSequence)dFy(), 0);
      int i = dFy().length();
      if (paramImageSpan != null) {
        paramm.setSpan(paramImageSpan, i, i + 1, 33);
      }
      AppMethodBeat.o(291443);
      return;
    }
    AppMethodBeat.o(291443);
  }
  
  private final boolean a(CharSequence paramCharSequence, NeatTextView paramNeatTextView)
  {
    AppMethodBeat.i(291441);
    int k = this.yWC;
    int m = paramNeatTextView.getPaddingLeft();
    int n = paramNeatTextView.getPaddingRight();
    ViewParent localViewParent = paramNeatTextView.getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    int i;
    if (localObject != null)
    {
      i = ((ViewGroup)localObject).getPaddingLeft();
      localViewParent = paramNeatTextView.getParent();
      localObject = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject = null;
      }
      localObject = (ViewGroup)localObject;
      if (localObject == null) {
        break label188;
      }
    }
    label188:
    for (int j = ((ViewGroup)localObject).getPaddingRight();; j = 0)
    {
      i = k - m - n - i - j;
      if (i <= 0) {
        break label243;
      }
      j = paramNeatTextView.getMaxLines();
      paramNeatTextView.setMaxLines(2147483647);
      paramNeatTextView.aL(paramCharSequence);
      paramCharSequence = paramNeatTextView.nH(i, 2147483647);
      p.j(paramCharSequence, "staticLayout");
      k = paramCharSequence.ikp();
      paramNeatTextView.setMaxLines(j);
      if (k > 1) {
        break label194;
      }
      AppMethodBeat.o(291441);
      return true;
      i = 0;
      break;
    }
    label194:
    if (k <= 2)
    {
      if (i - paramCharSequence.azV(1) > dFq())
      {
        AppMethodBeat.o(291441);
        return true;
      }
      AppMethodBeat.o(291441);
      return false;
    }
    AppMethodBeat.o(291441);
    return false;
    label243:
    Log.i(this.TAG, "matchRules " + i + ", " + paramCharSequence);
    AppMethodBeat.o(291441);
    return true;
  }
  
  private final boolean a(CharSequence paramCharSequence, NeatTextView paramNeatTextView, int paramInt)
  {
    AppMethodBeat.i(291442);
    for (;;)
    {
      try
      {
        int k = this.yWC;
        int m = paramNeatTextView.getPaddingLeft();
        int n = paramNeatTextView.getPaddingRight();
        ViewParent localViewParent = paramNeatTextView.getParent();
        Object localObject = localViewParent;
        if (!(localViewParent instanceof ViewGroup)) {
          localObject = null;
        }
        localObject = (ViewGroup)localObject;
        if (localObject != null)
        {
          i = ((ViewGroup)localObject).getPaddingLeft();
          localViewParent = paramNeatTextView.getParent();
          localObject = localViewParent;
          if (!(localViewParent instanceof ViewGroup)) {
            localObject = null;
          }
          localObject = (ViewGroup)localObject;
          if (localObject == null) {
            break label297;
          }
          j = ((ViewGroup)localObject).getPaddingRight();
          j = k - m - n - i - j - 6;
          if ((j > 0) && (j > dFq()))
          {
            i = paramNeatTextView.getMaxLines();
            paramNeatTextView.setMaxLines(2147483647);
            paramNeatTextView.aL(paramCharSequence);
            paramCharSequence = paramNeatTextView.nH(j - dFq(), 2147483647);
            p.j(paramCharSequence, "staticLayout");
            j = paramCharSequence.ikp();
            paramNeatTextView.setMaxLines(i);
            if ((j > 1) && (paramCharSequence.azW(1) > paramInt))
            {
              AppMethodBeat.o(291442);
              return true;
            }
            AppMethodBeat.o(291442);
            return false;
          }
          Log.i(this.TAG, "giftSingleLine " + j + ", " + paramCharSequence);
          AppMethodBeat.o(291442);
          return false;
        }
      }
      catch (Throwable paramCharSequence)
      {
        Log.printErrStackTrace(this.TAG, paramCharSequence, "", new Object[0]);
        AppMethodBeat.o(291442);
        return false;
      }
      int i = 0;
      continue;
      label297:
      int j = 0;
    }
  }
  
  private final String b(String paramString1, List<? extends ImageSpan> paramList, String paramString2, String paramString3)
  {
    int j = 0;
    AppMethodBeat.i(291435);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("createTextMsg:");
    int i;
    if (((CharSequence)paramString1).length() > 0)
    {
      i = 1;
      if (i != 0)
      {
        localStringBuilder1.append(paramString1);
        localStringBuilder2.append("anchorTag:" + paramString1 + ',');
      }
      if (paramList == null) {
        break label128;
      }
      i = paramList.size();
    }
    for (;;)
    {
      if (j >= i) {
        break label134;
      }
      localStringBuilder1.append(" ");
      j += 1;
      continue;
      i = 0;
      break;
      label128:
      i = 0;
    }
    label134:
    localStringBuilder2.append("badgeSpanSize:" + i + ',');
    localStringBuilder1.append(paramString2);
    localStringBuilder2.append("userTag:" + paramString2 + ',');
    if (paramString3 == null) {}
    for (paramString1 = "";; paramString1 = paramString3)
    {
      localStringBuilder1.append(paramString1);
      localStringBuilder2.append("content:" + paramString3 + '!');
      paramString1 = localStringBuilder1.toString();
      p.j(paramString1, "result.toString()");
      paramList = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.ha(this.TAG, "#createTextMsg result=".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(291435);
      return paramString1;
    }
  }
  
  private final String dFA()
  {
    AppMethodBeat.i(291446);
    String str = (String)this.yWV.getValue();
    AppMethodBeat.o(291446);
    return str;
  }
  
  private int dFp()
  {
    AppMethodBeat.i(291429);
    int i = ((Number)this.yWx.getValue()).intValue();
    AppMethodBeat.o(291429);
    return i;
  }
  
  private int dFr()
  {
    AppMethodBeat.i(291431);
    int i = ((Number)this.yWz.getValue()).intValue();
    AppMethodBeat.o(291431);
    return i;
  }
  
  private int dFs()
  {
    AppMethodBeat.i(291432);
    int i = ((Number)this.yWA.getValue()).intValue();
    AppMethodBeat.o(291432);
    return i;
  }
  
  private final String dFt()
  {
    AppMethodBeat.i(291433);
    String str = (String)this.yWK.getValue();
    AppMethodBeat.o(291433);
    return str;
  }
  
  private final af dFu()
  {
    AppMethodBeat.i(291434);
    af localaf = (af)this.yWL.getValue();
    AppMethodBeat.o(291434);
    return localaf;
  }
  
  private af dFx()
  {
    AppMethodBeat.i(291440);
    af localaf = (af)this.yWP.getValue();
    AppMethodBeat.o(291440);
    return localaf;
  }
  
  private final String dFz()
  {
    AppMethodBeat.i(291445);
    String str = (String)this.yWT.getValue();
    AppMethodBeat.o(291445);
    return str;
  }
  
  public final int dFq()
  {
    AppMethodBeat.i(291430);
    int i = ((Number)this.yWy.getValue()).intValue();
    AppMethodBeat.o(291430);
    return i;
  }
  
  public final String dFv()
  {
    AppMethodBeat.i(291437);
    String str = (String)this.yWM.getValue();
    AppMethodBeat.o(291437);
    return str;
  }
  
  public final String dFw()
  {
    AppMethodBeat.i(291439);
    String str = (String)this.yWO.getValue();
    AppMethodBeat.o(291439);
    return str;
  }
  
  public final String dFy()
  {
    AppMethodBeat.i(291444);
    String str = (String)this.yWQ.getValue();
    AppMethodBeat.o(291444);
    return str;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(291448);
    int i = this.kMd.size();
    AppMethodBeat.o(291448);
    return i;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindViewHolder$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class aa
    implements HardTouchableLayout.b
  {
    aa(int paramInt) {}
    
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(276082);
      p.k(paramView, "view");
      p.k(paramMotionEvent, "e");
      paramMotionEvent = (ao)kotlin.a.j.M((List)this.yXg.kMd, this.jEN);
      if (paramMotionEvent != null)
      {
        paramView = this.yXg.yWI;
        if (paramView != null)
        {
          paramView.invoke(paramMotionEvent);
          AppMethodBeat.o(276082);
          return;
        }
        AppMethodBeat.o(276082);
        return;
      }
      Log.w(j.a(this.yXg), "onDoubleClick IndexOutOfBounds! position:" + this.jEN + " commentList.size:" + this.yXg.kMd.size() + " view:" + paramView);
      AppMethodBeat.o(276082);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(j.d paramd, aa.f paramf, com.tencent.mm.pluginsdk.ui.span.m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(226697);
      if (this.yXA.yXc.getLineCount() > 1)
      {
        ((RelativeLayout)this.ypl.aaBC).setPadding(0, ((RelativeLayout)this.ypl.aaBC).getPaddingTop(), 0, ((RelativeLayout)this.ypl.aaBC).getPaddingBottom());
        this.yXA.yXc.setSpacingAdd(5);
        SpannableStringBuilder localSpannableStringBuilder = SpannableStringBuilder.valueOf((CharSequence)this.ypm);
        localSpannableStringBuilder.setSpan(new LeadingMarginSpan.Standard(0, aw.fromDPToPix(MMApplicationContext.getContext(), 11)), 0, this.ypm.length(), 33);
        this.yXA.yXc.aL((CharSequence)localSpannableStringBuilder);
        AppMethodBeat.o(226697);
        return;
      }
      ((RelativeLayout)this.ypl.aaBC).setPadding(0, ((RelativeLayout)this.ypl.aaBC).getPaddingTop(), ((RelativeLayout)this.ypl.aaBC).getPaddingRight(), ((RelativeLayout)this.ypl.aaBC).getPaddingBottom());
      AppMethodBeat.o(226697);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onCreateViewHolder$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class ac
    implements HardTouchableLayout.c
  {
    public final boolean Y(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(271030);
      p.k(paramMotionEvent, "event");
      AppMethodBeat.o(271030);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class ad
    extends q
    implements kotlin.g.a.a<af>
  {
    ad(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class ae
    extends q
    implements kotlin.g.a.a<af>
  {
    ae(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class af
    extends q
    implements kotlin.g.a.a<af>
  {
    af(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class ah
    extends q
    implements kotlin.g.a.a<af>
  {
    ah(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "getArrow", "()Landroid/view/View;", "bgView", "getBgView", "contentTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getContentTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.v
  {
    final View cCj;
    final MMNeat7extView yXc;
    final View yXd;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(285851);
      View localView = paramView.findViewById(b.f.live_comment_item_content_tv);
      p.j(localView, "itemView.findViewById(R.…_comment_item_content_tv)");
      this.yXc = ((MMNeat7extView)localView);
      localView = paramView.findViewById(b.f.live_comment_container);
      p.j(localView, "itemView.findViewById(R.id.live_comment_container)");
      this.cCj = localView;
      paramView = paramView.findViewById(b.f.live_comment_arrow);
      p.j(paramView, "itemView.findViewById(R.id.live_comment_arrow)");
      this.yXd = paramView;
      AppMethodBeat.o(285851);
    }
    
    public final MMNeat7extView dFB()
    {
      return this.yXc;
    }
    
    public final View dFC()
    {
      return this.yXd;
    }
    
    public final View getBgView()
    {
      return this.cCj;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<af>
  {
    g(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<af>
  {
    j(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<af>
  {
    l(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindComboLiveRewardMsg$3$1"})
  static final class n<T, R>
    implements e<w, Bitmap>
  {
    n(j paramj, String paramString, j.d paramd, axq paramaxq, Context paramContext, aa.f paramf, aa.d paramd1) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.span.m>
  {
    o(j paramj, Context paramContext, String paramString, aa.f paramf1, aa.f paramf2, aa.f paramf3, ImageSpan paramImageSpan)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.span.m>
  {
    p(j paramj, Context paramContext, String paramString1, aa.f paramf1, String paramString2, aa.f paramf2, aa.f paramf3, ImageSpan paramImageSpan)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.span.m>
  {
    q(j paramj, Context paramContext, String paramString, aa.f paramf1, aa.f paramf2, aa.f paramf3, ImageSpan paramImageSpan)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.span.m>
  {
    r(j paramj, Context paramContext, String paramString1, aa.f paramf1, String paramString2, aa.f paramf2, aa.f paramf3, ImageSpan paramImageSpan)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.span.m>
  {
    s(j paramj, Context paramContext, String paramString1, aa.f paramf1, String paramString2, aa.f paramf2, aa.f paramf3, ImageSpan paramImageSpan)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindRecvLuckyMoneyMsg$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class t
    extends ClickableSpan
  {
    t(ao paramao, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291654);
      p.k(paramView, "widget");
      if ((this.yXz instanceof com.tencent.mm.plugin.finder.live.model.x))
      {
        paramView = this.yXz.dyn();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAppMsgRecvRedPacketInfo");
          AppMethodBeat.o(291654);
          throw paramView;
        }
        paramView = (axz)paramView;
        kotlin.g.a.b localb = this.yXg.yWJ;
        if (localb != null)
        {
          localb.invoke(paramView.SKs);
          AppMethodBeat.o(291654);
          return;
        }
      }
      AppMethodBeat.o(291654);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(291655);
      p.k(paramTextPaint, "ds");
      paramTextPaint.setColor(this.$context.getResources().getColor(b.c.finder_live_comment_lucky_money_color));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(291655);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindSendLuckyMoneyMsg$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class u
    extends ClickableSpan
  {
    u(ao paramao, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291802);
      p.k(paramView, "widget");
      if ((this.yXz instanceof y))
      {
        paramView = this.yXz.dyn();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAppMsgSendRedPacketInfo");
          AppMethodBeat.o(291802);
          throw paramView;
        }
        paramView = (ayc)paramView;
        kotlin.g.a.b localb = this.yXg.yWJ;
        if (localb != null)
        {
          localb.invoke(paramView.SKs);
          AppMethodBeat.o(291802);
          return;
        }
      }
      AppMethodBeat.o(291802);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(291803);
      p.k(paramTextPaint, "ds");
      paramTextPaint.setColor(this.$context.getResources().getColor(b.c.finder_live_comment_lucky_money_color));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(291803);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(j.d paramd, aa.f paramf, com.tencent.mm.pluginsdk.ui.span.m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(275841);
      if (this.yXA.yXc.getLineCount() > 1)
      {
        ((RelativeLayout)localf.aaBC).setPadding(0, ((RelativeLayout)localf.aaBC).getPaddingTop(), 0, ((RelativeLayout)localf.aaBC).getPaddingBottom());
        this.yXA.yXc.setSpacingAdd(5);
        SpannableStringBuilder localSpannableStringBuilder = SpannableStringBuilder.valueOf((CharSequence)paramString);
        localSpannableStringBuilder.setSpan(new LeadingMarginSpan.Standard(0, aw.fromDPToPix(MMApplicationContext.getContext(), 6)), 0, paramString.length(), 33);
        this.yXA.yXc.aL((CharSequence)localSpannableStringBuilder);
        AppMethodBeat.o(275841);
        return;
      }
      ((RelativeLayout)localf.aaBC).setPadding(0, ((RelativeLayout)localf.aaBC).getPaddingTop(), ((RelativeLayout)localf.aaBC).getPaddingRight(), ((RelativeLayout)localf.aaBC).getPaddingBottom());
      AppMethodBeat.o(275841);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"getContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "invoke"})
  static final class w
    extends q
    implements kotlin.g.a.a<aza>
  {
    w(ao paramao)
    {
      super();
    }
    
    public final aza dFD()
    {
      AppMethodBeat.i(229011);
      aza localaza = this.yXz.dye();
      AppMethodBeat.o(229011);
      return localaza;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(j.d paramd, aa.f paramf, com.tencent.mm.pluginsdk.ui.span.m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(274264);
      if (this.yXA.yXc.getLineCount() > 1)
      {
        Object localObject = this.yXA.yXc.getParent();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
          AppMethodBeat.o(274264);
          throw ((Throwable)localObject);
        }
        ((RelativeLayout)localObject).setPadding(0, ((RelativeLayout)this.ypl.aaBC).getPaddingTop(), 0, ((RelativeLayout)this.ypl.aaBC).getPaddingBottom());
        this.yXA.yXc.setSpacingAdd(5);
        localObject = SpannableStringBuilder.valueOf((CharSequence)this.ypm);
        ((SpannableStringBuilder)localObject).setSpan(new LeadingMarginSpan.Standard(0, aw.fromDPToPix(MMApplicationContext.getContext(), 11)), 0, this.ypm.length(), 33);
        this.yXA.yXc.aL((CharSequence)localObject);
      }
      AppMethodBeat.o(274264);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindViewHolder$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class y
    implements HardTouchableLayout.g
  {
    y(ao paramao, int paramInt, j.d paramd) {}
    
    public final void et(View paramView)
    {
      AppMethodBeat.i(290518);
      p.k(paramView, "view");
      if (this.yXB != null)
      {
        Log.i(j.a(this.yXg), "topComment,content:" + this.yXB.getContent() + ",position:" + this.jEN);
        paramView = this.yXg.yWH;
        if (paramView != null)
        {
          ao localao = this.yXB;
          View localView = this.yXA.amk;
          p.j(localView, "holder.itemView");
          paramView.invoke(localao, localView);
          AppMethodBeat.o(290518);
          return;
        }
        AppMethodBeat.o(290518);
        return;
      }
      Log.w(j.a(this.yXg), "OnClick IndexOutOfBounds! position:" + this.jEN + " commentList.size:" + this.yXg.kMd.size() + " view:" + paramView);
      AppMethodBeat.o(290518);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindViewHolder$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class z
    implements HardTouchableLayout.d
  {
    z(j.d paramd, ao paramao, int paramInt) {}
    
    public final void eD(View paramView)
    {
      AppMethodBeat.i(269930);
      p.k(paramView, "view");
      String str = this.yXA.yXc.ikC().toString();
      if (this.yXB != null)
      {
        paramView = this.yXg.yWG;
        if (paramView != null)
        {
          paramView.invoke(this.yXB, str);
          AppMethodBeat.o(269930);
          return;
        }
        AppMethodBeat.o(269930);
        return;
      }
      Log.w(j.a(this.yXg), "OnLongClick IndexOutOfBounds! position:" + this.jEN + " commentList.size:" + this.yXg.kMd.size() + " view:" + paramView);
      AppMethodBeat.o(269930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.j
 * JD-Core Version:    0.7.0.1
 */