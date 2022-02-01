package com.tencent.mm.plugin.finder.video.sticker;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.loader.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "()V", "TAG", "", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedId", "selectedLoading", "", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setLoading", "lensId", "isLoading", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "DiffCallbackToAdapter", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-finder_release"})
public final class e
  extends RecyclerView.a<a>
{
  public static final b ATa;
  boolean ASZ;
  final String TAG;
  int bFx;
  String uUZ;
  final ArrayList<c> uYi;
  m<? super Integer, ? super c, x> uYj;
  kotlin.g.a.b<? super Integer, x> uYk;
  
  static
  {
    AppMethodBeat.i(241403);
    ATa = new b((byte)0);
    AppMethodBeat.o(241403);
  }
  
  public e()
  {
    AppMethodBeat.i(241402);
    this.TAG = "MicroMsg.StickerEffectAdapter";
    this.uYi = new ArrayList();
    AppMethodBeat.o(241402);
  }
  
  public final c JZ(int paramInt)
  {
    AppMethodBeat.i(241394);
    c localc = (c)j.M((List)this.uYi, paramInt);
    AppMethodBeat.o(241394);
    return localc;
  }
  
  public final void bE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(241391);
    if ((p.h(this.uUZ, paramString)) && (this.ASZ != paramBoolean))
    {
      this.ASZ = paramBoolean;
      cL(this.bFx);
    }
    AppMethodBeat.o(241391);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(241398);
    int i = this.uYi.size();
    AppMethodBeat.o(241398);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(241396);
    c localc = JZ(paramInt);
    f.a locala = f.ATi;
    if (p.h(localc, f.eia()))
    {
      AppMethodBeat.o(241396);
      return 1;
    }
    AppMethodBeat.o(241396);
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(281123);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          int i = this.ATc.md();
          paramAnonymousView = this.ATc.ATb.JZ(i);
          if (paramAnonymousView != null)
          {
            localObject = this.ATc.ATb.uYj;
            if (localObject != null) {
              ((m)localObject).invoke(Integer.valueOf(i), paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(281123);
        }
      });
    }
    
    public void b(int paramInt, cqv paramcqv)
    {
      p.k(paramcqv, "info");
      paramcqv = this.amk;
      p.j(paramcqv, "itemView");
      if (paramInt == e.a(e.this)) {}
      for (boolean bool = true;; bool = false)
      {
        paramcqv.setSelected(bool);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$Companion;", "", "()V", "ViewTypeEmpty", "", "ViewTypeNormal", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$DiffCallbackToAdapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "adapter", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "updateData", "lensList", "", "Lcom/tencent/mm/sticker/LensItem;", "plugin-finder_release"})
  public static final class c
    implements d
  {
    private final e ATd;
    
    public c(e parame)
    {
      AppMethodBeat.i(287644);
      this.ATd = parame;
      AppMethodBeat.o(287644);
    }
    
    public final void aa(List<c> paramList)
    {
      AppMethodBeat.i(287639);
      p.k(paramList, "lensList");
      e locale = this.ATd;
      p.k(paramList, "lensList");
      Log.i(locale.TAG, "update: " + paramList.size());
      locale.uYi.clear();
      locale.uYi.addAll((Collection)paramList);
      AppMethodBeat.o(287639);
    }
    
    public final void ge(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287640);
      this.ATd.aG(paramInt1, paramInt2);
      AppMethodBeat.o(287640);
    }
    
    public final void gf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287641);
      this.ATd.aH(paramInt1, paramInt2);
      AppMethodBeat.o(287641);
    }
    
    public final void gg(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287642);
      this.ATd.aF(paramInt1, paramInt2);
      AppMethodBeat.o(287642);
    }
    
    public final void gh(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287643);
      this.ATd.aE(paramInt1, paramInt2);
      AppMethodBeat.o(287643);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "plugin-finder_release"})
  public final class d
    extends e.a
  {
    private final ImageView bwJ;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(287362);
      this.bwJ = ((ImageView)localObject.findViewById(b.f.finder_effect_sticker_item_icon));
      AppMethodBeat.o(287362);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "loadingBg", "getLoadingBg", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
  public final class e
    extends e.a
  {
    private final View ATe;
    private final ImageView bwJ;
    private final View uZA;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(270960);
      this.bwJ = ((ImageView)localObject.findViewById(b.f.finder_effect_sticker_item_icon));
      this.uZA = localObject.findViewById(b.f.finder_effect_sticker_item_loading);
      this.ATe = localObject.findViewById(b.f.finder_effect_sticker_item_loading_bg);
      AppMethodBeat.o(270960);
    }
    
    public final void b(int paramInt, cqv paramcqv)
    {
      AppMethodBeat.i(270958);
      p.k(paramcqv, "info");
      super.b(paramInt, paramcqv);
      Object localObject = h.VbF;
      paramcqv = h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(paramcqv));
      localObject = this.bwJ;
      p.j(localObject, "icon");
      paramcqv.c((ImageView)localObject);
      if ((paramInt == e.a(e.this)) && (e.b(e.this)))
      {
        paramcqv = this.uZA;
        p.j(paramcqv, "loading");
        paramcqv.setVisibility(0);
        paramcqv = this.ATe;
        p.j(paramcqv, "loadingBg");
        paramcqv.setVisibility(0);
        AppMethodBeat.o(270958);
        return;
      }
      paramcqv = this.uZA;
      p.j(paramcqv, "loading");
      paramcqv.setVisibility(8);
      paramcqv = this.ATe;
      p.j(paramcqv, "loadingBg");
      paramcqv.setVisibility(8);
      AppMethodBeat.o(270958);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.e
 * JD-Core Version:    0.7.0.1
 */