package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum zzabu
{
  private final Object zzbwn;
  
  static
  {
    AppMethodBeat.i(3430);
    zzbwe = new zzabu("INT", 0, Integer.valueOf(0));
    zzbwf = new zzabu("LONG", 1, Long.valueOf(0L));
    zzbwg = new zzabu("FLOAT", 2, Float.valueOf(0.0F));
    zzbwh = new zzabu("DOUBLE", 3, Double.valueOf(0.0D));
    zzbwi = new zzabu("BOOLEAN", 4, Boolean.FALSE);
    zzbwj = new zzabu("STRING", 5, "");
    zzbwk = new zzabu("BYTE_STRING", 6, zzyw.zzbqx);
    zzbwl = new zzabu("ENUM", 7, null);
    zzbwm = new zzabu("MESSAGE", 8, null);
    zzbwo = new zzabu[] { zzbwe, zzbwf, zzbwg, zzbwh, zzbwi, zzbwj, zzbwk, zzbwl, zzbwm };
    AppMethodBeat.o(3430);
  }
  
  private zzabu(Object paramObject)
  {
    this.zzbwn = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabu
 * JD-Core Version:    0.7.0.1
 */