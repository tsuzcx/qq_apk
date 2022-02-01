package com.tencent.mm.plugin.emojicapture.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.emojicapture.model.a.f;
import com.tencent.mm.plugin.emojicapture.model.a.f.a;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sticker.loader.a;
import com.tencent.mm.sticker.loader.h;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EmptyStickerViewHolder", "MoreStickerViewHolder", "StickerViewHolder", "plugin-emojicapture_release"})
public final class b
  extends RecyclerView.a<a>
{
  public static final String TAG = "MicroMsg.StickerAdapter";
  public static final b.b prB;
  public final ArrayList<com.tencent.mm.sticker.c> pru;
  public m<? super Integer, ? super com.tencent.mm.sticker.c, y> prv;
  public int ta;
  
  static
  {
    AppMethodBeat.i(564);
    prB = new b.b((byte)0);
    TAG = "MicroMsg.StickerAdapter";
    AppMethodBeat.o(564);
  }
  
  public b()
  {
    AppMethodBeat.i(563);
    this.pru = new ArrayList();
    this.ta = -1;
    AppMethodBeat.o(563);
  }
  
  public final com.tencent.mm.sticker.c BN(int paramInt)
  {
    AppMethodBeat.i(195161);
    com.tencent.mm.sticker.c localc = (com.tencent.mm.sticker.c)j.C((List)this.pru, paramInt);
    AppMethodBeat.o(195161);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(559);
    int i = this.pru.size();
    AppMethodBeat.o(559);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(560);
    Object localObject = BN(paramInt);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.sticker.c)localObject).GzM;; localObject = null)
    {
      locala = f.poo;
      if (!k.g(localObject, f.cft())) {
        break;
      }
      AppMethodBeat.o(560);
      return 1;
    }
    f.a locala = f.poo;
    if (!k.g(localObject, f.cfv()))
    {
      locala = f.poo;
      if (!k.g(localObject, f.cfu())) {}
    }
    else
    {
      AppMethodBeat.o(560);
      return 2;
    }
    AppMethodBeat.o(560);
    return 0;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public abstract class a
    extends RecyclerView.w
  {
    final TextView iWU;
    final ImageView ig;
    
    public a()
    {
      super();
      this.ig = ((ImageView)localObject.findViewById(2131299351));
      this.iWU = ((TextView)localObject.findViewById(2131299352));
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(551);
          int i = this.prD.lv();
          paramAnonymousView = this.prD.prC.BN(i);
          if (paramAnonymousView != null)
          {
            m localm = this.prD.prC.prv;
            if (localm != null) {
              localm.n(Integer.valueOf(i), paramAnonymousView);
            }
          }
          localObject.requestFocus();
          AppMethodBeat.o(551);
        }
      });
    }
    
    public abstract void c(bpl parambpl);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class c
    extends b.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(553);
      AppMethodBeat.o(553);
    }
    
    public final void c(bpl parambpl)
    {
      AppMethodBeat.i(552);
      k.h(parambpl, "info");
      parambpl = this.ig;
      k.g(parambpl, "icon");
      Object localObject = this.ig;
      k.g(localObject, "icon");
      localObject = ((ImageView)localObject).getContext();
      k.g(localObject, "icon.context");
      com.tencent.mm.plugin.emojicapture.ui.c.a(parambpl, 2131690610, ((Context)localObject).getResources().getColor(2131099732));
      this.iWU.setText(2131758231);
      AppMethodBeat.o(552);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$MoreStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class d
    extends b.a
  {
    public d()
    {
      super(localObject);
      AppMethodBeat.i(555);
      AppMethodBeat.o(555);
    }
    
    public final void c(bpl parambpl)
    {
      AppMethodBeat.i(554);
      k.h(parambpl, "info");
      Object localObject = f.poo;
      if (k.g(parambpl, f.cfv()))
      {
        parambpl = this.asD;
        k.g(parambpl, "itemView");
        parambpl.setVisibility(4);
        AppMethodBeat.o(554);
        return;
      }
      parambpl = this.asD;
      k.g(parambpl, "itemView");
      parambpl.setVisibility(0);
      parambpl = this.ig;
      k.g(parambpl, "icon");
      localObject = this.ig;
      k.g(localObject, "icon");
      localObject = ((ImageView)localObject).getContext();
      k.g(localObject, "icon.context");
      com.tencent.mm.plugin.emojicapture.ui.c.a(parambpl, 2131690436, ((Context)localObject).getResources().getColor(2131099732));
      this.iWU.setText(2131758230);
      AppMethodBeat.o(554);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class e
    extends b.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(557);
      AppMethodBeat.o(557);
    }
    
    public final void c(bpl parambpl)
    {
      AppMethodBeat.i(556);
      k.h(parambpl, "info");
      Object localObject = h.GAX;
      localObject = h.getLoader().bG(new a(parambpl));
      ImageView localImageView = this.ig;
      k.g(localImageView, "icon");
      ((com.tencent.mm.loader.a.b)localObject).c(localImageView);
      localObject = this.iWU;
      k.g(localObject, "text");
      ((TextView)localObject).setText((CharSequence)parambpl.Name);
      AppMethodBeat.o(556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.b
 * JD-Core Version:    0.7.0.1
 */