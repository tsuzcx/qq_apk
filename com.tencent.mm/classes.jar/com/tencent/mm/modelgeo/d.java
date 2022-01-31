package com.tencent.mm.modelgeo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  public static d fwu;
  List<WeakReference<b.a>> aTm;
  double bno;
  public boolean fBM;
  h fBN;
  long fBO;
  long fBP;
  boolean fBQ;
  boolean fBR;
  double fBS;
  double fBT;
  int fBU;
  double fBV;
  double fBW;
  String fBX;
  String fBY;
  int fBZ;
  private boolean fCa;
  private boolean fCb;
  private f fCc;
  private g fCd;
  private ak faV;
  private Context mContext;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(78131);
    this.fBM = false;
    this.aTm = new ArrayList();
    this.fBO = 0L;
    this.fBP = 0L;
    this.fBQ = false;
    this.fBR = false;
    this.fBS = 23.0D;
    this.fBT = 100.0D;
    this.fBU = 0;
    this.fBV = 0.0D;
    this.fBW = 0.0D;
    this.bno = 0.0D;
    this.fCa = false;
    this.fCb = false;
    this.faV = new ak(Looper.getMainLooper());
    this.fCc = new d.1(this);
    this.fCd = new d.2(this);
    this.mContext = paramContext;
    this.fBN = h.cd(paramContext);
    AppMethodBeat.o(78131);
  }
  
  public static d agQ()
  {
    AppMethodBeat.i(78130);
    if (fwu == null) {
      fwu = new d(ah.getContext());
    }
    d locald = fwu;
    AppMethodBeat.o(78130);
    return locald;
  }
  
  public static boolean agR()
  {
    AppMethodBeat.i(78137);
    try
    {
      boolean bool = ((LocationManager)ah.getContext().getSystemService("location")).isProviderEnabled("gps");
      AppMethodBeat.o(78137);
      return bool;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(78137);
    }
    return false;
  }
  
  public static boolean agS()
  {
    AppMethodBeat.i(78139);
    try
    {
      boolean bool = ((LocationManager)ah.getContext().getSystemService("location")).isProviderEnabled("network");
      AppMethodBeat.o(78139);
      return bool;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.LocationGeo", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(78139);
    }
    return false;
  }
  
  public static void cc(Context paramContext)
  {
    AppMethodBeat.i(78138);
    Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(localIntent, -1);
      AppMethodBeat.o(78138);
      return;
    }
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(78138);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(78134);
    b(parama, true);
    AppMethodBeat.o(78134);
  }
  
  public final void a(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(78132);
    ab.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", new Object[] { parama, Boolean.valueOf(paramBoolean), Integer.valueOf(0) });
    if ((this.fBM) && (this.aTm.size() > 0)) {}
    try
    {
      this.fBO = System.currentTimeMillis();
      this.fCa = false;
      this.fCb = false;
      this.fBN.agV();
      this.fBN.a(this.fCd, 0, Looper.getMainLooper());
      this.fBM = false;
      Iterator localIterator = this.aTm.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!((b.a)localWeakReference.get()).equals(parama)));
      i = 0;
      if (i != 0) {
        this.aTm.add(new WeakReference(parama));
      }
      ab.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.aTm.size()) });
      if ((this.aTm.size() != 1) || (i == 0)) {}
    }
    catch (h.a locala)
    {
      for (;;)
      {
        try
        {
          this.fBO = System.currentTimeMillis();
          this.fCa = false;
          this.fCb = false;
          this.fBN.a(this.fCd, 0, Looper.getMainLooper());
          if ((paramBoolean) && (this.fBR) && (System.currentTimeMillis() - this.fBP < 60000L)) {
            this.fCd.a(true, this.fBS, this.fBT, this.fBU, this.fBV, this.fBW, this.bno, this.fBX, this.fBY, this.fBZ);
          }
          AppMethodBeat.o(78132);
          return;
          locala = locala;
          ab.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (h.a parama)
        {
          ab.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final boolean agT()
  {
    AppMethodBeat.i(78140);
    if ((this.fBP > 0L) && (this.fBR) && (System.currentTimeMillis() - this.fBP < 600000L))
    {
      AppMethodBeat.o(78140);
      return true;
    }
    AppMethodBeat.o(78140);
    return false;
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(156856);
    a(parama, true);
    AppMethodBeat.o(156856);
  }
  
  public final void b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(78135);
    if ((!this.fBM) && (this.aTm.size() > 0)) {}
    try
    {
      this.fBO = System.currentTimeMillis();
      this.fCa = false;
      this.fCb = false;
      this.fBN.agV();
      this.fBN.a(this.fCc, 1, Looper.getMainLooper());
      this.fBM = true;
      Iterator localIterator = this.aTm.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!((b.a)localWeakReference.get()).equals(parama)));
      i = 0;
      if (i != 0) {
        this.aTm.add(new WeakReference(parama));
      }
      ab.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[] { Integer.valueOf(this.aTm.size()) });
      if ((this.aTm.size() != 1) || (i == 0)) {}
    }
    catch (h.a locala)
    {
      for (;;)
      {
        try
        {
          this.fBO = System.currentTimeMillis();
          this.fCa = false;
          this.fCb = false;
          this.fBN.a(this.fCc, 1, Looper.getMainLooper());
          if ((paramBoolean) && (this.fBQ) && (System.currentTimeMillis() - this.fBP < 60000L)) {
            this.fCc.a(true, this.fBS, this.fBT, this.fBU, this.fBV, this.fBW, this.bno, this.fBX, this.fBY, this.fBZ);
          }
          AppMethodBeat.o(78135);
          return;
          locala = locala;
          ab.d("MicroMsg.LocationGeo", locala.toString());
        }
        catch (h.a parama)
        {
          ab.d("MicroMsg.LocationGeo", parama.toString());
          continue;
        }
        int i = 1;
      }
    }
  }
  
  public final void c(b.a parama)
  {
    AppMethodBeat.i(78136);
    new ak().post(new d.3(this, parama));
    AppMethodBeat.o(78136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelgeo.d
 * JD-Core Version:    0.7.0.1
 */