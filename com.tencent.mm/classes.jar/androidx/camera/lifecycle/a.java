package androidx.camera.lifecycle;

import androidx.camera.core.a.c.b;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  extends LifecycleCameraRepository.a
{
  private final c.b QF;
  private final q lifecycleOwner;
  
  a(q paramq, c.b paramb)
  {
    AppMethodBeat.i(197242);
    if (paramq == null)
    {
      paramq = new NullPointerException("Null lifecycleOwner");
      AppMethodBeat.o(197242);
      throw paramq;
    }
    this.lifecycleOwner = paramq;
    if (paramb == null)
    {
      paramq = new NullPointerException("Null cameraId");
      AppMethodBeat.o(197242);
      throw paramq;
    }
    this.QF = paramb;
    AppMethodBeat.o(197242);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197259);
    if (paramObject == this)
    {
      AppMethodBeat.o(197259);
      return true;
    }
    if ((paramObject instanceof LifecycleCameraRepository.a))
    {
      paramObject = (LifecycleCameraRepository.a)paramObject;
      if ((this.lifecycleOwner.equals(paramObject.getLifecycleOwner())) && (this.QF.equals(paramObject.la())))
      {
        AppMethodBeat.o(197259);
        return true;
      }
      AppMethodBeat.o(197259);
      return false;
    }
    AppMethodBeat.o(197259);
    return false;
  }
  
  public final q getLifecycleOwner()
  {
    return this.lifecycleOwner;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(197266);
    int i = this.lifecycleOwner.hashCode();
    int j = this.QF.hashCode();
    AppMethodBeat.o(197266);
    return (i ^ 0xF4243) * 1000003 ^ j;
  }
  
  public final c.b la()
  {
    return this.QF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197254);
    String str = "Key{lifecycleOwner=" + this.lifecycleOwner + ", cameraId=" + this.QF + "}";
    AppMethodBeat.o(197254);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.lifecycle.a
 * JD-Core Version:    0.7.0.1
 */