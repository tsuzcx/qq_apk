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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@a(3)
public class RecoverAccountUI1
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private p fua;
  private String iNy;
  
  public int getLayoutId()
  {
    return 2131495226;
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
    }, 2131690371);
    ((Button)findViewById(2131302852)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(184447);
        paramAnonymousView = new in();
        paramAnonymousView.dHA = 3;
        paramAnonymousView.aHZ();
        paramAnonymousView = new y(RecoverAccountUI1.a(RecoverAccountUI1.this));
        com.tencent.mm.kernel.g.agi().a(paramAnonymousView, 0);
        RecoverAccountUI1.a(RecoverAccountUI1.this, h.b(RecoverAccountUI1.this, RecoverAccountUI1.this.getString(2131755804), false, null));
        AppMethodBeat.o(184447);
      }
    });
    AppMethodBeat.o(184450);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(184449);
    super.onCreate(paramBundle);
    this.iNy = getIntent().getStringExtra("key_qrcode_string");
    initView();
    com.tencent.mm.kernel.g.agi().a(870, this);
    AppMethodBeat.o(184449);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(184451);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(870, this);
    AppMethodBeat.o(184451);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(184452);
    ac.i("MicroMsg.RecoverAccountUI1", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.fua != null) {
      this.fua.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("key_session_id", ((lf)((y)paramn).gvE.hvs.hvw).session_id);
      paramString.putExtra("key_old_username", ((lf)((y)paramn).gvE.hvs.hvw).DYl);
      startActivity(RecoverFriendUI.class, paramString);
      finish();
      AppMethodBeat.o(184452);
      return;
    }
    if (bs.isNullOrNil(paramString)) {
      paramString = getString(2131755733);
    }
    for (;;)
    {
      h.a(this, paramString, "", getString(2131755792), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(184448);
          if (paramInt1 == 4)
          {
            paramAnonymousDialogInterface = new in();
            paramAnonymousDialogInterface.dHA = 2;
            paramAnonymousDialogInterface.ell = paramInt2;
            paramAnonymousDialogInterface.aHZ();
            RecoverAccountUI1.this.finish();
            AppMethodBeat.o(184448);
            return;
          }
          paramAnonymousDialogInterface = new in();
          paramAnonymousDialogInterface.dHA = 2;
          paramAnonymousDialogInterface.ell = 1;
          paramAnonymousDialogInterface.aHZ();
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