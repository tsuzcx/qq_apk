package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "()V", "style", "", "getStyle", "()I", "setStyle", "(I)V", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "Landroid/view/View;", "parent", "getCardType", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "gone", "inflate", "isVideoCard", "", "registerCard", "cardTmpl", "setVideoStatus", "status", "show", "PlayStatus", "plugin-brandservice_release"})
public abstract class ae
  extends a
{
  public static final ae.a sGq = new ae.a((byte)0);
  private int style = -1;
  
  public abstract void a(z paramz, int paramInt, View paramView1, View paramView2);
  
  public void a(z paramz, ae paramae)
  {
    p.k(paramz, "info");
    p.k(paramae, "cardTmpl");
  }
  
  public void a(z paramz, String paramString)
  {
    p.k(paramz, "info");
    p.k(paramString, "extra");
  }
  
  public boolean cAC()
  {
    return false;
  }
  
  public void cAv() {}
  
  public View getVideoView()
  {
    return null;
  }
  
  public void setVideoStatus(int paramInt) {}
  
  public void show() {}
  
  public int uv()
  {
    return this.style;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ae
 * JD-Core Version:    0.7.0.1
 */