package com.tencent.mm.plugin.appbrand.page.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/navigation/NavigateBackInterceptionInfo;", "", "dialogContent", "", "sceneInfo", "", "Lcom/tencent/mm/plugin/appbrand/page/navigation/SceneInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getDialogContent", "()Ljava/lang/String;", "getSceneInfo", "()Ljava/util/List;", "isEnable", "", "scene", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  final String tCT;
  private final List<h> tCU;
  
  public g()
  {
    this(null, null, 3);
  }
  
  public g(String paramString, List<h> paramList)
  {
    AppMethodBeat.i(325089);
    this.tCT = paramString;
    this.tCU = paramList;
    AppMethodBeat.o(325089);
  }
  
  public final boolean afc(String paramString)
  {
    AppMethodBeat.i(325110);
    s.u(paramString, "scene");
    Iterator localIterator = this.tCU.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if ((TextUtils.equals((CharSequence)localh.tCV, (CharSequence)paramString)) && (localh.enable))
      {
        AppMethodBeat.o(325110);
        return true;
      }
    }
    AppMethodBeat.o(325110);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.g
 * JD-Core Version:    0.7.0.1
 */