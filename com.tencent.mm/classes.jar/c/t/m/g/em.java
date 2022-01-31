package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public final class em
  implements Parcelable, TencentLocation
{
  public static final em a = new em(-1);
  public ei b;
  private eh c;
  private int d;
  private int e;
  private String f;
  private eg g;
  private final Bundle h = new Bundle();
  private String i = "network";
  private Location j;
  private final long k;
  private long l;
  private int m;
  
  static
  {
    new em.1();
  }
  
  private em(int paramInt)
  {
    this.d = paramInt;
    this.k = SystemClock.elapsedRealtime();
    this.l = System.currentTimeMillis();
  }
  
  /* Error */
  private em(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 48	android/os/Bundle
    //   8: dup
    //   9: invokespecial 49	android/os/Bundle:<init>	()V
    //   12: putfield 51	c/t/m/g/em:h	Landroid/os/Bundle;
    //   15: aload_0
    //   16: ldc 53
    //   18: putfield 55	c/t/m/g/em:i	Ljava/lang/String;
    //   21: aload_0
    //   22: invokestatic 63	android/os/SystemClock:elapsedRealtime	()J
    //   25: putfield 65	c/t/m/g/em:k	J
    //   28: aload_0
    //   29: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   32: putfield 72	c/t/m/g/em:l	J
    //   35: new 82	org/json/JSONObject
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_0
    //   45: new 86	c/t/m/g/ei
    //   48: dup
    //   49: aload_1
    //   50: ldc 88
    //   52: invokevirtual 92	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   55: invokespecial 95	c/t/m/g/ei:<init>	(Lorg/json/JSONObject;)V
    //   58: putfield 97	c/t/m/g/em:b	Lc/t/m/g/ei;
    //   61: aload_0
    //   62: new 99	c/t/m/g/eh
    //   65: dup
    //   66: aload_1
    //   67: ldc 101
    //   69: invokevirtual 92	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   72: invokespecial 102	c/t/m/g/eh:<init>	(Lorg/json/JSONObject;)V
    //   75: putfield 104	c/t/m/g/em:c	Lc/t/m/g/eh;
    //   78: aload_0
    //   79: aload_1
    //   80: ldc 106
    //   82: invokevirtual 110	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 112	c/t/m/g/em:f	Ljava/lang/String;
    //   88: aload_0
    //   89: aload_1
    //   90: ldc 114
    //   92: iconst_0
    //   93: invokevirtual 118	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   96: putfield 120	c/t/m/g/em:e	I
    //   99: aload_0
    //   100: aload_1
    //   101: ldc 122
    //   103: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   106: invokevirtual 126	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   109: putfield 72	c/t/m/g/em:l	J
    //   112: aload_1
    //   113: ldc 128
    //   115: invokevirtual 110	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_2
    //   119: aload_2
    //   120: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +49 -> 172
    //   126: aload_0
    //   127: getfield 51	c/t/m/g/em:h	Landroid/os/Bundle;
    //   130: ldc 128
    //   132: aload_2
    //   133: ldc 136
    //   135: invokevirtual 142	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   138: iconst_0
    //   139: aaload
    //   140: invokestatic 148	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   143: invokevirtual 152	java/lang/Integer:intValue	()I
    //   146: invokevirtual 156	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   149: ldc 158
    //   151: bipush 6
    //   153: new 160	java/lang/StringBuilder
    //   156: dup
    //   157: ldc 162
    //   159: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   162: aload_2
    //   163: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 176	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_1
    //   173: ldc 178
    //   175: invokevirtual 181	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   178: astore_2
    //   179: aload_2
    //   180: ifnull +77 -> 257
    //   183: aload_0
    //   184: new 183	c/t/m/g/eg
    //   187: dup
    //   188: aload_2
    //   189: invokespecial 184	c/t/m/g/eg:<init>	(Lorg/json/JSONObject;)V
    //   192: putfield 186	c/t/m/g/em:g	Lc/t/m/g/eg;
    //   195: aload_0
    //   196: getfield 186	c/t/m/g/em:g	Lc/t/m/g/eg;
    //   199: ifnull +30 -> 229
    //   202: aload_0
    //   203: getfield 186	c/t/m/g/em:g	Lc/t/m/g/eg;
    //   206: getfield 189	c/t/m/g/eg:c	Lc/t/m/g/ek;
    //   209: ifnull +20 -> 229
    //   212: aload_0
    //   213: getfield 51	c/t/m/g/em:h	Landroid/os/Bundle;
    //   216: aload_0
    //   217: getfield 186	c/t/m/g/em:g	Lc/t/m/g/eg;
    //   220: getfield 189	c/t/m/g/eg:c	Lc/t/m/g/ek;
    //   223: getfield 193	c/t/m/g/ek:m	Landroid/os/Bundle;
    //   226: invokevirtual 197	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   229: return
    //   230: astore_1
    //   231: aload_1
    //   232: athrow
    //   233: astore_2
    //   234: ldc 158
    //   236: bipush 6
    //   238: ldc 199
    //   240: invokestatic 176	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: goto -71 -> 172
    //   246: astore_1
    //   247: ldc 158
    //   249: ldc 201
    //   251: aload_1
    //   252: invokestatic 204	c/t/m/g/j:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   255: aload_1
    //   256: athrow
    //   257: aload_1
    //   258: ldc 206
    //   260: invokevirtual 181	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   263: astore_1
    //   264: aload_1
    //   265: ifnull -70 -> 195
    //   268: aload_1
    //   269: ldc 208
    //   271: invokevirtual 212	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   274: ifeq -79 -> 195
    //   277: aload_0
    //   278: new 183	c/t/m/g/eg
    //   281: dup
    //   282: aload_1
    //   283: ldc 208
    //   285: invokevirtual 181	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   288: invokespecial 184	c/t/m/g/eg:<init>	(Lorg/json/JSONObject;)V
    //   291: putfield 186	c/t/m/g/em:g	Lc/t/m/g/eg;
    //   294: goto -99 -> 195
    //   297: astore_2
    //   298: goto -220 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	em
    //   0	301	1	paramString	String
    //   118	71	2	localObject	Object
    //   233	1	2	localException	java.lang.Exception
    //   297	1	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   44	61	230	org/json/JSONException
    //   112	172	233	java/lang/Exception
    //   183	195	246	org/json/JSONException
    //   61	78	297	java/lang/Throwable
  }
  
  public static em a(em paramem, int paramInt)
  {
    paramem.m = paramInt;
    return paramem;
  }
  
  public static em a(em paramem, boolean paramBoolean)
  {
    Object localObject;
    int n;
    if ((paramem != null) && (paramem.f != null) && (!paramBoolean))
    {
      localObject = paramem.f;
      int i1 = 0;
      n = i1;
      if (localObject != null)
      {
        n = i1;
        if (((String)localObject).split(",").length > 1) {
          n = Integer.parseInt(localObject.split(",")[1]);
        }
      }
      localObject = paramem.b;
      if (localObject == null) {}
    }
    try
    {
      ((ei)localObject).d = ((float)e.r(((ei)localObject).d, n, -70));
      return paramem;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return paramem;
  }
  
  public static void a(em paramem)
  {
    if (paramem == a) {
      throw new JSONException("location failed");
    }
  }
  
  public final void a(Location paramLocation)
  {
    if (this.b != null)
    {
      double d2 = paramLocation.getLatitude();
      double d1 = paramLocation.getLongitude();
      d2 = Math.round(d2 * 1000000.0D) / 1000000.0D;
      d1 = Math.round(d1 * 1000000.0D) / 1000000.0D;
      this.b.a = d2;
      this.b.b = d1;
      this.b.c = paramLocation.getAltitude();
      this.b.d = paramLocation.getAccuracy();
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final float getAccuracy()
  {
    if (this.b != null) {
      return this.b.d;
    }
    return 0.0F;
  }
  
  public final String getAddress()
  {
    if (this.d == 5) {
      return this.h.getString("addrdesp.name");
    }
    if (this.d == 3)
    {
      if (this.g != null) {
        return this.g.c.l;
      }
      return "";
    }
    if (this.b != null) {
      return this.b.f;
    }
    return "";
  }
  
  public final double getAltitude()
  {
    if (this.b != null) {
      return this.b.c;
    }
    return 0.0D;
  }
  
  public final Integer getAreaStat()
  {
    if (this.g != null) {
      return Integer.valueOf(this.g.a);
    }
    return null;
  }
  
  public final float getBearing()
  {
    if (this.j == null) {
      return 0.0F;
    }
    return this.j.getBearing();
  }
  
  public final String getCity()
  {
    if (this.g != null) {
      return this.g.c.f;
    }
    return "";
  }
  
  public final String getCityCode()
  {
    if (this.g != null) {
      return this.g.c.d;
    }
    return "";
  }
  
  public final int getCoordinateType()
  {
    return this.m;
  }
  
  public final double getDirection()
  {
    return this.h.getDouble("direction");
  }
  
  public final String getDistrict()
  {
    if (this.g != null) {
      return this.g.c.g;
    }
    return "";
  }
  
  public final long getElapsedRealtime()
  {
    return this.k;
  }
  
  public final Bundle getExtra()
  {
    return this.h;
  }
  
  public final int getGPSRssi()
  {
    if (this.j == null) {}
    Bundle localBundle;
    do
    {
      return 0;
      localBundle = this.j.getExtras();
    } while (localBundle == null);
    return localBundle.getInt("rssi", 0);
  }
  
  public final String getIndoorBuildingFloor()
  {
    if (this.c != null) {
      return this.c.b;
    }
    return "";
  }
  
  public final String getIndoorBuildingId()
  {
    if (this.c != null) {
      return this.c.a;
    }
    return "";
  }
  
  public final int getIndoorLocationType()
  {
    if (this.c != null) {
      return this.c.c;
    }
    return -1;
  }
  
  public final double getLatitude()
  {
    if (this.b != null) {
      return this.b.a;
    }
    return 0.0D;
  }
  
  public final double getLongitude()
  {
    if (this.b != null) {
      return this.b.b;
    }
    return 0.0D;
  }
  
  public final String getName()
  {
    if (this.d == 5) {
      return this.h.getString("addrdesp.name");
    }
    if (this.d == 3)
    {
      if (this.g != null) {
        return this.g.c.c;
      }
      return "";
    }
    if (this.b != null) {
      return this.b.e;
    }
    return "";
  }
  
  public final String getNation()
  {
    if (this.g != null) {
      return this.g.c.b;
    }
    return "";
  }
  
  public final List<TencentPoi> getPoiList()
  {
    if (this.g != null) {
      return new ArrayList(this.g.b);
    }
    return Collections.emptyList();
  }
  
  public final String getProvider()
  {
    return this.i;
  }
  
  public final String getProvince()
  {
    if (this.g != null) {
      return this.g.c.e;
    }
    return "";
  }
  
  public final float getSpeed()
  {
    if (this.j == null) {
      return 0.0F;
    }
    return this.j.getSpeed();
  }
  
  public final String getStreet()
  {
    if (this.g != null) {
      return this.g.c.j;
    }
    return "";
  }
  
  public final String getStreetNo()
  {
    if (this.g != null) {
      return this.g.c.k;
    }
    return "";
  }
  
  public final long getTime()
  {
    return this.l;
  }
  
  public final String getTown()
  {
    if (this.g != null) {
      return this.g.c.h;
    }
    return "";
  }
  
  public final String getVillage()
  {
    if (this.g != null) {
      return this.g.c.i;
    }
    return "";
  }
  
  public final int isMockGps()
  {
    return this.e;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxLocation{");
    localStringBuilder.append("level=").append(this.d).append(",");
    localStringBuilder.append("name=").append(getName()).append(",");
    localStringBuilder.append("address=").append(getAddress()).append(",");
    localStringBuilder.append("provider=").append(getProvider()).append(",");
    localStringBuilder.append("latitude=").append(getLatitude()).append(",");
    localStringBuilder.append("longitude=").append(getLongitude()).append(",");
    localStringBuilder.append("altitude=").append(getAltitude()).append(",");
    localStringBuilder.append("accuracy=").append(getAccuracy()).append(",");
    localStringBuilder.append("cityCode=").append(getCityCode()).append(",");
    localStringBuilder.append("areaStat=").append(getAreaStat()).append(",");
    localStringBuilder.append("nation=").append(getNation()).append(",");
    localStringBuilder.append("province=").append(getProvince()).append(",");
    localStringBuilder.append("city=").append(getCity()).append(",");
    localStringBuilder.append("district=").append(getDistrict()).append(",");
    localStringBuilder.append("street=").append(getStreet()).append(",");
    localStringBuilder.append("streetNo=").append(getStreetNo()).append(",");
    localStringBuilder.append("town=").append(getTown()).append(",");
    localStringBuilder.append("village=").append(getVillage()).append(",");
    localStringBuilder.append("bearing=").append(getBearing()).append(",");
    localStringBuilder.append("time=").append(getTime()).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = getPoiList().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.d);
    paramParcel.writeString(getProvider());
    paramParcel.writeDouble(getLatitude());
    paramParcel.writeDouble(getLongitude());
    paramParcel.writeDouble(getAccuracy());
    paramParcel.writeDouble(getAltitude());
    paramParcel.writeString(getAddress());
    paramParcel.writeString(getNation());
    paramParcel.writeString(getProvince());
    paramParcel.writeString(getCity());
    paramParcel.writeString(getDistrict());
    paramParcel.writeString(getStreet());
    paramParcel.writeString(getStreetNo());
    if (this.g != null) {}
    for (String str = this.g.c.d;; str = "")
    {
      paramParcel.writeString(str);
      paramParcel.writeString(getName());
      paramParcel.writeLong(this.l);
      paramParcel.writeBundle(this.h);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.em
 * JD-Core Version:    0.7.0.1
 */