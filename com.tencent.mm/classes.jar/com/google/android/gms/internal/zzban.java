package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzban
  extends zza
{
  public static final Parcelable.Creator<zzban> CREATOR = new zzbao();
  final int zzaiI;
  final boolean zzbEt;
  final List<Scope> zzbEu;
  
  zzban(int paramInt, boolean paramBoolean, List<Scope> paramList)
  {
    this.zzaiI = paramInt;
    this.zzbEt = paramBoolean;
    this.zzbEu = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbao.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzban
 * JD-Core Version:    0.7.0.1
 */