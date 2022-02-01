package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;

public class HoneyPayCardDetailUI
  extends HoneyPayBaseUI
{
  private int mScene;
  private ImageView qyu;
  private String yjY;
  private TextView ykc;
  private TextView ykd;
  private TextView yke;
  private TextView ykf;
  private TextView ykg;
  private TextView ykh;
  private RelativeLayout yki;
  private CdnImageView ykj;
  private TextView ykk;
  private Button ykl;
  private dhh ykm;
  private caj ykn;
  
  private void dYQ()
  {
    AppMethodBeat.i(64675);
    if (this.ykm.LWG == null)
    {
      AppMethodBeat.o(64675);
      return;
    }
    cbx localcbx = this.ykm.LWG;
    setMMTitle(localcbx.pTn);
    this.ykc.setText(localcbx.MhP);
    int i = localcbx.state;
    if (i == 2)
    {
      this.qyu.setImageResource(2131690788);
      this.qyu.setColorFilter(getContext().getResources().getColor(2131099710), PorterDuff.Mode.SRC_ATOP);
      if (!Util.isNullOrNil(localcbx.MhL))
      {
        localcbx.MhL = c.W(localcbx.MhL, this.ykm.LWG.KBN, -1);
        this.ykd.setText(l.a(this, localcbx.MhL, (int)this.ykd.getTextSize(), null));
      }
      findViewById(2131302367).setVisibility(8);
      findViewById(2131302368).setVisibility(8);
      findViewById(2131302375).setVisibility(8);
      if (this.ykn != null)
      {
        this.yki.setVisibility(0);
        this.ykj.setUrl(this.ykn.icon);
        this.ykk.setText(this.ykn.MfD);
        this.ykl.setText(this.ykn.MfC);
        this.ykl.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64670);
            b localb = new b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.d(HoneyPayCardDetailUI.this.TAG, "click oper btn: %s", new Object[] { HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url });
            if (!Util.isNullOrNil(HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url)) {
              f.p(HoneyPayCardDetailUI.this.getContext(), HoneyPayCardDetailUI.b(HoneyPayCardDetailUI.this).url, false);
            }
            a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64670);
          }
        });
        AppMethodBeat.o(64675);
      }
    }
    else
    {
      if (i == 3)
      {
        this.qyu.setImageResource(2131691399);
        if (!Util.isNullOrNil(localcbx.MhL)) {
          this.ykd.setText(localcbx.MhL);
        }
        this.yke.setText(2131761689);
        this.ykf.setText(2131761691);
        this.ykg.setText(c.GP(this.ykm.LWG.Gaz));
        this.ykh.setText(c.GP(this.ykm.LWG.pRN));
        AppMethodBeat.o(64675);
        return;
      }
      if (i == 4)
      {
        this.qyu.setImageResource(2131691399);
        if (!Util.isNullOrNil(localcbx.MhL)) {
          this.ykd.setText(l.g(this, localcbx.MhL, (int)this.ykd.getTextSize()));
        }
        this.yke.setText(2131761690);
        this.ykg.setText(c.GP(this.ykm.LWG.MhN));
        findViewById(2131302375).setVisibility(8);
      }
    }
    AppMethodBeat.o(64675);
  }
  
  private void dYR()
  {
    AppMethodBeat.i(64676);
    m localm = new m(this.yjY);
    localm.t(this);
    doSceneProgress(localm, true);
    AppMethodBeat.o(64676);
  }
  
  public int getLayoutId()
  {
    return 2131495016;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64672);
    this.qyu = ((ImageView)findViewById(2131302380));
    this.ykc = ((TextView)findViewById(2131302379));
    this.ykd = ((TextView)findViewById(2131302378));
    this.ykg = ((TextView)findViewById(2131302370));
    this.ykh = ((TextView)findViewById(2131302377));
    this.yke = ((TextView)findViewById(2131302369));
    this.ykf = ((TextView)findViewById(2131302376));
    this.yki = ((RelativeLayout)findViewById(2131302374));
    this.ykj = ((CdnImageView)findViewById(2131302373));
    this.ykk = ((TextView)findViewById(2131302372));
    this.ykl = ((Button)findViewById(2131302371));
    this.ykd.setClickable(true);
    this.ykd.setOnTouchListener(new o(this));
    AppMethodBeat.o(64672);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64671);
    this.wwG = 2131100597;
    super.onCreate(paramBundle);
    addSceneEndListener(2613);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    this.yjY = getIntent().getStringExtra("key_card_no");
    initView();
    if (this.mScene == 0)
    {
      dYR();
      AppMethodBeat.o(64671);
      return;
    }
    paramBundle = getIntent().getByteArrayExtra("key_qry_response");
    try
    {
      this.ykm = new dhh();
      this.ykm.parseFrom(paramBundle);
      dYQ();
      AppMethodBeat.o(64671);
      return;
    }
    catch (IOException paramBundle)
    {
      Log.printErrStackTrace(this.TAG, paramBundle, "", new Object[0]);
      dYR();
      AppMethodBeat.o(64671);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64673);
    super.onDestroy();
    removeSceneEndListener(2613);
    AppMethodBeat.o(64673);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64674);
    if ((paramq instanceof m))
    {
      paramString = (m)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64669);
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this, paramString.yjK);
          HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this);
          AppMethodBeat.o(64669);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      });
    }
    AppMethodBeat.o(64674);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI
 * JD-Core Version:    0.7.0.1
 */