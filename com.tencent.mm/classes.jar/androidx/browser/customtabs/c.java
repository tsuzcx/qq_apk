package androidx.browser.customtabs;

import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  final android.support.a.a yA;
  private final a yB;
  
  c(android.support.a.a parama)
  {
    AppMethodBeat.i(191324);
    this.yA = parama;
    this.yB = new a() {};
    AppMethodBeat.o(191324);
  }
  
  final IBinder eU()
  {
    AppMethodBeat.i(191325);
    IBinder localIBinder = this.yA.asBinder();
    AppMethodBeat.o(191325);
    return localIBinder;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191331);
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(191331);
      return false;
    }
    boolean bool = ((c)paramObject).eU().equals(this.yA.asBinder());
    AppMethodBeat.o(191331);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191328);
    int i = eU().hashCode();
    AppMethodBeat.o(191328);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.browser.customtabs.c
 * JD-Core Version:    0.7.0.1
 */