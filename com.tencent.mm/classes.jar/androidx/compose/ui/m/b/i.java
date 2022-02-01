package androidx.compose.ui.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/font/FontWeight;", "", "weight", "", "(I)V", "getWeight", "()I", "compareTo", "other", "equals", "", "", "hashCode", "toString", "", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements Comparable<i>
{
  public static final i.a bcc;
  private static final i bcd;
  private static final i bce;
  private static final i bcf;
  private static final i bcg;
  private static final i bch;
  private static final i bci;
  private static final i bcj;
  private static final i bck;
  private static final i bcl;
  private static final i bcm;
  private static final i bcn;
  private static final i bco;
  private static final i bcp;
  private static final i bcq;
  private static final i bcr;
  private static final i bcs;
  private static final i bct;
  private static final i bcu;
  private static final List<i> values;
  public final int weight;
  
  static
  {
    AppMethodBeat.i(205325);
    bcc = new i.a((byte)0);
    bcd = new i(100);
    bce = new i(200);
    bcf = new i(300);
    bcg = new i(400);
    bch = new i(500);
    bci = new i(600);
    bcj = new i(700);
    bck = new i(800);
    bcl = new i(900);
    bcm = bcd;
    bcn = bce;
    bco = bcf;
    bcp = bcg;
    bcq = bch;
    bcr = bci;
    bcs = bcj;
    bct = bck;
    bcu = bcl;
    values = p.listOf(new i[] { bcd, bce, bcf, bcg, bch, bci, bcj, bck, bcl });
    AppMethodBeat.o(205325);
  }
  
  public i(int paramInt)
  {
    AppMethodBeat.i(205303);
    this.weight = paramInt;
    int j = this.weight;
    paramInt = i;
    if (j > 0)
    {
      paramInt = i;
      if (j <= 1000) {
        paramInt = 1;
      }
    }
    if (paramInt == 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException(s.X("Font weight can be in range [1, 1000]. Current value: ", Integer.valueOf(this.weight)).toString());
      AppMethodBeat.o(205303);
      throw localThrowable;
    }
    AppMethodBeat.o(205303);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(205328);
    s.u(parami, "other");
    int i = s.compare(this.weight, parami.weight);
    AppMethodBeat.o(205328);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof i)) {
        return false;
      }
    } while (this.weight == ((i)paramObject).weight);
    return false;
  }
  
  public final int hashCode()
  {
    return this.weight;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205335);
    String str = "FontWeight(weight=" + this.weight + ')';
    AppMethodBeat.o(205335);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.b.i
 * JD-Core Version:    0.7.0.1
 */