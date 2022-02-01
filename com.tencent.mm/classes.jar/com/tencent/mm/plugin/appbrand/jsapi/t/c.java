package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.az;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.av;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.d<s>
{
  private static final int CTRL_INDEX = 104;
  private static final String NAME = "showModal";
  
  public final void a(final s params, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(177329);
    final ac localac = params.getCurrentPageView();
    if (localac == null)
    {
      if ((params.getRuntime() != null) && (!params.getRuntime().isDestroyed()) && (!params.getRuntime().mInitialized))
      {
        Log.w("MicroMsg.JsApiShowModal", "invoke with appId[%s] callbackId[%d] runtime !initialized, retry", new Object[] { params.getAppId(), Integer.valueOf(paramInt) });
        params.getRuntime().O(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(138262);
            Log.i("MicroMsg.JsApiShowModal", "invoke after runtime initialized appId[%s] callbackId[%d]", new Object[] { params.getAppId(), Integer.valueOf(paramInt) });
            c.this.a(params, paramJSONObject, paramInt);
            AppMethodBeat.o(138262);
          }
        });
        AppMethodBeat.o(177329);
        return;
      }
      Log.w("MicroMsg.JsApiShowModal", "invoke failed with appId[%s] callbackId[%d], current page view is null.", new Object[] { params.getAppId(), Integer.valueOf(paramInt) });
      params.i(paramInt, h("fail:page don't exist", null));
      AppMethodBeat.o(177329);
      return;
    }
    final String str1 = paramJSONObject.optString("title");
    final String str2 = paramJSONObject.optString("confirmText", params.getContext().getString(2131762798));
    final String str3 = paramJSONObject.optString("cancelText", params.getContext().getString(2131762796));
    final boolean bool1 = paramJSONObject.optBoolean("showCancel", true);
    final boolean bool2 = paramJSONObject.optBoolean("editable", false);
    final int i;
    if (j.cDv.isDarkMode()) {
      i = com.tencent.mm.plugin.appbrand.ac.g.cu(paramJSONObject.optString("confirmColorDark", ""), MMApplicationContext.getContext().getResources().getColor(2131100063));
    }
    for (final int j = com.tencent.mm.plugin.appbrand.ac.g.cu(paramJSONObject.optString("cancelColorDark", ""), MMApplicationContext.getContext().getResources().getColor(2131100044));; j = com.tencent.mm.plugin.appbrand.ac.g.cu(paramJSONObject.optString("cancelColor", ""), MMApplicationContext.getContext().getResources().getColor(2131100044)))
    {
      final String str4 = paramJSONObject.optString("content");
      Log.i("MicroMsg.JsApiShowModal", "showModal appId[%s] title[%s] content[%s]", new Object[] { params.getAppId(), str1, str4 });
      params.P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(177328);
          if (!params.isRunning())
          {
            AppMethodBeat.o(177328);
            return;
          }
          localac.nqO.a(az.ntg);
          Object localObject1 = new com.tencent.mm.plugin.appbrand.widget.dialog.b(params.getContext());
          if (!Util.isNullOrNil(str1))
          {
            if ((Util.isNullOrNil(str4)) && (!bool2)) {
              ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).setMessage(str1);
            }
          }
          else
          {
            if ((!Util.isNullOrNil(str4)) && (!bool2)) {
              ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).setMessage(str4);
            }
            ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).a(str2, true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(177325);
                paramAnonymous2DialogInterface = new HashMap();
                paramAnonymous2DialogInterface.put("confirm", Boolean.TRUE);
                paramAnonymous2DialogInterface.put("cancel", Boolean.FALSE);
                if (c.2.this.mnT) {
                  paramAnonymous2DialogInterface.put("content", this.mnZ.hbk());
                }
                c.2.this.cvO.i(c.2.this.cvP, c.this.n("ok", paramAnonymous2DialogInterface));
                AppMethodBeat.o(177325);
              }
            });
            if (bool1) {
              ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).b(str3, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(177326);
                  HashMap localHashMap = new HashMap();
                  localHashMap.put("confirm", Boolean.FALSE);
                  localHashMap.put("cancel", Boolean.TRUE);
                  paramAnonymous2DialogInterface.dismiss();
                  c.2.this.cvO.i(c.2.this.cvP, c.this.n("ok", localHashMap));
                  AppMethodBeat.o(177326);
                }
              });
            }
            ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).setOnCancelListener(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(177327);
                paramAnonymous2DialogInterface = new HashMap();
                paramAnonymous2DialogInterface.put("confirm", Boolean.FALSE);
                paramAnonymous2DialogInterface.put("cancel", Boolean.TRUE);
                c.2.this.cvO.i(c.2.this.cvP, c.this.n("ok", paramAnonymous2DialogInterface));
                AppMethodBeat.o(177327);
              }
            });
            ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).ajL(i);
            if (bool1) {
              ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).ajM(j);
            }
            if (bool2)
            {
              ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).Dg(true);
              if (Util.isNullOrNil(str4)) {
                break label347;
              }
              localObject2 = str4;
              ((com.tencent.mm.ui.widget.a.d)localObject1).mEditText.setVisibility(0);
              ((com.tencent.mm.ui.widget.a.d)localObject1).mEditText.setText((CharSequence)localObject2);
              label231:
              localObject2 = n.cY(localac.getContentView());
              final c.a locala = new c.a((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1, localac, (byte)0);
              ((u)localObject2).a(locala);
              ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).setOnDismissListener(new DialogInterface.OnDismissListener()
              {
                public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(240899);
                  com.tencent.luggage.h.g.aM(c.2.this.cDR.getContext());
                  if (this.mob != null) {
                    this.mob.b(locala);
                  }
                  AppMethodBeat.o(240899);
                }
              });
            }
            params.getRuntime().jCK.b((k)localObject1);
            if (!bool2) {
              break label413;
            }
            ((com.tencent.mm.ui.widget.a.d)localObject1).mEditText.requestFocus();
            localObject1 = localac.getContext();
            if (!(localObject1 instanceof Activity)) {
              break label372;
            }
          }
          label347:
          label372:
          for (localObject1 = (Activity)localObject1;; localObject1 = null)
          {
            if (localObject1 != null) {
              break label377;
            }
            AppMethodBeat.o(177328);
            return;
            ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).setTitle(str1);
            break;
            localObject2 = paramJSONObject.optString("placeholderText");
            if (Util.isNullOrNil((String)localObject2)) {
              break label231;
            }
            ((com.tencent.mm.plugin.appbrand.widget.dialog.b)localObject1).ay((CharSequence)localObject2);
            break label231;
          }
          label377:
          Object localObject2 = (InputMethodManager)((Activity)localObject1).getSystemService("input_method");
          if (localObject2 != null)
          {
            localObject1 = ((Activity)localObject1).getCurrentFocus();
            if ((localObject1 != null) && (((View)localObject1).getWindowToken() != null)) {
              ((InputMethodManager)localObject2).toggleSoftInput(0, 2);
            }
          }
          label413:
          AppMethodBeat.o(177328);
        }
      });
      AppMethodBeat.o(177329);
      return;
      i = com.tencent.mm.plugin.appbrand.ac.g.cu(paramJSONObject.optString("confirmColor", ""), MMApplicationContext.getContext().getResources().getColor(2131100063));
    }
  }
  
  static final class a
    implements u.c
  {
    private boolean crD = false;
    private final ac cwK;
    private final com.tencent.mm.plugin.appbrand.widget.dialog.b mod;
    private int moe;
    private int mof = -1;
    
    private a(com.tencent.mm.plugin.appbrand.widget.dialog.b paramb, ac paramac)
    {
      this.mod = paramb;
      this.cwK = paramac;
    }
    
    private void o(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(240902);
      RelativeLayout.LayoutParams localLayoutParams;
      if (!paramBoolean)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.mod.getContentView().getLayoutParams();
        localLayoutParams.addRule(14);
        localLayoutParams.removeRule(12);
        localLayoutParams.addRule(13);
        localLayoutParams.bottomMargin = 0;
        this.mod.getContentView().setLayoutParams(localLayoutParams);
        AppMethodBeat.o(240902);
        return;
      }
      if (paramInt > 0)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.mod.getContentView().getLayoutParams();
        localLayoutParams.removeRule(13);
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(14);
        localLayoutParams.bottomMargin = xm(paramInt);
        this.mod.getContentView().setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(240902);
    }
    
    private int xm(int paramInt)
    {
      AppMethodBeat.i(240903);
      if (this.mof > 0)
      {
        paramInt = this.mof;
        AppMethodBeat.o(240903);
        return paramInt;
      }
      this.mof = ((com.tencent.mm.plugin.appbrand.utils.ai.f(this.cwK)[1] + paramInt - this.cwK.bRi().getHeight() - av.aD(this.cwK.getContext()) - this.mod.getContentView().getHeight()) / 2);
      if (this.mof <= paramInt) {
        this.mof = (paramInt + 12);
      }
      paramInt = this.mof;
      AppMethodBeat.o(240903);
      return paramInt;
    }
    
    public final void bQ(boolean paramBoolean)
    {
      AppMethodBeat.i(240901);
      Log.d("MicroMsg.JsApiShowModal", "onKeyboardStateChanged shown:%b, keyboardHeight:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.moe) });
      if (paramBoolean == this.crD)
      {
        AppMethodBeat.o(240901);
        return;
      }
      this.crD = paramBoolean;
      o(paramBoolean, this.moe);
      AppMethodBeat.o(240901);
    }
    
    public final int getHeight()
    {
      return this.moe;
    }
    
    public final void hF(int paramInt)
    {
      AppMethodBeat.i(240900);
      Log.d("MicroMsg.JsApiShowModal", "refreshHeight height:%d", new Object[] { Integer.valueOf(paramInt) });
      if ((this.moe != paramInt) && (this.crD)) {
        o(true, paramInt);
      }
      this.moe = paramInt;
      AppMethodBeat.o(240900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.c
 * JD-Core Version:    0.7.0.1
 */