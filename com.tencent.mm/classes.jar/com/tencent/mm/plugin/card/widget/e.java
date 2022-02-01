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
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class e
  extends a
{
  protected TextView iVq;
  private LinearLayout oCy;
  private RelativeLayout oQq;
  private TextView oQr;
  private View oQs;
  private ImageView oQt;
  private ImageView oQu;
  private ImageView oQv;
  private ImageView oQw;
  private ImageView oQx;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bYN()
  {
    AppMethodBeat.i(113912);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
    q.aIK();
    ((c.a)localObject).idJ = null;
    ((c.a)localObject).hdP = m.Yt(this.owK.bTO().FPA);
    ((c.a)localObject).idr = true;
    ((c.a)localObject).hfi = true;
    ((c.a)localObject).idK = this.mContext.getResources().getDimensionPixelSize(2131165983);
    ((c.a)localObject).idL = true;
    ((c.a)localObject).idp = true;
    ((c.a)localObject).idD = 2131231519;
    ((c.a)localObject).hdS = com.tencent.mm.cc.a.ax(this.mContext, 2131165987);
    ((c.a)localObject).hdR = com.tencent.mm.cc.a.ip(this.mContext);
    localObject = ((c.a)localObject).aJc();
    q.aIJ().a(this.owK.bTO().FPA, this.oQw, (c)localObject);
    ad.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.owK.bTO().FPA);
    AppMethodBeat.o(113912);
  }
  
  public final void AQ(int paramInt)
  {
    AppMethodBeat.i(113909);
    if (!TextUtils.isEmpty(this.owK.bTO().FPA))
    {
      this.oQw.setBackgroundDrawable(null);
      this.oQx.setVisibility(0);
      bYN();
      AppMethodBeat.o(113909);
      return;
    }
    if (this.oPV != null)
    {
      this.oQw.setBackgroundResource(paramInt);
      this.oQx.setVisibility(8);
    }
    AppMethodBeat.o(113909);
  }
  
  public final void I(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void a(ShapeDrawable paramShapeDrawable)
  {
    AppMethodBeat.i(113910);
    if (!TextUtils.isEmpty(this.owK.bTO().FPA))
    {
      this.oQw.setBackgroundDrawable(null);
      this.oQx.setVisibility(0);
      bYN();
      AppMethodBeat.o(113910);
      return;
    }
    if (this.oPV != null)
    {
      this.oQw.setBackgroundDrawable(paramShapeDrawable);
      this.oQx.setVisibility(8);
    }
    AppMethodBeat.o(113910);
  }
  
  protected final void bYI()
  {
    AppMethodBeat.i(113906);
    this.iVq = ((TextView)bYH().findViewById(2131297911));
    this.oQq = ((RelativeLayout)bYH().findViewById(2131297860));
    this.oCy = ((LinearLayout)bYH().findViewById(2131297762));
    this.oQr = ((TextView)bYH().findViewById(2131298408));
    this.oQs = bYH().findViewById(2131297760);
    this.oQt = ((ImageView)bYH().findViewById(2131297761));
    this.oQu = ((ImageView)this.oPV.findViewById(2131302234));
    this.oQv = ((ImageView)this.oPV.findViewById(2131302233));
    this.oQw = ((ImageView)this.oPV.findViewById(2131297857));
    this.oQx = ((ImageView)this.oPV.findViewById(2131297859));
    AppMethodBeat.o(113906);
  }
  
  protected final void bYJ()
  {
    AppMethodBeat.i(113907);
    if (this.mMD != null) {
      this.mMD.setText(this.owK.bTN().oze);
    }
    Object localObject;
    if ((this.owK.bTN().FRz != null) && (this.owK.bTN().FRz.size() > 0))
    {
      localObject = (aaf)this.owK.bTN().FRz.get(0);
      if (!TextUtils.isEmpty(((aaf)localObject).title)) {
        this.iVq.setText(((aaf)localObject).title);
      }
    }
    else
    {
      if (!this.owK.bTJ()) {
        break label484;
      }
      jB(true);
      this.oQw.setAlpha(255);
      if (this.oQw.getBackground() != null) {
        this.oQw.getBackground().setAlpha(255);
      }
      localObject = this.owK.bTO().code;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label307;
      }
      ad.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
      jB(false);
    }
    for (;;)
    {
      localObject = this.oQq.getLayoutParams();
      int i = this.mContext.getResources().getDimensionPixelSize(2131165483);
      int j = this.mContext.getResources().getDisplayMetrics().widthPixels - i * 2;
      int k = j * 3 / 5;
      ((ViewGroup.LayoutParams)localObject).height = k;
      ad.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.oQq.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(113907);
      return;
      this.iVq.setText("");
      break;
      label307:
      this.oQs.setOnClickListener(this.jtG);
      this.oQt.setOnClickListener(this.jtG);
      this.oQr.setOnClickListener(this.jtG);
      switch (this.owK.bTO().FPp)
      {
      default: 
        break;
      case 0: 
        if (((String)localObject).length() <= 40) {
          this.oQr.setText(n.Zo((String)localObject));
        }
        break;
      case 1: 
      case 2: 
        if (((String)localObject).length() <= 40)
        {
          if (this.owK.bTC()) {
            this.oQr.setText(n.Zo((String)localObject));
          } else {
            this.oQr.setText("");
          }
        }
        else
        {
          this.oQr.setText("");
          continue;
          this.oQr.setText("");
          continue;
          label484:
          this.oQr.setText("");
          this.oQt.setVisibility(8);
          this.oQs.setVisibility(8);
          this.oQw.setAlpha(90);
          if (this.oQw.getBackground() != null) {
            this.oQw.getBackground().setAlpha(90);
          }
        }
        break;
      }
    }
  }
  
  public final void jB(boolean paramBoolean)
  {
    AppMethodBeat.i(113908);
    if ((!TextUtils.isEmpty(this.owK.bTO().code)) && (paramBoolean) && (this.owK.bTO().FPp != 0) && (!this.owK.bTN().FSg))
    {
      this.oQt.setVisibility(0);
      this.oQs.setVisibility(0);
      AppMethodBeat.o(113908);
      return;
    }
    this.oQt.setVisibility(8);
    this.oQs.setVisibility(8);
    AppMethodBeat.o(113908);
  }
  
  public final void jC(boolean paramBoolean)
  {
    AppMethodBeat.i(113911);
    if (!TextUtils.isEmpty(this.owK.bTO().FPA))
    {
      this.oQv.setVisibility(8);
      this.oQu.setVisibility(8);
      AppMethodBeat.o(113911);
      return;
    }
    this.oQv.setVisibility(0);
    this.oQu.setVisibility(0);
    AppMethodBeat.o(113911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.e
 * JD-Core Version:    0.7.0.1
 */