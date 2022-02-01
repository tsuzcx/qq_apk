package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConnectionConfiguration
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR;
  private final String name;
  private final int type;
  private final String zzi;
  private final int zzj;
  private final boolean zzk;
  private volatile boolean zzl;
  private volatile String zzm;
  private boolean zzn;
  private String zzo;
  
  static
  {
    AppMethodBeat.i(100781);
    CREATOR = new zzg();
    AppMethodBeat.o(100781);
  }
  
  ConnectionConfiguration(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    this.name = paramString1;
    this.zzi = paramString2;
    this.type = paramInt1;
    this.zzj = paramInt2;
    this.zzk = paramBoolean1;
    this.zzl = paramBoolean2;
    this.zzm = paramString3;
    this.zzn = paramBoolean3;
    this.zzo = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(100779);
    if (!(paramObject instanceof ConnectionConfiguration))
    {
      AppMethodBeat.o(100779);
      return false;
    }
    paramObject = (ConnectionConfiguration)paramObject;
    if ((Objects.equal(this.name, paramObject.name)) && (Objects.equal(this.zzi, paramObject.zzi)) && (Objects.equal(Integer.valueOf(this.type), Integer.valueOf(paramObject.type))) && (Objects.equal(Integer.valueOf(this.zzj), Integer.valueOf(paramObject.zzj))) && (Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(paramObject.zzk))) && (Objects.equal(Boolean.valueOf(this.zzn), Boolean.valueOf(paramObject.zzn))))
    {
      AppMethodBeat.o(100779);
      return true;
    }
    AppMethodBeat.o(100779);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(100780);
    int i = Objects.hashCode(new Object[] { this.name, this.zzi, Integer.valueOf(this.type), Integer.valueOf(this.zzj), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzn) });
    AppMethodBeat.o(100780);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(100778);
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    String str = String.valueOf(this.name);
    if (str.length() != 0)
    {
      str = "mName=".concat(str);
      localStringBuilder.append(str);
      str = String.valueOf(this.zzi);
      if (str.length() == 0) {
        break label326;
      }
      str = ", mAddress=".concat(str);
      label67:
      localStringBuilder.append(str);
      int i = this.type;
      localStringBuilder.append(19 + ", mType=" + i);
      i = this.zzj;
      localStringBuilder.append(19 + ", mRole=" + i);
      boolean bool = this.zzk;
      localStringBuilder.append(16 + ", mEnabled=" + bool);
      bool = this.zzl;
      localStringBuilder.append(20 + ", mIsConnected=" + bool);
      str = String.valueOf(this.zzm);
      if (str.length() == 0) {
        break label339;
      }
      str = ", mPeerNodeId=".concat(str);
      label224:
      localStringBuilder.append(str);
      bool = this.zzn;
      localStringBuilder.append(21 + ", mBtlePriority=" + bool);
      str = String.valueOf(this.zzo);
      if (str.length() == 0) {
        break label352;
      }
    }
    label326:
    label339:
    label352:
    for (str = ", mNodeId=".concat(str);; str = new String(", mNodeId="))
    {
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      str = localStringBuilder.toString();
      AppMethodBeat.o(100778);
      return str;
      str = new String("mName=");
      break;
      str = new String(", mAddress=");
      break label67;
      str = new String(", mPeerNodeId=");
      break label224;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(100777);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.name, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzi, false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.type);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzj);
    SafeParcelWriter.writeBoolean(paramParcel, 6, this.zzk);
    SafeParcelWriter.writeBoolean(paramParcel, 7, this.zzl);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzm, false);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzn);
    SafeParcelWriter.writeString(paramParcel, 10, this.zzo, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(100777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.ConnectionConfiguration
 * JD-Core Version:    0.7.0.1
 */