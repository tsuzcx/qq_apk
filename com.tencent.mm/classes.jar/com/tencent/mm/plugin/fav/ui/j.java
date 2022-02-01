package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static String a(Context paramContext, anm paramanm)
  {
    AppMethodBeat.i(106781);
    switch (paramanm.dataType)
    {
    default: 
      paramContext = paramanm.desc;
      AppMethodBeat.o(106781);
      return paramContext;
    case 5: 
      str = "";
      paramContext = str;
      if (paramanm.SyG != null)
      {
        paramContext = str;
        if (paramanm.SyG.Szn != null) {
          paramContext = paramanm.SyG.Szn.link;
        }
      }
      if (Util.isNullOrNil(paramContext))
      {
        paramContext = paramanm.SxU;
        AppMethodBeat.o(106781);
        return paramContext;
      }
      AppMethodBeat.o(106781);
      return paramContext;
    case 22: 
      if (b.djw())
      {
        AppMethodBeat.o(106781);
        return "";
      }
      paramContext = paramContext.getString(s.i.app_finder);
      AppMethodBeat.o(106781);
      return paramContext;
    case 17: 
      paramContext = paramContext.getString(s.i.app_record);
      AppMethodBeat.o(106781);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(s.i.app_video);
      AppMethodBeat.o(106781);
      return paramContext;
    case 19: 
      paramContext = paramContext.getString(s.i.app_app_brand);
    }
    try
    {
      paramanm = paramContext + " " + paramanm.SyG.SzE.SxE;
      paramContext = paramanm;
    }
    catch (Exception paramanm)
    {
      label267:
      break label267;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(s.i.app_friend_card);
    try
    {
      com.tencent.mm.kernel.h.aHH();
      paramanm = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOU(paramanm.desc);
      paramanm = paramContext + " " + paramanm.nickname;
      paramContext = paramanm;
    }
    catch (Exception paramanm)
    {
      label338:
      break label338;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(s.i.app_voice) + " " + m.N(paramContext, paramanm.duration / 1000) + "\n";
    AppMethodBeat.o(106781);
    return paramContext;
    String str = paramanm.desc;
    paramContext = str;
    if (!Util.isNullOrNil(paramanm.title)) {
      paramContext = paramanm.title + " " + str;
    }
    AppMethodBeat.o(106781);
    return paramContext;
  }
  
  private static void a(Context paramContext, g paramg, int paramInt, anm paramanm)
  {
    AppMethodBeat.i(106779);
    paramg.field_favProto.syG.remove(paramInt);
    paramContext = a(paramContext, paramanm);
    if (paramContext == null) {}
    for (paramContext = "\n\n";; paramContext = "\n" + paramContext + "\n\n")
    {
      a(paramg, paramInt, aAo(paramContext));
      AppMethodBeat.o(106779);
      return;
    }
  }
  
  private static void a(g paramg, int paramInt, String paramString)
  {
    AppMethodBeat.i(106782);
    anm localanm = new anm();
    localanm.arq(1);
    localanm.bsy(paramString);
    paramg.field_favProto.syG.add(paramInt, localanm);
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
        localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong);
        if ((localg.field_favProto != null) && (localg.field_favProto.syG != null))
        {
          localObject1 = localg.field_favProto.syG.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (((anm)((Iterator)localObject1).next()).Syi <= ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimit(false)) {
              continue;
            }
            i = 0;
            if (i != 0) {
              continue;
            }
            com.tencent.mm.ui.base.h.d(paramMMActivity, paramMMActivity.getString(s.i.favorite_save_as_note_failed_bigfile, new Object[] { Integer.valueOf(((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimitInMB(false)) }), "", new DialogInterface.OnClickListener()
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
        com.tencent.mm.plugin.report.service.h.IzE.a(15378, new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        Log.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        localg.field_flag = 0;
        localg.field_updateTime = System.currentTimeMillis();
        localg.field_localId = -1L;
        localg.field_sourceType = 6;
        if (localg.field_favProto.SAB != null)
        {
          localg.field_favProto.SAB.btz("");
          localg.field_favProto.SAB.arz(6);
          localg.field_favProto.SAB.btx(z.bcZ());
        }
        localg.field_fromUser = z.bcZ();
        Object localObject2;
        if (localg.field_type == 1)
        {
          localObject1 = new LinkedList();
          localg.field_favProto.cg((LinkedList)localObject1);
          a(localg, 0, aAo(localg.field_favProto.desc));
          localg.field_localId = System.currentTimeMillis();
          localg.field_type = 18;
          localg.field_xml = g.t(localg);
          localObject1 = new aoe();
          if (parama != null)
          {
            ((aoe)localObject1).scene = parama.scene;
            ((aoe)localObject1).wGA = parama.wGA;
            ((aoe)localObject1).index = parama.index;
            ((aoe)localObject1).query = parama.query;
            ((aoe)localObject1).sessionId = parama.wmA;
            ((aoe)localObject1).wGC = parama.wGC;
          }
          parama = new oz();
          parama.fNG.field_localId = localg.field_localId;
          parama.fNG.fNP = 5;
          parama.fNG.fNI = localg.field_xml;
          parama.fNG.context = paramMMActivity;
          localObject2 = new Bundle();
          localObject3 = localg.field_favProto.RDh;
          if (localObject3 != null)
          {
            ((Bundle)localObject2).putString("noteauthor", ((anw)localObject3).SAu);
            ((Bundle)localObject2).putString("noteeditor", ((anw)localObject3).SAv);
          }
          ((Bundle)localObject2).putLong("edittime", localg.field_updateTime);
          parama.fNG.fNN = ((Bundle)localObject2);
          parama.fNG.field_favProto = localg.field_favProto;
          parama.fNG.type = 2;
          parama.fNG.fNQ = true;
          parama.fNG.fNR = ((aoe)localObject1);
          EventCenter.instance.publish(parama);
          paramMMActivity.finish();
          AppMethodBeat.o(106778);
          return;
        }
        if (localg.field_favProto.syG == null) {
          continue;
        }
        j = 1;
        i = 0;
        if (i >= localg.field_favProto.syG.size()) {
          continue;
        }
        localObject3 = (anm)localg.field_favProto.syG.get(i);
        if ((localg.field_type != 18) || (!((anm)localObject3).SyO.equals("WeNoteHtmlFile")))
        {
          localObject1 = b.d((anm)localObject3);
          localObject2 = b.a((anm)localObject3);
          ((anm)localObject3).bsK(b.dN(localObject3.toString(), 18));
          String str1 = b.d((anm)localObject3);
          String str2 = b.a((anm)localObject3);
          if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str1)) && (u.agG((String)localObject1))) {
            u.on((String)localObject1, str1);
          }
          if ((!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil(str2)) && (u.agG((String)localObject2))) {
            u.on((String)localObject2, str2);
          }
        }
        if (localg.field_type == 18) {
          break label1262;
        }
        if (((anm)localObject3).dataType == 1)
        {
          if (localg.field_type == 14)
          {
            if (((anm)localObject3).desc == null)
            {
              localObject1 = "\n";
              if (((anm)localObject3).SyI == null)
              {
                localObject2 = "";
                ((anm)localObject3).bsy(aAo((String)localObject2 + (String)localObject1 + "\n"));
                break label1299;
              }
            }
            else
            {
              localObject1 = ((anm)localObject3).desc + "\n";
              continue;
            }
            localObject2 = ((anm)localObject3).SyI + ":\n";
            continue;
          }
          if (Util.isNullOrNil(((anm)localObject3).desc)) {
            break label1288;
          }
          ((anm)localObject3).bsy(aAo(((anm)localObject3).desc));
          break label1299;
        }
        Object localObject1 = new StringBuilder("WeNote_");
        k = j + 1;
        ((anm)localObject3).bsU(j);
        j = i;
        if (localg.field_type == 14)
        {
          j = i;
          if (((anm)localObject3).SyI != null)
          {
            a(localg, i, aAo(((anm)localObject3).SyI + ":"));
            j = i + 1;
          }
        }
        i = ((anm)localObject3).dataType;
        if ((i == 1) || (i == 2) || (i == 3) || (i == 6) || (i == 8) || (i == 4) || (i == 0)) {
          break label1308;
        }
        if (i != 22) {
          break label1314;
        }
      }
      catch (Throwable parama)
      {
        g localg;
        Toast.makeText(paramMMActivity, paramMMActivity.getString(s.i.favorite_save_as_note_failed), 0).show();
        AppMethodBeat.o(106778);
        return;
      }
      if (i == 0)
      {
        a(paramMMActivity, localg, j, (anm)localObject3);
        if (((anm)localObject3).dataType == 3)
        {
          ((anm)localObject3).arq(20);
          i = j;
          j = k;
          break label1299;
        }
      }
      else
      {
        if ((((anm)localObject3).dataType != 4) || (((anm)localObject3).SyG == null) || (((anm)localObject3).SyG.SzH == null)) {
          continue;
        }
        a(paramMMActivity, localg, j, (anm)localObject3);
        continue;
        label1262:
        if (((anm)localObject3).dataType == 20)
        {
          ((anm)localObject3).bsB("");
          ((anm)localObject3).bsC("");
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
  
  private static String aAo(String paramString)
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