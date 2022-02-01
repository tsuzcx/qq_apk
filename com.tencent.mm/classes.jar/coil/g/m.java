package coil.g;

import coil.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import j.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/fetch/SourceResult;", "Lcoil/fetch/FetchResult;", "source", "Lokio/BufferedSource;", "mimeType", "", "dataSource", "Lcoil/decode/DataSource;", "(Lokio/BufferedSource;Ljava/lang/String;Lcoil/decode/DataSource;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getMimeType", "()Ljava/lang/String;", "getSource", "()Lokio/BufferedSource;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends f
{
  public final b cnH;
  public final h cnO;
  public final String mimeType;
  
  public m(h paramh, String paramString, b paramb)
  {
    super((byte)0);
    AppMethodBeat.i(188329);
    this.cnO = paramh;
    this.mimeType = paramString;
    this.cnH = paramb;
    AppMethodBeat.o(188329);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188369);
    if (this == paramObject)
    {
      AppMethodBeat.o(188369);
      return true;
    }
    if (!(paramObject instanceof m))
    {
      AppMethodBeat.o(188369);
      return false;
    }
    paramObject = (m)paramObject;
    if (!s.p(this.cnO, paramObject.cnO))
    {
      AppMethodBeat.o(188369);
      return false;
    }
    if (!s.p(this.mimeType, paramObject.mimeType))
    {
      AppMethodBeat.o(188369);
      return false;
    }
    if (this.cnH != paramObject.cnH)
    {
      AppMethodBeat.o(188369);
      return false;
    }
    AppMethodBeat.o(188369);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188356);
    int j = this.cnO.hashCode();
    if (this.mimeType == null) {}
    for (int i = 0;; i = this.mimeType.hashCode())
    {
      int k = this.cnH.hashCode();
      AppMethodBeat.o(188356);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188341);
    String str = "SourceResult(source=" + this.cnO + ", mimeType=" + this.mimeType + ", dataSource=" + this.cnH + ')';
    AppMethodBeat.o(188341);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.g.m
 * JD-Core Version:    0.7.0.1
 */