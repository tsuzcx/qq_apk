package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.widget.p;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Map;

class g
  extends p
{
  MMHandler mHandler;
  j sNc;
  com.tencent.mm.plugin.webview.e.g sNd;
  
  g()
  {
    AppMethodBeat.i(327545);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(327545);
  }
  
  public boolean i(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(327561);
    Log.i("MicroMsg.MMDefaultWebViewStubCallback", "callback, actionCode = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(327561);
      return false;
    case 1002: 
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327611);
          if ((g.this.sNc != null) && (g.this.sNd != null) && (g.this.sNd.iwo().sk(42))) {
            g.this.sNc.j(paramBundle, "download_succ");
          }
          AppMethodBeat.o(327611);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(327561);
      return true;
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327623);
          if ((g.this.sNc != null) && (g.this.sNd != null) && (g.this.sNd.iwo().sk(42))) {
            g.this.sNc.j(paramBundle, "download_fail");
          }
          AppMethodBeat.o(327623);
        }
      });
      continue;
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327634);
          if ((g.this.sNc != null) && (g.this.sNd != null) && (g.this.sNd.iwo().sk(42))) {
            g.this.sNc.j(paramBundle, "download_removed");
          }
          AppMethodBeat.o(327634);
        }
      });
      continue;
      final long l = paramBundle.getLong("download_manager_downloadid");
      paramInt = paramBundle.getInt("download_manager_progress");
      final float f = paramBundle.getFloat("download_manager_progress_float");
      paramBundle = paramBundle.getString("download_manager_appid", "");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327476);
          if ((g.this.sNc != null) && (g.this.sNd != null) && (g.this.sNd.iwo().sk(42))) {
            g.this.sNc.a(paramBundle, l, f, this.sNl);
          }
          AppMethodBeat.o(327476);
        }
      });
      continue;
      Object localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327482);
          if (g.this.sNc != null) {
            g.this.sNc.hS(this.sNm, paramInt);
          }
          AppMethodBeat.o(327482);
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327478);
          if (g.this.sNc != null) {
            g.this.sNc.hT(this.sNo, paramInt);
          }
          AppMethodBeat.o(327478);
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327489);
          if (g.this.sNc != null) {
            g.this.sNc.hU(this.sNp, paramInt);
          }
          AppMethodBeat.o(327489);
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327488);
          if (g.this.sNc != null) {
            g.this.sNc.hV(this.sNo, paramInt);
          }
          AppMethodBeat.o(327488);
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327490);
          if (g.this.sNc != null) {
            g.this.sNc.hW(this.sNp, paramInt);
          }
          AppMethodBeat.o(327490);
        }
      });
      continue;
      localObject = new HashMap();
      ((Map)localObject).put("err_msg", paramBundle.getString("playResult"));
      ((Map)localObject).put("localId", paramBundle.getString("localId"));
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327621);
          if (g.this.sNc != null) {
            g.this.sNc.cg(this.sNf);
          }
          AppMethodBeat.o(327621);
        }
      });
      continue;
      localObject = new HashMap();
      ((Map)localObject).put("localId", paramBundle.getString("localId"));
      ((Map)localObject).put("err_msg", paramBundle.getString("recordResult"));
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327624);
          if (g.this.sNc != null) {
            g.this.sNc.ch(this.sNf);
          }
          AppMethodBeat.o(327624);
        }
      });
      continue;
      if (this.sNc != null)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            AppMethodBeat.i(327628);
            if ((!paramBundle.containsKey("jsapi_preverify_fun_list")) || (g.this.sNd == null)) {
              if (g.this.sNd != null) {
                Log.e("MicroMsg.MMDefaultWebViewStubCallback", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
              }
            }
            for (;;)
            {
              if (g.this.sNc != null) {
                g.this.sNc.itz();
              }
              AppMethodBeat.o(327628);
              return;
              bool = false;
              break;
              g.this.sNd.br(paramBundle);
            }
          }
        });
        continue;
        if (this.sNc != null)
        {
          this.mHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(327616);
              if (g.this.sNc != null)
              {
                String str = paramBundle.getString("webview_network_type");
                g.this.sNc.bjO(str);
              }
              AppMethodBeat.o(327616);
            }
          });
          continue;
          if (this.sNc != null)
          {
            paramBundle = paramBundle.getString("err_msg");
            this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(327627);
                if (g.this.sNc != null) {
                  g.this.sNc.bjL(paramBundle);
                }
                AppMethodBeat.o(327627);
              }
            });
            continue;
            localObject = paramBundle.getString("uuid");
            paramInt = paramBundle.getInt("major");
            final int i = paramBundle.getInt("minor");
            final double d1 = paramBundle.getDouble("accuracy");
            double d2 = paramBundle.getDouble("rssi");
            f = paramBundle.getFloat("heading");
            if (this.sNc != null)
            {
              paramBundle = paramBundle.getString("err_msg");
              this.mHandler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(327626);
                  if (g.this.sNc != null)
                  {
                    g.this.sNc.bjL(paramBundle);
                    g.this.sNc.a(this.qCD, paramInt, i, d1, f, this.sNj);
                  }
                  AppMethodBeat.o(327626);
                }
              });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.g
 * JD-Core Version:    0.7.0.1
 */