package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@TargetApi(18)
public final class c
{
  public Context context;
  public Map<String, d> kEI;
  public h kEJ;
  public g kEK;
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static boolean g(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(175629);
    String str;
    Iterator localIterator;
    do
    {
      paramList1 = paramList1.iterator();
      while (!localIterator.hasNext())
      {
        if (!paramList1.hasNext()) {
          break;
        }
        str = (String)paramList1.next();
        localIterator = paramList2.iterator();
      }
    } while (!Objects.equals(str, (String)localIterator.next()));
    AppMethodBeat.o(175629);
    return true;
    AppMethodBeat.o(175629);
    return false;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> bjg()
  {
    AppMethodBeat.i(175628);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.kEI.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.kEN != null) {
        localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d(bt.nullAsNil(locald.kEN.getDevice().getName()), locald.cUi));
      }
    }
    AppMethodBeat.o(175628);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c
 * JD-Core Version:    0.7.0.1
 */