package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import java.util.Set;

public final class a$a
{
  Set<Long> Ejv;
  private c.a Ejw;
  
  public a$a()
  {
    AppMethodBeat.i(55679);
    this.Ejw = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(55678);
        a.a locala = a.a.this;
        ca localca;
        int i;
        boolean bool;
        Object localObject;
        if ((paramAnonymousAddr.tag != null) && ((paramAnonymousAddr.tag instanceof Long)))
        {
          long l = ((Long)paramAnonymousAddr.tag).longValue();
          localca = ((n)h.ae(n.class)).eSe().Oq(l);
          if (!Util.isNullOrNil(paramAnonymousAddr.lLg))
          {
            String str = localca.field_content;
            if (localca.field_isSend != 0) {
              break label573;
            }
            i = 1;
            bool = ab.Lj(localca.field_talker);
            localObject = str;
            if (bool)
            {
              localObject = str;
              if (i != 0)
              {
                int j = bq.RI(str);
                localObject = str;
                if (j != -1) {
                  localObject = str.substring(j + 1).trim();
                }
              }
            }
            localObject = ca.b.bxa((String)localObject);
            ((ca.b)localObject).label = paramAnonymousAddr.blm();
            if ((!bool) || (i == 0)) {
              break label584;
            }
            i = bq.RI(localca.field_content);
            if (i == -1) {
              break label584;
            }
            paramAnonymousAddr = localca.field_content.substring(0, i).trim();
            if (paramAnonymousAddr.length() <= 0) {
              break label584;
            }
          }
        }
        for (;;)
        {
          if ((((ca.b)localObject).VGR == null) || (((ca.b)localObject).VGR.equals(""))) {
            ((ca.b)localObject).VGR = "";
          }
          if ((((ca.b)localObject).VGQ == null) || (((ca.b)localObject).VGQ.equals(""))) {
            ((ca.b)localObject).VGR = "";
          }
          if ((((ca.b)localObject).VGP == null) || (((ca.b)localObject).VGP.equals(""))) {
            ((ca.b)localObject).VGP = "";
          }
          if ((((ca.b)localObject).fcC == null) || (((ca.b)localObject).fcC.equals(""))) {
            ((ca.b)localObject).fcC = "";
          }
          if ((((ca.b)localObject).label == null) || (((ca.b)localObject).label.equals(""))) {
            ((ca.b)localObject).label = "";
          }
          if ((((ca.b)localObject).VGO == null) || (((ca.b)localObject).VGO.equals(""))) {
            ((ca.b)localObject).VGO = "";
          }
          localObject = "<msg><location x=\"" + ((ca.b)localObject).Ejn + "\" y=\"" + ((ca.b)localObject).Ejo + "\" scale=\"" + ((ca.b)localObject).fKJ + "\" label=\"" + ((ca.b)localObject).label + "\" maptype=\"" + ((ca.b)localObject).VGO + "\"  fromusername=\"" + ((ca.b)localObject).fcC + "\" /></msg>";
          if ((bool) && (!paramAnonymousAddr.equals(""))) {}
          for (paramAnonymousAddr = paramAnonymousAddr + ":\n" + (String)localObject;; paramAnonymousAddr = (Addr)localObject)
          {
            Log.d("MicroMsg.LocationServer", "xml: ".concat(String.valueOf(paramAnonymousAddr)));
            localca.setContent(paramAnonymousAddr);
            ((n)h.ae(n.class)).eSe().a(localca.field_msgId, localca);
            locala.Ejv.remove(Long.valueOf(localca.field_msgId));
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
  
  public final String[] aJ(ca paramca)
  {
    int j = 1;
    AppMethodBeat.i(55681);
    String[] arrayOfString = new String[2];
    Object localObject2 = paramca.field_content;
    if (Util.isNullOrNil((String)localObject2))
    {
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      AppMethodBeat.o(55681);
      return arrayOfString;
    }
    Object localObject1;
    label162:
    long l;
    if (paramca.field_isSend == 0)
    {
      i = 1;
      localObject1 = localObject2;
      if (ab.Lj(paramca.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bq.RI((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject2 = ((n)h.ae(n.class)).eSe().aOV((String)localObject1);
      if (!((ca.b)localObject2).hAq()) {
        break label347;
      }
      localObject1 = ((ca.b)localObject2).label;
      localObject2 = ((ca.b)localObject2).poiName;
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localObject2;
      if ((Util.isNullOrNil(arrayOfString[0])) && (Util.isNullOrNil(arrayOfString[1])))
      {
        Log.i("MicroMsg.LocationServer", "pull from sever");
        l = paramca.field_msgId;
        if ((this.Ejv != null) && (!this.Ejv.contains(Long.valueOf(l))))
        {
          localObject2 = paramca.field_content;
          if (paramca.field_isSend != 0) {
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
      if (ab.Lj(paramca.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bq.RI((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject1 = ca.b.bxa((String)localObject1);
      this.Ejv.add(Long.valueOf(l));
      c.bln().a(((ca.b)localObject1).Ejn, ((ca.b)localObject1).Ejo, this.Ejw, Long.valueOf(paramca.field_msgId));
      AppMethodBeat.o(55681);
      return arrayOfString;
      i = 0;
      break;
      arrayOfString[0] = ((ca.b)localObject2).label;
      arrayOfString[1] = "";
      break label162;
    }
  }
  
  public final void eMb()
  {
    AppMethodBeat.i(55680);
    if (this.Ejv != null) {
      this.Ejv.clear();
    }
    c.bln().a(this.Ejw);
    AppMethodBeat.o(55680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */