package com.tencent.mm.plugin.datareport.f;

import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.apache.commons.c.i;

public final class c
{
  public int hIa;
  public String xhm;
  public String xhn;
  public boolean xho;
  public int xhp;
  
  public c(Object paramObject)
  {
    AppMethodBeat.i(262810);
    this.xhp = -1;
    StringBuilder localStringBuilder;
    if ((paramObject == null) || ((paramObject instanceof c)))
    {
      if (a.anH())
      {
        localStringBuilder = new StringBuilder("Create SubstitutePage use illegal argument, page is ");
        localObject = paramObject;
        if (paramObject == null) {
          localObject = "null";
        }
        paramObject = new IllegalArgumentException(localObject);
        AppMethodBeat.o(262810);
        throw paramObject;
      }
      localStringBuilder = new StringBuilder("Create SubstitutePage use illegal argument, page is ");
      if (paramObject != null) {
        break label147;
      }
    }
    label147:
    for (Object localObject = "null";; localObject = paramObject)
    {
      Log.e("SubstitutePage", localObject);
      this.hIa = paramObject.hashCode();
      this.xhm = paramObject.getClass().getSimpleName();
      this.xhn = paramObject.getClass().getCanonicalName();
      this.xho = (paramObject instanceof Fragment);
      AppMethodBeat.o(262810);
      return;
    }
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(262819);
    if (paramc == null)
    {
      AppMethodBeat.o(262819);
      return false;
    }
    if ((i.qA(paramc.xhm, this.xhm)) && (i.qA(paramc.xhn, this.xhn)) && (paramc.hIa == this.hIa) && (paramc.xho == this.xho))
    {
      AppMethodBeat.o(262819);
      return true;
    }
    AppMethodBeat.o(262819);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(262828);
    String str = "SubstitutePage{pageHash=" + this.hIa + ", simplePageName='" + this.xhm + '\'' + ", canonicalPageName='" + this.xhn + '\'' + ", stackDeep='" + this.xhp + '\'' + ", isFragment=" + this.xho + '}';
    AppMethodBeat.o(262828);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.f.c
 * JD-Core Version:    0.7.0.1
 */