package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.bc;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFollowConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFollow;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bh
  extends bf<bc>
{
  private final String TAG;
  private final int scene;
  
  public bh(int paramInt)
  {
    super(e.f.finder_msg_item_of_follow, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgFollowConvert";
  }
  
  private static final void a(j paramj, TextView paramTextView1, String paramString, TextView paramTextView2, bc parambc)
  {
    AppMethodBeat.i(350256);
    s.u(paramj, "$holder");
    s.u(paramString, "$nickNameStr");
    s.u(parambc, "$item");
    int i = paramj.UH(e.e.name_container).getWidth();
    float f = paramTextView1.getPaint().measureText(paramString);
    if (i > f)
    {
      paramTextView2.setVisibility(8);
      paramTextView1.setText((CharSequence)p.b(paramj.context, (CharSequence)paramString));
      AppMethodBeat.o(350256);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText((CharSequence)paramj.context.getString(e.h.finder_msg_suffix_desc, new Object[] { r.TQ(parambc.ECa.field_aggregatedContacts.ZXF) }));
    paramTextView1.setText((CharSequence)p.b(paramj.context, (CharSequence)paramString));
    AppMethodBeat.o(350256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bh
 * JD-Core Version:    0.7.0.1
 */