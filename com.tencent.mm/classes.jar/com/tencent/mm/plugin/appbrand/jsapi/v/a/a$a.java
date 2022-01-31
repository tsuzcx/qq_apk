package com.tencent.mm.plugin.appbrand.jsapi.v.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class a$a
{
  static ai iig;
  static ai iih;
  static ai iii;
  static ai iij;
  static ai iik;
  static ai iil;
  static ai iim;
  public String data;
  long ePF;
  GestureDetector idY;
  private e ihZ;
  public boolean iin;
  
  static
  {
    AppMethodBeat.i(154444);
    iig = new d.c();
    iih = new d.e();
    iii = new d.d();
    iij = new d.b();
    iik = new d.a();
    iil = new a.b((byte)0);
    iim = new a.c((byte)0);
    AppMethodBeat.o(154444);
  }
  
  public a$a(e parame)
  {
    AppMethodBeat.i(154434);
    this.ePF = 0L;
    this.ihZ = parame;
    this.idY = new GestureDetector(this.ihZ.getContext(), new a.a.1(this));
    AppMethodBeat.o(154434);
  }
  
  private static JSONObject D(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(154435);
    int i = paramMotionEvent.getActionIndex();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    paramMotionEvent = new d.f();
    paramMotionEvent.b(j, f1, f2);
    paramMotionEvent = paramMotionEvent.toJSONObject();
    AppMethodBeat.o(154435);
    return paramMotionEvent;
  }
  
  static JSONArray E(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(154436);
    JSONArray localJSONArray = new JSONArray();
    paramMotionEvent = y(paramMotionEvent);
    if (paramMotionEvent.length > 0)
    {
      int i = 0;
      while (i < paramMotionEvent.length)
      {
        localJSONArray.put(paramMotionEvent[i].toJSONObject());
        i += 1;
      }
    }
    AppMethodBeat.o(154436);
    return localJSONArray;
  }
  
  private void b(ai paramai, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(154439);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("data", this.data);
    localHashMap.put("touch", paramJSONObject);
    this.ihZ.b(paramai.x(localHashMap));
    AppMethodBeat.o(154439);
  }
  
  private void c(ai paramai, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(154440);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("data", this.data);
    localHashMap.put("touch", paramJSONObject);
    this.ihZ.a(paramai.x(localHashMap));
    AppMethodBeat.o(154440);
  }
  
  private static d.f[] y(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(154442);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      d.f localf = new d.f();
      localf.id = paramMotionEvent.getPointerId(i);
      localf.x = paramMotionEvent.getX(i);
      localf.y = paramMotionEvent.getY(i);
      localArrayList.add(localf);
      i += 1;
    }
    paramMotionEvent = new d.f[localArrayList.size()];
    i = j;
    while (i < localArrayList.size())
    {
      paramMotionEvent[i] = ((d.f)localArrayList.get(i));
      i += 1;
    }
    AppMethodBeat.o(154442);
    return paramMotionEvent;
  }
  
  final void F(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(154437);
    b(iig, D(paramMotionEvent));
    AppMethodBeat.o(154437);
  }
  
  final void G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(154438);
    b(iih, D(paramMotionEvent));
    c(iim, D(paramMotionEvent));
    AppMethodBeat.o(154438);
  }
  
  final void a(ai paramai, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(154441);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("data", this.data);
    localHashMap.put("touches", paramJSONArray);
    this.ihZ.b(paramai.x(localHashMap));
    AppMethodBeat.o(154441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a.a.a
 * JD-Core Version:    0.7.0.1
 */