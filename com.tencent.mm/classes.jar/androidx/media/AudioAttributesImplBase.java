package androidx.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

class AudioAttributesImplBase
  implements AudioAttributesImpl
{
  int bJu = 0;
  int bJv = 0;
  int bJw = -1;
  int cN = 0;
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193030);
    if (!(paramObject instanceof AudioAttributesImplBase))
    {
      AppMethodBeat.o(193030);
      return false;
    }
    paramObject = (AudioAttributesImplBase)paramObject;
    if (this.bJv == paramObject.bJv)
    {
      int m = this.cN;
      int k = paramObject.cN;
      int j;
      int i;
      if (paramObject.bJw != -1)
      {
        j = paramObject.bJw;
        if (j != 6) {
          break label125;
        }
        i = k | 0x4;
      }
      for (;;)
      {
        if ((m != (i & 0x111)) || (this.bJu != paramObject.bJu) || (this.bJw != paramObject.bJw)) {
          break label142;
        }
        AppMethodBeat.o(193030);
        return true;
        j = AudioAttributesCompat.aQ(paramObject.cN, paramObject.bJu);
        break;
        label125:
        i = k;
        if (j == 7) {
          i = k | 0x1;
        }
      }
    }
    label142:
    AppMethodBeat.o(193030);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(193023);
    int i = Arrays.hashCode(new Object[] { Integer.valueOf(this.bJv), Integer.valueOf(this.cN), Integer.valueOf(this.bJu), Integer.valueOf(this.bJw) });
    AppMethodBeat.o(193023);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(193035);
    Object localObject = new StringBuilder("AudioAttributesCompat:");
    if (this.bJw != -1)
    {
      ((StringBuilder)localObject).append(" stream=").append(this.bJw);
      ((StringBuilder)localObject).append(" derived");
    }
    ((StringBuilder)localObject).append(" usage=").append(AudioAttributesCompat.fb(this.bJu)).append(" content=").append(this.bJv).append(" flags=0x").append(Integer.toHexString(this.cN).toUpperCase());
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(193035);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.media.AudioAttributesImplBase
 * JD-Core Version:    0.7.0.1
 */