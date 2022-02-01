package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static String Yx(String paramString)
  {
    AppMethodBeat.i(106780);
    paramString = paramString.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
    AppMethodBeat.o(106780);
    return paramString;
  }
  
  private static String a(Context paramContext, afy paramafy)
  {
    AppMethodBeat.i(106781);
    switch (paramafy.dataType)
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
      paramContext = paramafy.desc;
      AppMethodBeat.o(106781);
      return paramContext;
    case 5: 
      str = "";
      paramContext = str;
      if (paramafy.DgT != null)
      {
        paramContext = str;
        if (paramafy.DgT.DhA != null) {
          paramContext = paramafy.DgT.DhA.link;
        }
      }
      if (bt.isNullOrNil(paramContext))
      {
        paramContext = paramafy.Dgg;
        AppMethodBeat.o(106781);
        return paramContext;
      }
      AppMethodBeat.o(106781);
      return paramContext;
    case 22: 
      if (b.chA())
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
      paramafy = paramContext + " " + paramafy.DgT.DhR.DfP;
      paramContext = paramafy;
    }
    catch (Exception paramafy)
    {
      label271:
      break label271;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(2131755782);
    try
    {
      com.tencent.mm.kernel.g.afC();
      paramafy = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().agC(paramafy.desc);
      paramafy = paramContext + " " + paramafy.nickname;
      paramContext = paramafy;
    }
    catch (Exception paramafy)
    {
      label341:
      break label341;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(2131755929) + " " + m.C(paramContext, paramafy.duration / 1000) + "\n";
    AppMethodBeat.o(106781);
    return paramContext;
    String str = paramafy.desc;
    paramContext = str;
    if (!bt.isNullOrNil(paramafy.title)) {
      paramContext = paramafy.title + " " + str;
    }
    AppMethodBeat.o(106781);
    return paramContext;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, int paramInt, afy paramafy)
  {
    AppMethodBeat.i(106779);
    paramg.field_favProto.mVb.remove(paramInt);
    paramContext = a(paramContext, paramafy);
    if (paramContext == null) {}
    for (paramContext = "\n\n";; paramContext = "\n" + paramContext + "\n\n")
    {
      a(paramg, paramInt, Yx(paramContext));
      AppMethodBeat.o(106779);
      return;
    }
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, int paramInt, String paramString)
  {
    AppMethodBeat.i(106782);
    afy localafy = new afy();
    localafy.VD(1);
    localafy.aDm(paramString);
    paramg.field_favProto.mVb.add(paramInt, localafy);
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
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong);
        if ((localg.field_favProto != null) && (localg.field_favProto.mVb != null))
        {
          localObject1 = localg.field_favProto.mVb.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (((afy)((Iterator)localObject1).next()).Dgu <= ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(false)) {
              continue;
            }
            i = 0;
            if (i != 0) {
              continue;
            }
            com.tencent.mm.ui.base.h.d(paramMMActivity, paramMMActivity.getString(2131758992, new Object[] { Integer.valueOf(((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimitInMB(false)) }), "", new DialogInterface.OnClickListener()
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
        com.tencent.mm.plugin.report.service.h.vKh.f(15378, new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        ad.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        localg.field_flag = 0;
        localg.field_updateTime = System.currentTimeMillis();
        localg.field_localId = -1L;
        localg.field_sourceType = 6;
        if (localg.field_favProto.DiD != null)
        {
          localg.field_favProto.DiD.aEn("");
          localg.field_favProto.DiD.VM(6);
          localg.field_favProto.DiD.aEl(u.aqG());
        }
        localg.field_fromUser = u.aqG();
        Object localObject2;
        if (localg.field_type == 1)
        {
          localObject1 = new LinkedList();
          localg.field_favProto.bd((LinkedList)localObject1);
          a(localg, 0, Yx(localg.field_favProto.desc));
          localg.field_localId = System.currentTimeMillis();
          localg.field_type = 18;
          localg.field_xml = com.tencent.mm.plugin.fav.a.g.t(localg);
          localObject1 = new agq();
          if (parama != null)
          {
            ((agq)localObject1).scene = parama.scene;
            ((agq)localObject1).niJ = parama.niJ;
            ((agq)localObject1).index = parama.index;
            ((agq)localObject1).query = parama.query;
            ((agq)localObject1).sessionId = parama.pZX;
            ((agq)localObject1).pZZ = parama.pZZ;
          }
          parama = new ms();
          parama.drL.field_localId = localg.field_localId;
          parama.drL.drU = 5;
          parama.drL.drN = localg.field_xml;
          parama.drL.context = paramMMActivity;
          localObject2 = new Bundle();
          localObject3 = localg.field_favProto.Csh;
          if (localObject3 != null)
          {
            ((Bundle)localObject2).putString("noteauthor", ((agi)localObject3).Diw);
            ((Bundle)localObject2).putString("noteeditor", ((agi)localObject3).Dix);
          }
          ((Bundle)localObject2).putLong("edittime", localg.field_updateTime);
          parama.drL.drS = ((Bundle)localObject2);
          parama.drL.field_favProto = localg.field_favProto;
          parama.drL.type = 2;
          parama.drL.drV = true;
          parama.drL.drW = ((agq)localObject1);
          a.ESL.l(parama);
          paramMMActivity.finish();
          AppMethodBeat.o(106778);
          return;
        }
        if (localg.field_favProto.mVb == null) {
          continue;
        }
        j = 1;
        i = 0;
        if (i >= localg.field_favProto.mVb.size()) {
          continue;
        }
        localObject3 = (afy)localg.field_favProto.mVb.get(i);
        if ((localg.field_type != 18) || (!((afy)localObject3).Dhb.equals("WeNoteHtmlFile")))
        {
          localObject1 = b.d((afy)localObject3);
          localObject2 = b.a((afy)localObject3);
          ((afy)localObject3).aDy(b.cT(localObject3.toString(), 18));
          String str1 = b.d((afy)localObject3);
          String str2 = b.a((afy)localObject3);
          if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(str1)) && (i.eK((String)localObject1))) {
            i.lC((String)localObject1, str1);
          }
          if ((!bt.isNullOrNil((String)localObject2)) && (!bt.isNullOrNil(str2)) && (i.eK((String)localObject2))) {
            i.lC((String)localObject2, str2);
          }
        }
        if (localg.field_type == 18) {
          break label1262;
        }
        if (((afy)localObject3).dataType == 1)
        {
          if (localg.field_type == 14)
          {
            if (((afy)localObject3).desc == null)
            {
              localObject1 = "\n";
              if (((afy)localObject3).DgV == null)
              {
                localObject2 = "";
                ((afy)localObject3).aDm(Yx((String)localObject2 + (String)localObject1 + "\n"));
                break label1299;
              }
            }
            else
            {
              localObject1 = ((afy)localObject3).desc + "\n";
              continue;
            }
            localObject2 = ((afy)localObject3).DgV + ":\n";
            continue;
          }
          if (bt.isNullOrNil(((afy)localObject3).desc)) {
            break label1288;
          }
          ((afy)localObject3).aDm(Yx(((afy)localObject3).desc));
          break label1299;
        }
        Object localObject1 = new StringBuilder("WeNote_");
        k = j + 1;
        ((afy)localObject3).aDI(j);
        j = i;
        if (localg.field_type == 14)
        {
          j = i;
          if (((afy)localObject3).DgV != null)
          {
            a(localg, i, Yx(((afy)localObject3).DgV + ":"));
            j = i + 1;
          }
        }
        i = ((afy)localObject3).dataType;
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
        a(paramMMActivity, localg, j, (afy)localObject3);
        if (((afy)localObject3).dataType == 3)
        {
          ((afy)localObject3).VD(20);
          i = j;
          j = k;
          break label1299;
        }
      }
      else
      {
        if ((((afy)localObject3).dataType != 4) || (((afy)localObject3).DgT == null) || (((afy)localObject3).DgT.DhU == null)) {
          continue;
        }
        a(paramMMActivity, localg, j, (afy)localObject3);
        continue;
        label1262:
        if (((afy)localObject3).dataType == 20)
        {
          ((afy)localObject3).aDp("");
          ((afy)localObject3).aDq("");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.j
 * JD-Core Version:    0.7.0.1
 */