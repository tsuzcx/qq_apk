package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.luggage.j.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;

abstract class a<CONTEXT extends c>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<CONTEXT>
{
  static boolean i(CONTEXT paramCONTEXT)
  {
    return f.j(paramCONTEXT.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.a
 * JD-Core Version:    0.7.0.1
 */