package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.c.cbx;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends a
{
  private final String TAG = "MicroMsg.CardWidgetCommon";
  protected TextView fcy;
  private boolean ixx = false;
  protected TextView izA;
  protected Button izB;
  protected LinearLayout izC;
  protected TextView izD;
  protected ImageView izE;
  protected View izF;
  protected ImageView izG;
  protected TextView izz;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private void aDm()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.izC.getLayoutParams();
    if (this.ikk.azd())
    {
      this.izx.setVisibility(0);
      this.izE.setVisibility(8);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.b.card_coupon_widget_body_top_margin);
    }
    for (;;)
    {
      this.izC.setLayoutParams(localLayoutParams);
      return;
      if ((this.ikk.aze()) && (this.ixx))
      {
        this.izx.setVisibility(8);
        this.izE.setVisibility(8);
        localLayoutParams.topMargin = 0;
      }
      else if (this.ikk.aze())
      {
        this.izx.setVisibility(0);
        this.izE.setVisibility(8);
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.b.card_coupon_widget_body_top_margin);
      }
    }
  }
  
  private void aDn()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.izB.getLayoutParams();
    if ((this.ikk.azy().sHF != null) && (!TextUtils.isEmpty(this.ikk.azy().sHF.ilr))) {
      localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.NormalPadding);
    }
    for (;;)
    {
      this.izB.setLayoutParams(localLayoutParams);
      return;
      if ((this.ikk.azy().sHG != null) && (!TextUtils.isEmpty(this.ikk.azy().sHG.ilq))) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.NormalPadding);
      } else if ((this.ikk.azx().sIq != null) && (this.ikk.azx().sIq.size() > 0)) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.NormalPadding);
      } else {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LargerPadding);
      }
    }
  }
  
  protected final void aDk()
  {
    this.fcy = ((TextView)this.izw.findViewById(a.d.card_title));
    this.izz = ((TextView)this.izw.findViewById(a.d.card_subtitle));
    this.izA = ((TextView)this.izw.findViewById(a.d.card_auxtitle));
    this.izB = ((Button)this.izw.findViewById(a.d.card_consume_btn));
    this.izC = ((LinearLayout)this.izw.findViewById(a.d.widget_body));
    this.izE = ((ImageView)this.izC.findViewById(a.d.app_small_logo));
    this.izF = this.izw.findViewById(a.d.card_bottom_dash_divider);
    this.izG = ((ImageView)this.izw.findViewById(a.d.card_code_img));
    this.izD = ((TextView)this.izw.findViewById(a.d.card_operate_field_aux_title_tv));
  }
  
  protected final void aDl()
  {
    ra localra1;
    Object localObject1;
    if ((this.ikk.azx().sIq != null) && (this.ikk.azx().sIq.size() > 0))
    {
      localra1 = (ra)this.ikk.azx().sIq.get(0);
      if (!bk.bl(localra1.title)) {
        this.fcy.setText(localra1.title);
      }
      if (!bk.bl(localra1.ilq))
      {
        this.izz.setText(localra1.ilq);
        this.izz.setVisibility(0);
        localObject1 = (LinearLayout.LayoutParams)this.izz.getLayoutParams();
        if (bk.bl(localra1.ilr)) {
          break label232;
        }
        this.izA.setText(localra1.ilr);
        this.izA.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        label148:
        this.izz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.izz.invalidate();
      }
    }
    else
    {
      if ((this.izB != null) && (this.izG != null)) {
        break label261;
      }
      y.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
    }
    for (;;)
    {
      aDm();
      this.izC.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.card_white_top_bg));
      aDn();
      this.izw.invalidate();
      return;
      this.izz.setVisibility(8);
      break;
      label232:
      this.izA.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.b.LargerPadding);
      break label148;
      label261:
      if (this.ikk.azy() == null)
      {
        y.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
        this.izB.setVisibility(8);
        this.izG.setVisibility(8);
      }
      else
      {
        if (this.ikk.azy().sHF != null)
        {
          y.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.ikk.azy().sHF.title);
          y.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.ikk.azy().sHF.url);
          y.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.ikk.azy().sHF.ilr);
        }
        localra1 = this.ikk.azy().sHG;
        if (localra1 != null)
        {
          y.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + localra1.title);
          y.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + localra1.sJq);
          y.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + localra1.ilr);
        }
        Object localObject2 = this.ikk.azx().sIJ;
        localObject1 = (LinearLayout)this.izC.findViewById(a.d.card_detail_field_layout);
        if ((localObject2 != null) && (!bk.dk(((cbx)localObject2).tRb)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((LinearLayout)localObject1).removeAllViews();
          localObject2 = ((cbx)localObject2).tRb.iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          ra localra2 = (ra)((Iterator)localObject2).next();
          View localView = LayoutInflater.from(this.mContext).inflate(a.e.card_detail_field_item, null);
          TextView localTextView1 = (TextView)localView.findViewById(a.d.card_detail_field_title);
          TextView localTextView2 = (TextView)localView.findViewById(a.d.card_detail_field_dec);
          localTextView1.setText(localra2.title);
          localTextView2.setText(localra2.ilq);
          ((LinearLayout)localObject1).addView(localView);
          continue;
          ((LinearLayout)localObject1).setVisibility(8);
        }
        if ((localra1 != null) && (!TextUtils.isEmpty(localra1.title)) && (localra1.sJq != 0L) && (this.ikk.isNormal()))
        {
          this.izB.setClickable(false);
          this.izB.setVisibility(0);
          this.izB.setTextColor(this.mContext.getResources().getColor(a.a.white_text_color_selector));
          this.izB.setText(localra1.title);
          if ((localra1 != null) && (!TextUtils.isEmpty(localra1.ilq)))
          {
            this.izD.setText(localra1.ilq);
            this.izD.setVisibility(0);
          }
          for (;;)
          {
            this.izG.setVisibility(8);
            if ((localra1.sJq & 0x2) <= 0L) {
              break label878;
            }
            this.izB.setBackgroundDrawable(l.z(this.mContext, l.bq(this.ikk.azx().color, 150)));
            this.izD.setTextColor(l.yR(this.ikk.azx().color));
            break;
            this.izD.setVisibility(8);
          }
          label878:
          if ((localra1.sJq & 0x4) > 0L)
          {
            this.izB.setBackgroundDrawable(l.z(this.mContext, this.mContext.getResources().getColor(a.a.light_grey)));
            this.izD.setTextColor(this.mContext.getResources().getColor(a.a.normal_color));
          }
          else
          {
            this.izB.setBackgroundDrawable(l.z(this.mContext, l.yR(this.ikk.azx().color)));
            this.izD.setTextColor(this.mContext.getResources().getColor(a.a.normal_color));
          }
        }
        else if ((this.ikk.azy().sHF != null) && (!TextUtils.isEmpty(this.ikk.azy().sHF.title)) && (!TextUtils.isEmpty(this.ikk.azy().sHF.url)) && (this.ikk.isNormal()))
        {
          this.izB.setClickable(true);
          this.izB.setVisibility(0);
          this.izB.setBackgroundDrawable(l.z(this.mContext, l.yR(this.ikk.azx().color)));
          this.izB.setTextColor(this.mContext.getResources().getColorStateList(a.a.white_text_color_selector));
          this.izB.setText(this.ikk.azy().sHF.title);
          if ((this.ikk.azy().sHF != null) && (!TextUtils.isEmpty(this.ikk.azy().sHF.ilr)))
          {
            this.izD.setTextColor(this.mContext.getResources().getColor(a.a.normal_color));
            this.izD.setText(this.ikk.azy().sHF.ilr);
            this.izD.setVisibility(0);
          }
          for (;;)
          {
            if (TextUtils.isEmpty(this.ikk.azy().code)) {
              break label1276;
            }
            this.izG.setVisibility(0);
            break;
            this.izD.setVisibility(8);
          }
          label1276:
          this.izG.setVisibility(8);
        }
        else if ((!TextUtils.isEmpty(this.ikk.azy().code)) && (this.ikk.isNormal()))
        {
          y.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
          this.izG.setVisibility(8);
          this.izD.setVisibility(8);
          this.izB.setClickable(true);
          this.izB.setVisibility(0);
          this.izB.setBackgroundDrawable(l.z(this.mContext, l.yR(this.ikk.azx().color)));
          this.izB.setTextColor(this.mContext.getResources().getColorStateList(a.a.white_text_color_selector));
          this.izB.setText(a.g.card_state_normal);
        }
        else if (!this.ikk.isNormal())
        {
          y.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.ikk.azy().status);
          this.izG.setVisibility(8);
          this.izD.setVisibility(8);
          this.izB.setClickable(true);
          this.izB.setVisibility(0);
          this.izB.setTextColor(this.mContext.getResources().getColor(a.a.grey_background_text_color));
          this.izB.setBackgroundDrawable(l.z(this.mContext, this.mContext.getResources().getColor(a.a.card_accept_btn_disable_bg_color)));
          if (!TextUtils.isEmpty(this.ikk.azx().sIO)) {
            this.izB.setText(this.ikk.azx().sIO);
          } else {
            m.c(this.izB, this.ikk.azy().status);
          }
        }
        else
        {
          y.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
          this.izB.setVisibility(8);
          this.izD.setVisibility(8);
          this.izG.setVisibility(8);
        }
      }
    }
  }
  
  public final void aDo()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.izC.getLayoutParams();
    if (this.ikk.aze())
    {
      this.izx.setVisibility(0);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.b.card_coupon_widget_body_top_margin);
    }
    this.izC.setLayoutParams(localLayoutParams);
    this.izC.invalidate();
  }
  
  public final void eE(boolean paramBoolean)
  {
    this.ixx = paramBoolean;
    if (paramBoolean)
    {
      this.izF.setVisibility(0);
      return;
    }
    this.izF.setVisibility(8);
  }
  
  public final void ph(int paramInt)
  {
    this.izC.setBackgroundResource(paramInt);
    this.izE.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.izC.getLayoutParams();
      if (this.ikk.azd())
      {
        this.izx.setVisibility(8);
        localLayoutParams.topMargin = 0;
        this.izE.setVisibility(0);
        int i = this.mContext.getResources().getDimensionPixelSize(a.b.card_app_small_logo_height);
        m.a(this.izE, this.ikk.azx().ilp, i, a.c.my_card_package_defaultlogo, false);
        this.izC.setLayoutParams(localLayoutParams);
        this.izC.invalidate();
        label119:
        aDn();
        localLayoutParams = (RelativeLayout.LayoutParams)this.izF.getLayoutParams();
        if (paramInt != 0) {
          break label214;
        }
        localLayoutParams.leftMargin = 0;
      }
    }
    for (localLayoutParams.rightMargin = 0;; localLayoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(a.b.BiggerPadding))
    {
      this.izF.setLayoutParams(localLayoutParams);
      this.izF.invalidate();
      this.izw.invalidate();
      return;
      if ((!this.ikk.aze()) || (!this.ixx)) {
        break;
      }
      this.izx.setVisibility(8);
      localLayoutParams.topMargin = 0;
      break;
      aDm();
      break label119;
      label214:
      localLayoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(a.b.BiggerPadding);
    }
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    if (this.izB != null) {
      this.izB.setOnClickListener(paramOnClickListener);
    }
    if (this.izG != null) {
      this.izG.setOnClickListener(paramOnClickListener);
    }
  }
  
  public final void w(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.izB != null)
    {
      ra localra = this.ikk.azy().sHG;
      if ((localra != null) && (!TextUtils.isEmpty(localra.title)) && (localra.sJq != 0L) && (this.ikk.isNormal()))
      {
        this.izB.setClickable(false);
        this.izB.setVisibility(0);
        this.izG.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    if ((this.ikk.azy().sHF != null) && (!TextUtils.isEmpty(this.ikk.azy().sHF.title)) && (!TextUtils.isEmpty(this.ikk.azy().sHF.url)) && (this.ikk.isNormal()))
    {
      this.izB.setVisibility(0);
      this.izB.setEnabled(true);
      if ((!TextUtils.isEmpty(this.ikk.azy().code)) && (this.ikk.azy().sHx != 0))
      {
        this.izG.setVisibility(0);
        return;
      }
      this.izG.setVisibility(8);
      return;
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(this.ikk.azy().code)) && (this.ikk.isNormal()))
    {
      this.izB.setVisibility(0);
      this.izB.setEnabled(paramBoolean2);
      this.izG.setVisibility(8);
      return;
    }
    if ((paramBoolean1) && (!this.ikk.isNormal()))
    {
      this.izB.setVisibility(0);
      this.izB.setEnabled(false);
      this.izG.setVisibility(8);
      return;
    }
    this.izB.setVisibility(8);
    this.izG.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.b
 * JD-Core Version:    0.7.0.1
 */