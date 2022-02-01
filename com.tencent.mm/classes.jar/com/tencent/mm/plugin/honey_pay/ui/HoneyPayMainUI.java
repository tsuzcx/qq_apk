package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.b;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.util.ArrayList;
import java.util.LinkedList;

public class HoneyPayMainUI
  extends HoneyPayBaseUI
{
  private LinearLayout ncf;
  private LinearLayout ylr;
  private ImageView yls;
  private RelativeLayout ylt;
  private Button ylu;
  private TextView ylv;
  private ArrayList<HoneyPayCardLayout> ylw;
  
  public HoneyPayMainUI()
  {
    AppMethodBeat.i(64783);
    this.ylw = new ArrayList();
    AppMethodBeat.o(64783);
  }
  
  private void aC(Intent paramIntent)
  {
    AppMethodBeat.i(64790);
    boolean bool = paramIntent.getBooleanExtra("key_create_succ", false);
    String str = paramIntent.getStringExtra("key_card_no");
    paramIntent = paramIntent.getStringExtra("key_card_type");
    Log.i(this.TAG, "create succ: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      d(str, true, paramIntent);
    }
    AppMethodBeat.o(64790);
  }
  
  private void d(String paramString1, boolean paramBoolean, String paramString2)
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
  
  private void qi(boolean paramBoolean)
  {
    AppMethodBeat.i(64791);
    Log.i(this.TAG, "get payer list");
    com.tencent.mm.plugin.honey_pay.a.f localf = new com.tencent.mm.plugin.honey_pay.a.f();
    localf.t(this);
    doSceneProgress(localf, paramBoolean);
    AppMethodBeat.o(64791);
  }
  
  public int getLayoutId()
  {
    return 2131495026;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64785);
    this.ncf = ((LinearLayout)findViewById(2131302430));
    this.ylt = ((RelativeLayout)findViewById(2131302436));
    this.yls = ((ImageView)findViewById(2131302435));
    this.ylu = ((Button)findViewById(2131302433));
    this.ylv = ((TextView)findViewById(2131302437));
    this.ylr = ((LinearLayout)findViewById(2131302431));
    this.ylr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.d(HoneyPayMainUI.this.TAG, "click add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64771);
      }
    });
    this.ylu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64777);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i(HoneyPayMainUI.this.TAG, "click empty header add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64777);
      }
    });
    if (ao.isDarkMode()) {
      this.yls.setImageResource(2131690409);
    }
    AppMethodBeat.o(64785);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64789);
    if (paramInt1 == 3) {
      qi(false);
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
    aC(getIntent());
    initView();
    qi(true);
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
    AppMethodBeat.o(64786);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(64788);
    Log.i(this.TAG, "on new intent");
    aC(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(64788);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64787);
    if ((paramq instanceof com.tencent.mm.plugin.honey_pay.a.f))
    {
      paramString = (com.tencent.mm.plugin.honey_pay.a.f)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64780);
          HoneyPayMainUI.b(HoneyPayMainUI.this);
          HoneyPayMainUI.this.removeAllOptionMenu();
          if ((paramString.yjC.MhD == null) || (paramString.yjC.MhD.isEmpty()))
          {
            Log.i(HoneyPayMainUI.this.TAG, "empty card");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.yjC.MhE);
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(8);
            HoneyPayMainUI.this.wwG = 2131101424;
            HoneyPayMainUI.this.setMMTitle("");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.yjC.MhH);
            HoneyPayMainUI.this.dYP();
            HoneyPayMainUI.this.findViewById(2131302441).setBackgroundResource(HoneyPayMainUI.this.wwG);
            c.b(HoneyPayMainUI.this, paramString.yjC.MhF, null, 0, null);
            HoneyPayMainUI.this.findViewById(2131302432).setVisibility(8);
            h.CyF.n(875L, 0L, 1L);
            AppMethodBeat.o(64780);
            return;
          }
          HoneyPayMainUI.d(HoneyPayMainUI.this);
          HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.yjC.MhD);
          Log.i(HoneyPayMainUI.this.TAG, "show open card: %s", new Object[] { Boolean.valueOf(paramString.yjC.MhG) });
          if (paramString.yjC.MhG) {
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(0);
          }
          for (;;)
          {
            HoneyPayMainUI.this.wwG = 2131100596;
            HoneyPayMainUI.this.setMMTitle(2131761663);
            break;
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(8);
          }
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64779);
          h.CyF.n(875L, 1L, 1L);
          AppMethodBeat.o(64779);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64778);
          h.CyF.n(875L, 1L, 1L);
          AppMethodBeat.o(64778);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64787);
      return true;
      if ((paramq instanceof com.tencent.mm.plugin.honey_pay.a.a))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.a)paramq;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64782);
            if (paramString.yjx.LjA != null)
            {
              Log.i(HoneyPayMainUI.this.TAG, "do realname guide");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
              c.a(HoneyPayMainUI.this, paramAnonymousString, paramString.yjx.LjA, true);
              AppMethodBeat.o(64782);
              return;
            }
            HoneyPayMainUI.b(HoneyPayMainUI.this, paramString.yjx.LjB);
            AppMethodBeat.o(64782);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64781);
            if (paramString.yjx.LjA != null)
            {
              Log.i(HoneyPayMainUI.this.TAG, "do realname guide");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
              c.a(HoneyPayMainUI.this, paramAnonymousString, paramString.yjx.LjA, true);
            }
            AppMethodBeat.o(64781);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
        });
      }
      else if ((paramq instanceof com.tencent.mm.plugin.honey_pay.a.b))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.b)paramq;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64772);
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.yjy.LjF, paramString.yjy.LjE, paramString.yjy.LjG, paramString.yjy.LjH, paramString.username);
            AppMethodBeat.o(64772);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
        });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI
 * JD-Core Version:    0.7.0.1
 */