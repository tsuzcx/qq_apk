package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.util.Set;

public final class a$a
{
  Set<Long> oad;
  private c.a oae;
  
  public a$a()
  {
    AppMethodBeat.i(113300);
    this.oae = new a.a.1(this);
    AppMethodBeat.o(113300);
  }
  
  public final String[] W(bi parambi)
  {
    int j = 1;
    AppMethodBeat.i(113302);
    String[] arrayOfString = new String[2];
    Object localObject2 = parambi.field_content;
    if (bo.isNullOrNil((String)localObject2))
    {
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      AppMethodBeat.o(113302);
      return arrayOfString;
    }
    Object localObject1;
    label162:
    long l;
    if (parambi.field_isSend == 0)
    {
      i = 1;
      localObject1 = localObject2;
      if (t.lA(parambi.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bf.pt((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject2 = ((j)g.E(j.class)).bPQ().Tz((String)localObject1);
      if (!((bi.b)localObject2).dyv()) {
        break label347;
      }
      localObject1 = ((bi.b)localObject2).label;
      localObject2 = ((bi.b)localObject2).eSM;
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localObject2;
      if ((bo.isNullOrNil(arrayOfString[0])) && (bo.isNullOrNil(arrayOfString[1])))
      {
        ab.i("MicroMsg.LocationServer", "pull from sever");
        l = parambi.field_msgId;
        if ((this.oad != null) && (!this.oad.contains(Long.valueOf(l))))
        {
          localObject2 = parambi.field_content;
          if (parambi.field_isSend != 0) {
            break label365;
          }
        }
      }
    }
    label347:
    label365:
    for (int i = j;; i = 0)
    {
      localObject1 = localObject2;
      if (t.lA(parambi.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bf.pt((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject1 = bi.b.ask((String)localObject1);
      this.oad.add(Long.valueOf(l));
      c.agN().a(((bi.b)localObject1).nZV, ((bi.b)localObject1).nZW, this.oae, Long.valueOf(parambi.field_msgId));
      AppMethodBeat.o(113302);
      return arrayOfString;
      i = 0;
      break;
      arrayOfString[0] = ((bi.b)localObject2).label;
      arrayOfString[1] = "";
      break label162;
    }
  }
  
  public final void bLj()
  {
    AppMethodBeat.i(113301);
    if (this.oad != null) {
      this.oad.clear();
    }
    c.agN().a(this.oae);
    AppMethodBeat.o(113301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */