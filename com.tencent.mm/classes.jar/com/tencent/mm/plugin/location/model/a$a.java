package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import java.util.Set;

public final class a$a
{
  Set<Long> yFC;
  private c.a yFD;
  
  public a$a()
  {
    AppMethodBeat.i(55679);
    this.yFD = new c.a()
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
          localca = ((l)g.af(l.class)).eiy().Hb(l);
          if (!Util.isNullOrNil(paramAnonymousAddr.iUO))
          {
            String str = localca.field_content;
            if (localca.field_isSend != 0) {
              break label573;
            }
            i = 1;
            bool = ab.Eq(localca.field_talker);
            localObject = str;
            if (bool)
            {
              localObject = str;
              if (i != 0)
              {
                int j = bp.Kp(str);
                localObject = str;
                if (j != -1) {
                  localObject = str.substring(j + 1).trim();
                }
              }
            }
            localObject = ca.b.bkB((String)localObject);
            ((ca.b)localObject).label = paramAnonymousAddr.bbW();
            if ((!bool) || (i == 0)) {
              break label584;
            }
            i = bp.Kp(localca.field_content);
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
          if ((((ca.b)localObject).OqV == null) || (((ca.b)localObject).OqV.equals(""))) {
            ((ca.b)localObject).OqV = "";
          }
          if ((((ca.b)localObject).OqU == null) || (((ca.b)localObject).OqU.equals(""))) {
            ((ca.b)localObject).OqV = "";
          }
          if ((((ca.b)localObject).OqT == null) || (((ca.b)localObject).OqT.equals(""))) {
            ((ca.b)localObject).OqT = "";
          }
          if ((((ca.b)localObject).dkU == null) || (((ca.b)localObject).dkU.equals(""))) {
            ((ca.b)localObject).dkU = "";
          }
          if ((((ca.b)localObject).label == null) || (((ca.b)localObject).label.equals(""))) {
            ((ca.b)localObject).label = "";
          }
          if ((((ca.b)localObject).OqS == null) || (((ca.b)localObject).OqS.equals(""))) {
            ((ca.b)localObject).OqS = "";
          }
          localObject = "<msg><location x=\"" + ((ca.b)localObject).yFu + "\" y=\"" + ((ca.b)localObject).yFv + "\" scale=\"" + ((ca.b)localObject).dRt + "\" label=\"" + ((ca.b)localObject).label + "\" maptype=\"" + ((ca.b)localObject).OqS + "\"  fromusername=\"" + ((ca.b)localObject).dkU + "\" /></msg>";
          if ((bool) && (!paramAnonymousAddr.equals(""))) {}
          for (paramAnonymousAddr = paramAnonymousAddr + ":\n" + (String)localObject;; paramAnonymousAddr = (Addr)localObject)
          {
            Log.d("MicroMsg.LocationServer", "xml: ".concat(String.valueOf(paramAnonymousAddr)));
            localca.setContent(paramAnonymousAddr);
            ((l)g.af(l.class)).eiy().a(localca.field_msgId, localca);
            locala.yFC.remove(Long.valueOf(localca.field_msgId));
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
  
  public final String[] az(ca paramca)
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
      if (ab.Eq(paramca.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bp.Kp((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject2 = ((l)g.af(l.class)).eiy().aEL((String)localObject1);
      if (!((ca.b)localObject2).gEa()) {
        break label347;
      }
      localObject1 = ((ca.b)localObject2).label;
      localObject2 = ((ca.b)localObject2).kHV;
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localObject2;
      if ((Util.isNullOrNil(arrayOfString[0])) && (Util.isNullOrNil(arrayOfString[1])))
      {
        Log.i("MicroMsg.LocationServer", "pull from sever");
        l = paramca.field_msgId;
        if ((this.yFC != null) && (!this.yFC.contains(Long.valueOf(l))))
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
      if (ab.Eq(paramca.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = bp.Kp((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject1 = ca.b.bkB((String)localObject1);
      this.yFC.add(Long.valueOf(l));
      c.bbX().a(((ca.b)localObject1).yFu, ((ca.b)localObject1).yFv, this.yFD, Long.valueOf(paramca.field_msgId));
      AppMethodBeat.o(55681);
      return arrayOfString;
      i = 0;
      break;
      arrayOfString[0] = ((ca.b)localObject2).label;
      arrayOfString[1] = "";
      break label162;
    }
  }
  
  public final void ecJ()
  {
    AppMethodBeat.i(55680);
    if (this.yFC != null) {
      this.yFC.clear();
    }
    c.bbX().a(this.yFD);
    AppMethodBeat.o(55680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */