package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.protocal.protobuf.fmu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "emojiList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "emojiSubType", "", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "getEmojiSubType", "()Ljava/lang/String;", "setEmojiSubType", "(Ljava/lang/String;)V", "mListener", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "updateData", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "Companion", "plugin-hld_release"})
public final class g
  extends RecyclerView.a<RecyclerView.v>
{
  public static final a Dwg;
  private final a DvT;
  LinkedList<fmu> Dwe;
  String Dwf;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(209817);
    Dwg = new a((byte)0);
    AppMethodBeat.o(209817);
  }
  
  public g(Context paramContext, LinkedList<fmu> paramLinkedList, String paramString, a parama)
  {
    AppMethodBeat.i(209816);
    this.context = paramContext;
    this.Dwe = paramLinkedList;
    this.Dwf = paramString;
    this.DvT = parama;
    AppMethodBeat.o(209816);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(209812);
    p.k(paramViewGroup, "viewGroup");
    Log.d("WxIme.ImeEmojiGridAdapter", "onCreateViewHolder ".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      paramViewGroup = ad.kS(paramViewGroup.getContext()).inflate(a.h.ime_emoji_grid_item, paramViewGroup, false);
      p.j(paramViewGroup, "MMLayoutInflater.getInfl…d_item, viewGroup, false)");
      paramViewGroup = (RecyclerView.v)new h(paramViewGroup, this.DvT);
      AppMethodBeat.o(209812);
      return paramViewGroup;
    }
    paramViewGroup = ad.kS(paramViewGroup.getContext()).inflate(a.h.ime_emoji_content_footer_item, paramViewGroup, false);
    p.j(paramViewGroup, "MMLayoutInflater.getInfl…r_item, viewGroup, false)");
    paramViewGroup = (RecyclerView.v)new f(paramViewGroup);
    AppMethodBeat.o(209812);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(209813);
    p.k(paramv, "viewHolder");
    Log.d("WxIme.ImeEmojiGridAdapter", "onBindViewHolder ".concat(String.valueOf(paramInt)));
    h localh;
    if ((paramv instanceof h))
    {
      localh = (h)paramv;
      paramv = (fmu)this.Dwe.get(paramInt);
      localh.Dwk = paramv;
      if (paramv != null)
      {
        localh.DtO.setVisibility(0);
        localh.Dwi.setText((CharSequence)paramv.content);
        localh.Dwi.setVisibility(0);
        localh.Dwj.setVisibility(8);
        com.tencent.mm.plugin.hld.f.g localg = com.tencent.mm.plugin.hld.f.g.DHh;
        paramv = com.tencent.mm.plugin.hld.f.g.b(paramv);
        if (paramv == null) {
          break label166;
        }
        localh.Dwi.setVisibility(8);
        localh.Dwj.setVisibility(0);
        localh.Dwj.setImageBitmap(paramv);
      }
    }
    label166:
    for (paramv = x.aazN;; paramv = null)
    {
      if (paramv == null)
      {
        ((h)localh).DtO.setVisibility(8);
        paramv = x.aazN;
      }
      AppMethodBeat.o(209813);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(209814);
    if (!Util.isEqual(this.Dwf, "recent"))
    {
      i = this.Dwe.size();
      AppMethodBeat.o(209814);
      return i + 1;
    }
    int i = this.Dwe.size();
    AppMethodBeat.o(209814);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(209815);
    if (paramInt == this.Dwe.size())
    {
      AppMethodBeat.o(209815);
      return 1;
    }
    AppMethodBeat.o(209815);
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiGridAdapter$Companion;", "", "()V", "TAG", "", "TYPE_FOOTER", "", "TYPE_NORMAL", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.g
 * JD-Core Version:    0.7.0.1
 */