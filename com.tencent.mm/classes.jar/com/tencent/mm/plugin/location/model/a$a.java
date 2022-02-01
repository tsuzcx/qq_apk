package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.b;
import java.util.Set;

public final class a$a
{
  Set<Long> vlK;
  private c.a vlL;
  
  public a$a()
  {
    AppMethodBeat.i(55679);
    this.vlL = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(55678);
        a.a locala = a.a.this;
        bv localbv;
        int i;
        boolean bool;
        Object localObject;
        if ((paramAnonymousAddr.tag != null) && ((paramAnonymousAddr.tag instanceof Long)))
        {
          long l = ((Long)paramAnonymousAddr.tag).longValue();
          localbv = ((l)g.ab(l.class)).doJ().ys(l);
          if (!bu.isNullOrNil(paramAnonymousAddr.hZQ))
          {
            String str = localbv.field_content;
            if (localbv.field_isSend != 0) {
              break label573;
            }
            i = 1;
            bool = x.wb(localbv.field_talker);
            localObject = str;
            if (bool)
            {
              localObject = str;
              if (i != 0)
              {
                int j = bl.BJ(str);
                localObject = str;
                if (j != -1) {
                  localObject = str.substring(j + 1).trim();
                }
              }
            }
            localObject = bv.b.aVD((String)localObject);
            ((bv.b)localObject).label = paramAnonymousAddr.aId();
            if ((!bool) || (i == 0)) {
              break label584;
            }
            i = bl.BJ(localbv.field_content);
            if (i == -1) {
              break label584;
            }
            paramAnonymousAddr = localbv.field_content.substring(0, i).trim();
            if (paramAnonymousAddr.length() <= 0) {
              break label584;
            }
          }
        }
        for (;;)
        {
          if ((((bv.b)localObject).Jhe == null) || (((bv.b)localObject).Jhe.equals(""))) {
            ((bv.b)localObject).Jhe = "";
          }
          if ((((bv.b)localObject).Jhd == null) || (((bv.b)localObject).Jhd.equals(""))) {
            ((bv.b)localObject).Jhe = "";
          }
          if ((((bv.b)localObject).Jhc == null) || (((bv.b)localObject).Jhc.equals(""))) {
            ((bv.b)localObject).Jhc = "";
          }
          if ((((bv.b)localObject).cUA == null) || (((bv.b)localObject).cUA.equals(""))) {
            ((bv.b)localObject).cUA = "";
          }
          if ((((bv.b)localObject).label == null) || (((bv.b)localObject).label.equals(""))) {
            ((bv.b)localObject).label = "";
          }
          if ((((bv.b)localObject).Jhb == null) || (((bv.b)localObject).Jhb.equals(""))) {
            ((bv.b)localObject).Jhb = "";
          }
          localObject = "<msg><location x=\"" + ((bv.b)localObject).vlC + "\" y=\"" + ((bv.b)localObject).vlD + "\" scale=\"" + ((bv.b)localObject).dzG + "\" label=\"" + ((bv.b)localObject).label + "\" maptype=\"" + ((bv.b)localObject).Jhb + "\"  fromusername=\"" + ((bv.b)localObject).cUA + "\" /></msg>";
          if ((bool) && (!paramAnonymousAddr.equals(""))) {}
          for (paramAnonymousAddr = paramAnonymousAddr + ":\n" + (String)localObject;; paramAnonymousAddr = (Addr)localObject)
          {
            ae.d("MicroMsg.LocationServer", "xml: ".concat(String.valueOf(paramAnonymousAddr)));
            localbv.setContent(paramAnonymousAddr);
            ((l)g.ab(l.class)).doJ().a(localbv.field_msgId, localbv);
            locala.vlK.remove(Long.valueOf(localbv.field_msgId));
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
  
  public final String[] ao(bv parambv)
  {
    int j = 1;
    AppMethodBeat.i(55681);
    String[] arrayOfString = new String[2];
    Object localObject2 = parambv.field_content;
    if (bu.isNullOrNil((String)localObject2))
    {
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      AppMethodBeat.o(55681);
      return arrayOfString;
    }
    Object localObject1;
    label162:
    long l;
    if (parambv.field_isSend == 0)
    {
      i = 1;
      localObject1 = localObject2;
      if (x.wb(parambv.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bl.BJ((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject2 = ((l)g.ab(l.class)).doJ().arq((String)localObject1);
      if (!((bv.b)localObject2).fwu()) {
        break label347;
      }
      localObject1 = ((bv.b)localObject2).label;
      localObject2 = ((bv.b)localObject2).jGd;
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localObject2;
      if ((bu.isNullOrNil(arrayOfString[0])) && (bu.isNullOrNil(arrayOfString[1])))
      {
        ae.i("MicroMsg.LocationServer", "pull from sever");
        l = parambv.field_msgId;
        if ((this.vlK != null) && (!this.vlK.contains(Long.valueOf(l))))
        {
          localObject2 = parambv.field_content;
          if (parambv.field_isSend != 0) {
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
      if (x.wb(parambv.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bl.BJ((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject1 = bv.b.aVD((String)localObject1);
      this.vlK.add(Long.valueOf(l));
      c.aIe().a(((bv.b)localObject1).vlC, ((bv.b)localObject1).vlD, this.vlL, Long.valueOf(parambv.field_msgId));
      AppMethodBeat.o(55681);
      return arrayOfString;
      i = 0;
      break;
      arrayOfString[0] = ((bv.b)localObject2).label;
      arrayOfString[1] = "";
      break label162;
    }
  }
  
  public final void diY()
  {
    AppMethodBeat.i(55680);
    if (this.vlK != null) {
      this.vlK.clear();
    }
    c.aIe().a(this.vlL);
    AppMethodBeat.o(55680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */