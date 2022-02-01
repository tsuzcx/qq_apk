package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.loader.a;
import com.tencent.mm.sticker.loader.h;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "()V", "TAG", "", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedId", "selectedLoading", "", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setLoading", "lensId", "isLoading", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "DiffCallbackToAdapter", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-finder_release"})
public final class e
  extends RecyclerView.a<a>
{
  public static final e.b rUB;
  final String TAG;
  String poq;
  final ArrayList<c> pru;
  m<? super Integer, ? super c, y> prv;
  d.g.a.b<? super Integer, y> prw;
  boolean rUA;
  int ta;
  
  static
  {
    AppMethodBeat.i(204050);
    rUB = new e.b((byte)0);
    AppMethodBeat.o(204050);
  }
  
  public e()
  {
    AppMethodBeat.i(204049);
    this.TAG = "MicroMsg.StickerEffectAdapter";
    this.pru = new ArrayList();
    AppMethodBeat.o(204049);
  }
  
  public final c BN(int paramInt)
  {
    AppMethodBeat.i(204044);
    c localc = (c)j.C((List)this.pru, paramInt);
    AppMethodBeat.o(204044);
    return localc;
  }
  
  public final void bc(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(204043);
    if ((k.g(this.poq, paramString)) && (this.rUA != paramBoolean))
    {
      this.rUA = paramBoolean;
      cj(this.ta);
    }
    AppMethodBeat.o(204043);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(204047);
    int i = this.pru.size();
    AppMethodBeat.o(204047);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(204045);
    c localc = BN(paramInt);
    f.a locala = f.rUJ;
    if (k.g(localc, f.cEx()))
    {
      AppMethodBeat.o(204045);
      return 1;
    }
    AppMethodBeat.o(204045);
    return 0;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
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
          AppMethodBeat.i(204033);
          int i = this.rUD.lv();
          paramAnonymousView = this.rUD.rUC.BN(i);
          if (paramAnonymousView != null)
          {
            m localm = this.rUD.rUC.prv;
            if (localm != null)
            {
              localm.n(Integer.valueOf(i), paramAnonymousView);
              AppMethodBeat.o(204033);
              return;
            }
            AppMethodBeat.o(204033);
            return;
          }
          AppMethodBeat.o(204033);
        }
      });
    }
    
    public void b(int paramInt, bpl parambpl)
    {
      k.h(parambpl, "info");
      parambpl = this.asD;
      k.g(parambpl, "itemView");
      if (paramInt == e.a(e.this)) {}
      for (boolean bool = true;; bool = false)
      {
        parambpl.setSelected(bool);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$DiffCallbackToAdapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "adapter", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "updateData", "lensList", "", "Lcom/tencent/mm/sticker/LensItem;", "plugin-finder_release"})
  public static final class c
    implements d
  {
    private final e rUE;
    
    public c(e parame)
    {
      AppMethodBeat.i(204039);
      this.rUE = parame;
      AppMethodBeat.o(204039);
    }
    
    public final void U(List<c> paramList)
    {
      AppMethodBeat.i(204034);
      k.h(paramList, "lensList");
      e locale = this.rUE;
      k.h(paramList, "lensList");
      ac.i(locale.TAG, "update: " + paramList.size());
      locale.pru.clear();
      locale.pru.addAll((Collection)paramList);
      AppMethodBeat.o(204034);
    }
    
    public final void fm(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204035);
      this.rUE.aq(paramInt1, paramInt2);
      AppMethodBeat.o(204035);
    }
    
    public final void fn(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204036);
      this.rUE.ar(paramInt1, paramInt2);
      AppMethodBeat.o(204036);
    }
    
    public final void fo(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204037);
      this.rUE.ap(paramInt1, paramInt2);
      AppMethodBeat.o(204037);
    }
    
    public final void fp(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204038);
      this.rUE.ao(paramInt1, paramInt2);
      AppMethodBeat.o(204038);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "plugin-finder_release"})
  public final class d
    extends e.a
  {
    private final ImageView ig;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(204040);
      this.ig = ((ImageView)localObject.findViewById(2131307392));
      AppMethodBeat.o(204040);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "loadingBg", "getLoadingBg", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
  public final class e
    extends e.a
  {
    private final ImageView ig;
    private final View psM;
    private final View rUF;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(204042);
      this.ig = ((ImageView)localObject.findViewById(2131307392));
      this.psM = localObject.findViewById(2131307393);
      this.rUF = localObject.findViewById(2131307394);
      AppMethodBeat.o(204042);
    }
    
    public final void b(int paramInt, bpl parambpl)
    {
      AppMethodBeat.i(204041);
      k.h(parambpl, "info");
      super.b(paramInt, parambpl);
      Object localObject = h.GAX;
      parambpl = h.getLoader().bG(new a(parambpl));
      localObject = this.ig;
      k.g(localObject, "icon");
      parambpl.c((ImageView)localObject);
      if ((paramInt == e.a(e.this)) && (e.b(e.this)))
      {
        parambpl = this.psM;
        k.g(parambpl, "loading");
        parambpl.setVisibility(0);
        parambpl = this.rUF;
        k.g(parambpl, "loadingBg");
        parambpl.setVisibility(0);
        AppMethodBeat.o(204041);
        return;
      }
      parambpl = this.psM;
      k.g(parambpl, "loading");
      parambpl.setVisibility(8);
      parambpl = this.rUF;
      k.g(parambpl, "loadingBg");
      parambpl.setVisibility(8);
      AppMethodBeat.o(204041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.e
 * JD-Core Version:    0.7.0.1
 */