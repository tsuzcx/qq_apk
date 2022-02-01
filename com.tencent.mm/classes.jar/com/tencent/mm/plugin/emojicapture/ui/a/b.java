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
import com.tencent.mm.plugin.emojicapture.model.a.f;
import com.tencent.mm.plugin.emojicapture.model.a.f.a;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sticker.loader.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EmptyStickerViewHolder", "MoreStickerViewHolder", "StickerViewHolder", "plugin-emojicapture_release"})
public final class b
  extends RecyclerView.a<a>
{
  public static final String TAG = "MicroMsg.StickerAdapter";
  public static final b.b rsJ;
  public final ArrayList<com.tencent.mm.sticker.c> rsC;
  public m<? super Integer, ? super com.tencent.mm.sticker.c, x> rsD;
  public int va;
  
  static
  {
    AppMethodBeat.i(564);
    rsJ = new b.b((byte)0);
    TAG = "MicroMsg.StickerAdapter";
    AppMethodBeat.o(564);
  }
  
  public b()
  {
    AppMethodBeat.i(563);
    this.rsC = new ArrayList();
    this.va = -1;
    AppMethodBeat.o(563);
  }
  
  public final com.tencent.mm.sticker.c Gs(int paramInt)
  {
    AppMethodBeat.i(256438);
    com.tencent.mm.sticker.c localc = (com.tencent.mm.sticker.c)j.L((List)this.rsC, paramInt);
    AppMethodBeat.o(256438);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(559);
    int i = this.rsC.size();
    AppMethodBeat.o(559);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(560);
    Object localObject = Gs(paramInt);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.sticker.c)localObject).NMJ;; localObject = null)
    {
      locala = f.rpr;
      if (!p.j(localObject, f.cJo())) {
        break;
      }
      AppMethodBeat.o(560);
      return 1;
    }
    f.a locala = f.rpr;
    if (!p.j(localObject, f.cJq()))
    {
      locala = f.rpr;
      if (!p.j(localObject, f.cJp())) {}
    }
    else
    {
      AppMethodBeat.o(560);
      return 2;
    }
    AppMethodBeat.o(560);
    return 0;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public abstract class a
    extends RecyclerView.v
  {
    final ImageView kc;
    final TextView krl;
    
    public a()
    {
      super();
      this.kc = ((ImageView)localObject.findViewById(2131299963));
      this.krl = ((TextView)localObject.findViewById(2131299964));
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(551);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          int i = this.rsL.lR();
          paramAnonymousView = this.rsL.rsK.Gs(i);
          if (paramAnonymousView != null)
          {
            localObject = this.rsL.rsK.rsD;
            if (localObject != null) {
              ((m)localObject).invoke(Integer.valueOf(i), paramAnonymousView);
            }
          }
          localObject.requestFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(551);
        }
      });
    }
    
    public abstract void c(chz paramchz);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class c
    extends b.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(553);
      AppMethodBeat.o(553);
    }
    
    public final void c(chz paramchz)
    {
      AppMethodBeat.i(552);
      p.h(paramchz, "info");
      paramchz = this.kc;
      p.g(paramchz, "icon");
      Object localObject = this.kc;
      p.g(localObject, "icon");
      localObject = ((ImageView)localObject).getContext();
      p.g(localObject, "icon.context");
      com.tencent.mm.plugin.emojicapture.ui.c.a(paramchz, 2131690854, ((Context)localObject).getResources().getColor(2131099746));
      this.krl.setText(2131758519);
      AppMethodBeat.o(552);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$MoreStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class d
    extends b.a
  {
    public d()
    {
      super(localObject);
      AppMethodBeat.i(555);
      AppMethodBeat.o(555);
    }
    
    public final void c(chz paramchz)
    {
      AppMethodBeat.i(554);
      p.h(paramchz, "info");
      Object localObject = f.rpr;
      if (p.j(paramchz, f.cJq()))
      {
        paramchz = this.aus;
        p.g(paramchz, "itemView");
        paramchz.setVisibility(4);
        AppMethodBeat.o(554);
        return;
      }
      paramchz = this.aus;
      p.g(paramchz, "itemView");
      paramchz.setVisibility(0);
      paramchz = this.kc;
      p.g(paramchz, "icon");
      localObject = this.kc;
      p.g(localObject, "icon");
      localObject = ((ImageView)localObject).getContext();
      p.g(localObject, "icon.context");
      com.tencent.mm.plugin.emojicapture.ui.c.a(paramchz, 2131690612, ((Context)localObject).getResources().getColor(2131099746));
      this.krl.setText(2131758518);
      AppMethodBeat.o(554);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class e
    extends b.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(557);
      AppMethodBeat.o(557);
    }
    
    public final void c(chz paramchz)
    {
      AppMethodBeat.i(556);
      p.h(paramchz, "info");
      Object localObject = h.NNV;
      localObject = h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(paramchz));
      ImageView localImageView = this.kc;
      p.g(localImageView, "icon");
      ((com.tencent.mm.loader.a.b)localObject).c(localImageView);
      localObject = this.krl;
      p.g(localObject, "text");
      ((TextView)localObject).setText((CharSequence)paramchz.Name);
      AppMethodBeat.o(556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.b
 * JD-Core Version:    0.7.0.1
 */