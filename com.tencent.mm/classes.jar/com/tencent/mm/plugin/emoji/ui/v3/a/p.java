package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3SingleProductRecyclerView;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAlbumHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/SingleProductAlbumTypeItem;", "context", "Landroid/content/Context;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;", "itemSizeResolver", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;)V", "TAG", "", "albumTitle", "Landroid/widget/TextView;", "bgRadius", "", "bgShape", "Landroid/graphics/drawable/Drawable;", "getContext", "()Landroid/content/Context;", "firstSetUp", "", "iconMore", "Landroid/widget/ImageView;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "normBgColor", "", "pressBgColor", "recyclerView", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3SingleProductRecyclerView;", "rvAdapter", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter;", "onBind", "", "dataItem", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "item", "payloads", "", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends e<aa>
{
  private final String TAG;
  private final Context context;
  private final GridLayoutManager mkZ;
  private final o yat;
  private boolean ybE;
  private final int ybv;
  private final int ybw;
  private final float ybx;
  private final Drawable yby;
  private final k ycI;
  private final TextView ycJ;
  private final ImageView ycK;
  private final EmojiStoreV3SingleProductRecyclerView ycL;
  
  public p(Context paramContext, View paramView, v paramv, k paramk)
  {
    super(paramView, (u)paramv);
    AppMethodBeat.i(270667);
    this.context = paramContext;
    this.ycI = paramk;
    this.TAG = "MicroMsg.EmojiStoreV3SingleProductAlbumHolder";
    paramContext = paramView.findViewById(h.e.single_product_album_item_title);
    s.s(paramContext, "itemView.findViewById(R.…product_album_item_title)");
    this.ycJ = ((TextView)paramContext);
    paramContext = paramView.findViewById(h.e.single_product_album_item_more);
    s.s(paramContext, "itemView.findViewById(R.…_product_album_item_more)");
    this.ycK = ((ImageView)paramContext);
    paramContext = paramView.findViewById(h.e.single_product_album_item_rv);
    s.s(paramContext, "itemView.findViewById(R.…le_product_album_item_rv)");
    this.ycL = ((EmojiStoreV3SingleProductRecyclerView)paramContext);
    this.mkZ = new GridLayoutManager(this.ycI.spanCount);
    this.yat = new o(this.context, (List)new ArrayList());
    this.ybE = true;
    this.ybv = com.tencent.mm.cd.a.w(this.context, h.b.BW_100);
    this.ybw = com.tencent.mm.cd.a.w(this.context, h.b.BW_0_Alpha_0_0_5);
    this.ybx = d.e(this.context, 8.0F);
    paramContext = com.tencent.mm.plugin.emoji.g.a.ydF;
    this.yby = com.tencent.mm.plugin.emoji.g.a.a(this.ybv, this.ybw, this.ybx, this.ybx, this.ybx, this.ybx);
    AppMethodBeat.o(270667);
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(270682);
    s.u(paramt, "dataItem");
    super.a(paramt);
    a(paramt, (List)new ArrayList());
    AppMethodBeat.o(270682);
  }
  
  public final void a(final t paramt, List<Object> paramList)
  {
    AppMethodBeat.i(270696);
    s.u(paramt, "item");
    s.u(paramList, "payloads");
    super.a(paramt, paramList);
    this.caK.setBackground(this.yby);
    ah.f localf;
    if ((paramt instanceof aa))
    {
      paramList = (aa)paramt;
      localf = new ah.f();
      if (paramList != null) {
        break label106;
      }
    }
    label106:
    for (Object localObject = null;; localObject = paramList.bMf)
    {
      localf.aqH = localObject;
      if ((localf.aqH != null) && (!((List)localf.aqH).isEmpty()) && (paramList != null)) {
        break label114;
      }
      AppMethodBeat.o(270696);
      return;
      paramList = null;
      break;
    }
    label114:
    localObject = this.ycJ;
    paramList = paramList.ycR;
    if (paramList == null) {}
    for (paramList = null;; paramList = paramList.hAP)
    {
      ((TextView)localObject).setText((CharSequence)paramList);
      aw.d((Paint)this.ycJ.getPaint());
      this.yat.ycw.clear();
      if (this.ybE)
      {
        this.ybE = false;
        paramList = this.context.getResources();
        this.ycL.setSizeResolver(this.ycI);
        this.ycL.a((RecyclerView.h)new com.tencent.mm.plugin.emoji.ui.v3.a((int)paramList.getDimension(h.c.Edge_2A), 0, this.ycI));
        this.ycL.setAdapter((RecyclerView.a)this.yat);
        this.yat.ycx = dDa();
        this.ycL.setLayoutManager((RecyclerView.LayoutManager)this.mkZ);
        this.ycL.setOnSizeChangedCallback((b)new a(localf, paramt, this));
      }
      this.yat.ycw.addAll((Collection)localf.aqH);
      this.yat.by(0, ((List)localf.aqH).size());
      ((aa)paramt).ycS = this.ycI.spanCount;
      AppMethodBeat.o(270696);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "spanCount", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements b<Integer, ah>
  {
    a(ah.f<List<ac>> paramf, t paramt, p paramp)
    {
      super();
    }
    
    private static final void a(p paramp, List paramList)
    {
      AppMethodBeat.i(270727);
      s.u(paramp, "this$0");
      s.u(paramList, "$newData");
      p.a(paramp).ycw.clear();
      p.a(paramp).ycw.addAll((Collection)paramList);
      p.a(paramp).bZE.notifyChanged();
      AppMethodBeat.o(270727);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.p
 * JD-Core Version:    0.7.0.1
 */