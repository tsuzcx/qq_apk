package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.e;
import java.util.LinkedList;
import java.util.Map;
import org.apache.commons.b.g;

public class av<PAGE extends c>
  extends a<PAGE>
  implements e
{
  private boolean izp;
  private final ay.a izq;
  
  protected av(PAGE paramPAGE)
  {
    super(paramPAGE);
    AppMethodBeat.i(140898);
    this.izp = false;
    this.izq = new av.2(this);
    AppMethodBeat.o(140898);
  }
  
  private void Er(String paramString)
  {
    AppMethodBeat.i(140900);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140900);
      return;
    }
    aJN().evaluateJavascript("document.title=\"" + paramString + "\"", null);
    AppMethodBeat.o(140900);
  }
  
  public void Ed(String arg1)
  {
    AppMethodBeat.i(140909);
    super.Ed(???);
    ??? = bb.b(wj());
    Object localObject1 = aJN();
    int i;
    if ((localObject1 instanceof az))
    {
      localObject1 = (az)localObject1;
      if (((az)localObject1).izE.aKd()) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (localObject1 != null) {
          ???.izP.addLast(localObject1);
        }
        i = 1;
        if (i != 0) {
          this.izp = true;
        }
      }
      else
      {
        synchronized (this.bDO)
        {
          this.bDO.remove(com.tencent.luggage.sdk.b.a.b.a.a.class);
          AppMethodBeat.o(140909);
          return;
          ((az)localObject1).bBK = null;
          ((az)localObject1).izF = null;
          ((az)localObject1).izG.clear();
          ((az)localObject1).setOnTrimListener(null);
          i = 1;
          continue;
          i = 0;
        }
      }
    }
    AppMethodBeat.o(140909);
  }
  
  protected final ay aJN()
  {
    AppMethodBeat.i(140899);
    if (this.izp)
    {
      localObject = new UnsupportedOperationException("ViewEngine Stashed after PageNotFound");
      AppMethodBeat.o(140899);
      throw ((Throwable)localObject);
    }
    Object localObject = (ay)this.iuy;
    AppMethodBeat.o(140899);
    return localObject;
  }
  
  public final void aJO()
  {
    AppMethodBeat.i(140901);
    ((c)this.bDN).aBr();
    aJN().aJO();
    AppMethodBeat.o(140901);
  }
  
  public final boolean aJP()
  {
    AppMethodBeat.i(140902);
    boolean bool = aJN().aJP();
    AppMethodBeat.o(140902);
    return bool;
  }
  
  public final boolean aJw()
  {
    AppMethodBeat.i(140903);
    boolean bool = aJN().aJw();
    AppMethodBeat.o(140903);
    return bool;
  }
  
  public boolean bX(String paramString)
  {
    AppMethodBeat.i(140908);
    aJN().J(new av.1(this));
    boolean bool = super.bX(paramString);
    AppMethodBeat.o(140908);
    return bool;
  }
  
  protected aq cY(Context paramContext)
  {
    AppMethodBeat.i(140910);
    paramContext = new al(paramContext);
    AppMethodBeat.o(140910);
    return paramContext;
  }
  
  public void dispatchStart()
  {
    AppMethodBeat.i(140905);
    super.dispatchStart();
    aJN().aJZ();
    AppMethodBeat.o(140905);
  }
  
  public final void vD()
  {
    AppMethodBeat.i(140906);
    d.i("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", new Object[] { getAppId(), this.hzM });
    super.vD();
    Er(g.b(new String[] { getAppId(), this.hzM, "VISIBLE" }, ":"));
    AppMethodBeat.o(140906);
  }
  
  public final void vE()
  {
    AppMethodBeat.i(140907);
    super.vE();
    Er(g.b(new String[] { getAppId(), this.hzM, "INVISIBLE" }, ":"));
    AppMethodBeat.o(140907);
  }
  
  public void vG()
  {
    AppMethodBeat.i(140904);
    super.vG();
    this.iux.invalidate();
    AppMethodBeat.o(140904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av
 * JD-Core Version:    0.7.0.1
 */