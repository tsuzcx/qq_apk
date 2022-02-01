package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.c;
import com.tencent.mm.protocal.protobuf.cmy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public abstract class h
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  protected static Activity c(com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    if ((paramh instanceof q)) {}
    for (paramh = ((q)paramh).au(Activity.class); paramh == null; paramh = paramh.getContext()) {
      return null;
    }
    return com.tencent.mm.sdk.f.a.iV(paramh);
  }
  
  protected static <T> LinkedList<T> q(ArrayList<T> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(paramArrayList);
    return localLinkedList;
  }
  
  protected static LinkedList<c.c> y(LinkedList<cmy> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cmy localcmy = (cmy)paramLinkedList.next();
      c.c localc = new c.c();
      localc.scope = localcmy.CLe;
      localc.desc = localcmy.Desc;
      localc.state = localcmy.EhH;
      localLinkedList.add(localc);
    }
    return localLinkedList;
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt)
  {
    if (!paramJSONObject.optBoolean("requestInQueue", true))
    {
      b.aa(paramh.getRuntime()).a(this, paramh, paramJSONObject, paramInt);
      return;
    }
    d.ab(paramh.getRuntime()).a(this, paramh, paramJSONObject, paramInt);
  }
  
  protected abstract void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt, e parame);
  
  @Deprecated
  final void b(com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, String paramString)
  {
    paramh.h(paramInt, e(paramString, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.h
 * JD-Core Version:    0.7.0.1
 */