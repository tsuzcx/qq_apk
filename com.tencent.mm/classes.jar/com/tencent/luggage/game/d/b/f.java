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
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.core.g.z;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a.a;
import com.tencent.luggage.l.k;
import com.tencent.luggage.wxa.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.widget.input.aa.e;
import com.tencent.mm.plugin.appbrand.widget.input.aa.f;
import com.tencent.mm.plugin.appbrand.widget.input.an;
import com.tencent.mm.plugin.appbrand.widget.input.p;
import com.tencent.mm.plugin.appbrand.widget.input.p.a;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.i;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.c<y>
{
  static final int CTRL_INDEX = 1;
  static final String NAME = "showKeyboard";
  final d emK;
  final b emL;
  final c emM;
  final h emN;
  
  public f()
  {
    AppMethodBeat.i(130618);
    this.emK = new d();
    this.emL = new b();
    this.emM = new c();
    this.emN = new h();
    AppMethodBeat.o(130618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.f
 * JD-Core Version:    0.7.0.1
 */