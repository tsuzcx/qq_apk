package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzrt;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.internal.zzsk;
import com.google.android.gms.internal.zzss;
import java.util.List;
import java.util.ListIterator;

public class zza
  extends zzg<zza>
{
  private final zzsc zzabn;
  private boolean zzabo;
  
  public zza(zzsc paramzzsc)
  {
    super(paramzzsc.zznU(), paramzzsc.zznR());
    this.zzabn = paramzzsc;
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    this.zzabo = paramBoolean;
  }
  
  protected void zza(zze paramzze)
  {
    paramzze = (zzrt)paramzze.zzb(zzrt.class);
    if (TextUtils.isEmpty(paramzze.zzmy())) {
      paramzze.setClientId(this.zzabn.zzoi().zzoQ());
    }
    if ((this.zzabo) && (TextUtils.isEmpty(paramzze.zznv())))
    {
      zzrx localzzrx = this.zzabn.zzoh();
      paramzze.zzbF(localzzrx.zznG());
      paramzze.zzS(localzzrx.zznw());
    }
  }
  
  public void zzbo(String paramString)
  {
    zzac.zzdr(paramString);
    zzbp(paramString);
    zzmO().add(new zzb(this.zzabn, paramString));
  }
  
  public void zzbp(String paramString)
  {
    paramString = zzb.zzbq(paramString);
    ListIterator localListIterator = zzmO().listIterator();
    while (localListIterator.hasNext()) {
      if (paramString.equals(((zzi)localListIterator.next()).zzmr())) {
        localListIterator.remove();
      }
    }
  }
  
  zzsc zzmn()
  {
    return this.zzabn;
  }
  
  public zze zzmo()
  {
    zze localzze = zzmN().zzmC();
    localzze.zza(this.zzabn.zznZ().zzoy());
    localzze.zza(this.zzabn.zzoa().zzpB());
    zzd(localzze);
    return localzze;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.analytics.zza
 * JD-Core Version:    0.7.0.1
 */