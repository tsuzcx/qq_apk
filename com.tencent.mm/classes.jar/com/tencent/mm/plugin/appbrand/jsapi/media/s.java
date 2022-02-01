package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData;", "", "duration", "", "size", "width", "", "height", "(JJII)V", "getDuration", "()J", "getHeight", "()I", "getSize", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-appbrand-integration_release"})
public final class s
{
  public static final a jYS;
  final long duration;
  final int height;
  final long size;
  final int width;
  
  static
  {
    AppMethodBeat.i(50581);
    jYS = new a((byte)0);
    AppMethodBeat.o(50581);
  }
  
  public s(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.duration = paramLong1;
    this.size = paramLong2;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof s))
      {
        paramObject = (s)paramObject;
        if ((this.duration != paramObject.duration) || (this.size != paramObject.size) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.duration;
    int i = (int)(l ^ l >>> 32);
    l = this.size;
    return ((i * 31 + (int)(l ^ l >>> 32)) * 31 + this.width) * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50582);
    String str = "VideoMetaData(duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + ")";
    AppMethodBeat.o(50582);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData$Companion;", "", "()V", "TAG", "", "obtain", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData;", "path", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static s IH(String paramString)
    {
      AppMethodBeat.i(50580);
      k.h(paramString, "path");
      if (!i.eK(paramString))
      {
        AppMethodBeat.o(50580);
        return null;
      }
      for (;;)
      {
        d locald;
        try
        {
          locald = new d();
          locald.setDataSource(paramString);
          i = bt.getInt(locald.extractMetadata(24), 0);
          if ((i == 90) || (i == 270))
          {
            i = bt.getInt(locald.extractMetadata(19), 0);
            j = bt.getInt(locald.extractMetadata(18), 0);
            long l = bt.getLong(locald.extractMetadata(9), 0L);
            locald.release();
            paramString = new s(l, i.aMN(paramString), i, j);
            AppMethodBeat.o(50580);
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.VideoMetaData", "MetaDataRetriever failed, e = ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(50580);
          return null;
        }
        int i = bt.getInt(locald.extractMetadata(18), 0);
        int j = bt.getInt(locald.extractMetadata(19), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.s
 * JD-Core Version:    0.7.0.1
 */