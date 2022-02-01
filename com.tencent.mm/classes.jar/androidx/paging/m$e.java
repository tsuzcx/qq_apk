package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/DataSource$KeyType;", "", "(Ljava/lang/String;I)V", "POSITIONAL", "PAGE_KEYED", "ITEM_KEYED", "paging-common"}, k=1, mv={1, 4, 2})
public enum m$e
{
  static
  {
    AppMethodBeat.i(196900);
    e locale1 = new e("POSITIONAL", 0);
    bMl = locale1;
    e locale2 = new e("PAGE_KEYED", 1);
    bMm = locale2;
    e locale3 = new e("ITEM_KEYED", 2);
    bMn = locale3;
    bMo = new e[] { locale1, locale2, locale3 };
    AppMethodBeat.o(196900);
  }
  
  private m$e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.m.e
 * JD-Core Version:    0.7.0.1
 */