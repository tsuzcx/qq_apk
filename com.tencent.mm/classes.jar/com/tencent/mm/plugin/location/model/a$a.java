package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.b;
import java.util.Set;

public final class a$a
{
  Set<Long> sOD;
  private c.a sOE;
  
  public a$a()
  {
    AppMethodBeat.i(55679);
    this.sOE = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(55678);
        a.a locala = a.a.this;
        bl localbl;
        int i;
        boolean bool;
        Object localObject;
        if ((paramAnonymousAddr.tag != null) && ((paramAnonymousAddr.tag instanceof Long)))
        {
          long l = ((Long)paramAnonymousAddr.tag).longValue();
          localbl = ((k)g.ab(k.class)).cOI().rm(l);
          if (!bt.isNullOrNil(paramAnonymousAddr.hdQ))
          {
            String str = localbl.field_content;
            if (localbl.field_isSend != 0) {
              break label573;
            }
            i = 1;
            bool = w.pF(localbl.field_talker);
            localObject = str;
            if (bool)
            {
              localObject = str;
              if (i != 0)
              {
                int j = bi.uc(str);
                localObject = str;
                if (j != -1) {
                  localObject = str.substring(j + 1).trim();
                }
              }
            }
            localObject = bl.b.aIP((String)localObject);
            ((bl.b)localObject).label = paramAnonymousAddr.axP();
            if ((!bool) || (i == 0)) {
              break label584;
            }
            i = bi.uc(localbl.field_content);
            if (i == -1) {
              break label584;
            }
            paramAnonymousAddr = localbl.field_content.substring(0, i).trim();
            if (paramAnonymousAddr.length() <= 0) {
              break label584;
            }
          }
        }
        for (;;)
        {
          if ((((bl.b)localObject).FAg == null) || (((bl.b)localObject).FAg.equals(""))) {
            ((bl.b)localObject).FAg = "";
          }
          if ((((bl.b)localObject).FAf == null) || (((bl.b)localObject).FAf.equals(""))) {
            ((bl.b)localObject).FAg = "";
          }
          if ((((bl.b)localObject).FAe == null) || (((bl.b)localObject).FAe.equals(""))) {
            ((bl.b)localObject).FAe = "";
          }
          if ((((bl.b)localObject).yGA == null) || (((bl.b)localObject).yGA.equals(""))) {
            ((bl.b)localObject).yGA = "";
          }
          if ((((bl.b)localObject).label == null) || (((bl.b)localObject).label.equals(""))) {
            ((bl.b)localObject).label = "";
          }
          if ((((bl.b)localObject).FAd == null) || (((bl.b)localObject).FAd.equals(""))) {
            ((bl.b)localObject).FAd = "";
          }
          localObject = "<msg><location x=\"" + ((bl.b)localObject).sOv + "\" y=\"" + ((bl.b)localObject).sOw + "\" scale=\"" + ((bl.b)localObject).dpd + "\" label=\"" + ((bl.b)localObject).label + "\" maptype=\"" + ((bl.b)localObject).FAd + "\"  fromusername=\"" + ((bl.b)localObject).yGA + "\" /></msg>";
          if ((bool) && (!paramAnonymousAddr.equals(""))) {}
          for (paramAnonymousAddr = paramAnonymousAddr + ":\n" + (String)localObject;; paramAnonymousAddr = (Addr)localObject)
          {
            ad.d("MicroMsg.LocationServer", "xml: ".concat(String.valueOf(paramAnonymousAddr)));
            localbl.setContent(paramAnonymousAddr);
            ((k)g.ab(k.class)).cOI().a(localbl.field_msgId, localbl);
            locala.sOD.remove(Long.valueOf(localbl.field_msgId));
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
  
  public final String[] ak(bl parambl)
  {
    int j = 1;
    AppMethodBeat.i(55681);
    String[] arrayOfString = new String[2];
    Object localObject2 = parambl.field_content;
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
    if (parambl.field_isSend == 0)
    {
      i = 1;
      localObject1 = localObject2;
      if (w.pF(parambl.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bi.uc((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject2 = ((k)g.ab(k.class)).cOI().agD((String)localObject1);
      if (!((bl.b)localObject2).eMH()) {
        break label347;
      }
      localObject1 = ((bl.b)localObject2).label;
      localObject2 = ((bl.b)localObject2).goQ;
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localObject2;
      if ((bt.isNullOrNil(arrayOfString[0])) && (bt.isNullOrNil(arrayOfString[1])))
      {
        ad.i("MicroMsg.LocationServer", "pull from sever");
        l = parambl.field_msgId;
        if ((this.sOD != null) && (!this.sOD.contains(Long.valueOf(l))))
        {
          localObject2 = parambl.field_content;
          if (parambl.field_isSend != 0) {
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
      if (w.pF(parambl.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bi.uc((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject1 = bl.b.aIP((String)localObject1);
      this.sOD.add(Long.valueOf(l));
      c.axQ().a(((bl.b)localObject1).sOv, ((bl.b)localObject1).sOw, this.sOE, Long.valueOf(parambl.field_msgId));
      AppMethodBeat.o(55681);
      return arrayOfString;
      i = 0;
      break;
      arrayOfString[0] = ((bl.b)localObject2).label;
      arrayOfString[1] = "";
      break label162;
    }
  }
  
  public final void cJi()
  {
    AppMethodBeat.i(55680);
    if (this.sOD != null) {
      this.sOD.clear();
    }
    c.axQ().a(this.sOE);
    AppMethodBeat.o(55680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */