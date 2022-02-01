package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
public final class AudioAttributesImplApi21
  implements AudioAttributesImpl
{
  AudioAttributes HN;
  int HO = -1;
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesImplApi21)) {
      return false;
    }
    paramObject = (AudioAttributesImplApi21)paramObject;
    return this.HN.equals(paramObject.HN);
  }
  
  public final int hashCode()
  {
    return this.HN.hashCode();
  }
  
  public final String toString()
  {
    return "AudioAttributesCompat: audioattributes=" + this.HN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.AudioAttributesImplApi21
 * JD-Core Version:    0.7.0.1
 */