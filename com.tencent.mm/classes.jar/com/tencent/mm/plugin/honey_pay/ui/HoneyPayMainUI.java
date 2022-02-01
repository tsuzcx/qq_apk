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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.b;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;

public class HoneyPayMainUI
  extends HoneyPayBaseUI
{
  private LinearLayout lPV;
  private LinearLayout uHd;
  private ImageView uHe;
  private RelativeLayout uHf;
  private Button uHg;
  private TextView uHh;
  private ArrayList<HoneyPayCardLayout> uHi;
  
  public HoneyPayMainUI()
  {
    AppMethodBeat.i(64783);
    this.uHi = new ArrayList();
    AppMethodBeat.o(64783);
  }
  
  private void au(Intent paramIntent)
  {
    AppMethodBeat.i(64790);
    boolean bool = paramIntent.getBooleanExtra("key_create_succ", false);
    String str = paramIntent.getStringExtra("key_card_no");
    paramIntent = paramIntent.getStringExtra("key_card_type");
    ad.i(this.TAG, "create succ: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      d(str, true, paramIntent);
    }
    AppMethodBeat.o(64790);
  }
  
  private void d(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(64792);
    ad.i(this.TAG, "go to card manager: %s", new Object[] { paramString1 });
    Intent localIntent = new Intent(this, HoneyPayCardManagerUI.class);
    localIntent.putExtra("key_card_no", paramString1);
    localIntent.putExtra("key_scene", 0);
    localIntent.putExtra("key_is_create", paramBoolean);
    localIntent.putExtra("key_card_type", paramString2);
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(64792);
  }
  
  private void nv(boolean paramBoolean)
  {
    AppMethodBeat.i(64791);
    ad.i(this.TAG, "get payer list");
    f localf = new f();
    localf.t(this);
    doSceneProgress(localf, paramBoolean);
    AppMethodBeat.o(64791);
  }
  
  public int getLayoutId()
  {
    return 2131494448;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64785);
    this.lPV = ((LinearLayout)findViewById(2131300836));
    this.uHf = ((RelativeLayout)findViewById(2131300842));
    this.uHe = ((ImageView)findViewById(2131300841));
    this.uHg = ((Button)findViewById(2131300839));
    this.uHh = ((TextView)findViewById(2131300843));
    this.uHd = ((LinearLayout)findViewById(2131300837));
    this.uHd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d(HoneyPayMainUI.this.TAG, "click add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64771);
      }
    });
    this.uHg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64777);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i(HoneyPayMainUI.this.TAG, "click empty header add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64777);
      }
    });
    if (al.isDarkMode()) {
      this.uHe.setImageResource(2131690312);
    }
    AppMethodBeat.o(64785);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64789);
    if (paramInt1 == 3) {
      nv(false);
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
    au(getIntent());
    initView();
    nv(true);
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
    ad.i(this.TAG, "on new intent");
    au(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(64788);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(64787);
    if ((paramn instanceof f))
    {
      paramString = (f)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(64780);
          HoneyPayMainUI.b(HoneyPayMainUI.this);
          HoneyPayMainUI.this.removeAllOptionMenu();
          if ((paramString.uFl.GIZ == null) || (paramString.uFl.GIZ.isEmpty()))
          {
            ad.i(HoneyPayMainUI.this.TAG, "empty card");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.uFl.GJa);
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(8);
            HoneyPayMainUI.this.uFB = 2131101179;
            HoneyPayMainUI.this.setMMTitle("");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.uFl.GJd);
            HoneyPayMainUI.this.dcd();
            HoneyPayMainUI.this.findViewById(2131300847).setBackgroundResource(HoneyPayMainUI.this.uFB);
            c.b(HoneyPayMainUI.this, paramString.uFl.GJb, null, 0, null);
            HoneyPayMainUI.this.findViewById(2131300838).setVisibility(8);
            g.yhR.n(875L, 0L, 1L);
            AppMethodBeat.o(64780);
            return;
          }
          HoneyPayMainUI.d(HoneyPayMainUI.this);
          HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.uFl.GIZ);
          ad.i(HoneyPayMainUI.this.TAG, "show open card: %s", new Object[] { Boolean.valueOf(paramString.uFl.GJc) });
          if (paramString.uFl.GJc) {
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(0);
          }
          for (;;)
          {
            HoneyPayMainUI.this.uFB = 2131100492;
            HoneyPayMainUI.this.setMMTitle(2131760277);
            break;
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(8);
          }
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(64779);
          g.yhR.n(875L, 1L, 1L);
          AppMethodBeat.o(64779);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(64778);
          g.yhR.n(875L, 1L, 1L);
          AppMethodBeat.o(64778);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64787);
      return true;
      if ((paramn instanceof com.tencent.mm.plugin.honey_pay.a.a))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.a)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(64782);
            if (paramString.uFg.FWq != null)
            {
              ad.i(HoneyPayMainUI.this.TAG, "do realname guide");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
              c.a(HoneyPayMainUI.this, paramAnonymousString, paramString.uFg.FWq, true);
              AppMethodBeat.o(64782);
              return;
            }
            HoneyPayMainUI.b(HoneyPayMainUI.this, paramString.uFg.FWr);
            AppMethodBeat.o(64782);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(64781);
            if (paramString.uFg.FWq != null)
            {
              ad.i(HoneyPayMainUI.this.TAG, "do realname guide");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
              c.a(HoneyPayMainUI.this, paramAnonymousString, paramString.uFg.FWq, true);
            }
            AppMethodBeat.o(64781);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn) {}
        });
      }
      else if ((paramn instanceof com.tencent.mm.plugin.honey_pay.a.b))
      {
        paramString = (com.tencent.mm.plugin.honey_pay.a.b)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(64772);
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.uFh.FWv, paramString.uFh.FWu, paramString.uFh.FWw, paramString.uFh.FWx, paramString.username);
            AppMethodBeat.o(64772);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn) {}
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn) {}
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