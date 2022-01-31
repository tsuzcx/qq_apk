package com.tencent.mm.cn;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.svg.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.WebViewExtensionListener;

final class b$3
  extends WebViewExtensionListener
{
  public final int getHostByName(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(80380);
    if (!b.PK().lX("com.tencent.mm"))
    {
      AppMethodBeat.o(80380);
      return 0;
    }
    paramString = (Bundle)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), b.a.class);
    if ((paramList != null) && (paramString != null))
    {
      paramList.clear();
      ArrayList localArrayList = paramString.getStringArrayList("ipList");
      int i = paramString.getInt("result");
      paramList.addAll(localArrayList);
      AppMethodBeat.o(80380);
      return i;
    }
    AppMethodBeat.o(80380);
    return 0;
  }
  
  public final Object onMiscCallBack(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(80379);
    if ("AddFilterResources".equals(paramString)) {
      e.a((Resources)paramVarArgs[0], (Map)paramVarArgs[1]);
    }
    AppMethodBeat.o(80379);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cn.b.3
 * JD-Core Version:    0.7.0.1
 */