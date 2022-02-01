package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.a;
import com.tencent.mm.model.cq;
import com.tencent.mm.modelappbrand.k.b;
import com.tencent.mm.plugin.appbrand.af.p;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;

@a(7)
public class AppBrandProcessShareMessageProxyUI
  extends MMActivity
{
  private e ubT;
  private a ubU;
  
  public void finish()
  {
    AppMethodBeat.i(48701);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(48701);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(48700);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    ae.g(getWindow());
    ae.c(getWindow(), false);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(48700);
      return;
    }
    String str1 = getIntent().getStringExtra("key_dialog_touser");
    if (Util.isNullOrNil(str1))
    {
      i = 0;
      if (i == 0) {
        finish();
      }
      AppMethodBeat.o(48700);
      return;
    }
    Object localObject1 = (HashMap)getIntent().getSerializableExtra("key_dialog_params");
    boolean bool1 = cq.dy(((HashMap)localObject1).get("is_video"));
    int i = cq.j(((HashMap)localObject1).get("type"), 1);
    String str2 = cq.d(((HashMap)localObject1).get("title"), "");
    String str3 = cq.d(((HashMap)localObject1).get("img_url"), null);
    int j;
    String str4;
    String str5;
    String str6;
    String str7;
    final String str8;
    boolean bool2;
    int k;
    Object localObject2;
    if ((i == 2) || (i == 3))
    {
      i = cq.j(((HashMap)localObject1).get("pkg_type"), 0);
      j = cq.j(((HashMap)localObject1).get("pkg_version"), 0);
      str4 = cq.d(((HashMap)localObject1).get("app_id"), null);
      str5 = cq.d(((HashMap)localObject1).get("cache_key"), null);
      str6 = cq.d(((HashMap)localObject1).get("path"), null);
      str7 = cq.d(((HashMap)localObject1).get("delay_load_img_path"), null);
      str8 = cq.d(((HashMap)localObject1).get("nickname"), "");
      bool2 = cq.dy(((HashMap)localObject1).get("is_dynamic"));
      k = cq.j(((HashMap)localObject1).get("biz"), k.a.nQY.ordinal());
      if (!k.a.uB(k)) {
        break label763;
      }
      localObject2 = cq.d(((HashMap)localObject1).get("tail_lang"), "");
      String str9 = cq.d(((HashMap)localObject1).get("icon_url"), "");
      paramBundle = new Bundle();
      paramBundle.putInt("key_biz", k);
      paramBundle.putString("key_footer_text_default", str8);
      paramBundle.putString("key_footer_text", k.a.b(k, (String)localObject2, getContext()));
      paramBundle.putString("key_footer_icon", str9);
      Log.d("MicroMsg.AppBrandProcessShareMessageProxyUI", "defaultFooterTxt: %s, tailLang: %s.", new Object[] { str8, localObject2 });
    }
    for (;;)
    {
      paramBundle = ((com.tencent.mm.modelappbrand.k)h.ax(com.tencent.mm.modelappbrand.k.class)).a(this, paramBundle, false, null);
      str8 = p.el(this);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("app_id", str4);
      ((Bundle)localObject2).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      ((Bundle)localObject2).putInt("msg_pkg_type", i);
      ((Bundle)localObject2).putInt("pkg_version", j);
      ((Bundle)localObject2).putString("image_url", str3);
      ((Bundle)localObject2).putBoolean("is_dynamic_page", bool2);
      ((Bundle)localObject2).putString("title", str2);
      ((Bundle)localObject2).putString("cache_key", str5);
      ((Bundle)localObject2).putString("msg_path", str6);
      ((Bundle)localObject2).putString("delay_load_img_path", str7);
      if (bool1)
      {
        str2 = cq.d(((HashMap)localObject1).get("video_path"), "");
        localObject1 = cq.d(((HashMap)localObject1).get("video_thumb_path"), "");
        ((Bundle)localObject2).putBoolean("is_video", true);
        ((Bundle)localObject2).putString("video_path", str2);
        ((Bundle)localObject2).putString("video_thumb_path", (String)localObject1);
      }
      localObject1 = new c(this);
      ((c)localObject1).ucc = new b()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(48687);
          Log.i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onProcessDone, result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (AppBrandProcessShareMessageProxyUI.a(AppBrandProcessShareMessageProxyUI.this) != null) {
            AppBrandProcessShareMessageProxyUI.a(AppBrandProcessShareMessageProxyUI.this).onDialogClick(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt);
          }
          ((com.tencent.mm.modelappbrand.k)h.ax(com.tencent.mm.modelappbrand.k.class)).b(str8, paramBundle);
          AppMethodBeat.o(48687);
        }
      };
      ((com.tencent.mm.modelappbrand.k)h.ax(com.tencent.mm.modelappbrand.k.class)).a(str8, paramBundle, (Bundle)localObject2, new k.b()
      {
        public final void vJ(int paramAnonymousInt)
        {
          AppMethodBeat.i(48688);
          Log.i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onLoadImageResult, result:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppBrandProcessShareMessageProxyUI.c localc = this.ubX;
          localc.ubZ = true;
          if (localc.checkReady())
          {
            MMHandlerThread.removeRunnable(localc.rNg);
            localc.cLf();
          }
          AppMethodBeat.o(48688);
        }
      });
      this.ubU = new a();
      this.ubT = ((j)h.ax(j.class)).a(this, str1, paramBundle, getResources().getString(ba.i.appbrand_share_app_message_to_contact), new y.a()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(48689);
          AppBrandProcessShareMessageProxyUI.this.hideVKB();
          this.ubX.e(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(48689);
        }
      });
      this.ubT.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(48690);
          ((com.tencent.mm.modelappbrand.k)h.ax(com.tencent.mm.modelappbrand.k.class)).b(str8, paramBundle);
          AppBrandProcessShareMessageProxyUI.this.finish();
          AppMethodBeat.o(48690);
        }
      });
      this.ubT.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(48691);
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
          {
            this.ubX.e(false, null, 0);
            paramAnonymousDialogInterface.dismiss();
          }
          AppMethodBeat.o(48691);
          return false;
        }
      });
      this.ubT.show();
      i = 1;
      break;
      label763:
      if (bool1)
      {
        paramBundle = new Bundle();
        paramBundle.putBoolean("is_video", true);
        str8 = cq.d(((HashMap)localObject1).get("footer_icon"), "");
        localObject2 = cq.d(((HashMap)localObject1).get("footer_text"), "");
        paramBundle.putString("key_footer_icon", str8);
        paramBundle.putString("key_footer_text", (String)localObject2);
      }
      else
      {
        Log.w("MicroMsg.AppBrandProcessShareMessageProxyUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(k) });
        paramBundle = null;
      }
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48699);
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(1);
    AppMethodBeat.o(48699);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48702);
    super.onDestroy();
    if ((this.ubT != null) && (this.ubT.isShowing()))
    {
      this.ubT.dismiss();
      this.ubT = null;
      this.ubU = null;
    }
    AppMethodBeat.o(48702);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(48703);
    int i = getIntent().getIntExtra("orientation", -1);
    if (i != -1) {
      setRequestedOrientation(i);
    }
    AppMethodBeat.o(48703);
  }
  
  final class a
    implements y.a
  {
    private boolean ruU = false;
    
    a() {}
    
    private void aJ(int paramInt, String paramString)
    {
      AppMethodBeat.i(48693);
      if (this.ruU)
      {
        AppMethodBeat.o(48693);
        return;
      }
      this.ruU = true;
      ResultReceiver localResultReceiver = (ResultReceiver)AppBrandProcessShareMessageProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
      if (localResultReceiver != null)
      {
        Bundle localBundle = null;
        if (!Util.isNullOrNil(paramString))
        {
          localBundle = new Bundle();
          localBundle.putString("message", paramString);
        }
        localResultReceiver.send(paramInt, localBundle);
      }
      AppMethodBeat.o(48693);
    }
    
    public final void onDialogClick(boolean paramBoolean, String paramString, int paramInt)
    {
      AppMethodBeat.i(48692);
      if (paramBoolean)
      {
        aJ(-1, paramString);
        AppMethodBeat.o(48692);
        return;
      }
      aJ(-2, null);
      AppMethodBeat.o(48692);
    }
  }
  
  static abstract interface b
  {
    public abstract void d(boolean paramBoolean, String paramString, int paramInt);
  }
  
  final class c
  {
    private Context context;
    Runnable rNg;
    private String text;
    w tipDialog;
    private boolean ubY;
    boolean ubZ;
    private boolean uca;
    private int ucb;
    AppBrandProcessShareMessageProxyUI.b ucc;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(48695);
      this.rNg = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48694);
          if (AppBrandProcessShareMessageProxyUI.c.this.tipDialog != null) {
            AppBrandProcessShareMessageProxyUI.c.this.tipDialog.dismiss();
          }
          AppBrandProcessShareMessageProxyUI.c.this.cLf();
          AppMethodBeat.o(48694);
        }
      };
      this.context = paramContext;
      AppMethodBeat.o(48695);
    }
    
    public final void cLf()
    {
      AppMethodBeat.i(48697);
      if (this.ucc != null) {
        this.ucc.d(this.uca, this.text, this.ucb);
      }
      AppMethodBeat.o(48697);
    }
    
    public final boolean checkReady()
    {
      return (this.ubY) && (this.ubZ);
    }
    
    public final void e(boolean paramBoolean, String paramString, int paramInt)
    {
      AppMethodBeat.i(48696);
      this.ubY = true;
      this.uca = paramBoolean;
      this.text = paramString;
      this.ucb = paramInt;
      if (checkReady())
      {
        cLf();
        AppMethodBeat.o(48696);
        return;
      }
      if (paramBoolean)
      {
        this.tipDialog = com.tencent.mm.ui.base.k.a(this.context, this.context.getString(ba.i.app_sending), true, null);
        MMHandlerThread.postToMainThreadDelayed(this.rNg, 5000L);
      }
      AppMethodBeat.o(48696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI
 * JD-Core Version:    0.7.0.1
 */