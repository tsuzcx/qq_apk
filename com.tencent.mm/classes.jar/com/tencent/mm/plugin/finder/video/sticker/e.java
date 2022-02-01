package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "()V", "TAG", "", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedId", "selectedLoading", "", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setLoading", "lensId", "isLoading", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "DiffCallbackToAdapter", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-finder_release"})
public final class e
  extends RecyclerView.a<a>
{
  public static final e.b sRj;
  final String TAG;
  String pRQ;
  final ArrayList<c> pVa;
  m<? super Integer, ? super c, z> pVb;
  d.g.a.b<? super Integer, z> pVc;
  boolean sRi;
  int uT;
  
  static
  {
    AppMethodBeat.i(205003);
    sRj = new e.b((byte)0);
    AppMethodBeat.o(205003);
  }
  
  public e()
  {
    AppMethodBeat.i(205002);
    this.TAG = "MicroMsg.StickerEffectAdapter";
    this.pVa = new ArrayList();
    AppMethodBeat.o(205002);
  }
  
  public final c Cv(int paramInt)
  {
    AppMethodBeat.i(204997);
    c localc = (c)j.E((List)this.pVa, paramInt);
    AppMethodBeat.o(204997);
    return localc;
  }
  
  public final void bh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(204996);
    if ((p.i(this.pRQ, paramString)) && (this.sRi != paramBoolean))
    {
      this.sRi = paramBoolean;
      cj(this.uT);
    }
    AppMethodBeat.o(204996);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(205000);
    int i = this.pVa.size();
    AppMethodBeat.o(205000);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(204998);
    c localc = Cv(paramInt);
    f.a locala = f.sRr;
    if (p.i(localc, f.cMQ()))
    {
      AppMethodBeat.o(204998);
      return 1;
    }
    AppMethodBeat.o(204998);
    return 0;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
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
          AppMethodBeat.i(204986);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          int i = this.sRl.lN();
          paramAnonymousView = this.sRl.sRk.Cv(i);
          if (paramAnonymousView != null)
          {
            localObject = this.sRl.sRk.pVb;
            if (localObject != null) {
              ((m)localObject).p(Integer.valueOf(i), paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(204986);
        }
      });
    }
    
    public void b(int paramInt, bty parambty)
    {
      p.h(parambty, "info");
      parambty = this.auu;
      p.g(parambty, "itemView");
      if (paramInt == e.a(e.this)) {}
      for (boolean bool = true;; bool = false)
      {
        parambty.setSelected(bool);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$DiffCallbackToAdapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "adapter", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "updateData", "lensList", "", "Lcom/tencent/mm/sticker/LensItem;", "plugin-finder_release"})
  public static final class c
    implements d
  {
    private final e sRm;
    
    public c(e parame)
    {
      AppMethodBeat.i(204992);
      this.sRm = parame;
      AppMethodBeat.o(204992);
    }
    
    public final void V(List<c> paramList)
    {
      AppMethodBeat.i(204987);
      p.h(paramList, "lensList");
      e locale = this.sRm;
      p.h(paramList, "lensList");
      ad.i(locale.TAG, "update: " + paramList.size());
      locale.pVa.clear();
      locale.pVa.addAll((Collection)paramList);
      AppMethodBeat.o(204987);
    }
    
    public final void fq(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204988);
      this.sRm.ar(paramInt1, paramInt2);
      AppMethodBeat.o(204988);
    }
    
    public final void fr(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204989);
      this.sRm.as(paramInt1, paramInt2);
      AppMethodBeat.o(204989);
    }
    
    public final void fs(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204990);
      this.sRm.aq(paramInt1, paramInt2);
      AppMethodBeat.o(204990);
    }
    
    public final void ft(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204991);
      this.sRm.ap(paramInt1, paramInt2);
      AppMethodBeat.o(204991);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "plugin-finder_release"})
  public final class d
    extends e.a
  {
    private final ImageView ka;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(204993);
      this.ka = ((ImageView)localObject.findViewById(2131307392));
      AppMethodBeat.o(204993);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "loadingBg", "getLoadingBg", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
  public final class e
    extends e.a
  {
    private final ImageView ka;
    private final View pWs;
    private final View sRn;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(204995);
      this.ka = ((ImageView)localObject.findViewById(2131307392));
      this.pWs = localObject.findViewById(2131307393);
      this.sRn = localObject.findViewById(2131307394);
      AppMethodBeat.o(204995);
    }
    
    public final void b(int paramInt, bty parambty)
    {
      AppMethodBeat.i(204994);
      p.h(parambty, "info");
      super.b(paramInt, parambty);
      Object localObject = h.ImR;
      parambty = h.getLoader().bI(new com.tencent.mm.sticker.loader.a(parambty));
      localObject = this.ka;
      p.g(localObject, "icon");
      parambty.c((ImageView)localObject);
      if ((paramInt == e.a(e.this)) && (e.b(e.this)))
      {
        parambty = this.pWs;
        p.g(parambty, "loading");
        parambty.setVisibility(0);
        parambty = this.sRn;
        p.g(parambty, "loadingBg");
        parambty.setVisibility(0);
        AppMethodBeat.o(204994);
        return;
      }
      parambty = this.pWs;
      p.g(parambty, "loading");
      parambty.setVisibility(8);
      parambty = this.sRn;
      p.g(parambty, "loadingBg");
      parambty.setVisibility(8);
      AppMethodBeat.o(204994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.e
 * JD-Core Version:    0.7.0.1
 */