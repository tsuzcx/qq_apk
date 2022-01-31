package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  private static final int CTRL_INDEX = 120;
  private static final String NAME = "getImageInfo";
  private static final Collection<h.b> hRZ;
  
  static
  {
    AppMethodBeat.i(114365);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new h.a((byte)0));
    localLinkedList.add(new d((byte)0));
    hRZ = Collections.unmodifiableCollection(localLinkedList);
    AppMethodBeat.o(114365);
  }
  
  static final class d
    implements h.b
  {
    public final com.tencent.mm.vending.j.a h(i parami, String paramString)
    {
      AppMethodBeat.i(114360);
      paramString = ax.f(parami, paramString);
      h.c localc;
      boolean bool;
      if (paramString != null)
      {
        paramString.mark(0);
        parami = new BitmapFactory.Options();
        parami.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(paramString, new Rect(), parami);
        localc = new h.c((byte)0);
        localc.width = parami.outWidth;
        localc.height = parami.outHeight;
        localc.type = com.tencent.luggage.e.a.a.c(parami);
        bool = com.tencent.luggage.e.a.a.b(parami);
      }
      try
      {
        paramString.reset();
        label92:
        if (bool) {}
        for (parami = com.tencent.luggage.e.a.a.ft(com.tencent.luggage.e.a.a.f(paramString));; parami = "up")
        {
          localc.hha = parami;
          bo.b(paramString);
          parami = com.tencent.mm.vending.j.a.C(h.e.hSf, localc);
          AppMethodBeat.o(114360);
          return parami;
        }
        parami = com.tencent.mm.vending.j.a.cP(h.e.hSd);
        AppMethodBeat.o(114360);
        return parami;
      }
      catch (IOException parami)
      {
        break label92;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.h
 * JD-Core Version:    0.7.0.1
 */