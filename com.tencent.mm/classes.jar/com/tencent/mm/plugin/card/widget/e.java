package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class e
  extends a
{
  protected TextView eXO;
  private LinearLayout ipD;
  private RelativeLayout izS;
  private TextView izT;
  private View izU;
  private ImageView izV;
  private ImageView izW;
  private ImageView izX;
  private ImageView izY;
  private ImageView izZ;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private void aDp()
  {
    Object localObject = new c.a();
    ((c.a)localObject).eri = com.tencent.mm.compatible.util.e.bkH;
    o.OO();
    ((c.a)localObject).erB = null;
    ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(this.ikk.azy().sHI);
    ((c.a)localObject).erf = true;
    ((c.a)localObject).erD = true;
    ((c.a)localObject).erE = this.mContext.getResources().getDimensionPixelSize(a.b.card_member_widget_bg_big_round_radius);
    ((c.a)localObject).erF = true;
    ((c.a)localObject).erd = true;
    ((c.a)localObject).eru = a.c.card_widget_member_bg;
    ((c.a)localObject).erm = com.tencent.mm.cb.a.aa(this.mContext, a.b.card_member_widget_layout_height);
    ((c.a)localObject).erl = com.tencent.mm.cb.a.fj(this.mContext);
    localObject = ((c.a)localObject).OV();
    o.ON().a(this.ikk.azy().sHI, this.izY, (c)localObject);
    y.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.ikk.azy().sHI);
  }
  
  public final void a(ShapeDrawable paramShapeDrawable)
  {
    if (!TextUtils.isEmpty(this.ikk.azy().sHI))
    {
      this.izY.setBackgroundDrawable(null);
      this.izZ.setVisibility(0);
      aDp();
    }
    while (this.izw == null) {
      return;
    }
    this.izY.setBackgroundDrawable(paramShapeDrawable);
    this.izZ.setVisibility(8);
  }
  
  protected final void aDk()
  {
    this.eXO = ((TextView)aDj().findViewById(a.d.card_title));
    this.izS = ((RelativeLayout)aDj().findViewById(a.d.card_membership_layout));
    this.ipD = ((LinearLayout)aDj().findViewById(a.d.card_code_layout));
    this.izT = ((TextView)aDj().findViewById(a.d.code_text));
    this.izU = aDj().findViewById(a.d.card_code_click_view);
    this.izV = ((ImageView)aDj().findViewById(a.d.card_code_img));
    this.izW = ((ImageView)this.izw.findViewById(a.d.member_widget_bg_up));
    this.izX = ((ImageView)this.izw.findViewById(a.d.member_widget_bg_down));
    this.izY = ((ImageView)this.izw.findViewById(a.d.card_member_bg_img));
    this.izZ = ((ImageView)this.izw.findViewById(a.d.card_member_top_shadow_img));
  }
  
  protected final void aDl()
  {
    if (this.izy != null) {
      this.izy.setText(this.ikk.azx().imA);
    }
    Object localObject;
    if ((this.ikk.azx().sIq != null) && (this.ikk.azx().sIq.size() > 0))
    {
      localObject = (ra)this.ikk.azx().sIq.get(0);
      if (!TextUtils.isEmpty(((ra)localObject).title)) {
        this.eXO.setText(((ra)localObject).title);
      }
    }
    else
    {
      if (!this.ikk.isNormal()) {
        break label472;
      }
      eD(true);
      this.izY.setAlpha(255);
      if (this.izY.getBackground() != null) {
        this.izY.getBackground().setAlpha(255);
      }
      localObject = this.ikk.azy().code;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label297;
      }
      y.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
      eD(false);
    }
    for (;;)
    {
      localObject = this.izS.getLayoutParams();
      int i = this.mContext.getResources().getDimensionPixelSize(a.b.LargerPadding);
      int j = this.mContext.getResources().getDisplayMetrics().widthPixels - i * 2;
      int k = j * 3 / 5;
      ((ViewGroup.LayoutParams)localObject).height = k;
      y.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.izS.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      this.eXO.setText("");
      break;
      label297:
      this.izU.setOnClickListener(this.fvj);
      this.izV.setOnClickListener(this.fvj);
      this.izT.setOnClickListener(this.fvj);
      switch (this.ikk.azy().sHx)
      {
      default: 
        break;
      case 0: 
        if (((String)localObject).length() <= 40) {
          this.izT.setText(com.tencent.mm.plugin.card.d.m.yZ((String)localObject));
        }
        break;
      case 1: 
      case 2: 
        if (((String)localObject).length() <= 40)
        {
          if (this.ikk.azn()) {
            this.izT.setText(com.tencent.mm.plugin.card.d.m.yZ((String)localObject));
          } else {
            this.izT.setText("");
          }
        }
        else
        {
          this.izT.setText("");
          continue;
          this.izT.setText("");
          continue;
          label472:
          this.izT.setText("");
          this.izV.setVisibility(8);
          this.izU.setVisibility(8);
          this.izY.setAlpha(90);
          if (this.izY.getBackground() != null) {
            this.izY.getBackground().setAlpha(90);
          }
        }
        break;
      }
    }
  }
  
  public final void eD(boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(this.ikk.azy().code)) && (paramBoolean) && (this.ikk.azy().sHx != 0) && (!this.ikk.azx().sIY))
    {
      this.izV.setVisibility(0);
      this.izU.setVisibility(0);
      return;
    }
    this.izV.setVisibility(8);
    this.izU.setVisibility(8);
  }
  
  public final void eE(boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.ikk.azy().sHI))
    {
      this.izX.setVisibility(8);
      this.izW.setVisibility(8);
      return;
    }
    this.izX.setVisibility(0);
    this.izW.setVisibility(0);
  }
  
  public final void ph(int paramInt)
  {
    if (!TextUtils.isEmpty(this.ikk.azy().sHI))
    {
      this.izY.setBackgroundDrawable(null);
      this.izZ.setVisibility(0);
      aDp();
    }
    while (this.izw == null) {
      return;
    }
    this.izY.setBackgroundResource(paramInt);
    this.izZ.setVisibility(8);
  }
  
  public final void w(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.e
 * JD-Core Version:    0.7.0.1
 */