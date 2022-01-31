package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzd
  implements zzi
{
  private static final Uri zzabS;
  private final LogPrinter zzabT = new LogPrinter(4, "GA/LogCatTransport");
  
  static
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("local");
    zzabS = localBuilder.build();
  }
  
  public final void zzb(zze paramzze)
  {
    Object localObject = new ArrayList(paramzze.zzmD());
    Collections.sort((List)localObject, new zzd.1(this));
    paramzze = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((zzf)((Iterator)localObject).next()).toString();
      if (!TextUtils.isEmpty(str))
      {
        if (paramzze.length() != 0) {
          paramzze.append(", ");
        }
        paramzze.append(str);
      }
    }
    this.zzabT.println(paramzze.toString());
  }
  
  public final Uri zzmr()
  {
    return zzabS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.analytics.zzd
 * JD-Core Version:    0.7.0.1
 */