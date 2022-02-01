package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "", "data", "", "type", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSize", "getType", "isEmpty", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$b
{
  final String data;
  final String qMq;
  final String type;
  
  public l$b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147863);
    this.data = paramString1;
    this.type = paramString2;
    this.qMq = paramString3;
    AppMethodBeat.o(147863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.l.b
 * JD-Core Version:    0.7.0.1
 */