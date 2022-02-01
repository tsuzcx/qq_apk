package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.uo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.model.v;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

@com.tencent.mm.ui.base.a(3)
public class RecoverAccountUI1
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String pVJ;
  private w psR;
  
  public int getLayoutId()
  {
    return a.d.recover_account_instruct_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(184450);
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.a.BG_2));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(184446);
        RecoverAccountUI1.this.finish();
        AppMethodBeat.o(184446);
        return true;
      }
    }, a.f.icons_filled_close);
    ((Button)findViewById(a.c.next_btn)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(184447);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/RecoverAccountUI1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new uo();
        paramAnonymousView.ipB = 3;
        paramAnonymousView.bMH();
        paramAnonymousView = new v(RecoverAccountUI1.a(RecoverAccountUI1.this));
        com.tencent.mm.kernel.h.aZW().a(paramAnonymousView, 0);
        RecoverAccountUI1.a(RecoverAccountUI1.this, k.a(RecoverAccountUI1.this, RecoverAccountUI1.this.getString(a.g.app_loading), false, null));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/RecoverAccountUI1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(184447);
      }
    });
    AppMethodBeat.o(184450);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(184449);
    super.onCreate(paramBundle);
    this.pVJ = getIntent().getStringExtra("key_qrcode_string");
    initView();
    com.tencent.mm.kernel.h.aZW().a(870, this);
    AppMethodBeat.o(184449);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(184451);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(870, this);
    AppMethodBeat.o(184451);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(184452);
    Log.i("MicroMsg.RecoverAccountUI1", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.psR != null) {
      this.psR.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("key_session_id", ((mx)c.c.b(((v)paramp).nao.otC)).session_id);
      paramString.putExtra("key_old_username", ((mx)c.c.b(((v)paramp).nao.otC)).YOa);
      startActivity(RecoverFriendUI.class, paramString);
      finish();
      AppMethodBeat.o(184452);
      return;
    }
    if (Util.isNullOrNil(paramString)) {
      paramString = getString(a.g.app_err_system_busy_tip);
    }
    for (;;)
    {
      k.a(this, paramString, "", getString(a.g.app_i_know), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(184448);
          if (paramInt1 == 4)
          {
            paramAnonymousDialogInterface = new uo();
            paramAnonymousDialogInterface.ipB = 2;
            paramAnonymousDialogInterface.jHG = paramInt2;
            paramAnonymousDialogInterface.bMH();
            RecoverAccountUI1.this.finish();
            AppMethodBeat.o(184448);
            return;
          }
          paramAnonymousDialogInterface = new uo();
          paramAnonymousDialogInterface.ipB = 2;
          paramAnonymousDialogInterface.jHG = 1;
          paramAnonymousDialogInterface.bMH();
          AppMethodBeat.o(184448);
        }
      });
      AppMethodBeat.o(184452);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecoverAccountUI1
 * JD-Core Version:    0.7.0.1
 */