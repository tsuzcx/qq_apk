package com.tencent.mapsdk.internal;

import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fj$a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR;
  String a;
  int b;
  int c;
  public float d;
  public int e;
  public Typeface f;
  public float g;
  
  static
  {
    AppMethodBeat.i(221957);
    CREATOR = new Parcelable.Creator()
    {
      private static fj.a a(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(225488);
        paramAnonymousParcel = new fj.a(paramAnonymousParcel);
        AppMethodBeat.o(225488);
        return paramAnonymousParcel;
      }
      
      private static fj.a[] a(int paramAnonymousInt)
      {
        return new fj.a[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(221957);
  }
  
  protected fj$a(Parcel paramParcel)
  {
    AppMethodBeat.i(221901);
    this.g = 1.0F;
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readInt();
    this.g = paramParcel.readFloat();
    AppMethodBeat.o(221901);
  }
  
  public fj$a(String paramString, int paramInt1, int paramInt2)
  {
    this.g = 1.0F;
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  private float a()
  {
    return this.g;
  }
  
  private void a(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  private void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  private void a(Typeface paramTypeface)
  {
    this.f = paramTypeface;
  }
  
  private float b()
  {
    return this.d;
  }
  
  private void b(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  private int c()
  {
    return this.e;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221986);
    Object localObject = new StringBuffer("FontText{");
    ((StringBuffer)localObject).append("text='").append(this.a).append('\'');
    ((StringBuffer)localObject).append(", textSize=").append(this.b);
    ((StringBuffer)localObject).append(", textColor=").append(this.c);
    ((StringBuffer)localObject).append(", strokeWith=").append(this.d);
    ((StringBuffer)localObject).append(", strokeColor=").append(this.e);
    ((StringBuffer)localObject).append(", typeface=").append(this.f);
    ((StringBuffer)localObject).append(", scale=").append(this.g);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221986);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(221967);
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeFloat(this.g);
    AppMethodBeat.o(221967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fj.a
 * JD-Core Version:    0.7.0.1
 */