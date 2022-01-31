package com.tencent.mm.plugin.appbrand.t.b;

import android.os.Bundle;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
  extends b
{
  public abstract void a(String paramString, a.b paramb, Bundle paramBundle);
  
  public abstract boolean b(String paramString, a.b paramb, Bundle paramBundle);
  
  public abstract boolean c(String paramString, a.b paramb, Bundle paramBundle);
  
  public static final class a
  {
    public double altitude;
    public String bsd;
    public String buildingId;
    public float direction;
    public String floorName;
    public Object fti;
    public double iYv;
    public double iYw;
    public int iYx;
    public double latitude;
    public double longitude;
    
    public final String toString()
    {
      AppMethodBeat.i(93905);
      String str = "Location{latitude=" + this.latitude + ", longitude=" + this.longitude + ", provider='" + this.bsd + '\'' + ", speed=" + this.iYv + ", accuracy=" + this.iYw + ", altitude=" + this.altitude + ", buildingId='" + this.buildingId + '\'' + ", floorName='" + this.floorName + '\'' + ", extra=" + this.fti + ", indoorLocationType=" + this.iYx + ", direction=" + this.direction + '}';
      AppMethodBeat.o(93905);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.b.a
 * JD-Core Version:    0.7.0.1
 */