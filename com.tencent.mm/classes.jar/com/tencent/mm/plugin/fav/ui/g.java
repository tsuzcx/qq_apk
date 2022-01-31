package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.li;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class g
{
  private static String NX(String paramString)
  {
    AppMethodBeat.i(74032);
    paramString = paramString.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
    AppMethodBeat.o(74032);
    return paramString;
  }
  
  private static String a(Context paramContext, aca paramaca)
  {
    AppMethodBeat.i(74033);
    switch (paramaca.dataType)
    {
    default: 
      paramContext = paramaca.desc;
      AppMethodBeat.o(74033);
      return paramContext;
    case 5: 
      str = "";
      paramContext = str;
      if (paramaca.wTw != null)
      {
        paramContext = str;
        if (paramaca.wTw.wUb != null) {
          paramContext = paramaca.wTw.wUb.link;
        }
      }
      if (bo.isNullOrNil(paramContext))
      {
        paramContext = paramaca.wSJ;
        AppMethodBeat.o(74033);
        return paramContext;
      }
      AppMethodBeat.o(74033);
      return paramContext;
    case 17: 
      paramContext = paramContext.getString(2131297055);
      AppMethodBeat.o(74033);
      return paramContext;
    case 19: 
      paramContext = paramContext.getString(2131296544);
    }
    try
    {
      paramaca = paramContext + " " + paramaca.wTw.wUs.wSs;
      paramContext = paramaca;
    }
    catch (Exception paramaca)
    {
      label197:
      break label197;
    }
    AppMethodBeat.o(74033);
    return paramContext;
    paramContext = paramContext.getString(2131296967);
    try
    {
      com.tencent.mm.kernel.g.RM();
      paramaca = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Ty(paramaca.desc);
      paramaca = paramContext + " " + paramaca.nickname;
      paramContext = paramaca;
    }
    catch (Exception paramaca)
    {
      label267:
      break label267;
    }
    AppMethodBeat.o(74033);
    return paramContext;
    paramContext = paramContext.getString(2131297105) + " " + j.C(paramContext, paramaca.duration / 1000) + "\n";
    AppMethodBeat.o(74033);
    return paramContext;
    String str = paramaca.desc;
    paramContext = str;
    if (!bo.isNullOrNil(paramaca.title)) {
      paramContext = paramaca.title + " " + str;
    }
    AppMethodBeat.o(74033);
    return paramContext;
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, int paramInt, String paramString)
  {
    AppMethodBeat.i(74034);
    aca localaca = new aca();
    localaca.MI(1);
    localaca.anr(paramString);
    paramg.field_favProto.wVc.add(paramInt, localaca);
    AppMethodBeat.o(74034);
  }
  
  public static void a(MMActivity paramMMActivity, long paramLong, h.a parama)
  {
    AppMethodBeat.i(74031);
    for (;;)
    {
      int k;
      try
      {
        com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong);
        com.tencent.mm.plugin.report.service.h.qsU.e(15378, new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        ab.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        localg.field_flag = 0;
        localg.field_updateTime = System.currentTimeMillis();
        localg.field_localId = -1L;
        localg.field_sourceType = 6;
        if (localg.field_favProto.wVa != null)
        {
          localg.field_favProto.wVa.aop("");
          localg.field_favProto.wVa.MR(6);
          localg.field_favProto.wVa.aon(r.Zn());
        }
        localg.field_fromUser = r.Zn();
        Object localObject1;
        Object localObject2;
        if (localg.field_type == 1)
        {
          localObject1 = new LinkedList();
          localg.field_favProto.aJ((LinkedList)localObject1);
          a(localg, 0, NX(localg.field_favProto.desc));
          localg.field_localId = System.currentTimeMillis();
          localg.field_type = 18;
          localg.field_xml = com.tencent.mm.plugin.fav.a.g.s(localg);
          localObject1 = new acs();
          if (parama != null)
          {
            ((acs)localObject1).scene = parama.scene;
            ((acs)localObject1).kbN = parama.kbN;
            ((acs)localObject1).index = parama.index;
            ((acs)localObject1).query = parama.query;
            ((acs)localObject1).cpW = parama.sid;
            ((acs)localObject1).mtm = parama.mtm;
          }
          parama = new li();
          parama.cBr.field_localId = localg.field_localId;
          parama.cBr.cBx = 5;
          parama.cBr.cBt = localg.field_xml;
          parama.cBr.context = paramMMActivity;
          localObject2 = new Bundle();
          localObject3 = localg.field_favProto.wjV;
          if (localObject3 != null)
          {
            ((Bundle)localObject2).putString("noteauthor", ((ack)localObject3).wUT);
            ((Bundle)localObject2).putString("noteeditor", ((ack)localObject3).wUU);
          }
          ((Bundle)localObject2).putLong("edittime", localg.field_updateTime);
          parama.cBr.cBw = ((Bundle)localObject2);
          parama.cBr.field_favProto = localg.field_favProto;
          parama.cBr.type = 2;
          parama.cBr.cBz = true;
          parama.cBr.cBA = ((acs)localObject1);
          a.ymk.l(parama);
          paramMMActivity.finish();
          AppMethodBeat.o(74031);
          return;
        }
        if (localg.field_favProto.wVc == null) {
          continue;
        }
        j = 1;
        i = 0;
        if (i >= localg.field_favProto.wVc.size()) {
          continue;
        }
        Object localObject3 = (aca)localg.field_favProto.wVc.get(i);
        if ((localg.field_type != 18) || (!((aca)localObject3).wTE.equals("WeNoteHtmlFile")))
        {
          localObject1 = b.b((aca)localObject3);
          localObject2 = b.c((aca)localObject3);
          ((aca)localObject3).anD(b.cj(localObject3.toString(), 18));
          String str1 = b.b((aca)localObject3);
          String str2 = b.c((aca)localObject3);
          if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil(str1)) && (e.cN((String)localObject1))) {
            e.C((String)localObject1, str1);
          }
          if ((!bo.isNullOrNil((String)localObject2)) && (!bo.isNullOrNil(str2)) && (e.cN((String)localObject2))) {
            e.C((String)localObject2, str2);
          }
        }
        if (localg.field_type != 18)
        {
          if (((aca)localObject3).dataType == 1)
          {
            if (localg.field_type == 14)
            {
              if (((aca)localObject3).desc == null)
              {
                localObject1 = "\n";
                if (((aca)localObject3).wTy == null)
                {
                  localObject2 = "";
                  ((aca)localObject3).anr(NX((String)localObject2 + (String)localObject1 + "\n"));
                  break label1173;
                }
              }
              else
              {
                localObject1 = ((aca)localObject3).desc + "\n";
                continue;
              }
              localObject2 = ((aca)localObject3).wTy + ":\n";
              continue;
            }
            if (!bo.isNullOrNil(((aca)localObject3).desc))
            {
              ((aca)localObject3).anr(NX(((aca)localObject3).desc));
              break label1173;
            }
          }
          else
          {
            localObject1 = new StringBuilder("WeNote_");
            k = j + 1;
            ((aca)localObject3).anN(j);
            j = i;
            if (localg.field_type == 14)
            {
              j = i;
              if (((aca)localObject3).wTy != null)
              {
                a(localg, i, NX(((aca)localObject3).wTy + ":"));
                j = i + 1;
              }
            }
            i = ((aca)localObject3).dataType;
            if ((i == 1) || (i == 2) || (i == 3) || (i == 6) || (i == 8) || (i == 4)) {
              break label1182;
            }
            if (i != 0) {
              break label1188;
            }
            break label1182;
            if (i == 0)
            {
              localg.field_favProto.wVc.remove(j);
              localObject1 = a(paramMMActivity, (aca)localObject3);
              if (localObject1 == null)
              {
                localObject1 = "\n\n";
                a(localg, j, NX((String)localObject1));
              }
            }
            else
            {
              if (((aca)localObject3).dataType != 3) {
                break label1165;
              }
              ((aca)localObject3).MI(20);
              i = j;
              j = k;
              break label1173;
            }
            localObject1 = "\n" + (String)localObject1 + "\n\n";
            continue;
          }
        }
        else if (((aca)localObject3).dataType == 20)
        {
          ((aca)localObject3).anu("");
          ((aca)localObject3).anv("");
        }
      }
      catch (Throwable parama)
      {
        Toast.makeText(paramMMActivity, paramMMActivity.getString(2131299816), 0).show();
        AppMethodBeat.o(74031);
        return;
      }
      label1165:
      int i = j;
      int j = k;
      label1173:
      i += 1;
      continue;
      label1182:
      i = 1;
      continue;
      label1188:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.g
 * JD-Core Version:    0.7.0.1
 */