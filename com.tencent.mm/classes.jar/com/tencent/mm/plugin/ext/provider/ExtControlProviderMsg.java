package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.fi;
import com.tencent.mm.h.a.fq;
import com.tencent.mm.h.a.fq.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderMsg
  extends ExtContentProviderBase
{
  private static final UriMatcher jKj;
  private static final String[] jKm = { "msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime" };
  private static final String[] jKn = { "userId", "unReadCount" };
  private static final String[] jKo = { "userId", "unReadCount" };
  private static final String[] jKp = { "userId", "retCode", "msgId" };
  private static final String[] jKq = { "msgId", "retCode" };
  private static final String[] jKr = { "msgId", "retCode" };
  private String[] jJU = null;
  private int jJV = -1;
  private boolean jKk = false;
  private Context jKl;
  private MatrixCursor jKs = null;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    jKj = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
    jKj.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
    jKj.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
    jKj.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
    jKj.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
    jKj.addURI("com.tencent.mm.plugin.ext.message", "playVoice", 12);
    jKj.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
    jKj.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
  }
  
  public ExtControlProviderMsg() {}
  
  public ExtControlProviderMsg(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.jKk = true;
    this.jJU = paramArrayOfString;
    this.jJV = paramInt;
    this.jKl = paramContext;
  }
  
  private Cursor a(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    y.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
    y.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      y.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      cL(3, 3701);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3701);
    }
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
      cL(3, 3702);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3702);
    }
    if (bk.bl(paramString2))
    {
      y.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
      cL(3, 3703);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3703);
    }
    if ((paramString1 != null) && (paramString1.equalsIgnoreCase("openapi"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1) {}
      try
      {
        paramString1 = com.tencent.mm.plugin.ext.b.aNq().acu(paramArrayOfString[0]);
        if ((paramString1 == null) || (bk.bl(paramString1.field_openId)) || (bk.bl(paramString1.field_username)))
        {
          y.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
          cL(3, 3704);
          return com.tencent.mm.pluginsdk.d.a.a.DA(3704);
        }
        au.Hx();
        long l;
        for (localad = c.Fw().abl(paramString1.field_username); (localad == null) || (localad.field_username == null) || (localad.field_username.length() <= 0); localad = c.Fw().hE(l))
        {
          y.e("MicroMsg.ExtControlProviderMsg", "contact is null");
          cL(3, 3705);
          return com.tencent.mm.pluginsdk.d.a.a.DA(3705);
          l = com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString[0]);
          au.Hx();
        }
        str = localad.Bq();
        if (!s.fn(localad.field_username)) {
          continue;
        }
        str = r.gV(localad.field_username);
        bool2 = true;
      }
      catch (Exception paramArrayOfString)
      {
        for (;;)
        {
          ad localad;
          String str;
          paramString1 = null;
          continue;
          boolean bool2 = false;
        }
      }
      if (bool1) {}
      for (;;)
      {
        try
        {
          i = bk.getInt(paramString2, 0);
          if ((i <= 0) || (i >= 15))
          {
            au.Hx();
            paramString1 = c.Fy().bS(localad.field_username, 15);
            if (paramString1 != null) {
              break;
            }
            y.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
            G(3, 4, 3706);
            return com.tencent.mm.pluginsdk.d.a.a.DA(3706);
          }
        }
        catch (Exception paramString1)
        {
          y.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[] { paramString2 });
          int i = 0;
          continue;
          au.Hx();
          paramString1 = c.Fy().bS(localad.field_username, i);
          continue;
        }
        au.Hx();
        paramString1 = c.Fy().bS(localad.field_username, 3);
      }
      paramString2 = new MatrixCursor(jKm);
      try
      {
        if ((paramString1.getCount() > 0) && (paramString1.moveToFirst()))
        {
          bi localbi = new bi();
          do
          {
            localbi.d(paramString1);
            a(paramString2, localbi, localad, bool2, str, bool1, paramArrayOfString[0]);
          } while (paramString1.moveToNext());
        }
        paramString1.close();
        G(2, 0, 1);
        return paramString2;
      }
      catch (Exception paramArrayOfString)
      {
        paramString1 = paramString2;
      }
      y.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (paramString1 != null) {
        paramString1.close();
      }
      G(3, 4, 12);
      return com.tencent.mm.pluginsdk.d.a.a.DA(12);
    }
  }
  
  private void a(MatrixCursor paramMatrixCursor, bi parambi, ad paramad, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    if (parambi == null) {}
    do
    {
      return;
      if (bk.bl(paramString2))
      {
        y.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
        return;
      }
    } while ((parambi.getType() == 9999) || (parambi.getType() == 10000));
    String str2 = "";
    String str3 = "";
    String str1 = str3;
    Object localObject = str2;
    int i;
    if (paramBoolean1)
    {
      i = com.tencent.mm.model.bd.iH(parambi.field_content);
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
                localObject = r.gV(str4);
                str1 = parambi.field_content.substring(i + 2);
              }
            }
          }
        }
      }
    }
    int k = com.tencent.mm.plugin.ext.b.b.P(parambi);
    if (k == 1) {
      if (paramBoolean1) {
        localObject = (String)localObject + "!]" + str1;
      }
    }
    label517:
    for (;;)
    {
      if (paramBoolean2)
      {
        try
        {
          label244:
          if (!bk.bl(paramString2)) {
            break label405;
          }
          y.w("MicroMsg.ExtControlProviderMsg", "userId is null");
          return;
        }
        catch (Exception paramMatrixCursor)
        {
          y.e("MicroMsg.ExtControlProviderMsg", paramMatrixCursor.getMessage());
          y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramMatrixCursor, "", new Object[0]);
          return;
        }
        localObject = parambi.field_content;
        continue;
        if (k == 2)
        {
          localObject = m.Tg().jz((int)parambi.field_msgId);
          if ((localObject == null) || (((p)localObject).fileName == null)) {
            break label511;
          }
          localObject = q.getFullPath(((p)localObject).fileName);
          y.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", new Object[] { localObject });
        }
      }
      for (;;)
      {
        break;
        if (paramBoolean1) {
          break label517;
        }
        if (this.jKl != null)
        {
          localObject = this.jKl.getString(R.l.ext_receive_unknown_type_message);
          break;
        }
        localObject = "";
        break;
        paramString2 = com.tencent.mm.plugin.ext.a.a.ei((int)paramad.dBe);
        break label244;
        label405:
        paramad = com.tencent.mm.plugin.ext.a.a.ei(parambi.field_msgId);
        if (parambi.field_isSend == 0)
        {
          i = 1;
          if (parambi.field_status != 4) {
            break label505;
          }
        }
        label505:
        for (int j = 1;; j = 2)
        {
          paramMatrixCursor.addRow(new Object[] { paramad, paramString2, paramString1, Integer.valueOf(i), Integer.valueOf(k), localObject, Integer.valueOf(j), Long.valueOf(parambi.field_createTime) });
          return;
          i = 2;
          break;
        }
        label511:
        localObject = "";
      }
    }
  }
  
  private Cursor aNC()
  {
    y.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
    MatrixCursor localMatrixCursor = new MatrixCursor(jKo);
    label250:
    for (;;)
    {
      try
      {
        au.Hx();
        Cursor localCursor = c.Fy().bib();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            String str = localCursor.getString(localCursor.getColumnIndex("talker"));
            au.Hx();
            ad localad = c.Fw().abl(str);
            if (!s.fn(str))
            {
              if ((s.hU(localad.field_username)) || (s.hS(localad.field_username)) || (ad.Fn(localad.field_verifyFlag)) || (s.hK(localad.field_username))) {
                break label250;
              }
              if (!s.hL(localad.field_username)) {
                continue;
              }
              break label250;
              if (i == 0) {
                localMatrixCursor.addRow(new Object[] { com.tencent.mm.plugin.ext.a.a.ei((int)localad.dBe), Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("unReadCount"))) });
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
          qF(0);
          return localMatrixCursor;
        }
        int i = 1;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
        y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
        localMatrixCursor.close();
        qF(4);
        return null;
      }
    }
  }
  
  private Cursor c(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = true;
    y.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      y.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      qF(3);
      return null;
    }
    try
    {
      long l = com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString[0]);
      au.Hx();
      localbi = c.Fy().fd(l);
      au.Hx();
      localad = c.Fw().abl(localbi.field_talker);
      if ((localad == null) || ((int)localad.dBe <= 0))
      {
        qF(3);
        return null;
      }
      str = localad.Bq();
      if (!s.fn(localad.field_username)) {
        break label226;
      }
      str = r.gV(localad.field_username);
      bool1 = true;
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        bi localbi;
        ad localad;
        String str;
        paramString = null;
        continue;
        boolean bool1 = false;
      }
    }
    if ((paramString != null) && (paramString.equalsIgnoreCase("openapi"))) {}
    for (;;)
    {
      paramString = new MatrixCursor(jKm);
      try
      {
        a(paramString, localbi, localad, bool1, str, bool2, paramArrayOfString[0]);
        qF(0);
        return paramString;
      }
      catch (Exception paramArrayOfString) {}
      y.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (paramString != null) {
        paramString.close();
      }
      qF(4);
      return null;
      bool2 = false;
    }
  }
  
  private Cursor p(String[] paramArrayOfString)
  {
    y.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      y.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      qF(3);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(jKn);
    for (;;)
    {
      try
      {
        if ("*".equals(paramArrayOfString[0]))
        {
          au.Hx();
          localMatrixCursor.addRow(new Object[] { "0", Integer.valueOf(c.FB().ie("")) });
          qF(0);
          return localMatrixCursor;
        }
      }
      catch (Exception paramArrayOfString)
      {
        y.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        localMatrixCursor.close();
        qF(4);
        return null;
      }
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        long l = com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString[i]);
        au.Hx();
        ad localad = c.Fw().hE(l);
        if ((localad != null) && ((int)localad.dBe > 0))
        {
          au.Hx();
          localMatrixCursor.addRow(new Object[] { Long.valueOf(l), Integer.valueOf(c.FB().ie(" and ( rconversation.username='" + localad.field_username + "' );")) });
        }
        i += 1;
      }
    }
  }
  
  private Cursor q(String[] paramArrayOfString)
  {
    y.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      y.w("MicroMsg.ExtControlProviderMsg", "wrong args");
      qF(3);
      return null;
    }
    int i;
    long l;
    try
    {
      i = Integer.valueOf(paramArrayOfString[0]).intValue();
      l = com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString[1]);
      if (l <= 0L)
      {
        qF(3);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      y.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.jKs != null) {
        this.jKs.close();
      }
      qF(4);
      return null;
    }
    com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
    localb.b(4000L, new ExtControlProviderMsg.1(this, i, l, localb, paramArrayOfString));
    paramArrayOfString = this.jKs;
    return paramArrayOfString;
  }
  
  private Cursor r(String[] paramArrayOfString)
  {
    y.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      y.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      qF(3);
    }
    int i;
    do
    {
      return null;
      for (;;)
      {
        long l;
        MatrixCursor localMatrixCursor;
        try
        {
          i = Integer.valueOf(paramArrayOfString[0]).intValue();
          l = com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString[1]);
          if (l <= 0L)
          {
            qF(3);
            return null;
          }
        }
        catch (Exception paramArrayOfString)
        {
          localMatrixCursor = null;
          y.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
          y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
          if (localMatrixCursor != null) {
            localMatrixCursor.close();
          }
          qF(4);
          return null;
        }
        if (i == 3)
        {
          localMatrixCursor = new MatrixCursor(jKq);
          try
          {
            fq localfq = new fq();
            localfq.bMG.bIt = l;
            com.tencent.mm.sdk.b.a.udP.m(localfq);
            if ((localfq.bMH.fileName == null) || (localfq.bMH.fileName.length() <= 0))
            {
              localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
              qF(4);
              return localMatrixCursor;
            }
            fi localfi = new fi();
            localfi.bMc.op = 1;
            localfi.bMc.fileName = localfq.bMH.fileName;
            if (com.tencent.mm.sdk.b.a.udP.m(localfi))
            {
              localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(1) });
              qF(0);
            }
            for (;;)
            {
              com.tencent.mm.plugin.ext.b.aNn();
              com.tencent.mm.plugin.ext.b.eh(l);
              return localMatrixCursor;
              y.e("MicroMsg.ExtControlProviderMsg", "play failed");
              localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
              qF(4);
            }
          }
          catch (Exception paramArrayOfString) {}
        }
      }
    } while (i != 4);
    paramArrayOfString = new fi();
    paramArrayOfString.bMc.op = 2;
    if (com.tencent.mm.sdk.b.a.udP.m(paramArrayOfString))
    {
      y.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
      qF(0);
      return null;
    }
    y.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
    qF(4);
    return null;
  }
  
  private Cursor s(String[] paramArrayOfString)
  {
    y.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      y.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      cL(3, 3801);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3801);
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramArrayOfString.length) {
          if ((paramArrayOfString[i] == null) || (paramArrayOfString[i].length() <= 0))
          {
            y.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = " + i);
          }
          else
          {
            long l = com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString[i]);
            com.tencent.mm.plugin.ext.b.aNn();
            com.tencent.mm.plugin.ext.b.eh(l);
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        y.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        cL(4, 12);
        return com.tencent.mm.pluginsdk.d.a.a.DA(12);
      }
      cL(0, 1);
      return com.tencent.mm.pluginsdk.d.a.a.DA(1);
      i += 1;
    }
  }
  
  private Cursor t(String[] paramArrayOfString)
  {
    y.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      y.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      qF(3);
      return null;
    }
    long l;
    try
    {
      l = com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString[0]);
      if (l <= 0L)
      {
        qF(3);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      y.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.jKs != null) {
        this.jKs.close();
      }
      qF(4);
      return null;
    }
    com.tencent.mm.plugin.ext.b.aNn();
    ad localad = com.tencent.mm.plugin.ext.b.eg(l);
    if ((localad == null) || ((int)localad.dBe <= 0))
    {
      y.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
      qF(3);
      return null;
    }
    this.jKs = new MatrixCursor(jKr);
    com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
    localb.b(15000L, new ExtControlProviderMsg.2(this, localad, paramArrayOfString, localb));
    return this.jKs;
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
    y.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.jKk);
    if (this.jKk)
    {
      a(paramUri, this.jKl, this.jJV, this.jJU);
      if (bk.bl(this.jKd))
      {
        y.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
        cL(3, 7);
        return com.tencent.mm.pluginsdk.d.a.a.DA(7);
      }
      if (bk.bl(aNA()))
      {
        y.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
        cL(3, 6);
        return com.tencent.mm.pluginsdk.d.a.a.DA(6);
      }
      int i = aNB();
      if (i != 1)
      {
        y.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = " + i);
        cL(2, i);
        return com.tencent.mm.pluginsdk.d.a.a.DA(i);
      }
    }
    else
    {
      this.jKl = getContext();
      a(paramUri, this.jKl, jKj);
      if (paramUri == null)
      {
        qF(3);
        return null;
      }
      if ((bk.bl(this.jKd)) || (bk.bl(aNA())))
      {
        qF(3);
        return null;
      }
      if (!awd())
      {
        qF(1);
        return this.hSn;
      }
      if (!dc(this.jKl))
      {
        y.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
        qF(2);
        return null;
      }
    }
    paramArrayOfString1 = bk.pm(paramUri.getQueryParameter("source"));
    paramString1 = bk.pm(paramUri.getQueryParameter("count"));
    if (!this.jKk) {
      this.jJV = jKj.match(paramUri);
    }
    switch (this.jJV)
    {
    default: 
      cL(3, 15);
      return null;
    case 7: 
      return c(paramArrayOfString2, paramArrayOfString1);
    case 8: 
      return p(paramArrayOfString2);
    case 9: 
      return a(paramArrayOfString2, paramArrayOfString1, paramString1);
    case 10: 
      return aNC();
    case 11: 
      return q(paramArrayOfString2);
    case 12: 
      return r(paramArrayOfString2);
    case 13: 
      return s(paramArrayOfString2);
    }
    return t(paramArrayOfString2);
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