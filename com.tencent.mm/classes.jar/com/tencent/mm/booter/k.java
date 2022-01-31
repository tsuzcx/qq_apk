package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.h.a.dq;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.protocal.c.apw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class k
{
  private static com.tencent.mm.modelgeo.c dhZ;
  private static float dia = -85.0F;
  private static float dib = -1000.0F;
  private static boolean dic = false;
  private static Map<String, apw> did = new ConcurrentHashMap();
  private static List<apw> die = new CopyOnWriteArrayList();
  private static Boolean dif = Boolean.valueOf(false);
  private static a.a dig = new k.1();
  private static am dih = new am(Looper.getMainLooper(), new k.2(), true);
  private static com.tencent.mm.sdk.b.c dii = new k.3();
  
  public static void run()
  {
    if ((!au.DK()) || (au.CW())) {}
    do
    {
      do
      {
        return;
        au.Hx();
        localObject = Boolean.valueOf(bk.a((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.urc, null), false));
        y.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is " + localObject);
      } while (!((Boolean)localObject).booleanValue());
      long l1 = bk.UX();
      au.Hx();
      long l2 = bk.a((Long)com.tencent.mm.model.c.Dz().get(ac.a.urd, null), 0L);
      au.Hx();
      if (l1 - l2 > bk.a((Long)com.tencent.mm.model.c.Dz().get(ac.a.uqX, null), 0L))
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.urc, Boolean.valueOf(false));
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.urb, "");
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.ura, "");
        au.Hx();
        com.tencent.mm.model.c.CY();
        return;
      }
      localObject = BluetoothAdapter.getDefaultAdapter();
      if ((Build.VERSION.SDK_INT < 18) || (localObject == null) || (((BluetoothAdapter)localObject).getState() != 12)) {
        break;
      }
      localObject = g.AB().Aq();
    } while (localObject == null);
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      y.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[] { str });
      dq localdq = new dq();
      localdq.bKd.bKf = str;
      localdq.bKd.bKc = true;
      a.udP.m(localdq);
    }
    dhZ = com.tencent.mm.modelgeo.c.Ob();
    if (dih.crl()) {
      dih.S(3000L, 3000L);
    }
    if ((!dic) && (dhZ != null)) {
      dhZ.b(dig);
    }
    a.udP.c(dii);
    return;
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.ura, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.k
 * JD-Core Version:    0.7.0.1
 */