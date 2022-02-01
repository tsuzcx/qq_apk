package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="ConnectionConfigurationCreator")
@SafeParcelable.Reserved({1})
public class ConnectionConfiguration
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR;
  @SafeParcelable.Field(getter="getName", id=2)
  private final String name;
  @SafeParcelable.Field(getter="getType", id=4)
  private final int type;
  @SafeParcelable.Field(getter="getAddress", id=3)
  private final String zzi;
  @SafeParcelable.Field(getter="getRole", id=5)
  private final int zzj;
  @SafeParcelable.Field(getter="isEnabled", id=6)
  private final boolean zzk;
  @SafeParcelable.Field(getter="isConnected", id=7)
  private volatile boolean zzl;
  @SafeParcelable.Field(getter="getPeerNodeId", id=8)
  private volatile String zzm;
  @SafeParcelable.Field(getter="getBtlePriority", id=9)
  private boolean zzn;
  @SafeParcelable.Field(getter="getNodeId", id=10)
  private String zzo;
  
  static
  {
    AppMethodBeat.i(100781);
    CREATOR = new zzg();
    AppMethodBeat.o(100781);
  }
  
  @SafeParcelable.Constructor
  ConnectionConfiguration(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) int paramInt1, @SafeParcelable.Param(id=5) int paramInt2, @SafeParcelable.Param(id=6) boolean paramBoolean1, @SafeParcelable.Param(id=7) boolean paramBoolean2, @SafeParcelable.Param(id=8) String paramString3, @SafeParcelable.Param(id=9) boolean paramBoolean3, @SafeParcelable.Param(id=10) String paramString4)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.ConnectionConfiguration
 * JD-Core Version:    0.7.0.1
 */