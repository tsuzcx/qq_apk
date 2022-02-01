package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static String a(Context paramContext, ajn paramajn)
  {
    AppMethodBeat.i(106781);
    switch (paramajn.dataType)
    {
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 18: 
    case 21: 
    default: 
      paramContext = paramajn.desc;
      AppMethodBeat.o(106781);
      return paramContext;
    case 5: 
      str = "";
      paramContext = str;
      if (paramajn.GhL != null)
      {
        paramContext = str;
        if (paramajn.GhL.Gis != null) {
          paramContext = paramajn.GhL.Gis.link;
        }
      }
      if (bt.isNullOrNil(paramContext))
      {
        paramContext = paramajn.GgY;
        AppMethodBeat.o(106781);
        return paramContext;
      }
      AppMethodBeat.o(106781);
      return paramContext;
    case 22: 
      if (b.cuM())
      {
        AppMethodBeat.o(106781);
        return "";
      }
      paramContext = paramContext.getString(2131755775);
      AppMethodBeat.o(106781);
      return paramContext;
    case 17: 
      paramContext = paramContext.getString(2131755872);
      AppMethodBeat.o(106781);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(2131755926);
      AppMethodBeat.o(106781);
      return paramContext;
    case 19: 
      paramContext = paramContext.getString(2131755279);
    }
    try
    {
      paramajn = paramContext + " " + paramajn.GhL.GiJ.GgH;
      paramContext = paramajn;
    }
    catch (Exception paramajn)
    {
      label271:
      break label271;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(2131755782);
    try
    {
      com.tencent.mm.kernel.g.ajD();
      paramajn = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqk(paramajn.desc);
      paramajn = paramContext + " " + paramajn.nickname;
      paramContext = paramajn;
    }
    catch (Exception paramajn)
    {
      label341:
      break label341;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(2131755929) + " " + m.G(paramContext, paramajn.duration / 1000) + "\n";
    AppMethodBeat.o(106781);
    return paramContext;
    String str = paramajn.desc;
    paramContext = str;
    if (!bt.isNullOrNil(paramajn.title)) {
      paramContext = paramajn.title + " " + str;
    }
    AppMethodBeat.o(106781);
    return paramContext;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, int paramInt, ajn paramajn)
  {
    AppMethodBeat.i(106779);
    paramg.field_favProto.nZa.remove(paramInt);
    paramContext = a(paramContext, paramajn);
    if (paramContext == null) {}
    for (paramContext = "\n\n";; paramContext = "\n" + paramContext + "\n\n")
    {
      a(paramg, paramInt, agI(paramContext));
      AppMethodBeat.o(106779);
      return;
    }
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, int paramInt, String paramString)
  {
    AppMethodBeat.i(106782);
    ajn localajn = new ajn();
    localajn.ZI(1);
    localajn.aOg(paramString);
    paramg.field_favProto.nZa.add(paramInt, localajn);
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
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramLong);
        if ((localg.field_favProto != null) && (localg.field_favProto.nZa != null))
        {
          localObject1 = localg.field_favProto.nZa.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (((ajn)((Iterator)localObject1).next()).Ghm <= ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(false)) {
              continue;
            }
            i = 0;
            if (i != 0) {
              continue;
            }
            h.d(paramMMActivity, paramMMActivity.getString(2131758992, new Object[] { Integer.valueOf(((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimitInMB(false)) }), "", new DialogInterface.OnClickListener()
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
        com.tencent.mm.plugin.report.service.g.yhR.f(15378, new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        ad.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        localg.field_flag = 0;
        localg.field_updateTime = System.currentTimeMillis();
        localg.field_localId = -1L;
        localg.field_sourceType = 6;
        if (localg.field_favProto.Gjv != null)
        {
          localg.field_favProto.Gjv.aPh("");
          localg.field_favProto.Gjv.ZR(6);
          localg.field_favProto.Gjv.aPf(u.aAm());
        }
        localg.field_fromUser = u.aAm();
        Object localObject2;
        if (localg.field_type == 1)
        {
          localObject1 = new LinkedList();
          localg.field_favProto.bl((LinkedList)localObject1);
          a(localg, 0, agI(localg.field_favProto.desc));
          localg.field_localId = System.currentTimeMillis();
          localg.field_type = 18;
          localg.field_xml = com.tencent.mm.plugin.fav.a.g.t(localg);
          localObject1 = new akf();
          if (parama != null)
          {
            ((akf)localObject1).scene = parama.scene;
            ((akf)localObject1).ooi = parama.ooi;
            ((akf)localObject1).index = parama.index;
            ((akf)localObject1).query = parama.query;
            ((akf)localObject1).sessionId = parama.qXk;
            ((akf)localObject1).rsG = parama.rsG;
          }
          parama = new nj();
          parama.dBj.field_localId = localg.field_localId;
          parama.dBj.dBs = 5;
          parama.dBj.dBl = localg.field_xml;
          parama.dBj.context = paramMMActivity;
          localObject2 = new Bundle();
          localObject3 = localg.field_favProto.FpF;
          if (localObject3 != null)
          {
            ((Bundle)localObject2).putString("noteauthor", ((ajx)localObject3).Gjo);
            ((Bundle)localObject2).putString("noteeditor", ((ajx)localObject3).Gjp);
          }
          ((Bundle)localObject2).putLong("edittime", localg.field_updateTime);
          parama.dBj.dBq = ((Bundle)localObject2);
          parama.dBj.field_favProto = localg.field_favProto;
          parama.dBj.type = 2;
          parama.dBj.dBt = true;
          parama.dBj.dBu = ((akf)localObject1);
          a.IbL.l(parama);
          paramMMActivity.finish();
          AppMethodBeat.o(106778);
          return;
        }
        if (localg.field_favProto.nZa == null) {
          continue;
        }
        j = 1;
        i = 0;
        if (i >= localg.field_favProto.nZa.size()) {
          continue;
        }
        localObject3 = (ajn)localg.field_favProto.nZa.get(i);
        if ((localg.field_type != 18) || (!((ajn)localObject3).GhT.equals("WeNoteHtmlFile")))
        {
          localObject1 = b.d((ajn)localObject3);
          localObject2 = b.a((ajn)localObject3);
          ((ajn)localObject3).aOs(b.di(localObject3.toString(), 18));
          String str1 = b.d((ajn)localObject3);
          String str2 = b.a((ajn)localObject3);
          if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(str1)) && (com.tencent.mm.vfs.i.fv((String)localObject1))) {
            com.tencent.mm.vfs.i.mz((String)localObject1, str1);
          }
          if ((!bt.isNullOrNil((String)localObject2)) && (!bt.isNullOrNil(str2)) && (com.tencent.mm.vfs.i.fv((String)localObject2))) {
            com.tencent.mm.vfs.i.mz((String)localObject2, str2);
          }
        }
        if (localg.field_type == 18) {
          break label1262;
        }
        if (((ajn)localObject3).dataType == 1)
        {
          if (localg.field_type == 14)
          {
            if (((ajn)localObject3).desc == null)
            {
              localObject1 = "\n";
              if (((ajn)localObject3).GhN == null)
              {
                localObject2 = "";
                ((ajn)localObject3).aOg(agI((String)localObject2 + (String)localObject1 + "\n"));
                break label1299;
              }
            }
            else
            {
              localObject1 = ((ajn)localObject3).desc + "\n";
              continue;
            }
            localObject2 = ((ajn)localObject3).GhN + ":\n";
            continue;
          }
          if (bt.isNullOrNil(((ajn)localObject3).desc)) {
            break label1288;
          }
          ((ajn)localObject3).aOg(agI(((ajn)localObject3).desc));
          break label1299;
        }
        Object localObject1 = new StringBuilder("WeNote_");
        k = j + 1;
        ((ajn)localObject3).aOC(j);
        j = i;
        if (localg.field_type == 14)
        {
          j = i;
          if (((ajn)localObject3).GhN != null)
          {
            a(localg, i, agI(((ajn)localObject3).GhN + ":"));
            j = i + 1;
          }
        }
        i = ((ajn)localObject3).dataType;
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
        Toast.makeText(paramMMActivity, paramMMActivity.getString(2131758990), 0).show();
        AppMethodBeat.o(106778);
        return;
      }
      if (i == 0)
      {
        a(paramMMActivity, localg, j, (ajn)localObject3);
        if (((ajn)localObject3).dataType == 3)
        {
          ((ajn)localObject3).ZI(20);
          i = j;
          j = k;
          break label1299;
        }
      }
      else
      {
        if ((((ajn)localObject3).dataType != 4) || (((ajn)localObject3).GhL == null) || (((ajn)localObject3).GhL.GiM == null)) {
          continue;
        }
        a(paramMMActivity, localg, j, (ajn)localObject3);
        continue;
        label1262:
        if (((ajn)localObject3).dataType == 20)
        {
          ((ajn)localObject3).aOj("");
          ((ajn)localObject3).aOk("");
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
  
  private static String agI(String paramString)
  {
    AppMethodBeat.i(106780);
    paramString = paramString.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
    AppMethodBeat.o(106780);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.j
 * JD-Core Version:    0.7.0.1
 */