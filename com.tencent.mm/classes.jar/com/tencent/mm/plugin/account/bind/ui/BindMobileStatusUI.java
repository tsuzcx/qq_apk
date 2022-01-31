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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class BindMobileStatusUI
  extends MMWizardActivity
{
  private TextView gtE;
  private Button gtF;
  private TextView gtU;
  private ImageView gtV;
  private ImageView gtW;
  private Boolean gtX;
  private Boolean gtY;
  private RelativeLayout gtZ;
  private ImageView gtl;
  private RelativeLayout gua;
  private BindWordingContent gub;
  private int guc;
  private boolean gud;
  private boolean gue;
  @SuppressLint({"UseSparseArrays"})
  private HashMap<Integer, Integer> guf;
  private SparseArray<String> gug;
  private SharedPreferences sp;
  private int status;
  
  public BindMobileStatusUI()
  {
    AppMethodBeat.i(13499);
    this.gtX = Boolean.TRUE;
    this.gtY = Boolean.TRUE;
    this.guf = new HashMap();
    this.gug = new SparseArray(3);
    AppMethodBeat.o(13499);
  }
  
  public static void c(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    int j = 1;
    AppMethodBeat.i(13505);
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
      i = r.Zr();
      if (!paramBoolean1) {
        break label276;
      }
      i |= 0x200;
      label120:
      if (!paramBoolean2) {
        break label285;
      }
      i |= 0x100;
      label130:
      g.RL().Ru().set(7, Integer.valueOf(i));
      paramContext = new aek();
      paramContext.wXn = 8;
      if (!paramBoolean2) {
        break label294;
      }
      i = 1;
      label165:
      paramContext.pKC = i;
      ((j)g.E(j.class)).Yz().c(new j.a(23, paramContext));
      localObject = new aek();
      ((aek)localObject).wXn = 7;
      if (!paramBoolean1) {
        break label299;
      }
    }
    label276:
    label285:
    label294:
    label299:
    for (int i = j;; i = 2)
    {
      paramContext.pKC = i;
      ((j)g.E(j.class)).Yz().c(new j.a(23, (com.tencent.mm.bv.a)localObject));
      com.tencent.mm.plugin.account.a.a.gmP.BO();
      AppMethodBeat.o(13505);
      return;
      bool1 = false;
      break;
      i &= 0xFFFFFDFF;
      break label120;
      i &= 0xFFFFFEFF;
      break label130;
      i = 2;
      break label165;
    }
  }
  
  private boolean c(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13502);
    ab.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + paramBoolean + " item value = " + paramInt1 + " functionId = " + paramInt2);
    label65:
    String str;
    Boolean localBoolean;
    if (paramBoolean)
    {
      this.status |= paramInt1;
      if (!paramBoolean) {
        break label194;
      }
      paramInt1 = 1;
      this.guf.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      str = (String)this.gug.get(paramInt2);
      if ((this.sp != null) && (str != null) && (str.length() > 0))
      {
        localBoolean = Boolean.valueOf(paramBoolean);
        if ((paramInt2 == 8) || (paramInt2 == 7)) {
          if (paramBoolean) {
            break label199;
          }
        }
      }
    }
    label194:
    label199:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localBoolean = Boolean.valueOf(paramBoolean);
      this.sp.edit().putBoolean(str, localBoolean.booleanValue()).commit();
      AppMethodBeat.o(13502);
      return true;
      this.status &= (paramInt1 ^ 0xFFFFFFFF);
      break;
      paramInt1 = 2;
      break label65;
    }
  }
  
  public int getLayoutId()
  {
    return 2130968842;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(13503);
    this.gtl = ((ImageView)findViewById(2131821776));
    this.gtU = ((TextView)findViewById(2131821777));
    this.gtE = ((TextView)findViewById(2131821778));
    this.gtF = ((Button)findViewById(2131821779));
    this.gtV = ((ImageView)findViewById(2131821781));
    this.gtW = ((ImageView)findViewById(2131821783));
    this.gtZ = ((RelativeLayout)findViewById(2131821780));
    this.gua = ((RelativeLayout)findViewById(2131821782));
    switch (this.guc)
    {
    default: 
      if (this.gub != null) {}
      switch (this.gub.bOw.intValue())
      {
      case 0: 
      case 1: 
      default: 
        label192:
        this.gtF.setVisibility(8);
        addTextOptionMenu(0, getString(2131296964), new BindMobileStatusUI.1(this));
        if ((l.aqq() == l.a.gxB) || (l.aqq() == l.a.gxC))
        {
          this.gtl.setImageResource(2130837904);
          String str = (String)g.RL().Ru().get(6, null);
          if ((str == null) || (str.equals(""))) {
            g.RL().Ru().get(4097, null);
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      this.gtV.setOnClickListener(new BindMobileStatusUI.2(this));
      this.gtW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          AppMethodBeat.i(13497);
          paramAnonymousView = BindMobileStatusUI.this;
          if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue())
          {
            bool1 = true;
            BindMobileStatusUI.b(paramAnonymousView, Boolean.valueOf(bool1));
            if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              break label131;
            }
            BindMobileStatusUI.e(BindMobileStatusUI.this).setImageResource(2131231137);
            label62:
            paramAnonymousView = BindMobileStatusUI.this;
            if (BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              break label146;
            }
          }
          label131:
          label146:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            BindMobileStatusUI.a(paramAnonymousView, bool1, 256, 7);
            if (!BindMobileStatusUI.d(BindMobileStatusUI.this).booleanValue()) {
              BindMobileStatusUI.a(BindMobileStatusUI.this, false, 2097152, 32);
            }
            AppMethodBeat.o(13497);
            return;
            bool1 = false;
            break;
            BindMobileStatusUI.e(BindMobileStatusUI.this).setImageResource(2131231142);
            break label62;
          }
        }
      });
      this.gtF.setOnClickListener(new BindMobileStatusUI.4(this));
      AppMethodBeat.o(13503);
      return;
      this.gtZ.setVisibility(8);
      this.gua.setVisibility(8);
      if (!this.gud)
      {
        bool1 = true;
        label372:
        c(bool1, 512, 8);
        if (this.gue) {
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
      this.gtZ.setVisibility(0);
      this.gtZ.setBackgroundResource(2130837908);
      this.gua.setVisibility(8);
      break;
      this.gtE.setVisibility(8);
      break label192;
      this.gtl.setImageResource(2130837901);
      this.gtE.setVisibility(8);
      this.gtU.setText(getString(2131297555));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13500);
    super.onCreate(paramBundle);
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.status = r.Zr();
    this.gug.put(8, "settings_find_me_by_mobile");
    this.gug.put(7, "settings_recommend_mobilefriends_to_me");
    this.gug.put(32, "settings_autoadd_mobilefriends");
    c(false, 512, 8);
    c(false, 256, 7);
    setMMTitle(2131297596);
    this.gub = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.guc = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.gud = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.gue = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    initView();
    AppMethodBeat.o(13500);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13504);
    if (paramInt == 4)
    {
      Oi(1);
      AppMethodBeat.o(13504);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13504);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13501);
    g.RL().Ru().set(7, Integer.valueOf(this.status));
    Iterator localIterator = this.guf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = new aek();
      ((aek)localObject).wXn = i;
      ((aek)localObject).pKC = j;
      ((j)g.E(j.class)).Yz().c(new j.a(23, (com.tencent.mm.bv.a)localObject));
      ab.d("MicroMsg.BindMobileStatusUI", "switch  " + i + " " + j);
    }
    this.guf.clear();
    super.onPause();
    AppMethodBeat.o(13501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI
 * JD-Core Version:    0.7.0.1
 */