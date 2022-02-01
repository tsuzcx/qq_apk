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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
import com.tencent.mm.plugin.honey_pay.a.a;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.protocal.protobuf.bkb;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;

public class HoneyPayMainUI
  extends HoneyPayBaseUI
{
  private LinearLayout lJf;
  private LinearLayout tEu;
  private ImageView tEv;
  private RelativeLayout tEw;
  private Button tEx;
  private TextView tEy;
  private ArrayList<HoneyPayCardLayout> tEz;
  
  public HoneyPayMainUI()
  {
    AppMethodBeat.i(64783);
    this.tEz = new ArrayList();
    AppMethodBeat.o(64783);
  }
  
  private void ap(Intent paramIntent)
  {
    AppMethodBeat.i(64790);
    boolean bool = paramIntent.getBooleanExtra("key_create_succ", false);
    String str = paramIntent.getStringExtra("key_card_no");
    paramIntent = paramIntent.getStringExtra("key_card_type");
    ac.i(this.TAG, "create succ: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      d(str, true, paramIntent);
    }
    AppMethodBeat.o(64790);
  }
  
  private void d(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(64792);
    ac.i(this.TAG, "go to card manager: %s", new Object[] { paramString1 });
    Intent localIntent = new Intent(this, HoneyPayCardManagerUI.class);
    localIntent.putExtra("key_card_no", paramString1);
    localIntent.putExtra("key_scene", 0);
    localIntent.putExtra("key_is_create", paramBoolean);
    localIntent.putExtra("key_card_type", paramString2);
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(64792);
  }
  
  private void nb(boolean paramBoolean)
  {
    AppMethodBeat.i(64791);
    ac.i(this.TAG, "get payer list");
    f localf = new f();
    localf.r(this);
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
    this.lJf = ((LinearLayout)findViewById(2131300836));
    this.tEw = ((RelativeLayout)findViewById(2131300842));
    this.tEv = ((ImageView)findViewById(2131300841));
    this.tEx = ((Button)findViewById(2131300839));
    this.tEy = ((TextView)findViewById(2131300843));
    this.tEu = ((LinearLayout)findViewById(2131300837));
    this.tEu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64771);
        ac.d(HoneyPayMainUI.this.TAG, "click add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        AppMethodBeat.o(64771);
      }
    });
    this.tEx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64777);
        ac.i(HoneyPayMainUI.this.TAG, "click empty header add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        AppMethodBeat.o(64777);
      }
    });
    if (aj.DT()) {
      this.tEv.setImageResource(2131690312);
    }
    AppMethodBeat.o(64785);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64789);
    if (paramInt1 == 3) {
      nb(false);
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
    ap(getIntent());
    initView();
    nb(true);
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
    ac.i(this.TAG, "on new intent");
    ap(paramIntent);
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
          if ((paramString.tCC.EZA == null) || (paramString.tCC.EZA.isEmpty()))
          {
            ac.i(HoneyPayMainUI.this.TAG, "empty card");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.tCC.EZB);
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(8);
            HoneyPayMainUI.this.tCS = 2131101179;
            HoneyPayMainUI.this.setMMTitle("");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.tCC.EZE);
            HoneyPayMainUI.this.cSW();
            HoneyPayMainUI.this.findViewById(2131300847).setBackgroundResource(HoneyPayMainUI.this.tCS);
            c.b(HoneyPayMainUI.this, paramString.tCC.EZC, null, 0, null);
            HoneyPayMainUI.this.findViewById(2131300838).setVisibility(8);
            h.wUl.n(875L, 0L, 1L);
            AppMethodBeat.o(64780);
            return;
          }
          HoneyPayMainUI.d(HoneyPayMainUI.this);
          HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.tCC.EZA);
          ac.i(HoneyPayMainUI.this.TAG, "show open card: %s", new Object[] { Boolean.valueOf(paramString.tCC.EZD) });
          if (paramString.tCC.EZD) {
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(0);
          }
          for (;;)
          {
            HoneyPayMainUI.this.tCS = 2131100492;
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
          h.wUl.n(875L, 1L, 1L);
          AppMethodBeat.o(64779);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(64778);
          h.wUl.n(875L, 1L, 1L);
          AppMethodBeat.o(64778);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64787);
      return true;
      if ((paramn instanceof a))
      {
        paramString = (a)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(64782);
            if (paramString.tCx.Epe != null)
            {
              ac.i(HoneyPayMainUI.this.TAG, "do realname guide");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
              c.a(HoneyPayMainUI.this, paramAnonymousString, paramString.tCx.Epe, true);
              AppMethodBeat.o(64782);
              return;
            }
            HoneyPayMainUI.b(HoneyPayMainUI.this, paramString.tCx.Epf);
            AppMethodBeat.o(64782);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(64781);
            if (paramString.tCx.Epe != null)
            {
              ac.i(HoneyPayMainUI.this.TAG, "do realname guide");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
              c.a(HoneyPayMainUI.this, paramAnonymousString, paramString.tCx.Epe, true);
            }
            AppMethodBeat.o(64781);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn) {}
        });
      }
      else if ((paramn instanceof b))
      {
        paramString = (b)paramn;
        paramString.a(new HoneyPayMainUI.3(this, paramString)).b(new r.a()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI
 * JD-Core Version:    0.7.0.1
 */