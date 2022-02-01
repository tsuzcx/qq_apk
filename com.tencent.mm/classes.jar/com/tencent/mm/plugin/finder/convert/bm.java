package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.bh;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgLikeConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bm
  extends bf<bh>
{
  private final String TAG;
  private final int scene;
  
  public bm(int paramInt)
  {
    super(e.f.finder_msg_item_of_like, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgLikeConvert";
  }
  
  private static final void a(j paramj, TextView paramTextView1, String paramString, bm parambm, bh parambh, TextView paramTextView2)
  {
    AppMethodBeat.i(350363);
    s.u(paramj, "$holder");
    s.u(paramString, "$nickNameStr");
    s.u(parambm, "this$0");
    s.u(parambh, "$item");
    int i = paramj.UH(e.e.name_container).getWidth();
    float f = paramTextView1.getPaint().measureText(paramString);
    Log.d(parambm.TAG, "allWidth:" + i + " nicknameWidth:" + f + " count:" + parambh.ECa.eZT());
    if (i > f)
    {
      paramTextView2.setVisibility(8);
      paramTextView1.setText((CharSequence)p.b(paramj.context, (CharSequence)paramString));
      AppMethodBeat.o(350363);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText((CharSequence)paramj.context.getString(e.h.finder_msg_suffix_desc, new Object[] { r.TQ(parambh.ECa.field_aggregatedContacts.ZXF) }));
    paramTextView1.setText((CharSequence)p.b(paramj.context, (CharSequence)paramString));
    AppMethodBeat.o(350363);
  }
  
  private static final void a(final ah.f paramf, final j paramj, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(350366);
    s.u(paramf, "$likeIv");
    s.u(paramj, "$holder");
    d.uiThread((kotlin.g.a.a)new a(paramBitmap, paramf, paramj));
    AppMethodBeat.o(350366);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(Bitmap paramBitmap, ah.f<WeImageView> paramf, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bm
 * JD-Core Version:    0.7.0.1
 */