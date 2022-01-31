package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.bv.b;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class r
  extends p
{
  public r(com.tencent.mm.sdk.e.e parame)
  {
    super(parame);
    AppMethodBeat.i(129901);
    Cursor localCursor;
    if (ayz())
    {
      parame = (f)parame;
      if (!com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yDn, false))
      {
        ab.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "before fix");
        localCursor = parame.a("select appInfo from WxaAttributesTable", null, 2);
        if ((localCursor == null) || (localCursor.isClosed()))
        {
          ab.e("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "try fix but db not working");
          AppMethodBeat.o(129901);
          return;
        }
        if (!localCursor.moveToFirst()) {
          break label362;
        }
        Object localObject1 = new LinkedList();
        Object localObject2 = localCursor.getString(0);
        if (!bo.isNullOrNil((String)localObject2)) {}
        for (;;)
        {
          try
          {
            localObject3 = new JSONObject((String)localObject2);
            localObject2 = ((JSONObject)localObject3).optString("Appid");
            localObject3 = ((JSONObject)localObject3).optString("RoundedSquareIconUrl");
            if (!bo.isNullOrNil((String)localObject2))
            {
              boolean bool = bo.isNullOrNil((String)localObject3);
              if (!bool) {
                continue;
              }
            }
          }
          catch (Exception localException)
          {
            Object localObject3;
            long l;
            ContentValues localContentValues;
            continue;
            parame.nY(l);
            ab.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
          }
          if (localCursor.moveToNext()) {
            break;
          }
          localCursor.close();
          l = parame.kr(Thread.currentThread().getId());
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (Pair)((Iterator)localObject1).next();
          parame.update("WxaAttributesTable", (ContentValues)((Pair)localObject2).second, "appId=?", new String[] { (String)((Pair)localObject2).first });
          continue;
          localContentValues = new ContentValues(1);
          localContentValues.put("roundedSquareIconURL", (String)localObject3);
          ((List)localObject1).add(Pair.create(localObject2, localContentValues));
        }
      }
    }
    for (;;)
    {
      if (!localCursor.isClosed()) {
        localCursor.close();
      }
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yDn, Boolean.TRUE);
      AppMethodBeat.o(129901);
      return;
      label362:
      ab.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
    }
  }
  
  protected final boolean a(WxaAttributes paramWxaAttributes, daa paramdaa)
  {
    AppMethodBeat.i(129904);
    boolean bool = super.a(paramWxaAttributes, paramdaa);
    if ((bool) && ("WxaAppInfo".equals(paramdaa.wxP))) {}
    try
    {
      paramdaa = n.s(new JSONObject(paramdaa.qsu));
      m.b(paramWxaAttributes.field_appId, paramdaa.wpH);
      label54:
      AppMethodBeat.o(129904);
      return bool;
    }
    catch (Exception paramWxaAttributes)
    {
      break label54;
    }
  }
  
  public final boolean a(String paramString, b paramb, List<daa> paramList)
  {
    AppMethodBeat.i(129902);
    if (!com.tencent.mm.kernel.g.RJ().eHg)
    {
      ab.e("MicroMsg.WxaAttrStorageWC", "flushAttrs username[%s], account().isInitializedNotifyAllDone()==FALSE", new Object[] { paramString });
      AppMethodBeat.o(129902);
      return false;
    }
    bool = super.a(paramString, paramb, paramList);
    Object localObject = d(paramString, new String[0]);
    if (localObject == null)
    {
      ab.e("MicroMsg.WxaAttrStorageWC", "flushAttrs, get NULL record with username[%s]", new Object[] { paramString });
      AppMethodBeat.o(129902);
      return bool;
    }
    paramString = ((WxaAttributes)localObject).ayE();
    if ((paramString != null) && (paramString.bDd == 0)) {
      com.tencent.mm.plugin.appbrand.app.g.auM().a(((WxaAttributes)localObject).field_appId, ((WxaAttributes)localObject).ayE());
    }
    if (bool) {}
    try
    {
      if (!com.tencent.mm.kernel.g.RG()) {
        break label366;
      }
      paramList = ((WxaAttributes)localObject).field_username;
      paramb = ((WxaAttributes)localObject).field_nickname;
      str = ((WxaAttributes)localObject).field_bigHeadURL;
      localObject = ((WxaAttributes)localObject).field_smallHeadURL;
      paramString = o.adg().rj(paramList);
      if (paramString != null) {
        break label408;
      }
      paramString = new h();
      i = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        try
        {
          String str;
          paramString.jq(com.tencent.mm.platformtools.g.wr(paramb));
          try
          {
            paramString.jr(com.tencent.mm.platformtools.g.wq(paramb));
            i = 1;
            if (i != 0) {
              ((j)com.tencent.mm.kernel.g.E(j.class)).YA().W(paramString);
            }
            AppMethodBeat.o(129902);
            return bool;
            paramString = paramString;
            ab.printErrStackTrace("MicroMsg.WxaAttrStorageWC", paramString, "flushContactInMainDB", new Object[0]);
            continue;
          }
          catch (UnsatisfiedLinkError paramb)
          {
            continue;
          }
        }
        catch (UnsatisfiedLinkError paramList)
        {
          continue;
        }
        int i = 0;
        continue;
        continue;
        i = 0;
      }
    }
    if (!bo.nullAsNil((String)localObject).equals(paramString.acY()))
    {
      paramString.fsk = ((String)localObject);
      i = 1;
    }
    if (!bo.nullAsNil(str).equals(paramString.acX()))
    {
      paramString.fsl = str;
      i = 1;
    }
    if (i != 0)
    {
      paramString.username = paramList;
      paramString.cM(true);
      paramString.bsY = 31;
      o.adg().b(paramString);
    }
    paramString = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(paramList);
    if (paramString == null)
    {
      paramString = new ad();
      if ((int)paramString.euF == 0)
      {
        paramString.setUsername(paramList);
        i = 1;
        if (!paramb.equals(paramString.field_nickname)) {
          paramString.jp(paramb);
        }
      }
    }
  }
  
  protected final boolean k(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129903);
    paramBoolean = super.k(paramString, paramInt, paramBoolean);
    if (paramBoolean)
    {
      WxaAttributes localWxaAttributes = d(paramString, new String[] { "appOpt" });
      lt locallt = new lt();
      locallt.cBL.cmx = paramString;
      locallt.cBL.cBM = localWxaAttributes.field_appOpt;
      com.tencent.mm.sdk.b.a.ymk.l(locallt);
    }
    AppMethodBeat.o(129903);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.r
 * JD-Core Version:    0.7.0.1
 */