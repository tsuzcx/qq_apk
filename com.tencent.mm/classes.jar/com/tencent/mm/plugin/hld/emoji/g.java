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
import com.tencent.mm.protocal.protobuf.gjm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "emojiList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "emojiSubType", "", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "getEmojiSubType", "()Ljava/lang/String;", "setEmojiSubType", "(Ljava/lang/String;)V", "mListener", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "updateData", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends RecyclerView.a<RecyclerView.v>
{
  public static final g.a Jpk;
  private final a Jpb;
  LinkedList<gjm> Jpl;
  String Jpm;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(312709);
    Jpk = new g.a((byte)0);
    AppMethodBeat.o(312709);
  }
  
  public g(Context paramContext, LinkedList<gjm> paramLinkedList, String paramString, a parama)
  {
    AppMethodBeat.i(312703);
    this.context = paramContext;
    this.Jpl = paramLinkedList;
    this.Jpm = paramString;
    this.Jpb = parama;
    AppMethodBeat.o(312703);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(312718);
    s.u(paramViewGroup, "viewGroup");
    Log.d("WxIme.ImeEmojiGridAdapter", s.X("onCreateViewHolder ", Integer.valueOf(paramInt)));
    if (paramInt == 0)
    {
      paramViewGroup = af.mU(paramViewGroup.getContext()).inflate(a.h.ime_emoji_grid_item, paramViewGroup, false);
      s.s(paramViewGroup, "getInflater(viewGroup.co…d_item, viewGroup, false)");
      paramViewGroup = (RecyclerView.v)new h(paramViewGroup, this.Jpb);
      AppMethodBeat.o(312718);
      return paramViewGroup;
    }
    paramViewGroup = af.mU(paramViewGroup.getContext()).inflate(a.h.ime_emoji_content_footer_item, paramViewGroup, false);
    s.s(paramViewGroup, "getInflater(viewGroup.co…r_item, viewGroup, false)");
    paramViewGroup = (RecyclerView.v)new f(paramViewGroup);
    AppMethodBeat.o(312718);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(312727);
    s.u(paramv, "viewHolder");
    Log.d("WxIme.ImeEmojiGridAdapter", s.X("onBindViewHolder ", Integer.valueOf(paramInt)));
    h localh;
    if ((paramv instanceof h))
    {
      localh = (h)paramv;
      paramv = (gjm)this.Jpl.get(paramInt);
      localh.Jpq = paramv;
      if (paramv != null) {
        break label82;
      }
      paramv = null;
    }
    for (;;)
    {
      if (paramv == null) {
        ((h)localh).Ikt.setVisibility(8);
      }
      AppMethodBeat.o(312727);
      return;
      label82:
      localh.Ikt.setVisibility(0);
      localh.Jpo.setText((CharSequence)paramv.content);
      localh.Jpo.setVisibility(0);
      localh.Jpp.setVisibility(8);
      com.tencent.mm.plugin.hld.f.g localg = com.tencent.mm.plugin.hld.f.g.Jyo;
      paramv = com.tencent.mm.plugin.hld.f.g.b(paramv);
      if (paramv == null)
      {
        paramv = null;
      }
      else
      {
        localh.Jpo.setVisibility(8);
        localh.Jpp.setVisibility(0);
        localh.Jpp.setImageBitmap(paramv);
        paramv = ah.aiuX;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(312733);
    if (!Util.isEqual(this.Jpm, "recent"))
    {
      i = this.Jpl.size();
      AppMethodBeat.o(312733);
      return i + 1;
    }
    int i = this.Jpl.size();
    AppMethodBeat.o(312733);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(312741);
    if (paramInt == this.Jpl.size())
    {
      AppMethodBeat.o(312741);
      return 1;
    }
    AppMethodBeat.o(312741);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.g
 * JD-Core Version:    0.7.0.1
 */