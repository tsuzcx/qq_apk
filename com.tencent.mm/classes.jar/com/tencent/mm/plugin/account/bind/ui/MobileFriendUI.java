package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.List;

public class MobileFriendUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private TextView emptyTipTv = null;
  private ProgressDialog fts = null;
  private ListView iIZ;
  b iJa;
  private View iJb;
  private ao iJc;
  String iJd;
  private TextView iJe = null;
  
  private void aPf()
  {
    AppMethodBeat.i(110161);
    if (com.tencent.mm.compatible.util.d.kZ(26))
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.WRITE_CONTACTS", 48, null, null);
      ac.i("MicroMsg.MobileFriendUI", "onCreateAfterMPermissionGranted() checkContacts(android.Manifest.permission.WRITE_CONTACTS)[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(110161);
        return;
      }
    }
    getData();
    AppMethodBeat.o(110161);
  }
  
  private void getData()
  {
    AppMethodBeat.i(110163);
    if (!com.tencent.mm.plugin.account.friend.a.l.aPB())
    {
      Object localObject = getContext();
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131761251), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110153);
          if (MobileFriendUI.a(MobileFriendUI.this) != null) {
            com.tencent.mm.kernel.g.agi().a(MobileFriendUI.a(MobileFriendUI.this));
          }
          AppMethodBeat.o(110153);
        }
      });
      if (this.iJa.getCount() == 0)
      {
        if ((!((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBook(new com.tencent.mm.plugin.account.a.a.b()
        {
          public final void eM(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(110154);
            ac.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (!paramAnonymousBoolean)
            {
              if (MobileFriendUI.b(MobileFriendUI.this) != null)
              {
                MobileFriendUI.b(MobileFriendUI.this).dismiss();
                MobileFriendUI.c(MobileFriendUI.this);
              }
              AppMethodBeat.o(110154);
              return;
            }
            System.currentTimeMillis();
            com.tencent.mm.plugin.account.friend.a.l.aPH();
            ao localao = new ao(com.tencent.mm.plugin.account.friend.a.l.aPL(), com.tencent.mm.plugin.account.friend.a.l.aPK());
            com.tencent.mm.kernel.g.agi().a(localao, 0);
            AppMethodBeat.o(110154);
          }
        })) && (this.fts != null))
        {
          this.fts.dismiss();
          this.fts = null;
        }
        AppMethodBeat.o(110163);
        return;
      }
      localObject = com.tencent.mm.plugin.account.friend.a.l.aPL();
      List localList = com.tencent.mm.plugin.account.friend.a.l.aPK();
      if ((((List)localObject).size() != 0) || (localList.size() != 0))
      {
        this.iJc = new ao(com.tencent.mm.plugin.account.friend.a.l.aPL(), com.tencent.mm.plugin.account.friend.a.l.aPK());
        com.tencent.mm.kernel.g.agi().a(this.iJc, 0);
        AppMethodBeat.o(110163);
        return;
      }
      localObject = new ad();
      com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
    }
    AppMethodBeat.o(110163);
  }
  
  public final void b(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    AppMethodBeat.i(110168);
    if (bs.isNullOrNil(parama.getUsername()))
    {
      ac.e("MicroMsg.MobileFriendUI", "username is null");
      AppMethodBeat.o(110168);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", parama.getUsername());
    localIntent.putExtra("Contact_Nick", parama.getNickName());
    localIntent.putExtra("Contact_Mobile_MD5", parama.JC());
    localIntent.putExtra("Contact_Alias", parama.iJY);
    localIntent.putExtra("Contact_Sex", parama.iJT);
    localIntent.putExtra("Contact_Signature", parama.iJW);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aW(parama.iKc, parama.iJU, parama.iJV));
    localIntent.putExtra("Contact_Scene", 13);
    localIntent.putExtra("Contact_ShowUserName", false);
    com.tencent.mm.plugin.account.a.a.iyx.c(localIntent, this);
    AppMethodBeat.o(110168);
  }
  
  public int getLayoutId()
  {
    return 2131494921;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110167);
    this.emptyTipTv = ((TextView)findViewById(2131302350));
    this.emptyTipTv.setText(2131761249);
    this.iJe = ((TextView)findViewById(2131299467));
    this.iJe.setText(2131761296);
    this.iJb = findViewById(2131302353);
    this.iIZ = ((ListView)findViewById(2131302352));
    Object localObject = new r((byte)0);
    ((r)localObject).ITM = new r.b()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(110155);
        MobileFriendUI.a(MobileFriendUI.this, bs.aLh(paramAnonymousString));
        paramAnonymousString = MobileFriendUI.this;
        if (paramAnonymousString.iJa != null) {
          paramAnonymousString.iJa.FZ(paramAnonymousString.iJd);
        }
        AppMethodBeat.o(110155);
      }
      
      public final void aPa() {}
      
      public final void aPb() {}
      
      public final void aPc() {}
      
      public final void aPd() {}
    };
    addSearchMenu(true, (r)localObject);
    boolean bool;
    if (com.tencent.mm.model.a.g.azO().yF("2") != null)
    {
      localObject = com.tencent.mm.model.a.g.azO().yF("2").value;
      if (((String)localObject).equals("0"))
      {
        bool = false;
        f.yJ("2");
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {}
      for (this.iJa = new c(this, new r.a()
          {
            public final void aPg()
            {
              AppMethodBeat.i(110156);
              MobileFriendUI localMobileFriendUI = MobileFriendUI.this;
              MobileFriendUI.d(MobileFriendUI.this).getCount();
              MobileFriendUI.e(localMobileFriendUI);
              AppMethodBeat.o(110156);
            }
          });; this.iJa = new d(this, new r.a()
          {
            public final void aPg()
            {
              AppMethodBeat.i(110157);
              MobileFriendUI localMobileFriendUI = MobileFriendUI.this;
              MobileFriendUI.d(MobileFriendUI.this).getCount();
              MobileFriendUI.e(localMobileFriendUI);
              AppMethodBeat.o(110157);
            }
          }))
      {
        this.iIZ.setAdapter(this.iJa);
        this.iIZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(110158);
            if (paramAnonymousInt < MobileFriendUI.f(MobileFriendUI.this).getHeaderViewsCount())
            {
              AppMethodBeat.o(110158);
              return;
            }
            int i = MobileFriendUI.f(MobileFriendUI.this).getHeaderViewsCount();
            paramAnonymousView = (com.tencent.mm.plugin.account.friend.a.a)MobileFriendUI.d(MobileFriendUI.this).getItem(paramAnonymousInt - i);
            if ((paramAnonymousView.status == 1) || (paramAnonymousView.status == 2)) {
              MobileFriendUI.this.b(paramAnonymousView);
            }
            if (paramAnonymousView.status == 0)
            {
              paramAnonymousAdapterView = new Intent(MobileFriendUI.this, InviteFriendUI.class);
              paramAnonymousAdapterView.putExtra("friend_type", 1);
              paramAnonymousAdapterView.putExtra("friend_user_name", paramAnonymousView.getUsername());
              paramAnonymousAdapterView.putExtra("friend_num", paramAnonymousView.aPr());
              paramAnonymousAdapterView.putExtra("friend_nick", paramAnonymousView.aPm());
              paramAnonymousAdapterView.putExtra("friend_weixin_nick", paramAnonymousView.getNickName());
              paramAnonymousAdapterView.putExtra("friend_scene", 13);
              paramAnonymousView = MobileFriendUI.this;
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.aeD(), "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(110158);
          }
        });
        this.iJa.a(new b.a()
        {
          public final void qL(int paramAnonymousInt)
          {
            AppMethodBeat.i(110159);
            if (paramAnonymousInt > 0)
            {
              MobileFriendUI.g(MobileFriendUI.this).setVisibility(8);
              AppMethodBeat.o(110159);
              return;
            }
            MobileFriendUI.g(MobileFriendUI.this).setVisibility(0);
            AppMethodBeat.o(110159);
          }
        });
        if ((com.tencent.mm.plugin.account.friend.a.l.aPC() != l.a.iKF) && (com.tencent.mm.plugin.account.friend.a.l.aPC() != l.a.iKG))
        {
          this.iJb = findViewById(2131302353);
          this.iJb.setVisibility(0);
          this.iJb.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(110146);
              paramAnonymousView = new Intent(MobileFriendUI.this.getContext(), BindMContactIntroUI.class);
              paramAnonymousView.putExtra("key_upload_scene", 6);
              MMWizardActivity.aj(MobileFriendUI.this, paramAnonymousView);
              AppMethodBeat.o(110146);
            }
          });
          this.iIZ.setVisibility(8);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(110147);
            MobileFriendUI.this.hideVKB();
            MobileFriendUI.this.finish();
            AppMethodBeat.o(110147);
            return true;
          }
        });
        setToTop(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(110148);
            paramAnonymousView = MobileFriendUI.f(MobileFriendUI.this);
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
            Object localObject = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            AppMethodBeat.o(110148);
          }
        });
        if ((!u.ayb()) || (com.tencent.mm.plugin.account.friend.a.l.aPB())) {
          com.tencent.mm.ui.base.h.b(this, 2131756445, 2131755906, 2131755835, 2131755691, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(110149);
              com.tencent.mm.plugin.report.service.h.wUl.f(11438, new Object[] { Integer.valueOf(6) });
              ac.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(6) });
              com.tencent.mm.plugin.account.friend.a.l.fn(true);
              ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, true);
              MobileFriendUI.h(MobileFriendUI.this);
              AppMethodBeat.o(110149);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(110150);
              com.tencent.mm.plugin.account.friend.a.l.fn(false);
              ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(false, true);
              MobileFriendUI.this.finish();
              AppMethodBeat.o(110150);
            }
          });
        }
        AppMethodBeat.o(110167);
        return;
        if (!((String)localObject).equals("1")) {
          break label407;
        }
        bool = true;
        break;
      }
      label407:
      bool = true;
      break;
      bool = true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110160);
    super.onCreate(paramBundle);
    setMMTitle(2131761253);
    ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).hpA.execSQL("qqlist", "update addr_upload2 set reserved4=0");
    com.tencent.mm.kernel.g.agi().a(32, this);
    com.tencent.mm.kernel.g.agi().a(133, this);
    initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ac.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts(android.Manifest.permission.READ_CONTACTS)[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(110160);
      return;
    }
    aPf();
    AppMethodBeat.o(110160);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110166);
    f.yK("2");
    com.tencent.mm.kernel.g.agi().b(32, this);
    com.tencent.mm.kernel.g.agi().b(133, this);
    this.iJa.cVi();
    super.onDestroy();
    AppMethodBeat.o(110166);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(110165);
    super.onPause();
    AppMethodBeat.o(110165);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110162);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110162);
      return;
    }
    ac.i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110162);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aPf();
        AppMethodBeat.o(110162);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110145);
          paramAnonymousDialogInterface = MobileFriendUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          MobileFriendUI.this.finish();
          AppMethodBeat.o(110145);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110152);
          MobileFriendUI.this.finish();
          AppMethodBeat.o(110152);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110164);
    super.onResume();
    this.iJa.notifyDataSetChanged();
    AppMethodBeat.o(110164);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(110169);
    ac.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramn.getType() == 32) && (this.fts != null))
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      ac.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
    }
    if (paramn.getType() == 133)
    {
      paramString = new ad();
      com.tencent.mm.kernel.g.agi().a(paramString, 0);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 32) {
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).updateAllContact();
      }
      this.iJa.a(null, null);
      AppMethodBeat.o(110169);
      return;
    }
    if (paramn.getType() == 32) {
      Toast.makeText(this, 2131761250, 0).show();
    }
    AppMethodBeat.o(110169);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI
 * JD-Core Version:    0.7.0.1
 */