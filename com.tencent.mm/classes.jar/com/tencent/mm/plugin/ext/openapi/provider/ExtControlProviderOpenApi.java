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
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.ge.b;
import com.tencent.mm.g.a.ws;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
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
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cg;
import com.tencent.mm.storage.ch;
import com.tencent.mm.storage.cr;
import com.tencent.mm.storage.cs;
import com.tencent.mm.vfs.s;
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
  private static final String[] sMG = { "retCode", "selfId" };
  private static final String[] sMH = { "retCode", "sportConfig" };
  private static final String[] sMI = { "openid", "avatar" };
  private static final String[] sMJ = { "voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath" };
  private static final String[] sMK = { "ssid", "macAddress", "isSupportWechat", "name" };
  private static final String[] sML = { "username", "appId", "versionType", "nickname", "shortNickname", "iconURL", "collection", "runningFlag", "wechatPkg", "action", "intentInfo" };
  private static final String[] sMM = { "token", "nickname", "iconURL" };
  private String appId = "";
  private Context context;
  private MMHandler handler;
  private String[] sMN = null;
  private int sMO = -1;
  
  private ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.sMN = paramArrayOfString;
    this.sMO = paramInt;
    this.context = paramContext;
  }
  
  public ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext, String paramString)
  {
    this(paramArrayOfString, paramInt, paramContext);
    this.appId = paramString;
  }
  
  private Cursor a(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(24393);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(2);
      AppMethodBeat.o(24393);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor;
    if (paramBoolean) {
      localMatrixCursor = new MatrixCursor(sMM);
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
          break label403;
        }
        if (paramBoolean)
        {
          paramArrayOfString = ((ah)g.af(ah.class)).dP(i, 0);
          Iterator localIterator = com.tencent.luggage.h.b.G(paramArrayOfString).iterator();
          if (!localIterator.hasNext()) {
            break label930;
          }
          localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
          localObject1 = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xl(localLocalUsageInfo.appId);
          if (localObject1 == null) {
            continue;
          }
          if (paramBoolean) {
            break label609;
          }
          paramArrayOfString = ((WxaAttributes)localObject1).field_roundedSquareIconURL;
          localObject2 = ((WxaAttributes)localObject1).field_brandIconURL;
          localObject3 = ((WxaAttributes)localObject1).field_bigHeadURL;
          localObject4 = (com.tencent.mm.modelappbrand.b.a)g.af(com.tencent.mm.modelappbrand.b.a.class);
          localObject5 = MMApplicationContext.getPackageName();
          i = localLocalUsageInfo.iOo;
          localObject6 = ((WxaAttributes)localObject1).field_username;
          String str1 = ((WxaAttributes)localObject1).field_nickname;
          String str2 = ((WxaAttributes)localObject1).field_appId;
          g.aAf();
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
            break label454;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          ((Map)localObject2).put(localObject5, ((Bundle)localObject3).get((String)localObject5));
          continue;
          localMatrixCursor = new MatrixCursor(sML);
          continue;
        }
        paramArrayOfString = ((ah)g.af(ah.class)).vW(i);
      }
      catch (NumberFormatException paramArrayOfString)
      {
        Log.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(2);
        AppMethodBeat.o(24393);
        return paramArrayOfString;
      }
      continue;
      label403:
      if (2 == j) {
        if (paramBoolean)
        {
          paramArrayOfString = ((ag)g.af(ag.class)).a(i, null, 0);
        }
        else
        {
          paramArrayOfString = ((ag)g.af(ag.class)).a(i, null);
          continue;
          label454:
          localObject3 = localLocalUsageInfo.username;
          localObject4 = localLocalUsageInfo.appId;
          k = localLocalUsageInfo.iOo;
          localObject5 = localLocalUsageInfo.nickname;
          localObject6 = localLocalUsageInfo.cyB;
          localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;
          if (localLocalUsageInfo.kWa) {}
          for (i = 1;; i = 0)
          {
            localMatrixCursor.addRow(new Object[] { localObject3, localObject4, Integer.valueOf(k), localObject5, localObject6, localObject1, Integer.valueOf(i), Long.valueOf(localLocalUsageInfo.czf), paramArrayOfString.getPackage(), paramArrayOfString.getAction(), new i((Map)localObject2).toString() });
            break;
          }
          label609:
          paramArrayOfString = new StringBuilder().append(localLocalUsageInfo.username).append(",");
          g.aAf();
          paramArrayOfString = (com.tencent.mm.kernel.a.getUin() + "," + this.sMZ).getBytes();
          try
          {
            localObject2 = MessageDigest.getInstance("SHA-256");
            ((MessageDigest)localObject2).update(paramArrayOfString);
            paramArrayOfString = String.format("%064x", new Object[] { new BigInteger(1, ((MessageDigest)localObject2).digest()) });
            localObject2 = com.tencent.mm.plugin.ext.b.cSj();
            localObject3 = localLocalUsageInfo.username;
            g.aAf();
            i = com.tencent.mm.kernel.a.getUin();
            localObject4 = this.sMZ;
            kotlin.g.b.p.h(paramArrayOfString, "token");
            kotlin.g.b.p.h(localObject3, "userName");
            kotlin.g.b.p.h(localObject4, "appid");
            localObject5 = g.aAh();
            kotlin.g.b.p.g(localObject5, "MMKernel.storage()");
            localObject5 = ((com.tencent.mm.kernel.e)localObject5).hqK.query(((com.tencent.mm.plugin.ext.a.a)localObject2).getTableName(), null, null, null, null, null, null);
            localObject6 = new StringBuilder();
            kotlin.g.b.p.g(localObject5, "query");
            ((StringBuilder)localObject6).append(((Cursor)localObject5).getColumnNames());
            com.tencent.e.f.h.hkS();
            localObject5 = new com.tencent.mm.plugin.ext.a.b();
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_token = paramArrayOfString;
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_username = ((String)localObject3);
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_uin = i;
            ((com.tencent.mm.plugin.ext.a.b)localObject5).field_appid = ((String)localObject4);
            if (((com.tencent.mm.plugin.ext.a.a)localObject2).arm(paramArrayOfString) != null)
            {
              ((com.tencent.mm.plugin.ext.a.a)localObject2).update((IAutoDBItem)localObject5, new String[0]);
              localMatrixCursor.addRow(new Object[] { paramArrayOfString, localLocalUsageInfo.nickname, ((WxaAttributes)localObject1).field_brandIconURL });
            }
          }
          catch (NoSuchAlgorithmException paramArrayOfString)
          {
            for (;;)
            {
              paramArrayOfString = "";
              continue;
              ((com.tencent.mm.plugin.ext.a.a)localObject2).insert((IAutoDBItem)localObject5);
            }
          }
        }
      }
    }
    label930:
    com.tencent.mm.plugin.report.service.h.CyF.a(18601, new Object[] { this.sMZ, Integer.valueOf(j), Integer.valueOf(localMatrixCursor.getCount()) });
    AppMethodBeat.o(24393);
    return localMatrixCursor;
  }
  
  private Cursor ad(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(24395);
    Log.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", new Object[] { paramString1, paramString2, paramString3 });
      fP(3, 2004);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.ahx(2004);
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
        Log.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: ".concat(String.valueOf(i)));
        fP(3, 2005);
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.ahx(2005);
        AppMethodBeat.o(24395);
        return paramString1;
      }
      if (com.tencent.mm.plugin.ext.b.cSh().bkL(this.sMZ) == null)
      {
        paramString1 = new cg();
        paramString1.field_appId = this.sMZ;
        paramString1.field_packageName = cSt();
        paramString2 = this.sMZ;
        boolean bool;
        if (Util.isNullOrNil(paramString2))
        {
          bool = false;
          if (!bool) {
            break label333;
          }
        }
        label333:
        for (paramString1.field_status = 1;; paramString1.field_status = 0)
        {
          paramString1.field_sceneFlag = j;
          paramString1.field_msgTypeFlag = k;
          paramString1.field_msgState = i;
          bool = com.tencent.mm.plugin.ext.b.cSh().insert(paramString1);
          Log.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", new Object[] { Boolean.valueOf(bool), cSt(), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(paramString1.field_status) });
          if (bool) {
            break label420;
          }
          paramString1 = com.tencent.mm.pluginsdk.d.a.a.ahx(2006);
          AppMethodBeat.o(24395);
          return paramString1;
          bool = com.tencent.mm.pluginsdk.model.app.h.o(com.tencent.mm.pluginsdk.model.app.h.o(paramString2, true, false));
          break;
        }
        ac(1, 4, 12);
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = localObject;
    }
    for (;;)
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", new Object[] { paramString1.getMessage() });
      if (paramString2 != null) {
        paramString2.close();
      }
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.ahx(12);
      AppMethodBeat.o(24395);
      return paramString1;
      Log.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", new Object[] { this.sMZ, cSt() });
      label420:
      paramString1 = new StringBuilder().append(z.aTY());
      bg.aVF();
      paramString1 = MD5Util.getMD5String(com.tencent.mm.model.c.getUin());
      paramString2 = new MatrixCursor(sMG);
      try
      {
        paramString2.addRow(new Object[] { Integer.valueOf(1), Util.nullAsNil(paramString1) });
        ac(0, 0, 1);
        Log.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(24395);
        return paramString2;
      }
      catch (Exception paramString1) {}
    }
  }
  
  private void cSq()
  {
    AppMethodBeat.i(24398);
    String str1 = (String)com.tencent.mm.plugin.ext.b.cSg().get(ar.a.NYu, null);
    String str2 = cSt();
    Log.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", new Object[] { str1, str2 });
    if (str1 != null)
    {
      if (!com.tencent.mm.compatible.loader.a.contains(str1.split(";"), str2)) {
        com.tencent.mm.plugin.ext.b.cSg().set(ar.a.NYu, str1 + ";" + cSt());
      }
      AppMethodBeat.o(24398);
      return;
    }
    com.tencent.mm.plugin.ext.b.cSg().set(ar.a.NYu, cSt());
    AppMethodBeat.o(24398);
  }
  
  private Cursor m(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(24394);
    Log.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", new Object[] { paramString1 });
    if (this.context == null)
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
      fP(4, 2001);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.ahx(2001);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
      fP(3, 2002);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.ahx(2002);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    int i = -1;
    try
    {
      int j = Util.getInt(paramString1, -1);
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
      paramString1 = ad(paramString2, paramString3, paramString4);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    if (i == 2)
    {
      Log.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
      if (com.tencent.mm.plugin.ext.b.cSh().bkL(this.sMZ) == null)
      {
        Log.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", new Object[] { this.sMZ, cSt() });
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.ahx(2007);
        AppMethodBeat.o(24394);
        return paramString1;
      }
      paramString1 = com.tencent.mm.plugin.ext.b.cSh();
      paramString2 = this.sMZ;
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        bool = false;
      }
      for (;;)
      {
        Log.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", new Object[] { Boolean.valueOf(bool), this.sMZ, cSt() });
        if (bool) {
          break;
        }
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.ahx(2008);
        AppMethodBeat.o(24394);
        return paramString1;
        if (paramString1.db.delete("OpenMsgListener", "appId=?", new String[] { Util.escapeSqlValue(paramString2) }) <= 0) {
          bool = false;
        } else {
          bool = true;
        }
      }
      ac(0, 0, 1);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
      AppMethodBeat.o(24394);
      return paramString1;
    }
    Log.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", new Object[] { Integer.valueOf(i) });
    fP(3, 2003);
    paramString1 = com.tencent.mm.pluginsdk.d.a.a.ahx(2003);
    AppMethodBeat.o(24394);
    return paramString1;
  }
  
  private Cursor x(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24392);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(2);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramArrayOfString[0]);
      if (1 == i) {
        ((m)g.af(m.class)).a(this.context, i, this.appId);
      }
    }
    catch (NumberFormatException paramArrayOfString)
    {
      try
      {
        i = Integer.parseInt(paramArrayOfString[1]);
        if ((1 == i) || (2 == i) || (i == 0)) {
          break label133;
        }
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(2);
        AppMethodBeat.o(24392);
        return paramArrayOfString;
      }
      catch (NumberFormatException paramArrayOfString)
      {
        Log.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(2);
        AppMethodBeat.o(24392);
        return paramArrayOfString;
      }
      paramArrayOfString = paramArrayOfString;
      Log.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(2);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
    }
    for (;;)
    {
      label133:
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
      AppMethodBeat.o(24392);
      return paramArrayOfString;
      if (2 != i) {
        break;
      }
      ((m)g.af(m.class)).af(this.context, this.appId);
    }
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(2);
    AppMethodBeat.o(24392);
    return paramArrayOfString;
  }
  
  private Cursor y(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24396);
    Log.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
      fP(3, 3001);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(3001);
      AppMethodBeat.o(24396);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(sMI);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 5)) {
          break label377;
        }
        if (Util.isNullOrNil(paramArrayOfString[i])) {
          break label397;
        }
        localObject = com.tencent.mm.plugin.ext.b.cSi().bkX(paramArrayOfString[i]);
        if ((localObject == null) || (Util.isNullOrNil(((cr)localObject).field_openId)) || (Util.isNullOrNil(((cr)localObject).field_username)))
        {
          Log.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
        }
        else
        {
          bg.aVF();
          localObject = com.tencent.mm.model.c.aSN().Kn(((cr)localObject).field_username);
          if ((localObject == null) || (((ax)localObject).field_username == null) || (((ax)localObject).field_username.length() <= 0)) {
            Log.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        Log.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", new Object[] { paramArrayOfString.getMessage() });
        ac(7, 4, 12);
        localMatrixCursor.close();
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(12);
        AppMethodBeat.o(24396);
        return paramArrayOfString;
      }
      com.tencent.mm.aj.p.aYn();
      Object localObject = com.tencent.mm.aj.e.M(((ax)localObject).field_username, false);
      if (Util.isNullOrNil((String)localObject))
      {
        Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
      }
      else
      {
        if (((String)localObject).startsWith(g.aAh().cachePath))
        {
          int j = g.aAh().cachePath.length();
          String str = g.aAh().hqG + ((String)localObject).substring(j);
          s.boN(s.boZ(str));
          s.nw((String)localObject, str);
          localObject = str;
        }
        for (;;)
        {
          e.b.Ms((String)localObject);
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], localObject });
          break;
          label377:
          ac(6, 0, 1);
          AppMethodBeat.o(24396);
          return localMatrixCursor;
        }
      }
      label397:
      i += 1;
    }
  }
  
  private Cursor z(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24397);
    Log.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (paramArrayOfString[0].length() <= 0))
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
      fP(3, 3101);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(3101);
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
        k localk;
        for (;;)
        {
          String str1;
          try
          {
            Object localObject1;
            if (!com.tencent.mm.modelvoice.q.i(str2, 0, true))
            {
              localObject4 = localObject3;
              Log.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", new Object[] { paramArrayOfString[i] });
              localObject1 = localObject3;
            }
            else
            {
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                localObject4 = localObject3;
                localObject1 = new MatrixCursor(sMJ);
              }
              localObject4 = localObject1;
              localk = new k();
              localObject4 = localObject1;
              str1 = com.tencent.mm.plugin.ext.b.cSl() + "/" + MD5Util.getMD5String(str2);
              localObject4 = localObject1;
              Log.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", new Object[] { str1 });
              localObject4 = localObject1;
              if (s.boW(str1) > 0L)
              {
                localObject4 = localObject1;
                Log.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                localObject3 = str1;
                localObject4 = localObject1;
                if (s.boW(str1) == 0L)
                {
                  localObject4 = localObject1;
                  localObject3 = localk.bD(str2, str1);
                }
                localObject4 = localObject1;
                if (!Util.isNullOrNil((String)localObject3)) {
                  break;
                }
                localObject4 = localObject1;
                Log.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
              }
            }
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", new Object[] { localException.getMessage() });
            localObject2 = localObject4;
          }
          localObject4 = localObject2;
          localObject3 = localk.bD(str2, str1);
        }
        localObject4 = localObject2;
        Log.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", new Object[] { Integer.valueOf(i) });
        localObject4 = localObject2;
        localObject2.addRow(new Object[] { Integer.valueOf(1), Integer.valueOf(localk.mSampleRate), Integer.valueOf(localk.dzz), Integer.valueOf(2), localObject3 });
      }
      else
      {
        if (localObject3 != null)
        {
          ac(8, 0, 1);
          AppMethodBeat.o(24397);
          return localObject3;
        }
        ac(9, 3, 4);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(4);
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
    this.handler = new MMHandler();
    AppMethodBeat.o(24390);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(24391);
    Log.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", new Object[] { Integer.valueOf(this.sMO) });
    a(paramUri, this.context, this.sMO, this.sMN);
    paramArrayOfString1 = this.sMZ;
    if (paramUri == null)
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
      fP(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(5);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (Util.isNullOrNil(this.sMZ))
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
      fP(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(7);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (Util.isNullOrNil(cSt()))
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
      fP(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(6);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    if (!ckf())
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
      fP(1, 3);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(3);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    int i = 1;
    if (!IS_DEBUG) {
      i = cSu();
    }
    if (i != 1)
    {
      Log.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = ".concat(String.valueOf(i)));
      fP(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(i);
      AppMethodBeat.o(24391);
      return paramUri;
    }
    long l1;
    switch (this.sMO)
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
      fP(3, 15);
      AppMethodBeat.o(24391);
      return null;
    case 22: 
      paramUri = m(paramUri.getQueryParameter("op"), paramUri.getQueryParameter("scene"), paramUri.getQueryParameter("msgType"), paramUri.getQueryParameter("msgState"));
      AppMethodBeat.o(24391);
      return paramUri;
    case 23: 
      paramUri = y(paramArrayOfString2);
      AppMethodBeat.o(24391);
      return paramUri;
    case 25: 
      paramUri = z(paramArrayOfString2);
      AppMethodBeat.o(24391);
      return paramUri;
    case 34: 
      Log.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (paramArrayOfString2[0].length() <= 0))
      {
        if (paramArrayOfString2 == null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.e("MicroMsg.ExtControlProviderOpenApi", "sendSight wrong args,args == null:%s", new Object[] { Boolean.valueOf(bool) });
          fP(3, 3401);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(3401);
          AppMethodBeat.o(24391);
          return paramUri;
        }
      }
      paramUri = paramArrayOfString2[0];
      if ((Util.isNullOrNil(paramUri)) || (!s.YS(paramUri))) {
        i = 0;
      }
      while (i == 0)
      {
        Log.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
        fP(3, 3402);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(3402);
        AppMethodBeat.o(24391);
        return paramUri;
        paramArrayOfString1 = new d();
        if (SightVideoJNI.isSightOkVFS(paramUri, paramArrayOfString1.Dmj, paramArrayOfString1.Dmk, paramArrayOfString1.Dml, paramArrayOfString1.Dmn, paramArrayOfString1.Dmm, paramArrayOfString1.Dmm.length) == 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.addFlags(67108864);
      paramArrayOfString1.putExtra("sight_local_path", paramUri);
      com.tencent.mm.br.c.f(this.context, ".ui.transmit.SightForwardUI", paramArrayOfString1);
      ac(12, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 35: 
      Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (Util.isNullOrNil(paramArrayOfString2[0])))
      {
        Log.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
        fP(3, 3201);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(3201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", new Object[] { paramUri });
      i = new com.tencent.mm.plugin.ext.b.c(this.context, paramUri).cSp();
      Log.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", new Object[] { Integer.valueOf(i) });
      if (i != -1)
      {
        ac(14, 0, i);
        i = 0;
      }
      for (;;)
      {
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(i);
        AppMethodBeat.o(24391);
        return paramUri;
        ac(15, 0, i);
      }
    case 36: 
      Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        Log.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
        fP(3, 3301);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(3301);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      i = Util.getInt(paramArrayOfString2[1], -1);
      paramArrayOfString1 = paramArrayOfString2[2];
      Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", new Object[] { paramUri, Integer.valueOf(i), paramArrayOfString1 });
      if ((Util.isNullOrNil(paramUri)) || (i < 0) || (Util.isNullOrNil(paramArrayOfString1)))
      {
        Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
        fP(3, 3302);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(3302);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramString1 = new ws();
      paramString1.ede.edf = paramUri;
      paramString1.ede.edg = i;
      paramString1.ede.ebd = paramArrayOfString1;
      paramString1.ede.nickName = com.tencent.mm.pluginsdk.b.k(paramUri, this.context);
      EventCenter.instance.publish(paramString1);
      ac(16, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 37: 
      Log.d("MicroMsg.ExtControlProviderOpenApi", "getWifiList");
      this.handler = new MMHandler(Looper.getMainLooper());
      paramUri = (MatrixCursor)new ExtControlProviderOpenApi.2(this, paramArrayOfString2).exec(this.handler);
      if (paramUri == null)
      {
        ac(19, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(14);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ac(18, 0, 1);
      Log.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
      AppMethodBeat.o(24391);
      return paramUri;
    case 38: 
      Log.d("MicroMsg.ExtControlProviderOpenApi", "connectWifi");
      this.handler = new MMHandler(Looper.getMainLooper());
      paramUri = (Integer)new ExtControlProviderOpenApi.3(this, paramArrayOfString2).exec(this.handler);
      if (paramUri == null)
      {
        ac(21, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(14);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ac(20, 0, paramUri.intValue());
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(paramUri.intValue());
      AppMethodBeat.o(24391);
      return paramUri;
    case 42: 
      paramUri = new Intent();
      paramUri.addFlags(131072);
      paramUri.putExtra("key_from_scene", 4);
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0) && (paramArrayOfString2[0].length() > 0))
      {
        Log.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", new Object[] { paramArrayOfString2[0], paramArrayOfString1 });
        paramUri.putExtra("key_business_attach", paramArrayOfString2[0]);
      }
      for (;;)
      {
        paramUri.putExtra("key_appid", paramArrayOfString1);
        com.tencent.mm.br.c.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", paramUri);
        com.tencent.mm.plugin.report.service.h.CyF.a(12097, new Object[] { Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        ac(24, 0, 1);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
        AppMethodBeat.o(24391);
        return paramUri;
        Log.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", new Object[] { paramArrayOfString1 });
      }
    case 40: 
      Log.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        Log.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
        ac(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(2);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      l1 = Util.getLong(paramArrayOfString2[0], -1L);
      long l2 = Util.getLong(paramArrayOfString2[1], -1L);
      long l3 = Util.getLong(paramArrayOfString2[2], -1L);
      Log.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
      if ((l2 < 0L) || (l1 < 0L) || (l3 < 0L))
      {
        Log.i("MicroMsg.ExtControlProviderOpenApi", "param err");
        ac(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(2);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      cSq();
      paramUri = new ge();
      paramUri.dJP.action = 2;
      paramUri.dJP.dJR = l2;
      paramUri.dJP.dJS = l1;
      paramUri.dJP.bqc = l3;
      if ((EventCenter.instance.publish(paramUri)) && (paramUri.dJQ.dJT))
      {
        ac(22, 0, paramUri.dJQ.dJU);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(paramUri.dJQ.dJU);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      ac(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(8);
      AppMethodBeat.o(24391);
      return paramUri;
    case 41: 
      Log.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
      cSq();
      paramUri = new ge();
      paramUri.dJP.action = 3;
      if ((EventCenter.instance.publish(paramUri)) && (paramUri.dJQ.dJT))
      {
        paramArrayOfString1 = paramUri.dJQ.config;
        paramString1 = new MatrixCursor(sMH);
        paramString1.addRow(new Object[] { Integer.valueOf(paramUri.dJQ.dJU), Util.nullAsNil(paramArrayOfString1) });
        ac(22, 0, paramUri.dJQ.dJU);
        Log.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(paramUri.dJQ.dJU) });
        AppMethodBeat.o(24391);
        return paramString1;
      }
      ac(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(8);
      AppMethodBeat.o(24391);
      return paramUri;
    case 46: 
      Log.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", new Object[] { paramArrayOfString1 });
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        ac(27, 5, 4);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4101);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramUri = new Intent();
      paramUri.putExtra("key_from_openapi", true);
      paramUri.putExtra("key_openapi_appid", paramArrayOfString1);
      com.tencent.mm.br.c.b(this.context, "clean", ".ui.CleanUI", paramUri);
      ac(26, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
      AppMethodBeat.o(24391);
      return paramUri;
    case 48: 
      com.tencent.mm.plugin.ext.d.e.cSE().mContext = this.context;
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
      {
        Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      i = Util.getInt(paramArrayOfString2[0], -1);
      if ((i < 0) || ((i != 0) && (i != 1) && (i != 2)))
      {
        Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
        ac(32, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4201);
        AppMethodBeat.o(24391);
        return paramUri;
      }
      paramArrayOfString1 = null;
      if ((i == 0) || (i == 1))
      {
        if (paramArrayOfString2.length < 2)
        {
          Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4205);
          AppMethodBeat.o(24391);
          return paramUri;
        }
        paramUri = paramArrayOfString2[1];
        if (i == 1)
        {
          if (paramArrayOfString2.length < 3)
          {
            Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4208);
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
      Log.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", new Object[] { Integer.valueOf(i), paramUri });
      switch (i)
      {
      default: 
        AppMethodBeat.o(24391);
        return null;
      case 0: 
        paramString1 = com.tencent.mm.plugin.ext.d.e.cSE();
        if (Util.isNullOrNil(paramUri))
        {
          Log.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
          com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4205);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4205);
          AppMethodBeat.o(24391);
          return paramUri;
        }
        paramArrayOfString1 = com.tencent.mm.plugin.ext.d.c.art(paramUri);
        if ((paramArrayOfString1 != null) && (!Util.isNullOrNil(paramArrayOfString1.url)))
        {
          Log.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramArrayOfString1 });
          paramUri = paramArrayOfString1;
        }
        break;
      }
      for (;;)
      {
        if (paramUri.type == 19)
        {
          if (com.tencent.mm.plugin.ext.d.c.arv(paramUri.url))
          {
            Log.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url.toUpperCase() });
            com.tencent.mm.plugin.ext.d.e.Z(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.bdj(paramUri.url);
            AppMethodBeat.o(24391);
            return paramUri;
            paramUri = com.tencent.mm.plugin.ext.d.e.bc(paramUri, false);
            if (paramUri == null)
            {
              Log.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
              com.tencent.mm.plugin.ext.d.e.Z(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4206);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramUri = paramString1.a(paramUri);
            if ((paramUri == null) || (Util.isNullOrNil(paramUri.url)))
            {
              Log.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4203);
              AppMethodBeat.o(24391);
              return paramUri;
            }
          }
          else
          {
            if (com.tencent.mm.plugin.ext.d.c.aru(paramUri.url))
            {
              Log.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", new Object[] { paramUri.url });
              com.tencent.mm.plugin.ext.d.e.Z(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            l1 = Util.currentTicks();
            paramArrayOfString1 = com.tencent.mm.plugin.ext.d.c.arw(paramUri.url);
            Log.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", new Object[] { paramArrayOfString1.toString(), Long.valueOf(Util.ticksToNow(l1)) });
            if (paramArrayOfString1 == b.b.sNT)
            {
              com.tencent.mm.plugin.ext.d.c.arr(paramUri.url);
              com.tencent.mm.plugin.ext.d.e.Z(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (paramArrayOfString1 != b.b.sNS)
            {
              paramArrayOfString1 = paramUri.url;
              i = paramUri.type;
              int j = paramUri.sOh;
              Log.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", new Object[] { paramArrayOfString1 });
              l1 = System.currentTimeMillis();
              paramArrayOfString1 = (Boolean)new e.2(paramString1, Boolean.TRUE, paramArrayOfString1, i, j).exec(com.tencent.mm.plugin.ext.d.e.cSG());
              Log.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", new Object[] { paramArrayOfString1, Long.valueOf(System.currentTimeMillis() - l1) });
              if (paramArrayOfString1.booleanValue())
              {
                com.tencent.mm.plugin.ext.d.c.arr(paramUri.url);
                com.tencent.mm.plugin.ext.d.e.Z(paramUri.url, paramUri.type, 1);
                paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
                AppMethodBeat.o(24391);
                return paramUri;
              }
            }
            com.tencent.mm.plugin.ext.d.c.ars(paramUri.url);
            Log.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.d.e.Z(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.bdj(paramUri.url);
            AppMethodBeat.o(24391);
            return paramUri;
          }
        }
        else
        {
          Log.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
          AppMethodBeat.o(24391);
          return paramUri;
          paramArrayOfString2 = com.tencent.mm.plugin.ext.d.e.cSE();
          if (Util.isNullOrNil(paramUri))
          {
            Log.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
            com.tencent.mm.plugin.ext.d.e.aa(null, -1, 4205);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4205);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramString1 = com.tencent.mm.plugin.ext.d.c.art(paramUri);
          if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.url))) {
            Log.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramString1 });
          }
          for (paramUri = paramString1; (paramUri.type == 19) && (com.tencent.mm.plugin.ext.d.c.arv(paramUri.url)); paramUri = paramArrayOfString1)
          {
            Log.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.d.e.aa(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4207);
            AppMethodBeat.o(24391);
            return paramUri;
            if (Util.isNullOrNil(paramArrayOfString1))
            {
              Log.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
              com.tencent.mm.plugin.ext.d.e.aa(null, -1, 4208);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4208);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramString1 = com.tencent.mm.plugin.ext.d.e.bc(paramUri, true);
            if (paramString1 == null)
            {
              Log.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
              com.tencent.mm.plugin.ext.d.e.aa(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4206);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (Util.isNullOrNil(paramString1.md5))
            {
              Log.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
              com.tencent.mm.plugin.ext.d.e.aa(null, -1, 4210);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4210);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            if (!paramString1.md5.equalsIgnoreCase(paramArrayOfString1))
            {
              Log.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
              com.tencent.mm.plugin.ext.d.e.aa(null, -1, 4209);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4209);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            paramArrayOfString1 = paramArrayOfString2.a(paramString1);
            if ((paramArrayOfString1 == null) || (Util.isNullOrNil(paramArrayOfString1.url)))
            {
              Log.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              com.tencent.mm.plugin.ext.d.e.aa(null, -1, 4203);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(4203);
              AppMethodBeat.o(24391);
              return paramUri;
            }
            com.tencent.mm.plugin.ext.d.c.a(paramUri, paramArrayOfString1);
          }
          Log.i("MicroMsg.ExtQrCodeHandler", "hy: do open");
          Log.i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", new Object[] { paramUri.toString() });
          paramArrayOfString1 = new Intent(paramArrayOfString2.mContext, RedirectToQrCodeStubUI.class);
          paramArrayOfString1.putExtra("K_STR", paramUri.url);
          paramArrayOfString1.putExtra("K_TYPE", paramUri.type);
          paramArrayOfString1.putExtra("K_VERSION", paramUri.sOh);
          paramArrayOfString1.addFlags(268435456);
          paramString1 = paramArrayOfString2.mContext;
          paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramArrayOfString1);
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramArrayOfString1.axQ(), "com/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler", "handleOpen", "(Lcom/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler$QrCodeModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramArrayOfString1.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler", "handleOpen", "(Lcom/tencent/mm/plugin/ext/qrcode/ExtQrCodeHandler$QrCodeModel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.ext.d.e.aa(paramUri.url, paramUri.type, 1);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
          AppMethodBeat.o(24391);
          return paramUri;
          com.tencent.mm.plugin.ext.d.e.cSE();
          paramUri = com.tencent.mm.plugin.ext.d.e.cSF();
          AppMethodBeat.o(24391);
          return paramUri;
          paramUri = a(paramArrayOfString2, false);
          AppMethodBeat.o(24391);
          return paramUri;
          if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
          {
            Log.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(2);
            AppMethodBeat.o(24391);
            return paramUri;
          }
          paramUri = x(new String[] { paramArrayOfString2[0], "0" });
          AppMethodBeat.o(24391);
          return paramUri;
          paramUri = x(paramArrayOfString2);
          AppMethodBeat.o(24391);
          return paramUri;
          this.handler = new MMHandler(Looper.getMainLooper());
          paramUri = (Cursor)new ExtControlProviderOpenApi.1(this, com.tencent.mm.pluginsdk.d.a.a.ahx(4302), paramArrayOfString2).exec(this.handler);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi
 * JD-Core Version:    0.7.0.1
 */