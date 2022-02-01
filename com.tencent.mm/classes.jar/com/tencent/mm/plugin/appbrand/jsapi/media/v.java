package com.tencent.mm.plugin.appbrand.jsapi.media;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData;", "", "duration", "", "size", "width", "", "height", "(JJII)V", "getDuration", "()J", "getHeight", "()I", "getSize", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final a shR;
  final long duration;
  final int height;
  final long size;
  final int width;
  
  static
  {
    AppMethodBeat.i(50581);
    shR = new a((byte)0);
    AppMethodBeat.o(50581);
  }
  
  public v(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.duration = paramLong1;
    this.size = paramLong2;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof v)) {
        return false;
      }
      paramObject = (v)paramObject;
      if (this.duration != paramObject.duration) {
        return false;
      }
      if (this.size != paramObject.size) {
        return false;
      }
      if (this.width != paramObject.width) {
        return false;
      }
    } while (this.height == paramObject.height);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(329326);
    int i = q.a..ExternalSyntheticBackport0.m(this.duration);
    int j = q.a..ExternalSyntheticBackport0.m(this.size);
    int k = this.width;
    int m = this.height;
    AppMethodBeat.o(329326);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50582);
    String str = "VideoMetaData(duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + ')';
    AppMethodBeat.o(50582);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData$Companion;", "", "()V", "TAG", "", "obtain", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData;", "path", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static v abf(String paramString)
    {
      AppMethodBeat.i(50580);
      s.u(paramString, "path");
      if (!y.ZC(paramString))
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
          switch (Util.getInt(locald.extractMetadata(24), 0))
          {
          case 90: 
            i = Util.getInt(locald.extractMetadata(18), 0);
            j = Util.getInt(locald.extractMetadata(19), 0);
            long l = Util.getLong(locald.extractMetadata(9), 0L);
            locald.release();
            paramString = new v(l, y.bEl(paramString), i, j);
            AppMethodBeat.o(50580);
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.VideoMetaData", s.X("MetaDataRetriever failed, e = ", paramString));
          AppMethodBeat.o(50580);
          return null;
        }
        int i = Util.getInt(locald.extractMetadata(19), 0);
        int j = Util.getInt(locald.extractMetadata(18), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.v
 * JD-Core Version:    0.7.0.1
 */