package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.b.c.c;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public abstract class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a<h>
{
  protected static MMActivity a(h paramh)
  {
    if ((paramh instanceof r)) {}
    for (paramh = ((r)paramh).X(Activity.class); (paramh == null) || (!(paramh instanceof MMActivity)); paramh = paramh.getContext()) {
      return null;
    }
    return (MMActivity)paramh;
  }
  
  protected static <T> LinkedList<T> j(ArrayList<T> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(paramArrayList);
    return localLinkedList;
  }
  
  protected static LinkedList<c.c> x(LinkedList<bwv> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      bwv localbwv = (bwv)paramLinkedList.next();
      c.c localc = new c.c();
      localc.scope = localbwv.wAh;
      localc.desc = localbwv.Desc;
      localc.state = localbwv.xJY;
      localLinkedList.add(localc);
    }
    return localLinkedList;
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    if (!paramJSONObject.optBoolean("requestInQueue", true))
    {
      a.x(paramh.getRuntime()).a(this, paramh, paramJSONObject, paramInt);
      return;
    }
    c.y(paramh.getRuntime()).a(this, paramh, paramJSONObject, paramInt);
  }
  
  protected abstract void a(h paramh, JSONObject paramJSONObject, int paramInt, d paramd);
  
  final void b(h paramh, int paramInt, String paramString)
  {
    paramh.h(paramInt, j(paramString, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f
 * JD-Core Version:    0.7.0.1
 */