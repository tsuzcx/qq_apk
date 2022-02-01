package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum zzabp
{
  private final zzabu zzbwb;
  private final int zzbwc;
  
  static
  {
    AppMethodBeat.i(40218);
    zzbvj = new zzabp("DOUBLE", 0, zzabu.zzbwh, 1);
    zzbvk = new zzabp("FLOAT", 1, zzabu.zzbwg, 5);
    zzbvl = new zzabp("INT64", 2, zzabu.zzbwf, 0);
    zzbvm = new zzabp("UINT64", 3, zzabu.zzbwf, 0);
    zzbvn = new zzabp("INT32", 4, zzabu.zzbwe, 0);
    zzbvo = new zzabp("FIXED64", 5, zzabu.zzbwf, 1);
    zzbvp = new zzabp("FIXED32", 6, zzabu.zzbwe, 5);
    zzbvq = new zzabp("BOOL", 7, zzabu.zzbwi, 0);
    zzbvr = new zzabq("STRING", 8, zzabu.zzbwj, 2);
    zzbvs = new zzabr("GROUP", 9, zzabu.zzbwm, 3);
    zzbvt = new zzabs("MESSAGE", 10, zzabu.zzbwm, 2);
    zzbvu = new zzabt("BYTES", 11, zzabu.zzbwk, 2);
    zzbvv = new zzabp("UINT32", 12, zzabu.zzbwe, 0);
    zzbvw = new zzabp("ENUM", 13, zzabu.zzbwl, 0);
    zzbvx = new zzabp("SFIXED32", 14, zzabu.zzbwe, 5);
    zzbvy = new zzabp("SFIXED64", 15, zzabu.zzbwf, 1);
    zzbvz = new zzabp("SINT32", 16, zzabu.zzbwe, 0);
    zzbwa = new zzabp("SINT64", 17, zzabu.zzbwf, 0);
    zzbwd = new zzabp[] { zzbvj, zzbvk, zzbvl, zzbvm, zzbvn, zzbvo, zzbvp, zzbvq, zzbvr, zzbvs, zzbvt, zzbvu, zzbvv, zzbvw, zzbvx, zzbvy, zzbvz, zzbwa };
    AppMethodBeat.o(40218);
  }
  
  private zzabp(zzabu paramzzabu, int paramInt)
  {
    this.zzbwb = paramzzabu;
    this.zzbwc = paramInt;
  }
  
  public final zzabu zzuv()
  {
    return this.zzbwb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabp
 * JD-Core Version:    0.7.0.1
 */