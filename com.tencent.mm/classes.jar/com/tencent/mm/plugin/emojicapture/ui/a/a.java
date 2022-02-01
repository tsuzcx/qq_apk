package com.tencent.mm.plugin.emojicapture.ui.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.emojicapture.model.a.g.a;
import com.tencent.mm.plugin.emojicapture.ui.capture.StickerSelectFrame;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sticker.loader.h;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EndViewHolder", "StickerViewHolder", "TitleViewHolder", "plugin-emojicapture_release"})
public final class a
  extends RecyclerView.a<a>
{
  public static final String TAG = "MicroMsg.MoreStickerAdapter";
  public static final b oOd;
  public final ArrayList<com.tencent.mm.sticker.g> oOa;
  public m<? super Integer, ? super com.tencent.mm.sticker.g, y> oOb;
  public d.g.a.b<? super Integer, y> oOc;
  private int rZ;
  
  static
  {
    AppMethodBeat.i(550);
    oOd = new b((byte)0);
    TAG = "MicroMsg.MoreStickerAdapter";
    AppMethodBeat.o(550);
  }
  
  public a()
  {
    AppMethodBeat.i(549);
    this.oOa = new ArrayList();
    this.rZ = -1;
    AppMethodBeat.o(549);
  }
  
  public final com.tencent.mm.sticker.g agQ(int paramInt)
  {
    AppMethodBeat.i(205000);
    com.tencent.mm.sticker.g localg = (com.tencent.mm.sticker.g)j.C((List)this.oOa, paramInt);
    AppMethodBeat.o(205000);
    return localg;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(545);
    int i = this.oOa.size();
    AppMethodBeat.o(545);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(546);
    Object localObject = agQ(paramInt);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.sticker.g)localObject).oKq;; localObject = null)
    {
      locala = com.tencent.mm.plugin.emojicapture.model.a.g.oKV;
      if (!k.g(localObject, com.tencent.mm.plugin.emojicapture.model.a.g.bYj()))
      {
        locala = com.tencent.mm.plugin.emojicapture.model.a.g.oKV;
        if (!k.g(localObject, com.tencent.mm.plugin.emojicapture.model.a.g.bYl())) {
          break;
        }
      }
      AppMethodBeat.o(546);
      return 1;
    }
    g.a locala = com.tencent.mm.plugin.emojicapture.model.a.g.oKV;
    if (k.g(localObject, com.tencent.mm.plugin.emojicapture.model.a.g.bYk()))
    {
      AppMethodBeat.o(546);
      return 2;
    }
    AppMethodBeat.o(546);
    return 0;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(543);
    if (this.rZ != paramInt)
    {
      ck(this.rZ);
      this.rZ = paramInt;
      ck(this.rZ);
    }
    AppMethodBeat.o(543);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public abstract void c(blp paramblp);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$Companion;", "", "()V", "TAG", "", "ViewTypeEnd", "", "ViewTypeNormal", "ViewTypeTitle", "plugin-emojicapture_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$EndViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class c
    extends a.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(537);
      AppMethodBeat.o(537);
    }
    
    public final void c(blp paramblp)
    {
      AppMethodBeat.i(536);
      k.h(paramblp, "info");
      AppMethodBeat.o(536);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "frame", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "kotlin.jvm.PlatformType", "getFrame", "()Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class d
    extends a.a
  {
    private final ImageView hg;
    private final TextView iwR;
    private final StickerSelectFrame oOf;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(540);
      this.hg = ((ImageView)localObject.findViewById(2131299351));
      this.iwR = ((TextView)localObject.findViewById(2131299352));
      this.oOf = ((StickerSelectFrame)localObject.findViewById(2131299357));
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(538);
          int i = this.oOg.ln();
          paramAnonymousView = this.oOg.oOe.agQ(i);
          if (paramAnonymousView != null)
          {
            m localm = this.oOg.oOe.oOb;
            if (localm != null)
            {
              localm.n(Integer.valueOf(i), paramAnonymousView);
              AppMethodBeat.o(538);
              return;
            }
            AppMethodBeat.o(538);
            return;
          }
          AppMethodBeat.o(538);
        }
      });
      AppMethodBeat.o(540);
    }
    
    public final void c(blp paramblp)
    {
      AppMethodBeat.i(539);
      k.h(paramblp, "info");
      Object localObject = h.Fdw;
      localObject = h.getLoader().bI(new com.tencent.mm.sticker.loader.a(paramblp));
      ImageView localImageView = this.hg;
      k.g(localImageView, "icon");
      ((com.tencent.mm.loader.a.b)localObject).c(localImageView);
      localObject = this.iwR;
      k.g(localObject, "text");
      ((TextView)localObject).setText((CharSequence)paramblp.Name);
      this.oOf.Uy(paramblp.Dds);
      AppMethodBeat.o(539);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$TitleViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class e
    extends a.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(542);
      AppMethodBeat.o(542);
    }
    
    public final void c(blp paramblp)
    {
      AppMethodBeat.i(541);
      k.h(paramblp, "info");
      TextView localTextView = (TextView)this.arI.findViewById(2131299352);
      g.a locala = com.tencent.mm.plugin.emojicapture.model.a.g.oKV;
      if (k.g(paramblp, com.tencent.mm.plugin.emojicapture.model.a.g.bYj()))
      {
        localTextView.setText(2131758229);
        AppMethodBeat.o(541);
        return;
      }
      locala = com.tencent.mm.plugin.emojicapture.model.a.g.oKV;
      if (k.g(paramblp, com.tencent.mm.plugin.emojicapture.model.a.g.bYl())) {
        localTextView.setText(2131758232);
      }
      AppMethodBeat.o(541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.a
 * JD-Core Version:    0.7.0.1
 */