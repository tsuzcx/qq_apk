package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.f.c;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.k.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "context", "Landroid/content/Context;", "itemListData", "", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "(Landroid/content/Context;Ljava/util/List;)V", "TAG", "", "bottomLoadingDataItem", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/SingleProductAlbumBottomLoadingItem;", "clickListener", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3ClickListener;", "getContext", "()Landroid/content/Context;", "headerCount", "", "getHeaderCount", "()I", "setHeaderCount", "(I)V", "getItemListData", "()Ljava/util/List;", "onExpose12875Report", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/emoji/ui/v3/report/SingleProductExpose12875Data;", "Lkotlin/ParameterName;", "name", "data", "", "getOnExpose12875Report", "()Lkotlin/jvm/functions/Function1;", "setOnExpose12875Report", "(Lkotlin/jvm/functions/Function1;)V", "onHeaderVisibilityChange", "", "visible", "getOnHeaderVisibilityChange", "setOnHeaderVisibilityChange", "onPreload", "Lkotlin/Function0;", "getOnPreload", "()Lkotlin/jvm/functions/Function0;", "setOnPreload", "(Lkotlin/jvm/functions/Function0;)V", "preloadItemCount", "getPreloadItemCount", "setPreloadItemCount", "scrollState", "checkPreload", "position", "getItem", "getItemCount", "getItemViewType", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeBottomLoadingUI", "reportExposeData", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setItemClickListener", "showBottomLoadingUI", "EmojiStoreV3SingleProductAlbumHeaderInfoHolder", "EmojiStoreV3SingleProductBottomLoadingViewHolder", "EmojiStoreV3SingleProductHolder", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends RecyclerView.a<e<?>>
{
  public final String TAG;
  private final Context context;
  private int dyP;
  private int xZt;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.emoji.ui.v3.b.d, ah> ybT;
  public int ycA;
  public final x ycB;
  public final List<t> ycw;
  public u ycx;
  public kotlin.g.a.a<ah> ycy;
  public kotlin.g.a.b<? super Boolean, ah> ycz;
  
  public o(Context paramContext, List<t> paramList)
  {
    AppMethodBeat.i(270670);
    this.context = paramContext;
    this.ycw = paramList;
    this.TAG = "MicroMsg.EmojiStoreV3SingleProductAdapter";
    paramContext = this.context.getString(h.h.emoji_store_load_more);
    kotlin.g.b.s.s(paramContext, "context.getString(R.string.emoji_store_load_more)");
    this.ycB = new x(paramContext);
    AppMethodBeat.o(270670);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(270679);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    paramRecyclerView.a((RecyclerView.l)new d(this));
    AppMethodBeat.o(270679);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(270689);
    int i = this.ycw.size();
    AppMethodBeat.o(270689);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(270695);
    t localt = (t)p.ae(this.ycw, paramInt);
    if (localt == null)
    {
      AppMethodBeat.o(270695);
      return 0;
    }
    paramInt = localt.getType();
    AppMethodBeat.o(270695);
    return paramInt;
  }
  
  public final void i(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(270704);
    if (paramLayoutManager == null)
    {
      Log.i(this.TAG, "reportExposeData failed, recyclerview layoutManager null");
      AppMethodBeat.o(270704);
      return;
    }
    int j;
    com.tencent.mm.plugin.emoji.ui.v3.b.d locald;
    int m;
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      int i = ((LinearLayoutManager)paramLayoutManager).Ju();
      j = ((LinearLayoutManager)paramLayoutManager).Jw();
      if (j - i <= 0)
      {
        AppMethodBeat.o(270704);
        return;
      }
      Log.d(this.TAG, "visible firstPos:" + i + " lastPos:" + j);
      paramLayoutManager = new g(i, j);
      int k = this.xZt;
      locald = new com.tencent.mm.plugin.emoji.ui.v3.b.d(0L, null, 0, 0, null, null, 63);
      j = paramLayoutManager.fIj;
      m = paramLayoutManager.aixs;
      if (j <= m)
      {
        i = 1;
        paramLayoutManager = (t)this.ycw.get(j);
        if (!(paramLayoutManager instanceof ac)) {
          break label289;
        }
        if (i == 0)
        {
          locald.ydc.append("#");
          locald.ydd.append("#");
        }
        StringBuilder localStringBuilder = locald.ydc;
        paramLayoutManager = ((ac)paramLayoutManager).ycT;
        if (paramLayoutManager != null) {
          break label274;
        }
        paramLayoutManager = null;
        label219:
        localStringBuilder.append(paramLayoutManager);
        locald.ydd.append(j + 1 - k);
        i = 0;
      }
    }
    label274:
    label289:
    for (;;)
    {
      if (j == m)
      {
        paramLayoutManager = this.ybT;
        if (paramLayoutManager != null) {
          paramLayoutManager.invoke(locald);
        }
        AppMethodBeat.o(270704);
        return;
        paramLayoutManager = paramLayoutManager.Md5;
        break label219;
      }
      j += 1;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter$EmojiStoreV3SingleProductAlbumHeaderInfoHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/SingleProductAlbumHeaderInfoItem;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "albumDescTv", "Landroid/widget/TextView;", "getAlbumDescTv", "()Landroid/widget/TextView;", "albumNameTv", "getAlbumNameTv", "onBind", "", "dataItem", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "item", "payloads", "", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends e<y>
  {
    private final String TAG;
    private final TextView ycC;
    private final TextView ycD;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(270620);
      this.TAG = "MicroMsg.EmojiStoreV3SingleProductAlbumHeaderInfoHolder";
      View localView = paramView.findViewById(h.e.single_product_album_header_title);
      kotlin.g.b.s.s(localView, "itemView.findViewById(R.…oduct_album_header_title)");
      this.ycC = ((TextView)localView);
      paramView = paramView.findViewById(h.e.single_product_album_header_desc);
      kotlin.g.b.s.s(paramView, "itemView.findViewById(R.…roduct_album_header_desc)");
      this.ycD = ((TextView)paramView);
      AppMethodBeat.o(270620);
    }
    
    public final void a(t paramt)
    {
      AppMethodBeat.i(270631);
      kotlin.g.b.s.u(paramt, "dataItem");
      super.a(paramt);
      a(paramt, (List)new ArrayList());
      AppMethodBeat.o(270631);
    }
    
    public final void a(t paramt, List<Object> paramList)
    {
      Object localObject = null;
      AppMethodBeat.i(270637);
      kotlin.g.b.s.u(paramt, "item");
      kotlin.g.b.s.u(paramList, "payloads");
      super.a(paramt, paramList);
      if ((paramt instanceof y))
      {
        paramt = (y)paramt;
        aw.d((Paint)this.ycC.getPaint());
        TextView localTextView = this.ycC;
        if (paramt != null) {
          break label127;
        }
        paramList = null;
        label62:
        localTextView.setText((CharSequence)paramList);
        localTextView = this.ycD;
        if (paramt != null) {
          break label135;
        }
        paramList = null;
        label83:
        localTextView.setText((CharSequence)paramList);
        if (paramt != null) {
          break label143;
        }
      }
      label135:
      label143:
      for (paramt = localObject;; paramt = paramt.yau)
      {
        if (kotlin.g.b.s.p(paramt, "")) {
          this.ycD.setVisibility(8);
        }
        AppMethodBeat.o(270637);
        return;
        paramt = null;
        break;
        label127:
        paramList = paramt.albumName;
        break label62;
        paramList = paramt.yau;
        break label83;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter$EmojiStoreV3SingleProductBottomLoadingViewHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/SingleProductAlbumBottomLoadingItem;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "loadingTv", "Landroid/widget/TextView;", "onBind", "", "dataItem", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "item", "payloads", "", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e<x>
  {
    private final TextView ycE;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(270623);
      paramView = paramView.findViewById(h.e.load_more_footer_tv);
      kotlin.g.b.s.s(paramView, "itemView.findViewById(R.id.load_more_footer_tv)");
      this.ycE = ((TextView)paramView);
      AppMethodBeat.o(270623);
    }
    
    public final void a(t paramt)
    {
      AppMethodBeat.i(270634);
      kotlin.g.b.s.u(paramt, "dataItem");
      super.a(paramt);
      a(paramt, (List)new ArrayList());
      AppMethodBeat.o(270634);
    }
    
    public final void a(t paramt, List<Object> paramList)
    {
      Object localObject = null;
      AppMethodBeat.i(270642);
      kotlin.g.b.s.u(paramt, "item");
      kotlin.g.b.s.u(paramList, "payloads");
      super.a(paramt, paramList);
      if (!((Collection)paramList).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.caK.setVisibility(8);
        this.ycE.setVisibility(8);
        AppMethodBeat.o(270642);
        return;
      }
      if ((paramt instanceof x))
      {
        paramt = (x)paramt;
        this.ycE.setVisibility(0);
        paramList = this.ycE;
        if (paramt != null) {
          break label124;
        }
      }
      label124:
      for (paramt = localObject;; paramt = paramt.wording)
      {
        paramList.setText((CharSequence)paramt);
        AppMethodBeat.o(270642);
        return;
        paramt = null;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter$EmojiStoreV3SingleProductHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/SingleProductTypeItem;", "context", "Landroid/content/Context;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3ClickListener;", "onPreload", "Lkotlin/Function0;", "", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3ClickListener;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "emotionImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getEmotionImg", "()Landroid/widget/ImageView;", "emotionTitle", "Landroid/widget/TextView;", "getEmotionTitle", "()Landroid/widget/TextView;", "imgWidth", "", "getImgWidth", "()I", "getOnPreload", "()Lkotlin/jvm/functions/Function0;", "setOnPreload", "(Lkotlin/jvm/functions/Function0;)V", "onBind", "dataItem", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "payloads", "", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends e<ac>
  {
    private final String TAG;
    private final int osv;
    private final ImageView ycF;
    private final TextView ycG;
    private kotlin.g.a.a<ah> ycy;
    
    private c(Context paramContext, View paramView, u paramu)
    {
      super(paramu);
      AppMethodBeat.i(270610);
      this.ycy = null;
      this.TAG = "MicroMsg.EmojiStoreV3SingleProductHolder";
      this.ycF = ((ImageView)paramView.findViewById(h.e.item_img));
      this.ycG = ((TextView)paramView.findViewById(h.e.item_name));
      this.osv = com.tencent.mm.cd.a.br(paramContext, h.c.emoji_store_v3_single_product_item_size);
      AppMethodBeat.o(270610);
    }
    
    public final void a(t paramt)
    {
      AppMethodBeat.i(270624);
      kotlin.g.b.s.u(paramt, "dataItem");
      super.a(paramt);
      a(paramt, (List)new ArrayList());
      AppMethodBeat.o(270624);
    }
    
    public final void a(t paramt, List<Object> paramList)
    {
      AppMethodBeat.i(270641);
      kotlin.g.b.s.u(paramt, "dataItem");
      kotlin.g.b.s.u(paramList, "payloads");
      super.a(paramt, paramList);
      if ((paramt instanceof ac))
      {
        paramt = (ac)paramt;
        if (paramt != null) {
          break label65;
        }
      }
      label65:
      for (paramt = null;; paramt = paramt.ycT)
      {
        if (paramt != null) {
          break label73;
        }
        Log.i(this.TAG, "onBind Failed, EmojiInfo null");
        AppMethodBeat.o(270641);
        return;
        paramt = null;
        break;
      }
      label73:
      this.ycG.setText((CharSequence)paramt.Zty);
      this.ycF.setImageResource(h.d.emoji_download_icon);
      if (!Util.isNullOrNil(paramt.ThumbUrl))
      {
        paramList = c.moq;
        paramList = c.Ew(paramt.Md5);
        r.bKe().a(paramt.ThumbUrl, this.ycF, com.tencent.mm.plugin.emoji.mgr.e.a(paramList, this.osv, new Object[0]));
        this.ycF.setImportantForAccessibility(1);
        this.ycF.setContentDescription((CharSequence)MMApplicationContext.getString(h.h.emoji_desc));
        AppMethodBeat.o(270641);
        return;
      }
      if (!Util.isNullOrNil(paramt.Url))
      {
        paramList = EmojiLogic.W(com.tencent.mm.plugin.emoji.g.d.bzQ(), "", paramt.Md5);
        com.tencent.mm.plugin.emoji.model.s.dAi().a(paramt.Url, this.ycF, com.tencent.mm.plugin.emoji.mgr.e.a(paramList, this.osv, new Object[0]));
        this.ycF.setImportantForAccessibility(1);
        this.ycF.setContentDescription((CharSequence)MMApplicationContext.getString(h.h.emoji_desc));
        AppMethodBeat.o(270641);
        return;
      }
      this.ycF.setImportantForAccessibility(4);
      Log.w(this.TAG, "this emoji has no thumb url and url. download faild");
      AppMethodBeat.o(270641);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter$onAttachedToRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(o paramo) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(270611);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      o.a(this.ycH, paramInt);
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if ((paramInt == 0) && (this.ycH.ybT != null)) {
        this.ycH.i(paramRecyclerView.getLayoutManager());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(270611);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(270619);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (paramInt2 != 0)
      {
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if ((paramRecyclerView instanceof GridLayoutManager))
        {
          localObject = this.ycH.ycz;
          if (localObject != null) {
            if (((GridLayoutManager)paramRecyclerView).Ju() != 0) {
              break label136;
            }
          }
        }
      }
      label136:
      for (boolean bool = true;; bool = false)
      {
        ((kotlin.g.a.b)localObject).invoke(Boolean.valueOf(bool));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(270619);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.o
 * JD-Core Version:    0.7.0.1
 */