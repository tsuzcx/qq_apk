package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ae;
import com.tencent.mm.plugin.account.friend.a.af;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GoogleFriendUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, d.a, f, a.a
{
  private String gsL;
  private boolean gso;
  private String gsq;
  private ProgressDialog gsr;
  private int gst;
  private TextView gsy;
  private ListView gvl;
  private a gvm;
  private String gvn;
  private af gvo;
  private ArrayList<com.tencent.mm.plugin.account.friend.a.n> gvp;
  private HashMap<String, com.tencent.mm.plugin.account.friend.a.n> gvq;
  private String mToken;
  private boolean qM;
  
  public GoogleFriendUI()
  {
    AppMethodBeat.i(13668);
    this.gso = false;
    this.qM = false;
    this.gvp = new ArrayList();
    this.gvq = new HashMap();
    AppMethodBeat.o(13668);
  }
  
  private void a(Cursor paramCursor, com.tencent.mm.plugin.account.friend.a.n paramn)
  {
    AppMethodBeat.i(13683);
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
    Object localObject = getResources().getString(2131300492);
    getResources().getString(2131296888);
    h.a(paramCursor, (String)localObject, localArrayList1, localArrayList2, new GoogleFriendUI.4(this, localArrayList3, paramn));
    AppMethodBeat.o(13683);
  }
  
  private void a(com.tencent.mm.plugin.account.friend.a.n paramn1, com.tencent.mm.plugin.account.friend.a.n paramn2)
  {
    AppMethodBeat.i(13684);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramn1.field_googlegmail);
    localObject = new ae((ArrayList)localObject);
    ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramn1.field_googleitemid });
    g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
    if (paramn2 == null)
    {
      ((ae)localObject).gyj = paramn1.field_googleitemid;
      paramn1.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(paramn1);
    }
    for (;;)
    {
      this.gvm.Ku();
      AppMethodBeat.o(13684);
      return;
      ((ae)localObject).gyj = paramn2.field_googleitemid;
      paramn2.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(paramn2);
    }
  }
  
  private void a(bah parambah)
  {
    try
    {
      AppMethodBeat.i(13687);
      ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(parambah.jJu) });
      if (this.gvm != null) {
        this.gvm.Ku();
      }
      AppMethodBeat.o(13687);
      return;
    }
    finally {}
  }
  
  private void apI()
  {
    AppMethodBeat.i(13676);
    ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
    apJ();
    if ((TextUtils.isEmpty(this.mToken)) || ((!this.gso) && (TextUtils.isEmpty(this.gsL))))
    {
      startActivity(BindGoogleContactUI.class);
      finish();
      AppMethodBeat.o(13676);
      return;
    }
    apK();
    AppMethodBeat.o(13676);
  }
  
  private void apJ()
  {
    AppMethodBeat.i(13681);
    if (this.gso)
    {
      this.mToken = ((String)g.RL().Ru().get(208901, null));
      AppMethodBeat.o(13681);
      return;
    }
    this.mToken = ((String)g.RL().Ru().get(208902, null));
    this.gsL = ((String)g.RL().Ru().get(208904, null));
    AppMethodBeat.o(13681);
  }
  
  private void apK()
  {
    AppMethodBeat.i(13682);
    if (this.gso)
    {
      apM();
      AppMethodBeat.o(13682);
      return;
    }
    apL();
    AppMethodBeat.o(13682);
  }
  
  private void apL()
  {
    AppMethodBeat.i(13685);
    apy();
    new GoogleFriendUI.c(this, this.gsL).execute(new Void[0]);
    AppMethodBeat.o(13685);
  }
  
  private void apM()
  {
    AppMethodBeat.i(13686);
    this.qM = false;
    apy();
    new GoogleFriendUI.b(this, this, this.mToken, (byte)0).execute(new Void[0]);
    AppMethodBeat.o(13686);
  }
  
  private void apy()
  {
    AppMethodBeat.i(13689);
    if ((this.gsr == null) || (!this.gsr.isShowing()))
    {
      getString(2131297087);
      this.gsr = h.b(this, getString(2131297112), true, new GoogleFriendUI.5(this));
    }
    AppMethodBeat.o(13689);
  }
  
  private void apz()
  {
    AppMethodBeat.i(13690);
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    AppMethodBeat.o(13690);
  }
  
  private void dv(boolean paramBoolean)
  {
    AppMethodBeat.i(13688);
    this.gsy.setVisibility(0);
    String str;
    if (!at.isConnected(this)) {
      str = getString(2131300491);
    }
    for (;;)
    {
      this.gsy.setText(str);
      AppMethodBeat.o(13688);
      return;
      if (paramBoolean) {
        str = getString(2131300484);
      } else {
        str = getString(2131300483);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130969836;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13673);
    setMMTitle(2131300485);
    setBackBtn(new GoogleFriendUI.1(this));
    this.gsy = ((TextView)findViewById(2131821788));
    this.gvl = ((ListView)findViewById(2131824793));
    this.gvl.setAdapter(this.gvm);
    this.gvl.setOnItemClickListener(this);
    q localq = new q((byte)0);
    localq.Axg = new GoogleFriendUI.2(this);
    addSearchMenu(true, localq);
    AppMethodBeat.o(13673);
  }
  
  public final void mP(int paramInt)
  {
    AppMethodBeat.i(13677);
    if (this.gvm == null)
    {
      AppMethodBeat.o(13677);
      return;
    }
    com.tencent.mm.plugin.account.friend.a.n localn = (com.tencent.mm.plugin.account.friend.a.n)this.gvm.getItem(paramInt);
    if (localn == null)
    {
      AppMethodBeat.o(13677);
      return;
    }
    switch (localn.field_status)
    {
    }
    label258:
    for (;;)
    {
      AppMethodBeat.o(13677);
      return;
      Object localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this, new GoogleFriendUI.3(this));
      Object localObject2 = localn.field_googleitemid;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).vST = false;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).vSS = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).gAl = ((String)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).vST = false;
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(58));
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).b(localn.field_username, (LinkedList)localObject2, true);
      localn.field_googlecgistatus = 0;
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(localn);
      this.gvm.Ku();
      AppMethodBeat.o(13677);
      return;
      localObject1 = localn.field_googleid;
      localObject1 = ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).xk((String)localObject1);
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13675);
    ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2005)
    {
      if (paramInt2 == -1)
      {
        this.gso = paramIntent.getBooleanExtra("gpservices", false);
        apI();
        AppMethodBeat.o(13675);
        return;
      }
      this.gso = paramIntent.getBooleanExtra("gpservices", false);
      finish();
    }
    AppMethodBeat.o(13675);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(13680);
    super.onBackPressed();
    AppMethodBeat.o(13680);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13669);
    super.onCreate(paramBundle);
    this.gsq = ((String)g.RL().Ru().get(208903, null));
    if (TextUtils.isEmpty(this.gsq)) {
      finish();
    }
    this.gst = getIntent().getIntExtra("enter_scene", 0);
    this.gvm = new a(this, this.gsq);
    this.gvm.gvc = this;
    initView();
    this.gso = com.tencent.mm.plugin.account.friend.a.m.cD(this);
    if (this.gso)
    {
      ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
      AppMethodBeat.o(13669);
      return;
      apI();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13672);
    super.onDestroy();
    ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
    AppMethodBeat.o(13672);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13674);
    ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", new Object[] { Integer.valueOf(paramInt) });
    if (this.gvm != null)
    {
      int i = this.gvl.getHeaderViewsCount();
      paramAdapterView = (com.tencent.mm.plugin.account.friend.a.n)this.gvm.getItem(paramInt - i);
      if (paramAdapterView != null)
      {
        paramView = paramAdapterView.field_username;
        ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", new Object[] { paramAdapterView.field_googlegmail, paramView });
        Object localObject = ((j)g.E(j.class)).YA().arw(paramView);
        if (((localObject != null) && (com.tencent.mm.n.a.je(((aq)localObject).field_type))) || (!TextUtils.isEmpty(paramAdapterView.field_nickname)))
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
            com.tencent.mm.plugin.account.a.a.gmO.c((Intent)localObject, getContext());
          }
          AppMethodBeat.o(13674);
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
        startActivity((Intent)localObject);
      }
    }
    AppMethodBeat.o(13674);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13670);
    super.onResume();
    g.Rc().a(488, this);
    g.Rc().a(489, this);
    com.tencent.mm.ah.o.acQ().d(this);
    if (this.gvm != null) {
      this.gvm.Ku();
    }
    AppMethodBeat.o(13670);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(13678);
    String str;
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      i = paramm.getType();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label305;
      }
      switch (i)
      {
      default: 
        ab.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
      }
    }
    for (;;)
    {
      apz();
      AppMethodBeat.o(13678);
      return;
      str = paramString;
      break;
      if (this.gvm != null)
      {
        paramString = (ae)paramm;
        ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.aqF().jJu) });
        paramString = paramString.gyj;
        ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
        ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(paramString, 1);
        this.gvm.Ku();
        continue;
        if (this.gvm != null)
        {
          paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).gyj;
          ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
          ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(paramString, 1);
          this.gvm.Ku();
          continue;
          a(((af)paramm).aqG());
          continue;
          switch (i)
          {
          default: 
            ab.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
            break;
          case 489: 
            if (this.gvm != null)
            {
              paramString = (ae)paramm;
              ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[] { Integer.valueOf(paramString.aqF().jJu) });
              paramString = paramString.gyj;
              ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(paramString, 1);
              this.gvm.Ku();
            }
            break;
          case 30: 
          case 137: 
            if (paramInt2 == -87) {
              h.b(this, getString(2131298545), "", true);
            }
            while (this.gvm != null)
            {
              paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).gyj;
              ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString });
              ((com.tencent.mm.plugin.account.friend.a.o)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(paramString, 2);
              this.gvm.Ku();
              break;
              if (((paramInt2 == -24) || (paramInt2 == -101)) && (!bo.isNullOrNil(paramString))) {
                Toast.makeText(this, paramString, 1).show();
              }
            }
          case 488: 
            label305:
            dv(false);
          }
        }
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(13671);
    super.onStop();
    g.Rc().b(488, this);
    g.Rc().b(489, this);
    com.tencent.mm.ah.o.acQ().e(this);
    AppMethodBeat.o(13671);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(13679);
    if (this.gvm != null) {
      this.gvm.notifyDataSetChanged();
    }
    AppMethodBeat.o(13679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI
 * JD-Core Version:    0.7.0.1
 */