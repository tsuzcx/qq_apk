package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static String a(Context paramContext, ajx paramajx)
  {
    AppMethodBeat.i(106781);
    switch (paramajx.dataType)
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
      paramContext = paramajx.desc;
      AppMethodBeat.o(106781);
      return paramContext;
    case 5: 
      str = "";
      paramContext = str;
      if (paramajx.GAu != null)
      {
        paramContext = str;
        if (paramajx.GAu.GBb != null) {
          paramContext = paramajx.GAu.GBb.link;
        }
      }
      if (bu.isNullOrNil(paramContext))
      {
        paramContext = paramajx.GzH;
        AppMethodBeat.o(106781);
        return paramContext;
      }
      AppMethodBeat.o(106781);
      return paramContext;
    case 22: 
      if (b.cwn())
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
      paramajx = paramContext + " " + paramajx.GAu.GBs.Gzq;
      paramContext = paramajx;
    }
    catch (Exception paramajx)
    {
      label271:
      break label271;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(2131755782);
    try
    {
      com.tencent.mm.kernel.g.ajS();
      paramajx = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arp(paramajx.desc);
      paramajx = paramContext + " " + paramajx.nickname;
      paramContext = paramajx;
    }
    catch (Exception paramajx)
    {
      label341:
      break label341;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(2131755929) + " " + m.G(paramContext, paramajx.duration / 1000) + "\n";
    AppMethodBeat.o(106781);
    return paramContext;
    String str = paramajx.desc;
    paramContext = str;
    if (!bu.isNullOrNil(paramajx.title)) {
      paramContext = paramajx.title + " " + str;
    }
    AppMethodBeat.o(106781);
    return paramContext;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, int paramInt, ajx paramajx)
  {
    AppMethodBeat.i(106779);
    paramg.field_favProto.oeJ.remove(paramInt);
    paramContext = a(paramContext, paramajx);
    if (paramContext == null) {}
    for (paramContext = "\n\n";; paramContext = "\n" + paramContext + "\n\n")
    {
      a(paramg, paramInt, ahF(paramContext));
      AppMethodBeat.o(106779);
      return;
    }
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, int paramInt, String paramString)
  {
    AppMethodBeat.i(106782);
    ajx localajx = new ajx();
    localajx.aao(1);
    localajx.aPD(paramString);
    paramg.field_favProto.oeJ.add(paramInt, localajx);
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
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramLong);
        if ((localg.field_favProto != null) && (localg.field_favProto.oeJ != null))
        {
          localObject1 = localg.field_favProto.oeJ.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (((ajx)((Iterator)localObject1).next()).GzV <= ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(false)) {
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
        com.tencent.mm.plugin.report.service.g.yxI.f(15378, new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        ae.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        localg.field_flag = 0;
        localg.field_updateTime = System.currentTimeMillis();
        localg.field_localId = -1L;
        localg.field_sourceType = 6;
        if (localg.field_favProto.GCe != null)
        {
          localg.field_favProto.GCe.aQE("");
          localg.field_favProto.GCe.aax(6);
          localg.field_favProto.GCe.aQC(v.aAC());
        }
        localg.field_fromUser = v.aAC();
        Object localObject2;
        if (localg.field_type == 1)
        {
          localObject1 = new LinkedList();
          localg.field_favProto.bm((LinkedList)localObject1);
          a(localg, 0, ahF(localg.field_favProto.desc));
          localg.field_localId = System.currentTimeMillis();
          localg.field_type = 18;
          localg.field_xml = com.tencent.mm.plugin.fav.a.g.t(localg);
          localObject1 = new akp();
          if (parama != null)
          {
            ((akp)localObject1).scene = parama.scene;
            ((akp)localObject1).otZ = parama.otZ;
            ((akp)localObject1).index = parama.index;
            ((akp)localObject1).query = parama.query;
            ((akp)localObject1).sessionId = parama.rfp;
            ((akp)localObject1).rAT = parama.rAT;
          }
          parama = new nk();
          parama.dCo.field_localId = localg.field_localId;
          parama.dCo.dCx = 5;
          parama.dCo.dCq = localg.field_xml;
          parama.dCo.context = paramMMActivity;
          localObject2 = new Bundle();
          localObject3 = localg.field_favProto.FId;
          if (localObject3 != null)
          {
            ((Bundle)localObject2).putString("noteauthor", ((akh)localObject3).GBX);
            ((Bundle)localObject2).putString("noteeditor", ((akh)localObject3).GBY);
          }
          ((Bundle)localObject2).putLong("edittime", localg.field_updateTime);
          parama.dCo.dCv = ((Bundle)localObject2);
          parama.dCo.field_favProto = localg.field_favProto;
          parama.dCo.type = 2;
          parama.dCo.dCy = true;
          parama.dCo.dCz = ((akp)localObject1);
          a.IvT.l(parama);
          paramMMActivity.finish();
          AppMethodBeat.o(106778);
          return;
        }
        if (localg.field_favProto.oeJ == null) {
          continue;
        }
        j = 1;
        i = 0;
        if (i >= localg.field_favProto.oeJ.size()) {
          continue;
        }
        localObject3 = (ajx)localg.field_favProto.oeJ.get(i);
        if ((localg.field_type != 18) || (!((ajx)localObject3).GAC.equals("WeNoteHtmlFile")))
        {
          localObject1 = b.d((ajx)localObject3);
          localObject2 = b.a((ajx)localObject3);
          ((ajx)localObject3).aPP(b.dm(localObject3.toString(), 18));
          String str1 = b.d((ajx)localObject3);
          String str2 = b.a((ajx)localObject3);
          if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil(str1)) && (o.fB((String)localObject1))) {
            o.mF((String)localObject1, str1);
          }
          if ((!bu.isNullOrNil((String)localObject2)) && (!bu.isNullOrNil(str2)) && (o.fB((String)localObject2))) {
            o.mF((String)localObject2, str2);
          }
        }
        if (localg.field_type == 18) {
          break label1262;
        }
        if (((ajx)localObject3).dataType == 1)
        {
          if (localg.field_type == 14)
          {
            if (((ajx)localObject3).desc == null)
            {
              localObject1 = "\n";
              if (((ajx)localObject3).GAw == null)
              {
                localObject2 = "";
                ((ajx)localObject3).aPD(ahF((String)localObject2 + (String)localObject1 + "\n"));
                break label1299;
              }
            }
            else
            {
              localObject1 = ((ajx)localObject3).desc + "\n";
              continue;
            }
            localObject2 = ((ajx)localObject3).GAw + ":\n";
            continue;
          }
          if (bu.isNullOrNil(((ajx)localObject3).desc)) {
            break label1288;
          }
          ((ajx)localObject3).aPD(ahF(((ajx)localObject3).desc));
          break label1299;
        }
        Object localObject1 = new StringBuilder("WeNote_");
        k = j + 1;
        ((ajx)localObject3).aPZ(j);
        j = i;
        if (localg.field_type == 14)
        {
          j = i;
          if (((ajx)localObject3).GAw != null)
          {
            a(localg, i, ahF(((ajx)localObject3).GAw + ":"));
            j = i + 1;
          }
        }
        i = ((ajx)localObject3).dataType;
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
        a(paramMMActivity, localg, j, (ajx)localObject3);
        if (((ajx)localObject3).dataType == 3)
        {
          ((ajx)localObject3).aao(20);
          i = j;
          j = k;
          break label1299;
        }
      }
      else
      {
        if ((((ajx)localObject3).dataType != 4) || (((ajx)localObject3).GAu == null) || (((ajx)localObject3).GAu.GBv == null)) {
          continue;
        }
        a(paramMMActivity, localg, j, (ajx)localObject3);
        continue;
        label1262:
        if (((ajx)localObject3).dataType == 20)
        {
          ((ajx)localObject3).aPG("");
          ((ajx)localObject3).aPH("");
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
  
  private static String ahF(String paramString)
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