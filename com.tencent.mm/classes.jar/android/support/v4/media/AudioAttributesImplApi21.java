package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
public final class AudioAttributesImplApi21
  implements AudioAttributesImpl
{
  AudioAttributes KL;
  int KM = -1;
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesImplApi21)) {
      return false;
    }
    paramObject = (AudioAttributesImplApi21)paramObject;
    return this.KL.equals(paramObject.KL);
  }
  
  public final int hashCode()
  {
    return this.KL.hashCode();
  }
  
  public final String toString()
  {
    return "AudioAttributesCompat: audioattributes=" + this.KL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.AudioAttributesImplApi21
 * JD-Core Version:    0.7.0.1
 */