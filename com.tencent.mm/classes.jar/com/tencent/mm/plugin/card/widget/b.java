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
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends a
{
  private final String TAG = "MicroMsg.CardWidgetCommon";
  protected TextView hbb;
  private boolean qeD = false;
  protected ImageView qlA;
  protected TextView qlt;
  protected TextView qlu;
  protected Button qlv;
  protected LinearLayout qlw;
  protected TextView qlx;
  protected ImageView qly;
  protected View qlz;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private void cxP()
  {
    AppMethodBeat.i(113895);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.qlw.getLayoutParams();
    if (this.pQV.csv())
    {
      this.qls.setVisibility(0);
      this.qly.setVisibility(8);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165993);
    }
    for (;;)
    {
      this.qlw.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113895);
      return;
      if ((this.pQV.csw()) && (this.qeD))
      {
        this.qls.setVisibility(8);
        this.qly.setVisibility(8);
        localLayoutParams.topMargin = 0;
      }
      else if (this.pQV.csw())
      {
        this.qls.setVisibility(0);
        this.qly.setVisibility(8);
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165993);
      }
    }
  }
  
  private void cxQ()
  {
    AppMethodBeat.i(113897);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.qlv.getLayoutParams();
    if ((this.pQV.csR().Lcz != null) && (!TextUtils.isEmpty(this.pQV.csR().Lcz.pRZ))) {
      localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165534);
    }
    for (;;)
    {
      this.qlv.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113897);
      return;
      if ((this.pQV.csR().LcA != null) && (!TextUtils.isEmpty(this.pQV.csR().LcA.pRY))) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165534);
      } else if ((this.pQV.csQ().LeC != null) && (this.pQV.csQ().LeC.size() > 0)) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165534);
      } else {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165501);
      }
    }
  }
  
  public final void EK(int paramInt)
  {
    AppMethodBeat.i(113896);
    this.qlw.setBackgroundResource(paramInt);
    this.qly.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.qlw.getLayoutParams();
      if (this.pQV.csv())
      {
        this.qls.setVisibility(8);
        localLayoutParams.topMargin = 0;
        this.qly.setVisibility(0);
        int i = this.mContext.getResources().getDimensionPixelSize(2131165987);
        n.a(this.qly, this.pQV.csQ().iwv, i, 2131234198, false);
        this.qlw.setLayoutParams(localLayoutParams);
        this.qlw.invalidate();
        label122:
        cxQ();
        localLayoutParams = (RelativeLayout.LayoutParams)this.qlz.getLayoutParams();
        if (paramInt != 0) {
          break label222;
        }
        localLayoutParams.leftMargin = 0;
      }
    }
    for (localLayoutParams.rightMargin = 0;; localLayoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(2131165201))
    {
      this.qlz.setLayoutParams(localLayoutParams);
      this.qlz.invalidate();
      this.qlr.invalidate();
      AppMethodBeat.o(113896);
      return;
      if ((!this.pQV.csw()) || (!this.qeD)) {
        break;
      }
      this.qls.setVisibility(8);
      localLayoutParams.topMargin = 0;
      break;
      cxP();
      break label122;
      label222:
      localLayoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(2131165201);
    }
  }
  
  public final void H(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113899);
    if (this.qlv != null)
    {
      abz localabz = this.pQV.csR().LcA;
      if ((localabz != null) && (!TextUtils.isEmpty(localabz.title)) && (localabz.LfD != 0L) && (this.pQV.csM()))
      {
        this.qlv.setClickable(false);
        this.qlv.setVisibility(0);
        this.qlA.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((this.pQV.csR().Lcz != null) && (!TextUtils.isEmpty(this.pQV.csR().Lcz.title)) && (!TextUtils.isEmpty(this.pQV.csR().Lcz.url)) && (this.pQV.csM()))
      {
        this.qlv.setVisibility(0);
        this.qlv.setEnabled(true);
        if ((!TextUtils.isEmpty(this.pQV.csR().code)) && (this.pQV.csR().Lcr != 0))
        {
          this.qlA.setVisibility(0);
          AppMethodBeat.o(113899);
          return;
        }
        this.qlA.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!TextUtils.isEmpty(this.pQV.csR().code)) && (this.pQV.csM()))
      {
        this.qlv.setVisibility(0);
        this.qlv.setEnabled(paramBoolean2);
        this.qlA.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!this.pQV.csM()))
      {
        this.qlv.setVisibility(0);
        this.qlv.setEnabled(false);
        this.qlA.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      this.qlv.setVisibility(8);
      this.qlA.setVisibility(8);
    }
    AppMethodBeat.o(113899);
  }
  
  public final void cvI()
  {
    AppMethodBeat.i(113900);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.qlw.getLayoutParams();
    if (this.pQV.csw())
    {
      this.qls.setVisibility(0);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165993);
    }
    this.qlw.setLayoutParams(localLayoutParams);
    this.qlw.invalidate();
    AppMethodBeat.o(113900);
  }
  
  protected final void cxM()
  {
    AppMethodBeat.i(113893);
    this.hbb = ((TextView)this.qlr.findViewById(2131298229));
    this.qlt = ((TextView)this.qlr.findViewById(2131298221));
    this.qlu = ((TextView)this.qlr.findViewById(2131298038));
    this.qlv = ((Button)this.qlr.findViewById(2131298083));
    this.qlw = ((LinearLayout)this.qlr.findViewById(2131310503));
    this.qly = ((ImageView)this.qlw.findViewById(2131296967));
    this.qlz = this.qlr.findViewById(2131298052);
    this.qlA = ((ImageView)this.qlr.findViewById(2131298075));
    this.qlx = ((TextView)this.qlr.findViewById(2131298184));
    AppMethodBeat.o(113893);
  }
  
  protected final void cxN()
  {
    AppMethodBeat.i(113894);
    abz localabz1;
    Object localObject1;
    if ((this.pQV.csQ().LeC != null) && (this.pQV.csQ().LeC.size() > 0))
    {
      localabz1 = (abz)this.pQV.csQ().LeC.get(0);
      if (!Util.isNullOrNil(localabz1.title)) {
        this.hbb.setText(localabz1.title);
      }
      if (!Util.isNullOrNil(localabz1.pRY))
      {
        this.qlt.setText(localabz1.pRY);
        this.qlt.setVisibility(0);
        localObject1 = (LinearLayout.LayoutParams)this.qlt.getLayoutParams();
        if (Util.isNullOrNil(localabz1.pRZ)) {
          break label245;
        }
        this.qlu.setText(localabz1.pRZ);
        this.qlu.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        label154:
        this.qlt.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.qlt.invalidate();
      }
    }
    else
    {
      if ((this.qlv != null) && (this.qlA != null)) {
        break label273;
      }
      Log.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
    }
    label1288:
    for (;;)
    {
      cxP();
      this.qlw.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231580));
      cxQ();
      this.qlr.invalidate();
      AppMethodBeat.o(113894);
      return;
      this.qlt.setVisibility(8);
      break;
      label245:
      this.qlu.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelSize(2131165501);
      break label154;
      label273:
      if (this.pQV.csR() == null)
      {
        Log.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
        this.qlv.setVisibility(8);
        this.qlA.setVisibility(8);
      }
      else
      {
        if (this.pQV.csR().Lcz != null)
        {
          Log.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.pQV.csR().Lcz.title);
          Log.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.pQV.csR().Lcz.url);
          Log.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.pQV.csR().Lcz.pRZ);
        }
        localabz1 = this.pQV.csR().LcA;
        if (localabz1 != null)
        {
          Log.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + localabz1.title);
          Log.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + localabz1.LfD);
          Log.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + localabz1.pRZ);
        }
        Object localObject2 = this.pQV.csQ().LeT;
        localObject1 = (LinearLayout)this.qlw.findViewById(2131298097);
        if ((localObject2 != null) && (!Util.isNullOrNil(((eol)localObject2).Nmm)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((LinearLayout)localObject1).removeAllViews();
          localObject2 = ((eol)localObject2).Nmm.iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          abz localabz2 = (abz)((Iterator)localObject2).next();
          View localView = LayoutInflater.from(this.mContext).inflate(2131493357, null);
          TextView localTextView1 = (TextView)localView.findViewById(2131298100);
          TextView localTextView2 = (TextView)localView.findViewById(2131298096);
          localTextView1.setText(localabz2.title);
          localTextView2.setText(localabz2.pRY);
          ((LinearLayout)localObject1).addView(localView);
          continue;
          ((LinearLayout)localObject1).setVisibility(8);
        }
        if ((localabz1 != null) && (!TextUtils.isEmpty(localabz1.title)) && (localabz1.LfD != 0L) && (this.pQV.csM()))
        {
          this.qlv.setClickable(false);
          this.qlv.setVisibility(0);
          this.qlv.setTextColor(this.mContext.getResources().getColor(2131101430));
          this.qlv.setText(localabz1.title);
          if ((localabz1 != null) && (!TextUtils.isEmpty(localabz1.pRY)))
          {
            this.qlx.setText(localabz1.pRY);
            this.qlx.setVisibility(0);
          }
          for (;;)
          {
            this.qlA.setVisibility(8);
            if ((localabz1.LfD & 0x2) <= 0L) {
              break label890;
            }
            this.qlv.setBackgroundDrawable(l.U(this.mContext, l.convertStringToRGB(this.pQV.csQ().ixw, 150)));
            this.qlx.setTextColor(l.ake(this.pQV.csQ().ixw));
            break;
            this.qlx.setVisibility(8);
          }
          label890:
          if ((localabz1.LfD & 0x4) > 0L)
          {
            this.qlv.setBackgroundDrawable(l.U(this.mContext, this.mContext.getResources().getColor(2131100678)));
            this.qlx.setTextColor(this.mContext.getResources().getColor(2131100900));
          }
          else
          {
            this.qlv.setBackgroundDrawable(l.U(this.mContext, l.ake(this.pQV.csQ().ixw)));
            this.qlx.setTextColor(this.mContext.getResources().getColor(2131100900));
          }
        }
        else if ((this.pQV.csR().Lcz != null) && (!TextUtils.isEmpty(this.pQV.csR().Lcz.title)) && (!TextUtils.isEmpty(this.pQV.csR().Lcz.url)) && (this.pQV.csM()))
        {
          this.qlv.setClickable(true);
          this.qlv.setVisibility(0);
          this.qlv.setBackgroundDrawable(l.U(this.mContext, l.ake(this.pQV.csQ().ixw)));
          this.qlv.setTextColor(this.mContext.getResources().getColorStateList(2131101430));
          this.qlv.setText(this.pQV.csR().Lcz.title);
          if ((this.pQV.csR().Lcz != null) && (!TextUtils.isEmpty(this.pQV.csR().Lcz.pRZ)))
          {
            this.qlx.setTextColor(this.mContext.getResources().getColor(2131100900));
            this.qlx.setText(this.pQV.csR().Lcz.pRZ);
            this.qlx.setVisibility(0);
          }
          for (;;)
          {
            if (TextUtils.isEmpty(this.pQV.csR().code)) {
              break label1288;
            }
            this.qlA.setVisibility(0);
            break;
            this.qlx.setVisibility(8);
          }
          this.qlA.setVisibility(8);
        }
        else if ((!TextUtils.isEmpty(this.pQV.csR().code)) && (this.pQV.csM()))
        {
          Log.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
          this.qlA.setVisibility(8);
          this.qlx.setVisibility(8);
          this.qlv.setClickable(true);
          this.qlv.setVisibility(0);
          this.qlv.setBackgroundDrawable(l.U(this.mContext, l.ake(this.pQV.csQ().ixw)));
          this.qlv.setTextColor(this.mContext.getResources().getColorStateList(2131101430));
          this.qlv.setText(2131757176);
        }
        else if (!this.pQV.csM())
        {
          Log.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.pQV.csR().status);
          this.qlA.setVisibility(8);
          this.qlx.setVisibility(8);
          this.qlv.setClickable(true);
          this.qlv.setVisibility(0);
          this.qlv.setTextColor(this.mContext.getResources().getColor(2131100571));
          this.qlv.setBackgroundDrawable(l.U(this.mContext, this.mContext.getResources().getColor(2131100112)));
          if (!TextUtils.isEmpty(this.pQV.csQ().LeY)) {
            this.qlv.setText(this.pQV.csQ().LeY);
          } else {
            n.h(this.qlv, this.pQV.csR().status);
          }
        }
        else
        {
          Log.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
          this.qlv.setVisibility(8);
          this.qlx.setVisibility(8);
          this.qlA.setVisibility(8);
        }
      }
    }
  }
  
  public final void kE(boolean paramBoolean)
  {
    AppMethodBeat.i(113901);
    this.qeD = paramBoolean;
    if (paramBoolean)
    {
      this.qlz.setVisibility(0);
      AppMethodBeat.o(113901);
      return;
    }
    this.qlz.setVisibility(8);
    AppMethodBeat.o(113901);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113898);
    super.setOnClickListener(paramOnClickListener);
    if (this.qlv != null) {
      this.qlv.setOnClickListener(paramOnClickListener);
    }
    if (this.qlA != null) {
      this.qlA.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(113898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.b
 * JD-Core Version:    0.7.0.1
 */