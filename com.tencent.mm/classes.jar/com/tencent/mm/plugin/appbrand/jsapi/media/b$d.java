package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "files", "", "Ljava/io/File;", "from", "", "(Ljava/util/List;I)V", "getFiles", "()Ljava/util/List;", "getFrom", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
public final class b$d
  extends b
{
  final int from;
  final List<File> hQl;
  
  public b$d(List<? extends File> paramList, int paramInt)
  {
    super((byte)0);
    AppMethodBeat.i(143782);
    this.hQl = paramList;
    this.from = paramInt;
    AppMethodBeat.o(143782);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(143785);
    if (this != paramObject)
    {
      if (!(paramObject instanceof d)) {
        break label65;
      }
      paramObject = (d)paramObject;
      if (!j.e(this.hQl, paramObject.hQl)) {
        break label65;
      }
      if (this.from != paramObject.from) {
        break label60;
      }
    }
    label60:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(143785);
      return true;
    }
    label65:
    AppMethodBeat.o(143785);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(143784);
    List localList = this.hQl;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      int j = this.from;
      AppMethodBeat.o(143784);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(143783);
    String str = "OK(files=" + this.hQl + ", from=" + this.from + ")";
    AppMethodBeat.o(143783);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.b.d
 * JD-Core Version:    0.7.0.1
 */