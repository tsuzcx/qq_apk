package com.tencent.mm.cl;

import android.content.res.Resources;
import com.tencent.mm.svg.a.e;
import java.util.Map;
import org.xwalk.core.WebViewExtensionListener;

final class a$3
  extends WebViewExtensionListener
{
  public final Object onMiscCallBack(String paramString, Object... paramVarArgs)
  {
    if ("AddFilterResources".equals(paramString)) {
      e.a((Resources)paramVarArgs[0], (Map)paramVarArgs[1]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cl.a.3
 * JD-Core Version:    0.7.0.1
 */