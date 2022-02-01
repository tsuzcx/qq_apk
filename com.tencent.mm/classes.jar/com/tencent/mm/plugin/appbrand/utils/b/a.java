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
    public double dfE;
    public String floorName;
    public Object hNZ;
    public double latitude;
    public double longitude;
    public double mPP;
    public int mPQ;
    public float mPR;
    public double mPS = 0.0D;
    public String provider;
    
    public final String toString()
    {
      AppMethodBeat.i(143729);
      String str = "Location{latitude=" + this.latitude + ", longitude=" + this.longitude + ", provider='" + this.provider + '\'' + ", speed=" + this.dfE + ", accuracy=" + this.mPP + ", altitude=" + this.altitude + ", buildingId='" + this.buildingId + '\'' + ", floorName='" + this.floorName + '\'' + ", extra=" + this.hNZ + ", indoorLocationType=" + this.mPQ + ", direction=" + this.mPR + '}';
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