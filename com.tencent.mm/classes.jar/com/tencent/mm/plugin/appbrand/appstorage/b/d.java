package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/LegacyFolder;", "", "dir", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDir", "()Ljava/lang/String;", "imagecache", "wxafiles", "wxanewfiles", "plugin-appbrand-integration_release"})
public enum d
{
  public final String jub;
  
  static
  {
    AppMethodBeat.i(175124);
    d locald1 = new d("imagecache", 0, "wxacache");
    jtX = locald1;
    d locald2 = new d("wxafiles", 1, "wxafiles");
    jtY = locald2;
    d locald3 = new d("wxanewfiles", 2, "wxanewfiles");
    jtZ = locald3;
    jua = new d[] { locald1, locald2, locald3 };
    AppMethodBeat.o(175124);
  }
  
  private d(String paramString)
  {
    this.jub = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.d
 * JD-Core Version:    0.7.0.1
 */