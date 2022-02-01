package com.tencent.mm.plugin.card.sharecard.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.c.a;
import com.tencent.mm.plugin.card.b.d.a;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI
  extends MMActivity
  implements View.OnClickListener, c.a, d.a
{
  private final String TAG = "MicroMsg.CardConsumeCodeUI";
  private int fPp = 3;
  private Vibrator nKv;
  private TextView oCA;
  private TextView oCB;
  private TextView oCC;
  private boolean oCD = false;
  private String oCp;
  private int oCq = 3;
  private int oCr = 0;
  private a oCs;
  private TextView oCt;
  private TextView oCu;
  private LinearLayout oCv;
  private ImageView oCw;
  private View oCx;
  private LinearLayout oCy;
  private View oCz;
  private com.tencent.mm.plugin.card.base.b owK;
  
  public final void Yd(String paramString)
  {
    AppMethodBeat.i(113048);
    com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    AppMethodBeat.o(113048);
  }
  
  public final void Yg(String paramString)
  {
    AppMethodBeat.i(113046);
    ad.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
    if (this.oCD)
    {
      ad.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
      AppMethodBeat.o(113046);
      return;
    }
    ad.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
    this.oCD = true;
    Intent localIntent = new Intent(this, CardConsumeSuccessUI.class);
    localIntent.putExtra("KEY_CARD_ID", this.owK.bTR());
    localIntent.putExtra("KEY_CARD_CONSUMED_JSON", paramString);
    localIntent.putExtra("KEY_CARD_COLOR", this.owK.bTN().hAD);
    localIntent.putExtra("key_stastic_scene", this.fPp);
    localIntent.putExtra("key_from_scene", 0);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113046);
  }
  
  public final void bUh()
  {
    AppMethodBeat.i(113047);
    this.oCs.bVy();
    AppMethodBeat.o(113047);
  }
  
  public final void bUm()
  {
    AppMethodBeat.i(113044);
    this.nKv.vibrate(300L);
    AppMethodBeat.o(113044);
  }
  
  public final void bUn()
  {
    AppMethodBeat.i(113045);
    ad.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
    finish();
    AppMethodBeat.o(113045);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113043);
    ad.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
    if ((paramb != null) && (paramb.bTR() != null) && (paramb.bTR().equals(this.owK.bTR())))
    {
      this.owK = paramb;
      this.oCs.owK = this.owK;
      this.oCs.bVy();
    }
    AppMethodBeat.o(113043);
  }
  
  public int getLayoutId()
  {
    return 2131493264;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113038);
    Object localObject1;
    label411:
    int i;
    if (this.owK.bTu())
    {
      if (!TextUtils.isEmpty(this.owK.bTN().ozd)) {
        setMMTitle(getString(2131756819, new Object[] { this.owK.bTN().ozd }));
      }
    }
    else
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(113035);
          CardConsumeCodeUI.this.setResult(-1);
          CardConsumeCodeUI.this.finish();
          AppMethodBeat.o(113035);
          return true;
        }
      });
      if (this.oCs == null)
      {
        this.oCs = new a(this, getContentView());
        localObject1 = this.oCs;
        ((a)localObject1).oCm = ((a)localObject1).owO.getWindow().getAttributes().screenBrightness;
        localObject1 = this.oCs;
        ((a)localObject1).oCf = ((TextView)((a)localObject1).iCR.findViewById(2131297865));
        ((a)localObject1).oCg = ((TextView)((a)localObject1).iCR.findViewById(2131297873));
        ((a)localObject1).oCh = ((CheckBox)((a)localObject1).iCR.findViewById(2131302965));
        ((a)localObject1).oCh.setChecked(true);
        ((a)localObject1).oCh.setOnClickListener(((a)localObject1).jtG);
        if (((a)localObject1).oCm < 0.8F) {
          ((a)localObject1).aV(0.8F);
        }
        this.oCs.oCl = new a.a()
        {
          public final void Av(int paramAnonymousInt)
          {
            AppMethodBeat.i(113036);
            am.bUZ().U(CardConsumeCodeUI.a(CardConsumeCodeUI.this).bTR(), paramAnonymousInt, 1);
            AppMethodBeat.o(113036);
          }
        };
      }
      this.oCs.owK = this.owK;
      this.oCs.oCk = true;
      Object localObject2;
      if (this.owK.bTt())
      {
        localObject1 = this.oCs;
        localObject2 = this.oCp;
        ((a)localObject1).oCj = 1;
        ((a)localObject1).oCi = ((String)localObject2);
      }
      this.nKv = ((Vibrator)getSystemService("vibrator"));
      this.oCt = ((TextView)findViewById(2131297507));
      this.oCu = ((TextView)findViewById(2131305902));
      this.oCv = ((LinearLayout)findViewById(2131296860));
      this.oCw = ((ImageView)findViewById(2131296859));
      this.oCx = findViewById(2131298923);
      this.oCy = ((LinearLayout)findViewById(2131298398));
      if (!this.owK.bTu()) {
        break label1007;
      }
      findViewById(2131297770).setBackgroundColor(getResources().getColor(2131100084));
      n.d(this);
      if ((!this.owK.bTu()) || (TextUtils.isEmpty(this.owK.bTN().hzB))) {
        break label1045;
      }
      this.oCv.setVisibility(0);
      this.oCt.setVisibility(8);
      this.oCu.setVisibility(8);
      this.oCx.setVisibility(8);
      i = getResources().getDimensionPixelSize(2131165962);
      n.a(this.oCw, this.owK.bTN().hzB, i, 2131233400, true);
      label511:
      if (this.owK.bTN().FSc != null)
      {
        localObject1 = this.owK.bTN().FSc;
        if (!TextUtils.isEmpty(((aaf)localObject1).title))
        {
          if (this.oCz == null) {
            this.oCz = ((ViewStub)findViewById(2131297874)).inflate();
          }
          this.oCz.setOnClickListener(this);
          this.oCA = ((TextView)this.oCz.findViewById(2131297876));
          this.oCB = ((TextView)this.oCz.findViewById(2131297875));
          this.oCC = ((TextView)this.oCz.findViewById(2131297872));
          this.oCA.setVisibility(0);
          this.oCA.setText(((aaf)localObject1).title);
          localObject2 = getResources().getDrawable(2131231436);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Drawable)localObject2).setColorFilter(com.tencent.mm.plugin.card.d.l.Zh(this.owK.bTN().hAD), PorterDuff.Mode.SRC_IN);
          this.oCA.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          this.oCA.setTextColor(com.tencent.mm.plugin.card.d.l.Zh(this.owK.bTN().hAD));
          this.oCA.setOnClickListener(this);
          if (TextUtils.isEmpty(((aaf)localObject1).oxN)) {
            break label1086;
          }
          this.oCB.setVisibility(0);
          this.oCB.setText(((aaf)localObject1).oxN);
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((aaf)localObject1).oxO))
      {
        this.oCC.setVisibility(0);
        this.oCC.setText(((aaf)localObject1).oxO);
      }
      localObject1 = this.oCw.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(2131165963);
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(2131165963);
      this.oCw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.oCv.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cc.a.fromDPToPix(this, 54);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cc.a.fromDPToPix(this, 54);
      this.oCv.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = getResources().getDimensionPixelSize(2131165963);
      n.a(this.oCw, this.owK.bTN().hzB, i, 2131233400, true);
      this.oCy.setPadding(0, com.tencent.mm.cc.a.fromDPToPix(this, 10), 0, com.tencent.mm.cc.a.fromDPToPix(this, 30));
      am.bUY().a(this);
      if (!this.owK.bTH()) {
        break label1134;
      }
      am.bVa().a(this);
      if (am.bVa().isEmpty()) {
        break label1111;
      }
      am.bVa().bUf();
      AppMethodBeat.o(113038);
      return;
      setMMTitle(getString(2131756819, new Object[] { getString(2131756930) }));
      break;
      label1007:
      i = com.tencent.mm.plugin.card.d.l.Zh(this.owK.bTN().hAD);
      findViewById(2131297770).setBackgroundColor(i);
      n.a(this, this.owK);
      break label411;
      label1045:
      this.oCt.setText(this.owK.bTN().oze);
      this.oCu.setText(this.owK.bTN().title);
      break label511;
      label1086:
      this.oCB.setVisibility(0);
      this.oCB.setText(getString(2131756931));
    }
    label1111:
    ad.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
    am.bVa().Ye(this.owK.bTR());
    label1134:
    AppMethodBeat.o(113038);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113050);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((paramView.getId() == 2131297876) || (paramView.getId() == 2131297871))
    {
      if (!this.owK.bTG()) {
        break label121;
      }
      paramView = new j.b();
      com.tencent.mm.plugin.card.d.b.a(this, paramView.oxC, paramView.oxD, false, this.owK);
    }
    for (;;)
    {
      finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113050);
      return;
      label121:
      paramView = this.owK.bTN().FSc;
      if ((!com.tencent.mm.plugin.card.d.b.a(this.owK.bTR(), paramView, this.oCq, this.oCr)) && (paramView != null) && (!TextUtils.isEmpty(paramView.url)))
      {
        com.tencent.mm.plugin.card.d.b.a(this, com.tencent.mm.plugin.card.d.l.Z(paramView.url, paramView.FSA), 1);
        g.yhR.f(11941, new Object[] { Integer.valueOf(9), this.owK.bTR(), this.owK.bTS(), "", paramView.title });
        if (com.tencent.mm.plugin.card.d.l.a(paramView, this.owK.bTR()))
        {
          com.tencent.mm.plugin.card.d.l.Zm(this.owK.bTR());
          com.tencent.mm.plugin.card.d.b.b(this, this.owK.bTN().oze);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113037);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
    setResult(0);
    this.owK = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    this.fPp = getIntent().getIntExtra("key_from_scene", 3);
    this.oCq = getIntent().getIntExtra("key_previous_scene", 3);
    this.oCp = getIntent().getStringExtra("key_mark_user");
    this.oCr = getIntent().getIntExtra("key_from_appbrand_type", 0);
    if ((this.owK == null) || (this.owK.bTN() == null) || (this.owK.bTO() == null))
    {
      ad.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113037);
      return;
    }
    initView();
    am.bUT().H("", "", 3);
    AppMethodBeat.o(113037);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113041);
    a locala = this.oCs;
    locala.aV(locala.oCm);
    com.tencent.mm.plugin.card.d.l.T(locala.jtB);
    com.tencent.mm.plugin.card.d.l.T(locala.oCe);
    locala.oCl = null;
    locala.owO = null;
    am.bUY().c(this);
    am.bUY().b(this);
    if (this.owK.bTH())
    {
      am.bVa().b(this);
      am.bVa().bUg();
    }
    this.nKv.cancel();
    super.onDestroy();
    AppMethodBeat.o(113041);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113042);
    if (paramInt == 4)
    {
      ad.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
      setResult(-1);
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113042);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113040);
    am.bUY().a(this, false);
    super.onPause();
    AppMethodBeat.o(113040);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113039);
    this.oCs.bVy();
    am.bUY().a(this, true);
    super.onResume();
    AppMethodBeat.o(113039);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113049);
    this.oCs.bVy();
    AppMethodBeat.o(113049);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI
 * JD-Core Version:    0.7.0.1
 */