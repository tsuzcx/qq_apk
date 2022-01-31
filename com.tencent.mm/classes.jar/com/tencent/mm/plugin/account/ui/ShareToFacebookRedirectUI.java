package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.widget.b.e.a;

@a(3)
public class ShareToFacebookRedirectUI
  extends MMActivity
  implements f
{
  private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
  private com.tencent.mm.ui.base.p efs;
  private String gKh;
  private String gKi;
  private String gKj;
  private String gKk;
  
  private void arH()
  {
    AppMethodBeat.i(125580);
    ab.i(TAG, "doSend");
    e.a locala = new e.a(this);
    locala.aj(this.gKh).avv(this.gKj).ak(this.gKi).avw(getString(2131296893)).Rm(2131297073).c(new ShareToFacebookRedirectUI.4(this, locala)).show();
    AppMethodBeat.o(125580);
  }
  
  private void asf()
  {
    AppMethodBeat.i(125579);
    ab.i(TAG, "refreshFacebookToken");
    long l = bo.c((Long)g.RL().Ru().get(65831, null));
    String str = bo.nullAsNil((String)g.RL().Ru().get(65830, null));
    if ((bo.hl(l) > 86400000L) && (str.length() > 0))
    {
      c localc = new c(getString(2131306163));
      localc.auI(str);
      new com.tencent.mm.plugin.account.model.h(localc, new i()
      {
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(125572);
          ab.e(ShareToFacebookRedirectUI.TAG, "refresh token error. errType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          super.onError(paramAnonymousInt, paramAnonymousString);
          if (paramAnonymousInt == 3) {
            ShareToFacebookRedirectUI.a(ShareToFacebookRedirectUI.this);
          }
          AppMethodBeat.o(125572);
        }
        
        public final void u(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(125571);
          super.u(paramAnonymousBundle);
          AppMethodBeat.o(125571);
        }
      }).apL();
      AppMethodBeat.o(125579);
      return;
    }
    arH();
    AppMethodBeat.o(125579);
  }
  
  private void bm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125581);
    com.tencent.mm.ui.base.h.a(getContext(), paramString2, paramString1, new ShareToFacebookRedirectUI.5(this), null);
    AppMethodBeat.o(125581);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(125582);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str = TAG;
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i(str, "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 0) || (paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      ab.i(TAG, "bind facebooksucc %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      asf();
      arH();
      AppMethodBeat.o(125582);
      return;
    }
    finish();
    AppMethodBeat.o(125582);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125576);
    super.onCreate(paramBundle);
    g.Rc().a(433, this);
    this.gKh = getIntent().getStringExtra("title");
    this.gKi = getIntent().getStringExtra("digest");
    this.gKj = getIntent().getStringExtra("img");
    this.gKk = getIntent().getStringExtra("link");
    ab.i(TAG, "title %s, digest:%s, img:%s, link:%s", new Object[] { this.gKh, this.gKi, this.gKj, this.gKk });
    if (!r.ZP())
    {
      paramBundle = new Intent(this, FacebookAuthUI.class);
      paramBundle.putExtra("is_force_unbind", true);
      startActivityForResult(paramBundle, 0);
      AppMethodBeat.o(125576);
      return;
    }
    asf();
    arH();
    AppMethodBeat.o(125576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125577);
    g.Rc().b(433, this);
    super.onDestroy();
    AppMethodBeat.o(125577);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(125578);
    ab.i(TAG, "type:%d, code:%d, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    hideVKB();
    this.efs.dismiss();
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramm = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramm = "error";
      }
      bm(getString(2131297087), paramm);
      AppMethodBeat.o(125578);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getString(2131303664);
      new ShareToFacebookRedirectUI.1(this);
      com.tencent.mm.ui.base.h.bO(this, paramString);
      finish();
      AppMethodBeat.o(125578);
      return;
    }
    com.tencent.mm.ui.base.h.a(getContext(), "err(" + paramInt2 + "," + paramInt1 + ")", getString(2131297087), new ShareToFacebookRedirectUI.2(this), null);
    AppMethodBeat.o(125578);
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