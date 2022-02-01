package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

final class d
  extends c<s>
{
  int orM;
  s orN;
  v orO;
  com.tencent.mm.plugin.appbrand.widget.input.d.h orP;
  boolean orQ;
  boolean orR;
  private boolean orS;
  
  d(String paramString, ac paramac, e parame)
  {
    super(paramString, paramac, parame.orE);
    AppMethodBeat.i(136314);
    this.orM = 0;
    this.orN = new s(paramac.getContext());
    this.orM = Util.nullAs((Integer)o.otl.get(paramString), 0);
    AppMethodBeat.o(136314);
  }
  
  private v cbb()
  {
    AppMethodBeat.i(136325);
    if (this.orO != null)
    {
      localv = this.orO;
      AppMethodBeat.o(136325);
      return localv;
    }
    v localv = this.orN.getInputPanel();
    this.orO = localv;
    AppMethodBeat.o(136325);
    return localv;
  }
  
  private boolean isFocused()
  {
    AppMethodBeat.i(136323);
    if (this.orN == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.orN.isFocused())
    {
      AppMethodBeat.o(136323);
      return true;
    }
    if (cbb() == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (!cbb().isShown())
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.orO.getAttachedEditText() == this.orN)
    {
      AppMethodBeat.o(136323);
      return true;
    }
    AppMethodBeat.o(136323);
    return false;
  }
  
  public final boolean afY(String paramString)
  {
    AppMethodBeat.i(136320);
    if (this.orN == null)
    {
      AppMethodBeat.o(136320);
      return false;
    }
    this.orN.G(paramString);
    AppMethodBeat.o(136320);
    return true;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.input.d.h b(com.tencent.mm.plugin.appbrand.widget.input.d.h paramh)
  {
    AppMethodBeat.i(136319);
    if (this.orP == null)
    {
      this.orP = paramh;
      if ((aj.i(paramh.oyp)) && (this.orN != null)) {
        this.orN.setPasswordMode(true);
      }
    }
    while (this.orN == null)
    {
      AppMethodBeat.o(136319);
      return null;
      this.orP.a(paramh);
    }
    b.a(this.orN, this.orP);
    paramh = this.orP;
    AppMethodBeat.o(136319);
    return paramh;
  }
  
  final Rect caT()
  {
    AppMethodBeat.i(136318);
    Rect localRect = new Rect(this.orP.oxN.intValue(), this.orP.oxM.intValue(), this.orP.oxN.intValue() + this.orP.oxK.intValue(), this.orP.oxM.intValue() + this.orP.oxL.intValue());
    AppMethodBeat.o(136318);
    return localRect;
  }
  
  public final boolean caY()
  {
    AppMethodBeat.i(136316);
    if ((this.orP != null) && (aj.i(this.orP.oyh)))
    {
      AppMethodBeat.o(136316);
      return true;
    }
    AppMethodBeat.o(136316);
    return false;
  }
  
  public final int caZ()
  {
    AppMethodBeat.i(136317);
    if ((this.orP == null) || (this.orP.oye == null))
    {
      AppMethodBeat.o(136317);
      return 0;
    }
    int i = this.orP.oye.intValue();
    AppMethodBeat.o(136317);
    return i;
  }
  
  public final boolean cba()
  {
    AppMethodBeat.i(136322);
    if (cbb() == null)
    {
      AppMethodBeat.o(136322);
      return false;
    }
    if (isFocused())
    {
      Object localObject = this.orO;
      ((v)localObject).setVisibility(8);
      ((v)localObject).cbE();
      Log.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[] { this.orN });
      if (this.orN != null)
      {
        this.orN.setFocusable(false);
        this.orN.setFocusableInTouchMode(false);
        this.orN.setEnabled(false);
      }
      localObject = (ac)this.orG.get();
      if ((localObject != null) && (((ac)localObject).nmX != null)) {
        h.cbe().e(((ac)localObject).nmX);
      }
      k.a(this.orG).Ad(this.orE);
      AppMethodBeat.o(136322);
      return true;
    }
    AppMethodBeat.o(136322);
    return false;
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136315);
    cbb();
    v localv = this.orO;
    AppMethodBeat.o(136315);
    return localv;
  }
  
  protected final boolean jg(boolean paramBoolean)
  {
    AppMethodBeat.i(136324);
    Log.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isFocused()) });
    if (!paramBoolean)
    {
      if (this.orQ)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (!isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.orQ = true;
      a(cbf());
      cba();
      remove();
      this.orQ = false;
      this.orN = null;
    }
    for (;;)
    {
      AppMethodBeat.o(136324);
      return true;
      if (this.orR)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.orR = true;
      q(-2, -2, this.orS);
      this.orR = false;
    }
  }
  
  public final boolean q(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(230571);
    if (this.orN == null)
    {
      AppMethodBeat.o(230571);
      return false;
    }
    Object localObject2 = ((ac)this.orG.get()).getContentView();
    if ((this.orG.get() != null) && ((this.orG.get() instanceof ac))) {}
    for (Object localObject1 = ((ac)this.orG.get()).bRo();; localObject1 = null)
    {
      this.orO = v.a((View)localObject2, (a)localObject1);
      this.orO.setComponentView(this.orP.oyq.booleanValue());
      localObject1 = this.orO;
      if ((v.otQ) && (((v)localObject1).otO == null))
      {
        ((v)localObject1).otO = v.otP;
        v.db(((v)localObject1).otO);
        ((v)localObject1).addView(((v)localObject1).otO, 0);
      }
      if ((v.otQ) && (((v)localObject1).otO != v.otP))
      {
        v.db(((v)localObject1).otO);
        ((v)localObject1).otO = v.otP;
        v.db(((v)localObject1).otO);
        ((v)localObject1).addView(((v)localObject1).otO, 0);
        Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
      }
      if ((v.otQ) && (((v)localObject1).otO.getParent() != localObject1))
      {
        v.db(((v)localObject1).otO);
        ((v)localObject1).addView(((v)localObject1).otO, 0);
      }
      if ((!v.otQ) && (((v)localObject1).otO != null) && (((v)localObject1).otO.getParent() == localObject1)) {
        ((v)localObject1).removeView(((v)localObject1).otO);
      }
      if (this.orO != null) {
        break;
      }
      AppMethodBeat.o(230571);
      return false;
    }
    this.orS = paramBoolean;
    if (paramBoolean)
    {
      localObject1 = this.orO;
      ((v)localObject1).otK.setBackgroundResource(2131099694);
      ((v)localObject1).otK.findViewById(2131299682).setBackgroundResource(2131099832);
      ((v)localObject1).otK.findViewById(2131297902).setBackgroundResource(2131099832);
      localObject1 = ((v)localObject1).otN;
      ((BaseNumberKeyboardView)localObject1).orS = true;
      ((BaseNumberKeyboardView)localObject1).mKey1.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKey1.setBackgroundResource(2131231089);
      ((BaseNumberKeyboardView)localObject1).mKey2.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKey2.setBackgroundResource(2131231089);
      ((BaseNumberKeyboardView)localObject1).mKey3.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKey3.setBackgroundResource(2131231089);
      ((BaseNumberKeyboardView)localObject1).mKey4.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKey4.setBackgroundResource(2131231089);
      ((BaseNumberKeyboardView)localObject1).mKey5.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKey5.setBackgroundResource(2131231089);
      ((BaseNumberKeyboardView)localObject1).mKey6.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKey6.setBackgroundResource(2131231089);
      ((BaseNumberKeyboardView)localObject1).mKey7.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKey7.setBackgroundResource(2131231089);
      ((BaseNumberKeyboardView)localObject1).mKey8.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKey8.setBackgroundResource(2131231089);
      ((BaseNumberKeyboardView)localObject1).mKey9.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKey9.setBackgroundResource(2131231089);
      ((BaseNumberKeyboardView)localObject1).mKeyX.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKeyX.setBackgroundResource(2131235232);
      ((BaseNumberKeyboardView)localObject1).mKey0.setTextColor(((BaseNumberKeyboardView)localObject1).getResources().getColor(2131099836));
      ((BaseNumberKeyboardView)localObject1).mKey0.setBackgroundResource(2131231089);
      ((BaseNumberKeyboardView)localObject1).owM.setBackgroundResource(2131235232);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131307173).setBackgroundResource(2131099694);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299683).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299688).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299689).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299690).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299691).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299692).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299693).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299694).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299695).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299684).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299685).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299686).setBackgroundResource(2131099832);
      ((BaseNumberKeyboardView)localObject1).jBN.findViewById(2131299687).setBackgroundResource(2131099832);
    }
    this.orR = true;
    localObject1 = (ac)this.orG.get();
    if ((localObject1 != null) && (((ac)localObject1).nmX != null)) {
      h.cbe().d(((ac)localObject1).nmX);
    }
    this.orO.setXMode(this.orM);
    localObject1 = this.orO;
    localObject2 = this.orN;
    if (localObject2 != null)
    {
      if (((v)localObject1).mEditText != localObject2) {
        ((v)localObject1).cbE();
      }
      ((v)localObject1).setInputEditText((EditText)localObject2);
      ((v)localObject1).setVisibility(0);
    }
    this.orO.setOnDoneListener(new v.a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(136313);
        d.this.a(d.this.cbf());
        d.this.jg(false);
        AppMethodBeat.o(136313);
      }
    });
    eJ(paramInt1, paramInt2);
    k.a(this.orG).Ac(this.orE);
    this.orR = false;
    AppMethodBeat.o(230571);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d
 * JD-Core Version:    0.7.0.1
 */