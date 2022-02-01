package com.tencent.mm.plugin.appbrand.page.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/NavigateBackInterceptionInfo;", "", "dialogContent", "", "sceneInfo", "", "Lcom/tencent/mm/plugin/appbrand/page/navigation/SceneInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getDialogContent", "()Ljava/lang/String;", "getSceneInfo", "()Ljava/util/List;", "isEnable", "", "scene", "luggage-wxa-app_release"})
public final class f
{
  final String mgu;
  private final List<g> mgv;
  
  public f()
  {
    this(null, null, 3);
  }
  
  public f(String paramString, List<g> paramList)
  {
    AppMethodBeat.i(197519);
    this.mgu = paramString;
    this.mgv = paramList;
    AppMethodBeat.o(197519);
  }
  
  public final boolean TB(String paramString)
  {
    AppMethodBeat.i(197518);
    p.h(paramString, "scene");
    Iterator localIterator = this.mgv.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if ((TextUtils.equals((CharSequence)localg.mgw, (CharSequence)paramString)) && (localg.enable))
      {
        AppMethodBeat.o(197518);
        return true;
      }
    }
    AppMethodBeat.o(197518);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.f
 * JD-Core Version:    0.7.0.1
 */