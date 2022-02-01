package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
import java.util.List;

public class MobileFriendUI
  extends MMActivity
  implements i
{
  private TextView emptyTipTv = null;
  private ProgressDialog gtM = null;
  private ListView kde;
  b kdf;
  private View kdg;
  private ao kdh;
  String kdi;
  private TextView kdj = null;
  
  private void bnD()
  {
    AppMethodBeat.i(110161);
    if (com.tencent.mm.compatible.util.d.oD(26))
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.WRITE_CONTACTS", 48, null, null);
      Log.i("MicroMsg.MobileFriendUI", "onCreateAfterMPermissionGranted() checkContacts(android.Manifest.permission.WRITE_CONTACTS)[%b]", new Object[] { Boolean.valueOf(bool) });
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
    if (!l.bnY())
    {
      Object localObject = getContext();
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a((Context)localObject, getString(2131763077), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110153);
          if (MobileFriendUI.a(MobileFriendUI.this) != null) {
            com.tencent.mm.kernel.g.azz().a(MobileFriendUI.a(MobileFriendUI.this));
          }
          AppMethodBeat.o(110153);
        }
      });
      if (this.kdf.getCount() == 0)
      {
        if ((!((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBook(new com.tencent.mm.plugin.account.a.a.b()
        {
          public final void fG(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(110154);
            Log.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
            l.boe();
            ao localao = new ao(l.boi(), l.boh());
            com.tencent.mm.kernel.g.azz().a(localao, 0);
            AppMethodBeat.o(110154);
          }
        })) && (this.gtM != null))
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        AppMethodBeat.o(110163);
        return;
      }
      localObject = l.boi();
      List localList = l.boh();
      if ((((List)localObject).size() != 0) || (localList.size() != 0))
      {
        this.kdh = new ao(l.boi(), l.boh());
        com.tencent.mm.kernel.g.azz().a(this.kdh, 0);
        AppMethodBeat.o(110163);
        return;
      }
      localObject = new ad();
      com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
    }
    AppMethodBeat.o(110163);
  }
  
  public final void b(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    AppMethodBeat.i(110168);
    if (Util.isNullOrNil(parama.getUsername()))
    {
      Log.e("MicroMsg.MobileFriendUI", "username is null");
      AppMethodBeat.o(110168);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", parama.getUsername());
    localIntent.putExtra("Contact_Nick", parama.getNickName());
    localIntent.putExtra("Contact_Mobile_MD5", parama.getMd5());
    localIntent.putExtra("Contact_Alias", parama.ked);
    localIntent.putExtra("Contact_Sex", parama.kdY);
    localIntent.putExtra("Contact_Signature", parama.keb);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(parama.keh, parama.kdZ, parama.kea));
    localIntent.putExtra("Contact_Scene", 13);
    localIntent.putExtra("Contact_ShowUserName", false);
    com.tencent.mm.plugin.account.a.a.jRt.c(localIntent, this);
    AppMethodBeat.o(110168);
  }
  
  public int getLayoutId()
  {
    return 2131495661;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110167);
    this.emptyTipTv = ((TextView)findViewById(2131304747));
    this.emptyTipTv.setText(2131763075);
    this.kdj = ((TextView)findViewById(2131300095));
    this.kdj.setText(2131763122);
    this.kdg = findViewById(2131304750);
    this.kde = ((ListView)findViewById(2131304749));
    Object localObject = new s((byte)0);
    ((s)localObject).Qwi = new s.b()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(110155);
        MobileFriendUI.a(MobileFriendUI.this, Util.escapeSqlValue(paramAnonymousString));
        paramAnonymousString = MobileFriendUI.this;
        if (paramAnonymousString.kdf != null) {
          paramAnonymousString.kdf.SM(paramAnonymousString.kdi);
        }
        AppMethodBeat.o(110155);
      }
      
      public final void bnA() {}
      
      public final void bnB() {}
      
      public final void bny() {}
      
      public final void bnz() {}
    };
    addSearchMenu(true, (s)localObject);
    boolean bool;
    if (com.tencent.mm.model.a.g.aWT().KR("2") != null)
    {
      localObject = com.tencent.mm.model.a.g.aWT().KR("2").value;
      if (((String)localObject).equals("0"))
      {
        bool = false;
        f.KV("2");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {}
      for (this.kdf = new c(this, new s.a()
          {
            public final void bnE()
            {
              AppMethodBeat.i(110156);
              MobileFriendUI localMobileFriendUI = MobileFriendUI.this;
              MobileFriendUI.d(MobileFriendUI.this).getCount();
              MobileFriendUI.e(localMobileFriendUI);
              AppMethodBeat.o(110156);
            }
          });; this.kdf = new d(this, new s.a()
          {
            public final void bnE()
            {
              AppMethodBeat.i(110157);
              MobileFriendUI localMobileFriendUI = MobileFriendUI.this;
              MobileFriendUI.d(MobileFriendUI.this).getCount();
              MobileFriendUI.e(localMobileFriendUI);
              AppMethodBeat.o(110157);
            }
          }))
      {
        this.kde.setAdapter(this.kdf);
        this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(110158);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousAdapterView);
            localb.bm(paramAnonymousView);
            localb.pH(paramAnonymousInt);
            localb.zo(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
            if (paramAnonymousInt < MobileFriendUI.f(MobileFriendUI.this).getHeaderViewsCount())
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
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
              paramAnonymousAdapterView.putExtra("friend_num", paramAnonymousView.bnP());
              paramAnonymousAdapterView.putExtra("friend_nick", paramAnonymousView.bnK());
              paramAnonymousAdapterView.putExtra("friend_weixin_nick", paramAnonymousView.getNickName());
              paramAnonymousAdapterView.putExtra("friend_scene", 13);
              paramAnonymousView = MobileFriendUI.this;
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(110158);
          }
        });
        this.kdf.a(new b.a()
        {
          public final void ve(int paramAnonymousInt)
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
        if ((l.bnZ() != l.a.keL) && (l.bnZ() != l.a.keM))
        {
          this.kdg = findViewById(2131304750);
          this.kdg.setVisibility(0);
          this.kdg.setOnClickListener(new MobileFriendUI.2(this));
          this.kde.setVisibility(8);
        }
        setBackBtn(new MobileFriendUI.3(this));
        setToTop(new MobileFriendUI.4(this));
        if ((!z.aUI()) || (l.bnY())) {
          com.tencent.mm.ui.base.h.a(this, 2131756581, 2131755998, 2131755921, 2131755761, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(110149);
              com.tencent.mm.plugin.report.service.h.CyF.a(11438, new Object[] { Integer.valueOf(6) });
              Log.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(6) });
              l.gl(true);
              ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, true);
              MobileFriendUI.h(MobileFriendUI.this);
              AppMethodBeat.o(110149);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(110150);
              l.gl(false);
              ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(false, true);
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
    setMMTitle(2131763079);
    ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).iFy.execSQL("qqlist", "update addr_upload2 set reserved4=0");
    com.tencent.mm.kernel.g.azz().a(32, this);
    com.tencent.mm.kernel.g.azz().a(133, this);
    initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    Log.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts(android.Manifest.permission.READ_CONTACTS)[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(110160);
      return;
    }
    bnD();
    AppMethodBeat.o(110160);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110166);
    f.KW("2");
    com.tencent.mm.kernel.g.azz().b(32, this);
    com.tencent.mm.kernel.g.azz().b(133, this);
    this.kdf.ebf();
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
      Log.i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110162);
      return;
    }
    Log.i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110162);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bnD();
        AppMethodBeat.o(110162);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763866), getString(2131763890), getString(2131762043), getString(2131755761), false, new MobileFriendUI.1(this), new MobileFriendUI.8(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110164);
    super.onResume();
    this.kdf.notifyDataSetChanged();
    AppMethodBeat.o(110164);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(110169);
    Log.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramq.getType() == 32) && (this.gtM != null))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Log.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
    }
    if (paramq.getType() == 133)
    {
      paramString = new ad();
      com.tencent.mm.kernel.g.azz().a(paramString, 0);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 32) {
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).updateAllContact();
      }
      this.kdf.onNotifyChange(null, null);
      AppMethodBeat.o(110169);
      return;
    }
    if (paramq.getType() == 32) {
      Toast.makeText(this, 2131763076, 0).show();
    }
    AppMethodBeat.o(110169);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI
 * JD-Core Version:    0.7.0.1
 */