package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.protocal.protobuf.dua;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

@a(3)
public class ShareToFacebookRedirectUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
  private com.tencent.mm.ui.base.q gut;
  private String ksh;
  private String ksi;
  private String ksj;
  private String ksk;
  
  private void bpW()
  {
    AppMethodBeat.i(128741);
    Log.i(TAG, "refreshFacebookToken");
    long l = Util.nullAsNil((Long)g.aAh().azQ().get(65831, null));
    String str = Util.nullAsNil((String)g.aAh().azQ().get(65830, null));
    if ((Util.milliSecondsToNow(l) > 86400000L) && (str.length() > 0))
    {
      c localc = new c(getString(2131759094));
      localc.bnE(str);
      new k(localc, new l()
      {
        public final void E(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(128733);
          super.E(paramAnonymousBundle);
          AppMethodBeat.o(128733);
        }
        
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(128734);
          Log.e(ShareToFacebookRedirectUI.TAG, "refresh token error. errType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          super.onError(paramAnonymousInt, paramAnonymousString);
          if (paramAnonymousInt == 3) {
            ShareToFacebookRedirectUI.a(ShareToFacebookRedirectUI.this);
          }
          AppMethodBeat.o(128734);
        }
      }).bnw();
      AppMethodBeat.o(128741);
      return;
    }
    bpw();
    AppMethodBeat.o(128741);
  }
  
  private void bpw()
  {
    AppMethodBeat.i(128742);
    Log.i(TAG, "doSend");
    final f.a locala = new f.a(this);
    locala.aC(this.ksh).box(this.ksj).aD(this.ksi).boy(getString(2131755767)).apa(2131755983).c(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(128736);
        ShareToFacebookRedirectUI.this.hideVKB();
        locala.kdo.dismiss();
        if (paramAnonymousBoolean)
        {
          dua localdua = new dua();
          String str = paramAnonymousString;
          if (Util.isNullOrNil(paramAnonymousString)) {
            str = " ";
          }
          localdua.xJz = str;
          localdua.Name = ShareToFacebookRedirectUI.b(ShareToFacebookRedirectUI.this);
          localdua.KHk = ShareToFacebookRedirectUI.c(ShareToFacebookRedirectUI.this);
          localdua.AAN = ShareToFacebookRedirectUI.d(ShareToFacebookRedirectUI.this);
          localdua.MVL = ShareToFacebookRedirectUI.e(ShareToFacebookRedirectUI.this);
          paramAnonymousString = new com.tencent.mm.plugin.account.model.i(localdua);
          g.azz().a(paramAnonymousString, 0);
          ShareToFacebookRedirectUI.a(ShareToFacebookRedirectUI.this, h.a(ShareToFacebookRedirectUI.this, "", false, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(128735);
              ShareToFacebookRedirectUI.f(ShareToFacebookRedirectUI.this).dismiss();
              ShareToFacebookRedirectUI.this.finish();
              AppMethodBeat.o(128735);
            }
          }));
          AppMethodBeat.o(128736);
          return;
        }
        ShareToFacebookRedirectUI.this.finish();
        AppMethodBeat.o(128736);
      }
    }).show();
    AppMethodBeat.o(128742);
  }
  
  private void cb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128743);
    h.a(getContext(), paramString2, paramString1, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(128737);
        paramAnonymousDialogInterface = new Intent(ShareToFacebookRedirectUI.this.getContext(), FacebookAuthUI.class);
        paramAnonymousDialogInterface.putExtra("is_force_unbind", true);
        ShareToFacebookRedirectUI.this.getContext().startActivityForResult(paramAnonymousDialogInterface, 0);
        AppMethodBeat.o(128737);
      }
    }, null);
    AppMethodBeat.o(128743);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128744);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str = TAG;
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 0) || (paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      Log.i(TAG, "bind facebooksucc %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      bpW();
      bpw();
      AppMethodBeat.o(128744);
      return;
    }
    finish();
    AppMethodBeat.o(128744);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128738);
    super.onCreate(paramBundle);
    g.azz().a(433, this);
    this.ksh = getIntent().getStringExtra("title");
    this.ksi = getIntent().getStringExtra("digest");
    this.ksj = getIntent().getStringExtra("img");
    this.ksk = getIntent().getStringExtra("link");
    Log.i(TAG, "title %s, digest:%s, img:%s, link:%s", new Object[] { this.ksh, this.ksi, this.ksj, this.ksk });
    if (!z.aUF())
    {
      paramBundle = new Intent(this, FacebookAuthUI.class);
      paramBundle.putExtra("is_force_unbind", true);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(128738);
      return;
    }
    bpW();
    bpw();
    AppMethodBeat.o(128738);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128739);
    g.azz().b(433, this);
    super.onDestroy();
    AppMethodBeat.o(128739);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128740);
    Log.i(TAG, "type:%d, code:%d, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    hideVKB();
    this.gut.dismiss();
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = "error";
      }
      cb(getString(2131755998), paramq);
      AppMethodBeat.o(128740);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getString(2131765834);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      h.cD(this, paramString);
      finish();
      AppMethodBeat.o(128740);
      return;
    }
    h.a(getContext(), "err(" + paramInt2 + "," + paramInt1 + ")", getString(2131755998), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(128732);
        ShareToFacebookRedirectUI.this.finish();
        AppMethodBeat.o(128732);
      }
    }, null);
    AppMethodBeat.o(128740);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI
 * JD-Core Version:    0.7.0.1
 */