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
  public Map<String, a> jAl;
  
  public e()
  {
    AppMethodBeat.i(145360);
    this.jAl = new HashMap();
    a(new h());
    a(new f());
    a(new g());
    a(new i());
    a(new d());
    a(new b());
    a(new c());
    a(new j());
    AppMethodBeat.o(145360);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(145365);
    this.jAl.put(parama.getMethod(), parama);
    AppMethodBeat.o(145365);
  }
  
  private boolean a(Path paramPath, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145364);
    Object localObject = paramJSONObject.optString("method");
    paramJSONObject = paramJSONObject.optJSONArray("data");
    localObject = (a)this.jAl.get(localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(145364);
      return false;
    }
    boolean bool = ((a)localObject).a(paramPath, paramJSONObject);
    AppMethodBeat.o(145364);
    return bool;
  }
  
  private boolean b(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(145362);
    Object localObject = paramBasePathActionArg.method;
    localObject = (a)this.jAl.get(localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(145362);
      return false;
    }
    boolean bool = ((a)localObject).a(paramPath, paramBasePathActionArg);
    AppMethodBeat.o(145362);
    return bool;
  }
  
  public final Path a(PathActionArgWrapper paramPathActionArgWrapper)
  {
    AppMethodBeat.i(145361);
    Path localPath = new Path();
    paramPathActionArgWrapper = paramPathActionArgWrapper.jzO;
    if ((paramPathActionArgWrapper == null) || (paramPathActionArgWrapper.size() == 0))
    {
      AppMethodBeat.o(145361);
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
    AppMethodBeat.o(145361);
    return localPath;
  }
  
  public final Path g(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145363);
    Path localPath = new Path();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(145363);
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
    AppMethodBeat.o(145363);
    return localPath;
  }
  
  public static final class a
  {
    public static e jAm;
    
    static
    {
      AppMethodBeat.i(145359);
      jAm = new e();
      AppMethodBeat.o(145359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.e
 * JD-Core Version:    0.7.0.1
 */