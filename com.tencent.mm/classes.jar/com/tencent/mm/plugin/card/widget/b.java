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
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends a
{
  private final String TAG = "MicroMsg.CardWidgetCommon";
  protected TextView gui;
  protected TextView kCE;
  protected TextView kCF;
  protected Button kCG;
  protected LinearLayout kCH;
  protected TextView kCI;
  protected ImageView kCJ;
  protected View kCK;
  protected ImageView kCL;
  private boolean kyA = false;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bfK()
  {
    AppMethodBeat.i(88967);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.kCH.getLayoutParams();
    if (this.klk.baJ())
    {
      this.kCD.setVisibility(0);
      this.kCJ.setVisibility(8);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131428162);
    }
    for (;;)
    {
      this.kCH.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(88967);
      return;
      if ((this.klk.baK()) && (this.kyA))
      {
        this.kCD.setVisibility(8);
        this.kCJ.setVisibility(8);
        localLayoutParams.topMargin = 0;
      }
      else if (this.klk.baK())
      {
        this.kCD.setVisibility(0);
        this.kCJ.setVisibility(8);
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131428162);
      }
    }
  }
  
  private void bfL()
  {
    AppMethodBeat.i(88969);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.kCG.getLayoutParams();
    if ((this.klk.bbe().wEb != null) && (!TextUtils.isEmpty(this.klk.bbe().wEb.kmo))) {
      localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131427808);
    }
    for (;;)
    {
      this.kCG.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(88969);
      return;
      if ((this.klk.bbe().wEc != null) && (!TextUtils.isEmpty(this.klk.bbe().wEc.kmn))) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131427808);
      } else if ((this.klk.bbd().wFZ != null) && (this.klk.bbd().wFZ.size() > 0)) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131427808);
      } else {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131427775);
      }
    }
  }
  
  public final void bdN()
  {
    AppMethodBeat.i(88972);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.kCH.getLayoutParams();
    if (this.klk.baK())
    {
      this.kCD.setVisibility(0);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131428162);
    }
    this.kCH.setLayoutParams(localLayoutParams);
    this.kCH.invalidate();
    AppMethodBeat.o(88972);
  }
  
  protected final void bfH()
  {
    AppMethodBeat.i(88965);
    this.gui = ((TextView)this.kCC.findViewById(2131822059));
    this.kCE = ((TextView)this.kCC.findViewById(2131822060));
    this.kCF = ((TextView)this.kCC.findViewById(2131822394));
    this.kCG = ((Button)this.kCC.findViewById(2131822393));
    this.kCH = ((LinearLayout)this.kCC.findViewById(2131822056));
    this.kCJ = ((ImageView)this.kCH.findViewById(2131822392));
    this.kCK = this.kCC.findViewById(2131822057);
    this.kCL = ((ImageView)this.kCC.findViewById(2131822058));
    this.kCI = ((TextView)this.kCC.findViewById(2131822308));
    AppMethodBeat.o(88965);
  }
  
  protected final void bfI()
  {
    AppMethodBeat.i(88966);
    uo localuo1;
    Object localObject1;
    if ((this.klk.bbd().wFZ != null) && (this.klk.bbd().wFZ.size() > 0))
    {
      localuo1 = (uo)this.klk.bbd().wFZ.get(0);
      if (!bo.isNullOrNil(localuo1.title)) {
        this.gui.setText(localuo1.title);
      }
      if (!bo.isNullOrNil(localuo1.kmn))
      {
        this.kCE.setText(localuo1.kmn);
        this.kCE.setVisibility(0);
        localObject1 = (LinearLayout.LayoutParams)this.kCE.getLayoutParams();
        if (bo.isNullOrNil(localuo1.kmo)) {
          break label241;
        }
        this.kCF.setText(localuo1.kmo);
        this.kCF.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        label153:
        this.kCE.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.kCE.invalidate();
      }
    }
    else
    {
      if ((this.kCG != null) && (this.kCL != null)) {
        break label269;
      }
      ab.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
    }
    label1283:
    for (;;)
    {
      bfK();
      this.kCH.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838183));
      bfL();
      this.kCC.invalidate();
      AppMethodBeat.o(88966);
      return;
      this.kCE.setVisibility(8);
      break;
      label241:
      this.kCF.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelSize(2131427775);
      break label153;
      label269:
      if (this.klk.bbe() == null)
      {
        ab.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
        this.kCG.setVisibility(8);
        this.kCL.setVisibility(8);
      }
      else
      {
        if (this.klk.bbe().wEb != null)
        {
          ab.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.klk.bbe().wEb.title);
          ab.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.klk.bbe().wEb.url);
          ab.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.klk.bbe().wEb.kmo);
        }
        localuo1 = this.klk.bbe().wEc;
        if (localuo1 != null)
        {
          ab.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + localuo1.title);
          ab.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + localuo1.wGZ);
          ab.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + localuo1.kmo);
        }
        Object localObject2 = this.klk.bbd().wGs;
        localObject1 = (LinearLayout)this.kCH.findViewById(2131822395);
        if ((localObject2 != null) && (!bo.es(((cpd)localObject2).xXV)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((LinearLayout)localObject1).removeAllViews();
          localObject2 = ((cpd)localObject2).xXV.iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          uo localuo2 = (uo)((Iterator)localObject2).next();
          View localView = LayoutInflater.from(this.mContext).inflate(2130968927, null);
          TextView localTextView1 = (TextView)localView.findViewById(2131822062);
          TextView localTextView2 = (TextView)localView.findViewById(2131822063);
          localTextView1.setText(localuo2.title);
          localTextView2.setText(localuo2.kmn);
          ((LinearLayout)localObject1).addView(localView);
          continue;
          ((LinearLayout)localObject1).setVisibility(8);
        }
        if ((localuo1 != null) && (!TextUtils.isEmpty(localuo1.title)) && (localuo1.wGZ != 0L) && (this.klk.isNormal()))
        {
          this.kCG.setClickable(false);
          this.kCG.setVisibility(0);
          this.kCG.setTextColor(this.mContext.getResources().getColor(2131690799));
          this.kCG.setText(localuo1.title);
          if ((localuo1 != null) && (!TextUtils.isEmpty(localuo1.kmn)))
          {
            this.kCI.setText(localuo1.kmn);
            this.kCI.setVisibility(0);
          }
          for (;;)
          {
            this.kCL.setVisibility(8);
            if ((localuo1.wGZ & 0x2) <= 0L) {
              break label885;
            }
            this.kCG.setBackgroundDrawable(l.I(this.mContext, l.bS(this.klk.bbd().color, 150)));
            this.kCI.setTextColor(l.IB(this.klk.bbd().color));
            break;
            this.kCI.setVisibility(8);
          }
          label885:
          if ((localuo1.wGZ & 0x4) > 0L)
          {
            this.kCG.setBackgroundDrawable(l.I(this.mContext, this.mContext.getResources().getColor(2131690207)));
            this.kCI.setTextColor(this.mContext.getResources().getColor(2131690318));
          }
          else
          {
            this.kCG.setBackgroundDrawable(l.I(this.mContext, l.IB(this.klk.bbd().color)));
            this.kCI.setTextColor(this.mContext.getResources().getColor(2131690318));
          }
        }
        else if ((this.klk.bbe().wEb != null) && (!TextUtils.isEmpty(this.klk.bbe().wEb.title)) && (!TextUtils.isEmpty(this.klk.bbe().wEb.url)) && (this.klk.isNormal()))
        {
          this.kCG.setClickable(true);
          this.kCG.setVisibility(0);
          this.kCG.setBackgroundDrawable(l.I(this.mContext, l.IB(this.klk.bbd().color)));
          this.kCG.setTextColor(this.mContext.getResources().getColorStateList(2131690799));
          this.kCG.setText(this.klk.bbe().wEb.title);
          if ((this.klk.bbe().wEb != null) && (!TextUtils.isEmpty(this.klk.bbe().wEb.kmo)))
          {
            this.kCI.setTextColor(this.mContext.getResources().getColor(2131690318));
            this.kCI.setText(this.klk.bbe().wEb.kmo);
            this.kCI.setVisibility(0);
          }
          for (;;)
          {
            if (TextUtils.isEmpty(this.klk.bbe().code)) {
              break label1283;
            }
            this.kCL.setVisibility(0);
            break;
            this.kCI.setVisibility(8);
          }
          this.kCL.setVisibility(8);
        }
        else if ((!TextUtils.isEmpty(this.klk.bbe().code)) && (this.klk.isNormal()))
        {
          ab.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
          this.kCL.setVisibility(8);
          this.kCI.setVisibility(8);
          this.kCG.setClickable(true);
          this.kCG.setVisibility(0);
          this.kCG.setBackgroundDrawable(l.I(this.mContext, l.IB(this.klk.bbd().color)));
          this.kCG.setTextColor(this.mContext.getResources().getColorStateList(2131690799));
          this.kCG.setText(2131298064);
        }
        else if (!this.klk.isNormal())
        {
          ab.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.klk.bbe().status);
          this.kCL.setVisibility(8);
          this.kCI.setVisibility(8);
          this.kCG.setClickable(true);
          this.kCG.setVisibility(0);
          this.kCG.setTextColor(this.mContext.getResources().getColor(2131690143));
          this.kCG.setBackgroundDrawable(l.I(this.mContext, this.mContext.getResources().getColor(2131689821)));
          if (!TextUtils.isEmpty(this.klk.bbd().wGx)) {
            this.kCG.setText(this.klk.bbd().wGx);
          } else {
            m.f(this.kCG, this.klk.bbe().status);
          }
        }
        else
        {
          ab.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
          this.kCG.setVisibility(8);
          this.kCI.setVisibility(8);
          this.kCL.setVisibility(8);
        }
      }
    }
  }
  
  public final void gd(boolean paramBoolean)
  {
    AppMethodBeat.i(88973);
    this.kyA = paramBoolean;
    if (paramBoolean)
    {
      this.kCK.setVisibility(0);
      AppMethodBeat.o(88973);
      return;
    }
    this.kCK.setVisibility(8);
    AppMethodBeat.o(88973);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(88970);
    super.setOnClickListener(paramOnClickListener);
    if (this.kCG != null) {
      this.kCG.setOnClickListener(paramOnClickListener);
    }
    if (this.kCL != null) {
      this.kCL.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(88970);
  }
  
  public final void tw(int paramInt)
  {
    AppMethodBeat.i(88968);
    this.kCH.setBackgroundResource(paramInt);
    this.kCJ.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.kCH.getLayoutParams();
      if (this.klk.baJ())
      {
        this.kCD.setVisibility(8);
        localLayoutParams.topMargin = 0;
        this.kCJ.setVisibility(0);
        int i = this.mContext.getResources().getDimensionPixelSize(2131428156);
        m.a(this.kCJ, this.klk.bbd().kmm, i, 2130839758, false);
        this.kCH.setLayoutParams(localLayoutParams);
        this.kCH.invalidate();
        label125:
        bfL();
        localLayoutParams = (RelativeLayout.LayoutParams)this.kCK.getLayoutParams();
        if (paramInt != 0) {
          break label226;
        }
        localLayoutParams.leftMargin = 0;
      }
    }
    for (localLayoutParams.rightMargin = 0;; localLayoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(2131427506))
    {
      this.kCK.setLayoutParams(localLayoutParams);
      this.kCK.invalidate();
      this.kCC.invalidate();
      AppMethodBeat.o(88968);
      return;
      if ((!this.klk.baK()) || (!this.kyA)) {
        break;
      }
      this.kCD.setVisibility(8);
      localLayoutParams.topMargin = 0;
      break;
      bfK();
      break label125;
      label226:
      localLayoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(2131427506);
    }
  }
  
  public final void x(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(88971);
    if (this.kCG != null)
    {
      uo localuo = this.klk.bbe().wEc;
      if ((localuo != null) && (!TextUtils.isEmpty(localuo.title)) && (localuo.wGZ != 0L) && (this.klk.isNormal()))
      {
        this.kCG.setClickable(false);
        this.kCG.setVisibility(0);
        this.kCL.setVisibility(8);
        AppMethodBeat.o(88971);
        return;
      }
      if ((this.klk.bbe().wEb != null) && (!TextUtils.isEmpty(this.klk.bbe().wEb.title)) && (!TextUtils.isEmpty(this.klk.bbe().wEb.url)) && (this.klk.isNormal()))
      {
        this.kCG.setVisibility(0);
        this.kCG.setEnabled(true);
        if ((!TextUtils.isEmpty(this.klk.bbe().code)) && (this.klk.bbe().wDT != 0))
        {
          this.kCL.setVisibility(0);
          AppMethodBeat.o(88971);
          return;
        }
        this.kCL.setVisibility(8);
        AppMethodBeat.o(88971);
        return;
      }
      if ((paramBoolean1) && (!TextUtils.isEmpty(this.klk.bbe().code)) && (this.klk.isNormal()))
      {
        this.kCG.setVisibility(0);
        this.kCG.setEnabled(paramBoolean2);
        this.kCL.setVisibility(8);
        AppMethodBeat.o(88971);
        return;
      }
      if ((paramBoolean1) && (!this.klk.isNormal()))
      {
        this.kCG.setVisibility(0);
        this.kCG.setEnabled(false);
        this.kCL.setVisibility(8);
        AppMethodBeat.o(88971);
        return;
      }
      this.kCG.setVisibility(8);
      this.kCL.setVisibility(8);
    }
    AppMethodBeat.o(88971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.b
 * JD-Core Version:    0.7.0.1
 */