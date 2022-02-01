package com.google.android.gms.gcm;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class Task
  implements ReflectedParcelable
{
  public static final int EXTRAS_LIMIT_BYTES = 10240;
  public static final int NETWORK_STATE_ANY = 2;
  public static final int NETWORK_STATE_CONNECTED = 0;
  public static final int NETWORK_STATE_UNMETERED = 1;
  protected static final long UNINITIALIZED = -1L;
  private final Bundle extras;
  private final String gcmTaskService;
  private final boolean isPersisted;
  private final int requiredNetworkState;
  private final boolean requiresCharging;
  private final String tag;
  private final boolean updateCurrent;
  private final Set<Uri> zzau;
  private final boolean zzav;
  private final zzl zzaw;
  
  @Deprecated
  Task(Parcel paramParcel)
  {
    AppMethodBeat.i(3691);
    this.gcmTaskService = paramParcel.readString();
    this.tag = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.updateCurrent = bool1;
      if (paramParcel.readInt() != 1) {
        break label104;
      }
    }
    label104:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isPersisted = bool1;
      this.requiredNetworkState = 2;
      this.zzau = Collections.emptySet();
      this.requiresCharging = false;
      this.zzav = false;
      this.zzaw = zzl.zzao;
      this.extras = null;
      AppMethodBeat.o(3691);
      return;
      bool1 = false;
      break;
    }
  }
  
  Task(Builder paramBuilder)
  {
    AppMethodBeat.i(3690);
    this.gcmTaskService = paramBuilder.gcmTaskService;
    this.tag = paramBuilder.tag;
    this.updateCurrent = paramBuilder.updateCurrent;
    this.isPersisted = paramBuilder.isPersisted;
    this.requiredNetworkState = paramBuilder.requiredNetworkState;
    this.zzau = paramBuilder.zzau;
    this.requiresCharging = paramBuilder.requiresCharging;
    this.zzav = false;
    this.extras = paramBuilder.extras;
    if (paramBuilder.zzaw != null) {}
    for (paramBuilder = paramBuilder.zzaw;; paramBuilder = zzl.zzao)
    {
      this.zzaw = paramBuilder;
      AppMethodBeat.o(3690);
      return;
    }
  }
  
  private static void zzd(Uri paramUri)
  {
    AppMethodBeat.i(3695);
    if (paramUri == null)
    {
      paramUri = new IllegalArgumentException("Null URI");
      AppMethodBeat.o(3695);
      throw paramUri;
    }
    String str1 = paramUri.getScheme();
    String str2 = paramUri.getHost();
    if ((TextUtils.isEmpty(str2)) || ("null".equals(str2)))
    {
      paramUri = new IllegalArgumentException("URI hostname is required");
      AppMethodBeat.o(3695);
      throw paramUri;
    }
    try
    {
      i = paramUri.getPort();
      if ("tcp".equals(str1))
      {
        if ((i > 0) && (i <= 65535)) {
          break label272;
        }
        i = paramUri.getPort();
        paramUri = new IllegalArgumentException(38 + "Invalid required URI port: " + i);
        AppMethodBeat.o(3695);
        throw paramUri;
      }
    }
    catch (NumberFormatException paramUri)
    {
      int i;
      paramUri = String.valueOf(paramUri.getMessage());
      if (paramUri.length() != 0) {}
      for (paramUri = "Invalid port number: ".concat(paramUri);; paramUri = new String("Invalid port number: "))
      {
        paramUri = new IllegalArgumentException(paramUri);
        AppMethodBeat.o(3695);
        throw paramUri;
      }
      if ("ping".equals(str1))
      {
        if (i != -1)
        {
          paramUri = new IllegalArgumentException("Ping does not support port numbers");
          AppMethodBeat.o(3695);
          throw paramUri;
        }
      }
      else
      {
        paramUri = String.valueOf(str1);
        if (paramUri.length() != 0) {}
        for (paramUri = "Unsupported required URI scheme: ".concat(paramUri);; paramUri = new String("Unsupported required URI scheme: "))
        {
          paramUri = new IllegalArgumentException(paramUri);
          AppMethodBeat.o(3695);
          throw paramUri;
        }
      }
      label272:
      AppMethodBeat.o(3695);
    }
  }
  
  public static void zzg(Bundle paramBundle)
  {
    AppMethodBeat.i(3694);
    if (paramBundle != null)
    {
      Object localObject1 = Parcel.obtain();
      paramBundle.writeToParcel((Parcel)localObject1, 0);
      int i = ((Parcel)localObject1).dataSize();
      ((Parcel)localObject1).recycle();
      if (i > 10240)
      {
        paramBundle = new IllegalArgumentException(55 + "Extras exceeding maximum size(10240 bytes): " + i);
        AppMethodBeat.o(3694);
        throw paramBundle;
      }
      localObject1 = paramBundle.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = paramBundle.get((String)((Iterator)localObject1).next());
        if (((localObject2 instanceof Integer)) || ((localObject2 instanceof Long)) || ((localObject2 instanceof Double)) || ((localObject2 instanceof String)) || ((localObject2 instanceof Boolean))) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label167;
          }
          if (!(localObject2 instanceof Bundle)) {
            break label169;
          }
          zzg((Bundle)localObject2);
          break;
        }
        label167:
        continue;
        label169:
        paramBundle = new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, Boolean, and nested Bundles with the same restrictions.");
        AppMethodBeat.o(3694);
        throw paramBundle;
      }
    }
    AppMethodBeat.o(3694);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getExtras()
  {
    return this.extras;
  }
  
  public int getRequiredNetwork()
  {
    return this.requiredNetworkState;
  }
  
  public boolean getRequiresCharging()
  {
    return this.requiresCharging;
  }
  
  public String getServiceName()
  {
    return this.gcmTaskService;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public boolean isPersisted()
  {
    return this.isPersisted;
  }
  
  public boolean isUpdateCurrent()
  {
    return this.updateCurrent;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3692);
    paramBundle.putString("tag", this.tag);
    paramBundle.putBoolean("update_current", this.updateCurrent);
    paramBundle.putBoolean("persisted", this.isPersisted);
    paramBundle.putString("service", this.gcmTaskService);
    paramBundle.putInt("requiredNetwork", this.requiredNetworkState);
    if (!this.zzau.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.zzau.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Uri)localIterator.next()).toString());
      }
      paramBundle.putStringArrayList("reachabilityUris", localArrayList);
    }
    paramBundle.putBoolean("requiresCharging", this.requiresCharging);
    paramBundle.putBoolean("requiresIdle", false);
    paramBundle.putBundle("retryStrategy", this.zzaw.zzf(new Bundle()));
    paramBundle.putBundle("extras", this.extras);
    AppMethodBeat.o(3692);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(3693);
    paramParcel.writeString(this.gcmTaskService);
    paramParcel.writeString(this.tag);
    if (this.updateCurrent)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.isPersisted) {
        break label64;
      }
    }
    label64:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(3693);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public static abstract class Builder
  {
    protected Bundle extras;
    protected String gcmTaskService;
    protected boolean isPersisted;
    protected int requiredNetworkState;
    protected boolean requiresCharging;
    protected String tag;
    protected boolean updateCurrent;
    protected Set<Uri> zzau = Collections.emptySet();
    protected zzl zzaw = zzl.zzao;
    
    public abstract Task build();
    
    protected void checkConditions()
    {
      if (this.gcmTaskService != null) {}
      int i;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Must provide an endpoint for this task by calling setService(ComponentName).");
        GcmNetworkManager.zzd(this.tag);
        localObject = this.zzaw;
        if (localObject == null) {
          break label195;
        }
        i = ((zzl)localObject).zzh();
        if ((i == 1) || (i == 0)) {
          break;
        }
        throw new IllegalArgumentException(45 + "Must provide a valid RetryPolicy: " + i);
      }
      int j = ((zzl)localObject).zzi();
      int k = ((zzl)localObject).zzj();
      if ((i == 0) && (j < 0)) {
        throw new IllegalArgumentException(52 + "InitialBackoffSeconds can't be negative: " + j);
      }
      if ((i == 1) && (j < 10)) {
        throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
      }
      if (k < j)
      {
        i = ((zzl)localObject).zzj();
        throw new IllegalArgumentException(77 + "MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + i);
      }
      label195:
      if (this.isPersisted) {
        Task.zzg(this.extras);
      }
      if ((!this.zzau.isEmpty()) && (this.requiredNetworkState == 2)) {
        throw new IllegalArgumentException("Required URIs may not be used with NETWORK_STATE_ANY");
      }
      Object localObject = this.zzau.iterator();
      while (((Iterator)localObject).hasNext()) {
        Task.zze((Uri)((Iterator)localObject).next());
      }
    }
    
    public abstract Builder setExtras(Bundle paramBundle);
    
    public abstract Builder setPersisted(boolean paramBoolean);
    
    public abstract Builder setRequiredNetwork(int paramInt);
    
    public abstract Builder setRequiresCharging(boolean paramBoolean);
    
    public abstract Builder setService(Class<? extends GcmTaskService> paramClass);
    
    public abstract Builder setTag(String paramString);
    
    public abstract Builder setUpdateCurrent(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.gcm.Task
 * JD-Core Version:    0.7.0.1
 */