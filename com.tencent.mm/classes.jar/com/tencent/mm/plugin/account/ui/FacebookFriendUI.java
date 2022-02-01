package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;

@Deprecated
public class FacebookFriendUI
  extends MMActivity
  implements com.tencent.mm.aj.e.a, i
{
  private ProgressDialog gtM = null;
  private ListView kde;
  private View kdg;
  String kdi;
  private TextView kdj = null;
  private boolean khr = false;
  e kkQ;
  
  private void cb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(127977);
    h.a(this, paramString2, paramString1, new FacebookFriendUI.4(this), null);
    AppMethodBeat.o(127977);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(127978);
    this.kkQ.notifyDataSetChanged();
    AppMethodBeat.o(127978);
  }
  
  public int getLayoutId()
  {
    return 2131494166;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127975);
    this.kde = ((ListView)findViewById(2131304749));
    this.kdj = ((TextView)findViewById(2131300087));
    this.kdj.setText(2131759112);
    Object localObject1 = (TextView)findViewById(2131300096);
    ((TextView)localObject1).setText(2131759110);
    Object localObject2 = new s((byte)0);
    ((s)localObject2).Qwi = new s.b()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(127958);
        FacebookFriendUI.a(FacebookFriendUI.this, Util.escapeSqlValue(paramAnonymousString));
        paramAnonymousString = FacebookFriendUI.this;
        if (paramAnonymousString.kkQ != null) {
          paramAnonymousString.kkQ.SM(paramAnonymousString.kdi);
        }
        AppMethodBeat.o(127958);
      }
      
      public final void bnA() {}
      
      public final void bnB() {}
      
      public final void bny() {}
      
      public final void bnz() {}
    };
    addSearchMenu(true, (s)localObject2);
    this.kkQ = new e(this, new s.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(127962);
        if ((z.aUF()) && (FacebookFriendUI.a(FacebookFriendUI.this)))
        {
          if (FacebookFriendUI.b(FacebookFriendUI.this).getCount() != 0) {
            break label56;
          }
          this.kkS.setVisibility(0);
        }
        for (;;)
        {
          FacebookFriendUI.c(FacebookFriendUI.this);
          AppMethodBeat.o(127962);
          return;
          label56:
          this.kkS.setVisibility(8);
        }
      }
    });
    this.kkQ.kkM = new e.a()
    {
      public final void ve(int paramAnonymousInt)
      {
        AppMethodBeat.i(127963);
        if (paramAnonymousInt > 0)
        {
          FacebookFriendUI.d(FacebookFriendUI.this).setVisibility(8);
          AppMethodBeat.o(127963);
          return;
        }
        FacebookFriendUI.d(FacebookFriendUI.this).setVisibility(0);
        AppMethodBeat.o(127963);
      }
    };
    this.kde.setAdapter(this.kkQ);
    this.kdg = findViewById(2131304750);
    this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(127964);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/FacebookFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = (com.tencent.mm.plugin.account.friend.a.g)FacebookFriendUI.b(FacebookFriendUI.this).getItem(paramAnonymousInt - FacebookFriendUI.e(FacebookFriendUI.this).getHeaderViewsCount());
        if ((paramAnonymousAdapterView.status == 100) || (paramAnonymousAdapterView.status == 101))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.getUsername());
          paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.getNickName());
          paramAnonymousView.putExtra("Contact_KFacebookId", paramAnonymousAdapterView.fuC);
          paramAnonymousView.putExtra("Contact_KFacebookName", paramAnonymousAdapterView.bnT());
          paramAnonymousView.putExtra("Contact_Scene", 31);
          com.tencent.mm.plugin.account.a.a.jRt.c(paramAnonymousView, FacebookFriendUI.this);
        }
        if (paramAnonymousAdapterView.status == 102)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(127964);
          return;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(127964);
      }
    });
    Log.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + z.aUF());
    if (z.aUF())
    {
      this.kde.setVisibility(0);
      this.kdg.setVisibility(8);
      long l = Util.nullAsNil((Long)com.tencent.mm.kernel.g.aAh().azQ().get(65831, null));
      localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(65830, null));
      if ((Util.milliSecondsToNow(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new c(getString(2131759094));
        ((c)localObject2).bnE((String)localObject1);
        new k((c)localObject2, new l()
        {
          public final void E(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(127965);
            super.E(paramAnonymousBundle);
            AppMethodBeat.o(127965);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(127966);
            super.onError(paramAnonymousInt, paramAnonymousString);
            if (paramAnonymousInt == 3) {
              FacebookFriendUI.f(FacebookFriendUI.this);
            }
            AppMethodBeat.o(127966);
          }
        }).bnw();
      }
      localObject1 = new ad();
      ((ad)localObject1).bon();
      localObject2 = new MTimerHandler(new FacebookFriendUI.9(this, (ad)localObject1), false);
      if (Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(65829, null)) > 0)
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(65829, Integer.valueOf(1));
        com.tencent.mm.kernel.g.azz().a((q)localObject1, 0);
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131755998);
        this.gtM = h.a(localAppCompatActivity, getString(2131764090), true, new FacebookFriendUI.10(this, (MTimerHandler)localObject2, (ad)localObject1));
        addTextOptionMenu(0, getString(2131759417), new FacebookFriendUI.11(this));
      }
    }
    for (;;)
    {
      setBackBtn(new FacebookFriendUI.2(this));
      setToTop(new FacebookFriendUI.3(this));
      AppMethodBeat.o(127975);
      return;
      ((MTimerHandler)localObject2).startTimer(5000L);
      break;
      this.kde.setVisibility(8);
      this.kdg.setVisibility(0);
      ((TextView)findViewById(2131304751)).setText(2131759366);
      this.kdg.setOnClickListener(new FacebookFriendUI.12(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127971);
    super.onCreate(paramBundle);
    setMMTitle(2131759416);
    com.tencent.mm.kernel.g.azz().a(32, this);
    initView();
    AppMethodBeat.o(127971);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127974);
    com.tencent.mm.kernel.g.azz().b(32, this);
    this.kkQ.ebf();
    super.onDestroy();
    AppMethodBeat.o(127974);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127973);
    super.onPause();
    p.aYn().e(this);
    AppMethodBeat.o(127973);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127972);
    super.onResume();
    p.aYn().d(this);
    this.kkQ.notifyDataSetChanged();
    AppMethodBeat.o(127972);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127976);
    Log.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 32)
    {
      AppMethodBeat.o(127976);
      return;
    }
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = "error";
      }
      cb(getString(2131755998), paramq);
      AppMethodBeat.o(127976);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.kkQ.onNotifyChange(null, null);
      AppMethodBeat.o(127976);
      return;
    }
    Toast.makeText(this, 2131763076, 0).show();
    AppMethodBeat.o(127976);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI
 * JD-Core Version:    0.7.0.1
 */