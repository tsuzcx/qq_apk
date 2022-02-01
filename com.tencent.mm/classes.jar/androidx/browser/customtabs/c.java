package androidx.browser.customtabs;

import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  final android.support.a.a zw;
  private final a zx;
  
  c(android.support.a.a parama)
  {
    AppMethodBeat.i(192986);
    this.zw = parama;
    this.zx = new a() {};
    AppMethodBeat.o(192986);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193003);
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(193003);
      return false;
    }
    boolean bool = ((c)paramObject).fR().equals(this.zw.asBinder());
    AppMethodBeat.o(193003);
    return bool;
  }
  
  final IBinder fR()
  {
    AppMethodBeat.i(192991);
    IBinder localIBinder = this.zw.asBinder();
    AppMethodBeat.o(192991);
    return localIBinder;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(192996);
    int i = fR().hashCode();
    AppMethodBeat.o(192996);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.browser.customtabs.c
 * JD-Core Version:    0.7.0.1
 */