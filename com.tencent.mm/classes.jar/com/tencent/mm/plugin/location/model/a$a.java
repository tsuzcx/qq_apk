package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.b;
import java.util.Set;

public final class a$a
{
  private c.a uZA;
  Set<Long> uZz;
  
  public a$a()
  {
    AppMethodBeat.i(55679);
    this.uZA = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(55678);
        a.a locala = a.a.this;
        bu localbu;
        int i;
        boolean bool;
        Object localObject;
        if ((paramAnonymousAddr.tag != null) && ((paramAnonymousAddr.tag instanceof Long)))
        {
          long l = ((Long)paramAnonymousAddr.tag).longValue();
          localbu = ((l)g.ab(l.class)).dlK().xY(l);
          if (!bt.isNullOrNil(paramAnonymousAddr.hWY))
          {
            String str = localbu.field_content;
            if (localbu.field_isSend != 0) {
              break label573;
            }
            i = 1;
            bool = w.vF(localbu.field_talker);
            localObject = str;
            if (bool)
            {
              localObject = str;
              if (i != 0)
              {
                int j = bj.Bh(str);
                localObject = str;
                if (j != -1) {
                  localObject = str.substring(j + 1).trim();
                }
              }
            }
            localObject = bu.b.aUc((String)localObject);
            ((bu.b)localObject).label = paramAnonymousAddr.aHM();
            if ((!bool) || (i == 0)) {
              break label584;
            }
            i = bj.Bh(localbu.field_content);
            if (i == -1) {
              break label584;
            }
            paramAnonymousAddr = localbu.field_content.substring(0, i).trim();
            if (paramAnonymousAddr.length() <= 0) {
              break label584;
            }
          }
        }
        for (;;)
        {
          if ((((bu.b)localObject).IMx == null) || (((bu.b)localObject).IMx.equals(""))) {
            ((bu.b)localObject).IMx = "";
          }
          if ((((bu.b)localObject).IMw == null) || (((bu.b)localObject).IMw.equals(""))) {
            ((bu.b)localObject).IMx = "";
          }
          if ((((bu.b)localObject).IMv == null) || (((bu.b)localObject).IMv.equals(""))) {
            ((bu.b)localObject).IMv = "";
          }
          if ((((bu.b)localObject).dHm == null) || (((bu.b)localObject).dHm.equals(""))) {
            ((bu.b)localObject).dHm = "";
          }
          if ((((bu.b)localObject).label == null) || (((bu.b)localObject).label.equals(""))) {
            ((bu.b)localObject).label = "";
          }
          if ((((bu.b)localObject).IMu == null) || (((bu.b)localObject).IMu.equals(""))) {
            ((bu.b)localObject).IMu = "";
          }
          localObject = "<msg><location x=\"" + ((bu.b)localObject).uZr + "\" y=\"" + ((bu.b)localObject).uZs + "\" scale=\"" + ((bu.b)localObject).dyB + "\" label=\"" + ((bu.b)localObject).label + "\" maptype=\"" + ((bu.b)localObject).IMu + "\"  fromusername=\"" + ((bu.b)localObject).dHm + "\" /></msg>";
          if ((bool) && (!paramAnonymousAddr.equals(""))) {}
          for (paramAnonymousAddr = paramAnonymousAddr + ":\n" + (String)localObject;; paramAnonymousAddr = (Addr)localObject)
          {
            ad.d("MicroMsg.LocationServer", "xml: ".concat(String.valueOf(paramAnonymousAddr)));
            localbu.setContent(paramAnonymousAddr);
            ((l)g.ab(l.class)).dlK().a(localbu.field_msgId, localbu);
            locala.uZz.remove(Long.valueOf(localbu.field_msgId));
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
  
  public final String[] ap(bu parambu)
  {
    int j = 1;
    AppMethodBeat.i(55681);
    String[] arrayOfString = new String[2];
    Object localObject2 = parambu.field_content;
    if (bt.isNullOrNil((String)localObject2))
    {
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      AppMethodBeat.o(55681);
      return arrayOfString;
    }
    Object localObject1;
    label162:
    long l;
    if (parambu.field_isSend == 0)
    {
      i = 1;
      localObject1 = localObject2;
      if (w.vF(parambu.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bj.Bh((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject2 = ((l)g.ab(l.class)).dlK().aql((String)localObject1);
      if (!((bu.b)localObject2).fst()) {
        break label347;
      }
      localObject1 = ((bu.b)localObject2).label;
      localObject2 = ((bu.b)localObject2).jDf;
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localObject2;
      if ((bt.isNullOrNil(arrayOfString[0])) && (bt.isNullOrNil(arrayOfString[1])))
      {
        ad.i("MicroMsg.LocationServer", "pull from sever");
        l = parambu.field_msgId;
        if ((this.uZz != null) && (!this.uZz.contains(Long.valueOf(l))))
        {
          localObject2 = parambu.field_content;
          if (parambu.field_isSend != 0) {
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
      if (w.vF(parambu.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bj.Bh((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject1 = bu.b.aUc((String)localObject1);
      this.uZz.add(Long.valueOf(l));
      c.aHN().a(((bu.b)localObject1).uZr, ((bu.b)localObject1).uZs, this.uZA, Long.valueOf(parambu.field_msgId));
      AppMethodBeat.o(55681);
      return arrayOfString;
      i = 0;
      break;
      arrayOfString[0] = ((bu.b)localObject2).label;
      arrayOfString[1] = "";
      break label162;
    }
  }
  
  public final void dfZ()
  {
    AppMethodBeat.i(55680);
    if (this.uZz != null) {
      this.uZz.clear();
    }
    c.aHN().a(this.uZA);
    AppMethodBeat.o(55680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */