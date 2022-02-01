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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.dum;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends a
{
  private final String TAG = "MicroMsg.CardWidgetCommon";
  protected TextView gqi;
  private boolean oQP = false;
  protected TextView oWA;
  protected Button oWB;
  protected LinearLayout oWC;
  protected TextView oWD;
  protected ImageView oWE;
  protected View oWF;
  protected ImageView oWG;
  protected TextView oWz;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private void caa()
  {
    AppMethodBeat.i(113895);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.oWC.getLayoutParams();
    if (this.oDm.bUH())
    {
      this.oWy.setVisibility(0);
      this.oWE.setVisibility(8);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
    }
    for (;;)
    {
      this.oWC.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113895);
      return;
      if ((this.oDm.bUI()) && (this.oQP))
      {
        this.oWy.setVisibility(8);
        this.oWE.setVisibility(8);
        localLayoutParams.topMargin = 0;
      }
      else if (this.oDm.bUI())
      {
        this.oWy.setVisibility(0);
        this.oWE.setVisibility(8);
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
      }
    }
  }
  
  private void cab()
  {
    AppMethodBeat.i(113897);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.oWB.getLayoutParams();
    if ((this.oDm.bVd().GhW != null) && (!TextUtils.isEmpty(this.oDm.bVd().GhW.oEq))) {
      localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
    }
    for (;;)
    {
      this.oWB.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113897);
      return;
      if ((this.oDm.bVd().GhX != null) && (!TextUtils.isEmpty(this.oDm.bVd().GhX.oEp))) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
      } else if ((this.oDm.bVc().GjY != null) && (this.oDm.bVc().GjY.size() > 0)) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
      } else {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165483);
      }
    }
  }
  
  public final void Bc(int paramInt)
  {
    AppMethodBeat.i(113896);
    this.oWC.setBackgroundResource(paramInt);
    this.oWE.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.oWC.getLayoutParams();
      if (this.oDm.bUH())
      {
        this.oWy.setVisibility(8);
        localLayoutParams.topMargin = 0;
        this.oWE.setVisibility(0);
        int i = this.mContext.getResources().getDimensionPixelSize(2131165955);
        n.a(this.oWE, this.oDm.bVc().hCp, i, 2131233400, false);
        this.oWC.setLayoutParams(localLayoutParams);
        this.oWC.invalidate();
        label122:
        cab();
        localLayoutParams = (RelativeLayout.LayoutParams)this.oWF.getLayoutParams();
        if (paramInt != 0) {
          break label222;
        }
        localLayoutParams.leftMargin = 0;
      }
    }
    for (localLayoutParams.rightMargin = 0;; localLayoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(2131165198))
    {
      this.oWF.setLayoutParams(localLayoutParams);
      this.oWF.invalidate();
      this.oWx.invalidate();
      AppMethodBeat.o(113896);
      return;
      if ((!this.oDm.bUI()) || (!this.oQP)) {
        break;
      }
      this.oWy.setVisibility(8);
      localLayoutParams.topMargin = 0;
      break;
      caa();
      break label122;
      label222:
      localLayoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(2131165198);
    }
  }
  
  public final void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113899);
    if (this.oWB != null)
    {
      aai localaai = this.oDm.bVd().GhX;
      if ((localaai != null) && (!TextUtils.isEmpty(localaai.title)) && (localaai.GkZ != 0L) && (this.oDm.bUY()))
      {
        this.oWB.setClickable(false);
        this.oWB.setVisibility(0);
        this.oWG.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((this.oDm.bVd().GhW != null) && (!TextUtils.isEmpty(this.oDm.bVd().GhW.title)) && (!TextUtils.isEmpty(this.oDm.bVd().GhW.url)) && (this.oDm.bUY()))
      {
        this.oWB.setVisibility(0);
        this.oWB.setEnabled(true);
        if ((!TextUtils.isEmpty(this.oDm.bVd().code)) && (this.oDm.bVd().GhO != 0))
        {
          this.oWG.setVisibility(0);
          AppMethodBeat.o(113899);
          return;
        }
        this.oWG.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!TextUtils.isEmpty(this.oDm.bVd().code)) && (this.oDm.bUY()))
      {
        this.oWB.setVisibility(0);
        this.oWB.setEnabled(paramBoolean2);
        this.oWG.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!this.oDm.bUY()))
      {
        this.oWB.setVisibility(0);
        this.oWB.setEnabled(false);
        this.oWG.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      this.oWB.setVisibility(8);
      this.oWG.setVisibility(8);
    }
    AppMethodBeat.o(113899);
  }
  
  public final void bXS()
  {
    AppMethodBeat.i(113900);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.oWC.getLayoutParams();
    if (this.oDm.bUI())
    {
      this.oWy.setVisibility(0);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
    }
    this.oWC.setLayoutParams(localLayoutParams);
    this.oWC.invalidate();
    AppMethodBeat.o(113900);
  }
  
  protected final void bZX()
  {
    AppMethodBeat.i(113893);
    this.gqi = ((TextView)this.oWx.findViewById(2131297911));
    this.oWz = ((TextView)this.oWx.findViewById(2131297903));
    this.oWA = ((TextView)this.oWx.findViewById(2131297734));
    this.oWB = ((Button)this.oWx.findViewById(2131297769));
    this.oWC = ((LinearLayout)this.oWx.findViewById(2131306991));
    this.oWE = ((ImageView)this.oWC.findViewById(2131296874));
    this.oWF = this.oWx.findViewById(2131297740);
    this.oWG = ((ImageView)this.oWx.findViewById(2131297761));
    this.oWD = ((TextView)this.oWx.findViewById(2131297867));
    AppMethodBeat.o(113893);
  }
  
  protected final void bZY()
  {
    AppMethodBeat.i(113894);
    aai localaai1;
    Object localObject1;
    if ((this.oDm.bVc().GjY != null) && (this.oDm.bVc().GjY.size() > 0))
    {
      localaai1 = (aai)this.oDm.bVc().GjY.get(0);
      if (!bu.isNullOrNil(localaai1.title)) {
        this.gqi.setText(localaai1.title);
      }
      if (!bu.isNullOrNil(localaai1.oEp))
      {
        this.oWz.setText(localaai1.oEp);
        this.oWz.setVisibility(0);
        localObject1 = (LinearLayout.LayoutParams)this.oWz.getLayoutParams();
        if (bu.isNullOrNil(localaai1.oEq)) {
          break label245;
        }
        this.oWA.setText(localaai1.oEq);
        this.oWA.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        label154:
        this.oWz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.oWz.invalidate();
      }
    }
    else
    {
      if ((this.oWB != null) && (this.oWG != null)) {
        break label273;
      }
      ae.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
    }
    label1288:
    for (;;)
    {
      caa();
      this.oWC.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231516));
      cab();
      this.oWx.invalidate();
      AppMethodBeat.o(113894);
      return;
      this.oWz.setVisibility(8);
      break;
      label245:
      this.oWA.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelSize(2131165483);
      break label154;
      label273:
      if (this.oDm.bVd() == null)
      {
        ae.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
        this.oWB.setVisibility(8);
        this.oWG.setVisibility(8);
      }
      else
      {
        if (this.oDm.bVd().GhW != null)
        {
          ae.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.oDm.bVd().GhW.title);
          ae.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.oDm.bVd().GhW.url);
          ae.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.oDm.bVd().GhW.oEq);
        }
        localaai1 = this.oDm.bVd().GhX;
        if (localaai1 != null)
        {
          ae.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + localaai1.title);
          ae.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + localaai1.GkZ);
          ae.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + localaai1.oEq);
        }
        Object localObject2 = this.oDm.bVc().Gkq;
        localObject1 = (LinearLayout)this.oWC.findViewById(2131297782);
        if ((localObject2 != null) && (!bu.ht(((dum)localObject2).Iaf)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((LinearLayout)localObject1).removeAllViews();
          localObject2 = ((dum)localObject2).Iaf.iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          aai localaai2 = (aai)((Iterator)localObject2).next();
          View localView = LayoutInflater.from(this.mContext).inflate(2131493269, null);
          TextView localTextView1 = (TextView)localView.findViewById(2131297785);
          TextView localTextView2 = (TextView)localView.findViewById(2131297781);
          localTextView1.setText(localaai2.title);
          localTextView2.setText(localaai2.oEp);
          ((LinearLayout)localObject1).addView(localView);
          continue;
          ((LinearLayout)localObject1).setVisibility(8);
        }
        if ((localaai1 != null) && (!TextUtils.isEmpty(localaai1.title)) && (localaai1.GkZ != 0L) && (this.oDm.bUY()))
        {
          this.oWB.setClickable(false);
          this.oWB.setVisibility(0);
          this.oWB.setTextColor(this.mContext.getResources().getColor(2131101185));
          this.oWB.setText(localaai1.title);
          if ((localaai1 != null) && (!TextUtils.isEmpty(localaai1.oEp)))
          {
            this.oWD.setText(localaai1.oEp);
            this.oWD.setVisibility(0);
          }
          for (;;)
          {
            this.oWG.setVisibility(8);
            if ((localaai1.GkZ & 0x2) <= 0L) {
              break label890;
            }
            this.oWB.setBackgroundDrawable(l.P(this.mContext, l.cN(this.oDm.bVc().hDr, 150)));
            this.oWD.setTextColor(l.ZY(this.oDm.bVc().hDr));
            break;
            this.oWD.setVisibility(8);
          }
          label890:
          if ((localaai1.GkZ & 0x4) > 0L)
          {
            this.oWB.setBackgroundDrawable(l.P(this.mContext, this.mContext.getResources().getColor(2131100540)));
            this.oWD.setTextColor(this.mContext.getResources().getColor(2131100707));
          }
          else
          {
            this.oWB.setBackgroundDrawable(l.P(this.mContext, l.ZY(this.oDm.bVc().hDr)));
            this.oWD.setTextColor(this.mContext.getResources().getColor(2131100707));
          }
        }
        else if ((this.oDm.bVd().GhW != null) && (!TextUtils.isEmpty(this.oDm.bVd().GhW.title)) && (!TextUtils.isEmpty(this.oDm.bVd().GhW.url)) && (this.oDm.bUY()))
        {
          this.oWB.setClickable(true);
          this.oWB.setVisibility(0);
          this.oWB.setBackgroundDrawable(l.P(this.mContext, l.ZY(this.oDm.bVc().hDr)));
          this.oWB.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
          this.oWB.setText(this.oDm.bVd().GhW.title);
          if ((this.oDm.bVd().GhW != null) && (!TextUtils.isEmpty(this.oDm.bVd().GhW.oEq)))
          {
            this.oWD.setTextColor(this.mContext.getResources().getColor(2131100707));
            this.oWD.setText(this.oDm.bVd().GhW.oEq);
            this.oWD.setVisibility(0);
          }
          for (;;)
          {
            if (TextUtils.isEmpty(this.oDm.bVd().code)) {
              break label1288;
            }
            this.oWG.setVisibility(0);
            break;
            this.oWD.setVisibility(8);
          }
          this.oWG.setVisibility(8);
        }
        else if ((!TextUtils.isEmpty(this.oDm.bVd().code)) && (this.oDm.bUY()))
        {
          ae.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
          this.oWG.setVisibility(8);
          this.oWD.setVisibility(8);
          this.oWB.setClickable(true);
          this.oWB.setVisibility(0);
          this.oWB.setBackgroundDrawable(l.P(this.mContext, l.ZY(this.oDm.bVc().hDr)));
          this.oWB.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
          this.oWB.setText(2131757006);
        }
        else if (!this.oDm.bUY())
        {
          ae.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.oDm.bVd().status);
          this.oWG.setVisibility(8);
          this.oWD.setVisibility(8);
          this.oWB.setClickable(true);
          this.oWB.setVisibility(0);
          this.oWB.setTextColor(this.mContext.getResources().getColor(2131100469));
          this.oWB.setBackgroundDrawable(l.P(this.mContext, this.mContext.getResources().getColor(2131100081)));
          if (!TextUtils.isEmpty(this.oDm.bVc().Gkv)) {
            this.oWB.setText(this.oDm.bVc().Gkv);
          } else {
            n.h(this.oWB, this.oDm.bVd().status);
          }
        }
        else
        {
          ae.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
          this.oWB.setVisibility(8);
          this.oWD.setVisibility(8);
          this.oWG.setVisibility(8);
        }
      }
    }
  }
  
  public final void jB(boolean paramBoolean)
  {
    AppMethodBeat.i(113901);
    this.oQP = paramBoolean;
    if (paramBoolean)
    {
      this.oWF.setVisibility(0);
      AppMethodBeat.o(113901);
      return;
    }
    this.oWF.setVisibility(8);
    AppMethodBeat.o(113901);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113898);
    super.setOnClickListener(paramOnClickListener);
    if (this.oWB != null) {
      this.oWB.setOnClickListener(paramOnClickListener);
    }
    if (this.oWG != null) {
      this.oWG.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(113898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.b
 * JD-Core Version:    0.7.0.1
 */