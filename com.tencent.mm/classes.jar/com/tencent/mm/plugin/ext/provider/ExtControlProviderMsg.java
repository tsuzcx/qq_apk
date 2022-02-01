package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.fp.b;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.a.fs.b;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.a.fy.b;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.fz.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cb;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderMsg
  extends ExtContentProviderBase
{
  private static final UriMatcher pKZ;
  private static final String[] pLc;
  private static final String[] pLd;
  private static final String[] pLe;
  private static final String[] pLf;
  private static final String[] pLg;
  private static final String[] pLh;
  private String[] pKH = null;
  private int pKI = -1;
  private boolean pLa = false;
  private Context pLb;
  private MatrixCursor pLi = null;
  
  static
  {
    AppMethodBeat.i(24440);
    pLc = new String[] { "msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime" };
    pLd = new String[] { "userId", "unReadCount" };
    pLe = new String[] { "userId", "unReadCount" };
    pLf = new String[] { "userId", "retCode", "msgId" };
    pLg = new String[] { "msgId", "retCode" };
    pLh = new String[] { "msgId", "retCode" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    pKZ = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
    pKZ.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
    pKZ.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
    pKZ.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
    pKZ.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
    pKZ.addURI("com.tencent.mm.plugin.ext.message", "playVoice", 12);
    pKZ.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
    pKZ.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    AppMethodBeat.o(24440);
  }
  
  public ExtControlProviderMsg() {}
  
  public ExtControlProviderMsg(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.pLa = true;
    this.pKH = paramArrayOfString;
    this.pKI = paramInt;
    this.pLb = paramContext;
  }
  
  private Cursor A(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24435);
    ad.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ad.w("MicroMsg.ExtControlProviderMsg", "wrong args");
      BS(3);
      AppMethodBeat.o(24435);
      return null;
    }
    try
    {
      final int i = Integer.valueOf(paramArrayOfString[0]).intValue();
      final long l = AESUtil.Xw(paramArrayOfString[1]);
      if (l <= 0L)
      {
        BS(3);
        AppMethodBeat.o(24435);
        return null;
      }
      com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
      localb.b(4000L, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24427);
          Object localObject1;
          Object localObject2;
          if (i == 1)
          {
            com.tencent.mm.plugin.ext.b.ceJ();
            localObject1 = com.tencent.mm.plugin.ext.b.pu(l);
            if ((localObject1 == null) || ((int)((com.tencent.mm.n.b)localObject1).fId <= 0))
            {
              ExtControlProviderMsg.this.BS(3);
              paramArrayOfString.countDown();
              AppMethodBeat.o(24427);
              return;
            }
            localObject2 = new fs();
            ((fs)localObject2).dix.op = 1;
            ((fs)localObject2).dix.username = ((au)localObject1).field_username;
            if (!com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2))
            {
              ExtControlProviderMsg.this.BS(4);
              paramArrayOfString.countDown();
              AppMethodBeat.o(24427);
              return;
            }
            ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.cfa()));
            if ((localObject1 != null) && ((int)((com.tencent.mm.n.b)localObject1).fId > 0) && (((fs)localObject2).diy.dew))
            {
              ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.fHR[1], Integer.valueOf(1), "0" });
              ExtControlProviderMsg.this.BS(0);
              ad.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[] { Boolean.valueOf(((fs)localObject2).diy.dew), ((fs)localObject2).diy.fileName });
            }
          }
          for (;;)
          {
            paramArrayOfString.countDown();
            AppMethodBeat.o(24427);
            return;
            ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.fHR[1], Integer.valueOf(2), "0" });
            ExtControlProviderMsg.this.BS(3);
            break;
            if (i == 2)
            {
              localObject1 = new fs();
              ((fs)localObject1).dix.op = 2;
              if (!com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1))
              {
                ExtControlProviderMsg.this.BS(4);
                paramArrayOfString.countDown();
                AppMethodBeat.o(24427);
                return;
              }
              localObject2 = ((fs)localObject1).diy.fileName;
              ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.cfa()));
              fy localfy = new fy();
              localfy.diT.fileName = ((String)localObject2);
              if (!com.tencent.mm.sdk.b.a.ESL.l(localfy))
              {
                ExtControlProviderMsg.this.BS(4);
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).close();
                paramArrayOfString.countDown();
                AppMethodBeat.o(24427);
                return;
              }
              ad.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[] { Long.valueOf(localfy.diU.msgId) });
              long l = localfy.diU.msgId;
              if (l > 0L)
              {
                try
                {
                  if (!((fs)localObject1).diy.dew) {
                    break label643;
                  }
                  if ((aj.getContext() == null) || (!ay.isConnected(aj.getContext()))) {
                    break label594;
                  }
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.fHR[1], Integer.valueOf(1), AESUtil.pw(l) });
                  ExtControlProviderMsg.this.BS(0);
                }
                catch (Exception localException)
                {
                  ad.w("MicroMsg.ExtControlProviderMsg", localException.getMessage());
                  ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
                  ExtControlProviderMsg.this.BS(4);
                }
                continue;
                label594:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.fHR[1], Integer.valueOf(6), AESUtil.pw(l) });
                ExtControlProviderMsg.this.BS(4);
                continue;
                label643:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.fHR[1], Integer.valueOf(4), AESUtil.pw(l) });
                ExtControlProviderMsg.this.BS(4);
              }
              else
              {
                ExtControlProviderMsg.this.BS(3);
              }
            }
          }
        }
      });
      paramArrayOfString = this.pLi;
      AppMethodBeat.o(24435);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.pLi != null) {
        this.pLi.close();
      }
      BS(4);
      AppMethodBeat.o(24435);
    }
    return null;
  }
  
  private Cursor B(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24436);
    ad.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      BS(3);
      AppMethodBeat.o(24436);
      return null;
    }
    Object localObject = null;
    try
    {
      i = Integer.valueOf(paramArrayOfString[0]).intValue();
      long l = AESUtil.Xw(paramArrayOfString[1]);
      if (l <= 0L)
      {
        BS(3);
        AppMethodBeat.o(24436);
        return null;
      }
      if (i != 3) {
        break label363;
      }
      MatrixCursor localMatrixCursor = new MatrixCursor(pLg);
      try
      {
        localObject = new fz();
        ((fz)localObject).diV.msgId = l;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        if ((((fz)localObject).diW.fileName == null) || (((fz)localObject).diW.fileName.length() <= 0))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          BS(4);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
        }
        fr localfr = new fr();
        localfr.dis.op = 1;
        localfr.dis.fileName = ((fz)localObject).diW.fileName;
        if (com.tencent.mm.sdk.b.a.ESL.l(localfr))
        {
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(1) });
          BS(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.ext.b.ceJ();
          com.tencent.mm.plugin.ext.b.pv(l);
          AppMethodBeat.o(24436);
          return localMatrixCursor;
          ad.e("MicroMsg.ExtControlProviderMsg", "play failed");
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          BS(4);
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
      label319:
      break label319;
    }
    ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
    if (localObject != null) {
      ((MatrixCursor)localObject).close();
    }
    BS(4);
    AppMethodBeat.o(24436);
    return null;
    label363:
    if (i == 4)
    {
      paramArrayOfString = new fr();
      paramArrayOfString.dis.op = 2;
      if (!com.tencent.mm.sdk.b.a.ESL.l(paramArrayOfString)) {
        break label415;
      }
      ad.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
      BS(0);
    }
    for (;;)
    {
      AppMethodBeat.o(24436);
      return null;
      label415:
      ad.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
      BS(4);
    }
  }
  
  private Cursor C(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24437);
    ad.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      fq(3, 3801);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3801);
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
            long l = AESUtil.Xw(paramArrayOfString[i]);
            com.tencent.mm.plugin.ext.b.ceJ();
            com.tencent.mm.plugin.ext.b.pv(l);
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        fq(4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(12);
        AppMethodBeat.o(24437);
        return paramArrayOfString;
      }
      fq(0, 1);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
      AppMethodBeat.o(24437);
      return paramArrayOfString;
      i += 1;
    }
  }
  
  private Cursor D(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(24438);
    ad.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      BS(3);
      AppMethodBeat.o(24438);
      return null;
    }
    try
    {
      long l = AESUtil.Xw(paramArrayOfString[0]);
      if (l <= 0L)
      {
        BS(3);
        AppMethodBeat.o(24438);
        return null;
      }
      com.tencent.mm.plugin.ext.b.ceJ();
      final af localaf = com.tencent.mm.plugin.ext.b.pu(l);
      if ((localaf == null) || ((int)localaf.fId <= 0))
      {
        ad.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
        BS(3);
        AppMethodBeat.o(24438);
        return null;
      }
      this.pLi = new MatrixCursor(pLh);
      final com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
      localb.b(15000L, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24429);
          Object localObject = new fp();
          ((fp)localObject).dim.dio = localaf.field_username;
          ((fp)localObject).dim.content = paramArrayOfString[1];
          ((fp)localObject).dim.type = com.tencent.mm.model.w.tq(localaf.field_username);
          ((fp)localObject).dim.flags = 0;
          if (!com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject))
          {
            ExtControlProviderMsg.this.BS(4);
            localb.countDown();
            AppMethodBeat.o(24429);
            return;
          }
          n localn = ((fp)localObject).din.dip;
          try
          {
            localObject = new g()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(24428);
                ad.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                if (paramAnonymous2n == null)
                {
                  ad.e("MicroMsg.ExtControlProviderMsg", "scene == null");
                  az.aeS().b(522, this);
                  ExtControlProviderMsg.this.BS(4);
                  ExtControlProviderMsg.2.this.mLg.countDown();
                  AppMethodBeat.o(24428);
                  return;
                }
                switch (paramAnonymous2n.getType())
                {
                default: 
                  ExtControlProviderMsg.this.BS(0);
                }
                for (;;)
                {
                  ExtControlProviderMsg.2.this.mLg.countDown();
                  az.aeS().b(522, this);
                  AppMethodBeat.o(24428);
                  return;
                  if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                  {
                    ad.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                    ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.pLm, Integer.valueOf(1) });
                    break;
                  }
                  ad.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + paramAnonymous2Int1 + ", errCode = " + paramAnonymous2Int2);
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.pLm, Integer.valueOf(2) });
                  ExtControlProviderMsg.this.BS(4);
                }
              }
            };
            az.aeS().a(522, (g)localObject);
            az.aeS().a(localn, 0);
            AppMethodBeat.o(24429);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
            ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
            ExtControlProviderMsg.this.BS(4);
            localb.countDown();
            AppMethodBeat.o(24429);
          }
        }
      });
      paramArrayOfString = this.pLi;
      AppMethodBeat.o(24438);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.pLi != null) {
        this.pLi.close();
      }
      BS(4);
      AppMethodBeat.o(24438);
    }
    return null;
  }
  
  private Cursor a(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(24432);
    ad.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
    ad.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      fq(3, 3701);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3701);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
      fq(3, 3702);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3702);
      AppMethodBeat.o(24432);
      return paramArrayOfString;
    }
    if (bt.isNullOrNil(paramString2))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
      fq(3, 3703);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3703);
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
        paramString1 = com.tencent.mm.plugin.ext.b.ceM().aJl(paramArrayOfString[0]);
        if ((paramString1 == null) || (bt.isNullOrNil(paramString1.field_openId)) || (bt.isNullOrNil(paramString1.field_username)))
        {
          ad.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
          fq(3, 3704);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3704);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          bool1 = false;
          break;
        }
        az.arV();
        af localaf = c.apM().aHY(paramString1.field_username);
        if ((localaf == null) || (localaf.field_username == null) || (localaf.field_username.length() <= 0))
        {
          ad.e("MicroMsg.ExtControlProviderMsg", "contact is null");
          fq(3, 3705);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3705);
          AppMethodBeat.o(24432);
          return paramArrayOfString;
          label315:
          long l = AESUtil.Xw(paramArrayOfString[0]);
          az.arV();
          localaf = c.apM().wl(l);
        }
        else
        {
          String str = localaf.ZX();
          if (com.tencent.mm.model.w.pF(localaf.field_username))
          {
            str = v.sh(localaf.field_username);
            bool2 = true;
            if (bool1)
            {
              try
              {
                i = bt.getInt(paramString2, 0);
                if ((i <= 0) || (i >= 15))
                {
                  az.arV();
                  paramString1 = c.apO().dL(localaf.field_username, 15);
                  if (paramString1 != null) {
                    continue;
                  }
                  ad.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                  Y(3, 4, 3706);
                  paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3706);
                  AppMethodBeat.o(24432);
                  return paramArrayOfString;
                }
              }
              catch (Exception paramString1)
              {
                ad.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[] { paramString2 });
                int i = 0;
                continue;
                az.arV();
                paramString1 = c.apO().dL(localaf.field_username, i);
                continue;
              }
            }
            else
            {
              az.arV();
              paramString1 = c.apO().dL(localaf.field_username, 3);
              continue;
            }
            paramString2 = new MatrixCursor(pLc);
          }
          bl localbl;
          boolean bool2 = false;
        }
      }
      catch (Exception paramArrayOfString)
      {
        try
        {
          if ((paramString1.getCount() > 0) && (paramString1.moveToFirst()))
          {
            localbl = new bl();
            localbl.convertFrom(paramString1);
            a(paramString2, localbl, localaf, bool2, str, bool1, paramArrayOfString[0]);
            if (paramString1.moveToNext()) {
              continue;
            }
          }
          paramString1.close();
          Y(2, 0, 1);
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
        Y(3, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(12);
        AppMethodBeat.o(24432);
        return paramArrayOfString;
      }
    }
  }
  
  private void a(MatrixCursor paramMatrixCursor, bl parambl, af paramaf, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    AppMethodBeat.i(24439);
    if (parambl == null)
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
    if ((parambl.getType() == 9999) || (parambl.getType() == 10000))
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
      i = bi.uc(parambl.field_content);
      str1 = str3;
      localObject = str2;
      if (i != -1)
      {
        str1 = str3;
        localObject = str2;
        if (parambl.field_content.length() > i)
        {
          String str4 = parambl.field_content.substring(0, i).trim();
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
              if (parambl.field_content.length() >= i + 2)
              {
                localObject = v.sh(str4);
                str1 = parambl.field_content.substring(i + 2);
              }
            }
          }
        }
      }
    }
    int k = com.tencent.mm.plugin.ext.b.b.ai(parambl);
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
          localObject = parambl.field_content;
          break;
          if (k == 2)
          {
            localObject = o.aDy().pb((int)parambl.field_msgId);
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
          if (this.pLb != null)
          {
            localObject = this.pLb.getString(2131758655);
            break;
          }
          localObject = "";
          break;
          paramString2 = AESUtil.pw((int)paramaf.fId);
          continue;
        }
        paramaf = AESUtil.pw(parambl.field_msgId);
        if (parambl.field_isSend == 0)
        {
          i = 1;
          if (parambl.field_status == 4)
          {
            j = 1;
            paramMatrixCursor.addRow(new Object[] { paramaf, paramString2, paramString1, Integer.valueOf(i), Integer.valueOf(k), localObject, Integer.valueOf(j), Long.valueOf(parambl.field_createTime) });
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
      BS(3);
      AppMethodBeat.o(24434);
      return null;
    }
    for (;;)
    {
      try
      {
        long l = AESUtil.Xw(paramArrayOfString[0]);
        az.arV();
        localbl = c.apO().rm(l);
        az.arV();
        localaf = c.apM().aHY(localbl.field_talker);
        if ((localaf == null) || ((int)localaf.fId <= 0))
        {
          BS(3);
          AppMethodBeat.o(24434);
          return null;
        }
        str = localaf.ZX();
        if (!com.tencent.mm.model.w.pF(localaf.field_username)) {
          break label256;
        }
        str = v.sh(localaf.field_username);
        bool1 = true;
        if ((paramString != null) && (paramString.equalsIgnoreCase("openapi"))) {
          paramString = new MatrixCursor(pLc);
        }
      }
      catch (Exception paramArrayOfString)
      {
        bl localbl;
        af localaf;
        String str;
        paramString = null;
        ad.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        if (paramString != null) {
          paramString.close();
        }
        BS(4);
        AppMethodBeat.o(24434);
        return null;
      }
      try
      {
        a(paramString, localbl, localaf, bool1, str, bool2, paramArrayOfString[0]);
        BS(0);
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
  
  private Cursor ceZ()
  {
    AppMethodBeat.i(24433);
    ad.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
    MatrixCursor localMatrixCursor = new MatrixCursor(pLe);
    label267:
    for (;;)
    {
      try
      {
        az.arV();
        Cursor localCursor = c.apO().cOV();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            String str = localCursor.getString(localCursor.getColumnIndex("talker"));
            az.arV();
            af localaf = c.apM().aHY(str);
            if (!com.tencent.mm.model.w.pF(str))
            {
              if ((com.tencent.mm.model.w.to(localaf.field_username)) || (com.tencent.mm.model.w.tl(localaf.field_username)) || (af.Wy(localaf.field_verifyFlag)) || (com.tencent.mm.model.w.td(localaf.field_username))) {
                break label267;
              }
              if (!com.tencent.mm.model.w.te(localaf.field_username)) {
                continue;
              }
              break label267;
              if (i == 0) {
                localMatrixCursor.addRow(new Object[] { AESUtil.pw((int)localaf.fId), Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("unReadCount"))) });
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
          BS(0);
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
        BS(4);
        AppMethodBeat.o(24433);
        return null;
      }
    }
  }
  
  private Cursor z(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24431);
    ad.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      BS(3);
      AppMethodBeat.o(24431);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(pLd);
    try
    {
      if ("*".equals(paramArrayOfString[0]))
      {
        az.arV();
        localMatrixCursor.addRow(new Object[] { "0", Integer.valueOf(c.apR().tz("")) });
      }
      for (;;)
      {
        BS(0);
        AppMethodBeat.o(24431);
        return localMatrixCursor;
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          long l = AESUtil.Xw(paramArrayOfString[i]);
          az.arV();
          af localaf = c.apM().wl(l);
          if ((localaf != null) && ((int)localaf.fId > 0))
          {
            az.arV();
            localMatrixCursor.addRow(new Object[] { Long.valueOf(l), Integer.valueOf(c.apR().tz(" and ( rconversation.username='" + localaf.field_username + "' );")) });
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
      BS(4);
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
    ad.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.pLa);
    if (this.pLa)
    {
      a(paramUri, this.pLb, this.pKI, this.pKH);
      if (bt.isNullOrNil(this.pKT))
      {
        ad.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
        fq(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(7);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (bt.isNullOrNil(ceX()))
      {
        ad.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
        fq(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(6);
        AppMethodBeat.o(24430);
        return paramUri;
      }
      int i = ceY();
      if (i != 1)
      {
        ad.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(i)));
        fq(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(i);
        AppMethodBeat.o(24430);
        return paramUri;
      }
    }
    else
    {
      this.pLb = getContext();
      a(paramUri, this.pLb, pKZ);
      if (paramUri == null)
      {
        BS(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if ((bt.isNullOrNil(this.pKT)) || (bt.isNullOrNil(ceX())))
      {
        BS(3);
        AppMethodBeat.o(24430);
        return null;
      }
      if (!bBg())
      {
        BS(1);
        paramUri = this.mKX;
        AppMethodBeat.o(24430);
        return paramUri;
      }
      if (!ey(this.pLb))
      {
        ad.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
        BS(2);
        AppMethodBeat.o(24430);
        return null;
      }
    }
    paramArrayOfString1 = bt.nullAsNil(paramUri.getQueryParameter("source"));
    paramString1 = bt.nullAsNil(paramUri.getQueryParameter("count"));
    if (!this.pLa) {
      this.pKI = pKZ.match(paramUri);
    }
    switch (this.pKI)
    {
    default: 
      fq(3, 15);
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
      paramUri = ceZ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg
 * JD-Core Version:    0.7.0.1
 */