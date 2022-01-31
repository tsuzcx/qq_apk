package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  public Map<String, a> fMD = new HashMap();
  
  public e()
  {
    a(new h());
    a(new f());
    a(new g());
    a(new i());
    a(new d());
    a(new b());
    a(new c());
    a(new j());
  }
  
  private void a(a parama)
  {
    this.fMD.put(parama.getMethod(), parama);
  }
  
  public final Path a(PathActionArgWrapper paramPathActionArgWrapper)
  {
    Path localPath = new Path();
    paramPathActionArgWrapper = paramPathActionArgWrapper.fMg;
    if ((paramPathActionArgWrapper == null) || (paramPathActionArgWrapper.size() == 0)) {
      return localPath;
    }
    paramPathActionArgWrapper = paramPathActionArgWrapper.iterator();
    while (paramPathActionArgWrapper.hasNext())
    {
      BasePathActionArg localBasePathActionArg = (BasePathActionArg)paramPathActionArgWrapper.next();
      if (localBasePathActionArg != null)
      {
        Object localObject = localBasePathActionArg.method;
        localObject = (a)this.fMD.get(localObject);
        if (localObject != null) {
          ((a)localObject).a(localPath, localBasePathActionArg);
        }
      }
    }
    return localPath;
  }
  
  public final Path f(JSONArray paramJSONArray)
  {
    Path localPath = new Path();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return localPath;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.optJSONObject(i);
      if (localObject2 != null)
      {
        Object localObject1 = ((JSONObject)localObject2).optString("method");
        localObject2 = ((JSONObject)localObject2).optJSONArray("data");
        localObject1 = (a)this.fMD.get(localObject1);
        if (localObject1 != null) {
          ((a)localObject1).a(localPath, (JSONArray)localObject2);
        }
      }
      i += 1;
    }
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.e
 * JD-Core Version:    0.7.0.1
 */