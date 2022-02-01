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
import com.tencent.mm.ab.i;
import com.tencent.mm.aj.e.b;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.a.gb.b;
import com.tencent.mm.g.a.vs;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.ext.d.b.b;
import com.tencent.mm.plugin.ext.d.d.b;
import com.tencent.mm.plugin.ext.d.e.2;
import com.tencent.mm.plugin.ext.d.e.a;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.cl;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExtControlProviderOpenApi
  extends ExtContentProviderBase
{
  public static boolean IS_DEBUG = false;
  private static final String[] rlb = { "retCode", "selfId" };
  private static final String[] rlc = { "retCode", "sportConfig" };
  private static final String[] rld = { "openid", "avatar" };
  private static final String[] rle = { "voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath" };
  private static final String[] rlf = { "ssid", "macAddress", "isSupportWechat", "name" };
  private static final String[] rlg = { "username", "appId", "versionType", "nickname", "shortNickname", "iconURL", "collection", "runningFlag", "wechatPkg", "action", "intentInfo" };
  private static final String[] rlh = { "token", "nickname", "iconURL" };
  private String appId = "";
  private Context context;
  private aq handler;
  private String[] rli = null;
  private int rlj = -1;
  
  private ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.rli = paramArrayOfString;
    this.rlj = paramInt;
    this.context = paramContext;
  }
  
  public ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext, String paramString)
  {
    this(paramArrayOfString, paramInt, paramContext);
    this.appId = paramString;
  }
  
  private Cursor Y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(24395);
    ae.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString3)))
    {
      ae.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", new Object[] { paramString1, paramString2, paramString3 });
      fz(3, 2004);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.YL(2004);
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
        ae.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: ".concat(String.valueOf(i)));
        fz(3, 2005);
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.YL(2005);
        AppMethodBeat.o(24395);
        return paramString1;
      }
      if (com.tencent.mm.plugin.ext.b.ctz().aVN(this.rlu) == null)
      {
        paramString1 = new bz();
        paramString1.field_appId = this.rlu;
        paramString1.field_packageName = ctL();
        paramString2 = this.rlu;
        boolean bool;
        if (bu.isNullOrNil(paramString2))
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
          bool = com.tencent.mm.plugin.ext.b.ctz().insert(paramString1);
          ae.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", new Object[] { Boolean.valueOf(bool), ctL(), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(paramString1.field_status) });
          if (bool) {
            break label415;
          }
          paramString1 = com.tencent.mm.pluginsdk.d.a.a.YL(2006);
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
      ae.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", new Object[] { paramString1.getMessage() });
      if (paramString2 != null) {
        paramString2.close();
      }
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.YL(12);
      AppMethodBeat.o(24395);
      return paramString1;
      ae.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", new Object[] { this.rlu, ctL() });
      label415:
      paramString1 = new StringBuilder().append(v.aAC());
      bc.aCg();
      paramString1 = com.tencent.mm.sdk.platformtools.aj.ej(com.tencent.mm.model.c.getUin());
      paramString2 = new MatrixCursor(rlb);
      try
      {
        paramString2.addRow(new Object[] { Integer.valueOf(1), bu.nullAsNil(paramString1) });
        ab(0, 0, 1);
        ae.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(1) });
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
      ae.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(2);
      AppMethodBeat.o(24393);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor;
    if (paramBoolean) {
      localMatrixCursor = new MatrixCursor(rlh);
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
          paramArrayOfString = ((ai)com.tencent.mm.kernel.g.ab(ai.class)).dE(i, 0);
          Iterator localIterator = com.tencent.luggage.h.b.C(paramArrayOfString).iterator();
          if (!localIterator.hasNext()) {
            break label935;
          }
          localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
          localObject1 = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Oc(localLocalUsageInfo.appId);
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
          localObject5 = ak.getPackageName();
          i = localLocalUsageInfo.hSZ;
          localObject6 = ((WxaAttributes)localObject1).field_username;
          String str1 = ((WxaAttributes)localObject1).field_nickname;
          String str2 = ((WxaAttributes)localObject1).field_appId;
          com.tencent.mm.kernel.g.ajP();
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
          localMatrixCursor = new MatrixCursor(rlg);
          continue;
        }
        paramArrayOfString = ((ai)com.tencent.mm.kernel.g.ab(ai.class)).sb(i);
      }
      catch (NumberFormatException paramArrayOfString)
      {
        ae.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(2);
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
          k = localLocalUsageInfo.hSZ;
          localObject5 = localLocalUsageInfo.nickname;
          localObject6 = localLocalUsageInfo.cmF;
          localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;
          if (localLocalUsageInfo.jTs) {}
          for (i = 1;; i = 0)
          {
            localMatrixCursor.addRow(new Object[] { localObject3, localObject4, Integer.valueOf(k), localObject5, localObject6, localObject1, Integer.valueOf(i), Long.valueOf(localLocalUsageInfo.cnj), paramArrayOfString.getPackage(), paramArrayOfString.getAction(), new i((Map)localObject2).toString() });
            break;
          }
          label614:
          paramArrayOfString = new StringBuilder().append(localLocalUsageInfo.username).append(",");
          com.tencent.mm.kernel.g.ajP();
          paramArrayOfString = (com.tencent.mm.kernel.a.getUin() + "," + this.rlu).getBytes();
          try
          {
            localObject2 = MessageDigest.getInstance("SHA-256");
            ((MessageDigest)localObject2).update(paramArrayOfString);
            paramArrayOfString = String.format("%064x", new Object[] { new BigInteger(1, ((MessageDigest)localObject2).digest()) });
            localObject2 = com.tencent.mm.plugin.ext.b.ctB();
            localObject3 = localLocalUsageInfo.username;
            com.tencent.mm.kernel.g.ajP();
            i = com.tencent.mm.kernel.a.getUin();
            localObject4 = this.rlu;
            d.g.b.p.h(paramArrayOfString, "token");
            d.g.b.p.h(localObject3, "userName");
            d.g.b.p.h(localObject4, "appid");
            localObject5 = com.tencent.mm.kernel.g.ajR();
            d.g.b.p.g(localObject5, "MMKernel.storage()");
            localObject5 = ((com.tencent.mm.kernel.e)localObject5).gDX.query(((com.tencent.mm.plugin.ext.a.a)localObject2).getTableName(), null, null, null, null, null, null);
            localObject6 = new StringBuilder();
            d.g.b.p.g(localObject5, "query");
            ((StringBuilder)localObject6).append(((Cursor)localObject5).getColumnNames());
            com.tencent.d.f.h.fYG();
            localObject5 = new com.tencent.mm.plugin.ext.a.b();
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_token = paramArrayOfString;
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_username = ((String)localObject3);
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_uin = i;
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_appid = ((String)localObject4);
            if (((com.tencent.mm.plugin.ext.a.a)localObject2).agC(paramArrayOfString) != null)
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
    com.tencent.mm.plugin.report.service.g.yxI.f(18601, new Object[] { this.rlu, Integer.valueOf(j), Integer.valueOf(localMatrixCursor.getCount()) });
    AppMethodBeat.o(24393);
    return localMatrixCursor;
  }
  
  private void ctI()
  {
    AppMethodBeat.i(24398);
    String str1 = (String)com.tencent.mm.plugin.ext.b.cty().get(am.a.IQt, null);
    String str2 = ctL();
    ae.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", new Object[] { str1, str2 });
    if (str1 != null)
    {
      if (!com.tencent.mm.compatible.loader.a.contains(str1.split(";"), str2)) {
        com.tencent.mm.plugin.ext.b.cty().set(am.a.IQt, str1 + ";" + ctL());
      }
      AppMethodBeat.o(24398);
      return;
    }
    com.tencent.mm.plugin.ext.b.cty().set(am.a.IQt, ctL());
    AppMethodBeat.o(24398);
  }
  
  private Cursor m(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(24394);
    ae.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", new Object[] { paramString1 });
    if (this.context == null)
    {
      ae.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
      fz(4, 2001);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.YL(2001);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
      fz(3, 2002);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.YL(2002);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    int i = -1;
    try
    {
      int j = bu.getInt(paramString1, -1);
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
      paramString1 = Y(paramString2, paramString3, paramString4);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    if (i == 2)
    {
      ae.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
      if (com.tencent.mm.plugin.ext.b.ctz().aVN(this.rlu) == null)
      {
        ae.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", new Object[] { this.rlu, ctL() });
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.YL(2007);
        AppMethodBeat.o(24394);
        return paramString1;
      }
      paramString1 = com.tencent.mm.plugin.ext.b.ctz();
      paramString2 = this.rlu;
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        bool = false;
      }
      for (;;)
      {
        ae.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", new Object[] { Boolean.valueOf(bool), this.rlu, ctL() });
        if (bool) {
          break;
        }
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.YL(2008);
        AppMethodBeat.o(24394);
        return paramString1;
        if (paramString1.db.delete("OpenMsgListener", "appId=?", new String[] { bu.aSk(paramString2) }) <= 0) {
          bool = false;
        } else {
          bool = true;
        }
      }
      ab(0, 0, 1);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.YL(1);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    ae.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", new Object[] { Integer.valueOf(i) });
    fz(3, 2003);
    paramString1 = com.tencent.mm.pluginsdk.d.a.a.YL(2003);
    AppMethodBeat.o(24394);
    return paramString1;
  }
  
  private Cursor v(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24392);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      ae.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(2);
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
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(2);
        AppMethodBeat.o(24392);
        return paramArrayOfString;
      }
      catch (NumberFormatException paramArrayOfString)
      {
        ae.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(2);
        AppMethodBeat.o(24392);
        return paramArrayOfString;
      }
      paramArrayOfString = paramArrayOfString;
      ae.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(2);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
    }
    for (;;)
    {
      label134:
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(1);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
      if (2 != i) {
        break;
      }
      ((com.tencent.mm.plugin.appbrand.service.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.k.class)).X(this.context, this.appId);
    }
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(2);
    AppMethodBeat.o(24392);
    return paramArrayOfString;
  }
  
  private Cursor w(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24396);
    ae.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ae.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
      fz(3, 3001);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3001);
      AppMethodBeat.o(24396);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(rld);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 5)) {
          break label377;
        }
        if (bu.isNullOrNil(paramArrayOfString[i])) {
          break label397;
        }
        localObject = com.tencent.mm.plugin.ext.b.ctA().aVZ(paramArrayOfString[i]);
        if ((localObject == null) || (bu.isNullOrNil(((ck)localObject).field_openId)) || (bu.isNullOrNil(((ck)localObject).field_username)))
        {
          ae.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
        }
        else
        {
          bc.aCg();
          localObject = com.tencent.mm.model.c.azF().BH(((ck)localObject).field_username);
          if ((localObject == null) || (((aw)localObject).field_username == null) || (((aw)localObject).field_username.length() <= 0)) {
            ae.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ae.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", new Object[] { paramArrayOfString.getMessage() });
        ab(7, 4, 12);
        localMatrixCursor.close();
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(12);
        AppMethodBeat.o(24396);
        return paramArrayOfString;
      }
      com.tencent.mm.aj.p.aEA();
      Object localObject = com.tencent.mm.aj.e.K(((aw)localObject).field_username, false);
      if (bu.isNullOrNil((String)localObject))
      {
        ae.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
      }
      else
      {
        if (((String)localObject).startsWith(com.tencent.mm.kernel.g.ajR().cachePath))
        {
          int j = com.tencent.mm.kernel.g.ajR().cachePath.length();
          String str = com.tencent.mm.kernel.g.ajR().gDT + ((String)localObject).substring(j);
          com.tencent.mm.vfs.o.aZI(com.tencent.mm.vfs.o.aZU(str));
          com.tencent.mm.vfs.o.mF((String)localObject, str);
          localObject = str;
        }
        for (;;)
        {
          e.b.DH((String)localObject);
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
    ae.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (paramArrayOfString[0].length() <= 0))
    {
      ae.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
      fz(3, 3101);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3101);
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
              ae.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", new Object[] { paramArrayOfString[i] });
              localObject1 = localObject3;
            }
            else
            {
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                localObject4 = localObject3;
                localObject1 = new MatrixCursor(rle);
              }
              localObject4 = localObject1;
              localk = new com.tencent.mm.modelvoice.k();
              localObject4 = localObject1;
              str1 = com.tencent.mm.plugin.ext.b.ctD() + "/" + com.tencent.mm.sdk.platformtools.aj.ej(str2);
              localObject4 = localObject1;
              ae.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", new Object[] { str1 });
              localObject4 = localObject1;
              if (com.tencent.mm.vfs.o.aZR(str1) > 0L)
              {
                localObject4 = localObject1;
                ae.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                localObject3 = str1;
                localObject4 = localObject1;
                if (com.tencent.mm.vfs.o.aZR(str1) == 0L)
                {
                  localObject4 = localObject1;
                  localObject3 = localk.bz(str2, str1);
                }
                localObject4 = localObject1;
                if (!bu.isNullOrNil((String)localObject3)) {
                  break;
                }
                localObject4 = localObject1;
                ae.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
              }
            }
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", new Object[] { localException.getMessage() });
            localObject2 = localObject4;
          }
          localObject4 = localObject2;
          localObject3 = localk.bz(str2, str1);
        }
        localObject4 = localObject2;
        ae.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", new Object[] { Integer.valueOf(i) });
        localObject4 = localObject2;
        localObject2.addRow(new Object[] { Integer.valueOf(1), Integer.valueOf(localk.mSampleRate), Integer.valueOf(localk.din), Integer.valueOf(2), localObject3 });
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
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(4);
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
    this.handler = new aq();
    AppMethodBeat.o(24390);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(24391);
    ae.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", new Object[] { Integer.valueOf(this.rlj) });
    a(paramUri, this.context, this.rlj, this.rli);
    paramArrayOfString1 = this.rlu;
    if (paramUri == null)
    {
      ae.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
      fz(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(5);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (bu.isNullOrNil(this.rlu))
    {
      ae.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
      fz(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(7);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (bu.isNullOrNil(ctL()))
    {
      ae.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
      fz(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(6);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (!bNl())
    {
      ae.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
      fz(1, 3);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(3);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    int i = 1;
    if (!IS_DEBUG) {
      i = ctM();
    }
    if (i != 1)
    {
      ae.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = ".concat(String.valueOf(i)));
      fz(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(i);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    long l1;
    switch (this.rlj)
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
      fz(3, 15);
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
      ae.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (paramArrayOfString2[0].length() <= 0))
      {
        if (paramArrayOfString2 == null) {}
        for (boolean bool = true;; bool = false)
        {
          ae.e("MicroMsg.ExtControlProviderOpenApi", "sendSight wrong args,args == null:%s", new Object[] { Boolean.valueOf(bool) });
          fz(3, 3401);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(3401);
          AppMethodBeat.o(24391);
          return paramUri;
        }
      }
      paramUri = paramArrayOfString2[0];
      if ((bu.isNullOrNil(paramUri)) || (!com.tencent.mm.vfs.o.fB(paramUri))) {
        i = 0;
      }
      while (i == 0)
      {
        ae.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
        fz(3, 3402);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(3402);
        AppMethodBeat.o(24391);
        return paramUri;
        paramArrayOfString1 = new com.tencent.mm.plugin.sight.base.d();
        if (SightVideoJNI.isSightOkVFS(paramUri, paramArrayOfString1.zhs, paramArrayOfString1.zht, paramArrayOfString1.zhu, paramArrayOfString1.zhw, paramArrayOfString1.zhv, paramArrayOfString1.zhv.length) == 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.addFlags(67108864);
      paramArrayOfString1.putExtra("sight_local_path", paramUri);
      com.tencent.mm.br.d.f(this.context, ".ui.transmit.SightForwardUI", paramArrayOfString1);
      ab(12, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 35: 
      ae.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (bu.isNullOrNil(paramArrayOfString2[0])))
      {
        ae.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
        fz(3, 3201);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(3201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      ae.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", new Object[] { paramUri });
      i = new com.tencent.mm.plugin.ext.b.c(this.context, paramUri).ctH();
      ae.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", new Object[] { Integer.valueOf(i) });
      if (i != -1)
      {
        ab(14, 0, i);
        i = 0;
      }
      for (;;)
      {
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(i);
        AppMethodBeat.o(24391);
        return paramUri;
        ab(15, 0, i);
      }
    case 36: 
      ae.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        ae.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
        fz(3, 3301);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(3301);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      i = bu.getInt(paramArrayOfString2[1], -1);
      paramArrayOfString1 = paramArrayOfString2[2];
      ae.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", new Object[] { paramUri, Integer.valueOf(i), paramArrayOfString1 });
      if ((bu.isNullOrNil(paramUri)) || (i < 0) || (bu.isNullOrNil(paramArrayOfString1)))
      {
        ae.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
        fz(3, 3302);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(3302);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramString1 = new vs();
      paramString1.dLp.dLq = paramUri;
      paramString1.dLp.dLr = i;
      paramString1.dLp.dJq = paramArrayOfString1;
      paramString1.dLp.bVF = com.tencent.mm.pluginsdk.b.i(paramUri, this.context);
      com.tencent.mm.sdk.b.a.IvT.l(paramString1);
      ab(16, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 37: 
      ae.d("MicroMsg.ExtControlProviderOpenApi", "getWifiList");
      this.handler = new aq(Looper.getMainLooper());
      paramUri = (MatrixCursor)new ExtControlProviderOpenApi.2(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        ab(19, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(14);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ab(18, 0, 1);
      ae.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
      AppMethodBeat.o(24391);
      return paramUri;
    case 38: 
      ae.d("MicroMsg.ExtControlProviderOpenApi", "connectWifi");
      this.handler = new aq(Looper.getMainLooper());
      paramUri = (Integer)new ExtControlProviderOpenApi.3(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        ab(21, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(14);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ab(20, 0, paramUri.intValue());
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(paramUri.intValue());
      AppMethodBeat.o(24391);
      return paramUri;
    case 42: 
      paramUri = new Intent();
      paramUri.addFlags(131072);
      paramUri.putExtra("key_from_scene", 4);
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0) && (paramArrayOfString2[0].length() > 0))
      {
        ae.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", new Object[] { paramArrayOfString2[0], paramArrayOfString1 });
        paramUri.putExtra("key_business_attach", paramArrayOfString2[0]);
      }
      for (;;)
      {
        paramUri.putExtra("key_appid", paramArrayOfString1);
        com.tencent.mm.br.d.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", paramUri);
        com.tencent.mm.plugin.report.service.g.yxI.f(12097, new Object[] { Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        ab(24, 0, 1);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
        AppMethodBeat.o(24391);
        return paramUri;
        ae.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", new Object[] { paramArrayOfString1 });
      }
    case 40: 
      ae.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        ae.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
        ab(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(2);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      l1 = bu.getLong(paramArrayOfString2[0], -1L);
      long l2 = bu.getLong(paramArrayOfString2[1], -1L);
      long l3 = bu.getLong(paramArrayOfString2[2], -1L);
      ae.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
      if ((l2 < 0L) || (l1 < 0L) || (l3 < 0L))
      {
        ae.i("MicroMsg.ExtControlProviderOpenApi", "param err");
        ab(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(2);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ctI();
      paramUri = new gb();
      paramUri.dsE.action = 2;
      paramUri.dsE.dsG = l2;
      paramUri.dsE.dsH = l1;
      paramUri.dsE.bqh = l3;
      if ((com.tencent.mm.sdk.b.a.IvT.l(paramUri)) && (paramUri.dsF.dsJ))
      {
        ab(22, 0, paramUri.dsF.dsK);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(paramUri.dsF.dsK);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ab(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(8);
      AppMethodBeat.o(24391);
      return paramUri;
    case 41: 
      ae.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
      ctI();
      paramUri = new gb();
      paramUri.dsE.action = 3;
      if ((com.tencent.mm.sdk.b.a.IvT.l(paramUri)) && (paramUri.dsF.dsJ))
      {
        paramArrayOfString1 = paramUri.dsF.dsI;
        paramString1 = new MatrixCursor(rlc);
        paramString1.addRow(new Object[] { Integer.valueOf(paramUri.dsF.dsK), bu.nullAsNil(paramArrayOfString1) });
        ab(22, 0, paramUri.dsF.dsK);
        ae.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(paramUri.dsF.dsK) });
        AppMethodBeat.o(24391);
        return paramString1;
      }
      ab(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(8);
      AppMethodBeat.o(24391);
      return paramUri;
    case 46: 
      ae.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", new Object[] { paramArrayOfString1 });
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        ab(27, 5, 4);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4101);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = new Intent();
      paramUri.putExtra("key_from_openapi", true);
      paramUri.putExtra("key_openapi_appid", paramArrayOfString1);
      com.tencent.mm.br.d.b(this.context, "clean", ".ui.CleanUI", paramUri);
      ab(26, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 48: 
      com.tencent.mm.plugin.ext.d.e.ctW().mContext = this.context;
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
      {
        ae.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      i = bu.getInt(paramArrayOfString2[0], -1);
      if ((i < 0) || ((i != 0) && (i != 1) && (i != 2)))
      {
        ae.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
        ab(32, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramArrayOfString1 = null;
      if ((i == 0) || (i == 1))
      {
        if (paramArrayOfString2.length < 2)
        {
          ae.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4205);
          AppMethodBeat.o(24391);
          return paramUri;
        }
        paramUri = paramArrayOfString2[1];
        if (i == 1)
        {
          if (paramArrayOfString2.length < 3)
          {
            ae.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4208);
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
      ae.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", new Object[] { Integer.valueOf(i), paramUri });
      switch (i)
      {
      default: 
        AppMethodBeat.o(24391);
        return null;
      case 0: 
        paramString1 = com.tencent.mm.plugin.ext.d.e.ctW();
        if (bu.isNullOrNil(paramUri))
        {
          ae.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
          com.tencent.mm.plugin.ext.d.e.Y(null, -1, 4205);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4205);
          AppMethodBeat.o(24391);
          return paramUri;
        }
        paramArrayOfString1 = com.tencent.mm.plugin.ext.d.c.agJ(paramUri);
        if ((paramArrayOfString1 != null) && (!bu.isNullOrNil(paramArrayOfString1.url)))
        {
          ae.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramArrayOfString1 });
          paramUri = paramArrayOfString1;
        }
        break;
      }
      for (;;)
      {
        if (paramUri.type == 19)
        {
          if (com.tencent.mm.plugin.ext.d.c.agL(paramUri.url))
          {
            ae.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url.toUpperCase() });
            com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.aMN(paramUri.url);
            AppMethodBeat.o(24391);
            return paramUri;
            paramUri = com.tencent.mm.plugin.ext.d.e.ba(paramUri, false);
            if (paramUri == null)
            {
              ae.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
              com.tencent.mm.plugin.ext.d.e.Y(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4206);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramUri = paramString1.a(paramUri);
            if ((paramUri == null) || (bu.isNullOrNil(paramUri.url)))
            {
              ae.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4203);
              AppMethodBeat.o(24391);
              return paramUri;
            }
          }
          else
          {
            if (com.tencent.mm.plugin.ext.d.c.agK(paramUri.url))
            {
              ae.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", new Object[] { paramUri.url });
              com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            l1 = bu.HQ();
            paramArrayOfString1 = com.tencent.mm.plugin.ext.d.c.agM(paramUri.url);
            ae.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", new Object[] { paramArrayOfString1.toString(), Long.valueOf(bu.aO(l1)) });
            if (paramArrayOfString1 == b.b.rmo)
            {
              com.tencent.mm.plugin.ext.d.c.agH(paramUri.url);
              com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (paramArrayOfString1 != b.b.rmn)
            {
              paramArrayOfString1 = paramUri.url;
              i = paramUri.type;
              int j = paramUri.rmC;
              ae.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", new Object[] { paramArrayOfString1 });
              l1 = System.currentTimeMillis();
              paramArrayOfString1 = (Boolean)new e.2(paramString1, Boolean.TRUE, paramArrayOfString1, i, j).b(com.tencent.mm.plugin.ext.d.e.ctY());
              ae.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", new Object[] { paramArrayOfString1, Long.valueOf(System.currentTimeMillis() - l1) });
              if (paramArrayOfString1.booleanValue())
              {
                com.tencent.mm.plugin.ext.d.c.agH(paramUri.url);
                com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 1);
                paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
                AppMethodBeat.o(24391);
                return paramUri;
              }
            }
            com.tencent.mm.plugin.ext.d.c.agI(paramUri.url);
            ae.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.d.e.Y(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.aMN(paramUri.url);
            AppMethodBeat.o(24391);
            return paramUri;
          }
        }
        else
        {
          ae.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
          AppMethodBeat.o(24391);
          return paramUri;
          paramArrayOfString2 = com.tencent.mm.plugin.ext.d.e.ctW();
          if (bu.isNullOrNil(paramUri))
          {
            ae.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
            com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4205);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4205);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramString1 = com.tencent.mm.plugin.ext.d.c.agJ(paramUri);
          if ((paramString1 != null) && (!bu.isNullOrNil(paramString1.url))) {
            ae.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramString1 });
          }
          for (paramUri = paramString1; (paramUri.type == 19) && (com.tencent.mm.plugin.ext.d.c.agL(paramUri.url)); paramUri = paramArrayOfString1)
          {
            ae.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.d.e.Z(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4207);
            AppMethodBeat.o(24391);
            return paramUri;
            if (bu.isNullOrNil(paramArrayOfString1))
            {
              ae.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4208);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4208);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramString1 = com.tencent.mm.plugin.ext.d.e.ba(paramUri, true);
            if (paramString1 == null)
            {
              ae.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4206);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (bu.isNullOrNil(paramString1.md5))
            {
              ae.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4210);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4210);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (!paramString1.md5.equalsIgnoreCase(paramArrayOfString1))
            {
              ae.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4209);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4209);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramArrayOfString1 = paramArrayOfString2.a(paramString1);
            if ((paramArrayOfString1 == null) || (bu.isNullOrNil(paramArrayOfString1.url)))
            {
              ae.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4203);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(4203);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            com.tencent.mm.plugin.ext.d.c.a(paramUri, paramArrayOfString1);
          }
          ae.i("MicroMsg.ExtQrCodeHandler", "hy: do open");
          ae.i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", new Object[] { paramUri.toString() });
          paramArrayOfString1 = new Intent(paramArrayOfString2.mContext, RedirectToQrCodeStubUI.class);
          paramArrayOfString1.putExtra("K_STR", paramUri.url);
          paramArrayOfString1.putExtra("K_TYPE", paramUri.type);
          paramArrayOfString1.putExtra("K_VERSION", paramUri.rmC);
          paramArrayOfString1.addFlags(268435456);
          paramString1 = paramArrayOfString2.mContext;
          paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramArrayOfString1);
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramArrayOfString1.ahE(), "com/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler", "handleOpen", "(Lcom/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler$QrCodeModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramArrayOfString1.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler", "handleOpen", "(Lcom/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler$QrCodeModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.ext.d.e.Z(paramUri.url, paramUri.type, 1);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
          AppMethodBeat.o(24391);
          return paramUri;
          com.tencent.mm.plugin.ext.d.e.ctW();
          paramUri = com.tencent.mm.plugin.ext.d.e.ctX();
          AppMethodBeat.o(24391);
          return paramUri;
          paramUri = a(paramArrayOfString2, false);
          AppMethodBeat.o(24391);
          return paramUri;
          if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
          {
            ae.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(2);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramUri = v(new String[] { paramArrayOfString2[0], "0" });
          AppMethodBeat.o(24391);
          return paramUri;
          paramUri = v(paramArrayOfString2);
          AppMethodBeat.o(24391);
          return paramUri;
          this.handler = new aq(Looper.getMainLooper());
          paramUri = (Cursor)new ExtControlProviderOpenApi.1(this, com.tencent.mm.pluginsdk.d.a.a.YL(4302), paramArrayOfString2).b(this.handler);
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