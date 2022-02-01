package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.luggage.wxa.b.a.c;
import com.tencent.luggage.wxa.b.a.d;
import com.tencent.luggage.wxa.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.plugin.appbrand.widget.input.e.h;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

final class d
  extends c<s>
{
  int uFa;
  s uFb;
  v uFc;
  h uFd;
  boolean uFe;
  boolean uFf;
  private boolean uFg;
  
  d(String paramString, ad paramad, e parame)
  {
    super(paramString, paramad, parame.uES);
    AppMethodBeat.i(136314);
    this.uFa = 0;
    this.uFb = new s(paramad.getContext());
    this.uFa = Util.nullAs((Integer)o.uGA.get(paramString), 0);
    AppMethodBeat.o(136314);
  }
  
  private v cQO()
  {
    AppMethodBeat.i(136325);
    if (this.uFc != null)
    {
      localv = this.uFc;
      AppMethodBeat.o(136325);
      return localv;
    }
    v localv = this.uFb.getInputPanel();
    this.uFc = localv;
    AppMethodBeat.o(136325);
    return localv;
  }
  
  private boolean isFocused()
  {
    AppMethodBeat.i(136323);
    if (this.uFb == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.uFb.isFocused())
    {
      AppMethodBeat.o(136323);
      return true;
    }
    if (cQO() == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (!cQO().isShown())
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.uFc.getAttachedEditText() == this.uFb)
    {
      AppMethodBeat.o(136323);
      return true;
    }
    AppMethodBeat.o(136323);
    return false;
  }
  
  public final boolean agZ(String paramString)
  {
    AppMethodBeat.i(136320);
    if (this.uFb == null)
    {
      AppMethodBeat.o(136320);
      return false;
    }
    this.uFb.T(paramString);
    AppMethodBeat.o(136320);
    return true;
  }
  
  public final h b(h paramh)
  {
    AppMethodBeat.i(136319);
    if (this.uFd == null)
    {
      this.uFd = paramh;
      if ((an.o(paramh.uMf)) && (this.uFb != null)) {
        this.uFb.setPasswordMode(true);
      }
    }
    while (this.uFb == null)
    {
      AppMethodBeat.o(136319);
      return null;
      this.uFd.a(paramh);
    }
    b.a(this.uFb, this.uFd);
    paramh = this.uFd;
    AppMethodBeat.o(136319);
    return paramh;
  }
  
  final Rect cQC()
  {
    AppMethodBeat.i(136318);
    Rect localRect = new Rect(this.uFd.uLC.intValue(), this.uFd.uLB.intValue(), this.uFd.uLC.intValue() + this.uFd.uLz.intValue(), this.uFd.uLB.intValue() + this.uFd.uLA.intValue());
    AppMethodBeat.o(136318);
    return localRect;
  }
  
  public final boolean cQL()
  {
    AppMethodBeat.i(136316);
    if ((this.uFd != null) && (an.o(this.uFd.uLW)))
    {
      AppMethodBeat.o(136316);
      return true;
    }
    AppMethodBeat.o(136316);
    return false;
  }
  
  public final int cQM()
  {
    AppMethodBeat.i(136317);
    if ((this.uFd == null) || (this.uFd.uLT == null))
    {
      AppMethodBeat.o(136317);
      return 0;
    }
    int i = this.uFd.uLT.intValue();
    AppMethodBeat.o(136317);
    return i;
  }
  
  public final boolean cQN()
  {
    AppMethodBeat.i(136322);
    if (cQO() == null)
    {
      AppMethodBeat.o(136322);
      return false;
    }
    if (isFocused())
    {
      v localv = this.uFc;
      localv.setVisibility(8);
      localv.cRq();
      Log.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[] { this.uFb });
      if (this.uFb != null)
      {
        this.uFb.setFocusable(false);
        this.uFb.setFocusableInTouchMode(false);
        this.uFb.setEnabled(false);
      }
      cQS();
      cQT();
      AppMethodBeat.o(136322);
      return true;
    }
    AppMethodBeat.o(136322);
    return false;
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136315);
    cQO();
    v localv = this.uFc;
    AppMethodBeat.o(136315);
    return localv;
  }
  
  protected final boolean lz(boolean paramBoolean)
  {
    AppMethodBeat.i(136324);
    Log.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isFocused()) });
    if (!paramBoolean)
    {
      if (this.uFe)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (!isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.uFe = true;
      a(cQF());
      cQN();
      remove();
      this.uFe = false;
      this.uFb = null;
    }
    for (;;)
    {
      AppMethodBeat.o(136324);
      return true;
      if (this.uFf)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.uFf = true;
      r(-2, -2, this.uFg);
      this.uFf = false;
    }
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(324623);
    if (this.uFb == null)
    {
      AppMethodBeat.o(324623);
      return false;
    }
    Object localObject2 = ((ad)this.uEU.get()).getContentView();
    if ((this.uEU.get() != null) && ((this.uEU.get() instanceof ad))) {}
    for (Object localObject1 = ((ad)this.uEU.get()).cEK();; localObject1 = null)
    {
      this.uFc = v.a((View)localObject2, (a)localObject1);
      this.uFc.setComponentView(this.uFd.uMg.booleanValue());
      localObject1 = this.uFc;
      if ((((v)localObject1).uHl) && (((v)localObject1).uHj == null))
      {
        ((v)localObject1).uHj = ((v)localObject1).uHk;
        v.ei(((v)localObject1).uHj);
        ((v)localObject1).addView(((v)localObject1).uHj, 0);
      }
      if ((((v)localObject1).uHl) && (((v)localObject1).uHj != ((v)localObject1).uHk))
      {
        v.ei(((v)localObject1).uHj);
        ((v)localObject1).uHj = ((v)localObject1).uHk;
        v.ei(((v)localObject1).uHj);
        ((v)localObject1).addView(((v)localObject1).uHj, 0);
        Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
      }
      if ((((v)localObject1).uHl) && (((v)localObject1).uHj.getParent() != localObject1))
      {
        v.ei(((v)localObject1).uHj);
        ((v)localObject1).addView(((v)localObject1).uHj, 0);
      }
      if ((!((v)localObject1).uHl) && (((v)localObject1).uHj != null) && (((v)localObject1).uHj.getParent() == localObject1)) {
        ((v)localObject1).removeView(((v)localObject1).uHj);
      }
      if (this.uFc != null) {
        break;
      }
      AppMethodBeat.o(324623);
      return false;
    }
    this.uFg = paramBoolean;
    if (paramBoolean)
    {
      localObject1 = this.uFc;
      ((v)localObject1).uHf.setBackgroundResource(a.c.BW_BG_100);
      ((v)localObject1).uHf.findViewById(a.e.divider).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((v)localObject1).uHf.findViewById(a.e.button_area).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      localObject1 = ((v)localObject1).uHi;
      ((BaseNumberKeyboardView)localObject1).uFg = true;
      ((BaseNumberKeyboardView)localObject1).uKJ.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKJ.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).uKK.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKK.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).uKL.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKL.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).uKM.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKM.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).uKN.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKN.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).uKO.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKO.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).uKP.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKP.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).uKQ.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKQ.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).uKR.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKR.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).uKS.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKS.setBackgroundResource(a.d.tenpay_keybtn_bottom_left_right_force_light);
      ((BaseNumberKeyboardView)localObject1).uKT.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).uKT.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).uKU.setBackgroundResource(a.d.tenpay_keybtn_bottom_left_right_force_light);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.root_view).setBackgroundResource(a.c.BW_BG_100);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider1).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider2).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider3).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider4).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider5).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider6).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider7).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider8).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider9).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider10).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider11).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider12).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).plc.findViewById(a.e.divider13).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    }
    this.uFf = true;
    cQJ();
    this.uFc.setXMode(this.uFa);
    localObject1 = this.uFc;
    localObject2 = this.uFb;
    if (localObject2 != null)
    {
      if (((v)localObject1).mEditText != localObject2) {
        ((v)localObject1).cRq();
      }
      ((v)localObject1).setInputEditText((EditText)localObject2);
      ((v)localObject1).setVisibility(0);
    }
    this.uFc.setOnDoneListener(new v.a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(136313);
        d.this.a(d.this.cQF());
        d.this.lz(false);
        AppMethodBeat.o(136313);
      }
    });
    fZ(paramInt1, paramInt2);
    cQU();
    this.uFf = false;
    AppMethodBeat.o(324623);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d
 * JD-Core Version:    0.7.0.1
 */