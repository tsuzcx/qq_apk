package com.tencent.mm.plugin.expt.edge.h.a;

import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Array;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.c.i;

public final class a
  implements b
{
  private V8 zAq;
  
  public a()
  {
    AppMethodBeat.i(299720);
    try
    {
      this.zAq = V8.createV8Runtime();
      com.tencent.mm.plugin.expt.edge.f.a.oG(true);
      AppMethodBeat.o(299720);
      return;
    }
    finally
    {
      com.tencent.mm.plugin.expt.edge.f.a.oG(false);
      Log.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] init V8 fail for : %s", new Object[] { localObject.getMessage() });
      AppMethodBeat.o(299720);
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.expt.edge.h.b.a parama)
  {
    AppMethodBeat.i(299728);
    if ((this.zAq == null) || (this.zAq.isReleased()) || (parama == null))
    {
      AppMethodBeat.o(299728);
      return false;
    }
    try
    {
      this.zAq.registerJavaMethod(parama, parama.dIx());
      AppMethodBeat.o(299728);
      return true;
    }
    finally
    {
      Log.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] registerJsApi fail, jsApi : %s, msg : %s", new Object[] { parama.dIx(), localObject.getMessage() });
      AppMethodBeat.o(299728);
    }
    return false;
  }
  
  public final List<String> ab(String paramString1, String paramString2, String paramString3)
  {
    i = 0;
    AppMethodBeat.i(299747);
    if ((i.hm(paramString1)) || (i.hm(paramString2)) || (this.zAq == null) || (this.zAq.isReleased()) || (i.hm(paramString3)))
    {
      AppMethodBeat.o(299747);
      return null;
    }
    try
    {
      localV8Array = new V8Array(this.zAq).push(paramString2).push(paramString3);
    }
    finally
    {
      label104:
      String str;
      label141:
      paramString3 = null;
      V8Array localV8Array = null;
      try
      {
        Log.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] executeArrayFunction funcName : %s, throw Throwable e : %s", new Object[] { paramString1, paramString2.getMessage() });
        return null;
      }
      finally
      {
        if ((localV8Array != null) && (!localV8Array.isReleased())) {
          localV8Array.release();
        }
        if ((paramString3 != null) && (!paramString3.isReleased())) {
          paramString3.release();
        }
        AppMethodBeat.o(299747);
      }
    }
    try
    {
      paramString3 = this.zAq.executeArrayFunction(paramString1, localV8Array);
    }
    finally
    {
      paramString3 = null;
    }
    try
    {
      paramString2 = new ArrayList();
      if ((paramString3 == null) || (paramString3.length() <= 0) || (i >= paramString3.length())) {
        break label141;
      }
    }
    finally
    {
      break label196;
      i += 1;
      break label104;
    }
    str = paramString3.getString(i);
    if (!i.hm(str))
    {
      paramString2.add(str);
      break label309;
      localV8Array.release();
      paramString3.release();
      if ((localV8Array != null) && (!localV8Array.isReleased())) {
        localV8Array.release();
      }
      if ((paramString3 != null) && (!paramString3.isReleased())) {
        paramString3.release();
      }
      AppMethodBeat.o(299747);
      return paramString2;
    }
  }
  
  public final boolean aqt(String paramString)
  {
    AppMethodBeat.i(299735);
    if ((i.hm(paramString)) || (this.zAq == null) || (this.zAq.isReleased()))
    {
      AppMethodBeat.o(299735);
      return false;
    }
    try
    {
      this.zAq.executeVoidScript(paramString);
      AppMethodBeat.o(299735);
      return true;
    }
    finally
    {
      Log.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] loadScript throw Throwable e : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(299735);
    }
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(299751);
    if ((this.zAq != null) && (!this.zAq.isReleased())) {}
    try
    {
      this.zAq.release(true);
      this.zAq = null;
      AppMethodBeat.o(299751);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] release throw Throwable : " + localObject.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.h.a.a
 * JD-Core Version:    0.7.0.1
 */