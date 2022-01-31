package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.tw;
import java.util.LinkedList;

public final class k
  extends i
{
  private View iyb;
  
  public final void aCU()
  {
    if (this.iyb != null) {
      this.iyb.setVisibility(8);
    }
  }
  
  public final void initView() {}
  
  public final void update()
  {
    if (this.iyb == null) {
      this.iyb = ((ViewStub)findViewById(a.d.card_detail_field_stub)).inflate();
    }
    this.iyb.setOnClickListener(this.iya.aBI());
    Object localObject1 = this.iya.aBE().azx().sII;
    if (!TextUtils.isEmpty(((tw)localObject1).detail))
    {
      ((TextView)findViewById(a.d.card_detail_desc)).setText(((tw)localObject1).detail);
      findViewById(a.d.card_detail_desc_layout).setVisibility(0);
    }
    ImageView localImageView;
    for (;;)
    {
      localImageView = (ImageView)findViewById(a.d.card_detail_field_pic);
      if ((((tw)localObject1).sQI == null) || (((tw)localObject1).sQI.size() <= 0) || (TextUtils.isEmpty((CharSequence)((tw)localObject1).sQI.get(0)))) {
        break;
      }
      localObject1 = (String)((tw)localObject1).sQI.get(0);
      localImageView.setVisibility(0);
      Object localObject2 = new c.a();
      ((c.a)localObject2).eri = e.bkH;
      o.OO();
      ((c.a)localObject2).erB = null;
      ((c.a)localObject2).erh = m.yn((String)localObject1);
      ((c.a)localObject2).erf = true;
      ((c.a)localObject2).erD = false;
      ((c.a)localObject2).erd = true;
      localObject2 = ((c.a)localObject2).OV();
      o.ON().a((String)localObject1, localImageView, (c)localObject2);
      return;
      findViewById(a.d.card_detail_desc_layout).setVisibility(8);
    }
    localImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.k
 * JD-Core Version:    0.7.0.1
 */