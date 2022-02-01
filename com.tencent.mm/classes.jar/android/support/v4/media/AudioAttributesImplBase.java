package android.support.v4.media;

import java.util.Arrays;

public final class AudioAttributesImplBase
  implements AudioAttributesImpl
{
  int FV = 0;
  int KN = 0;
  int KO = 0;
  int KP = -1;
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesImplBase)) {}
    label110:
    label125:
    for (;;)
    {
      return false;
      paramObject = (AudioAttributesImplBase)paramObject;
      if (this.KO == paramObject.KO)
      {
        int m = this.FV;
        int k = paramObject.FV;
        int j;
        int i;
        if (paramObject.KP != -1)
        {
          j = paramObject.KP;
          if (j != 6) {
            break label110;
          }
          i = k | 0x4;
        }
        for (;;)
        {
          if ((m != (i & 0x111)) || (this.KN != paramObject.KN) || (this.KP != paramObject.KP)) {
            break label125;
          }
          return true;
          j = AudioAttributesCompat.y(paramObject.FV, paramObject.KN);
          break;
          i = k;
          if (j == 7) {
            i = k | 0x1;
          }
        }
      }
    }
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.KO), Integer.valueOf(this.FV), Integer.valueOf(this.KN), Integer.valueOf(this.KP) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AudioAttributesCompat:");
    if (this.KP != -1)
    {
      localStringBuilder.append(" stream=").append(this.KP);
      localStringBuilder.append(" derived");
    }
    localStringBuilder.append(" usage=").append(AudioAttributesCompat.ay(this.KN)).append(" content=").append(this.KO).append(" flags=0x").append(Integer.toHexString(this.FV).toUpperCase());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.AudioAttributesImplBase
 * JD-Core Version:    0.7.0.1
 */