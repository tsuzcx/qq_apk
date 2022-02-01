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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI
  extends MMActivity
  implements View.OnClickListener, c.a, d.a
{
  private final String TAG = "MicroMsg.CardConsumeCodeUI";
  private int fsv = 3;
  private Vibrator mHT;
  private com.tencent.mm.plugin.card.base.b nqp;
  private String nvV;
  private int nvW = 3;
  private int nvX = 0;
  private a nvY;
  private TextView nvZ;
  private TextView nwa;
  private LinearLayout nwb;
  private ImageView nwc;
  private View nwd;
  private LinearLayout nwe;
  private View nwf;
  private TextView nwg;
  private TextView nwh;
  private TextView nwi;
  private boolean nwj = false;
  
  public final void Qi(String paramString)
  {
    AppMethodBeat.i(113048);
    com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    AppMethodBeat.o(113048);
  }
  
  public final void Ql(String paramString)
  {
    AppMethodBeat.i(113046);
    ad.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
    if (this.nwj)
    {
      ad.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
      AppMethodBeat.o(113046);
      return;
    }
    ad.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
    this.nwj = true;
    Intent localIntent = new Intent(this, CardConsumeSuccessUI.class);
    localIntent.putExtra("KEY_CARD_ID", this.nqp.bHZ());
    localIntent.putExtra("KEY_CARD_CONSUMED_JSON", paramString);
    localIntent.putExtra("KEY_CARD_COLOR", this.nqp.bHV().gHT);
    localIntent.putExtra("key_stastic_scene", this.fsv);
    localIntent.putExtra("key_from_scene", 0);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113046);
  }
  
  public final void bIp()
  {
    AppMethodBeat.i(113047);
    this.nvY.bJG();
    AppMethodBeat.o(113047);
  }
  
  public final void bIu()
  {
    AppMethodBeat.i(113044);
    this.mHT.vibrate(300L);
    AppMethodBeat.o(113044);
  }
  
  public final void bIv()
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
    if ((paramb != null) && (paramb.bHZ() != null) && (paramb.bHZ().equals(this.nqp.bHZ())))
    {
      this.nqp = paramb;
      this.nvY.nqp = this.nqp;
      this.nvY.bJG();
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
    if (this.nqp.bHC())
    {
      if (!TextUtils.isEmpty(this.nqp.bHV().nsJ)) {
        setMMTitle(getString(2131756819, new Object[] { this.nqp.bHV().nsJ }));
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
      if (this.nvY == null)
      {
        this.nvY = new a(this, getContentView());
        localObject1 = this.nvY;
        ((a)localObject1).nvS = ((a)localObject1).nqt.getWindow().getAttributes().screenBrightness;
        localObject1 = this.nvY;
        ((a)localObject1).nvL = ((TextView)((a)localObject1).hIZ.findViewById(2131297865));
        ((a)localObject1).nvM = ((TextView)((a)localObject1).hIZ.findViewById(2131297873));
        ((a)localObject1).nvN = ((CheckBox)((a)localObject1).hIZ.findViewById(2131302965));
        ((a)localObject1).nvN.setChecked(true);
        ((a)localObject1).nvN.setOnClickListener(((a)localObject1).iAw);
        if (((a)localObject1).nvS < 0.8F) {
          ((a)localObject1).aO(0.8F);
        }
        this.nvY.nvR = new a.a()
        {
          public final void yW(int paramAnonymousInt)
          {
            AppMethodBeat.i(113036);
            am.bJh().T(CardConsumeCodeUI.a(CardConsumeCodeUI.this).bHZ(), paramAnonymousInt, 1);
            AppMethodBeat.o(113036);
          }
        };
      }
      this.nvY.nqp = this.nqp;
      this.nvY.nvQ = true;
      Object localObject2;
      if (this.nqp.bHB())
      {
        localObject1 = this.nvY;
        localObject2 = this.nvV;
        ((a)localObject1).nvP = 1;
        ((a)localObject1).nvO = ((String)localObject2);
      }
      this.mHT = ((Vibrator)getSystemService("vibrator"));
      this.nvZ = ((TextView)findViewById(2131297507));
      this.nwa = ((TextView)findViewById(2131305902));
      this.nwb = ((LinearLayout)findViewById(2131296860));
      this.nwc = ((ImageView)findViewById(2131296859));
      this.nwd = findViewById(2131298923);
      this.nwe = ((LinearLayout)findViewById(2131298398));
      if (!this.nqp.bHC()) {
        break label1007;
      }
      findViewById(2131297770).setBackgroundColor(getResources().getColor(2131100084));
      n.d(this);
      if ((!this.nqp.bHC()) || (TextUtils.isEmpty(this.nqp.bHV().gGR))) {
        break label1045;
      }
      this.nwb.setVisibility(0);
      this.nvZ.setVisibility(8);
      this.nwa.setVisibility(8);
      this.nwd.setVisibility(8);
      i = getResources().getDimensionPixelSize(2131165962);
      n.a(this.nwc, this.nqp.bHV().gGR, i, 2131233400, true);
      label511:
      if (this.nqp.bHV().CSi != null)
      {
        localObject1 = this.nqp.bHV().CSi;
        if (!TextUtils.isEmpty(((xo)localObject1).title))
        {
          if (this.nwf == null) {
            this.nwf = ((ViewStub)findViewById(2131297874)).inflate();
          }
          this.nwf.setOnClickListener(this);
          this.nwg = ((TextView)this.nwf.findViewById(2131297876));
          this.nwh = ((TextView)this.nwf.findViewById(2131297875));
          this.nwi = ((TextView)this.nwf.findViewById(2131297872));
          this.nwg.setVisibility(0);
          this.nwg.setText(((xo)localObject1).title);
          localObject2 = getResources().getDrawable(2131231436);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Drawable)localObject2).setColorFilter(com.tencent.mm.plugin.card.d.l.Rm(this.nqp.bHV().gHT), PorterDuff.Mode.SRC_IN);
          this.nwg.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          this.nwg.setTextColor(com.tencent.mm.plugin.card.d.l.Rm(this.nqp.bHV().gHT));
          this.nwg.setOnClickListener(this);
          if (TextUtils.isEmpty(((xo)localObject1).nrs)) {
            break label1086;
          }
          this.nwh.setVisibility(0);
          this.nwh.setText(((xo)localObject1).nrs);
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((xo)localObject1).nrt))
      {
        this.nwi.setVisibility(0);
        this.nwi.setText(((xo)localObject1).nrt);
      }
      localObject1 = this.nwc.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(2131165963);
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(2131165963);
      this.nwc.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.nwb.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.fromDPToPix(this, 54);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cd.a.fromDPToPix(this, 54);
      this.nwb.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = getResources().getDimensionPixelSize(2131165963);
      n.a(this.nwc, this.nqp.bHV().gGR, i, 2131233400, true);
      this.nwe.setPadding(0, com.tencent.mm.cd.a.fromDPToPix(this, 10), 0, com.tencent.mm.cd.a.fromDPToPix(this, 30));
      am.bJg().a(this);
      if (!this.nqp.bHP()) {
        break label1134;
      }
      am.bJi().a(this);
      if (am.bJi().isEmpty()) {
        break label1111;
      }
      am.bJi().bIn();
      AppMethodBeat.o(113038);
      return;
      setMMTitle(getString(2131756819, new Object[] { getString(2131756930) }));
      break;
      label1007:
      i = com.tencent.mm.plugin.card.d.l.Rm(this.nqp.bHV().gHT);
      findViewById(2131297770).setBackgroundColor(i);
      n.a(this, this.nqp);
      break label411;
      label1045:
      this.nvZ.setText(this.nqp.bHV().nsK);
      this.nwa.setText(this.nqp.bHV().title);
      break label511;
      label1086:
      this.nwh.setVisibility(0);
      this.nwh.setText(getString(2131756931));
    }
    label1111:
    ad.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
    am.bJi().Qj(this.nqp.bHZ());
    label1134:
    AppMethodBeat.o(113038);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113050);
    if ((paramView.getId() == 2131297876) || (paramView.getId() == 2131297871))
    {
      if (!this.nqp.bHO()) {
        break label74;
      }
      paramView = new j.b();
      com.tencent.mm.plugin.card.d.b.a(this, paramView.nrh, paramView.nri, false, this.nqp);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(113050);
      return;
      label74:
      paramView = this.nqp.bHV().CSi;
      if ((!com.tencent.mm.plugin.card.d.b.a(this.nqp.bHZ(), paramView, this.nvW, this.nvX)) && (paramView != null) && (!TextUtils.isEmpty(paramView.url)))
      {
        com.tencent.mm.plugin.card.d.b.a(this, com.tencent.mm.plugin.card.d.l.R(paramView.url, paramView.CSH), 1);
        h.vKh.f(11941, new Object[] { Integer.valueOf(9), this.nqp.bHZ(), this.nqp.bIa(), "", paramView.title });
        if (com.tencent.mm.plugin.card.d.l.a(paramView, this.nqp.bHZ()))
        {
          com.tencent.mm.plugin.card.d.l.Rr(this.nqp.bHZ());
          com.tencent.mm.plugin.card.d.b.b(this, this.nqp.bHV().nsK);
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
    this.nqp = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    this.fsv = getIntent().getIntExtra("key_from_scene", 3);
    this.nvW = getIntent().getIntExtra("key_previous_scene", 3);
    this.nvV = getIntent().getStringExtra("key_mark_user");
    this.nvX = getIntent().getIntExtra("key_from_appbrand_type", 0);
    if ((this.nqp == null) || (this.nqp.bHV() == null) || (this.nqp.bHW() == null))
    {
      ad.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113037);
      return;
    }
    initView();
    am.bJb().F("", "", 3);
    AppMethodBeat.o(113037);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113041);
    a locala = this.nvY;
    locala.aO(locala.nvS);
    com.tencent.mm.plugin.card.d.l.T(locala.iAr);
    com.tencent.mm.plugin.card.d.l.T(locala.nvK);
    locala.nvR = null;
    locala.nqt = null;
    am.bJg().c(this);
    am.bJg().b(this);
    if (this.nqp.bHP())
    {
      am.bJi().b(this);
      am.bJi().bIo();
    }
    this.mHT.cancel();
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
    am.bJg().a(this, false);
    super.onPause();
    AppMethodBeat.o(113040);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113039);
    this.nvY.bJG();
    am.bJg().a(this, true);
    super.onResume();
    AppMethodBeat.o(113039);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113049);
    this.nvY.bJG();
    AppMethodBeat.o(113049);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI
 * JD-Core Version:    0.7.0.1
 */