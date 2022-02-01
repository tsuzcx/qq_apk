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
import androidx.core.g.w;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a.a;
import com.tencent.luggage.k.j;
import com.tencent.luggage.wxa.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.input.aa.e;
import com.tencent.mm.plugin.appbrand.widget.input.aa.f;
import com.tencent.mm.plugin.appbrand.widget.input.an;
import com.tencent.mm.plugin.appbrand.widget.input.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.i;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.c<v>
{
  static final int CTRL_INDEX = 1;
  static final String NAME = "showKeyboard";
  final d cuS;
  final b cuT;
  final c cuU;
  final h cuV;
  
  public f()
  {
    AppMethodBeat.i(130618);
    this.cuS = new d();
    this.cuT = new b();
    this.cuU = new c();
    this.cuV = new h();
    AppMethodBeat.o(130618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.f
 * JD-Core Version:    0.7.0.1
 */