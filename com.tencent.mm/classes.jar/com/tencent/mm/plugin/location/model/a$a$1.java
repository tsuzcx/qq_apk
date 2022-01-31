package com.tencent.mm.plugin.location.model;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.util.Set;

final class a$a$1
  implements b.a
{
  a$a$1(a.a parama) {}
  
  public final void b(Addr paramAddr)
  {
    a.a locala = this.lCT;
    bi localbi;
    int i;
    boolean bool;
    Object localObject;
    if ((paramAddr.tag != null) && ((paramAddr.tag instanceof Long)))
    {
      long l = ((Long)paramAddr.tag).longValue();
      localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(l);
      if (!bk.bl(paramAddr.ekZ))
      {
        String str = localbi.field_content;
        if (localbi.field_isSend != 0) {
          break label570;
        }
        i = 1;
        bool = s.fn(localbi.field_talker);
        localObject = str;
        if (bool)
        {
          localObject = str;
          if (i != 0)
          {
            int j = bd.iH(str);
            localObject = str;
            if (j != -1) {
              localObject = str.substring(j + 1).trim();
            }
          }
        }
        localObject = bi.b.aca((String)localObject);
        ((bi.b)localObject).label = paramAddr.NY();
        if ((!bool) || (i == 0)) {
          break label581;
        }
        i = bd.iH(localbi.field_content);
        if (i == -1) {
          break label581;
        }
        paramAddr = localbi.field_content.substring(0, i).trim();
        if (paramAddr.length() <= 0) {
          break label581;
        }
      }
    }
    for (;;)
    {
      if ((((bi.b)localObject).uCh == null) || (((bi.b)localObject).uCh.equals(""))) {
        ((bi.b)localObject).uCh = "";
      }
      if ((((bi.b)localObject).uCg == null) || (((bi.b)localObject).uCg.equals(""))) {
        ((bi.b)localObject).uCh = "";
      }
      if ((((bi.b)localObject).uCf == null) || (((bi.b)localObject).uCf.equals(""))) {
        ((bi.b)localObject).uCf = "";
      }
      if ((((bi.b)localObject).pyp == null) || (((bi.b)localObject).pyp.equals(""))) {
        ((bi.b)localObject).pyp = "";
      }
      if ((((bi.b)localObject).label == null) || (((bi.b)localObject).label.equals(""))) {
        ((bi.b)localObject).label = "";
      }
      if ((((bi.b)localObject).uCe == null) || (((bi.b)localObject).uCe.equals(""))) {
        ((bi.b)localObject).uCe = "";
      }
      localObject = "<msg><location x=\"" + ((bi.b)localObject).lCJ + "\" y=\"" + ((bi.b)localObject).lCK + "\" scale=\"" + ((bi.b)localObject).bRv + "\" label=\"" + ((bi.b)localObject).label + "\" maptype=\"" + ((bi.b)localObject).uCe + "\"  fromusername=\"" + ((bi.b)localObject).pyp + "\" /></msg>";
      if ((bool) && (!paramAddr.equals(""))) {}
      for (paramAddr = paramAddr + ":\n" + (String)localObject;; paramAddr = (Addr)localObject)
      {
        y.d("MicroMsg.LocationServer", "xml: " + paramAddr);
        localbi.setContent(paramAddr);
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(localbi.field_msgId, localbi);
        locala.lCR.remove(Long.valueOf(localbi.field_msgId));
        return;
        label570:
        i = 0;
        break;
      }
      label581:
      paramAddr = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a.1
 * JD-Core Version:    0.7.0.1
 */