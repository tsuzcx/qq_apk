package android.support.v4.media;

import java.util.Arrays;

public final class AudioAttributesImplBase
  implements AudioAttributesImpl
{
  int FL = 0;
  int KD = 0;
  int KE = 0;
  int KF = -1;
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesImplBase)) {}
    label110:
    label125:
    for (;;)
    {
      return false;
      paramObject = (AudioAttributesImplBase)paramObject;
      if (this.KE == paramObject.KE)
      {
        int m = this.FL;
        int k = paramObject.FL;
        int j;
        int i;
        if (paramObject.KF != -1)
        {
          j = paramObject.KF;
          if (j != 6) {
            break label110;
          }
          i = k | 0x4;
        }
        for (;;)
        {
          if ((m != (i & 0x111)) || (this.KD != paramObject.KD) || (this.KF != paramObject.KF)) {
            break label125;
          }
          return true;
          j = AudioAttributesCompat.y(paramObject.FL, paramObject.KD);
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
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.KE), Integer.valueOf(this.FL), Integer.valueOf(this.KD), Integer.valueOf(this.KF) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AudioAttributesCompat:");
    if (this.KF != -1)
    {
      localStringBuilder.append(" stream=").append(this.KF);
      localStringBuilder.append(" derived");
    }
    localStringBuilder.append(" usage=").append(AudioAttributesCompat.ay(this.KD)).append(" content=").append(this.KE).append(" flags=0x").append(Integer.toHexString(this.FL).toUpperCase());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.AudioAttributesImplBase
 * JD-Core Version:    0.7.0.1
 */