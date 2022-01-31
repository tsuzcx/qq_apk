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
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class e
  extends a
{
  protected TextView gpL;
  private RelativeLayout kCX;
  private TextView kCY;
  private View kCZ;
  private ImageView kDa;
  private ImageView kDb;
  private ImageView kDc;
  private ImageView kDd;
  private ImageView kDe;
  private LinearLayout kqK;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bfM()
  {
    AppMethodBeat.i(88984);
    Object localObject = new c.a();
    ((c.a)localObject).eNP = com.tencent.mm.compatible.util.e.eQz;
    o.ahH();
    ((c.a)localObject).eOd = null;
    ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(this.klk.bbe().wEe);
    ((c.a)localObject).eNM = true;
    ((c.a)localObject).eOk = true;
    ((c.a)localObject).eOl = this.mContext.getResources().getDimensionPixelSize(2131428184);
    ((c.a)localObject).eOf = true;
    ((c.a)localObject).eNK = true;
    ((c.a)localObject).eNY = 2130838185;
    ((c.a)localObject).eNT = com.tencent.mm.cb.a.ao(this.mContext, 2131428188);
    ((c.a)localObject).eNS = com.tencent.mm.cb.a.gw(this.mContext);
    localObject = ((c.a)localObject).ahY();
    o.ahG().a(this.klk.bbe().wEe, this.kDd, (c)localObject);
    ab.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.klk.bbe().wEe);
    AppMethodBeat.o(88984);
  }
  
  public final void a(ShapeDrawable paramShapeDrawable)
  {
    AppMethodBeat.i(88982);
    if (!TextUtils.isEmpty(this.klk.bbe().wEe))
    {
      this.kDd.setBackgroundDrawable(null);
      this.kDe.setVisibility(0);
      bfM();
      AppMethodBeat.o(88982);
      return;
    }
    if (this.kCC != null)
    {
      this.kDd.setBackgroundDrawable(paramShapeDrawable);
      this.kDe.setVisibility(8);
    }
    AppMethodBeat.o(88982);
  }
  
  protected final void bfH()
  {
    AppMethodBeat.i(88978);
    this.gpL = ((TextView)bfG().findViewById(2131822059));
    this.kCX = ((RelativeLayout)bfG().findViewById(2131822287));
    this.kqK = ((LinearLayout)bfG().findViewById(2131822291));
    this.kCY = ((TextView)bfG().findViewById(2131822013));
    this.kCZ = bfG().findViewById(2131822290);
    this.kDa = ((ImageView)bfG().findViewById(2131822058));
    this.kDb = ((ImageView)this.kCC.findViewById(2131822293));
    this.kDc = ((ImageView)this.kCC.findViewById(2131822292));
    this.kDd = ((ImageView)this.kCC.findViewById(2131822288));
    this.kDe = ((ImageView)this.kCC.findViewById(2131822289));
    AppMethodBeat.o(88978);
  }
  
  protected final void bfI()
  {
    AppMethodBeat.i(88979);
    if (this.iVS != null) {
      this.iVS.setText(this.klk.bbd().knw);
    }
    Object localObject;
    if ((this.klk.bbd().wFZ != null) && (this.klk.bbd().wFZ.size() > 0))
    {
      localObject = (uo)this.klk.bbd().wFZ.get(0);
      if (!TextUtils.isEmpty(((uo)localObject).title)) {
        this.gpL.setText(((uo)localObject).title);
      }
    }
    else
    {
      if (!this.klk.isNormal()) {
        break label484;
      }
      gc(true);
      this.kDd.setAlpha(255);
      if (this.kDd.getBackground() != null) {
        this.kDd.getBackground().setAlpha(255);
      }
      localObject = this.klk.bbe().code;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label307;
      }
      ab.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
      gc(false);
    }
    for (;;)
    {
      localObject = this.kCX.getLayoutParams();
      int i = this.mContext.getResources().getDimensionPixelSize(2131427775);
      int j = this.mContext.getResources().getDisplayMetrics().widthPixels - i * 2;
      int k = j * 3 / 5;
      ((ViewGroup.LayoutParams)localObject).height = k;
      ab.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.kCX.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(88979);
      return;
      this.gpL.setText("");
      break;
      label307:
      this.kCZ.setOnClickListener(this.gMO);
      this.kDa.setOnClickListener(this.gMO);
      this.kCY.setOnClickListener(this.gMO);
      switch (this.klk.bbe().wDT)
      {
      default: 
        break;
      case 0: 
        if (((String)localObject).length() <= 40) {
          this.kCY.setText(com.tencent.mm.plugin.card.d.m.II((String)localObject));
        }
        break;
      case 1: 
      case 2: 
        if (((String)localObject).length() <= 40)
        {
          if (this.klk.baT()) {
            this.kCY.setText(com.tencent.mm.plugin.card.d.m.II((String)localObject));
          } else {
            this.kCY.setText("");
          }
        }
        else
        {
          this.kCY.setText("");
          continue;
          this.kCY.setText("");
          continue;
          label484:
          this.kCY.setText("");
          this.kDa.setVisibility(8);
          this.kCZ.setVisibility(8);
          this.kDd.setAlpha(90);
          if (this.kDd.getBackground() != null) {
            this.kDd.getBackground().setAlpha(90);
          }
        }
        break;
      }
    }
  }
  
  public final void gc(boolean paramBoolean)
  {
    AppMethodBeat.i(88980);
    if ((!TextUtils.isEmpty(this.klk.bbe().code)) && (paramBoolean) && (this.klk.bbe().wDT != 0) && (!this.klk.bbd().wGH))
    {
      this.kDa.setVisibility(0);
      this.kCZ.setVisibility(0);
      AppMethodBeat.o(88980);
      return;
    }
    this.kDa.setVisibility(8);
    this.kCZ.setVisibility(8);
    AppMethodBeat.o(88980);
  }
  
  public final void gd(boolean paramBoolean)
  {
    AppMethodBeat.i(88983);
    if (!TextUtils.isEmpty(this.klk.bbe().wEe))
    {
      this.kDc.setVisibility(8);
      this.kDb.setVisibility(8);
      AppMethodBeat.o(88983);
      return;
    }
    this.kDc.setVisibility(0);
    this.kDb.setVisibility(0);
    AppMethodBeat.o(88983);
  }
  
  public final void tw(int paramInt)
  {
    AppMethodBeat.i(88981);
    if (!TextUtils.isEmpty(this.klk.bbe().wEe))
    {
      this.kDd.setBackgroundDrawable(null);
      this.kDe.setVisibility(0);
      bfM();
      AppMethodBeat.o(88981);
      return;
    }
    if (this.kCC != null)
    {
      this.kDd.setBackgroundResource(paramInt);
      this.kDe.setVisibility(8);
    }
    AppMethodBeat.o(88981);
  }
  
  public final void x(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.e
 * JD-Core Version:    0.7.0.1
 */