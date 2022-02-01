package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.b;
import java.util.Set;

public final class a$a
{
  Set<Long> tWQ;
  private c.a tWR;
  
  public a$a()
  {
    AppMethodBeat.i(55679);
    this.tWR = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(55678);
        a.a locala = a.a.this;
        bo localbo;
        int i;
        boolean bool;
        Object localObject;
        if ((paramAnonymousAddr.tag != null) && ((paramAnonymousAddr.tag instanceof Long)))
        {
          long l = ((Long)paramAnonymousAddr.tag).longValue();
          localbo = ((k)g.ab(k.class)).dcr().vP(l);
          if (!bs.isNullOrNil(paramAnonymousAddr.hEt))
          {
            String str = localbo.field_content;
            if (localbo.field_isSend != 0) {
              break label573;
            }
            i = 1;
            bool = w.sQ(localbo.field_talker);
            localObject = str;
            if (bool)
            {
              localObject = str;
              if (i != 0)
              {
                int j = bi.yi(str);
                localObject = str;
                if (j != -1) {
                  localObject = str.substring(j + 1).trim();
                }
              }
            }
            localObject = bo.b.aOl((String)localObject);
            ((bo.b)localObject).label = paramAnonymousAddr.aEH();
            if ((!bool) || (i == 0)) {
              break label584;
            }
            i = bi.yi(localbo.field_content);
            if (i == -1) {
              break label584;
            }
            paramAnonymousAddr = localbo.field_content.substring(0, i).trim();
            if (paramAnonymousAddr.length() <= 0) {
              break label584;
            }
          }
        }
        for (;;)
        {
          if ((((bo.b)localObject).GZi == null) || (((bo.b)localObject).GZi.equals(""))) {
            ((bo.b)localObject).GZi = "";
          }
          if ((((bo.b)localObject).GZh == null) || (((bo.b)localObject).GZh.equals(""))) {
            ((bo.b)localObject).GZi = "";
          }
          if ((((bo.b)localObject).GZg == null) || (((bo.b)localObject).GZg.equals(""))) {
            ((bo.b)localObject).GZg = "";
          }
          if ((((bo.b)localObject).zTO == null) || (((bo.b)localObject).zTO.equals(""))) {
            ((bo.b)localObject).zTO = "";
          }
          if ((((bo.b)localObject).label == null) || (((bo.b)localObject).label.equals(""))) {
            ((bo.b)localObject).label = "";
          }
          if ((((bo.b)localObject).GZf == null) || (((bo.b)localObject).GZf.equals(""))) {
            ((bo.b)localObject).GZf = "";
          }
          localObject = "<msg><location x=\"" + ((bo.b)localObject).tWI + "\" y=\"" + ((bo.b)localObject).tWJ + "\" scale=\"" + ((bo.b)localObject).dmN + "\" label=\"" + ((bo.b)localObject).label + "\" maptype=\"" + ((bo.b)localObject).GZf + "\"  fromusername=\"" + ((bo.b)localObject).zTO + "\" /></msg>";
          if ((bool) && (!paramAnonymousAddr.equals(""))) {}
          for (paramAnonymousAddr = paramAnonymousAddr + ":\n" + (String)localObject;; paramAnonymousAddr = (Addr)localObject)
          {
            ac.d("MicroMsg.LocationServer", "xml: ".concat(String.valueOf(paramAnonymousAddr)));
            localbo.setContent(paramAnonymousAddr);
            ((k)g.ab(k.class)).dcr().a(localbo.field_msgId, localbo);
            locala.tWQ.remove(Long.valueOf(localbo.field_msgId));
            AppMethodBeat.o(55678);
            return;
            label573:
            i = 0;
            break;
          }
          label584:
          paramAnonymousAddr = "";
        }
      }
    };
    AppMethodBeat.o(55679);
  }
  
  public final String[] am(bo parambo)
  {
    int j = 1;
    AppMethodBeat.i(55681);
    String[] arrayOfString = new String[2];
    Object localObject2 = parambo.field_content;
    if (bs.isNullOrNil((String)localObject2))
    {
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      AppMethodBeat.o(55681);
      return arrayOfString;
    }
    Object localObject1;
    label162:
    long l;
    if (parambo.field_isSend == 0)
    {
      i = 1;
      localObject1 = localObject2;
      if (w.sQ(parambo.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bi.yi((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject2 = ((k)g.ab(k.class)).dcr().alx((String)localObject1);
      if (!((bo.b)localObject2).fcm()) {
        break label347;
      }
      localObject1 = ((bo.b)localObject2).label;
      localObject2 = ((bo.b)localObject2).gPy;
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localObject2;
      if ((bs.isNullOrNil(arrayOfString[0])) && (bs.isNullOrNil(arrayOfString[1])))
      {
        ac.i("MicroMsg.LocationServer", "pull from sever");
        l = parambo.field_msgId;
        if ((this.tWQ != null) && (!this.tWQ.contains(Long.valueOf(l))))
        {
          localObject2 = parambo.field_content;
          if (parambo.field_isSend != 0) {
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
      if (w.sQ(parambo.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bi.yi((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject1 = bo.b.aOl((String)localObject1);
      this.tWQ.add(Long.valueOf(l));
      c.aEI().a(((bo.b)localObject1).tWI, ((bo.b)localObject1).tWJ, this.tWR, Long.valueOf(parambo.field_msgId));
      AppMethodBeat.o(55681);
      return arrayOfString;
      i = 0;
      break;
      arrayOfString[0] = ((bo.b)localObject2).label;
      arrayOfString[1] = "";
      break label162;
    }
  }
  
  public final void cWN()
  {
    AppMethodBeat.i(55680);
    if (this.tWQ != null) {
      this.tWQ.clear();
    }
    c.aEI().a(this.tWR);
    AppMethodBeat.o(55680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */