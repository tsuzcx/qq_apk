package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class j
  extends com.tencent.mm.plugin.appbrand.jsapi.c<g>
  implements com.tencent.mm.plugin.appbrand.jsapi.d<g>
{
  protected boolean otD = false;
  
  protected static LinkedList<c.c> C(LinkedList<eul> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      eul localeul = (eul)paramLinkedList.next();
      c.c localc = new c.c();
      localc.scope = localeul.YVX;
      localc.desc = localeul.IGG;
      localc.state = localeul.abxm;
      localLinkedList.add(localc);
    }
    return localLinkedList;
  }
  
  protected static <T> LinkedList<T> E(ArrayList<T> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(paramArrayList);
    return localLinkedList;
  }
  
  protected static Activity a(k paramk)
  {
    if ((paramk instanceof y)) {}
    for (paramk = ((y)paramk).aQ(Activity.class); paramk == null; paramk = paramk.getContext()) {
      return null;
    }
    return AndroidContextUtil.castActivityOrNull(paramk);
  }
  
  public void a(dh<g> paramdh)
  {
    g localg = (g)paramdh.rBv;
    JSONObject localJSONObject = paramdh.rmi;
    this.otD = localJSONObject.optBoolean("keepAlive", false);
    boolean bool = localJSONObject.optBoolean("requestInQueue", true);
    if ("adOperateWXData".equalsIgnoreCase(getName()))
    {
      a(paramdh, null);
      return;
    }
    try
    {
      localJSONObject.put("wxdataQueueTimestamp", Util.nowMilliSecond());
      label65:
      if (!bool)
      {
        b.ac(localg.getRuntime()).execute(this, paramdh);
        return;
      }
      d.ad(localg.getRuntime()).execute(this, paramdh);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label65;
    }
  }
  
  protected abstract void a(dh<g> paramdh, e parame);
  
  @Deprecated
  final void b(k paramk, int paramInt, String paramString)
  {
    paramk.callback(paramInt, ZP(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.j
 * JD-Core Version:    0.7.0.1
 */