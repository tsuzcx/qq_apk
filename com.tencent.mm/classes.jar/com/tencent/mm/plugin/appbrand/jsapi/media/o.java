package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/VideoMetaData;", "", "duration", "", "size", "width", "", "height", "(JJII)V", "getDuration", "()J", "getHeight", "()I", "getSize", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-appbrand-integration_release"})
public final class o
{
  public static final o.a hSO;
  final long duration;
  final int height;
  final long size;
  final int width;
  
  static
  {
    AppMethodBeat.i(143844);
    hSO = new o.a((byte)0);
    AppMethodBeat.o(143844);
  }
  
  public o(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.duration = paramLong1;
    this.size = paramLong2;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof o)) {
        break label107;
      }
      paramObject = (o)paramObject;
      if (this.duration != paramObject.duration) {
        break label109;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label107;
      }
      if (this.size != paramObject.size) {
        break label114;
      }
      i = 1;
      label58:
      bool1 = bool2;
      if (i == 0) {
        break label107;
      }
      if (this.width != paramObject.width) {
        break label119;
      }
      i = 1;
      label78:
      bool1 = bool2;
      if (i == 0) {
        break label107;
      }
      if (this.height != paramObject.height) {
        break label124;
      }
    }
    label107:
    label109:
    label114:
    label119:
    label124:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
      i = 0;
      break label58;
      i = 0;
      break label78;
    }
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
    AppMethodBeat.i(143845);
    String str = "VideoMetaData(duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + ")";
    AppMethodBeat.o(143845);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.o
 * JD-Core Version:    0.7.0.1
 */