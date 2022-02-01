package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.c;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class i
  extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.d>
{
  protected boolean iLM = false;
  
  protected static <T> LinkedList<T> A(ArrayList<T> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(paramArrayList);
    return localLinkedList;
  }
  
  protected static Activity b(k paramk)
  {
    if ((paramk instanceof s)) {}
    for (paramk = ((s)paramk).ay(Activity.class); paramk == null; paramk = paramk.getContext()) {
      return null;
    }
    return AndroidContextUtil.castActivityOrNull(paramk);
  }
  
  protected static LinkedList<c.c> y(LinkedList<drb> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      drb localdrb = (drb)paramLinkedList.next();
      c.c localc = new c.c();
      localc.scope = localdrb.KWK;
      localc.desc = localdrb.Desc;
      localc.state = localdrb.MTI;
      localLinkedList.add(localc);
    }
    return localLinkedList;
  }
  
  public void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt)
  {
    this.iLM = paramJSONObject.optBoolean("keepAlive", false);
    boolean bool = paramJSONObject.optBoolean("requestInQueue", true);
    if ("adOperateWXData".equalsIgnoreCase(getName()))
    {
      a(paramd, paramJSONObject, paramInt, null);
      return;
    }
    try
    {
      paramJSONObject.put("wxdataQueueTimestamp", Util.nowMilliSecond());
      label51:
      if (!bool)
      {
        b.U(paramd.getRuntime()).a(this, paramd, paramJSONObject, paramInt);
        return;
      }
      d.V(paramd.getRuntime()).a(this, paramd, paramJSONObject, paramInt);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label51;
    }
  }
  
  protected abstract void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt, e parame);
  
  @Deprecated
  final void b(k paramk, int paramInt, String paramString)
  {
    paramk.i(paramInt, h(paramString, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.i
 * JD-Core Version:    0.7.0.1
 */