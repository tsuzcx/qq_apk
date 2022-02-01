package androidx.camera.camera2.b;

import android.util.Size;
import androidx.camera.core.impl.bb;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends h.e
{
  private final String zN;
  private final Class<?> zO;
  private final bb zP;
  private final Size zQ;
  
  b(String paramString, Class<?> paramClass, bb parambb, Size paramSize)
  {
    AppMethodBeat.i(197636);
    if (paramString == null)
    {
      paramString = new NullPointerException("Null useCaseId");
      AppMethodBeat.o(197636);
      throw paramString;
    }
    this.zN = paramString;
    if (paramClass == null)
    {
      paramString = new NullPointerException("Null useCaseType");
      AppMethodBeat.o(197636);
      throw paramString;
    }
    this.zO = paramClass;
    if (parambb == null)
    {
      paramString = new NullPointerException("Null sessionConfig");
      AppMethodBeat.o(197636);
      throw paramString;
    }
    this.zP = parambb;
    this.zQ = paramSize;
    AppMethodBeat.o(197636);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197680);
    if (paramObject == this)
    {
      AppMethodBeat.o(197680);
      return true;
    }
    if ((paramObject instanceof h.e))
    {
      paramObject = (h.e)paramObject;
      if ((this.zN.equals(paramObject.gf())) && (this.zO.equals(paramObject.gg())) && (this.zP.equals(paramObject.gh()))) {
        if (this.zQ == null)
        {
          if (paramObject.gi() != null) {}
        }
        else {
          while (this.zQ.equals(paramObject.gi()))
          {
            AppMethodBeat.o(197680);
            return true;
          }
        }
      }
      AppMethodBeat.o(197680);
      return false;
    }
    AppMethodBeat.o(197680);
    return false;
  }
  
  final String gf()
  {
    return this.zN;
  }
  
  final Class<?> gg()
  {
    return this.zO;
  }
  
  final bb gh()
  {
    return this.zP;
  }
  
  final Size gi()
  {
    return this.zQ;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(197685);
    int j = this.zN.hashCode();
    int k = this.zO.hashCode();
    int m = this.zP.hashCode();
    if (this.zQ == null) {}
    for (int i = 0;; i = this.zQ.hashCode())
    {
      AppMethodBeat.o(197685);
      return i ^ (((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197674);
    String str = "UseCaseInfo{useCaseId=" + this.zN + ", useCaseType=" + this.zO + ", sessionConfig=" + this.zP + ", surfaceResolution=" + this.zQ + "}";
    AppMethodBeat.o(197674);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.b
 * JD-Core Version:    0.7.0.1
 */