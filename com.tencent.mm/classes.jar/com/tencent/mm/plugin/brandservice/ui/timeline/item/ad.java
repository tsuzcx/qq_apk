package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "()V", "style", "", "getStyle", "()I", "setStyle", "(I)V", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "Landroid/view/View;", "parent", "getCardType", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "gone", "inflate", "isVideoCard", "", "registerCard", "cardTmpl", "setVideoStatus", "status", "show", "PlayStatus", "plugin-brandservice_release"})
public abstract class ad
  extends a
{
  public static final ad.a pwU = new ad.a((byte)0);
  private int style = -1;
  
  public abstract void a(z paramz, int paramInt, View paramView1, View paramView2);
  
  public void a(z paramz, ad paramad)
  {
    p.h(paramz, "info");
    p.h(paramad, "cardTmpl");
  }
  
  public void a(z paramz, String paramString)
  {
    p.h(paramz, "info");
    p.h(paramString, "extra");
  }
  
  public void cmO() {}
  
  public boolean cmS()
  {
    return false;
  }
  
  public int getStyle()
  {
    return this.style;
  }
  
  public View getVideoView()
  {
    return null;
  }
  
  public void setVideoStatus(int paramInt) {}
  
  public void show() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
 * JD-Core Version:    0.7.0.1
 */