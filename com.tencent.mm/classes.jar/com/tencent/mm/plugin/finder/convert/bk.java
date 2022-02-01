package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.be;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.logic.f;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFollowApply;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "setAccept", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "acceptBtn", "Landroid/widget/TextView;", "setAccepted", "setInvalid", "setRevoke", "plugin-finder_release"})
public final class bk
  extends bj<az>
{
  private final String TAG = "Finder.FinderMsgFollowApplyConvert";
  final int scene = 1;
  
  private bk()
  {
    super(b.g.finder_msg_item_of_follow_apply, 1);
  }
  
  static void a(TextView paramTextView, i parami)
  {
    AppMethodBeat.i(291075);
    paramTextView.setBackground(null);
    paramTextView.setOnClickListener(null);
    paramTextView.setText((CharSequence)parami.getContext().getString(b.j.finder_msg_accepted));
    ar.a((Paint)paramTextView.getPaint(), 0.0F);
    parami = parami.getContext();
    p.j(parami, "holder.context");
    paramTextView.setTextColor(parami.getResources().getColor(b.c.FG_2));
    AppMethodBeat.o(291075);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(i parami, TextView paramTextView1, String paramString, TextView paramTextView2, az paramaz) {}
    
    public final void run()
    {
      AppMethodBeat.i(291338);
      Object localObject = this.tDl.RD(b.f.name_container);
      p.j(localObject, "holder.getView<View>(R.id.name_container)");
      int i = ((View)localObject).getWidth();
      localObject = this.xkm;
      p.j(localObject, "nickTv");
      float f = ((TextView)localObject).getPaint().measureText(this.xnu);
      if (i > f)
      {
        localObject = this.xnv;
        p.j(localObject, "suffixTv");
        ((TextView)localObject).setVisibility(8);
        localObject = this.xkm;
        p.j(localObject, "nickTv");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.tDl.getContext(), (CharSequence)this.xnu));
        AppMethodBeat.o(291338);
        return;
      }
      localObject = this.xnv;
      p.j(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.xnv;
      p.j(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.tDl.getContext().getString(b.j.finder_msg_suffix_desc, new Object[] { m.QG(this.xnw.zzT.field_aggregatedContacts.SPu) }));
      localObject = this.xkm;
      p.j(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.tDl.getContext(), (CharSequence)this.xnu));
      AppMethodBeat.o(291338);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(bk parambk, an paraman, TextView paramTextView, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(288372);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert$setAccept$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = n.zWF;
      paramView = this.xny.field_username;
      p.j(paramView, "mention.field_username");
      n.af(paramView, 1, cm.bfF());
      bk.a(this.xnz, this.tDl);
      paramView = f.AnR;
      f.c(this.xny);
      paramView = g.Xox;
      paramView = this.tDl.getContext();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(288372);
        throw paramView;
      }
      paramView = ((aj)g.b((AppCompatActivity)paramView).i(aj.class)).ekY();
      paramView = new be(this.xny, paramView, this.xnx.scene);
      h.aGY().b((q)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert$setAccept$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bk
 * JD-Core Version:    0.7.0.1
 */