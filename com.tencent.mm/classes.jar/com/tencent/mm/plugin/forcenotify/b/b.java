package com.tencent.mm.plugin.forcenotify.b;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.d.e;
import com.tencent.mm.plugin.forcenotify.d.g;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/convert/ForceNotifyLiveConvert;", "Lcom/tencent/mm/plugin/forcenotify/convert/ForceNotifyBaseConvert;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "plugin-force-notify_release"})
public final class b
  extends a<g>
{
  private void a(i parami, g paramg, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(253976);
    p.k(parami, "holder");
    p.k(paramg, "item");
    super.a(parami, (e)paramg, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (TextView)parami.amk.findViewById(a.e.title_tv);
    p.j(paramList, "titleTv");
    paramList.setText((CharSequence)paramList.getResources().getString(a.h.force_notify_live_tip, new Object[] { paramg.nickname }));
    parami = (TextView)parami.amk.findViewById(a.e.force_notify_desc);
    paramList = (CharSequence)paramg.BDX;
    if ((paramList == null) || (paramList.length() == 0)) {}
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      p.j(parami, "descTv");
      parami.setVisibility(8);
      AppMethodBeat.o(253976);
      return;
    }
    p.j(parami, "descTv");
    parami.setVisibility(0);
    parami.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(parami.getContext(), (CharSequence)paramg.BDX, parami.getTextSize()));
    AppMethodBeat.o(253976);
  }
  
  public final int getLayoutId()
  {
    return a.f.force_notify_popup_item_live;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.b
 * JD-Core Version:    0.7.0.1
 */