package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.q.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;

@Deprecated
public class FacebookFriendUI
  extends MMActivity
  implements e.a, com.tencent.mm.al.g
{
  private ProgressDialog fpP = null;
  private ListView iiS;
  private View iiU;
  String iiW;
  private TextView iiX = null;
  private boolean inh = false;
  d iqz;
  
  private void bI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(127977);
    h.a(this, paramString2, paramString1, new FacebookFriendUI.4(this), null);
    AppMethodBeat.o(127977);
  }
  
  public int getLayoutId()
  {
    return 2131493996;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127975);
    this.iiS = ((ListView)findViewById(2131302352));
    this.iiX = ((TextView)findViewById(2131299463));
    this.iiX.setText(2131758791);
    Object localObject1 = (TextView)findViewById(2131299468);
    ((TextView)localObject1).setText(2131758789);
    Object localObject2 = new r((byte)0);
    ((r)localObject2).Htp = new r.b()
    {
      public final boolean BX(String paramAnonymousString)
      {
        return false;
      }
      
      public final void BY(String paramAnonymousString)
      {
        AppMethodBeat.i(127958);
        FacebookFriendUI.a(FacebookFriendUI.this, bt.aFQ(paramAnonymousString));
        paramAnonymousString = FacebookFriendUI.this;
        if (paramAnonymousString.iqz != null) {
          paramAnonymousString.iqz.BW(paramAnonymousString.iiW);
        }
        AppMethodBeat.o(127958);
      }
      
      public final void aIj() {}
      
      public final void aIk() {}
      
      public final void aIl() {}
      
      public final void aIm() {}
    };
    addSearchMenu(true, (r)localObject2);
    this.iqz = new d(this, new q.a()
    {
      public final void aIp()
      {
        AppMethodBeat.i(127962);
        if ((u.arj()) && (FacebookFriendUI.a(FacebookFriendUI.this)))
        {
          if (FacebookFriendUI.b(FacebookFriendUI.this).getCount() != 0) {
            break label56;
          }
          this.iqB.setVisibility(0);
        }
        for (;;)
        {
          FacebookFriendUI.c(FacebookFriendUI.this);
          AppMethodBeat.o(127962);
          return;
          label56:
          this.iqB.setVisibility(8);
        }
      }
    });
    this.iqz.iqv = new d.a()
    {
      public final void pY(int paramAnonymousInt)
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
    this.iiS.setAdapter(this.iqz);
    this.iiU = findViewById(2131302353);
    this.iiS.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(127964);
        paramAnonymousAdapterView = (com.tencent.mm.plugin.account.friend.a.g)FacebookFriendUI.b(FacebookFriendUI.this).getItem(paramAnonymousInt - FacebookFriendUI.e(FacebookFriendUI.this).getHeaderViewsCount());
        if ((paramAnonymousAdapterView.status == 100) || (paramAnonymousAdapterView.status == 101))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.getUsername());
          paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.getNickName());
          paramAnonymousView.putExtra("Contact_KFacebookId", paramAnonymousAdapterView.evr);
          paramAnonymousView.putExtra("Contact_KFacebookName", paramAnonymousAdapterView.aIF());
          paramAnonymousView.putExtra("Contact_Scene", 31);
          com.tencent.mm.plugin.account.a.a.hYt.c(paramAnonymousView, FacebookFriendUI.this);
        }
        if (paramAnonymousAdapterView.status == 102)
        {
          AppMethodBeat.o(127964);
          return;
        }
        AppMethodBeat.o(127964);
      }
    });
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + u.arj());
    if (u.arj())
    {
      this.iiS.setVisibility(0);
      this.iiU.setVisibility(8);
      long l = bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(65831, null));
      localObject1 = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(65830, null));
      if ((bt.vM(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new c(getString(2131758773));
        ((c)localObject2).aLA((String)localObject1);
        new j((c)localObject2, new k()
        {
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(127966);
            super.onError(paramAnonymousInt, paramAnonymousString);
            if (paramAnonymousInt == 3) {
              FacebookFriendUI.f(FacebookFriendUI.this);
            }
            AppMethodBeat.o(127966);
          }
          
          public final void w(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(127965);
            super.w(paramAnonymousBundle);
            AppMethodBeat.o(127965);
          }
        }).aIh();
      }
      localObject1 = new com.tencent.mm.plugin.account.friend.a.ad();
      ((com.tencent.mm.plugin.account.friend.a.ad)localObject1).aIZ();
      localObject2 = new av(new FacebookFriendUI.9(this, (com.tencent.mm.plugin.account.friend.a.ad)localObject1), false);
      if (bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(65829, null)) > 0)
      {
        com.tencent.mm.kernel.g.afB().afk().set(65829, Integer.valueOf(1));
        com.tencent.mm.kernel.g.aeS().a((n)localObject1, 0);
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131755906);
        this.fpP = h.b(localAppCompatActivity, getString(2131762072), true, new FacebookFriendUI.10(this, (av)localObject2, (com.tencent.mm.plugin.account.friend.a.ad)localObject1));
        addTextOptionMenu(0, getString(2131759084), new FacebookFriendUI.11(this));
      }
    }
    for (;;)
    {
      setBackBtn(new FacebookFriendUI.2(this));
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(127960);
          paramAnonymousView = FacebookFriendUI.e(FacebookFriendUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(127960);
        }
      });
      AppMethodBeat.o(127975);
      return;
      ((av)localObject2).av(5000L, 5000L);
      break;
      this.iiS.setVisibility(8);
      this.iiU.setVisibility(0);
      ((TextView)findViewById(2131302354)).setText(2131759040);
      this.iiU.setOnClickListener(new FacebookFriendUI.12(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127971);
    super.onCreate(paramBundle);
    setMMTitle(2131759083);
    com.tencent.mm.kernel.g.aeS().a(32, this);
    initView();
    AppMethodBeat.o(127971);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127974);
    com.tencent.mm.kernel.g.aeS().b(32, this);
    this.iqz.cHX();
    super.onDestroy();
    AppMethodBeat.o(127974);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127973);
    super.onPause();
    p.auq().e(this);
    AppMethodBeat.o(127973);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127972);
    super.onResume();
    p.auq().d(this);
    this.iqz.notifyDataSetChanged();
    AppMethodBeat.o(127972);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127976);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 32)
    {
      AppMethodBeat.o(127976);
      return;
    }
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = "error";
      }
      bI(getString(2131755906), paramn);
      AppMethodBeat.o(127976);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iqz.a(null, null);
      AppMethodBeat.o(127976);
      return;
    }
    Toast.makeText(this, 2131761250, 0).show();
    AppMethodBeat.o(127976);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(127978);
    this.iqz.notifyDataSetChanged();
    AppMethodBeat.o(127978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI
 * JD-Core Version:    0.7.0.1
 */