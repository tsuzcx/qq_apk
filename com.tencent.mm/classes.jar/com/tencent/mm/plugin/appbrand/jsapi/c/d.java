package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.c;
import com.tencent.mm.plugin.appbrand.widget.input.x;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends h
{
  private static final int CTRL_INDEX = 110;
  private static final String NAME = "insertTextArea";
  
  protected final i a(final WeakReference<aa> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136267);
    paramWeakReference = new x()
    {
      private void bgT()
      {
        AppMethodBeat.i(136263);
        aa localaa = (aa)paramWeakReference.get();
        if ((localaa == null) || (localaa.lyE == null))
        {
          AppMethodBeat.o(136263);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.bzW().e(localaa.lyE);
        AppMethodBeat.o(136263);
      }
      
      public final void Mi(String paramAnonymousString)
      {
        AppMethodBeat.i(136261);
        aa localaa = (aa)paramWeakReference.get();
        if (localaa == null)
        {
          AppMethodBeat.o(136261);
          return;
        }
        try
        {
          int i = this.mCW;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", com.tencent.mm.plugin.appbrand.utils.e.Rv(paramAnonymousString)).put("data", d.sB(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localaa.getRuntime().CX(), localaa.aUT()).LN(paramAnonymousString.toString()).beN();
          AppMethodBeat.o(136261);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ac.e("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136261);
        }
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136259);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.appbrand.utils.e.Rv(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.mCW).put("cursor", paramAnonymousInt).toString();
          if (paramAnonymousBoolean1) {
            ((aa)paramWeakReference.get()).c("onKeyboardConfirm", paramAnonymousString, 0);
          }
          if (!paramAnonymousBoolean2) {
            ((aa)paramWeakReference.get()).c("onKeyboardComplete", paramAnonymousString, 0);
          }
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", new Object[] { bs.m(paramAnonymousString) });
          }
        }
        if (!paramAnonymousBoolean2) {
          bgT();
        }
        AppMethodBeat.o(136259);
      }
      
      public final void bgR()
      {
        AppMethodBeat.i(136260);
        if (paramWeakReference.get() != null)
        {
          int i = this.mCW;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((aa)paramWeakReference.get()).h(paramInt, d.this.k("ok", localHashMap));
          d.ag(i, paramString);
          d.a(i, (aa)paramWeakReference.get());
        }
        AppMethodBeat.o(136260);
      }
      
      public final void bgS()
      {
        AppMethodBeat.i(136262);
        if (paramWeakReference.get() != null)
        {
          ((aa)paramWeakReference.get()).h(paramInt, d.this.e("fail", null));
          bgT();
        }
        AppMethodBeat.o(136262);
      }
    };
    AppMethodBeat.o(136267);
    return paramWeakReference;
  }
  
  public final void a(aa paramaa, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136264);
    super.a(paramaa, paramJSONObject, paramInt);
    AppMethodBeat.o(136264);
  }
  
  protected final void a(final i parami)
  {
    AppMethodBeat.i(136266);
    super.a(parami);
    parami.mCP = new i.c()
    {
      public final void dP(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(136258);
        int i = parami.mCW;
        Object localObject = y.ayq().xH("AppBrandJsInput@".concat(String.valueOf(i)));
        if (localObject == null) {
          localObject = null;
        }
        while ((localObject == null) || (!((aa)localObject).isRunning()))
        {
          AppMethodBeat.o(136258);
          return;
          localObject = (WeakReference)((y.b)localObject).get("webview_reference", null);
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = (aa)((WeakReference)localObject).get();
          }
        }
        d.a locala = new d.a((byte)0);
        HashMap localHashMap = new HashMap();
        localHashMap.put("height", Integer.valueOf(g.vd(paramAnonymousInt2)));
        localHashMap.put("lineCount", Integer.valueOf(paramAnonymousInt1));
        localHashMap.put("inputId", Integer.valueOf(i));
        locala.g((c)localObject).A(localHashMap).beN();
        AppMethodBeat.o(136258);
      }
    };
    AppMethodBeat.o(136266);
  }
  
  protected final boolean a(com.tencent.mm.plugin.appbrand.widget.input.d.e parame, JSONObject paramJSONObject, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(136265);
    if (!super.a(parame, paramJSONObject, paramaa, paramInt))
    {
      AppMethodBeat.o(136265);
      return false;
    }
    parame.mIQ = Boolean.TRUE;
    parame.clf = "emoji";
    parame.cli = false;
    parame.mIv = false;
    parame.mIW = Boolean.FALSE;
    parame.mIR = Boolean.valueOf(paramJSONObject.optBoolean("confirm", true));
    AppMethodBeat.o(136265);
    return true;
  }
  
  protected final boolean bgP()
  {
    return false;
  }
  
  protected final boolean bgQ()
  {
    return false;
  }
  
  static final class a
    extends p
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onTextAreaHeightChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.d
 * JD-Core Version:    0.7.0.1
 */