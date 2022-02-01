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
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.xd.b;
import com.tencent.mm.plugin.honey_pay.a.a;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;

public class HoneyPayMainUI
  extends HoneyPayBaseUI
{
  private LinearLayout ljn;
  private LinearLayout swF;
  private ImageView swG;
  private RelativeLayout swH;
  private Button swI;
  private TextView swJ;
  private ArrayList<HoneyPayCardLayout> swK;
  
  public HoneyPayMainUI()
  {
    AppMethodBeat.i(64783);
    this.swK = new ArrayList();
    AppMethodBeat.o(64783);
  }
  
  private void ao(Intent paramIntent)
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
  
  private void mi(boolean paramBoolean)
  {
    AppMethodBeat.i(64791);
    ad.i(this.TAG, "get payer list");
    f localf = new f();
    localf.q(this);
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
    this.ljn = ((LinearLayout)findViewById(2131300836));
    this.swH = ((RelativeLayout)findViewById(2131300842));
    this.swG = ((ImageView)findViewById(2131300841));
    this.swI = ((Button)findViewById(2131300839));
    this.swJ = ((TextView)findViewById(2131300843));
    this.swF = ((LinearLayout)findViewById(2131300837));
    this.swF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64771);
        ad.d(HoneyPayMainUI.this.TAG, "click add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        AppMethodBeat.o(64771);
      }
    });
    this.swI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64777);
        ad.i(HoneyPayMainUI.this.TAG, "click empty header add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        AppMethodBeat.o(64777);
      }
    });
    if (ai.Eq()) {
      this.swG.setImageResource(2131690312);
    }
    AppMethodBeat.o(64785);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64789);
    if (paramInt1 == 3) {
      mi(false);
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
    ao(getIntent());
    initView();
    mi(true);
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
    ao(paramIntent);
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
          if ((paramString.suN.DEf == null) || (paramString.suN.DEf.isEmpty()))
          {
            ad.i(HoneyPayMainUI.this.TAG, "empty card");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.suN.DEg);
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(8);
            HoneyPayMainUI.this.svd = 2131101179;
            HoneyPayMainUI.this.setMMTitle("");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.suN.DEj);
            HoneyPayMainUI.this.cFM();
            HoneyPayMainUI.this.findViewById(2131300847).setBackgroundResource(HoneyPayMainUI.this.svd);
            c.b(HoneyPayMainUI.this, paramString.suN.DEh, null, 0, null);
            HoneyPayMainUI.this.findViewById(2131300838).setVisibility(8);
            h.vKh.m(875L, 0L, 1L);
            AppMethodBeat.o(64780);
            return;
          }
          HoneyPayMainUI.d(HoneyPayMainUI.this);
          HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.suN.DEf);
          ad.i(HoneyPayMainUI.this.TAG, "show open card: %s", new Object[] { Boolean.valueOf(paramString.suN.DEi) });
          if (paramString.suN.DEi) {
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(0);
          }
          for (;;)
          {
            HoneyPayMainUI.this.svd = 2131100492;
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
          h.vKh.m(875L, 1L, 1L);
          AppMethodBeat.o(64779);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(64778);
          h.vKh.m(875L, 1L, 1L);
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
            if (paramString.suI.CWv != null)
            {
              ad.i(HoneyPayMainUI.this.TAG, "do realname guide");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
              c.a(HoneyPayMainUI.this, paramAnonymousString, paramString.suI.CWv, true);
              AppMethodBeat.o(64782);
              return;
            }
            HoneyPayMainUI.b(HoneyPayMainUI.this, paramString.suI.CWw);
            AppMethodBeat.o(64782);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(64781);
            if (paramString.suI.CWv != null)
            {
              ad.i(HoneyPayMainUI.this.TAG, "do realname guide");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
              c.a(HoneyPayMainUI.this, paramAnonymousString, paramString.suI.CWv, true);
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
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(64772);
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.suJ.CWA, paramString.suJ.CWz, paramString.suJ.CWB, paramString.suJ.CWC, paramString.username);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI
 * JD-Core Version:    0.7.0.1
 */