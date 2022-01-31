package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.ft.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderMsg
  extends ExtContentProviderBase
{
  private static final UriMatcher meo;
  private static final String[] mer;
  private static final String[] mes;
  private static final String[] met;
  private static final String[] meu;
  private static final String[] mev;
  private static final String[] mew;
  private String[] mdZ = null;
  private int mea = -1;
  private boolean mep = false;
  private Context meq;
  private MatrixCursor mex = null;
  
  static
  {
    AppMethodBeat.i(20361);
    mer = new String[] { "msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime" };
    mes = new String[] { "userId", "unReadCount" };
    met = new String[] { "userId", "unReadCount" };
    meu = new String[] { "userId", "retCode", "msgId" };
    mev = new String[] { "msgId", "retCode" };
    mew = new String[] { "msgId", "retCode" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    meo = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
    meo.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
    meo.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
    meo.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
    meo.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
    meo.addURI("com.tencent.mm.plugin.ext.message", "playVoice", 12);
    meo.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
    meo.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    AppMethodBeat.o(20361);
  }
  
  public ExtControlProviderMsg() {}
  
  public ExtControlProviderMsg(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.mep = true;
    this.mdZ = paramArrayOfString;
    this.mea = paramInt;
    this.meq = paramContext;
  }
  
  private Cursor a(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(20353);
    ab.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
    ab.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      ej(3, 3701);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3701);
      AppMethodBeat.o(20353);
      return paramArrayOfString;
    }
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
      ej(3, 3702);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3702);
      AppMethodBeat.o(20353);
      return paramArrayOfString;
    }
    if (bo.isNullOrNil(paramString2))
    {
      ab.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
      ej(3, 3703);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3703);
      AppMethodBeat.o(20353);
      return paramArrayOfString;
    }
    boolean bool1;
    if ((paramString1 != null) && (paramString1.equalsIgnoreCase("openapi")))
    {
      bool1 = true;
      if (!bool1) {
        break label308;
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = com.tencent.mm.plugin.ext.b.btt().asG(paramArrayOfString[0]);
        if ((paramString1 == null) || (bo.isNullOrNil(paramString1.field_openId)) || (bo.isNullOrNil(paramString1.field_username)))
        {
          ab.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
          ej(3, 3704);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3704);
          AppMethodBeat.o(20353);
          return paramArrayOfString;
          bool1 = false;
          break;
        }
        aw.aaz();
        ad localad = c.YA().arw(paramString1.field_username);
        if ((localad == null) || (localad.field_username == null) || (localad.field_username.length() <= 0))
        {
          ab.e("MicroMsg.ExtControlProviderMsg", "contact is null");
          ej(3, 3705);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3705);
          AppMethodBeat.o(20353);
          return paramArrayOfString;
          label308:
          long l = com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString[0]);
          aw.aaz();
          localad = c.YA().on(l);
        }
        else
        {
          String str = localad.Of();
          if (t.lA(localad.field_username))
          {
            str = com.tencent.mm.model.s.nE(localad.field_username);
            bool2 = true;
            if (bool1)
            {
              try
              {
                i = bo.getInt(paramString2, 0);
                if ((i <= 0) || (i >= 15))
                {
                  aw.aaz();
                  paramString1 = c.YC().cJ(localad.field_username, 15);
                  if (paramString1 != null) {
                    continue;
                  }
                  ab.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                  S(3, 4, 3706);
                  paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3706);
                  AppMethodBeat.o(20353);
                  return paramArrayOfString;
                }
              }
              catch (Exception paramString1)
              {
                ab.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[] { paramString2 });
                int i = 0;
                continue;
                aw.aaz();
                paramString1 = c.YC().cJ(localad.field_username, i);
                continue;
              }
            }
            else
            {
              aw.aaz();
              paramString1 = c.YC().cJ(localad.field_username, 3);
              continue;
            }
            paramString2 = new MatrixCursor(mer);
          }
          bi localbi;
          boolean bool2 = false;
        }
      }
      catch (Exception paramArrayOfString)
      {
        try
        {
          if ((paramString1.getCount() > 0) && (paramString1.moveToFirst()))
          {
            localbi = new bi();
            localbi.convertFrom(paramString1);
            a(paramString2, localbi, localad, bool2, str, bool1, paramArrayOfString[0]);
            if (paramString1.moveToNext()) {
              continue;
            }
          }
          paramString1.close();
          S(2, 0, 1);
          AppMethodBeat.o(20353);
          return paramString2;
        }
        catch (Exception paramArrayOfString)
        {
          paramString1 = paramString2;
          continue;
        }
        paramArrayOfString = paramArrayOfString;
        paramString1 = null;
        ab.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString1 != null) {
          paramString1.close();
        }
        S(3, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(12);
        AppMethodBeat.o(20353);
        return paramArrayOfString;
      }
    }
  }
  
  private void a(MatrixCursor paramMatrixCursor, bi parambi, ad paramad, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    AppMethodBeat.i(20360);
    if (parambi == null)
    {
      AppMethodBeat.o(20360);
      return;
    }
    if (bo.isNullOrNil(paramString2))
    {
      ab.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
      AppMethodBeat.o(20360);
      return;
    }
    if ((parambi.getType() == 9999) || (parambi.getType() == 10000))
    {
      AppMethodBeat.o(20360);
      return;
    }
    String str2 = "";
    String str3 = "";
    String str1 = str3;
    Object localObject = str2;
    int i;
    if (paramBoolean1)
    {
      i = bf.pt(parambi.field_content);
      str1 = str3;
      localObject = str2;
      if (i != -1)
      {
        str1 = str3;
        localObject = str2;
        if (parambi.field_content.length() > i)
        {
          String str4 = parambi.field_content.substring(0, i).trim();
          str1 = str3;
          localObject = str2;
          if (str4 != null)
          {
            str1 = str3;
            localObject = str2;
            if (str4.length() > 0)
            {
              str1 = str3;
              localObject = str2;
              if (parambi.field_content.length() >= i + 2)
              {
                localObject = com.tencent.mm.model.s.nE(str4);
                str1 = parambi.field_content.substring(i + 2);
              }
            }
          }
        }
      }
    }
    int k = com.tencent.mm.plugin.ext.b.b.V(parambi);
    if (k == 1) {
      if (paramBoolean1)
      {
        localObject = (String)localObject + "!]" + str1;
        if (!paramBoolean2) {
          break label398;
        }
      }
    }
    label398:
    label554:
    for (;;)
    {
      try
      {
        if (bo.isNullOrNil(paramString2))
        {
          ab.w("MicroMsg.ExtControlProviderMsg", "userId is null");
          AppMethodBeat.o(20360);
          return;
          localObject = parambi.field_content;
          break;
          if (k == 2)
          {
            localObject = o.ams().ms((int)parambi.field_msgId);
            if ((localObject == null) || (((r)localObject).fileName == null)) {
              break label554;
            }
            localObject = com.tencent.mm.modelvoice.s.getFullPath(((r)localObject).fileName);
            ab.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", new Object[] { localObject });
            break;
          }
          if (paramBoolean1) {
            break;
          }
          if (this.meq != null)
          {
            localObject = this.meq.getString(2131299517);
            break;
          }
          localObject = "";
          break;
          paramString2 = com.tencent.mm.plugin.ext.a.a.jF((int)paramad.euF);
          continue;
        }
        paramad = com.tencent.mm.plugin.ext.a.a.jF(parambi.field_msgId);
        if (parambi.field_isSend == 0)
        {
          i = 1;
          if (parambi.field_status == 4)
          {
            j = 1;
            paramMatrixCursor.addRow(new Object[] { paramad, paramString2, paramString1, Integer.valueOf(i), Integer.valueOf(k), localObject, Integer.valueOf(j), Long.valueOf(parambi.field_createTime) });
            AppMethodBeat.o(20360);
          }
        }
        else
        {
          i = 2;
          continue;
        }
        int j = 2;
        continue;
        localObject = "";
      }
      catch (Exception paramMatrixCursor)
      {
        ab.e("MicroMsg.ExtControlProviderMsg", paramMatrixCursor.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramMatrixCursor, "", new Object[0]);
        AppMethodBeat.o(20360);
        return;
      }
    }
  }
  
  private Cursor b(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20355);
    ab.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      vA(3);
      AppMethodBeat.o(20355);
      return null;
    }
    for (;;)
    {
      try
      {
        long l = com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString[0]);
        aw.aaz();
        localbi = c.YC().kB(l);
        aw.aaz();
        localad = c.YA().arw(localbi.field_talker);
        if ((localad == null) || ((int)localad.euF <= 0))
        {
          vA(3);
          AppMethodBeat.o(20355);
          return null;
        }
        str = localad.Of();
        if (!t.lA(localad.field_username)) {
          break label256;
        }
        str = com.tencent.mm.model.s.nE(localad.field_username);
        bool1 = true;
        if ((paramString != null) && (paramString.equalsIgnoreCase("openapi"))) {
          paramString = new MatrixCursor(mer);
        }
      }
      catch (Exception paramArrayOfString)
      {
        bi localbi;
        ad localad;
        String str;
        paramString = null;
        ab.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString != null) {
          paramString.close();
        }
        vA(4);
        AppMethodBeat.o(20355);
        return null;
      }
      try
      {
        a(paramString, localbi, localad, bool1, str, bool2, paramArrayOfString[0]);
        vA(0);
        AppMethodBeat.o(20355);
        return paramString;
      }
      catch (Exception paramArrayOfString)
      {
        continue;
      }
      bool2 = false;
      continue;
      label256:
      boolean bool1 = false;
    }
  }
  
  private Cursor btF()
  {
    AppMethodBeat.i(20354);
    ab.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
    MatrixCursor localMatrixCursor = new MatrixCursor(met);
    label268:
    for (;;)
    {
      try
      {
        aw.aaz();
        Cursor localCursor = c.YC().bQd();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            String str = localCursor.getString(localCursor.getColumnIndex("talker"));
            aw.aaz();
            ad localad = c.YA().arw(str);
            if (!t.lA(str))
            {
              if ((t.oD(localad.field_username)) || (t.oB(localad.field_username)) || (ad.Nt(localad.field_verifyFlag)) || (t.ot(localad.field_username))) {
                break label268;
              }
              if (!t.ou(localad.field_username)) {
                continue;
              }
              break label268;
              if (i == 0) {
                localMatrixCursor.addRow(new Object[] { com.tencent.mm.plugin.ext.a.a.jF((int)localad.euF), Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("unReadCount"))) });
              }
            }
            if (localCursor.moveToNext()) {
              continue;
            }
          }
          else
          {
            localCursor.close();
          }
        }
        else
        {
          vA(0);
          AppMethodBeat.o(20354);
          return localMatrixCursor;
        }
        int i = 1;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
        localMatrixCursor.close();
        vA(4);
        AppMethodBeat.o(20354);
        return null;
      }
    }
  }
  
  private Cursor t(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20352);
    ab.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      vA(3);
      AppMethodBeat.o(20352);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(mes);
    try
    {
      if ("*".equals(paramArrayOfString[0]))
      {
        aw.aaz();
        localMatrixCursor.addRow(new Object[] { "0", Integer.valueOf(c.YF().oM("")) });
      }
      for (;;)
      {
        vA(0);
        AppMethodBeat.o(20352);
        return localMatrixCursor;
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          long l = com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString[i]);
          aw.aaz();
          ad localad = c.YA().on(l);
          if ((localad != null) && ((int)localad.euF > 0))
          {
            aw.aaz();
            localMatrixCursor.addRow(new Object[] { Long.valueOf(l), Integer.valueOf(c.YF().oM(" and ( rconversation.username='" + localad.field_username + "' );")) });
          }
          i += 1;
        }
      }
      return null;
    }
    catch (Exception paramArrayOfString)
    {
      ab.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      localMatrixCursor.close();
      vA(4);
      AppMethodBeat.o(20352);
    }
  }
  
  private Cursor u(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20356);
    ab.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ab.w("MicroMsg.ExtControlProviderMsg", "wrong args");
      vA(3);
      AppMethodBeat.o(20356);
      return null;
    }
    try
    {
      int i = Integer.valueOf(paramArrayOfString[0]).intValue();
      long l = com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString[1]);
      if (l <= 0L)
      {
        vA(3);
        AppMethodBeat.o(20356);
        return null;
      }
      com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
      localb.b(4000L, new ExtControlProviderMsg.1(this, i, l, localb, paramArrayOfString));
      paramArrayOfString = this.mex;
      AppMethodBeat.o(20356);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      ab.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.mex != null) {
        this.mex.close();
      }
      vA(4);
      AppMethodBeat.o(20356);
    }
    return null;
  }
  
  private Cursor v(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20357);
    ab.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      vA(3);
      AppMethodBeat.o(20357);
      return null;
    }
    Object localObject = null;
    try
    {
      i = Integer.valueOf(paramArrayOfString[0]).intValue();
      long l = com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString[1]);
      if (l <= 0L)
      {
        vA(3);
        AppMethodBeat.o(20357);
        return null;
      }
      if (i != 3) {
        break label365;
      }
      MatrixCursor localMatrixCursor = new MatrixCursor(mev);
      try
      {
        localObject = new ft();
        ((ft)localObject).cua.cpO = l;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
        if ((((ft)localObject).cub.fileName == null) || (((ft)localObject).cub.fileName.length() <= 0))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          vA(4);
          AppMethodBeat.o(20357);
          return localMatrixCursor;
        }
        fl localfl = new fl();
        localfl.ctw.op = 1;
        localfl.ctw.fileName = ((ft)localObject).cub.fileName;
        if (com.tencent.mm.sdk.b.a.ymk.l(localfl))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(1) });
          vA(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.ext.b.btq();
          com.tencent.mm.plugin.ext.b.jE(l);
          AppMethodBeat.o(20357);
          return localMatrixCursor;
          ab.e("MicroMsg.ExtControlProviderMsg", "play failed");
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          vA(4);
        }
        ab.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      }
      catch (Exception paramArrayOfString)
      {
        localObject = localMatrixCursor;
      }
    }
    catch (Exception paramArrayOfString)
    {
      int i;
      label320:
      break label320;
    }
    ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
    if (localObject != null) {
      ((MatrixCursor)localObject).close();
    }
    vA(4);
    AppMethodBeat.o(20357);
    return null;
    label365:
    if (i == 4)
    {
      paramArrayOfString = new fl();
      paramArrayOfString.ctw.op = 2;
      if (!com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfString)) {
        break label417;
      }
      ab.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
      vA(0);
    }
    for (;;)
    {
      AppMethodBeat.o(20357);
      return null;
      label417:
      ab.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
      vA(4);
    }
  }
  
  private Cursor w(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20358);
    ab.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      ej(3, 3801);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3801);
      AppMethodBeat.o(20358);
      return paramArrayOfString;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramArrayOfString.length) {
          if ((paramArrayOfString[i] == null) || (paramArrayOfString[i].length() <= 0))
          {
            ab.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = ".concat(String.valueOf(i)));
          }
          else
          {
            long l = com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString[i]);
            com.tencent.mm.plugin.ext.b.btq();
            com.tencent.mm.plugin.ext.b.jE(l);
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ab.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        ej(4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(12);
        AppMethodBeat.o(20358);
        return paramArrayOfString;
      }
      ej(0, 1);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
      AppMethodBeat.o(20358);
      return paramArrayOfString;
      i += 1;
    }
  }
  
  private Cursor x(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20359);
    ab.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      vA(3);
      AppMethodBeat.o(20359);
      return null;
    }
    try
    {
      long l = com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString[0]);
      if (l <= 0L)
      {
        vA(3);
        AppMethodBeat.o(20359);
        return null;
      }
      com.tencent.mm.plugin.ext.b.btq();
      ad localad = com.tencent.mm.plugin.ext.b.jD(l);
      if ((localad == null) || ((int)localad.euF <= 0))
      {
        ab.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
        vA(3);
        AppMethodBeat.o(20359);
        return null;
      }
      this.mex = new MatrixCursor(mew);
      com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
      localb.b(15000L, new ExtControlProviderMsg.2(this, localad, paramArrayOfString, localb));
      paramArrayOfString = this.mex;
      AppMethodBeat.o(20359);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      ab.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.mex != null) {
        this.mex.close();
      }
      vA(4);
      AppMethodBeat.o(20359);
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(20351);
    ab.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.mep);
    if (this.mep)
    {
      a(paramUri, this.meq, this.mea, this.mdZ);
      if (bo.isNullOrNil(this.mei))
      {
        ab.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
        ej(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(7);
        AppMethodBeat.o(20351);
        return paramUri;
      }
      if (bo.isNullOrNil(btD()))
      {
        ab.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
        ej(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(6);
        AppMethodBeat.o(20351);
        return paramUri;
      }
      int i = btE();
      if (i != 1)
      {
        ab.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(i)));
        ej(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(i);
        AppMethodBeat.o(20351);
        return paramUri;
      }
    }
    else
    {
      this.meq = getContext();
      a(paramUri, this.meq, meo);
      if (paramUri == null)
      {
        vA(3);
        AppMethodBeat.o(20351);
        return null;
      }
      if ((bo.isNullOrNil(this.mei)) || (bo.isNullOrNil(btD())))
      {
        vA(3);
        AppMethodBeat.o(20351);
        return null;
      }
      if (!aVH())
      {
        vA(1);
        paramUri = this.jLW;
        AppMethodBeat.o(20351);
        return paramUri;
      }
      if (!dO(this.meq))
      {
        ab.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
        vA(2);
        AppMethodBeat.o(20351);
        return null;
      }
    }
    paramArrayOfString1 = bo.nullAsNil(paramUri.getQueryParameter("source"));
    paramString1 = bo.nullAsNil(paramUri.getQueryParameter("count"));
    if (!this.mep) {
      this.mea = meo.match(paramUri);
    }
    switch (this.mea)
    {
    default: 
      ej(3, 15);
      AppMethodBeat.o(20351);
      return null;
    case 7: 
      paramUri = b(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(20351);
      return paramUri;
    case 8: 
      paramUri = t(paramArrayOfString2);
      AppMethodBeat.o(20351);
      return paramUri;
    case 9: 
      paramUri = a(paramArrayOfString2, paramArrayOfString1, paramString1);
      AppMethodBeat.o(20351);
      return paramUri;
    case 10: 
      paramUri = btF();
      AppMethodBeat.o(20351);
      return paramUri;
    case 11: 
      paramUri = u(paramArrayOfString2);
      AppMethodBeat.o(20351);
      return paramUri;
    case 12: 
      paramUri = v(paramArrayOfString2);
      AppMethodBeat.o(20351);
      return paramUri;
    case 13: 
      paramUri = w(paramArrayOfString2);
      AppMethodBeat.o(20351);
      return paramUri;
    }
    paramUri = x(paramArrayOfString2);
    AppMethodBeat.o(20351);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg
 * JD-Core Version:    0.7.0.1
 */