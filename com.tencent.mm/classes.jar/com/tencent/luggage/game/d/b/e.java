package com.tencent.luggage.game.d.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.plugin.appbrand.widget.input.aj;
import com.tencent.mm.plugin.appbrand.widget.input.p.a;
import com.tencent.mm.plugin.appbrand.widget.input.w.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.g;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  private static final int CTRL_INDEX = 1;
  private static final String NAME = "showKeyboard";
  final c cdi;
  final a cdj;
  final b cdk;
  
  public e()
  {
    AppMethodBeat.i(130618);
    this.cdi = new c();
    this.cdj = new a();
    this.cdk = new b();
    AppMethodBeat.o(130618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.e
 * JD-Core Version:    0.7.0.1
 */