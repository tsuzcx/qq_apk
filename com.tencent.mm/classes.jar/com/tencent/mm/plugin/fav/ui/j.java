package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ql;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static String a(Context paramContext, arf paramarf)
  {
    AppMethodBeat.i(106781);
    switch (paramarf.dataType)
    {
    default: 
      paramContext = paramarf.desc;
      AppMethodBeat.o(106781);
      return paramContext;
    case 5: 
      str = "";
      paramContext = str;
      if (paramarf.Zzy != null)
      {
        paramContext = str;
        if (paramarf.Zzy.ZAf != null) {
          paramContext = paramarf.Zzy.ZAf.link;
        }
      }
      if (Util.isNullOrNil(paramContext))
      {
        paramContext = paramarf.ZyM;
        AppMethodBeat.o(106781);
        return paramContext;
      }
      AppMethodBeat.o(106781);
      return paramContext;
    case 22: 
      if (b.dQh())
      {
        AppMethodBeat.o(106781);
        return "";
      }
      paramContext = paramContext.getString(q.i.app_finder);
      AppMethodBeat.o(106781);
      return paramContext;
    case 17: 
      paramContext = paramContext.getString(q.i.app_record);
      AppMethodBeat.o(106781);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(q.i.app_video);
      AppMethodBeat.o(106781);
      return paramContext;
    case 19: 
      paramContext = paramContext.getString(q.i.app_app_brand);
    }
    try
    {
      paramarf = paramContext + " " + paramarf.Zzy.ZAw.Zyw;
      paramContext = paramarf;
    }
    catch (Exception paramarf)
    {
      label267:
      break label267;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(q.i.app_friend_card);
    try
    {
      com.tencent.mm.kernel.h.baF();
      paramarf = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(paramarf.desc);
      paramarf = paramContext + " " + paramarf.nickname;
      paramContext = paramarf;
    }
    catch (Exception paramarf)
    {
      label338:
      break label338;
    }
    AppMethodBeat.o(106781);
    return paramContext;
    paramContext = paramContext.getString(q.i.app_voice) + " " + m.Q(paramContext, paramarf.duration / 1000) + "\n";
    AppMethodBeat.o(106781);
    return paramContext;
    String str = paramarf.desc;
    paramContext = str;
    if (!Util.isNullOrNil(paramarf.title)) {
      paramContext = paramarf.title + " " + str;
    }
    AppMethodBeat.o(106781);
    return paramContext;
  }
  
  private static void a(Context paramContext, g paramg, int paramInt, arf paramarf)
  {
    AppMethodBeat.i(106779);
    paramg.field_favProto.vEn.remove(paramInt);
    paramContext = a(paramContext, paramarf);
    if (paramContext == null) {}
    for (paramContext = "\n\n";; paramContext = "\n" + paramContext + "\n\n")
    {
      a(paramg, paramInt, auv(paramContext));
      AppMethodBeat.o(106779);
      return;
    }
  }
  
  private static void a(g paramg, int paramInt, String paramString)
  {
    AppMethodBeat.i(106782);
    arf localarf = new arf();
    localarf.axy(1);
    localarf.bsp(paramString);
    paramg.field_favProto.vEn.add(paramInt, localarf);
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
        localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramLong);
        if ((localg.field_favProto != null) && (localg.field_favProto.vEn != null))
        {
          localObject1 = localg.field_favProto.vEn.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (((arf)((Iterator)localObject1).next()).Zza <= ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimit(false)) {
              continue;
            }
            i = 0;
            if (i != 0) {
              continue;
            }
            k.d(paramMMActivity, paramMMActivity.getString(q.i.favorite_save_as_note_failed_bigfile, new Object[] { Integer.valueOf(((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimitInMB(false)) }), "", new DialogInterface.OnClickListener()
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
        com.tencent.mm.plugin.report.service.h.OAn.b(15378, new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        Log.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        localg.field_flag = 0;
        localg.field_updateTime = System.currentTimeMillis();
        localg.field_localId = -1L;
        localg.field_sourceType = 6;
        if (localg.field_favProto.ZBt != null)
        {
          localg.field_favProto.ZBt.btq("");
          localg.field_favProto.ZBt.axH(6);
          localg.field_favProto.ZBt.bto(z.bAM());
        }
        localg.field_fromUser = z.bAM();
        Object localObject2;
        if (localg.field_type == 1)
        {
          localObject1 = new LinkedList();
          localg.field_favProto.cs((LinkedList)localObject1);
          a(localg, 0, auv(localg.field_favProto.desc));
          localg.field_localId = System.currentTimeMillis();
          localg.field_type = 18;
          localg.field_xml = g.t(localg);
          localObject1 = new arx();
          if (parama != null)
          {
            ((arx)localObject1).scene = parama.scene;
            ((arx)localObject1).AcJ = parama.AcJ;
            ((arx)localObject1).index = parama.index;
            ((arx)localObject1).query = parama.query;
            ((arx)localObject1).sessionId = parama.zIC;
            ((arx)localObject1).AcL = parama.AcL;
          }
          parama = new ql();
          parama.hTy.field_localId = localg.field_localId;
          parama.hTy.hTG = 5;
          parama.hTy.hTA = localg.field_xml;
          parama.hTy.context = paramMMActivity;
          localObject2 = new Bundle();
          localObject3 = localg.field_favProto.YzK;
          if (localObject3 != null)
          {
            ((Bundle)localObject2).putString("noteauthor", ((arp)localObject3).ZBm);
            ((Bundle)localObject2).putString("noteeditor", ((arp)localObject3).ZBn);
          }
          ((Bundle)localObject2).putLong("edittime", localg.field_updateTime);
          parama.hTy.hTF = ((Bundle)localObject2);
          parama.hTy.field_favProto = localg.field_favProto;
          parama.hTy.type = 2;
          parama.hTy.hTH = true;
          parama.hTy.hTI = ((arx)localObject1);
          parama.publish();
          paramMMActivity.finish();
          AppMethodBeat.o(106778);
          return;
        }
        if (localg.field_favProto.vEn == null) {
          continue;
        }
        j = 1;
        i = 0;
        if (i >= localg.field_favProto.vEn.size()) {
          continue;
        }
        localObject3 = (arf)localg.field_favProto.vEn.get(i);
        if ((localg.field_type != 18) || (!((arf)localObject3).ZzG.equals("WeNoteHtmlFile")))
        {
          localObject1 = b.d((arf)localObject3);
          localObject2 = b.a((arf)localObject3);
          ((arf)localObject3).bsB(b.er(localObject3.toString(), 18));
          String str1 = b.d((arf)localObject3);
          String str2 = b.a((arf)localObject3);
          if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str1)) && (com.tencent.mm.vfs.y.ZC((String)localObject1))) {
            com.tencent.mm.vfs.y.O((String)localObject1, str1, false);
          }
          if ((!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil(str2)) && (com.tencent.mm.vfs.y.ZC((String)localObject2))) {
            com.tencent.mm.vfs.y.O((String)localObject2, str2, false);
          }
        }
        if (localg.field_type == 18) {
          break label1261;
        }
        if (((arf)localObject3).dataType == 1)
        {
          if (localg.field_type == 14)
          {
            if (((arf)localObject3).desc == null)
            {
              localObject1 = "\n";
              if (((arf)localObject3).ZzA == null)
              {
                localObject2 = "";
                ((arf)localObject3).bsp(auv((String)localObject2 + (String)localObject1 + "\n"));
                break label1298;
              }
            }
            else
            {
              localObject1 = ((arf)localObject3).desc + "\n";
              continue;
            }
            localObject2 = ((arf)localObject3).ZzA + ":\n";
            continue;
          }
          if (Util.isNullOrNil(((arf)localObject3).desc)) {
            break label1287;
          }
          ((arf)localObject3).bsp(auv(((arf)localObject3).desc));
          break label1298;
        }
        Object localObject1 = new StringBuilder("WeNote_");
        k = j + 1;
        ((arf)localObject3).bsL(j);
        j = i;
        if (localg.field_type == 14)
        {
          j = i;
          if (((arf)localObject3).ZzA != null)
          {
            a(localg, i, auv(((arf)localObject3).ZzA + ":"));
            j = i + 1;
          }
        }
        i = ((arf)localObject3).dataType;
        if ((i == 1) || (i == 2) || (i == 3) || (i == 6) || (i == 8) || (i == 4) || (i == 0)) {
          break label1307;
        }
        if (i != 22) {
          break label1313;
        }
      }
      finally
      {
        g localg;
        Toast.makeText(paramMMActivity, paramMMActivity.getString(q.i.favorite_save_as_note_failed), 0).show();
        AppMethodBeat.o(106778);
        return;
      }
      if (i == 0)
      {
        a(paramMMActivity, localg, j, (arf)localObject3);
        if (((arf)localObject3).dataType == 3)
        {
          ((arf)localObject3).axy(20);
          i = j;
          j = k;
          break label1298;
        }
      }
      else
      {
        if ((((arf)localObject3).dataType != 4) || (((arf)localObject3).Zzy == null) || (((arf)localObject3).Zzy.ZAz == null)) {
          continue;
        }
        a(paramMMActivity, localg, j, (arf)localObject3);
        continue;
        label1261:
        if (((arf)localObject3).dataType == 20)
        {
          ((arf)localObject3).bss("");
          ((arf)localObject3).bst("");
        }
        label1287:
        break label1298;
      }
      int i = j;
      int j = k;
      label1298:
      i += 1;
      continue;
      label1307:
      i = 1;
      continue;
      label1313:
      i = 0;
    }
  }
  
  private static String auv(String paramString)
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