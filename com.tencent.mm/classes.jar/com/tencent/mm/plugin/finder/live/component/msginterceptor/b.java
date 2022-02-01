package com.tencent.mm.plugin.finder.live.component.msginterceptor;

import android.content.Context;
import android.content.res.Resources;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.view.span.i;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "FINDER_LOGO_SPAN_REPLACE", "", "getFINDER_LOGO_SPAN_REPLACE", "()Ljava/lang/String;", "LUCKY_MONEY_HEIGHT_SIZE", "", "getLUCKY_MONEY_HEIGHT_SIZE", "()I", "LUCKY_MONEY_HEIGHT_SIZE$delegate", "Lkotlin/Lazy;", "LUCKY_MONEY_WIDTH_SIZE", "getLUCKY_MONEY_WIDTH_SIZE", "LUCKY_MONEY_WIDTH_SIZE$delegate", "TAG", "TEXT_PADDING_LEFT", "getTEXT_PADDING_LEFT", "TEXT_PADDING_LEFT$delegate", "annoucement", "getAnnoucement", "annoucement$delegate", "cacheAnchorSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan;", "getCacheAnchorSpan", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan;", "cacheAnchorSpan$delegate", "cacheAnchorTag", "getCacheAnchorTag", "cacheAnchorTag$delegate", "contentFontSize", "getContentFontSize", "finderLogoSpan", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "getFinderLogoSpan", "()Lcom/tencent/mm/ui/widget/FixImageSpan;", "finderLogoSpan$delegate", "userNameSpan", "Landroid/text/style/ForegroundColorSpan;", "getUserNameSpan", "()Landroid/text/style/ForegroundColorSpan;", "createTextMsg", "anchorTag", "badgeSpans", "", "Landroid/text/style/ImageSpan;", "userTag", "content", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "msgType", "onCleared", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  private final j CBn = k.cm((kotlin.g.a.a)b.CBy);
  private final j CBo = k.cm((kotlin.g.a.a)a.CBx);
  private final j CBp = k.cm((kotlin.g.a.a)f.CBC);
  private final j CBq = k.cm((kotlin.g.a.a)c.CBz);
  private final String CBr = " ";
  private final j CBs = k.cm((kotlin.g.a.a)new e(this));
  private final ForegroundColorSpan CBt = new ForegroundColorSpan(MMApplicationContext.getContext().getResources().getColor(p.b.half_alpha_white));
  private final j CBu = k.cm((kotlin.g.a.a)d.CBA);
  private final j CBv = k.cm((kotlin.g.a.a)g.CBD);
  private final int CBw;
  private final String TAG = "FinderLiveCommentItem";
  
  public b(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    parama = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {}
    for (int i = 17;; i = 15)
    {
      this.CBw = i;
      return;
    }
  }
  
  public aq a(bdm parambdm)
  {
    s.u(parambdm, "msg");
    return null;
  }
  
  public aq a(bke parambke)
  {
    s.u(parambke, "msg");
    return null;
  }
  
  public void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    paramContext = new StringBuilder();
    paramContext.append("#fillItem");
    paramContext.append(" name=");
    paramContext.append(paramaq.ekt());
    paramContext.append(" content=");
    paramContext.append(paramaq.getContent());
    paramContext.append(" badge=");
    parama = paramaq.eku();
    if (parama != null)
    {
      parama = parama.ZKa;
      if (parama != null)
      {
        parama = ((Iterable)parama).iterator();
        while (parama.hasNext())
        {
          paramContext.append(String.valueOf(((bfl)parama.next()).ZPp));
          paramContext.append("|");
        }
      }
    }
    Log.i(this.TAG, paramContext.toString());
  }
  
  protected final String b(String paramString1, List<? extends ImageSpan> paramList, String paramString2, String paramString3)
  {
    s.u(paramString1, "anchorTag");
    s.u(paramString2, "userTag");
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
      if (paramList != null) {
        break label279;
      }
      i = 0;
      label97:
      if (i > 0)
      {
        int j = 0;
        int k;
        do
        {
          k = j + 1;
          localStringBuilder1.append(" ");
          j = k;
        } while (k < i);
      }
      localStringBuilder2.append("badgeSpanSize:" + i + ',');
      localStringBuilder1.append(paramString2);
      localStringBuilder2.append("userTag:" + paramString2 + ',');
      if (paramString3 != null) {
        break label290;
      }
    }
    label279:
    label290:
    for (paramString1 = "";; paramString1 = paramString3)
    {
      localStringBuilder1.append(paramString1);
      localStringBuilder2.append("content:" + paramString3 + '!');
      paramString1 = localStringBuilder1.toString();
      s.s(paramString1, "result.toString()");
      paramList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ(this.TAG, s.X("#createTextMsg result=", paramString1));
      return paramString1;
      i = 0;
      break;
      i = paramList.size();
      break label97;
    }
  }
  
  public abstract int eiV();
  
  protected final int eiW()
  {
    return ((Number)this.CBn.getValue()).intValue();
  }
  
  protected final int eiX()
  {
    return ((Number)this.CBo.getValue()).intValue();
  }
  
  protected final String eiY()
  {
    return (String)this.CBp.getValue();
  }
  
  protected final int eiZ()
  {
    return ((Number)this.CBq.getValue()).intValue();
  }
  
  protected final String eja()
  {
    return this.CBr;
  }
  
  protected final i ejb()
  {
    return (i)this.CBs.getValue();
  }
  
  protected final ForegroundColorSpan ejc()
  {
    return this.CBt;
  }
  
  public final String ejd()
  {
    return (String)this.CBu.getValue();
  }
  
  protected final com.tencent.mm.ui.widget.a eje()
  {
    return (com.tencent.mm.ui.widget.a)this.CBv.getValue();
  }
  
  protected final int ejf()
  {
    return this.CBw;
  }
  
  public void onCleared() {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final a CBx;
    
    static
    {
      AppMethodBeat.i(353127);
      CBx = new a();
      AppMethodBeat.o(353127);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final b CBy;
    
    static
    {
      AppMethodBeat.i(353138);
      CBy = new b();
      AppMethodBeat.o(353138);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final c CBz;
    
    static
    {
      AppMethodBeat.i(353140);
      CBz = new c();
      AppMethodBeat.o(353140);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final d CBA;
    
    static
    {
      AppMethodBeat.i(353145);
      CBA = new d();
      AppMethodBeat.o(353145);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<i>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final f CBC;
    
    static
    {
      AppMethodBeat.i(353150);
      CBC = new f();
      AppMethodBeat.o(353150);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/FixImageSpan;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<com.tencent.mm.ui.widget.a>
  {
    public static final g CBD;
    
    static
    {
      AppMethodBeat.i(353152);
      CBD = new g();
      AppMethodBeat.o(353152);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.b
 * JD-Core Version:    0.7.0.1
 */