package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.ui.v3.banner.EmojiStoreV3BannerView;
import com.tencent.mm.plugin.emoji.ui.v3.banner.EmojiStoreV3BannerView.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BannerHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/BannerEmotionTypeItem;", "context", "Landroid/content/Context;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;)V", "TAG", "", "bannerAdapter", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerAdapter;", "getBannerAdapter", "()Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerAdapter;", "bannerAdapter$delegate", "Lkotlin/Lazy;", "bannerView", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerView;", "getContext", "()Landroid/content/Context;", "firstSetUp", "", "itemSizeResolver", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/BannerItemSizeResolver;", "onBind", "", "dataItem", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "item", "payloads", "", "", "startPlayBanner", "stopPlayBanner", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e<a>
{
  private final String TAG;
  private final Context context;
  private final EmojiStoreV3BannerView ybC;
  private final j ybD;
  private boolean ybE;
  private final b ybF;
  
  public c(Context paramContext, View paramView, v paramv)
  {
    super(paramView, (u)paramv);
    AppMethodBeat.i(270659);
    this.context = paramContext;
    this.TAG = "MicroMsg.EmojiStoreV3BannerHolder";
    paramContext = paramView.findViewById(h.e.emoji_store_header_banner);
    s.s(paramContext, "itemView.findViewById(R.…moji_store_header_banner)");
    this.ybC = ((EmojiStoreV3BannerView)paramContext);
    this.ybD = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.ybE = true;
    this.ybF = new b();
    AppMethodBeat.o(270659);
  }
  
  private final com.tencent.mm.plugin.emoji.ui.v3.banner.a dCX()
  {
    AppMethodBeat.i(270671);
    com.tencent.mm.plugin.emoji.ui.v3.banner.a locala = (com.tencent.mm.plugin.emoji.ui.v3.banner.a)this.ybD.getValue();
    AppMethodBeat.o(270671);
    return locala;
  }
  
  private void dCY()
  {
    AppMethodBeat.i(270680);
    Log.d(this.TAG, "startPlayBanner");
    this.ybC.dCU();
    AppMethodBeat.o(270680);
  }
  
  private void dCZ()
  {
    AppMethodBeat.i(270697);
    Log.d(this.TAG, "stopPlayBanner");
    this.ybC.dCV();
    AppMethodBeat.o(270697);
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(270716);
    s.u(paramt, "dataItem");
    super.a(paramt);
    a(paramt, (List)new ArrayList());
    AppMethodBeat.o(270716);
  }
  
  public final void a(t paramt, List<Object> paramList)
  {
    AppMethodBeat.i(270738);
    s.u(paramt, "item");
    s.u(paramList, "payloads");
    super.a(paramt);
    if (paramList.isEmpty())
    {
      if ((paramt instanceof a)) {}
      for (paramt = (a)paramt; paramt == null; paramt = null)
      {
        AppMethodBeat.o(270738);
        return;
      }
      paramList = paramt.ybA;
      paramt = paramt.ybB;
      int i = (int)this.context.getResources().getDimension(h.c.emoji_store_v3_banner_item_space);
      EmojiStoreV3BannerView.a locala = new EmojiStoreV3BannerView.a((byte)0);
      locala.ybl = true;
      locala.ybk = true;
      locala.ybo = i;
      locala.loop = true;
      locala.yaY = i;
      locala.ybm = 5000L;
      i = (int)this.context.getResources().getDimension(h.c.emoji_store_v3_banner_top_margin);
      int j = (int)this.context.getResources().getDimension(h.c.emoji_store_v3_banner_item_height);
      this.caK.setBackgroundResource(h.b.BW_93);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, j);
      localLayoutParams.setMargins(0, i, 0, 0);
      this.ybC.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      if (this.ybE)
      {
        this.ybC.a(locala, (RecyclerView.a)dCX());
        this.ybC.setSizeResolver((k)this.ybF);
      }
      dCX();
      paramt = com.tencent.mm.plugin.emoji.ui.v3.banner.a.s(paramList, paramt);
      dCX().fh(paramt);
      this.ybE = false;
      AppMethodBeat.o(270738);
      return;
    }
    paramt = paramList.get(paramList.size() - 1);
    if ((paramt instanceof d.a))
    {
      Log.d(this.TAG, "onBind: StartAutoSlide");
      dCY();
      AppMethodBeat.o(270738);
      return;
    }
    if ((paramt instanceof d.b))
    {
      Log.d(this.TAG, "onBind: StopAutoSlide");
      dCZ();
    }
    AppMethodBeat.o(270738);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerAdapter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.emoji.ui.v3.banner.a>
  {
    a(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.c
 * JD-Core Version:    0.7.0.1
 */