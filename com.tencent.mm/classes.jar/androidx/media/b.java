package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(21)
class b
  implements a
{
  AudioAttributes abJ;
  int abK = -1;
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(242712);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(242712);
      return false;
    }
    paramObject = (b)paramObject;
    boolean bool = this.abJ.equals(paramObject.abJ);
    AppMethodBeat.o(242712);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(242710);
    int i = this.abJ.hashCode();
    AppMethodBeat.o(242710);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(242714);
    String str = "AudioAttributesCompat: audioattributes=" + this.abJ;
    AppMethodBeat.o(242714);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.media.b
 * JD-Core Version:    0.7.0.1
 */