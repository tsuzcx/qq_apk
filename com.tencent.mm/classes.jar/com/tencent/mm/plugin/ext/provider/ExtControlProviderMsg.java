package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.gp;
import com.tencent.mm.autogen.a.gp.b;
import com.tencent.mm.autogen.a.gr;
import com.tencent.mm.autogen.a.gs;
import com.tencent.mm.autogen.a.gs.b;
import com.tencent.mm.autogen.a.gy;
import com.tencent.mm.autogen.a.gy.b;
import com.tencent.mm.autogen.a.gz;
import com.tencent.mm.autogen.a.gz.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.ext.SubCoreExt;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cv;
import com.tencent.mm.storage.cw;

public class ExtControlProviderMsg
  extends ExtContentProviderBase
{
  private static final UriMatcher zPg;
  private static final String[] zPj;
  private static final String[] zPk;
  private static final String[] zPl;
  private static final String[] zPm;
  private static final String[] zPn;
  private static final String[] zPo;
  private String[] zOO = null;
  private int zOP = -1;
  private boolean zPh = false;
  private Context zPi;
  private MatrixCursor zPp = null;
  
  static
  {
    AppMethodBeat.i(24440);
    zPj = new String[] { "msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime" };
    zPk = new String[] { "userId", "unReadCount" };
    zPl = new String[] { "userId", "unReadCount" };
    zPm = new String[] { "userId", "retCode", "msgId" };
    zPn = new String[] { "msgId", "retCode" };
    zPo = new String[] { "msgId", "retCode" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    zPg = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "oneMsg", 7);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadCount", 8);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadMsgs", 9);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadUserList", 10);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "recordMsg", 11);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "playVoice", 12);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "setReaded", 13);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "sendTextMsg", 14);
    AppMethodBeat.o(24440);
  }
  
  public ExtControlProviderMsg() {}
  
  public ExtControlProviderMsg(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.zPh = true;
    this.zOO = paramArrayOfString;
    this.zOP = paramInt;
    this.zPi = paramContext;
  }
  
  private Cursor C(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24431);
    Log.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      Mm(3);
      AppMethodBeat.o(24431);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(zPk);
    try
    {
      if ("*".equals(paramArrayOfString[0]))
      {
        bh.bCz();
        localMatrixCursor.addRow(new Object[] { "0", Integer.valueOf(c.bzG().byd("")) });
      }
      for (;;)
      {
        Mm(0);
        AppMethodBeat.o(24431);
        return localMatrixCursor;
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          long l = AESUtil.atw(paramArrayOfString[i]);
          bh.bCz();
          au localau = c.bzA().zc(l);
          if ((localau != null) && ((int)localau.maN > 0))
          {
            bh.bCz();
            localMatrixCursor.addRow(new Object[] { Long.valueOf(l), Integer.valueOf(c.bzG().byd(" and ( rconversation.username='" + localau.field_username + "' );")) });
          }
          i += 1;
        }
      }
      return null;
    }
    catch (Exception paramArrayOfString)
    {
      Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      localMatrixCursor.close();
      Mm(4);
      AppMethodBeat.o(24431);
    }
  }
  
  private Cursor D(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24435);
    Log.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      Log.w("MicroMsg.ExtControlProviderMsg", "wrong args");
      Mm(3);
      AppMethodBeat.o(24435);
      return null;
    }
    try
    {
      final int i = Integer.valueOf(paramArrayOfString[0]).intValue();
      final long l = AESUtil.atw(paramArrayOfString[1]);
      if (l <= 0L)
      {
        Mm(3);
        AppMethodBeat.o(24435);
        return null;
      }
      com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
      localb.c(4000L, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24427);
          Object localObject1;
          Object localObject2;
          if (i == 1)
          {
            SubCoreExt.dNQ();
            localObject1 = SubCoreExt.mm(l);
            if ((localObject1 == null) || ((int)((d)localObject1).maN <= 0))
            {
              ExtControlProviderMsg.this.Mm(3);
              paramArrayOfString.asP();
              AppMethodBeat.o(24427);
              return;
            }
            localObject2 = new gs();
            ((gs)localObject2).hHj.op = 1;
            ((gs)localObject2).hHj.username = ((az)localObject1).field_username;
            if (!((gs)localObject2).publish())
            {
              ExtControlProviderMsg.this.Mm(4);
              paramArrayOfString.asP();
              AppMethodBeat.o(24427);
              return;
            }
            ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.dOh()));
            if ((localObject1 != null) && ((int)((d)localObject1).maN > 0) && (((gs)localObject2).hHk.hCQ))
            {
              ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.val$args[1], Integer.valueOf(1), "0" });
              ExtControlProviderMsg.this.Mm(0);
              Log.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[] { Boolean.valueOf(((gs)localObject2).hHk.hCQ), ((gs)localObject2).hHk.fileName });
            }
          }
          for (;;)
          {
            paramArrayOfString.asP();
            AppMethodBeat.o(24427);
            return;
            ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.val$args[1], Integer.valueOf(2), "0" });
            ExtControlProviderMsg.this.Mm(3);
            break;
            if (i == 2)
            {
              localObject1 = new gs();
              ((gs)localObject1).hHj.op = 2;
              if (!((gs)localObject1).publish())
              {
                ExtControlProviderMsg.this.Mm(4);
                paramArrayOfString.asP();
                AppMethodBeat.o(24427);
                return;
              }
              localObject2 = ((gs)localObject1).hHk.fileName;
              ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.dOh()));
              gy localgy = new gy();
              localgy.hHE.fileName = ((String)localObject2);
              if (!localgy.publish())
              {
                ExtControlProviderMsg.this.Mm(4);
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).close();
                paramArrayOfString.asP();
                AppMethodBeat.o(24427);
                return;
              }
              Log.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[] { Long.valueOf(localgy.hHF.msgId) });
              long l = localgy.hHF.msgId;
              if (l > 0L)
              {
                try
                {
                  if (!((gs)localObject1).hHk.hCQ) {
                    break label634;
                  }
                  if ((MMApplicationContext.getContext() == null) || (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))) {
                    break label585;
                  }
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.val$args[1], Integer.valueOf(1), AESUtil.mo(l) });
                  ExtControlProviderMsg.this.Mm(0);
                }
                catch (Exception localException)
                {
                  Log.w("MicroMsg.ExtControlProviderMsg", localException.getMessage());
                  Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
                  ExtControlProviderMsg.this.Mm(4);
                }
                continue;
                label585:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.val$args[1], Integer.valueOf(6), AESUtil.mo(l) });
                ExtControlProviderMsg.this.Mm(4);
                continue;
                label634:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.val$args[1], Integer.valueOf(4), AESUtil.mo(l) });
                ExtControlProviderMsg.this.Mm(4);
              }
              else
              {
                ExtControlProviderMsg.this.Mm(3);
              }
            }
          }
        }
      });
      paramArrayOfString = this.zPp;
      AppMethodBeat.o(24435);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.zPp != null) {
        this.zPp.close();
      }
      Mm(4);
      AppMethodBeat.o(24435);
    }
    return null;
  }
  
  private Cursor E(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24436);
    Log.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      Mm(3);
      AppMethodBeat.o(24436);
      return null;
    }
    Object localObject = null;
    try
    {
      i = Integer.valueOf(paramArrayOfString[0]).intValue();
      long l = AESUtil.atw(paramArrayOfString[1]);
      if (l <= 0L)
      {
        Mm(3);
        AppMethodBeat.o(24436);
        return null;
      }
      if (i != 3) {
        break label358;
      }
      MatrixCursor localMatrixCursor = new MatrixCursor(zPn);
      try
      {
        localObject = new gz();
        ((gz)localObject).hHG.msgId = l;
        ((gz)localObject).publish();
        if ((((gz)localObject).hHH.fileName == null) || (((gz)localObject).hHH.fileName.length() <= 0))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          Mm(4);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
        }
        gr localgr = new gr();
        localgr.hHe.op = 1;
        localgr.hHe.fileName = ((gz)localObject).hHH.fileName;
        if (localgr.publish())
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(1) });
          Mm(0);
        }
        for (;;)
        {
          SubCoreExt.dNQ();
          SubCoreExt.mn(l);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
          Log.e("MicroMsg.ExtControlProviderMsg", "play failed");
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          Mm(4);
        }
        Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      }
      catch (Exception paramArrayOfString)
      {
        localObject = localMatrixCursor;
      }
    }
    catch (Exception paramArrayOfString)
    {
      int i;
      label314:
      break label314;
    }
    Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
    if (localObject != null) {
      ((MatrixCursor)localObject).close();
    }
    Mm(4);
    AppMethodBeat.o(24436);
    return null;
    label358:
    if (i == 4)
    {
      paramArrayOfString = new gr();
      paramArrayOfString.hHe.op = 2;
      if (!paramArrayOfString.publish()) {
        break label407;
      }
      Log.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
      Mm(0);
    }
    for (;;)
    {
      AppMethodBeat.o(24436);
      return null;
      label407:
      Log.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
      Mm(4);
    }
  }
  
  private Cursor F(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24437);
    Log.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      hf(3, 3801);
      paramArrayOfString = a.avy(3801);
      AppMethodBeat.o(24437);
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
            Log.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = ".concat(String.valueOf(i)));
          }
          else
          {
            long l = AESUtil.atw(paramArrayOfString[i]);
            SubCoreExt.dNQ();
            SubCoreExt.mn(l);
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        hf(4, 12);
        paramArrayOfString = a.avy(12);
        AppMethodBeat.o(24437);
        return paramArrayOfString;
      }
      hf(0, 1);
      paramArrayOfString = a.avy(1);
      AppMethodBeat.o(24437);
      return paramArrayOfString;
      i += 1;
    }
  }
  
  private Cursor G(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24438);
    Log.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      Mm(3);
      AppMethodBeat.o(24438);
      return null;
    }
    try
    {
      long l = AESUtil.atw(paramArrayOfString[0]);
      if (l <= 0L)
      {
        Mm(3);
        AppMethodBeat.o(24438);
        return null;
      }
      SubCoreExt.dNQ();
      final au localau = SubCoreExt.mm(l);
      if ((localau == null) || ((int)localau.maN <= 0))
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
        Mm(3);
        AppMethodBeat.o(24438);
        return null;
      }
      this.zPp = new MatrixCursor(zPo);
      final com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
      localb.c(15000L, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24429);
          Object localObject = new gp();
          ((gp)localObject).hGY.hHa = localau.field_username;
          ((gp)localObject).hGY.content = paramArrayOfString[1];
          ((gp)localObject).hGY.type = ab.IX(localau.field_username);
          ((gp)localObject).hGY.flags = 0;
          if (!((gp)localObject).publish())
          {
            ExtControlProviderMsg.this.Mm(4);
            localb.asP();
            AppMethodBeat.o(24429);
            return;
          }
          p localp = ((gp)localObject).hGZ.hHb;
          try
          {
            localObject = new h()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
              {
                AppMethodBeat.i(24428);
                Log.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                if (paramAnonymous2p == null)
                {
                  Log.e("MicroMsg.ExtControlProviderMsg", "scene == null");
                  bh.aZW().b(522, this);
                  ExtControlProviderMsg.this.Mm(4);
                  ExtControlProviderMsg.2.this.vsq.asP();
                  AppMethodBeat.o(24428);
                  return;
                }
                switch (paramAnonymous2p.getType())
                {
                default: 
                  ExtControlProviderMsg.this.Mm(0);
                }
                for (;;)
                {
                  ExtControlProviderMsg.2.this.vsq.asP();
                  bh.aZW().b(522, this);
                  AppMethodBeat.o(24428);
                  return;
                  if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                  {
                    Log.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                    ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.zPt, Integer.valueOf(1) });
                    break;
                  }
                  Log.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + paramAnonymous2Int1 + ", errCode = " + paramAnonymous2Int2);
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.zPt, Integer.valueOf(2) });
                  ExtControlProviderMsg.this.Mm(4);
                }
              }
            };
            bh.aZW().a(522, (h)localObject);
            bh.aZW().a(localp, 0);
            AppMethodBeat.o(24429);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
            ExtControlProviderMsg.this.Mm(4);
            localb.asP();
            AppMethodBeat.o(24429);
          }
        }
      });
      paramArrayOfString = this.zPp;
      AppMethodBeat.o(24438);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.zPp != null) {
        this.zPp.close();
      }
      Mm(4);
      AppMethodBeat.o(24438);
    }
    return null;
  }
  
  private void a(MatrixCursor paramMatrixCursor, cc paramcc, au paramau, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    AppMethodBeat.i(24439);
    if (paramcc == null)
    {
      AppMethodBeat.o(24439);
      return;
    }
    if (Util.isNullOrNil(paramString2))
    {
      Log.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
      AppMethodBeat.o(24439);
      return;
    }
    if ((paramcc.getType() == 9999) || (paramcc.getType() == 10000))
    {
      AppMethodBeat.o(24439);
      return;
    }
    String str2 = "";
    String str3 = "";
    String str1 = str3;
    Object localObject = str2;
    int i;
    if (paramBoolean1)
    {
      i = br.JG(paramcc.field_content);
      str1 = str3;
      localObject = str2;
      if (i != -1)
      {
        str1 = str3;
        localObject = str2;
        if (paramcc.field_content.length() > i)
        {
          String str4 = paramcc.field_content.substring(0, i).trim();
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
              if (paramcc.field_content.length() >= i + 2)
              {
                localObject = aa.getDisplayName(str4);
                str1 = paramcc.field_content.substring(i + 2);
              }
            }
          }
        }
      }
    }
    int k = com.tencent.mm.plugin.ext.b.b.aR(paramcc);
    if (k == 1) {
      if (paramBoolean1)
      {
        localObject = (String)localObject + "!]" + str1;
        if (!paramBoolean2) {
          break label395;
        }
      }
    }
    label395:
    label550:
    for (;;)
    {
      try
      {
        if (Util.isNullOrNil(paramString2))
        {
          Log.w("MicroMsg.ExtControlProviderMsg", "userId is null");
          AppMethodBeat.o(24439);
          return;
          localObject = paramcc.field_content;
          break;
          if (k == 2)
          {
            localObject = o.bPf().xk((int)paramcc.field_msgId);
            if ((localObject == null) || (((r)localObject).fileName == null)) {
              break label550;
            }
            localObject = com.tencent.mm.modelvoice.s.getFullPath(((r)localObject).fileName);
            Log.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", new Object[] { localObject });
            break;
          }
          if (paramBoolean1) {
            break;
          }
          if (this.zPi != null)
          {
            localObject = this.zPi.getString(R.l.gHk);
            break;
          }
          localObject = "";
          break;
          paramString2 = AESUtil.mo((int)paramau.maN);
          continue;
        }
        paramau = AESUtil.mo(paramcc.field_msgId);
        if (paramcc.field_isSend == 0)
        {
          i = 1;
          if (paramcc.field_status == 4)
          {
            j = 1;
            paramMatrixCursor.addRow(new Object[] { paramau, paramString2, paramString1, Integer.valueOf(i), Integer.valueOf(k), localObject, Integer.valueOf(j), Long.valueOf(paramcc.getCreateTime()) });
            AppMethodBeat.o(24439);
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
        Log.e("MicroMsg.ExtControlProviderMsg", paramMatrixCursor.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramMatrixCursor, "", new Object[0]);
        AppMethodBeat.o(24439);
        return;
      }
    }
  }
  
  private Cursor b(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(24432);
    Log.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
    Log.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      hf(3, 3701);
      paramArrayOfString = a.avy(3701);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
      hf(3, 3702);
      paramArrayOfString = a.avy(3702);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
      hf(3, 3703);
      paramArrayOfString = a.avy(3703);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    boolean bool1;
    if ((paramString1 != null) && (paramString1.equalsIgnoreCase("openapi")))
    {
      bool1 = true;
      if (!bool1) {
        break label315;
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = SubCoreExt.dNT().byP(paramArrayOfString[0]);
        if ((paramString1 == null) || (Util.isNullOrNil(paramString1.field_openId)) || (Util.isNullOrNil(paramString1.field_username)))
        {
          Log.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
          hf(3, 3704);
          paramArrayOfString = a.avy(3704);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          bool1 = false;
          break;
        }
        bh.bCz();
        au localau = c.bzA().JE(paramString1.field_username);
        if ((localau == null) || (localau.field_username == null) || (localau.field_username.length() <= 0))
        {
          Log.e("MicroMsg.ExtControlProviderMsg", "contact is null");
          hf(3, 3705);
          paramArrayOfString = a.avy(3705);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          label315:
          long l = AESUtil.atw(paramArrayOfString[0]);
          bh.bCz();
          localau = c.bzA().zc(l);
        }
        else
        {
          String str = localau.aSV();
          if (au.bwE(localau.field_username))
          {
            str = aa.getDisplayName(localau.field_username);
            bool2 = true;
            if (bool1)
            {
              try
              {
                i = Util.getInt(paramString2, 0);
                if ((i <= 0) || (i >= 15))
                {
                  bh.bCz();
                  paramString1 = c.bzD().fY(localau.field_username, 15);
                  if (paramString1 != null) {
                    continue;
                  }
                  Log.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                  au(3, 4, 3706);
                  paramArrayOfString = a.avy(3706);
                  AppMethodBeat.o(24432);
                  return paramArrayOfString;
                }
              }
              catch (Exception paramString1)
              {
                Log.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[] { paramString2 });
                int i = 0;
                continue;
                bh.bCz();
                paramString1 = c.bzD().fY(localau.field_username, i);
                continue;
              }
            }
            else
            {
              bh.bCz();
              paramString1 = c.bzD().fY(localau.field_username, 3);
              continue;
            }
            paramString2 = new MatrixCursor(zPj);
          }
          cc localcc;
          boolean bool2 = false;
        }
      }
      catch (Exception paramArrayOfString)
      {
        try
        {
          if ((paramString1.getCount() > 0) && (paramString1.moveToFirst()))
          {
            localcc = new cc();
            localcc.convertFrom(paramString1);
            a(paramString2, localcc, localau, bool2, str, bool1, paramArrayOfString[0]);
            if (paramString1.moveToNext()) {
              continue;
            }
          }
          paramString1.close();
          au(2, 0, 1);
          AppMethodBeat.o(24432);
          return paramString2;
        }
        catch (Exception paramArrayOfString)
        {
          paramString1 = paramString2;
          continue;
        }
        paramArrayOfString = paramArrayOfString;
        paramString1 = null;
        Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString1 != null) {
          paramString1.close();
        }
        au(3, 4, 12);
        paramArrayOfString = a.avy(12);
        AppMethodBeat.o(24432);
        return paramArrayOfString;
      }
    }
  }
  
  private Cursor d(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(24434);
    Log.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      Mm(3);
      AppMethodBeat.o(24434);
      return null;
    }
    for (;;)
    {
      try
      {
        long l = AESUtil.atw(paramArrayOfString[0]);
        bh.bCz();
        localcc = c.bzD().sl(l);
        if (localcc == null)
        {
          Mm(3);
          AppMethodBeat.o(24434);
          return null;
        }
        bh.bCz();
        localau = c.bzA().JE(localcc.field_talker);
        if ((localau == null) || ((int)localau.maN <= 0))
        {
          Mm(3);
          AppMethodBeat.o(24434);
          return null;
        }
        str = localau.aSV();
        if (!au.bwE(localau.field_username)) {
          break label274;
        }
        str = aa.getDisplayName(localau.field_username);
        bool1 = true;
        if ((paramString != null) && (paramString.equalsIgnoreCase("openapi"))) {
          paramString = new MatrixCursor(zPj);
        }
      }
      catch (Exception paramArrayOfString)
      {
        cc localcc;
        au localau;
        String str;
        paramString = null;
        Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString != null) {
          paramString.close();
        }
        Mm(4);
        AppMethodBeat.o(24434);
        return null;
      }
      try
      {
        a(paramString, localcc, localau, bool1, str, bool2, paramArrayOfString[0]);
        Mm(0);
        AppMethodBeat.o(24434);
        return paramString;
      }
      catch (Exception paramArrayOfString)
      {
        continue;
      }
      bool2 = false;
      continue;
      label274:
      boolean bool1 = false;
    }
  }
  
  private Cursor dOg()
  {
    AppMethodBeat.i(24433);
    Log.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
    MatrixCursor localMatrixCursor = new MatrixCursor(zPl);
    label267:
    for (;;)
    {
      try
      {
        bh.bCz();
        Cursor localCursor = c.bzD().gbn();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            String str = localCursor.getString(localCursor.getColumnIndex("talker"));
            bh.bCz();
            au localau = c.bzA().JE(str);
            if (!au.bwE(str))
            {
              if ((ab.IV(localau.field_username)) || (au.bwx(localau.field_username)) || (au.ayS(localau.field_verifyFlag)) || (au.bwp(localau.field_username))) {
                break label267;
              }
              if (!au.bwq(localau.field_username)) {
                continue;
              }
              break label267;
              if (i == 0) {
                localMatrixCursor.addRow(new Object[] { AESUtil.mo((int)localau.maN), Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("unReadCount"))) });
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
          Mm(0);
          AppMethodBeat.o(24433);
          return localMatrixCursor;
        }
        int i = 1;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
        localMatrixCursor.close();
        Mm(4);
        AppMethodBeat.o(24433);
        return null;
      }
    }
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
    AppMethodBeat.i(24430);
    Log.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.zPh);
    if (this.zPh)
    {
      a(paramUri, this.zPi, this.zOP, this.zOO);
      if (Util.isNullOrNil(this.zPa))
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
        hf(3, 7);
        paramUri = a.avy(7);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (Util.isNullOrNil(dOe()))
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
        hf(3, 6);
        paramUri = a.avy(6);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      int i = dOf();
      if (i != 1)
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(i)));
        hf(2, i);
        paramUri = a.avy(i);
        AppMethodBeat.o(24430);
        return paramUri;
      }
    }
    else
    {
      this.zPi = getContext();
      a(paramUri, this.zPi, zPg);
      if (paramUri == null)
      {
        Mm(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if ((Util.isNullOrNil(this.zPa)) || (Util.isNullOrNil(dOe())))
      {
        Mm(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if (!dak())
      {
        Mm(1);
        paramUri = this.vsh;
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (!gh(this.zPi))
      {
        Log.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
        Mm(2);
        AppMethodBeat.o(24430);
        return null;
      }
    }
    paramArrayOfString1 = Util.nullAsNil(paramUri.getQueryParameter("source"));
    paramString1 = Util.nullAsNil(paramUri.getQueryParameter("count"));
    if (!this.zPh) {
      this.zOP = zPg.match(paramUri);
    }
    switch (this.zOP)
    {
    default: 
      hf(3, 15);
      AppMethodBeat.o(24430);
      return null;
    case 7: 
      paramUri = d(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(24430);
      return paramUri;
    case 8: 
      paramUri = C(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 9: 
      paramUri = b(paramArrayOfString2, paramArrayOfString1, paramString1);
      AppMethodBeat.o(24430);
      return paramUri;
    case 10: 
      paramUri = dOg();
      AppMethodBeat.o(24430);
      return paramUri;
    case 11: 
      paramUri = D(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 12: 
      paramUri = E(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 13: 
      paramUri = F(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    }
    paramUri = G(paramArrayOfString2);
    AppMethodBeat.o(24430);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg
 * JD-Core Version:    0.7.0.1
 */