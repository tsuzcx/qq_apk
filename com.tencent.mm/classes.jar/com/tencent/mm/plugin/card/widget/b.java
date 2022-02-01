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
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.dtp;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends a
{
  private final String TAG = "MicroMsg.CardWidgetCommon";
  protected TextView gnM;
  private boolean oKn = false;
  protected TextView oPX;
  protected TextView oPY;
  protected Button oPZ;
  protected LinearLayout oQa;
  protected TextView oQb;
  protected ImageView oQc;
  protected View oQd;
  protected ImageView oQe;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bYL()
  {
    AppMethodBeat.i(113895);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.oQa.getLayoutParams();
    if (this.owK.bTs())
    {
      this.oPW.setVisibility(0);
      this.oQc.setVisibility(8);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
    }
    for (;;)
    {
      this.oQa.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113895);
      return;
      if ((this.owK.bTt()) && (this.oKn))
      {
        this.oPW.setVisibility(8);
        this.oQc.setVisibility(8);
        localLayoutParams.topMargin = 0;
      }
      else if (this.owK.bTt())
      {
        this.oPW.setVisibility(0);
        this.oQc.setVisibility(8);
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
      }
    }
  }
  
  private void bYM()
  {
    AppMethodBeat.i(113897);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.oPZ.getLayoutParams();
    if ((this.owK.bTO().FPx != null) && (!TextUtils.isEmpty(this.owK.bTO().FPx.oxO))) {
      localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
    }
    for (;;)
    {
      this.oPZ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113897);
      return;
      if ((this.owK.bTO().FPy != null) && (!TextUtils.isEmpty(this.owK.bTO().FPy.oxN))) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
      } else if ((this.owK.bTN().FRz != null) && (this.owK.bTN().FRz.size() > 0)) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
      } else {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165483);
      }
    }
  }
  
  public final void AQ(int paramInt)
  {
    AppMethodBeat.i(113896);
    this.oQa.setBackgroundResource(paramInt);
    this.oQc.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.oQa.getLayoutParams();
      if (this.owK.bTs())
      {
        this.oPW.setVisibility(8);
        localLayoutParams.topMargin = 0;
        this.oQc.setVisibility(0);
        int i = this.mContext.getResources().getDimensionPixelSize(2131165955);
        n.a(this.oQc, this.owK.bTN().hzB, i, 2131233400, false);
        this.oQa.setLayoutParams(localLayoutParams);
        this.oQa.invalidate();
        label122:
        bYM();
        localLayoutParams = (RelativeLayout.LayoutParams)this.oQd.getLayoutParams();
        if (paramInt != 0) {
          break label222;
        }
        localLayoutParams.leftMargin = 0;
      }
    }
    for (localLayoutParams.rightMargin = 0;; localLayoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(2131165198))
    {
      this.oQd.setLayoutParams(localLayoutParams);
      this.oQd.invalidate();
      this.oPV.invalidate();
      AppMethodBeat.o(113896);
      return;
      if ((!this.owK.bTt()) || (!this.oKn)) {
        break;
      }
      this.oPW.setVisibility(8);
      localLayoutParams.topMargin = 0;
      break;
      bYL();
      break label122;
      label222:
      localLayoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(2131165198);
    }
  }
  
  public final void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113899);
    if (this.oPZ != null)
    {
      aaf localaaf = this.owK.bTO().FPy;
      if ((localaaf != null) && (!TextUtils.isEmpty(localaaf.title)) && (localaaf.FSA != 0L) && (this.owK.bTJ()))
      {
        this.oPZ.setClickable(false);
        this.oPZ.setVisibility(0);
        this.oQe.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((this.owK.bTO().FPx != null) && (!TextUtils.isEmpty(this.owK.bTO().FPx.title)) && (!TextUtils.isEmpty(this.owK.bTO().FPx.url)) && (this.owK.bTJ()))
      {
        this.oPZ.setVisibility(0);
        this.oPZ.setEnabled(true);
        if ((!TextUtils.isEmpty(this.owK.bTO().code)) && (this.owK.bTO().FPp != 0))
        {
          this.oQe.setVisibility(0);
          AppMethodBeat.o(113899);
          return;
        }
        this.oQe.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!TextUtils.isEmpty(this.owK.bTO().code)) && (this.owK.bTJ()))
      {
        this.oPZ.setVisibility(0);
        this.oPZ.setEnabled(paramBoolean2);
        this.oQe.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!this.owK.bTJ()))
      {
        this.oPZ.setVisibility(0);
        this.oPZ.setEnabled(false);
        this.oQe.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      this.oPZ.setVisibility(8);
      this.oQe.setVisibility(8);
    }
    AppMethodBeat.o(113899);
  }
  
  public final void bWD()
  {
    AppMethodBeat.i(113900);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.oQa.getLayoutParams();
    if (this.owK.bTt())
    {
      this.oPW.setVisibility(0);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
    }
    this.oQa.setLayoutParams(localLayoutParams);
    this.oQa.invalidate();
    AppMethodBeat.o(113900);
  }
  
  protected final void bYI()
  {
    AppMethodBeat.i(113893);
    this.gnM = ((TextView)this.oPV.findViewById(2131297911));
    this.oPX = ((TextView)this.oPV.findViewById(2131297903));
    this.oPY = ((TextView)this.oPV.findViewById(2131297734));
    this.oPZ = ((Button)this.oPV.findViewById(2131297769));
    this.oQa = ((LinearLayout)this.oPV.findViewById(2131306991));
    this.oQc = ((ImageView)this.oQa.findViewById(2131296874));
    this.oQd = this.oPV.findViewById(2131297740);
    this.oQe = ((ImageView)this.oPV.findViewById(2131297761));
    this.oQb = ((TextView)this.oPV.findViewById(2131297867));
    AppMethodBeat.o(113893);
  }
  
  protected final void bYJ()
  {
    AppMethodBeat.i(113894);
    aaf localaaf1;
    Object localObject1;
    if ((this.owK.bTN().FRz != null) && (this.owK.bTN().FRz.size() > 0))
    {
      localaaf1 = (aaf)this.owK.bTN().FRz.get(0);
      if (!bt.isNullOrNil(localaaf1.title)) {
        this.gnM.setText(localaaf1.title);
      }
      if (!bt.isNullOrNil(localaaf1.oxN))
      {
        this.oPX.setText(localaaf1.oxN);
        this.oPX.setVisibility(0);
        localObject1 = (LinearLayout.LayoutParams)this.oPX.getLayoutParams();
        if (bt.isNullOrNil(localaaf1.oxO)) {
          break label245;
        }
        this.oPY.setText(localaaf1.oxO);
        this.oPY.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        label154:
        this.oPX.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.oPX.invalidate();
      }
    }
    else
    {
      if ((this.oPZ != null) && (this.oQe != null)) {
        break label273;
      }
      ad.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
    }
    label1288:
    for (;;)
    {
      bYL();
      this.oQa.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231516));
      bYM();
      this.oPV.invalidate();
      AppMethodBeat.o(113894);
      return;
      this.oPX.setVisibility(8);
      break;
      label245:
      this.oPY.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelSize(2131165483);
      break label154;
      label273:
      if (this.owK.bTO() == null)
      {
        ad.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
        this.oPZ.setVisibility(8);
        this.oQe.setVisibility(8);
      }
      else
      {
        if (this.owK.bTO().FPx != null)
        {
          ad.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.owK.bTO().FPx.title);
          ad.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.owK.bTO().FPx.url);
          ad.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.owK.bTO().FPx.oxO);
        }
        localaaf1 = this.owK.bTO().FPy;
        if (localaaf1 != null)
        {
          ad.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + localaaf1.title);
          ad.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + localaaf1.FSA);
          ad.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + localaaf1.oxO);
        }
        Object localObject2 = this.owK.bTN().FRR;
        localObject1 = (LinearLayout)this.oQa.findViewById(2131297782);
        if ((localObject2 != null) && (!bt.hj(((dtp)localObject2).HGs)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((LinearLayout)localObject1).removeAllViews();
          localObject2 = ((dtp)localObject2).HGs.iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          aaf localaaf2 = (aaf)((Iterator)localObject2).next();
          View localView = LayoutInflater.from(this.mContext).inflate(2131493269, null);
          TextView localTextView1 = (TextView)localView.findViewById(2131297785);
          TextView localTextView2 = (TextView)localView.findViewById(2131297781);
          localTextView1.setText(localaaf2.title);
          localTextView2.setText(localaaf2.oxN);
          ((LinearLayout)localObject1).addView(localView);
          continue;
          ((LinearLayout)localObject1).setVisibility(8);
        }
        if ((localaaf1 != null) && (!TextUtils.isEmpty(localaaf1.title)) && (localaaf1.FSA != 0L) && (this.owK.bTJ()))
        {
          this.oPZ.setClickable(false);
          this.oPZ.setVisibility(0);
          this.oPZ.setTextColor(this.mContext.getResources().getColor(2131101185));
          this.oPZ.setText(localaaf1.title);
          if ((localaaf1 != null) && (!TextUtils.isEmpty(localaaf1.oxN)))
          {
            this.oQb.setText(localaaf1.oxN);
            this.oQb.setVisibility(0);
          }
          for (;;)
          {
            this.oQe.setVisibility(8);
            if ((localaaf1.FSA & 0x2) <= 0L) {
              break label890;
            }
            this.oPZ.setBackgroundDrawable(l.P(this.mContext, l.cJ(this.owK.bTN().hAD, 150)));
            this.oQb.setTextColor(l.Zh(this.owK.bTN().hAD));
            break;
            this.oQb.setVisibility(8);
          }
          label890:
          if ((localaaf1.FSA & 0x4) > 0L)
          {
            this.oPZ.setBackgroundDrawable(l.P(this.mContext, this.mContext.getResources().getColor(2131100540)));
            this.oQb.setTextColor(this.mContext.getResources().getColor(2131100707));
          }
          else
          {
            this.oPZ.setBackgroundDrawable(l.P(this.mContext, l.Zh(this.owK.bTN().hAD)));
            this.oQb.setTextColor(this.mContext.getResources().getColor(2131100707));
          }
        }
        else if ((this.owK.bTO().FPx != null) && (!TextUtils.isEmpty(this.owK.bTO().FPx.title)) && (!TextUtils.isEmpty(this.owK.bTO().FPx.url)) && (this.owK.bTJ()))
        {
          this.oPZ.setClickable(true);
          this.oPZ.setVisibility(0);
          this.oPZ.setBackgroundDrawable(l.P(this.mContext, l.Zh(this.owK.bTN().hAD)));
          this.oPZ.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
          this.oPZ.setText(this.owK.bTO().FPx.title);
          if ((this.owK.bTO().FPx != null) && (!TextUtils.isEmpty(this.owK.bTO().FPx.oxO)))
          {
            this.oQb.setTextColor(this.mContext.getResources().getColor(2131100707));
            this.oQb.setText(this.owK.bTO().FPx.oxO);
            this.oQb.setVisibility(0);
          }
          for (;;)
          {
            if (TextUtils.isEmpty(this.owK.bTO().code)) {
              break label1288;
            }
            this.oQe.setVisibility(0);
            break;
            this.oQb.setVisibility(8);
          }
          this.oQe.setVisibility(8);
        }
        else if ((!TextUtils.isEmpty(this.owK.bTO().code)) && (this.owK.bTJ()))
        {
          ad.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
          this.oQe.setVisibility(8);
          this.oQb.setVisibility(8);
          this.oPZ.setClickable(true);
          this.oPZ.setVisibility(0);
          this.oPZ.setBackgroundDrawable(l.P(this.mContext, l.Zh(this.owK.bTN().hAD)));
          this.oPZ.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
          this.oPZ.setText(2131757006);
        }
        else if (!this.owK.bTJ())
        {
          ad.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.owK.bTO().status);
          this.oQe.setVisibility(8);
          this.oQb.setVisibility(8);
          this.oPZ.setClickable(true);
          this.oPZ.setVisibility(0);
          this.oPZ.setTextColor(this.mContext.getResources().getColor(2131100469));
          this.oPZ.setBackgroundDrawable(l.P(this.mContext, this.mContext.getResources().getColor(2131100081)));
          if (!TextUtils.isEmpty(this.owK.bTN().FRW)) {
            this.oPZ.setText(this.owK.bTN().FRW);
          } else {
            n.h(this.oPZ, this.owK.bTO().status);
          }
        }
        else
        {
          ad.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
          this.oPZ.setVisibility(8);
          this.oQb.setVisibility(8);
          this.oQe.setVisibility(8);
        }
      }
    }
  }
  
  public final void jC(boolean paramBoolean)
  {
    AppMethodBeat.i(113901);
    this.oKn = paramBoolean;
    if (paramBoolean)
    {
      this.oQd.setVisibility(0);
      AppMethodBeat.o(113901);
      return;
    }
    this.oQd.setVisibility(8);
    AppMethodBeat.o(113901);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113898);
    super.setOnClickListener(paramOnClickListener);
    if (this.oPZ != null) {
      this.oPZ.setOnClickListener(paramOnClickListener);
    }
    if (this.oQe != null) {
      this.oQe.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(113898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.b
 * JD-Core Version:    0.7.0.1
 */