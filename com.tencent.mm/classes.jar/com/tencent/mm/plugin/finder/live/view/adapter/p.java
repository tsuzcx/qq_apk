package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentInputAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentInputAdapter$FastCommentInputViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "canShowPoiIcon", "", "getCanShowPoiIcon", "()Z", "setCanShowPoiIcon", "(Z)V", "getContext", "()Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentInputAdapter$FinderFastCommentInfo;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "extraFastCommentContent", "", "getExtraFastCommentContent", "()Ljava/lang/String;", "setExtraFastCommentContent", "(Ljava/lang/String;)V", "itemClickListener", "Lkotlin/Function1;", "", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "localCity", "getLocalCity", "setLocalCity", "poiClickListener", "Lkotlin/Function0;", "getPoiClickListener", "()Lkotlin/jvm/functions/Function0;", "setPoiClickListener", "(Lkotlin/jvm/functions/Function0;)V", "bindInputFastComment", "holder", "position", "getExtraContent", "getItemCount", "initPoiInfo", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "setExtraContent", "setFastCommentItemClickListener", "setPoiInfo", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setPoiItemClickListener", "updateFastCommentDataList", "commentList", "Companion", "FastCommentInputViewHolder", "FinderFastCommentInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends RecyclerView.a<b>
{
  public static final p.a DRb;
  public kotlin.g.a.a<ah> DRc;
  public String DRd;
  private boolean DRe;
  public String DRf;
  public final Context context;
  public kotlin.g.a.b<? super Integer, ah> nod;
  public ArrayList<p.c> pUj;
  
  static
  {
    AppMethodBeat.i(358712);
    DRb = new p.a((byte)0);
    AppMethodBeat.o(358712);
  }
  
  public p(Context paramContext)
  {
    AppMethodBeat.i(358677);
    this.context = paramContext;
    this.pUj = new ArrayList();
    this.DRe = true;
    AppMethodBeat.o(358677);
  }
  
  private static final void a(int paramInt, p paramp, View paramView)
  {
    AppMethodBeat.i(358694);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.sc(paramInt);
    localb.cH(paramp);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentInputAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramp, "this$0");
    j.Dob.a(q.s.DuH, ak.f(new r[] { new r("button_type", "0"), new r("quick_reply_index", String.valueOf(paramInt)), new r("quick_reply_content", ((p.c)paramp.pUj.get(paramInt)).comment) }));
    paramp = paramp.DRc;
    if (paramp != null) {
      paramp.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentInputAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358694);
  }
  
  private static final void b(int paramInt, p paramp, View paramView)
  {
    AppMethodBeat.i(358704);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.sc(paramInt);
    localb.cH(paramp);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentInputAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramp, "this$0");
    j.Dob.a(q.s.DuH, ak.f(new r[] { new r("button_type", "1"), new r("quick_reply_index", String.valueOf(paramInt)), new r("quick_reply_content", ((p.c)paramp.pUj.get(paramInt)).comment) }));
    paramp = paramp.nod;
    if (paramp != null) {
      paramp.invoke(Integer.valueOf(paramInt));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentInputAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358704);
  }
  
  public final void a(boi paramboi)
  {
    AppMethodBeat.i(358759);
    int j = this.pUj.size() - 1;
    String str1;
    Object localObject;
    int i;
    if (paramboi != null)
    {
      str1 = paramboi.city;
      this.DRf = str1;
      if (str1 != null)
      {
        paramboi = this.DRd;
        localObject = (CharSequence)paramboi;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label227;
        }
        i = 1;
        if (i != 0) {
          break label232;
        }
        i = 1;
        label71:
        if (i == 0) {
          break label237;
        }
        label75:
        if (paramboi != null) {
          break label242;
        }
      }
    }
    for (paramboi = null;; paramboi = ah.aiuX)
    {
      if (paramboi == null)
      {
        paramboi = (p)this;
        paramboi.DRe = true;
        localObject = ((p.c)paramboi.pUj.get(j)).comment;
        String str2 = MMApplicationContext.getContext().getString(p.h.finder_live_comment_i_am_in_the_specified_city, new Object[] { str1 });
        s.s(str2, "getContext().getString(R…the_specified_city, city)");
        if (!s.p(localObject, n.bq((CharSequence)str2).toString()))
        {
          localObject = (p.c)paramboi.pUj.get(j);
          str1 = MMApplicationContext.getContext().getString(p.h.finder_live_comment_i_am_in_the_specified_city, new Object[] { str1 });
          s.s(str1, "getContext().getString(R…the_specified_city, city)");
          ((p.c)localObject).axZ(n.bq((CharSequence)str1).toString());
          paramboi.fV(j);
        }
      }
      AppMethodBeat.o(358759);
      return;
      label227:
      i = 0;
      break;
      label232:
      i = 0;
      break label71;
      label237:
      paramboi = null;
      break label75;
      label242:
      this.DRe = false;
      paramboi = n.m(paramboi, "<%@>", str1, false);
      if (!s.p(((p.c)this.pUj.get(j)).comment, paramboi))
      {
        ((p.c)this.pUj.get(j)).axZ(paramboi);
        fV(j);
      }
    }
  }
  
  public final void al(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(358739);
    s.u(paramArrayList, "commentList");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)this.pUj);
    kotlin.a.p.e((List)this.pUj, (kotlin.g.a.b)p.d.DRj);
    Iterator localIterator1 = ((Iterable)paramArrayList).iterator();
    if (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Iterator localIterator2 = ((Iterable)localArrayList).iterator();
      while (localIterator2.hasNext())
      {
        paramArrayList = localIterator2.next();
        if (s.p(((p.c)paramArrayList).comment, str))
        {
          label130:
          paramArrayList = (p.c)paramArrayList;
          if (paramArrayList != null) {
            break label176;
          }
        }
      }
      label176:
      for (long l = 0L;; l = paramArrayList.pdr)
      {
        this.pUj.add(this.pUj.size() - 1, new p.c(str, 1, l));
        break;
        paramArrayList = null;
        break label130;
      }
    }
    this.bZE.notifyChanged();
    AppMethodBeat.o(358739);
  }
  
  public final void axY(String paramString)
  {
    AppMethodBeat.i(358770);
    int j = this.pUj.size() - 1;
    this.DRd = paramString;
    Object localObject1 = this.DRf;
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label139;
      }
      i = 1;
      label57:
      if (i == 0) {
        break label144;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label150;
      }
      paramString = null;
      if (paramString == null)
      {
        localObject1 = (p)this;
        ((p)localObject1).DRe = true;
        paramString = (p.c)((p)localObject1).pUj.get(j);
        localObject1 = ((p)localObject1).context.getResources().getString(p.h.finder_live_fast_comment_location_tip);
        s.s(localObject1, "context.resources.getStr…ast_comment_location_tip)");
        paramString.axZ((String)localObject1);
      }
      AppMethodBeat.o(358770);
      return;
      i = 0;
      break;
      label139:
      i = 0;
      break label57;
      label144:
      localObject1 = null;
    }
    label150:
    if (paramString == null)
    {
      this.DRe = true;
      paramString = ((p.c)this.pUj.get(j)).comment;
      localObject2 = MMApplicationContext.getContext().getString(p.h.finder_live_comment_i_am_in_the_specified_city, new Object[] { localObject1 });
      s.s(localObject2, "getContext().getString(R…pecified_city, localCity)");
      if (!s.p(paramString, n.bq((CharSequence)localObject2).toString()))
      {
        paramString = (p.c)this.pUj.get(j);
        localObject1 = MMApplicationContext.getContext().getString(p.h.finder_live_comment_i_am_in_the_specified_city, new Object[] { localObject1 });
        s.s(localObject1, "getContext().getString(R…pecified_city, localCity)");
        paramString.axZ(n.bq((CharSequence)localObject1).toString());
        fV(j);
      }
    }
    for (;;)
    {
      paramString = ah.aiuX;
      break;
      this.DRe = false;
      paramString = n.m(paramString, "<%@>", (String)localObject1, false);
      if (!s.p(((p.c)this.pUj.get(j)).comment, paramString))
      {
        ((p.c)this.pUj.get(j)).axZ(paramString);
        fV(j);
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358744);
    int i = this.pUj.size();
    AppMethodBeat.o(358744);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentInputAdapter$FastCommentInputViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "fastCommentInfo", "Landroid/widget/TextView;", "getFastCommentInfo", "()Landroid/widget/TextView;", "setFastCommentInfo", "(Landroid/widget/TextView;)V", "fastCommentItemLayout", "Landroid/widget/FrameLayout;", "getFastCommentItemLayout", "()Landroid/widget/FrameLayout;", "setFastCommentItemLayout", "(Landroid/widget/FrameLayout;)V", "fastCommentPoiIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getFastCommentPoiIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setFastCommentPoiIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.v
  {
    WeImageView DRg;
    TextView DRh;
    FrameLayout DRi;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(358769);
      View localView = paramView.findViewById(p.e.BWI);
      s.s(localView, "itemView.findViewById(R.…st_comment_poi_info_icon)");
      this.DRg = ((WeImageView)localView);
      localView = paramView.findViewById(p.e.BWG);
      s.s(localView, "itemView.findViewById(R.…e_fast_comment_info_text)");
      this.DRh = ((TextView)localView);
      paramView = paramView.findViewById(p.e.BWH);
      s.s(paramView, "itemView.findViewById(R.…fast_comment_item_layout)");
      this.DRi = ((FrameLayout)paramView);
      AppMethodBeat.o(358769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.p
 * JD-Core Version:    0.7.0.1
 */