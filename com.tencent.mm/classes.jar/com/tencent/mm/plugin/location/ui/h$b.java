package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class h$b
{
  private LinearLayout.LayoutParams kXB;
  boolean lFT = false;
  a lFU;
  String username;
  
  public h$b(h paramh, String paramString)
  {
    this.username = paramString;
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
      return;
    }
    this.lFU = new a();
    paramh = (LayoutInflater)this.lFQ.context.getSystemService("layout_inflater");
    this.lFU.lFV = ((RelativeLayout)paramh.inflate(a.f.location_share_header_avatar_layout, null));
    this.lFU.eYO = ((ImageView)this.lFU.lFV.findViewById(a.e.avatar));
    a.b.n(this.lFU.eYO, this.username);
    this.lFU.lFV.setTag(this.username);
    this.kXB = new LinearLayout.LayoutParams(-2, -2);
    this.kXB.leftMargin = BackwardSupportUtil.b.b(this.lFQ.context, 5.0F);
    this.kXB.rightMargin = BackwardSupportUtil.b.b(this.lFQ.context, 5.0F);
    this.kXB.gravity = 17;
  }
  
  public final void bes()
  {
    y.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[] { this.username });
    this.lFU.lFV.setBackgroundResource(a.d.location_share_avatar_bg_hl);
    this.lFU.lFV.invalidate();
    this.lFT = true;
  }
  
  public final void bet()
  {
    y.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[] { this.username });
    this.lFU.lFV.setBackgroundResource(a.d.location_share_avatar_bg);
    this.lFU.lFV.invalidate();
    this.lFT = false;
  }
  
  final class a
  {
    ImageView eYO;
    RelativeLayout lFV;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h.b
 * JD-Core Version:    0.7.0.1
 */