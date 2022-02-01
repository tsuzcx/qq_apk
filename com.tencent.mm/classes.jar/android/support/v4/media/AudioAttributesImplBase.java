package android.support.v4.media;

import java.util.Arrays;

public final class AudioAttributesImplBase
  implements AudioAttributesImpl
{
  int DU = 0;
  int IM = 0;
  int IN = 0;
  int IP = -1;
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesImplBase)) {}
    label110:
    label125:
    for (;;)
    {
      return false;
      paramObject = (AudioAttributesImplBase)paramObject;
      if (this.IN == paramObject.IN)
      {
        int m = this.DU;
        int k = paramObject.DU;
        int j;
        int i;
        if (paramObject.IP != -1)
        {
          j = paramObject.IP;
          if (j != 6) {
            break label110;
          }
          i = k | 0x4;
        }
        for (;;)
        {
          if ((m != (i & 0x111)) || (this.IM != paramObject.IM) || (this.IP != paramObject.IP)) {
            break label125;
          }
          return true;
          j = AudioAttributesCompat.r(paramObject.DU, paramObject.IM);
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
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.IN), Integer.valueOf(this.DU), Integer.valueOf(this.IM), Integer.valueOf(this.IP) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AudioAttributesCompat:");
    if (this.IP != -1)
    {
      localStringBuilder.append(" stream=").append(this.IP);
      localStringBuilder.append(" derived");
    }
    localStringBuilder.append(" usage=").append(AudioAttributesCompat.ay(this.IM)).append(" content=").append(this.IN).append(" flags=0x").append(Integer.toHexString(this.DU).toUpperCase());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.media.AudioAttributesImplBase
 * JD-Core Version:    0.7.0.1
 */