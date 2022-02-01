package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.ge;
import com.tencent.mm.f.a.ge.b;
import com.tencent.mm.f.a.gg;
import com.tencent.mm.f.a.gh;
import com.tencent.mm.f.a.gh.b;
import com.tencent.mm.f.a.gn;
import com.tencent.mm.f.a.gn.b;
import com.tencent.mm.f.a.go;
import com.tencent.mm.f.a.go.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.pluginsdk.e.a.a;
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
import com.tencent.mm.storage.cs;
import com.tencent.mm.storage.ct;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderMsg
  extends ExtContentProviderBase
{
  private static final UriMatcher wta;
  private static final String[] wtd;
  private static final String[] wte;
  private static final String[] wtf;
  private static final String[] wtg;
  private static final String[] wth;
  private static final String[] wti;
  private String[] wsI = null;
  private int wsJ = -1;
  private boolean wtb = false;
  private Context wtc;
  private MatrixCursor wtj = null;
  
  static
  {
    AppMethodBeat.i(24440);
    wtd = new String[] { "msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime" };
    wte = new String[] { "userId", "unReadCount" };
    wtf = new String[] { "userId", "unReadCount" };
    wtg = new String[] { "userId", "retCode", "msgId" };
    wth = new String[] { "msgId", "retCode" };
    wti = new String[] { "msgId", "retCode" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    wta = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "oneMsg", 7);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadCount", 8);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadMsgs", 9);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadUserList", 10);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "recordMsg", 11);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "playVoice", 12);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "setReaded", 13);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "sendTextMsg", 14);
    AppMethodBeat.o(24440);
  }
  
  public ExtControlProviderMsg() {}
  
  public ExtControlProviderMsg(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.wtb = true;
    this.wsI = paramArrayOfString;
    this.wsJ = paramInt;
    this.wtc = paramContext;
  }
  
  private Cursor B(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24431);
    Log.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      Lp(3);
      AppMethodBeat.o(24431);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(wte);
    try
    {
      if ("*".equals(paramArrayOfString[0]))
      {
        bh.beI();
        localMatrixCursor.addRow(new Object[] { "0", Integer.valueOf(c.bbR().bwK("")) });
      }
      for (;;)
      {
        Lp(0);
        AppMethodBeat.o(24431);
        return localMatrixCursor;
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          long l = AESUtil.azp(paramArrayOfString[i]);
          bh.beI();
          as localas = c.bbL().UT(l);
          if ((localas != null) && ((int)localas.jxt > 0))
          {
            bh.beI();
            localMatrixCursor.addRow(new Object[] { Long.valueOf(l), Integer.valueOf(c.bbR().bwK(" and ( rconversation.username='" + localas.field_username + "' );")) });
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
      Lp(4);
      AppMethodBeat.o(24431);
    }
  }
  
  private Cursor C(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24435);
    Log.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      Log.w("MicroMsg.ExtControlProviderMsg", "wrong args");
      Lp(3);
      AppMethodBeat.o(24435);
      return null;
    }
    try
    {
      final int i = Integer.valueOf(paramArrayOfString[0]).intValue();
      final long l = AESUtil.azp(paramArrayOfString[1]);
      if (l <= 0L)
      {
        Lp(3);
        AppMethodBeat.o(24435);
        return null;
      }
      com.tencent.mm.pluginsdk.e.a.b localb = new com.tencent.mm.pluginsdk.e.a.b();
      localb.c(4000L, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24427);
          Object localObject1;
          Object localObject2;
          if (i == 1)
          {
            com.tencent.mm.plugin.ext.b.dhf();
            localObject1 = com.tencent.mm.plugin.ext.b.JO(l);
            if ((localObject1 == null) || ((int)((d)localObject1).jxt <= 0))
            {
              ExtControlProviderMsg.this.Lp(3);
              paramArrayOfString.Sz();
              AppMethodBeat.o(24427);
              return;
            }
            localObject2 = new gh();
            ((gh)localObject2).fCu.op = 1;
            ((gh)localObject2).fCu.username = ((ax)localObject1).field_username;
            if (!EventCenter.instance.publish((IEvent)localObject2))
            {
              ExtControlProviderMsg.this.Lp(4);
              paramArrayOfString.Sz();
              AppMethodBeat.o(24427);
              return;
            }
            ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.dhw()));
            if ((localObject1 != null) && ((int)((d)localObject1).jxt > 0) && (((gh)localObject2).fCv.fyl))
            {
              ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.jxc[1], Integer.valueOf(1), "0" });
              ExtControlProviderMsg.this.Lp(0);
              Log.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[] { Boolean.valueOf(((gh)localObject2).fCv.fyl), ((gh)localObject2).fCv.fileName });
            }
          }
          for (;;)
          {
            paramArrayOfString.Sz();
            AppMethodBeat.o(24427);
            return;
            ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.jxc[1], Integer.valueOf(2), "0" });
            ExtControlProviderMsg.this.Lp(3);
            break;
            if (i == 2)
            {
              localObject1 = new gh();
              ((gh)localObject1).fCu.op = 2;
              if (!EventCenter.instance.publish((IEvent)localObject1))
              {
                ExtControlProviderMsg.this.Lp(4);
                paramArrayOfString.Sz();
                AppMethodBeat.o(24427);
                return;
              }
              localObject2 = ((gh)localObject1).fCv.fileName;
              ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.dhw()));
              gn localgn = new gn();
              localgn.fCP.fileName = ((String)localObject2);
              if (!EventCenter.instance.publish(localgn))
              {
                ExtControlProviderMsg.this.Lp(4);
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).close();
                paramArrayOfString.Sz();
                AppMethodBeat.o(24427);
                return;
              }
              Log.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[] { Long.valueOf(localgn.fCQ.msgId) });
              long l = localgn.fCQ.msgId;
              if (l > 0L)
              {
                try
                {
                  if (!((gh)localObject1).fCv.fyl) {
                    break label643;
                  }
                  if ((MMApplicationContext.getContext() == null) || (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))) {
                    break label594;
                  }
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.jxc[1], Integer.valueOf(1), AESUtil.JQ(l) });
                  ExtControlProviderMsg.this.Lp(0);
                }
                catch (Exception localException)
                {
                  Log.w("MicroMsg.ExtControlProviderMsg", localException.getMessage());
                  Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
                  ExtControlProviderMsg.this.Lp(4);
                }
                continue;
                label594:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.jxc[1], Integer.valueOf(6), AESUtil.JQ(l) });
                ExtControlProviderMsg.this.Lp(4);
                continue;
                label643:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.jxc[1], Integer.valueOf(4), AESUtil.JQ(l) });
                ExtControlProviderMsg.this.Lp(4);
              }
              else
              {
                ExtControlProviderMsg.this.Lp(3);
              }
            }
          }
        }
      });
      paramArrayOfString = this.wtj;
      AppMethodBeat.o(24435);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.wtj != null) {
        this.wtj.close();
      }
      Lp(4);
      AppMethodBeat.o(24435);
    }
    return null;
  }
  
  private Cursor D(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24436);
    Log.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      Lp(3);
      AppMethodBeat.o(24436);
      return null;
    }
    Object localObject = null;
    try
    {
      i = Integer.valueOf(paramArrayOfString[0]).intValue();
      long l = AESUtil.azp(paramArrayOfString[1]);
      if (l <= 0L)
      {
        Lp(3);
        AppMethodBeat.o(24436);
        return null;
      }
      if (i != 3) {
        break label364;
      }
      MatrixCursor localMatrixCursor = new MatrixCursor(wth);
      try
      {
        localObject = new go();
        ((go)localObject).fCR.msgId = l;
        EventCenter.instance.publish((IEvent)localObject);
        if ((((go)localObject).fCS.fileName == null) || (((go)localObject).fCS.fileName.length() <= 0))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          Lp(4);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
        }
        gg localgg = new gg();
        localgg.fCp.op = 1;
        localgg.fCp.fileName = ((go)localObject).fCS.fileName;
        if (EventCenter.instance.publish(localgg))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(1) });
          Lp(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.ext.b.dhf();
          com.tencent.mm.plugin.ext.b.JP(l);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
          Log.e("MicroMsg.ExtControlProviderMsg", "play failed");
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          Lp(4);
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
    Lp(4);
    AppMethodBeat.o(24436);
    return null;
    label364:
    if (i == 4)
    {
      paramArrayOfString = new gg();
      paramArrayOfString.fCp.op = 2;
      if (!EventCenter.instance.publish(paramArrayOfString)) {
        break label416;
      }
      Log.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
      Lp(0);
    }
    for (;;)
    {
      AppMethodBeat.o(24436);
      return null;
      label416:
      Log.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
      Lp(4);
    }
  }
  
  private Cursor E(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24437);
    Log.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      gm(3, 3801);
      paramArrayOfString = a.apu(3801);
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
            long l = AESUtil.azp(paramArrayOfString[i]);
            com.tencent.mm.plugin.ext.b.dhf();
            com.tencent.mm.plugin.ext.b.JP(l);
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        gm(4, 12);
        paramArrayOfString = a.apu(12);
        AppMethodBeat.o(24437);
        return paramArrayOfString;
      }
      gm(0, 1);
      paramArrayOfString = a.apu(1);
      AppMethodBeat.o(24437);
      return paramArrayOfString;
      i += 1;
    }
  }
  
  private Cursor F(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24438);
    Log.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      Lp(3);
      AppMethodBeat.o(24438);
      return null;
    }
    try
    {
      long l = AESUtil.azp(paramArrayOfString[0]);
      if (l <= 0L)
      {
        Lp(3);
        AppMethodBeat.o(24438);
        return null;
      }
      com.tencent.mm.plugin.ext.b.dhf();
      final as localas = com.tencent.mm.plugin.ext.b.JO(l);
      if ((localas == null) || ((int)localas.jxt <= 0))
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
        Lp(3);
        AppMethodBeat.o(24438);
        return null;
      }
      this.wtj = new MatrixCursor(wti);
      final com.tencent.mm.pluginsdk.e.a.b localb = new com.tencent.mm.pluginsdk.e.a.b();
      localb.c(15000L, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24429);
          Object localObject = new ge();
          ((ge)localObject).fCj.fCl = localas.field_username;
          ((ge)localObject).fCj.content = paramArrayOfString[1];
          ((ge)localObject).fCj.type = ab.QZ(localas.field_username);
          ((ge)localObject).fCj.flags = 0;
          if (!EventCenter.instance.publish((IEvent)localObject))
          {
            ExtControlProviderMsg.this.Lp(4);
            localb.Sz();
            AppMethodBeat.o(24429);
            return;
          }
          q localq = ((ge)localObject).fCk.fCm;
          try
          {
            localObject = new com.tencent.mm.an.i()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
              {
                AppMethodBeat.i(24428);
                Log.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                if (paramAnonymous2q == null)
                {
                  Log.e("MicroMsg.ExtControlProviderMsg", "scene == null");
                  bh.aGY().b(522, this);
                  ExtControlProviderMsg.this.Lp(4);
                  ExtControlProviderMsg.2.this.sgy.Sz();
                  AppMethodBeat.o(24428);
                  return;
                }
                switch (paramAnonymous2q.getType())
                {
                default: 
                  ExtControlProviderMsg.this.Lp(0);
                }
                for (;;)
                {
                  ExtControlProviderMsg.2.this.sgy.Sz();
                  bh.aGY().b(522, this);
                  AppMethodBeat.o(24428);
                  return;
                  if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                  {
                    Log.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                    ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.wtn, Integer.valueOf(1) });
                    break;
                  }
                  Log.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + paramAnonymous2Int1 + ", errCode = " + paramAnonymous2Int2);
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.wtn, Integer.valueOf(2) });
                  ExtControlProviderMsg.this.Lp(4);
                }
              }
            };
            bh.aGY().a(522, (com.tencent.mm.an.i)localObject);
            bh.aGY().a(localq, 0);
            AppMethodBeat.o(24429);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
            ExtControlProviderMsg.this.Lp(4);
            localb.Sz();
            AppMethodBeat.o(24429);
          }
        }
      });
      paramArrayOfString = this.wtj;
      AppMethodBeat.o(24438);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      Log.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.wtj != null) {
        this.wtj.close();
      }
      Lp(4);
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
      i = bq.RI(paramca.field_content);
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
                localObject = aa.PJ(str4);
                str1 = paramca.field_content.substring(i + 2);
              }
            }
          }
        }
      }
    }
    int k = com.tencent.mm.plugin.ext.b.b.aD(paramca);
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
            localObject = o.brz().xk((int)paramca.field_msgId);
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
          if (this.wtc != null)
          {
            localObject = this.wtc.getString(R.l.eEs);
            break;
          }
          localObject = "";
          break;
          paramString2 = AESUtil.JQ((int)paramas.jxt);
          continue;
        }
        paramas = AESUtil.JQ(paramca.field_msgId);
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
      Lp(3);
      AppMethodBeat.o(24434);
      return null;
    }
    for (;;)
    {
      try
      {
        long l = AESUtil.azp(paramArrayOfString[0]);
        bh.beI();
        localca = c.bbO().Oq(l);
        bh.beI();
        localas = c.bbL().RG(localca.field_talker);
        if ((localas == null) || ((int)localas.jxt <= 0))
        {
          Lp(3);
          AppMethodBeat.o(24434);
          return null;
        }
        str = localas.ays();
        if (!ab.Lj(localas.field_username)) {
          break label256;
        }
        str = aa.PJ(localas.field_username);
        bool1 = true;
        if ((paramString != null) && (paramString.equalsIgnoreCase("openapi"))) {
          paramString = new MatrixCursor(wtd);
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
        Lp(4);
        AppMethodBeat.o(24434);
        return null;
      }
      try
      {
        a(paramString, localca, localas, bool1, str, bool2, paramArrayOfString[0]);
        Lp(0);
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
      gm(3, 3701);
      paramArrayOfString = a.apu(3701);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
      gm(3, 3702);
      paramArrayOfString = a.apu(3702);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
      gm(3, 3703);
      paramArrayOfString = a.apu(3703);
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
        paramString1 = com.tencent.mm.plugin.ext.b.dhi().bxx(paramArrayOfString[0]);
        if ((paramString1 == null) || (Util.isNullOrNil(paramString1.field_openId)) || (Util.isNullOrNil(paramString1.field_username)))
        {
          Log.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
          gm(3, 3704);
          paramArrayOfString = a.apu(3704);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          bool1 = false;
          break;
        }
        bh.beI();
        as localas = c.bbL().RG(paramString1.field_username);
        if ((localas == null) || (localas.field_username == null) || (localas.field_username.length() <= 0))
        {
          Log.e("MicroMsg.ExtControlProviderMsg", "contact is null");
          gm(3, 3705);
          paramArrayOfString = a.apu(3705);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          label315:
          long l = AESUtil.azp(paramArrayOfString[0]);
          bh.beI();
          localas = c.bbL().UT(l);
        }
        else
        {
          String str = localas.ays();
          if (ab.Lj(localas.field_username))
          {
            str = aa.PJ(localas.field_username);
            bool2 = true;
            if (bool1)
            {
              try
              {
                i = Util.getInt(paramString2, 0);
                if ((i <= 0) || (i >= 15))
                {
                  bh.beI();
                  paramString1 = c.bbO().ff(localas.field_username, 15);
                  if (paramString1 != null) {
                    continue;
                  }
                  Log.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                  ad(3, 4, 3706);
                  paramArrayOfString = a.apu(3706);
                  AppMethodBeat.o(24432);
                  return paramArrayOfString;
                }
              }
              catch (Exception paramString1)
              {
                Log.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[] { paramString2 });
                int i = 0;
                continue;
                bh.beI();
                paramString1 = c.bbO().ff(localas.field_username, i);
                continue;
              }
            }
            else
            {
              bh.beI();
              paramString1 = c.bbO().ff(localas.field_username, 3);
              continue;
            }
            paramString2 = new MatrixCursor(wtd);
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
          ad(2, 0, 1);
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
        ad(3, 4, 12);
        paramArrayOfString = a.apu(12);
        AppMethodBeat.o(24432);
        return paramArrayOfString;
      }
    }
  }
  
  private Cursor dhv()
  {
    AppMethodBeat.i(24433);
    Log.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
    MatrixCursor localMatrixCursor = new MatrixCursor(wtf);
    label267:
    for (;;)
    {
      try
      {
        bh.beI();
        Cursor localCursor = c.bbO().eSs();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            String str = localCursor.getString(localCursor.getColumnIndex("talker"));
            bh.beI();
            as localas = c.bbL().RG(str);
            if (!ab.Lj(str))
            {
              if ((ab.QX(localas.field_username)) || (ab.QT(localas.field_username)) || (as.asD(localas.field_verifyFlag)) || (ab.QL(localas.field_username))) {
                break label267;
              }
              if (!ab.QM(localas.field_username)) {
                continue;
              }
              break label267;
              if (i == 0) {
                localMatrixCursor.addRow(new Object[] { AESUtil.JQ((int)localas.jxt), Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("unReadCount"))) });
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
          Lp(0);
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
        Lp(4);
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
    Log.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.wtb);
    if (this.wtb)
    {
      a(paramUri, this.wtc, this.wsJ, this.wsI);
      if (Util.isNullOrNil(this.wsU))
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
        gm(3, 7);
        paramUri = a.apu(7);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (Util.isNullOrNil(dht()))
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
        gm(3, 6);
        paramUri = a.apu(6);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      int i = dhu();
      if (i != 1)
      {
        Log.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(i)));
        gm(2, i);
        paramUri = a.apu(i);
        AppMethodBeat.o(24430);
        return paramUri;
      }
    }
    else
    {
      this.wtc = getContext();
      a(paramUri, this.wtc, wta);
      if (paramUri == null)
      {
        Lp(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if ((Util.isNullOrNil(this.wsU)) || (Util.isNullOrNil(dht())))
      {
        Lp(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if (!cxw())
      {
        Lp(1);
        paramUri = this.sgp;
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (!fj(this.wtc))
      {
        Log.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
        Lp(2);
        AppMethodBeat.o(24430);
        return null;
      }
    }
    paramArrayOfString1 = Util.nullAsNil(paramUri.getQueryParameter("source"));
    paramString1 = Util.nullAsNil(paramUri.getQueryParameter("count"));
    if (!this.wtb) {
      this.wsJ = wta.match(paramUri);
    }
    switch (this.wsJ)
    {
    default: 
      gm(3, 15);
      AppMethodBeat.o(24430);
      return null;
    case 7: 
      paramUri = b(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(24430);
      return paramUri;
    case 8: 
      paramUri = B(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 9: 
      paramUri = b(paramArrayOfString2, paramArrayOfString1, paramString1);
      AppMethodBeat.o(24430);
      return paramUri;
    case 10: 
      paramUri = dhv();
      AppMethodBeat.o(24430);
      return paramUri;
    case 11: 
      paramUri = C(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 12: 
      paramUri = D(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 13: 
      paramUri = E(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    }
    paramUri = F(paramArrayOfString2);
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