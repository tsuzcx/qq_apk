package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.no;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
    if (baH())
    {
      parame = (f)parame;
      if (!g.agR().agA().getBoolean(ah.a.GJA, false))
      {
        ac.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "before fix");
        localCursor = parame.a("select appInfo from WxaAttributesTable", null, 2);
        if ((localCursor == null) || (localCursor.isClosed()))
        {
          ac.e("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "try fix but db not working");
          AppMethodBeat.o(44905);
          return;
        }
        if (!localCursor.moveToFirst()) {
          break label362;
        }
        Object localObject1 = new LinkedList();
        Object localObject2 = localCursor.getString(0);
        if (!bs.isNullOrNil((String)localObject2)) {}
        for (;;)
        {
          try
          {
            localObject3 = new JSONObject((String)localObject2);
            localObject2 = ((JSONObject)localObject3).optString("Appid");
            localObject3 = ((JSONObject)localObject3).optString("RoundedSquareIconUrl");
            if (!bs.isNullOrNil((String)localObject2))
            {
              boolean bool = bs.isNullOrNil((String)localObject3);
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
            parame.qL(l);
            ac.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
          }
          if (localCursor.moveToNext()) {
            break;
          }
          localCursor.close();
          l = parame.vE(Thread.currentThread().getId());
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
      g.agR().agA().set(ah.a.GJA, Boolean.TRUE);
      AppMethodBeat.o(44905);
      return;
      label362:
      ac.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
    }
  }
  
  protected final boolean a(final WxaAttributes paramWxaAttributes, final eah parameah)
  {
    AppMethodBeat.i(44908);
    boolean bool = super.a(paramWxaAttributes, parameah);
    if ((bool) && ("WxaAppInfo".equals(parameah.tlp)))
    {
      paramWxaAttributes = paramWxaAttributes.field_appId;
      parameah = parameah.wTM;
      h.JZN.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44904);
          try
          {
            eg localeg = r.x(new JSONObject(parameah));
            p.b(paramWxaAttributes, localeg.DQQ);
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
  
  public final boolean a(String paramString, final b paramb, List<eah> paramList)
  {
    AppMethodBeat.i(44906);
    if (!g.agP().ggT)
    {
      ac.e("MicroMsg.WxaAttrStorageWC", "flushAttrs username[%s], account().isInitializedNotifyAllDone()==FALSE", new Object[] { paramString });
      AppMethodBeat.o(44906);
      return false;
    }
    boolean bool = super.a(paramString, paramb, paramList);
    paramb = super.d(paramString, new String[] { "appId", "versionInfo", "nickname", "bigHeadURL", "smallHeadURL" });
    if (paramb == null)
    {
      ac.e("MicroMsg.WxaAttrStorageWC", "flushAttrs, get NULL record with username[%s]", new Object[] { paramString });
      AppMethodBeat.o(44906);
      return bool;
    }
    paramString = paramb.baN();
    if ((paramString != null) && (paramString.ccg == 0))
    {
      paramString = j.aVC();
      if (paramString != null) {
        paramString.a(paramb.field_appId, paramb.baN());
      }
    }
    if (bool) {
      h.JZN.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44903);
          try
          {
            v.e(paramb);
            AppMethodBeat.o(44903);
            return;
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.WxaAttrStorageWC", localException, "flushContactInMainDB", new Object[0]);
            AppMethodBeat.o(44903);
          }
        }
      }, "MicroMsg.WxaAttrStorageWCTHREAD_TAG_POST_FLUSH_ATTRS");
    }
    AppMethodBeat.o(44906);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(186410);
    super.add("MicroMsg.WxaAttrStorageWC.WORKER", parama);
    AppMethodBeat.o(186410);
  }
  
  protected final boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44907);
    paramBoolean = super.j(paramString, paramInt, paramBoolean);
    if (paramBoolean)
    {
      WxaAttributes localWxaAttributes = d(paramString, new String[] { "appOpt" });
      no localno = new no();
      localno.dpV.cYF = paramString;
      localno.dpV.dpW = localWxaAttributes.field_appOpt;
      com.tencent.mm.sdk.b.a.GpY.l(localno);
    }
    AppMethodBeat.o(44907);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.v
 * JD-Core Version:    0.7.0.1
 */