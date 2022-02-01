package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.c;
import com.tencent.mm.protocal.protobuf.cxm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public abstract class i
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.d>
{
  protected static Activity b(h paramh)
  {
    if ((paramh instanceof q)) {}
    for (paramh = ((q)paramh).au(Activity.class); paramh == null; paramh = paramh.getContext()) {
      return null;
    }
    return com.tencent.mm.sdk.f.a.jq(paramh);
  }
  
  protected static <T> LinkedList<T> v(ArrayList<T> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(paramArrayList);
    return localLinkedList;
  }
  
  protected static LinkedList<c.c> y(LinkedList<cxm> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cxm localcxm = (cxm)paramLinkedList.next();
      c.c localc = new c.c();
      localc.scope = localcxm.FKf;
      localc.desc = localcxm.Desc;
      localc.state = localcxm.HoV;
      localLinkedList.add(localc);
    }
    return localLinkedList;
  }
  
  public void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = paramJSONObject.optBoolean("requestInQueue", true);
    if ("adOperateWXData".equalsIgnoreCase(getName()))
    {
      a(paramd, paramJSONObject, paramInt, null);
      return;
    }
    if (!bool)
    {
      b.U(paramd.getRuntime()).a(this, paramd, paramJSONObject, paramInt);
      return;
    }
    d.V(paramd.getRuntime()).a(this, paramd, paramJSONObject, paramInt);
  }
  
  protected abstract void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt, e parame);
  
  @Deprecated
  final void b(h paramh, int paramInt, String paramString)
  {
    paramh.h(paramInt, e(paramString, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.i
 * JD-Core Version:    0.7.0.1
 */