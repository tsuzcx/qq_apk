package com.tencent.mm.plugin.forcenotify.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.forcenotify.a.d;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.ui.b.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/convert/BaseMsgCardConvert;", "T", "Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "()V", "adjustDarkMode", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "darkMode", "", "getContentLayoutId", "", "getLayoutId", "onBindContentViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;IIZLjava/util/List;)V", "onBindViewHolder", "onCreateContentViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "updateCardStyle", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;)V", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T extends com.tencent.mm.plugin.forcenotify.c.a>
  extends f<T>
{
  private static final void a(com.tencent.mm.plugin.forcenotify.c.a parama, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/convert/BaseMsgCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$item");
    paramView = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
    paramView = b.a.fwZ().mZo;
    localObject = (List)paramView;
    int i = 0;
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext()) {
      if (s.p(((com.tencent.mm.plugin.forcenotify.c.a)((Iterator)localObject).next()).id, parama.id))
      {
        label108:
        if ((i != 0) || (paramView.size() <= 1)) {
          break label164;
        }
        parama = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
        b.a.fwZ().Wa(i + 1);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/forcenotify/convert/BaseMsgCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      i += 1;
      break;
      i = -1;
      break label108;
      label164:
      paramView = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
      b.a.fwZ().aDU(parama.id);
    }
  }
  
  public abstract void a(RecyclerView paramRecyclerView, j paramj);
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    Object localObject = (FrameLayout)paramj.caK.findViewById(a.e.content_container);
    View localView = af.mU(paramj.context).inflate(dTn(), null);
    a(paramRecyclerView, paramj);
    ((FrameLayout)localObject).addView(localView);
    paramRecyclerView = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
    boolean bool = b.a.fwZ().isDarkMode();
    paramRecyclerView = paramj.context;
    if (bool)
    {
      localObject = paramj.UH(a.e.card_container);
      if (localObject != null) {
        ((View)localObject).setBackground(paramRecyclerView.getDrawable(a.d.force_notify_popup_bg_dark));
      }
      localObject = (WeImageView)paramj.UH(a.e.icon_iv);
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(paramRecyclerView.getResources().getColor(a.b.force_notify_text_white_50));
      }
      localObject = (TextView)paramj.UH(a.e.card_title_tv);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(paramRecyclerView.getResources().getColor(a.b.force_notify_text_white_50));
      }
      localObject = paramj.UH(a.e.btn_close);
      if (localObject != null) {
        ((View)localObject).setBackground(paramRecyclerView.getDrawable(a.d.close_button_bg));
      }
      localObject = (WeImageView)paramj.UH(a.e.btn_close_icon);
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(paramRecyclerView.getResources().getColor(a.b.force_notify_close_color_dark));
      }
    }
    for (;;)
    {
      aw.a((Paint)((TextView)paramj.caK.findViewById(a.e.title_tv)).getPaint(), 0.8F);
      return;
      localObject = paramj.UH(a.e.card_container);
      if (localObject != null) {
        ((View)localObject).setBackground(paramRecyclerView.getDrawable(a.d.force_notify_popup_bg));
      }
      localObject = (WeImageView)paramj.UH(a.e.icon_iv);
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(paramRecyclerView.getResources().getColor(a.b.force_notify_text_dark_50));
      }
      localObject = (TextView)paramj.UH(a.e.card_title_tv);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(paramRecyclerView.getResources().getColor(a.b.force_notify_text_dark_50));
      }
      localObject = paramj.UH(a.e.btn_close);
      if (localObject != null) {
        ((View)localObject).setBackground(paramRecyclerView.getDrawable(a.d.close_button_bg_dark));
      }
      localObject = (WeImageView)paramj.UH(a.e.btn_close_icon);
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(paramRecyclerView.getResources().getColor(a.b.force_notify_close_color));
      }
    }
  }
  
  public abstract void a(j paramj, T paramT);
  
  public abstract int dTn();
  
  public final int getLayoutId()
  {
    return a.f.force_notify_item_card;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.a
 * JD-Core Version:    0.7.0.1
 */