package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.g.a.fu.b;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.fx.b;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.gd.b;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.ge.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.cl;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderMsg
  extends ExtContentProviderBase
{
  private static final UriMatcher rlA;
  private static final String[] rlD;
  private static final String[] rlE;
  private static final String[] rlF;
  private static final String[] rlG;
  private static final String[] rlH;
  private static final String[] rlI;
  private boolean rlB = false;
  private Context rlC;
  private MatrixCursor rlJ = null;
  private String[] rli = null;
  private int rlj = -1;
  
  static
  {
    AppMethodBeat.i(24440);
    rlD = new String[] { "msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime" };
    rlE = new String[] { "userId", "unReadCount" };
    rlF = new String[] { "userId", "unReadCount" };
    rlG = new String[] { "userId", "retCode", "msgId" };
    rlH = new String[] { "msgId", "retCode" };
    rlI = new String[] { "msgId", "retCode" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    rlA = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
    rlA.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
    rlA.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
    rlA.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
    rlA.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
    rlA.addURI("com.tencent.mm.plugin.ext.message", "playVoice", 12);
    rlA.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
    rlA.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    AppMethodBeat.o(24440);
  }
  
  public ExtControlProviderMsg() {}
  
  public ExtControlProviderMsg(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.rlB = true;
    this.rli = paramArrayOfString;
    this.rlj = paramInt;
    this.rlC = paramContext;
  }
  
  private Cursor A(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24431);
    ae.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ae.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      DS(3);
      AppMethodBeat.o(24431);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(rlE);
    try
    {
      if ("*".equals(paramArrayOfString[0]))
      {
        bc.aCg();
        localMatrixCursor.addRow(new Object[] { "0", Integer.valueOf(com.tencent.mm.model.c.azL().Bk("")) });
      }
      for (;;)
      {
        DS(0);
        AppMethodBeat.o(24431);
        return localMatrixCursor;
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          long l = AESUtil.agE(paramArrayOfString[i]);
          bc.aCg();
          an localan = com.tencent.mm.model.c.azF().Ed(l);
          if ((localan != null) && ((int)localan.ght > 0))
          {
            bc.aCg();
            localMatrixCursor.addRow(new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.azL().Bk(" and ( rconversation.username='" + localan.field_username + "' );")) });
          }
          i += 1;
        }
      }
      return null;
    }
    catch (Exception paramArrayOfString)
    {
      ae.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      localMatrixCursor.close();
      DS(4);
      AppMethodBeat.o(24431);
    }
  }
  
  private Cursor B(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24435);
    ae.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ae.w("MicroMsg.ExtControlProviderMsg", "wrong args");
      DS(3);
      AppMethodBeat.o(24435);
      return null;
    }
    try
    {
      final int i = Integer.valueOf(paramArrayOfString[0]).intValue();
      final long l = AESUtil.agE(paramArrayOfString[1]);
      if (l <= 0L)
      {
        DS(3);
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
            com.tencent.mm.plugin.ext.b.ctx();
            localObject1 = com.tencent.mm.plugin.ext.b.vw(l);
            if ((localObject1 == null) || ((int)((com.tencent.mm.contact.c)localObject1).ght <= 0))
            {
              ExtControlProviderMsg.this.DS(3);
              paramArrayOfString.countDown();
              AppMethodBeat.o(24427);
              return;
            }
            localObject2 = new fx();
            ((fx)localObject2).dsu.op = 1;
            ((fx)localObject2).dsu.username = ((aw)localObject1).field_username;
            if (!com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2))
            {
              ExtControlProviderMsg.this.DS(4);
              paramArrayOfString.countDown();
              AppMethodBeat.o(24427);
              return;
            }
            ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.ctO()));
            if ((localObject1 != null) && ((int)((com.tencent.mm.contact.c)localObject1).ght > 0) && (((fx)localObject2).dsv.doq))
            {
              ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.ghh[1], Integer.valueOf(1), "0" });
              ExtControlProviderMsg.this.DS(0);
              ae.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[] { Boolean.valueOf(((fx)localObject2).dsv.doq), ((fx)localObject2).dsv.fileName });
            }
          }
          for (;;)
          {
            paramArrayOfString.countDown();
            AppMethodBeat.o(24427);
            return;
            ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.ghh[1], Integer.valueOf(2), "0" });
            ExtControlProviderMsg.this.DS(3);
            break;
            if (i == 2)
            {
              localObject1 = new fx();
              ((fx)localObject1).dsu.op = 2;
              if (!com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1))
              {
                ExtControlProviderMsg.this.DS(4);
                paramArrayOfString.countDown();
                AppMethodBeat.o(24427);
                return;
              }
              localObject2 = ((fx)localObject1).dsv.fileName;
              ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.ctO()));
              gd localgd = new gd();
              localgd.dsQ.fileName = ((String)localObject2);
              if (!com.tencent.mm.sdk.b.a.IvT.l(localgd))
              {
                ExtControlProviderMsg.this.DS(4);
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).close();
                paramArrayOfString.countDown();
                AppMethodBeat.o(24427);
                return;
              }
              ae.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[] { Long.valueOf(localgd.dsR.msgId) });
              long l = localgd.dsR.msgId;
              if (l > 0L)
              {
                try
                {
                  if (!((fx)localObject1).dsv.doq) {
                    break label643;
                  }
                  if ((ak.getContext() == null) || (!az.isConnected(ak.getContext()))) {
                    break label594;
                  }
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.ghh[1], Integer.valueOf(1), AESUtil.vy(l) });
                  ExtControlProviderMsg.this.DS(0);
                }
                catch (Exception localException)
                {
                  ae.w("MicroMsg.ExtControlProviderMsg", localException.getMessage());
                  ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
                  ExtControlProviderMsg.this.DS(4);
                }
                continue;
                label594:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.ghh[1], Integer.valueOf(6), AESUtil.vy(l) });
                ExtControlProviderMsg.this.DS(4);
                continue;
                label643:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.ghh[1], Integer.valueOf(4), AESUtil.vy(l) });
                ExtControlProviderMsg.this.DS(4);
              }
              else
              {
                ExtControlProviderMsg.this.DS(3);
              }
            }
          }
        }
      });
      paramArrayOfString = this.rlJ;
      AppMethodBeat.o(24435);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      ae.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.rlJ != null) {
        this.rlJ.close();
      }
      DS(4);
      AppMethodBeat.o(24435);
    }
    return null;
  }
  
  private Cursor C(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24436);
    ae.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ae.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      DS(3);
      AppMethodBeat.o(24436);
      return null;
    }
    Object localObject = null;
    try
    {
      i = Integer.valueOf(paramArrayOfString[0]).intValue();
      long l = AESUtil.agE(paramArrayOfString[1]);
      if (l <= 0L)
      {
        DS(3);
        AppMethodBeat.o(24436);
        return null;
      }
      if (i != 3) {
        break label364;
      }
      MatrixCursor localMatrixCursor = new MatrixCursor(rlH);
      try
      {
        localObject = new ge();
        ((ge)localObject).dsS.msgId = l;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        if ((((ge)localObject).dsT.fileName == null) || (((ge)localObject).dsT.fileName.length() <= 0))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          DS(4);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
        }
        fw localfw = new fw();
        localfw.dso.op = 1;
        localfw.dso.fileName = ((ge)localObject).dsT.fileName;
        if (com.tencent.mm.sdk.b.a.IvT.l(localfw))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(1) });
          DS(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.ext.b.ctx();
          com.tencent.mm.plugin.ext.b.vx(l);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
          ae.e("MicroMsg.ExtControlProviderMsg", "play failed");
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          DS(4);
        }
        ae.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
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
    ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
    if (localObject != null) {
      ((MatrixCursor)localObject).close();
    }
    DS(4);
    AppMethodBeat.o(24436);
    return null;
    label364:
    if (i == 4)
    {
      paramArrayOfString = new fw();
      paramArrayOfString.dso.op = 2;
      if (!com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfString)) {
        break label416;
      }
      ae.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
      DS(0);
    }
    for (;;)
    {
      AppMethodBeat.o(24436);
      return null;
      label416:
      ae.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
      DS(4);
    }
  }
  
  private Cursor D(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24437);
    ae.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ae.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      fz(3, 3801);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3801);
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
            ae.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = ".concat(String.valueOf(i)));
          }
          else
          {
            long l = AESUtil.agE(paramArrayOfString[i]);
            com.tencent.mm.plugin.ext.b.ctx();
            com.tencent.mm.plugin.ext.b.vx(l);
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ae.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        fz(4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(12);
        AppMethodBeat.o(24437);
        return paramArrayOfString;
      }
      fz(0, 1);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(1);
      AppMethodBeat.o(24437);
      return paramArrayOfString;
      i += 1;
    }
  }
  
  private Cursor E(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24438);
    ae.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ae.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      DS(3);
      AppMethodBeat.o(24438);
      return null;
    }
    try
    {
      long l = AESUtil.agE(paramArrayOfString[0]);
      if (l <= 0L)
      {
        DS(3);
        AppMethodBeat.o(24438);
        return null;
      }
      com.tencent.mm.plugin.ext.b.ctx();
      final an localan = com.tencent.mm.plugin.ext.b.vw(l);
      if ((localan == null) || ((int)localan.ght <= 0))
      {
        ae.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
        DS(3);
        AppMethodBeat.o(24438);
        return null;
      }
      this.rlJ = new MatrixCursor(rlI);
      final com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
      localb.c(15000L, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24429);
          Object localObject = new fu();
          ((fu)localObject).dsi.dsk = localan.field_username;
          ((fu)localObject).dsi.content = paramArrayOfString[1];
          ((fu)localObject).dsi.type = x.Bb(localan.field_username);
          ((fu)localObject).dsi.flags = 0;
          if (!com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject))
          {
            ExtControlProviderMsg.this.DS(4);
            localb.countDown();
            AppMethodBeat.o(24429);
            return;
          }
          n localn = ((fu)localObject).dsj.dsl;
          try
          {
            localObject = new f()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(24428);
                ae.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                if (paramAnonymous2n == null)
                {
                  ae.e("MicroMsg.ExtControlProviderMsg", "scene == null");
                  bc.ajj().b(522, this);
                  ExtControlProviderMsg.this.DS(4);
                  ExtControlProviderMsg.2.this.nTH.countDown();
                  AppMethodBeat.o(24428);
                  return;
                }
                switch (paramAnonymous2n.getType())
                {
                default: 
                  ExtControlProviderMsg.this.DS(0);
                }
                for (;;)
                {
                  ExtControlProviderMsg.2.this.nTH.countDown();
                  bc.ajj().b(522, this);
                  AppMethodBeat.o(24428);
                  return;
                  if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                  {
                    ae.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                    ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.rlN, Integer.valueOf(1) });
                    break;
                  }
                  ae.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + paramAnonymous2Int1 + ", errCode = " + paramAnonymous2Int2);
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.rlN, Integer.valueOf(2) });
                  ExtControlProviderMsg.this.DS(4);
                }
              }
            };
            bc.ajj().a(522, (f)localObject);
            bc.ajj().a(localn, 0);
            AppMethodBeat.o(24429);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
            ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
            ExtControlProviderMsg.this.DS(4);
            localb.countDown();
            AppMethodBeat.o(24429);
          }
        }
      });
      paramArrayOfString = this.rlJ;
      AppMethodBeat.o(24438);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      ae.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.rlJ != null) {
        this.rlJ.close();
      }
      DS(4);
      AppMethodBeat.o(24438);
    }
    return null;
  }
  
  private void a(MatrixCursor paramMatrixCursor, bv parambv, an paraman, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    AppMethodBeat.i(24439);
    if (parambv == null)
    {
      AppMethodBeat.o(24439);
      return;
    }
    if (bu.isNullOrNil(paramString2))
    {
      ae.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
      AppMethodBeat.o(24439);
      return;
    }
    if ((parambv.getType() == 9999) || (parambv.getType() == 10000))
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
      i = bl.BJ(parambv.field_content);
      str1 = str3;
      localObject = str2;
      if (i != -1)
      {
        str1 = str3;
        localObject = str2;
        if (parambv.field_content.length() > i)
        {
          String str4 = parambv.field_content.substring(0, i).trim();
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
              if (parambv.field_content.length() >= i + 2)
              {
                localObject = com.tencent.mm.model.w.zP(str4);
                str1 = parambv.field_content.substring(i + 2);
              }
            }
          }
        }
      }
    }
    int k = com.tencent.mm.plugin.ext.b.b.ak(parambv);
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
        if (bu.isNullOrNil(paramString2))
        {
          ae.w("MicroMsg.ExtControlProviderMsg", "userId is null");
          AppMethodBeat.o(24439);
          return;
          localObject = parambv.field_content;
          break;
          if (k == 2)
          {
            localObject = o.aNW().qv((int)parambv.field_msgId);
            if ((localObject == null) || (((r)localObject).fileName == null)) {
              break label550;
            }
            localObject = s.getFullPath(((r)localObject).fileName);
            ae.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", new Object[] { localObject });
            break;
          }
          if (paramBoolean1) {
            break;
          }
          if (this.rlC != null)
          {
            localObject = this.rlC.getString(2131758655);
            break;
          }
          localObject = "";
          break;
          paramString2 = AESUtil.vy((int)paraman.ght);
          continue;
        }
        paraman = AESUtil.vy(parambv.field_msgId);
        if (parambv.field_isSend == 0)
        {
          i = 1;
          if (parambv.field_status == 4)
          {
            j = 1;
            paramMatrixCursor.addRow(new Object[] { paraman, paramString2, paramString1, Integer.valueOf(i), Integer.valueOf(k), localObject, Integer.valueOf(j), Long.valueOf(parambv.field_createTime) });
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
        ae.e("MicroMsg.ExtControlProviderMsg", paramMatrixCursor.getMessage());
        ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramMatrixCursor, "", new Object[0]);
        AppMethodBeat.o(24439);
        return;
      }
    }
  }
  
  private Cursor b(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(24434);
    ae.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ae.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      DS(3);
      AppMethodBeat.o(24434);
      return null;
    }
    for (;;)
    {
      try
      {
        long l = AESUtil.agE(paramArrayOfString[0]);
        bc.aCg();
        localbv = com.tencent.mm.model.c.azI().ys(l);
        bc.aCg();
        localan = com.tencent.mm.model.c.azF().BH(localbv.field_talker);
        if ((localan == null) || ((int)localan.ght <= 0))
        {
          DS(3);
          AppMethodBeat.o(24434);
          return null;
        }
        str = localan.adG();
        if (!x.wb(localan.field_username)) {
          break label256;
        }
        str = com.tencent.mm.model.w.zP(localan.field_username);
        bool1 = true;
        if ((paramString != null) && (paramString.equalsIgnoreCase("openapi"))) {
          paramString = new MatrixCursor(rlD);
        }
      }
      catch (Exception paramArrayOfString)
      {
        bv localbv;
        an localan;
        String str;
        paramString = null;
        ae.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString != null) {
          paramString.close();
        }
        DS(4);
        AppMethodBeat.o(24434);
        return null;
      }
      try
      {
        a(paramString, localbv, localan, bool1, str, bool2, paramArrayOfString[0]);
        DS(0);
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
    ae.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
    ae.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ae.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      fz(3, 3701);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3701);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
      fz(3, 3702);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3702);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (bu.isNullOrNil(paramString2))
    {
      ae.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
      fz(3, 3703);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3703);
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
        paramString1 = com.tencent.mm.plugin.ext.b.ctA().aVZ(paramArrayOfString[0]);
        if ((paramString1 == null) || (bu.isNullOrNil(paramString1.field_openId)) || (bu.isNullOrNil(paramString1.field_username)))
        {
          ae.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
          fz(3, 3704);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3704);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          bool1 = false;
          break;
        }
        bc.aCg();
        an localan = com.tencent.mm.model.c.azF().BH(paramString1.field_username);
        if ((localan == null) || (localan.field_username == null) || (localan.field_username.length() <= 0))
        {
          ae.e("MicroMsg.ExtControlProviderMsg", "contact is null");
          fz(3, 3705);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3705);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          label315:
          long l = AESUtil.agE(paramArrayOfString[0]);
          bc.aCg();
          localan = com.tencent.mm.model.c.azF().Ed(l);
        }
        else
        {
          String str = localan.adG();
          if (x.wb(localan.field_username))
          {
            str = com.tencent.mm.model.w.zP(localan.field_username);
            bool2 = true;
            if (bool1)
            {
              try
              {
                i = bu.getInt(paramString2, 0);
                if ((i <= 0) || (i >= 15))
                {
                  bc.aCg();
                  paramString1 = com.tencent.mm.model.c.azI().eq(localan.field_username, 15);
                  if (paramString1 != null) {
                    continue;
                  }
                  ae.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                  ab(3, 4, 3706);
                  paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3706);
                  AppMethodBeat.o(24432);
                  return paramArrayOfString;
                }
              }
              catch (Exception paramString1)
              {
                ae.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[] { paramString2 });
                int i = 0;
                continue;
                bc.aCg();
                paramString1 = com.tencent.mm.model.c.azI().eq(localan.field_username, i);
                continue;
              }
            }
            else
            {
              bc.aCg();
              paramString1 = com.tencent.mm.model.c.azI().eq(localan.field_username, 3);
              continue;
            }
            paramString2 = new MatrixCursor(rlD);
          }
          bv localbv;
          boolean bool2 = false;
        }
      }
      catch (Exception paramArrayOfString)
      {
        try
        {
          if ((paramString1.getCount() > 0) && (paramString1.moveToFirst()))
          {
            localbv = new bv();
            localbv.convertFrom(paramString1);
            a(paramString2, localbv, localan, bool2, str, bool1, paramArrayOfString[0]);
            if (paramString1.moveToNext()) {
              continue;
            }
          }
          paramString1.close();
          ab(2, 0, 1);
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
        ae.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString1 != null) {
          paramString1.close();
        }
        ab(3, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(12);
        AppMethodBeat.o(24432);
        return paramArrayOfString;
      }
    }
  }
  
  private Cursor ctN()
  {
    AppMethodBeat.i(24433);
    ae.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
    MatrixCursor localMatrixCursor = new MatrixCursor(rlF);
    label267:
    for (;;)
    {
      try
      {
        bc.aCg();
        Cursor localCursor = com.tencent.mm.model.c.azI().doX();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            String str = localCursor.getString(localCursor.getColumnIndex("talker"));
            bc.aCg();
            an localan = com.tencent.mm.model.c.azF().BH(str);
            if (!x.wb(str))
            {
              if ((x.AZ(localan.field_username)) || (x.AV(localan.field_username)) || (an.abz(localan.field_verifyFlag)) || (x.AN(localan.field_username))) {
                break label267;
              }
              if (!x.AO(localan.field_username)) {
                continue;
              }
              break label267;
              if (i == 0) {
                localMatrixCursor.addRow(new Object[] { AESUtil.vy((int)localan.ght), Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("unReadCount"))) });
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
          DS(0);
          AppMethodBeat.o(24433);
          return localMatrixCursor;
        }
        int i = 1;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
        ae.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
        localMatrixCursor.close();
        DS(4);
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
    ae.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.rlB);
    if (this.rlB)
    {
      a(paramUri, this.rlC, this.rlj, this.rli);
      if (bu.isNullOrNil(this.rlu))
      {
        ae.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
        fz(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(7);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (bu.isNullOrNil(ctL()))
      {
        ae.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
        fz(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(6);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      int i = ctM();
      if (i != 1)
      {
        ae.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(i)));
        fz(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(i);
        AppMethodBeat.o(24430);
        return paramUri;
      }
    }
    else
    {
      this.rlC = getContext();
      a(paramUri, this.rlC, rlA);
      if (paramUri == null)
      {
        DS(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if ((bu.isNullOrNil(this.rlu)) || (bu.isNullOrNil(ctL())))
      {
        DS(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if (!bNl())
      {
        DS(1);
        paramUri = this.nTy;
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (!eK(this.rlC))
      {
        ae.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
        DS(2);
        AppMethodBeat.o(24430);
        return null;
      }
    }
    paramArrayOfString1 = bu.nullAsNil(paramUri.getQueryParameter("source"));
    paramString1 = bu.nullAsNil(paramUri.getQueryParameter("count"));
    if (!this.rlB) {
      this.rlj = rlA.match(paramUri);
    }
    switch (this.rlj)
    {
    default: 
      fz(3, 15);
      AppMethodBeat.o(24430);
      return null;
    case 7: 
      paramUri = b(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(24430);
      return paramUri;
    case 8: 
      paramUri = A(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 9: 
      paramUri = b(paramArrayOfString2, paramArrayOfString1, paramString1);
      AppMethodBeat.o(24430);
      return paramUri;
    case 10: 
      paramUri = ctN();
      AppMethodBeat.o(24430);
      return paramUri;
    case 11: 
      paramUri = B(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 12: 
      paramUri = C(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 13: 
      paramUri = D(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    }
    paramUri = E(paramArrayOfString2);
    AppMethodBeat.o(24430);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg
 * JD-Core Version:    0.7.0.1
 */