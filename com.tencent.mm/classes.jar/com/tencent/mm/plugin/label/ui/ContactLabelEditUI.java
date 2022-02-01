package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.b.e;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.fve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelEditUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private boolean JLD;
  private ArrayList<String> JUA;
  private ArrayList<String> JUB;
  private HashSet<String> JUC;
  private HashSet<String> JUD;
  private HashSet<String> JUE;
  private String JUF;
  private String JUG;
  private boolean JUH;
  private boolean JUQ;
  private com.tencent.mm.ui.base.preference.f JUR;
  private ContactListExpandPreference JUS;
  private InputClearablePreference JUT;
  private Preference JUU;
  private PreferenceTitleCategory JUV;
  private String JUr;
  private String JUs;
  private String JUt;
  private aw JUu;
  private boolean JUv;
  private boolean JUw;
  private String JUx;
  private boolean JUy;
  private MMHandler mHandler;
  private ProgressDialog pNH;
  
  public ContactLabelEditUI()
  {
    AppMethodBeat.i(26178);
    this.JUw = false;
    this.JUy = true;
    this.JLD = true;
    this.JUA = new ArrayList();
    this.JUB = new ArrayList();
    this.JUC = new HashSet();
    this.JUD = new HashSet();
    this.JUE = new HashSet();
    this.mHandler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26162);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          Log.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(26162);
          return;
        case 6001: 
          ContactLabelEditUI.a(ContactLabelEditUI.this);
          AppMethodBeat.o(26162);
          return;
        }
        com.tencent.mm.plugin.label.a.pFo.aDx();
        AppMethodBeat.o(26162);
      }
    };
    AppMethodBeat.o(26178);
  }
  
  private void a(aw paramaw)
  {
    AppMethodBeat.i(26197);
    if (!com.tencent.mm.plugin.label.d.fTa().a(paramaw, new String[] { "labelID" }))
    {
      Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
      fTe();
      AppMethodBeat.o(26197);
      return;
    }
    fTl();
    AppMethodBeat.o(26197);
  }
  
  private static boolean aJL(String paramString)
  {
    AppMethodBeat.i(26191);
    if (!Util.isNullOrNil(com.tencent.mm.plugin.label.d.fTa().aJH(paramString)))
    {
      AppMethodBeat.o(26191);
      return true;
    }
    AppMethodBeat.o(26191);
    return false;
  }
  
  private void aJO(String paramString)
  {
    AppMethodBeat.i(26193);
    getString(R.l.app_tip);
    this.pNH = k.a(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26163);
        bh.aZW().cancel(635);
        bh.aZW().cancel(637);
        AppMethodBeat.o(26163);
      }
    });
    AppMethodBeat.o(26193);
  }
  
  private void aoP(String paramString)
  {
    AppMethodBeat.i(26195);
    k.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(26195);
  }
  
  private void fTe()
  {
    AppMethodBeat.i(26198);
    aoP(getString(R.l.gEb));
    AppMethodBeat.o(26198);
  }
  
  private void fTf()
  {
    AppMethodBeat.i(26189);
    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
    hideLoading();
    if (this.JUC != null) {}
    for (int i = this.JUC.size();; i = 0)
    {
      if (this.JUE != null) {}
      for (int j = this.JUE.size();; j = 0)
      {
        int k;
        if (this.JUQ)
        {
          if (this.JUy) {
            com.tencent.mm.plugin.label.c.d(getIntent().getIntExtra("key_label_click_source", 0), 10L, 1L, i, 0L);
          }
        }
        else
        {
          Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            int m = this.JUD.size();
            int n = Math.max(0, i - m);
            localObject = com.tencent.mm.plugin.report.service.h.OAn;
            String str = z.bAM();
            if (!this.JUv) {
              break label339;
            }
            k = 1;
            label145:
            ((com.tencent.mm.plugin.report.service.h)localObject).b(11220, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
          }
          if (!this.JUy) {
            break label381;
          }
          Object localObject = getIntent();
          ((Intent)localObject).putExtra("k_sns_label_add_label", this.JUs);
          ((Intent)localObject).putStringArrayListExtra("k_sns_label_add_label_usernames", new ArrayList(this.JUC));
          setResult(0, (Intent)localObject);
          if (!this.JUH) {
            break label344;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(26189);
          return;
          com.tencent.mm.plugin.label.c.d(getIntent().getIntExtra("key_label_click_source", 0), 6L, 1L, i, j);
          break;
          label339:
          k = 2;
          break label145;
          label344:
          com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
        }
        label381:
        if (i > 0)
        {
          if (this.JUH) {
            com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
        else if (j > 0)
        {
          if (!this.JUH) {
            break label516;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2) });
        }
        for (;;)
        {
          label426:
          setResult(0);
          break;
          com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(3) });
          break label426;
          label516:
          com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(3) });
        }
      }
    }
  }
  
  private void fTg()
  {
    AppMethodBeat.i(26190);
    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
    hideLoading();
    aoP(getString(R.l.gpI));
    AppMethodBeat.o(26190);
  }
  
  private void fTh()
  {
    AppMethodBeat.i(26192);
    int i;
    if (this.JUC == null)
    {
      i = 0;
      if (this.JUE != null) {
        break label227;
      }
    }
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    String str;
    label227:
    for (int j = 0;; j = this.JUE.size())
    {
      Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList] addcount:%d,delcount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = new LinkedList();
      if ((this.JUC == null) || (this.JUC.size() <= 0)) {
        break label238;
      }
      this.JUC.size();
      localIterator = this.JUC.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        bh.bCz();
        localObject2 = com.tencent.mm.model.c.bzA().JE((String)localObject2);
        localObject3 = ((com.tencent.mm.autogen.b.az)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.jQ((String)localObject3, this.JUt);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[] { localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new fve();
          ((fve)localObject3).UserName = ((com.tencent.mm.autogen.b.az)localObject2).field_username;
          ((fve)localObject3).ZqN = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
      i = this.JUC.size();
      break;
    }
    label238:
    if ((this.JUE != null) && (this.JUE.size() > 0))
    {
      this.JUE.size();
      localIterator = this.JUE.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        bh.bCz();
        localObject3 = com.tencent.mm.model.c.bzA().JE((String)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.jR((String)localObject3, this.JUt);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[] { localObject2, localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new fve();
          ((fve)localObject3).UserName = ((String)localObject2);
          ((fve)localObject3).ZqN = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new e((LinkedList)localObject1);
      bh.aZW().a((p)localObject1, 0);
      AppMethodBeat.o(26192);
      return;
    }
    fTf();
    AppMethodBeat.o(26192);
  }
  
  private void fTk()
  {
    AppMethodBeat.i(26187);
    if (this.JUS != null)
    {
      this.JUS.y(null, this.JUA);
      if ((this.JUA == null) || (this.JUA.size() <= 0)) {
        this.JUS.iLt();
      }
    }
    if (this.JUT != null) {
      this.JUT.setText(this.JUs);
    }
    AppMethodBeat.o(26187);
  }
  
  private void fTl()
  {
    AppMethodBeat.i(26199);
    setResult(-1);
    finish();
    AppMethodBeat.o(26199);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(26194);
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    AppMethodBeat.o(26194);
  }
  
  private void updateTitle(String paramString)
  {
    AppMethodBeat.i(26188);
    if (Util.isNullOrNil(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(26188);
      return;
    }
  }
  
  public String getIdentString()
  {
    if (this.JUy) {
      return "_New";
    }
    return "_Edit";
  }
  
  public int getResourceId()
  {
    return R.o.hbg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26183);
    if (this.JUH)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if (!Util.isNullOrNil(this.JUt)) {
        break label561;
      }
      this.JUy = true;
      this.JUx = getString(R.l.gRA);
      label73:
      setMMTitle(this.JUx);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(26166);
          ContactLabelEditUI.this.onBackPressed();
          AppMethodBeat.o(26166);
          return true;
        }
      });
      addTextOptionMenu(0, getString(R.l.app_save), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(26167);
          ContactLabelEditUI.b(ContactLabelEditUI.this);
          AppMethodBeat.o(26167);
          return true;
        }
      }, null, y.b.adEJ);
      this.JUR = getPreferenceScreen();
      this.JUS = ((ContactListExpandPreference)this.JUR.bAi("contact_label_contact_list"));
      this.JUS.a(this.JUR, this.JUS.mKey);
      this.JUS.JJ(true);
      this.JUS.JK(true);
      this.JUS.iLv();
      this.JUS.iLp();
      this.JUS.a(new s.b()
      {
        public final boolean qy(int paramAnonymousInt)
        {
          return false;
        }
      });
      this.JUS.a(new ContactListExpandPreference.a()
      {
        public final void aMI()
        {
          AppMethodBeat.i(26169);
          if (ContactLabelEditUI.c(ContactLabelEditUI.this) != null) {
            ContactLabelEditUI.c(ContactLabelEditUI.this).iLt();
          }
          AppMethodBeat.o(26169);
        }
        
        public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(268722);
          Intent localIntent;
          if (ContactLabelEditUI.c(ContactLabelEditUI.this).awt(paramAnonymousInt))
          {
            paramAnonymousViewGroup = ContactLabelEditUI.c(ContactLabelEditUI.this).awu(paramAnonymousInt);
            String str = ContactLabelEditUI.c(ContactLabelEditUI.this).awv(paramAnonymousInt);
            if (Util.isNullOrNil(paramAnonymousViewGroup))
            {
              AppMethodBeat.o(268722);
              return;
            }
            localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
            localIntent.putExtra("Contact_RoomNickname", str);
            if (!ContactLabelEditUI.d(ContactLabelEditUI.this)) {
              break label125;
            }
          }
          label125:
          for (paramAnonymousInt = 17;; paramAnonymousInt = 15)
          {
            localIntent.putExtra("CONTACT_INFO_UI_SOURCE", paramAnonymousInt);
            com.tencent.mm.plugin.label.a.pFn.c(localIntent, ContactLabelEditUI.this);
            AppMethodBeat.o(268722);
            return;
          }
        }
        
        public final void qw(int paramAnonymousInt)
        {
          AppMethodBeat.i(26171);
          String str = ContactLabelEditUI.c(ContactLabelEditUI.this).awu(paramAnonymousInt);
          Log.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
          ContactLabelEditUI.a(ContactLabelEditUI.this, str);
          AppMethodBeat.o(26171);
        }
        
        public final void qx(int paramAnonymousInt)
        {
          AppMethodBeat.i(26170);
          ContactLabelEditUI.e(ContactLabelEditUI.this);
          AppMethodBeat.o(26170);
        }
      });
      this.JUT = ((InputClearablePreference)this.JUR.bAi("contact_label_name"));
      InputClearablePreference localInputClearablePreference = this.JUT;
      localInputClearablePreference.JYm = getString(R.l.gMi);
      if (localInputClearablePreference.JYp != null) {
        localInputClearablePreference.JYp.setHint(localInputClearablePreference.JYm);
      }
      this.JUT.ppp = getString(R.l.gMr);
      localInputClearablePreference = this.JUT;
      localInputClearablePreference.JYn = getString(R.l.gpJ);
      if (localInputClearablePreference.JXe != null) {
        localInputClearablePreference.JXe.setText(localInputClearablePreference.JYn);
      }
      this.JUT.JWX = 36;
      this.JUT.JYo = this.JUy;
      this.JUT.JYr = new InputClearablePreference.a()
      {
        public final void aAg(String paramAnonymousString)
        {
          AppMethodBeat.i(26172);
          ContactLabelEditUI.b(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.c(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.f(ContactLabelEditUI.this).xR(false);
          AppMethodBeat.o(26172);
        }
        
        public final void xO(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(26173);
          if ((!ContactLabelEditUI.g(ContactLabelEditUI.this)) && (ContactLabelEditUI.h(ContactLabelEditUI.this)))
          {
            ContactLabelEditUI.this.enableOptionMenu(false);
            ContactLabelEditUI.i(ContactLabelEditUI.this);
            AppMethodBeat.o(26173);
            return;
          }
          ContactLabelEditUI.this.enableOptionMenu(paramAnonymousBoolean);
          AppMethodBeat.o(26173);
        }
      };
      this.JUT.setText(this.JUs);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(6001);
      }
      if (!this.JUy) {
        break label611;
      }
      if ((this.JUA == null) || (this.JUA.size() <= 0)) {
        break label594;
      }
      this.JUS.y(null, this.JUA);
    }
    for (;;)
    {
      if (getListView() != null) {
        getListView().setOnScrollListener(new AbsListView.OnScrollListener()
        {
          public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
          {
            AppMethodBeat.i(26176);
            if ((paramAnonymousInt == 2) || (paramAnonymousInt == 1)) {
              ContactLabelEditUI.this.hideVKB();
            }
            AppMethodBeat.o(26176);
          }
        });
      }
      this.JUU = this.JUR.bAi("contact_label_delete");
      this.JUV = ((PreferenceTitleCategory)this.JUR.bAi("contact_label_empty_category"));
      if (!this.JUy) {
        break label629;
      }
      this.JUR.e(this.JUU);
      this.JUR.e(this.JUV);
      AppMethodBeat.o(26183);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3) });
      break;
      label561:
      this.JUy = false;
      this.JUu = com.tencent.mm.plugin.label.d.fTa().bxn(this.JUt);
      this.JUx = getString(R.l.gRz);
      break label73;
      label594:
      this.JUS.bW(new ArrayList());
      continue;
      label611:
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26174);
          ArrayList localArrayList = com.tencent.mm.plugin.label.d.fTa().bxk(ContactLabelEditUI.j(ContactLabelEditUI.this));
          if (localArrayList == null)
          {
            Log.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
            AppMethodBeat.o(26174);
            return;
          }
          if (localArrayList != null)
          {
            ContactLabelEditUI.a(ContactLabelEditUI.this, localArrayList);
            if (ContactLabelEditUI.k(ContactLabelEditUI.this) != null) {
              break label119;
            }
            ContactLabelEditUI.b(ContactLabelEditUI.this, new ArrayList());
          }
          for (;;)
          {
            ContactLabelEditUI.k(ContactLabelEditUI.this).addAll(localArrayList);
            if (ContactLabelEditUI.l(ContactLabelEditUI.this) != null) {
              ContactLabelEditUI.l(ContactLabelEditUI.this).sendEmptyMessage(6001);
            }
            AppMethodBeat.o(26174);
            return;
            label119:
            ContactLabelEditUI.k(ContactLabelEditUI.this).clear();
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(26175);
          String str = super.toString() + "|initView";
          AppMethodBeat.o(26175);
          return str;
        }
      });
    }
    label629:
    if (!this.JUw) {
      this.JUR.e(this.JUU);
    }
    AppMethodBeat.o(26183);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26184);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(26184);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26184);
      return;
      String str = paramIntent.getStringExtra("Select_Contact");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[] { String.valueOf(str) });
      if (!Util.isNullOrNil(str))
      {
        paramIntent = Util.stringsToList(str.split(","));
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramInt2 = paramIntent.size();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            str = (String)paramIntent.get(paramInt1);
            if (!Util.isNullOrNil(str))
            {
              if ((!ab.IR(str)) || (this.JUA.contains(str)) || (str.equals(this.JUF))) {
                break label312;
              }
              this.JUA.add(str);
              if ((this.JUB != null) && (!this.JUB.contains(paramIntent.get(paramInt1)))) {
                this.JUC.add(str);
              }
              if (bool) {
                this.JUD.add(str);
              }
              if ((this.JUE != null) && (this.JUE.contains(str))) {
                this.JUE.remove(str);
              }
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              label312:
              Log.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
            }
          }
        }
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(6001);
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26196);
    if (((!Util.isNullOrNil(this.JUs)) && (!this.JUs.equals(this.JUr))) || ((this.JUC != null) && (this.JUC.size() > 0)) || ((this.JUE != null) && (this.JUE.size() > 0)))
    {
      k.b(this, getString(R.l.save_label_msg), "", getString(R.l.gvW), getString(R.l.gvX), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26164);
          ContactLabelEditUI.b(ContactLabelEditUI.this);
          AppMethodBeat.o(26164);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26165);
          ContactLabelEditUI.this.setResult(0);
          ContactLabelEditUI.this.finish();
          AppMethodBeat.o(26165);
        }
      });
      AppMethodBeat.o(26196);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(26196);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26179);
    super.onCreate(paramBundle);
    this.JUF = z.bAM();
    this.JUt = getIntent().getStringExtra("label_id");
    this.JUr = getIntent().getStringExtra("label_name");
    this.JUs = getIntent().getStringExtra("label_name");
    this.JUv = getIntent().getBooleanExtra("Is_Chatroom", false);
    boolean bool;
    label136:
    int i;
    label219:
    String str;
    if (getIntent().getIntExtra("last_page_source_type", 0) == 1)
    {
      bool = true;
      this.JUQ = bool;
      this.JUG = getIntent().getStringExtra("label_source");
      if ((this.JUG == null) || (!this.JUG.equals("label_source_Address"))) {
        break label326;
      }
      bool = true;
      this.JUH = bool;
      this.JUw = getIntent().getBooleanExtra("is_show_delete", true);
      paramBundle = getIntent().getStringExtra("Select_Contact");
      if (Util.isNullOrNil(paramBundle)) {
        break label352;
      }
      paramBundle = Util.stringsToList(paramBundle.split(","));
      this.JUA = new ArrayList();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label352;
      }
      int j = paramBundle.size();
      i = 0;
      if (i >= j) {
        break label352;
      }
      str = (String)paramBundle.get(i);
      if (!Util.isNullOrNil(str))
      {
        if ((!ab.IR(str)) || (this.JUA.contains(str)) || (str.equals(this.JUF))) {
          break label332;
        }
        this.JUA.add(str);
        this.JUC.add(str);
        if (this.JUv) {
          this.JUD.add(str);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label219;
      bool = false;
      break;
      label326:
      bool = false;
      break label136;
      label332:
      Log.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
    }
    label352:
    bh.aZW().a(635, this);
    bh.aZW().a(637, this);
    bh.aZW().a(638, this);
    initView();
    AppMethodBeat.o(26179);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26182);
    bh.aZW().b(635, this);
    bh.aZW().b(637, this);
    bh.aZW().b(638, this);
    super.onDestroy();
    AppMethodBeat.o(26182);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26181);
    com.tencent.mm.modelstat.d.d(4, "ContactLabelEditUI" + getIdentString(), hashCode());
    bh.aZW().b(636, this);
    super.onPause();
    AppMethodBeat.o(26181);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26185);
    paramf = paramPreference.mKey;
    if (Util.isNullOrNil(paramf))
    {
      Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
      AppMethodBeat.o(26185);
      return false;
    }
    if (paramf.equals("contact_label_delete")) {
      k.a(this, getString(R.l.gMf), "", getString(R.l.gMe), getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26177);
          ContactLabelEditUI.m(ContactLabelEditUI.this);
          AppMethodBeat.o(26177);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, a.c.red_text_color);
    }
    Log.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[] { paramf });
    AppMethodBeat.o(26185);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26180);
    com.tencent.mm.modelstat.d.d(3, "ContactLabelEditUI" + getIdentString(), hashCode());
    bh.aZW().a(636, this);
    updateTitle(this.JUs);
    fTk();
    super.onResume();
    AppMethodBeat.o(26180);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(26186);
    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.label.b.a)paramp).fTc().YFs;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (dgk)paramString.get(0);
          Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[] { paramString.aaLB, paramString.aaLA });
          this.JUt = paramString.aaLB;
          fTh();
          AppMethodBeat.o(26186);
          return;
        }
        fTg();
        AppMethodBeat.o(26186);
        return;
      }
      fTg();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.JUt;
        String str = this.JUs;
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
        try
        {
          paramInt1 = Integer.valueOf(paramString).intValue();
          if (paramInt1 != -1)
          {
            paramp = com.tencent.mm.plugin.label.d.fTa().bxn(paramString);
            paramString = paramp;
            if (paramp == null) {
              paramString = new aw();
            }
            paramString.field_labelID = paramInt1;
            paramString.field_labelName = str;
            paramString.field_labelPYFull = com.tencent.mm.platformtools.f.RZ(str);
            paramString.field_labelPYShort = com.tencent.mm.platformtools.f.Sa(str);
            com.tencent.mm.plugin.label.d.fTa().b(paramString, new String[] { "labelID" });
            fTh();
            AppMethodBeat.o(26186);
            return;
          }
        }
        catch (Exception paramp)
        {
          for (;;)
          {
            Log.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[] { String.valueOf(paramString) });
            paramInt1 = -1;
            continue;
            fTg();
          }
        }
      }
      fTg();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        fTf();
        if (this.mHandler != null)
        {
          this.mHandler.sendEmptyMessageDelayed(6002, 300L);
          AppMethodBeat.o(26186);
        }
      }
      else
      {
        fTg();
        AppMethodBeat.o(26186);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(this.JUu);
          if (this.mHandler != null)
          {
            this.mHandler.sendEmptyMessageDelayed(6002, 300L);
            AppMethodBeat.o(26186);
          }
        }
        else
        {
          Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
          fTe();
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI
 * JD-Core Version:    0.7.0.1
 */