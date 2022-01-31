package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.e.a;

@a(3)
public class ShareToFacebookRedirectUI
  extends MMActivity
  implements f
{
  private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
  private com.tencent.mm.ui.base.p dnV;
  private String fsF;
  private String fsG;
  private String fsH;
  private String fsI;
  
  private void XY()
  {
    y.i(TAG, "doSend");
    e.a locala1 = new e.a(this);
    e.a locala2 = locala1.aeF(this.fsF);
    String str = this.fsH;
    locala2.scn.aeB(str);
    str = this.fsG;
    int i = ap.fromDPToPix(locala2.mContext, (int)(14.0F * ap.cJ(locala2.mContext)));
    if ((str != null) && (str.length() > 0))
    {
      SpannableString localSpannableString = (SpannableString)b.c(str.toString(), i);
      locala2.scn.U(localSpannableString);
    }
    locala2.scn.U(str);
    locala2.aeH(getString(q.j.app_comment)).Iu(q.j.app_share).c(new ShareToFacebookRedirectUI.4(this, locala1)).show();
  }
  
  private void Yv()
  {
    y.i(TAG, "refreshFacebookToken");
    long l = bk.c((Long)com.tencent.mm.kernel.g.DP().Dz().get(65831, null));
    String str = bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(65830, null));
    if ((bk.co(l) > 86400000L) && (str.length() > 0))
    {
      c localc = new c("290293790992170");
      localc.aea(str);
      new com.tencent.mm.plugin.account.model.g(localc, new ShareToFacebookRedirectUI.3(this)).Xx();
      return;
    }
    XY();
  }
  
  private void aS(String paramString1, String paramString2)
  {
    h.a(this.mController.uMN, paramString2, paramString1, new ShareToFacebookRedirectUI.5(this), null);
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str = TAG;
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i(str, "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 0) || (paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      bool = paramIntent.getBooleanExtra("bind_facebook_succ", false);
      y.i(TAG, "bind facebooksucc %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      Yv();
      XY();
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Dk().a(433, this);
    this.fsF = getIntent().getStringExtra("title");
    this.fsG = getIntent().getStringExtra("digest");
    this.fsH = getIntent().getStringExtra("img");
    this.fsI = getIntent().getStringExtra("link");
    y.i(TAG, "title %s, digest:%s, img:%s, link:%s", new Object[] { this.fsF, this.fsG, this.fsH, this.fsI });
    if (!q.GL())
    {
      paramBundle = new Intent(this, FacebookAuthUI.class);
      paramBundle.putExtra("is_force_unbind", true);
      startActivityForResult(paramBundle, 0);
      return;
    }
    Yv();
    XY();
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.kernel.g.Dk().b(433, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i(TAG, "type:%d, code:%d, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    XM();
    this.dnV.dismiss();
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramm = paramString;
      if (bk.bl(paramString)) {
        paramm = "error";
      }
      aS(getString(q.j.app_tip), paramm);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getString(q.j.share_ok);
      new ShareToFacebookRedirectUI.1(this);
      h.bC(this, paramString);
      finish();
      return;
    }
    h.a(this.mController.uMN, "err(" + paramInt2 + "," + paramInt1 + ")", getString(q.j.app_tip), new ShareToFacebookRedirectUI.2(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI
 * JD-Core Version:    0.7.0.1
 */