package com.tencent.mm.media.camera.a;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/analyse/CameraRenderAnalyse;", "", "()V", "availableAnalyse", "Lcom/tencent/mm/media/camera/analyse/CameraRenderAnalyse$CameraAnalyseStruct;", "lastAvailableTimeStamp", "", "realTimeAverage", "frameAvailable", "", "getDebugInfo", "", "CameraAnalyseStruct", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b nuf;
  long nug;
  a nuh;
  long nui;
  
  static
  {
    AppMethodBeat.i(237308);
    nuf = new b((byte)0);
    AppMethodBeat.o(237308);
  }
  
  public b()
  {
    AppMethodBeat.i(237303);
    this.nug = System.currentTimeMillis();
    b.a.a locala = a.nuj;
    this.nuh = new a(System.currentTimeMillis(), "available", (byte)0);
    AppMethodBeat.o(237303);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/analyse/CameraRenderAnalyse$CameraAnalyseStruct;", "", "startTime", "", "count", "interval", "tag", "", "average", "(JJJLjava/lang/String;J)V", "getCount", "()J", "setCount", "(J)V", "getInterval", "setInterval", "getStartTime", "setStartTime", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "getAverage", "hashCode", "", "reset", "", "toString", "trigger", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a nuj;
    long count;
    long interval;
    long nuk;
    long startTime;
    String tag;
    
    static
    {
      AppMethodBeat.i(237314);
      nuj = new a((byte)0);
      AppMethodBeat.o(237314);
    }
    
    private a(long paramLong, String paramString)
    {
      this.startTime = paramLong;
      this.count = 0L;
      this.interval = 1000L;
      this.tag = paramString;
      this.nuk = 0L;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(237330);
      if (this == paramObject)
      {
        AppMethodBeat.o(237330);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(237330);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.startTime != paramObject.startTime)
      {
        AppMethodBeat.o(237330);
        return false;
      }
      if (this.count != paramObject.count)
      {
        AppMethodBeat.o(237330);
        return false;
      }
      if (this.interval != paramObject.interval)
      {
        AppMethodBeat.o(237330);
        return false;
      }
      if (!s.p(this.tag, paramObject.tag))
      {
        AppMethodBeat.o(237330);
        return false;
      }
      if (this.nuk != paramObject.nuk)
      {
        AppMethodBeat.o(237330);
        return false;
      }
      AppMethodBeat.o(237330);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(237323);
      int j = q.a..ExternalSyntheticBackport0.m(this.startTime);
      int k = q.a..ExternalSyntheticBackport0.m(this.count);
      int m = q.a..ExternalSyntheticBackport0.m(this.interval);
      if (this.tag == null) {}
      for (int i = 0;; i = this.tag.hashCode())
      {
        int n = q.a..ExternalSyntheticBackport0.m(this.nuk);
        AppMethodBeat.o(237323);
        return (i + ((j * 31 + k) * 31 + m) * 31) * 31 + n;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(237318);
      String str = "CameraAnalyseStruct(startTime=" + this.startTime + ", count=" + this.count + ", interval=" + this.interval + ", tag=" + this.tag + ", average=" + this.nuk + ')';
      AppMethodBeat.o(237318);
      return str;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/analyse/CameraRenderAnalyse$CameraAnalyseStruct$Companion;", "", "()V", "averageAnalyseStruct", "Lcom/tencent/mm/media/camera/analyse/CameraRenderAnalyse$CameraAnalyseStruct;", "tag", "", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/analyse/CameraRenderAnalyse$Companion;", "", "()V", "TAG", "", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.camera.a.b
 * JD-Core Version:    0.7.0.1
 */