package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.protocal.protobuf.ext;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;

@a(3)
public class ShareToFacebookRedirectUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
  private com.tencent.mm.ui.mmfb.sdk.f pWC;
  private w psR;
  private String qhe;
  private String qhf;
  private String qhg;
  private String qhh;
  
  private void bYx()
  {
    AppMethodBeat.i(128742);
    Log.i(TAG, "doSend");
    final g.a locala = new g.a(this);
    locala.bf(this.qhe).bDF(this.qhg).bg(this.qhf).bDG(getString(r.j.app_comment)).aEX(r.j.app_share).c(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(128736);
        ShareToFacebookRedirectUI.this.hideVKB();
        locala.pRv.dismiss();
        if (paramAnonymousBoolean)
        {
          ext localext = new ext();
          String str = paramAnonymousString;
          if (Util.isNullOrNil(paramAnonymousString)) {
            str = " ";
          }
          localext.IHO = str;
          localext.IGU = ShareToFacebookRedirectUI.b(ShareToFacebookRedirectUI.this);
          localext.crB = ShareToFacebookRedirectUI.c(ShareToFacebookRedirectUI.this);
          localext.MpP = ShareToFacebookRedirectUI.d(ShareToFacebookRedirectUI.this);
          localext.abzu = ShareToFacebookRedirectUI.e(ShareToFacebookRedirectUI.this);
          paramAnonymousString = new com.tencent.mm.plugin.account.model.h(localext);
          com.tencent.mm.kernel.h.aZW().a(paramAnonymousString, 0);
          ShareToFacebookRedirectUI.a(ShareToFacebookRedirectUI.this, com.tencent.mm.ui.base.k.a(ShareToFacebookRedirectUI.this, "", false, new DialogInterface.OnCancelListener()
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
  
  private void bZa()
  {
    AppMethodBeat.i(128741);
    Log.i(TAG, "refreshFacebookToken");
    long l = Util.nullAsNil((Long)com.tencent.mm.kernel.h.baE().ban().d(65831, null));
    String str = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(65830, null));
    if ((Util.milliSecondsToNow(l) > 86400000L) && (str.length() > 0))
    {
      this.pWC = new com.tencent.mm.ui.mmfb.sdk.f();
      this.pWC.bCk(str);
      new j(this.pWC, new com.tencent.mm.plugin.account.model.k()
      {
        public final void T(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(128733);
          super.T(paramAnonymousBundle);
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
      }).bWu();
      AppMethodBeat.o(128741);
      return;
    }
    bYx();
    AppMethodBeat.o(128741);
  }
  
  private void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128743);
    com.tencent.mm.ui.base.k.a(getContext(), paramString2, paramString1, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(128737);
        paramAnonymousDialogInterface = new Intent(ShareToFacebookRedirectUI.this.getContext(), MMFBAuthUI.class);
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
      bZa();
      bYx();
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
    com.tencent.mm.kernel.h.aZW().a(433, this);
    this.qhe = getIntent().getStringExtra("title");
    this.qhf = getIntent().getStringExtra("digest");
    this.qhg = getIntent().getStringExtra("img");
    this.qhh = getIntent().getStringExtra("link");
    Log.i(TAG, "title %s, digest:%s, img:%s, link:%s", new Object[] { this.qhe, this.qhf, this.qhg, this.qhh });
    if (!z.bBz())
    {
      paramBundle = new Intent(this, MMFBAuthUI.class);
      paramBundle.putExtra("is_force_unbind", true);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(128738);
      return;
    }
    bZa();
    bYx();
    AppMethodBeat.o(128738);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128739);
    com.tencent.mm.kernel.h.aZW().b(433, this);
    if (this.pWC != null) {
      this.pWC.cf(this);
    }
    super.onDestroy();
    AppMethodBeat.o(128739);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128740);
    Log.i(TAG, "type:%d, code:%d, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    hideVKB();
    this.psR.dismiss();
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = "error";
      }
      cv(getString(r.j.app_tip), paramp);
      AppMethodBeat.o(128740);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getString(r.j.share_ok);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      com.tencent.mm.ui.base.k.cZ(this, paramString);
      finish();
      AppMethodBeat.o(128740);
      return;
    }
    com.tencent.mm.ui.base.k.a(getContext(), "err(" + paramInt2 + "," + paramInt1 + ")", getString(r.j.app_tip), new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI
 * JD-Core Version:    0.7.0.1
 */