package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class d$4
  extends z
{
  d$4(d paramd, String paramString, m paramm, int paramInt) {}
  
  private void BK(String paramString)
  {
    AppMethodBeat.i(91014);
    this.mResult = paramString;
    this.hwL.h(this.bAX, paramString);
    AppMethodBeat.o(91014);
  }
  
  private String aBu()
  {
    AppMethodBeat.i(91013);
    for (;;)
    {
      try
      {
        Object localObject = d.BJ(this.hwP);
        if (localObject == null)
        {
          localObject = this.gOQ.j("fail:invalid data", null);
          d locald = this.hwL;
          m localm = this.gOQ;
          String str2 = this.hwP;
          int i = this.bAX;
          if (locald.hwJ != null) {
            locald.hwJ.a(localm, str2, i, (String)localObject);
          }
          AppMethodBeat.o(91013);
          return localObject;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", "invokeImpl() parseDataStr oom, api[%s], data_length[%d]", new Object[] { this.gOQ.getName(), Integer.valueOf(bo.nullAsNil(this.hwP).length()) });
        AppMethodBeat.o(91013);
        throw localOutOfMemoryError;
      }
      String str1 = this.hwL.a(this.gOQ, localOutOfMemoryError, this.bAX);
    }
  }
  
  public final void BI(String paramString)
  {
    AppMethodBeat.i(91016);
    if (!TextUtils.isEmpty(this.mResult))
    {
      AppMethodBeat.o(91016);
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {
      BK(paramString);
    }
    AppMethodBeat.o(91016);
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(91015);
    if (!TextUtils.isEmpty(this.mResult))
    {
      AppMethodBeat.o(91015);
      return;
    }
    boolean bool = this.hwL.isRunning();
    if (!bool) {
      com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", "invoke handler.proceed() log[%s] api[%s], callbackId[%d], component not running", new Object[] { this.hwL.aug(), this.gOQ, Integer.valueOf(this.bAX) });
    }
    if (bool) {}
    for (String str = aBu();; str = this.gOQ.j("fail:interrupted", null))
    {
      if (!TextUtils.isEmpty(str)) {
        BK(str);
      }
      AppMethodBeat.o(91015);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.4
 * JD-Core Version:    0.7.0.1
 */