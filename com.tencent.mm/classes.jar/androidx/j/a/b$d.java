package androidx.j.a;

import android.graphics.Color;
import androidx.core.graphics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class b$d
{
  final int bSR;
  private final int bTm;
  private final int bTn;
  private final int bTo;
  public final int bTp;
  private boolean bTq;
  private int bTr;
  private float[] bTs;
  private int xR;
  
  public b$d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192708);
    this.bTm = Color.red(paramInt1);
    this.bTn = Color.green(paramInt1);
    this.bTo = Color.blue(paramInt1);
    this.bTp = paramInt1;
    this.bSR = paramInt2;
    AppMethodBeat.o(192708);
  }
  
  private void IH()
  {
    AppMethodBeat.i(192724);
    int j;
    int m;
    int k;
    if (!this.bTq)
    {
      i = b.c(-1, this.bTp, 4.5F);
      j = b.c(-1, this.bTp, 3.0F);
      if ((i != -1) && (j != -1))
      {
        this.bTr = b.ax(-1, i);
        this.xR = b.ax(-1, j);
        this.bTq = true;
        AppMethodBeat.o(192724);
        return;
      }
      m = b.c(-16777216, this.bTp, 4.5F);
      k = b.c(-16777216, this.bTp, 3.0F);
      if ((m != -1) && (k != -1))
      {
        this.bTr = b.ax(-16777216, m);
        this.xR = b.ax(-16777216, k);
        this.bTq = true;
        AppMethodBeat.o(192724);
        return;
      }
      if (i == -1) {
        break label184;
      }
      i = b.ax(-1, i);
      this.bTr = i;
      if (j == -1) {
        break label195;
      }
    }
    label184:
    label195:
    for (int i = b.ax(-1, j);; i = b.ax(-16777216, k))
    {
      this.xR = i;
      this.bTq = true;
      AppMethodBeat.o(192724);
      return;
      i = b.ax(-16777216, m);
      break;
    }
  }
  
  public final float[] IF()
  {
    AppMethodBeat.i(192736);
    if (this.bTs == null) {
      this.bTs = new float[3];
    }
    b.a(this.bTm, this.bTn, this.bTo, this.bTs);
    float[] arrayOfFloat = this.bTs;
    AppMethodBeat.o(192736);
    return arrayOfFloat;
  }
  
  public final int IG()
  {
    AppMethodBeat.i(192748);
    IH();
    int i = this.bTr;
    AppMethodBeat.o(192748);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(192774);
    if (this == paramObject)
    {
      AppMethodBeat.o(192774);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(192774);
      return false;
    }
    paramObject = (d)paramObject;
    if ((this.bSR == paramObject.bSR) && (this.bTp == paramObject.bTp))
    {
      AppMethodBeat.o(192774);
      return true;
    }
    AppMethodBeat.o(192774);
    return false;
  }
  
  public final int hashCode()
  {
    return this.bTp * 31 + this.bSR;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192758);
    Object localObject = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.bTp)).append(']').append(" [HSL: ").append(Arrays.toString(IF())).append(']').append(" [Population: ").append(this.bSR).append(']').append(" [Title Text: #");
    IH();
    localObject = Integer.toHexString(this.xR) + ']' + " [Body Text: #" + Integer.toHexString(IG()) + ']';
    AppMethodBeat.o(192758);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.j.a.b.d
 * JD-Core Version:    0.7.0.1
 */