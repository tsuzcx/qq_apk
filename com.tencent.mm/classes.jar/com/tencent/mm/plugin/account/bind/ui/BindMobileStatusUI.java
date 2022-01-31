package com.tencent.mm.plugin.account.bind.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class BindMobileStatusUI
  extends MMWizardActivity
{
  private SharedPreferences dnD;
  private TextView fbN;
  private Button fbO;
  private ImageView fbt;
  private TextView fck;
  private ImageView fcl;
  private ImageView fcm;
  private Boolean fcn = Boolean.valueOf(true);
  private Boolean fco = Boolean.valueOf(true);
  private RelativeLayout fcp;
  private RelativeLayout fcq;
  private BindWordingContent fcr;
  private int fcs;
  private boolean fct;
  private boolean fcu;
  @SuppressLint({"UseSparseArrays"})
  private HashMap<Integer, Integer> fcv = new HashMap();
  private SparseArray<String> fcw = new SparseArray(3);
  private int status;
  
  private boolean a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    label59:
    String str;
    Boolean localBoolean;
    if (paramBoolean)
    {
      this.status |= paramInt1;
      if (!paramBoolean) {
        break label182;
      }
      paramInt1 = 1;
      this.fcv.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      str = (String)this.fcw.get(paramInt2);
      if ((this.dnD != null) && (str != null) && (str.length() > 0))
      {
        localBoolean = Boolean.valueOf(paramBoolean);
        if ((paramInt2 == 8) || (paramInt2 == 7)) {
          if (paramBoolean) {
            break label187;
          }
        }
      }
    }
    label182:
    label187:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localBoolean = Boolean.valueOf(paramBoolean);
      this.dnD.edit().putBoolean(str, localBoolean.booleanValue()).commit();
      return true;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
      paramInt1 = 2;
      break label59;
    }
  }
  
  public static void c(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    int j = 1;
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
      i = q.Gn();
      if (!paramBoolean1) {
        break label264;
      }
      i |= 0x200;
      label114:
      if (!paramBoolean2) {
        break label273;
      }
      i |= 0x100;
      label124:
      g.DP().Dz().o(7, Integer.valueOf(i));
      paramContext = new zr();
      paramContext.sYS = 8;
      if (!paramBoolean2) {
        break label282;
      }
      i = 1;
      label159:
      paramContext.nfn = i;
      ((j)g.r(j.class)).Fv().b(new i.a(23, paramContext));
      localObject = new zr();
      ((zr)localObject).sYS = 7;
      if (!paramBoolean1) {
        break label287;
      }
    }
    label264:
    label273:
    label282:
    label287:
    for (int i = j;; i = 2)
    {
      paramContext.nfn = i;
      ((j)g.r(j.class)).Fv().b(new i.a(23, (com.tencent.mm.bv.a)localObject));
      com.tencent.mm.plugin.account.a.a.eUS.tk();
      return;
      bool1 = false;
      break;
      i &= 0xFFFFFDFF;
      break label114;
      i &= 0xFFFFFEFF;
      break label124;
      i = 2;
      break label159;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.f.bind_mobile_status;
  }
  
  protected final void initView()
  {
    boolean bool2 = true;
    this.fbt = ((ImageView)findViewById(a.e.bind_m_contact_status_state_icon));
    this.fck = ((TextView)findViewById(a.e.bind_m_contact_status_bind_state_title));
    this.fbN = ((TextView)findViewById(a.e.bind_m_contact_status_bind_state_hint));
    this.fbO = ((Button)findViewById(a.e.bind_m_contact_status_ok_btn));
    this.fcl = ((ImageView)findViewById(a.e.bind_setttings_find_me_by_mobile));
    this.fcm = ((ImageView)findViewById(a.e.bind_settings_recommend_friends_with_contacts));
    this.fcp = ((RelativeLayout)findViewById(a.e.bind_m_contact_status_RL));
    this.fcq = ((RelativeLayout)findViewById(a.e.bind_m_contact_status_RL1));
    switch (this.fcs)
    {
    default: 
      if (this.fcr != null) {}
      switch (this.fcr.boJ.intValue())
      {
      case 0: 
      case 1: 
      default: 
        label184:
        this.fbO.setVisibility(8);
        addTextOptionMenu(0, getString(a.i.app_finish), new BindMobileStatusUI.1(this));
        if ((com.tencent.mm.plugin.account.friend.a.l.WP() == l.a.ffT) || (com.tencent.mm.plugin.account.friend.a.l.WP() == l.a.ffU))
        {
          this.fbt.setImageResource(a.d.bind_mcontact_success);
          String str = (String)g.DP().Dz().get(6, null);
          if ((str == null) || (str.equals(""))) {
            g.DP().Dz().get(4097, null);
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      this.fcl.setOnClickListener(new BindMobileStatusUI.2(this));
      this.fcm.setOnClickListener(new BindMobileStatusUI.3(this));
      this.fbO.setOnClickListener(new BindMobileStatusUI.4(this));
      return;
      this.fcp.setVisibility(8);
      this.fcq.setVisibility(8);
      if (!this.fct)
      {
        bool1 = true;
        label358:
        a(bool1, 512, 8);
        if (this.fcu) {
          break label397;
        }
      }
      label397:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        a(bool1, 256, 7);
        break;
        bool1 = false;
        break label358;
      }
      this.fcp.setVisibility(0);
      this.fcp.setBackgroundResource(a.d.bind_preference_one_item);
      this.fcq.setVisibility(8);
      break;
      this.fbN.setVisibility(8);
      break label184;
      this.fbt.setImageResource(a.d.bind_mcontact_error);
      this.fbN.setVisibility(8);
      this.fck.setText(getString(a.i.bind_mcontact_bind_error));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.status = q.Gn();
    this.fcw.put(8, "settings_find_me_by_mobile");
    this.fcw.put(7, "settings_recommend_mobilefriends_to_me");
    this.fcw.put(32, "settings_autoadd_mobilefriends");
    a(false, 512, 8);
    a(false, 256, 7);
    setMMTitle(a.i.bind_mcontact_title_bind_finish);
    this.fcr = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.fcs = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.fct = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.fcu = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      FW(1);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    g.DP().Dz().o(7, Integer.valueOf(this.status));
    Iterator localIterator = this.fcv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new zr();
      ((zr)localObject).sYS = i;
      ((zr)localObject).nfn = j;
      ((j)g.r(j.class)).Fv().b(new i.a(23, (com.tencent.mm.bv.a)localObject));
      y.d("MicroMsg.BindMobileStatusUI", "switch  " + i + " " + j);
    }
    this.fcv.clear();
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI
 * JD-Core Version:    0.7.0.1
 */