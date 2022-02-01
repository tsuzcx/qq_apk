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
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class e
  extends a
{
  protected TextView mNb;
  private RelativeLayout tHH;
  private TextView tHI;
  private View tHJ;
  private ImageView tHK;
  private ImageView tHL;
  private ImageView tHM;
  private ImageView tHN;
  private ImageView tHO;
  private LinearLayout tsL;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private void cLt()
  {
    AppMethodBeat.i(113912);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
    q.bmm();
    ((c.a)localObject).lRV = null;
    ((c.a)localObject).fullPath = m.arc(this.tmU.cGt().SdP);
    ((c.a)localObject).lRD = true;
    ((c.a)localObject).kPz = true;
    ((c.a)localObject).lRW = this.mContext.getResources().getDimensionPixelSize(a.b.sZR);
    ((c.a)localObject).lRX = true;
    ((c.a)localObject).lRB = true;
    ((c.a)localObject).lRP = a.c.tau;
    ((c.a)localObject).kOg = com.tencent.mm.ci.a.aY(this.mContext, a.b.sZT);
    ((c.a)localObject).kOf = com.tencent.mm.ci.a.kr(this.mContext);
    localObject = ((c.a)localObject).bmL();
    q.bml().a(this.tmU.cGt().SdP, this.tHN, (c)localObject);
    Log.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.tmU.cGt().SdP);
    AppMethodBeat.o(113912);
  }
  
  public final void Il(int paramInt)
  {
    AppMethodBeat.i(113909);
    if (!TextUtils.isEmpty(this.tmU.cGt().SdP))
    {
      this.tHN.setBackgroundDrawable(null);
      this.tHO.setVisibility(0);
      cLt();
      AppMethodBeat.o(113909);
      return;
    }
    if (this.tHm != null)
    {
      this.tHN.setBackgroundResource(paramInt);
      this.tHO.setVisibility(8);
    }
    AppMethodBeat.o(113909);
  }
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void a(ShapeDrawable paramShapeDrawable)
  {
    AppMethodBeat.i(113910);
    if (!TextUtils.isEmpty(this.tmU.cGt().SdP))
    {
      this.tHN.setBackgroundDrawable(null);
      this.tHO.setVisibility(0);
      cLt();
      AppMethodBeat.o(113910);
      return;
    }
    if (this.tHm != null)
    {
      this.tHN.setBackgroundDrawable(paramShapeDrawable);
      this.tHO.setVisibility(8);
    }
    AppMethodBeat.o(113910);
  }
  
  protected final void cLo()
  {
    AppMethodBeat.i(113906);
    this.mNb = ((TextView)cLn().findViewById(a.d.dvg));
    this.tHH = ((RelativeLayout)cLn().findViewById(a.d.tcS));
    this.tsL = ((LinearLayout)cLn().findViewById(a.d.tbB));
    this.tHI = ((TextView)cLn().findViewById(a.d.tfp));
    this.tHJ = cLn().findViewById(a.d.tbz);
    this.tHK = ((ImageView)cLn().findViewById(a.d.tbA));
    this.tHL = ((ImageView)this.tHm.findViewById(a.d.tgg));
    this.tHM = ((ImageView)this.tHm.findViewById(a.d.tgf));
    this.tHN = ((ImageView)this.tHm.findViewById(a.d.tcP));
    this.tHO = ((ImageView)this.tHm.findViewById(a.d.tcR));
    AppMethodBeat.o(113906);
  }
  
  protected final void cLp()
  {
    AppMethodBeat.i(113907);
    if (this.rgv != null) {
      this.rgv.setText(this.tmU.cGs().jEi);
    }
    Object localObject;
    if ((this.tmU.cGs().SfP != null) && (this.tmU.cGs().SfP.size() > 0))
    {
      localObject = (acg)this.tmU.cGs().SfP.get(0);
      if (!TextUtils.isEmpty(((acg)localObject).title)) {
        this.mNb.setText(((acg)localObject).title);
      }
    }
    else
    {
      if (!this.tmU.cGn()) {
        break label484;
      }
      lP(true);
      this.tHN.setAlpha(255);
      if (this.tHN.getBackground() != null) {
        this.tHN.getBackground().setAlpha(255);
      }
      localObject = this.tmU.cGt().code;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label309;
      }
      Log.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
      lP(false);
    }
    for (;;)
    {
      localObject = this.tHH.getLayoutParams();
      int i = this.mContext.getResources().getDimensionPixelSize(a.b.LargerPadding);
      int j = this.mContext.getResources().getDisplayMetrics().widthPixels - i * 2;
      int k = j * 3 / 5;
      ((ViewGroup.LayoutParams)localObject).height = k;
      Log.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.tHH.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(113907);
      return;
      this.mNb.setText("");
      break;
      label309:
      this.tHJ.setOnClickListener(this.nmC);
      this.tHK.setOnClickListener(this.nmC);
      this.tHI.setOnClickListener(this.nmC);
      switch (this.tmU.cGt().SdE)
      {
      default: 
        break;
      case 0: 
        if (((String)localObject).length() <= 40) {
          this.tHI.setText(n.arY((String)localObject));
        }
        break;
      case 1: 
      case 2: 
        if (((String)localObject).length() <= 40)
        {
          if (this.tmU.cGg()) {
            this.tHI.setText(n.arY((String)localObject));
          } else {
            this.tHI.setText("");
          }
        }
        else
        {
          this.tHI.setText("");
          continue;
          this.tHI.setText("");
          continue;
          label484:
          this.tHI.setText("");
          this.tHK.setVisibility(8);
          this.tHJ.setVisibility(8);
          this.tHN.setAlpha(90);
          if (this.tHN.getBackground() != null) {
            this.tHN.getBackground().setAlpha(90);
          }
        }
        break;
      }
    }
  }
  
  public final void lP(boolean paramBoolean)
  {
    AppMethodBeat.i(113908);
    if ((!TextUtils.isEmpty(this.tmU.cGt().code)) && (paramBoolean) && (this.tmU.cGt().SdE != 0) && (!this.tmU.cGs().Sgw))
    {
      this.tHK.setVisibility(0);
      this.tHJ.setVisibility(0);
      AppMethodBeat.o(113908);
      return;
    }
    this.tHK.setVisibility(8);
    this.tHJ.setVisibility(8);
    AppMethodBeat.o(113908);
  }
  
  public final void lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(113911);
    if (!TextUtils.isEmpty(this.tmU.cGt().SdP))
    {
      this.tHM.setVisibility(8);
      this.tHL.setVisibility(8);
      AppMethodBeat.o(113911);
      return;
    }
    this.tHM.setVisibility(0);
    this.tHL.setVisibility(0);
    AppMethodBeat.o(113911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.e
 * JD-Core Version:    0.7.0.1
 */