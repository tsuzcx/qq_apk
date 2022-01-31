package com.tencent.mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.c;
import com.tencent.mm.d.a.l;
import com.tencent.mm.d.a.t;
import com.tencent.mm.d.a.t.3;
import com.tencent.mm.d.a.t.a;
import com.tencent.mm.d.a.u;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.k;
import com.tencent.mm.plugin.appbrand.s.d;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class w
{
  protected u ccw;
  protected r gPA;
  k gRO;
  public t gRP;
  private ArrayList<t.a> gRQ;
  
  public w(r paramr)
  {
    AppMethodBeat.i(86783);
    this.ccw = new w.1(this);
    this.gPA = paramr;
    this.gRO = ((k)paramr.aAO().v(k.class));
    this.gRP = auk();
    this.gRQ = new ArrayList();
    String str1 = this.gPA.wH() + "wxa_library/bootstrap_j2v8_worker.js";
    String str2 = d.Fj("wxa_library/bootstrap_j2v8_worker.js");
    this.gRQ.add(new t.a(str1, str2));
    paramr.aAO().addJavascriptInterface(this, "WeixinWorker");
    AppMethodBeat.o(86783);
  }
  
  protected t auk()
  {
    AppMethodBeat.i(86784);
    t localt = new t(this.ccw);
    AppMethodBeat.o(86784);
    return localt;
  }
  
  protected void b(ArrayList<t.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(86787);
    paramArrayList.add(new t.a(this.gPA.wH() + "config", String.format("var __wxConfig = %s;", new Object[] { this.gPA.wE().toString() })));
    AppMethodBeat.o(86787);
  }
  
  @JavascriptInterface
  public int create(String paramString)
  {
    AppMethodBeat.i(86785);
    ArrayList localArrayList = new ArrayList(this.gRQ);
    b(localArrayList, paramString);
    localArrayList.add(yh(paramString));
    int i = this.gRP.d(localArrayList);
    AppMethodBeat.o(86785);
    return i;
  }
  
  @JavascriptInterface
  public void postMsgToWorker(int paramInt, String paramString)
  {
    AppMethodBeat.i(86789);
    t localt = this.gRP;
    l locall = (l)localt.ccv.get(Integer.valueOf(paramInt));
    if (locall != null) {
      locall.cbC.k(new t.3(localt, locall, paramString));
    }
    AppMethodBeat.o(86789);
  }
  
  @JavascriptInterface
  public void terminate(int paramInt)
  {
    AppMethodBeat.i(86788);
    l locall = (l)this.gRP.ccv.remove(Integer.valueOf(paramInt));
    if (locall != null) {
      locall.destroy();
    }
    AppMethodBeat.o(86788);
  }
  
  protected t.a yh(String paramString)
  {
    AppMethodBeat.i(86786);
    paramString = new t.a(this.gPA.wG() + paramString, ax.c(this.gPA.getRuntime(), paramString) + this.gPA.ce(paramString));
    AppMethodBeat.o(86786);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w
 * JD-Core Version:    0.7.0.1
 */