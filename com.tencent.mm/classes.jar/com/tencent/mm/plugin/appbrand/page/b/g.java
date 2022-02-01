package com.tencent.mm.plugin.appbrand.page.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/navigation/NavigateBackInterceptionInfo;", "", "dialogContent", "", "sceneInfo", "", "Lcom/tencent/mm/plugin/appbrand/page/navigation/SceneInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getDialogContent", "()Ljava/lang/String;", "getSceneInfo", "()Ljava/util/List;", "isEnable", "", "scene", "luggage-wxa-app_release"})
public final class g
{
  final String mlt;
  private final List<h> mlu;
  
  public g()
  {
    this(null, null, 3);
  }
  
  public g(String paramString, List<h> paramList)
  {
    AppMethodBeat.i(208128);
    this.mlt = paramString;
    this.mlu = paramList;
    AppMethodBeat.o(208128);
  }
  
  public final boolean Uk(String paramString)
  {
    AppMethodBeat.i(208127);
    p.h(paramString, "scene");
    Iterator localIterator = this.mlu.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if ((TextUtils.equals((CharSequence)localh.mlv, (CharSequence)paramString)) && (localh.enable))
      {
        AppMethodBeat.o(208127);
        return true;
      }
    }
    AppMethodBeat.o(208127);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.g
 * JD-Core Version:    0.7.0.1
 */