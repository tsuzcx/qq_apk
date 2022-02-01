package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.c;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.by;
import com.tencent.mm.plugin.finder.live.report.q.bz;
import com.tencent.mm.plugin.finder.live.view.FinderLiveFoldTextView;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.view.span.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;
import kotlin.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemAnnoucement;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "mLiveCtx", "dealWithListener", "", "contentTv", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFoldTextView;", "content", "", "msgPosition", "", "dealWithReport", "fillItem", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "msgType", "onBindWelcomeMsg", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.b
{
  public static final a CKV;
  private static final j<String> CKX;
  private static final j<f> CKY;
  private static final m<CharSequence, Integer, q> CKZ;
  private static final kotlin.g.a.s<FinderLiveFoldTextView, CharSequence, Integer, Integer, Boolean, ah> CLa;
  private static final kotlin.g.a.s<FinderLiveFoldTextView, CharSequence, Integer, Integer, Boolean, ah> CLb;
  private final com.tencent.mm.plugin.finder.live.model.context.a CKW;
  
  static
  {
    AppMethodBeat.i(360008);
    CKV = new a((byte)0);
    CKX = kotlin.k.cm((kotlin.g.a.a)f.CLh);
    CKY = kotlin.k.cm((kotlin.g.a.a)e.CLg);
    CKZ = (m)c.CLe;
    CLa = (kotlin.g.a.s)b.CLc;
    CLb = (kotlin.g.a.s)d.CLf;
    AppMethodBeat.o(360008);
  }
  
  public b(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359962);
    this.CKW = parama;
    AppMethodBeat.o(359962);
  }
  
  public final aq a(bke parambke)
  {
    AppMethodBeat.i(360019);
    kotlin.g.b.s.u(parambke, "msg");
    parambke = (aq)new am(parambke);
    AppMethodBeat.o(360019);
    return parambke;
  }
  
  public final void a(Context paramContext, k.a parama, final aq paramaq, final int paramInt)
  {
    AppMethodBeat.i(360039);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "holder");
    kotlin.g.b.s.u(paramaq, "msg");
    parama.caK.setAlpha(1.0F);
    FinderLiveFoldTextView localFinderLiveFoldTextView = (FinderLiveFoldTextView)parama.DQt;
    paramaq = paramContext.getString(p.h.Cia) + ' ' + paramaq.getContent();
    CharSequence localCharSequence = (CharSequence)paramaq;
    int i = ((c)this.CKW.business(c.class)).CBG;
    int j = ejf();
    Boolean localBoolean = (Boolean)((l)this.CKW.business(l.class)).EgO.get(Integer.valueOf(paramInt));
    if (localBoolean == null) {}
    for (boolean bool = true;; bool = localBoolean.booleanValue())
    {
      a.a(localCharSequence, localFinderLiveFoldTextView, i, j, bool);
      parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
      parama.DQt.setTag(p.e.BEo, a.emO());
      localFinderLiveFoldTextView.setUnFoldListener((kotlin.g.a.a)new g(this, paramInt, paramaq));
      localFinderLiveFoldTextView.setFoldListener((kotlin.g.a.a)new h(this, paramInt));
      if ((localFinderLiveFoldTextView.DNc) && (!((l)this.CKW.business(l.class)).EgN.contains(Integer.valueOf(paramInt))))
      {
        paramContext = com.tencent.mm.plugin.finder.live.report.k.Doi;
        parama = new JSONObject();
        parama.put(q.by.DDR.key, q.bz.DDV.Dsd);
        parama.put(q.by.DDS.key, r.as(Util.nullAsNil(paramaq), "utf-8"));
        paramaq = ah.aiuX;
        parama = parama.toString();
        kotlin.g.b.s.s(parama, "JSONObject().apply {\n   …\n            }.toString()");
        paramContext.axx(parama);
        ((l)this.CKW.business(l.class)).EgN.add(Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(360039);
      return;
    }
  }
  
  public int eiV()
  {
    return 100000;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemAnnoucement$Companion;", "", "()V", "MaxLines", "", "foldAbleSetText", "Lkotlin/Function5;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFoldTextView;", "", "", "", "makeSpanDelegate", "Lkotlin/Function2;", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "normalSetText", "welcomeImageSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "getWelcomeImageSpan", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "welcomeImageSpan$delegate", "Lkotlin/Lazy;", "welcomeTag", "", "getWelcomeTag", "()Ljava/lang/String;", "welcomeTag$delegate", "fillContent", "content", "contentTv", "contentMaxWidth", "contentFontSize", "initIsFolding", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final void a(FinderLiveFoldTextView paramFinderLiveFoldTextView, ah.f paramf, kotlin.g.a.s params, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(359995);
      kotlin.g.b.s.u(paramFinderLiveFoldTextView, "$contentTv");
      kotlin.g.b.s.u(paramf, "$parent");
      kotlin.g.b.s.u(params, "$setTextMethod");
      kotlin.g.b.s.u(paramCharSequence, "$content");
      if (paramFinderLiveFoldTextView.getLineCount() > 1)
      {
        ((ViewGroup)paramf.aqH).setPadding(0, ((ViewGroup)paramf.aqH).getPaddingTop(), 0, ((ViewGroup)paramf.aqH).getPaddingBottom());
        paramFinderLiveFoldTextView.setSpacingAdd(5);
        params.a(paramFinderLiveFoldTextView, paramCharSequence, Integer.valueOf(paramFinderLiveFoldTextView.getLineCount()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(359995);
        return;
      }
      ((ViewGroup)paramf.aqH).setPadding(0, ((ViewGroup)paramf.aqH).getPaddingTop(), ((ViewGroup)paramf.aqH).getPaddingRight(), ((ViewGroup)paramf.aqH).getPaddingBottom());
      AppMethodBeat.o(359995);
    }
    
    public static void a(CharSequence paramCharSequence, FinderLiveFoldTextView paramFinderLiveFoldTextView, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(359981);
      kotlin.g.b.s.u(paramCharSequence, "content");
      kotlin.g.b.s.u(paramFinderLiveFoldTextView, "contentTv");
      if (paramInt1 > 0) {}
      ah.f localf;
      ViewParent localViewParent;
      for (kotlin.g.a.s locals = b.emJ();; locals = b.emK())
      {
        localf = new ah.f();
        localViewParent = paramFinderLiveFoldTextView.getParent();
        if (localViewParent != null) {
          break;
        }
        paramCharSequence = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(359981);
        throw paramCharSequence;
      }
      localf.aqH = ((ViewGroup)localViewParent);
      paramFinderLiveFoldTextView.setTextSize(paramInt2);
      paramFinderLiveFoldTextView.setVisibility(0);
      locals.a(paramFinderLiveFoldTextView, paramCharSequence, Integer.valueOf(1), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean));
      paramFinderLiveFoldTextView.post(new b.a..ExternalSyntheticLambda0(paramFinderLiveFoldTextView, localf, locals, paramCharSequence, paramInt1, paramBoolean));
      AppMethodBeat.o(359981);
    }
    
    static String emO()
    {
      AppMethodBeat.i(359988);
      String str = (String)b.emL().getValue();
      AppMethodBeat.o(359988);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "tv", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFoldTextView;", "content", "", "lineCount", "", "maxWidth", "initIsFolding", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.s<FinderLiveFoldTextView, CharSequence, Integer, Integer, Boolean, ah>
  {
    public static final b CLc;
    
    static
    {
      AppMethodBeat.i(359974);
      CLc = new b();
      AppMethodBeat.o(359974);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "content", "", "lineCount", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<CharSequence, Integer, q>
  {
    public static final c CLe;
    
    static
    {
      AppMethodBeat.i(359963);
      CLe = new c();
      AppMethodBeat.o(359963);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "tv", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFoldTextView;", "content", "", "lineCount", "", "<anonymous parameter 3>", "<anonymous parameter 4>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.s<FinderLiveFoldTextView, CharSequence, Integer, Integer, Boolean, ah>
  {
    public static final d CLf;
    
    static
    {
      AppMethodBeat.i(359964);
      CLf = new d();
      AppMethodBeat.o(359964);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<f>
  {
    public static final e CLg;
    
    static
    {
      AppMethodBeat.i(359969);
      CLg = new e();
      AppMethodBeat.o(359969);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final f CLh;
    
    static
    {
      AppMethodBeat.i(359985);
      CLh = new f();
      AppMethodBeat.o(359985);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(b paramb, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(b paramb, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.b
 * JD-Core Version:    0.7.0.1
 */