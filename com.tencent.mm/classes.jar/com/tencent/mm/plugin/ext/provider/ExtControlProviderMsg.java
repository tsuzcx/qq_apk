package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.ft.b;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.fw.b;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.g.a.gc.b;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.gd.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storage.ck;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderMsg
  extends ExtContentProviderBase
{
  private static final String[] rdA;
  private static final String[] rdB;
  private static final String[] rdC;
  private static final UriMatcher rdu;
  private static final String[] rdx;
  private static final String[] rdy;
  private static final String[] rdz;
  private MatrixCursor rdD = null;
  private String[] rdc = null;
  private int rdd = -1;
  private boolean rdv = false;
  private Context rdw;
  
  static
  {
    AppMethodBeat.i(24440);
    rdx = new String[] { "msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime" };
    rdy = new String[] { "userId", "unReadCount" };
    rdz = new String[] { "userId", "unReadCount" };
    rdA = new String[] { "userId", "retCode", "msgId" };
    rdB = new String[] { "msgId", "retCode" };
    rdC = new String[] { "msgId", "retCode" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    rdu = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
    rdu.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
    rdu.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
    rdu.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
    rdu.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
    rdu.addURI("com.tencent.mm.plugin.ext.message", "playVoice", 12);
    rdu.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
    rdu.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    AppMethodBeat.o(24440);
  }
  
  public ExtControlProviderMsg() {}
  
  public ExtControlProviderMsg(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.rdv = true;
    this.rdc = paramArrayOfString;
    this.rdd = paramInt;
    this.rdw = paramContext;
  }
  
  private Cursor A(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24431);
    ad.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      DF(3);
      AppMethodBeat.o(24431);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(rdy);
    try
    {
      if ("*".equals(paramArrayOfString[0]))
      {
        ba.aBQ();
        localMatrixCursor.addRow(new Object[] { "0", Integer.valueOf(c.azv().AA("")) });
      }
      for (;;)
      {
        DF(0);
        AppMethodBeat.o(24431);
        return localMatrixCursor;
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          long l = AESUtil.afI(paramArrayOfString[i]);
          ba.aBQ();
          am localam = c.azp().DE(l);
          if ((localam != null) && ((int)localam.gfj > 0))
          {
            ba.aBQ();
            localMatrixCursor.addRow(new Object[] { Long.valueOf(l), Integer.valueOf(c.azv().AA(" and ( rconversation.username='" + localam.field_username + "' );")) });
          }
          i += 1;
        }
      }
      return null;
    }
    catch (Exception paramArrayOfString)
    {
      ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      localMatrixCursor.close();
      DF(4);
      AppMethodBeat.o(24431);
    }
  }
  
  private Cursor B(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24435);
    ad.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ad.w("MicroMsg.ExtControlProviderMsg", "wrong args");
      DF(3);
      AppMethodBeat.o(24435);
      return null;
    }
    try
    {
      final int i = Integer.valueOf(paramArrayOfString[0]).intValue();
      final long l = AESUtil.afI(paramArrayOfString[1]);
      if (l <= 0L)
      {
        DF(3);
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
            com.tencent.mm.plugin.ext.b.crV();
            localObject1 = com.tencent.mm.plugin.ext.b.vg(l);
            if ((localObject1 == null) || ((int)((com.tencent.mm.o.b)localObject1).gfj <= 0))
            {
              ExtControlProviderMsg.this.DF(3);
              paramArrayOfString.countDown();
              AppMethodBeat.o(24427);
              return;
            }
            localObject2 = new fw();
            ((fw)localObject2).dro.op = 1;
            ((fw)localObject2).dro.username = ((aw)localObject1).field_username;
            if (!com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2))
            {
              ExtControlProviderMsg.this.DF(4);
              paramArrayOfString.countDown();
              AppMethodBeat.o(24427);
              return;
            }
            ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.csm()));
            if ((localObject1 != null) && ((int)((com.tencent.mm.o.b)localObject1).gfj > 0) && (((fw)localObject2).drp.dno))
            {
              ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.geX[1], Integer.valueOf(1), "0" });
              ExtControlProviderMsg.this.DF(0);
              ad.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[] { Boolean.valueOf(((fw)localObject2).drp.dno), ((fw)localObject2).drp.fileName });
            }
          }
          for (;;)
          {
            paramArrayOfString.countDown();
            AppMethodBeat.o(24427);
            return;
            ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.geX[1], Integer.valueOf(2), "0" });
            ExtControlProviderMsg.this.DF(3);
            break;
            if (i == 2)
            {
              localObject1 = new fw();
              ((fw)localObject1).dro.op = 2;
              if (!com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1))
              {
                ExtControlProviderMsg.this.DF(4);
                paramArrayOfString.countDown();
                AppMethodBeat.o(24427);
                return;
              }
              localObject2 = ((fw)localObject1).drp.fileName;
              ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.csm()));
              gc localgc = new gc();
              localgc.drK.fileName = ((String)localObject2);
              if (!com.tencent.mm.sdk.b.a.IbL.l(localgc))
              {
                ExtControlProviderMsg.this.DF(4);
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).close();
                paramArrayOfString.countDown();
                AppMethodBeat.o(24427);
                return;
              }
              ad.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[] { Long.valueOf(localgc.drL.msgId) });
              long l = localgc.drL.msgId;
              if (l > 0L)
              {
                try
                {
                  if (!((fw)localObject1).drp.dno) {
                    break label643;
                  }
                  if ((aj.getContext() == null) || (!ay.isConnected(aj.getContext()))) {
                    break label594;
                  }
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.geX[1], Integer.valueOf(1), AESUtil.vi(l) });
                  ExtControlProviderMsg.this.DF(0);
                }
                catch (Exception localException)
                {
                  ad.w("MicroMsg.ExtControlProviderMsg", localException.getMessage());
                  ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
                  ExtControlProviderMsg.this.DF(4);
                }
                continue;
                label594:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.geX[1], Integer.valueOf(6), AESUtil.vi(l) });
                ExtControlProviderMsg.this.DF(4);
                continue;
                label643:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.geX[1], Integer.valueOf(4), AESUtil.vi(l) });
                ExtControlProviderMsg.this.DF(4);
              }
              else
              {
                ExtControlProviderMsg.this.DF(3);
              }
            }
          }
        }
      });
      paramArrayOfString = this.rdD;
      AppMethodBeat.o(24435);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.rdD != null) {
        this.rdD.close();
      }
      DF(4);
      AppMethodBeat.o(24435);
    }
    return null;
  }
  
  private Cursor C(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24436);
    ad.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      DF(3);
      AppMethodBeat.o(24436);
      return null;
    }
    Object localObject = null;
    try
    {
      i = Integer.valueOf(paramArrayOfString[0]).intValue();
      long l = AESUtil.afI(paramArrayOfString[1]);
      if (l <= 0L)
      {
        DF(3);
        AppMethodBeat.o(24436);
        return null;
      }
      if (i != 3) {
        break label364;
      }
      MatrixCursor localMatrixCursor = new MatrixCursor(rdB);
      try
      {
        localObject = new gd();
        ((gd)localObject).drM.msgId = l;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        if ((((gd)localObject).drN.fileName == null) || (((gd)localObject).drN.fileName.length() <= 0))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          DF(4);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
        }
        fv localfv = new fv();
        localfv.drj.op = 1;
        localfv.drj.fileName = ((gd)localObject).drN.fileName;
        if (com.tencent.mm.sdk.b.a.IbL.l(localfv))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(1) });
          DF(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.ext.b.crV();
          com.tencent.mm.plugin.ext.b.vh(l);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
          ad.e("MicroMsg.ExtControlProviderMsg", "play failed");
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          DF(4);
        }
        ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
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
    ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
    if (localObject != null) {
      ((MatrixCursor)localObject).close();
    }
    DF(4);
    AppMethodBeat.o(24436);
    return null;
    label364:
    if (i == 4)
    {
      paramArrayOfString = new fv();
      paramArrayOfString.drj.op = 2;
      if (!com.tencent.mm.sdk.b.a.IbL.l(paramArrayOfString)) {
        break label416;
      }
      ad.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
      DF(0);
    }
    for (;;)
    {
      AppMethodBeat.o(24436);
      return null;
      label416:
      ad.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
      DF(4);
    }
  }
  
  private Cursor D(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24437);
    ad.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      fB(3, 3801);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(3801);
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
            ad.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = ".concat(String.valueOf(i)));
          }
          else
          {
            long l = AESUtil.afI(paramArrayOfString[i]);
            com.tencent.mm.plugin.ext.b.crV();
            com.tencent.mm.plugin.ext.b.vh(l);
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        fB(4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(12);
        AppMethodBeat.o(24437);
        return paramArrayOfString;
      }
      fB(0, 1);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
      AppMethodBeat.o(24437);
      return paramArrayOfString;
      i += 1;
    }
  }
  
  private Cursor E(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24438);
    ad.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      DF(3);
      AppMethodBeat.o(24438);
      return null;
    }
    try
    {
      long l = AESUtil.afI(paramArrayOfString[0]);
      if (l <= 0L)
      {
        DF(3);
        AppMethodBeat.o(24438);
        return null;
      }
      com.tencent.mm.plugin.ext.b.crV();
      final am localam = com.tencent.mm.plugin.ext.b.vg(l);
      if ((localam == null) || ((int)localam.gfj <= 0))
      {
        ad.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
        DF(3);
        AppMethodBeat.o(24438);
        return null;
      }
      this.rdD = new MatrixCursor(rdC);
      final com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
      localb.c(15000L, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24429);
          Object localObject = new ft();
          ((ft)localObject).drd.drf = localam.field_username;
          ((ft)localObject).drd.content = paramArrayOfString[1];
          ((ft)localObject).drd.type = com.tencent.mm.model.w.Ar(localam.field_username);
          ((ft)localObject).drd.flags = 0;
          if (!com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject))
          {
            ExtControlProviderMsg.this.DF(4);
            localb.countDown();
            AppMethodBeat.o(24429);
            return;
          }
          n localn = ((ft)localObject).dre.drg;
          try
          {
            localObject = new f()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(24428);
                ad.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                if (paramAnonymous2n == null)
                {
                  ad.e("MicroMsg.ExtControlProviderMsg", "scene == null");
                  ba.aiU().b(522, this);
                  ExtControlProviderMsg.this.DF(4);
                  ExtControlProviderMsg.2.this.nOc.countDown();
                  AppMethodBeat.o(24428);
                  return;
                }
                switch (paramAnonymous2n.getType())
                {
                default: 
                  ExtControlProviderMsg.this.DF(0);
                }
                for (;;)
                {
                  ExtControlProviderMsg.2.this.nOc.countDown();
                  ba.aiU().b(522, this);
                  AppMethodBeat.o(24428);
                  return;
                  if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                  {
                    ad.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                    ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.rdH, Integer.valueOf(1) });
                    break;
                  }
                  ad.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + paramAnonymous2Int1 + ", errCode = " + paramAnonymous2Int2);
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.rdH, Integer.valueOf(2) });
                  ExtControlProviderMsg.this.DF(4);
                }
              }
            };
            ba.aiU().a(522, (f)localObject);
            ba.aiU().a(localn, 0);
            AppMethodBeat.o(24429);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
            ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
            ExtControlProviderMsg.this.DF(4);
            localb.countDown();
            AppMethodBeat.o(24429);
          }
        }
      });
      paramArrayOfString = this.rdD;
      AppMethodBeat.o(24438);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.rdD != null) {
        this.rdD.close();
      }
      DF(4);
      AppMethodBeat.o(24438);
    }
    return null;
  }
  
  private void a(MatrixCursor paramMatrixCursor, bu parambu, am paramam, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    AppMethodBeat.i(24439);
    if (parambu == null)
    {
      AppMethodBeat.o(24439);
      return;
    }
    if (bt.isNullOrNil(paramString2))
    {
      ad.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
      AppMethodBeat.o(24439);
      return;
    }
    if ((parambu.getType() == 9999) || (parambu.getType() == 10000))
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
      i = bj.Bh(parambu.field_content);
      str1 = str3;
      localObject = str2;
      if (i != -1)
      {
        str1 = str3;
        localObject = str2;
        if (parambu.field_content.length() > i)
        {
          String str4 = parambu.field_content.substring(0, i).trim();
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
              if (parambu.field_content.length() >= i + 2)
              {
                localObject = v.zf(str4);
                str1 = parambu.field_content.substring(i + 2);
              }
            }
          }
        }
      }
    }
    int k = com.tencent.mm.plugin.ext.b.b.al(parambu);
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
        if (bt.isNullOrNil(paramString2))
        {
          ad.w("MicroMsg.ExtControlProviderMsg", "userId is null");
          AppMethodBeat.o(24439);
          return;
          localObject = parambu.field_content;
          break;
          if (k == 2)
          {
            localObject = o.aNy().qs((int)parambu.field_msgId);
            if ((localObject == null) || (((r)localObject).fileName == null)) {
              break label550;
            }
            localObject = s.getFullPath(((r)localObject).fileName);
            ad.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", new Object[] { localObject });
            break;
          }
          if (paramBoolean1) {
            break;
          }
          if (this.rdw != null)
          {
            localObject = this.rdw.getString(2131758655);
            break;
          }
          localObject = "";
          break;
          paramString2 = AESUtil.vi((int)paramam.gfj);
          continue;
        }
        paramam = AESUtil.vi(parambu.field_msgId);
        if (parambu.field_isSend == 0)
        {
          i = 1;
          if (parambu.field_status == 4)
          {
            j = 1;
            paramMatrixCursor.addRow(new Object[] { paramam, paramString2, paramString1, Integer.valueOf(i), Integer.valueOf(k), localObject, Integer.valueOf(j), Long.valueOf(parambu.field_createTime) });
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
        ad.e("MicroMsg.ExtControlProviderMsg", paramMatrixCursor.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramMatrixCursor, "", new Object[0]);
        AppMethodBeat.o(24439);
        return;
      }
    }
  }
  
  private Cursor b(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(24434);
    ad.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      DF(3);
      AppMethodBeat.o(24434);
      return null;
    }
    for (;;)
    {
      try
      {
        long l = AESUtil.afI(paramArrayOfString[0]);
        ba.aBQ();
        localbu = c.azs().xY(l);
        ba.aBQ();
        localam = c.azp().Bf(localbu.field_talker);
        if ((localam == null) || ((int)localam.gfj <= 0))
        {
          DF(3);
          AppMethodBeat.o(24434);
          return null;
        }
        str = localam.adv();
        if (!com.tencent.mm.model.w.vF(localam.field_username)) {
          break label256;
        }
        str = v.zf(localam.field_username);
        bool1 = true;
        if ((paramString != null) && (paramString.equalsIgnoreCase("openapi"))) {
          paramString = new MatrixCursor(rdx);
        }
      }
      catch (Exception paramArrayOfString)
      {
        bu localbu;
        am localam;
        String str;
        paramString = null;
        ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString != null) {
          paramString.close();
        }
        DF(4);
        AppMethodBeat.o(24434);
        return null;
      }
      try
      {
        a(paramString, localbu, localam, bool1, str, bool2, paramArrayOfString[0]);
        DF(0);
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
    ad.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
    ad.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      fB(3, 3701);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(3701);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
      fB(3, 3702);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(3702);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (bt.isNullOrNil(paramString2))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
      fB(3, 3703);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(3703);
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
        paramString1 = com.tencent.mm.plugin.ext.b.crY().aUy(paramArrayOfString[0]);
        if ((paramString1 == null) || (bt.isNullOrNil(paramString1.field_openId)) || (bt.isNullOrNil(paramString1.field_username)))
        {
          ad.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
          fB(3, 3704);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(3704);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          bool1 = false;
          break;
        }
        ba.aBQ();
        am localam = c.azp().Bf(paramString1.field_username);
        if ((localam == null) || (localam.field_username == null) || (localam.field_username.length() <= 0))
        {
          ad.e("MicroMsg.ExtControlProviderMsg", "contact is null");
          fB(3, 3705);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(3705);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          label315:
          long l = AESUtil.afI(paramArrayOfString[0]);
          ba.aBQ();
          localam = c.azp().DE(l);
        }
        else
        {
          String str = localam.adv();
          if (com.tencent.mm.model.w.vF(localam.field_username))
          {
            str = v.zf(localam.field_username);
            bool2 = true;
            if (bool1)
            {
              try
              {
                i = bt.getInt(paramString2, 0);
                if ((i <= 0) || (i >= 15))
                {
                  ba.aBQ();
                  paramString1 = c.azs().ej(localam.field_username, 15);
                  if (paramString1 != null) {
                    continue;
                  }
                  ad.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                  ab(3, 4, 3706);
                  paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(3706);
                  AppMethodBeat.o(24432);
                  return paramArrayOfString;
                }
              }
              catch (Exception paramString1)
              {
                ad.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[] { paramString2 });
                int i = 0;
                continue;
                ba.aBQ();
                paramString1 = c.azs().ej(localam.field_username, i);
                continue;
              }
            }
            else
            {
              ba.aBQ();
              paramString1 = c.azs().ej(localam.field_username, 3);
              continue;
            }
            paramString2 = new MatrixCursor(rdx);
          }
          bu localbu;
          boolean bool2 = false;
        }
      }
      catch (Exception paramArrayOfString)
      {
        try
        {
          if ((paramString1.getCount() > 0) && (paramString1.moveToFirst()))
          {
            localbu = new bu();
            localbu.convertFrom(paramString1);
            a(paramString2, localbu, localam, bool2, str, bool1, paramArrayOfString[0]);
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
        ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString1 != null) {
          paramString1.close();
        }
        ab(3, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(12);
        AppMethodBeat.o(24432);
        return paramArrayOfString;
      }
    }
  }
  
  private Cursor csl()
  {
    AppMethodBeat.i(24433);
    ad.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
    MatrixCursor localMatrixCursor = new MatrixCursor(rdz);
    label267:
    for (;;)
    {
      try
      {
        ba.aBQ();
        Cursor localCursor = c.azs().dlY();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            String str = localCursor.getString(localCursor.getColumnIndex("talker"));
            ba.aBQ();
            am localam = c.azp().Bf(str);
            if (!com.tencent.mm.model.w.vF(str))
            {
              if ((com.tencent.mm.model.w.Ap(localam.field_username)) || (com.tencent.mm.model.w.Al(localam.field_username)) || (am.aaR(localam.field_verifyFlag)) || (com.tencent.mm.model.w.Ad(localam.field_username))) {
                break label267;
              }
              if (!com.tencent.mm.model.w.Ae(localam.field_username)) {
                continue;
              }
              break label267;
              if (i == 0) {
                localMatrixCursor.addRow(new Object[] { AESUtil.vi((int)localam.gfj), Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("unReadCount"))) });
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
          DF(0);
          AppMethodBeat.o(24433);
          return localMatrixCursor;
        }
        int i = 1;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
        localMatrixCursor.close();
        DF(4);
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
    ad.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.rdv);
    if (this.rdv)
    {
      a(paramUri, this.rdw, this.rdd, this.rdc);
      if (bt.isNullOrNil(this.rdo))
      {
        ad.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
        fB(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(7);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (bt.isNullOrNil(csj()))
      {
        ad.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
        fB(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(6);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      int i = csk();
      if (i != 1)
      {
        ad.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(i)));
        fB(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(i);
        AppMethodBeat.o(24430);
        return paramUri;
      }
    }
    else
    {
      this.rdw = getContext();
      a(paramUri, this.rdw, rdu);
      if (paramUri == null)
      {
        DF(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if ((bt.isNullOrNil(this.rdo)) || (bt.isNullOrNil(csj())))
      {
        DF(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if (!bMn())
      {
        DF(1);
        paramUri = this.nNT;
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (!eG(this.rdw))
      {
        ad.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
        DF(2);
        AppMethodBeat.o(24430);
        return null;
      }
    }
    paramArrayOfString1 = bt.nullAsNil(paramUri.getQueryParameter("source"));
    paramString1 = bt.nullAsNil(paramUri.getQueryParameter("count"));
    if (!this.rdv) {
      this.rdd = rdu.match(paramUri);
    }
    switch (this.rdd)
    {
    default: 
      fB(3, 15);
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
      paramUri = csl();
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