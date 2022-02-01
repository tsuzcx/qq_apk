package com.tencent.mm.plugin.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.ab.a.a.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.e.3;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storagebase.h.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.b.c
{
  private static volatile a GGE;
  private static HashMap<Integer, h.b> baseDBFactories;
  private d GGF;
  private com.tencent.mm.pluginsdk.model.app.f GGG;
  private com.tencent.mm.pluginsdk.model.app.i GGH;
  private j GGI;
  private l GGJ;
  private n GGK;
  private com.tencent.mm.pluginsdk.model.app.e GGL;
  private IListener GGM;
  
  static
  {
    AppMethodBeat.i(151530);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new a.3());
    AppMethodBeat.o(151530);
  }
  
  private a()
  {
    AppMethodBeat.i(151516);
    this.GGM = new a.4(this);
    a.a.a(new a.1(this));
    AppMethodBeat.o(151516);
  }
  
  public static d ctZ()
  {
    AppMethodBeat.i(151520);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fmr().GGF == null) {
      fmr().GGF = new d(com.tencent.mm.kernel.h.aHG().kcF);
    }
    d locald = fmr().GGF;
    AppMethodBeat.o(151520);
    return locald;
  }
  
  public static l fmA()
  {
    AppMethodBeat.i(151524);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fmr().GGJ == null) {
      fmr().GGJ = new l(com.tencent.mm.kernel.h.aHG().kcF);
    }
    l locall = fmr().GGJ;
    AppMethodBeat.o(151524);
    return locall;
  }
  
  public static n fmB()
  {
    AppMethodBeat.i(151525);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fmr().GGK == null) {
      fmr().GGK = new n();
    }
    n localn = fmr().GGK;
    AppMethodBeat.o(151525);
    return localn;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.e fmC()
  {
    AppMethodBeat.i(151526);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fmr().GGL == null) {
      fmr().GGL = new com.tencent.mm.pluginsdk.model.app.e();
    }
    com.tencent.mm.pluginsdk.model.app.e locale = fmr().GGL;
    AppMethodBeat.o(151526);
    return locale;
  }
  
  public static a fmr()
  {
    AppMethodBeat.i(151517);
    if (GGE == null) {}
    try
    {
      if (GGE == null) {
        GGE = new a();
      }
      a locala = GGE;
      AppMethodBeat.o(151517);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(151517);
    }
  }
  
  public static String fms()
  {
    AppMethodBeat.i(151519);
    String str = com.tencent.mm.kernel.h.aHG().kcB + "openapi/";
    AppMethodBeat.o(151519);
    return str;
  }
  
  public static void fmt()
  {
    AppMethodBeat.i(243865);
    if ((!com.tencent.mm.vfs.u.agG(fms())) && (!com.tencent.mm.vfs.u.bBD(fms()))) {
      Log.e("XPinOpenApi", "alvinluo checkAccOpenApiPath mkdirs failed");
    }
    AppMethodBeat.o(243865);
  }
  
  public static String fmu()
  {
    AppMethodBeat.i(243867);
    String str = fms() + "thumb/";
    AppMethodBeat.o(243867);
    return str;
  }
  
  public static String fmv()
  {
    AppMethodBeat.i(243869);
    String str = com.tencent.mm.kernel.h.aHG().kcB + "share_img_tmp/";
    AppMethodBeat.o(243869);
    return str;
  }
  
  public static String fmw()
  {
    AppMethodBeat.i(243871);
    String str = com.tencent.mm.kernel.h.aHG().kcB + "openapi_cache/";
    AppMethodBeat.o(243871);
    return str;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.f fmx()
  {
    AppMethodBeat.i(151521);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fmr().GGG == null) {
      fmr().GGG = new com.tencent.mm.pluginsdk.model.app.f();
    }
    com.tencent.mm.pluginsdk.model.app.f localf = fmr().GGG;
    AppMethodBeat.o(151521);
    return localf;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.i fmy()
  {
    AppMethodBeat.i(151522);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fmr().GGH == null) {
      fmr().GGH = new com.tencent.mm.pluginsdk.model.app.i();
    }
    com.tencent.mm.pluginsdk.model.app.i locali = fmr().GGH;
    AppMethodBeat.o(151522);
    return locali;
  }
  
  public static j fmz()
  {
    AppMethodBeat.i(151523);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fmr().GGI == null) {
      fmr().GGI = new j(com.tencent.mm.kernel.h.aHG().kcF);
    }
    j localj = fmr().GGI;
    AppMethodBeat.o(151523);
    return localj;
  }
  
  public final List<String> aHP()
  {
    AppMethodBeat.i(151518);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "openapi/", "openapi_cache/", "share_img_tmp/" });
    AppMethodBeat.o(151518);
    return localLinkedList;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(151527);
    com.tencent.mm.model.am.a.lto = fmy();
    EventCenter.instance.addListener(this.GGM);
    AppMethodBeat.o(151527);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151528);
    Object localObject = fmr().GGH;
    if (localObject != null) {
      fmC().b(7, (com.tencent.mm.pluginsdk.model.app.u)localObject);
    }
    localObject = fmr().GGG;
    if (localObject != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).QWa.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).jUI.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).QWb.clear();
    }
    localObject = fmr().GGK;
    if (localObject != null)
    {
      Log.d("MicroMsg.AppSettingService", "stop service");
      ((n)localObject).QWI.clear();
      fmC().b(1, (com.tencent.mm.pluginsdk.model.app.u)localObject);
    }
    if (this.GGL != null)
    {
      localObject = this.GGL;
      com.tencent.mm.kernel.h.aHF().kcd.b(452, (com.tencent.mm.an.i)localObject);
      MMHandlerThread.postToMainThread(new e.3((com.tencent.mm.pluginsdk.model.app.e)localObject));
    }
    if (fmr().GGI != null) {
      fmr().GGI.QWu.clear();
    }
    EventCenter.instance.removeListener(this.GGM);
    Log.i("XPinOpenApi", "onAccountRelease");
    AppMethodBeat.o(151528);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(151529);
    this.GGF = null;
    this.GGI = null;
    Log.i("XPinOpenApi", "onDataBaseClosed");
    AppMethodBeat.o(151529);
  }
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.a
 * JD-Core Version:    0.7.0.1
 */