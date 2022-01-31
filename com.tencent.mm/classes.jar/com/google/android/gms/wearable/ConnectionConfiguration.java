package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public class ConnectionConfiguration
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzg();
  private final String mName;
  private final int zzaLu;
  private final String zzaSq;
  private boolean zzagx;
  private final int zzakD;
  private final boolean zzbST;
  private String zzbSU;
  private boolean zzbSV;
  private String zzbSW;
  
  ConnectionConfiguration(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    this.mName = paramString1;
    this.zzaSq = paramString2;
    this.zzakD = paramInt1;
    this.zzaLu = paramInt2;
    this.zzbST = paramBoolean1;
    this.zzagx = paramBoolean2;
    this.zzbSU = paramString3;
    this.zzbSV = paramBoolean3;
    this.zzbSW = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionConfiguration)) {}
    do
    {
      return false;
      paramObject = (ConnectionConfiguration)paramObject;
    } while ((!zzaa.equal(this.mName, paramObject.mName)) || (!zzaa.equal(this.zzaSq, paramObject.zzaSq)) || (!zzaa.equal(Integer.valueOf(this.zzakD), Integer.valueOf(paramObject.zzakD))) || (!zzaa.equal(Integer.valueOf(this.zzaLu), Integer.valueOf(paramObject.zzaLu))) || (!zzaa.equal(Boolean.valueOf(this.zzbST), Boolean.valueOf(paramObject.zzbST))) || (!zzaa.equal(Boolean.valueOf(this.zzbSV), Boolean.valueOf(paramObject.zzbSV))));
    return true;
  }
  
  public String getAddress()
  {
    return this.zzaSq;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getNodeId()
  {
    return this.zzbSW;
  }
  
  public int getRole()
  {
    return this.zzaLu;
  }
  
  public int getType()
  {
    return this.zzakD;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.mName, this.zzaSq, Integer.valueOf(this.zzakD), Integer.valueOf(this.zzaLu), Boolean.valueOf(this.zzbST), Boolean.valueOf(this.zzbSV) });
  }
  
  public boolean isConnected()
  {
    return this.zzagx;
  }
  
  public boolean isEnabled()
  {
    return this.zzbST;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    String str = String.valueOf(this.mName);
    if (str.length() != 0)
    {
      str = "mName=".concat(str);
      localStringBuilder.append(str);
      str = String.valueOf(this.zzaSq);
      if (str.length() == 0) {
        break label314;
      }
      str = ", mAddress=".concat(str);
      label62:
      localStringBuilder.append(str);
      int i = this.zzakD;
      localStringBuilder.append(19 + ", mType=" + i);
      i = this.zzaLu;
      localStringBuilder.append(19 + ", mRole=" + i);
      boolean bool = this.zzbST;
      localStringBuilder.append(16 + ", mEnabled=" + bool);
      bool = this.zzagx;
      localStringBuilder.append(20 + ", mIsConnected=" + bool);
      str = String.valueOf(this.zzbSU);
      if (str.length() == 0) {
        break label327;
      }
      str = ", mPeerNodeId=".concat(str);
      label219:
      localStringBuilder.append(str);
      bool = this.zzbSV;
      localStringBuilder.append(21 + ", mBtlePriority=" + bool);
      str = String.valueOf(this.zzbSW);
      if (str.length() == 0) {
        break label340;
      }
    }
    label314:
    label327:
    label340:
    for (str = ", mNodeId=".concat(str);; str = new String(", mNodeId="))
    {
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      str = new String("mName=");
      break;
      str = new String(", mAddress=");
      break label62;
      str = new String(", mPeerNodeId=");
      break label219;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public String zzUd()
  {
    return this.zzbSU;
  }
  
  public boolean zzUe()
  {
    return this.zzbSV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.ConnectionConfiguration
 * JD-Core Version:    0.7.0.1
 */