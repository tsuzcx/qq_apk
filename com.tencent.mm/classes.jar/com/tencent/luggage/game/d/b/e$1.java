package com.tencent.luggage.game.d.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a.a;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.f.a;

final class e$1
  implements Runnable
{
  e$1(e parame, r paramr, String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, b paramb, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(130611);
    Object localObject4 = this.ckG;
    Object localObject3 = this.cjR;
    Object localObject1 = this.ckB;
    int i = this.ckC;
    boolean bool2 = this.ckD;
    boolean bool3 = this.ckE;
    b localb = this.ckF;
    int j = this.cjS;
    if (((r)localObject3).isRunning())
    {
      localObject2 = ((r)localObject3).getCurrentPageView();
      if (localObject2 != null) {}
    }
    else
    {
      AppMethodBeat.o(130611);
      return;
    }
    float f = com.tencent.mm.cb.a.getDensity(((z)localObject2).getContext());
    Object localObject2 = com.tencent.luggage.game.widget.input.a.cp(((z)localObject2).kfr);
    WAGamePanelInputEditText localWAGamePanelInputEditText = ((com.tencent.luggage.game.widget.input.a)localObject2).getAttachedEditText();
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      localWAGamePanelInputEditText.setSingleLine(bool1);
      localWAGamePanelInputEditText.setMaxLength(i);
      com.tencent.mm.ui.tools.b.c localc = p.a(localWAGamePanelInputEditText).afD(i);
      localc.LiL = false;
      localc.njK = f.a.Lfg;
      localc.a(new e.2((e)localObject4, localWAGamePanelInputEditText, (r)localObject3));
      if (bu.isNullOrNil((String)localObject1)) {
        break label707;
      }
      if (((String)localObject1).length() <= i) {
        break label704;
      }
      localObject1 = ((String)localObject1).substring(0, i);
      label193:
      localWAGamePanelInputEditText.setText((CharSequence)localObject1);
      localWAGamePanelInputEditText.setSelection(localWAGamePanelInputEditText.getText().length());
      label215:
      localWAGamePanelInputEditText.addTextChangedListener(new e.3((e)localObject4, (r)localObject3));
      localWAGamePanelInputEditText.setComposingDismissedListener(new e.4((e)localObject4, localWAGamePanelInputEditText, (r)localObject3));
      ((com.tencent.luggage.game.widget.input.a)localObject2).setOnConfirmClickListener(new e.5((e)localObject4, localWAGamePanelInputEditText, (r)localObject3, bool3, (com.tencent.luggage.game.widget.input.a)localObject2));
      ((com.tencent.luggage.game.widget.input.a)localObject2).setOnVisibilityChangedListener(new e.6((e)localObject4, localWAGamePanelInputEditText, (r)localObject3, (com.tencent.luggage.game.widget.input.a)localObject2, f, j));
      if (!bool2) {
        localWAGamePanelInputEditText.setOnEditorActionListener(new e.7((e)localObject4, localWAGamePanelInputEditText, (r)localObject3, bool3));
      }
      localObject4 = ((r)localObject3).jDa.getOrientationHandler().aYg();
      localObject1 = com.tencent.mm.sdk.f.a.jw(((r)localObject3).getRuntime().mContext);
      if ((localObject4 == e.b.mtF) || (localObject4 == e.b.mtG) || (e.b.mtH == localObject4) || (e.b.mtI == localObject4))
      {
        if (localObject1 != null) {
          break label718;
        }
        i = 0;
        label387:
        if (i <= 0) {
          break label876;
        }
        i = 1;
        label393:
        if (i == 0) {
          break label881;
        }
        i = 0;
        j = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
        if (j > 0) {
          i = Resources.getSystem().getDimensionPixelSize(j);
        }
        label427:
        j = i.cre.aG((Context)localObject1);
        localObject1 = (LinearLayout.LayoutParams)((com.tencent.luggage.game.widget.input.a)localObject2).clW.getLayoutParams();
        ae.i("MicroMsg.WAGameInputPanel", "EditBar setmEditText cutoutHeight(%d),leftMargin(%d).", new Object[] { Integer.valueOf(j), Integer.valueOf(((LinearLayout.LayoutParams)localObject1).leftMargin) });
        if (j <= 0) {
          break label886;
        }
        ((LinearLayout.LayoutParams)localObject1).setMargins(j, ((LinearLayout.LayoutParams)localObject1).topMargin, ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
        label505:
        ((com.tencent.luggage.game.widget.input.a)localObject2).clW.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = ((com.tencent.luggage.game.widget.input.a)localObject2).clV;
        localObject3 = (LinearLayout.LayoutParams)((a.a)localObject1).cma.getLayoutParams();
        ae.i("MicroMsg.WAGameInputPanel", "EditBar setmConfirmButtonPadding tolerate(%d),rightMargin(%d).", new Object[] { Integer.valueOf(i), Integer.valueOf(((LinearLayout.LayoutParams)localObject3).rightMargin) });
        ((LinearLayout.LayoutParams)localObject3).setMargins(((LinearLayout.LayoutParams)localObject3).leftMargin, ((LinearLayout.LayoutParams)localObject3).topMargin, i + ((LinearLayout.LayoutParams)localObject3).rightMargin, ((LinearLayout.LayoutParams)localObject3).bottomMargin);
        ((a.a)localObject1).cma.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      if (localb != null) {
        break label914;
      }
      localObject1 = b.nnO;
      label613:
      ((com.tencent.luggage.game.widget.input.a)localObject2).getAttachedEditText().setImeOptions(((b)localObject1).nnU);
      ((com.tencent.luggage.game.widget.input.a)localObject2).getAttachedEditText().setFocusable(true);
      ((com.tencent.luggage.game.widget.input.a)localObject2).getAttachedEditText().setFocusableInTouchMode(true);
      ((com.tencent.luggage.game.widget.input.a)localObject2).show();
      switch (com.tencent.luggage.game.widget.input.a.2.clZ[localObject1.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(130611);
      return;
      bool1 = false;
      break;
      label704:
      break label193;
      label707:
      localWAGamePanelInputEditText.setText("");
      break label215;
      label718:
      localObject3 = (WindowManager)((Context)localObject1).getSystemService("window");
      if (localObject3 == null)
      {
        ae.e("Luggage.LuggageUIHelper", "getRealBottomHeight, get NULL windowManager");
        i = 0;
        break label387;
      }
      localObject4 = ((WindowManager)localObject3).getDefaultDisplay();
      localObject3 = new Point();
      ((Display)localObject4).getSize((Point)localObject3);
      localObject4 = q.ck((Context)localObject1);
      i = Math.max(((Point)localObject3).y, ((Point)localObject3).x);
      j = Math.max(((Point)localObject4).y, ((Point)localObject4).x);
      localObject3 = new Rect();
      if ((localObject1 instanceof Activity))
      {
        ((Activity)localObject1).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
        i = Math.max(((Rect)localObject3).bottom - ((Rect)localObject3).top, ((Rect)localObject3).right - ((Rect)localObject3).left);
      }
      i = j - i;
      break label387;
      label876:
      i = 0;
      break label393;
      label881:
      i = 0;
      break label427;
      label886:
      ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, ((LinearLayout.LayoutParams)localObject1).topMargin, ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
      break label505;
      label914:
      localObject1 = localb;
      break label613;
      ((Button)((com.tencent.luggage.game.widget.input.a)localObject2).clV.getConfirmButton()).setText(2131755966);
      AppMethodBeat.o(130611);
      return;
      ((Button)((com.tencent.luggage.game.widget.input.a)localObject2).clV.getConfirmButton()).setText(2131755969);
      AppMethodBeat.o(130611);
      return;
      ((Button)((com.tencent.luggage.game.widget.input.a)localObject2).clV.getConfirmButton()).setText(2131755968);
      AppMethodBeat.o(130611);
      return;
      ((Button)((com.tencent.luggage.game.widget.input.a)localObject2).clV.getConfirmButton()).setText(2131755967);
      AppMethodBeat.o(130611);
      return;
      ((Button)((com.tencent.luggage.game.widget.input.a)localObject2).clV.getConfirmButton()).setText(2131755970);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.e.1
 * JD-Core Version:    0.7.0.1
 */