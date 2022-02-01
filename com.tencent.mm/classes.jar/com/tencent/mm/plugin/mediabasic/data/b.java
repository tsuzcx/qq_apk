package com.tencent.mm.plugin.mediabasic.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;", "", "inputs", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mediabasic/data/MediaSingleInfo;", "Lkotlin/collections/ArrayList;", "extra", "Landroid/os/Bundle;", "(Ljava/util/ArrayList;Landroid/os/Bundle;)V", "getExtra", "()Landroid/os/Bundle;", "setExtra", "(Landroid/os/Bundle;)V", "getInputs", "()Ljava/util/ArrayList;", "setInputs", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a KOH;
  public ArrayList<MediaSingleInfo> KOI;
  private Bundle oSS;
  
  static
  {
    AppMethodBeat.i(269630);
    KOH = new a((byte)0);
    AppMethodBeat.o(269630);
  }
  
  private b(ArrayList<MediaSingleInfo> paramArrayList)
  {
    AppMethodBeat.i(269622);
    this.KOI = paramArrayList;
    this.oSS = null;
    AppMethodBeat.o(269622);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(269652);
    if (this == paramObject)
    {
      AppMethodBeat.o(269652);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(269652);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.KOI, paramObject.KOI))
    {
      AppMethodBeat.o(269652);
      return false;
    }
    if (!s.p(this.oSS, paramObject.oSS))
    {
      AppMethodBeat.o(269652);
      return false;
    }
    AppMethodBeat.o(269652);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(269648);
    int j = this.KOI.hashCode();
    if (this.oSS == null) {}
    for (int i = 0;; i = this.oSS.hashCode())
    {
      AppMethodBeat.o(269648);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269638);
    String str = "MediaInputInfo(inputs=" + this.KOI + ", extra=" + this.oSS + ')';
    AppMethodBeat.o(269638);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo$Companion;", "", "()V", "makeMediaInputInfo", "Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;", "path", "", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabasic.data.b
 * JD-Core Version:    0.7.0.1
 */