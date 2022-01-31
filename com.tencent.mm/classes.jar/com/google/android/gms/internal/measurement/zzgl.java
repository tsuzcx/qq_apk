package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public class zzgl
  extends zzjr
  implements zzhi
{
  private static volatile zzgl zzame;
  private final long zzaem;
  private final zzef zzamf;
  private final zzfr zzamg;
  private final zzfg zzamh;
  private final zzgg zzami;
  private final zzjh zzamj;
  private final AppMeasurement zzamk;
  private final FirebaseAnalytics zzaml;
  private final zzka zzamm;
  private final zzfe zzamn;
  private final zzif zzamo;
  private final zzhk zzamp;
  private final zzdu zzamq;
  private zzfc zzamr;
  private zzii zzams;
  private zzeo zzamt;
  private zzfb zzamu;
  private zzfx zzamv;
  private Boolean zzamw;
  private long zzamx;
  private int zzamy;
  private int zzamz;
  private final Context zzqx;
  private final Clock zzro;
  private boolean zzvo;
  
  private zzgl(zzhj paramzzhj)
  {
    AppMethodBeat.i(69063);
    this.zzvo = false;
    Preconditions.checkNotNull(paramzzhj);
    zza(this);
    this.zzqx = paramzzhj.zzqx;
    zzws.init(this.zzqx);
    this.zzaqs = -1L;
    this.zzro = DefaultClock.getInstance();
    this.zzaem = this.zzro.currentTimeMillis();
    this.zzamf = new zzef(this);
    Object localObject = new zzfr(this);
    ((zzhh)localObject).zzm();
    this.zzamg = ((zzfr)localObject);
    localObject = new zzfg(this);
    ((zzhh)localObject).zzm();
    this.zzamh = ((zzfg)localObject);
    localObject = new zzka(this);
    ((zzhh)localObject).zzm();
    this.zzamm = ((zzka)localObject);
    localObject = new zzfe(this);
    ((zzhh)localObject).zzm();
    this.zzamn = ((zzfe)localObject);
    this.zzamq = new zzdu(this);
    localObject = new zzif(this);
    ((zzhh)localObject).zzm();
    this.zzamo = ((zzif)localObject);
    localObject = new zzhk(this);
    ((zzhh)localObject).zzm();
    this.zzamp = ((zzhk)localObject);
    this.zzamk = new AppMeasurement(this);
    this.zzaml = new FirebaseAnalytics(this);
    localObject = new zzjh(this);
    ((zzhh)localObject).zzm();
    this.zzamj = ((zzjh)localObject);
    localObject = new zzgg(this);
    ((zzhh)localObject).zzm();
    this.zzami = ((zzgg)localObject);
    if ((this.zzqx.getApplicationContext() instanceof Application))
    {
      localObject = zzfu();
      if ((((zzhg)localObject).getContext().getApplicationContext() instanceof Application))
      {
        Application localApplication = (Application)((zzhg)localObject).getContext().getApplicationContext();
        if (((zzhk)localObject).zzanp == null) {
          ((zzhk)localObject).zzanp = new zzid((zzhk)localObject, null);
        }
        localApplication.unregisterActivityLifecycleCallbacks(((zzhk)localObject).zzanp);
        localApplication.registerActivityLifecycleCallbacks(((zzhk)localObject).zzanp);
        ((zzhg)localObject).zzge().zzit().log("Registered activity lifecycle callback");
      }
    }
    for (;;)
    {
      localObject = new zzfk(this);
      ((zzjq)localObject).zzm();
      this.zzaqb = ((zzfk)localObject);
      localObject = new zzgf(this);
      ((zzjq)localObject).zzm();
      this.zzaqa = ((zzgf)localObject);
      this.zzami.zzc(new zzgm(this, paramzzhj));
      AppMethodBeat.o(69063);
      return;
      zzge().zzip().log("Application context is not an Application");
    }
  }
  
  private static void zza(zzhg paramzzhg)
  {
    AppMethodBeat.i(69084);
    if (paramzzhg == null)
    {
      paramzzhg = new IllegalStateException("Component not created");
      AppMethodBeat.o(69084);
      throw paramzzhg;
    }
    AppMethodBeat.o(69084);
  }
  
  private static void zza(zzhh paramzzhh)
  {
    AppMethodBeat.i(69083);
    if (paramzzhh == null)
    {
      paramzzhh = new IllegalStateException("Component not created");
      AppMethodBeat.o(69083);
      throw paramzzhh;
    }
    if (!paramzzhh.isInitialized())
    {
      paramzzhh = String.valueOf(paramzzhh.getClass());
      paramzzhh = new IllegalStateException(String.valueOf(paramzzhh).length() + 27 + "Component not initialized: " + paramzzhh);
      AppMethodBeat.o(69083);
      throw paramzzhh;
    }
    AppMethodBeat.o(69083);
  }
  
  private final void zzch()
  {
    AppMethodBeat.i(69082);
    if (!this.zzvo)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("AppMeasurement is not initialized");
      AppMethodBeat.o(69082);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(69082);
  }
  
  static void zzfr()
  {
    AppMethodBeat.i(69087);
    IllegalStateException localIllegalStateException = new IllegalStateException("Unexpected call on client side");
    AppMethodBeat.o(69087);
    throw localIllegalStateException;
  }
  
  public static zzgl zzg(Context paramContext)
  {
    AppMethodBeat.i(69081);
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramContext.getApplicationContext());
    if (zzame == null) {}
    try
    {
      if (zzame == null) {
        zzame = new zzgl(new zzhj(paramContext));
      }
      paramContext = zzame;
      AppMethodBeat.o(69081);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(69081);
    }
  }
  
  public final Context getContext()
  {
    return this.zzqx;
  }
  
  public final boolean isEnabled()
  {
    boolean bool = false;
    AppMethodBeat.i(69085);
    zzab();
    zzch();
    if (zzgg().zzhg())
    {
      AppMethodBeat.o(69085);
      return false;
    }
    Boolean localBoolean = zzgg().zzas("firebase_analytics_collection_enabled");
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    }
    for (;;)
    {
      bool = zzgf().zzg(bool);
      AppMethodBeat.o(69085);
      return bool;
      if (!GoogleServices.isMeasurementExplicitlyDisabled()) {
        bool = true;
      }
    }
  }
  
  protected final void start()
  {
    boolean bool1 = false;
    AppMethodBeat.i(69065);
    zzab();
    if (zzgf().zzaju.get() == 0L) {
      zzgf().zzaju.set(zzbt().currentTimeMillis());
    }
    if (zzgf().zzajz.get() == 0L)
    {
      zzge().zzit().zzg("Persisting first open", Long.valueOf(this.zzaem));
      zzgf().zzajz.set(this.zzaem);
    }
    if (!zzjv())
    {
      if (isEnabled())
      {
        if (!zzgb().zzx("android.permission.INTERNET")) {
          zzge().zzim().log("App is missing INTERNET permission");
        }
        if (!zzgb().zzx("android.permission.ACCESS_NETWORK_STATE")) {
          zzge().zzim().log("App is missing ACCESS_NETWORK_STATE permission");
        }
        if (!Wrappers.packageManager(getContext()).isCallerInstantApp())
        {
          if (!zzgb.zza(getContext())) {
            zzge().zzim().log("AppMeasurementReceiver not registered/enabled");
          }
          if (!zzjc.zza(getContext(), false)) {
            zzge().zzim().log("AppMeasurementService not registered/enabled");
          }
        }
        zzge().zzim().log("Uploading is not possible. App measurement disabled");
      }
      super.start();
      AppMethodBeat.o(69065);
      return;
    }
    Object localObject;
    if (!TextUtils.isEmpty(zzfv().getGmpAppId()))
    {
      localObject = zzgf().zziz();
      if (localObject != null) {
        break label400;
      }
      zzgf().zzbq(zzfv().getGmpAppId());
    }
    for (;;)
    {
      zzfu().zzbr(zzgf().zzakb.zzjg());
      if (TextUtils.isEmpty(zzfv().getGmpAppId())) {
        break;
      }
      boolean bool2 = isEnabled();
      if ((!zzgf().zzjf()) && (!zzgg().zzhg()))
      {
        localObject = zzgf();
        if (!bool2) {
          bool1 = true;
        }
        ((zzfr)localObject).zzh(bool1);
      }
      if ((!zzgg().zzaz(zzfv().zzah())) || (bool2)) {
        zzfu().zzkb();
      }
      zzfx().zza(new AtomicReference());
      break;
      label400:
      if (!((String)localObject).equals(zzfv().getGmpAppId()))
      {
        zzge().zzir().log("Rechecking which service to use due to a GMP App Id change");
        zzgf().zzjc();
        this.zzams.disconnect();
        this.zzams.zzdf();
        zzgf().zzbq(zzfv().getGmpAppId());
        zzgf().zzajz.set(this.zzaem);
        zzgf().zzakb.zzbs(null);
      }
    }
  }
  
  final void zza(zzhj paramzzhj)
  {
    AppMethodBeat.i(69064);
    zzab();
    Object localObject1 = new zzeo(this);
    ((zzhh)localObject1).zzm();
    this.zzamt = ((zzeo)localObject1);
    localObject1 = new zzfb(this);
    ((zzhh)localObject1).zzm();
    this.zzamu = ((zzfb)localObject1);
    Object localObject2 = new zzfc(this);
    ((zzhh)localObject2).zzm();
    this.zzamr = ((zzfc)localObject2);
    localObject2 = new zzii(this);
    ((zzhh)localObject2).zzm();
    this.zzams = ((zzii)localObject2);
    this.zzamm.zzjw();
    this.zzamg.zzjw();
    this.zzamv = new zzfx(this);
    this.zzamu.zzjw();
    zzge().zzir().zzg("App measurement is starting up, version", Long.valueOf(12451L));
    zzge().zzir().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
    localObject1 = ((zzfb)localObject1).zzah();
    if (zzgb().zzcj((String)localObject1))
    {
      localObject2 = zzge().zzir();
      localObject1 = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
    }
    for (;;)
    {
      ((zzfi)localObject2).log((String)localObject1);
      zzge().zzis().log("Debug-level message logging enabled");
      if (this.zzamy != this.zzamz) {
        zzge().zzim().zze("Not all components initialized", Integer.valueOf(this.zzamy), Integer.valueOf(this.zzamz));
      }
      super.zza(paramzzhj);
      this.zzvo = true;
      AppMethodBeat.o(69064);
      return;
      localObject2 = zzge().zzir();
      localObject1 = String.valueOf(localObject1);
      if (((String)localObject1).length() != 0) {
        localObject1 = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat((String)localObject1);
      } else {
        localObject1 = new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
      }
    }
  }
  
  public final void zzab()
  {
    AppMethodBeat.i(69080);
    zzgd().zzab();
    AppMethodBeat.o(69080);
  }
  
  final void zzb(zzhh paramzzhh)
  {
    this.zzamy += 1;
  }
  
  public final Clock zzbt()
  {
    return this.zzro;
  }
  
  public final zzdu zzft()
  {
    AppMethodBeat.i(69079);
    zza(this.zzamq);
    zzdu localzzdu = this.zzamq;
    AppMethodBeat.o(69079);
    return localzzdu;
  }
  
  public final zzhk zzfu()
  {
    AppMethodBeat.i(69071);
    zza(this.zzamp);
    zzhk localzzhk = this.zzamp;
    AppMethodBeat.o(69071);
    return localzzhk;
  }
  
  public final zzfb zzfv()
  {
    AppMethodBeat.i(69078);
    zza(this.zzamu);
    zzfb localzzfb = this.zzamu;
    AppMethodBeat.o(69078);
    return localzzfb;
  }
  
  public final zzeo zzfw()
  {
    AppMethodBeat.i(69077);
    zza(this.zzamt);
    zzeo localzzeo = this.zzamt;
    AppMethodBeat.o(69077);
    return localzzeo;
  }
  
  public final zzii zzfx()
  {
    AppMethodBeat.i(69076);
    zza(this.zzams);
    zzii localzzii = this.zzams;
    AppMethodBeat.o(69076);
    return localzzii;
  }
  
  public final zzif zzfy()
  {
    AppMethodBeat.i(69075);
    zza(this.zzamo);
    zzif localzzif = this.zzamo;
    AppMethodBeat.o(69075);
    return localzzif;
  }
  
  public final zzfc zzfz()
  {
    AppMethodBeat.i(69074);
    zza(this.zzamr);
    zzfc localzzfc = this.zzamr;
    AppMethodBeat.o(69074);
    return localzzfc;
  }
  
  public final zzfe zzga()
  {
    AppMethodBeat.i(69073);
    zza(this.zzamn);
    zzfe localzzfe = this.zzamn;
    AppMethodBeat.o(69073);
    return localzzfe;
  }
  
  public final zzka zzgb()
  {
    AppMethodBeat.i(69072);
    zza(this.zzamm);
    zzka localzzka = this.zzamm;
    AppMethodBeat.o(69072);
    return localzzka;
  }
  
  public final zzjh zzgc()
  {
    AppMethodBeat.i(69070);
    zza(this.zzamj);
    zzjh localzzjh = this.zzamj;
    AppMethodBeat.o(69070);
    return localzzjh;
  }
  
  public final zzgg zzgd()
  {
    AppMethodBeat.i(69069);
    zza(this.zzami);
    zzgg localzzgg = this.zzami;
    AppMethodBeat.o(69069);
    return localzzgg;
  }
  
  public final zzfg zzge()
  {
    AppMethodBeat.i(69067);
    zza(this.zzamh);
    zzfg localzzfg = this.zzamh;
    AppMethodBeat.o(69067);
    return localzzfg;
  }
  
  public final zzfr zzgf()
  {
    AppMethodBeat.i(69066);
    zza(this.zzamg);
    zzfr localzzfr = this.zzamg;
    AppMethodBeat.o(69066);
    return localzzfr;
  }
  
  public final zzef zzgg()
  {
    return this.zzamf;
  }
  
  public final zzfg zzjo()
  {
    AppMethodBeat.i(69068);
    if ((this.zzamh != null) && (this.zzamh.isInitialized()))
    {
      zzfg localzzfg = this.zzamh;
      AppMethodBeat.o(69068);
      return localzzfg;
    }
    AppMethodBeat.o(69068);
    return null;
  }
  
  public final zzfx zzjp()
  {
    return this.zzamv;
  }
  
  final zzgg zzjq()
  {
    return this.zzami;
  }
  
  public final AppMeasurement zzjr()
  {
    return this.zzamk;
  }
  
  public final FirebaseAnalytics zzjs()
  {
    return this.zzaml;
  }
  
  final long zzjt()
  {
    AppMethodBeat.i(69086);
    Long localLong = Long.valueOf(zzgf().zzajz.get());
    if (localLong.longValue() == 0L)
    {
      l = this.zzaem;
      AppMethodBeat.o(69086);
      return l;
    }
    long l = Math.min(this.zzaem, localLong.longValue());
    AppMethodBeat.o(69086);
    return l;
  }
  
  final void zzju()
  {
    this.zzamz += 1;
  }
  
  protected final boolean zzjv()
  {
    boolean bool2 = false;
    AppMethodBeat.i(69088);
    zzch();
    zzab();
    if ((this.zzamw == null) || (this.zzamx == 0L) || ((this.zzamw != null) && (!this.zzamw.booleanValue()) && (Math.abs(zzbt().elapsedRealtime() - this.zzamx) > 1000L)))
    {
      this.zzamx = zzbt().elapsedRealtime();
      bool1 = bool2;
      if (zzgb().zzx("android.permission.INTERNET"))
      {
        bool1 = bool2;
        if (zzgb().zzx("android.permission.ACCESS_NETWORK_STATE")) {
          if (!Wrappers.packageManager(getContext()).isCallerInstantApp())
          {
            bool1 = bool2;
            if (zzgb.zza(getContext()))
            {
              bool1 = bool2;
              if (!zzjc.zza(getContext(), false)) {}
            }
          }
          else
          {
            bool1 = true;
          }
        }
      }
      this.zzamw = Boolean.valueOf(bool1);
      if (this.zzamw.booleanValue()) {
        this.zzamw = Boolean.valueOf(zzgb().zzcg(zzfv().getGmpAppId()));
      }
    }
    boolean bool1 = this.zzamw.booleanValue();
    AppMethodBeat.o(69088);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgl
 * JD-Core Version:    0.7.0.1
 */