package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class w
  extends u
{
  public w(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, "WxaAttributesTable", WxaAttributes.INDEX_CREATE);
    AppMethodBeat.i(44905);
    Cursor localCursor;
    if (beO())
    {
      parame = (f)parame;
      if (!g.ajR().ajA().getBoolean(am.a.IQq, false))
      {
        ae.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "before fix");
        localCursor = parame.a("select appInfo from WxaAttributesTable", null, 2);
        if ((localCursor == null) || (localCursor.isClosed()))
        {
          ae.e("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "try fix but db not working");
          AppMethodBeat.o(44905);
          return;
        }
        if (!localCursor.moveToFirst()) {
          break label367;
        }
        Object localObject1 = new LinkedList();
        Object localObject2 = localCursor.getString(0);
        if (!bu.isNullOrNil((String)localObject2)) {}
        for (;;)
        {
          try
          {
            localObject3 = new JSONObject((String)localObject2);
            localObject2 = ((JSONObject)localObject3).optString("Appid");
            localObject3 = ((JSONObject)localObject3).optString("RoundedSquareIconUrl");
            if (!bu.isNullOrNil((String)localObject2))
            {
              boolean bool = bu.isNullOrNil((String)localObject3);
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
            parame.sW(l);
            ae.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
          }
          if (localCursor.moveToNext()) {
            break;
          }
          localCursor.close();
          l = parame.yi(Thread.currentThread().getId());
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
      g.ajR().ajA().set(am.a.IQq, Boolean.TRUE);
      AppMethodBeat.o(44905);
      return;
      label367:
      ae.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
    }
  }
  
  protected final boolean a(final WxaAttributes paramWxaAttributes, final eic parameic)
  {
    AppMethodBeat.i(44908);
    boolean bool = super.a(paramWxaAttributes, parameic);
    if ((bool) && ("WxaAppInfo".equals(parameic.uuW)))
    {
      paramWxaAttributes = paramWxaAttributes.field_appId;
      parameic = parameic.yxn;
      h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44904);
          try
          {
            ek localek = r.x(new JSONObject(parameic));
            p.b(paramWxaAttributes, localek.FOG);
            AppMethodBeat.o(44904);
            return;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(44904);
          }
        }
      }, "MicroMsg.WxaAttrStorageWCTHREAD_TAG_POST_FLUSH_ATTRS");
    }
    AppMethodBeat.o(44908);
    return bool;
  }
  
  public final boolean a(String paramString, final b paramb, List<eic> paramList)
  {
    AppMethodBeat.i(44906);
    if (!g.ajP().gDk)
    {
      ae.e("MicroMsg.WxaAttrStorageWC", "flushAttrs username[%s], account().isInitializedNotifyAllDone()==FALSE", new Object[] { paramString });
      AppMethodBeat.o(44906);
      return false;
    }
    boolean bool = super.a(paramString, paramb, paramList);
    paramb = super.d(paramString, new String[] { "appId", "versionInfo", "nickname", "bigHeadURL", "smallHeadURL" });
    if (paramb == null)
    {
      ae.e("MicroMsg.WxaAttrStorageWC", "flushAttrs, get NULL record with username[%s]", new Object[] { paramString });
      AppMethodBeat.o(44906);
      return bool;
    }
    paramString = paramb.beV();
    if ((paramString != null) && (paramString.cmz == 0))
    {
      paramString = j.aZu();
      if (paramString != null) {
        paramString.a(paramb.field_appId, paramb.beV());
      }
    }
    if (bool) {
      h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44903);
          try
          {
            w.f(paramb);
            AppMethodBeat.o(44903);
            return;
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace("MicroMsg.WxaAttrStorageWC", localException, "flushContactInMainDB", new Object[0]);
            AppMethodBeat.o(44903);
          }
        }
      }, "MicroMsg.WxaAttrStorageWCTHREAD_TAG_POST_FLUSH_ATTRS");
    }
    AppMethodBeat.o(44906);
    return bool;
  }
  
  public void add(k.a parama)
  {
    AppMethodBeat.i(222228);
    super.add("MicroMsg.WxaAttrStorageWC.WORKER", parama);
    AppMethodBeat.o(222228);
  }
  
  protected final boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44907);
    paramBoolean = super.j(paramString, paramInt, paramBoolean);
    if (paramBoolean)
    {
      WxaAttributes localWxaAttributes = d(paramString, new String[] { "appOpt" });
      nx localnx = new nx();
      localnx.dCN.dkZ = paramString;
      localnx.dCN.dCO = localWxaAttributes.field_appOpt;
      com.tencent.mm.sdk.b.a.IvT.l(localnx);
    }
    AppMethodBeat.o(44907);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.w
 * JD-Core Version:    0.7.0.1
 */