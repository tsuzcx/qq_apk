package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/OpenMaterialMimeTypeWhiteList;", "", "()V", "mimeTypeStrWhiteList", "", "", "[Ljava/lang/String;", "mimeTypeWhiteList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/MimeType;", "Lkotlin/collections/ArrayList;", "contains", "", "mimeTypeStr", "plugin-appbrand-integration_release"})
public final class d
{
  private static final String[] nlw;
  private static final ArrayList<c> nlx;
  public static final d nly;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(229153);
    nly = new d();
    nlw = new String[] { "text/html", "image/*", "audio/*", "video/*", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.ms-word.document.macroEnabled.12", "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.ms-excel.sheet.macroEnabled.12", "application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/wps-office.wps", "application/wps-office.et", "text/plain", "text/csv", "application/pdf", "application/zip", "application/vnd.rar", "application/x-7z-compressed", "application/x-photoshop", "application/acad", "application/x-cdr", "application/dxf", "application/step", "application/rtf", "application/postscript" };
    nlx = new ArrayList();
    String[] arrayOfString = nlw;
    int j = arrayOfString.length;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      c.a locala = c.nlu;
      localObject = c.a.adm((String)localObject);
      if (localObject != null) {
        nlx.add(localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(229153);
  }
  
  public static boolean contains(String paramString)
  {
    AppMethodBeat.i(229152);
    p.h(paramString, "mimeTypeStr");
    Object localObject = c.nlu;
    paramString = c.a.adm(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(229152);
      return false;
    }
    localObject = (Iterable)nlx;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        p.h(paramString, "mimeType");
        if ((p.j(localc.type, paramString.type)) && ((p.j(localc.nls, paramString.nls)) || (localc.bQf()))) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(229152);
          return true;
        }
      }
    }
    AppMethodBeat.o(229152);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.d
 * JD-Core Version:    0.7.0.1
 */