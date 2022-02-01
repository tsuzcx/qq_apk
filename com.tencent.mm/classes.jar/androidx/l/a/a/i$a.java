package androidx.l.a.a;

import android.content.res.TypedArray;
import androidx.core.graphics.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$a
  extends i.e
{
  public i$a() {}
  
  public i$a(a parama)
  {
    super(parama);
  }
  
  public final boolean Mg()
  {
    return true;
  }
  
  final void b(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(192656);
    String str = paramTypedArray.getString(0);
    if (str != null) {
      this.ciZ = str;
    }
    paramTypedArray = paramTypedArray.getString(1);
    if (paramTypedArray != null) {
      this.ciY = d.av(paramTypedArray);
    }
    AppMethodBeat.o(192656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.l.a.a.i.a
 * JD-Core Version:    0.7.0.1
 */