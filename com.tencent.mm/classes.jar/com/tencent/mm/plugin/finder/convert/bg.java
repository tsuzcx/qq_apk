package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.cb;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFollowApply;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "setAccept", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "acceptBtn", "Landroid/widget/TextView;", "setAccepted", "setInvalid", "setRevoke", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg
  extends bf<bd>
{
  private final String TAG = "Finder.FinderMsgFollowApplyConvert";
  private final int scene = 1;
  
  private bg()
  {
    super(e.f.finder_msg_item_of_follow_apply, 1);
  }
  
  private static void a(TextView paramTextView, j paramj)
  {
    AppMethodBeat.i(350264);
    paramTextView.setBackground(null);
    paramTextView.setOnClickListener(null);
    paramTextView.setText((CharSequence)paramj.context.getString(e.h.finder_msg_accepted));
    aw.a((Paint)paramTextView.getPaint(), 0.0F);
    paramTextView.setTextColor(paramj.context.getResources().getColor(e.b.FG_2));
    AppMethodBeat.o(350264);
  }
  
  private static final void a(av paramav, bg parambg, TextView paramTextView, j paramj, View paramView)
  {
    AppMethodBeat.i(350275);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramav);
    localb.cH(parambg);
    localb.cH(paramTextView);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramav, "$mention");
    kotlin.g.b.s.u(parambg, "this$0");
    kotlin.g.b.s.u(paramTextView, "$acceptBtn");
    kotlin.g.b.s.u(paramj, "$holder");
    paramView = z.FrZ;
    paramView = paramav.field_username;
    kotlin.g.b.s.s(paramView, "mention.field_username");
    z.ak(paramView, 1, cn.getSyncServerTimeSecond());
    a(paramTextView, paramj);
    paramTextView = g.FNK;
    g.d(paramav);
    paramTextView = k.aeZF;
    paramTextView = paramj.context;
    if (paramTextView == null)
    {
      paramav = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(350275);
      throw paramav;
    }
    paramav = new cb(paramav, ((as)k.d((AppCompatActivity)paramTextView).q(as.class)).fou(), parambg.scene);
    h.aZW().a((com.tencent.mm.am.p)paramav, 0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350275);
  }
  
  private static final void a(j paramj, TextView paramTextView1, String paramString, TextView paramTextView2, bd parambd)
  {
    AppMethodBeat.i(350267);
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramString, "$nickNameStr");
    kotlin.g.b.s.u(parambd, "$item");
    int i = paramj.UH(e.e.name_container).getWidth();
    float f = paramTextView1.getPaint().measureText(paramString);
    if (i > f)
    {
      paramTextView2.setVisibility(8);
      paramTextView1.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramj.context, (CharSequence)paramString));
      AppMethodBeat.o(350267);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText((CharSequence)paramj.context.getString(e.h.finder_msg_suffix_desc, new Object[] { r.TQ(parambd.ECa.field_aggregatedContacts.ZXF) }));
    paramTextView1.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramj.context, (CharSequence)paramString));
    AppMethodBeat.o(350267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bg
 * JD-Core Version:    0.7.0.1
 */