package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.n.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderTextUtils;", "", "()V", "Edge_2A", "", "Edge_2_5_A", "getEdge_2_5_A", "()I", "TAG", "", "_2dp", "", "campaignColor", "disableColor", "iconPadding", "iconWidth", "layoutWidth", "linkBgColor", "linkColor1", "linkColor2", "measureTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "normalLinkColor", "poiColor", "addReportParamForBizUrl", "url", "scene", "subScene", "clickTime", "appendHeadLeading", "text", "copySpan", "Landroid/text/SpannableString;", "src", "dest", "formatRecommendDesc", "Landroid/text/SpannableStringBuilder;", "incCount", "prefix", "context", "Landroid/content/Context;", "isNewsObject", "", "hotFireIconColor", "hotFireIconSize", "isIconFilled", "getBubbleMessageCount", "count", "getCampaignSpan", "Lkotlin/Pair;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "linkColor", "availWidth", "getCampaignTagTitle", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "getCampaignText", "isWithEllipse", "getFriendRecommendText", "friendRecommendCount", "likeCount", "commentCount", "totalCount", "getLimitDescSpan", "layout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "limitCount", "desc", "getLinkSpan", "getPoiSpan", "getTimeText", "isFinderSelfScene", "getTimelineBubbleWidth", "getWxBubbleText", "handleCampaignOnClick", "", "handleLinkTvOnClick", "link", "handlePoiOnClick", "poiText", "makeTest", "mergeContent", "Lkotlin/Triple;", "isSelfScene", "AsyncGetDescText", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
{
  private static final float AIr;
  private static final int Edge_2A;
  private static final int Edge_2_5_A;
  private static final int GiA;
  private static final int GiB;
  private static final int GiC;
  private static final int GiD;
  private static final MMNeat7extView GiE;
  public static final ar Giw;
  private static final int Gix;
  private static final int Giy;
  private static final int Giz;
  private static final int iconPadding;
  private static final int iconWidth;
  private static final int layoutWidth;
  
  static
  {
    AppMethodBeat.i(333146);
    Giw = new ar();
    iconPadding = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 24);
    AIr = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2.0F);
    Edge_2A = (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_2A);
    Edge_2_5_A = (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_2_5_A);
    iconWidth = Edge_2A;
    Gix = MMApplicationContext.getContext().getResources().getColor(e.b.hot_tab_BW_0_Alpha_0_1);
    Giy = com.tencent.mm.cd.a.w(MMApplicationContext.getContext(), e.b.finder_btn_disable_color);
    Giz = Color.parseColor("#DEE9FF");
    GiA = MMApplicationContext.getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_8);
    GiB = MMApplicationContext.getContext().getResources().getColor(e.b.Orange);
    GiC = MMApplicationContext.getContext().getResources().getColor(e.b.Brand);
    GiD = MMApplicationContext.getContext().getResources().getColor(e.b.Brand);
    layoutWidth = MMApplicationContext.getContext().getResources().getDisplayMetrics().widthPixels - Edge_2A * 2;
    MMNeat7extView localMMNeat7extView = new MMNeat7extView(MMApplicationContext.getContext());
    localMMNeat7extView.setTextSize(1, com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext()) * 15.0F);
    localMMNeat7extView.setMaxWidth(layoutWidth);
    GiE = localMMNeat7extView;
    AppMethodBeat.o(333146);
  }
  
  private static String TY(int paramInt)
  {
    AppMethodBeat.i(333107);
    if (paramInt > 99)
    {
      AppMethodBeat.o(333107);
      return "99+";
    }
    AppMethodBeat.o(333107);
    return String.valueOf(paramInt);
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(333098);
    s.u(paramContext, "context");
    if (paramInt2 == 0)
    {
      if (paramInt1 > 0)
      {
        paramContext = b(paramContext, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(333098);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(e.h.finder_message_comment_tip, new Object[] { TY(paramInt3) });
      s.s(paramContext, "{\n                    co…Count))\n                }");
      AppMethodBeat.o(333098);
      return paramContext;
    }
    if (paramInt3 == 0)
    {
      if (paramInt1 > 0)
      {
        paramContext = b(paramContext, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(333098);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(e.h.finder_message_like_tip, new Object[] { TY(paramInt2) });
      s.s(paramContext, "{\n                    co…Count))\n                }");
      AppMethodBeat.o(333098);
      return paramContext;
    }
    if (paramInt1 > 0)
    {
      paramContext = b(paramContext, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(333098);
      return paramContext;
    }
    paramContext = paramContext.getResources().getString(e.h.finder_new_message_tip, new Object[] { TY(paramInt4) });
    s.s(paramContext, "{\n                contex…otalCount))\n            }");
    AppMethodBeat.o(333098);
    return paramContext;
  }
  
  public static String a(brg parambrg, Context paramContext)
  {
    Object localObject2 = null;
    AppMethodBeat.i(333070);
    s.u(parambrg, "activityEvent");
    s.u(paramContext, "context");
    Object localObject1 = av.GiL;
    boolean bool = av.qI(parambrg.ZZn);
    if ((Util.isNullOrNil(parambrg.eventName)) || (Util.isNullOrNil(parambrg.ZZl))) {
      parambrg = paramContext.getString(e.h.finder_activity_title);
    }
    for (;;)
    {
      s.s(parambrg, "if (Util.isNullOrNil(act…          }\n            }");
      AppMethodBeat.o(333070);
      return parambrg;
      localObject1 = parambrg.ZHN;
      if (localObject1 == null)
      {
        localObject1 = null;
        label89:
        if (localObject1 == null) {
          break label191;
        }
        if (!bool) {
          break label157;
        }
        localObject1 = parambrg.ZHN;
        if (localObject1 != null) {
          break label149;
        }
      }
      label149:
      for (localObject1 = localObject2;; localObject1 = ((awx)localObject1).ZIb)
      {
        parambrg = s.X((String)localObject1, paramContext.getString(e.h.finder_activity_config_feed_tag, new Object[] { parambrg.ZZl, "" }));
        break;
        localObject1 = ((awx)localObject1).ZIb;
        break label89;
      }
      label157:
      parambrg = parambrg.ZHN;
      if (parambrg == null)
      {
        parambrg = "";
      }
      else
      {
        paramContext = parambrg.ZIb;
        parambrg = paramContext;
        if (paramContext == null)
        {
          parambrg = "";
          continue;
          label191:
          if (bool) {
            parambrg = paramContext.getString(e.h.finder_activity_feed_tag, new Object[] { parambrg.ZZl, "" });
          } else {
            parambrg = paramContext.getString(e.h.finder_activity_title_with_quote);
          }
        }
      }
    }
  }
  
  public static kotlin.u<Boolean, Integer, SpannableString> a(final Context paramContext, final BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
  {
    AppMethodBeat.i(333050);
    s.u(paramContext, "context");
    s.u(paramBaseFinderFeed, "item");
    System.nanoTime();
    SpannableString localSpannableString = paramBaseFinderFeed.feedObject.getDescriptionFullSpan();
    Object localObject1;
    int i;
    int j;
    try
    {
      localObject1 = Result.Companion;
      localSpannableStringBuilder1 = new SpannableStringBuilder((CharSequence)localSpannableString);
      localSpannableStringBuilder2 = new SpannableStringBuilder();
      if (((bw)h.ax(bw.class)).aBu()) {
        break label1523;
      }
      i = Giz;
      f1 = layoutWidth - iconPadding - iconWidth;
      localObject3 = GiE;
      f2 = layoutWidth - iconWidth;
      j = paramBaseFinderFeed.feedObject.getFeedObject().adFlag;
      Log.i("Finder.TextUtils", s.X("getCampaignSpan adFlag:", Integer.valueOf(j)));
      if (4 != j) {
        break label1531;
      }
      localObject1 = new kotlin.r(Integer.valueOf(-1), null);
      label160:
      m = ((Number)((kotlin.r)localObject1).bsC).intValue();
      localObject3 = (SpannableString)((kotlin.r)localObject1).bsD;
      localObject4 = GiE;
      localObject1 = av.GiL;
      localObject1 = paramBaseFinderFeed.feedObject.getLocation().city;
      localObject2 = (CharSequence)localObject1;
      if (localObject2 == null) {
        break label2630;
      }
      if (((CharSequence)localObject2).length() != 0) {
        break label2832;
      }
    }
    finally
    {
      for (;;)
      {
        SpannableStringBuilder localSpannableStringBuilder1;
        SpannableStringBuilder localSpannableStringBuilder2;
        float f1;
        Object localObject3;
        float f2;
        int m;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        Drawable localDrawable;
        paramBaseFinderFeed = Result.Companion;
        paramContext = Result.constructor-impl(ResultKt.createFailure(paramContext));
        continue;
        i = ((com.tencent.neattextview.textview.layout.a)localObject1).jQH();
        continue;
        paramContext = new SpannableString((CharSequence)"");
        continue;
        paramContext = (CharSequence)"";
      }
      AppMethodBeat.o(333050);
      return paramContext;
    }
    Object localObject2 = paramBaseFinderFeed.feedObject.getLocation().poiName;
    localObject5 = (CharSequence)localObject2;
    label267:
    label300:
    label316:
    label335:
    int n;
    int i1;
    label417:
    label454:
    int k;
    if (localObject5 != null)
    {
      if (((CharSequence)localObject5).length() != 0) {
        break label2841;
      }
      break label2644;
      localObject1 = av.cn((String)localObject1, (String)localObject2);
      if (localObject1 != null)
      {
        if (((CharSequence)localObject1).length() != 0) {
          break label2847;
        }
        j = 1;
        break label2658;
        if (((CharSequence)localObject1).length() != 0) {
          break label2853;
        }
        j = 1;
        if (j != 0)
        {
          localObject1 = new kotlin.r(Integer.valueOf(-1), null);
          n = ((Number)((kotlin.r)localObject1).bsC).intValue();
          localObject4 = (SpannableString)((kotlin.r)localObject1).bsD;
          localObject5 = GiE;
          i1 = paramBaseFinderFeed.feedObject.getExtReading().style;
          localObject1 = av.GiL;
          localObject1 = paramBaseFinderFeed.feedObject.getExtReading().link;
          localObject2 = (CharSequence)localObject1;
          if (localObject2 == null) {
            break label2671;
          }
          if (((CharSequence)localObject2).length() != 0) {
            break label2866;
          }
          break label2671;
          localObject2 = paramBaseFinderFeed.feedObject.getExtReading().title;
          localObject6 = (CharSequence)localObject2;
          if (localObject6 == null) {
            break label2685;
          }
          if (((CharSequence)localObject6).length() != 0) {
            break label2875;
          }
          break label2685;
          localObject6 = aw.Gjk;
          if ((localObject1 == null) || (localObject2 == null)) {
            break label2500;
          }
          localObject5 = s.X("  ", TextUtils.ellipsize((CharSequence)localObject2, ((MMNeat7extView)localObject5).getPaint(), f1, TextUtils.TruncateAt.END));
          localObject6 = new SpannableString((CharSequence)localObject5);
          if ((!((bw)h.ax(bw.class)).aBu()) && (!paramBaseFinderFeed.isPreview)) {
            break label2484;
          }
          j = Giz;
          label537:
          if (i1 == 1) {
            break label2492;
          }
          k = e.g.icons_filled_link;
          label548:
          localDrawable = bb.m(paramContext, k, j);
          localDrawable.setBounds(0, 0, (int)(iconWidth * 1.0F * localDrawable.getIntrinsicWidth() / localDrawable.getIntrinsicHeight()), iconWidth);
          if ((((bw)h.ax(bw.class)).aBu()) || (paramBaseFinderFeed.isPreview)) {
            i = Giz;
          }
          ((SpannableString)localObject6).setSpan(new com.tencent.mm.ui.widget.a(localDrawable, 1), 0, 1, 17);
          localObject1 = new q((String)localObject2, i, Gix, (kotlin.g.a.b)new c(paramContext, paramBaseFinderFeed, (String)localObject1));
          ((q)localObject1).shadowRadius = AIr;
          localObject2 = ah.aiuX;
          ((SpannableString)localObject6).setSpan(localObject1, 1, ((String)localObject5).length(), 17);
          switch (i1)
          {
          default: 
            label720:
            localObject1 = new kotlin.r(Integer.valueOf(i), localObject6);
            label736:
            k = ((Number)((kotlin.r)localObject1).bsC).intValue();
            localObject1 = (SpannableString)((kotlin.r)localObject1).bsD;
            if ((!paramBoolean) && (paramBaseFinderFeed.feedObject.getCreateTime() > 0))
            {
              if (paramBaseFinderFeed.feedObject.getFeedObject().objectType != 1) {
                break label2893;
              }
              i = 1;
              break label2705;
              label793:
              localObject2 = new SpannableString((CharSequence)r.q(paramContext, paramBaseFinderFeed.feedObject.getCreateTime() * 1000L));
              ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_4)), 0, ((SpannableString)localObject2).length(), 17);
              if (!paramBoolean) {
                break label2899;
              }
              i = 1;
              label858:
              paramContext = new kotlin.r(Integer.valueOf(i), localObject2);
              label873:
              i1 = ((Number)paramContext.bsC).intValue();
              localObject2 = (SpannableString)paramContext.bsD;
              paramContext = new ah.a();
              localObject5 = (CharSequence)localSpannableString;
              if (localObject5 == null) {
                break label2717;
              }
              if (((CharSequence)localObject5).length() != 0) {
                break label2905;
              }
              break label2717;
              label927:
              paramContext.aiwY = paramBoolean;
              if (m >= 0)
              {
                if (paramContext.aiwY) {
                  localSpannableStringBuilder2.append((CharSequence)"\n");
                }
                localSpannableStringBuilder2.append((CharSequence)localObject3);
                paramContext.aiwY = true;
              }
              if ((k > n) && (k > 0) && (n == 0))
              {
                b(k, paramContext, localSpannableStringBuilder2, (SpannableString)localObject1);
                a(n, paramContext, localSpannableStringBuilder2, (SpannableString)localObject4);
                label1009:
                if (i1 >= 0)
                {
                  if (paramContext.aiwY) {
                    localSpannableStringBuilder2.append((CharSequence)"\n");
                  }
                  localSpannableStringBuilder2.append((CharSequence)localObject2);
                  paramContext.aiwY = true;
                }
                localObject1 = paramBaseFinderFeed.feedObject.getDescLayout();
                if (localObject1 != null) {
                  break label2572;
                }
                i = 2;
                j = Math.min(i, 2);
                i = j;
                if (m <= 0) {
                  break label2730;
                }
                i = j + 1;
                break label2730;
                label1092:
                k = Math.max(j, 2);
                System.nanoTime();
                if (paramContext.aiwY)
                {
                  paramContext = (CharSequence)localSpannableString;
                  if (paramContext == null) {
                    break label2778;
                  }
                  if (paramContext.length() != 0) {
                    break label2916;
                  }
                  break label2778;
                  label1133:
                  if (i == 0)
                  {
                    paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getDescLayout();
                    paramContext = paramBaseFinderFeed;
                    if (paramBaseFinderFeed == null)
                    {
                      GiE.setMaxLines(2);
                      GiE.setEllipsize(TextUtils.TruncateAt.END);
                      GiE.aZ((CharSequence)localSpannableString);
                      paramContext = GiE.pE(layoutWidth, 2147483647);
                    }
                    if (paramContext.aGN(1) > 0)
                    {
                      localSpannableStringBuilder1.clear();
                      localSpannableStringBuilder1.clearSpans();
                      s.s(paramContext, "descLayout");
                      i = paramContext.aGM(1);
                      j = paramContext.dk(1);
                      if ((j + i <= 0) || (localSpannableString == null)) {
                        break label2584;
                      }
                      paramContext = (SpannableString)localSpannableString.subSequence(0, Math.min(j + i, localSpannableString.length()));
                      localSpannableStringBuilder1.append((CharSequence)new SpannableString((CharSequence)new SpannableStringBuilder((CharSequence)paramContext).append((CharSequence)"…")));
                    }
                  }
                }
                System.nanoTime();
                localSpannableStringBuilder1.append((CharSequence)localSpannableStringBuilder2);
                paramContext = (CharSequence)localSpannableStringBuilder1;
                i = n.bt(paramContext);
              }
            }
            break;
          }
        }
      }
    }
    label1588:
    label1752:
    label1884:
    label2784:
    for (;;)
    {
      if (i >= 0) {
        if (paramContext.charAt(i) != '\n') {
          break label2922;
        }
      }
      label2147:
      label2790:
      label2922:
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label2928;
        }
        paramContext = paramContext.subSequence(0, i + 1);
        paramContext = new SpannableString(paramContext);
        paramContext = Result.constructor-impl(new kotlin.u(Boolean.FALSE, Integer.valueOf(k), paramContext));
        paramBaseFinderFeed = Result.exceptionOrNull-impl(paramContext);
        if (paramBaseFinderFeed != null)
        {
          e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, "mergeContent_crash", false, null, false, (kotlin.g.a.a)new ar.e(paramBaseFinderFeed), 28);
          Log.printErrStackTrace("Finder.TextUtils", paramBaseFinderFeed, "", new Object[0]);
        }
        if (Result.isFailure-impl(paramContext))
        {
          paramContext = null;
          paramContext = (kotlin.u)paramContext;
          if (paramContext != null) {
            break label2614;
          }
          paramBaseFinderFeed = Boolean.FALSE;
          paramContext = localSpannableString;
          if (localSpannableString == null) {
            paramContext = new SpannableString((CharSequence)"");
          }
          paramContext = new kotlin.u(paramBaseFinderFeed, Integer.valueOf(2), paramContext);
          AppMethodBeat.o(333050);
          return paramContext;
          label1523:
          i = GiA;
          break;
          label1531:
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (localObject1 != null)
          {
            localObject4 = ((FinderObjectDesc)localObject1).event;
            if (localObject4 != null)
            {
              localObject1 = (CharSequence)((brg)localObject4).eventName;
              if (localObject1 == null) {
                break label2784;
              }
              if (((CharSequence)localObject1).length() != 0) {
                break label2797;
              }
              break label2784;
              if (j == 0)
              {
                float f3 = ((MMNeat7extView)localObject3).getPaint().measureText("  ");
                localObject5 = a((brg)localObject4, paramContext);
                if (((brg)localObject4).ZZm == 0)
                {
                  localObject1 = s.X((String)localObject5, ((brg)localObject4).eventName);
                  localObject2 = new SpannableString((CharSequence)s.X("  ", localObject1));
                  j = paramContext.getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_8);
                  if (((bw)h.ax(bw.class)).aBu()) {
                    break label2790;
                  }
                  if (!paramBaseFinderFeed.isPreview) {
                    break label2147;
                  }
                  break label2790;
                }
                for (;;)
                {
                  localObject3 = bb.m(paramContext, e.g.finder_filled_activity, k);
                  k = iconWidth;
                  ((Drawable)localObject3).setBounds(0, 0, k, k);
                  k = j;
                  if (!((bw)h.ax(bw.class)).aBu())
                  {
                    if (!paramBaseFinderFeed.isPreview) {
                      break label2825;
                    }
                    k = j;
                  }
                  ((SpannableString)localObject2).setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject3, 1), 0, 1, 17);
                  localObject1 = new q((String)localObject1, k, Gix, (kotlin.g.a.b)new b(paramBaseFinderFeed, paramContext, (brg)localObject4));
                  ((q)localObject1).shadowRadius = AIr;
                  ((q)localObject1).GDi = true;
                  localObject3 = ah.aiuX;
                  ((SpannableString)localObject2).setSpan(localObject1, 1, ((SpannableString)localObject2).length(), 17);
                  localObject1 = new kotlin.r(Integer.valueOf(1), localObject2);
                  break;
                  localObject1 = av.GiL;
                  if (!av.a(((brg)localObject4).ZHN)) {
                    break label2622;
                  }
                  localObject1 = ((brg)localObject4).ZHN;
                  if (localObject1 == null)
                  {
                    localObject1 = null;
                    localObject1 = (CharSequence)localObject1;
                    if (localObject1 == null) {
                      break label2803;
                    }
                    if (((CharSequence)localObject1).length() != 0) {
                      break label2816;
                    }
                    break label2803;
                    label1909:
                    if (j == 0) {
                      break label2103;
                    }
                    localObject6 = r.ip(2, ((brg)localObject4).ZZm);
                    localObject1 = ((brg)localObject4).ZHN;
                    if (localObject1 != null) {
                      break label2056;
                    }
                  }
                  for (localObject1 = null;; localObject1 = s.X((String)localObject2, ((awx)localObject1).ZIe))
                  {
                    localObject2 = localObject1;
                    if (localObject1 != null) {
                      break label2809;
                    }
                    localObject2 = paramContext.getString(e.h.finder_activity_feed_participate_tag, new Object[] { " ", localObject6 });
                    s.s(localObject2, "context.getString(\n     …teCount\n                )");
                    break label2809;
                    localObject2 = av.GiL;
                    localObject6 = ((MMNeat7extView)localObject3).getPaint();
                    s.s(localObject6, "measureTv.paint");
                    localObject3 = ((brg)localObject4).eventName;
                    localObject2 = localObject3;
                    if (localObject3 == null) {
                      localObject2 = "";
                    }
                    localObject1 = av.a((TextPaint)localObject6, (String)localObject5, (String)localObject2, (String)localObject1, f2 - f3);
                    break;
                    localObject1 = ((awx)localObject1).ZIm;
                    break label1884;
                    localObject2 = paramContext.getString(e.h.finder_activity_feed_participate_tag_new, new Object[] { "", localObject6 });
                    s.s(localObject2, "context.getString(\n     …unt\n                    )");
                  }
                  localObject1 = ((brg)localObject4).ZHN;
                  if (localObject1 == null)
                  {
                    localObject1 = "";
                    break label2822;
                  }
                  localObject2 = ((awx)localObject1).ZIm;
                  localObject1 = localObject2;
                  if (localObject2 != null) {
                    break label2822;
                  }
                  localObject1 = "";
                  break label2822;
                  k = GiB;
                }
              }
            }
          }
          localObject1 = new kotlin.r(Integer.valueOf(-1), null);
          break label160;
          localObject2 = new SpannableString((CharSequence)s.X("  ", TextUtils.ellipsize((CharSequence)localObject1, ((MMNeat7extView)localObject4).getPaint(), f1, TextUtils.TruncateAt.END)));
          if ((((bw)h.ax(bw.class)).aBu()) || (paramBaseFinderFeed.isPreview))
          {
            j = Giz;
            localObject4 = bb.m(paramContext, e.g.icons_filled_location, j);
            j = iconWidth;
            ((Drawable)localObject4).setBounds(0, 0, j, j);
            if ((!((bw)h.ax(bw.class)).aBu()) && (!paramBaseFinderFeed.isPreview)) {
              break label2859;
            }
            j = Giz;
            label2292:
            ((SpannableString)localObject2).setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject4, 1), 0, 1, 17);
            localObject1 = new q((String)localObject1, j, Gix, (kotlin.g.a.b)new d(paramBaseFinderFeed, paramContext));
            ((q)localObject1).shadowRadius = AIr;
            ((q)localObject1).zID = true;
            localObject4 = ah.aiuX;
            ((SpannableString)localObject2).setSpan(localObject1, 1, ((SpannableString)localObject2).length(), 17);
            localObject1 = as.GSQ;
            localObject1 = as.a.hu(paramContext);
            if (localObject1 != null) {
              break label2439;
            }
          }
          for (j = 0;; j = ((as)localObject1).AJo)
          {
            if ((j != 16) || (paramBaseFinderFeed.feedObject.getFeedObject().is_poi_same_city != 1)) {
              break label2449;
            }
            localObject1 = new kotlin.r(Integer.valueOf(1), localObject2);
            break;
            j = GiC;
            break label2236;
          }
          localObject1 = new kotlin.r(Integer.valueOf(0), localObject2);
          break label335;
          localObject1 = new kotlin.r(Integer.valueOf(-1), null);
          break label335;
          j = GiD;
          break label537;
          k = e.g.icons_filled_red_envelope_big;
          break label548;
          localObject1 = new kotlin.r(Integer.valueOf(-1), null);
          break label736;
        }
        label2671:
        label2674:
        label2685:
        do
        {
          paramContext = new kotlin.r(Integer.valueOf(-1), null);
          break label873;
          a(n, paramContext, localSpannableStringBuilder2, (SpannableString)localObject4);
          b(k, paramContext, localSpannableStringBuilder2, (SpannableString)localObject1);
          break label1009;
          localObject1 = "";
          break label1984;
          j = 1;
          if (j == 0) {
            break label2838;
          }
          localObject1 = null;
          break;
          j = 1;
          if (j == 0) {
            break label267;
          }
          localObject2 = null;
          break label267;
          if (j == 0) {
            break label300;
          }
          localObject1 = "";
          break label300;
          j = 1;
          if (j == 0) {
            break label2872;
          }
          localObject1 = null;
          break label417;
          j = 1;
          if (j == 0) {
            break label454;
          }
          localObject2 = null;
          break label454;
          i = -1;
          break label720;
          if (i != 0) {
            break label793;
          }
        } while (!paramBoolean);
        break label793;
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label2911;
          }
          paramBoolean = true;
          break label927;
          j = i;
          if (n > 0) {
            j = i + 1;
          }
          i = j;
          if (k > 0) {
            i = j + 1;
          }
          j = i;
          if (i1 <= 0) {
            break label1092;
          }
          j = i + 1;
          break label1092;
          i = 1;
          break label1133;
          j = 1;
          break label1588;
          k = j;
          break label1693;
          label2797:
          j = 0;
          break label1588;
          label2803:
          j = 1;
          break label1909;
          label2809:
          localObject1 = localObject2;
          break label1984;
          j = 0;
          break label1909;
          break label1984;
          k = i;
          break label1752;
          j = 0;
          break label2633;
          break;
          j = 0;
          break label2647;
          j = 0;
          break label2658;
          j = 0;
          break label316;
          j = i;
          break label2292;
          j = 0;
          break label2674;
          break label417;
          j = 0;
          break label2688;
          i = 0;
          break label720;
          i = 1;
          break label720;
          i = 0;
          break label2705;
          i = 0;
          break label858;
        }
        paramBoolean = false;
        break label927;
        i = 0;
        break label1133;
      }
      label2658:
      label2916:
      label2928:
      i -= 1;
    }
  }
  
  private static final void a(int paramInt, ah.a parama, SpannableStringBuilder paramSpannableStringBuilder, SpannableString paramSpannableString)
  {
    AppMethodBeat.i(370220);
    if (paramInt >= 0)
    {
      if (parama.aiwY) {
        paramSpannableStringBuilder.append((CharSequence)"\n");
      }
      paramSpannableStringBuilder.append((CharSequence)paramSpannableString);
      parama.aiwY = true;
    }
    AppMethodBeat.o(370220);
  }
  
  public static String aBF(String paramString)
  {
    AppMethodBeat.i(333088);
    s.u(paramString, "text");
    if ((paramString.length() >= 2) && (n.U(paramString, "\t", false)) && (!n.e(paramString.subSequence(1, 2), (CharSequence)"\t")))
    {
      paramString = s.X("\t\t\t", paramString);
      AppMethodBeat.o(333088);
      return paramString;
    }
    AppMethodBeat.o(333088);
    return paramString;
  }
  
  public static String ap(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(333080);
    int j = ad.getSessionId();
    Object localObject;
    String str;
    if (paramString != null)
    {
      localObject = (CharSequence)paramString;
      str = WeChatHosts.domainString(e.h.host_mp_weixin_qq_com);
      s.s(str, "domainString(R.string.host_mp_weixin_qq_com)");
      if ((!n.a((CharSequence)localObject, (CharSequence)str, false)) && (paramInt1 < 0)) {}
      str = "";
      int k = n.a((CharSequence)paramString, "#", 0, false, 6);
      if (k <= 0) {
        break label381;
      }
      localObject = paramString.substring(0, k);
      s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      str = paramString.substring(k);
      s.s(str, "(this as java.lang.String).substring(startIndex)");
      if (n.a((CharSequence)paramString, (CharSequence)"?", false)) {
        break label387;
      }
      paramString = s.X((String)localObject, "?");
      i = 1;
    }
    for (;;)
    {
      paramString = (CharSequence)paramString;
      paramString = new k("(scene=[\\d]*)").e(paramString, "");
      localObject = paramString + "&scene=156";
      paramString = (String)localObject;
      if (paramInt1 >= 0)
      {
        paramString = (CharSequence)localObject;
        paramString = new k("(subscene=[\\d]*)").e(paramString, "");
        paramString = paramString + "&subscene=" + paramInt1;
      }
      localObject = paramString;
      if (j > 0) {
        localObject = paramString + "&sessionid=" + j;
      }
      paramString = (String)localObject;
      if (paramInt2 > 0)
      {
        paramString = (String)localObject + "&clicktime=" + paramInt2;
        paramString = paramString + "&enterid=" + paramInt2;
      }
      localObject = paramString;
      if (i != 0) {
        localObject = n.bV(paramString, "?&", "?");
      }
      paramString = s.X((String)localObject, str);
      AppMethodBeat.o(333080);
      return paramString;
      AppMethodBeat.o(333080);
      return paramString;
      label381:
      localObject = paramString;
      break;
      label387:
      paramString = (String)localObject;
    }
  }
  
  private static String b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(333102);
    if ((paramInt1 == 1) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      paramContext = paramContext.getResources().getString(e.h.finder_message_single_friend_recommend_tip);
      s.s(paramContext, "{\n            context.re…_recommend_tip)\n        }");
      AppMethodBeat.o(333102);
      return paramContext;
    }
    if ((paramInt1 > 1) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      paramContext = paramContext.getResources().getString(e.h.finder_message_multi_friend_recommend_tip, new Object[] { TY(paramInt1) });
      s.s(paramContext, "{\n            context.re…ecommendCount))\n        }");
      AppMethodBeat.o(333102);
      return paramContext;
    }
    if ((paramInt1 > 0) && (paramInt2 == 0) && (paramInt3 > 0))
    {
      paramContext = paramContext.getResources().getString(e.h.finder_message_comment_tip, new Object[] { TY(paramInt4) });
      s.s(paramContext, "{\n            context.re…)\n            )\n        }");
      AppMethodBeat.o(333102);
      return paramContext;
    }
    if (((paramInt1 > 0) || (paramInt3 > 0)) && (paramInt2 > 0))
    {
      paramContext = paramContext.getResources().getString(e.h.finder_new_message_tip, new Object[] { TY(paramInt4) });
      s.s(paramContext, "{\n            context.re…)\n            )\n        }");
      AppMethodBeat.o(333102);
      return paramContext;
    }
    AppMethodBeat.o(333102);
    return "";
  }
  
  private static final void b(int paramInt, ah.a parama, SpannableStringBuilder paramSpannableStringBuilder, SpannableString paramSpannableString)
  {
    AppMethodBeat.i(370221);
    if (paramInt >= 0)
    {
      if (parama.aiwY) {
        paramSpannableStringBuilder.append((CharSequence)"\n");
      }
      paramSpannableStringBuilder.append((CharSequence)paramSpannableString);
      parama.aiwY = true;
    }
    AppMethodBeat.o(370221);
  }
  
  public static int ffK()
  {
    return Edge_2_5_A;
  }
  
  public final int ffL()
  {
    AppMethodBeat.i(333161);
    int i = h.baE().ban().getInt(at.a.adcq, 0);
    int j = h.baE().ban().getInt(at.a.adcs, 0);
    int k = h.baE().ban().getInt(at.a.adct, 0);
    int m = h.baE().ban().getInt(at.a.adcu, 0);
    int n = h.baE().ban().getInt(at.a.adcw, 0);
    int i1 = j + i + k + m + n;
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 14) * com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext()));
    com.tencent.mm.ui.aw.a((Paint)localTextPaint, 0.8F);
    if (i1 > 0)
    {
      Object localObject = MMApplicationContext.getContext();
      s.s(localObject, "getContext()");
      i = (int)localTextPaint.measureText(a((Context)localObject, n, j + k + m, i, i1));
      localObject = l.ARA;
      localObject = (l.a)l.dZP().getValue();
      if ((localObject == null) || (((l.a)localObject).hBY != true)) {
        break label340;
      }
      j = 1;
      label205:
      if (j == 0) {
        break label345;
      }
      localObject = MMApplicationContext.getContext().getResources().getString(e.h.finder_private_msg_bubble_text);
      s.s(localObject, "getContext().resources.g…_private_msg_bubble_text)");
      j = (int)localTextPaint.measureText((String)localObject);
      label240:
      if (i <= j) {
        break label350;
      }
    }
    label340:
    label345:
    label350:
    for (k = i;; k = j)
    {
      Log.i("Finder.TextUtils", "bubbleWidth :" + i + " privateMsgWidth:" + j + " width:" + k);
      i = (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_10_5_A);
      j = (int)MMApplicationContext.getContext().getResources().getDimension(e.c.finder_18_25_A);
      if (k <= i) {
        break label355;
      }
      AppMethodBeat.o(333161);
      return k + j - i;
      i = 0;
      break;
      j = 0;
      break label205;
      j = 0;
      break label240;
    }
    label355:
    AppMethodBeat.o(333161);
    return j;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderTextUtils$AsyncGetDescText;", "", "onGetDescText", "", "isNeedRefresh", "", "desc", "Landroid/text/SpannableStringBuilder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, SpannableStringBuilder paramSpannableStringBuilder);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "txt", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    b(BaseFinderFeed paramBaseFinderFeed, Context paramContext, brg parambrg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "txt", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    c(Context paramContext, BaseFinderFeed paramBaseFinderFeed, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "txt", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    d(BaseFinderFeed paramBaseFinderFeed, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ar
 * JD-Core Version:    0.7.0.1
 */