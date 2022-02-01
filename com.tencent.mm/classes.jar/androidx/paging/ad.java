package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/LoadType;", "", "(Ljava/lang/String;I)V", "REFRESH", "PREPEND", "APPEND", "paging-common"}, k=1, mv={1, 4, 2})
public enum ad
{
  static
  {
    AppMethodBeat.i(196682);
    ad localad1 = new ad("REFRESH", 0);
    bNC = localad1;
    ad localad2 = new ad("PREPEND", 1);
    bND = localad2;
    ad localad3 = new ad("APPEND", 2);
    bNE = localad3;
    bNF = new ad[] { localad1, localad2, localad3 };
    AppMethodBeat.o(196682);
  }
  
  private ad() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ad
 * JD-Core Version:    0.7.0.1
 */