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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.plugin.account.friend.a.ai;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
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
  implements AdapterView.OnItemClickListener, e.a, i, a.a
{
  private boolean jZE;
  private String jZG;
  private ProgressDialog jZH;
  private int jZJ;
  private TextView jZO;
  private String kab;
  private ArrayList<n> kcA;
  private HashMap<String, n> kcB;
  private ListView kcw;
  private a kcx;
  private String kcy;
  private ai kcz;
  private boolean mCanceled;
  private String mToken;
  
  public GoogleFriendUI()
  {
    AppMethodBeat.i(110094);
    this.jZE = false;
    this.mCanceled = false;
    this.kcA = new ArrayList();
    this.kcB = new HashMap();
    AppMethodBeat.o(110094);
  }
  
  private void a(Cursor paramCursor, final n paramn)
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
        localObject = new n();
        ((n)localObject).convertFrom(paramCursor);
        localArrayList1.add(((n)localObject).field_googlegmail);
        localArrayList2.add(Integer.valueOf(i));
        localArrayList3.add(localObject);
        paramCursor.moveToNext();
        i += 1;
      }
      localArrayList2.add(Integer.valueOf(-1));
    }
    paramCursor = getContext();
    Object localObject = getResources().getString(2131761406);
    getResources().getString(2131755761);
    h.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new h.e()
    {
      public final void cy(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(110077);
        if (paramAnonymousInt2 != -1) {
          GoogleFriendUI.a(GoogleFriendUI.this, (n)localArrayList3.get(paramAnonymousInt2), paramn);
        }
        AppMethodBeat.o(110077);
      }
    });
    AppMethodBeat.o(110109);
  }
  
  private void a(n paramn1, n paramn2)
  {
    AppMethodBeat.i(110110);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramn1.field_googlegmail);
    localObject = new ah((ArrayList)localObject);
    Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramn1.field_googleitemid });
    g.azz().a((q)localObject, 0);
    if (paramn2 == null)
    {
      ((ah)localObject).kfu = paramn1.field_googleitemid;
      paramn1.field_googlecgistatus = 0;
      ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(paramn1);
    }
    for (;;)
    {
      this.kcx.anp();
      AppMethodBeat.o(110110);
      return;
      ((ah)localObject).kfu = paramn2.field_googleitemid;
      paramn2.field_googlecgistatus = 0;
      ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(paramn2);
    }
  }
  
  private void a(cij paramcij)
  {
    try
    {
      AppMethodBeat.i(110113);
      Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(paramcij.oTz) });
      if (this.kcx != null) {
        this.kcx.anp();
      }
      AppMethodBeat.o(110113);
      return;
    }
    finally {}
  }
  
  private void bnj()
  {
    AppMethodBeat.i(110115);
    if ((this.jZH == null) || (!this.jZH.isShowing()))
    {
      getString(2131755998);
      this.jZH = h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110078);
          GoogleFriendUI.c(GoogleFriendUI.this);
          g.azz().a(GoogleFriendUI.d(GoogleFriendUI.this));
          AppMethodBeat.o(110078);
        }
      });
    }
    AppMethodBeat.o(110115);
  }
  
  private void bnk()
  {
    AppMethodBeat.i(110116);
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
    AppMethodBeat.o(110116);
  }
  
  private void bnt()
  {
    AppMethodBeat.i(110102);
    Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
    bnu();
    if ((TextUtils.isEmpty(this.mToken)) || ((!this.jZE) && (TextUtils.isEmpty(this.kab))))
    {
      startActivity(BindGoogleContactUI.class);
      finish();
      AppMethodBeat.o(110102);
      return;
    }
    bnv();
    AppMethodBeat.o(110102);
  }
  
  private void bnu()
  {
    AppMethodBeat.i(110107);
    if (this.jZE)
    {
      this.mToken = ((String)g.aAh().azQ().get(208901, null));
      AppMethodBeat.o(110107);
      return;
    }
    this.mToken = ((String)g.aAh().azQ().get(208902, null));
    this.kab = ((String)g.aAh().azQ().get(208904, null));
    AppMethodBeat.o(110107);
  }
  
  private void bnv()
  {
    AppMethodBeat.i(110108);
    if (this.jZE)
    {
      bnx();
      AppMethodBeat.o(110108);
      return;
    }
    bnw();
    AppMethodBeat.o(110108);
  }
  
  private void bnw()
  {
    AppMethodBeat.i(110111);
    bnj();
    new c(this.kab).execute(new Void[0]);
    AppMethodBeat.o(110111);
  }
  
  private void bnx()
  {
    AppMethodBeat.i(110112);
    this.mCanceled = false;
    bnj();
    new b(this, this.mToken, (byte)0).execute(new Void[0]);
    AppMethodBeat.o(110112);
  }
  
  private void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(110114);
    this.jZO.setVisibility(0);
    String str;
    if (!NetStatusUtil.isConnected(this)) {
      str = getString(2131761405);
    }
    for (;;)
    {
      this.jZO.setText(str);
      AppMethodBeat.o(110114);
      return;
      if (paramBoolean) {
        str = getString(2131761398);
      } else {
        str = getString(2131761397);
      }
    }
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(110105);
    if (this.kcx != null) {
      this.kcx.notifyDataSetChanged();
    }
    AppMethodBeat.o(110105);
  }
  
  public int getLayoutId()
  {
    return 2131494979;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110099);
    setMMTitle(2131761399);
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
    this.jZO = ((TextView)findViewById(2131300076));
    this.kcw = ((ListView)findViewById(2131302109));
    this.kcw.setAdapter(this.kcx);
    this.kcw.setOnItemClickListener(this);
    s locals = new s((byte)0);
    locals.Qwi = new s.b()
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
      
      public final void bnA() {}
      
      public final void bnB() {}
      
      public final void bny() {}
      
      public final void bnz() {}
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
        this.jZE = paramIntent.getBooleanExtra("gpservices", false);
        bnt();
        AppMethodBeat.o(110101);
        return;
      }
      this.jZE = paramIntent.getBooleanExtra("gpservices", false);
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
    this.jZG = ((String)g.aAh().azQ().get(208903, null));
    if (TextUtils.isEmpty(this.jZG)) {
      finish();
    }
    this.jZJ = getIntent().getIntExtra("enter_scene", 0);
    this.kcx = new a(this, this.jZG);
    this.kcx.kco = this;
    initView();
    this.jZE = com.tencent.mm.plugin.account.friend.a.m.dB(this);
    if (this.jZE)
    {
      Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
    }
    for (;;)
    {
      ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
      AppMethodBeat.o(110095);
      return;
      bnt();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110098);
    super.onDestroy();
    ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
    AppMethodBeat.o(110098);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(110100);
    Object localObject = new b();
    ((b)localObject).bm(paramAdapterView);
    ((b)localObject).bm(paramView);
    ((b)localObject).pH(paramInt);
    ((b)localObject).zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
    Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", new Object[] { Integer.valueOf(paramInt) });
    if (this.kcx != null)
    {
      int i = this.kcw.getHeaderViewsCount();
      paramAdapterView = (n)this.kcx.getItem(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = paramAdapterView.field_username;
        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", new Object[] { paramAdapterView.field_googlegmail, paramView });
        localObject = ((l)g.af(l.class)).aSN().Kn(paramView);
        if (((localObject == null) || (!c.oR(((ax)localObject).field_type))) && (TextUtils.isEmpty(paramAdapterView.field_nickname))) {
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
          com.tencent.mm.plugin.account.a.a.jRt.c((Intent)localObject, getContext());
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
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.axQ(), "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110096);
    super.onResume();
    g.azz().a(488, this);
    g.azz().a(489, this);
    com.tencent.mm.aj.p.aYn().d(this);
    if (this.kcx != null) {
      this.kcx.anp();
    }
    AppMethodBeat.o(110096);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
      bnk();
      AppMethodBeat.o(110104);
      return;
      str = paramString;
      break;
      if (this.kcx != null)
      {
        paramString = (ah)paramq;
        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.bop().oTz) });
        paramString = paramString.kfu;
        Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
        ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(paramString, 1);
        this.kcx.anp();
        continue;
        if (this.kcx != null)
        {
          paramString = ((com.tencent.mm.pluginsdk.model.p)paramq).kfu;
          Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
          ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(paramString, 1);
          this.kcx.anp();
          continue;
          a(((ai)paramq).boq());
          continue;
          switch (i)
          {
          default: 
            Log.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
            break;
          case 489: 
            if (this.kcx != null)
            {
              paramString = (ah)paramq;
              Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.bop().oTz) });
              paramString = paramString.kfu;
              Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(paramString, 1);
              this.kcx.anp();
            }
            break;
          case 30: 
          case 137: 
            if (paramInt2 == -87) {
              h.c(this, getString(2131757832), "", true);
            }
            while (this.kcx != null)
            {
              paramString = ((com.tencent.mm.pluginsdk.model.p)paramq).kfu;
              Log.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(paramString, 2);
              this.kcx.anp();
              break;
              if (((paramInt2 == -24) || (paramInt2 == -101)) && (!Util.isNullOrNil(paramString))) {
                Toast.makeText(this, paramString, 1).show();
              }
            }
          case 488: 
            label305:
            gj(false);
          }
        }
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(110097);
    super.onStop();
    g.azz().b(488, this);
    g.azz().b(489, this);
    com.tencent.mm.aj.p.aYn().e(this);
    AppMethodBeat.o(110097);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vd(int paramInt)
  {
    AppMethodBeat.i(110103);
    if (this.kcx == null)
    {
      AppMethodBeat.o(110103);
      return;
    }
    n localn = (n)this.kcx.getItem(paramInt);
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
            ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(paramAnonymousString2, 1);
          }
          for (;;)
          {
            GoogleFriendUI.a(GoogleFriendUI.this).anp();
            AppMethodBeat.o(110076);
            return;
            ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aF(paramAnonymousString2, 2);
          }
        }
      });
      Object localObject2 = localn.field_googleitemid;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Kee = false;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Ked = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).khI = ((String)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Kee = false;
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(58));
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).b(localn.field_username, (LinkedList)localObject2, true);
      localn.field_googlecgistatus = 0;
      ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(localn);
      this.kcx.anp();
      AppMethodBeat.o(110103);
      return;
      localObject1 = localn.field_googleid;
      localObject1 = ((o)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).Td((String)localObject1);
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
      kcF = new a("SUCCESS", 0);
      kcG = new a("NO_CONTACT", 1);
      kcH = new a("ACCESS_DEDY", 2);
      kcI = new a("OTHER", 3);
      kcJ = new a[] { kcF, kcG, kcH, kcI };
      AppMethodBeat.o(110081);
    }
    
    private a() {}
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private GoogleFriendUI.a kcK = GoogleFriendUI.a.kcI;
    private Context mContext;
    private String mToken;
    
    private b(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      this.mToken = paramString;
    }
    
    private static String A(InputStream paramInputStream)
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
                localObject3 = new n();
                ((n)localObject3).field_googleid = ((String)localObject1);
                ((n)localObject3).field_googleitemid = ((String)localObject1 + paramString);
                ((n)localObject3).field_googlename = ((String)localObject2);
                ((n)localObject3).field_googlephotourl = str1;
                ((n)localObject3).field_googlegmail = paramString;
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
    
    private Void bnl()
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
          this.kcK = GoogleFriendUI.a.kcH;
          Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + localIOException.getMessage());
          continue;
        }
        catch (JSONException localJSONException)
        {
          this.kcK = GoogleFriendUI.a.kcI;
          Log.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + localJSONException.getMessage());
          continue;
          j = k;
        }
        if ((j == 0) || (GoogleFriendUI.g(GoogleFriendUI.this)))
        {
          this.kcK = GoogleFriendUI.a.kcF;
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
        paramString2 = A(paramString1);
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
  
  final class c
    extends AsyncTask<Void, Void, Void>
  {
    private String jZX;
    private boolean jZZ;
    private String kab;
    
    public c(String paramString)
    {
      this.kab = paramString;
    }
    
    private String bnC()
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
      ((List)localObject2).add(new BasicNameValuePair("refresh_token", this.kab));
      ((List)localObject2).add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
      ((List)localObject2).add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
      ((List)localObject2).add(new BasicNameValuePair("grant_type", "refresh_token"));
      localObject2 = com.tencent.mm.plugin.account.friend.a.m.aY((List)localObject2);
      Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "QueryString:%s".concat(String.valueOf(localObject2)));
      Object localObject3 = new BufferedWriter(new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8"));
      ((BufferedWriter)localObject3).write((String)localObject2);
      ((BufferedWriter)localObject3).flush();
      ((BufferedWriter)localObject3).close();
      int i = localHttpURLConnection.getResponseCode();
      Log.e("MicroMsg.GoogleContact.GoogleFriendUI", "responseCode:".concat(String.valueOf(i)));
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
        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "exchange token respone:%s".concat(String.valueOf(localObject1)));
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
          Log.e("MicroMsg.GoogleContact.GoogleFriendUI", localException.getMessage());
        }
      }
    }
    
    private Void bnl()
    {
      AppMethodBeat.i(110090);
      Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "doInBackground");
      try
      {
        String str = bnC();
        Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "refresh response:%s", new Object[] { str });
        this.jZX = new JSONObject(str).optString("access_token");
        this.jZZ = true;
        AppMethodBeat.o(110090);
        return null;
      }
      catch (ProtocolException localProtocolException)
      {
        for (;;)
        {
          Log.e("MicroMsg.GoogleContact.GoogleFriendUI", "ProtocolException:%s", new Object[] { localProtocolException.getMessage() });
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          Log.e("MicroMsg.GoogleContact.GoogleFriendUI", "MalformedURLException:%s", new Object[] { localMalformedURLException.getMessage() });
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.GoogleContact.GoogleFriendUI", "IOException:%s", new Object[] { localIOException.getMessage() });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e("MicroMsg.GoogleContact.GoogleFriendUI", "JSONException:%s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(110089);
      super.onPreExecute();
      Log.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPreExecute");
      this.jZZ = false;
      AppMethodBeat.o(110089);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI
 * JD-Core Version:    0.7.0.1
 */