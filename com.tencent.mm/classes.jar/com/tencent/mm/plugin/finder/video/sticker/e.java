package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.loader.h;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "()V", "TAG", "", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedId", "selectedLoading", "", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setLoading", "lensId", "isLoading", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "DiffCallbackToAdapter", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-finder_release"})
public final class e
  extends RecyclerView.a<a>
{
  public static final e.b tcu;
  final String TAG;
  String pYv;
  final ArrayList<c> qbF;
  m<? super Integer, ? super c, z> qbG;
  d.g.a.b<? super Integer, z> qbH;
  boolean tct;
  int uT;
  
  static
  {
    AppMethodBeat.i(205628);
    tcu = new e.b((byte)0);
    AppMethodBeat.o(205628);
  }
  
  public e()
  {
    AppMethodBeat.i(205627);
    this.TAG = "MicroMsg.StickerEffectAdapter";
    this.qbF = new ArrayList();
    AppMethodBeat.o(205627);
  }
  
  public final c CH(int paramInt)
  {
    AppMethodBeat.i(205622);
    c localc = (c)j.F((List)this.qbF, paramInt);
    AppMethodBeat.o(205622);
    return localc;
  }
  
  public final void bk(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205621);
    if ((p.i(this.pYv, paramString)) && (this.tct != paramBoolean))
    {
      this.tct = paramBoolean;
      cj(this.uT);
    }
    AppMethodBeat.o(205621);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(205625);
    int i = this.qbF.size();
    AppMethodBeat.o(205625);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(205623);
    c localc = CH(paramInt);
    f.a locala = f.tcC;
    if (p.i(localc, f.cPz()))
    {
      AppMethodBeat.o(205623);
      return 1;
    }
    AppMethodBeat.o(205623);
    return 0;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(205611);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          int i = this.tcw.lN();
          paramAnonymousView = this.tcw.tcv.CH(i);
          if (paramAnonymousView != null)
          {
            localObject = this.tcw.tcv.qbG;
            if (localObject != null) {
              ((m)localObject).p(Integer.valueOf(i), paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205611);
        }
      });
    }
    
    public void b(int paramInt, bus parambus)
    {
      p.h(parambus, "info");
      parambus = this.auu;
      p.g(parambus, "itemView");
      if (paramInt == e.a(e.this)) {}
      for (boolean bool = true;; bool = false)
      {
        parambus.setSelected(bool);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$DiffCallbackToAdapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "adapter", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "updateData", "lensList", "", "Lcom/tencent/mm/sticker/LensItem;", "plugin-finder_release"})
  public static final class c
    implements d
  {
    private final e tcx;
    
    public c(e parame)
    {
      AppMethodBeat.i(205617);
      this.tcx = parame;
      AppMethodBeat.o(205617);
    }
    
    public final void V(List<c> paramList)
    {
      AppMethodBeat.i(205612);
      p.h(paramList, "lensList");
      e locale = this.tcx;
      p.h(paramList, "lensList");
      ae.i(locale.TAG, "update: " + paramList.size());
      locale.qbF.clear();
      locale.qbF.addAll((Collection)paramList);
      AppMethodBeat.o(205612);
    }
    
    public final void fr(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205613);
      this.tcx.ar(paramInt1, paramInt2);
      AppMethodBeat.o(205613);
    }
    
    public final void fs(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205614);
      this.tcx.as(paramInt1, paramInt2);
      AppMethodBeat.o(205614);
    }
    
    public final void ft(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205615);
      this.tcx.aq(paramInt1, paramInt2);
      AppMethodBeat.o(205615);
    }
    
    public final void fu(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205616);
      this.tcx.ap(paramInt1, paramInt2);
      AppMethodBeat.o(205616);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "plugin-finder_release"})
  public final class d
    extends e.a
  {
    private final ImageView ka;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(205618);
      this.ka = ((ImageView)localObject.findViewById(2131307392));
      AppMethodBeat.o(205618);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "loadingBg", "getLoadingBg", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
  public final class e
    extends e.a
  {
    private final ImageView ka;
    private final View qcX;
    private final View tcy;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(205620);
      this.ka = ((ImageView)localObject.findViewById(2131307392));
      this.qcX = localObject.findViewById(2131307393);
      this.tcy = localObject.findViewById(2131307394);
      AppMethodBeat.o(205620);
    }
    
    public final void b(int paramInt, bus parambus)
    {
      AppMethodBeat.i(205619);
      p.h(parambus, "info");
      super.b(paramInt, parambus);
      Object localObject = h.IHc;
      parambus = h.getLoader().bI(new com.tencent.mm.sticker.loader.a(parambus));
      localObject = this.ka;
      p.g(localObject, "icon");
      parambus.c((ImageView)localObject);
      if ((paramInt == e.a(e.this)) && (e.b(e.this)))
      {
        parambus = this.qcX;
        p.g(parambus, "loading");
        parambus.setVisibility(0);
        parambus = this.tcy;
        p.g(parambus, "loadingBg");
        parambus.setVisibility(0);
        AppMethodBeat.o(205619);
        return;
      }
      parambus = this.qcX;
      p.g(parambus, "loading");
      parambus.setVisibility(8);
      parambus = this.tcy;
      p.g(parambus, "loadingBg");
      parambus.setVisibility(8);
      AppMethodBeat.o(205619);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.e
 * JD-Core Version:    0.7.0.1
 */