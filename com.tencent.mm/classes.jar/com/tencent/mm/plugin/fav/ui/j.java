package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static String a(Context paramContext, agx paramagx)
  {
    AppMethodBeat.i(106781);
    switch (paramagx.dataType)
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
      paramContext = paramagx.desc;
      AppMethodBeat.o(106781);
      return paramContext;
    case 5: 
      str = "";
      paramContext = str;
      if (paramagx.EzZ != null)
      {
        paramContext = str;
        if (paramagx.EzZ.EAG != null) {
          paramContext = paramagx.EzZ.EAG.link;
        }
      }
      if (bs.isNullOrNil(paramContext))
      {
        paramContext = paramagx.Ezm;
        AppMethodBeat.o(106781);
        return paramContext;
      }
      AppMethodBeat.o(106781);
      return paramContext;
    case 22: 
      if (b.cph())
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
      paramagx = paramContext + " " + paramagx.EzZ.EAX.EyV;
      paramContext = paramagx;
    }
    catch (Exception paramagx)
    {
      label271:
      break label271;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(2131755782);
    try
    {
      com.tencent.mm.kernel.g.agS();
      paramagx = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().alw(paramagx.desc);
      paramagx = paramContext + " " + paramagx.nickname;
      paramContext = paramagx;
    }
    catch (Exception paramagx)
    {
      label341:
      break label341;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(2131755929) + " " + m.F(paramContext, paramagx.duration / 1000) + "\n";
    AppMethodBeat.o(106781);
    return paramContext;
    String str = paramagx.desc;
    paramContext = str;
    if (!bs.isNullOrNil(paramagx.title)) {
      paramContext = paramagx.title + " " + str;
    }
    AppMethodBeat.o(106781);
    return paramContext;
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.fav.a.g paramg, int paramInt, agx paramagx)
  {
    AppMethodBeat.i(106779);
    paramg.field_favProto.nxC.remove(paramInt);
    paramContext = a(paramContext, paramagx);
    if (paramContext == null) {}
    for (paramContext = "\n\n";; paramContext = "\n" + paramContext + "\n\n")
    {
      a(paramg, paramInt, acT(paramContext));
      AppMethodBeat.o(106779);
      return;
    }
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, int paramInt, String paramString)
  {
    AppMethodBeat.i(106782);
    agx localagx = new agx();
    localagx.XM(1);
    localagx.aID(paramString);
    paramg.field_favProto.nxC.add(paramInt, localagx);
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
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong);
        if ((localg.field_favProto != null) && (localg.field_favProto.nxC != null))
        {
          localObject1 = localg.field_favProto.nxC.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (((agx)((Iterator)localObject1).next()).EzA <= ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(false)) {
              continue;
            }
            i = 0;
            if (i != 0) {
              continue;
            }
            com.tencent.mm.ui.base.h.d(paramMMActivity, paramMMActivity.getString(2131758992, new Object[] { Integer.valueOf(((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimitInMB(false)) }), "", new j.1());
            AppMethodBeat.o(106778);
            return;
          }
        }
        i = 1;
        continue;
        com.tencent.mm.plugin.report.service.h.wUl.f(15378, new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        ac.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        localg.field_flag = 0;
        localg.field_updateTime = System.currentTimeMillis();
        localg.field_localId = -1L;
        localg.field_sourceType = 6;
        if (localg.field_favProto.EBJ != null)
        {
          localg.field_favProto.EBJ.aJE("");
          localg.field_favProto.EBJ.XV(6);
          localg.field_favProto.EBJ.aJC(u.axw());
        }
        localg.field_fromUser = u.axw();
        Object localObject2;
        if (localg.field_type == 1)
        {
          localObject1 = new LinkedList();
          localg.field_favProto.bk((LinkedList)localObject1);
          a(localg, 0, acT(localg.field_favProto.desc));
          localg.field_localId = System.currentTimeMillis();
          localg.field_type = 18;
          localg.field_xml = com.tencent.mm.plugin.fav.a.g.t(localg);
          localObject1 = new ahp();
          if (parama != null)
          {
            ((ahp)localObject1).scene = parama.scene;
            ((ahp)localObject1).nLC = parama.nLC;
            ((ahp)localObject1).index = parama.index;
            ((ahp)localObject1).query = parama.query;
            ((ahp)localObject1).sessionId = parama.qon;
            ((ahp)localObject1).qIF = parama.qIF;
          }
          parama = new nb();
          parama.dpw.field_localId = localg.field_localId;
          parama.dpw.dpF = 5;
          parama.dpw.dpy = localg.field_xml;
          parama.dpw.context = paramMMActivity;
          localObject2 = new Bundle();
          localObject3 = localg.field_favProto.DKz;
          if (localObject3 != null)
          {
            ((Bundle)localObject2).putString("noteauthor", ((ahh)localObject3).EBC);
            ((Bundle)localObject2).putString("noteeditor", ((ahh)localObject3).EBD);
          }
          ((Bundle)localObject2).putLong("edittime", localg.field_updateTime);
          parama.dpw.dpD = ((Bundle)localObject2);
          parama.dpw.field_favProto = localg.field_favProto;
          parama.dpw.type = 2;
          parama.dpw.dpG = true;
          parama.dpw.dpH = ((ahp)localObject1);
          a.GpY.l(parama);
          paramMMActivity.finish();
          AppMethodBeat.o(106778);
          return;
        }
        if (localg.field_favProto.nxC == null) {
          continue;
        }
        j = 1;
        i = 0;
        if (i >= localg.field_favProto.nxC.size()) {
          continue;
        }
        localObject3 = (agx)localg.field_favProto.nxC.get(i);
        if ((localg.field_type != 18) || (!((agx)localObject3).EAh.equals("WeNoteHtmlFile")))
        {
          localObject1 = b.d((agx)localObject3);
          localObject2 = b.a((agx)localObject3);
          ((agx)localObject3).aIP(b.cY(localObject3.toString(), 18));
          String str1 = b.d((agx)localObject3);
          String str2 = b.a((agx)localObject3);
          if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil(str1)) && (i.eA((String)localObject1))) {
            i.lZ((String)localObject1, str1);
          }
          if ((!bs.isNullOrNil((String)localObject2)) && (!bs.isNullOrNil(str2)) && (i.eA((String)localObject2))) {
            i.lZ((String)localObject2, str2);
          }
        }
        if (localg.field_type == 18) {
          break label1262;
        }
        if (((agx)localObject3).dataType == 1)
        {
          if (localg.field_type == 14)
          {
            if (((agx)localObject3).desc == null)
            {
              localObject1 = "\n";
              if (((agx)localObject3).EAb == null)
              {
                localObject2 = "";
                ((agx)localObject3).aID(acT((String)localObject2 + (String)localObject1 + "\n"));
                break label1299;
              }
            }
            else
            {
              localObject1 = ((agx)localObject3).desc + "\n";
              continue;
            }
            localObject2 = ((agx)localObject3).EAb + ":\n";
            continue;
          }
          if (bs.isNullOrNil(((agx)localObject3).desc)) {
            break label1288;
          }
          ((agx)localObject3).aID(acT(((agx)localObject3).desc));
          break label1299;
        }
        Object localObject1 = new StringBuilder("WeNote_");
        k = j + 1;
        ((agx)localObject3).aIZ(j);
        j = i;
        if (localg.field_type == 14)
        {
          j = i;
          if (((agx)localObject3).EAb != null)
          {
            a(localg, i, acT(((agx)localObject3).EAb + ":"));
            j = i + 1;
          }
        }
        i = ((agx)localObject3).dataType;
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
        a(paramMMActivity, localg, j, (agx)localObject3);
        if (((agx)localObject3).dataType == 3)
        {
          ((agx)localObject3).XM(20);
          i = j;
          j = k;
          break label1299;
        }
      }
      else
      {
        if ((((agx)localObject3).dataType != 4) || (((agx)localObject3).EzZ == null) || (((agx)localObject3).EzZ.EBa == null)) {
          continue;
        }
        a(paramMMActivity, localg, j, (agx)localObject3);
        continue;
        label1262:
        if (((agx)localObject3).dataType == 20)
        {
          ((agx)localObject3).aIG("");
          ((agx)localObject3).aIH("");
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
  
  private static String acT(String paramString)
  {
    AppMethodBeat.i(106780);
    paramString = paramString.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
    AppMethodBeat.o(106780);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.j
 * JD-Core Version:    0.7.0.1
 */