package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.c;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c<g>
{
  protected boolean lBT = false;
  
  protected static <T> LinkedList<T> B(ArrayList<T> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(paramArrayList);
    return localLinkedList;
  }
  
  protected static Activity b(j paramj)
  {
    if ((paramj instanceof v)) {}
    for (paramj = ((v)paramj).ax(Activity.class); paramj == null; paramj = paramj.getContext()) {
      return null;
    }
    return AndroidContextUtil.castActivityOrNull(paramj);
  }
  
  protected static LinkedList<c.c> z(LinkedList<eax> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      eax localeax = (eax)paramLinkedList.next();
      c.c localc = new c.c();
      localc.scope = localeax.RXY;
      localc.desc = localeax.CMB;
      localc.state = localeax.UfR;
      localLinkedList.add(localc);
    }
    return localLinkedList;
  }
  
  public void a(g paramg, JSONObject paramJSONObject, int paramInt)
  {
    this.lBT = paramJSONObject.optBoolean("keepAlive", false);
    boolean bool = paramJSONObject.optBoolean("requestInQueue", true);
    if ("adOperateWXData".equalsIgnoreCase(getName()))
    {
      a(paramg, paramJSONObject, paramInt, null);
      return;
    }
    try
    {
      paramJSONObject.put("wxdataQueueTimestamp", Util.nowMilliSecond());
      label51:
      if (!bool)
      {
        b.V(paramg.getRuntime()).a(this, paramg, paramJSONObject, paramInt);
        return;
      }
      d.W(paramg.getRuntime()).a(this, paramg, paramJSONObject, paramInt);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label51;
    }
  }
  
  protected abstract void a(g paramg, JSONObject paramJSONObject, int paramInt, e parame);
  
  @Deprecated
  final void b(j paramj, int paramInt, String paramString)
  {
    paramj.j(paramInt, h(paramString, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.i
 * JD-Core Version:    0.7.0.1
 */