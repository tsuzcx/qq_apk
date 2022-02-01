package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.fq.b;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.ft.b;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.fz.b;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.a.ga.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderMsg
  extends ExtContentProviderBase
{
  private static final UriMatcher qtG;
  private static final String[] qtJ;
  private static final String[] qtK;
  private static final String[] qtL;
  private static final String[] qtM;
  private static final String[] qtN;
  private static final String[] qtO;
  private boolean qtH = false;
  private Context qtI;
  private MatrixCursor qtP = null;
  private String[] qto = null;
  private int qtp = -1;
  
  static
  {
    AppMethodBeat.i(24440);
    qtJ = new String[] { "msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime" };
    qtK = new String[] { "userId", "unReadCount" };
    qtL = new String[] { "userId", "unReadCount" };
    qtM = new String[] { "userId", "retCode", "msgId" };
    qtN = new String[] { "msgId", "retCode" };
    qtO = new String[] { "msgId", "retCode" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    qtG = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
    qtG.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
    qtG.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
    qtG.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
    qtG.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
    qtG.addURI("com.tencent.mm.plugin.ext.message", "playVoice", 12);
    qtG.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
    qtG.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    AppMethodBeat.o(24440);
  }
  
  public ExtControlProviderMsg() {}
  
  public ExtControlProviderMsg(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.qtH = true;
    this.qto = paramArrayOfString;
    this.qtp = paramInt;
    this.qtI = paramContext;
  }
  
  private Cursor A(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24435);
    ac.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ac.w("MicroMsg.ExtControlProviderMsg", "wrong args");
      CN(3);
      AppMethodBeat.o(24435);
      return null;
    }
    try
    {
      final int i = Integer.valueOf(paramArrayOfString[0]).intValue();
      final long l = AESUtil.abT(paramArrayOfString[1]);
      if (l <= 0L)
      {
        CN(3);
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
            com.tencent.mm.plugin.ext.b.cmq();
            localObject1 = com.tencent.mm.plugin.ext.b.tj(l);
            if ((localObject1 == null) || ((int)((com.tencent.mm.n.b)localObject1).fLJ <= 0))
            {
              ExtControlProviderMsg.this.CN(3);
              paramArrayOfString.countDown();
              AppMethodBeat.o(24427);
              return;
            }
            localObject2 = new ft();
            ((ft)localObject2).dfS.op = 1;
            ((ft)localObject2).dfS.username = ((av)localObject1).field_username;
            if (!com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2))
            {
              ExtControlProviderMsg.this.CN(4);
              paramArrayOfString.countDown();
              AppMethodBeat.o(24427);
              return;
            }
            ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.cmH()));
            if ((localObject1 != null) && ((int)((com.tencent.mm.n.b)localObject1).fLJ > 0) && (((ft)localObject2).dfT.dbS))
            {
              ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.fLx[1], Integer.valueOf(1), "0" });
              ExtControlProviderMsg.this.CN(0);
              ac.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[] { Boolean.valueOf(((ft)localObject2).dfT.dbS), ((ft)localObject2).dfT.fileName });
            }
          }
          for (;;)
          {
            paramArrayOfString.countDown();
            AppMethodBeat.o(24427);
            return;
            ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.fLx[1], Integer.valueOf(2), "0" });
            ExtControlProviderMsg.this.CN(3);
            break;
            if (i == 2)
            {
              localObject1 = new ft();
              ((ft)localObject1).dfS.op = 2;
              if (!com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1))
              {
                ExtControlProviderMsg.this.CN(4);
                paramArrayOfString.countDown();
                AppMethodBeat.o(24427);
                return;
              }
              localObject2 = ((ft)localObject1).dfT.fileName;
              ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.cmH()));
              fz localfz = new fz();
              localfz.dgo.fileName = ((String)localObject2);
              if (!com.tencent.mm.sdk.b.a.GpY.l(localfz))
              {
                ExtControlProviderMsg.this.CN(4);
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).close();
                paramArrayOfString.countDown();
                AppMethodBeat.o(24427);
                return;
              }
              ac.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[] { Long.valueOf(localfz.dgp.msgId) });
              long l = localfz.dgp.msgId;
              if (l > 0L)
              {
                try
                {
                  if (!((ft)localObject1).dfT.dbS) {
                    break label643;
                  }
                  if ((com.tencent.mm.sdk.platformtools.ai.getContext() == null) || (!ax.isConnected(com.tencent.mm.sdk.platformtools.ai.getContext()))) {
                    break label594;
                  }
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.fLx[1], Integer.valueOf(1), AESUtil.tl(l) });
                  ExtControlProviderMsg.this.CN(0);
                }
                catch (Exception localException)
                {
                  ac.w("MicroMsg.ExtControlProviderMsg", localException.getMessage());
                  ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
                  ExtControlProviderMsg.this.CN(4);
                }
                continue;
                label594:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.fLx[1], Integer.valueOf(6), AESUtil.tl(l) });
                ExtControlProviderMsg.this.CN(4);
                continue;
                label643:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.fLx[1], Integer.valueOf(4), AESUtil.tl(l) });
                ExtControlProviderMsg.this.CN(4);
              }
              else
              {
                ExtControlProviderMsg.this.CN(3);
              }
            }
          }
        }
      });
      paramArrayOfString = this.qtP;
      AppMethodBeat.o(24435);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      ac.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.qtP != null) {
        this.qtP.close();
      }
      CN(4);
      AppMethodBeat.o(24435);
    }
    return null;
  }
  
  private Cursor B(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24436);
    ac.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ac.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      CN(3);
      AppMethodBeat.o(24436);
      return null;
    }
    Object localObject = null;
    try
    {
      i = Integer.valueOf(paramArrayOfString[0]).intValue();
      long l = AESUtil.abT(paramArrayOfString[1]);
      if (l <= 0L)
      {
        CN(3);
        AppMethodBeat.o(24436);
        return null;
      }
      if (i != 3) {
        break label363;
      }
      MatrixCursor localMatrixCursor = new MatrixCursor(qtN);
      try
      {
        localObject = new ga();
        ((ga)localObject).dgq.msgId = l;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        if ((((ga)localObject).dgr.fileName == null) || (((ga)localObject).dgr.fileName.length() <= 0))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          CN(4);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
        }
        fs localfs = new fs();
        localfs.dfN.op = 1;
        localfs.dfN.fileName = ((ga)localObject).dgr.fileName;
        if (com.tencent.mm.sdk.b.a.GpY.l(localfs))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(1) });
          CN(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.ext.b.cmq();
          com.tencent.mm.plugin.ext.b.tk(l);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
          ac.e("MicroMsg.ExtControlProviderMsg", "play failed");
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          CN(4);
        }
        ac.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      }
      catch (Exception paramArrayOfString)
      {
        localObject = localMatrixCursor;
      }
    }
    catch (Exception paramArrayOfString)
    {
      int i;
      label319:
      break label319;
    }
    ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
    if (localObject != null) {
      ((MatrixCursor)localObject).close();
    }
    CN(4);
    AppMethodBeat.o(24436);
    return null;
    label363:
    if (i == 4)
    {
      paramArrayOfString = new fs();
      paramArrayOfString.dfN.op = 2;
      if (!com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfString)) {
        break label415;
      }
      ac.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
      CN(0);
    }
    for (;;)
    {
      AppMethodBeat.o(24436);
      return null;
      label415:
      ac.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
      CN(4);
    }
  }
  
  private Cursor C(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24437);
    ac.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ac.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      ft(3, 3801);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3801);
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
            ac.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = ".concat(String.valueOf(i)));
          }
          else
          {
            long l = AESUtil.abT(paramArrayOfString[i]);
            com.tencent.mm.plugin.ext.b.cmq();
            com.tencent.mm.plugin.ext.b.tk(l);
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ac.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        ft(4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(12);
        AppMethodBeat.o(24437);
        return paramArrayOfString;
      }
      ft(0, 1);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
      AppMethodBeat.o(24437);
      return paramArrayOfString;
      i += 1;
    }
  }
  
  private Cursor D(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24438);
    ac.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ac.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      CN(3);
      AppMethodBeat.o(24438);
      return null;
    }
    try
    {
      long l = AESUtil.abT(paramArrayOfString[0]);
      if (l <= 0L)
      {
        CN(3);
        AppMethodBeat.o(24438);
        return null;
      }
      com.tencent.mm.plugin.ext.b.cmq();
      final com.tencent.mm.storage.ai localai = com.tencent.mm.plugin.ext.b.tj(l);
      if ((localai == null) || ((int)localai.fLJ <= 0))
      {
        ac.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
        CN(3);
        AppMethodBeat.o(24438);
        return null;
      }
      this.qtP = new MatrixCursor(qtO);
      final com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
      localb.c(15000L, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24429);
          Object localObject = new fq();
          ((fq)localObject).dfH.dfJ = localai.field_username;
          ((fq)localObject).dfH.content = paramArrayOfString[1];
          ((fq)localObject).dfH.type = com.tencent.mm.model.w.xt(localai.field_username);
          ((fq)localObject).dfH.flags = 0;
          if (!com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject))
          {
            ExtControlProviderMsg.this.CN(4);
            localb.countDown();
            AppMethodBeat.o(24429);
            return;
          }
          n localn = ((fq)localObject).dfI.dfK;
          try
          {
            localObject = new g()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(24428);
                ac.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                if (paramAnonymous2n == null)
                {
                  ac.e("MicroMsg.ExtControlProviderMsg", "scene == null");
                  az.agi().b(522, this);
                  ExtControlProviderMsg.this.CN(4);
                  ExtControlProviderMsg.2.this.nnp.countDown();
                  AppMethodBeat.o(24428);
                  return;
                }
                switch (paramAnonymous2n.getType())
                {
                default: 
                  ExtControlProviderMsg.this.CN(0);
                }
                for (;;)
                {
                  ExtControlProviderMsg.2.this.nnp.countDown();
                  az.agi().b(522, this);
                  AppMethodBeat.o(24428);
                  return;
                  if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                  {
                    ac.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                    ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.qtT, Integer.valueOf(1) });
                    break;
                  }
                  ac.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + paramAnonymous2Int1 + ", errCode = " + paramAnonymous2Int2);
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.qtT, Integer.valueOf(2) });
                  ExtControlProviderMsg.this.CN(4);
                }
              }
            };
            az.agi().a(522, (g)localObject);
            az.agi().a(localn, 0);
            AppMethodBeat.o(24429);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
            ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
            ExtControlProviderMsg.this.CN(4);
            localb.countDown();
            AppMethodBeat.o(24429);
          }
        }
      });
      paramArrayOfString = this.qtP;
      AppMethodBeat.o(24438);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      ac.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.qtP != null) {
        this.qtP.close();
      }
      CN(4);
      AppMethodBeat.o(24438);
    }
    return null;
  }
  
  private Cursor a(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(24432);
    ac.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
    ac.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ac.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      ft(3, 3701);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3701);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (bs.isNullOrNil(paramString1))
    {
      ac.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
      ft(3, 3702);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3702);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (bs.isNullOrNil(paramString2))
    {
      ac.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
      ft(3, 3703);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3703);
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
        paramString1 = com.tencent.mm.plugin.ext.b.cmt().aOH(paramArrayOfString[0]);
        if ((paramString1 == null) || (bs.isNullOrNil(paramString1.field_openId)) || (bs.isNullOrNil(paramString1.field_username)))
        {
          ac.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
          ft(3, 3704);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3704);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          bool1 = false;
          break;
        }
        az.ayM();
        com.tencent.mm.storage.ai localai = c.awB().aNt(paramString1.field_username);
        if ((localai == null) || (localai.field_username == null) || (localai.field_username.length() <= 0))
        {
          ac.e("MicroMsg.ExtControlProviderMsg", "contact is null");
          ft(3, 3705);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3705);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          label315:
          long l = AESUtil.abT(paramArrayOfString[0]);
          az.ayM();
          localai = c.awB().AO(l);
        }
        else
        {
          String str = localai.aaS();
          if (com.tencent.mm.model.w.sQ(localai.field_username))
          {
            str = v.wk(localai.field_username);
            bool2 = true;
            if (bool1)
            {
              try
              {
                i = bs.getInt(paramString2, 0);
                if ((i <= 0) || (i >= 15))
                {
                  az.ayM();
                  paramString1 = c.awD().dS(localai.field_username, 15);
                  if (paramString1 != null) {
                    continue;
                  }
                  ac.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                  Z(3, 4, 3706);
                  paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3706);
                  AppMethodBeat.o(24432);
                  return paramArrayOfString;
                }
              }
              catch (Exception paramString1)
              {
                ac.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[] { paramString2 });
                int i = 0;
                continue;
                az.ayM();
                paramString1 = c.awD().dS(localai.field_username, i);
                continue;
              }
            }
            else
            {
              az.ayM();
              paramString1 = c.awD().dS(localai.field_username, 3);
              continue;
            }
            paramString2 = new MatrixCursor(qtJ);
          }
          bo localbo;
          boolean bool2 = false;
        }
      }
      catch (Exception paramArrayOfString)
      {
        try
        {
          if ((paramString1.getCount() > 0) && (paramString1.moveToFirst()))
          {
            localbo = new bo();
            localbo.convertFrom(paramString1);
            a(paramString2, localbo, localai, bool2, str, bool1, paramArrayOfString[0]);
            if (paramString1.moveToNext()) {
              continue;
            }
          }
          paramString1.close();
          Z(2, 0, 1);
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
        ac.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString1 != null) {
          paramString1.close();
        }
        Z(3, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(12);
        AppMethodBeat.o(24432);
        return paramArrayOfString;
      }
    }
  }
  
  private void a(MatrixCursor paramMatrixCursor, bo parambo, com.tencent.mm.storage.ai paramai, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    AppMethodBeat.i(24439);
    if (parambo == null)
    {
      AppMethodBeat.o(24439);
      return;
    }
    if (bs.isNullOrNil(paramString2))
    {
      ac.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
      AppMethodBeat.o(24439);
      return;
    }
    if ((parambo.getType() == 9999) || (parambo.getType() == 10000))
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
      i = bi.yi(parambo.field_content);
      str1 = str3;
      localObject = str2;
      if (i != -1)
      {
        str1 = str3;
        localObject = str2;
        if (parambo.field_content.length() > i)
        {
          String str4 = parambo.field_content.substring(0, i).trim();
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
              if (parambo.field_content.length() >= i + 2)
              {
                localObject = v.wk(str4);
                str1 = parambo.field_content.substring(i + 2);
              }
            }
          }
        }
      }
    }
    int k = com.tencent.mm.plugin.ext.b.b.ai(parambo);
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
        if (bs.isNullOrNil(paramString2))
        {
          ac.w("MicroMsg.ExtControlProviderMsg", "userId is null");
          AppMethodBeat.o(24439);
          return;
          localObject = parambo.field_content;
          break;
          if (k == 2)
          {
            localObject = o.aKp().pQ((int)parambo.field_msgId);
            if ((localObject == null) || (((r)localObject).fileName == null)) {
              break label550;
            }
            localObject = s.getFullPath(((r)localObject).fileName);
            ac.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", new Object[] { localObject });
            break;
          }
          if (paramBoolean1) {
            break;
          }
          if (this.qtI != null)
          {
            localObject = this.qtI.getString(2131758655);
            break;
          }
          localObject = "";
          break;
          paramString2 = AESUtil.tl((int)paramai.fLJ);
          continue;
        }
        paramai = AESUtil.tl(parambo.field_msgId);
        if (parambo.field_isSend == 0)
        {
          i = 1;
          if (parambo.field_status == 4)
          {
            j = 1;
            paramMatrixCursor.addRow(new Object[] { paramai, paramString2, paramString1, Integer.valueOf(i), Integer.valueOf(k), localObject, Integer.valueOf(j), Long.valueOf(parambo.field_createTime) });
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
        ac.e("MicroMsg.ExtControlProviderMsg", paramMatrixCursor.getMessage());
        ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramMatrixCursor, "", new Object[0]);
        AppMethodBeat.o(24439);
        return;
      }
    }
  }
  
  private Cursor b(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(24434);
    ac.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ac.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      CN(3);
      AppMethodBeat.o(24434);
      return null;
    }
    for (;;)
    {
      try
      {
        long l = AESUtil.abT(paramArrayOfString[0]);
        az.ayM();
        localbo = c.awD().vP(l);
        az.ayM();
        localai = c.awB().aNt(localbo.field_talker);
        if ((localai == null) || ((int)localai.fLJ <= 0))
        {
          CN(3);
          AppMethodBeat.o(24434);
          return null;
        }
        str = localai.aaS();
        if (!com.tencent.mm.model.w.sQ(localai.field_username)) {
          break label256;
        }
        str = v.wk(localai.field_username);
        bool1 = true;
        if ((paramString != null) && (paramString.equalsIgnoreCase("openapi"))) {
          paramString = new MatrixCursor(qtJ);
        }
      }
      catch (Exception paramArrayOfString)
      {
        bo localbo;
        com.tencent.mm.storage.ai localai;
        String str;
        paramString = null;
        ac.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString != null) {
          paramString.close();
        }
        CN(4);
        AppMethodBeat.o(24434);
        return null;
      }
      try
      {
        a(paramString, localbo, localai, bool1, str, bool2, paramArrayOfString[0]);
        CN(0);
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
  
  private Cursor cmG()
  {
    AppMethodBeat.i(24433);
    ac.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
    MatrixCursor localMatrixCursor = new MatrixCursor(qtL);
    label267:
    for (;;)
    {
      try
      {
        az.ayM();
        Cursor localCursor = c.awD().dcE();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            String str = localCursor.getString(localCursor.getColumnIndex("talker"));
            az.ayM();
            com.tencent.mm.storage.ai localai = c.awB().aNt(str);
            if (!com.tencent.mm.model.w.sQ(str))
            {
              if ((com.tencent.mm.model.w.xr(localai.field_username)) || (com.tencent.mm.model.w.xo(localai.field_username)) || (com.tencent.mm.storage.ai.YI(localai.field_verifyFlag)) || (com.tencent.mm.model.w.xg(localai.field_username))) {
                break label267;
              }
              if (!com.tencent.mm.model.w.xh(localai.field_username)) {
                continue;
              }
              break label267;
              if (i == 0) {
                localMatrixCursor.addRow(new Object[] { AESUtil.tl((int)localai.fLJ), Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("unReadCount"))) });
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
          CN(0);
          AppMethodBeat.o(24433);
          return localMatrixCursor;
        }
        int i = 1;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
        ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
        localMatrixCursor.close();
        CN(4);
        AppMethodBeat.o(24433);
        return null;
      }
    }
  }
  
  private Cursor z(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24431);
    ac.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ac.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      CN(3);
      AppMethodBeat.o(24431);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(qtK);
    try
    {
      if ("*".equals(paramArrayOfString[0]))
      {
        az.ayM();
        localMatrixCursor.addRow(new Object[] { "0", Integer.valueOf(c.awG().xC("")) });
      }
      for (;;)
      {
        CN(0);
        AppMethodBeat.o(24431);
        return localMatrixCursor;
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          long l = AESUtil.abT(paramArrayOfString[i]);
          az.ayM();
          com.tencent.mm.storage.ai localai = c.awB().AO(l);
          if ((localai != null) && ((int)localai.fLJ > 0))
          {
            az.ayM();
            localMatrixCursor.addRow(new Object[] { Long.valueOf(l), Integer.valueOf(c.awG().xC(" and ( rconversation.username='" + localai.field_username + "' );")) });
          }
          i += 1;
        }
      }
      return null;
    }
    catch (Exception paramArrayOfString)
    {
      ac.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ac.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      localMatrixCursor.close();
      CN(4);
      AppMethodBeat.o(24431);
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
    ac.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.qtH);
    if (this.qtH)
    {
      a(paramUri, this.qtI, this.qtp, this.qto);
      if (bs.isNullOrNil(this.qtA))
      {
        ac.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
        ft(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(7);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (bs.isNullOrNil(cmE()))
      {
        ac.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
        ft(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(6);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      int i = cmF();
      if (i != 1)
      {
        ac.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(i)));
        ft(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(i);
        AppMethodBeat.o(24430);
        return paramUri;
      }
    }
    else
    {
      this.qtI = getContext();
      a(paramUri, this.qtI, qtG);
      if (paramUri == null)
      {
        CN(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if ((bs.isNullOrNil(this.qtA)) || (bs.isNullOrNil(cmE())))
      {
        CN(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if (!bIc())
      {
        CN(1);
        paramUri = this.nng;
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (!eG(this.qtI))
      {
        ac.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
        CN(2);
        AppMethodBeat.o(24430);
        return null;
      }
    }
    paramArrayOfString1 = bs.nullAsNil(paramUri.getQueryParameter("source"));
    paramString1 = bs.nullAsNil(paramUri.getQueryParameter("count"));
    if (!this.qtH) {
      this.qtp = qtG.match(paramUri);
    }
    switch (this.qtp)
    {
    default: 
      ft(3, 15);
      AppMethodBeat.o(24430);
      return null;
    case 7: 
      paramUri = b(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(24430);
      return paramUri;
    case 8: 
      paramUri = z(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 9: 
      paramUri = a(paramArrayOfString2, paramArrayOfString1, paramString1);
      AppMethodBeat.o(24430);
      return paramUri;
    case 10: 
      paramUri = cmG();
      AppMethodBeat.o(24430);
      return paramUri;
    case 11: 
      paramUri = A(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 12: 
      paramUri = B(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    case 13: 
      paramUri = C(paramArrayOfString2);
      AppMethodBeat.o(24430);
      return paramUri;
    }
    paramUri = D(paramArrayOfString2);
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