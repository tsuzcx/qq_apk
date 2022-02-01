package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static String a(Context paramContext, aml paramaml)
  {
    AppMethodBeat.i(106781);
    switch (paramaml.dataType)
    {
    default: 
      paramContext = paramaml.desc;
      AppMethodBeat.o(106781);
      return paramContext;
    case 5: 
      str = "";
      paramContext = str;
      if (paramaml.Lwh != null)
      {
        paramContext = str;
        if (paramaml.Lwh.LwO != null) {
          paramContext = paramaml.Lwh.LwO.link;
        }
      }
      if (Util.isNullOrNil(paramContext))
      {
        paramContext = paramaml.Lvu;
        AppMethodBeat.o(106781);
        return paramContext;
      }
      AppMethodBeat.o(106781);
      return paramContext;
    case 22: 
      if (b.cUq())
      {
        AppMethodBeat.o(106781);
        return "";
      }
      paramContext = paramContext.getString(2131755853);
      AppMethodBeat.o(106781);
      return paramContext;
    case 17: 
      paramContext = paramContext.getString(2131755961);
      AppMethodBeat.o(106781);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(2131756018);
      AppMethodBeat.o(106781);
      return paramContext;
    case 19: 
      paramContext = paramContext.getString(2131755314);
    }
    try
    {
      paramaml = paramContext + " " + paramaml.Lwh.Lxf.Lve;
      paramContext = paramaml;
    }
    catch (Exception paramaml)
    {
      label263:
      break label263;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(2131755862);
    try
    {
      com.tencent.mm.kernel.g.aAi();
      paramaml = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEK(paramaml.desc);
      paramaml = paramContext + " " + paramaml.nickname;
      paramContext = paramaml;
    }
    catch (Exception paramaml)
    {
      label333:
      break label333;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(2131756022) + " " + m.J(paramContext, paramaml.duration / 1000) + "\n";
    AppMethodBeat.o(106781);
    return paramContext;
    String str = paramaml.desc;
    paramContext = str;
    if (!Util.isNullOrNil(paramaml.title)) {
      paramContext = paramaml.title + " " + str;
    }
    AppMethodBeat.o(106781);
    return paramContext;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, int paramInt, aml paramaml)
  {
    AppMethodBeat.i(106779);
    paramg.field_favProto.ppH.remove(paramInt);
    paramContext = a(paramContext, paramaml);
    if (paramContext == null) {}
    for (paramContext = "\n\n";; paramContext = "\n" + paramContext + "\n\n")
    {
      a(paramg, paramInt, asn(paramContext));
      AppMethodBeat.o(106779);
      return;
    }
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, int paramInt, String paramString)
  {
    AppMethodBeat.i(106782);
    aml localaml = new aml();
    localaml.ajd(1);
    localaml.bgg(paramString);
    paramg.field_favProto.ppH.add(paramInt, localaml);
    AppMethodBeat.o(106782);
  }
  
  public static void a(MMActivity paramMMActivity, long paramLong, h.a parama)
  {
    AppMethodBeat.i(106778);
    for (;;)
    {
      Object localObject3;
      int k;
      try
      {
        localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong);
        if ((localg.field_favProto != null) && (localg.field_favProto.ppH != null))
        {
          localObject1 = localg.field_favProto.ppH.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (((aml)((Iterator)localObject1).next()).LvI <= ((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(false)) {
              continue;
            }
            i = 0;
            if (i != 0) {
              continue;
            }
            com.tencent.mm.ui.base.h.d(paramMMActivity, paramMMActivity.getString(2131759317, new Object[] { Integer.valueOf(((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimitInMB(false)) }), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(106777);
                if (paramAnonymousDialogInterface != null) {
                  paramAnonymousDialogInterface.cancel();
                }
                AppMethodBeat.o(106777);
              }
            });
            AppMethodBeat.o(106778);
            return;
          }
        }
        i = 1;
        continue;
        com.tencent.mm.plugin.report.service.h.CyF.a(15378, new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        Log.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        localg.field_flag = 0;
        localg.field_updateTime = System.currentTimeMillis();
        localg.field_localId = -1L;
        localg.field_sourceType = 6;
        if (localg.field_favProto.Lya != null)
        {
          localg.field_favProto.Lya.bhh("");
          localg.field_favProto.Lya.ajm(6);
          localg.field_favProto.Lya.bhf(z.aTY());
        }
        localg.field_fromUser = z.aTY();
        Object localObject2;
        if (localg.field_type == 1)
        {
          localObject1 = new LinkedList();
          localg.field_favProto.bH((LinkedList)localObject1);
          a(localg, 0, asn(localg.field_favProto.desc));
          localg.field_localId = System.currentTimeMillis();
          localg.field_type = 18;
          localg.field_xml = com.tencent.mm.plugin.fav.a.g.t(localg);
          localObject1 = new and();
          if (parama != null)
          {
            ((and)localObject1).scene = parama.scene;
            ((and)localObject1).pHw = parama.pHw;
            ((and)localObject1).index = parama.index;
            ((and)localObject1).query = parama.query;
            ((and)localObject1).sessionId = parama.sGF;
            ((and)localObject1).tay = parama.tay;
          }
          parama = new oc();
          parama.dUe.field_localId = localg.field_localId;
          parama.dUe.dUn = 5;
          parama.dUe.dUg = localg.field_xml;
          parama.dUe.context = paramMMActivity;
          localObject2 = new Bundle();
          localObject3 = localg.field_favProto.KBr;
          if (localObject3 != null)
          {
            ((Bundle)localObject2).putString("noteauthor", ((amv)localObject3).LxT);
            ((Bundle)localObject2).putString("noteeditor", ((amv)localObject3).LxU);
          }
          ((Bundle)localObject2).putLong("edittime", localg.field_updateTime);
          parama.dUe.dUl = ((Bundle)localObject2);
          parama.dUe.field_favProto = localg.field_favProto;
          parama.dUe.type = 2;
          parama.dUe.dUo = true;
          parama.dUe.dUp = ((and)localObject1);
          EventCenter.instance.publish(parama);
          paramMMActivity.finish();
          AppMethodBeat.o(106778);
          return;
        }
        if (localg.field_favProto.ppH == null) {
          continue;
        }
        j = 1;
        i = 0;
        if (i >= localg.field_favProto.ppH.size()) {
          continue;
        }
        localObject3 = (aml)localg.field_favProto.ppH.get(i);
        if ((localg.field_type != 18) || (!((aml)localObject3).Lwp.equals("WeNoteHtmlFile")))
        {
          localObject1 = b.d((aml)localObject3);
          localObject2 = b.a((aml)localObject3);
          ((aml)localObject3).bgs(b.ds(localObject3.toString(), 18));
          String str1 = b.d((aml)localObject3);
          String str2 = b.a((aml)localObject3);
          if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str1)) && (s.YS((String)localObject1))) {
            s.nw((String)localObject1, str1);
          }
          if ((!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil(str2)) && (s.YS((String)localObject2))) {
            s.nw((String)localObject2, str2);
          }
        }
        if (localg.field_type == 18) {
          break label1262;
        }
        if (((aml)localObject3).dataType == 1)
        {
          if (localg.field_type == 14)
          {
            if (((aml)localObject3).desc == null)
            {
              localObject1 = "\n";
              if (((aml)localObject3).Lwj == null)
              {
                localObject2 = "";
                ((aml)localObject3).bgg(asn((String)localObject2 + (String)localObject1 + "\n"));
                break label1299;
              }
            }
            else
            {
              localObject1 = ((aml)localObject3).desc + "\n";
              continue;
            }
            localObject2 = ((aml)localObject3).Lwj + ":\n";
            continue;
          }
          if (Util.isNullOrNil(((aml)localObject3).desc)) {
            break label1288;
          }
          ((aml)localObject3).bgg(asn(((aml)localObject3).desc));
          break label1299;
        }
        Object localObject1 = new StringBuilder("WeNote_");
        k = j + 1;
        ((aml)localObject3).bgC(j);
        j = i;
        if (localg.field_type == 14)
        {
          j = i;
          if (((aml)localObject3).Lwj != null)
          {
            a(localg, i, asn(((aml)localObject3).Lwj + ":"));
            j = i + 1;
          }
        }
        i = ((aml)localObject3).dataType;
        if ((i == 1) || (i == 2) || (i == 3) || (i == 6) || (i == 8) || (i == 4) || (i == 0)) {
          break label1308;
        }
        if (i != 22) {
          break label1314;
        }
      }
      catch (Throwable parama)
      {
        com.tencent.mm.plugin.fav.a.g localg;
        Toast.makeText(paramMMActivity, paramMMActivity.getString(2131759315), 0).show();
        AppMethodBeat.o(106778);
        return;
      }
      if (i == 0)
      {
        a(paramMMActivity, localg, j, (aml)localObject3);
        if (((aml)localObject3).dataType == 3)
        {
          ((aml)localObject3).ajd(20);
          i = j;
          j = k;
          break label1299;
        }
      }
      else
      {
        if ((((aml)localObject3).dataType != 4) || (((aml)localObject3).Lwh == null) || (((aml)localObject3).Lwh.Lxi == null)) {
          continue;
        }
        a(paramMMActivity, localg, j, (aml)localObject3);
        continue;
        label1262:
        if (((aml)localObject3).dataType == 20)
        {
          ((aml)localObject3).bgj("");
          ((aml)localObject3).bgk("");
        }
        label1288:
        break label1299;
      }
      int i = j;
      int j = k;
      label1299:
      i += 1;
      continue;
      label1308:
      i = 1;
      continue;
      label1314:
      i = 0;
    }
  }
  
  private static String asn(String paramString)
  {
    AppMethodBeat.i(106780);
    paramString = paramString.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
    AppMethodBeat.o(106780);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.j
 * JD-Core Version:    0.7.0.1
 */