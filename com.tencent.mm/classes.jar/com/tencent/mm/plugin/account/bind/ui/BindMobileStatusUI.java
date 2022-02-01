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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class BindMobileStatusUI
  extends MMWizardActivity
{
  private Button hPX;
  private TextView hQd;
  private ImageView kaB;
  private TextView kaU;
  private ImageView kbj;
  private ImageView kbk;
  private Boolean kbl;
  private Boolean kbm;
  private RelativeLayout kbn;
  private RelativeLayout kbo;
  private BindWordingContent kbp;
  private int kbq;
  private boolean kbr;
  private boolean kbs;
  @SuppressLint({"UseSparseArrays"})
  private HashMap<Integer, Integer> kbt;
  private SparseArray<String> kbu;
  private SharedPreferences sp;
  private int status;
  
  public BindMobileStatusUI()
  {
    AppMethodBeat.i(109926);
    this.kbl = Boolean.TRUE;
    this.kbm = Boolean.TRUE;
    this.kbt = new HashMap();
    this.kbu = new SparseArray(3);
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
      i = z.aUc();
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
      g.aAh().azQ().set(7, Integer.valueOf(i));
      paramContext = new bfx();
      paramContext.LPB = 8;
      if (!paramBoolean2) {
        break label292;
      }
      i = 1;
      label164:
      paramContext.BsD = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, paramContext));
      localObject = new bfx();
      ((bfx)localObject).LPB = 7;
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
      paramContext.BsD = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
      com.tencent.mm.plugin.account.a.a.jRu.WZ();
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
  
  private boolean d(boolean paramBoolean, int paramInt1, int paramInt2)
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
      this.kbt.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      str = (String)this.kbu.get(paramInt2);
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
    return 2131493220;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(109930);
    this.kaB = ((ImageView)findViewById(2131297395));
    this.hQd = ((TextView)findViewById(2131297393));
    this.kaU = ((TextView)findViewById(2131297392));
    this.hPX = ((Button)findViewById(2131297394));
    this.kbj = ((ImageView)findViewById(2131297422));
    this.kbk = ((ImageView)findViewById(2131297421));
    this.kbn = ((RelativeLayout)findViewById(2131297389));
    this.kbo = ((RelativeLayout)findViewById(2131297390));
    switch (this.kbq)
    {
    default: 
      if (this.kbp != null) {}
      switch (this.kbp.jiW.intValue())
      {
      case 0: 
      case 1: 
      default: 
        label192:
        this.hPX.setVisibility(8);
        addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(109922);
            BindMobileStatusUI.a(BindMobileStatusUI.this);
            AppMethodBeat.o(109922);
            return false;
          }
        });
        if ((com.tencent.mm.plugin.account.friend.a.l.bnZ() == l.a.keL) || (com.tencent.mm.plugin.account.friend.a.l.bnZ() == l.a.keM))
        {
          this.kaB.setImageResource(2131231229);
          String str = (String)g.aAh().azQ().get(6, null);
          if ((str == null) || (str.equals(""))) {
            g.aAh().azQ().get(4097, null);
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      this.kbj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(109923);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = BindMobileStatusUI.this;
          if (!BindMobileStatusUI.b(BindMobileStatusUI.this).booleanValue())
          {
            bool1 = true;
            BindMobileStatusUI.a(paramAnonymousView, Boolean.valueOf(bool1));
            if (!BindMobileStatusUI.b(BindMobileStatusUI.this).booleanValue()) {
              break label147;
            }
            BindMobileStatusUI.c(BindMobileStatusUI.this).setImageResource(2131689951);
            label93:
            paramAnonymousView = BindMobileStatusUI.this;
            if (BindMobileStatusUI.b(BindMobileStatusUI.this).booleanValue()) {
              break label162;
            }
          }
          label147:
          label162:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            BindMobileStatusUI.a(paramAnonymousView, bool1, 512, 8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109923);
            return;
            bool1 = false;
            break;
            BindMobileStatusUI.c(BindMobileStatusUI.this).setImageResource(2131231825);
            break label93;
          }
        }
      });
      this.kbk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(109924);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = BindMobileStatusUI.this;
          if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue())
          {
            bool1 = true;
            BindMobileStatusUI.b(paramAnonymousView, Boolean.valueOf(bool1));
            if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              break label173;
            }
            BindMobileStatusUI.e(BindMobileStatusUI.this).setImageResource(2131689951);
            label93:
            paramAnonymousView = BindMobileStatusUI.this;
            if (BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              break label188;
            }
          }
          label173:
          label188:
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
            BindMobileStatusUI.e(BindMobileStatusUI.this).setImageResource(2131231825);
            break label93;
          }
        }
      });
      this.hPX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109925);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          BindMobileStatusUI.f(BindMobileStatusUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileStatusUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109925);
        }
      });
      AppMethodBeat.o(109930);
      return;
      this.kbn.setVisibility(8);
      this.kbo.setVisibility(8);
      if (!this.kbr)
      {
        bool1 = true;
        label372:
        d(bool1, 512, 8);
        if (this.kbs) {
          break label411;
        }
      }
      label411:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        d(bool1, 256, 7);
        break;
        bool1 = false;
        break label372;
      }
      this.kbn.setVisibility(0);
      this.kbn.setBackgroundResource(2131231233);
      this.kbo.setVisibility(8);
      break;
      this.kaU.setVisibility(8);
      break label192;
      this.kaB.setImageResource(2131231226);
      this.kaU.setVisibility(8);
      this.hQd.setText(getString(2131756583));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109927);
    super.onCreate(paramBundle);
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.status = z.aUc();
    this.kbu.put(8, "settings_find_me_by_mobile");
    this.kbu.put(7, "settings_recommend_mobilefriends_to_me");
    this.kbu.put(32, "settings_autoadd_mobilefriends");
    d(false, 512, 8);
    d(false, 256, 7);
    setMMTitle(2131756624);
    this.kbp = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.kbq = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.kbr = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.kbs = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    initView();
    AppMethodBeat.o(109927);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109931);
    if (paramInt == 4)
    {
      ala(1);
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
    g.aAh().azQ().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.kbt.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new bfx();
      ((bfx)localObject).LPB = i;
      ((bfx)localObject).BsD = j;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
      Log.d("MicroMsg.BindMobileStatusUI", "switch  " + i + " " + j);
    }
    this.kbt.clear();
    super.onPause();
    AppMethodBeat.o(109928);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI
 * JD-Core Version:    0.7.0.1
 */