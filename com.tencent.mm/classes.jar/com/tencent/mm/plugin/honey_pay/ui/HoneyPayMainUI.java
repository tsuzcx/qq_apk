package com.tencent.mm.plugin.honey_pay.ui;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.dac;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class HoneyPayMainUI
  extends HoneyPayBaseUI
{
  private Button JCA;
  private TextView JCB;
  private TextView JCC;
  private TextView JCD;
  private LinearLayout JCE;
  private CheckBox JCF;
  private ArrayList<HoneyPayCardLayout> JCG;
  private String JCH;
  private LinearLayout JCx;
  private ImageView JCy;
  private RelativeLayout JCz;
  private boolean tSj;
  private LinearLayout thn;
  
  public HoneyPayMainUI()
  {
    AppMethodBeat.i(64783);
    this.JCG = new ArrayList();
    this.JCH = "";
    this.tSj = false;
    AppMethodBeat.o(64783);
  }
  
  private void aU(Intent paramIntent)
  {
    AppMethodBeat.i(64790);
    boolean bool = paramIntent.getBooleanExtra("key_create_succ", false);
    String str = paramIntent.getStringExtra("key_card_no");
    paramIntent = paramIntent.getStringExtra("key_card_type");
    Log.i(this.TAG, "create succ: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      f(str, true, paramIntent);
      if (this.tSj) {
        h.OAn.b(24522, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      }
    }
    AppMethodBeat.o(64790);
  }
  
  private void f(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(64792);
    Log.i(this.TAG, "go to card manager: %s", new Object[] { paramString1 });
    Intent localIntent = new Intent(this, HoneyPayCardManagerUI.class);
    localIntent.putExtra("key_card_no", paramString1);
    localIntent.putExtra("key_scene", 0);
    localIntent.putExtra("key_is_create", paramBoolean);
    localIntent.putExtra("key_card_type", paramString2);
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(64792);
  }
  
  private void xv(boolean paramBoolean)
  {
    AppMethodBeat.i(64791);
    Log.i(this.TAG, "get payer list");
    f localf = new f();
    localf.r(this);
    doSceneProgress(localf, paramBoolean);
    AppMethodBeat.o(64791);
  }
  
  public int getLayoutId()
  {
    return a.g.honey_pay_main_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64785);
    this.thn = ((LinearLayout)findViewById(a.f.hpmu_content_layout));
    this.JCz = ((RelativeLayout)findViewById(a.f.hpou_empty_header_layout));
    this.JCy = ((ImageView)findViewById(a.f.hpou_empty_header_iv));
    this.JCA = ((Button)findViewById(a.f.hpou_empty_add_friend_btn));
    aw.a(this.JCA.getPaint(), 0.8F);
    this.JCB = ((TextView)findViewById(a.f.hpou_empty_header_tv));
    if (this.JCB != null) {
      i.Q(this.JCB);
    }
    this.JCC = ((TextView)findViewById(a.f.hpou_empty_title_tv));
    if (this.JCC != null) {
      i.Q(this.JCC);
    }
    this.JCE = ((LinearLayout)findViewById(a.f.hpou_agreement_layout));
    this.JCF = ((CheckBox)findViewById(a.f.hpou_agreement_cb));
    this.JCD = ((TextView)findViewById(a.f.hpou_agreement_tv));
    this.JCx = ((LinearLayout)findViewById(a.f.hpou_add_friend_layout));
    this.JCx.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(267365);
        Log.d(HoneyPayMainUI.this.TAG, "click add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        AppMethodBeat.o(267365);
      }
    });
    this.JCA.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(267369);
        Log.i(HoneyPayMainUI.this.TAG, "click empty header add friend");
        if ((HoneyPayMainUI.b(HoneyPayMainUI.this).getVisibility() == 0) && (!HoneyPayMainUI.c(HoneyPayMainUI.this).isChecked()))
        {
          int i = HoneyPayMainUI.this.getResources().getDimensionPixelOffset(a.d.Edge_A);
          paramAnonymousView = ObjectAnimator.ofFloat(HoneyPayMainUI.b(HoneyPayMainUI.this), "translationX", new float[] { 0.0F, -i, i, -i, 0.0F }).setDuration(300L);
          paramAnonymousView.setInterpolator(new LinearInterpolator());
          paramAnonymousView.start();
          HoneyPayMainUI.e(HoneyPayMainUI.this).announceForAccessibility(HoneyPayMainUI.this.getString(a.i.honey_pay_contract_unchecked, new Object[] { HoneyPayMainUI.d(HoneyPayMainUI.this) }));
          AppMethodBeat.o(267369);
          return;
        }
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        AppMethodBeat.o(267369);
      }
    });
    if (aw.isDarkMode())
    {
      this.JCy.setImageResource(a.h.honey_pay_input_logo_dm);
      this.JCF.setBackgroundResource(a.e.honey_agreement_checkbox_bg_dm);
      AppMethodBeat.o(64785);
      return;
    }
    this.JCy.setImageResource(a.h.honey_pay_input_logo);
    this.JCF.setBackgroundResource(a.e.honey_agreement_checkbox_bg);
    AppMethodBeat.o(64785);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64789);
    if (paramInt1 == 3) {
      xv(false);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(64789);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64784);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    addSceneEndListener(2725);
    addSceneEndListener(2618);
    addSceneEndListener(2926);
    aU(getIntent());
    initView();
    xv(true);
    setMMTitle("");
    AppMethodBeat.o(64784);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64786);
    super.onDestroy();
    removeSceneEndListener(2725);
    removeSceneEndListener(2618);
    removeSceneEndListener(2926);
    if (this.tSj) {
      h.OAn.b(24522, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
    }
    AppMethodBeat.o(64786);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(64788);
    Log.i(this.TAG, "on new intent");
    aU(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(64788);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(64787);
    if ((paramp instanceof f))
    {
      paramString = (f)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(64780);
          HoneyPayMainUI.f(HoneyPayMainUI.this);
          HoneyPayMainUI.this.removeAllOptionMenu();
          if (paramString.JAA.aaFF)
          {
            HoneyPayMainUI.a(HoneyPayMainUI.this, true);
            h.OAn.b(24522, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
          }
          while ((paramString.JAA.aaFA == null) || (paramString.JAA.aaFA.isEmpty()))
          {
            Log.i(HoneyPayMainUI.this.TAG, "empty card");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.JAA.aaFB);
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.JAA);
            HoneyPayMainUI.g(HoneyPayMainUI.this).setVisibility(8);
            HoneyPayMainUI.this.GRg = a.c.white;
            HoneyPayMainUI.this.setMMTitle("");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.JAA.ign);
            HoneyPayMainUI.this.fPx();
            HoneyPayMainUI.this.findViewById(a.f.hpou_root_view).setBackgroundResource(HoneyPayMainUI.this.GRg);
            c.a(HoneyPayMainUI.this, paramString.JAA.aaFC, null, 0, null);
            HoneyPayMainUI.this.findViewById(a.f.hpou_block_view).setVisibility(8);
            h.OAn.p(875L, 0L, 1L);
            AppMethodBeat.o(64780);
            return;
            HoneyPayMainUI.a(HoneyPayMainUI.this, false);
          }
          HoneyPayMainUI.h(HoneyPayMainUI.this);
          HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.JAA.aaFA);
          Log.i(HoneyPayMainUI.this.TAG, "show open card: %s", new Object[] { Boolean.valueOf(paramString.JAA.aaFD) });
          if (paramString.JAA.aaFD) {
            HoneyPayMainUI.g(HoneyPayMainUI.this).setVisibility(0);
          }
          for (;;)
          {
            HoneyPayMainUI.this.GRg = a.c.honey_pay_grey_bg_1;
            HoneyPayMainUI.this.setMMTitle(a.i.honey_pay_main_title);
            break;
            HoneyPayMainUI.g(HoneyPayMainUI.this).setVisibility(8);
          }
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(64779);
          h.OAn.p(875L, 1L, 1L);
          AppMethodBeat.o(64779);
        }
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(64778);
          h.OAn.p(875L, 1L, 1L);
          AppMethodBeat.o(64778);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64787);
      return true;
      if ((paramp instanceof com.tencent.mm.plugin.honey_pay.a.a))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.a)paramp;
        paramString.a(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(64782);
            if (paramString.JAv.Zjb != null)
            {
              Log.i(HoneyPayMainUI.this.TAG, "do realname guide");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
              c.a(HoneyPayMainUI.this, paramAnonymousString, paramString.JAv.Zjb, true);
              AppMethodBeat.o(64782);
              return;
            }
            HoneyPayMainUI.b(HoneyPayMainUI.this, paramString.JAv.Zjc);
            AppMethodBeat.o(64782);
          }
        }).b(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(64781);
            if (paramString.JAv.Zjb != null)
            {
              Log.i(HoneyPayMainUI.this.TAG, "do realname guide");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
              c.a(HoneyPayMainUI.this, paramAnonymousString, paramString.JAv.Zjb, true);
            }
            AppMethodBeat.o(64781);
          }
        }).c(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
        });
      }
      else if ((paramp instanceof com.tencent.mm.plugin.honey_pay.a.b))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.b)paramp;
        paramString.a(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(64772);
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.JAw.Zjg, paramString.JAw.Zjf, paramString.JAw.Zjh, paramString.JAw.Zji, paramString.username);
            AppMethodBeat.o(64772);
          }
        }).b(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
        }).c(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
        });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(267368);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(HoneyPayMainUI.a.class);
    AppMethodBeat.o(267368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI
 * JD-Core Version:    0.7.0.1
 */