package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.q.b;

public class InviteFacebookFriendsUI
  extends MMActivity
  implements f
{
  private ProgressDialog eeN = null;
  private final int gAe = 5;
  InviteFacebookFriendsUI.a gDw;
  private ListView gvV;
  private View gvX;
  String gvZ;
  
  private void bm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124898);
    com.tencent.mm.ui.base.h.a(this, paramString2, paramString1, new InviteFacebookFriendsUI.2(this), null);
    AppMethodBeat.o(124898);
  }
  
  public int getLayoutId()
  {
    return 2130969578;
  }
  
  public void initView()
  {
    AppMethodBeat.i(124897);
    this.gvV = ((ListView)findViewById(2131824128));
    Object localObject1 = (TextView)findViewById(2131821852);
    ((TextView)localObject1).setText(2131299630);
    Object localObject2 = new q((byte)0);
    ((q)localObject2).Axg = new q.b()
    {
      public final void apN() {}
      
      public final void apO() {}
      
      public final void apP() {}
      
      public final void apQ() {}
      
      public final boolean wR(String paramAnonymousString)
      {
        return false;
      }
      
      public final void wS(String paramAnonymousString)
      {
        AppMethodBeat.i(124871);
        InviteFacebookFriendsUI.a(InviteFacebookFriendsUI.this, bo.wC(paramAnonymousString));
        paramAnonymousString = InviteFacebookFriendsUI.this;
        if (paramAnonymousString.gDw != null)
        {
          InviteFacebookFriendsUI.a locala = paramAnonymousString.gDw;
          locala.gvB = bo.wC(paramAnonymousString.gvZ.trim());
          locala.bKb();
          locala.Ku();
        }
        AppMethodBeat.o(124871);
      }
    };
    addSearchMenu(true, (q)localObject2);
    this.gDw = new InviteFacebookFriendsUI.a(this, new InviteFacebookFriendsUI.3(this, (TextView)localObject1));
    this.gvV.setAdapter(this.gDw);
    this.gvX = findViewById(2131824130);
    this.gvV.setOnItemClickListener(new InviteFacebookFriendsUI.4(this));
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + r.ZP());
    if (r.ZP())
    {
      this.gvV.setVisibility(0);
      this.gvX.setVisibility(8);
      long l = bo.c((Long)g.RL().Ru().get(65831, null));
      localObject1 = bo.nullAsNil((String)g.RL().Ru().get(65830, null));
      if ((bo.hl(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new c(getString(2131306163));
        ((c)localObject2).auI((String)localObject1);
        new com.tencent.mm.plugin.account.model.h((c)localObject2, new InviteFacebookFriendsUI.5(this)).apL();
      }
      localObject1 = new com.tencent.mm.plugin.account.friend.a.ab();
      ((com.tencent.mm.plugin.account.friend.a.ab)localObject1).aqE();
      localObject2 = new ap(new InviteFacebookFriendsUI.6(this, (com.tencent.mm.plugin.account.friend.a.ab)localObject1), false);
      if (bo.g((Integer)g.RL().Ru().get(65829, null)) <= 0) {
        break label439;
      }
      g.RL().Ru().set(65829, Integer.valueOf(1));
      g.Rc().a((m)localObject1, 0);
    }
    for (;;)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131302195), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(124878);
          this.gDj.stopTimer();
          g.Rc().a(this.gDi);
          AppMethodBeat.o(124878);
        }
      });
      setBackBtn(new InviteFacebookFriendsUI.8(this));
      setToTop(new InviteFacebookFriendsUI.9(this));
      addTextOptionMenu(0, getString(2131299634), new InviteFacebookFriendsUI.10(this));
      showOptionMenu(false);
      AppMethodBeat.o(124897);
      return;
      label439:
      ((ap)localObject2).ag(5000L, 5000L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(124895);
    super.onCreate(paramBundle);
    setMMTitle(2131299637);
    g.Rc().a(32, this);
    initView();
    AppMethodBeat.o(124895);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(124896);
    g.Rc().b(32, this);
    this.gDw.bKb();
    super.onDestroy();
    AppMethodBeat.o(124896);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124899);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() != 32)
    {
      AppMethodBeat.o(124899);
      return;
    }
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramm = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramm = "error";
      }
      bm(getString(2131297087), paramm);
      AppMethodBeat.o(124899);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.gDw.a(null, null);
      AppMethodBeat.o(124899);
      return;
    }
    Toast.makeText(this, 2131301578, 0).show();
    AppMethodBeat.o(124899);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI
 * JD-Core Version:    0.7.0.1
 */