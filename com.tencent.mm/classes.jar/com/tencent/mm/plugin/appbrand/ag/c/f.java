package com.tencent.mm.plugin.appbrand.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/TPDownloadStrategy;", "", "flattenVal", "", "(Ljava/lang/String;II)V", "NOT_PROXY", "PROXY_DEFAULT", "PROXY_CDN", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum f
{
  public static final a uts;
  private final int rht;
  
  static
  {
    AppMethodBeat.i(317883);
    utt = new f("NOT_PROXY", 0, 0);
    utu = new f("PROXY_DEFAULT", 1, 1);
    utv = new f("PROXY_CDN", 2, 2);
    utw = new f[] { utt, utu, utv };
    uts = new a((byte)0);
    AppMethodBeat.o(317883);
  }
  
  private f(int paramInt)
  {
    this.rht = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/TPDownloadStrategy$Companion;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/appbrand/video/thumb/TPDownloadStrategy;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.f
 * JD-Core Version:    0.7.0.1
 */