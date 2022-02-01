package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.fx.b;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.a.ga.b;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.gg.b;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.gh.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cr;
import com.tencent.mm.storage.cs;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderMsg
  extends ExtContentProviderBase
{
  private static final UriMatcher sNf;
  private static final String[] sNi;
  private static final String[] sNj;
  private static final String[] sNk;
  private static final String[] sNl;
  private static final String[] sNm;
  private static final String[] sNn;
  private String[] sMN = null;
  private int sMO = -1;
  private boolean sNg = false;
  private Context sNh;
  private MatrixCursor sNo = null;
  
  static
  {
    AppMethodBeat.i(24440);
    sNi = new String[] { "msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime" };
    sNj = new String[] { "userId", "unReadCount" };
    sNk = new String[] { "userId", "unReadCount" };
    sNl = new String[] { "userId", "retCode", "msgId" };
    sNm = new String[] { "msgId", "retCode" };
    sNn = new String[] { "msgId", "retCode" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    sNf = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "oneMsg", 7);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadCount", 8);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadMsgs", 9);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadUserList", 10);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "recordMsg", 11);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "playVoice", 12);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "setReaded", 13);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "sendTextMsg", 14);
    AppMethodBeat.o(24440);
  }
  
  public ExtControlProviderMsg() {}
  
  public ExtControlProviderMsg(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.sNg = true;
    this.sMN = paramArrayOfString;
    this.sMO = paramInt;
    this.sNh = paramContext;
  }
  
  private Cursor C(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24431);
    Log.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      HF(3);
      AppMethodBeat.o(24431);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(sNj);
    try
    {
      if ("*".equals(paramArrayOfString[0]))
      {
        bg.aVF();
        localMatrixCursor.addRow(new Object[] { "0", Integer.valueOf(com.tencent.mm.model.c.aST().JP("")) });
      }
      for (;;)
      {
        HF(0);
        AppMethodBeat.o(24431);
        return localMatrixCursor;
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          long l = AESUtil.aro(paramArrayOfString[i]);
          bg.aVF();
          as localas = com.tencent.mm.model.c.aSN().Nh(l);
          if ((localas != null) && ((int)localas.gMZ > 0))
          {
            bg.aVF();
            localMatrixCursor.addRow(new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.aST().JP(" and ( rconversation.username='" + localas.field_username + "' );")) });
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
      HF(4);
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
      HF(3);
      AppMethodBeat.o(24435);
      return null;
    }
    try
    {
      final int i = Integer.valueOf(paramArrayOfString[0]).intValue();
      final long l = AESUtil.aro(paramArrayOfString[1]);
      if (l <= 0L)
      {
        HF(3);
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
            com.tencent.mm.plugin.ext.b.cSf();
            localObject1 = com.tencent.mm.plugin.ext.b.DA(l);
            if ((localObject1 == null) || ((int)((com.tencent.mm.contact.c)localObject1).gMZ <= 0))
            {
              ExtControlProviderMsg.this.HF(3);
              paramArrayOfString.countDown();
              AppMethodBeat.o(24427);
              return;
            }
            localObject2 = new ga();
            ((ga)localObject2).dJF.op = 1;
            ((ga)localObject2).dJF.username = ((ax)localObject1).field_username;
            if (!EventCenter.instance.publish((IEvent)localObject2))
            {
              ExtControlProviderMsg.this.HF(4);
              paramArrayOfString.countDown();
              AppMethodBeat.o(24427);
              return;
            }
            ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.cSw()));
            if ((localObject1 != null) && ((int)((com.tencent.mm.contact.c)localObject1).gMZ > 0) && (((ga)localObject2).dJG.dFE))
            {
              ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.gMN[1], Integer.valueOf(1), "0" });
              ExtControlProviderMsg.this.HF(0);
              Log.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[] { Boolean.valueOf(((ga)localObject2).dJG.dFE), ((ga)localObject2).dJG.fileName });
            }
          }
          for (;;)
          {
            paramArrayOfString.countDown();
            AppMethodBeat.o(24427);
            return;
            ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.gMN[1], Integer.valueOf(2), "0" });
            ExtControlProviderMsg.this.HF(3);
            break;
            if (i == 2)
            {
              localObject1 = new ga();
              ((ga)localObject1).dJF.op = 2;
              if (!EventCenter.instance.publish((IEvent)localObject1))
              {
                ExtControlProviderMsg.this.HF(4);
                paramArrayOfString.countDown();
                AppMethodBeat.o(24427);
                return;
              }
              localObject2 = ((ga)localObject1).dJG.fileName;
              ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.cSw()));
              gg localgg = new gg();
              localgg.dKa.fileName = ((String)localObject2);
              if (!EventCenter.instance.publish(localgg))
              {
                ExtControlProviderMsg.this.HF(4);
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).close();
                paramArrayOfString.countDown();
                AppMethodBeat.o(24427);
                return;
              }
              Log.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[] { Long.valueOf(localgg.dKb.msgId) });
              long l = localgg.dKb.msgId;
              if (l > 0L)
              {
                try
                {
                  if (!((ga)localObject1).dJG.dFE) {
                    break label643;
                  }
                  if ((MMApplicationContext.getContext() == null) || (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))) {
                    break label594;
                  }
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.gMN[1], Integer.valueOf(1), AESUtil.DC(l) });
                  ExtControlProviderMsg.this.HF(0);
                }
                catch (Exception localException)
                {
                  Log.w("MicroMsg.ExtControlProviderMsg", localException.getMessage());
                  Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
                  ExtControlProviderMsg.this.HF(4);
                }
                continue;
                label594:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.gMN[1], Integer.valueOf(6), AESUtil.DC(l) });
                ExtControlProviderMsg.this.HF(4);
                continue;
                label643:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.gMN[1], Integer.valueOf(4), AESUtil.DC(l) });
                ExtControlProviderMsg.this.HF(4);
              }
              else
              {
                ExtControlProviderMsg.this.HF(3);
              }
            }
          }
        }
      });
      paramArrayOfString = this.sNo;
      AppMethodBeat.o(24435);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.sNo != null) {
        this.sNo.close();
      }
      HF(4);
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
      HF(3);
      AppMethodBeat.o(24436);
      return null;
    }
    Object localObject = null;
    try
    {
      i = Integer.valueOf(paramArrayOfString[0]).intValue();
      long l = AESUtil.aro(paramArrayOfString[1]);
      if (l <= 0L)
      {
        HF(3);
        AppMethodBeat.o(24436);
        return null;
      }
      if (i != 3) {
        break label364;
      }
      MatrixCursor localMatrixCursor = new MatrixCursor(sNm);
      try
      {
        localObject = new gh();
        ((gh)localObject).dKc.msgId = l;
        EventCenter.instance.publish((IEvent)localObject);
        if ((((gh)localObject).dKd.fileName == null) || (((gh)localObject).dKd.fileName.length() <= 0))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          HF(4);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
        }
        fz localfz = new fz();
        localfz.dJA.op = 1;
        localfz.dJA.fileName = ((gh)localObject).dKd.fileName;
        if (EventCenter.instance.publish(localfz))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(1) });
          HF(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.ext.b.cSf();
          com.tencent.mm.plugin.ext.b.DB(l);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
          Log.e("MicroMsg.ExtControlProviderMsg", "play failed");
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          HF(4);
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
      label320:
      break label320;
    }
    Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
    if (localObject != null) {
      ((MatrixCursor)localObject).close();
    }
    HF(4);
    AppMethodBeat.o(24436);
    return null;
    label364:
    if (i == 4)
    {
      paramArrayOfString = new fz();
      paramArrayOfString.dJA.op = 2;
      if (!EventCenter.instance.publish(paramArrayOfString)) {
        break label416;
      }
      Log.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
      HF(0);
    }
    for (;;)
    {
      AppMethodBeat.o(24436);
      return null;
      label416:
      Log.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
      HF(4);
    }
  }
  
  private Cursor F(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24437);
    Log.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      fP(3, 3801);
      paramArrayOfString = a.ahx(3801);
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
            long l = AESUtil.aro(paramArrayOfString[i]);
            com.tencent.mm.plugin.ext.b.cSf();
            com.tencent.mm.plugin.ext.b.DB(l);
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        fP(4, 12);
        paramArrayOfString = a.ahx(12);
        AppMethodBeat.o(24437);
        return paramArrayOfString;
      }
      fP(0, 1);
      paramArrayOfString = a.ahx(1);
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
      HF(3);
      AppMethodBeat.o(24438);
      return null;
    }
    try
    {
      long l = AESUtil.aro(paramArrayOfString[0]);
      if (l <= 0L)
      {
        HF(3);
        AppMethodBeat.o(24438);
        return null;
      }
      com.tencent.mm.plugin.ext.b.cSf();
      final as localas = com.tencent.mm.plugin.ext.b.DA(l);
      if ((localas == null) || ((int)localas.gMZ <= 0))
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
        HF(3);
        AppMethodBeat.o(24438);
        return null;
      }
      this.sNo = new MatrixCursor(sNn);
      final com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
      localb.c(15000L, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24429);
          Object localObject = new fx();
          ((fx)localObject).dJu.dJw = localas.field_username;
          ((fx)localObject).dJu.content = paramArrayOfString[1];
          ((fx)localObject).dJu.type = ab.JG(localas.field_username);
          ((fx)localObject).dJu.flags = 0;
          if (!EventCenter.instance.publish((IEvent)localObject))
          {
            ExtControlProviderMsg.this.HF(4);
            localb.countDown();
            AppMethodBeat.o(24429);
            return;
          }
          q localq = ((fx)localObject).dJv.dJx;
          try
          {
            localObject = new com.tencent.mm.ak.i()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
              {
                AppMethodBeat.i(24428);
                Log.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                if (paramAnonymous2q == null)
                {
                  Log.e("MicroMsg.ExtControlProviderMsg", "scene == null");
                  bg.azz().b(522, this);
                  ExtControlProviderMsg.this.HF(4);
                  ExtControlProviderMsg.2.this.pev.countDown();
                  AppMethodBeat.o(24428);
                  return;
                }
                switch (paramAnonymous2q.getType())
                {
                default: 
                  ExtControlProviderMsg.this.HF(0);
                }
                for (;;)
                {
                  ExtControlProviderMsg.2.this.pev.countDown();
                  bg.azz().b(522, this);
                  AppMethodBeat.o(24428);
                  return;
                  if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                  {
                    Log.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                    ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.sNs, Integer.valueOf(1) });
                    break;
                  }
                  Log.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + paramAnonymous2Int1 + ", errCode = " + paramAnonymous2Int2);
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.sNs, Integer.valueOf(2) });
                  ExtControlProviderMsg.this.HF(4);
                }
              }
            };
            bg.azz().a(522, (com.tencent.mm.ak.i)localObject);
            bg.azz().a(localq, 0);
            AppMethodBeat.o(24429);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
            ExtControlProviderMsg.this.HF(4);
            localb.countDown();
            AppMethodBeat.o(24429);
          }
        }
      });
      paramArrayOfString = this.sNo;
      AppMethodBeat.o(24438);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.sNo != null) {
        this.sNo.close();
      }
      HF(4);
      AppMethodBeat.o(24438);
    }
    return null;
  }
  
  private void a(MatrixCursor paramMatrixCursor, ca paramca, as paramas, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    AppMethodBeat.i(24439);
    if (paramca == null)
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
    if ((paramca.getType() == 9999) || (paramca.getType() == 10000))
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
      i = bp.Kp(paramca.field_content);
      str1 = str3;
      localObject = str2;
      if (i != -1)
      {
        str1 = str3;
        localObject = str2;
        if (paramca.field_content.length() > i)
        {
          String str4 = paramca.field_content.substring(0, i).trim();
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
              if (paramca.field_content.length() >= i + 2)
              {
                localObject = aa.getDisplayName(str4);
                str1 = paramca.field_content.substring(i + 2);
              }
            }
          }
        }
      }
    }
    int k = com.tencent.mm.plugin.ext.b.b.av(paramca);
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
          localObject = paramca.field_content;
          break;
          if (k == 2)
          {
            localObject = o.bib().uk((int)paramca.field_msgId);
            if ((localObject == null) || (((r)localObject).fileName == null)) {
              break label550;
            }
            localObject = s.getFullPath(((r)localObject).fileName);
            Log.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", new Object[] { localObject });
            break;
          }
          if (paramBoolean1) {
            break;
          }
          if (this.sNh != null)
          {
            localObject = this.sNh.getString(2131758960);
            break;
          }
          localObject = "";
          break;
          paramString2 = AESUtil.DC((int)paramas.gMZ);
          continue;
        }
        paramas = AESUtil.DC(paramca.field_msgId);
        if (paramca.field_isSend == 0)
        {
          i = 1;
          if (paramca.field_status == 4)
          {
            j = 1;
            paramMatrixCursor.addRow(new Object[] { paramas, paramString2, paramString1, Integer.valueOf(i), Integer.valueOf(k), localObject, Integer.valueOf(j), Long.valueOf(paramca.field_createTime) });
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
  
  private Cursor b(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(24434);
    Log.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      HF(3);
      AppMethodBeat.o(24434);
      return null;
    }
    for (;;)
    {
      try
      {
        long l = AESUtil.aro(paramArrayOfString[0]);
        bg.aVF();
        localca = com.tencent.mm.model.c.aSQ().Hb(l);
        bg.aVF();
        localas = com.tencent.mm.model.c.aSN().Kn(localca.field_talker);
        if ((localas == null) || ((int)localas.gMZ <= 0))
        {
          HF(3);
          AppMethodBeat.o(24434);
          return null;
        }
        str = localas.arJ();
        if (!ab.Eq(localas.field_username)) {
          break label256;
        }
        str = aa.getDisplayName(localas.field_username);
        bool1 = true;
        if ((paramString != null) && (paramString.equalsIgnoreCase("openapi"))) {
          paramString = new MatrixCursor(sNi);
        }
      }
      catch (Exception paramArrayOfString)
      {
        ca localca;
        as localas;
        String str;
        paramString = null;
        Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString != null) {
          paramString.close();
        }
        HF(4);
        AppMethodBeat.o(24434);
        return null;
      }
      try
      {
        a(paramString, localca, localas, bool1, str, bool2, paramArrayOfString[0]);
        HF(0);
        AppMethodBeat.o(24434);
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
  
  private Cursor b(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(24432);
    Log.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
    Log.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      fP(3, 3701);
      paramArrayOfString = a.ahx(3701);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
      fP(3, 3702);
      paramArrayOfString = a.ahx(3702);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
      fP(3, 3703);
      paramArrayOfString = a.ahx(3703);
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
        paramString1 = com.tencent.mm.plugin.ext.b.cSi().bkX(paramArrayOfString[0]);
        if ((paramString1 == null) || (Util.isNullOrNil(paramString1.field_openId)) || (Util.isNullOrNil(paramString1.field_username)))
        {
          Log.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
          fP(3, 3704);
          paramArrayOfString = a.ahx(3704);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          bool1 = false;
          break;
        }
        bg.aVF();
        as localas = com.tencent.mm.model.c.aSN().Kn(paramString1.field_username);
        if ((localas == null) || (localas.field_username == null) || (localas.field_username.length() <= 0))
        {
          Log.e("MicroMsg.ExtControlProviderMsg", "contact is null");
          fP(3, 3705);
          paramArrayOfString = a.ahx(3705);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          label315:
          long l = AESUtil.aro(paramArrayOfString[0]);
          bg.aVF();
          localas = com.tencent.mm.model.c.aSN().Nh(l);
        }
        else
        {
          String str = localas.arJ();
          if (ab.Eq(localas.field_username))
          {
            str = aa.getDisplayName(localas.field_username);
            bool2 = true;
            if (bool1)
            {
              try
              {
                i = Util.getInt(paramString2, 0);
                if ((i <= 0) || (i >= 15))
                {
                  bg.aVF();
                  paramString1 = com.tencent.mm.model.c.aSQ().eE(localas.field_username, 15);
                  if (paramString1 != null) {
                    continue;
                  }
                  Log.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                  ac(3, 4, 3706);
                  paramArrayOfString = a.ahx(3706);
                  AppMethodBeat.o(24432);
                  return paramArrayOfString;
                }
              }
              catch (Exception paramString1)
              {
                Log.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[] { paramString2 });
                int i = 0;
                continue;
                bg.aVF();
                paramString1 = com.tencent.mm.model.c.aSQ().eE(localas.field_username, i);
                continue;
              }
            }
            else
            {
              bg.aVF();
              paramString1 = com.tencent.mm.model.c.aSQ().eE(localas.field_username, 3);
              continue;
            }
            paramString2 = new MatrixCursor(sNi);
          }
          ca localca;
          boolean bool2 = false;
        }
      }
      catch (Exception paramArrayOfString)
      {
        try
        {
          if ((paramString1.getCount() > 0) && (paramString1.moveToFirst()))
          {
            localca = new ca();
            localca.convertFrom(paramString1);
            a(paramString2, localca, localas, bool2, str, bool1, paramArrayOfString[0]);
            if (paramString1.moveToNext()) {
              continue;
            }
          }
          paramString1.close();
          ac(2, 0, 1);
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
        ac(3, 4, 12);
        paramArrayOfString = a.ahx(12);
        AppMethodBeat.o(24432);
        return paramArrayOfString;
      }
    }
  }
  
  private Cursor cSv()
  {
    AppMethodBeat.i(24433);
    Log.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
    MatrixCursor localMatrixCursor = new MatrixCursor(sNk);
    label267:
    for (;;)
    {
      try
      {
        bg.aVF();
        Cursor localCursor = com.tencent.mm.model.c.aSQ().eiM();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            String str = localCursor.getString(localCursor.getColumnIndex("talker"));
            bg.aVF();
            as localas = com.tencent.mm.model.c.aSN().Kn(str);
            if (!ab.Eq(str))
            {
              if ((ab.JE(localas.field_username)) || (ab.JA(localas.field_username)) || (as.akh(localas.field_verifyFlag)) || (ab.Js(localas.field_username))) {
                break label267;
              }
              if (!ab.Jt(localas.field_username)) {
                continue;
              }
              break label267;
              if (i == 0) {
                localMatrixCursor.addRow(new Object[] { AESUtil.DC((int)localas.gMZ), Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("unReadCount"))) });
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
          HF(0);
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
        HF(4);
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
    Log.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.sNg);
    if (this.sNg)
    {
      a(paramUri, this.sNh, this.sMO, this.sMN);
      if (Util.isNullOrNil(this.sMZ))
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
        fP(3, 7);
        paramUri = a.ahx(7);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (Util.isNullOrNil(cSt()))
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
        fP(3, 6);
        paramUri = a.ahx(6);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      int i = cSu();
      if (i != 1)
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(i)));
        fP(2, i);
        paramUri = a.ahx(i);
        AppMethodBeat.o(24430);
        return paramUri;
      }
    }
    else
    {
      this.sNh = getContext();
      a(paramUri, this.sNh, sNf);
      if (paramUri == null)
      {
        HF(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if ((Util.isNullOrNil(this.sMZ)) || (Util.isNullOrNil(cSt())))
      {
        HF(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if (!ckf())
      {
        HF(1);
        paramUri = this.pem;
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (!fe(this.sNh))
      {
        Log.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
        HF(2);
        AppMethodBeat.o(24430);
        return null;
      }
    }
    paramArrayOfString1 = Util.nullAsNil(paramUri.getQueryParameter("source"));
    paramString1 = Util.nullAsNil(paramUri.getQueryParameter("count"));
    if (!this.sNg) {
      this.sMO = sNf.match(paramUri);
    }
    switch (this.sMO)
    {
    default: 
      fP(3, 15);
      AppMethodBeat.o(24430);
      return null;
    case 7: 
      paramUri = b(paramArrayOfString2, paramArrayOfString1);
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
      paramUri = cSv();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg
 * JD-Core Version:    0.7.0.1
 */