package com.tencent.mm.plugin.emojicapture.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.emojicapture.model.a.g.a;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sticker.loader.a;
import com.tencent.mm.sticker.loader.h;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EmptyStickerViewHolder", "MoreStickerViewHolder", "StickerViewHolder", "plugin-emojicapture_release"})
public final class b
  extends RecyclerView.a<a>
{
  public static final String TAG = "MicroMsg.StickerAdapter";
  public static final b oOh;
  public final ArrayList<com.tencent.mm.sticker.g> oOa;
  public m<? super Integer, ? super com.tencent.mm.sticker.g, y> oOb;
  public int rZ;
  
  static
  {
    AppMethodBeat.i(564);
    oOh = new b((byte)0);
    TAG = "MicroMsg.StickerAdapter";
    AppMethodBeat.o(564);
  }
  
  public b()
  {
    AppMethodBeat.i(563);
    this.oOa = new ArrayList();
    this.rZ = -1;
    AppMethodBeat.o(563);
  }
  
  public final com.tencent.mm.sticker.g agQ(int paramInt)
  {
    AppMethodBeat.i(205001);
    com.tencent.mm.sticker.g localg = (com.tencent.mm.sticker.g)j.C((List)this.oOa, paramInt);
    AppMethodBeat.o(205001);
    return localg;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(559);
    int i = this.oOa.size();
    AppMethodBeat.o(559);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(560);
    Object localObject = agQ(paramInt);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.sticker.g)localObject).oKq;; localObject = null)
    {
      locala = com.tencent.mm.plugin.emojicapture.model.a.g.oKV;
      if (!k.g(localObject, com.tencent.mm.plugin.emojicapture.model.a.g.bYg())) {
        break;
      }
      AppMethodBeat.o(560);
      return 1;
    }
    g.a locala = com.tencent.mm.plugin.emojicapture.model.a.g.oKV;
    if (!k.g(localObject, com.tencent.mm.plugin.emojicapture.model.a.g.bYi()))
    {
      locala = com.tencent.mm.plugin.emojicapture.model.a.g.oKV;
      if (!k.g(localObject, com.tencent.mm.plugin.emojicapture.model.a.g.bYh())) {}
    }
    else
    {
      AppMethodBeat.o(560);
      return 2;
    }
    AppMethodBeat.o(560);
    return 0;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public abstract class a
    extends RecyclerView.v
  {
    final ImageView hg;
    final TextView iwR;
    
    public a()
    {
      super();
      this.hg = ((ImageView)localObject.findViewById(2131299351));
      this.iwR = ((TextView)localObject.findViewById(2131299352));
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(551);
          int i = this.oOj.ln();
          paramAnonymousView = this.oOj.oOi.agQ(i);
          if (paramAnonymousView != null)
          {
            m localm = this.oOj.oOi.oOb;
            if (localm != null) {
              localm.n(Integer.valueOf(i), paramAnonymousView);
            }
          }
          localObject.requestFocus();
          AppMethodBeat.o(551);
        }
      });
    }
    
    public abstract void c(blp paramblp);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$Companion;", "", "()V", "TAG", "", "ViewTypeEmpty", "", "ViewTypeMore", "ViewTypeNormal", "plugin-emojicapture_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class c
    extends b.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(553);
      AppMethodBeat.o(553);
    }
    
    public final void c(blp paramblp)
    {
      AppMethodBeat.i(552);
      k.h(paramblp, "info");
      paramblp = this.hg;
      k.g(paramblp, "icon");
      Object localObject = this.hg;
      k.g(localObject, "icon");
      localObject = ((ImageView)localObject).getContext();
      k.g(localObject, "icon.context");
      c.a(paramblp, 2131690610, ((Context)localObject).getResources().getColor(2131099732));
      this.iwR.setText(2131758231);
      AppMethodBeat.o(552);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$MoreStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class d
    extends b.a
  {
    public d()
    {
      super(localObject);
      AppMethodBeat.i(555);
      AppMethodBeat.o(555);
    }
    
    public final void c(blp paramblp)
    {
      AppMethodBeat.i(554);
      k.h(paramblp, "info");
      Object localObject = com.tencent.mm.plugin.emojicapture.model.a.g.oKV;
      if (k.g(paramblp, com.tencent.mm.plugin.emojicapture.model.a.g.bYi()))
      {
        paramblp = this.arI;
        k.g(paramblp, "itemView");
        paramblp.setVisibility(4);
        AppMethodBeat.o(554);
        return;
      }
      paramblp = this.arI;
      k.g(paramblp, "itemView");
      paramblp.setVisibility(0);
      paramblp = this.hg;
      k.g(paramblp, "icon");
      localObject = this.hg;
      k.g(localObject, "icon");
      localObject = ((ImageView)localObject).getContext();
      k.g(localObject, "icon.context");
      c.a(paramblp, 2131690436, ((Context)localObject).getResources().getColor(2131099732));
      this.iwR.setText(2131758230);
      AppMethodBeat.o(554);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class e
    extends b.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(557);
      AppMethodBeat.o(557);
    }
    
    public final void c(blp paramblp)
    {
      AppMethodBeat.i(556);
      k.h(paramblp, "info");
      Object localObject = h.Fdw;
      localObject = h.getLoader().bI(new a(paramblp));
      ImageView localImageView = this.hg;
      k.g(localImageView, "icon");
      ((com.tencent.mm.loader.a.b)localObject).c(localImageView);
      localObject = this.iwR;
      k.g(localObject, "text");
      ((TextView)localObject).setText((CharSequence)paramblp.Name);
      AppMethodBeat.o(556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.b
 * JD-Core Version:    0.7.0.1
 */