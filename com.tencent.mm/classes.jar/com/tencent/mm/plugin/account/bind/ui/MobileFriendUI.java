package com.tencent.mm.plugin.account.bind.ui;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.aa;
import com.tencent.mm.plugin.account.friend.model.al;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.ui.x.a;
import java.util.List;

public class MobileFriendUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private TextView emptyTipTv = null;
  private ProgressDialog lzP = null;
  private ListView pRl;
  b pRm;
  private View pRn;
  private al pRo;
  String pRp;
  private TextView pRq = null;
  
  private void bWB()
  {
    AppMethodBeat.i(110161);
    if (com.tencent.mm.compatible.util.d.rb(26)) {
      Log.i("MicroMsg.MobileFriendUI", "onCreateAfterMPermissionGranted() checkContacts(android.Manifest.permission.WRITE_CONTACTS)[%b]", new Object[] { Boolean.TRUE });
    }
    getData();
    l.kK(13, 33);
    AppMethodBeat.o(110161);
  }
  
  private void getData()
  {
    AppMethodBeat.i(110163);
    if (!i.bWV())
    {
      Object localObject = getContext();
      getString(a.i.app_tip);
      this.lzP = k.a((Context)localObject, getString(a.i.mobile_friend_loading), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110153);
          if (MobileFriendUI.a(MobileFriendUI.this) != null) {
            com.tencent.mm.kernel.h.aZW().a(MobileFriendUI.a(MobileFriendUI.this));
          }
          AppMethodBeat.o(110153);
        }
      });
      if (i.bWY())
      {
        if ((!((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncAddrBook(new com.tencent.mm.plugin.account.sdk.a.b()
        {
          public final void hi(boolean paramAnonymousBoolean)
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
            i.bXa();
            al localal = new al(i.bXe(), i.bXd());
            com.tencent.mm.kernel.h.aZW().a(localal, 0);
            AppMethodBeat.o(110154);
          }
        })) && (this.lzP != null))
        {
          this.lzP.dismiss();
          this.lzP = null;
        }
        AppMethodBeat.o(110163);
        return;
      }
      localObject = i.bXe();
      List localList = i.bXd();
      if (((localObject != null) && (((List)localObject).size() != 0)) || ((localList != null) && (localList.size() != 0)))
      {
        this.pRo = new al(i.bXe(), i.bXd());
        com.tencent.mm.kernel.h.aZW().a(this.pRo, 0);
        AppMethodBeat.o(110163);
        return;
      }
      localObject = new aa();
      com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    }
    AppMethodBeat.o(110163);
  }
  
  public final void b(com.tencent.mm.plugin.account.friend.model.a parama)
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
    localIntent.putExtra("Contact_Alias", parama.pSk);
    localIntent.putExtra("Contact_Sex", parama.pSf);
    localIntent.putExtra("Contact_Signature", parama.pSi);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.bI(parama.pSo, parama.pSg, parama.pSh));
    localIntent.putExtra("Contact_Scene", 13);
    localIntent.putExtra("Contact_ShowUserName", false);
    com.tencent.mm.plugin.account.sdk.a.pFn.c(localIntent, this);
    AppMethodBeat.o(110168);
  }
  
  public int getLayoutId()
  {
    return a.f.mobile_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110167);
    this.emptyTipTv = ((TextView)findViewById(a.e.mobile_friend_empty_msg_tip_tv));
    this.emptyTipTv.setText(a.i.mobile_friend_empty_qmsg_tip);
    this.pRq = ((TextView)findViewById(a.e.empty_mobile_friend_search_tip_tv));
    this.pRq.setText(a.i.mobile_search_no_friend);
    this.pRn = findViewById(a.e.mobile_friend_mobile_not_bind_ll);
    this.pRl = ((ListView)findViewById(a.e.mobile_friend_lv));
    Object localObject = new com.tencent.mm.ui.tools.s(true);
    ((com.tencent.mm.ui.tools.s)localObject).afKz = new s.c()
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
        if (paramAnonymousString.pRm != null) {
          paramAnonymousString.pRm.SM(paramAnonymousString.pRp);
        }
        AppMethodBeat.o(110155);
      }
      
      public final void bWw() {}
      
      public final void bWx() {}
      
      public final void bWy() {}
      
      public final void bWz() {}
    };
    addSearchMenu(true, (com.tencent.mm.ui.tools.s)localObject);
    boolean bool;
    if (g.bDR().Km("2") != null)
    {
      localObject = g.bDR().Km("2").value;
      if (((String)localObject).equals("0"))
      {
        bool = false;
        f.Kq("2");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {}
      for (this.pRm = new c(this, new x.a()
          {
            public final void bWC()
            {
              AppMethodBeat.i(110156);
              MobileFriendUI localMobileFriendUI = MobileFriendUI.this;
              MobileFriendUI.d(MobileFriendUI.this).getCount();
              MobileFriendUI.e(localMobileFriendUI);
              AppMethodBeat.o(110156);
            }
          });; this.pRm = new d(this, new x.a()
          {
            public final void bWC()
            {
              AppMethodBeat.i(110157);
              MobileFriendUI localMobileFriendUI = MobileFriendUI.this;
              MobileFriendUI.d(MobileFriendUI.this).getCount();
              MobileFriendUI.e(localMobileFriendUI);
              AppMethodBeat.o(110157);
            }
          }))
      {
        this.pRl.setAdapter(this.pRm);
        this.pRl.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(110158);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousAdapterView);
            localb.cH(paramAnonymousView);
            localb.sc(paramAnonymousInt);
            localb.hB(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
            if (paramAnonymousInt < MobileFriendUI.f(MobileFriendUI.this).getHeaderViewsCount())
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(110158);
              return;
            }
            int i = MobileFriendUI.f(MobileFriendUI.this).getHeaderViewsCount();
            paramAnonymousView = (com.tencent.mm.plugin.account.friend.model.a)MobileFriendUI.d(MobileFriendUI.this).getItem(paramAnonymousInt - i);
            if ((paramAnonymousView.status == 1) || (paramAnonymousView.status == 2)) {
              MobileFriendUI.this.b(paramAnonymousView);
            }
            if (paramAnonymousView.status == 0)
            {
              paramAnonymousAdapterView = new Intent(MobileFriendUI.this, InviteFriendUI.class);
              paramAnonymousAdapterView.putExtra("friend_type", 1);
              paramAnonymousAdapterView.putExtra("friend_user_name", paramAnonymousView.getUsername());
              paramAnonymousAdapterView.putExtra("friend_num", paramAnonymousView.bWN());
              paramAnonymousAdapterView.putExtra("friend_nick", paramAnonymousView.bWI());
              paramAnonymousAdapterView.putExtra("friend_weixin_nick", paramAnonymousView.getNickName());
              paramAnonymousAdapterView.putExtra("friend_scene", 13);
              paramAnonymousView = MobileFriendUI.this;
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aYi(), "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(110158);
          }
        });
        this.pRm.a(new b.a()
        {
          public final void yo(int paramAnonymousInt)
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
        if ((i.bWW() != i.a.pSQ) && (i.bWW() != i.a.pSR))
        {
          this.pRn = findViewById(a.e.mobile_friend_mobile_not_bind_ll);
          this.pRn.setVisibility(0);
          this.pRn.setOnClickListener(new MobileFriendUI.2(this));
          this.pRl.setVisibility(8);
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
        setToTop(new MobileFriendUI.4(this));
        if ((!z.bBC()) || (i.bWV())) {
          k.a(this, a.i.bind_mcontact_bind_alert_content, a.i.app_tip, a.i.app_ok, a.i.app_cancel, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(110149);
              com.tencent.mm.plugin.report.service.h.OAn.b(11438, new Object[] { Integer.valueOf(6) });
              Log.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(6) });
              i.hN(true);
              ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncUploadMContactStatus(true, true);
              MobileFriendUI.h(MobileFriendUI.this);
              AppMethodBeat.o(110149);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(110150);
              i.hN(false);
              ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).syncUploadMContactStatus(false, true);
              MobileFriendUI.this.finish();
              AppMethodBeat.o(110150);
            }
          });
        }
        AppMethodBeat.o(110167);
        return;
        if (!((String)localObject).equals("1")) {
          break label408;
        }
        bool = true;
        break;
      }
      label408:
      bool = true;
      break;
      bool = true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110160);
    super.onCreate(paramBundle);
    setMMTitle(a.i.mobile_friend_title);
    ((com.tencent.mm.plugin.account.friend.model.b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).omV.execSQL("qqlist", "update addr_upload2 set reserved4=0");
    com.tencent.mm.kernel.h.aZW().a(32, this);
    com.tencent.mm.kernel.h.aZW().a(133, this);
    initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null);
    Log.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts(android.Manifest.permission.READ_CONTACTS)[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(110160);
      return;
    }
    bWB();
    AppMethodBeat.o(110160);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110166);
    f.Kr("2");
    com.tencent.mm.kernel.h.aZW().b(32, this);
    com.tencent.mm.kernel.h.aZW().b(133, this);
    this.pRm.fSd();
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
        bWB();
        AppMethodBeat.o(110162);
        return;
      }
      k.a(this, getString(a.i.permission_contacts_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110145);
          com.tencent.mm.pluginsdk.permission.b.lx(MobileFriendUI.this.getContext());
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
    this.pRm.notifyDataSetChanged();
    AppMethodBeat.o(110164);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(110169);
    Log.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramp.getType() == 32) && (this.lzP != null))
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Log.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
    }
    if (paramp.getType() == 133)
    {
      paramString = new aa();
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp.getType() == 32) {
        ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).updateAllContact();
      }
      this.pRm.onNotifyChange(null, null);
      AppMethodBeat.o(110169);
      return;
    }
    if (paramp.getType() == 32) {
      Toast.makeText(this, a.i.mobile_friend_err, 0).show();
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