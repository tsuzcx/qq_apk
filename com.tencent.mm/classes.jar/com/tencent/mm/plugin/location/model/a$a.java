package com.tencent.mm.plugin.location.model;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.util.Set;

public final class a$a
{
  Set<Long> lCR;
  private b.a lCS = new a.a.1(this);
  
  public final String[] Q(bi parambi)
  {
    int j = 1;
    String[] arrayOfString = new String[2];
    Object localObject2 = parambi.field_content;
    if (bk.bl((String)localObject2))
    {
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      return arrayOfString;
    }
    Object localObject1;
    label152:
    long l;
    if (parambi.field_isSend == 0)
    {
      i = 1;
      localObject1 = localObject2;
      if (s.fn(parambi.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bd.iH((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HO((String)localObject1);
      if (!((bi.b)localObject2).cvN()) {
        break label332;
      }
      localObject1 = ((bi.b)localObject2).label;
      localObject2 = ((bi.b)localObject2).lFn;
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localObject2;
      if ((bk.bl(arrayOfString[0])) && (bk.bl(arrayOfString[1])))
      {
        y.i("MicroMsg.LocationServer", "pull from sever");
        l = parambi.field_msgId;
        if ((this.lCR != null) && (!this.lCR.contains(Long.valueOf(l))))
        {
          localObject2 = parambi.field_content;
          if (parambi.field_isSend != 0) {
            break label350;
          }
        }
      }
    }
    label332:
    label350:
    for (int i = j;; i = 0)
    {
      localObject1 = localObject2;
      if (s.fn(parambi.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bd.iH((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject1 = bi.b.aca((String)localObject1);
      this.lCR.add(Long.valueOf(l));
      b.NZ().a(((bi.b)localObject1).lCJ, ((bi.b)localObject1).lCK, this.lCS, Long.valueOf(parambi.field_msgId));
      return arrayOfString;
      i = 0;
      break;
      arrayOfString[0] = ((bi.b)localObject2).label;
      arrayOfString[1] = "";
      break label152;
    }
  }
  
  public final void bdP()
  {
    if (this.lCR != null) {
      this.lCR.clear();
    }
    b.NZ().a(this.lCS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */