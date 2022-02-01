package com.tencent.mm.plugin.finder.live.b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.style.ForegroundColorSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.cy;
import com.tencent.mm.plugin.finder.live.util.ai;
import com.tencent.mm.plugin.finder.live.view.LiveNeat7extView;
import com.tencent.mm.plugin.finder.live.view.span.i;
import com.tencent.mm.plugin.finder.live.view.span.m;
import com.tencent.mm.plugin.finder.live.view.span.m.a;
import com.tencent.mm.plugin.finder.live.view.span.m.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentHelper;", "", "()V", "AVATAR_END", "", "AVATAR_START", "LAND_WIDTH", "getLAND_WIDTH", "()I", "LAND_WIDTH$delegate", "Lkotlin/Lazy;", "POI_ICON_HEIGHT_SIZE", "getPOI_ICON_HEIGHT_SIZE", "POI_ICON_WIDTH_SIZE", "getPOI_ICON_WIDTH_SIZE", "POI_ICON_WIDTH_SIZE$delegate", "PORT_WIDTH", "getPORT_WIDTH", "PORT_WIDTH$delegate", "TAG", "", "annoucement", "getAnnoucement", "()Ljava/lang/String;", "annoucement$delegate", "avatarSize", "getAvatarSize", "avatarSize$delegate", "systemAnnoucementSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan;", "getSystemAnnoucementSpan", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan;", "systemAnnoucementSpan$delegate", "value", "textHeight", "getTextHeight", "setTextHeight", "(I)V", "userNameSpan", "Landroid/text/style/ForegroundColorSpan;", "getUserNameSpan", "()Landroid/text/style/ForegroundColorSpan;", "userNameSpan$delegate", "adjustTextSpace", "", "contentTv", "Landroid/widget/TextView;", "mmSpannableString", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "space", "calTextHeight", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "createAvatarTextMsg", "usernameTag", "content", "getFromUsername", "context", "Landroid/content/Context;", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "feed", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "getFromUsernameTag", "getToUsername", "loadWxAvatar", "Lcom/tencent/mm/plugin/finder/live/view/LiveNeat7extView;", "username", "avatarStart", "avatarEnd", "userMessage", "processPayload", "", "item", "position", "type", "isHotPatch", "payloads", "", "setBoxCommentActionListener", "isAnchor", "msg", "view", "Landroid/view/View;", "setBoxCommentLikeListener", "likeView", "setBoxContentMaxWidth", "setLike", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final kotlin.j CBu;
  private static final kotlin.j CLS;
  private static final kotlin.j ZuA;
  private static final kotlin.j ZuB;
  private static final int ZuC;
  private static final kotlin.j ZuD;
  private static final kotlin.j ZuE;
  private static int ZuF;
  public static final c Zuy;
  private static final kotlin.j Zuz;
  
  static
  {
    AppMethodBeat.i(371038);
    Zuy = new c();
    Zuz = kotlin.k.cm((kotlin.g.a.a)c.e.ZuQ);
    ZuA = kotlin.k.cm((kotlin.g.a.a)c.i.Zvk);
    CBu = kotlin.k.cm((kotlin.g.a.a)c.d.ZuJ);
    ZuB = kotlin.k.cm((kotlin.g.a.a)c.h.Zvj);
    CLS = kotlin.k.cm((kotlin.g.a.a)c.b.ZuH);
    ZuC = flV();
    ZuD = kotlin.k.cm((kotlin.g.a.a)c.a.ZuG);
    ZuE = kotlin.k.cm((kotlin.g.a.a)c.c.ZuI);
    AppMethodBeat.o(371038);
  }
  
  public static String a(Context paramContext, MMNeat7extView paramMMNeat7extView, com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb)
  {
    AppMethodBeat.i(370980);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramMMNeat7extView, "contentTv");
    kotlin.g.b.s.u(paramb, "feed");
    Object localObject1 = ai.akfD;
    paramb = ai.n(paramb.kKZ(), paramb.aJO(), paramb.jKB(), BuildInfo.DEBUG);
    localObject1 = paramContext.getResources();
    int i = p.h.live_comment_row_content_tmpl;
    Object localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    kotlin.g.b.s.s(localObject2, "service(IFinderCommonService::class.java)");
    localObject2 = (com.tencent.mm.plugin.h)localObject2;
    paramMMNeat7extView = paramMMNeat7extView.getPaint();
    kotlin.g.b.s.s(paramMMNeat7extView, "contentTv.paint");
    paramContext = ((Resources)localObject1).getString(i, new Object[] { h.a.a((com.tencent.mm.plugin.h)localObject2, paramContext, paramMMNeat7extView, (CharSequence)paramb) });
    kotlin.g.b.s.s(paramContext, "context.resources.getStr…   displayName)\n        )");
    AppMethodBeat.o(370980);
    return paramContext;
  }
  
  public static void a(LiveNeat7extView paramLiveNeat7extView, String paramString, int paramInt, q paramq)
  {
    AppMethodBeat.i(370998);
    kotlin.g.b.s.u(paramLiveNeat7extView, "contentTv");
    kotlin.g.b.s.u(paramString, "username");
    kotlin.g.b.s.u(paramq, "userMessage");
    Object localObject1 = new d(paramString);
    ((d)localObject1).setCallback((Drawable.Callback)paramLiveNeat7extView);
    ((d)localObject1).setBounds(0, 0, paramInt, paramInt);
    Object localObject2 = m.akfI;
    localObject2 = new m.a();
    localObject1 = (BitmapDrawable)localObject1;
    kotlin.g.b.s.u(localObject1, "drawable");
    ((m.a)localObject2).akfJ.akfK = ((BitmapDrawable)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
    paramInt = com.tencent.mm.plugin.finder.live.view.span.h.ewy();
    ((m.a)localObject2).akfJ.bmu = paramInt;
    localObject1 = ((m.a)localObject2).akfJ.akfK;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = ((m.a)localObject2).akfJ;
        kotlin.g.b.s.u(localObject2, "<set-?>");
        ((m)localObject1).akfJ = ((m.c)localObject2);
      }
      if (localObject1 != null) {
        break label200;
      }
    }
    for (paramLiveNeat7extView = null;; paramLiveNeat7extView = ah.aiuX)
    {
      if (paramLiveNeat7extView == null) {
        Log.e("FinderLiveGroupCommentHelper", "loadWxAvatar err create drawable fail!");
      }
      AppMethodBeat.o(370998);
      return;
      localObject1 = new m((Drawable)localObject1);
      break;
      label200:
      paramq.setSpan(localObject1, 0, 1, 33);
      paramLiveNeat7extView.setInvalidateVerifyPassTag(paramString);
      paramLiveNeat7extView.aZ((CharSequence)paramq);
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(371037);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$msg");
    kotlin.g.b.s.u(paramj, "$holder");
    paramView = aw.Gjk;
    if (aw.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(371037);
      return;
    }
    if (paramb.akga)
    {
      paramj = paramj.getRecyclerView().getTag();
      if (paramj == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.plugin.FinderLiveBoxCommentPlugin");
        AppMethodBeat.o(371037);
        throw paramb;
      }
      if (((cy)paramj).jdv().b(paramb)) {
        com.tencent.mm.plugin.finder.live.report.k.Doi.aa(18, paramb.kKZ(), paramb.getContent());
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(371037);
      return;
      paramj = paramj.getRecyclerView().getTag();
      if (paramj == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.plugin.FinderLiveBoxCommentPlugin");
        AppMethodBeat.o(371037);
        throw paramb;
      }
      if (((cy)paramj).jdv().a(paramb)) {
        com.tencent.mm.plugin.finder.live.report.k.Doi.aa(15, paramb.kKZ(), paramb.getContent());
      }
    }
  }
  
  public static void a(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb)
  {
    int m = 0;
    AppMethodBeat.i(371007);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramb, "item");
    int i;
    if (ZuF > 0)
    {
      i = ZuF;
      boolean bool = paramb.akga;
      j = paramb.likeCount;
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveGroupCommentHelper", "boxCommentLikeTrack content:" + paramb.getContent() + " seq:" + paramb.akfZ.seq + " setLike isLike:" + bool + ",likeCnt:" + j + ",textHeight:" + i);
      paramb = paramj.UH(p.e.KQQ);
      localObject = com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.akgP;
      if (j <= com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.kLn()) {
        break label460;
      }
      if (j <= 0) {
        break label454;
      }
      localObject = (TextView)paramj.UH(p.e.KQP);
      if (!bool) {
        break label407;
      }
      ((TextView)localObject).setTextColor(paramj.context.getResources().getColor(p.b.finder_live_logo_color));
      ((WeImageView)paramj.UH(p.e.KQO)).setIconColor(paramj.context.getResources().getColor(p.b.finder_live_logo_color));
      label207:
      ((TextView)localObject).setText((CharSequence)String.valueOf(j));
      j = m;
      if (i > 0)
      {
        paramj = paramb.getLayoutParams();
        j = m;
        if (paramj != null) {
          paramj.height = i;
        }
      }
    }
    label274:
    label294:
    label454:
    for (int j = m;; j = 8)
    {
      paramb.setVisibility(j);
      AppMethodBeat.o(371007);
      return;
      localObject = paramj.UH(p.e.KQK);
      if (localObject == null)
      {
        i = 0;
        if (i <= 0) {
          break label391;
        }
        localObject = paramj.UH(p.e.Kyl);
        if (localObject != null) {
          break label372;
        }
        j = 0;
        if (localObject != null) {
          break label381;
        }
      }
      label372:
      label381:
      for (int k = 0;; k = ((View)localObject).getPaddingBottom())
      {
        i = k + (i + j);
        if (i != ZuF) {
          Log.i("FinderLiveGroupCommentHelper", "textHeight from " + ZuF + " to " + i + '!');
        }
        ZuF = i;
        break;
        i = ((View)localObject).getMeasuredHeight();
        break label274;
        j = ((View)localObject).getPaddingTop();
        break label294;
      }
      i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(p.c.Edge_3_5_A);
      break;
      ((TextView)localObject).setTextColor(paramj.context.getResources().getColor(p.b.BW_100_Alpha_0_3));
      ((WeImageView)paramj.UH(p.e.KQO)).setIconColor(paramj.context.getResources().getColor(p.b.GGW));
      break label207;
    }
    label391:
    label407:
    label460:
    Object localObject = com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.akgP;
    if (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.kLn() > 1)
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      localObject = new StringBuilder("(DEBUG)赞数达到");
      s.a locala = com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.akgP;
      com.tencent.mm.plugin.finder.live.utils.a.aD(paramj, com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.kLn() + "个才展示");
    }
    paramb.setVisibility(8);
    AppMethodBeat.o(371007);
  }
  
  public static void a(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb, View paramView)
  {
    AppMethodBeat.i(371019);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramb, "msg");
    kotlin.g.b.s.u(paramView, "view");
    if ((paramj.getRecyclerView().getTag() instanceof cy))
    {
      GestureDetector localGestureDetector = new GestureDetector(paramj.context, (GestureDetector.OnGestureListener)new c.f());
      localGestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)new c.g(paramb, paramj, paramView));
      paramView.setOnTouchListener(new c..ExternalSyntheticLambda1(localGestureDetector));
    }
    AppMethodBeat.o(371019);
  }
  
  public static boolean a(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb, List<Object> paramList)
  {
    AppMethodBeat.i(371029);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramb, "item");
    Object localObject = (Collection)paramList;
    int i;
    boolean bool1;
    if ((localObject == null) || (((Collection)localObject).isEmpty()))
    {
      i = 1;
      if (i == 0)
      {
        paramList = ((Iterable)paramList).iterator();
        bool1 = false;
      }
    }
    else
    {
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break label140;
        }
        localObject = paramList.next();
        if ((localObject instanceof Integer))
        {
          if (kotlin.g.b.s.p(localObject, Integer.valueOf(101)))
          {
            a(paramj, paramb);
            bool1 = true;
            continue;
            i = 0;
            break;
          }
          if (kotlin.g.b.s.p(localObject, Integer.valueOf(102))) {
            bool1 = true;
          }
        }
      }
    }
    boolean bool2 = false;
    label140:
    AppMethodBeat.o(371029);
    return bool2;
  }
  
  public static String b(Context paramContext, MMNeat7extView paramMMNeat7extView, com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb)
  {
    AppMethodBeat.i(370984);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramMMNeat7extView, "contentTv");
    kotlin.g.b.s.u(paramb, "feed");
    Object localObject = ai.akfD;
    paramb = ai.n(paramb.kKZ(), paramb.aJO(), paramb.jKB(), BuildInfo.DEBUG);
    localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    kotlin.g.b.s.s(localObject, "service(IFinderCommonService::class.java)");
    localObject = (com.tencent.mm.plugin.h)localObject;
    paramMMNeat7extView = paramMMNeat7extView.getPaint();
    kotlin.g.b.s.s(paramMMNeat7extView, "contentTv.paint");
    paramContext = h.a.a((com.tencent.mm.plugin.h)localObject, paramContext, paramMMNeat7extView, (CharSequence)paramb).toString();
    AppMethodBeat.o(370984);
    return paramContext;
  }
  
  public static void b(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb, View paramView)
  {
    AppMethodBeat.i(371023);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramb, "msg");
    kotlin.g.b.s.u(paramView, "likeView");
    if ((paramj.getRecyclerView().getTag() instanceof cy)) {
      paramView.setOnClickListener(new c..ExternalSyntheticLambda0(paramb, paramj));
    }
    AppMethodBeat.o(371023);
  }
  
  public static String c(Context paramContext, MMNeat7extView paramMMNeat7extView, com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb)
  {
    AppMethodBeat.i(370987);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramMMNeat7extView, "contentTv");
    kotlin.g.b.s.u(paramb, "feed");
    Object localObject = ai.akfD;
    String str1 = paramb.kKZ();
    String str2 = paramb.aJP();
    paramb = paramb.akfZ.ZNW;
    if (paramb == null) {
      paramb = "";
    }
    for (;;)
    {
      paramb = ai.n(str1, str2, paramb, BuildInfo.DEBUG);
      localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject, "service(IFinderCommonService::class.java)");
      localObject = (com.tencent.mm.plugin.h)localObject;
      paramMMNeat7extView = paramMMNeat7extView.getPaint();
      kotlin.g.b.s.s(paramMMNeat7extView, "contentTv.paint");
      paramContext = h.a.a((com.tencent.mm.plugin.h)localObject, paramContext, paramMMNeat7extView, (CharSequence)paramb).toString();
      AppMethodBeat.o(370987);
      return paramContext;
      paramb = paramb.contact;
      if (paramb == null)
      {
        paramb = "";
      }
      else
      {
        localObject = paramb.username;
        paramb = (com.tencent.mm.plugin.finder.live.viewmodel.data.a.b)localObject;
        if (localObject == null) {
          paramb = "";
        }
      }
    }
  }
  
  private static final boolean c(GestureDetector paramGestureDetector, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(371034);
    kotlin.g.b.s.u(paramGestureDetector, "$this_apply");
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramGestureDetector, paramView.aYi(), "com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper", "setBoxCommentActionListener$lambda-5$lambda-4", "(Landroid/view/GestureDetector;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramGestureDetector, paramGestureDetector.onTouchEvent((MotionEvent)paramView.sb(0)), "com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper", "setBoxCommentActionListener$lambda-5$lambda-4", "(Landroid/view/GestureDetector;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(371034);
    return bool;
  }
  
  public static ForegroundColorSpan ejc()
  {
    AppMethodBeat.i(370955);
    ForegroundColorSpan localForegroundColorSpan = (ForegroundColorSpan)ZuA.getValue();
    AppMethodBeat.o(370955);
    return localForegroundColorSpan;
  }
  
  public static String ejd()
  {
    AppMethodBeat.i(370961);
    String str = (String)CBu.getValue();
    AppMethodBeat.o(370961);
    return str;
  }
  
  public static int fkJ()
  {
    AppMethodBeat.i(370949);
    int i = ((Number)Zuz.getValue()).intValue();
    AppMethodBeat.o(370949);
    return i;
  }
  
  public static i fkL()
  {
    AppMethodBeat.i(370967);
    i locali = (i)ZuB.getValue();
    AppMethodBeat.o(370967);
    return locali;
  }
  
  public static int flV()
  {
    AppMethodBeat.i(370970);
    int i = ((Number)CLS.getValue()).intValue();
    AppMethodBeat.o(370970);
    return i;
  }
  
  public static int fml()
  {
    return ZuC;
  }
  
  public static void h(MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(371012);
    kotlin.g.b.s.u(paramMMNeat7extView, "contentTv");
    if (paramMMNeat7extView.getContext().getResources().getConfiguration().orientation == 2) {}
    for (int i = ((Number)ZuD.getValue()).intValue();; i = ((Number)ZuE.getValue()).intValue())
    {
      paramMMNeat7extView.setMaxWidth(i);
      AppMethodBeat.o(371012);
      return;
    }
  }
  
  public static String oq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(370991);
    kotlin.g.b.s.u(paramString1, "usernameTag");
    kotlin.g.b.s.u(paramString2, "content");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    kotlin.g.b.s.s(paramString1, "result.toString()");
    AppMethodBeat.o(370991);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b.c
 * JD-Core Version:    0.7.0.1
 */