package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.ns;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class RecoverAccountUI1
  extends MMActivity
  implements i
{
  private com.tencent.mm.ui.base.q gut;
  private String khC;
  
  public int getLayoutId()
  {
    return 2131496072;
  }
  
  public void initView()
  {
    AppMethodBeat.i(184450);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131099650));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(184446);
        RecoverAccountUI1.this.finish();
        AppMethodBeat.o(184446);
        return true;
      }
    }, 2131690514);
    ((Button)findViewById(2131305423)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(184447);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/RecoverAccountUI1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new ns();
        paramAnonymousView.eqm = 3;
        paramAnonymousView.bfK();
        paramAnonymousView = new y(RecoverAccountUI1.a(RecoverAccountUI1.this));
        g.azz().a(paramAnonymousView, 0);
        RecoverAccountUI1.a(RecoverAccountUI1.this, h.a(RecoverAccountUI1.this, RecoverAccountUI1.this.getString(2131755886), false, null));
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
    this.khC = getIntent().getStringExtra("key_qrcode_string");
    initView();
    g.azz().a(870, this);
    AppMethodBeat.o(184449);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(184451);
    super.onDestroy();
    g.azz().b(870, this);
    AppMethodBeat.o(184451);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(184452);
    Log.i("MicroMsg.RecoverAccountUI1", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.gut != null) {
      this.gut.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("key_session_id", ((mg)((y)paramq).hJu.iLL.iLR).session_id);
      paramString.putExtra("key_old_username", ((mg)((y)paramq).hJu.iLL.iLR).KPN);
      startActivity(RecoverFriendUI.class, paramString);
      finish();
      AppMethodBeat.o(184452);
      return;
    }
    if (Util.isNullOrNil(paramString)) {
      paramString = getString(2131755804);
    }
    for (;;)
    {
      h.a(this, paramString, "", getString(2131755873), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(184448);
          if (paramInt1 == 4)
          {
            paramAnonymousDialogInterface = new ns();
            paramAnonymousDialogInterface.eqm = 2;
            paramAnonymousDialogInterface.fiv = paramInt2;
            paramAnonymousDialogInterface.bfK();
            RecoverAccountUI1.this.finish();
            AppMethodBeat.o(184448);
            return;
          }
          paramAnonymousDialogInterface = new ns();
          paramAnonymousDialogInterface.eqm = 2;
          paramAnonymousDialogInterface.fiv = 1;
          paramAnonymousDialogInterface.bfK();
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