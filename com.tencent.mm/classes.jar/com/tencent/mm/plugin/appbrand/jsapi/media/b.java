package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "", "()V", "CANCELED", "Companion", "FAILED", "OK", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$FAILED;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  public static final b sfb = new b((byte)0);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "()V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends b
  {
    public static final a sfc;
    
    static
    {
      AppMethodBeat.i(50514);
      sfc = new a();
      AppMethodBeat.o(50514);
    }
    
    private a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$Companion;", "", "()V", "FROM_ALBUM", "", "FROM_CAMERA", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$FAILED;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      if (this == paramObject)
      {
        AppMethodBeat.o(50517);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(50517);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.message, paramObject.message))
      {
        AppMethodBeat.o(50517);
        return false;
      }
      AppMethodBeat.o(50517);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(50516);
      if (this.message == null)
      {
        AppMethodBeat.o(50516);
        return 0;
      }
      int i = this.message.hashCode();
      AppMethodBeat.o(50516);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(50515);
      String str = "FAILED(message=" + this.message + ')';
      AppMethodBeat.o(50515);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "files", "", "Lcom/tencent/mm/vfs/VFSFile;", "from", "", "(Ljava/util/List;I)V", "getFiles", "()Ljava/util/List;", "getFrom", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends b
  {
    final int from;
    final List<u> sfd;
    
    public d(List<? extends u> paramList, int paramInt)
    {
      super();
      AppMethodBeat.i(50518);
      this.sfd = paramList;
      this.from = paramInt;
      AppMethodBeat.o(50518);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(50521);
      if (this == paramObject)
      {
        AppMethodBeat.o(50521);
        return true;
      }
      if (!(paramObject instanceof d))
      {
        AppMethodBeat.o(50521);
        return false;
      }
      paramObject = (d)paramObject;
      if (!s.p(this.sfd, paramObject.sfd))
      {
        AppMethodBeat.o(50521);
        return false;
      }
      if (this.from != paramObject.from)
      {
        AppMethodBeat.o(50521);
        return false;
      }
      AppMethodBeat.o(50521);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(50520);
      int i = this.sfd.hashCode();
      int j = this.from;
      AppMethodBeat.o(50520);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(50519);
      String str = "OK(files=" + this.sfd + ", from=" + this.from + ')';
      AppMethodBeat.o(50519);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.b
 * JD-Core Version:    0.7.0.1
 */