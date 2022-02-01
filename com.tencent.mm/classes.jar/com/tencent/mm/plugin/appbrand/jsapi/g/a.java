package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public final class a
{
  public static final class b
  {
    public static final a.d rUD;
    
    static
    {
      AppMethodBeat.i(325571);
      rUD = new a.d(102101, "fail:settings page not found");
      AppMethodBeat.o(325571);
    }
  }
  
  public static final class d
  {
    public final String errMsg;
    public final int rVs;
    
    public d(int paramInt)
    {
      this(paramInt, null);
    }
    
    public d(int paramInt, String paramString)
    {
      this.rVs = paramInt;
      this.errMsg = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(325574);
      if (this == paramObject)
      {
        AppMethodBeat.o(325574);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(325574);
        return false;
      }
      paramObject = (d)paramObject;
      if (this.rVs == paramObject.rVs)
      {
        AppMethodBeat.o(325574);
        return true;
      }
      AppMethodBeat.o(325574);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(325578);
      int i = Objects.hash(new Object[] { Integer.valueOf(this.rVs) });
      AppMethodBeat.o(325578);
      return i;
    }
  }
  
  public static final class e
  {
    public static final a.d rVA;
    public static final a.d rVB;
    public static final a.d rVC;
    public static final a.d rVD;
    public static final a.d rVE;
    public static final a.d rVF;
    public static final a.d rVG;
    public static final a.d rVH;
    public static final a.d rVI;
    public static final a.d rVt;
    public static final a.d rVu;
    public static final a.d rVv;
    public static final a.d rVw;
    public static final a.d rVx;
    public static final a.d rVy;
    public static final a.d rVz;
    
    static
    {
      AppMethodBeat.i(325568);
      rVt = new a.d(0, "ok");
      rVu = new a.d(1, "cancel");
      rVv = new a.d(2, "fail:native buffer exceed size limit");
      rVw = new a.d(3, "fail:system permission denied");
      rVx = new a.d(4, "fail:internal error");
      rVy = new a.d(100, "fail:jsapi not supported");
      rVz = new a.d(101, "fail:jsapi invalid request data");
      rVA = new a.d(102, "fail:jsapi has no permission");
      rVB = new a.d(103, "fail:jsapi user authorize denied");
      rVC = new a.d(104, "fail:jsapi user authorize canceled");
      rVD = new a.d(105, "fail:invalid jsapi state");
      rVE = new a.d(106, "fail:invalid jsapi index");
      rVF = new a.d(1000, "fail:server system error");
      rVG = new a.d(1001, "fail:invalid request parameter");
      rVH = new a.d(1002, "fail:empty request");
      rVI = new a.d(1003, "fail:meet server frequency limit");
      AppMethodBeat.o(325568);
    }
  }
  
  public static final class f
  {
    public static final a.d rVJ;
    public static final a.d rVK;
    public static final a.d rVL;
    public static final a.d rVM;
    public static final a.d rVN;
    public static final a.d rVO;
    public static final a.d rVP;
    public static final a.d rVQ;
    public static final a.d rVR;
    public static final a.d rVS;
    public static final a.d rVT;
    public static final a.d rVU;
    public static final a.d rVV;
    public static final a.d rVW;
    public static final a.d rVX;
    public static final a.d rVY;
    public static final a.d rVZ;
    
    static
    {
      AppMethodBeat.i(325570);
      rVJ = new a.d(700000, "fail:unknown payment error");
      rVK = new a.d(700001, "fail:limited use");
      rVL = new a.d(701000, "fail:unknown payment default class error");
      rVM = new a.d(701001, "fail:ios not support");
      rVN = new a.d(701002, "fail:need realname verify before payment");
      rVO = new a.d(701100, "fail:midas buy goods failed");
      rVP = new a.d(701101, "fail:midas get account balance failed");
      rVQ = new a.d(701102, "fail:midas currency pay failed");
      rVR = new a.d(701103, "fail:midas currency canel pay failed");
      rVS = new a.d(701104, "fail:midas currency present failed");
      rVT = new a.d(701105, "fail:midas get user water failed");
      rVU = new a.d(701106, "fail:midas currency in sufficient");
      rVV = new a.d(701107, "fail:midas order not exists");
      rVW = new a.d(701108, "fail:midas order already refunded");
      rVX = new a.d(701109, "fail:midas order refunded amount exceed");
      rVY = new a.d(701110, "fail:midas order duplicated pperator");
      rVZ = new a.d(701111, "fail:midas invalid parameter");
      AppMethodBeat.o(325570);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a
 * JD-Core Version:    0.7.0.1
 */