package com.tencent.mm.plugin.forcenotify.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/convert/ForceNotifyBaseConvert;", "T", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-force-notify_release"})
public abstract class a<T extends com.tencent.mm.plugin.forcenotify.d.e>
  extends com.tencent.mm.view.recyclerview.e<T>
{
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = (TextView)parami.amk.findViewById(a.e.title_tv);
    p.j(paramRecyclerView, "titleTv");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
  }
  
  public void a(i parami, T paramT, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    p.k(parami, "holder");
    p.k(paramT, "item");
    if (ar.isDarkMode())
    {
      paramT = (TextView)parami.RD(a.e.title_tv);
      if (paramT != null)
      {
        paramList = parami.getContext();
        p.j(paramList, "holder.context");
        paramT.setTextColor(paramList.getResources().getColor(a.b.force_notify_text_white_90));
      }
      paramT = (TextView)parami.RD(a.e.wording_tv);
      if (paramT != null)
      {
        parami = parami.getContext();
        p.j(parami, "holder.context");
        paramT.setTextColor(parami.getResources().getColor(a.b.force_notify_text_white_50));
      }
    }
    do
    {
      return;
      paramT = (TextView)parami.RD(a.e.title_tv);
      if (paramT != null)
      {
        paramList = parami.getContext();
        p.j(paramList, "holder.context");
        paramT.setTextColor(paramList.getResources().getColor(a.b.force_notify_text_dark_90));
      }
      paramT = (TextView)parami.RD(a.e.wording_tv);
    } while (paramT == null);
    parami = parami.getContext();
    p.j(parami, "holder.context");
    paramT.setTextColor(parami.getResources().getColor(a.b.force_notify_text_dark_70));
  }
  
  public int getLayoutId()
  {
    return a.f.force_notify_popup_item_msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.a
 * JD-Core Version:    0.7.0.1
 */