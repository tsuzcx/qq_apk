package com.tencent.mm.plugin.account.bind.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class BindMobileStatusUI
  extends MMWizardActivity
{
  private Button gAJ;
  private TextView gAP;
  private TextView iGP;
  private ImageView iGw;
  private ImageView iHe;
  private ImageView iHf;
  private Boolean iHg;
  private Boolean iHh;
  private RelativeLayout iHi;
  private RelativeLayout iHj;
  private BindWordingContent iHk;
  private int iHl;
  private boolean iHm;
  private boolean iHn;
  @SuppressLint({"UseSparseArrays"})
  private HashMap<Integer, Integer> iHo;
  private SparseArray<String> iHp;
  private SharedPreferences sp;
  private int status;
  
  public BindMobileStatusUI()
  {
    AppMethodBeat.i(109926);
    this.iHg = Boolean.TRUE;
    this.iHh = Boolean.TRUE;
    this.iHo = new HashMap();
    this.iHp = new SparseArray(3);
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
      i = u.axA();
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
      g.agR().agA().set(7, Integer.valueOf(i));
      paramContext = new aqc();
      paramContext.EIY = 8;
      if (!paramBoolean2) {
        break label292;
      }
      i = 1;
      label164:
      paramContext.vVH = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(23, paramContext));
      localObject = new aqc();
      ((aqc)localObject).EIY = 7;
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
      paramContext.vVH = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(23, (com.tencent.mm.bw.a)localObject));
      com.tencent.mm.plugin.account.a.a.iyy.Lj();
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
  
  private boolean c(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109929);
    ac.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
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
      this.iHo.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      str = (String)this.iHp.get(paramInt2);
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
    return 2131493174;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(109930);
    this.iGw = ((ImageView)findViewById(2131297240));
    this.gAP = ((TextView)findViewById(2131297238));
    this.iGP = ((TextView)findViewById(2131297237));
    this.gAJ = ((Button)findViewById(2131297239));
    this.iHe = ((ImageView)findViewById(2131297266));
    this.iHf = ((ImageView)findViewById(2131297265));
    this.iHi = ((RelativeLayout)findViewById(2131297234));
    this.iHj = ((RelativeLayout)findViewById(2131297235));
    switch (this.iHl)
    {
    default: 
      if (this.iHk != null) {}
      switch (this.iHk.hRH.intValue())
      {
      case 0: 
      case 1: 
      default: 
        label192:
        this.gAJ.setVisibility(8);
        addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(109922);
            BindMobileStatusUI.a(BindMobileStatusUI.this);
            AppMethodBeat.o(109922);
            return false;
          }
        });
        if ((l.aPC() == l.a.iKF) || (l.aPC() == l.a.iKG))
        {
          this.iGw.setImageResource(2131231178);
          String str = (String)g.agR().agA().get(6, null);
          if ((str == null) || (str.equals(""))) {
            g.agR().agA().get(4097, null);
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      this.iHe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(109923);
          paramAnonymousView = BindMobileStatusUI.this;
          if (!BindMobileStatusUI.b(BindMobileStatusUI.this).booleanValue())
          {
            bool1 = true;
            BindMobileStatusUI.a(paramAnonymousView, Boolean.valueOf(bool1));
            if (!BindMobileStatusUI.b(BindMobileStatusUI.this).booleanValue()) {
              break label103;
            }
            BindMobileStatusUI.c(BindMobileStatusUI.this).setImageResource(2131689936);
            label61:
            paramAnonymousView = BindMobileStatusUI.this;
            if (BindMobileStatusUI.b(BindMobileStatusUI.this).booleanValue()) {
              break label118;
            }
          }
          label103:
          label118:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            BindMobileStatusUI.a(paramAnonymousView, bool1, 512, 8);
            AppMethodBeat.o(109923);
            return;
            bool1 = false;
            break;
            BindMobileStatusUI.c(BindMobileStatusUI.this).setImageResource(2131231750);
            break label61;
          }
        }
      });
      this.iHf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(109924);
          paramAnonymousView = BindMobileStatusUI.this;
          if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue())
          {
            bool1 = true;
            BindMobileStatusUI.b(paramAnonymousView, Boolean.valueOf(bool1));
            if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              break label129;
            }
            BindMobileStatusUI.e(BindMobileStatusUI.this).setImageResource(2131689936);
            label61:
            paramAnonymousView = BindMobileStatusUI.this;
            if (BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              break label144;
            }
          }
          label129:
          label144:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            BindMobileStatusUI.a(paramAnonymousView, bool1, 256, 7);
            if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              BindMobileStatusUI.a(BindMobileStatusUI.this, false, 2097152, 32);
            }
            AppMethodBeat.o(109924);
            return;
            bool1 = false;
            break;
            BindMobileStatusUI.e(BindMobileStatusUI.this).setImageResource(2131231750);
            break label61;
          }
        }
      });
      this.gAJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109925);
          BindMobileStatusUI.f(BindMobileStatusUI.this);
          AppMethodBeat.o(109925);
        }
      });
      AppMethodBeat.o(109930);
      return;
      this.iHi.setVisibility(8);
      this.iHj.setVisibility(8);
      if (!this.iHm)
      {
        bool1 = true;
        label372:
        c(bool1, 512, 8);
        if (this.iHn) {
          break label411;
        }
      }
      label411:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        c(bool1, 256, 7);
        break;
        bool1 = false;
        break label372;
      }
      this.iHi.setVisibility(0);
      this.iHi.setBackgroundResource(2131231182);
      this.iHj.setVisibility(8);
      break;
      this.iGP.setVisibility(8);
      break label192;
      this.iGw.setImageResource(2131231175);
      this.iGP.setVisibility(8);
      this.gAP.setText(getString(2131756447));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109927);
    super.onCreate(paramBundle);
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.status = u.axA();
    this.iHp.put(8, "settings_find_me_by_mobile");
    this.iHp.put(7, "settings_recommend_mobilefriends_to_me");
    this.iHp.put(32, "settings_autoadd_mobilefriends");
    c(false, 512, 8);
    c(false, 256, 7);
    setMMTitle(2131756488);
    this.iHk = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.iHl = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.iHm = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.iHn = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    initView();
    AppMethodBeat.o(109927);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109931);
    if (paramInt == 4)
    {
      ZA(1);
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
    g.agR().agA().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.iHo.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new aqc();
      ((aqc)localObject).EIY = i;
      ((aqc)localObject).vVH = j;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(23, (com.tencent.mm.bw.a)localObject));
      ac.d("MicroMsg.BindMobileStatusUI", "switch  " + i + " " + j);
    }
    this.iHo.clear();
    super.onPause();
    AppMethodBeat.o(109928);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI
 * JD-Core Version:    0.7.0.1
 */