package com.tencent.mm.plugin.appbrand.page.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/navigation/NavigateBackInterceptionInfo;", "", "dialogContent", "", "sceneInfo", "", "Lcom/tencent/mm/plugin/appbrand/page/navigation/SceneInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getDialogContent", "()Ljava/lang/String;", "getSceneInfo", "()Ljava/util/List;", "isEnable", "", "scene", "luggage-wxa-app_release"})
public final class g
{
  final String qxT;
  private final List<h> qxU;
  
  public g()
  {
    this(null, null, 3);
  }
  
  public g(String paramString, List<h> paramList)
  {
    AppMethodBeat.i(246321);
    this.qxT = paramString;
    this.qxU = paramList;
    AppMethodBeat.o(246321);
  }
  
  public final boolean alT(String paramString)
  {
    AppMethodBeat.i(246319);
    p.k(paramString, "scene");
    Iterator localIterator = this.qxU.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if ((TextUtils.equals((CharSequence)localh.qxV, (CharSequence)paramString)) && (localh.enable))
      {
        AppMethodBeat.o(246319);
        return true;
      }
    }
    AppMethodBeat.o(246319);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.g
 * JD-Core Version:    0.7.0.1
 */