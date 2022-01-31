package com.tencent.mm.plugin.appbrand.widget.d;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONObject;

public abstract class a
  extends c
{
  private static final LinkedList<Runnable> hze = new LinkedList();
  private static boolean hzf = false;
  private static a.a hzg = new a.1();
  
  protected final boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject, g paramg)
  {
    parame = new a.2(this, parame, paramInt, paramView, paramJSONObject, paramg);
    if (!hzf)
    {
      hzf = true;
      parame.run();
      return true;
    }
    hze.add(parame);
    y.i("MicroMsg.BaseMarkerAnimatorJsApi", "add to MarkerAnimator!");
    return true;
  }
  
  public abstract boolean a(e parame, JSONObject paramJSONObject, a.a parama, g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.a
 * JD-Core Version:    0.7.0.1
 */