package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Iterator;
import java.util.Set;

public abstract class Task
  implements ReflectedParcelable
{
  public static final int EXTRAS_LIMIT_BYTES = 10240;
  public static final int NETWORK_STATE_ANY = 2;
  public static final int NETWORK_STATE_CONNECTED = 0;
  public static final int NETWORK_STATE_UNMETERED = 1;
  protected static final long UNINITIALIZED = -1L;
  private final Bundle mExtras;
  private final String mTag;
  private final String zzbgW;
  private final boolean zzbgX;
  private final boolean zzbgY;
  private final int zzbgZ;
  private final boolean zzbha;
  private final boolean zzbhb;
  private final zzc zzbhc;
  
  @Deprecated
  Task(Parcel paramParcel)
  {
    this.zzbgW = paramParcel.readString();
    this.mTag = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.zzbgX = bool1;
      if (paramParcel.readInt() != 1) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.zzbgY = bool1;
      this.zzbgZ = 2;
      this.zzbha = false;
      this.zzbhb = false;
      this.zzbhc = zzc.zzbgR;
      this.mExtras = null;
      return;
      bool1 = false;
      break;
    }
  }
  
  Task(Task.Builder paramBuilder)
  {
    this.zzbgW = paramBuilder.gcmTaskService;
    this.mTag = paramBuilder.tag;
    this.zzbgX = paramBuilder.updateCurrent;
    this.zzbgY = paramBuilder.isPersisted;
    this.zzbgZ = paramBuilder.requiredNetworkState;
    this.zzbha = paramBuilder.requiresCharging;
    this.zzbhb = false;
    this.mExtras = paramBuilder.extras;
    if (paramBuilder.zzbhd != null) {}
    for (paramBuilder = paramBuilder.zzbhd;; paramBuilder = zzc.zzbgR)
    {
      this.zzbhc = paramBuilder;
      return;
    }
  }
  
  private static boolean zzF(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Double)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean));
  }
  
  public static void zzL(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject1 = Parcel.obtain();
      paramBundle.writeToParcel((Parcel)localObject1, 0);
      int i = ((Parcel)localObject1).dataSize();
      if (i > 10240)
      {
        ((Parcel)localObject1).recycle();
        paramBundle = String.valueOf("Extras exceeding maximum size(10240 bytes): ");
        throw new IllegalArgumentException(String.valueOf(paramBundle).length() + 11 + paramBundle + i);
      }
      ((Parcel)localObject1).recycle();
      localObject1 = paramBundle.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = paramBundle.get((String)((Iterator)localObject1).next());
        if (!zzF(localObject2)) {
          if ((localObject2 instanceof Bundle)) {
            zzL((Bundle)localObject2);
          } else {
            throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, Boolean, and nested Bundles with the same restrictions.");
          }
        }
      }
    }
  }
  
  public static void zza(zzc paramzzc)
  {
    if (paramzzc != null)
    {
      int i = paramzzc.zzGT();
      if ((i != 1) && (i != 0)) {
        throw new IllegalArgumentException(45 + "Must provide a valid RetryPolicy: " + i);
      }
      int j = paramzzc.zzGU();
      int k = paramzzc.zzGV();
      if ((i == 0) && (j < 0)) {
        throw new IllegalArgumentException(52 + "InitialBackoffSeconds can't be negative: " + j);
      }
      if ((i == 1) && (j < 10)) {
        throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
      }
      if (k < j)
      {
        i = paramzzc.zzGV();
        throw new IllegalArgumentException(77 + "MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + i);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public int getRequiredNetwork()
  {
    return this.zzbgZ;
  }
  
  public boolean getRequiresCharging()
  {
    return this.zzbha;
  }
  
  public String getServiceName()
  {
    return this.zzbgW;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public boolean isPersisted()
  {
    return this.zzbgY;
  }
  
  public boolean isUpdateCurrent()
  {
    return this.zzbgX;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("tag", this.mTag);
    paramBundle.putBoolean("update_current", this.zzbgX);
    paramBundle.putBoolean("persisted", this.zzbgY);
    paramBundle.putString("service", this.zzbgW);
    paramBundle.putInt("requiredNetwork", this.zzbgZ);
    paramBundle.putBoolean("requiresCharging", this.zzbha);
    paramBundle.putBoolean("requiresIdle", false);
    paramBundle.putBundle("retryStrategy", this.zzbhc.zzK(new Bundle()));
    paramBundle.putBundle("extras", this.mExtras);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.zzbgW);
    paramParcel.writeString(this.mTag);
    if (this.zzbgX)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.zzbgY) {
        break label52;
      }
    }
    label52:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.gcm.Task
 * JD-Core Version:    0.7.0.1
 */