package com.tencent.mm.plugin.game.luggage.i;

import android.webkit.ValueCallback;
import com.tencent.luggage.d.o;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.j;
import com.tencent.mm.plugin.wepkg.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends o
{
  private static LinkedList<a> CDr;
  public f CDs;
  public com.tencent.luggage.d.f CDt;
  public a CDu;
  public MTimerHandler cts;
  
  static
  {
    AppMethodBeat.i(231588);
    CDr = new LinkedList();
    AppMethodBeat.o(231588);
  }
  
  private a()
  {
    super(MMApplicationContext.getContext(), e.class);
    AppMethodBeat.i(231561);
    this.CDu = a.CDB;
    this.CDt = ((com.tencent.luggage.d.f)NS());
    this.CDs = new f(this.CDt);
    this.CDt.a(b.ewB(), this);
    com.tencent.mm.plugin.wepkg.b.a(new b.a()
    {
      public final void aqk(String paramAnonymousString)
      {
        AppMethodBeat.i(230929);
        com.tencent.mm.plugin.wepkg.b.destroy();
        String str = paramAnonymousString;
        if (Util.isNullOrNil(paramAnonymousString)) {
          str = com.tencent.mm.plugin.appbrand.ac.d.anc("gamecenter_jscore.js");
        }
        a.b(a.this).evaluateJavascript(str, new ValueCallback() {});
        AppMethodBeat.o(230929);
      }
    });
    aJD("initing");
    Log.i("MicroMsg.GameJsCore", "JS CORE CREATE");
    AppMethodBeat.o(231561);
  }
  
  private void aJD(String paramString)
  {
    AppMethodBeat.i(231564);
    Iterator localIterator = j.gUQ().iterator();
    while (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      locals.crX.a(new com.tencent.luggage.d.d()
      {
        public final JSONObject NU()
        {
          return null;
        }
        
        public final String name()
        {
          return "onJsCoreReady";
        }
      });
      locals.crX.dt(String.format("window.__jscore_state__='%s';", new Object[] { paramString }));
    }
    AppMethodBeat.o(231564);
  }
  
  /* Error */
  public static void create()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 175
    //   5: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 52	com/tencent/mm/plugin/game/luggage/i/a:CDr	Ljava/util/LinkedList;
    //   11: invokevirtual 178	java/util/LinkedList:peek	()Ljava/lang/Object;
    //   14: checkcast 2	com/tencent/mm/plugin/game/luggage/i/a
    //   17: astore_0
    //   18: aload_0
    //   19: ifnull +13 -> 32
    //   22: aload_0
    //   23: getfield 73	com/tencent/mm/plugin/game/luggage/i/a:CDu	Lcom/tencent/mm/plugin/game/luggage/i/a$a;
    //   26: getstatic 181	com/tencent/mm/plugin/game/luggage/i/a$a:CDG	Lcom/tencent/mm/plugin/game/luggage/i/a$a;
    //   29: if_acmpne +32 -> 61
    //   32: ldc 113
    //   34: ldc 183
    //   36: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 52	com/tencent/mm/plugin/game/luggage/i/a:CDr	Ljava/util/LinkedList;
    //   42: new 2	com/tencent/mm/plugin/game/luggage/i/a
    //   45: dup
    //   46: invokespecial 184	com/tencent/mm/plugin/game/luggage/i/a:<init>	()V
    //   49: invokevirtual 188	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   52: ldc 175
    //   54: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: ldc 2
    //   59: monitorexit
    //   60: return
    //   61: aload_0
    //   62: getfield 73	com/tencent/mm/plugin/game/luggage/i/a:CDu	Lcom/tencent/mm/plugin/game/luggage/i/a$a;
    //   65: getstatic 191	com/tencent/mm/plugin/game/luggage/i/a$a:CDF	Lcom/tencent/mm/plugin/game/luggage/i/a$a;
    //   68: if_acmpne +16 -> 84
    //   71: aload_0
    //   72: getstatic 194	com/tencent/mm/plugin/game/luggage/i/a$a:CDD	Lcom/tencent/mm/plugin/game/luggage/i/a$a;
    //   75: putfield 73	com/tencent/mm/plugin/game/luggage/i/a:CDu	Lcom/tencent/mm/plugin/game/luggage/i/a$a;
    //   78: aload_0
    //   79: ldc 196
    //   81: invokevirtual 199	com/tencent/mm/plugin/game/luggage/i/a:aJE	(Ljava/lang/String;)V
    //   84: ldc 175
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
  
  public static a exd()
  {
    AppMethodBeat.i(231556);
    a locala = (a)CDr.peek();
    AppMethodBeat.o(231556);
    return locala;
  }
  
  public final void aJE(final String paramString)
  {
    AppMethodBeat.i(231572);
    this.CDs.b(new com.tencent.luggage.d.d()
    {
      public final JSONObject NU()
      {
        AppMethodBeat.i(231857);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("state", paramString);
          label24:
          AppMethodBeat.o(231857);
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
    AppMethodBeat.o(231572);
  }
  
  public final void al(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(231574);
    Log.i("MicroMsg.GameJsCore", "onPageLifeChanged, state:[%s], pageId:[%s], url:[%s]", new Object[] { paramString1, paramString2, paramString3 });
    this.CDs.b(new com.tencent.luggage.d.d()
    {
      public final JSONObject NU()
      {
        AppMethodBeat.i(231224);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("state", paramString1);
          if (paramString3 != null) {
            localJSONObject.put("url", paramString3);
          }
          localJSONObject.put("pageId", paramString2);
          AppMethodBeat.o(231224);
          return localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          AppMethodBeat.o(231224);
        }
        return null;
      }
      
      public final String name()
      {
        return "onPageLifeChange";
      }
    });
    AppMethodBeat.o(231574);
  }
  
  /* Error */
  public final void exe()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 240
    //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 113
    //   9: ldc 242
    //   11: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 73	com/tencent/mm/plugin/game/luggage/i/a:CDu	Lcom/tencent/mm/plugin/game/luggage/i/a$a;
    //   18: getstatic 181	com/tencent/mm/plugin/game/luggage/i/a$a:CDG	Lcom/tencent/mm/plugin/game/luggage/i/a$a;
    //   21: if_acmpeq +11 -> 32
    //   24: ldc 240
    //   26: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 213	com/tencent/mm/plugin/game/luggage/i/a:cts	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: getfield 213	com/tencent/mm/plugin/game/luggage/i/a:cts	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   43: invokevirtual 245	com/tencent/mm/sdk/platformtools/MTimerHandler:stopped	()Z
    //   46: ifne +10 -> 56
    //   49: aload_0
    //   50: getfield 213	com/tencent/mm/plugin/game/luggage/i/a:cts	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   53: invokevirtual 248	com/tencent/mm/sdk/platformtools/MTimerHandler:stopTimer	()V
    //   56: aload_0
    //   57: getfield 88	com/tencent/mm/plugin/game/luggage/i/a:CDs	Lcom/tencent/mm/plugin/game/luggage/i/f;
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_1
    //   63: putfield 252	com/tencent/mm/plugin/game/luggage/i/f:CDM	Z
    //   66: aload_1
    //   67: getfield 255	com/tencent/mm/plugin/game/luggage/i/f:CDN	Ljava/util/LinkedList;
    //   70: invokevirtual 258	java/util/LinkedList:clear	()V
    //   73: aload_1
    //   74: getfield 261	com/tencent/mm/plugin/game/luggage/i/f:CDO	Ljava/util/LinkedList;
    //   77: invokevirtual 258	java/util/LinkedList:clear	()V
    //   80: aload_0
    //   81: getfield 81	com/tencent/mm/plugin/game/luggage/i/a:CDt	Lcom/tencent/luggage/d/f;
    //   84: invokevirtual 263	com/tencent/luggage/d/f:destroy	()V
    //   87: getstatic 52	com/tencent/mm/plugin/game/luggage/i/a:CDr	Ljava/util/LinkedList;
    //   90: aload_0
    //   91: invokevirtual 267	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: ldc 240
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
    this.CDu = a.CDC;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(231174);
      CDB = new a("none", 0);
      CDC = new a("initing", 1);
      CDD = new a("inited", 2);
      CDE = new a("failed", 3);
      CDF = new a("stopped", 4);
      CDG = new a("destroyed", 5);
      CDH = new a[] { CDB, CDC, CDD, CDE, CDF, CDG };
      AppMethodBeat.o(231174);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i.a
 * JD-Core Version:    0.7.0.1
 */