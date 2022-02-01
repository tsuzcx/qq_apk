package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class b$1
  extends HashMap<String, Object>
{
  b$1(b paramb, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(193661);
    put("width", Integer.valueOf(this.lTh.outWidth));
    put("height", Integer.valueOf(this.lTh.outHeight));
    AppMethodBeat.o(193661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.b.1
 * JD-Core Version:    0.7.0.1
 */