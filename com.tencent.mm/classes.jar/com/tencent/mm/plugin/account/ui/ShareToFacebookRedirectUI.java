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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.protocal.protobuf.dac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
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
  private p fNb;
  private String jqZ;
  private String jra;
  private String jrb;
  private String jrc;
  
  private void aUL()
  {
    AppMethodBeat.i(128741);
    ad.i(TAG, "refreshFacebookToken");
    long l = bt.g((Long)g.ajC().ajl().get(65831, null));
    String str = bt.nullAsNil((String)g.ajC().ajl().get(65830, null));
    if ((bt.Df(l) > 86400000L) && (str.length() > 0))
    {
      c localc = new c(getString(2131758773));
      localc.aXa(str);
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
        
        public final void x(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(128733);
          super.x(paramAnonymousBundle);
          AppMethodBeat.o(128733);
        }
      }).aSk();
      AppMethodBeat.o(128741);
      return;
    }
    aUk();
    AppMethodBeat.o(128741);
  }
  
  private void aUk()
  {
    AppMethodBeat.i(128742);
    ad.i(TAG, "doSend");
    final f.a locala = new f.a(this);
    locala.av(this.jqZ).aXP(this.jrb).aw(this.jra).aXQ(getString(2131755696)).afp(2131755891).c(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(128736);
        ShareToFacebookRedirectUI.this.hideVKB();
        locala.jcs.dismiss();
        if (paramAnonymousBoolean)
        {
          dac localdac = new dac();
          String str = paramAnonymousString;
          if (bt.isNullOrNil(paramAnonymousString)) {
            str = " ";
          }
          localdac.ufM = str;
          localdac.Name = ShareToFacebookRedirectUI.b(ShareToFacebookRedirectUI.this);
          localdac.Fvh = ShareToFacebookRedirectUI.c(ShareToFacebookRedirectUI.this);
          localdac.wpT = ShareToFacebookRedirectUI.d(ShareToFacebookRedirectUI.this);
          localdac.Hqx = ShareToFacebookRedirectUI.e(ShareToFacebookRedirectUI.this);
          paramAnonymousString = new com.tencent.mm.plugin.account.model.h(localdac);
          g.aiU().a(paramAnonymousString, 0);
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
      ad.i(str, "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 0) || (paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      ad.i(TAG, "bind facebooksucc %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      aUL();
      aUk();
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
    g.aiU().a(433, this);
    this.jqZ = getIntent().getStringExtra("title");
    this.jra = getIntent().getStringExtra("digest");
    this.jrb = getIntent().getStringExtra("img");
    this.jrc = getIntent().getStringExtra("link");
    ad.i(TAG, "title %s, digest:%s, img:%s, link:%s", new Object[] { this.jqZ, this.jra, this.jrb, this.jrc });
    if (!u.aAS())
    {
      paramBundle = new Intent(this, FacebookAuthUI.class);
      paramBundle.putExtra("is_force_unbind", true);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(128738);
      return;
    }
    aUL();
    aUk();
    AppMethodBeat.o(128738);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128739);
    g.aiU().b(433, this);
    super.onDestroy();
    AppMethodBeat.o(128739);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128740);
    ad.i(TAG, "type:%d, code:%d, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    hideVKB();
    this.fNb.dismiss();
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
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
      com.tencent.mm.ui.base.h.cl(this, paramString);
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