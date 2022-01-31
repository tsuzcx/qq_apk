package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.q.e;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.plugin.appbrand.v.r;
import java.util.Map;

public class ai<C extends o>
  extends e<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  
  protected Map<String, Object> b(C paramC)
  {
    Map localMap = super.g(paramC);
    int[] arrayOfInt = r.i(paramC);
    localMap.put("windowWidth", Integer.valueOf(h.mw(arrayOfInt[0])));
    localMap.put("windowHeight", Integer.valueOf(h.mw(arrayOfInt[1])));
    paramC = r.j(paramC);
    localMap.put("screenWidth", Integer.valueOf(h.mw(paramC[0])));
    localMap.put("screenHeight", Integer.valueOf(h.mw(paramC[1])));
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai
 * JD-Core Version:    0.7.0.1
 */