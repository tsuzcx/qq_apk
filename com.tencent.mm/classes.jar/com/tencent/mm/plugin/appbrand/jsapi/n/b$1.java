package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.luggage.l.b.a.b;
import com.tencent.luggage.l.b.a.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.plugin.appbrand.widget.b.i;
import java.util.ArrayList;
import org.json.JSONObject;

final class b$1
  implements Runnable
{
  b$1(b paramb, o paramo, q paramq, JSONObject paramJSONObject, ArrayList paramArrayList, int paramInt) {}
  
  public final void run()
  {
    if (!this.gcp.isRunning()) {
      return;
    }
    this.gjp.agN().a(ad.gVH);
    Object localObject = this.gcp.F(Activity.class);
    com.tencent.mm.plugin.appbrand.widget.b.b localb = new com.tencent.mm.plugin.appbrand.widget.b.b((Context)localObject);
    int i = h.bd(this.gbZ.optString("itemColor", ""), Color.parseColor("#000000"));
    localObject = (ViewGroup)View.inflate((Context)localObject, a.c.app_brand_action_sheet_list_layout, null);
    localb.setContentView((View)localObject);
    localObject = (ListView)((ViewGroup)localObject).findViewById(a.b.action_sheet_list);
    ((ListView)localObject).setAdapter(new b.a(this.dAu, i));
    ((ListView)localObject).setOnItemClickListener(new b.1.1(this, localb));
    localb.setOnCancelListener(new b.1.2(this));
    this.gcp.Zm().b(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.b.1
 * JD-Core Version:    0.7.0.1
 */