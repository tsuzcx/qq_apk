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
import com.tencent.mm.aj.e.b;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.fx.b;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.ext.d.b.b;
import com.tencent.mm.plugin.ext.d.d.b;
import com.tencent.mm.plugin.ext.d.e.2;
import com.tencent.mm.plugin.ext.d.e.a;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
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
  private static final String[] qth = { "retCode", "selfId" };
  private static final String[] qti = { "retCode", "sportConfig" };
  private static final String[] qtj = { "openid", "avatar" };
  private static final String[] qtk = { "voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath" };
  private static final String[] qtl = { "ssid", "macAddress", "isSupportWechat", "name" };
  private static final String[] qtm = { "username", "appId", "versionType", "nickname", "shortNickname", "iconURL", "collection", "runningFlag", "wechatPkg", "action", "intentInfo" };
  private static final String[] qtn = { "token", "nickname", "iconURL" };
  private String appId = "";
  private Context context;
  private ao handler;
  private String[] qto = null;
  private int qtp = -1;
  
  private ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.qto = paramArrayOfString;
    this.qtp = paramInt;
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
    ac.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
    if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString1)) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString2)) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString3)))
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", new Object[] { paramString1, paramString2, paramString3 });
      ft(3, 2004);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Wo(2004);
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
        ac.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: ".concat(String.valueOf(i)));
        ft(3, 2005);
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Wo(2005);
        AppMethodBeat.o(24395);
        return paramString1;
      }
      if (com.tencent.mm.plugin.ext.b.cms().aOv(this.qtA) == null)
      {
        paramString1 = new com.tencent.mm.storage.bs();
        paramString1.field_appId = this.qtA;
        paramString1.field_packageName = cmE();
        paramString2 = this.qtA;
        boolean bool;
        if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString2))
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
          bool = com.tencent.mm.plugin.ext.b.cms().insert(paramString1);
          ac.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", new Object[] { Boolean.valueOf(bool), cmE(), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(paramString1.field_status) });
          if (bool) {
            break label415;
          }
          paramString1 = com.tencent.mm.pluginsdk.d.a.a.Wo(2006);
          AppMethodBeat.o(24395);
          return paramString1;
          bool = com.tencent.mm.pluginsdk.model.app.h.n(com.tencent.mm.pluginsdk.model.app.h.k(paramString2, true, false));
          break;
        }
        Z(1, 4, 12);
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = localObject;
    }
    for (;;)
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", new Object[] { paramString1.getMessage() });
      if (paramString2 != null) {
        paramString2.close();
      }
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Wo(12);
      AppMethodBeat.o(24395);
      return paramString1;
      ac.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", new Object[] { this.qtA, cmE() });
      label415:
      paramString1 = new StringBuilder().append(u.axw());
      az.ayM();
      paramString1 = com.tencent.mm.sdk.platformtools.ah.dg(com.tencent.mm.model.c.getUin());
      paramString2 = new MatrixCursor(qth);
      try
      {
        paramString2.addRow(new Object[] { Integer.valueOf(1), com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramString1) });
        Z(0, 0, 1);
        ac.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(1) });
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
      ac.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(2);
      AppMethodBeat.o(24393);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor;
    if (paramBoolean) {
      localMatrixCursor = new MatrixCursor(qtn);
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
          Iterator localIterator = com.tencent.luggage.h.b.C(paramArrayOfString).iterator();
          if (!localIterator.hasNext()) {
            break label935;
          }
          localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
          localObject1 = ((m)com.tencent.mm.kernel.g.ab(m.class)).Kb(localLocalUsageInfo.appId);
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
          localObject5 = com.tencent.mm.sdk.platformtools.ai.getPackageName();
          i = localLocalUsageInfo.hxM;
          localObject6 = ((WxaAttributes)localObject1).field_username;
          String str1 = ((WxaAttributes)localObject1).field_nickname;
          String str2 = ((WxaAttributes)localObject1).field_appId;
          com.tencent.mm.kernel.g.agP();
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
          localMatrixCursor = new MatrixCursor(qtm);
          continue;
        }
        paramArrayOfString = ((com.tencent.mm.plugin.appbrand.appusage.ai)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appusage.ai.class)).ry(i);
      }
      catch (NumberFormatException paramArrayOfString)
      {
        ac.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(2);
        AppMethodBeat.o(24393);
        return paramArrayOfString;
      }
      continue;
      label408:
      if (2 == j) {
        if (paramBoolean)
        {
          paramArrayOfString = ((com.tencent.mm.plugin.appbrand.appusage.ah)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appusage.ah.class)).a(i, null, 0);
        }
        else
        {
          paramArrayOfString = ((com.tencent.mm.plugin.appbrand.appusage.ah)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appusage.ah.class)).a(i, null);
          continue;
          label459:
          localObject3 = localLocalUsageInfo.username;
          localObject4 = localLocalUsageInfo.appId;
          k = localLocalUsageInfo.hxM;
          localObject5 = localLocalUsageInfo.nickname;
          localObject6 = localLocalUsageInfo.ccm;
          localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;
          if (localLocalUsageInfo.jwg) {}
          for (i = 1;; i = 0)
          {
            localMatrixCursor.addRow(new Object[] { localObject3, localObject4, Integer.valueOf(k), localObject5, localObject6, localObject1, Integer.valueOf(i), Long.valueOf(localLocalUsageInfo.ccQ), paramArrayOfString.getPackage(), paramArrayOfString.getAction(), new com.tencent.mm.ab.i((Map)localObject2).toString() });
            break;
          }
          label614:
          paramArrayOfString = new StringBuilder().append(localLocalUsageInfo.username).append(",");
          com.tencent.mm.kernel.g.agP();
          paramArrayOfString = (com.tencent.mm.kernel.a.getUin() + "," + this.qtA).getBytes();
          try
          {
            localObject2 = MessageDigest.getInstance("SHA-256");
            ((MessageDigest)localObject2).update(paramArrayOfString);
            paramArrayOfString = String.format("%064x", new Object[] { new BigInteger(1, ((MessageDigest)localObject2).digest()) });
            localObject2 = com.tencent.mm.plugin.ext.b.cmu();
            localObject3 = localLocalUsageInfo.username;
            com.tencent.mm.kernel.g.agP();
            i = com.tencent.mm.kernel.a.getUin();
            localObject4 = this.qtA;
            d.g.b.k.h(paramArrayOfString, "token");
            d.g.b.k.h(localObject3, "userName");
            d.g.b.k.h(localObject4, "appid");
            localObject5 = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(localObject5, "MMKernel.storage()");
            localObject5 = ((com.tencent.mm.kernel.e)localObject5).ghG.query(((com.tencent.mm.plugin.ext.a.a)localObject2).getTableName(), null, null, null, null, null, null);
            localObject6 = new StringBuilder();
            d.g.b.k.g(localObject5, "query");
            ((StringBuilder)localObject6).append(((Cursor)localObject5).getColumnNames());
            com.tencent.d.f.h.fCP();
            localObject5 = new com.tencent.mm.plugin.ext.a.b();
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_token = paramArrayOfString;
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_username = ((String)localObject3);
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_uin = i;
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_appid = ((String)localObject4);
            if (((com.tencent.mm.plugin.ext.a.a)localObject2).abR(paramArrayOfString) != null)
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
    com.tencent.mm.plugin.report.service.h.wUl.f(18601, new Object[] { this.qtA, Integer.valueOf(j), Integer.valueOf(localMatrixCursor.getCount()) });
    AppMethodBeat.o(24393);
    return localMatrixCursor;
  }
  
  private void cmB()
  {
    AppMethodBeat.i(24398);
    String str1 = (String)com.tencent.mm.plugin.ext.b.cmr().get(ah.a.GJD, null);
    String str2 = cmE();
    ac.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", new Object[] { str1, str2 });
    if (str1 != null)
    {
      if (!com.tencent.mm.compatible.loader.a.contains(str1.split(";"), str2)) {
        com.tencent.mm.plugin.ext.b.cmr().set(ah.a.GJD, str1 + ";" + cmE());
      }
      AppMethodBeat.o(24398);
      return;
    }
    com.tencent.mm.plugin.ext.b.cmr().set(ah.a.GJD, cmE());
    AppMethodBeat.o(24398);
  }
  
  private Cursor n(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(24394);
    ac.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", new Object[] { paramString1 });
    if (this.context == null)
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
      ft(4, 2001);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Wo(2001);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString1))
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
      ft(3, 2002);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Wo(2002);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    int i = -1;
    try
    {
      int j = com.tencent.mm.sdk.platformtools.bs.getInt(paramString1, -1);
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
      ac.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
      if (com.tencent.mm.plugin.ext.b.cms().aOv(this.qtA) == null)
      {
        ac.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", new Object[] { this.qtA, cmE() });
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Wo(2007);
        AppMethodBeat.o(24394);
        return paramString1;
      }
      paramString1 = com.tencent.mm.plugin.ext.b.cms();
      paramString2 = this.qtA;
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        bool = false;
      }
      for (;;)
      {
        ac.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", new Object[] { Boolean.valueOf(bool), this.qtA, cmE() });
        if (bool) {
          break;
        }
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Wo(2008);
        AppMethodBeat.o(24394);
        return paramString1;
        if (paramString1.db.delete("OpenMsgListener", "appId=?", new String[] { com.tencent.mm.sdk.platformtools.bs.aLh(paramString2) }) <= 0) {
          bool = false;
        } else {
          bool = true;
        }
      }
      Z(0, 0, 1);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    ac.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", new Object[] { Integer.valueOf(i) });
    ft(3, 2003);
    paramString1 = com.tencent.mm.pluginsdk.d.a.a.Wo(2003);
    AppMethodBeat.o(24394);
    return paramString1;
  }
  
  private Cursor u(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24392);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      ac.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(2);
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
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(2);
        AppMethodBeat.o(24392);
        return paramArrayOfString;
      }
      catch (NumberFormatException paramArrayOfString)
      {
        ac.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(2);
        AppMethodBeat.o(24392);
        return paramArrayOfString;
      }
      paramArrayOfString = paramArrayOfString;
      ac.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(2);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
    }
    for (;;)
    {
      label134:
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
      if (2 != i) {
        break;
      }
      ((com.tencent.mm.plugin.appbrand.service.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.k.class)).W(this.context, this.appId);
    }
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(2);
    AppMethodBeat.o(24392);
    return paramArrayOfString;
  }
  
  private Cursor v(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24396);
    ac.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
      ft(3, 3001);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3001);
      AppMethodBeat.o(24396);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(qtj);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 5)) {
          break label377;
        }
        if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramArrayOfString[i])) {
          break label397;
        }
        localObject = com.tencent.mm.plugin.ext.b.cmt().aOH(paramArrayOfString[i]);
        if ((localObject == null) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((cd)localObject).field_openId)) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(((cd)localObject).field_username)))
        {
          ac.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
        }
        else
        {
          az.ayM();
          localObject = com.tencent.mm.model.c.awB().aNt(((cd)localObject).field_username);
          if ((localObject == null) || (((av)localObject).field_username == null) || (((av)localObject).field_username.length() <= 0)) {
            ac.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ac.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", new Object[] { paramArrayOfString.getMessage() });
        Z(7, 4, 12);
        localMatrixCursor.close();
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(12);
        AppMethodBeat.o(24396);
        return paramArrayOfString;
      }
      p.aBh();
      Object localObject = com.tencent.mm.aj.e.K(((av)localObject).field_username, false);
      if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject))
      {
        ac.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
      }
      else
      {
        if (((String)localObject).startsWith(com.tencent.mm.kernel.g.agR().cachePath))
        {
          int j = com.tencent.mm.kernel.g.agR().cachePath.length();
          String str = com.tencent.mm.kernel.g.agR().ghC + ((String)localObject).substring(j);
          com.tencent.mm.vfs.i.aSh(com.tencent.mm.vfs.i.aSs(str));
          com.tencent.mm.vfs.i.lZ((String)localObject, str);
          localObject = str;
        }
        for (;;)
        {
          e.b.Ag((String)localObject);
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], localObject });
          break;
          label377:
          Z(6, 0, 1);
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
    ac.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (paramArrayOfString[0].length() <= 0))
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
      ft(3, 3101);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3101);
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
              ac.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", new Object[] { paramArrayOfString[i] });
              localObject1 = localObject3;
            }
            else
            {
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                localObject4 = localObject3;
                localObject1 = new MatrixCursor(qtk);
              }
              localObject4 = localObject1;
              localk = new com.tencent.mm.modelvoice.k();
              localObject4 = localObject1;
              str1 = com.tencent.mm.plugin.ext.b.cmw() + "/" + com.tencent.mm.sdk.platformtools.ah.dg(str2);
              localObject4 = localObject1;
              ac.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", new Object[] { str1 });
              localObject4 = localObject1;
              if (com.tencent.mm.vfs.i.aSp(str1) > 0L)
              {
                localObject4 = localObject1;
                ac.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                localObject3 = str1;
                localObject4 = localObject1;
                if (com.tencent.mm.vfs.i.aSp(str1) == 0L)
                {
                  localObject4 = localObject1;
                  localObject3 = localk.by(str2, str1);
                }
                localObject4 = localObject1;
                if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject3)) {
                  break;
                }
                localObject4 = localObject1;
                ac.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
              }
            }
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", new Object[] { localException.getMessage() });
            localObject2 = localObject4;
          }
          localObject4 = localObject2;
          localObject3 = localk.by(str2, str1);
        }
        localObject4 = localObject2;
        ac.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", new Object[] { Integer.valueOf(i) });
        localObject4 = localObject2;
        localObject2.addRow(new Object[] { Integer.valueOf(1), Integer.valueOf(localk.mSampleRate), Integer.valueOf(localk.cVV), Integer.valueOf(2), localObject3 });
      }
      else
      {
        if (localObject3 != null)
        {
          Z(8, 0, 1);
          AppMethodBeat.o(24397);
          return localObject3;
        }
        Z(9, 3, 4);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(4);
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
    this.handler = new ao();
    AppMethodBeat.o(24390);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, final String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(24391);
    ac.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", new Object[] { Integer.valueOf(this.qtp) });
    a(paramUri, this.context, this.qtp, this.qto);
    paramArrayOfString1 = this.qtA;
    if (paramUri == null)
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
      ft(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(5);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.qtA))
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
      ft(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(7);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(cmE()))
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
      ft(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(6);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (!bIc())
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
      ft(1, 3);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(3);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    int i = 1;
    if (!IS_DEBUG) {
      i = cmF();
    }
    if (i != 1)
    {
      ac.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = ".concat(String.valueOf(i)));
      ft(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(i);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    long l1;
    switch (this.qtp)
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
      ft(3, 15);
      AppMethodBeat.o(24391);
      return null;
    case 22: 
      paramUri = n(paramUri.getQueryParameter("op"), paramUri.getQueryParameter("scene"), paramUri.getQueryParameter("msgType"), paramUri.getQueryParameter("msgState"));
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
      ac.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (paramArrayOfString2[0].length() <= 0))
      {
        if (paramArrayOfString2 == null) {}
        for (boolean bool = true;; bool = false)
        {
          ac.e("MicroMsg.ExtControlProviderOpenApi", "sendSight wrong args,args == null:%s", new Object[] { Boolean.valueOf(bool) });
          ft(3, 3401);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(3401);
          AppMethodBeat.o(24391);
          return paramUri;
        }
      }
      paramUri = paramArrayOfString2[0];
      if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramUri)) || (!com.tencent.mm.vfs.i.eA(paramUri))) {
        i = 0;
      }
      while (i == 0)
      {
        ac.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
        ft(3, 3402);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(3402);
        AppMethodBeat.o(24391);
        return paramUri;
        paramArrayOfString1 = new com.tencent.mm.plugin.sight.base.d();
        if (SightVideoJNI.isSightOkVFS(paramUri, paramArrayOfString1.xCy, paramArrayOfString1.xCz, paramArrayOfString1.xCA, paramArrayOfString1.xCC, paramArrayOfString1.xCB, paramArrayOfString1.xCB.length) == 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.addFlags(67108864);
      paramArrayOfString1.putExtra("sight_local_path", paramUri);
      com.tencent.mm.br.d.e(this.context, ".ui.transmit.SightForwardUI", paramArrayOfString1);
      Z(12, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 35: 
      ac.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramArrayOfString2[0])))
      {
        ac.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
        ft(3, 3201);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(3201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      ac.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", new Object[] { paramUri });
      i = new com.tencent.mm.plugin.ext.b.c(this.context, paramUri).cmA();
      ac.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", new Object[] { Integer.valueOf(i) });
      if (i != -1)
      {
        Z(14, 0, i);
        i = 0;
      }
      for (;;)
      {
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(i);
        AppMethodBeat.o(24391);
        return paramUri;
        Z(15, 0, i);
      }
    case 36: 
      ac.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        ac.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
        ft(3, 3301);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(3301);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      i = com.tencent.mm.sdk.platformtools.bs.getInt(paramArrayOfString2[1], -1);
      paramArrayOfString1 = paramArrayOfString2[2];
      ac.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", new Object[] { paramUri, Integer.valueOf(i), paramArrayOfString1 });
      if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramUri)) || (i < 0) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramArrayOfString1)))
      {
        ac.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
        ft(3, 3302);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(3302);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramString1 = new uv();
      paramString1.dxN.dxO = paramUri;
      paramString1.dxN.dxP = i;
      paramString1.dxN.dwc = paramArrayOfString1;
      paramString1.dxN.bLs = com.tencent.mm.pluginsdk.a.i(paramUri, this.context);
      com.tencent.mm.sdk.b.a.GpY.l(paramString1);
      Z(16, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 37: 
      ac.d("MicroMsg.ExtControlProviderOpenApi", "getWifiList");
      this.handler = new ao(Looper.getMainLooper());
      paramUri = (MatrixCursor)new ExtControlProviderOpenApi.2(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        Z(19, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(14);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      Z(18, 0, 1);
      ac.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
      AppMethodBeat.o(24391);
      return paramUri;
    case 38: 
      ac.d("MicroMsg.ExtControlProviderOpenApi", "connectWifi");
      this.handler = new ao(Looper.getMainLooper());
      paramUri = (Integer)new ExtControlProviderOpenApi.3(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        Z(21, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(14);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      Z(20, 0, paramUri.intValue());
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(paramUri.intValue());
      AppMethodBeat.o(24391);
      return paramUri;
    case 42: 
      paramUri = new Intent();
      paramUri.addFlags(131072);
      paramUri.putExtra("key_from_scene", 4);
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0) && (paramArrayOfString2[0].length() > 0))
      {
        ac.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", new Object[] { paramArrayOfString2[0], paramArrayOfString1 });
        paramUri.putExtra("key_business_attach", paramArrayOfString2[0]);
      }
      for (;;)
      {
        paramUri.putExtra("key_appid", paramArrayOfString1);
        com.tencent.mm.br.d.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", paramUri);
        com.tencent.mm.plugin.report.service.h.wUl.f(12097, new Object[] { Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        Z(24, 0, 1);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
        AppMethodBeat.o(24391);
        return paramUri;
        ac.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", new Object[] { paramArrayOfString1 });
      }
    case 40: 
      ac.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        ac.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
        Z(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(2);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      l1 = com.tencent.mm.sdk.platformtools.bs.getLong(paramArrayOfString2[0], -1L);
      long l2 = com.tencent.mm.sdk.platformtools.bs.getLong(paramArrayOfString2[1], -1L);
      long l3 = com.tencent.mm.sdk.platformtools.bs.getLong(paramArrayOfString2[2], -1L);
      ac.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
      if ((l2 < 0L) || (l1 < 0L) || (l3 < 0L))
      {
        ac.i("MicroMsg.ExtControlProviderOpenApi", "param err");
        Z(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(2);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      cmB();
      paramUri = new fx();
      paramUri.dgc.action = 2;
      paramUri.dgc.dge = l2;
      paramUri.dgc.dgf = l1;
      paramUri.dgc.bfN = l3;
      if ((com.tencent.mm.sdk.b.a.GpY.l(paramUri)) && (paramUri.dgd.dgh))
      {
        Z(22, 0, paramUri.dgd.dgi);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(paramUri.dgd.dgi);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      Z(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(8);
      AppMethodBeat.o(24391);
      return paramUri;
    case 41: 
      ac.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
      cmB();
      paramUri = new fx();
      paramUri.dgc.action = 3;
      if ((com.tencent.mm.sdk.b.a.GpY.l(paramUri)) && (paramUri.dgd.dgh))
      {
        paramArrayOfString1 = paramUri.dgd.dgg;
        paramString1 = new MatrixCursor(qti);
        paramString1.addRow(new Object[] { Integer.valueOf(paramUri.dgd.dgi), com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramArrayOfString1) });
        Z(22, 0, paramUri.dgd.dgi);
        ac.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(paramUri.dgd.dgi) });
        AppMethodBeat.o(24391);
        return paramString1;
      }
      Z(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(8);
      AppMethodBeat.o(24391);
      return paramUri;
    case 46: 
      ac.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", new Object[] { paramArrayOfString1 });
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        Z(27, 5, 4);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4101);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = new Intent();
      paramUri.putExtra("key_from_openapi", true);
      paramUri.putExtra("key_openapi_appid", paramArrayOfString1);
      com.tencent.mm.br.d.b(this.context, "clean", ".ui.CleanUI", paramUri);
      Z(26, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 48: 
      com.tencent.mm.plugin.ext.d.e.cmP().mContext = this.context;
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
      {
        ac.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      i = com.tencent.mm.sdk.platformtools.bs.getInt(paramArrayOfString2[0], -1);
      if ((i < 0) || ((i != 0) && (i != 1) && (i != 2)))
      {
        ac.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
        Z(32, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramArrayOfString1 = null;
      if ((i == 0) || (i == 1))
      {
        if (paramArrayOfString2.length < 2)
        {
          ac.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4205);
          AppMethodBeat.o(24391);
          return paramUri;
        }
        paramUri = paramArrayOfString2[1];
        if (i == 1)
        {
          if (paramArrayOfString2.length < 3)
          {
            ac.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4208);
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
      ac.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", new Object[] { Integer.valueOf(i), paramUri });
      switch (i)
      {
      default: 
        AppMethodBeat.o(24391);
        return null;
      case 0: 
        paramString1 = com.tencent.mm.plugin.ext.d.e.cmP();
        if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramUri))
        {
          ac.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
          com.tencent.mm.plugin.ext.d.e.W(null, -1, 4205);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4205);
          AppMethodBeat.o(24391);
          return paramUri;
        }
        paramArrayOfString1 = com.tencent.mm.plugin.ext.d.c.abY(paramUri);
        if ((paramArrayOfString1 != null) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramArrayOfString1.url)))
        {
          ac.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramArrayOfString1 });
          paramUri = paramArrayOfString1;
        }
        break;
      }
      for (;;)
      {
        if (paramUri.type == 19)
        {
          if (com.tencent.mm.plugin.ext.d.c.aca(paramUri.url))
          {
            ac.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url.toUpperCase() });
            com.tencent.mm.plugin.ext.d.e.W(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.aFR(paramUri.url);
            AppMethodBeat.o(24391);
            return paramUri;
            paramUri = com.tencent.mm.plugin.ext.d.e.aW(paramUri, false);
            if (paramUri == null)
            {
              ac.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
              com.tencent.mm.plugin.ext.d.e.W(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4206);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramUri = paramString1.a(paramUri);
            if ((paramUri == null) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramUri.url)))
            {
              ac.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4203);
              AppMethodBeat.o(24391);
              return paramUri;
            }
          }
          else
          {
            if (com.tencent.mm.plugin.ext.d.c.abZ(paramUri.url))
            {
              ac.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", new Object[] { paramUri.url });
              com.tencent.mm.plugin.ext.d.e.W(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            l1 = com.tencent.mm.sdk.platformtools.bs.Gn();
            paramArrayOfString1 = com.tencent.mm.plugin.ext.d.c.acb(paramUri.url);
            ac.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", new Object[] { paramArrayOfString1.toString(), Long.valueOf(com.tencent.mm.sdk.platformtools.bs.aO(l1)) });
            if (paramArrayOfString1 == b.b.quv)
            {
              com.tencent.mm.plugin.ext.d.c.abW(paramUri.url);
              com.tencent.mm.plugin.ext.d.e.W(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (paramArrayOfString1 != b.b.quu)
            {
              paramArrayOfString1 = paramUri.url;
              i = paramUri.type;
              int j = paramUri.quJ;
              ac.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", new Object[] { paramArrayOfString1 });
              l1 = System.currentTimeMillis();
              paramArrayOfString1 = (Boolean)new e.2(paramString1, Boolean.TRUE, paramArrayOfString1, i, j).b(com.tencent.mm.plugin.ext.d.e.cmR());
              ac.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", new Object[] { paramArrayOfString1, Long.valueOf(System.currentTimeMillis() - l1) });
              if (paramArrayOfString1.booleanValue())
              {
                com.tencent.mm.plugin.ext.d.c.abW(paramUri.url);
                com.tencent.mm.plugin.ext.d.e.W(paramUri.url, paramUri.type, 1);
                paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
                AppMethodBeat.o(24391);
                return paramUri;
              }
            }
            com.tencent.mm.plugin.ext.d.c.abX(paramUri.url);
            ac.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.d.e.W(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.aFR(paramUri.url);
            AppMethodBeat.o(24391);
            return paramUri;
          }
        }
        else
        {
          ac.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
          AppMethodBeat.o(24391);
          return paramUri;
          paramArrayOfString2 = com.tencent.mm.plugin.ext.d.e.cmP();
          if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramUri))
          {
            ac.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
            com.tencent.mm.plugin.ext.d.e.X(null, -1, 4205);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4205);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramString1 = com.tencent.mm.plugin.ext.d.c.abY(paramUri);
          if ((paramString1 != null) && (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString1.url))) {
            ac.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramString1 });
          }
          for (paramUri = paramString1; (paramUri.type == 19) && (com.tencent.mm.plugin.ext.d.c.aca(paramUri.url)); paramUri = paramArrayOfString1)
          {
            ac.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.d.e.X(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4207);
            AppMethodBeat.o(24391);
            return paramUri;
            if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramArrayOfString1))
            {
              ac.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
              com.tencent.mm.plugin.ext.d.e.X(null, -1, 4208);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4208);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramString1 = com.tencent.mm.plugin.ext.d.e.aW(paramUri, true);
            if (paramString1 == null)
            {
              ac.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
              com.tencent.mm.plugin.ext.d.e.X(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4206);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString1.md5))
            {
              ac.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
              com.tencent.mm.plugin.ext.d.e.X(null, -1, 4210);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4210);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (!paramString1.md5.equalsIgnoreCase(paramArrayOfString1))
            {
              ac.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
              com.tencent.mm.plugin.ext.d.e.X(null, -1, 4209);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4209);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramArrayOfString1 = paramArrayOfString2.a(paramString1);
            if ((paramArrayOfString1 == null) || (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramArrayOfString1.url)))
            {
              ac.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              com.tencent.mm.plugin.ext.d.e.X(null, -1, 4203);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(4203);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            com.tencent.mm.plugin.ext.d.c.a(paramUri, paramArrayOfString1);
          }
          ac.i("MicroMsg.ExtQrCodeHandler", "hy: do open");
          ac.i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", new Object[] { paramUri.toString() });
          paramArrayOfString1 = new Intent(paramArrayOfString2.mContext, RedirectToQrCodeStubUI.class);
          paramArrayOfString1.putExtra("K_STR", paramUri.url);
          paramArrayOfString1.putExtra("K_TYPE", paramUri.type);
          paramArrayOfString1.putExtra("K_VERSION", paramUri.quJ);
          paramArrayOfString1.addFlags(268435456);
          paramString1 = paramArrayOfString2.mContext;
          paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().ba(paramArrayOfString1);
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramArrayOfString1.aeD(), "com/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler", "handleOpen", "(Lcom/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler$QrCodeModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramArrayOfString1.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler", "handleOpen", "(Lcom/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler$QrCodeModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.ext.d.e.X(paramUri.url, paramUri.type, 1);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
          AppMethodBeat.o(24391);
          return paramUri;
          com.tencent.mm.plugin.ext.d.e.cmP();
          paramUri = com.tencent.mm.plugin.ext.d.e.cmQ();
          AppMethodBeat.o(24391);
          return paramUri;
          paramUri = a(paramArrayOfString2, false);
          AppMethodBeat.o(24391);
          return paramUri;
          if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
          {
            ac.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(2);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramUri = u(new String[] { paramArrayOfString2[0], "0" });
          AppMethodBeat.o(24391);
          return paramUri;
          paramUri = u(paramArrayOfString2);
          AppMethodBeat.o(24391);
          return paramUri;
          this.handler = new ao(Looper.getMainLooper());
          paramUri = (Cursor)new bn(com.tencent.mm.pluginsdk.d.a.a.Wo(4302), paramArrayOfString2) {}.b(this.handler);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi
 * JD-Core Version:    0.7.0.1
 */