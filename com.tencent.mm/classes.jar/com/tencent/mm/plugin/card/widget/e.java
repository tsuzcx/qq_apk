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
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class e
  extends a
{
  protected TextView jVO;
  private LinearLayout pWO;
  private RelativeLayout qlM;
  private TextView qlN;
  private View qlO;
  private ImageView qlP;
  private ImageView qlQ;
  private ImageView qlR;
  private ImageView qlS;
  private ImageView qlT;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private void cxR()
  {
    AppMethodBeat.i(113912);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
    q.bcW();
    ((c.a)localObject).jbw = null;
    ((c.a)localObject).fullPath = m.ajp(this.pQV.csR().LcC);
    ((c.a)localObject).jbf = true;
    ((c.a)localObject).iaT = true;
    ((c.a)localObject).jbx = this.mContext.getResources().getDimensionPixelSize(2131166015);
    ((c.a)localObject).jby = true;
    ((c.a)localObject).jbd = true;
    ((c.a)localObject).jbq = 2131231583;
    ((c.a)localObject).hZA = com.tencent.mm.cb.a.aG(this.mContext, 2131166019);
    ((c.a)localObject).hZz = com.tencent.mm.cb.a.jn(this.mContext);
    localObject = ((c.a)localObject).bdv();
    q.bcV().a(this.pQV.csR().LcC, this.qlS, (c)localObject);
    Log.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.pQV.csR().LcC);
    AppMethodBeat.o(113912);
  }
  
  public final void EK(int paramInt)
  {
    AppMethodBeat.i(113909);
    if (!TextUtils.isEmpty(this.pQV.csR().LcC))
    {
      this.qlS.setBackgroundDrawable(null);
      this.qlT.setVisibility(0);
      cxR();
      AppMethodBeat.o(113909);
      return;
    }
    if (this.qlr != null)
    {
      this.qlS.setBackgroundResource(paramInt);
      this.qlT.setVisibility(8);
    }
    AppMethodBeat.o(113909);
  }
  
  public final void H(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void a(ShapeDrawable paramShapeDrawable)
  {
    AppMethodBeat.i(113910);
    if (!TextUtils.isEmpty(this.pQV.csR().LcC))
    {
      this.qlS.setBackgroundDrawable(null);
      this.qlT.setVisibility(0);
      cxR();
      AppMethodBeat.o(113910);
      return;
    }
    if (this.qlr != null)
    {
      this.qlS.setBackgroundDrawable(paramShapeDrawable);
      this.qlT.setVisibility(8);
    }
    AppMethodBeat.o(113910);
  }
  
  protected final void cxM()
  {
    AppMethodBeat.i(113906);
    this.jVO = ((TextView)cxL().findViewById(2131298229));
    this.qlM = ((RelativeLayout)cxL().findViewById(2131298176));
    this.pWO = ((LinearLayout)cxL().findViewById(2131298076));
    this.qlN = ((TextView)cxL().findViewById(2131298817));
    this.qlO = cxL().findViewById(2131298074);
    this.qlP = ((ImageView)cxL().findViewById(2131298075));
    this.qlQ = ((ImageView)this.qlr.findViewById(2131304600));
    this.qlR = ((ImageView)this.qlr.findViewById(2131304599));
    this.qlS = ((ImageView)this.qlr.findViewById(2131298173));
    this.qlT = ((ImageView)this.qlr.findViewById(2131298175));
    AppMethodBeat.o(113906);
  }
  
  protected final void cxN()
  {
    AppMethodBeat.i(113907);
    if (this.oeJ != null) {
      this.oeJ.setText(this.pQV.csQ().gTG);
    }
    Object localObject;
    if ((this.pQV.csQ().LeC != null) && (this.pQV.csQ().LeC.size() > 0))
    {
      localObject = (abz)this.pQV.csQ().LeC.get(0);
      if (!TextUtils.isEmpty(((abz)localObject).title)) {
        this.jVO.setText(((abz)localObject).title);
      }
    }
    else
    {
      if (!this.pQV.csM()) {
        break label484;
      }
      kD(true);
      this.qlS.setAlpha(255);
      if (this.qlS.getBackground() != null) {
        this.qlS.getBackground().setAlpha(255);
      }
      localObject = this.pQV.csR().code;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label307;
      }
      Log.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
      kD(false);
    }
    for (;;)
    {
      localObject = this.qlM.getLayoutParams();
      int i = this.mContext.getResources().getDimensionPixelSize(2131165501);
      int j = this.mContext.getResources().getDisplayMetrics().widthPixels - i * 2;
      int k = j * 3 / 5;
      ((ViewGroup.LayoutParams)localObject).height = k;
      Log.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.qlM.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(113907);
      return;
      this.jVO.setText("");
      break;
      label307:
      this.qlO.setOnClickListener(this.kuO);
      this.qlP.setOnClickListener(this.kuO);
      this.qlN.setOnClickListener(this.kuO);
      switch (this.pQV.csR().Lcr)
      {
      default: 
        break;
      case 0: 
        if (((String)localObject).length() <= 40) {
          this.qlN.setText(n.akl((String)localObject));
        }
        break;
      case 1: 
      case 2: 
        if (((String)localObject).length() <= 40)
        {
          if (this.pQV.csF()) {
            this.qlN.setText(n.akl((String)localObject));
          } else {
            this.qlN.setText("");
          }
        }
        else
        {
          this.qlN.setText("");
          continue;
          this.qlN.setText("");
          continue;
          label484:
          this.qlN.setText("");
          this.qlP.setVisibility(8);
          this.qlO.setVisibility(8);
          this.qlS.setAlpha(90);
          if (this.qlS.getBackground() != null) {
            this.qlS.getBackground().setAlpha(90);
          }
        }
        break;
      }
    }
  }
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(113908);
    if ((!TextUtils.isEmpty(this.pQV.csR().code)) && (paramBoolean) && (this.pQV.csR().Lcr != 0) && (!this.pQV.csQ().Lfi))
    {
      this.qlP.setVisibility(0);
      this.qlO.setVisibility(0);
      AppMethodBeat.o(113908);
      return;
    }
    this.qlP.setVisibility(8);
    this.qlO.setVisibility(8);
    AppMethodBeat.o(113908);
  }
  
  public final void kE(boolean paramBoolean)
  {
    AppMethodBeat.i(113911);
    if (!TextUtils.isEmpty(this.pQV.csR().LcC))
    {
      this.qlR.setVisibility(8);
      this.qlQ.setVisibility(8);
      AppMethodBeat.o(113911);
      return;
    }
    this.qlR.setVisibility(0);
    this.qlQ.setVisibility(0);
    AppMethodBeat.o(113911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.e
 * JD-Core Version:    0.7.0.1
 */