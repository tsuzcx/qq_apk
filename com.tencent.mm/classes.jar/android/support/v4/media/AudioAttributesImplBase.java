package android.support.v4.media;

import java.util.Arrays;

public final class AudioAttributesImplBase
  implements AudioAttributesImpl
{
  int CW = 0;
  int HP = 0;
  int HQ = 0;
  int HR = -1;
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesImplBase)) {}
    label110:
    label125:
    for (;;)
    {
      return false;
      paramObject = (AudioAttributesImplBase)paramObject;
      if (this.HQ == paramObject.HQ)
      {
        int m = this.CW;
        int k = paramObject.CW;
        int j;
        int i;
        if (paramObject.HR != -1)
        {
          j = paramObject.HR;
          if (j != 6) {
            break label110;
          }
          i = k | 0x4;
        }
        for (;;)
        {
          if ((m != (i & 0x111)) || (this.HP != paramObject.HP) || (this.HR != paramObject.HR)) {
            break label125;
          }
          return true;
          j = AudioAttributesCompat.r(paramObject.CW, paramObject.HP);
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
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.HQ), Integer.valueOf(this.CW), Integer.valueOf(this.HP), Integer.valueOf(this.HR) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AudioAttributesCompat:");
    if (this.HR != -1)
    {
      localStringBuilder.append(" stream=").append(this.HR);
      localStringBuilder.append(" derived");
    }
    localStringBuilder.append(" usage=").append(AudioAttributesCompat.ay(this.HP)).append(" content=").append(this.HQ).append(" flags=0x").append(Integer.toHexString(this.CW).toUpperCase());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.AudioAttributesImplBase
 * JD-Core Version:    0.7.0.1
 */