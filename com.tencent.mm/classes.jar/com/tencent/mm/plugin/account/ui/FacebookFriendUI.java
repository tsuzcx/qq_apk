package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
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

@Deprecated
public class FacebookFriendUI
  extends MMActivity
  implements d.a, f
{
  private ProgressDialog eeN = null;
  d gDf;
  private ListView gvV;
  private View gvX;
  String gvZ;
  private TextView gwa = null;
  private boolean gzX = false;
  
  private void bm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124826);
    com.tencent.mm.ui.base.h.a(this, paramString2, paramString1, new FacebookFriendUI.4(this), null);
    AppMethodBeat.o(124826);
  }
  
  public int getLayoutId()
  {
    return 2130969578;
  }
  
  public void initView()
  {
    AppMethodBeat.i(124824);
    this.gvV = ((ListView)findViewById(2131824128));
    this.gwa = ((TextView)findViewById(2131824129));
    this.gwa.setText(2131299632);
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
        AppMethodBeat.i(124807);
        FacebookFriendUI.a(FacebookFriendUI.this, bo.wC(paramAnonymousString));
        paramAnonymousString = FacebookFriendUI.this;
        if (paramAnonymousString.gDf != null) {
          paramAnonymousString.gDf.wQ(paramAnonymousString.gvZ);
        }
        AppMethodBeat.o(124807);
      }
    };
    addSearchMenu(true, (q)localObject2);
    this.gDf = new d(this, new FacebookFriendUI.5(this, (TextView)localObject1));
    this.gDf.gDb = new FacebookFriendUI.6(this);
    this.gvV.setAdapter(this.gDf);
    this.gvX = findViewById(2131824130);
    this.gvV.setOnItemClickListener(new FacebookFriendUI.7(this));
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + r.ZP());
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
        new com.tencent.mm.plugin.account.model.h((c)localObject2, new FacebookFriendUI.8(this)).apL();
      }
      localObject1 = new com.tencent.mm.plugin.account.friend.a.ab();
      ((com.tencent.mm.plugin.account.friend.a.ab)localObject1).aqE();
      localObject2 = new ap(new FacebookFriendUI.9(this, (com.tencent.mm.plugin.account.friend.a.ab)localObject1), false);
      if (bo.g((Integer)g.RL().Ru().get(65829, null)) > 0)
      {
        g.RL().Ru().set(65829, Integer.valueOf(1));
        g.Rc().a((m)localObject1, 0);
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131297087);
        this.eeN = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131302195), true, new FacebookFriendUI.10(this, (ap)localObject2, (com.tencent.mm.plugin.account.friend.a.ab)localObject1));
        addTextOptionMenu(0, getString(2131299898), new FacebookFriendUI.11(this));
      }
    }
    for (;;)
    {
      setBackBtn(new FacebookFriendUI.2(this));
      setToTop(new FacebookFriendUI.3(this));
      AppMethodBeat.o(124824);
      return;
      ((ap)localObject2).ag(5000L, 5000L);
      break;
      this.gvV.setVisibility(8);
      this.gvX.setVisibility(0);
      ((TextView)findViewById(2131824131)).setText(2131299863);
      this.gvX.setOnClickListener(new FacebookFriendUI.12(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(124820);
    super.onCreate(paramBundle);
    setMMTitle(2131299897);
    g.Rc().a(32, this);
    initView();
    AppMethodBeat.o(124820);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(124823);
    g.Rc().b(32, this);
    this.gDf.bKb();
    super.onDestroy();
    AppMethodBeat.o(124823);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(124822);
    super.onPause();
    o.acQ().e(this);
    AppMethodBeat.o(124822);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(124821);
    super.onResume();
    o.acQ().d(this);
    this.gDf.notifyDataSetChanged();
    AppMethodBeat.o(124821);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124825);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() != 32)
    {
      AppMethodBeat.o(124825);
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
      AppMethodBeat.o(124825);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.gDf.a(null, null);
      AppMethodBeat.o(124825);
      return;
    }
    Toast.makeText(this, 2131301578, 0).show();
    AppMethodBeat.o(124825);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(124827);
    this.gDf.notifyDataSetChanged();
    AppMethodBeat.o(124827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI
 * JD-Core Version:    0.7.0.1
 */