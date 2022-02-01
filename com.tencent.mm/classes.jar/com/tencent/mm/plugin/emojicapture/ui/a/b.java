package com.tencent.mm.plugin.emojicapture.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.emojicapture.a.c;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.h;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.model.a.f;
import com.tencent.mm.plugin.emojicapture.model.a.f.a;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.sticker.loader.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EmptyStickerViewHolder", "MoreStickerViewHolder", "StickerViewHolder", "plugin-emojicapture_release"})
public final class b
  extends RecyclerView.a<a>
{
  public static final String TAG = "MicroMsg.StickerAdapter";
  public static final b uYp;
  public int bFx;
  public final ArrayList<com.tencent.mm.sticker.c> uYi;
  public m<? super Integer, ? super com.tencent.mm.sticker.c, x> uYj;
  
  static
  {
    AppMethodBeat.i(564);
    uYp = new b((byte)0);
    TAG = "MicroMsg.StickerAdapter";
    AppMethodBeat.o(564);
  }
  
  public b()
  {
    AppMethodBeat.i(563);
    this.uYi = new ArrayList();
    this.bFx = -1;
    AppMethodBeat.o(563);
  }
  
  public final com.tencent.mm.sticker.c JZ(int paramInt)
  {
    AppMethodBeat.i(201131);
    com.tencent.mm.sticker.c localc = (com.tencent.mm.sticker.c)j.M((List)this.uYi, paramInt);
    AppMethodBeat.o(201131);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(559);
    int i = this.uYi.size();
    AppMethodBeat.o(559);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(560);
    Object localObject = JZ(paramInt);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.sticker.c)localObject).Vat;; localObject = null)
    {
      locala = f.uUX;
      if (!p.h(localObject, f.cXW())) {
        break;
      }
      AppMethodBeat.o(560);
      return 1;
    }
    f.a locala = f.uUX;
    if (!p.h(localObject, f.cXY()))
    {
      locala = f.uUX;
      if (!p.h(localObject, f.cXX())) {}
    }
    else
    {
      AppMethodBeat.o(560);
      return 2;
    }
    AppMethodBeat.o(560);
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public abstract class a
    extends RecyclerView.v
  {
    private final ImageView bwJ;
    private final TextView sYQ;
    
    public a()
    {
      super();
      this.bwJ = ((ImageView)localObject.findViewById(a.f.uRU));
      this.sYQ = ((TextView)localObject.findViewById(a.f.uRV));
      localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(551);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          int i = this.uYr.md();
          paramAnonymousView = this.uYr.uYq.JZ(i);
          if (paramAnonymousView != null)
          {
            localObject = this.uYr.uYq.uYj;
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
    
    public abstract void c(cqv paramcqv);
    
    public final ImageView cYq()
    {
      return this.bwJ;
    }
    
    public final TextView cYr()
    {
      return this.sYQ;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$Companion;", "", "()V", "TAG", "", "ViewTypeEmpty", "", "ViewTypeMore", "ViewTypeNormal", "plugin-emojicapture_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class c
    extends b.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(553);
      AppMethodBeat.o(553);
    }
    
    public final void c(cqv paramcqv)
    {
      AppMethodBeat.i(552);
      p.k(paramcqv, "info");
      paramcqv = cYq();
      p.j(paramcqv, "icon");
      int i = a.h.icons_outlined_no_effect;
      Object localObject = cYq();
      p.j(localObject, "icon");
      localObject = ((ImageView)localObject).getContext();
      p.j(localObject, "icon.context");
      com.tencent.mm.plugin.emojicapture.ui.c.a(paramcqv, i, ((Context)localObject).getResources().getColor(a.c.FG_0));
      cYr().setText(a.i.uTd);
      AppMethodBeat.o(552);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$MoreStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class d
    extends b.a
  {
    public d()
    {
      super(localObject);
      AppMethodBeat.i(555);
      AppMethodBeat.o(555);
    }
    
    public final void c(cqv paramcqv)
    {
      AppMethodBeat.i(554);
      p.k(paramcqv, "info");
      Object localObject = f.uUX;
      if (p.h(paramcqv, f.cXY()))
      {
        paramcqv = this.amk;
        p.j(paramcqv, "itemView");
        paramcqv.setVisibility(4);
        AppMethodBeat.o(554);
        return;
      }
      paramcqv = this.amk;
      p.j(paramcqv, "itemView");
      paramcqv.setVisibility(0);
      paramcqv = cYq();
      p.j(paramcqv, "icon");
      int i = a.h.icons_filled_more;
      localObject = cYq();
      p.j(localObject, "icon");
      localObject = ((ImageView)localObject).getContext();
      p.j(localObject, "icon.context");
      com.tencent.mm.plugin.emojicapture.ui.c.a(paramcqv, i, ((Context)localObject).getResources().getColor(a.c.FG_0));
      cYr().setText(a.i.uTc);
      AppMethodBeat.o(554);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public final class e
    extends b.a
  {
    public e()
    {
      super(localObject);
      AppMethodBeat.i(557);
      AppMethodBeat.o(557);
    }
    
    public final void c(cqv paramcqv)
    {
      AppMethodBeat.i(556);
      p.k(paramcqv, "info");
      Object localObject = h.VbF;
      localObject = h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(paramcqv));
      ImageView localImageView = cYq();
      p.j(localImageView, "icon");
      ((com.tencent.mm.loader.a.b)localObject).c(localImageView);
      localObject = cYr();
      p.j(localObject, "text");
      ((TextView)localObject).setText((CharSequence)paramcqv.CMP);
      AppMethodBeat.o(556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.b
 * JD-Core Version:    0.7.0.1
 */