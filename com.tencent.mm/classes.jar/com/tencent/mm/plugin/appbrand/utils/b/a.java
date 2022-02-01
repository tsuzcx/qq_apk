package com.tencent.mm.plugin.appbrand.utils.b;

import android.os.Bundle;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
  extends b
{
  public abstract void a(String paramString, b paramb, Bundle paramBundle);
  
  public abstract boolean b(String paramString, b paramb, Bundle paramBundle);
  
  public abstract boolean c(String paramString, b paramb, Bundle paramBundle);
  
  public static final class a
  {
    public double altitude;
    public String buildingId;
    public double cWS;
    public String floorName;
    public Object gVl;
    public double lNk;
    public int lNl;
    public float lNm;
    public double lNn = 0.0D;
    public double latitude;
    public double longitude;
    public String provider;
    
    public final String toString()
    {
      AppMethodBeat.i(143729);
      String str = "Location{latitude=" + this.latitude + ", longitude=" + this.longitude + ", provider='" + this.provider + '\'' + ", speed=" + this.cWS + ", accuracy=" + this.lNk + ", altitude=" + this.altitude + ", buildingId='" + this.buildingId + '\'' + ", floorName='" + this.floorName + '\'' + ", extra=" + this.gVl + ", indoorLocationType=" + this.lNl + ", direction=" + this.lNm + '}';
      AppMethodBeat.o(143729);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString, a.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.b.a
 * JD-Core Version:    0.7.0.1
 */