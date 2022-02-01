package com.tencent.mm.plugin.finder.video.sticker;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.loader.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "()V", "TAG", "", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedId", "selectedLoading", "", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setLoading", "lensId", "isLoading", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "DiffCallbackToAdapter", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.a<a>
{
  public static final e.b GuY;
  boolean GuZ;
  final String TAG;
  int dyx;
  String mlM;
  final ArrayList<c> ykw;
  m<? super Integer, ? super c, ah> ykx;
  kotlin.g.a.b<? super Integer, ah> yky;
  
  static
  {
    AppMethodBeat.i(335912);
    GuY = new e.b((byte)0);
    AppMethodBeat.o(335912);
  }
  
  public e()
  {
    AppMethodBeat.i(335895);
    this.TAG = "MicroMsg.StickerEffectAdapter";
    this.ykw = new ArrayList();
    AppMethodBeat.o(335895);
  }
  
  public final c KX(int paramInt)
  {
    AppMethodBeat.i(335923);
    c localc = (c)p.ae((List)this.ykw, paramInt);
    AppMethodBeat.o(335923);
    return localc;
  }
  
  public final void bW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(335916);
    if ((s.p(this.mlM, paramString)) && (this.GuZ != paramBoolean))
    {
      this.GuZ = paramBoolean;
      fV(this.dyx);
    }
    AppMethodBeat.o(335916);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(335934);
    int i = this.ykw.size();
    AppMethodBeat.o(335934);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(335930);
    c localc = KX(paramInt);
    f.a locala = f.Gvd;
    if (s.p(localc, f.fjY()))
    {
      AppMethodBeat.o(335930);
      return 1;
    }
    AppMethodBeat.o(335930);
    return 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      localObject.setOnClickListener(new e.a..ExternalSyntheticLambda0(this, e.this));
    }
    
    private static final void a(a parama, e parame, View paramView)
    {
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(parame);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      s.u(parame, "this$1");
      int i = parama.KJ();
      parama = parame.KX(i);
      if (parama != null)
      {
        parame = parame.ykx;
        if (parame != null) {
          parame.invoke(Integer.valueOf(i), parama);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    }
    
    public void b(int paramInt, dhp paramdhp)
    {
      s.u(paramdhp, "info");
      paramdhp = this.caK;
      if (paramInt == e.a(e.this)) {}
      for (boolean bool = true;; bool = false)
      {
        paramdhp.setSelected(bool);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$DiffCallbackToAdapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "adapter", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "updateData", "lensList", "", "Lcom/tencent/mm/sticker/LensItem;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements d
  {
    private final e Gvb;
    
    public c(e parame)
    {
      AppMethodBeat.i(335921);
      this.Gvb = parame;
      AppMethodBeat.o(335921);
    }
    
    public final void bz(List<c> paramList)
    {
      AppMethodBeat.i(335928);
      s.u(paramList, "lensList");
      e locale = this.Gvb;
      s.u(paramList, "lensList");
      Log.i(locale.TAG, s.X("update: ", Integer.valueOf(paramList.size())));
      locale.ykw.clear();
      locale.ykw.addAll((Collection)paramList);
      AppMethodBeat.o(335928);
    }
    
    public final void gX(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(335933);
      this.Gvb.bA(paramInt1, paramInt2);
      AppMethodBeat.o(335933);
    }
    
    public final void gY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(335942);
      this.Gvb.bB(paramInt1, paramInt2);
      AppMethodBeat.o(335942);
    }
    
    public final void gZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(335947);
      this.Gvb.bz(paramInt1, paramInt2);
      AppMethodBeat.o(335947);
    }
    
    public final void ha(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(335954);
      this.Gvb.by(paramInt1, paramInt2);
      AppMethodBeat.o(335954);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends e.a
  {
    private final ImageView dpM;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(335914);
      this.dpM = ((ImageView)localObject.findViewById(l.e.finder_effect_sticker_item_icon));
      AppMethodBeat.o(335914);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "loadingBg", "getLoadingBg", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends e.a
  {
    private final View Gvc;
    private final ImageView dpM;
    private final View ylD;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(335911);
      this.dpM = ((ImageView)localObject.findViewById(l.e.finder_effect_sticker_item_icon));
      this.ylD = localObject.findViewById(l.e.finder_effect_sticker_item_loading);
      this.Gvc = localObject.findViewById(l.e.finder_effect_sticker_item_loading_bg);
      AppMethodBeat.o(335911);
    }
    
    public final void b(int paramInt, dhp paramdhp)
    {
      AppMethodBeat.i(335919);
      s.u(paramdhp, "info");
      super.b(paramInt, paramdhp);
      Object localObject = h.acCW;
      paramdhp = h.getLoader().dk(new com.tencent.mm.sticker.loader.a(paramdhp));
      localObject = this.dpM;
      s.s(localObject, "icon");
      paramdhp.d((ImageView)localObject);
      if ((paramInt == e.a(e.this)) && (e.b(e.this)))
      {
        this.ylD.setVisibility(0);
        this.Gvc.setVisibility(0);
        AppMethodBeat.o(335919);
        return;
      }
      this.ylD.setVisibility(8);
      this.Gvc.setVisibility(8);
      AppMethodBeat.o(335919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.e
 * JD-Core Version:    0.7.0.1
 */