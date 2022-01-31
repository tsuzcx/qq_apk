package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public Map<String, a> hfN;
  
  public e()
  {
    AppMethodBeat.i(103677);
    this.hfN = new HashMap();
    a(new h());
    a(new f());
    a(new g());
    a(new i());
    a(new d());
    a(new b());
    a(new c());
    a(new j());
    AppMethodBeat.o(103677);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(103682);
    this.hfN.put(parama.getMethod(), parama);
    AppMethodBeat.o(103682);
  }
  
  private boolean a(Path paramPath, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103681);
    Object localObject = paramJSONObject.optString("method");
    paramJSONObject = paramJSONObject.optJSONArray("data");
    localObject = (a)this.hfN.get(localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(103681);
      return false;
    }
    boolean bool = ((a)localObject).a(paramPath, paramJSONObject);
    AppMethodBeat.o(103681);
    return bool;
  }
  
  private boolean b(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(103679);
    Object localObject = paramBasePathActionArg.method;
    localObject = (a)this.hfN.get(localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(103679);
      return false;
    }
    boolean bool = ((a)localObject).a(paramPath, paramBasePathActionArg);
    AppMethodBeat.o(103679);
    return bool;
  }
  
  public final Path a(PathActionArgWrapper paramPathActionArgWrapper)
  {
    AppMethodBeat.i(103678);
    Path localPath = new Path();
    paramPathActionArgWrapper = paramPathActionArgWrapper.hfq;
    if ((paramPathActionArgWrapper == null) || (paramPathActionArgWrapper.size() == 0))
    {
      AppMethodBeat.o(103678);
      return localPath;
    }
    paramPathActionArgWrapper = paramPathActionArgWrapper.iterator();
    while (paramPathActionArgWrapper.hasNext())
    {
      BasePathActionArg localBasePathActionArg = (BasePathActionArg)paramPathActionArgWrapper.next();
      if (localBasePathActionArg != null) {
        b(localPath, localBasePathActionArg);
      }
    }
    AppMethodBeat.o(103678);
    return localPath;
  }
  
  public final Path g(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103680);
    Path localPath = new Path();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(103680);
      return localPath;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject != null) {
        a(localPath, localJSONObject);
      }
      i += 1;
    }
    AppMethodBeat.o(103680);
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.e
 * JD-Core Version:    0.7.0.1
 */