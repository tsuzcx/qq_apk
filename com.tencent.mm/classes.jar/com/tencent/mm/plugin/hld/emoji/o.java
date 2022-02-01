package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.view.e;
import com.tencent.mm.protocal.protobuf.gjm;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridAdapter;", "Lcom/tencent/mm/plugin/hld/view/ImeFourGridBaseAdapter;", "Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridViewHolder;", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "context", "Landroid/content/Context;", "emojiList", "Ljava/util/LinkedList;", "emojiSubType", "", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "itemWidth", "", "mListener", "textView", "Landroid/widget/TextView;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "updateData", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "arg", "holdPosition", "", "updateViewType", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends e<p, gjm>
{
  public static final o.a JpN;
  private final a Jpb;
  LinkedList<gjm> Jpl;
  private String Jpm;
  private final Context context;
  private TextView dyR;
  private int wLI;
  
  static
  {
    AppMethodBeat.i(312688);
    JpN = new o.a((byte)0);
    AppMethodBeat.o(312688);
  }
  
  public o(Context paramContext, LinkedList<gjm> paramLinkedList, String paramString, a parama)
  {
    AppMethodBeat.i(312686);
    this.context = paramContext;
    this.Jpl = paramLinkedList;
    this.Jpm = paramString;
    this.Jpb = parama;
    AppMethodBeat.o(312686);
  }
  
  public final void a(RecyclerView paramRecyclerView, List<? extends gjm> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(312708);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramList, "dataList");
    s.u(paramString, "arg");
    this.Jpl.clear();
    this.Jpl.addAll((Collection)paramList);
    iC((List)this.Jpl);
    this.bZE.notifyChanged();
    paramList = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, paramList.aYi(), "com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    paramRecyclerView.scrollToPosition(((Integer)paramList.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiGridAdapter", "updateData", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(312708);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(312692);
    int i = this.Jpl.size();
    AppMethodBeat.o(312692);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(312700);
    if (fPr().containsKey(Integer.valueOf(paramInt)))
    {
      localObject = fPr().get(Integer.valueOf(paramInt));
      s.checkNotNull(localObject);
      s.s(localObject, "viewTypeCacheMap[position]!!");
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(312700);
      return paramInt;
    }
    if (this.wLI == 0) {
      this.wLI = (this.context.getResources().getDisplayMetrics().widthPixels / 4);
    }
    if (this.dyR == null)
    {
      this.dyR = new TextView(this.context);
      localObject = this.dyR;
      s.checkNotNull(localObject);
      ((TextView)localObject).setTextSize(0, com.tencent.mm.cd.a.bs(this.context, a.d.S5_keys_button_text_size));
    }
    Object localObject = ((gjm)this.Jpl.get(paramInt)).content;
    TextView localTextView = this.dyR;
    s.checkNotNull(localTextView);
    paramInt = (int)localTextView.getPaint().measureText((String)localObject) / this.wLI + 1;
    if (paramInt > 4)
    {
      AppMethodBeat.o(312700);
      return 4;
    }
    AppMethodBeat.o(312700);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.o
 * JD-Core Version:    0.7.0.1
 */