package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.c;
import java.util.Set;

public final class a$a
{
  Set<Long> Kce;
  private c.a Kcf;
  
  public a$a()
  {
    AppMethodBeat.i(55679);
    this.Kcf = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(55678);
        a.a locala = a.a.this;
        cc localcc;
        int i;
        boolean bool;
        Object localObject;
        if ((paramAnonymousAddr.tag != null) && ((paramAnonymousAddr.tag instanceof Long)))
        {
          long l = ((Long)paramAnonymousAddr.tag).longValue();
          localcc = ((n)h.ax(n.class)).gaZ().sl(l);
          if (!Util.isNullOrNil(paramAnonymousAddr.oDI))
          {
            String str = localcc.field_content;
            if (localcc.field_isSend != 0) {
              break label573;
            }
            i = 1;
            bool = au.bwE(localcc.field_talker);
            localObject = str;
            if (bool)
            {
              localObject = str;
              if (i != 0)
              {
                int j = br.JG(str);
                localObject = str;
                if (j != -1) {
                  localObject = str.substring(j + 1).trim();
                }
              }
            }
            localObject = cc.c.byt((String)localObject);
            ((cc.c)localObject).label = paramAnonymousAddr.bJg();
            if ((!bool) || (i == 0)) {
              break label584;
            }
            i = br.JG(localcc.field_content);
            if (i == -1) {
              break label584;
            }
            paramAnonymousAddr = localcc.field_content.substring(0, i).trim();
            if (paramAnonymousAddr.length() <= 0) {
              break label584;
            }
          }
        }
        for (;;)
        {
          if ((((cc.c)localObject).adkL == null) || (((cc.c)localObject).adkL.equals(""))) {
            ((cc.c)localObject).adkL = "";
          }
          if ((((cc.c)localObject).adkK == null) || (((cc.c)localObject).adkK.equals(""))) {
            ((cc.c)localObject).adkL = "";
          }
          if ((((cc.c)localObject).adkJ == null) || (((cc.c)localObject).adkJ.equals(""))) {
            ((cc.c)localObject).adkJ = "";
          }
          if ((((cc.c)localObject).hgk == null) || (((cc.c)localObject).hgk.equals(""))) {
            ((cc.c)localObject).hgk = "";
          }
          if ((((cc.c)localObject).label == null) || (((cc.c)localObject).label.equals(""))) {
            ((cc.c)localObject).label = "";
          }
          if ((((cc.c)localObject).adkI == null) || (((cc.c)localObject).adkI.equals(""))) {
            ((cc.c)localObject).adkI = "";
          }
          localObject = "<msg><location x=\"" + ((cc.c)localObject).KbW + "\" y=\"" + ((cc.c)localObject).KbX + "\" scale=\"" + ((cc.c)localObject).hQp + "\" label=\"" + ((cc.c)localObject).label + "\" maptype=\"" + ((cc.c)localObject).adkI + "\"  fromusername=\"" + ((cc.c)localObject).hgk + "\" /></msg>";
          if ((bool) && (!paramAnonymousAddr.equals(""))) {}
          for (paramAnonymousAddr = paramAnonymousAddr + ":\n" + (String)localObject;; paramAnonymousAddr = (Addr)localObject)
          {
            Log.d("MicroMsg.LocationServer", "xml: ".concat(String.valueOf(paramAnonymousAddr)));
            localcc.setContent(paramAnonymousAddr);
            ((n)h.ax(n.class)).gaZ().a(localcc.field_msgId, localcc);
            locala.Kce.remove(Long.valueOf(localcc.field_msgId));
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
  
  public final String[] aX(cc paramcc)
  {
    int j = 1;
    AppMethodBeat.i(55681);
    String[] arrayOfString = new String[2];
    Object localObject2 = paramcc.field_content;
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
    if (paramcc.field_isSend == 0)
    {
      i = 1;
      localObject1 = localObject2;
      if (au.bwE(paramcc.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = br.JG((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject2 = ((n)h.ax(n.class)).gaZ().aLV((String)localObject1);
      if (!((cc.c)localObject2).jcw()) {
        break label347;
      }
      localObject1 = ((cc.c)localObject2).label;
      localObject2 = ((cc.c)localObject2).poiName;
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localObject2;
      if ((Util.isNullOrNil(arrayOfString[0])) && (Util.isNullOrNil(arrayOfString[1])))
      {
        Log.i("MicroMsg.LocationServer", "pull from sever");
        l = paramcc.field_msgId;
        if ((this.Kce != null) && (!this.Kce.contains(Long.valueOf(l))))
        {
          localObject2 = paramcc.field_content;
          if (paramcc.field_isSend != 0) {
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
      if (au.bwE(paramcc.field_talker))
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          i = br.JG((String)localObject2);
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = ((String)localObject2).substring(i + 1).trim();
          }
        }
      }
      localObject1 = cc.c.byt((String)localObject1);
      this.Kce.add(Long.valueOf(l));
      c.bJh().a(((cc.c)localObject1).KbW, ((cc.c)localObject1).KbX, this.Kcf, Long.valueOf(paramcc.field_msgId));
      AppMethodBeat.o(55681);
      return arrayOfString;
      i = 0;
      break;
      arrayOfString[0] = ((cc.c)localObject2).label;
      arrayOfString[1] = "";
      break label162;
    }
  }
  
  public final void fUu()
  {
    AppMethodBeat.i(55680);
    if (this.Kce != null) {
      this.Kce.clear();
    }
    c.bJh().a(this.Kcf);
    AppMethodBeat.o(55680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */