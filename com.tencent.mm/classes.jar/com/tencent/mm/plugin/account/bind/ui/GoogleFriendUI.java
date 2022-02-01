package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.ae;
import com.tencent.mm.plugin.account.friend.model.af;
import com.tencent.mm.plugin.account.friend.model.j;
import com.tencent.mm.plugin.account.friend.model.l;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.ui.tools.s.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleFriendUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.am.h, AvatarStorage.a, a.a
{
  private boolean mCanceled;
  private String mToken;
  private boolean pNE;
  private String pNG;
  private ProgressDialog pNH;
  private int pNJ;
  private TextView pNO;
  private String pOb;
  private ListView pQD;
  private a pQE;
  private String pQF;
  private af pQG;
  private ArrayList<com.tencent.mm.plugin.account.friend.model.k> pQH;
  private HashMap<String, com.tencent.mm.plugin.account.friend.model.k> pQI;
  
  public GoogleFriendUI()
  {
    AppMethodBeat.i(110094);
    this.pNE = false;
    this.mCanceled = false;
    this.pQH = new ArrayList();
    this.pQI = new HashMap();
    AppMethodBeat.o(110094);
  }
  
  private void a(Cursor paramCursor, final com.tencent.mm.plugin.account.friend.model.k paramk)
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
        localObject = new com.tencent.mm.plugin.account.friend.model.k();
        ((com.tencent.mm.plugin.account.friend.model.k)localObject).convertFrom(paramCursor);
        localArrayList1.add(((com.tencent.mm.plugin.account.friend.model.k)localObject).field_googlegmail);
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
    com.tencent.mm.ui.base.k.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new k.e()
    {
      public final void onClick(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110077);
        if (paramAnonymousInt2 != -1) {
          GoogleFriendUI.a(GoogleFriendUI.this, (com.tencent.mm.plugin.account.friend.model.k)localArrayList3.get(paramAnonymousInt2), paramk);
        }
        AppMethodBeat.o(110077);
      }
    });
    AppMethodBeat.o(110109);
  }
  
  private void a(com.tencent.mm.plugin.account.friend.model.k paramk1, com.tencent.mm.plugin.account.friend.model.k paramk2)
  {
    AppMethodBeat.i(110110);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramk1.field_googlegmail);
    localObject = new ae((ArrayList)localObject);
    Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramk1.field_googleitemid });
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    if (paramk2 == null)
    {
      ((ae)localObject).pTA = paramk1.field_googleitemid;
      paramk1.field_googlecgistatus = 0;
      ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).b(paramk1);
    }
    for (;;)
    {
      this.pQE.aNy();
      AppMethodBeat.o(110110);
      return;
      ((ae)localObject).pTA = paramk2.field_googleitemid;
      paramk2.field_googlecgistatus = 0;
      ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).b(paramk2);
    }
  }
  
  private void a(dia paramdia)
  {
    try
    {
      AppMethodBeat.i(110113);
      Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(paramdia.vgN) });
      if (this.pQE != null) {
        this.pQE.aNy();
      }
      AppMethodBeat.o(110113);
      return;
    }
    finally {}
  }
  
  private void bWh()
  {
    AppMethodBeat.i(110116);
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    AppMethodBeat.o(110116);
  }
  
  private void bWr()
  {
    AppMethodBeat.i(110102);
    Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
    bWs();
    if ((TextUtils.isEmpty(this.mToken)) || ((!this.pNE) && (TextUtils.isEmpty(this.pOb))))
    {
      startActivity(BindGoogleContactUI.class);
      finish();
      AppMethodBeat.o(110102);
      return;
    }
    bWt();
    AppMethodBeat.o(110102);
  }
  
  private void bWs()
  {
    AppMethodBeat.i(110107);
    if (this.pNE)
    {
      this.mToken = ((String)com.tencent.mm.kernel.h.baE().ban().d(208901, null));
      AppMethodBeat.o(110107);
      return;
    }
    this.mToken = ((String)com.tencent.mm.kernel.h.baE().ban().d(208902, null));
    this.pOb = ((String)com.tencent.mm.kernel.h.baE().ban().d(208904, null));
    AppMethodBeat.o(110107);
  }
  
  private void bWt()
  {
    AppMethodBeat.i(110108);
    if (this.pNE)
    {
      bWv();
      AppMethodBeat.o(110108);
      return;
    }
    bWu();
    AppMethodBeat.o(110108);
  }
  
  private void bWu()
  {
    AppMethodBeat.i(110111);
    showLoadingDialog();
    new GoogleFriendUI.c(this, this.pOb).execute(new Void[0]);
    AppMethodBeat.o(110111);
  }
  
  private void bWv()
  {
    AppMethodBeat.i(110112);
    this.mCanceled = false;
    showLoadingDialog();
    new b(this, this.mToken, (byte)0).execute(new Void[0]);
    AppMethodBeat.o(110112);
  }
  
  private void hL(boolean paramBoolean)
  {
    AppMethodBeat.i(110114);
    this.pNO.setVisibility(0);
    String str;
    if (!NetStatusUtil.isConnected(this)) {
      str = getString(a.i.gcontact_network_error_msg);
    }
    for (;;)
    {
      this.pNO.setText(str);
      AppMethodBeat.o(110114);
      return;
      if (paramBoolean) {
        str = getString(a.i.gcontact_empty);
      } else {
        str = getString(a.i.gcontact_default_error_msg);
      }
    }
  }
  
  private void showLoadingDialog()
  {
    AppMethodBeat.i(110115);
    if ((this.pNH == null) || (!this.pNH.isShowing()))
    {
      getString(a.i.app_tip);
      this.pNH = com.tencent.mm.ui.base.k.a(this, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110078);
          GoogleFriendUI.c(GoogleFriendUI.this);
          com.tencent.mm.kernel.h.aZW().a(GoogleFriendUI.d(GoogleFriendUI.this));
          AppMethodBeat.o(110078);
        }
      });
    }
    AppMethodBeat.o(110115);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(110105);
    if (this.pQE != null) {
      this.pQE.notifyDataSetChanged();
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
    this.pNO = ((TextView)findViewById(a.e.empty));
    this.pQD = ((ListView)findViewById(a.e.gcontact_friend_lv));
    this.pQD.setAdapter(this.pQE);
    this.pQD.setOnItemClickListener(this);
    com.tencent.mm.ui.tools.s locals = new com.tencent.mm.ui.tools.s(true);
    locals.afKz = new s.c()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(110075);
        GoogleFriendUI.a(GoogleFriendUI.this, Util.escapeSqlValue(paramAnonymousString));
        if (GoogleFriendUI.a(GoogleFriendUI.this) != null) {
          GoogleFriendUI.a(GoogleFriendUI.this).SM(GoogleFriendUI.b(GoogleFriendUI.this));
        }
        AppMethodBeat.o(110075);
      }
      
      public final void bWw() {}
      
      public final void bWx() {}
      
      public final void bWy() {}
      
      public final void bWz() {}
    };
    addSearchMenu(true, locals);
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
        this.pNE = paramIntent.getBooleanExtra("gpservices", false);
        bWr();
        AppMethodBeat.o(110101);
        return;
      }
      this.pNE = paramIntent.getBooleanExtra("gpservices", false);
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
    this.pNG = ((String)com.tencent.mm.kernel.h.baE().ban().d(208903, null));
    if (TextUtils.isEmpty(this.pNG)) {
      finish();
    }
    this.pNJ = getIntent().getIntExtra("enter_scene", 0);
    this.pQE = new a(this, this.pNG);
    this.pQE.pQu = this;
    initView();
    this.pNE = j.eq(this);
    if (this.pNE)
    {
      Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
    }
    for (;;)
    {
      ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).clearAll();
      AppMethodBeat.o(110095);
      return;
      bWr();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110098);
    super.onDestroy();
    ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).clearAll();
    AppMethodBeat.o(110098);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(110100);
    Object localObject = new b();
    ((b)localObject).cH(paramAdapterView);
    ((b)localObject).cH(paramView);
    ((b)localObject).sc(paramInt);
    ((b)localObject).hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
    Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", new Object[] { Integer.valueOf(paramInt) });
    if (this.pQE != null)
    {
      int i = this.pQD.getHeaderViewsCount();
      paramAdapterView = (com.tencent.mm.plugin.account.friend.model.k)this.pQE.getItem(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = paramAdapterView.field_username;
        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", new Object[] { paramAdapterView.field_googlegmail, paramView });
        localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramView);
        if (((localObject == null) || (!d.rs(((az)localObject).field_type))) && (TextUtils.isEmpty(paramAdapterView.field_nickname))) {
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
          com.tencent.mm.plugin.account.sdk.a.pFn.c((Intent)localObject, getContext());
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
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramAdapterView.aYi(), "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110096);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(488, this);
    com.tencent.mm.kernel.h.aZW().a(489, this);
    q.bFp().d(this);
    if (this.pQE != null) {
      this.pQE.aNy();
    }
    AppMethodBeat.o(110096);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(110104);
    String str;
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      i = paramp.getType();
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
      bWh();
      AppMethodBeat.o(110104);
      return;
      str = paramString;
      break;
      if (this.pQE != null)
      {
        paramString = (ae)paramp;
        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.bXm().vgN) });
        paramString = paramString.pTA;
        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
        ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).bo(paramString, 1);
        this.pQE.aNy();
        continue;
        if (this.pQE != null)
        {
          paramString = ((v)paramp).pTA;
          Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
          ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).bo(paramString, 1);
          this.pQE.aNy();
          continue;
          a(((af)paramp).bXn());
          continue;
          switch (i)
          {
          default: 
            Log.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
            break;
          case 489: 
            if (this.pQE != null)
            {
              paramString = (ae)paramp;
              Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.bXm().vgN) });
              paramString = paramString.pTA;
              Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).bo(paramString, 1);
              this.pQE.aNy();
            }
            break;
          case 30: 
          case 137: 
            if (paramInt2 == -87) {
              com.tencent.mm.ui.base.k.c(this, getString(a.i.contact_info_biz_join_fans_limit), "", true);
            }
            while (this.pQE != null)
            {
              paramString = ((v)paramp).pTA;
              Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).bo(paramString, 2);
              this.pQE.aNy();
              break;
              if (((paramInt2 == -24) || (paramInt2 == -101)) && (!Util.isNullOrNil(paramString))) {
                Toast.makeText(this, paramString, 1).show();
              }
            }
          case 488: 
            label305:
            hL(false);
          }
        }
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(110097);
    super.onStop();
    com.tencent.mm.kernel.h.aZW().b(488, this);
    com.tencent.mm.kernel.h.aZW().b(489, this);
    q.bFp().e(this);
    AppMethodBeat.o(110097);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void yn(int paramInt)
  {
    AppMethodBeat.i(110103);
    if (this.pQE == null)
    {
      AppMethodBeat.o(110103);
      return;
    }
    com.tencent.mm.plugin.account.friend.model.k localk = (com.tencent.mm.plugin.account.friend.model.k)this.pQE.getItem(paramInt);
    if (localk == null)
    {
      AppMethodBeat.o(110103);
      return;
    }
    switch (localk.field_status)
    {
    }
    label258:
    for (;;)
    {
      AppMethodBeat.o(110103);
      return;
      Object localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this, new com.tencent.mm.pluginsdk.ui.applet.a.a()
      {
        public final void canAddContact(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(110076);
          Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
          if ((paramAnonymousBoolean1) || (paramAnonymousBoolean2))
          {
            Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramAnonymousString2 });
            ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).bo(paramAnonymousString2, 1);
          }
          for (;;)
          {
            GoogleFriendUI.a(GoogleFriendUI.this).aNy();
            AppMethodBeat.o(110076);
            return;
            ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).bo(paramAnonymousString2, 2);
          }
        }
      });
      Object localObject2 = localk.field_googleitemid;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).hks = false;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).YaQ = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).pVP = ((String)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).hks = false;
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(58));
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).b(localk.field_username, (LinkedList)localObject2, true);
      localk.field_googlecgistatus = 0;
      ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).b(localk);
      this.pQE.aNy();
      AppMethodBeat.o(110103);
      return;
      localObject1 = localk.field_googleid;
      localObject1 = ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).Tc((String)localObject1);
      if ((localObject1 == null) || (((Cursor)localObject1).getCount() <= 1)) {
        a(localk, null);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label258;
        }
        ((Cursor)localObject1).close();
        break;
        a((Cursor)localObject1, localk);
      }
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(110081);
      pQM = new a("SUCCESS", 0);
      pQN = new a("NO_CONTACT", 1);
      pQO = new a("ACCESS_DEDY", 2);
      pQP = new a("OTHER", 3);
      pQQ = new a[] { pQM, pQN, pQO, pQP };
      AppMethodBeat.o(110081);
    }
    
    private a() {}
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private Context mContext;
    private String mToken;
    private GoogleFriendUI.a pQR = GoogleFriendUI.a.pQP;
    
    private b(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      this.mToken = paramString;
    }
    
    private static String K(InputStream paramInputStream)
    {
      AppMethodBeat.i(110085);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[20480];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 20480);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramInputStream = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
      AppMethodBeat.o(110085);
      return paramInputStream;
    }
    
    private void SP(String paramString)
    {
      AppMethodBeat.i(110086);
      JSONArray localJSONArray1 = new JSONObject(paramString).getJSONObject("feed").getJSONArray("entry");
      int i;
      Object localObject2;
      JSONArray localJSONArray2;
      Object localObject3;
      int j;
      if (localJSONArray1 != null)
      {
        i = 0;
        if (i < localJSONArray1.length())
        {
          paramString = "";
          localObject1 = localJSONArray1.getJSONObject(i).optJSONObject("id");
          localObject2 = localJSONArray1.getJSONObject(i).optJSONObject("title");
          localJSONArray2 = localJSONArray1.getJSONObject(i).optJSONArray("gd$email");
          localObject3 = localJSONArray1.getJSONObject(i).optJSONArray("link");
          if (localObject1 == null) {
            break label440;
          }
          localObject1 = ((JSONObject)localObject1).getString("$t");
          j = ((String)localObject1).lastIndexOf("/");
          if (j <= 0) {
            break label440;
          }
        }
      }
      label440:
      for (Object localObject1 = ((String)localObject1).substring(j + 1);; localObject1 = "")
      {
        if (localObject2 != null) {}
        for (localObject2 = ((JSONObject)localObject2).getString("$t");; localObject2 = "")
        {
          String str1 = paramString;
          if (localObject3 != null)
          {
            j = 0;
            for (;;)
            {
              str1 = paramString;
              if (j >= ((JSONArray)localObject3).length()) {
                break;
              }
              String str2 = ((JSONArray)localObject3).getJSONObject(j).getString("rel");
              int k = str2.lastIndexOf("#");
              str1 = paramString;
              if (k > 0)
              {
                str2 = str2.substring(k + 1);
                str1 = paramString;
                if (!TextUtils.isEmpty(str2))
                {
                  str1 = paramString;
                  if ("photo".equals(str2)) {
                    str1 = ((JSONArray)localObject3).getJSONObject(j).getString("href");
                  }
                }
              }
              j += 1;
              paramString = str1;
            }
          }
          if (localJSONArray2 != null)
          {
            j = 0;
            while (j < localJSONArray2.length())
            {
              paramString = localJSONArray2.getJSONObject(j).getString("address");
              if ((!TextUtils.isEmpty(paramString)) && (Util.isValidEmail(paramString)) && (!paramString.equals(GoogleFriendUI.h(GoogleFriendUI.this))))
              {
                localObject3 = new com.tencent.mm.plugin.account.friend.model.k();
                ((com.tencent.mm.plugin.account.friend.model.k)localObject3).field_googleid = ((String)localObject1);
                ((com.tencent.mm.plugin.account.friend.model.k)localObject3).field_googleitemid = ((String)localObject1 + paramString);
                ((com.tencent.mm.plugin.account.friend.model.k)localObject3).field_googlename = ((String)localObject2);
                ((com.tencent.mm.plugin.account.friend.model.k)localObject3).field_googlephotourl = str1;
                ((com.tencent.mm.plugin.account.friend.model.k)localObject3).field_googlegmail = paramString;
                if (!GoogleFriendUI.f(GoogleFriendUI.this).containsKey(paramString))
                {
                  GoogleFriendUI.e(GoogleFriendUI.this).add(localObject3);
                  GoogleFriendUI.f(GoogleFriendUI.this).put(paramString, localObject3);
                }
              }
              j += 1;
            }
          }
          i += 1;
          break;
          AppMethodBeat.o(110086);
          return;
        }
      }
    }
    
    private Void bWi()
    {
      AppMethodBeat.i(110083);
      Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
      int j = 0;
      int i = 1;
      for (;;)
      {
        int k;
        try
        {
          Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          String str = m("json", i, this.mToken);
          k = new JSONObject(str).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
          if (k <= 0) {
            break label205;
          }
          SP(str);
        }
        catch (IOException localIOException)
        {
          this.pQR = GoogleFriendUI.a.pQO;
          Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + localIOException.getMessage());
          continue;
        }
        catch (JSONException localJSONException)
        {
          this.pQR = GoogleFriendUI.a.pQP;
          Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + localJSONException.getMessage());
          continue;
          j = k;
        }
        if ((j == 0) || (GoogleFriendUI.g(GoogleFriendUI.this)))
        {
          this.pQR = GoogleFriendUI.a.pQM;
          AppMethodBeat.o(110083);
          return null;
          j = 0;
        }
        else
        {
          continue;
          label205:
          if (k - i > 100)
          {
            i += 100;
            j = 1;
          }
        }
      }
    }
    
    private static String m(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(110084);
      paramString1 = new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + paramString1 + "&max-results=100&start-index=" + paramInt + "&access_token=" + paramString2);
      Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new Object[] { paramString1.toString() });
      paramString1 = (HttpURLConnection)paramString1.openConnection();
      paramString1.setRequestMethod("GET");
      paramString1.setConnectTimeout(20000);
      paramInt = paramString1.getResponseCode();
      Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 200)
      {
        paramString1 = paramString1.getInputStream();
        paramString2 = K(paramString1);
        paramString1.close();
        AppMethodBeat.o(110084);
        return paramString2;
      }
      if (paramInt == 401) {
        Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
      }
      try
      {
        for (;;)
        {
          paramString1.getInputStream().close();
          paramString1.disconnect();
          AppMethodBeat.o(110084);
          return null;
          Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", paramString2.getMessage());
        }
      }
    }
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(110082);
      super.onPreExecute();
      Log.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
      GoogleFriendUI.e(GoogleFriendUI.this).clear();
      GoogleFriendUI.f(GoogleFriendUI.this).clear();
      AppMethodBeat.o(110082);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI
 * JD-Core Version:    0.7.0.1
 */