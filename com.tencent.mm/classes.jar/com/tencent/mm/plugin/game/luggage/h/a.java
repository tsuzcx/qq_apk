package com.tencent.mm.plugin.game.luggage.h;

import android.webkit.ValueCallback;
import com.tencent.luggage.d.o;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.webview.luggage.j;
import com.tencent.mm.plugin.wepkg.b.1;
import com.tencent.mm.plugin.wepkg.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends o
{
  private static LinkedList<a> tVT;
  public av cjg;
  public f tVU;
  public com.tencent.luggage.d.f tVV;
  public a tVW;
  
  static
  {
    AppMethodBeat.i(211709);
    tVT = new LinkedList();
    AppMethodBeat.o(211709);
  }
  
  private a()
  {
    super(aj.getContext(), e.class);
    AppMethodBeat.i(211702);
    this.tVW = a.tWc;
    this.tVV = ((com.tencent.luggage.d.f)this.chL);
    this.tVU = new f(this.tVV);
    this.tVV.a(b.ccP(), this);
    b.a local1 = new b.a()
    {
      public final void alE(String paramAnonymousString)
      {
        AppMethodBeat.i(211690);
        String str = paramAnonymousString;
        if (bt.isNullOrNil(paramAnonymousString)) {
          str = com.tencent.mm.plugin.appbrand.z.d.UT("jscore.js");
        }
        a.b(a.this).evaluateJavascript(str, new ValueCallback() {});
        AppMethodBeat.o(211690);
      }
    };
    if (!AppBrandMainProcessService.bhH()) {
      com.tencent.mm.plugin.wepkg.utils.d.b("", new b.1(local1));
    }
    for (;;)
    {
      alC("initing");
      ad.i("MicroMsg.GameJsCore", "JS CORE CREATE");
      AppMethodBeat.o(211702);
      return;
      com.tencent.mm.plugin.wepkg.b.a(local1);
    }
  }
  
  private void alC(String paramString)
  {
    AppMethodBeat.i(211703);
    Iterator localIterator = j.ePw().iterator();
    while (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      locals.chX.a(new com.tencent.luggage.d.d()
      {
        public final JSONObject BO()
        {
          return null;
        }
        
        public final String name()
        {
          return "onJsCoreReady";
        }
      });
      locals.chX.cB(String.format("window.__jscore_state__='%s';", new Object[] { paramString }));
    }
    AppMethodBeat.o(211703);
  }
  
  public static a cXE()
  {
    AppMethodBeat.i(211700);
    a locala = (a)tVT.peek();
    AppMethodBeat.o(211700);
    return locala;
  }
  
  /* Error */
  public static void create()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 197
    //   5: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 52	com/tencent/mm/plugin/game/luggage/h/a:tVT	Ljava/util/LinkedList;
    //   11: invokevirtual 195	java/util/LinkedList:peek	()Ljava/lang/Object;
    //   14: checkcast 2	com/tencent/mm/plugin/game/luggage/h/a
    //   17: astore_0
    //   18: aload_0
    //   19: ifnull +13 -> 32
    //   22: aload_0
    //   23: getfield 73	com/tencent/mm/plugin/game/luggage/h/a:tVW	Lcom/tencent/mm/plugin/game/luggage/h/a$a;
    //   26: getstatic 200	com/tencent/mm/plugin/game/luggage/h/a$a:tWh	Lcom/tencent/mm/plugin/game/luggage/h/a$a;
    //   29: if_acmpne +32 -> 61
    //   32: ldc 127
    //   34: ldc 202
    //   36: invokestatic 134	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 52	com/tencent/mm/plugin/game/luggage/h/a:tVT	Ljava/util/LinkedList;
    //   42: new 2	com/tencent/mm/plugin/game/luggage/h/a
    //   45: dup
    //   46: invokespecial 203	com/tencent/mm/plugin/game/luggage/h/a:<init>	()V
    //   49: invokevirtual 207	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   52: ldc 197
    //   54: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: ldc 2
    //   59: monitorexit
    //   60: return
    //   61: aload_0
    //   62: getfield 73	com/tencent/mm/plugin/game/luggage/h/a:tVW	Lcom/tencent/mm/plugin/game/luggage/h/a$a;
    //   65: getstatic 210	com/tencent/mm/plugin/game/luggage/h/a$a:tWg	Lcom/tencent/mm/plugin/game/luggage/h/a$a;
    //   68: if_acmpne +16 -> 84
    //   71: aload_0
    //   72: getstatic 213	com/tencent/mm/plugin/game/luggage/h/a$a:tWe	Lcom/tencent/mm/plugin/game/luggage/h/a$a;
    //   75: putfield 73	com/tencent/mm/plugin/game/luggage/h/a:tVW	Lcom/tencent/mm/plugin/game/luggage/h/a$a;
    //   78: aload_0
    //   79: ldc 215
    //   81: invokevirtual 218	com/tencent/mm/plugin/game/luggage/h/a:alD	(Ljava/lang/String;)V
    //   84: ldc 197
    //   86: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: goto -32 -> 57
    //   92: astore_0
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	62	0	locala	a
    //   92	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	18	92	finally
    //   22	32	92	finally
    //   32	57	92	finally
    //   61	84	92	finally
    //   84	89	92	finally
  }
  
  public final void ai(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(211706);
    this.tVU.b(new com.tencent.luggage.d.d()
    {
      public final JSONObject BO()
      {
        AppMethodBeat.i(211694);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("state", paramString1);
          if (paramString3 != null) {
            localJSONObject.put("url", paramString3);
          }
          localJSONObject.put("pageId", paramString2);
          AppMethodBeat.o(211694);
          return localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          AppMethodBeat.o(211694);
        }
        return null;
      }
      
      public final String name()
      {
        return "onPageLifeChange";
      }
    });
    AppMethodBeat.o(211706);
  }
  
  public final void alD(final String paramString)
  {
    AppMethodBeat.i(211705);
    this.tVU.b(new com.tencent.luggage.d.d()
    {
      public final JSONObject BO()
      {
        AppMethodBeat.i(211693);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("state", paramString);
          label24:
          AppMethodBeat.o(211693);
          return localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          break label24;
        }
      }
      
      public final String name()
      {
        return "onJsCoreLifeChange";
      }
    });
    AppMethodBeat.o(211705);
  }
  
  /* Error */
  public final void cXF()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 251
    //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 127
    //   9: ldc 253
    //   11: invokestatic 134	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 73	com/tencent/mm/plugin/game/luggage/h/a:tVW	Lcom/tencent/mm/plugin/game/luggage/h/a$a;
    //   18: getstatic 200	com/tencent/mm/plugin/game/luggage/h/a$a:tWh	Lcom/tencent/mm/plugin/game/luggage/h/a$a;
    //   21: if_acmpeq +11 -> 32
    //   24: ldc 251
    //   26: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 232	com/tencent/mm/plugin/game/luggage/h/a:cjg	Lcom/tencent/mm/sdk/platformtools/av;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: getfield 232	com/tencent/mm/plugin/game/luggage/h/a:cjg	Lcom/tencent/mm/sdk/platformtools/av;
    //   43: invokevirtual 256	com/tencent/mm/sdk/platformtools/av:fkZ	()Z
    //   46: ifne +10 -> 56
    //   49: aload_0
    //   50: getfield 232	com/tencent/mm/plugin/game/luggage/h/a:cjg	Lcom/tencent/mm/sdk/platformtools/av;
    //   53: invokevirtual 259	com/tencent/mm/sdk/platformtools/av:stopTimer	()V
    //   56: aload_0
    //   57: getfield 88	com/tencent/mm/plugin/game/luggage/h/a:tVU	Lcom/tencent/mm/plugin/game/luggage/h/f;
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_1
    //   63: putfield 263	com/tencent/mm/plugin/game/luggage/h/f:tWp	Z
    //   66: aload_1
    //   67: getfield 266	com/tencent/mm/plugin/game/luggage/h/f:tWq	Ljava/util/LinkedList;
    //   70: invokevirtual 269	java/util/LinkedList:clear	()V
    //   73: aload_1
    //   74: getfield 272	com/tencent/mm/plugin/game/luggage/h/f:tWr	Ljava/util/LinkedList;
    //   77: invokevirtual 269	java/util/LinkedList:clear	()V
    //   80: aload_0
    //   81: getfield 81	com/tencent/mm/plugin/game/luggage/h/a:tVV	Lcom/tencent/luggage/d/f;
    //   84: invokevirtual 274	com/tencent/luggage/d/f:destroy	()V
    //   87: getstatic 52	com/tencent/mm/plugin/game/luggage/h/a:tVT	Ljava/util/LinkedList;
    //   90: aload_0
    //   91: invokevirtual 278	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: ldc 251
    //   97: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: goto -71 -> 29
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	a
    //   60	14	1	localf	f
    //   103	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	103	finally
    //   32	56	103	finally
    //   56	100	103	finally
  }
  
  public final void init()
  {
    this.tVW = a.tWd;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(211699);
      tWc = new a("none", 0);
      tWd = new a("initing", 1);
      tWe = new a("inited", 2);
      tWf = new a("failed", 3);
      tWg = new a("stopped", 4);
      tWh = new a("destroyed", 5);
      tWi = new a[] { tWc, tWd, tWe, tWf, tWg, tWh };
      AppMethodBeat.o(211699);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.a
 * JD-Core Version:    0.7.0.1
 */