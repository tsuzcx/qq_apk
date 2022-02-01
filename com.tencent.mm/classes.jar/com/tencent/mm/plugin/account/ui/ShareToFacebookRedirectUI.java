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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
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
  implements com.tencent.mm.al.g
{
  private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
  private p fqw;
  private String ixN;
  private String ixO;
  private String ixP;
  private String ixQ;
  
  private void aKI()
  {
    AppMethodBeat.i(128741);
    ad.i(TAG, "refreshFacebookToken");
    long l = bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(65831, null));
    String str = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(65830, null));
    if ((bt.vM(l) > 86400000L) && (str.length() > 0))
    {
      c localc = new c(getString(2131758773));
      localc.aLA(str);
      new j(localc, new k()
      {
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(128734);
          ad.e(ShareToFacebookRedirectUI.TAG, "refresh token error. errType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          super.onError(paramAnonymousInt, paramAnonymousString);
          if (paramAnonymousInt == 3) {
            ShareToFacebookRedirectUI.a(ShareToFacebookRedirectUI.this);
          }
          AppMethodBeat.o(128734);
        }
        
        public final void w(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(128733);
          super.w(paramAnonymousBundle);
          AppMethodBeat.o(128733);
        }
      }).aIh();
      AppMethodBeat.o(128741);
      return;
    }
    aKh();
    AppMethodBeat.o(128741);
  }
  
  private void aKh()
  {
    AppMethodBeat.i(128742);
    ad.i(TAG, "doSend");
    final f.a locala = new f.a(this);
    locala.au(this.ixN).aMp(this.ixP).av(this.ixO).aMq(getString(2131755696)).aaF(2131755891).c(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(128736);
        ShareToFacebookRedirectUI.this.hideVKB();
        locala.ijc.dismiss();
        if (paramAnonymousBoolean)
        {
          cpl localcpl = new cpl();
          String str = paramAnonymousString;
          if (bt.isNullOrNil(paramAnonymousString)) {
            str = " ";
          }
          localcpl.sac = str;
          localcpl.Name = ShareToFacebookRedirectUI.b(ShareToFacebookRedirectUI.this);
          localcpl.Cxw = ShareToFacebookRedirectUI.c(ShareToFacebookRedirectUI.this);
          localcpl.ubD = ShareToFacebookRedirectUI.d(ShareToFacebookRedirectUI.this);
          localcpl.EiY = ShareToFacebookRedirectUI.e(ShareToFacebookRedirectUI.this);
          paramAnonymousString = new com.tencent.mm.plugin.account.model.h(localcpl);
          com.tencent.mm.kernel.g.aeS().a(paramAnonymousString, 0);
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
  
  private void bI(String paramString1, String paramString2)
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
      ad.i(str, "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 0) || (paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      ad.i(TAG, "bind facebooksucc %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      aKI();
      aKh();
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
    com.tencent.mm.kernel.g.aeS().a(433, this);
    this.ixN = getIntent().getStringExtra("title");
    this.ixO = getIntent().getStringExtra("digest");
    this.ixP = getIntent().getStringExtra("img");
    this.ixQ = getIntent().getStringExtra("link");
    ad.i(TAG, "title %s, digest:%s, img:%s, link:%s", new Object[] { this.ixN, this.ixO, this.ixP, this.ixQ });
    if (!u.arj())
    {
      paramBundle = new Intent(this, FacebookAuthUI.class);
      paramBundle.putExtra("is_force_unbind", true);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(128738);
      return;
    }
    aKI();
    aKh();
    AppMethodBeat.o(128738);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128739);
    com.tencent.mm.kernel.g.aeS().b(433, this);
    super.onDestroy();
    AppMethodBeat.o(128739);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128740);
    ad.i(TAG, "type:%d, code:%d, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    hideVKB();
    this.fqw.dismiss();
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = "error";
      }
      bI(getString(2131755906), paramn);
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
      com.tencent.mm.ui.base.h.cf(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI
 * JD-Core Version:    0.7.0.1
 */