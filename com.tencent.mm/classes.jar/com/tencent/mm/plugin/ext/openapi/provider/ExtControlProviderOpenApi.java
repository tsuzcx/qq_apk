package com.tencent.mm.plugin.ext.openapi.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.fw.b;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.ext.d.b.b;
import com.tencent.mm.plugin.ext.d.d.b;
import com.tencent.mm.plugin.ext.d.e.2;
import com.tencent.mm.plugin.ext.d.e.a;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cb;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExtControlProviderOpenApi
  extends ExtContentProviderBase
{
  public static boolean IS_DEBUG = false;
  private static final String[] pKA = { "retCode", "selfId" };
  private static final String[] pKB = { "retCode", "sportConfig" };
  private static final String[] pKC = { "openid", "avatar" };
  private static final String[] pKD = { "voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath" };
  private static final String[] pKE = { "ssid", "macAddress", "isSupportWechat", "name" };
  private static final String[] pKF = { "username", "appId", "versionType", "nickname", "shortNickname", "iconURL", "collection", "runningFlag", "wechatPkg", "action", "intentInfo" };
  private static final String[] pKG = { "token", "nickname", "iconURL" };
  private String appId = "";
  private Context context;
  private ap handler;
  private String[] pKH = null;
  private int pKI = -1;
  
  private ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.pKH = paramArrayOfString;
    this.pKI = paramInt;
    this.context = paramContext;
  }
  
  public ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext, String paramString)
  {
    this(paramArrayOfString, paramInt, paramContext);
    this.appId = paramString;
  }
  
  private Cursor V(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(24395);
    ad.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", new Object[] { paramString1, paramString2, paramString3 });
      fq(3, 2004);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ue(2004);
      AppMethodBeat.o(24395);
      return paramString1;
    }
    Object localObject = null;
    try
    {
      int i = Integer.parseInt(paramString3);
      int j = Integer.parseInt(paramString1);
      int k = Integer.parseInt(paramString2);
      if (i != 2)
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: ".concat(String.valueOf(i)));
        fq(3, 2005);
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ue(2005);
        AppMethodBeat.o(24395);
        return paramString1;
      }
      if (com.tencent.mm.plugin.ext.b.ceL().aIZ(this.pKT) == null)
      {
        paramString1 = new bp();
        paramString1.field_appId = this.pKT;
        paramString1.field_packageName = ceX();
        paramString2 = this.pKT;
        boolean bool;
        if (bt.isNullOrNil(paramString2))
        {
          bool = false;
          if (!bool) {
            break label329;
          }
        }
        label329:
        for (paramString1.field_status = 1;; paramString1.field_status = 0)
        {
          paramString1.field_sceneFlag = j;
          paramString1.field_msgTypeFlag = k;
          paramString1.field_msgState = i;
          bool = com.tencent.mm.plugin.ext.b.ceL().insert(paramString1);
          ad.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", new Object[] { Boolean.valueOf(bool), ceX(), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(paramString1.field_status) });
          if (bool) {
            break label415;
          }
          paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ue(2006);
          AppMethodBeat.o(24395);
          return paramString1;
          bool = com.tencent.mm.pluginsdk.model.app.h.n(com.tencent.mm.pluginsdk.model.app.h.j(paramString2, true, false));
          break;
        }
        Y(1, 4, 12);
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = localObject;
    }
    for (;;)
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", new Object[] { paramString1.getMessage() });
      if (paramString2 != null) {
        paramString2.close();
      }
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ue(12);
      AppMethodBeat.o(24395);
      return paramString1;
      ad.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", new Object[] { this.pKT, ceX() });
      label415:
      paramString1 = new StringBuilder().append(u.aqG());
      az.arV();
      paramString1 = com.tencent.mm.sdk.platformtools.ai.du(com.tencent.mm.model.c.getUin());
      paramString2 = new MatrixCursor(pKA);
      try
      {
        paramString2.addRow(new Object[] { Integer.valueOf(1), bt.nullAsNil(paramString1) });
        Y(0, 0, 1);
        ad.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(24395);
        return paramString2;
      }
      catch (Exception paramString1) {}
    }
  }
  
  private Cursor a(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(24393);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(2);
      AppMethodBeat.o(24393);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor;
    if (paramBoolean) {
      localMatrixCursor = new MatrixCursor(pKG);
    }
    int j;
    for (;;)
    {
      int i;
      LocalUsageInfo localLocalUsageInfo;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      int k;
      try
      {
        j = Integer.parseInt(paramArrayOfString[0]);
        i = Integer.parseInt(paramArrayOfString[1]);
        paramArrayOfString = null;
        if (1 != j) {
          break label408;
        }
        if (paramBoolean)
        {
          paramArrayOfString = ((com.tencent.mm.plugin.appbrand.appusage.ai)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appusage.ai.class)).dC(i, 0);
          Iterator localIterator = com.tencent.luggage.h.b.L(paramArrayOfString).iterator();
          if (!localIterator.hasNext()) {
            break label935;
          }
          localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
          localObject1 = ((m)com.tencent.mm.kernel.g.ab(m.class)).FX(localLocalUsageInfo.appId);
          if (localObject1 == null) {
            continue;
          }
          if (paramBoolean) {
            break label614;
          }
          paramArrayOfString = ((WxaAttributes)localObject1).field_roundedSquareIconURL;
          localObject2 = ((WxaAttributes)localObject1).field_brandIconURL;
          localObject3 = ((WxaAttributes)localObject1).field_bigHeadURL;
          localObject4 = (com.tencent.mm.modelappbrand.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.b.a.class);
          localObject5 = aj.getPackageName();
          i = localLocalUsageInfo.gXn;
          localObject6 = ((WxaAttributes)localObject1).field_username;
          String str1 = ((WxaAttributes)localObject1).field_nickname;
          String str2 = ((WxaAttributes)localObject1).field_appId;
          com.tencent.mm.kernel.g.afz();
          k = com.tencent.mm.kernel.a.getUin();
          paramArrayOfString = ((com.tencent.mm.modelappbrand.b.a)localObject4).a((String)localObject5, i, (String)localObject6, str1, new String[] { paramArrayOfString, localObject2, localObject3 }, str2, k, 3);
          if (paramArrayOfString == null) {
            continue;
          }
          localObject3 = paramArrayOfString.getExtras();
          if (localObject3 == null) {
            continue;
          }
          localObject2 = new HashMap();
          localObject4 = ((Bundle)localObject3).keySet().iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label459;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          ((Map)localObject2).put(localObject5, ((Bundle)localObject3).get((String)localObject5));
          continue;
          localMatrixCursor = new MatrixCursor(pKF);
          continue;
        }
        paramArrayOfString = ((com.tencent.mm.plugin.appbrand.appusage.ai)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appusage.ai.class)).qL(i);
      }
      catch (NumberFormatException paramArrayOfString)
      {
        ad.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(2);
        AppMethodBeat.o(24393);
        return paramArrayOfString;
      }
      continue;
      label408:
      if (2 == j) {
        if (paramBoolean)
        {
          paramArrayOfString = ((ah)com.tencent.mm.kernel.g.ab(ah.class)).a(i, null, 0);
        }
        else
        {
          paramArrayOfString = ((ah)com.tencent.mm.kernel.g.ab(ah.class)).a(i, null);
          continue;
          label459:
          localObject3 = localLocalUsageInfo.username;
          localObject4 = localLocalUsageInfo.appId;
          k = localLocalUsageInfo.gXn;
          localObject5 = localLocalUsageInfo.nickname;
          localObject6 = localLocalUsageInfo.cfp;
          localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;
          if (localLocalUsageInfo.iVQ) {}
          for (i = 1;; i = 0)
          {
            localMatrixCursor.addRow(new Object[] { localObject3, localObject4, Integer.valueOf(k), localObject5, localObject6, localObject1, Integer.valueOf(i), Long.valueOf(localLocalUsageInfo.cfT), paramArrayOfString.getPackage(), paramArrayOfString.getAction(), new com.tencent.mm.ac.i((Map)localObject2).toString() });
            break;
          }
          label614:
          paramArrayOfString = new StringBuilder().append(localLocalUsageInfo.username).append(",");
          com.tencent.mm.kernel.g.afz();
          paramArrayOfString = (com.tencent.mm.kernel.a.getUin() + "," + this.pKT).getBytes();
          try
          {
            localObject2 = MessageDigest.getInstance("SHA-256");
            ((MessageDigest)localObject2).update(paramArrayOfString);
            paramArrayOfString = String.format("%064x", new Object[] { new BigInteger(1, ((MessageDigest)localObject2).digest()) });
            localObject2 = com.tencent.mm.plugin.ext.b.ceN();
            localObject3 = localLocalUsageInfo.username;
            com.tencent.mm.kernel.g.afz();
            i = com.tencent.mm.kernel.a.getUin();
            localObject4 = this.pKT;
            d.g.b.k.h(paramArrayOfString, "token");
            d.g.b.k.h(localObject3, "userName");
            d.g.b.k.h(localObject4, "appid");
            localObject5 = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(localObject5, "MMKernel.storage()");
            localObject5 = ((com.tencent.mm.kernel.e)localObject5).gda.query(((com.tencent.mm.plugin.ext.a.a)localObject2).getTableName(), null, null, null, null, null, null);
            localObject6 = new StringBuilder();
            d.g.b.k.g(localObject5, "query");
            ((StringBuilder)localObject6).append(((Cursor)localObject5).getColumnNames());
            com.tencent.d.f.h.fmz();
            localObject5 = new com.tencent.mm.plugin.ext.a.b();
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_token = paramArrayOfString;
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_username = ((String)localObject3);
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_uin = i;
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_appid = ((String)localObject4);
            if (((com.tencent.mm.plugin.ext.a.a)localObject2).Xu(paramArrayOfString) != null)
            {
              ((com.tencent.mm.plugin.ext.a.a)localObject2).update((com.tencent.mm.sdk.e.c)localObject5, new String[0]);
              localMatrixCursor.addRow(new Object[] { paramArrayOfString, localLocalUsageInfo.nickname, ((WxaAttributes)localObject1).field_brandIconURL });
            }
          }
          catch (NoSuchAlgorithmException paramArrayOfString)
          {
            for (;;)
            {
              paramArrayOfString = "";
              continue;
              ((com.tencent.mm.plugin.ext.a.a)localObject2).insert((com.tencent.mm.sdk.e.c)localObject5);
            }
          }
        }
      }
    }
    label935:
    com.tencent.mm.plugin.report.service.h.vKh.f(18601, new Object[] { this.pKT, Integer.valueOf(j), Integer.valueOf(localMatrixCursor.getCount()) });
    AppMethodBeat.o(24393);
    return localMatrixCursor;
  }
  
  private void ceU()
  {
    AppMethodBeat.i(24398);
    String str1 = (String)com.tencent.mm.plugin.ext.b.ceK().get(ae.a.FlO, null);
    String str2 = ceX();
    ad.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", new Object[] { str1, str2 });
    if (str1 != null)
    {
      if (!com.tencent.mm.compatible.loader.a.contains(str1.split(";"), str2)) {
        com.tencent.mm.plugin.ext.b.ceK().set(ae.a.FlO, str1 + ";" + ceX());
      }
      AppMethodBeat.o(24398);
      return;
    }
    com.tencent.mm.plugin.ext.b.ceK().set(ae.a.FlO, ceX());
    AppMethodBeat.o(24398);
  }
  
  private Cursor l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(24394);
    ad.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", new Object[] { paramString1 });
    if (this.context == null)
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
      fq(4, 2001);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ue(2001);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
      fq(3, 2002);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ue(2002);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    int i = -1;
    try
    {
      int j = bt.getInt(paramString1, -1);
      i = j;
    }
    catch (Exception paramString1)
    {
      label112:
      boolean bool;
      break label112;
    }
    if (i == 1)
    {
      paramString1 = V(paramString2, paramString3, paramString4);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    if (i == 2)
    {
      ad.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
      if (com.tencent.mm.plugin.ext.b.ceL().aIZ(this.pKT) == null)
      {
        ad.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", new Object[] { this.pKT, ceX() });
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ue(2007);
        AppMethodBeat.o(24394);
        return paramString1;
      }
      paramString1 = com.tencent.mm.plugin.ext.b.ceL();
      paramString2 = this.pKT;
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        bool = false;
      }
      for (;;)
      {
        ad.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", new Object[] { Boolean.valueOf(bool), this.pKT, ceX() });
        if (bool) {
          break;
        }
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ue(2008);
        AppMethodBeat.o(24394);
        return paramString1;
        if (paramString1.db.delete("OpenMsgListener", "appId=?", new String[] { bt.aFQ(paramString2) }) <= 0) {
          bool = false;
        } else {
          bool = true;
        }
      }
      Y(0, 0, 1);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    ad.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", new Object[] { Integer.valueOf(i) });
    fq(3, 2003);
    paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ue(2003);
    AppMethodBeat.o(24394);
    return paramString1;
  }
  
  private Cursor u(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24392);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(2);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramArrayOfString[0]);
      if (1 == i) {
        ((com.tencent.mm.plugin.appbrand.service.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.k.class)).a(this.context, i, this.appId);
      }
    }
    catch (NumberFormatException paramArrayOfString)
    {
      try
      {
        i = Integer.parseInt(paramArrayOfString[1]);
        if ((1 == i) || (2 == i) || (i == 0)) {
          break label134;
        }
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(2);
        AppMethodBeat.o(24392);
        return paramArrayOfString;
      }
      catch (NumberFormatException paramArrayOfString)
      {
        ad.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(2);
        AppMethodBeat.o(24392);
        return paramArrayOfString;
      }
      paramArrayOfString = paramArrayOfString;
      ad.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(2);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
    }
    for (;;)
    {
      label134:
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
      if (2 != i) {
        break;
      }
      ((com.tencent.mm.plugin.appbrand.service.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.k.class)).V(this.context, this.appId);
    }
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(2);
    AppMethodBeat.o(24392);
    return paramArrayOfString;
  }
  
  private Cursor v(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24396);
    ad.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
      fq(3, 3001);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3001);
      AppMethodBeat.o(24396);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(pKC);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 5)) {
          break label377;
        }
        if (bt.isNullOrNil(paramArrayOfString[i])) {
          break label397;
        }
        localObject = com.tencent.mm.plugin.ext.b.ceM().aJl(paramArrayOfString[i]);
        if ((localObject == null) || (bt.isNullOrNil(((ca)localObject).field_openId)) || (bt.isNullOrNil(((ca)localObject).field_username)))
        {
          ad.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
        }
        else
        {
          az.arV();
          localObject = com.tencent.mm.model.c.apM().aHY(((ca)localObject).field_username);
          if ((localObject == null) || (((au)localObject).field_username == null) || (((au)localObject).field_username.length() <= 0)) {
            ad.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", new Object[] { paramArrayOfString.getMessage() });
        Y(7, 4, 12);
        localMatrixCursor.close();
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(12);
        AppMethodBeat.o(24396);
        return paramArrayOfString;
      }
      p.auq();
      Object localObject = com.tencent.mm.ak.e.J(((au)localObject).field_username, false);
      if (bt.isNullOrNil((String)localObject))
      {
        ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
      }
      else
      {
        if (((String)localObject).startsWith(com.tencent.mm.kernel.g.afB().cachePath))
        {
          int j = com.tencent.mm.kernel.g.afB().cachePath.length();
          String str = com.tencent.mm.kernel.g.afB().gcW + ((String)localObject).substring(j);
          com.tencent.mm.vfs.i.aMF(com.tencent.mm.vfs.i.aMQ(str));
          com.tencent.mm.vfs.i.lC((String)localObject, str);
          localObject = str;
        }
        for (;;)
        {
          e.b.wa((String)localObject);
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], localObject });
          break;
          label377:
          Y(6, 0, 1);
          AppMethodBeat.o(24396);
          return localMatrixCursor;
        }
      }
      label397:
      i += 1;
    }
  }
  
  private Cursor w(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24397);
    ad.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (paramArrayOfString[0].length() <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
      fq(3, 3101);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3101);
      AppMethodBeat.o(24397);
      return paramArrayOfString;
    }
    Object localObject3 = null;
    int i = 0;
    for (;;)
    {
      Object localObject2;
      if ((i < 5) && (i < paramArrayOfString.length))
      {
        String str2 = paramArrayOfString[i];
        Object localObject4 = localObject3;
        com.tencent.mm.modelvoice.k localk;
        for (;;)
        {
          String str1;
          try
          {
            Object localObject1;
            if (!q.h(str2, 0, true))
            {
              localObject4 = localObject3;
              ad.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", new Object[] { paramArrayOfString[i] });
              localObject1 = localObject3;
            }
            else
            {
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                localObject4 = localObject3;
                localObject1 = new MatrixCursor(pKD);
              }
              localObject4 = localObject1;
              localk = new com.tencent.mm.modelvoice.k();
              localObject4 = localObject1;
              str1 = com.tencent.mm.plugin.ext.b.ceP() + "/" + com.tencent.mm.sdk.platformtools.ai.du(str2);
              localObject4 = localObject1;
              ad.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", new Object[] { str1 });
              localObject4 = localObject1;
              if (com.tencent.mm.vfs.i.aMN(str1) > 0L)
              {
                localObject4 = localObject1;
                ad.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                localObject3 = str1;
                localObject4 = localObject1;
                if (com.tencent.mm.vfs.i.aMN(str1) == 0L)
                {
                  localObject4 = localObject1;
                  localObject3 = localk.bq(str2, str1);
                }
                localObject4 = localObject1;
                if (!bt.isNullOrNil((String)localObject3)) {
                  break;
                }
                localObject4 = localObject1;
                ad.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
              }
            }
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", new Object[] { localException.getMessage() });
            localObject2 = localObject4;
          }
          localObject4 = localObject2;
          localObject3 = localk.bq(str2, str1);
        }
        localObject4 = localObject2;
        ad.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", new Object[] { Integer.valueOf(i) });
        localObject4 = localObject2;
        localObject2.addRow(new Object[] { Integer.valueOf(1), Integer.valueOf(localk.mSampleRate), Integer.valueOf(localk.cYz), Integer.valueOf(2), localObject3 });
      }
      else
      {
        if (localObject3 != null)
        {
          Y(8, 0, 1);
          AppMethodBeat.o(24397);
          return localObject3;
        }
        Y(9, 3, 4);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(4);
        AppMethodBeat.o(24397);
        return paramArrayOfString;
      }
      i += 1;
      localObject3 = localObject2;
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
    AppMethodBeat.i(24390);
    this.handler = new ap();
    AppMethodBeat.o(24390);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, final String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(24391);
    ad.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", new Object[] { Integer.valueOf(this.pKI) });
    a(paramUri, this.context, this.pKI, this.pKH);
    paramArrayOfString1 = this.pKT;
    if (paramUri == null)
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
      fq(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(5);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (bt.isNullOrNil(this.pKT))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
      fq(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(7);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (bt.isNullOrNil(ceX()))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
      fq(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(6);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (!bBg())
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
      fq(1, 3);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(3);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    int i = 1;
    if (!IS_DEBUG) {
      i = ceY();
    }
    if (i != 1)
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = ".concat(String.valueOf(i)));
      fq(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(i);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    long l1;
    switch (this.pKI)
    {
    case 24: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 39: 
    case 43: 
    case 44: 
    case 45: 
    case 47: 
    case 49: 
    case 50: 
    case 53: 
    case 55: 
    default: 
      fq(3, 15);
      AppMethodBeat.o(24391);
      return null;
    case 22: 
      paramUri = l(paramUri.getQueryParameter("op"), paramUri.getQueryParameter("scene"), paramUri.getQueryParameter("msgType"), paramUri.getQueryParameter("msgState"));
      AppMethodBeat.o(24391);
      return paramUri;
    case 23: 
      paramUri = v(paramArrayOfString2);
      AppMethodBeat.o(24391);
      return paramUri;
    case 25: 
      paramUri = w(paramArrayOfString2);
      AppMethodBeat.o(24391);
      return paramUri;
    case 34: 
      ad.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (paramArrayOfString2[0].length() <= 0))
      {
        if (paramArrayOfString2 == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.e("MicroMsg.ExtControlProviderOpenApi", "sendSight wrong args,args == null:%s", new Object[] { Boolean.valueOf(bool) });
          fq(3, 3401);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(3401);
          AppMethodBeat.o(24391);
          return paramUri;
        }
      }
      paramUri = paramArrayOfString2[0];
      if ((bt.isNullOrNil(paramUri)) || (!com.tencent.mm.vfs.i.eK(paramUri))) {
        i = 0;
      }
      while (i == 0)
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
        fq(3, 3402);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(3402);
        AppMethodBeat.o(24391);
        return paramUri;
        paramArrayOfString1 = new com.tencent.mm.plugin.sight.base.d();
        if (SightVideoJNI.isSightOkVFS(paramUri, paramArrayOfString1.wri, paramArrayOfString1.wrj, paramArrayOfString1.wrk, paramArrayOfString1.wrm, paramArrayOfString1.wrl, paramArrayOfString1.wrl.length) == 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.addFlags(67108864);
      paramArrayOfString1.putExtra("sight_local_path", paramUri);
      com.tencent.mm.bs.d.e(this.context, ".ui.transmit.SightForwardUI", paramArrayOfString1);
      Y(12, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 35: 
      ad.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (bt.isNullOrNil(paramArrayOfString2[0])))
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
        fq(3, 3201);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(3201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      ad.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", new Object[] { paramUri });
      i = new com.tencent.mm.plugin.ext.b.c(this.context, paramUri).ceT();
      ad.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", new Object[] { Integer.valueOf(i) });
      if (i != -1)
      {
        Y(14, 0, i);
        i = 0;
      }
      for (;;)
      {
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(i);
        AppMethodBeat.o(24391);
        return paramUri;
        Y(15, 0, i);
      }
    case 36: 
      ad.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
        fq(3, 3301);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(3301);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      i = bt.getInt(paramArrayOfString2[1], -1);
      paramArrayOfString1 = paramArrayOfString2[2];
      ad.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", new Object[] { paramUri, Integer.valueOf(i), paramArrayOfString1 });
      if ((bt.isNullOrNil(paramUri)) || (i < 0) || (bt.isNullOrNil(paramArrayOfString1)))
      {
        ad.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
        fq(3, 3302);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(3302);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramString1 = new ul();
      paramString1.dAb.dAc = paramUri;
      paramString1.dAb.dAd = i;
      paramString1.dAb.dyq = paramArrayOfString1;
      paramString1.dAb.bNK = com.tencent.mm.pluginsdk.a.i(paramUri, this.context);
      com.tencent.mm.sdk.b.a.ESL.l(paramString1);
      Y(16, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 37: 
      ad.d("MicroMsg.ExtControlProviderOpenApi", "getWifiList");
      this.handler = new ap(Looper.getMainLooper());
      paramUri = (MatrixCursor)new ExtControlProviderOpenApi.2(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        Y(19, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(14);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      Y(18, 0, 1);
      ad.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
      AppMethodBeat.o(24391);
      return paramUri;
    case 38: 
      ad.d("MicroMsg.ExtControlProviderOpenApi", "connectWifi");
      this.handler = new ap(Looper.getMainLooper());
      paramUri = (Integer)new ExtControlProviderOpenApi.3(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        Y(21, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(14);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      Y(20, 0, paramUri.intValue());
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(paramUri.intValue());
      AppMethodBeat.o(24391);
      return paramUri;
    case 42: 
      paramUri = new Intent();
      paramUri.addFlags(131072);
      paramUri.putExtra("key_from_scene", 4);
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0) && (paramArrayOfString2[0].length() > 0))
      {
        ad.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", new Object[] { paramArrayOfString2[0], paramArrayOfString1 });
        paramUri.putExtra("key_business_attach", paramArrayOfString2[0]);
      }
      for (;;)
      {
        paramUri.putExtra("key_appid", paramArrayOfString1);
        com.tencent.mm.bs.d.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", paramUri);
        com.tencent.mm.plugin.report.service.h.vKh.f(12097, new Object[] { Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        Y(24, 0, 1);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
        AppMethodBeat.o(24391);
        return paramUri;
        ad.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", new Object[] { paramArrayOfString1 });
      }
    case 40: 
      ad.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
        Y(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(2);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      l1 = bt.getLong(paramArrayOfString2[0], -1L);
      long l2 = bt.getLong(paramArrayOfString2[1], -1L);
      long l3 = bt.getLong(paramArrayOfString2[2], -1L);
      ad.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
      if ((l2 < 0L) || (l1 < 0L) || (l3 < 0L))
      {
        ad.i("MicroMsg.ExtControlProviderOpenApi", "param err");
        Y(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(2);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ceU();
      paramUri = new fw();
      paramUri.diH.action = 2;
      paramUri.diH.diJ = l2;
      paramUri.diH.diK = l1;
      paramUri.diH.bfb = l3;
      if ((com.tencent.mm.sdk.b.a.ESL.l(paramUri)) && (paramUri.diI.diM))
      {
        Y(22, 0, paramUri.diI.diN);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(paramUri.diI.diN);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      Y(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(8);
      AppMethodBeat.o(24391);
      return paramUri;
    case 41: 
      ad.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
      ceU();
      paramUri = new fw();
      paramUri.diH.action = 3;
      if ((com.tencent.mm.sdk.b.a.ESL.l(paramUri)) && (paramUri.diI.diM))
      {
        paramArrayOfString1 = paramUri.diI.diL;
        paramString1 = new MatrixCursor(pKB);
        paramString1.addRow(new Object[] { Integer.valueOf(paramUri.diI.diN), bt.nullAsNil(paramArrayOfString1) });
        Y(22, 0, paramUri.diI.diN);
        ad.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(paramUri.diI.diN) });
        AppMethodBeat.o(24391);
        return paramString1;
      }
      Y(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(8);
      AppMethodBeat.o(24391);
      return paramUri;
    case 46: 
      ad.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", new Object[] { paramArrayOfString1 });
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        Y(27, 5, 4);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4101);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = new Intent();
      paramUri.putExtra("key_from_openapi", true);
      paramUri.putExtra("key_openapi_appid", paramArrayOfString1);
      com.tencent.mm.bs.d.b(this.context, "clean", ".ui.CleanUI", paramUri);
      Y(26, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 48: 
      com.tencent.mm.plugin.ext.d.e.cfi().mContext = this.context;
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
      {
        ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      i = bt.getInt(paramArrayOfString2[0], -1);
      if ((i < 0) || ((i != 0) && (i != 1) && (i != 2)))
      {
        ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
        Y(32, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramArrayOfString1 = null;
      if ((i == 0) || (i == 1))
      {
        if (paramArrayOfString2.length < 2)
        {
          ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4205);
          AppMethodBeat.o(24391);
          return paramUri;
        }
        paramUri = paramArrayOfString2[1];
        if (i == 1)
        {
          if (paramArrayOfString2.length < 3)
          {
            ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4208);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramArrayOfString1 = paramArrayOfString2[2];
        }
      }
      break;
    }
    for (;;)
    {
      ad.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", new Object[] { Integer.valueOf(i), paramUri });
      switch (i)
      {
      default: 
        AppMethodBeat.o(24391);
        return null;
      case 0: 
        paramString1 = com.tencent.mm.plugin.ext.d.e.cfi();
        if (bt.isNullOrNil(paramUri))
        {
          ad.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
          com.tencent.mm.plugin.ext.d.e.X(null, -1, 4205);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4205);
          AppMethodBeat.o(24391);
          return paramUri;
        }
        paramArrayOfString1 = com.tencent.mm.plugin.ext.d.c.XB(paramUri);
        if ((paramArrayOfString1 != null) && (!bt.isNullOrNil(paramArrayOfString1.url)))
        {
          ad.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramArrayOfString1 });
          paramUri = paramArrayOfString1;
        }
        break;
      }
      for (;;)
      {
        if (paramUri.type == 19)
        {
          if (com.tencent.mm.plugin.ext.d.c.XD(paramUri.url))
          {
            ad.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url.toUpperCase() });
            com.tencent.mm.plugin.ext.d.e.X(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.aAz(paramUri.url);
            AppMethodBeat.o(24391);
            return paramUri;
            paramUri = com.tencent.mm.plugin.ext.d.e.aV(paramUri, false);
            if (paramUri == null)
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
              com.tencent.mm.plugin.ext.d.e.X(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4206);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramUri = paramString1.a(paramUri);
            if ((paramUri == null) || (bt.isNullOrNil(paramUri.url)))
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4203);
              AppMethodBeat.o(24391);
              return paramUri;
            }
          }
          else
          {
            if (com.tencent.mm.plugin.ext.d.c.XC(paramUri.url))
            {
              ad.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", new Object[] { paramUri.url });
              com.tencent.mm.plugin.ext.d.e.X(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            l1 = bt.GC();
            paramArrayOfString1 = com.tencent.mm.plugin.ext.d.c.XE(paramUri.url);
            ad.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", new Object[] { paramArrayOfString1.toString(), Long.valueOf(bt.aS(l1)) });
            if (paramArrayOfString1 == b.b.pLN)
            {
              com.tencent.mm.plugin.ext.d.c.Xz(paramUri.url);
              com.tencent.mm.plugin.ext.d.e.X(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (paramArrayOfString1 != b.b.pLM)
            {
              paramArrayOfString1 = paramUri.url;
              i = paramUri.type;
              int j = paramUri.pMb;
              ad.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", new Object[] { paramArrayOfString1 });
              l1 = System.currentTimeMillis();
              paramArrayOfString1 = (Boolean)new e.2(paramString1, Boolean.TRUE, paramArrayOfString1, i, j).b(com.tencent.mm.plugin.ext.d.e.cfk());
              ad.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", new Object[] { paramArrayOfString1, Long.valueOf(System.currentTimeMillis() - l1) });
              if (paramArrayOfString1.booleanValue())
              {
                com.tencent.mm.plugin.ext.d.c.Xz(paramUri.url);
                com.tencent.mm.plugin.ext.d.e.X(paramUri.url, paramUri.type, 1);
                paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
                AppMethodBeat.o(24391);
                return paramUri;
              }
            }
            com.tencent.mm.plugin.ext.d.c.XA(paramUri.url);
            ad.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.d.e.X(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.aAz(paramUri.url);
            AppMethodBeat.o(24391);
            return paramUri;
          }
        }
        else
        {
          ad.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
          AppMethodBeat.o(24391);
          return paramUri;
          paramArrayOfString2 = com.tencent.mm.plugin.ext.d.e.cfi();
          if (bt.isNullOrNil(paramUri))
          {
            ad.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
            com.tencent.mm.plugin.ext.d.e.Y(null, -1, 4205);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4205);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramString1 = com.tencent.mm.plugin.ext.d.c.XB(paramUri);
          if ((paramString1 != null) && (!bt.isNullOrNil(paramString1.url))) {
            ad.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramString1 });
          }
          for (paramUri = paramString1; (paramUri.type == 19) && (com.tencent.mm.plugin.ext.d.c.XD(paramUri.url)); paramUri = paramArrayOfString1)
          {
            ad.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4207);
            AppMethodBeat.o(24391);
            return paramUri;
            if (bt.isNullOrNil(paramArrayOfString1))
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
              com.tencent.mm.plugin.ext.d.e.Y(null, -1, 4208);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4208);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramString1 = com.tencent.mm.plugin.ext.d.e.aV(paramUri, true);
            if (paramString1 == null)
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
              com.tencent.mm.plugin.ext.d.e.Y(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4206);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (bt.isNullOrNil(paramString1.md5))
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
              com.tencent.mm.plugin.ext.d.e.Y(null, -1, 4210);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4210);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (!paramString1.md5.equalsIgnoreCase(paramArrayOfString1))
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
              com.tencent.mm.plugin.ext.d.e.Y(null, -1, 4209);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4209);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramArrayOfString1 = paramArrayOfString2.a(paramString1);
            if ((paramArrayOfString1 == null) || (bt.isNullOrNil(paramArrayOfString1.url)))
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              com.tencent.mm.plugin.ext.d.e.Y(null, -1, 4203);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(4203);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            com.tencent.mm.plugin.ext.d.c.a(paramUri, paramArrayOfString1);
          }
          ad.i("MicroMsg.ExtQrCodeHandler", "hy: do open");
          ad.i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", new Object[] { paramUri.toString() });
          paramArrayOfString1 = new Intent(paramArrayOfString2.mContext, RedirectToQrCodeStubUI.class);
          paramArrayOfString1.putExtra("K_STR", paramUri.url);
          paramArrayOfString1.putExtra("K_TYPE", paramUri.type);
          paramArrayOfString1.putExtra("K_VERSION", paramUri.pMb);
          paramArrayOfString1.addFlags(268435456);
          paramString1 = paramArrayOfString2.mContext;
          paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramArrayOfString1);
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramArrayOfString1.adn(), "com/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler", "handleOpen", "(Lcom/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler$QrCodeModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramArrayOfString1.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler", "handleOpen", "(Lcom/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler$QrCodeModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 1);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
          AppMethodBeat.o(24391);
          return paramUri;
          com.tencent.mm.plugin.ext.d.e.cfi();
          paramUri = com.tencent.mm.plugin.ext.d.e.cfj();
          AppMethodBeat.o(24391);
          return paramUri;
          paramUri = a(paramArrayOfString2, false);
          AppMethodBeat.o(24391);
          return paramUri;
          if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
          {
            ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(2);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramUri = u(new String[] { paramArrayOfString2[0], "0" });
          AppMethodBeat.o(24391);
          return paramUri;
          paramUri = u(paramArrayOfString2);
          AppMethodBeat.o(24391);
          return paramUri;
          this.handler = new ap(Looper.getMainLooper());
          paramUri = (Cursor)new bo(com.tencent.mm.pluginsdk.d.a.a.Ue(4302), paramArrayOfString2) {}.b(this.handler);
          AppMethodBeat.o(24391);
          return paramUri;
        }
      }
      continue;
      paramUri = null;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi
 * JD-Core Version:    0.7.0.1
 */