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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class e
  extends a
{
  protected TextView ica;
  private RelativeLayout nJV;
  private TextView nJW;
  private View nJX;
  private ImageView nJY;
  private ImageView nJZ;
  private ImageView nKa;
  private ImageView nKb;
  private ImageView nKc;
  private LinearLayout nwe;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bMX()
  {
    AppMethodBeat.i(113912);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
    o.ayK();
    ((c.a)localObject).hkl = null;
    ((c.a)localObject).gjt = m.Qy(this.nqp.bHW().CPF);
    ((c.a)localObject).hjU = true;
    ((c.a)localObject).gkG = true;
    ((c.a)localObject).hkm = this.mContext.getResources().getDimensionPixelSize(2131165983);
    ((c.a)localObject).hkn = true;
    ((c.a)localObject).hjS = true;
    ((c.a)localObject).hkf = 2131231519;
    ((c.a)localObject).gjw = com.tencent.mm.cd.a.ao(this.mContext, 2131165987);
    ((c.a)localObject).gjv = com.tencent.mm.cd.a.hV(this.mContext);
    localObject = ((c.a)localObject).azc();
    o.ayJ().a(this.nqp.bHW().CPF, this.nKb, (c)localObject);
    ad.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.nqp.bHW().CPF);
    AppMethodBeat.o(113912);
  }
  
  public final void G(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void a(ShapeDrawable paramShapeDrawable)
  {
    AppMethodBeat.i(113910);
    if (!TextUtils.isEmpty(this.nqp.bHW().CPF))
    {
      this.nKb.setBackgroundDrawable(null);
      this.nKc.setVisibility(0);
      bMX();
      AppMethodBeat.o(113910);
      return;
    }
    if (this.nJA != null)
    {
      this.nKb.setBackgroundDrawable(paramShapeDrawable);
      this.nKc.setVisibility(8);
    }
    AppMethodBeat.o(113910);
  }
  
  protected final void bMS()
  {
    AppMethodBeat.i(113906);
    this.ica = ((TextView)bMR().findViewById(2131297911));
    this.nJV = ((RelativeLayout)bMR().findViewById(2131297860));
    this.nwe = ((LinearLayout)bMR().findViewById(2131297762));
    this.nJW = ((TextView)bMR().findViewById(2131298408));
    this.nJX = bMR().findViewById(2131297760);
    this.nJY = ((ImageView)bMR().findViewById(2131297761));
    this.nJZ = ((ImageView)this.nJA.findViewById(2131302234));
    this.nKa = ((ImageView)this.nJA.findViewById(2131302233));
    this.nKb = ((ImageView)this.nJA.findViewById(2131297857));
    this.nKc = ((ImageView)this.nJA.findViewById(2131297859));
    AppMethodBeat.o(113906);
  }
  
  protected final void bMT()
  {
    AppMethodBeat.i(113907);
    if (this.lKe != null) {
      this.lKe.setText(this.nqp.bHV().nsK);
    }
    Object localObject;
    if ((this.nqp.bHV().CRF != null) && (this.nqp.bHV().CRF.size() > 0))
    {
      localObject = (xo)this.nqp.bHV().CRF.get(0);
      if (!TextUtils.isEmpty(((xo)localObject).title)) {
        this.ica.setText(((xo)localObject).title);
      }
    }
    else
    {
      if (!this.nqp.bHR()) {
        break label484;
      }
      iN(true);
      this.nKb.setAlpha(255);
      if (this.nKb.getBackground() != null) {
        this.nKb.getBackground().setAlpha(255);
      }
      localObject = this.nqp.bHW().code;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label307;
      }
      ad.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
      iN(false);
    }
    for (;;)
    {
      localObject = this.nJV.getLayoutParams();
      int i = this.mContext.getResources().getDimensionPixelSize(2131165483);
      int j = this.mContext.getResources().getDisplayMetrics().widthPixels - i * 2;
      int k = j * 3 / 5;
      ((ViewGroup.LayoutParams)localObject).height = k;
      ad.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.nJV.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(113907);
      return;
      this.ica.setText("");
      break;
      label307:
      this.nJX.setOnClickListener(this.iAw);
      this.nJY.setOnClickListener(this.iAw);
      this.nJW.setOnClickListener(this.iAw);
      switch (this.nqp.bHW().CPu)
      {
      default: 
        break;
      case 0: 
        if (((String)localObject).length() <= 40) {
          this.nJW.setText(n.Rt((String)localObject));
        }
        break;
      case 1: 
      case 2: 
        if (((String)localObject).length() <= 40)
        {
          if (this.nqp.bHK()) {
            this.nJW.setText(n.Rt((String)localObject));
          } else {
            this.nJW.setText("");
          }
        }
        else
        {
          this.nJW.setText("");
          continue;
          this.nJW.setText("");
          continue;
          label484:
          this.nJW.setText("");
          this.nJY.setVisibility(8);
          this.nJX.setVisibility(8);
          this.nKb.setAlpha(90);
          if (this.nKb.getBackground() != null) {
            this.nKb.getBackground().setAlpha(90);
          }
        }
        break;
      }
    }
  }
  
  public final void iN(boolean paramBoolean)
  {
    AppMethodBeat.i(113908);
    if ((!TextUtils.isEmpty(this.nqp.bHW().code)) && (paramBoolean) && (this.nqp.bHW().CPu != 0) && (!this.nqp.bHV().CSm))
    {
      this.nJY.setVisibility(0);
      this.nJX.setVisibility(0);
      AppMethodBeat.o(113908);
      return;
    }
    this.nJY.setVisibility(8);
    this.nJX.setVisibility(8);
    AppMethodBeat.o(113908);
  }
  
  public final void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(113911);
    if (!TextUtils.isEmpty(this.nqp.bHW().CPF))
    {
      this.nKa.setVisibility(8);
      this.nJZ.setVisibility(8);
      AppMethodBeat.o(113911);
      return;
    }
    this.nKa.setVisibility(0);
    this.nJZ.setVisibility(0);
    AppMethodBeat.o(113911);
  }
  
  public final void zq(int paramInt)
  {
    AppMethodBeat.i(113909);
    if (!TextUtils.isEmpty(this.nqp.bHW().CPF))
    {
      this.nKb.setBackgroundDrawable(null);
      this.nKc.setVisibility(0);
      bMX();
      AppMethodBeat.o(113909);
      return;
    }
    if (this.nJA != null)
    {
      this.nKb.setBackgroundResource(paramInt);
      this.nKc.setVisibility(8);
    }
    AppMethodBeat.o(113909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.e
 * JD-Core Version:    0.7.0.1
 */