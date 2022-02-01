package com.tencent.mapsdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class fn
  implements Parcelable
{
  public static final Parcelable.Creator<fn> CREATOR;
  public int a;
  public String b;
  public int c;
  public int d;
  public float e;
  public float f;
  public float g;
  public String h;
  public int i;
  public int j;
  public String k;
  public float l;
  public float m;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public LatLng u;
  
  static
  {
    AppMethodBeat.i(221684);
    CREATOR = new Parcelable.Creator()
    {
      private static fn a(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(222310);
        paramAnonymousParcel = new fn(paramAnonymousParcel);
        AppMethodBeat.o(222310);
        return paramAnonymousParcel;
      }
      
      private static fn[] a(int paramAnonymousInt)
      {
        return new fn[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(221684);
  }
  
  public fn()
  {
    this.e = 0.5F;
    this.f = 0.5F;
    this.g = 1.0F;
    this.n = 0;
    this.o = 3;
  }
  
  protected fn(Parcel paramParcel)
  {
    AppMethodBeat.i(221672);
    this.e = 0.5F;
    this.f = 0.5F;
    this.g = 1.0F;
    this.n = 0;
    this.o = 3;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
    this.g = paramParcel.readFloat();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readString();
    this.l = paramParcel.readFloat();
    this.m = paramParcel.readFloat();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
    this.p = paramParcel.readInt();
    this.q = paramParcel.readInt();
    this.r = paramParcel.readInt();
    this.u = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    AppMethodBeat.o(221672);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(221693);
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeFloat(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeFloat(this.l);
    paramParcel.writeFloat(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.p);
    paramParcel.writeInt(this.q);
    paramParcel.writeInt(this.r);
    paramParcel.writeParcelable(this.u, paramInt);
    AppMethodBeat.o(221693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fn
 * JD-Core Version:    0.7.0.1
 */