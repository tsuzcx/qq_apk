package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.honey_pay.a.e;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;

public class HoneyPayReceiveCardUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private String yjY;
  private ImageView ylK;
  private TextView ylL;
  private TextView ylM;
  private TextView ylN;
  private TextView ylO;
  private TextView ylP;
  private TextView ylQ;
  private TextView ylR;
  private TextView ylS;
  private TextView ylT;
  private LinearLayout ylU;
  private CdnImageView ylV;
  private i ylW;
  
  public HoneyPayReceiveCardUI()
  {
    AppMethodBeat.i(64831);
    this.ylW = new HoneyPayReceiveCardUI.1(this);
    AppMethodBeat.o(64831);
  }
  
  private void a(final dhh paramdhh)
  {
    AppMethodBeat.i(64836);
    if (paramdhh.LWG == null)
    {
      AppMethodBeat.o(64836);
      return;
    }
    cbx localcbx = paramdhh.LWG;
    this.ylP.setText(localcbx.MhL);
    this.ylR.setText(l.b(getContext(), localcbx.yPK, this.ylR.getTextSize()));
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("click_help", true);
    this.ylS.setText(l.a(getContext(), localcbx.Cjw, (int)this.ylS.getTextSize(), localObject));
    this.ylS.setClickable(true);
    this.ylS.setOnTouchListener(new o(this));
    if (!Util.isNullOrNil(paramdhh.MGq))
    {
      localObject = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
      {
        public final void dF(View paramAnonymousView)
        {
          AppMethodBeat.i(64830);
          if (!Util.isNullOrNil(paramdhh.MGr)) {
            f.p(HoneyPayReceiveCardUI.this.getContext(), paramdhh.MGr, false);
          }
          h.CyF.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(64830);
        }
      });
      paramdhh = new SpannableString(paramdhh.MGq);
      paramdhh.setSpan(localObject, 0, paramdhh.length(), 18);
      this.ylN.setText(paramdhh);
      this.ylN.setOnTouchListener(new o(this));
      this.ylN.setClickable(true);
      this.ylM.setText(localcbx.pTn);
      a.b.a(this.ylK, localcbx.KBN, 0.06F, false);
      f.i(this.ylL, localcbx.KBN);
      f.i(this.ylT, localcbx.KBN);
      if (localcbx.nHh != 1) {
        break label321;
      }
      this.ylQ.setText(2131761649);
    }
    for (;;)
    {
      if (Util.isNullOrNil(localcbx.qGB)) {
        break label370;
      }
      this.ylV.gI(localcbx.qGB, c.dYO());
      AppMethodBeat.o(64836);
      return;
      Log.d(this.TAG, "no help url");
      this.ylN.setVisibility(8);
      break;
      label321:
      if (localcbx.nHh == 2) {
        this.ylQ.setText(2131761676);
      } else {
        this.ylQ.setText(l.b(this, f.hs(z.aUa(), 16), this.ylQ.getTextSize()));
      }
    }
    label370:
    this.ylV.setImageResource(c.dYO());
    AppMethodBeat.o(64836);
  }
  
  private void dYR()
  {
    AppMethodBeat.i(64837);
    Log.i(this.TAG, "qry user detail");
    m localm = new m(this.yjY);
    localm.t(this);
    doSceneProgress(localm, true);
    AppMethodBeat.o(64837);
  }
  
  public int getLayoutId()
  {
    return 2131495030;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64833);
    this.ylK = ((ImageView)findViewById(2131302442));
    this.ylL = ((TextView)findViewById(2131302445));
    this.ylQ = ((TextView)findViewById(2131302452));
    this.ylM = ((TextView)findViewById(2131302446));
    this.ylT = ((TextView)findViewById(2131302449));
    this.ylN = ((TextView)findViewById(2131302443));
    this.ylO = ((TextView)findViewById(2131302450));
    this.ylP = ((TextView)findViewById(2131302451));
    this.ylU = ((LinearLayout)findViewById(2131302447));
    this.ylR = ((TextView)findViewById(2131302453));
    this.ylS = ((TextView)findViewById(2131302444));
    this.ylV = ((CdnImageView)findViewById(2131302448));
    this.ylO.setOnClickListener(new HoneyPayReceiveCardUI.2(this));
    AppMethodBeat.o(64833);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64832);
    this.wwG = 2131100597;
    super.onCreate(paramBundle);
    l.a(this.ylW);
    addSceneEndListener(2613);
    addSceneEndListener(1983);
    this.yjY = getIntent().getStringExtra("key_card_no");
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    initView();
    if (this.mScene == 1)
    {
      paramBundle = new dhh();
      try
      {
        paramBundle.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
        a(paramBundle);
        if (paramBundle.LWG != null) {
          setMMTitle(paramBundle.LWG.pTn);
        }
        AppMethodBeat.o(64832);
        return;
      }
      catch (IOException paramBundle)
      {
        Log.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
        dYR();
        AppMethodBeat.o(64832);
        return;
      }
    }
    dYR();
    AppMethodBeat.o(64832);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64834);
    super.onDestroy();
    l.b(this.ylW);
    removeSceneEndListener(2613);
    removeSceneEndListener(1983);
    AppMethodBeat.o(64834);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(64835);
    if ((paramq instanceof m))
    {
      paramString = (m)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(64826);
          HoneyPayReceiveCardUI.a(HoneyPayReceiveCardUI.this, paramString.yjK);
          AppMethodBeat.o(64826);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64835);
      return true;
      if ((paramq instanceof e))
      {
        paramString = (e)paramq;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(64829);
            if (paramString.yjB.LjA != null)
            {
              Log.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.yjB.LjA, false);
            }
            for (;;)
            {
              h.CyF.n(875L, 4L, 1L);
              AppMethodBeat.o(64829);
              return;
              HoneyPayReceiveCardUI.b(HoneyPayReceiveCardUI.this);
              paramAnonymousString = HoneyPayReceiveCardUI.c(HoneyPayReceiveCardUI.this);
              paramAnonymousq = new zv();
              paramAnonymousq.efR.scene = 8;
              EventCenter.instance.publish(paramAnonymousq);
              Log.i("MicroMsg.HoneyPayUtil", "trigger offline event");
              paramAnonymousq = new og();
              paramAnonymousq.dUv.scene = 1;
              paramAnonymousq.dUv.dQm = "qmf";
              EventCenter.instance.publish(paramAnonymousq);
              if (!Util.isNullOrNil(paramAnonymousString)) {
                a.aJk(paramAnonymousString);
              }
              HoneyPayReceiveCardUI.this.finish();
            }
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(64828);
            if (paramString.yjB.LjA != null)
            {
              Log.i(HoneyPayReceiveCardUI.this.TAG, "do real name");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
              c.a(HoneyPayReceiveCardUI.this, paramAnonymousString, paramString.yjB.LjA, false);
            }
            h.CyF.n(875L, 5L, 1L);
            AppMethodBeat.o(64828);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(64827);
            h.CyF.n(875L, 5L, 1L);
            AppMethodBeat.o(64827);
          }
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
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI
 * JD-Core Version:    0.7.0.1
 */