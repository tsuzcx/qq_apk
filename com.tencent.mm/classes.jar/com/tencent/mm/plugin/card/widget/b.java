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
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends a
{
  private final String TAG = "MicroMsg.CardWidgetCommon";
  protected TextView fQp;
  private boolean nDT = false;
  protected TextView nJC;
  protected TextView nJD;
  protected Button nJE;
  protected LinearLayout nJF;
  protected TextView nJG;
  protected ImageView nJH;
  protected View nJI;
  protected ImageView nJJ;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bMV()
  {
    AppMethodBeat.i(113895);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.nJF.getLayoutParams();
    if (this.nqp.bHA())
    {
      this.nJB.setVisibility(0);
      this.nJH.setVisibility(8);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
    }
    for (;;)
    {
      this.nJF.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113895);
      return;
      if ((this.nqp.bHB()) && (this.nDT))
      {
        this.nJB.setVisibility(8);
        this.nJH.setVisibility(8);
        localLayoutParams.topMargin = 0;
      }
      else if (this.nqp.bHB())
      {
        this.nJB.setVisibility(0);
        this.nJH.setVisibility(8);
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
      }
    }
  }
  
  private void bMW()
  {
    AppMethodBeat.i(113897);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.nJE.getLayoutParams();
    if ((this.nqp.bHW().CPC != null) && (!TextUtils.isEmpty(this.nqp.bHW().CPC.nrt))) {
      localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
    }
    for (;;)
    {
      this.nJE.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113897);
      return;
      if ((this.nqp.bHW().CPD != null) && (!TextUtils.isEmpty(this.nqp.bHW().CPD.nrs))) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
      } else if ((this.nqp.bHV().CRF != null) && (this.nqp.bHV().CRF.size() > 0)) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
      } else {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165483);
      }
    }
  }
  
  public final void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113899);
    if (this.nJE != null)
    {
      xo localxo = this.nqp.bHW().CPD;
      if ((localxo != null) && (!TextUtils.isEmpty(localxo.title)) && (localxo.CSH != 0L) && (this.nqp.bHR()))
      {
        this.nJE.setClickable(false);
        this.nJE.setVisibility(0);
        this.nJJ.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((this.nqp.bHW().CPC != null) && (!TextUtils.isEmpty(this.nqp.bHW().CPC.title)) && (!TextUtils.isEmpty(this.nqp.bHW().CPC.url)) && (this.nqp.bHR()))
      {
        this.nJE.setVisibility(0);
        this.nJE.setEnabled(true);
        if ((!TextUtils.isEmpty(this.nqp.bHW().code)) && (this.nqp.bHW().CPu != 0))
        {
          this.nJJ.setVisibility(0);
          AppMethodBeat.o(113899);
          return;
        }
        this.nJJ.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!TextUtils.isEmpty(this.nqp.bHW().code)) && (this.nqp.bHR()))
      {
        this.nJE.setVisibility(0);
        this.nJE.setEnabled(paramBoolean2);
        this.nJJ.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!this.nqp.bHR()))
      {
        this.nJE.setVisibility(0);
        this.nJE.setEnabled(false);
        this.nJJ.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      this.nJE.setVisibility(8);
      this.nJJ.setVisibility(8);
    }
    AppMethodBeat.o(113899);
  }
  
  public final void bKL()
  {
    AppMethodBeat.i(113900);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.nJF.getLayoutParams();
    if (this.nqp.bHB())
    {
      this.nJB.setVisibility(0);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
    }
    this.nJF.setLayoutParams(localLayoutParams);
    this.nJF.invalidate();
    AppMethodBeat.o(113900);
  }
  
  protected final void bMS()
  {
    AppMethodBeat.i(113893);
    this.fQp = ((TextView)this.nJA.findViewById(2131297911));
    this.nJC = ((TextView)this.nJA.findViewById(2131297903));
    this.nJD = ((TextView)this.nJA.findViewById(2131297734));
    this.nJE = ((Button)this.nJA.findViewById(2131297769));
    this.nJF = ((LinearLayout)this.nJA.findViewById(2131306991));
    this.nJH = ((ImageView)this.nJF.findViewById(2131296874));
    this.nJI = this.nJA.findViewById(2131297740);
    this.nJJ = ((ImageView)this.nJA.findViewById(2131297761));
    this.nJG = ((TextView)this.nJA.findViewById(2131297867));
    AppMethodBeat.o(113893);
  }
  
  protected final void bMT()
  {
    AppMethodBeat.i(113894);
    xo localxo1;
    Object localObject1;
    if ((this.nqp.bHV().CRF != null) && (this.nqp.bHV().CRF.size() > 0))
    {
      localxo1 = (xo)this.nqp.bHV().CRF.get(0);
      if (!bt.isNullOrNil(localxo1.title)) {
        this.fQp.setText(localxo1.title);
      }
      if (!bt.isNullOrNil(localxo1.nrs))
      {
        this.nJC.setText(localxo1.nrs);
        this.nJC.setVisibility(0);
        localObject1 = (LinearLayout.LayoutParams)this.nJC.getLayoutParams();
        if (bt.isNullOrNil(localxo1.nrt)) {
          break label243;
        }
        this.nJD.setText(localxo1.nrt);
        this.nJD.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        label153:
        this.nJC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.nJC.invalidate();
      }
    }
    else
    {
      if ((this.nJE != null) && (this.nJJ != null)) {
        break label271;
      }
      ad.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
    }
    label1286:
    for (;;)
    {
      bMV();
      this.nJF.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231516));
      bMW();
      this.nJA.invalidate();
      AppMethodBeat.o(113894);
      return;
      this.nJC.setVisibility(8);
      break;
      label243:
      this.nJD.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelSize(2131165483);
      break label153;
      label271:
      if (this.nqp.bHW() == null)
      {
        ad.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
        this.nJE.setVisibility(8);
        this.nJJ.setVisibility(8);
      }
      else
      {
        if (this.nqp.bHW().CPC != null)
        {
          ad.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.nqp.bHW().CPC.title);
          ad.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.nqp.bHW().CPC.url);
          ad.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.nqp.bHW().CPC.nrt);
        }
        localxo1 = this.nqp.bHW().CPD;
        if (localxo1 != null)
        {
          ad.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + localxo1.title);
          ad.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + localxo1.CSH);
          ad.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + localxo1.nrt);
        }
        Object localObject2 = this.nqp.bHV().CRX;
        localObject1 = (LinearLayout)this.nJF.findViewById(2131297782);
        if ((localObject2 != null) && (!bt.gL(((dij)localObject2).EyC)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((LinearLayout)localObject1).removeAllViews();
          localObject2 = ((dij)localObject2).EyC.iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          xo localxo2 = (xo)((Iterator)localObject2).next();
          View localView = LayoutInflater.from(this.mContext).inflate(2131493269, null);
          TextView localTextView1 = (TextView)localView.findViewById(2131297785);
          TextView localTextView2 = (TextView)localView.findViewById(2131297781);
          localTextView1.setText(localxo2.title);
          localTextView2.setText(localxo2.nrs);
          ((LinearLayout)localObject1).addView(localView);
          continue;
          ((LinearLayout)localObject1).setVisibility(8);
        }
        if ((localxo1 != null) && (!TextUtils.isEmpty(localxo1.title)) && (localxo1.CSH != 0L) && (this.nqp.bHR()))
        {
          this.nJE.setClickable(false);
          this.nJE.setVisibility(0);
          this.nJE.setTextColor(this.mContext.getResources().getColor(2131101185));
          this.nJE.setText(localxo1.title);
          if ((localxo1 != null) && (!TextUtils.isEmpty(localxo1.nrs)))
          {
            this.nJG.setText(localxo1.nrs);
            this.nJG.setVisibility(0);
          }
          for (;;)
          {
            this.nJJ.setVisibility(8);
            if ((localxo1.CSH & 0x2) <= 0L) {
              break label888;
            }
            this.nJE.setBackgroundDrawable(l.K(this.mContext, l.cB(this.nqp.bHV().gHT, 150)));
            this.nJG.setTextColor(l.Rm(this.nqp.bHV().gHT));
            break;
            this.nJG.setVisibility(8);
          }
          label888:
          if ((localxo1.CSH & 0x4) > 0L)
          {
            this.nJE.setBackgroundDrawable(l.K(this.mContext, this.mContext.getResources().getColor(2131100540)));
            this.nJG.setTextColor(this.mContext.getResources().getColor(2131100707));
          }
          else
          {
            this.nJE.setBackgroundDrawable(l.K(this.mContext, l.Rm(this.nqp.bHV().gHT)));
            this.nJG.setTextColor(this.mContext.getResources().getColor(2131100707));
          }
        }
        else if ((this.nqp.bHW().CPC != null) && (!TextUtils.isEmpty(this.nqp.bHW().CPC.title)) && (!TextUtils.isEmpty(this.nqp.bHW().CPC.url)) && (this.nqp.bHR()))
        {
          this.nJE.setClickable(true);
          this.nJE.setVisibility(0);
          this.nJE.setBackgroundDrawable(l.K(this.mContext, l.Rm(this.nqp.bHV().gHT)));
          this.nJE.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
          this.nJE.setText(this.nqp.bHW().CPC.title);
          if ((this.nqp.bHW().CPC != null) && (!TextUtils.isEmpty(this.nqp.bHW().CPC.nrt)))
          {
            this.nJG.setTextColor(this.mContext.getResources().getColor(2131100707));
            this.nJG.setText(this.nqp.bHW().CPC.nrt);
            this.nJG.setVisibility(0);
          }
          for (;;)
          {
            if (TextUtils.isEmpty(this.nqp.bHW().code)) {
              break label1286;
            }
            this.nJJ.setVisibility(0);
            break;
            this.nJG.setVisibility(8);
          }
          this.nJJ.setVisibility(8);
        }
        else if ((!TextUtils.isEmpty(this.nqp.bHW().code)) && (this.nqp.bHR()))
        {
          ad.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
          this.nJJ.setVisibility(8);
          this.nJG.setVisibility(8);
          this.nJE.setClickable(true);
          this.nJE.setVisibility(0);
          this.nJE.setBackgroundDrawable(l.K(this.mContext, l.Rm(this.nqp.bHV().gHT)));
          this.nJE.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
          this.nJE.setText(2131757006);
        }
        else if (!this.nqp.bHR())
        {
          ad.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.nqp.bHW().status);
          this.nJJ.setVisibility(8);
          this.nJG.setVisibility(8);
          this.nJE.setClickable(true);
          this.nJE.setVisibility(0);
          this.nJE.setTextColor(this.mContext.getResources().getColor(2131100469));
          this.nJE.setBackgroundDrawable(l.K(this.mContext, this.mContext.getResources().getColor(2131100081)));
          if (!TextUtils.isEmpty(this.nqp.bHV().CSc)) {
            this.nJE.setText(this.nqp.bHV().CSc);
          } else {
            n.h(this.nJE, this.nqp.bHW().status);
          }
        }
        else
        {
          ad.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
          this.nJE.setVisibility(8);
          this.nJG.setVisibility(8);
          this.nJJ.setVisibility(8);
        }
      }
    }
  }
  
  public final void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(113901);
    this.nDT = paramBoolean;
    if (paramBoolean)
    {
      this.nJI.setVisibility(0);
      AppMethodBeat.o(113901);
      return;
    }
    this.nJI.setVisibility(8);
    AppMethodBeat.o(113901);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113898);
    super.setOnClickListener(paramOnClickListener);
    if (this.nJE != null) {
      this.nJE.setOnClickListener(paramOnClickListener);
    }
    if (this.nJJ != null) {
      this.nJJ.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(113898);
  }
  
  public final void zq(int paramInt)
  {
    AppMethodBeat.i(113896);
    this.nJF.setBackgroundResource(paramInt);
    this.nJH.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.nJF.getLayoutParams();
      if (this.nqp.bHA())
      {
        this.nJB.setVisibility(8);
        localLayoutParams.topMargin = 0;
        this.nJH.setVisibility(0);
        int i = this.mContext.getResources().getDimensionPixelSize(2131165955);
        n.a(this.nJH, this.nqp.bHV().gGR, i, 2131233400, false);
        this.nJF.setLayoutParams(localLayoutParams);
        this.nJF.invalidate();
        label125:
        bMW();
        localLayoutParams = (RelativeLayout.LayoutParams)this.nJI.getLayoutParams();
        if (paramInt != 0) {
          break label226;
        }
        localLayoutParams.leftMargin = 0;
      }
    }
    for (localLayoutParams.rightMargin = 0;; localLayoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(2131165198))
    {
      this.nJI.setLayoutParams(localLayoutParams);
      this.nJI.invalidate();
      this.nJA.invalidate();
      AppMethodBeat.o(113896);
      return;
      if ((!this.nqp.bHB()) || (!this.nDT)) {
        break;
      }
      this.nJB.setVisibility(8);
      localLayoutParams.topMargin = 0;
      break;
      bMV();
      break label125;
      label226:
      localLayoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(2131165198);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.b
 * JD-Core Version:    0.7.0.1
 */