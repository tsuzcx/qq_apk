package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.ae;
import com.tencent.mm.plugin.account.friend.a.af;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.aub;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GoogleFriendUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, d.a, f, a.a
{
  private int faB;
  private TextView faG;
  private String faT;
  private boolean faw = false;
  private String fay;
  private ProgressDialog faz;
  private ListView fdA;
  private a fdB;
  private String fdC;
  private String fdD;
  private af fdE;
  private ArrayList<com.tencent.mm.plugin.account.friend.a.n> fdF = new ArrayList();
  private HashMap<String, com.tencent.mm.plugin.account.friend.a.n> fdG = new HashMap();
  private boolean pP = false;
  
  private void VZ()
  {
    if ((this.faz == null) || (!this.faz.isShowing()))
    {
      getString(a.i.app_tip);
      this.faz = h.b(this, getString(a.i.app_waiting), true, new GoogleFriendUI.5(this));
    }
  }
  
  private void Wa()
  {
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
  }
  
  private void Wj()
  {
    y.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
    if (this.faw) {
      this.fdD = ((String)g.DP().Dz().get(208901, null));
    }
    while ((TextUtils.isEmpty(this.fdD)) || ((!this.faw) && (TextUtils.isEmpty(this.faT))))
    {
      Y(BindGoogleContactUI.class);
      finish();
      return;
      this.fdD = ((String)g.DP().Dz().get(208902, null));
      this.faT = ((String)g.DP().Dz().get(208904, null));
    }
    if (this.faw)
    {
      Wk();
      return;
    }
    VZ();
    new GoogleFriendUI.c(this, this.faT).execute(new Void[0]);
  }
  
  private void Wk()
  {
    this.pP = false;
    VZ();
    new GoogleFriendUI.b(this, this, this.fdD, (byte)0).execute(new Void[0]);
  }
  
  private void a(Cursor paramCursor, com.tencent.mm.plugin.account.friend.a.n paramn)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    if (paramCursor != null)
    {
      paramCursor.moveToFirst();
      int j = paramCursor.getCount();
      int i = 0;
      while (i < j)
      {
        localObject = new com.tencent.mm.plugin.account.friend.a.n();
        ((com.tencent.mm.plugin.account.friend.a.n)localObject).d(paramCursor);
        localArrayList1.add(((com.tencent.mm.plugin.account.friend.a.n)localObject).field_googlegmail);
        localArrayList2.add(Integer.valueOf(i));
        localArrayList3.add(localObject);
        paramCursor.moveToNext();
        i += 1;
      }
      localArrayList2.add(Integer.valueOf(-1));
    }
    paramCursor = this.mController.uMN;
    Object localObject = getResources().getString(a.i.gcontact_select_email);
    getResources().getString(a.i.app_cancel);
    h.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new GoogleFriendUI.4(this, localArrayList3, paramn));
  }
  
  private void a(com.tencent.mm.plugin.account.friend.a.n paramn1, com.tencent.mm.plugin.account.friend.a.n paramn2)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramn1.field_googlegmail);
    localObject = new ae((ArrayList)localObject);
    y.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramn1.field_googleitemid });
    g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
    if (paramn2 == null)
    {
      ((ae)localObject).fgB = paramn1.field_googleitemid;
      paramn1.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(paramn1);
    }
    for (;;)
    {
      this.fdB.yc();
      return;
      ((ae)localObject).fgB = paramn2.field_googleitemid;
      paramn2.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(paramn2);
    }
  }
  
  private void a(aub paramaub)
  {
    try
    {
      y.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(paramaub.hPS) });
      if (this.fdB != null) {
        this.fdB.yc();
      }
      return;
    }
    finally
    {
      paramaub = finally;
      throw paramaub;
    }
  }
  
  private void ct(boolean paramBoolean)
  {
    this.faG.setVisibility(0);
    String str;
    if (!aq.isConnected(this)) {
      str = getString(a.i.gcontact_network_error_msg);
    }
    for (;;)
    {
      this.faG.setText(str);
      return;
      if (paramBoolean) {
        str = getString(a.i.gcontact_empty);
      } else {
        str = getString(a.i.gcontact_default_error_msg);
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return a.f.gcontact_friend;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.gcontact_friend_title);
    setBackBtn(new GoogleFriendUI.1(this));
    this.faG = ((TextView)findViewById(a.e.empty));
    this.fdA = ((ListView)findViewById(a.e.gcontact_friend_lv));
    this.fdA.setAdapter(this.fdB);
    this.fdA.setOnItemClickListener(this);
    com.tencent.mm.ui.tools.n localn = new com.tencent.mm.ui.tools.n((byte)0);
    localn.weq = new GoogleFriendUI.2(this);
    a(localn);
  }
  
  public final void jT(int paramInt)
  {
    if (this.fdB == null) {}
    for (;;)
    {
      return;
      com.tencent.mm.plugin.account.friend.a.n localn = (com.tencent.mm.plugin.account.friend.a.n)this.fdB.getItem(paramInt);
      if (localn != null)
      {
        switch (localn.field_status)
        {
        default: 
          return;
        case 0: 
          localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this, new GoogleFriendUI.3(this));
          Object localObject2 = localn.field_googleitemid;
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).sbN = false;
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).sbM = true;
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).fiE = ((String)localObject2);
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).sbN = false;
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(Integer.valueOf(58));
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).b(localn.field_username, (LinkedList)localObject2, true);
          localn.field_googlecgistatus = 0;
          ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(localn);
          this.fdB.yc();
          return;
        }
        Object localObject1 = localn.field_googleid;
        localObject1 = ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).pP((String)localObject1);
        if ((localObject1 == null) || (((Cursor)localObject1).getCount() <= 1)) {
          a(localn, null);
        }
        while (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          return;
          a((Cursor)localObject1, localn);
        }
      }
    }
  }
  
  public final void kk(String paramString)
  {
    if (this.fdB != null) {
      this.fdB.notifyDataSetChanged();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2005)
    {
      if (paramInt2 == -1)
      {
        this.faw = paramIntent.getBooleanExtra("gpservices", false);
        Wj();
      }
    }
    else {
      return;
    }
    this.faw = paramIntent.getBooleanExtra("gpservices", false);
    finish();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.fay = ((String)g.DP().Dz().get(208903, null));
    if (TextUtils.isEmpty(this.fay)) {
      finish();
    }
    this.faB = getIntent().getIntExtra("enter_scene", 0);
    this.fdB = new a(this, this.fay);
    this.fdB.fdr = this;
    initView();
    this.faw = com.tencent.mm.plugin.account.friend.a.m.bX(this);
    if (this.faw)
    {
      y.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
      return;
      Wj();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", new Object[] { Integer.valueOf(paramInt) });
    if (this.fdB != null)
    {
      int i = this.fdA.getHeaderViewsCount();
      paramAdapterView = (com.tencent.mm.plugin.account.friend.a.n)this.fdB.getItem(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = paramAdapterView.field_username;
        y.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", new Object[] { paramAdapterView.field_googlegmail, paramView });
        localObject = ((j)g.r(j.class)).Fw().abl(paramView);
        if (((localObject == null) || (!com.tencent.mm.n.a.gR(((ao)localObject).field_type))) && (TextUtils.isEmpty(paramAdapterView.field_nickname))) {
          break label249;
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
          com.tencent.mm.plugin.account.a.a.eUR.d((Intent)localObject, this.mController.uMN);
        }
      }
    }
    return;
    label249:
    Object localObject = new Intent(this, InviteFriendUI.class);
    ((Intent)localObject).putExtra("friend_type", 2);
    ((Intent)localObject).putExtra("friend_user_name", paramView);
    ((Intent)localObject).putExtra("friend_num", paramAdapterView.field_googlegmail);
    ((Intent)localObject).putExtra("friend_nick", paramAdapterView.field_googlename);
    ((Intent)localObject).putExtra("friend_weixin_nick", paramAdapterView.field_nickname);
    ((Intent)localObject).putExtra("friend_googleID", paramAdapterView.field_googleid);
    ((Intent)localObject).putExtra("friend_googleItemID", paramAdapterView.field_googleitemid);
    ((Intent)localObject).putExtra("friend_scene", 58);
    ((Intent)localObject).putExtra("Contact_Scene", 58);
    startActivity((Intent)localObject);
  }
  
  protected void onResume()
  {
    super.onResume();
    g.Dk().a(488, this);
    g.Dk().a(489, this);
    com.tencent.mm.ag.o.JQ().d(this);
    if (this.fdB != null) {
      this.fdB.yc();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    String str;
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      y.i("MicroMsg.GoogleContact.GoogleFriendUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      i = paramm.getType();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label295;
      }
      switch (i)
      {
      default: 
        y.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
      }
    }
    for (;;)
    {
      Wa();
      return;
      str = paramString;
      break;
      if (this.fdB != null)
      {
        paramString = (ae)paramm;
        y.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.Xb().hPS) });
        paramString = paramString.fgB;
        y.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
        ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ab(paramString, 1);
        this.fdB.yc();
        continue;
        if (this.fdB != null)
        {
          paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).fgB;
          y.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
          ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ab(paramString, 1);
          this.fdB.yc();
          continue;
          a(((af)paramm).Xc());
          continue;
          switch (i)
          {
          default: 
            y.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
            break;
          case 489: 
            if (this.fdB != null)
            {
              paramString = (ae)paramm;
              y.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.Xb().hPS) });
              paramString = paramString.fgB;
              y.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ab(paramString, 1);
              this.fdB.yc();
            }
            break;
          case 30: 
          case 137: 
            if (paramInt2 == -87) {
              h.b(this, getString(a.i.contact_info_biz_join_fans_limit), "", true);
            }
            while (this.fdB != null)
            {
              paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).fgB;
              y.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ab(paramString, 2);
              this.fdB.yc();
              break;
              if (((paramInt2 == -24) || (paramInt2 == -101)) && (!bk.bl(paramString))) {
                Toast.makeText(this, paramString, 1).show();
              }
            }
          case 488: 
            label295:
            ct(false);
          }
        }
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    g.Dk().b(488, this);
    g.Dk().b(489, this);
    com.tencent.mm.ag.o.JQ().e(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI
 * JD-Core Version:    0.7.0.1
 */