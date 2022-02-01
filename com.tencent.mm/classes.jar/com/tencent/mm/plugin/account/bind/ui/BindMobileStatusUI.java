package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class BindMobileStatusUI
  extends MMWizardActivity
{
  private Button nhC;
  private TextView nhK;
  private ImageView pOB;
  private TextView pOT;
  private ImageView pPo;
  private ImageView pPp;
  private Boolean pPq;
  private Boolean pPr;
  private RelativeLayout pPs;
  private RelativeLayout pPt;
  private BindWordingContent pPu;
  private int pPv;
  private boolean pPw;
  private boolean pPx;
  private HashMap<Integer, Integer> pPy;
  private SparseArray<String> pPz;
  private SharedPreferences sp;
  private int status;
  
  public BindMobileStatusUI()
  {
    AppMethodBeat.i(109926);
    this.pPq = Boolean.TRUE;
    this.pPr = Boolean.TRUE;
    this.pPy = new HashMap();
    this.pPz = new SparseArray(3);
    AppMethodBeat.o(109926);
  }
  
  public static void c(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    int j = 1;
    AppMethodBeat.i(109932);
    paramContext = paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0);
    Object localObject = paramContext.edit();
    boolean bool1;
    if (!paramBoolean1)
    {
      bool1 = true;
      ((SharedPreferences.Editor)localObject).putBoolean("settings_find_me_by_mobile", bool1).commit();
      paramContext = paramContext.edit();
      bool1 = bool2;
      if (!paramBoolean2) {
        bool1 = true;
      }
      paramContext.putBoolean("settings_recommend_mobilefriends_to_me", bool1).commit();
      i = z.bAQ();
      if (!paramBoolean1) {
        break label274;
      }
      i |= 0x200;
      label119:
      if (!paramBoolean2) {
        break label283;
      }
      i |= 0x100;
      label129:
      h.baE().ban().B(7, Integer.valueOf(i));
      paramContext = new cas();
      paramContext.aajJ = 8;
      if (!paramBoolean2) {
        break label292;
      }
      i = 1;
      label164:
      paramContext.NkL = i;
      ((n)h.ax(n.class)).bzz().d(new k.a(23, paramContext));
      localObject = new cas();
      ((cas)localObject).aajJ = 7;
      if (!paramBoolean1) {
        break label297;
      }
    }
    label274:
    label283:
    label292:
    label297:
    for (int i = j;; i = 2)
    {
      paramContext.NkL = i;
      ((n)h.ax(n.class)).bzz().d(new k.a(23, (com.tencent.mm.bx.a)localObject));
      com.tencent.mm.plugin.account.sdk.a.pFo.aDx();
      AppMethodBeat.o(109932);
      return;
      bool1 = false;
      break;
      i &= 0xFFFFFDFF;
      break label119;
      i &= 0xFFFFFEFF;
      break label129;
      i = 2;
      break label164;
    }
  }
  
  private boolean f(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109929);
    Log.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    label64:
    String str;
    Boolean localBoolean;
    if (paramBoolean)
    {
      this.status |= paramInt1;
      if (!paramBoolean) {
        break label192;
      }
      paramInt1 = 1;
      this.pPy.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      str = (String)this.pPz.get(paramInt2);
      if ((this.sp != null) && (str != null) && (str.length() > 0))
      {
        localBoolean = Boolean.valueOf(paramBoolean);
        if ((paramInt2 == 8) || (paramInt2 == 7)) {
          if (paramBoolean) {
            break label197;
          }
        }
      }
    }
    label192:
    label197:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localBoolean = Boolean.valueOf(paramBoolean);
      this.sp.edit().putBoolean(str, localBoolean.booleanValue()).commit();
      AppMethodBeat.o(109929);
      return true;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
      paramInt1 = 2;
      break label64;
    }
  }
  
  public int getLayoutId()
  {
    return a.f.bind_mobile_status;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(109930);
    this.pOB = ((ImageView)findViewById(a.e.bind_m_contact_status_state_icon));
    this.nhK = ((TextView)findViewById(a.e.bind_m_contact_status_bind_state_title));
    this.pOT = ((TextView)findViewById(a.e.bind_m_contact_status_bind_state_hint));
    this.nhC = ((Button)findViewById(a.e.bind_m_contact_status_ok_btn));
    this.pPo = ((ImageView)findViewById(a.e.bind_setttings_find_me_by_mobile));
    this.pPp = ((ImageView)findViewById(a.e.bind_settings_recommend_friends_with_contacts));
    this.pPs = ((RelativeLayout)findViewById(a.e.bind_m_contact_status_RL));
    this.pPt = ((RelativeLayout)findViewById(a.e.bind_m_contact_status_RL1));
    switch (this.pPv)
    {
    default: 
      if (this.pPu != null) {}
      switch (this.pPu.type.intValue())
      {
      case 0: 
      case 1: 
      default: 
        label192:
        this.nhC.setVisibility(8);
        addTextOptionMenu(0, getString(a.i.app_finish), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(109922);
            BindMobileStatusUI.a(BindMobileStatusUI.this);
            AppMethodBeat.o(109922);
            return false;
          }
        });
        if ((i.bWW() == i.a.pSQ) || (i.bWW() == i.a.pSR))
        {
          this.pOB.setImageResource(a.d.bind_mcontact_success);
          String str = (String)h.baE().ban().d(6, null);
          if ((str == null) || (str.equals(""))) {
            h.baE().ban().d(4097, null);
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      this.pPo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(109923);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = BindMobileStatusUI.this;
          if (!BindMobileStatusUI.b(BindMobileStatusUI.this).booleanValue())
          {
            bool1 = true;
            BindMobileStatusUI.a(paramAnonymousView, Boolean.valueOf(bool1));
            if (!BindMobileStatusUI.b(BindMobileStatusUI.this).booleanValue()) {
              break label148;
            }
            BindMobileStatusUI.c(BindMobileStatusUI.this).setImageResource(a.h.checkbox_selected);
            label94:
            paramAnonymousView = BindMobileStatusUI.this;
            if (BindMobileStatusUI.b(BindMobileStatusUI.this).booleanValue()) {
              break label164;
            }
          }
          label148:
          label164:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            BindMobileStatusUI.a(paramAnonymousView, bool1, 512, 8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109923);
            return;
            bool1 = false;
            break;
            BindMobileStatusUI.c(BindMobileStatusUI.this).setImageResource(a.d.checkbox_unselected);
            break label94;
          }
        }
      });
      this.pPp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(109924);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = BindMobileStatusUI.this;
          if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue())
          {
            bool1 = true;
            BindMobileStatusUI.b(paramAnonymousView, Boolean.valueOf(bool1));
            if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              break label174;
            }
            BindMobileStatusUI.e(BindMobileStatusUI.this).setImageResource(a.h.checkbox_selected);
            label94:
            paramAnonymousView = BindMobileStatusUI.this;
            if (BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              break label190;
            }
          }
          label174:
          label190:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            BindMobileStatusUI.a(paramAnonymousView, bool1, 256, 7);
            if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              BindMobileStatusUI.a(BindMobileStatusUI.this, false, 2097152, 32);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109924);
            return;
            bool1 = false;
            break;
            BindMobileStatusUI.e(BindMobileStatusUI.this).setImageResource(a.d.checkbox_unselected);
            break label94;
          }
        }
      });
      this.nhC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109925);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          BindMobileStatusUI.f(BindMobileStatusUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109925);
        }
      });
      AppMethodBeat.o(109930);
      return;
      this.pPs.setVisibility(8);
      this.pPt.setVisibility(8);
      if (!this.pPw)
      {
        bool1 = true;
        label372:
        f(bool1, 512, 8);
        if (this.pPx) {
          break label411;
        }
      }
      label411:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        f(bool1, 256, 7);
        break;
        bool1 = false;
        break label372;
      }
      this.pPs.setVisibility(0);
      this.pPs.setBackgroundResource(a.d.bind_preference_one_item);
      this.pPt.setVisibility(8);
      break;
      this.pOT.setVisibility(8);
      break label192;
      this.pOB.setImageResource(a.d.bind_mcontact_error);
      this.pOT.setVisibility(8);
      this.nhK.setText(getString(a.i.bind_mcontact_bind_error));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109927);
    super.onCreate(paramBundle);
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.status = z.bAQ();
    this.pPz.put(8, "settings_find_me_by_mobile");
    this.pPz.put(7, "settings_recommend_mobilefriends_to_me");
    this.pPz.put(32, "settings_autoadd_mobilefriends");
    f(false, 512, 8);
    f(false, 256, 7);
    setMMTitle(a.i.bind_mcontact_title_bind_finish);
    this.pPu = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.pPv = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.pPw = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.pPx = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    initView();
    AppMethodBeat.o(109927);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109931);
    if (paramInt == 4)
    {
      aAp(1);
      AppMethodBeat.o(109931);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109931);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109928);
    h.baE().ban().B(7, Integer.valueOf(this.status));
    Iterator localIterator = this.pPy.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new cas();
      ((cas)localObject).aajJ = i;
      ((cas)localObject).NkL = j;
      ((n)h.ax(n.class)).bzz().d(new k.a(23, (com.tencent.mm.bx.a)localObject));
      Log.d("MicroMsg.BindMobileStatusUI", "switch  " + i + " " + j);
    }
    this.pPy.clear();
    super.onPause();
    AppMethodBeat.o(109928);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI
 * JD-Core Version:    0.7.0.1
 */