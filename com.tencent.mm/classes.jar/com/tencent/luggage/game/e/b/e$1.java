package com.tencent.luggage.game.e.b;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f.a;

final class e$1
  implements Runnable
{
  e$1(e parame, r paramr, String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, b paramb, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(140473);
    e locale = this.bBC;
    Object localObject3 = this.bAW;
    Object localObject2 = this.bBx;
    int i = this.bBy;
    boolean bool2 = this.bBz;
    boolean bool3 = this.bBA;
    b localb = this.bBB;
    int j = this.bAX;
    Object localObject1;
    if (((r)localObject3).isRunning())
    {
      localObject1 = ((r)localObject3).getCurrentPageView();
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(140473);
      return;
    }
    float f = com.tencent.mm.cb.a.getDensity(((v)localObject1).getContext());
    com.tencent.luggage.game.widget.input.a locala = com.tencent.luggage.game.widget.input.a.cg(((v)localObject1).hmw);
    WAGamePanelInputEditText localWAGamePanelInputEditText = locala.getAttachedEditText();
    boolean bool1;
    if (!bo.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > i) {
        localObject1 = ((String)localObject2).substring(0, i);
      }
      localWAGamePanelInputEditText.setText((CharSequence)localObject1);
      localWAGamePanelInputEditText.setSelection(localWAGamePanelInputEditText.getText().length());
      if (bool2) {
        break label597;
      }
      bool1 = true;
      label163:
      localWAGamePanelInputEditText.setSingleLine(bool1);
      localWAGamePanelInputEditText.setMaxLength(i);
      localObject1 = p.a(localWAGamePanelInputEditText).QS(i);
      ((c)localObject1).AyD = false;
      ((c)localObject1).jmp = f.a.Avm;
      ((c)localObject1).a(new e.2(locale, localWAGamePanelInputEditText, (r)localObject3));
      localWAGamePanelInputEditText.addTextChangedListener(new e.3(locale, (r)localObject3));
      localWAGamePanelInputEditText.setComposingDismissedListener(new e.4(locale, localWAGamePanelInputEditText, (r)localObject3));
      locala.setOnConfirmClickListener(new e.5(locale, localWAGamePanelInputEditText, (r)localObject3, bool3, locala));
      locala.setOnVisibilityChangedListener(new e.6(locale, localWAGamePanelInputEditText, (r)localObject3, locala, f, j));
      if (!bool2) {
        localWAGamePanelInputEditText.setOnEditorActionListener(new e.7(locale, bool3, localWAGamePanelInputEditText, (r)localObject3));
      }
      localObject1 = com.tencent.mm.plugin.appbrand.config.a.a.s(((r)localObject3).getRuntime().getContext()).dQ(com.tencent.mm.plugin.appbrand.config.a.a.ayK());
      localObject3 = ((r)localObject3).getRuntime().getContext();
      localObject2 = locala.bCC;
      i = af.fx((Context)localObject3);
      ab.i("MicroMsg.WAGameInputPanel", "orientation: %s", new Object[] { localObject1 });
      if ((localObject1 == a.b.hkF) || (localObject1 == a.b.hkG) || (a.b.hkH == localObject1) || (a.b.hkI == localObject1))
      {
        localObject1 = (LinearLayout.LayoutParams)((a.a)localObject2).bCH.getLayoutParams();
        ab.i("MicroMsg.WAGameInputPanel", "EditBar setmConfirmButtonPadding tolerate(%d),rightMargin(%d).", new Object[] { Integer.valueOf(i), Integer.valueOf(((LinearLayout.LayoutParams)localObject1).rightMargin) });
        ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, ((LinearLayout.LayoutParams)localObject1).topMargin, i + ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
        ((a.a)localObject2).bCH.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (localb != null) {
        break label603;
      }
      localObject1 = b.jqr;
      label502:
      locala.getAttachedEditText().setImeOptions(((b)localObject1).jqw);
      locala.getAttachedEditText().setFocusable(true);
      locala.getAttachedEditText().setFocusableInTouchMode(true);
      locala.show();
      switch (com.tencent.luggage.game.widget.input.a.2.bCG[localObject1.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(140473);
      return;
      localWAGamePanelInputEditText.setText("");
      break;
      label597:
      bool1 = false;
      break label163;
      label603:
      localObject1 = localb;
      break label502;
      ((Button)locala.bCC.getConfirmButton()).setText(2131297136);
      AppMethodBeat.o(140473);
      return;
      ((Button)locala.bCC.getConfirmButton()).setText(2131297139);
      AppMethodBeat.o(140473);
      return;
      ((Button)locala.bCC.getConfirmButton()).setText(2131297138);
      AppMethodBeat.o(140473);
      return;
      ((Button)locala.bCC.getConfirmButton()).setText(2131297137);
      AppMethodBeat.o(140473);
      return;
      ((Button)locala.bCC.getConfirmButton()).setText(2131297140);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.e.b.e.1
 * JD-Core Version:    0.7.0.1
 */