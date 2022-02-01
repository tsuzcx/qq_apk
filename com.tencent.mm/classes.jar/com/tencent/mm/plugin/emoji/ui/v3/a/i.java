package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.emoji.model.k.a;
import com.tencent.mm.plugin.emoji.ui.v3.b.c;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "context", "Landroid/content/Context;", "singleProductAlbumItemSizeResolver", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;)V", "TAG", "", "bannerPosSet", "", "", "clickListener", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;", "dataModel", "Lcom/tencent/mm/plugin/emoji/model/IEmojiStoreTypeRecModel;", "emotionListPosRangeRecord", "", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionRecRange;", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "Lkotlin/collections/ArrayList;", "onExpose12875Report", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/emoji/ui/v3/report/SingleProductExpose12875Data;", "Lkotlin/ParameterName;", "name", "data", "", "getOnExpose12875Report", "()Lkotlin/jvm/functions/Function1;", "setOnExpose12875Report", "(Lkotlin/jvm/functions/Function1;)V", "onExpose18662Report", "Lcom/tencent/mm/plugin/emoji/ui/v3/report/EmotionListExpose18662Data;", "getOnExpose18662Report", "setOnExpose18662Report", "productIdPosMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "addData", "items", "", "checkProgress", "findEmotionTypeItemRealIndex", "adapterPos", "getItem", "position", "getItemCount", "getItemViewType", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshViewWithNewData", "reqModel", "Lcom/tencent/mm/plugin/emoji/model/EmojiStoreTypeRecModel;", "reportExposeData", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "safeReplaceEmotionItemStatus", "emotionItem", "Lcom/tencent/mm/plugin/emoji/adapter/data/EmotionItem;", "productId", "status", "setItemClickListener", "updateBannerAutoSlide", "allowAutoSlide", "", "updateEmotionItemCdn", "cdnClientID", "updateEmotionItemListUI", "updateEmotionTypeItemView", "event", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionHolderUpdateEvent;", "updateListUIByType", "type", "updateRecListData", "updateRecTypeListUI", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends RecyclerView.a<e<?>>
{
  public final String TAG;
  private final Context context;
  public final ArrayList<t> mfy;
  private final k ybN;
  public v ybO;
  private HashMap<String, Integer> ybP;
  public Set<Integer> ybQ;
  private List<g> ybR;
  public kotlin.g.a.b<? super c, ah> ybS;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.emoji.ui.v3.b.d, ah> ybT;
  public com.tencent.mm.plugin.emoji.model.p ybU;
  
  public i(Context paramContext, k paramk)
  {
    AppMethodBeat.i(270687);
    this.context = paramContext;
    this.ybN = paramk;
    this.TAG = "MicroMsg.EmojiStoreV3HomeMainAdapter";
    this.mfy = new ArrayList();
    this.ybP = new HashMap();
    this.ybQ = ((Set)new LinkedHashSet());
    this.ybR = ((List)new ArrayList());
    AppMethodBeat.o(270687);
  }
  
  private void b(com.tencent.mm.plugin.emoji.a.a.f paramf, String paramString, int paramInt)
  {
    AppMethodBeat.i(270692);
    if ((paramf == null) || (paramString == null) || (kotlin.g.b.s.p(paramString, "")))
    {
      AppMethodBeat.o(270692);
      return;
    }
    paramf.setStatus(paramInt);
    paramf = this.ybU;
    if (paramf != null) {
      paramf.dZ(paramString, paramInt);
    }
    AppMethodBeat.o(270692);
  }
  
  public final g KF(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(270740);
    int i;
    if (this.ybR.isEmpty())
    {
      AppMethodBeat.o(270740);
      return null;
      i += 1;
    }
    for (;;)
    {
      int j = k;
      if (i < this.ybR.size())
      {
        localg = (g)this.ybR.get(i);
        if ((paramInt <= localg.dIY) || (paramInt >= localg.endPos)) {
          break;
        }
        j = 1;
      }
      if (j == 0)
      {
        AppMethodBeat.o(270740);
        return null;
      }
      AppMethodBeat.o(270740);
      return localg;
      g localg = null;
      i = 0;
    }
  }
  
  public final void a(f paramf)
  {
    int i = 1;
    bj localbj = null;
    AppMethodBeat.i(270728);
    kotlin.g.b.s.u(paramf, "event");
    String str = paramf.getProductId();
    Integer localInteger = (Integer)this.ybP.get(str);
    if ((localInteger == null) || (localInteger.intValue() >= this.mfy.size()))
    {
      Log.i(this.TAG, kotlin.g.b.s.X("updateListItemProgress failed, cache pos error, productId:", str));
      AppMethodBeat.o(270728);
      return;
    }
    Object localObject1 = this.mfy.get(localInteger.intValue());
    if ((localObject1 instanceof s))
    {
      localObject1 = (s)localObject1;
      if (localObject1 != null) {
        break label226;
      }
      localObject1 = null;
      label114:
      if (!(paramf instanceof f.b)) {
        break label255;
      }
      b((com.tencent.mm.plugin.emoji.a.a.f)localObject1, str, ((f.b)paramf).status);
      if ((localObject1 == null) || (((com.tencent.mm.plugin.emoji.a.a.f)localObject1).mStatus != -1)) {
        break label236;
      }
      if (i != 0)
      {
        Log.i(this.TAG, kotlin.g.b.s.X("force refresh emotionItem status, productId:", str));
        bool = h.dDc();
        localObject2 = this.ybU;
        if (localObject2 != null) {
          break label241;
        }
        localObject2 = com.tencent.mm.plugin.emoji.model.k.xML;
        ((com.tencent.mm.plugin.emoji.a.a.f)localObject1).a(bool, localbj, k.a.anP(str));
      }
    }
    label226:
    label236:
    label241:
    label255:
    while (!(paramf instanceof f.a)) {
      for (;;)
      {
        boolean bool;
        Object localObject2;
        t(localInteger.intValue(), paramf);
        AppMethodBeat.o(270728);
        return;
        localObject1 = null;
        break;
        localObject1 = ((s)localObject1).ycP;
        break label114;
        i = 0;
        continue;
        localbj = ((com.tencent.mm.plugin.emoji.model.p)localObject2).anQ(str);
      }
    }
    int j = ((f.a)paramf).progress;
    if (j >= 0) {
      if (j <= 99) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        b((com.tencent.mm.plugin.emoji.a.a.f)localObject1, str, 6);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.emoji.a.a.f)localObject1).boE = j;
        }
      }
      if (j < 100) {
        break;
      }
      b((com.tencent.mm.plugin.emoji.a.a.f)localObject1, str, 7);
      break;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(270703);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    paramRecyclerView.a((RecyclerView.l)new a(this));
    AppMethodBeat.o(270703);
  }
  
  public final void gO(String paramString1, String paramString2)
  {
    s locals = null;
    Object localObject2 = null;
    AppMethodBeat.i(270718);
    Object localObject1 = (Integer)((Map)this.ybP).get(paramString1);
    if ((localObject1 != null) && (((Integer)localObject1).intValue() < this.mfy.size()))
    {
      localObject1 = this.mfy.get(((Integer)localObject1).intValue());
      if ((localObject1 instanceof s))
      {
        locals = (s)localObject1;
        if (locals != null) {
          break label117;
        }
        localObject1 = null;
        label79:
        if (!kotlin.g.b.s.p(localObject1, paramString1)) {
          break label298;
        }
        if (locals != null) {
          break label154;
        }
        paramString1 = localObject2;
      }
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString1.xHI = paramString2;
        AppMethodBeat.o(270718);
        return;
        locals = null;
        break;
        label117:
        localObject1 = locals.ycP;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label79;
        }
        localObject1 = ((com.tencent.mm.plugin.emoji.a.a.f)localObject1).xHE;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label79;
        }
        localObject1 = ((cjb)localObject1).ProductID;
        break label79;
        label154:
        paramString1 = locals.ycP;
        continue;
        Log.i(this.TAG, "updateEmotionItemCdn find pos failed by productId:" + paramString1 + ", updateEmotionItemCdn ergodic");
        Iterator localIterator = ((Iterable)this.mfy).iterator();
        if (!localIterator.hasNext()) {
          break label346;
        }
        localObject2 = localIterator.next();
        localObject1 = (t)localObject2;
        if (!(localObject1 instanceof s)) {
          break label305;
        }
        localObject1 = (s)localObject1;
        label244:
        if (localObject1 != null) {
          break label310;
        }
        localObject1 = null;
        label250:
        if (!kotlin.g.b.s.p(localObject1, paramString1)) {
          break label344;
        }
        paramString1 = localObject2;
        label261:
        paramString1 = (t)paramString1;
        if (paramString1 != null)
        {
          if (!(paramString1 instanceof s)) {
            break label351;
          }
          paramString1 = (s)paramString1;
          label282:
          if (paramString1 != null) {
            break label356;
          }
        }
      }
    }
    label298:
    label305:
    label310:
    label344:
    label346:
    label351:
    label356:
    for (paramString1 = locals;; paramString1 = paramString1.ycP)
    {
      if (paramString1 != null) {
        paramString1.xHI = paramString2;
      }
      AppMethodBeat.o(270718);
      return;
      localObject1 = null;
      break label244;
      localObject1 = ((s)localObject1).ycP;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label250;
      }
      localObject1 = ((com.tencent.mm.plugin.emoji.a.a.f)localObject1).xHE;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label250;
      }
      localObject1 = ((cjb)localObject1).ProductID;
      break label250;
      break;
      paramString1 = null;
      break label261;
      paramString1 = null;
      break label282;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(270707);
    int i = this.mfy.size();
    AppMethodBeat.o(270707);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(270710);
    t localt = (t)kotlin.a.p.ae((List)this.mfy, paramInt);
    if (localt == null)
    {
      AppMethodBeat.o(270710);
      return 0;
    }
    paramInt = localt.getType();
    AppMethodBeat.o(270710);
    return paramInt;
  }
  
  public final void i(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(270749);
    if (paramLayoutManager == null)
    {
      Log.i(this.TAG, "reportExposeData failed, recyclerview layoutManager null");
      AppMethodBeat.o(270749);
      return;
    }
    int i;
    Map localMap1;
    Map localMap2;
    Map localMap3;
    Map localMap4;
    int n;
    int i1;
    t localt;
    int k;
    int m;
    label249:
    Object localObject;
    label288:
    StringBuilder localStringBuilder;
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramLayoutManager).Ju();
      int j = ((LinearLayoutManager)paramLayoutManager).Jw();
      Log.d(this.TAG, "visible firstPos:" + i + " lastPos:" + j);
      if (j - i <= 0)
      {
        AppMethodBeat.o(270749);
        return;
      }
      paramLayoutManager = new kotlin.k.g(i, j);
      i = 0;
      localMap1 = (Map)new LinkedHashMap();
      localMap2 = (Map)new LinkedHashMap();
      localMap3 = (Map)new LinkedHashMap();
      localMap4 = (Map)new LinkedHashMap();
      j = 1;
      n = paramLayoutManager.fIj;
      i1 = paramLayoutManager.aixs;
      if (n <= i1)
      {
        paramLayoutManager = this.mfy.get(n);
        kotlin.g.b.s.s(paramLayoutManager, "itemList[pos]");
        localt = (t)paramLayoutManager;
        if (!(localt instanceof s)) {
          break label1069;
        }
        if (((Collection)this.ybR).isEmpty()) {
          break label897;
        }
        k = 1;
        if (k == 0) {
          break label1069;
        }
        paramLayoutManager = (g)this.ybR.get(i);
        m = i;
        k = i;
        if (m < this.ybR.size())
        {
          if ((n <= paramLayoutManager.dIY) || (n >= paramLayoutManager.endPos)) {
            break label903;
          }
          k = m;
        }
        i = paramLayoutManager.ybL;
        if (!localMap3.containsKey(Integer.valueOf(i)))
        {
          localMap3.put(Integer.valueOf(i), new StringBuilder());
          j = 1;
        }
        if (!localMap1.containsKey(Integer.valueOf(i))) {
          localMap1.put(Integer.valueOf(i), new StringBuilder());
        }
        if (!localMap2.containsKey(Integer.valueOf(i))) {
          localMap2.put(Integer.valueOf(i), new StringBuilder());
        }
        if (j == 0)
        {
          localObject = (StringBuilder)localMap3.get(Integer.valueOf(i));
          if (localObject != null) {
            ((StringBuilder)localObject).append("#");
          }
          localObject = (StringBuilder)localMap1.get(Integer.valueOf(i));
          if (localObject != null) {
            ((StringBuilder)localObject).append("#");
          }
          localObject = (StringBuilder)localMap2.get(Integer.valueOf(i));
          if (localObject != null) {
            ((StringBuilder)localObject).append("#");
          }
        }
        j = 0;
        localObject = (StringBuilder)localMap3.get(Integer.valueOf(i));
        if (localObject != null) {
          ((StringBuilder)localObject).append(n - paramLayoutManager.dIY);
        }
        localStringBuilder = (StringBuilder)localMap1.get(Integer.valueOf(i));
        if (localStringBuilder != null)
        {
          paramLayoutManager = ((s)localt).ycP;
          if (paramLayoutManager != null) {
            break label944;
          }
          paramLayoutManager = "";
          label561:
          localStringBuilder.append(paramLayoutManager);
        }
        localStringBuilder = (StringBuilder)localMap2.get(Integer.valueOf(i));
        if (localStringBuilder != null)
        {
          paramLayoutManager = ((s)localt).ycP;
          if (paramLayoutManager != null) {
            break label979;
          }
          paramLayoutManager = "";
          label605:
          localStringBuilder.append(paramLayoutManager);
        }
        i = k;
      }
    }
    label675:
    label1060:
    label1069:
    for (;;)
    {
      if ((localt instanceof aa))
      {
        paramLayoutManager = ((aa)localt).ycR;
        if (paramLayoutManager != null) {
          break label1014;
        }
        k = 0;
        label639:
        if (!localMap4.containsKey(Integer.valueOf(k)))
        {
          long l = k;
          paramLayoutManager = ((aa)localt).ycR;
          if (paramLayoutManager != null) {
            break label1023;
          }
          paramLayoutManager = "";
          localMap4.put(Integer.valueOf(k), new com.tencent.mm.plugin.emoji.ui.v3.b.d(l, paramLayoutManager, 0, 0, null, null, 60));
        }
        m = ((aa)localt).ycS;
        localObject = (com.tencent.mm.plugin.emoji.ui.v3.b.d)localMap4.get(Integer.valueOf(k));
        if (localObject != null) {
          if (m > 0) {
            k = 1;
          }
        }
      }
      for (;;)
      {
        if (k != 1)
        {
          ((com.tencent.mm.plugin.emoji.ui.v3.b.d)localObject).ydd.append("#");
          ((com.tencent.mm.plugin.emoji.ui.v3.b.d)localObject).ydc.append("#");
        }
        ((com.tencent.mm.plugin.emoji.ui.v3.b.d)localObject).ydd.append(k);
        localStringBuilder = ((com.tencent.mm.plugin.emoji.ui.v3.b.d)localObject).ydc;
        paramLayoutManager = ((ac)((aa)localt).bMf.get(k - 1)).ycT;
        if (paramLayoutManager == null) {}
        for (paramLayoutManager = null;; paramLayoutManager = paramLayoutManager.Md5)
        {
          localStringBuilder.append(paramLayoutManager);
          if (k != m) {
            break label1060;
          }
          paramLayoutManager = this.ybT;
          if (paramLayoutManager != null) {
            paramLayoutManager.invoke(localObject);
          }
          if (n != i1) {
            break label1051;
          }
          paramLayoutManager = this.ybS;
          if (paramLayoutManager != null) {
            paramLayoutManager.invoke(new c(localMap1, localMap2, localMap3));
          }
          AppMethodBeat.o(270749);
          return;
          k = 0;
          break;
          m += 1;
          k = i;
          if (m >= this.ybR.size()) {
            break label288;
          }
          paramLayoutManager = (g)this.ybR.get(m);
          break label249;
          label944:
          paramLayoutManager = paramLayoutManager.xHE;
          if (paramLayoutManager == null)
          {
            paramLayoutManager = "";
            break label561;
          }
          localObject = paramLayoutManager.ProductID;
          paramLayoutManager = (RecyclerView.LayoutManager)localObject;
          if (localObject != null) {
            break label561;
          }
          paramLayoutManager = "";
          break label561;
          label979:
          paramLayoutManager = paramLayoutManager.xHE;
          if (paramLayoutManager == null)
          {
            paramLayoutManager = "";
            break label605;
          }
          localObject = paramLayoutManager.Zul;
          paramLayoutManager = (RecyclerView.LayoutManager)localObject;
          if (localObject != null) {
            break label605;
          }
          paramLayoutManager = "";
          break label605;
          label1014:
          k = paramLayoutManager.hjP;
          break label639;
          label1023:
          localObject = paramLayoutManager.hAP;
          paramLayoutManager = (RecyclerView.LayoutManager)localObject;
          if (localObject != null) {
            break label675;
          }
          paramLayoutManager = "";
          break label675;
        }
        n += 1;
        break;
        k += 1;
      }
    }
  }
  
  public final void om(boolean paramBoolean)
  {
    AppMethodBeat.i(270734);
    if (paramBoolean) {}
    for (d locald = (d)d.a.ybH;; locald = (d)d.b.ybI)
    {
      Iterator localIterator = ((Iterable)this.ybQ).iterator();
      while (localIterator.hasNext())
      {
        int i = ((Number)localIterator.next()).intValue();
        if (((t)this.mfy.get(i)).getType() == 5) {
          t(i, locald);
        }
      }
    }
    AppMethodBeat.o(270734);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeAdapter$onAttachedToRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.l
  {
    a(i parami) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(270650);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      a.c("com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        Log.d(i.a(this.ybV), "rv idle reportExposeData 18662, 12875");
        if ((this.ybV.ybS != null) && (this.ybV.ybT != null)) {
          this.ybV.i(paramRecyclerView.getLayoutManager());
        }
      }
      a.a(this, "com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(270650);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(270656);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      a.c("com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(270656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.i
 * JD-Core Version:    0.7.0.1
 */