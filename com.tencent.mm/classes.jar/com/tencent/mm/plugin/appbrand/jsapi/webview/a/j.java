package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Map;

class j
  extends m
{
  MMHandler mHandler;
  h pIl;
  g pIm;
  
  j()
  {
    AppMethodBeat.i(249677);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(249677);
  }
  
  public boolean h(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(249680);
    Log.i("MicroMsg.MMDefaultWebViewStubCallback", "callback, actionCode = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(249680);
      return false;
    case 1002: 
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(284433);
          if ((j.this.pIl != null) && (j.this.pIm != null) && (j.this.pIm.gWI().so(42))) {
            j.this.pIl.j(paramBundle, "download_succ");
          }
          AppMethodBeat.o(284433);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(249680);
      return true;
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(272284);
          if ((j.this.pIl != null) && (j.this.pIm != null) && (j.this.pIm.gWI().so(42))) {
            j.this.pIl.j(paramBundle, "download_fail");
          }
          AppMethodBeat.o(272284);
        }
      });
      continue;
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(283570);
          if ((j.this.pIl != null) && (j.this.pIm != null) && (j.this.pIm.gWI().so(42))) {
            j.this.pIl.j(paramBundle, "download_removed");
          }
          AppMethodBeat.o(283570);
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
          AppMethodBeat.i(243446);
          if ((j.this.pIl != null) && (j.this.pIm != null) && (j.this.pIm.gWI().so(42))) {
            j.this.pIl.a(paramBundle, l, f, this.pIu);
          }
          AppMethodBeat.o(243446);
        }
      });
      continue;
      Object localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(284191);
          if (j.this.pIl != null) {
            j.this.pIl.gS(this.pIv, paramInt);
          }
          AppMethodBeat.o(284191);
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(274248);
          if (j.this.pIl != null) {
            j.this.pIl.gT(this.pIx, paramInt);
          }
          AppMethodBeat.o(274248);
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(282620);
          if (j.this.pIl != null) {
            j.this.pIl.gU(this.pIy, paramInt);
          }
          AppMethodBeat.o(282620);
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(273662);
          if (j.this.pIl != null) {
            j.this.pIl.gV(this.pIx, paramInt);
          }
          AppMethodBeat.o(273662);
        }
      });
      continue;
      localObject = paramBundle.getString("webview_jssdk_file_item_local_id");
      paramInt = paramBundle.getInt("webview_jssdk_file_item_progreess");
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(243041);
          if (j.this.pIl != null) {
            j.this.pIl.gW(this.pIy, paramInt);
          }
          AppMethodBeat.o(243041);
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
          AppMethodBeat.i(266028);
          if (j.this.pIl != null) {
            j.this.pIl.bN(this.pIo);
          }
          AppMethodBeat.o(266028);
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
          AppMethodBeat.i(255422);
          if (j.this.pIl != null) {
            j.this.pIl.bO(this.pIo);
          }
          AppMethodBeat.o(255422);
        }
      });
      continue;
      if (this.pIl != null)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            AppMethodBeat.i(281728);
            if ((!paramBundle.containsKey("jsapi_preverify_fun_list")) || (j.this.pIm == null)) {
              if (j.this.pIm != null) {
                Log.e("MicroMsg.MMDefaultWebViewStubCallback", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
              }
            }
            for (;;)
            {
              if (j.this.pIl != null) {
                j.this.pIl.gTS();
              }
              AppMethodBeat.o(281728);
              return;
              bool = false;
              break;
              j.this.pIm.aN(paramBundle);
            }
          }
        });
        continue;
        if (this.pIl != null)
        {
          this.mHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(277237);
              if (j.this.pIl != null)
              {
                String str = paramBundle.getString("webview_network_type");
                j.this.pIl.bke(str);
              }
              AppMethodBeat.o(277237);
            }
          });
          continue;
          if (this.pIl != null)
          {
            paramBundle = paramBundle.getString("err_msg");
            this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(281850);
                if (j.this.pIl != null) {
                  j.this.pIl.bkb(paramBundle);
                }
                AppMethodBeat.o(281850);
              }
            });
            continue;
            localObject = paramBundle.getString("uuid");
            paramInt = paramBundle.getInt("major");
            final int i = paramBundle.getInt("minor");
            final double d1 = paramBundle.getDouble("accuracy");
            double d2 = paramBundle.getDouble("rssi");
            f = paramBundle.getFloat("heading");
            if (this.pIl != null)
            {
              paramBundle = paramBundle.getString("err_msg");
              this.mHandler.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(265069);
                  if (j.this.pIl != null)
                  {
                    j.this.pIl.bkb(paramBundle);
                    j.this.pIl.a(this.nCI, paramInt, i, d1, f, this.pIs);
                  }
                  AppMethodBeat.o(265069);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.j
 * JD-Core Version:    0.7.0.1
 */