package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sticker.g;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "()V", "TAG", "", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedId", "selectedLoading", "", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setLoading", "lensId", "isLoading", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "DiffCallbackToAdapter", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-finder_release"})
public final class e
  extends RecyclerView.a<a>
{
  public static final b LdJ;
  boolean LdI;
  final String TAG;
  String oKX;
  final ArrayList<g> oOa;
  m<? super Integer, ? super g, y> oOb;
  d.g.a.b<? super Integer, y> oOc;
  int rZ;
  
  static
  {
    AppMethodBeat.i(199982);
    LdJ = new b((byte)0);
    AppMethodBeat.o(199982);
  }
  
  public e()
  {
    AppMethodBeat.i(199981);
    this.TAG = "MicroMsg.StickerEffectAdapter";
    this.oOa = new ArrayList();
    AppMethodBeat.o(199981);
  }
  
  public final g agQ(int paramInt)
  {
    AppMethodBeat.i(199976);
    g localg = (g)j.C((List)this.oOa, paramInt);
    AppMethodBeat.o(199976);
    return localg;
  }
  
  public final void jdMethod_do(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(199975);
    if ((k.g(this.oKX, paramString)) && (this.LdI != paramBoolean))
    {
      this.LdI = paramBoolean;
      ck(this.rZ);
    }
    AppMethodBeat.o(199975);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(199979);
    int i = this.oOa.size();
    AppMethodBeat.o(199979);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(199977);
    g localg = agQ(paramInt);
    f.a locala = f.LdR;
    if (k.g(localg, f.fWF()))
    {
      AppMethodBeat.o(199977);
      return 1;
    }
    AppMethodBeat.o(199977);
    return 0;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
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
          AppMethodBeat.i(199965);
          int i = this.LdL.ln();
          paramAnonymousView = this.LdL.LdK.agQ(i);
          if (paramAnonymousView != null)
          {
            m localm = this.LdL.LdK.oOb;
            if (localm != null)
            {
              localm.n(Integer.valueOf(i), paramAnonymousView);
              AppMethodBeat.o(199965);
              return;
            }
            AppMethodBeat.o(199965);
            return;
          }
          AppMethodBeat.o(199965);
        }
      });
    }
    
    public void b(int paramInt, blp paramblp)
    {
      k.h(paramblp, "info");
      paramblp = this.arI;
      k.g(paramblp, "itemView");
      if (paramInt == e.a(e.this)) {}
      for (boolean bool = true;; bool = false)
      {
        paramblp.setSelected(bool);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$Companion;", "", "()V", "ViewTypeEmpty", "", "ViewTypeNormal", "plugin-finder_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$DiffCallbackToAdapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "adapter", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "updateData", "lensList", "", "Lcom/tencent/mm/sticker/LensItem;", "plugin-finder_release"})
  public static final class c
    implements d
  {
    private final e LdM;
    
    public c(e parame)
    {
      AppMethodBeat.i(199971);
      this.LdM = parame;
      AppMethodBeat.o(199971);
    }
    
    public final void ad(List<g> paramList)
    {
      AppMethodBeat.i(199966);
      k.h(paramList, "lensList");
      e locale = this.LdM;
      k.h(paramList, "lensList");
      ad.i(locale.TAG, "update: " + paramList.size());
      locale.oOa.clear();
      locale.oOa.addAll((Collection)paramList);
      AppMethodBeat.o(199966);
    }
    
    public final void fj(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199967);
      this.LdM.aq(paramInt1, paramInt2);
      AppMethodBeat.o(199967);
    }
    
    public final void fk(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199968);
      this.LdM.ar(paramInt1, paramInt2);
      AppMethodBeat.o(199968);
    }
    
    public final void fl(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199969);
      this.LdM.ap(paramInt1, paramInt2);
      AppMethodBeat.o(199969);
    }
    
    public final void fm(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199970);
      this.LdM.ao(paramInt1, paramInt2);
      AppMethodBeat.o(199970);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "plugin-finder_release"})
  public final class d
    extends e.a
  {
    private final ImageView hg;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(199972);
      this.hg = ((ImageView)localObject.findViewById(2131307323));
      AppMethodBeat.o(199972);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "loadingBg", "getLoadingBg", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
  public final class e
    extends e.a
  {
    private final View LdN;
    private final ImageView hg;
    private final View oPA;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(199974);
      this.hg = ((ImageView)localObject.findViewById(2131307323));
      this.oPA = localObject.findViewById(2131307324);
      this.LdN = localObject.findViewById(2131307325);
      AppMethodBeat.o(199974);
    }
    
    public final void b(int paramInt, blp paramblp)
    {
      AppMethodBeat.i(199973);
      k.h(paramblp, "info");
      super.b(paramInt, paramblp);
      Object localObject = h.Fdw;
      paramblp = h.getLoader().bI(new a(paramblp));
      localObject = this.hg;
      k.g(localObject, "icon");
      paramblp.c((ImageView)localObject);
      if ((paramInt == e.a(e.this)) && (e.b(e.this)))
      {
        paramblp = this.oPA;
        k.g(paramblp, "loading");
        paramblp.setVisibility(0);
        paramblp = this.LdN;
        k.g(paramblp, "loadingBg");
        paramblp.setVisibility(0);
        AppMethodBeat.o(199973);
        return;
      }
      paramblp = this.oPA;
      k.g(paramblp, "loading");
      paramblp.setVisibility(8);
      paramblp = this.LdN;
      k.g(paramblp, "loadingBg");
      paramblp.setVisibility(8);
      AppMethodBeat.o(199973);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.e
 * JD-Core Version:    0.7.0.1
 */