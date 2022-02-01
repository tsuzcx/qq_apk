package androidx.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

class c
  implements a
{
  int abL = 0;
  int abM = 0;
  int abN = -1;
  int cN = 0;
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(242724);
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(242724);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.abM == paramObject.abM)
    {
      int m = this.cN;
      int k = paramObject.cN;
      int j;
      int i;
      if (paramObject.abN != -1)
      {
        j = paramObject.abN;
        if (j != 6) {
          break label125;
        }
        i = k | 0x4;
      }
      for (;;)
      {
        if ((m != (i & 0x111)) || (this.abL != paramObject.abL) || (this.abN != paramObject.abN)) {
          break label142;
        }
        AppMethodBeat.o(242724);
        return true;
        j = AudioAttributesCompat.V(paramObject.cN, paramObject.abL);
        break;
        label125:
        i = k;
        if (j == 7) {
          i = k | 0x1;
        }
      }
    }
    label142:
    AppMethodBeat.o(242724);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(242722);
    int i = Arrays.hashCode(new Object[] { Integer.valueOf(this.abM), Integer.valueOf(this.cN), Integer.valueOf(this.abL), Integer.valueOf(this.abN) });
    AppMethodBeat.o(242722);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(242726);
    Object localObject = new StringBuilder("AudioAttributesCompat:");
    if (this.abN != -1)
    {
      ((StringBuilder)localObject).append(" stream=").append(this.abN);
      ((StringBuilder)localObject).append(" derived");
    }
    ((StringBuilder)localObject).append(" usage=").append(AudioAttributesCompat.cf(this.abL)).append(" content=").append(this.abM).append(" flags=0x").append(Integer.toHexString(this.cN).toUpperCase());
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(242726);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.media.c
 * JD-Core Version:    0.7.0.1
 */