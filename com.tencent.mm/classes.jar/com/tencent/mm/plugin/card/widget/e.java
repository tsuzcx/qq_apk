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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class e
  extends a
{
  protected TextView iYj;
  private LinearLayout oJa;
  private RelativeLayout oWS;
  private TextView oWT;
  private View oWU;
  private ImageView oWV;
  private ImageView oWW;
  private ImageView oWX;
  private ImageView oWY;
  private ImageView oWZ;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private void cac()
  {
    AppMethodBeat.i(113912);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
    q.aJc();
    ((c.a)localObject).igB = null;
    ((c.a)localObject).hgD = m.Zk(this.oDm.bVd().GhZ);
    ((c.a)localObject).igk = true;
    ((c.a)localObject).hhW = true;
    ((c.a)localObject).igC = this.mContext.getResources().getDimensionPixelSize(2131165983);
    ((c.a)localObject).igD = true;
    ((c.a)localObject).igi = true;
    ((c.a)localObject).igv = 2131231519;
    ((c.a)localObject).hgG = com.tencent.mm.cb.a.ax(this.mContext, 2131165987);
    ((c.a)localObject).hgF = com.tencent.mm.cb.a.iu(this.mContext);
    localObject = ((c.a)localObject).aJu();
    q.aJb().a(this.oDm.bVd().GhZ, this.oWY, (c)localObject);
    ae.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.oDm.bVd().GhZ);
    AppMethodBeat.o(113912);
  }
  
  public final void Bc(int paramInt)
  {
    AppMethodBeat.i(113909);
    if (!TextUtils.isEmpty(this.oDm.bVd().GhZ))
    {
      this.oWY.setBackgroundDrawable(null);
      this.oWZ.setVisibility(0);
      cac();
      AppMethodBeat.o(113909);
      return;
    }
    if (this.oWx != null)
    {
      this.oWY.setBackgroundResource(paramInt);
      this.oWZ.setVisibility(8);
    }
    AppMethodBeat.o(113909);
  }
  
  public final void I(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void a(ShapeDrawable paramShapeDrawable)
  {
    AppMethodBeat.i(113910);
    if (!TextUtils.isEmpty(this.oDm.bVd().GhZ))
    {
      this.oWY.setBackgroundDrawable(null);
      this.oWZ.setVisibility(0);
      cac();
      AppMethodBeat.o(113910);
      return;
    }
    if (this.oWx != null)
    {
      this.oWY.setBackgroundDrawable(paramShapeDrawable);
      this.oWZ.setVisibility(8);
    }
    AppMethodBeat.o(113910);
  }
  
  protected final void bZX()
  {
    AppMethodBeat.i(113906);
    this.iYj = ((TextView)bZW().findViewById(2131297911));
    this.oWS = ((RelativeLayout)bZW().findViewById(2131297860));
    this.oJa = ((LinearLayout)bZW().findViewById(2131297762));
    this.oWT = ((TextView)bZW().findViewById(2131298408));
    this.oWU = bZW().findViewById(2131297760);
    this.oWV = ((ImageView)bZW().findViewById(2131297761));
    this.oWW = ((ImageView)this.oWx.findViewById(2131302234));
    this.oWX = ((ImageView)this.oWx.findViewById(2131302233));
    this.oWY = ((ImageView)this.oWx.findViewById(2131297857));
    this.oWZ = ((ImageView)this.oWx.findViewById(2131297859));
    AppMethodBeat.o(113906);
  }
  
  protected final void bZY()
  {
    AppMethodBeat.i(113907);
    if (this.mRG != null) {
      this.mRG.setText(this.oDm.bVc().oFG);
    }
    Object localObject;
    if ((this.oDm.bVc().GjY != null) && (this.oDm.bVc().GjY.size() > 0))
    {
      localObject = (aai)this.oDm.bVc().GjY.get(0);
      if (!TextUtils.isEmpty(((aai)localObject).title)) {
        this.iYj.setText(((aai)localObject).title);
      }
    }
    else
    {
      if (!this.oDm.bUY()) {
        break label484;
      }
      jA(true);
      this.oWY.setAlpha(255);
      if (this.oWY.getBackground() != null) {
        this.oWY.getBackground().setAlpha(255);
      }
      localObject = this.oDm.bVd().code;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label307;
      }
      ae.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
      jA(false);
    }
    for (;;)
    {
      localObject = this.oWS.getLayoutParams();
      int i = this.mContext.getResources().getDimensionPixelSize(2131165483);
      int j = this.mContext.getResources().getDisplayMetrics().widthPixels - i * 2;
      int k = j * 3 / 5;
      ((ViewGroup.LayoutParams)localObject).height = k;
      ae.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.oWS.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(113907);
      return;
      this.iYj.setText("");
      break;
      label307:
      this.oWU.setOnClickListener(this.jwB);
      this.oWV.setOnClickListener(this.jwB);
      this.oWT.setOnClickListener(this.jwB);
      switch (this.oDm.bVd().GhO)
      {
      default: 
        break;
      case 0: 
        if (((String)localObject).length() <= 40) {
          this.oWT.setText(n.aaf((String)localObject));
        }
        break;
      case 1: 
      case 2: 
        if (((String)localObject).length() <= 40)
        {
          if (this.oDm.bUR()) {
            this.oWT.setText(n.aaf((String)localObject));
          } else {
            this.oWT.setText("");
          }
        }
        else
        {
          this.oWT.setText("");
          continue;
          this.oWT.setText("");
          continue;
          label484:
          this.oWT.setText("");
          this.oWV.setVisibility(8);
          this.oWU.setVisibility(8);
          this.oWY.setAlpha(90);
          if (this.oWY.getBackground() != null) {
            this.oWY.getBackground().setAlpha(90);
          }
        }
        break;
      }
    }
  }
  
  public final void jA(boolean paramBoolean)
  {
    AppMethodBeat.i(113908);
    if ((!TextUtils.isEmpty(this.oDm.bVd().code)) && (paramBoolean) && (this.oDm.bVd().GhO != 0) && (!this.oDm.bVc().GkF))
    {
      this.oWV.setVisibility(0);
      this.oWU.setVisibility(0);
      AppMethodBeat.o(113908);
      return;
    }
    this.oWV.setVisibility(8);
    this.oWU.setVisibility(8);
    AppMethodBeat.o(113908);
  }
  
  public final void jB(boolean paramBoolean)
  {
    AppMethodBeat.i(113911);
    if (!TextUtils.isEmpty(this.oDm.bVd().GhZ))
    {
      this.oWX.setVisibility(8);
      this.oWW.setVisibility(8);
      AppMethodBeat.o(113911);
      return;
    }
    this.oWX.setVisibility(0);
    this.oWW.setVisibility(0);
    AppMethodBeat.o(113911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.e
 * JD-Core Version:    0.7.0.1
 */