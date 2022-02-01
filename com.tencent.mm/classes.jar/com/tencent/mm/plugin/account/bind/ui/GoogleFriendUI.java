package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.a;
import com.tencent.mm.an.i;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.plugin.account.friend.a.ai;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.tools.t.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GoogleFriendUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, f.a, i, a.a
{
  private boolean mCanceled;
  private boolean mQX;
  private String mQZ;
  private ProgressDialog mRa;
  private int mRc;
  private TextView mRh;
  private String mRu;
  private ListView mTV;
  private a mTW;
  private String mTX;
  private ai mTY;
  private ArrayList<com.tencent.mm.plugin.account.friend.a.n> mTZ;
  private String mToken;
  private HashMap<String, com.tencent.mm.plugin.account.friend.a.n> mUa;
  
  public GoogleFriendUI()
  {
    AppMethodBeat.i(110094);
    this.mQX = false;
    this.mCanceled = false;
    this.mTZ = new ArrayList();
    this.mUa = new HashMap();
    AppMethodBeat.o(110094);
  }
  
  private void a(Cursor paramCursor, final com.tencent.mm.plugin.account.friend.a.n paramn)
  {
    AppMethodBeat.i(110109);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    final ArrayList localArrayList3 = new ArrayList();
    if (paramCursor != null)
    {
      paramCursor.moveToFirst();
      int j = paramCursor.getCount();
      int i = 0;
      while (i < j)
      {
        localObject = new com.tencent.mm.plugin.account.friend.a.n();
        ((com.tencent.mm.plugin.account.friend.a.n)localObject).convertFrom(paramCursor);
        localArrayList1.add(((com.tencent.mm.plugin.account.friend.a.n)localObject).field_googlegmail);
        localArrayList2.add(Integer.valueOf(i));
        localArrayList3.add(localObject);
        paramCursor.moveToNext();
        i += 1;
      }
      localArrayList2.add(Integer.valueOf(-1));
    }
    paramCursor = getContext();
    Object localObject = getResources().getString(a.i.gcontact_select_email);
    getResources().getString(a.i.app_cancel);
    com.tencent.mm.ui.base.h.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new h.e()
    {
      public final void cS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110077);
        if (paramAnonymousInt2 != -1) {
          GoogleFriendUI.a(GoogleFriendUI.this, (com.tencent.mm.plugin.account.friend.a.n)localArrayList3.get(paramAnonymousInt2), paramn);
        }
        AppMethodBeat.o(110077);
      }
    });
    AppMethodBeat.o(110109);
  }
  
  private void a(com.tencent.mm.plugin.account.friend.a.n paramn1, com.tencent.mm.plugin.account.friend.a.n paramn2)
  {
    AppMethodBeat.i(110110);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramn1.field_googlegmail);
    localObject = new ah((ArrayList)localObject);
    Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramn1.field_googleitemid });
    com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject, 0);
    if (paramn2 == null)
    {
      ((ah)localObject).mWT = paramn1.field_googleitemid;
      paramn1.field_googlecgistatus = 0;
      ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).b(paramn1);
    }
    for (;;)
    {
      this.mTW.atr();
      AppMethodBeat.o(110110);
      return;
      ((ah)localObject).mWT = paramn2.field_googleitemid;
      paramn2.field_googlecgistatus = 0;
      ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).b(paramn2);
    }
  }
  
  private void a(crf paramcrf)
  {
    try
    {
      AppMethodBeat.i(110113);
      Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(paramcrf.rVx) });
      if (this.mTW != null) {
        this.mTW.atr();
      }
      AppMethodBeat.o(110113);
      return;
    }
    finally {}
  }
  
  private void bxC()
  {
    AppMethodBeat.i(110102);
    Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
    bxD();
    if ((TextUtils.isEmpty(this.mToken)) || ((!this.mQX) && (TextUtils.isEmpty(this.mRu))))
    {
      startActivity(BindGoogleContactUI.class);
      finish();
      AppMethodBeat.o(110102);
      return;
    }
    bxE();
    AppMethodBeat.o(110102);
  }
  
  private void bxD()
  {
    AppMethodBeat.i(110107);
    if (this.mQX)
    {
      this.mToken = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(208901, null));
      AppMethodBeat.o(110107);
      return;
    }
    this.mToken = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(208902, null));
    this.mRu = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(208904, null));
    AppMethodBeat.o(110107);
  }
  
  private void bxE()
  {
    AppMethodBeat.i(110108);
    if (this.mQX)
    {
      bxG();
      AppMethodBeat.o(110108);
      return;
    }
    bxF();
    AppMethodBeat.o(110108);
  }
  
  private void bxF()
  {
    AppMethodBeat.i(110111);
    bxs();
    new GoogleFriendUI.c(this, this.mRu).execute(new Void[0]);
    AppMethodBeat.o(110111);
  }
  
  private void bxG()
  {
    AppMethodBeat.i(110112);
    this.mCanceled = false;
    bxs();
    new GoogleFriendUI.b(this, this, this.mToken, (byte)0).execute(new Void[0]);
    AppMethodBeat.o(110112);
  }
  
  private void bxs()
  {
    AppMethodBeat.i(110115);
    if ((this.mRa == null) || (!this.mRa.isShowing()))
    {
      getString(a.i.app_tip);
      this.mRa = com.tencent.mm.ui.base.h.a(this, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110078);
          GoogleFriendUI.c(GoogleFriendUI.this);
          com.tencent.mm.kernel.h.aGY().a(GoogleFriendUI.d(GoogleFriendUI.this));
          AppMethodBeat.o(110078);
        }
      });
    }
    AppMethodBeat.o(110115);
  }
  
  private void bxt()
  {
    AppMethodBeat.i(110116);
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
    }
    AppMethodBeat.o(110116);
  }
  
  private void gV(boolean paramBoolean)
  {
    AppMethodBeat.i(110114);
    this.mRh.setVisibility(0);
    String str;
    if (!NetStatusUtil.isConnected(this)) {
      str = getString(a.i.gcontact_network_error_msg);
    }
    for (;;)
    {
      this.mRh.setText(str);
      AppMethodBeat.o(110114);
      return;
      if (paramBoolean) {
        str = getString(a.i.gcontact_empty);
      } else {
        str = getString(a.i.gcontact_default_error_msg);
      }
    }
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(110105);
    if (this.mTW != null) {
      this.mTW.notifyDataSetChanged();
    }
    AppMethodBeat.o(110105);
  }
  
  public int getLayoutId()
  {
    return a.f.gcontact_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110099);
    setMMTitle(a.i.gcontact_friend_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(110074);
        GoogleFriendUI.this.finish();
        AppMethodBeat.o(110074);
        return true;
      }
    });
    this.mRh = ((TextView)findViewById(a.e.empty));
    this.mTV = ((ListView)findViewById(a.e.gcontact_friend_lv));
    this.mTV.setAdapter(this.mTW);
    this.mTV.setOnItemClickListener(this);
    com.tencent.mm.ui.tools.t localt = new com.tencent.mm.ui.tools.t((byte)0);
    localt.XUl = new t.b()
    {
      public final boolean aat(String paramAnonymousString)
      {
        return false;
      }
      
      public final void aau(String paramAnonymousString)
      {
        AppMethodBeat.i(110075);
        GoogleFriendUI.a(GoogleFriendUI.this, Util.escapeSqlValue(paramAnonymousString));
        if (GoogleFriendUI.a(GoogleFriendUI.this) != null) {
          GoogleFriendUI.a(GoogleFriendUI.this).aas(GoogleFriendUI.b(GoogleFriendUI.this));
        }
        AppMethodBeat.o(110075);
      }
      
      public final void bxH() {}
      
      public final void bxI() {}
      
      public final void bxJ() {}
      
      public final void bxK() {}
    };
    addSearchMenu(true, localt);
    AppMethodBeat.o(110099);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(110101);
    Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2005)
    {
      if (paramInt2 == -1)
      {
        this.mQX = paramIntent.getBooleanExtra("gpservices", false);
        bxC();
        AppMethodBeat.o(110101);
        return;
      }
      this.mQX = paramIntent.getBooleanExtra("gpservices", false);
      finish();
    }
    AppMethodBeat.o(110101);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(110106);
    super.onBackPressed();
    AppMethodBeat.o(110106);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110095);
    super.onCreate(paramBundle);
    this.mQZ = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(208903, null));
    if (TextUtils.isEmpty(this.mQZ)) {
      finish();
    }
    this.mRc = getIntent().getIntExtra("enter_scene", 0);
    this.mTW = new a(this, this.mQZ);
    this.mTW.mTN = this;
    initView();
    this.mQX = com.tencent.mm.plugin.account.friend.a.m.dz(this);
    if (this.mQX)
    {
      Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
    }
    for (;;)
    {
      ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).clear();
      AppMethodBeat.o(110095);
      return;
      bxC();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110098);
    super.onDestroy();
    ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).clear();
    AppMethodBeat.o(110098);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(110100);
    Object localObject = new b();
    ((b)localObject).bn(paramAdapterView);
    ((b)localObject).bn(paramView);
    ((b)localObject).sg(paramInt);
    ((b)localObject).Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aFi());
    Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", new Object[] { Integer.valueOf(paramInt) });
    if (this.mTW != null)
    {
      int i = this.mTV.getHeaderViewsCount();
      paramAdapterView = (com.tencent.mm.plugin.account.friend.a.n)this.mTW.getItem(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = paramAdapterView.field_username;
        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", new Object[] { paramAdapterView.field_googlegmail, paramView });
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramView);
        if (((localObject == null) || (!d.rk(((ax)localObject).field_type))) && (TextUtils.isEmpty(paramAdapterView.field_nickname))) {
          break label327;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramView);
        ((Intent)localObject).putExtra("Contact_Nick", paramAdapterView.field_nickname);
        ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
        ((Intent)localObject).putExtra("verify_gmail", paramAdapterView.field_googlegmail);
        ((Intent)localObject).putExtra("profileName", paramAdapterView.field_googlename);
        ((Intent)localObject).putExtra("Contact_Source_FMessage", 58);
        ((Intent)localObject).putExtra("Contact_Scene", 58);
        if ((paramView != null) && (paramView.length() > 0)) {
          com.tencent.mm.plugin.account.sdk.a.mIG.c((Intent)localObject, getContext());
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(110100);
      return;
      label327:
      localObject = new Intent(this, InviteFriendUI.class);
      ((Intent)localObject).putExtra("friend_type", 2);
      ((Intent)localObject).putExtra("friend_user_name", paramView);
      ((Intent)localObject).putExtra("friend_num", paramAdapterView.field_googlegmail);
      ((Intent)localObject).putExtra("friend_nick", paramAdapterView.field_googlename);
      ((Intent)localObject).putExtra("friend_weixin_nick", paramAdapterView.field_nickname);
      ((Intent)localObject).putExtra("friend_googleID", paramAdapterView.field_googleid);
      ((Intent)localObject).putExtra("friend_googleItemID", paramAdapterView.field_googleitemid);
      ((Intent)localObject).putExtra("friend_scene", 58);
      ((Intent)localObject).putExtra("Contact_Scene", 58);
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramAdapterView.aFh(), "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110096);
    super.onResume();
    com.tencent.mm.kernel.h.aGY().a(488, this);
    com.tencent.mm.kernel.h.aGY().a(489, this);
    com.tencent.mm.am.q.bhz().d(this);
    if (this.mTW != null) {
      this.mTW.atr();
    }
    AppMethodBeat.o(110096);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(110104);
    String str;
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      i = paramq.getType();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label305;
      }
      switch (i)
      {
      default: 
        Log.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
      }
    }
    for (;;)
    {
      bxt();
      AppMethodBeat.o(110104);
      return;
      str = paramString;
      break;
      if (this.mTW != null)
      {
        paramString = (ah)paramq;
        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.byy().rVx) });
        paramString = paramString.mWT;
        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
        ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).aY(paramString, 1);
        this.mTW.atr();
        continue;
        if (this.mTW != null)
        {
          paramString = ((com.tencent.mm.pluginsdk.model.t)paramq).mWT;
          Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
          ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).aY(paramString, 1);
          this.mTW.atr();
          continue;
          a(((ai)paramq).byz());
          continue;
          switch (i)
          {
          default: 
            Log.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
            break;
          case 489: 
            if (this.mTW != null)
            {
              paramString = (ah)paramq;
              Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.byy().rVx) });
              paramString = paramString.mWT;
              Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).aY(paramString, 1);
              this.mTW.atr();
            }
            break;
          case 30: 
          case 137: 
            if (paramInt2 == -87) {
              com.tencent.mm.ui.base.h.c(this, getString(a.i.contact_info_biz_join_fans_limit), "", true);
            }
            while (this.mTW != null)
            {
              paramString = ((com.tencent.mm.pluginsdk.model.t)paramq).mWT;
              Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).aY(paramString, 2);
              this.mTW.atr();
              break;
              if (((paramInt2 == -24) || (paramInt2 == -101)) && (!Util.isNullOrNil(paramString))) {
                Toast.makeText(this, paramString, 1).show();
              }
            }
          case 488: 
            label305:
            gV(false);
          }
        }
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(110097);
    super.onStop();
    com.tencent.mm.kernel.h.aGY().b(488, this);
    com.tencent.mm.kernel.h.aGY().b(489, this);
    com.tencent.mm.am.q.bhz().e(this);
    AppMethodBeat.o(110097);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void yh(int paramInt)
  {
    AppMethodBeat.i(110103);
    if (this.mTW == null)
    {
      AppMethodBeat.o(110103);
      return;
    }
    com.tencent.mm.plugin.account.friend.a.n localn = (com.tencent.mm.plugin.account.friend.a.n)this.mTW.getItem(paramInt);
    if (localn == null)
    {
      AppMethodBeat.o(110103);
      return;
    }
    switch (localn.field_status)
    {
    }
    label258:
    for (;;)
    {
      AppMethodBeat.o(110103);
      return;
      Object localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this, new com.tencent.mm.pluginsdk.ui.applet.a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(110076);
          Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
          if ((paramAnonymousBoolean1) || (paramAnonymousBoolean2))
          {
            Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramAnonymousString2 });
            ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).aY(paramAnonymousString2, 1);
          }
          for (;;)
          {
            GoogleFriendUI.a(GoogleFriendUI.this).atr();
            AppMethodBeat.o(110076);
            return;
            ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).aY(paramAnonymousString2, 2);
          }
        }
      });
      Object localObject2 = localn.field_googleitemid;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).fgi = false;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).ReL = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).mZh = ((String)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).fgi = false;
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(58));
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).b(localn.field_username, (LinkedList)localObject2, true);
      localn.field_googlecgistatus = 0;
      ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).b(localn);
      this.mTW.atr();
      AppMethodBeat.o(110103);
      return;
      localObject1 = localn.field_googleid;
      localObject1 = ((o)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).aaJ((String)localObject1);
      if ((localObject1 == null) || (((Cursor)localObject1).getCount() <= 1)) {
        a(localn, null);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label258;
        }
        ((Cursor)localObject1).close();
        break;
        a((Cursor)localObject1, localn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI
 * JD-Core Version:    0.7.0.1
 */