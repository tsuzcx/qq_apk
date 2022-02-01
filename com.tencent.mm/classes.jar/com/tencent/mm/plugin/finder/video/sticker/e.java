package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.loader.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "()V", "TAG", "", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedId", "selectedLoading", "", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setLoading", "lensId", "isLoading", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "DiffCallbackToAdapter", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-finder_release"})
public final class e
  extends RecyclerView.a<a>
{
  public static final e.b wiS;
  final String TAG;
  String rpt;
  final ArrayList<c> rsC;
  m<? super Integer, ? super c, x> rsD;
  kotlin.g.a.b<? super Integer, x> rsE;
  int va;
  boolean wiR;
  
  static
  {
    AppMethodBeat.i(254580);
    wiS = new e.b((byte)0);
    AppMethodBeat.o(254580);
  }
  
  public e()
  {
    AppMethodBeat.i(254579);
    this.TAG = "MicroMsg.StickerEffectAdapter";
    this.rsC = new ArrayList();
    AppMethodBeat.o(254579);
  }
  
  public final c Gs(int paramInt)
  {
    AppMethodBeat.i(254574);
    c localc = (c)j.L((List)this.rsC, paramInt);
    AppMethodBeat.o(254574);
    return localc;
  }
  
  public final void bx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(254573);
    if ((p.j(this.rpt, paramString)) && (this.wiR != paramBoolean))
    {
      this.wiR = paramBoolean;
      ci(this.va);
    }
    AppMethodBeat.o(254573);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(254577);
    int i = this.rsC.size();
    AppMethodBeat.o(254577);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(254575);
    c localc = Gs(paramInt);
    f.a locala = f.wja;
    if (p.j(localc, f.dGg()))
    {
      AppMethodBeat.o(254575);
      return 1;
    }
    AppMethodBeat.o(254575);
    return 0;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
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
          AppMethodBeat.i(254563);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          int i = this.wiU.lR();
          paramAnonymousView = this.wiU.wiT.Gs(i);
          if (paramAnonymousView != null)
          {
            localObject = this.wiU.wiT.rsD;
            if (localObject != null) {
              ((m)localObject).invoke(Integer.valueOf(i), paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254563);
        }
      });
    }
    
    public void b(int paramInt, chz paramchz)
    {
      p.h(paramchz, "info");
      paramchz = this.aus;
      p.g(paramchz, "itemView");
      if (paramInt == e.a(e.this)) {}
      for (boolean bool = true;; bool = false)
      {
        paramchz.setSelected(bool);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "plugin-finder_release"})
  public final class d
    extends e.a
  {
    private final ImageView kc;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(254570);
      this.kc = ((ImageView)localObject.findViewById(2131300806));
      AppMethodBeat.o(254570);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "loadingBg", "getLoadingBg", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
  public final class e
    extends e.a
  {
    private final ImageView kc;
    private final View rtV;
    private final View wiW;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(254572);
      this.kc = ((ImageView)localObject.findViewById(2131300806));
      this.rtV = localObject.findViewById(2131300807);
      this.wiW = localObject.findViewById(2131300808);
      AppMethodBeat.o(254572);
    }
    
    public final void b(int paramInt, chz paramchz)
    {
      AppMethodBeat.i(254571);
      p.h(paramchz, "info");
      super.b(paramInt, paramchz);
      Object localObject = h.NNV;
      paramchz = h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(paramchz));
      localObject = this.kc;
      p.g(localObject, "icon");
      paramchz.c((ImageView)localObject);
      if ((paramInt == e.a(e.this)) && (e.b(e.this)))
      {
        paramchz = this.rtV;
        p.g(paramchz, "loading");
        paramchz.setVisibility(0);
        paramchz = this.wiW;
        p.g(paramchz, "loadingBg");
        paramchz.setVisibility(0);
        AppMethodBeat.o(254571);
        return;
      }
      paramchz = this.rtV;
      p.g(paramchz, "loading");
      paramchz.setVisibility(8);
      paramchz = this.wiW;
      p.g(paramchz, "loadingBg");
      paramchz.setVisibility(8);
      AppMethodBeat.o(254571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.e
 * JD-Core Version:    0.7.0.1
 */