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
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.a;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.avd;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import java.util.ArrayList;
import java.util.LinkedList;

public class HoneyPayMainUI
  extends HoneyPayBaseUI
{
  private LinearLayout iCt;
  private LinearLayout nIY;
  private ImageView nIZ;
  private RelativeLayout nJa;
  private Button nJb;
  private TextView nJc;
  private ArrayList<HoneyPayCardLayout> nJd;
  
  public HoneyPayMainUI()
  {
    AppMethodBeat.i(41894);
    this.nJd = new ArrayList();
    AppMethodBeat.o(41894);
  }
  
  private void aa(Intent paramIntent)
  {
    AppMethodBeat.i(41901);
    boolean bool = paramIntent.getBooleanExtra("key_create_succ", false);
    String str = paramIntent.getStringExtra("key_card_no");
    paramIntent = paramIntent.getStringExtra("key_card_type");
    ab.i(this.TAG, "create succ: %s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      b(str, true, paramIntent);
    }
    AppMethodBeat.o(41901);
  }
  
  private void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(41903);
    ab.i(this.TAG, "go to card manager: %s", new Object[] { paramString1 });
    Intent localIntent = new Intent(this, HoneyPayCardManagerUI.class);
    localIntent.putExtra("key_card_no", paramString1);
    localIntent.putExtra("key_scene", 0);
    localIntent.putExtra("key_is_create", paramBoolean);
    localIntent.putExtra("key_card_type", paramString2);
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(41903);
  }
  
  private void it(boolean paramBoolean)
  {
    AppMethodBeat.i(41902);
    ab.i(this.TAG, "get payer list");
    f localf = new f();
    localf.o(this);
    doSceneProgress(localf, paramBoolean);
    AppMethodBeat.o(41902);
  }
  
  public int getLayoutId()
  {
    return 2130969871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41896);
    this.iCt = ((LinearLayout)findViewById(2131825048));
    this.nJa = ((RelativeLayout)findViewById(2131825049));
    this.nIZ = ((ImageView)findViewById(2131825051));
    this.nJb = ((Button)findViewById(2131825055));
    this.nJc = ((TextView)findViewById(2131825056));
    this.nIY = ((LinearLayout)findViewById(2131825057));
    this.nIY.setOnClickListener(new HoneyPayMainUI.1(this));
    this.nJb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41888);
        ab.i(HoneyPayMainUI.this.TAG, "click empty header add friend");
        HoneyPayMainUI.a(HoneyPayMainUI.this);
        AppMethodBeat.o(41888);
      }
    });
    AppMethodBeat.o(41896);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41900);
    if (paramInt1 == 3) {
      it(false);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(41900);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41895);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    addSceneEndListener(2725);
    addSceneEndListener(2618);
    addSceneEndListener(2926);
    aa(getIntent());
    initView();
    it(true);
    setMMTitle("");
    AppMethodBeat.o(41895);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41897);
    super.onDestroy();
    removeSceneEndListener(2725);
    removeSceneEndListener(2618);
    removeSceneEndListener(2926);
    AppMethodBeat.o(41897);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(41899);
    ab.i(this.TAG, "on new intent");
    aa(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(41899);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    AppMethodBeat.i(41898);
    if ((paramm instanceof f))
    {
      paramString = (f)paramm;
      paramString.a(new p.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(41891);
          HoneyPayMainUI.b(HoneyPayMainUI.this);
          HoneyPayMainUI.this.removeAllOptionMenu();
          if ((paramString.nHg.xkv == null) || (paramString.nHg.xkv.isEmpty()))
          {
            ab.i(HoneyPayMainUI.this.TAG, "empty card");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.nHg.xkw);
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(8);
            HoneyPayMainUI.this.nHx = 2131690709;
            HoneyPayMainUI.this.setMMTitle("");
            HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.nHg.xkz);
            HoneyPayMainUI.this.bHV();
            HoneyPayMainUI.this.findViewById(2131825047).setBackgroundResource(HoneyPayMainUI.this.nHx);
            c.b(HoneyPayMainUI.this, paramString.nHg.xkx, null, 0, null);
            HoneyPayMainUI.this.findViewById(2131825058).setVisibility(8);
            h.qsU.j(875L, 0L, 1L);
            AppMethodBeat.o(41891);
            return;
          }
          HoneyPayMainUI.d(HoneyPayMainUI.this);
          HoneyPayMainUI.a(HoneyPayMainUI.this, paramString.nHg.xkv);
          ab.i(HoneyPayMainUI.this.TAG, "show open card: %s", new Object[] { Boolean.valueOf(paramString.nHg.xky) });
          if (paramString.nHg.xky) {
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(0);
          }
          for (;;)
          {
            HoneyPayMainUI.this.nHx = 2131690170;
            HoneyPayMainUI.this.setMMTitle(2131300680);
            break;
            HoneyPayMainUI.c(HoneyPayMainUI.this).setVisibility(8);
          }
        }
      }).b(new HoneyPayMainUI.10(this)).c(new HoneyPayMainUI.9(this));
    }
    for (;;)
    {
      AppMethodBeat.o(41898);
      return true;
      if ((paramm instanceof a))
      {
        paramString = (a)paramm;
        paramString.a(new HoneyPayMainUI.14(this, paramString)).b(new HoneyPayMainUI.13(this, paramString)).c(new HoneyPayMainUI.12(this));
      }
      else if ((paramm instanceof b))
      {
        paramString = (b)paramm;
        paramString.a(new HoneyPayMainUI.3(this, paramString)).b(new HoneyPayMainUI.2(this)).c(new HoneyPayMainUI.15(this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI
 * JD-Core Version:    0.7.0.1
 */