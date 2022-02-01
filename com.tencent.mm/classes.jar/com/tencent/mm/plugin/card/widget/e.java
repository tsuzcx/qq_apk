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
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class e
  extends a
{
  protected TextView iCg;
  private LinearLayout nZe;
  private RelativeLayout omV;
  private TextView omW;
  private View omX;
  private ImageView omY;
  private ImageView omZ;
  private ImageView ona;
  private ImageView onb;
  private ImageView onc;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bUi()
  {
    AppMethodBeat.i(113912);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
    o.aFC();
    ((c.a)localObject).hKO = null;
    ((c.a)localObject).gKe = m.UK(this.nTp.bPj().Eiq);
    ((c.a)localObject).hKx = true;
    ((c.a)localObject).gLt = true;
    ((c.a)localObject).hKP = this.mContext.getResources().getDimensionPixelSize(2131165983);
    ((c.a)localObject).hKQ = true;
    ((c.a)localObject).hKv = true;
    ((c.a)localObject).hKI = 2131231519;
    ((c.a)localObject).gKh = com.tencent.mm.cc.a.au(this.mContext, 2131165987);
    ((c.a)localObject).gKg = com.tencent.mm.cc.a.ig(this.mContext);
    localObject = ((c.a)localObject).aFT();
    o.aFB().a(this.nTp.bPj().Eiq, this.onb, (c)localObject);
    ac.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.nTp.bPj().Eiq);
    AppMethodBeat.o(113912);
  }
  
  public final void Ah(int paramInt)
  {
    AppMethodBeat.i(113909);
    if (!TextUtils.isEmpty(this.nTp.bPj().Eiq))
    {
      this.onb.setBackgroundDrawable(null);
      this.onc.setVisibility(0);
      bUi();
      AppMethodBeat.o(113909);
      return;
    }
    if (this.omA != null)
    {
      this.onb.setBackgroundResource(paramInt);
      this.onc.setVisibility(8);
    }
    AppMethodBeat.o(113909);
  }
  
  public final void H(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void a(ShapeDrawable paramShapeDrawable)
  {
    AppMethodBeat.i(113910);
    if (!TextUtils.isEmpty(this.nTp.bPj().Eiq))
    {
      this.onb.setBackgroundDrawable(null);
      this.onc.setVisibility(0);
      bUi();
      AppMethodBeat.o(113910);
      return;
    }
    if (this.omA != null)
    {
      this.onb.setBackgroundDrawable(paramShapeDrawable);
      this.onc.setVisibility(8);
    }
    AppMethodBeat.o(113910);
  }
  
  protected final void bUd()
  {
    AppMethodBeat.i(113906);
    this.iCg = ((TextView)bUc().findViewById(2131297911));
    this.omV = ((RelativeLayout)bUc().findViewById(2131297860));
    this.nZe = ((LinearLayout)bUc().findViewById(2131297762));
    this.omW = ((TextView)bUc().findViewById(2131298408));
    this.omX = bUc().findViewById(2131297760);
    this.omY = ((ImageView)bUc().findViewById(2131297761));
    this.omZ = ((ImageView)this.omA.findViewById(2131302234));
    this.ona = ((ImageView)this.omA.findViewById(2131302233));
    this.onb = ((ImageView)this.omA.findViewById(2131297857));
    this.onc = ((ImageView)this.omA.findViewById(2131297859));
    AppMethodBeat.o(113906);
  }
  
  protected final void bUe()
  {
    AppMethodBeat.i(113907);
    if (this.mmb != null) {
      this.mmb.setText(this.nTp.bPi().nVK);
    }
    Object localObject;
    if ((this.nTp.bPi().Ekq != null) && (this.nTp.bPi().Ekq.size() > 0))
    {
      localObject = (yg)this.nTp.bPi().Ekq.get(0);
      if (!TextUtils.isEmpty(((yg)localObject).title)) {
        this.iCg.setText(((yg)localObject).title);
      }
    }
    else
    {
      if (!this.nTp.bPe()) {
        break label484;
      }
      jq(true);
      this.onb.setAlpha(255);
      if (this.onb.getBackground() != null) {
        this.onb.getBackground().setAlpha(255);
      }
      localObject = this.nTp.bPj().code;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label307;
      }
      ac.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
      jq(false);
    }
    for (;;)
    {
      localObject = this.omV.getLayoutParams();
      int i = this.mContext.getResources().getDimensionPixelSize(2131165483);
      int j = this.mContext.getResources().getDisplayMetrics().widthPixels - i * 2;
      int k = j * 3 / 5;
      ((ViewGroup.LayoutParams)localObject).height = k;
      ac.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.omV.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(113907);
      return;
      this.iCg.setText("");
      break;
      label307:
      this.omX.setOnClickListener(this.jax);
      this.omY.setOnClickListener(this.jax);
      this.omW.setOnClickListener(this.jax);
      switch (this.nTp.bPj().Eif)
      {
      default: 
        break;
      case 0: 
        if (((String)localObject).length() <= 40) {
          this.omW.setText(n.VF((String)localObject));
        }
        break;
      case 1: 
      case 2: 
        if (((String)localObject).length() <= 40)
        {
          if (this.nTp.bOX()) {
            this.omW.setText(n.VF((String)localObject));
          } else {
            this.omW.setText("");
          }
        }
        else
        {
          this.omW.setText("");
          continue;
          this.omW.setText("");
          continue;
          label484:
          this.omW.setText("");
          this.omY.setVisibility(8);
          this.omX.setVisibility(8);
          this.onb.setAlpha(90);
          if (this.onb.getBackground() != null) {
            this.onb.getBackground().setAlpha(90);
          }
        }
        break;
      }
    }
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(113908);
    if ((!TextUtils.isEmpty(this.nTp.bPj().code)) && (paramBoolean) && (this.nTp.bPj().Eif != 0) && (!this.nTp.bPi().EkX))
    {
      this.omY.setVisibility(0);
      this.omX.setVisibility(0);
      AppMethodBeat.o(113908);
      return;
    }
    this.omY.setVisibility(8);
    this.omX.setVisibility(8);
    AppMethodBeat.o(113908);
  }
  
  public final void jr(boolean paramBoolean)
  {
    AppMethodBeat.i(113911);
    if (!TextUtils.isEmpty(this.nTp.bPj().Eiq))
    {
      this.ona.setVisibility(8);
      this.omZ.setVisibility(8);
      AppMethodBeat.o(113911);
      return;
    }
    this.ona.setVisibility(0);
    this.omZ.setVisibility(0);
    AppMethodBeat.o(113911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.e
 * JD-Core Version:    0.7.0.1
 */