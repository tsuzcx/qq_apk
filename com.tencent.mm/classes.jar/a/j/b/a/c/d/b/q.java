package a.j.b.a.c.d.b;

import a.f.b.j;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.b.a.f;
import a.j.b.a.c.e.b.a.f.a;
import a.j.b.a.c.e.b.a.f.b;
import a.j.b.a.c.e.b.b.c;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static final a Cjw;
  final String signature;
  
  static
  {
    AppMethodBeat.i(120296);
    Cjw = new a((byte)0);
    AppMethodBeat.o(120296);
  }
  
  private q(String paramString)
  {
    this.signature = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(120299);
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if (!j.e(this.signature, paramObject.signature)) {}
      }
    }
    else
    {
      AppMethodBeat.o(120299);
      return true;
    }
    AppMethodBeat.o(120299);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(120298);
    String str = this.signature;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(120298);
      return i;
    }
    AppMethodBeat.o(120298);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120297);
    String str = "MemberSignature(signature=" + this.signature + ")";
    AppMethodBeat.o(120297);
    return str;
  }
  
  public static final class a
  {
    public static q a(q paramq, int paramInt)
    {
      AppMethodBeat.i(120295);
      j.q(paramq, "signature");
      paramq = new q(paramq.signature + "@" + paramInt, (byte)0);
      AppMethodBeat.o(120295);
      return paramq;
    }
    
    public static q a(c paramc, b.c paramc1)
    {
      AppMethodBeat.i(120291);
      j.q(paramc, "nameResolver");
      j.q(paramc1, "signature");
      paramc = jo(paramc.getString(paramc1.ClT), paramc.getString(paramc1.CpB));
      AppMethodBeat.o(120291);
      return paramc;
    }
    
    public static q a(f paramf)
    {
      AppMethodBeat.i(120294);
      j.q(paramf, "signature");
      if ((paramf instanceof f.b))
      {
        paramf = jo(paramf.getName(), paramf.getDesc());
        AppMethodBeat.o(120294);
        return paramf;
      }
      if ((paramf instanceof f.a))
      {
        paramf = jp(paramf.getName(), paramf.getDesc());
        AppMethodBeat.o(120294);
        return paramf;
      }
      paramf = new m();
      AppMethodBeat.o(120294);
      throw paramf;
    }
    
    public static q jo(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120292);
      j.q(paramString1, "name");
      j.q(paramString2, "desc");
      paramString1 = new q(paramString1 + paramString2, (byte)0);
      AppMethodBeat.o(120292);
      return paramString1;
    }
    
    public static q jp(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120293);
      j.q(paramString1, "name");
      j.q(paramString2, "desc");
      paramString1 = new q(paramString1 + "#" + paramString2, (byte)0);
      AppMethodBeat.o(120293);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.b.q
 * JD-Core Version:    0.7.0.1
 */