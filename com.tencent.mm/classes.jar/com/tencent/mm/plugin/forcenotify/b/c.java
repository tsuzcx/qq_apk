package com.tencent.mm.plugin.forcenotify.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.d.e;
import com.tencent.mm.plugin.forcenotify.d.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/convert/ForceNotifyMsgConvert;", "Lcom/tencent/mm/plugin/forcenotify/convert/ForceNotifyBaseConvert;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "()V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-force-notify_release"})
public final class c
  extends a<h>
{
  private void a(i parami, h paramh, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(253052);
    p.k(parami, "holder");
    p.k(paramh, "item");
    super.a(parami, (e)paramh, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)parami.amk.findViewById(a.e.avatar_iv);
    if (n.pu(paramh.BDR, "@miniapp")) {
      q.bml().loadImage(paramh.nfY, paramList);
    }
    for (;;)
    {
      paramList = (TextView)parami.amk.findViewById(a.e.title_tv);
      p.j(paramList, "titleTv");
      paramList.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(paramList.getContext(), (CharSequence)paramh.nickname, paramList.getTextSize()));
      parami = (TextView)parami.amk.findViewById(a.e.wording_tv);
      p.j(parami, "wordingTv");
      parami.setText((CharSequence)paramh.wording);
      AppMethodBeat.o(253052);
      return;
      a.b.d(paramList, paramh.username, 0.12F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.c
 * JD-Core Version:    0.7.0.1
 */