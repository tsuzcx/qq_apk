package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "", "()V", "CANCELED", "Companion", "FAILED", "OK", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$FAILED;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;", "plugin-appbrand-integration_release"})
public abstract class b
{
  public static final b kwK = new b((byte)0);
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "()V", "plugin-appbrand-integration_release"})
  public static final class a
    extends b
  {
    public static final a kwL;
    
    static
    {
      AppMethodBeat.i(50514);
      kwL = new a();
      AppMethodBeat.o(50514);
    }
    
    private a()
    {
      super();
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$Companion;", "", "()V", "FROM_ALBUM", "", "FROM_CAMERA", "plugin-appbrand-integration_release"})
  public static final class b {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$FAILED;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class c
    extends b
  {
    final String message;
    
    public c(String paramString)
    {
      super();
      this.message = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(50517);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (!k.g(this.message, paramObject.message)) {}
        }
      }
      else
      {
        AppMethodBeat.o(50517);
        return true;
      }
      AppMethodBeat.o(50517);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(50516);
      String str = this.message;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(50516);
        return i;
      }
      AppMethodBeat.o(50516);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(50515);
      String str = "FAILED(message=" + this.message + ")";
      AppMethodBeat.o(50515);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "files", "", "Lcom/tencent/mm/vfs/VFSFile;", "from", "", "(Ljava/util/List;I)V", "getFiles", "()Ljava/util/List;", "getFrom", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
  public static final class d
    extends b
  {
    final int from;
    final List<e> kwM;
    
    public d(List<? extends e> paramList, int paramInt)
    {
      super();
      AppMethodBeat.i(50518);
      this.kwM = paramList;
      this.from = paramInt;
      AppMethodBeat.o(50518);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(50521);
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((!k.g(this.kwM, paramObject.kwM)) || (this.from != paramObject.from)) {}
        }
      }
      else
      {
        AppMethodBeat.o(50521);
        return true;
      }
      AppMethodBeat.o(50521);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(50520);
      List localList = this.kwM;
      if (localList != null) {}
      for (int i = localList.hashCode();; i = 0)
      {
        int j = this.from;
        AppMethodBeat.o(50520);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(50519);
      String str = "OK(files=" + this.kwM + ", from=" + this.from + ")";
      AppMethodBeat.o(50519);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.b
 * JD-Core Version:    0.7.0.1
 */