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
import com.tencent.mm.plugin.appbrand.n.a;
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
  int rtV;
  s rtW;
  v rtX;
  h rtY;
  boolean rtZ;
  boolean rua;
  private boolean rub;
  
  d(String paramString, ad paramad, e parame)
  {
    super(paramString, paramad, parame.rtN);
    AppMethodBeat.i(136314);
    this.rtV = 0;
    this.rtW = new s(paramad.getContext());
    this.rtV = Util.nullAs((Integer)o.rvv.get(paramString), 0);
    AppMethodBeat.o(136314);
  }
  
  private v com()
  {
    AppMethodBeat.i(136325);
    if (this.rtX != null)
    {
      localv = this.rtX;
      AppMethodBeat.o(136325);
      return localv;
    }
    v localv = this.rtW.getInputPanel();
    this.rtX = localv;
    AppMethodBeat.o(136325);
    return localv;
  }
  
  private boolean isFocused()
  {
    AppMethodBeat.i(136323);
    if (this.rtW == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.rtW.isFocused())
    {
      AppMethodBeat.o(136323);
      return true;
    }
    if (com() == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (!com().isShown())
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.rtX.getAttachedEditText() == this.rtW)
    {
      AppMethodBeat.o(136323);
      return true;
    }
    AppMethodBeat.o(136323);
    return false;
  }
  
  public final boolean anC(String paramString)
  {
    AppMethodBeat.i(136320);
    if (this.rtW == null)
    {
      AppMethodBeat.o(136320);
      return false;
    }
    this.rtW.P(paramString);
    AppMethodBeat.o(136320);
    return true;
  }
  
  public final h b(h paramh)
  {
    AppMethodBeat.i(136319);
    if (this.rtY == null)
    {
      this.rtY = paramh;
      if ((an.m(paramh.rAP)) && (this.rtW != null)) {
        this.rtW.setPasswordMode(true);
      }
    }
    while (this.rtW == null)
    {
      AppMethodBeat.o(136319);
      return null;
      this.rtY.a(paramh);
    }
    b.a(this.rtW, this.rtY);
    paramh = this.rtY;
    AppMethodBeat.o(136319);
    return paramh;
  }
  
  final Rect coa()
  {
    AppMethodBeat.i(136318);
    Rect localRect = new Rect(this.rtY.rAm.intValue(), this.rtY.rAl.intValue(), this.rtY.rAm.intValue() + this.rtY.rAj.intValue(), this.rtY.rAl.intValue() + this.rtY.rAk.intValue());
    AppMethodBeat.o(136318);
    return localRect;
  }
  
  public final boolean coj()
  {
    AppMethodBeat.i(136316);
    if ((this.rtY != null) && (an.m(this.rtY.rAG)))
    {
      AppMethodBeat.o(136316);
      return true;
    }
    AppMethodBeat.o(136316);
    return false;
  }
  
  public final int cok()
  {
    AppMethodBeat.i(136317);
    if ((this.rtY == null) || (this.rtY.rAD == null))
    {
      AppMethodBeat.o(136317);
      return 0;
    }
    int i = this.rtY.rAD.intValue();
    AppMethodBeat.o(136317);
    return i;
  }
  
  public final boolean col()
  {
    AppMethodBeat.i(136322);
    if (com() == null)
    {
      AppMethodBeat.o(136322);
      return false;
    }
    if (isFocused())
    {
      v localv = this.rtX;
      localv.setVisibility(8);
      localv.coO();
      Log.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[] { this.rtW });
      if (this.rtW != null)
      {
        this.rtW.setFocusable(false);
        this.rtW.setFocusableInTouchMode(false);
        this.rtW.setEnabled(false);
      }
      cof();
      cog();
      AppMethodBeat.o(136322);
      return true;
    }
    AppMethodBeat.o(136322);
    return false;
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136315);
    com();
    v localv = this.rtX;
    AppMethodBeat.o(136315);
    return localv;
  }
  
  protected final boolean kn(boolean paramBoolean)
  {
    AppMethodBeat.i(136324);
    Log.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isFocused()) });
    if (!paramBoolean)
    {
      if (this.rtZ)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (!isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.rtZ = true;
      a(cod());
      col();
      remove();
      this.rtZ = false;
      this.rtW = null;
    }
    for (;;)
    {
      AppMethodBeat.o(136324);
      return true;
      if (this.rua)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.rua = true;
      r(-2, -2, this.rub);
      this.rua = false;
    }
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(214295);
    if (this.rtW == null)
    {
      AppMethodBeat.o(214295);
      return false;
    }
    Object localObject2 = ((ad)this.rtP.get()).getContentView();
    if ((this.rtP.get() != null) && ((this.rtP.get() instanceof ad))) {}
    for (Object localObject1 = ((ad)this.rtP.get()).cef();; localObject1 = null)
    {
      this.rtX = v.a((View)localObject2, (a)localObject1);
      this.rtX.setComponentView(this.rtY.rAQ.booleanValue());
      localObject1 = this.rtX;
      if ((((v)localObject1).rwe) && (((v)localObject1).rwc == null))
      {
        ((v)localObject1).rwc = ((v)localObject1).rwd;
        v.du(((v)localObject1).rwc);
        ((v)localObject1).addView(((v)localObject1).rwc, 0);
      }
      if ((((v)localObject1).rwe) && (((v)localObject1).rwc != ((v)localObject1).rwd))
      {
        v.du(((v)localObject1).rwc);
        ((v)localObject1).rwc = ((v)localObject1).rwd;
        v.du(((v)localObject1).rwc);
        ((v)localObject1).addView(((v)localObject1).rwc, 0);
        Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
      }
      if ((((v)localObject1).rwe) && (((v)localObject1).rwc.getParent() != localObject1))
      {
        v.du(((v)localObject1).rwc);
        ((v)localObject1).addView(((v)localObject1).rwc, 0);
      }
      if ((!((v)localObject1).rwe) && (((v)localObject1).rwc != null) && (((v)localObject1).rwc.getParent() == localObject1)) {
        ((v)localObject1).removeView(((v)localObject1).rwc);
      }
      if (this.rtX != null) {
        break;
      }
      AppMethodBeat.o(214295);
      return false;
    }
    this.rub = paramBoolean;
    if (paramBoolean)
    {
      localObject1 = this.rtX;
      ((v)localObject1).rvY.setBackgroundResource(a.c.BW_BG_100);
      ((v)localObject1).rvY.findViewById(a.e.divider).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((v)localObject1).rvY.findViewById(a.e.button_area).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      localObject1 = ((v)localObject1).rwb;
      ((BaseNumberKeyboardView)localObject1).rub = true;
      ((BaseNumberKeyboardView)localObject1).mKey1.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKey1.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).mKey2.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKey2.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).mKey3.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKey3.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).mKey4.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKey4.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).mKey5.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKey5.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).mKey6.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKey6.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).mKey7.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKey7.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).mKey8.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKey8.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).mKey9.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKey9.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).mKeyX.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKeyX.setBackgroundResource(a.d.tenpay_keybtn_bottom_left_right_force_light);
      ((BaseNumberKeyboardView)localObject1).mKey0.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
      ((BaseNumberKeyboardView)localObject1).mKey0.setBackgroundResource(a.d.appbrand_keybtn_bg_force_light);
      ((BaseNumberKeyboardView)localObject1).rzG.setBackgroundResource(a.d.tenpay_keybtn_bottom_left_right_force_light);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.root_view).setBackgroundResource(a.c.BW_BG_100);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider1).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider2).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider3).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider4).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider5).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider6).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider7).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider8).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider9).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider10).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider11).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider12).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
      ((BaseNumberKeyboardView)localObject1).mrI.findViewById(a.e.divider13).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    }
    this.rua = true;
    coe();
    this.rtX.setXMode(this.rtV);
    localObject1 = this.rtX;
    localObject2 = this.rtW;
    if (localObject2 != null)
    {
      if (((v)localObject1).mEditText != localObject2) {
        ((v)localObject1).coO();
      }
      ((v)localObject1).setInputEditText((EditText)localObject2);
      ((v)localObject1).setVisibility(0);
    }
    this.rtX.setOnDoneListener(new v.a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(136313);
        d.this.a(d.this.cod());
        d.this.kn(false);
        AppMethodBeat.o(136313);
      }
    });
    fh(paramInt1, paramInt2);
    coh();
    this.rua = false;
    AppMethodBeat.o(214295);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d
 * JD-Core Version:    0.7.0.1
 */