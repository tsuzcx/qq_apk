package androidx.media;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AudioAttributesImplApi21
  implements AudioAttributesImpl
{
  AudioAttributes bJs;
  int bJt = -1;
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193038);
    if (!(paramObject instanceof AudioAttributesImplApi21))
    {
      AppMethodBeat.o(193038);
      return false;
    }
    paramObject = (AudioAttributesImplApi21)paramObject;
    boolean bool = this.bJs.equals(paramObject.bJs);
    AppMethodBeat.o(193038);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(193034);
    int i = this.bJs.hashCode();
    AppMethodBeat.o(193034);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(193046);
    String str = "AudioAttributesCompat: audioattributes=" + this.bJs;
    AppMethodBeat.o(193046);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.media.AudioAttributesImplApi21
 * JD-Core Version:    0.7.0.1
 */