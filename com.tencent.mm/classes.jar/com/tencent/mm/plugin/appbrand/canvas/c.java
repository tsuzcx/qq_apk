package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.a;
import com.tencent.mm.plugin.appbrand.canvas.action.aa;
import com.tencent.mm.plugin.appbrand.canvas.action.ab;
import com.tencent.mm.plugin.appbrand.canvas.action.ac;
import com.tencent.mm.plugin.appbrand.canvas.action.ad;
import com.tencent.mm.plugin.appbrand.canvas.action.ae;
import com.tencent.mm.plugin.appbrand.canvas.action.af;
import com.tencent.mm.plugin.appbrand.canvas.action.ag;
import com.tencent.mm.plugin.appbrand.canvas.action.ah;
import com.tencent.mm.plugin.appbrand.canvas.action.ai;
import com.tencent.mm.plugin.appbrand.canvas.action.aj;
import com.tencent.mm.plugin.appbrand.canvas.action.ak;
import com.tencent.mm.plugin.appbrand.canvas.action.b;
import com.tencent.mm.plugin.appbrand.canvas.action.e;
import com.tencent.mm.plugin.appbrand.canvas.action.f;
import com.tencent.mm.plugin.appbrand.canvas.action.g;
import com.tencent.mm.plugin.appbrand.canvas.action.h;
import com.tencent.mm.plugin.appbrand.canvas.action.i;
import com.tencent.mm.plugin.appbrand.canvas.action.j;
import com.tencent.mm.plugin.appbrand.canvas.action.k;
import com.tencent.mm.plugin.appbrand.canvas.action.l;
import com.tencent.mm.plugin.appbrand.canvas.action.m;
import com.tencent.mm.plugin.appbrand.canvas.action.n;
import com.tencent.mm.plugin.appbrand.canvas.action.o;
import com.tencent.mm.plugin.appbrand.canvas.action.p;
import com.tencent.mm.plugin.appbrand.canvas.action.q;
import com.tencent.mm.plugin.appbrand.canvas.action.r;
import com.tencent.mm.plugin.appbrand.canvas.action.s;
import com.tencent.mm.plugin.appbrand.canvas.action.t;
import com.tencent.mm.plugin.appbrand.canvas.action.u;
import com.tencent.mm.plugin.appbrand.canvas.action.v;
import com.tencent.mm.plugin.appbrand.canvas.action.w;
import com.tencent.mm.plugin.appbrand.canvas.action.x;
import com.tencent.mm.plugin.appbrand.canvas.action.y;
import com.tencent.mm.plugin.appbrand.canvas.action.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public Map<String, com.tencent.mm.plugin.appbrand.canvas.action.d> heA;
  
  public c()
  {
    AppMethodBeat.i(103162);
    this.heA = new HashMap();
    a(new ae());
    a(new q());
    a(new af());
    a(new v());
    a(new k());
    a(new a());
    a(new h());
    a(new e());
    a(new l());
    a(new i());
    a(new f());
    a(new ad());
    a(new j());
    a(new g());
    a(new com.tencent.mm.plugin.appbrand.canvas.action.c());
    a(new b());
    a(new ag());
    a(new ah());
    a(new x());
    a(new aa());
    a(new ab());
    a(new ac());
    a(new s());
    a(new y());
    a(new t());
    a(new u());
    a(new r());
    a(new z());
    a(new ai());
    a(new w());
    a(new p());
    a(new n());
    a(new ak());
    a(new o());
    a(new m());
    a(new aj());
    AppMethodBeat.o(103162);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.canvas.action.d paramd)
  {
    AppMethodBeat.i(103164);
    this.heA.put(paramd.getMethod(), paramd);
    AppMethodBeat.o(103164);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103163);
    Object localObject = paramJSONObject.optString("method");
    paramJSONObject = paramJSONObject.optJSONArray("data");
    localObject = (com.tencent.mm.plugin.appbrand.canvas.action.d)this.heA.get(localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(103163);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.appbrand.canvas.action.d)localObject).a(paramd, paramCanvas, paramJSONObject);
    AppMethodBeat.o(103163);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.c
 * JD-Core Version:    0.7.0.1
 */