package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter$ProductEditViewHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/EditData;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "itemClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "pos", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "product", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function3;", "setItemClickListener", "(Lkotlin/jvm/functions/Function3;)V", "otherItem", "", "getOtherItem", "()Ljava/util/List;", "setOtherItem", "(Ljava/util/List;)V", "bindProductItem", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "select", "", "holder", "position", "deleteProducts", "", "getItemCount", "getPositionText", "", "getProductIdList", "haveSelectAllProduct", "haveSelectProduct", "moveProductItem", "from", "to", "notifyItemRangeRefresh", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "onItemClickListener", "printInfo", "list", "tag", "printRvListInfo", "resetSelectProductItems", "selectAllProducts", "updateProductList", "Ljava/util/LinkedList;", "Companion", "ProductEditViewHolder", "plugin-finder_release"})
public final class w
  extends RecyclerView.a<b>
{
  public static final a yZk;
  public ArrayList<a> mXB;
  public q<? super View, ? super Integer, ? super bu, kotlin.x> yWa;
  public List<? extends bu> yZj;
  
  static
  {
    AppMethodBeat.i(270280);
    yZk = new a((byte)0);
    AppMethodBeat.o(270280);
  }
  
  public w()
  {
    AppMethodBeat.i(270279);
    this.mXB = new ArrayList();
    AppMethodBeat.o(270279);
  }
  
  private final String NP(int paramInt)
  {
    AppMethodBeat.i(270274);
    int i = getItemCount();
    AppMethodBeat.o(270274);
    return String.valueOf(i - paramInt);
  }
  
  private void a(final b paramb, final int paramInt)
  {
    AppMethodBeat.i(270277);
    p.k(paramb, "holder");
    Object localObject = this.mXB.get(paramInt);
    p.j(localObject, "dataList[position]");
    localObject = (a)localObject;
    a(((a)localObject).yVL, ((a)localObject).yip, paramb, paramInt);
    paramb.amk.setOnClickListener((View.OnClickListener)new c(this, paramb, paramInt, (a)localObject));
    AppMethodBeat.o(270277);
  }
  
  private final void a(f paramf, boolean paramBoolean, b paramb, int paramInt)
  {
    AppMethodBeat.i(270275);
    Object localObject1 = t.ztT;
    localObject1 = t.dJi();
    Object localObject2 = paramf.zaP;
    p.j(localObject2, "item.img_urls");
    localObject2 = new e((String)j.lp((List)localObject2));
    Object localObject3 = paramb.yZl;
    p.j(localObject3, "holder.productImg");
    Object localObject4 = t.ztT;
    ((d)localObject1).a(localObject2, (ImageView)localObject3, t.a(t.a.zug));
    localObject1 = paramb.yZm;
    p.j(localObject1, "holder.productSeq");
    ((TextView)localObject1).setText((CharSequence)NP(paramInt));
    localObject1 = x.yZD;
    localObject4 = paramb.yZn;
    p.j(localObject4, "holder.productDesc");
    localObject2 = paramf.zaM;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject3 = paramf.title;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    x.a.a((TextView)localObject4, (String)localObject1, (String)localObject2);
    localObject1 = x.yZD;
    localObject3 = paramb.yZp;
    p.j(localObject3, "holder.productStock");
    localObject4 = paramb.yZr;
    p.j(localObject4, "holder.sourceDivider");
    TextView localTextView = paramb.yZq;
    p.j(localTextView, "holder.productSource");
    paramInt = paramf.zaQ;
    localObject2 = paramf.zaM;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    x.a.a((TextView)localObject3, (View)localObject4, localTextView, paramInt, (String)localObject1, paramf.yiH);
    localObject1 = x.yZD;
    localObject1 = paramb.yZo;
    p.j(localObject1, "holder.productPrice");
    x.a.a((TextView)localObject1, paramf.zaS, paramf.zaR);
    paramf = paramb.checkBox;
    p.j(paramf, "holder.checkBox");
    paramf.setChecked(paramBoolean);
    AppMethodBeat.o(270275);
  }
  
  public static void d(ArrayList<a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(270271);
    Object localObject = aj.AGc;
    if (aj.eej())
    {
      paramString = new StringBuilder(paramString + ':');
      if (paramArrayList != null)
      {
        paramArrayList = ((Iterable)paramArrayList).iterator();
        int i = 0;
        while (paramArrayList.hasNext())
        {
          localObject = paramArrayList.next();
          if (i < 0) {
            j.iBO();
          }
          localObject = (a)localObject;
          paramString.append("[" + i + ',' + ((a)localObject).yVL.zaO + ']');
          i += 1;
        }
      }
      Log.i("FinderLiveShoppingEditAdapter", paramString.toString());
    }
    AppMethodBeat.o(270271);
  }
  
  public static void j(List<? extends bu> paramList, String paramString)
  {
    AppMethodBeat.i(270270);
    paramString = new StringBuilder(paramString + ':');
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (i < 0) {
          j.iBO();
        }
        localObject = (bu)localObject;
        paramString.append("[" + i + ',' + ((bu)localObject).mf() + ']');
        i += 1;
      }
    }
    Log.i("FinderLiveShoppingEditAdapter", paramString.toString());
    AppMethodBeat.o(270270);
  }
  
  public final boolean dFF()
  {
    AppMethodBeat.i(270264);
    if (this.mXB.size() <= 0)
    {
      AppMethodBeat.o(270264);
      return false;
    }
    Iterator localIterator = ((Iterable)this.mXB).iterator();
    while (localIterator.hasNext()) {
      if (!((a)localIterator.next()).yip)
      {
        AppMethodBeat.o(270264);
        return false;
      }
    }
    AppMethodBeat.o(270264);
    return true;
  }
  
  public final void dFG()
  {
    AppMethodBeat.i(270265);
    Iterator localIterator = ((Iterable)this.mXB).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).yip = true;
    }
    AppMethodBeat.o(270265);
  }
  
  public final void dFH()
  {
    AppMethodBeat.i(270266);
    Iterator localIterator = ((Iterable)this.mXB).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).yip = false;
    }
    AppMethodBeat.o(270266);
  }
  
  public final void dFI()
  {
    AppMethodBeat.i(270268);
    e(0, getItemCount(), Integer.valueOf(1));
    AppMethodBeat.o(270268);
  }
  
  public final ArrayList<Long> dFJ()
  {
    AppMethodBeat.i(270269);
    localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.mXB.iterator();
      p.j(localIterator, "dataList.iterator()");
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = localIterator.next();
        p.j(localObject2, "iterator.next()");
        localObject2 = (a)localObject2;
        if (((a)localObject2).yip)
        {
          localIterator.remove();
          localArrayList.add(Long.valueOf(((a)localObject2).yVL.zaO));
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localObject2 = aj.AGc;
      aj.a(localException, "FinderLiveShoppingEditAdapter,deleteProducts:");
      return localArrayList;
      d(this.mXB, "after deleteProducts");
      return localArrayList;
    }
    finally
    {
      AppMethodBeat.o(270269);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(270273);
    int i = this.mXB.size();
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.ha("FinderLiveShoppingEditAdapter", "getItemCount ".concat(String.valueOf(i)));
    AppMethodBeat.o(270273);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter$Companion;", "", "()V", "TAG", "", "payloadMove", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter$ProductEditViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "productDesc", "Landroid/widget/TextView;", "getProductDesc", "()Landroid/widget/TextView;", "setProductDesc", "(Landroid/widget/TextView;)V", "productImg", "Landroid/widget/ImageView;", "getProductImg", "()Landroid/widget/ImageView;", "setProductImg", "(Landroid/widget/ImageView;)V", "productPrice", "getProductPrice", "setProductPrice", "productSeq", "getProductSeq", "setProductSeq", "productSource", "getProductSource", "setProductSource", "productStock", "getProductStock", "setProductStock", "sourceDivider", "getSourceDivider", "()Landroid/view/View;", "setSourceDivider", "(Landroid/view/View;)V", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    CheckBox checkBox;
    ImageView yZl;
    TextView yZm;
    TextView yZn;
    TextView yZo;
    TextView yZp;
    TextView yZq;
    View yZr;
    
    public b()
    {
      super();
      AppMethodBeat.i(291214);
      this.checkBox = ((CheckBox)localObject.findViewById(b.f.shopping_edit_checkbox));
      this.yZl = ((ImageView)localObject.findViewById(b.f.product_img));
      this.yZm = ((TextView)localObject.findViewById(b.f.product_seq));
      this.yZn = ((TextView)localObject.findViewById(b.f.product_desc));
      this.yZo = ((TextView)localObject.findViewById(b.f.product_price));
      this.yZp = ((TextView)localObject.findViewById(b.f.product_stock));
      this.yZq = ((TextView)localObject.findViewById(b.f.product_source));
      this.yZr = localObject.findViewById(b.f.product_src_divider);
      this$1 = aj.AGc;
      this$1 = this.yZo;
      p.j(w.this, "productPrice");
      aj.u(w.this);
      AppMethodBeat.o(291214);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(w paramw, w.b paramb, int paramInt, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230399);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      w.a(this.yZs, paramb, paramInt, this.yZu);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230399);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.w
 * JD-Core Version:    0.7.0.1
 */