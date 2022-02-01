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
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
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
  implements AdapterView.OnItemClickListener, e.a, f, a.a
{
  private boolean iYI;
  private String iYK;
  private ProgressDialog iYL;
  private int iYN;
  private TextView iYS;
  private String iZf;
  private ListView jbA;
  private a jbB;
  private String jbC;
  private com.tencent.mm.plugin.account.friend.a.ai jbD;
  private ArrayList<com.tencent.mm.plugin.account.friend.a.n> jbE;
  private HashMap<String, com.tencent.mm.plugin.account.friend.a.n> jbF;
  private boolean mCanceled;
  private String mToken;
  
  public GoogleFriendUI()
  {
    AppMethodBeat.i(110094);
    this.iYI = false;
    this.mCanceled = false;
    this.jbE = new ArrayList();
    this.jbF = new HashMap();
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
      public final void cv(int paramAnonymousInt1, int paramAnonymousInt2)
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
    ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramn1.field_googleitemid });
    g.aiU().a((com.tencent.mm.al.n)localObject, 0);
    if (paramn2 == null)
    {
      ((ah)localObject).jex = paramn1.field_googleitemid;
      paramn1.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(paramn1);
    }
    for (;;)
    {
      this.jbB.Zu();
      AppMethodBeat.o(110110);
      return;
      ((ah)localObject).jex = paramn2.field_googleitemid;
      paramn2.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(paramn2);
    }
  }
  
  private void a(bui parambui)
  {
    try
    {
      AppMethodBeat.i(110113);
      ad.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(parambui.nDi) });
      if (this.jbB != null) {
        this.jbB.Zu();
      }
      AppMethodBeat.o(110113);
      return;
    }
    finally {}
  }
  
  private void aRX()
  {
    AppMethodBeat.i(110115);
    if ((this.iYL == null) || (!this.iYL.isShowing()))
    {
      getString(2131755906);
      this.iYL = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(110078);
          GoogleFriendUI.c(GoogleFriendUI.this);
          g.aiU().a(GoogleFriendUI.d(GoogleFriendUI.this));
          AppMethodBeat.o(110078);
        }
      });
    }
    AppMethodBeat.o(110115);
  }
  
  private void aRY()
  {
    AppMethodBeat.i(110116);
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
    }
    AppMethodBeat.o(110116);
  }
  
  private void aSh()
  {
    AppMethodBeat.i(110102);
    ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
    aSi();
    if ((TextUtils.isEmpty(this.mToken)) || ((!this.iYI) && (TextUtils.isEmpty(this.iZf))))
    {
      startActivity(BindGoogleContactUI.class);
      finish();
      AppMethodBeat.o(110102);
      return;
    }
    aSj();
    AppMethodBeat.o(110102);
  }
  
  private void aSi()
  {
    AppMethodBeat.i(110107);
    if (this.iYI)
    {
      this.mToken = ((String)g.ajC().ajl().get(208901, null));
      AppMethodBeat.o(110107);
      return;
    }
    this.mToken = ((String)g.ajC().ajl().get(208902, null));
    this.iZf = ((String)g.ajC().ajl().get(208904, null));
    AppMethodBeat.o(110107);
  }
  
  private void aSj()
  {
    AppMethodBeat.i(110108);
    if (this.iYI)
    {
      aSl();
      AppMethodBeat.o(110108);
      return;
    }
    aSk();
    AppMethodBeat.o(110108);
  }
  
  private void aSk()
  {
    AppMethodBeat.i(110111);
    aRX();
    new GoogleFriendUI.c(this, this.iZf).execute(new Void[0]);
    AppMethodBeat.o(110111);
  }
  
  private void aSl()
  {
    AppMethodBeat.i(110112);
    this.mCanceled = false;
    aRX();
    new b(this, this.mToken, (byte)0).execute(new Void[0]);
    AppMethodBeat.o(110112);
  }
  
  private void fp(boolean paramBoolean)
  {
    AppMethodBeat.i(110114);
    this.iYS.setVisibility(0);
    String str;
    if (!ay.isConnected(this)) {
      str = getString(2131760027);
    }
    for (;;)
    {
      this.iYS.setText(str);
      AppMethodBeat.o(110114);
      return;
      if (paramBoolean) {
        str = getString(2131760020);
      } else {
        str = getString(2131760019);
      }
    }
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(110105);
    if (this.jbB != null) {
      this.jbB.notifyDataSetChanged();
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
    this.iYS = ((TextView)findViewById(2131299457));
    this.jbA = ((ListView)findViewById(2131300574));
    this.jbA.setAdapter(this.jbB);
    this.jbA.setOnItemClickListener(this);
    r localr = new r((byte)0);
    localr.KKQ = new r.b()
    {
      public final boolean Jp(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Jq(String paramAnonymousString)
      {
        AppMethodBeat.i(110075);
        GoogleFriendUI.a(GoogleFriendUI.this, bt.aQN(paramAnonymousString));
        if (GoogleFriendUI.a(GoogleFriendUI.this) != null) {
          GoogleFriendUI.a(GoogleFriendUI.this).Jo(GoogleFriendUI.b(GoogleFriendUI.this));
        }
        AppMethodBeat.o(110075);
      }
      
      public final void aSm() {}
      
      public final void aSn() {}
      
      public final void aSo() {}
      
      public final void aSp() {}
    };
    addSearchMenu(true, localr);
    AppMethodBeat.o(110099);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(110101);
    ad.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2005)
    {
      if (paramInt2 == -1)
      {
        this.iYI = paramIntent.getBooleanExtra("gpservices", false);
        aSh();
        AppMethodBeat.o(110101);
        return;
      }
      this.iYI = paramIntent.getBooleanExtra("gpservices", false);
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
    this.iYK = ((String)g.ajC().ajl().get(208903, null));
    if (TextUtils.isEmpty(this.iYK)) {
      finish();
    }
    this.iYN = getIntent().getIntExtra("enter_scene", 0);
    this.jbB = new a(this, this.iYK);
    this.jbB.jbs = this;
    initView();
    this.iYI = com.tencent.mm.plugin.account.friend.a.m.de(this);
    if (this.iYI)
    {
      ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
      AppMethodBeat.o(110095);
      return;
      aSh();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110098);
    super.onDestroy();
    ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
    AppMethodBeat.o(110098);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(110100);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", new Object[] { Integer.valueOf(paramInt) });
    if (this.jbB != null)
    {
      int i = this.jbA.getHeaderViewsCount();
      paramAdapterView = (com.tencent.mm.plugin.account.friend.a.n)this.jbB.getItem(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = paramAdapterView.field_username;
        ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", new Object[] { paramAdapterView.field_googlegmail, paramView });
        localObject = ((l)g.ab(l.class)).azp().Bf(paramView);
        if (((localObject == null) || (!com.tencent.mm.o.b.lM(((aw)localObject).field_type))) && (TextUtils.isEmpty(paramAdapterView.field_nickname))) {
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
          com.tencent.mm.plugin.account.a.a.iRG.c((Intent)localObject, getContext());
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
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.ahp(), "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendUI", "jumpToProfile", "(Lcom/tencent/mm/plugin/account/friend/model/GoogleFriendInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110096);
    super.onResume();
    g.aiU().a(488, this);
    g.aiU().a(489, this);
    p.aEk().d(this);
    if (this.jbB != null) {
      this.jbB.Zu();
    }
    AppMethodBeat.o(110096);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(110104);
    String str;
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      ad.i("MicroMsg.GoogleContact.GoogleFriendUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      i = paramn.getType();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label305;
      }
      switch (i)
      {
      default: 
        ad.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
      }
    }
    for (;;)
    {
      aRY();
      AppMethodBeat.o(110104);
      return;
      str = paramString;
      break;
      if (this.jbB != null)
      {
        paramString = (ah)paramn;
        ad.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.aTe().nDi) });
        paramString = paramString.jex;
        ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
        ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aA(paramString, 1);
        this.jbB.Zu();
        continue;
        if (this.jbB != null)
        {
          paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).jex;
          ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
          ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aA(paramString, 1);
          this.jbB.Zu();
          continue;
          a(((com.tencent.mm.plugin.account.friend.a.ai)paramn).aTf());
          continue;
          switch (i)
          {
          default: 
            ad.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
            break;
          case 489: 
            if (this.jbB != null)
            {
              paramString = (ah)paramn;
              ad.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.aTe().nDi) });
              paramString = paramString.jex;
              ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aA(paramString, 1);
              this.jbB.Zu();
            }
            break;
          case 30: 
          case 137: 
            if (paramInt2 == -87) {
              h.c(this, getString(2131757604), "", true);
            }
            while (this.jbB != null)
            {
              paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).jex;
              ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aA(paramString, 2);
              this.jbB.Zu();
              break;
              if (((paramInt2 == -24) || (paramInt2 == -101)) && (!bt.isNullOrNil(paramString))) {
                Toast.makeText(this, paramString, 1).show();
              }
            }
          case 488: 
            label305:
            fp(false);
          }
        }
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(110097);
    super.onStop();
    g.aiU().b(488, this);
    g.aiU().b(489, this);
    p.aEk().e(this);
    AppMethodBeat.o(110097);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rk(int paramInt)
  {
    AppMethodBeat.i(110103);
    if (this.jbB == null)
    {
      AppMethodBeat.o(110103);
      return;
    }
    com.tencent.mm.plugin.account.friend.a.n localn = (com.tencent.mm.plugin.account.friend.a.n)this.jbB.getItem(paramInt);
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
          ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
          if ((paramAnonymousBoolean1) || (paramAnonymousBoolean2))
          {
            ad.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramAnonymousString2 });
            ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aA(paramAnonymousString2, 1);
          }
          for (;;)
          {
            GoogleFriendUI.a(GoogleFriendUI.this).Zu();
            AppMethodBeat.o(110076);
            return;
            ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aA(paramAnonymousString2, 2);
          }
        }
      });
      Object localObject2 = localn.field_googleitemid;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).EUT = false;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).EUS = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).jgN = ((String)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).EUT = false;
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(58));
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).b(localn.field_username, (LinkedList)localObject2, true);
      localn.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(localn);
      this.jbB.Zu();
      AppMethodBeat.o(110103);
      return;
      localObject1 = localn.field_googleid;
      localObject1 = ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).JG((String)localObject1);
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
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private GoogleFriendUI.a jbO = GoogleFriendUI.a.jbM;
    private Context mContext;
    private String mToken;
    
    private b(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      this.mToken = paramString;
    }
    
    private static String B(InputStream paramInputStream)
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
    
    private void Jr(String paramString)
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
              if ((!TextUtils.isEmpty(paramString)) && (bt.aQS(paramString)) && (!paramString.equals(GoogleFriendUI.h(GoogleFriendUI.this))))
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
    
    private Void aRZ()
    {
      AppMethodBeat.i(110083);
      ad.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
      int j = 0;
      int i = 1;
      for (;;)
      {
        int k;
        try
        {
          ad.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          String str = k("json", i, this.mToken);
          k = new JSONObject(str).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
          if (k <= 0) {
            break label205;
          }
          Jr(str);
        }
        catch (IOException localIOException)
        {
          this.jbO = GoogleFriendUI.a.jbL;
          ad.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + localIOException.getMessage());
          continue;
        }
        catch (JSONException localJSONException)
        {
          this.jbO = GoogleFriendUI.a.jbM;
          ad.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + localJSONException.getMessage());
          continue;
          j = k;
        }
        if ((j == 0) || (GoogleFriendUI.g(GoogleFriendUI.this)))
        {
          this.jbO = GoogleFriendUI.a.jbJ;
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
    
    private static String k(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(110084);
      paramString1 = new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + paramString1 + "&max-results=100&start-index=" + paramInt + "&access_token=" + paramString2);
      ad.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new Object[] { paramString1.toString() });
      paramString1 = (HttpURLConnection)paramString1.openConnection();
      paramString1.setRequestMethod("GET");
      paramString1.setConnectTimeout(20000);
      paramInt = paramString1.getResponseCode();
      ad.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 200)
      {
        paramString1 = paramString1.getInputStream();
        paramString2 = B(paramString1);
        paramString1.close();
        AppMethodBeat.o(110084);
        return paramString2;
      }
      if (paramInt == 401) {
        ad.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
      }
      try
      {
        for (;;)
        {
          paramString1.getInputStream().close();
          paramString1.disconnect();
          AppMethodBeat.o(110084);
          return null;
          ad.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          ad.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", paramString2.getMessage());
        }
      }
    }
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(110082);
      super.onPreExecute();
      ad.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
      GoogleFriendUI.e(GoogleFriendUI.this).clear();
      GoogleFriendUI.f(GoogleFriendUI.this).clear();
      AppMethodBeat.o(110082);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI
 * JD-Core Version:    0.7.0.1
 */