package com.tencent.mm.model.newabtest;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/plugin/IPin;", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_NAME", "", "PROVIDER", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "getPROVIDER", "()Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "PROVIDER$delegate", "Lkotlin/Lazy;", "TAG", "mmAbTestStorageChangeListener", "com/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1;", "getAbTestItem", "Lcom/tencent/mm/storage/ABTestItem;", "id", "getLayerKey", "onAccountInitialized", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "resetAllExp", "storage", "Lcom/tencent/mm/storage/ABTestStorage;", "marshallFrom", "mmkv", "toUinString", "", "unmarshallTo", "ClientProvider", "MMProvider", "Provider", "plugin-abtest_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  public static final c ooH;
  private static final e ooI;
  private static final j ooJ;
  
  static
  {
    AppMethodBeat.i(153176);
    ooH = new c();
    ooI = new e();
    ooJ = k.cm((a)c.c.ooM);
    AppMethodBeat.o(153176);
  }
  
  public static com.tencent.mm.storage.c KB(String paramString)
  {
    AppMethodBeat.i(153182);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(153182);
      return null;
    }
    localObject = new com.tencent.mm.storage.c();
    ((com.tencent.mm.storage.c)localObject).field_layerId = paramString;
    paramString = aBP();
    s.s(paramString, "MMKV");
    String str = s.X("layer_", ((com.tencent.mm.storage.c)localObject).field_layerId);
    ((com.tencent.mm.storage.c)localObject).field_rawXML = paramString.getString(s.X(str, "_rawXML"), "");
    ((com.tencent.mm.storage.c)localObject).field_startTime = paramString.getLong(s.X(str, "_startTime"), Util.nowSecond());
    ((com.tencent.mm.storage.c)localObject).field_endTime = paramString.getLong(s.X(str, "_endTime"), Util.nowSecond());
    AppMethodBeat.o(153182);
    return localObject;
  }
  
  public static void a(com.tencent.mm.storage.d paramd)
  {
    AppMethodBeat.i(153179);
    s.u(paramd, "storage");
    Object localObject1 = aBP();
    ((MultiProcessMMKV)localObject1).clear();
    paramd = paramd.getAll();
    if (paramd != null) {
      paramd = (Closeable)paramd;
    }
    for (;;)
    {
      try
      {
        Cursor localCursor = (Cursor)paramd;
        boolean bool = localCursor.moveToFirst();
        if (!bool)
        {
          kotlin.f.b.a(paramd, null);
          AppMethodBeat.o(153179);
          return;
        }
        com.tencent.mm.storage.c localc = new com.tencent.mm.storage.c();
        localc.convertFrom(localCursor);
        Object localObject3 = (CharSequence)localc.field_layerId;
        if (localObject3 == null) {
          break label239;
        }
        if (((CharSequence)localObject3).length() == 0)
        {
          break label239;
          if (i == 0)
          {
            s.s(localObject1, "mmkv");
            localObject3 = s.X("layer_", localc.field_layerId);
            ((MultiProcessMMKV)localObject1).putString(s.X((String)localObject3, "_rawXML"), localc.field_rawXML);
            ((MultiProcessMMKV)localObject1).putLong(s.X((String)localObject3, "_startTime"), localc.field_startTime);
            ((MultiProcessMMKV)localObject1).putLong(s.X((String)localObject3, "_endTime"), localc.field_endTime);
          }
          if (localCursor.moveToNext()) {
            continue;
          }
          localObject1 = ah.aiuX;
          kotlin.f.b.a(paramd, null);
          AppMethodBeat.o(153179);
          return;
        }
        i = 0;
        continue;
        AppMethodBeat.o(153179);
      }
      finally
      {
        try
        {
          AppMethodBeat.o(153179);
          throw localThrowable;
        }
        finally
        {
          kotlin.f.b.a(paramd, localThrowable);
          AppMethodBeat.o(153179);
        }
      }
      return;
      label239:
      int i = 1;
    }
  }
  
  private static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(153181);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(s.X(vG(bEq().bEr()), "_PluginABTest_NewABTestMMKV"));
    AppMethodBeat.o(153181);
    return localMultiProcessMMKV;
  }
  
  private static c.d bEq()
  {
    AppMethodBeat.i(153180);
    c.d locald = (c.d)ooJ.getValue();
    AppMethodBeat.o(153180);
    return locald;
  }
  
  private static String vG(int paramInt)
  {
    AppMethodBeat.i(153183);
    String str = new p(paramInt).toString();
    s.s(str, "UIN(this).toString()");
    AppMethodBeat.o(153183);
    return str;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(153177);
    paramc = new StringBuilder("onAccountInitialized uin[");
    h.baC();
    Log.i("MicroMsg.PluginABTest.NewABTestMMKV", vG(com.tencent.mm.kernel.b.getUin()) + ']');
    d.bEt().add("MicroMsg.PluginABTest.NewABTestMMKV", (MStorage.IOnStorageChange)ooI);
    paramc = d.bEt();
    s.s(paramc, "getABTestStorage()");
    a(paramc);
    AppMethodBeat.o(153177);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(153178);
    d.bEt().remove((MStorage.IOnStorageChange)ooI);
    AppMethodBeat.o(153178);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onNotifyChange", "", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "plugin-abtest_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MStorage.IOnStorageChange
  {
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(153175);
      if (s.p("event_updated", paramString))
      {
        paramString = c.ooH;
        paramString = d.bEt();
        s.s(paramString, "getABTestStorage()");
        c.a(paramString);
      }
      AppMethodBeat.o(153175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.newabtest.c
 * JD-Core Version:    0.7.0.1
 */