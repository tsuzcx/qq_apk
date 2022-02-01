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
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.a.ga.b;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.ext.d.b.b;
import com.tencent.mm.plugin.ext.d.d.b;
import com.tencent.mm.plugin.ext.d.e.2;
import com.tencent.mm.plugin.ext.d.e.a;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storage.ck;
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
  private static final String[] rcV = { "retCode", "selfId" };
  private static final String[] rcW = { "retCode", "sportConfig" };
  private static final String[] rcX = { "openid", "avatar" };
  private static final String[] rcY = { "voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath" };
  private static final String[] rcZ = { "ssid", "macAddress", "isSupportWechat", "name" };
  private static final String[] rda = { "username", "appId", "versionType", "nickname", "shortNickname", "iconURL", "collection", "runningFlag", "wechatPkg", "action", "intentInfo" };
  private static final String[] rdb = { "token", "nickname", "iconURL" };
  private String appId = "";
  private Context context;
  private ap handler;
  private String[] rdc = null;
  private int rdd = -1;
  
  private ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.rdc = paramArrayOfString;
    this.rdd = paramInt;
    this.context = paramContext;
  }
  
  public ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext, String paramString)
  {
    this(paramArrayOfString, paramInt, paramContext);
    this.appId = paramString;
  }
  
  private Cursor X(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(24395);
    ad.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", new Object[] { paramString1, paramString2, paramString3 });
      fB(3, 2004);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Yf(2004);
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
        fB(3, 2005);
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Yf(2005);
        AppMethodBeat.o(24395);
        return paramString1;
      }
      if (com.tencent.mm.plugin.ext.b.crX().aUm(this.rdo) == null)
      {
        paramString1 = new by();
        paramString1.field_appId = this.rdo;
        paramString1.field_packageName = csj();
        paramString2 = this.rdo;
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
          bool = com.tencent.mm.plugin.ext.b.crX().insert(paramString1);
          ad.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", new Object[] { Boolean.valueOf(bool), csj(), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(paramString1.field_status) });
          if (bool) {
            break label415;
          }
          paramString1 = com.tencent.mm.pluginsdk.d.a.a.Yf(2006);
          AppMethodBeat.o(24395);
          return paramString1;
          bool = com.tencent.mm.pluginsdk.model.app.h.n(com.tencent.mm.pluginsdk.model.app.h.m(paramString2, true, false));
          break;
        }
        ab(1, 4, 12);
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
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Yf(12);
      AppMethodBeat.o(24395);
      return paramString1;
      ad.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", new Object[] { this.rdo, csj() });
      label415:
      paramString1 = new StringBuilder().append(u.aAm());
      ba.aBQ();
      paramString1 = com.tencent.mm.sdk.platformtools.ai.ee(com.tencent.mm.model.c.getUin());
      paramString2 = new MatrixCursor(rcV);
      try
      {
        paramString2.addRow(new Object[] { Integer.valueOf(1), bt.nullAsNil(paramString1) });
        ab(0, 0, 1);
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
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(2);
      AppMethodBeat.o(24393);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor;
    if (paramBoolean) {
      localMatrixCursor = new MatrixCursor(rdb);
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
          paramArrayOfString = ((com.tencent.mm.plugin.appbrand.appusage.ai)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appusage.ai.class)).dE(i, 0);
          Iterator localIterator = com.tencent.luggage.h.b.C(paramArrayOfString).iterator();
          if (!localIterator.hasNext()) {
            break label935;
          }
          localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
          localObject1 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nu(localLocalUsageInfo.appId);
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
          i = localLocalUsageInfo.hQh;
          localObject6 = ((WxaAttributes)localObject1).field_username;
          String str1 = ((WxaAttributes)localObject1).field_nickname;
          String str2 = ((WxaAttributes)localObject1).field_appId;
          com.tencent.mm.kernel.g.ajA();
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
          localMatrixCursor = new MatrixCursor(rda);
          continue;
        }
        paramArrayOfString = ((com.tencent.mm.plugin.appbrand.appusage.ai)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appusage.ai.class)).rY(i);
      }
      catch (NumberFormatException paramArrayOfString)
      {
        ad.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(2);
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
          k = localLocalUsageInfo.hQh;
          localObject5 = localLocalUsageInfo.nickname;
          localObject6 = localLocalUsageInfo.cmD;
          localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;
          if (localLocalUsageInfo.jQa) {}
          for (i = 1;; i = 0)
          {
            localMatrixCursor.addRow(new Object[] { localObject3, localObject4, Integer.valueOf(k), localObject5, localObject6, localObject1, Integer.valueOf(i), Long.valueOf(localLocalUsageInfo.cnh), paramArrayOfString.getPackage(), paramArrayOfString.getAction(), new com.tencent.mm.ac.i((Map)localObject2).toString() });
            break;
          }
          label614:
          paramArrayOfString = new StringBuilder().append(localLocalUsageInfo.username).append(",");
          com.tencent.mm.kernel.g.ajA();
          paramArrayOfString = (com.tencent.mm.kernel.a.getUin() + "," + this.rdo).getBytes();
          try
          {
            localObject2 = MessageDigest.getInstance("SHA-256");
            ((MessageDigest)localObject2).update(paramArrayOfString);
            paramArrayOfString = String.format("%064x", new Object[] { new BigInteger(1, ((MessageDigest)localObject2).digest()) });
            localObject2 = com.tencent.mm.plugin.ext.b.crZ();
            localObject3 = localLocalUsageInfo.username;
            com.tencent.mm.kernel.g.ajA();
            i = com.tencent.mm.kernel.a.getUin();
            localObject4 = this.rdo;
            d.g.b.p.h(paramArrayOfString, "token");
            d.g.b.p.h(localObject3, "userName");
            d.g.b.p.h(localObject4, "appid");
            localObject5 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject5, "MMKernel.storage()");
            localObject5 = ((com.tencent.mm.kernel.e)localObject5).gBq.query(((com.tencent.mm.plugin.ext.a.a)localObject2).getTableName(), null, null, null, null, null, null);
            localObject6 = new StringBuilder();
            d.g.b.p.g(localObject5, "query");
            ((StringBuilder)localObject6).append(((Cursor)localObject5).getColumnNames());
            com.tencent.d.f.h.fUh();
            localObject5 = new com.tencent.mm.plugin.ext.a.b();
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_token = paramArrayOfString;
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_username = ((String)localObject3);
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_uin = i;
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_appid = ((String)localObject4);
            if (((com.tencent.mm.plugin.ext.a.a)localObject2).afG(paramArrayOfString) != null)
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
    com.tencent.mm.plugin.report.service.g.yhR.f(18601, new Object[] { this.rdo, Integer.valueOf(j), Integer.valueOf(localMatrixCursor.getCount()) });
    AppMethodBeat.o(24393);
    return localMatrixCursor;
  }
  
  private void csg()
  {
    AppMethodBeat.i(24398);
    String str1 = (String)com.tencent.mm.plugin.ext.b.crW().get(al.a.IvV, null);
    String str2 = csj();
    ad.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", new Object[] { str1, str2 });
    if (str1 != null)
    {
      if (!com.tencent.mm.compatible.loader.a.contains(str1.split(";"), str2)) {
        com.tencent.mm.plugin.ext.b.crW().set(al.a.IvV, str1 + ";" + csj());
      }
      AppMethodBeat.o(24398);
      return;
    }
    com.tencent.mm.plugin.ext.b.crW().set(al.a.IvV, csj());
    AppMethodBeat.o(24398);
  }
  
  private Cursor m(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(24394);
    ad.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", new Object[] { paramString1 });
    if (this.context == null)
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
      fB(4, 2001);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Yf(2001);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
      fB(3, 2002);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Yf(2002);
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
      paramString1 = X(paramString2, paramString3, paramString4);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    if (i == 2)
    {
      ad.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
      if (com.tencent.mm.plugin.ext.b.crX().aUm(this.rdo) == null)
      {
        ad.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", new Object[] { this.rdo, csj() });
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Yf(2007);
        AppMethodBeat.o(24394);
        return paramString1;
      }
      paramString1 = com.tencent.mm.plugin.ext.b.crX();
      paramString2 = this.rdo;
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        bool = false;
      }
      for (;;)
      {
        ad.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", new Object[] { Boolean.valueOf(bool), this.rdo, csj() });
        if (bool) {
          break;
        }
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Yf(2008);
        AppMethodBeat.o(24394);
        return paramString1;
        if (paramString1.db.delete("OpenMsgListener", "appId=?", new String[] { bt.aQN(paramString2) }) <= 0) {
          bool = false;
        } else {
          bool = true;
        }
      }
      ab(0, 0, 1);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    ad.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", new Object[] { Integer.valueOf(i) });
    fB(3, 2003);
    paramString1 = com.tencent.mm.pluginsdk.d.a.a.Yf(2003);
    AppMethodBeat.o(24394);
    return paramString1;
  }
  
  private Cursor v(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24392);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(2);
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
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(2);
        AppMethodBeat.o(24392);
        return paramArrayOfString;
      }
      catch (NumberFormatException paramArrayOfString)
      {
        ad.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(2);
        AppMethodBeat.o(24392);
        return paramArrayOfString;
      }
      paramArrayOfString = paramArrayOfString;
      ad.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(2);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
    }
    for (;;)
    {
      label134:
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
      if (2 != i) {
        break;
      }
      ((com.tencent.mm.plugin.appbrand.service.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.k.class)).V(this.context, this.appId);
    }
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(2);
    AppMethodBeat.o(24392);
    return paramArrayOfString;
  }
  
  private Cursor w(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24396);
    ad.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
      fB(3, 3001);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(3001);
      AppMethodBeat.o(24396);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(rcX);
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
        localObject = com.tencent.mm.plugin.ext.b.crY().aUy(paramArrayOfString[i]);
        if ((localObject == null) || (bt.isNullOrNil(((cj)localObject).field_openId)) || (bt.isNullOrNil(((cj)localObject).field_username)))
        {
          ad.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
        }
        else
        {
          ba.aBQ();
          localObject = com.tencent.mm.model.c.azp().Bf(((cj)localObject).field_username);
          if ((localObject == null) || (((aw)localObject).field_username == null) || (((aw)localObject).field_username.length() <= 0)) {
            ad.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", new Object[] { paramArrayOfString.getMessage() });
        ab(7, 4, 12);
        localMatrixCursor.close();
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(12);
        AppMethodBeat.o(24396);
        return paramArrayOfString;
      }
      com.tencent.mm.ak.p.aEk();
      Object localObject = com.tencent.mm.ak.e.K(((aw)localObject).field_username, false);
      if (bt.isNullOrNil((String)localObject))
      {
        ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
      }
      else
      {
        if (((String)localObject).startsWith(com.tencent.mm.kernel.g.ajC().cachePath))
        {
          int j = com.tencent.mm.kernel.g.ajC().cachePath.length();
          String str = com.tencent.mm.kernel.g.ajC().gBm + ((String)localObject).substring(j);
          com.tencent.mm.vfs.i.aYg(com.tencent.mm.vfs.i.aYr(str));
          com.tencent.mm.vfs.i.mz((String)localObject, str);
          localObject = str;
        }
        for (;;)
        {
          e.b.Df((String)localObject);
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], localObject });
          break;
          label377:
          ab(6, 0, 1);
          AppMethodBeat.o(24396);
          return localMatrixCursor;
        }
      }
      label397:
      i += 1;
    }
  }
  
  private Cursor x(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24397);
    ad.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (paramArrayOfString[0].length() <= 0))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
      fB(3, 3101);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(3101);
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
                localObject1 = new MatrixCursor(rcY);
              }
              localObject4 = localObject1;
              localk = new com.tencent.mm.modelvoice.k();
              localObject4 = localObject1;
              str1 = com.tencent.mm.plugin.ext.b.csb() + "/" + com.tencent.mm.sdk.platformtools.ai.ee(str2);
              localObject4 = localObject1;
              ad.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", new Object[] { str1 });
              localObject4 = localObject1;
              if (com.tencent.mm.vfs.i.aYo(str1) > 0L)
              {
                localObject4 = localObject1;
                ad.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                localObject3 = str1;
                localObject4 = localObject1;
                if (com.tencent.mm.vfs.i.aYo(str1) == 0L)
                {
                  localObject4 = localObject1;
                  localObject3 = localk.bz(str2, str1);
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
          localObject3 = localk.bz(str2, str1);
        }
        localObject4 = localObject2;
        ad.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", new Object[] { Integer.valueOf(i) });
        localObject4 = localObject2;
        localObject2.addRow(new Object[] { Integer.valueOf(1), Integer.valueOf(localk.mSampleRate), Integer.valueOf(localk.dhl), Integer.valueOf(2), localObject3 });
      }
      else
      {
        if (localObject3 != null)
        {
          ab(8, 0, 1);
          AppMethodBeat.o(24397);
          return localObject3;
        }
        ab(9, 3, 4);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Yf(4);
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
    ad.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", new Object[] { Integer.valueOf(this.rdd) });
    a(paramUri, this.context, this.rdd, this.rdc);
    paramArrayOfString1 = this.rdo;
    if (paramUri == null)
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
      fB(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(5);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (bt.isNullOrNil(this.rdo))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
      fB(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(7);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (bt.isNullOrNil(csj()))
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
      fB(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(6);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (!bMn())
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
      fB(1, 3);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(3);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    int i = 1;
    if (!IS_DEBUG) {
      i = csk();
    }
    if (i != 1)
    {
      ad.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = ".concat(String.valueOf(i)));
      fB(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(i);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    long l1;
    switch (this.rdd)
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
      fB(3, 15);
      AppMethodBeat.o(24391);
      return null;
    case 22: 
      paramUri = m(paramUri.getQueryParameter("op"), paramUri.getQueryParameter("scene"), paramUri.getQueryParameter("msgType"), paramUri.getQueryParameter("msgState"));
      AppMethodBeat.o(24391);
      return paramUri;
    case 23: 
      paramUri = w(paramArrayOfString2);
      AppMethodBeat.o(24391);
      return paramUri;
    case 25: 
      paramUri = x(paramArrayOfString2);
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
          fB(3, 3401);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(3401);
          AppMethodBeat.o(24391);
          return paramUri;
        }
      }
      paramUri = paramArrayOfString2[0];
      if ((bt.isNullOrNil(paramUri)) || (!com.tencent.mm.vfs.i.fv(paramUri))) {
        i = 0;
      }
      while (i == 0)
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
        fB(3, 3402);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(3402);
        AppMethodBeat.o(24391);
        return paramUri;
        paramArrayOfString1 = new com.tencent.mm.plugin.sight.base.d();
        if (SightVideoJNI.isSightOkVFS(paramUri, paramArrayOfString1.yRi, paramArrayOfString1.yRj, paramArrayOfString1.yRk, paramArrayOfString1.yRm, paramArrayOfString1.yRl, paramArrayOfString1.yRl.length) == 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.addFlags(67108864);
      paramArrayOfString1.putExtra("sight_local_path", paramUri);
      com.tencent.mm.bs.d.f(this.context, ".ui.transmit.SightForwardUI", paramArrayOfString1);
      ab(12, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 35: 
      ad.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (bt.isNullOrNil(paramArrayOfString2[0])))
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
        fB(3, 3201);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(3201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      ad.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", new Object[] { paramUri });
      i = new com.tencent.mm.plugin.ext.b.c(this.context, paramUri).csf();
      ad.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", new Object[] { Integer.valueOf(i) });
      if (i != -1)
      {
        ab(14, 0, i);
        i = 0;
      }
      for (;;)
      {
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(i);
        AppMethodBeat.o(24391);
        return paramUri;
        ab(15, 0, i);
      }
    case 36: 
      ad.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
        fB(3, 3301);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(3301);
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
        fB(3, 3302);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(3302);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramString1 = new vo();
      paramString1.dKa.dKb = paramUri;
      paramString1.dKa.dKc = i;
      paramString1.dKa.dIm = paramArrayOfString1;
      paramString1.dKa.bVF = com.tencent.mm.pluginsdk.b.i(paramUri, this.context);
      com.tencent.mm.sdk.b.a.IbL.l(paramString1);
      ab(16, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 37: 
      ad.d("MicroMsg.ExtControlProviderOpenApi", "getWifiList");
      this.handler = new ap(Looper.getMainLooper());
      paramUri = (MatrixCursor)new ExtControlProviderOpenApi.2(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        ab(19, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(14);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ab(18, 0, 1);
      ad.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
      AppMethodBeat.o(24391);
      return paramUri;
    case 38: 
      ad.d("MicroMsg.ExtControlProviderOpenApi", "connectWifi");
      this.handler = new ap(Looper.getMainLooper());
      paramUri = (Integer)new ExtControlProviderOpenApi.3(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        ab(21, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(14);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ab(20, 0, paramUri.intValue());
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(paramUri.intValue());
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
        com.tencent.mm.plugin.report.service.g.yhR.f(12097, new Object[] { Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        ab(24, 0, 1);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
        AppMethodBeat.o(24391);
        return paramUri;
        ad.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", new Object[] { paramArrayOfString1 });
      }
    case 40: 
      ad.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
        ab(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(2);
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
        ab(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(2);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      csg();
      paramUri = new ga();
      paramUri.dry.action = 2;
      paramUri.dry.drA = l2;
      paramUri.dry.drB = l1;
      paramUri.dry.bqh = l3;
      if ((com.tencent.mm.sdk.b.a.IbL.l(paramUri)) && (paramUri.drz.drD))
      {
        ab(22, 0, paramUri.drz.drE);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(paramUri.drz.drE);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ab(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(8);
      AppMethodBeat.o(24391);
      return paramUri;
    case 41: 
      ad.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
      csg();
      paramUri = new ga();
      paramUri.dry.action = 3;
      if ((com.tencent.mm.sdk.b.a.IbL.l(paramUri)) && (paramUri.drz.drD))
      {
        paramArrayOfString1 = paramUri.drz.drC;
        paramString1 = new MatrixCursor(rcW);
        paramString1.addRow(new Object[] { Integer.valueOf(paramUri.drz.drE), bt.nullAsNil(paramArrayOfString1) });
        ab(22, 0, paramUri.drz.drE);
        ad.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(paramUri.drz.drE) });
        AppMethodBeat.o(24391);
        return paramString1;
      }
      ab(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(8);
      AppMethodBeat.o(24391);
      return paramUri;
    case 46: 
      ad.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", new Object[] { paramArrayOfString1 });
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        ab(27, 5, 4);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4101);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = new Intent();
      paramUri.putExtra("key_from_openapi", true);
      paramUri.putExtra("key_openapi_appid", paramArrayOfString1);
      com.tencent.mm.bs.d.b(this.context, "clean", ".ui.CleanUI", paramUri);
      ab(26, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 48: 
      com.tencent.mm.plugin.ext.d.e.csu().mContext = this.context;
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
      {
        ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      i = bt.getInt(paramArrayOfString2[0], -1);
      if ((i < 0) || ((i != 0) && (i != 1) && (i != 2)))
      {
        ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
        ab(32, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramArrayOfString1 = null;
      if ((i == 0) || (i == 1))
      {
        if (paramArrayOfString2.length < 2)
        {
          ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4205);
          AppMethodBeat.o(24391);
          return paramUri;
        }
        paramUri = paramArrayOfString2[1];
        if (i == 1)
        {
          if (paramArrayOfString2.length < 3)
          {
            ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4208);
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
        paramString1 = com.tencent.mm.plugin.ext.d.e.csu();
        if (bt.isNullOrNil(paramUri))
        {
          ad.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
          com.tencent.mm.plugin.ext.d.e.Y(null, -1, 4205);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4205);
          AppMethodBeat.o(24391);
          return paramUri;
        }
        paramArrayOfString1 = com.tencent.mm.plugin.ext.d.c.afN(paramUri);
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
          if (com.tencent.mm.plugin.ext.d.c.afP(paramUri.url))
          {
            ad.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url.toUpperCase() });
            com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.aLr(paramUri.url);
            AppMethodBeat.o(24391);
            return paramUri;
            paramUri = com.tencent.mm.plugin.ext.d.e.aY(paramUri, false);
            if (paramUri == null)
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
              com.tencent.mm.plugin.ext.d.e.Y(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4206);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramUri = paramString1.a(paramUri);
            if ((paramUri == null) || (bt.isNullOrNil(paramUri.url)))
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4203);
              AppMethodBeat.o(24391);
              return paramUri;
            }
          }
          else
          {
            if (com.tencent.mm.plugin.ext.d.c.afO(paramUri.url))
            {
              ad.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", new Object[] { paramUri.url });
              com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            l1 = bt.HI();
            paramArrayOfString1 = com.tencent.mm.plugin.ext.d.c.afQ(paramUri.url);
            ad.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", new Object[] { paramArrayOfString1.toString(), Long.valueOf(bt.aO(l1)) });
            if (paramArrayOfString1 == b.b.rej)
            {
              com.tencent.mm.plugin.ext.d.c.afL(paramUri.url);
              com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (paramArrayOfString1 != b.b.rei)
            {
              paramArrayOfString1 = paramUri.url;
              i = paramUri.type;
              int j = paramUri.rez;
              ad.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", new Object[] { paramArrayOfString1 });
              l1 = System.currentTimeMillis();
              paramArrayOfString1 = (Boolean)new e.2(paramString1, Boolean.TRUE, paramArrayOfString1, i, j).b(com.tencent.mm.plugin.ext.d.e.csw());
              ad.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", new Object[] { paramArrayOfString1, Long.valueOf(System.currentTimeMillis() - l1) });
              if (paramArrayOfString1.booleanValue())
              {
                com.tencent.mm.plugin.ext.d.c.afL(paramUri.url);
                com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 1);
                paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
                AppMethodBeat.o(24391);
                return paramUri;
              }
            }
            com.tencent.mm.plugin.ext.d.c.afM(paramUri.url);
            ad.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.aLr(paramUri.url);
            AppMethodBeat.o(24391);
            return paramUri;
          }
        }
        else
        {
          ad.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
          AppMethodBeat.o(24391);
          return paramUri;
          paramArrayOfString2 = com.tencent.mm.plugin.ext.d.e.csu();
          if (bt.isNullOrNil(paramUri))
          {
            ad.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
            com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4205);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4205);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramString1 = com.tencent.mm.plugin.ext.d.c.afN(paramUri);
          if ((paramString1 != null) && (!bt.isNullOrNil(paramString1.url))) {
            ad.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramString1 });
          }
          for (paramUri = paramString1; (paramUri.type == 19) && (com.tencent.mm.plugin.ext.d.c.afP(paramUri.url)); paramUri = paramArrayOfString1)
          {
            ad.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.d.e.Z(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4207);
            AppMethodBeat.o(24391);
            return paramUri;
            if (bt.isNullOrNil(paramArrayOfString1))
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4208);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4208);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramString1 = com.tencent.mm.plugin.ext.d.e.aY(paramUri, true);
            if (paramString1 == null)
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4206);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (bt.isNullOrNil(paramString1.md5))
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4210);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4210);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (!paramString1.md5.equalsIgnoreCase(paramArrayOfString1))
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4209);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4209);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramArrayOfString1 = paramArrayOfString2.a(paramString1);
            if ((paramArrayOfString1 == null) || (bt.isNullOrNil(paramArrayOfString1.url)))
            {
              ad.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4203);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(4203);
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
          paramArrayOfString1.putExtra("K_VERSION", paramUri.rez);
          paramArrayOfString1.addFlags(268435456);
          paramString1 = paramArrayOfString2.mContext;
          paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramArrayOfString1);
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramArrayOfString1.ahp(), "com/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler", "handleOpen", "(Lcom/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler$QrCodeModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramArrayOfString1.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler", "handleOpen", "(Lcom/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler$QrCodeModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.ext.d.e.Z(paramUri.url, paramUri.type, 1);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
          AppMethodBeat.o(24391);
          return paramUri;
          com.tencent.mm.plugin.ext.d.e.csu();
          paramUri = com.tencent.mm.plugin.ext.d.e.csv();
          AppMethodBeat.o(24391);
          return paramUri;
          paramUri = a(paramArrayOfString2, false);
          AppMethodBeat.o(24391);
          return paramUri;
          if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
          {
            ad.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Yf(2);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramUri = v(new String[] { paramArrayOfString2[0], "0" });
          AppMethodBeat.o(24391);
          return paramUri;
          paramUri = v(paramArrayOfString2);
          AppMethodBeat.o(24391);
          return paramUri;
          this.handler = new ap(Looper.getMainLooper());
          paramUri = (Cursor)new bo(com.tencent.mm.pluginsdk.d.a.a.Yf(4302), paramArrayOfString2) {}.b(this.handler);
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