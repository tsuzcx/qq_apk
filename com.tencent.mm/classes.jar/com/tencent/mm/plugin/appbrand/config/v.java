package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.protocal.protobuf.duq;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class v
  extends t
{
  public v(com.tencent.mm.sdk.e.e parame)
  {
    super(parame);
    AppMethodBeat.i(44905);
    Cursor localCursor;
    if (aTJ())
    {
      parame = (f)parame;
      if (!g.afB().afk().getBoolean(ae.a.FlL, false))
      {
        ad.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "before fix");
        localCursor = parame.a("select appInfo from WxaAttributesTable", null, 2);
        if ((localCursor == null) || (localCursor.isClosed()))
        {
          ad.e("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "try fix but db not working");
          AppMethodBeat.o(44905);
          return;
        }
        if (!localCursor.moveToFirst()) {
          break label362;
        }
        Object localObject1 = new LinkedList();
        Object localObject2 = localCursor.getString(0);
        if (!bt.isNullOrNil((String)localObject2)) {}
        for (;;)
        {
          try
          {
            localObject3 = new JSONObject((String)localObject2);
            localObject2 = ((JSONObject)localObject3).optString("Appid");
            localObject3 = ((JSONObject)localObject3).optString("RoundedSquareIconUrl");
            if (!bt.isNullOrNil((String)localObject2))
            {
              boolean bool = bt.isNullOrNil((String)localObject3);
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
            parame.mX(l);
            ad.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
          }
          if (localCursor.moveToNext()) {
            break;
          }
          localCursor.close();
          l = parame.rb(Thread.currentThread().getId());
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
      g.afB().afk().set(ae.a.FlL, Boolean.TRUE);
      AppMethodBeat.o(44905);
      return;
      label362:
      ad.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
    }
  }
  
  protected final boolean a(WxaAttributes paramWxaAttributes, duq paramduq)
  {
    AppMethodBeat.i(44908);
    boolean bool = super.a(paramWxaAttributes, paramduq);
    if ((bool) && ("WxaAppInfo".equals(paramduq.sdv)))
    {
      paramWxaAttributes = paramWxaAttributes.field_appId;
      paramduq = paramduq.vJI;
      h.Iye.f(new v.2(this, paramduq, paramWxaAttributes), "MicroMsg.WxaAttrStorageWCTHREAD_TAG_POST_FLUSH_ATTRS");
    }
    AppMethodBeat.o(44908);
    return bool;
  }
  
  public final boolean a(String paramString, b paramb, List<duq> paramList)
  {
    AppMethodBeat.i(44906);
    if (!g.afz().gcn)
    {
      ad.e("MicroMsg.WxaAttrStorageWC", "flushAttrs username[%s], account().isInitializedNotifyAllDone()==FALSE", new Object[] { paramString });
      AppMethodBeat.o(44906);
      return false;
    }
    boolean bool = super.a(paramString, paramb, paramList);
    paramb = super.d(paramString, new String[] { "appId", "versionInfo", "nickname", "bigHeadURL", "smallHeadURL" });
    if (paramb == null)
    {
      ad.e("MicroMsg.WxaAttrStorageWC", "flushAttrs, get NULL record with username[%s]", new Object[] { paramString });
      AppMethodBeat.o(44906);
      return bool;
    }
    paramString = paramb.aTP();
    if ((paramString != null) && (paramString.cfk == 0))
    {
      paramString = j.aOK();
      if (paramString != null) {
        paramString.a(paramb.field_appId, paramb.aTP());
      }
    }
    if (bool) {
      h.Iye.f(new v.1(this, paramb), "MicroMsg.WxaAttrStorageWCTHREAD_TAG_POST_FLUSH_ATTRS");
    }
    AppMethodBeat.o(44906);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(195690);
    super.add("MicroMsg.WxaAttrStorageWC.WORKER", parama);
    AppMethodBeat.o(195690);
  }
  
  protected final boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44907);
    paramBoolean = super.j(paramString, paramInt, paramBoolean);
    if (paramBoolean)
    {
      WxaAttributes localWxaAttributes = d(paramString, new String[] { "appOpt" });
      nf localnf = new nf();
      localnf.dsk.dbj = paramString;
      localnf.dsk.dsl = localWxaAttributes.field_appOpt;
      com.tencent.mm.sdk.b.a.ESL.l(localnf);
    }
    AppMethodBeat.o(44907);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.v
 * JD-Core Version:    0.7.0.1
 */