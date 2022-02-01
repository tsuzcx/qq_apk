package com.tencent.mm.plugin.lite.a.c;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.luggage.f.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.lite.api.e
{
  public final void a(final String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271602);
    Log.d("LiteAppJsApiProfile", "Invoke profile");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271602);
      return;
    }
    final String str = paramJSONObject.optString("username");
    final Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("nextAnimIn", com.tencent.mm.plugin.lite.b.b.bo(paramJSONObject));
      localIntent.putExtra("currentAnimOut", com.tencent.mm.plugin.lite.b.b.bp(paramJSONObject));
      if ((str == null) || (str.length() == 0))
      {
        Log.e("LiteAppJsApiProfile", "profile fail, username is null");
        this.JZj.aJV("username is null");
        AppMethodBeat.o(271602);
        return;
      }
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("LiteAppJsApiProfile", paramString, "parse json", new Object[0]);
      this.JZj.aJV("exception");
      AppMethodBeat.o(271602);
      return;
    }
    if (Util.isNullOrNil(str))
    {
      s.D(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271580);
          Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.d.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(271580);
        }
      });
      this.JZj.aJV("fail");
      AppMethodBeat.o(271602);
      return;
    }
    com.tencent.mm.kernel.h.baC();
    if (!com.tencent.mm.kernel.b.aZM())
    {
      Log.e("LiteAppJsApiProfile", "have to login");
      AppMethodBeat.o(271602);
      return;
    }
    au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str);
    if (localau != null)
    {
      paramString = localau;
      if ((int)localau.maN > 0) {}
    }
    else
    {
      paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxs(str);
    }
    paramJSONObject = paramJSONObject.optString("profileReportInfo");
    if (!Util.isNullOrNil(paramJSONObject)) {
      localIntent.putExtra("key_add_contact_report_info", paramJSONObject);
    }
    if ((paramString != null) && ((int)paramString.maN > 0))
    {
      localIntent.addFlags(268435456);
      localIntent.putExtra("Contact_User", paramString.field_username);
      if (paramString.iZC()) {
        localIntent.putExtra("Contact_Scene", 42);
      }
      c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
      this.JZj.fTW();
      AppMethodBeat.o(271602);
      return;
    }
    paramString = MMApplicationContext.getContext();
    MMApplicationContext.getContext().getString(a.d.app_tip);
    paramString = k.a(paramString, MMApplicationContext.getContext().getString(a.d.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(271576);
        az.a.okP.Jq(str);
        h.a(h.this).aJV("cancel");
        AppMethodBeat.o(271576);
      }
    });
    az.a.okP.a(str, "", new az.b.a()
    {
      public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(271581);
        if (paramString != null) {
          paramString.dismiss();
        }
        au localau2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramAnonymousString);
        au localau1;
        if (localau2 != null)
        {
          localau1 = localau2;
          if ((int)localau2.maN > 0) {}
        }
        else
        {
          localau1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxs(paramAnonymousString);
        }
        if ((localau1 == null) || ((int)localau1.maN <= 0)) {
          paramAnonymousBoolean = false;
        }
        while (!paramAnonymousBoolean)
        {
          s.D(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(271579);
              Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.d.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              AppMethodBeat.o(271579);
            }
          });
          h.b(h.this).aJV("fail");
          AppMethodBeat.o(271581);
          return;
          paramAnonymousString = localau1.field_username;
        }
        com.tencent.mm.modelavatar.d.aS(paramAnonymousString, 3);
        q.bFG().LB(paramAnonymousString);
        localIntent.addFlags(268435456);
        localIntent.putExtra("Contact_User", paramAnonymousString);
        if (localau1.iZC())
        {
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, localau1.field_username + ",42");
          localIntent.putExtra("Contact_Scene", 42);
        }
        c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        h.c(h.this).fTW();
        AppMethodBeat.o(271581);
      }
    });
    AppMethodBeat.o(271602);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.h
 * JD-Core Version:    0.7.0.1
 */