package com.tencent.mm.plugin.emojicapture.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.emojicapture.a.c;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.h;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.model.a.f;
import com.tencent.mm.plugin.emojicapture.model.a.f.a;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sticker.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EmptyStickerViewHolder", "MoreStickerViewHolder", "StickerViewHolder", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<a>
{
  public static final String TAG;
  public static final b.b ykB;
  public int dyx;
  public final ArrayList<c> ykw;
  public m<? super Integer, ? super c, ah> ykx;
  
  static
  {
    AppMethodBeat.i(564);
    ykB = new b.b((byte)0);
    TAG = "MicroMsg.StickerAdapter";
    AppMethodBeat.o(564);
  }
  
  public b()
  {
    AppMethodBeat.i(563);
    this.ykw = new ArrayList();
    this.dyx = -1;
    AppMethodBeat.o(563);
  }
  
  public final c KX(int paramInt)
  {
    AppMethodBeat.i(269429);
    c localc = (c)p.ae((List)this.ykw, paramInt);
    AppMethodBeat.o(269429);
    return localc;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(559);
    int i = this.ykw.size();
    AppMethodBeat.o(559);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(560);
    Object localObject = KX(paramInt);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c)localObject).acBO)
    {
      locala = f.yhn;
      if (!s.p(localObject, f.dEm())) {
        break;
      }
      AppMethodBeat.o(560);
      return 1;
    }
    f.a locala = f.yhn;
    if (s.p(localObject, f.dEo())) {}
    while (bool)
    {
      AppMethodBeat.o(560);
      return 2;
      locala = f.yhn;
      bool = s.p(localObject, f.dEn());
    }
    AppMethodBeat.o(560);
    return 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public abstract class a
    extends RecyclerView.v
  {
    private final ImageView dpM;
    private final TextView wdg;
    
    public a()
    {
      super();
      this.dpM = ((ImageView)localObject.findViewById(a.f.yeI));
      this.wdg = ((TextView)localObject.findViewById(a.f.yeJ));
      localObject.setOnClickListener(new b.a..ExternalSyntheticLambda0(this, b.this, localObject));
    }
    
    private static final void a(a parama, b paramb, View paramView1, View paramView2)
    {
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramb);
      localb.cH(paramView1);
      localb.cH(paramView2);
      a.c("com/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      s.u(paramb, "this$1");
      s.u(paramView1, "$itemView");
      int i = parama.KJ();
      parama = paramb.KX(i);
      if (parama != null)
      {
        paramb = paramb.ykx;
        if (paramb != null) {
          paramb.invoke(Integer.valueOf(i), parama);
        }
      }
      paramView1.requestFocus();
      a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    }
    
    public abstract void c(dhp paramdhp);
    
    public final ImageView dEI()
    {
      return this.dpM;
    }
    
    public final TextView dEJ()
    {
      return this.wdg;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends b.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(553);
      AppMethodBeat.o(553);
    }
    
    public final void c(dhp paramdhp)
    {
      AppMethodBeat.i(552);
      s.u(paramdhp, "info");
      paramdhp = dEI();
      s.s(paramdhp, "icon");
      com.tencent.mm.plugin.emojicapture.ui.b.a(paramdhp, a.h.icons_outlined_no_effect, dEI().getContext().getResources().getColor(a.c.FG_0));
      dEJ().setText(a.i.yfR);
      AppMethodBeat.o(552);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$MoreStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends b.a
  {
    public d()
    {
      super(localObject);
      AppMethodBeat.i(555);
      AppMethodBeat.o(555);
    }
    
    public final void c(dhp paramdhp)
    {
      AppMethodBeat.i(554);
      s.u(paramdhp, "info");
      f.a locala = f.yhn;
      if (s.p(paramdhp, f.dEo()))
      {
        this.caK.setVisibility(4);
        AppMethodBeat.o(554);
        return;
      }
      this.caK.setVisibility(0);
      paramdhp = dEI();
      s.s(paramdhp, "icon");
      com.tencent.mm.plugin.emojicapture.ui.b.a(paramdhp, a.h.icons_filled_more, dEI().getContext().getResources().getColor(a.c.FG_0));
      dEJ().setText(a.i.yfQ);
      AppMethodBeat.o(554);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.b
 * JD-Core Version:    0.7.0.1
 */