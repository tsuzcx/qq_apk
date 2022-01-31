package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import java.util.ArrayList;
import org.json.JSONObject;

final class b$1
  implements Runnable
{
  b$1(b paramb, r paramr, v paramv, JSONObject paramJSONObject, ArrayList paramArrayList, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(74783);
    if (!this.bAW.isRunning())
    {
      AppMethodBeat.o(74783);
      return;
    }
    this.hxy.ixn.a(an.iyX);
    Object localObject = this.bAW.X(Activity.class);
    com.tencent.mm.plugin.appbrand.widget.b.b localb = new com.tencent.mm.plugin.appbrand.widget.b.b((Context)localObject);
    localb.setCanceledOnTouchOutside(true);
    int i = g.bA(this.bBa.optString("itemColor", ""), Color.parseColor("#000000"));
    localObject = (ViewGroup)View.inflate((Context)localObject, 2130968658, null);
    localb.setContentView((View)localObject);
    localObject = (ListView)((ViewGroup)localObject).findViewById(2131821150);
    ((ListView)localObject).setAdapter(new b.a(this.etW, i));
    ((ListView)localObject).setOnItemClickListener(new b.1.1(this, localb));
    localb.setOnCancelListener(new b.1.2(this));
    this.bAW.asX().b(localb);
    AppMethodBeat.o(74783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b.1
 * JD-Core Version:    0.7.0.1
 */