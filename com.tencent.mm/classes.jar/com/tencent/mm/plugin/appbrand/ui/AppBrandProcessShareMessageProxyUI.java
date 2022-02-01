package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
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
import com.tencent.mm.ai.k.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.b;
import com.tencent.mm.plugin.appbrand.aa.m;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;

@a(7)
public class AppBrandProcessShareMessageProxyUI
  extends MMActivity
{
  private d lAE;
  private a lAF;
  
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
    r.b(getWindow());
    r.c(getWindow(), false);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(48700);
      return;
    }
    String str1 = getIntent().getStringExtra("key_dialog_touser");
    if (bt.isNullOrNil(str1))
    {
      i = 0;
      if (i == 0) {
        finish();
      }
      AppMethodBeat.o(48700);
      return;
    }
    Object localObject1 = (HashMap)getIntent().getSerializableExtra("key_dialog_params");
    boolean bool1 = ch.bW(((HashMap)localObject1).get("is_video"));
    int i = ch.getInt(((HashMap)localObject1).get("type"), 1);
    String str2 = ch.c(((HashMap)localObject1).get("title"), "");
    String str3 = ch.c(((HashMap)localObject1).get("img_url"), null);
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
      i = ch.getInt(((HashMap)localObject1).get("pkg_type"), 0);
      j = ch.getInt(((HashMap)localObject1).get("pkg_version"), 0);
      str4 = ch.c(((HashMap)localObject1).get("app_id"), null);
      str5 = ch.c(((HashMap)localObject1).get("cache_key"), null);
      str6 = ch.c(((HashMap)localObject1).get("path"), null);
      str7 = ch.c(((HashMap)localObject1).get("delay_load_img_path"), null);
      str8 = ch.c(((HashMap)localObject1).get("nickname"), "");
      bool2 = ch.bW(((HashMap)localObject1).get("is_dynamic"));
      k = ch.getInt(((HashMap)localObject1).get("biz"), k.a.gGZ.ordinal());
      if (!k.a.isValid(k)) {
        break label763;
      }
      localObject2 = ch.c(((HashMap)localObject1).get("tail_lang"), "");
      String str9 = ch.c(((HashMap)localObject1).get("icon_url"), "");
      paramBundle = new Bundle();
      paramBundle.putInt("key_biz", k);
      paramBundle.putString("key_footer_text_default", str8);
      paramBundle.putString("key_footer_text", k.a.b(k, (String)localObject2, getContext()));
      paramBundle.putString("key_footer_icon", str9);
      ad.d("MicroMsg.AppBrandProcessShareMessageProxyUI", "defaultFooterTxt: %s, tailLang: %s.", new Object[] { str8, localObject2 });
    }
    for (;;)
    {
      paramBundle = ((k)g.ab(k.class)).a(this, paramBundle, false, null);
      str8 = m.cF(this);
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
        str2 = ch.c(((HashMap)localObject1).get("video_path"), "");
        localObject1 = ch.c(((HashMap)localObject1).get("video_thumb_path"), "");
        ((Bundle)localObject2).putBoolean("is_video", true);
        ((Bundle)localObject2).putString("video_path", str2);
        ((Bundle)localObject2).putString("video_thumb_path", (String)localObject1);
      }
      localObject1 = new c(this);
      ((c)localObject1).lAN = new b()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(48687);
          ad.i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onProcessDone, result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (AppBrandProcessShareMessageProxyUI.a(AppBrandProcessShareMessageProxyUI.this) != null) {
            AppBrandProcessShareMessageProxyUI.a(AppBrandProcessShareMessageProxyUI.this).a(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt);
          }
          ((k)g.ab(k.class)).a(str8, paramBundle);
          AppMethodBeat.o(48687);
        }
      };
      ((k)g.ab(k.class)).a(str8, paramBundle, (Bundle)localObject2, new k.b()
      {
        public final void ny(int paramAnonymousInt)
        {
          AppMethodBeat.i(48688);
          ad.i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onLoadImageResult, result:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppBrandProcessShareMessageProxyUI.c localc = this.lAI;
          localc.lAK = true;
          if (localc.qh())
          {
            aq.az(localc.jJK);
            localc.bos();
          }
          AppMethodBeat.o(48688);
        }
      });
      this.lAF = new a();
      this.lAE = ((i)g.ab(i.class)).a(this, str1, paramBundle, getResources().getString(2131756050), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(48689);
          AppBrandProcessShareMessageProxyUI.this.hideVKB();
          this.lAI.f(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(48689);
        }
      });
      this.lAE.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(48690);
          ((k)g.ab(k.class)).a(str8, paramBundle);
          AppBrandProcessShareMessageProxyUI.this.finish();
          AppMethodBeat.o(48690);
        }
      });
      this.lAE.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(48691);
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
          {
            this.lAI.f(false, null, 0);
            paramAnonymousDialogInterface.dismiss();
          }
          AppMethodBeat.o(48691);
          return false;
        }
      });
      this.lAE.show();
      i = 1;
      break;
      label763:
      if (bool1)
      {
        paramBundle = new Bundle();
        paramBundle.putBoolean("is_video", true);
        str8 = ch.c(((HashMap)localObject1).get("footer_icon"), "");
        localObject2 = ch.c(((HashMap)localObject1).get("footer_text"), "");
        paramBundle.putString("key_footer_icon", str8);
        paramBundle.putString("key_footer_text", (String)localObject2);
      }
      else
      {
        ad.w("MicroMsg.AppBrandProcessShareMessageProxyUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(k) });
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
    if ((this.lAE != null) && (this.lAE.isShowing()))
    {
      this.lAE.dismiss();
      this.lAE = null;
      this.lAF = null;
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
    private boolean juI = false;
    
    a() {}
    
    private void aq(int paramInt, String paramString)
    {
      AppMethodBeat.i(48693);
      if (this.juI)
      {
        AppMethodBeat.o(48693);
        return;
      }
      this.juI = true;
      ResultReceiver localResultReceiver = (ResultReceiver)AppBrandProcessShareMessageProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
      if (localResultReceiver != null)
      {
        Bundle localBundle = null;
        if (!bt.isNullOrNil(paramString))
        {
          localBundle = new Bundle();
          localBundle.putString("message", paramString);
        }
        localResultReceiver.send(paramInt, localBundle);
      }
      AppMethodBeat.o(48693);
    }
    
    public final void a(boolean paramBoolean, String paramString, int paramInt)
    {
      AppMethodBeat.i(48692);
      if (paramBoolean)
      {
        aq(-1, paramString);
        AppMethodBeat.o(48692);
        return;
      }
      aq(-2, null);
      AppMethodBeat.o(48692);
    }
  }
  
  static abstract interface b
  {
    public abstract void e(boolean paramBoolean, String paramString, int paramInt);
  }
  
  final class c
  {
    private Context context;
    Runnable jJK;
    private boolean lAJ;
    boolean lAK;
    private boolean lAL;
    private int lAM;
    AppBrandProcessShareMessageProxyUI.b lAN;
    private String text;
    p tipDialog;
    
    public c(Context paramContext)
    {
      AppMethodBeat.i(48695);
      this.jJK = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48694);
          if (AppBrandProcessShareMessageProxyUI.c.this.tipDialog != null) {
            AppBrandProcessShareMessageProxyUI.c.this.tipDialog.dismiss();
          }
          AppBrandProcessShareMessageProxyUI.c.this.bos();
          AppMethodBeat.o(48694);
        }
      };
      this.context = paramContext;
      AppMethodBeat.o(48695);
    }
    
    public final void bos()
    {
      AppMethodBeat.i(48697);
      if (this.lAN != null) {
        this.lAN.e(this.lAL, this.text, this.lAM);
      }
      AppMethodBeat.o(48697);
    }
    
    public final void f(boolean paramBoolean, String paramString, int paramInt)
    {
      AppMethodBeat.i(48696);
      this.lAJ = true;
      this.lAL = paramBoolean;
      this.text = paramString;
      this.lAM = paramInt;
      if (qh())
      {
        bos();
        AppMethodBeat.o(48696);
        return;
      }
      if (paramBoolean)
      {
        this.tipDialog = h.b(this.context, this.context.getString(2131755886), true, null);
        aq.n(this.jJK, 5000L);
      }
      AppMethodBeat.o(48696);
    }
    
    public final boolean qh()
    {
      return (this.lAJ) && (this.lAK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI
 * JD-Core Version:    0.7.0.1
 */