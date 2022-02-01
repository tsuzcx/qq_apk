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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.eyt;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends a
{
  private final String TAG = "MicroMsg.CardWidgetCommon";
  protected TextView jMg;
  private boolean tAA = false;
  protected TextView tHo;
  protected TextView tHp;
  protected Button tHq;
  protected LinearLayout tHr;
  protected TextView tHs;
  protected ImageView tHt;
  protected View tHu;
  protected ImageView tHv;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private void cLr()
  {
    AppMethodBeat.i(113895);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.tHr.getLayoutParams();
    if (this.tmU.cFW())
    {
      this.tHn.setVisibility(0);
      this.tHt.setVisibility(8);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.b.sZE);
    }
    for (;;)
    {
      this.tHr.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113895);
      return;
      if ((this.tmU.cFX()) && (this.tAA))
      {
        this.tHn.setVisibility(8);
        this.tHt.setVisibility(8);
        localLayoutParams.topMargin = 0;
      }
      else if (this.tmU.cFX())
      {
        this.tHn.setVisibility(0);
        this.tHt.setVisibility(8);
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.b.sZE);
      }
    }
  }
  
  private void cLs()
  {
    AppMethodBeat.i(113897);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.tHq.getLayoutParams();
    if ((this.tmU.cGt().SdM != null) && (!TextUtils.isEmpty(this.tmU.cGt().SdM.tnZ))) {
      localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.NormalPadding);
    }
    for (;;)
    {
      this.tHq.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113897);
      return;
      if ((this.tmU.cGt().SdN != null) && (!TextUtils.isEmpty(this.tmU.cGt().SdN.tnY))) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.NormalPadding);
      } else if ((this.tmU.cGs().SfP != null) && (this.tmU.cGs().SfP.size() > 0)) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.NormalPadding);
      } else {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LargerPadding);
      }
    }
  }
  
  public final void Il(int paramInt)
  {
    AppMethodBeat.i(113896);
    this.tHr.setBackgroundResource(paramInt);
    this.tHt.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.tHr.getLayoutParams();
      if (this.tmU.cFW())
      {
        this.tHn.setVisibility(8);
        localLayoutParams.topMargin = 0;
        this.tHt.setVisibility(0);
        int i = this.mContext.getResources().getDimensionPixelSize(a.b.sZA);
        n.a(this.tHt, this.tmU.cGs().llI, i, a.c.my_card_package_defaultlogo, false);
        this.tHr.setLayoutParams(localLayoutParams);
        this.tHr.invalidate();
        label124:
        cLs();
        localLayoutParams = (RelativeLayout.LayoutParams)this.tHu.getLayoutParams();
        if (paramInt != 0) {
          break label224;
        }
        localLayoutParams.leftMargin = 0;
      }
    }
    for (localLayoutParams.rightMargin = 0;; localLayoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(a.b.BiggerPadding))
    {
      this.tHu.setLayoutParams(localLayoutParams);
      this.tHu.invalidate();
      this.tHm.invalidate();
      AppMethodBeat.o(113896);
      return;
      if ((!this.tmU.cFX()) || (!this.tAA)) {
        break;
      }
      this.tHn.setVisibility(8);
      localLayoutParams.topMargin = 0;
      break;
      cLr();
      break label124;
      label224:
      localLayoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(a.b.BiggerPadding);
    }
  }
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113899);
    if (this.tHq != null)
    {
      acg localacg = this.tmU.cGt().SdN;
      if ((localacg != null) && (!TextUtils.isEmpty(localacg.title)) && (localacg.SgR != 0L) && (this.tmU.cGn()))
      {
        this.tHq.setClickable(false);
        this.tHq.setVisibility(0);
        this.tHv.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((this.tmU.cGt().SdM != null) && (!TextUtils.isEmpty(this.tmU.cGt().SdM.title)) && (!TextUtils.isEmpty(this.tmU.cGt().SdM.url)) && (this.tmU.cGn()))
      {
        this.tHq.setVisibility(0);
        this.tHq.setEnabled(true);
        if ((!TextUtils.isEmpty(this.tmU.cGt().code)) && (this.tmU.cGt().SdE != 0))
        {
          this.tHv.setVisibility(0);
          AppMethodBeat.o(113899);
          return;
        }
        this.tHv.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!TextUtils.isEmpty(this.tmU.cGt().code)) && (this.tmU.cGn()))
      {
        this.tHq.setVisibility(0);
        this.tHq.setEnabled(paramBoolean2);
        this.tHv.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!this.tmU.cGn()))
      {
        this.tHq.setVisibility(0);
        this.tHq.setEnabled(false);
        this.tHv.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      this.tHq.setVisibility(8);
      this.tHv.setVisibility(8);
    }
    AppMethodBeat.o(113899);
  }
  
  public final void cJk()
  {
    AppMethodBeat.i(113900);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.tHr.getLayoutParams();
    if (this.tmU.cFX())
    {
      this.tHn.setVisibility(0);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.b.sZE);
    }
    this.tHr.setLayoutParams(localLayoutParams);
    this.tHr.invalidate();
    AppMethodBeat.o(113900);
  }
  
  protected final void cLo()
  {
    AppMethodBeat.i(113893);
    this.jMg = ((TextView)this.tHm.findViewById(a.d.dvg));
    this.tHo = ((TextView)this.tHm.findViewById(a.d.tdA));
    this.tHp = ((TextView)this.tHm.findViewById(a.d.tbi));
    this.tHq = ((Button)this.tHm.findViewById(a.d.tbG));
    this.tHr = ((LinearLayout)this.tHm.findViewById(a.d.ebj));
    this.tHt = ((ImageView)this.tHr.findViewById(a.d.taH));
    this.tHu = this.tHm.findViewById(a.d.tbn);
    this.tHv = ((ImageView)this.tHm.findViewById(a.d.tbA));
    this.tHs = ((TextView)this.tHm.findViewById(a.d.tcY));
    AppMethodBeat.o(113893);
  }
  
  protected final void cLp()
  {
    AppMethodBeat.i(113894);
    acg localacg1;
    Object localObject1;
    if ((this.tmU.cGs().SfP != null) && (this.tmU.cGs().SfP.size() > 0))
    {
      localacg1 = (acg)this.tmU.cGs().SfP.get(0);
      if (!Util.isNullOrNil(localacg1.title)) {
        this.jMg.setText(localacg1.title);
      }
      if (!Util.isNullOrNil(localacg1.tnY))
      {
        this.tHo.setText(localacg1.tnY);
        this.tHo.setVisibility(0);
        localObject1 = (LinearLayout.LayoutParams)this.tHo.getLayoutParams();
        if (Util.isNullOrNil(localacg1.tnZ)) {
          break label245;
        }
        this.tHp.setText(localacg1.tnZ);
        this.tHp.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        label154:
        this.tHo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.tHo.invalidate();
      }
    }
    else
    {
      if ((this.tHq != null) && (this.tHv != null)) {
        break label274;
      }
      Log.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
    }
    label1289:
    for (;;)
    {
      cLr();
      this.tHr.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.c.tat));
      cLs();
      this.tHm.invalidate();
      AppMethodBeat.o(113894);
      return;
      this.tHo.setVisibility(8);
      break;
      label245:
      this.tHp.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.b.LargerPadding);
      break label154;
      label274:
      if (this.tmU.cGt() == null)
      {
        Log.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
        this.tHq.setVisibility(8);
        this.tHv.setVisibility(8);
      }
      else
      {
        if (this.tmU.cGt().SdM != null)
        {
          Log.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.tmU.cGt().SdM.title);
          Log.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.tmU.cGt().SdM.url);
          Log.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.tmU.cGt().SdM.tnZ);
        }
        localacg1 = this.tmU.cGt().SdN;
        if (localacg1 != null)
        {
          Log.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + localacg1.title);
          Log.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + localacg1.SgR);
          Log.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + localacg1.tnZ);
        }
        Object localObject2 = this.tmU.cGs().Sgh;
        localObject1 = (LinearLayout)this.tHr.findViewById(a.d.tbP);
        if ((localObject2 != null) && (!Util.isNullOrNil(((eyt)localObject2).UyY)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((LinearLayout)localObject1).removeAllViews();
          localObject2 = ((eyt)localObject2).UyY.iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          acg localacg2 = (acg)((Iterator)localObject2).next();
          View localView = LayoutInflater.from(this.mContext).inflate(a.e.thY, null);
          TextView localTextView1 = (TextView)localView.findViewById(a.d.tbS);
          TextView localTextView2 = (TextView)localView.findViewById(a.d.tbO);
          localTextView1.setText(localacg2.title);
          localTextView2.setText(localacg2.tnY);
          ((LinearLayout)localObject1).addView(localView);
          continue;
          ((LinearLayout)localObject1).setVisibility(8);
        }
        if ((localacg1 != null) && (!TextUtils.isEmpty(localacg1.title)) && (localacg1.SgR != 0L) && (this.tmU.cGn()))
        {
          this.tHq.setClickable(false);
          this.tHq.setVisibility(0);
          this.tHq.setTextColor(this.mContext.getResources().getColor(a.a.white_text_color_selector));
          this.tHq.setText(localacg1.title);
          if ((localacg1 != null) && (!TextUtils.isEmpty(localacg1.tnY)))
          {
            this.tHs.setText(localacg1.tnY);
            this.tHs.setVisibility(0);
          }
          for (;;)
          {
            this.tHv.setVisibility(8);
            if ((localacg1.SgR & 0x2) <= 0L) {
              break label891;
            }
            this.tHq.setBackgroundDrawable(l.Z(this.mContext, l.convertStringToRGB(this.tmU.cGs().lmL, 150)));
            this.tHs.setTextColor(l.arR(this.tmU.cGs().lmL));
            break;
            this.tHs.setVisibility(8);
          }
          label891:
          if ((localacg1.SgR & 0x4) > 0L)
          {
            this.tHq.setBackgroundDrawable(l.Z(this.mContext, this.mContext.getResources().getColor(a.a.light_grey)));
            this.tHs.setTextColor(this.mContext.getResources().getColor(a.a.normal_color));
          }
          else
          {
            this.tHq.setBackgroundDrawable(l.Z(this.mContext, l.arR(this.tmU.cGs().lmL)));
            this.tHs.setTextColor(this.mContext.getResources().getColor(a.a.normal_color));
          }
        }
        else if ((this.tmU.cGt().SdM != null) && (!TextUtils.isEmpty(this.tmU.cGt().SdM.title)) && (!TextUtils.isEmpty(this.tmU.cGt().SdM.url)) && (this.tmU.cGn()))
        {
          this.tHq.setClickable(true);
          this.tHq.setVisibility(0);
          this.tHq.setBackgroundDrawable(l.Z(this.mContext, l.arR(this.tmU.cGs().lmL)));
          this.tHq.setTextColor(this.mContext.getResources().getColorStateList(a.a.white_text_color_selector));
          this.tHq.setText(this.tmU.cGt().SdM.title);
          if ((this.tmU.cGt().SdM != null) && (!TextUtils.isEmpty(this.tmU.cGt().SdM.tnZ)))
          {
            this.tHs.setTextColor(this.mContext.getResources().getColor(a.a.normal_color));
            this.tHs.setText(this.tmU.cGt().SdM.tnZ);
            this.tHs.setVisibility(0);
          }
          for (;;)
          {
            if (TextUtils.isEmpty(this.tmU.cGt().code)) {
              break label1289;
            }
            this.tHv.setVisibility(0);
            break;
            this.tHs.setVisibility(8);
          }
          this.tHv.setVisibility(8);
        }
        else if ((!TextUtils.isEmpty(this.tmU.cGt().code)) && (this.tmU.cGn()))
        {
          Log.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
          this.tHv.setVisibility(8);
          this.tHs.setVisibility(8);
          this.tHq.setClickable(true);
          this.tHq.setVisibility(0);
          this.tHq.setBackgroundDrawable(l.Z(this.mContext, l.arR(this.tmU.cGs().lmL)));
          this.tHq.setTextColor(this.mContext.getResources().getColorStateList(a.a.white_text_color_selector));
          this.tHq.setText(a.g.tlU);
        }
        else if (!this.tmU.cGn())
        {
          Log.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.tmU.cGt().status);
          this.tHv.setVisibility(8);
          this.tHs.setVisibility(8);
          this.tHq.setClickable(true);
          this.tHq.setVisibility(0);
          this.tHq.setTextColor(this.mContext.getResources().getColor(a.a.grey_background_text_color));
          this.tHq.setBackgroundDrawable(l.Z(this.mContext, this.mContext.getResources().getColor(a.a.sZq)));
          if (!TextUtils.isEmpty(this.tmU.cGs().Sgm)) {
            this.tHq.setText(this.tmU.cGs().Sgm);
          } else {
            n.h(this.tHq, this.tmU.cGt().status);
          }
        }
        else
        {
          Log.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
          this.tHq.setVisibility(8);
          this.tHs.setVisibility(8);
          this.tHv.setVisibility(8);
        }
      }
    }
  }
  
  public final void lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(113901);
    this.tAA = paramBoolean;
    if (paramBoolean)
    {
      this.tHu.setVisibility(0);
      AppMethodBeat.o(113901);
      return;
    }
    this.tHu.setVisibility(8);
    AppMethodBeat.o(113901);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113898);
    super.setOnClickListener(paramOnClickListener);
    if (this.tHq != null) {
      this.tHq.setOnClickListener(paramOnClickListener);
    }
    if (this.tHv != null) {
      this.tHv.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(113898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.b
 * JD-Core Version:    0.7.0.1
 */