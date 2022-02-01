package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
    if (beh())
    {
      parame = (f)parame;
      if (!g.ajC().ajl().getBoolean(al.a.IvS, false))
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
          break label367;
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
            parame.sJ(l);
            ad.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
          }
          if (localCursor.moveToNext()) {
            break;
          }
          localCursor.close();
          l = parame.xO(Thread.currentThread().getId());
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
      g.ajC().ajl().set(al.a.IvS, Boolean.TRUE);
      AppMethodBeat.o(44905);
      return;
      label367:
      ad.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
    }
  }
  
  protected final boolean a(final WxaAttributes paramWxaAttributes, final egl paramegl)
  {
    AppMethodBeat.i(44908);
    boolean bool = super.a(paramWxaAttributes, paramegl);
    if ((bool) && ("WxaAppInfo".equals(paramegl.ujy)))
    {
      paramWxaAttributes = paramWxaAttributes.field_appId;
      paramegl = paramegl.yhw;
      h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44904);
          try
          {
            ek localek = r.x(new JSONObject(paramegl));
            p.b(paramWxaAttributes, localek.Fwi);
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
  
  public final boolean a(String paramString, final b paramb, List<egl> paramList)
  {
    AppMethodBeat.i(44906);
    if (!g.ajA().gAD)
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
    paramString = paramb.ben();
    if ((paramString != null) && (paramString.cmx == 0))
    {
      paramString = j.aYX();
      if (paramString != null) {
        paramString.a(paramb.field_appId, paramb.ben());
      }
    }
    if (bool) {
      h.LTJ.f(new Runnable()
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
            ad.printErrStackTrace("MicroMsg.WxaAttrStorageWC", localException, "flushContactInMainDB", new Object[0]);
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
    AppMethodBeat.i(188104);
    super.add("MicroMsg.WxaAttrStorageWC.WORKER", parama);
    AppMethodBeat.o(188104);
  }
  
  protected final boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44907);
    paramBoolean = super.j(paramString, paramInt, paramBoolean);
    if (paramBoolean)
    {
      WxaAttributes localWxaAttributes = d(paramString, new String[] { "appOpt" });
      nw localnw = new nw();
      localnw.dBI.djX = paramString;
      localnw.dBI.dBJ = localWxaAttributes.field_appOpt;
      com.tencent.mm.sdk.b.a.IbL.l(localnw);
    }
    AppMethodBeat.o(44907);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.w
 * JD-Core Version:    0.7.0.1
 */