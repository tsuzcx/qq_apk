package com.tencent.mm.plugin.appbrand.page.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/navigation/NavigateBackInterceptionInfo;", "", "dialogContent", "", "sceneInfo", "", "Lcom/tencent/mm/plugin/appbrand/page/navigation/SceneInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getDialogContent", "()Ljava/lang/String;", "getSceneInfo", "()Ljava/util/List;", "isEnable", "", "scene", "luggage-wxa-app_release"})
public final class g
{
  final String nvR;
  private final List<h> nvS;
  
  public g()
  {
    this(null, null, 3);
  }
  
  public g(String paramString, List<h> paramList)
  {
    AppMethodBeat.i(219744);
    this.nvR = paramString;
    this.nvS = paramList;
    AppMethodBeat.o(219744);
  }
  
  public final boolean adY(String paramString)
  {
    AppMethodBeat.i(219743);
    p.h(paramString, "scene");
    Iterator localIterator = this.nvS.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if ((TextUtils.equals((CharSequence)localh.nvT, (CharSequence)paramString)) && (localh.enable))
      {
        AppMethodBeat.o(219743);
        return true;
      }
    }
    AppMethodBeat.o(219743);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.g
 * JD-Core Version:    0.7.0.1
 */