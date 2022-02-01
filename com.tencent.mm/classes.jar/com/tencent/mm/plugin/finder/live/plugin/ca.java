package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.core.core.e.q;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveSubtitlePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "firstLog", "", "lastSubtitle", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveSubtitle;", "maxWidth", "", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "subtitle", "Landroid/widget/TextView;", "getSubtitle", "()Landroid/widget/TextView;", "subtitle$delegate", "Lkotlin/Lazy;", "tmpMsg", "tmpSubtitle", "addSubtitleInfo", "", "index", "duration", "msg", "calMaxWidth", "canClearScreen", "checkVisible", "getOnLineMaxSize", "isOneLineSubtitle", "partitionSubtitle", "printMsg", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "showSubtitleImpl", "showSubtitleInfo", "updateSubtitle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ca
  extends b
{
  private boolean Dkc;
  private com.tencent.mm.plugin.finder.live.viewmodel.data.k Dkd;
  private final j Dke;
  private String Dkf;
  private com.tencent.mm.plugin.finder.live.viewmodel.data.k Dkg;
  private final String TAG;
  private int maxWidth;
  private final com.tencent.mm.live.b.b nfT;
  
  public ca(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, bui parambui)
  {
    super(paramViewGroup, paramb, parambui);
    AppMethodBeat.i(354147);
    this.nfT = paramb;
    this.TAG = "FinderLiveSubtitlePlugin";
    this.Dkc = true;
    this.Dke = kotlin.k.cm((kotlin.g.a.a)new a(paramViewGroup));
    this.Dkf = "";
    AppMethodBeat.o(354147);
  }
  
  private static String a(ConcurrentLinkedDeque<com.tencent.mm.plugin.finder.live.viewmodel.data.k> paramConcurrentLinkedDeque)
  {
    AppMethodBeat.i(354209);
    StringBuilder localStringBuilder = new StringBuilder();
    paramConcurrentLinkedDeque = paramConcurrentLinkedDeque.iterator();
    s.s(paramConcurrentLinkedDeque, "msg.iterator()");
    while (paramConcurrentLinkedDeque.hasNext()) {
      localStringBuilder.append(paramConcurrentLinkedDeque.next());
    }
    paramConcurrentLinkedDeque = localStringBuilder.toString();
    s.s(paramConcurrentLinkedDeque, "sb.toString()");
    AppMethodBeat.o(354209);
    return paramConcurrentLinkedDeque;
  }
  
  private static final void a(ca paramca)
  {
    AppMethodBeat.i(354215);
    s.u(paramca, "this$0");
    paramca.esp();
    AppMethodBeat.o(354215);
  }
  
  private final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.k paramk)
  {
    AppMethodBeat.i(354198);
    if (paramk == null) {}
    for (String str = null; str == null; str = paramk.igN) {
      try
      {
        AppMethodBeat.o(354198);
        return;
      }
      catch (Exception paramk)
      {
        localObject1 = aw.Gjk;
        aw.a(paramk, s.X(this.TAG, ":repairSubtitle"));
      }
    }
    int k = paramk.duration;
    int m = str.length();
    Object localObject1 = (CharSequence)str;
    Object localObject2 = (Iterable)new kotlin.n.k("(?<=\\uff0c)|(?<=\\uff1f)|(?<=\\u3002)|(?<=\\uff1b)|(\n)|(\r)").o((CharSequence)localObject1, 0);
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label175:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((CharSequence)localObject3).length() > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label175;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        AppMethodBeat.o(354198);
        return;
      }
    }
    localObject2 = (List)localObject1;
    int n = ((List)localObject2).size();
    localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.hQ(this.TAG, "partitionSubtitle spitlChineseMsg:" + localObject2 + ",size:" + n);
    int i = n - 1;
    label241:
    int j;
    boolean bool;
    if (i > 0)
    {
      j = i - 1;
      localObject1 = p.a((Iterable)((List)localObject2).subList(0, i), (CharSequence)"", null, null, 0, (CharSequence)"", null, 46);
      if (axn((String)localObject1))
      {
        localObject3 = p.a((Iterable)((List)localObject2).subList(i, n), (CharSequence)"", null, null, 0, (CharSequence)"", null, 46);
        bool = true;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      if (!bool)
      {
        i = new StaticLayout((CharSequence)str, 0, str.length(), eso().getPaint(), this.maxWidth, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineEnd(0);
        j = i - 1;
        if (j > 0)
        {
          i = j;
          label387:
          localObject2 = str.substring(0, i);
          s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localObject1 = str.substring(i, m);
          s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
      else
      {
        if (((CharSequence)localObject1).length() <= 0) {
          break label635;
        }
        i = 1;
        label437:
        if (i != 0)
        {
          localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.data.k((String)localObject1, paramk.index, (int)(k * (((String)localObject1).length() / m)));
          ((e)business(e.class)).EeB.addFirst(localObject1);
          Log.i(this.TAG, s.X("tailSubtitle:", localObject1));
        }
        if (((CharSequence)localObject2).length() <= 0) {
          break label640;
        }
      }
      label640:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label643;
        }
        paramk = new com.tencent.mm.plugin.finder.live.viewmodel.data.k((String)localObject2, paramk.index, (int)(k * (((String)localObject2).length() / m)));
        ((e)business(e.class)).EeB.addFirst(paramk);
        Log.i(this.TAG, "headSubtitle:" + paramk + ",findSingleLineWord:" + bool);
        AppMethodBeat.o(354198);
        return;
        if (j > 0) {
          break label645;
        }
        bool = false;
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        break label387;
        label635:
        i = 0;
        break label437;
      }
      label643:
      break;
      label645:
      i = j;
      break label241;
      bool = false;
      localObject1 = "";
      localObject2 = str;
    }
  }
  
  private final boolean axn(String paramString)
  {
    AppMethodBeat.i(354182);
    if (new StaticLayout((CharSequence)paramString, 0, paramString.length(), eso().getPaint(), this.maxWidth, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
    {
      AppMethodBeat.o(354182);
      return true;
    }
    AppMethodBeat.o(354182);
    return false;
  }
  
  private final TextView eso()
  {
    AppMethodBeat.i(354155);
    Object localObject = this.Dke.getValue();
    s.s(localObject, "<get-subtitle>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(354155);
    return localObject;
  }
  
  private final void esp()
  {
    AppMethodBeat.i(354166);
    if ((((e)business(e.class)).EeB.isEmpty()) || (eoH().isDestroyed()))
    {
      eso().setText((CharSequence)"");
      AppMethodBeat.o(354166);
      return;
    }
    this.Dkg = ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)((e)business(e.class)).EeB.pollFirst());
    Object localObject = this.Dkg;
    if (localObject == null)
    {
      localObject = "";
      this.Dkf = ((String)localObject);
      localObject = (CharSequence)this.Dkf;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label145;
      }
    }
    label145:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label150;
      }
      AppMethodBeat.o(354166);
      return;
      String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)localObject).igN;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
    }
    label150:
    if (axn(this.Dkf)) {}
    for (localObject = this.Dkg;; localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.k)((e)business(e.class)).EeB.pollFirst())
    {
      this.Dkd = ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)localObject);
      esq();
      AppMethodBeat.o(354166);
      return;
      a(this.Dkg);
    }
  }
  
  private final void esq()
  {
    AppMethodBeat.i(354172);
    TextView localTextView = eso();
    Object localObject = this.Dkd;
    if (localObject == null)
    {
      localObject = (CharSequence)"";
      localTextView.setText((CharSequence)localObject);
      localObject = this.Dkd;
      if (localObject != null) {
        break label96;
      }
    }
    label96:
    for (long l = 100L;; l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)localObject).duration)
    {
      eso().postDelayed(new ca..ExternalSyntheticLambda0(this), l);
      AppMethodBeat.o(354172);
      return;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)localObject).igN;
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        break;
      }
      localObject = (CharSequence)localObject;
      break;
    }
  }
  
  public final void axm(String paramString)
  {
    AppMethodBeat.i(354245);
    if ((!((e)business(e.class)).EeA) || (paramString == null))
    {
      if ((this.Dkc) && (paramString != null))
      {
        Log.i(this.TAG, "updateSubtitle msg:" + paramString + ", disable subtitle!");
        this.Dkc = false;
      }
      AppMethodBeat.o(354245);
      return;
    }
    try
    {
      Object localObject1 = new i(paramString);
      if (((i)localObject1).optInt("wxt") == e.q.mLJ.value)
      {
        int j = ((i)localObject1).Ft("subtitle").optInt("index");
        int k = ((i)localObject1).Ft("subtitle").optInt("duration");
        localObject1 = ((i)localObject1).Ft("subtitle").optString("chn");
        Object localObject2 = this.Dkd;
        if ((localObject2 != null) && (j == ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)localObject2).index)) {}
        for (int i = 1; i == 0; i = 0)
        {
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          com.tencent.mm.plugin.finder.live.utils.a.hQ(this.TAG, "msg:" + paramString + ",subtitleInfo:" + a(((e)business(e.class)).EeB));
          s.s(localObject1, "chn");
          eso().getHandler().removeCallbacksAndMessages(null);
          ((e)business(e.class)).EeB.clear();
          ((e)business(e.class)).EeB.add(new com.tencent.mm.plugin.finder.live.viewmodel.data.k((String)localObject1, j, k));
          esp();
          AppMethodBeat.o(354245);
          return;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      localObject1 = aw.Gjk;
      aw.a(paramString, s.X(this.TAG, ",updateSubtitle"));
      AppMethodBeat.o(354245);
    }
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(354234);
    Log.i(this.TAG, s.X("checkVisible enableSubtitle:", Boolean.valueOf(((e)business(e.class)).EeA)));
    if (!((e)business(e.class)).EeA)
    {
      AppMethodBeat.o(354234);
      return;
    }
    Object localObject;
    float f;
    boolean bool;
    if (isLandscape())
    {
      eso().setTextSize(1, 22.0F);
      tO(0);
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.b((b)this);
      if (!isLandscape()) {
        break label233;
      }
      f = bf.bf(this.mJe.getContext()).x;
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject = this.mJe.getContext();
      s.s(localObject, "root.context");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.n(getBuContext()))
      {
        locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.o(getBuContext())) {
          break label228;
        }
      }
      bool = true;
    }
    label169:
    label228:
    label233:
    for (int i = (int)(f - com.tencent.mm.plugin.finder.live.utils.a.I((Context)localObject, bool) * 2);; i = (int)(bf.bf(this.mJe.getContext()).x - this.mJe.getContext().getResources().getDimensionPixelOffset(p.c.Edge_2A) * 2))
    {
      this.maxWidth = i;
      Log.i(this.TAG, s.X("calMaxWidth:", Integer.valueOf(this.maxWidth)));
      AppMethodBeat.o(354234);
      return;
      eso().setTextSize(1, 15.0F);
      break;
      bool = false;
      break label169;
    }
  }
  
  public final boolean eoI()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<TextView>
  {
    a(ViewGroup paramViewGroup)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ca
 * JD-Core Version:    0.7.0.1
 */