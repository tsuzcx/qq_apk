package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.storage.bi;

public final class b
  extends g
{
  private j.b kEK;
  private String kEL;
  
  public b(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bi parambi)
  {
    super(paramg, parambi);
  }
  
  private j.b bgt()
  {
    AppMethodBeat.i(54287);
    if (this.kEK == null) {
      this.kEK = j.b.mY(this.kEz.field_content);
    }
    j.b localb = this.kEK;
    AppMethodBeat.o(54287);
    return localb;
  }
  
  protected final String aaZ()
  {
    AppMethodBeat.i(54291);
    Object localObject;
    if ((this.kEL == null) && (bgt() != null) && (bgt().cmN != null) && (bgt().cmN.length() > 0))
    {
      localObject = com.tencent.mm.plugin.s.a.aUJ().alo(bgt().cmN);
      if (localObject != null) {
        this.kEL = ((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath;
      }
    }
    if (this.kEL != null)
    {
      localObject = this.kEL;
      AppMethodBeat.o(54291);
      return localObject;
    }
    AppMethodBeat.o(54291);
    return "";
  }
  
  public final String bgm()
  {
    AppMethodBeat.i(54288);
    if (bgt() != null)
    {
      String str = bgt().fgx;
      AppMethodBeat.o(54288);
      return str;
    }
    AppMethodBeat.o(54288);
    return "";
  }
  
  public final int bgn()
  {
    AppMethodBeat.i(54290);
    if (bgt() != null)
    {
      int i = bgt().fgw;
      AppMethodBeat.o(54290);
      return i;
    }
    AppMethodBeat.o(54290);
    return 0;
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(54289);
    if (bgt() != null)
    {
      String str = bgt().title;
      AppMethodBeat.o(54289);
      return str;
    }
    AppMethodBeat.o(54289);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.b
 * JD-Core Version:    0.7.0.1
 */