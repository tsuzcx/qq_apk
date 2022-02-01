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
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;

@Deprecated
public class FacebookFriendUI
  extends MMActivity
  implements e.a, f
{
  private ProgressDialog fOC = null;
  private ListView jfb;
  private View jfd;
  String jff;
  private TextView jfg = null;
  private boolean jjp = false;
  d jmH;
  
  private void bS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(127977);
    h.a(this, paramString2, paramString1, new FacebookFriendUI.4(this), null);
    AppMethodBeat.o(127977);
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(127978);
    this.jmH.notifyDataSetChanged();
    AppMethodBeat.o(127978);
  }
  
  public int getLayoutId()
  {
    return 2131493996;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127975);
    this.jfb = ((ListView)findViewById(2131302352));
    this.jfg = ((TextView)findViewById(2131299463));
    this.jfg.setText(2131758791);
    Object localObject1 = (TextView)findViewById(2131299468);
    ((TextView)localObject1).setText(2131758789);
    Object localObject2 = new r((byte)0);
    ((r)localObject2).Lhk = new r.b()
    {
      public final boolean JO(String paramAnonymousString)
      {
        return false;
      }
      
      public final void JP(String paramAnonymousString)
      {
        AppMethodBeat.i(127958);
        FacebookFriendUI.a(FacebookFriendUI.this, bu.aSk(paramAnonymousString));
        paramAnonymousString = FacebookFriendUI.this;
        if (paramAnonymousString.jmH != null) {
          paramAnonymousString.jmH.JN(paramAnonymousString.jff);
        }
        AppMethodBeat.o(127958);
      }
      
      public final void aSL() {}
      
      public final void aSM() {}
      
      public final void aSN() {}
      
      public final void aSO() {}
    };
    addSearchMenu(true, (r)localObject2);
    this.jmH = new d(this, new r.a()
    {
      public final void aSR()
      {
        AppMethodBeat.i(127962);
        if ((v.aBi()) && (FacebookFriendUI.a(FacebookFriendUI.this)))
        {
          if (FacebookFriendUI.b(FacebookFriendUI.this).getCount() != 0) {
            break label56;
          }
          this.jmJ.setVisibility(0);
        }
        for (;;)
        {
          FacebookFriendUI.c(FacebookFriendUI.this);
          AppMethodBeat.o(127962);
          return;
          label56:
          this.jmJ.setVisibility(8);
        }
      }
    });
    this.jmH.jmD = new d.a()
    {
      public final void ro(int paramAnonymousInt)
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
    this.jfb.setAdapter(this.jmH);
    this.jfd = findViewById(2131302353);
    this.jfb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(127964);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/FacebookFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = (com.tencent.mm.plugin.account.friend.a.g)FacebookFriendUI.b(FacebookFriendUI.this).getItem(paramAnonymousInt - FacebookFriendUI.e(FacebookFriendUI.this).getHeaderViewsCount());
        if ((paramAnonymousAdapterView.status == 100) || (paramAnonymousAdapterView.status == 101))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.getUsername());
          paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.getNickName());
          paramAnonymousView.putExtra("Contact_KFacebookId", paramAnonymousAdapterView.eQX);
          paramAnonymousView.putExtra("Contact_KFacebookName", paramAnonymousAdapterView.aTh());
          paramAnonymousView.putExtra("Contact_Scene", 31);
          com.tencent.mm.plugin.account.a.a.iUz.c(paramAnonymousView, FacebookFriendUI.this);
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
    ae.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + v.aBi());
    if (v.aBi())
    {
      this.jfb.setVisibility(0);
      this.jfd.setVisibility(8);
      long l = bu.i((Long)com.tencent.mm.kernel.g.ajR().ajA().get(65831, null));
      localObject1 = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(65830, null));
      if ((bu.DD(l) > 86400000L) && (((String)localObject1).length() > 0))
      {
        localObject2 = new c(getString(2131758773));
        ((c)localObject2).aYB((String)localObject1);
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
          
          public final void y(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(127965);
            super.y(paramAnonymousBundle);
            AppMethodBeat.o(127965);
          }
        }).aSJ();
      }
      localObject1 = new ad();
      ((ad)localObject1).aTB();
      localObject2 = new aw(new FacebookFriendUI.9(this, (ad)localObject1), false);
      if (bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(65829, null)) > 0)
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(65829, Integer.valueOf(1));
        com.tencent.mm.kernel.g.ajj().a((n)localObject1, 0);
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131755906);
        this.fOC = h.b(localAppCompatActivity, getString(2131762072), true, new FacebookFriendUI.10(this, (aw)localObject2, (ad)localObject1));
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
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          paramAnonymousView = FacebookFriendUI.e(FacebookFriendUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/FacebookFriendUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(127960);
        }
      });
      AppMethodBeat.o(127975);
      return;
      ((aw)localObject2).ay(5000L, 5000L);
      break;
      this.jfb.setVisibility(8);
      this.jfd.setVisibility(0);
      ((TextView)findViewById(2131302354)).setText(2131759040);
      this.jfd.setOnClickListener(new FacebookFriendUI.12(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127971);
    super.onCreate(paramBundle);
    setMMTitle(2131759083);
    com.tencent.mm.kernel.g.ajj().a(32, this);
    initView();
    AppMethodBeat.o(127971);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127974);
    com.tencent.mm.kernel.g.ajj().b(32, this);
    this.jmH.dhl();
    super.onDestroy();
    AppMethodBeat.o(127974);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127973);
    super.onPause();
    p.aEA().e(this);
    AppMethodBeat.o(127973);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127972);
    super.onResume();
    p.aEA().d(this);
    this.jmH.notifyDataSetChanged();
    AppMethodBeat.o(127972);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127976);
    ae.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 32)
    {
      AppMethodBeat.o(127976);
      return;
    }
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = "error";
      }
      bS(getString(2131755906), paramn);
      AppMethodBeat.o(127976);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jmH.a(null, null);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI
 * JD-Core Version:    0.7.0.1
 */