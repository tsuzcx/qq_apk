package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "()V", "style", "", "getStyle", "()I", "setStyle", "(I)V", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "Landroid/view/View;", "parent", "getCardType", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "gone", "inflate", "isVideoCard", "", "registerCard", "cardTmpl", "setVideoStatus", "status", "show", "PlayStatus", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ab
  extends a
{
  public static final ab.a vLO = new ab.a((byte)0);
  private int style = -1;
  
  public int TY()
  {
    return this.style;
  }
  
  public abstract void a(com.tencent.mm.storage.ab paramab, int paramInt, View paramView1, View paramView2);
  
  public void a(com.tencent.mm.storage.ab paramab, ab paramab1)
  {
    s.u(paramab, "info");
    s.u(paramab1, "cardTmpl");
  }
  
  public void a(com.tencent.mm.storage.ab paramab, String paramString)
  {
    s.u(paramab, "info");
    s.u(paramString, "extra");
  }
  
  public boolean ddC()
  {
    return false;
  }
  
  public void ddv() {}
  
  public View getVideoView()
  {
    return null;
  }
  
  public void setVideoStatus(int paramInt) {}
  
  public void show() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ab
 * JD-Core Version:    0.7.0.1
 */