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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

@a(3)
public class ShareToFacebookRedirectUI
  extends MMActivity
  implements f
{
  private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
  private p fPj;
  private String jtS;
  private String jtT;
  private String jtU;
  private String jtV;
  
  private void aUJ()
  {
    AppMethodBeat.i(128742);
    ae.i(TAG, "doSend");
    final f.a locala = new f.a(this);
    locala.au(this.jtS).aZr(this.jtU).av(this.jtT).aZs(getString(2131755696)).afY(2131755891).c(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(128736);
        ShareToFacebookRedirectUI.this.hideVKB();
        locala.jfl.dismiss();
        if (paramAnonymousBoolean)
        {
          daw localdaw = new daw();
          String str = paramAnonymousString;
          if (bu.isNullOrNil(paramAnonymousString)) {
            str = " ";
          }
          localdaw.urg = str;
          localdaw.Name = ShareToFacebookRedirectUI.b(ShareToFacebookRedirectUI.this);
          localdaw.FNF = ShareToFacebookRedirectUI.c(ShareToFacebookRedirectUI.this);
          localdaw.wFC = ShareToFacebookRedirectUI.d(ShareToFacebookRedirectUI.this);
          localdaw.HJZ = ShareToFacebookRedirectUI.e(ShareToFacebookRedirectUI.this);
          paramAnonymousString = new com.tencent.mm.plugin.account.model.h(localdaw);
          g.ajj().a(paramAnonymousString, 0);
          ShareToFacebookRedirectUI.a(ShareToFacebookRedirectUI.this, com.tencent.mm.ui.base.h.b(ShareToFacebookRedirectUI.this, "", false, new DialogInterface.OnCancelListener()
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
  
  private void aVk()
  {
    AppMethodBeat.i(128741);
    ae.i(TAG, "refreshFacebookToken");
    long l = bu.i((Long)g.ajR().ajA().get(65831, null));
    String str = bu.nullAsNil((String)g.ajR().ajA().get(65830, null));
    if ((bu.DD(l) > 86400000L) && (str.length() > 0))
    {
      c localc = new c(getString(2131758773));
      localc.aYB(str);
      new j(localc, new k()
      {
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(128734);
          ae.e(ShareToFacebookRedirectUI.TAG, "refresh token error. errType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          super.onError(paramAnonymousInt, paramAnonymousString);
          if (paramAnonymousInt == 3) {
            ShareToFacebookRedirectUI.a(ShareToFacebookRedirectUI.this);
          }
          AppMethodBeat.o(128734);
        }
        
        public final void y(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(128733);
          super.y(paramAnonymousBundle);
          AppMethodBeat.o(128733);
        }
      }).aSJ();
      AppMethodBeat.o(128741);
      return;
    }
    aUJ();
    AppMethodBeat.o(128741);
  }
  
  private void bS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128743);
    com.tencent.mm.ui.base.h.a(getContext(), paramString2, paramString1, new DialogInterface.OnClickListener()
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
      ae.i(str, "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 0) || (paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      ae.i(TAG, "bind facebooksucc %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      aVk();
      aUJ();
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
    g.ajj().a(433, this);
    this.jtS = getIntent().getStringExtra("title");
    this.jtT = getIntent().getStringExtra("digest");
    this.jtU = getIntent().getStringExtra("img");
    this.jtV = getIntent().getStringExtra("link");
    ae.i(TAG, "title %s, digest:%s, img:%s, link:%s", new Object[] { this.jtS, this.jtT, this.jtU, this.jtV });
    if (!v.aBi())
    {
      paramBundle = new Intent(this, FacebookAuthUI.class);
      paramBundle.putExtra("is_force_unbind", true);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(128738);
      return;
    }
    aVk();
    aUJ();
    AppMethodBeat.o(128738);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128739);
    g.ajj().b(433, this);
    super.onDestroy();
    AppMethodBeat.o(128739);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128740);
    ae.i(TAG, "type:%d, code:%d, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    hideVKB();
    this.fPj.dismiss();
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = "error";
      }
      bS(getString(2131755906), paramn);
      AppMethodBeat.o(128740);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getString(2131763646);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      com.tencent.mm.ui.base.h.cm(this, paramString);
      finish();
      AppMethodBeat.o(128740);
      return;
    }
    com.tencent.mm.ui.base.h.a(getContext(), "err(" + paramInt2 + "," + paramInt1 + ")", getString(2131755906), new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI
 * JD-Core Version:    0.7.0.1
 */