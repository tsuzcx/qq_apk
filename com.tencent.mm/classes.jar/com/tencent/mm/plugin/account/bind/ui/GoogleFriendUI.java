package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
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
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.plugin.account.friend.a.ai;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleFriendUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, e.a, com.tencent.mm.ak.g, a.a
{
  private String iFB;
  private ProgressDialog iFC;
  private int iFE;
  private TextView iFJ;
  private String iFW;
  private boolean iFz;
  private ListView iIr;
  private a iIs;
  private String iIt;
  private ai iIu;
  private ArrayList<com.tencent.mm.plugin.account.friend.a.n> iIv;
  private HashMap<String, com.tencent.mm.plugin.account.friend.a.n> iIw;
  private boolean mCanceled;
  private String mToken;
  
  public GoogleFriendUI()
  {
    AppMethodBeat.i(110094);
    this.iFz = false;
    this.mCanceled = false;
    this.iIv = new ArrayList();
    this.iIw = new HashMap();
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
    Object localObject = getResources().getString(2131760028);
    getResources().getString(2131755691);
    h.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new h.d()
    {
      public final void ct(int paramAnonymousInt1, int paramAnonymousInt2)
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
    ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramn1.field_googleitemid });
    com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject, 0);
    if (paramn2 == null)
    {
      ((ah)localObject).iLo = paramn1.field_googleitemid;
      paramn1.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(paramn1);
    }
    for (;;)
    {
      this.iIs.Xb();
      AppMethodBeat.o(110110);
      return;
      ((ah)localObject).iLo = paramn2.field_googleitemid;
      paramn2.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(paramn2);
    }
  }
  
  private void a(bpv parambpv)
  {
    try
    {
      AppMethodBeat.i(110113);
      ac.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(parambpv.ncL) });
      if (this.iIs != null) {
        this.iIs.Xb();
      }
      AppMethodBeat.o(110113);
      return;
    }
    finally {}
  }
  
  private void aOL()
  {
    AppMethodBeat.i(110115);
    if ((this.iFC == null) || (!this.iFC.isShowing()))
    {
      getString(2131755906);
      this.iFC = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110078);
          GoogleFriendUI.c(GoogleFriendUI.this);
          com.tencent.mm.kernel.g.agi().a(GoogleFriendUI.d(GoogleFriendUI.this));
          AppMethodBeat.o(110078);
        }
      });
    }
    AppMethodBeat.o(110115);
  }
  
  private void aOM()
  {
    AppMethodBeat.i(110116);
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
    AppMethodBeat.o(110116);
  }
  
  private void aOV()
  {
    AppMethodBeat.i(110102);
    ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
    aOW();
    if ((TextUtils.isEmpty(this.mToken)) || ((!this.iFz) && (TextUtils.isEmpty(this.iFW))))
    {
      startActivity(BindGoogleContactUI.class);
      finish();
      AppMethodBeat.o(110102);
      return;
    }
    aOX();
    AppMethodBeat.o(110102);
  }
  
  private void aOW()
  {
    AppMethodBeat.i(110107);
    if (this.iFz)
    {
      this.mToken = ((String)com.tencent.mm.kernel.g.agR().agA().get(208901, null));
      AppMethodBeat.o(110107);
      return;
    }
    this.mToken = ((String)com.tencent.mm.kernel.g.agR().agA().get(208902, null));
    this.iFW = ((String)com.tencent.mm.kernel.g.agR().agA().get(208904, null));
    AppMethodBeat.o(110107);
  }
  
  private void aOX()
  {
    AppMethodBeat.i(110108);
    if (this.iFz)
    {
      aOZ();
      AppMethodBeat.o(110108);
      return;
    }
    aOY();
    AppMethodBeat.o(110108);
  }
  
  private void aOY()
  {
    AppMethodBeat.i(110111);
    aOL();
    new c(this.iFW).execute(new Void[0]);
    AppMethodBeat.o(110111);
  }
  
  private void aOZ()
  {
    AppMethodBeat.i(110112);
    this.mCanceled = false;
    aOL();
    new b(this, this.mToken, (byte)0).execute(new Void[0]);
    AppMethodBeat.o(110112);
  }
  
  private void fl(boolean paramBoolean)
  {
    AppMethodBeat.i(110114);
    this.iFJ.setVisibility(0);
    String str;
    if (!ax.isConnected(this)) {
      str = getString(2131760027);
    }
    for (;;)
    {
      this.iFJ.setText(str);
      AppMethodBeat.o(110114);
      return;
      if (paramBoolean) {
        str = getString(2131760020);
      } else {
        str = getString(2131760019);
      }
    }
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(110105);
    if (this.iIs != null) {
      this.iIs.notifyDataSetChanged();
    }
    AppMethodBeat.o(110105);
  }
  
  public int getLayoutId()
  {
    return 2131494407;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110099);
    setMMTitle(2131760021);
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
    this.iFJ = ((TextView)findViewById(2131299457));
    this.iIr = ((ListView)findViewById(2131300574));
    this.iIr.setAdapter(this.iIs);
    this.iIr.setOnItemClickListener(this);
    r localr = new r((byte)0);
    localr.ITM = new r.b()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(110075);
        GoogleFriendUI.a(GoogleFriendUI.this, bs.aLh(paramAnonymousString));
        if (GoogleFriendUI.a(GoogleFriendUI.this) != null) {
          GoogleFriendUI.a(GoogleFriendUI.this).FZ(GoogleFriendUI.b(GoogleFriendUI.this));
        }
        AppMethodBeat.o(110075);
      }
      
      public final void aPa() {}
      
      public final void aPb() {}
      
      public final void aPc() {}
      
      public final void aPd() {}
    };
    addSearchMenu(true, localr);
    AppMethodBeat.o(110099);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(110101);
    ac.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2005)
    {
      if (paramInt2 == -1)
      {
        this.iFz = paramIntent.getBooleanExtra("gpservices", false);
        aOV();
        AppMethodBeat.o(110101);
        return;
      }
      this.iFz = paramIntent.getBooleanExtra("gpservices", false);
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
    this.iFB = ((String)com.tencent.mm.kernel.g.agR().agA().get(208903, null));
    if (TextUtils.isEmpty(this.iFB)) {
      finish();
    }
    this.iFE = getIntent().getIntExtra("enter_scene", 0);
    this.iIs = new a(this, this.iFB);
    this.iIs.iIj = this;
    initView();
    this.iFz = m.dg(this);
    if (this.iFz)
    {
      ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
      AppMethodBeat.o(110095);
      return;
      aOV();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110098);
    super.onDestroy();
    ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
    AppMethodBeat.o(110098);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(110100);
    ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", new Object[] { Integer.valueOf(paramInt) });
    if (this.iIs != null)
    {
      int i = this.iIr.getHeaderViewsCount();
      paramAdapterView = (com.tencent.mm.plugin.account.friend.a.n)this.iIs.getItem(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = paramAdapterView.field_username;
        ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", new Object[] { paramAdapterView.field_googlegmail, paramView });
        Object localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramView);
        if (((localObject != null) && (b.ln(((av)localObject).field_type))) || (!TextUtils.isEmpty(paramAdapterView.field_nickname)))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("Contact_User", paramView);
          ((Intent)localObject).putExtra("Contact_Nick", paramAdapterView.field_nickname);
          ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
          ((Intent)localObject).putExtra("verify_gmail", paramAdapterView.field_googlegmail);
          ((Intent)localObject).putExtra("profileName", paramAdapterView.field_googlename);
          ((Intent)localObject).putExtra("Contact_Source_FMessage", 58);
          ((Intent)localObject).putExtra("Contact_Scene", 58);
          if ((paramView != null) && (paramView.length() > 0)) {
            com.tencent.mm.plugin.account.a.a.iyx.c((Intent)localObject, getContext());
          }
          AppMethodBeat.o(110100);
          return;
        }
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
        paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.aeD(), "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramAdapterView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(110100);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110096);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(488, this);
    com.tencent.mm.kernel.g.agi().a(489, this);
    p.aBh().d(this);
    if (this.iIs != null) {
      this.iIs.Xb();
    }
    AppMethodBeat.o(110096);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(110104);
    String str;
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      ac.i("MicroMsg.GoogleContact.GoogleFriendUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      i = paramn.getType();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label305;
      }
      switch (i)
      {
      default: 
        ac.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
      }
    }
    for (;;)
    {
      aOM();
      AppMethodBeat.o(110104);
      return;
      str = paramString;
      break;
      if (this.iIs != null)
      {
        paramString = (ah)paramn;
        ac.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.aPS().ncL) });
        paramString = paramString.iLo;
        ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
        ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ay(paramString, 1);
        this.iIs.Xb();
        continue;
        if (this.iIs != null)
        {
          paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).iLo;
          ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
          ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ay(paramString, 1);
          this.iIs.Xb();
          continue;
          a(((ai)paramn).aPT());
          continue;
          switch (i)
          {
          default: 
            ac.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
            break;
          case 489: 
            if (this.iIs != null)
            {
              paramString = (ah)paramn;
              ac.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.aPS().ncL) });
              paramString = paramString.iLo;
              ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ay(paramString, 1);
              this.iIs.Xb();
            }
            break;
          case 30: 
          case 137: 
            if (paramInt2 == -87) {
              h.c(this, getString(2131757604), "", true);
            }
            while (this.iIs != null)
            {
              paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).iLo;
              ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ay(paramString, 2);
              this.iIs.Xb();
              break;
              if (((paramInt2 == -24) || (paramInt2 == -101)) && (!bs.isNullOrNil(paramString))) {
                Toast.makeText(this, paramString, 1).show();
              }
            }
          case 488: 
            label305:
            fl(false);
          }
        }
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(110097);
    super.onStop();
    com.tencent.mm.kernel.g.agi().b(488, this);
    com.tencent.mm.kernel.g.agi().b(489, this);
    p.aBh().e(this);
    AppMethodBeat.o(110097);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qK(int paramInt)
  {
    AppMethodBeat.i(110103);
    if (this.iIs == null)
    {
      AppMethodBeat.o(110103);
      return;
    }
    com.tencent.mm.plugin.account.friend.a.n localn = (com.tencent.mm.plugin.account.friend.a.n)this.iIs.getItem(paramInt);
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
          ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
          if ((paramAnonymousBoolean1) || (paramAnonymousBoolean2))
          {
            ac.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramAnonymousString2 });
            ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ay(paramAnonymousString2, 1);
          }
          for (;;)
          {
            GoogleFriendUI.a(GoogleFriendUI.this).Xb();
            AppMethodBeat.o(110076);
            return;
            ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ay(paramAnonymousString2, 2);
          }
        }
      });
      Object localObject2 = localn.field_googleitemid;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).DpP = false;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).DpO = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).iNE = ((String)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).DpP = false;
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(58));
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).b(localn.field_username, (LinkedList)localObject2, true);
      localn.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(localn);
      this.iIs.Xb();
      AppMethodBeat.o(110103);
      return;
      localObject1 = localn.field_googleid;
      localObject1 = ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).Gr((String)localObject1);
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
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(110081);
      iIA = new a("SUCCESS", 0);
      iIB = new a("NO_CONTACT", 1);
      iIC = new a("ACCESS_DEDY", 2);
      iID = new a("OTHER", 3);
      iIE = new a[] { iIA, iIB, iIC, iID };
      AppMethodBeat.o(110081);
    }
    
    private a() {}
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private GoogleFriendUI.a iIF = GoogleFriendUI.a.iID;
    private Context mContext;
    private String mToken;
    
    private b(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      this.mToken = paramString;
    }
    
    private void Gc(String paramString)
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
              if ((!TextUtils.isEmpty(paramString)) && (bs.aLm(paramString)) && (!paramString.equals(GoogleFriendUI.h(GoogleFriendUI.this))))
              {
                localObject3 = new com.tencent.mm.plugin.account.friend.a.n();
                ((com.tencent.mm.plugin.account.friend.a.n)localObject3).field_googleid = ((String)localObject1);
                ((com.tencent.mm.plugin.account.friend.a.n)localObject3).field_googleitemid = ((String)localObject1 + paramString);
                ((com.tencent.mm.plugin.account.friend.a.n)localObject3).field_googlename = ((String)localObject2);
                ((com.tencent.mm.plugin.account.friend.a.n)localObject3).field_googlephotourl = str1;
                ((com.tencent.mm.plugin.account.friend.a.n)localObject3).field_googlegmail = paramString;
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
    
    private Void aON()
    {
      AppMethodBeat.i(110083);
      ac.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
      int j = 0;
      int i = 1;
      for (;;)
      {
        int k;
        try
        {
          ac.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          String str = j("json", i, this.mToken);
          k = new JSONObject(str).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
          if (k <= 0) {
            break label203;
          }
          Gc(str);
        }
        catch (IOException localIOException)
        {
          this.iIF = GoogleFriendUI.a.iIC;
          ac.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + localIOException.getMessage());
          continue;
        }
        catch (JSONException localJSONException)
        {
          this.iIF = GoogleFriendUI.a.iID;
          ac.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + localJSONException.getMessage());
          continue;
          j = k;
        }
        if ((j == 0) || (GoogleFriendUI.g(GoogleFriendUI.this)))
        {
          this.iIF = GoogleFriendUI.a.iIA;
          AppMethodBeat.o(110083);
          return null;
          j = 0;
        }
        else
        {
          continue;
          label203:
          if (k - i > 100)
          {
            i += 100;
            j = 1;
          }
        }
      }
    }
    
    private static String j(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(110084);
      paramString1 = new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + paramString1 + "&max-results=100&start-index=" + paramInt + "&access_token=" + paramString2);
      ac.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new Object[] { paramString1.toString() });
      paramString1 = (HttpURLConnection)paramString1.openConnection();
      paramString1.setRequestMethod("GET");
      paramString1.setConnectTimeout(20000);
      paramInt = paramString1.getResponseCode();
      ac.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 200)
      {
        paramString1 = paramString1.getInputStream();
        paramString2 = x(paramString1);
        paramString1.close();
        AppMethodBeat.o(110084);
        return paramString2;
      }
      if (paramInt == 401) {
        ac.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
      }
      try
      {
        for (;;)
        {
          paramString1.getInputStream().close();
          paramString1.disconnect();
          AppMethodBeat.o(110084);
          return null;
          ac.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          ac.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", paramString2.getMessage());
        }
      }
    }
    
    private static String x(InputStream paramInputStream)
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
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(110082);
      super.onPreExecute();
      ac.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
      GoogleFriendUI.e(GoogleFriendUI.this).clear();
      GoogleFriendUI.f(GoogleFriendUI.this).clear();
      AppMethodBeat.o(110082);
    }
  }
  
  final class c
    extends AsyncTask<Void, Void, Void>
  {
    private String iFS;
    private boolean iFU;
    private String iFW;
    
    public c(String paramString)
    {
      this.iFW = paramString;
    }
    
    private Void aON()
    {
      AppMethodBeat.i(110090);
      ac.i("MicroMsg.GoogleContact.GoogleFriendUI", "doInBackground");
      try
      {
        String str = aPe();
        ac.i("MicroMsg.GoogleContact.GoogleFriendUI", "refresh response:%s", new Object[] { str });
        this.iFS = new JSONObject(str).optString("access_token");
        this.iFU = true;
        AppMethodBeat.o(110090);
        return null;
      }
      catch (ProtocolException localProtocolException)
      {
        for (;;)
        {
          ac.e("MicroMsg.GoogleContact.GoogleFriendUI", "ProtocolException:%s", new Object[] { localProtocolException.getMessage() });
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          ac.e("MicroMsg.GoogleContact.GoogleFriendUI", "MalformedURLException:%s", new Object[] { localMalformedURLException.getMessage() });
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.e("MicroMsg.GoogleContact.GoogleFriendUI", "IOException:%s", new Object[] { localIOException.getMessage() });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ac.e("MicroMsg.GoogleContact.GoogleFriendUI", "JSONException:%s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    
    private String aPe()
    {
      AppMethodBeat.i(110091);
      Object localObject1 = "";
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://accounts.google.com/o/oauth2/token").openConnection();
      localHttpURLConnection.setRequestProperty("Charset", "UTF-8");
      localHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setConnectTimeout(20000);
      localHttpURLConnection.setReadTimeout(20000);
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.setDoOutput(true);
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(new BasicNameValuePair("refresh_token", this.iFW));
      ((List)localObject2).add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
      ((List)localObject2).add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
      ((List)localObject2).add(new BasicNameValuePair("grant_type", "refresh_token"));
      localObject2 = m.aO((List)localObject2);
      ac.i("MicroMsg.GoogleContact.GoogleFriendUI", "QueryString:%s".concat(String.valueOf(localObject2)));
      Object localObject3 = new BufferedWriter(new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8"));
      ((BufferedWriter)localObject3).write((String)localObject2);
      ((BufferedWriter)localObject3).flush();
      ((BufferedWriter)localObject3).close();
      int i = localHttpURLConnection.getResponseCode();
      ac.e("MicroMsg.GoogleContact.GoogleFriendUI", "responseCode:".concat(String.valueOf(i)));
      if (200 == i)
      {
        localObject1 = new StringBuffer();
        localObject2 = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream(), "UTF-8"));
        for (;;)
        {
          localObject3 = ((BufferedReader)localObject2).readLine();
          if (localObject3 == null) {
            break;
          }
          ((StringBuffer)localObject1).append((String)localObject3);
        }
        ((BufferedReader)localObject2).close();
        localObject1 = ((StringBuffer)localObject1).toString();
        ac.i("MicroMsg.GoogleContact.GoogleFriendUI", "exchange token respone:%s".concat(String.valueOf(localObject1)));
      }
      try
      {
        localHttpURLConnection.getInputStream().close();
        localHttpURLConnection.disconnect();
        AppMethodBeat.o(110091);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.GoogleContact.GoogleFriendUI", localException.getMessage());
        }
      }
    }
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(110089);
      super.onPreExecute();
      ac.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPreExecute");
      this.iFU = false;
      AppMethodBeat.o(110089);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI
 * JD-Core Version:    0.7.0.1
 */