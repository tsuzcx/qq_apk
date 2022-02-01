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
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI
  extends MMActivity
  implements View.OnClickListener, c.a, d.a
{
  private final String TAG = "MicroMsg.CardConsumeCodeUI";
  private int fwc = 3;
  private com.tencent.mm.plugin.card.base.b nTp;
  private String nYV;
  private int nYW = 3;
  private int nYX = 0;
  private a nYY;
  private TextView nYZ;
  private TextView nZa;
  private LinearLayout nZb;
  private ImageView nZc;
  private View nZd;
  private LinearLayout nZe;
  private View nZf;
  private TextView nZg;
  private TextView nZh;
  private TextView nZi;
  private boolean nZj = false;
  private Vibrator njY;
  
  public final void Uu(String paramString)
  {
    AppMethodBeat.i(113048);
    com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    AppMethodBeat.o(113048);
  }
  
  public final void Ux(String paramString)
  {
    AppMethodBeat.i(113046);
    ac.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
    if (this.nZj)
    {
      ac.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
      AppMethodBeat.o(113046);
      return;
    }
    ac.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
    this.nZj = true;
    Intent localIntent = new Intent(this, CardConsumeSuccessUI.class);
    localIntent.putExtra("KEY_CARD_ID", this.nTp.bPm());
    localIntent.putExtra("KEY_CARD_CONSUMED_JSON", paramString);
    localIntent.putExtra("KEY_CARD_COLOR", this.nTp.bPi().hiu);
    localIntent.putExtra("key_stastic_scene", this.fwc);
    localIntent.putExtra("key_from_scene", 0);
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113046);
  }
  
  public final void bPC()
  {
    AppMethodBeat.i(113047);
    this.nYY.bQT();
    AppMethodBeat.o(113047);
  }
  
  public final void bPH()
  {
    AppMethodBeat.i(113044);
    this.njY.vibrate(300L);
    AppMethodBeat.o(113044);
  }
  
  public final void bPI()
  {
    AppMethodBeat.i(113045);
    ac.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
    finish();
    AppMethodBeat.o(113045);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113043);
    ac.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
    if ((paramb != null) && (paramb.bPm() != null) && (paramb.bPm().equals(this.nTp.bPm())))
    {
      this.nTp = paramb;
      this.nYY.nTp = this.nTp;
      this.nYY.bQT();
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
    if (this.nTp.bOP())
    {
      if (!TextUtils.isEmpty(this.nTp.bPi().nVJ)) {
        setMMTitle(getString(2131756819, new Object[] { this.nTp.bPi().nVJ }));
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
      if (this.nYY == null)
      {
        this.nYY = new a(this, getContentView());
        localObject1 = this.nYY;
        ((a)localObject1).nYS = ((a)localObject1).nTt.getWindow().getAttributes().screenBrightness;
        localObject1 = this.nYY;
        ((a)localObject1).nYL = ((TextView)((a)localObject1).ijA.findViewById(2131297865));
        ((a)localObject1).nYM = ((TextView)((a)localObject1).ijA.findViewById(2131297873));
        ((a)localObject1).nYN = ((CheckBox)((a)localObject1).ijA.findViewById(2131302965));
        ((a)localObject1).nYN.setChecked(true);
        ((a)localObject1).nYN.setOnClickListener(((a)localObject1).jax);
        if (((a)localObject1).nYS < 0.8F) {
          ((a)localObject1).aS(0.8F);
        }
        this.nYY.nYR = new a.a()
        {
          public final void zM(int paramAnonymousInt)
          {
            AppMethodBeat.i(113036);
            am.bQu().S(CardConsumeCodeUI.a(CardConsumeCodeUI.this).bPm(), paramAnonymousInt, 1);
            AppMethodBeat.o(113036);
          }
        };
      }
      this.nYY.nTp = this.nTp;
      this.nYY.nYQ = true;
      Object localObject2;
      if (this.nTp.bOO())
      {
        localObject1 = this.nYY;
        localObject2 = this.nYV;
        ((a)localObject1).nYP = 1;
        ((a)localObject1).nYO = ((String)localObject2);
      }
      this.njY = ((Vibrator)getSystemService("vibrator"));
      this.nYZ = ((TextView)findViewById(2131297507));
      this.nZa = ((TextView)findViewById(2131305902));
      this.nZb = ((LinearLayout)findViewById(2131296860));
      this.nZc = ((ImageView)findViewById(2131296859));
      this.nZd = findViewById(2131298923);
      this.nZe = ((LinearLayout)findViewById(2131298398));
      if (!this.nTp.bOP()) {
        break label1007;
      }
      findViewById(2131297770).setBackgroundColor(getResources().getColor(2131100084));
      n.c(this);
      if ((!this.nTp.bOP()) || (TextUtils.isEmpty(this.nTp.bPi().hhs))) {
        break label1045;
      }
      this.nZb.setVisibility(0);
      this.nYZ.setVisibility(8);
      this.nZa.setVisibility(8);
      this.nZd.setVisibility(8);
      i = getResources().getDimensionPixelSize(2131165962);
      n.a(this.nZc, this.nTp.bPi().hhs, i, 2131233400, true);
      label511:
      if (this.nTp.bPi().EkT != null)
      {
        localObject1 = this.nTp.bPi().EkT;
        if (!TextUtils.isEmpty(((yg)localObject1).title))
        {
          if (this.nZf == null) {
            this.nZf = ((ViewStub)findViewById(2131297874)).inflate();
          }
          this.nZf.setOnClickListener(this);
          this.nZg = ((TextView)this.nZf.findViewById(2131297876));
          this.nZh = ((TextView)this.nZf.findViewById(2131297875));
          this.nZi = ((TextView)this.nZf.findViewById(2131297872));
          this.nZg.setVisibility(0);
          this.nZg.setText(((yg)localObject1).title);
          localObject2 = getResources().getDrawable(2131231436);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Drawable)localObject2).setColorFilter(com.tencent.mm.plugin.card.d.l.Vy(this.nTp.bPi().hiu), PorterDuff.Mode.SRC_IN);
          this.nZg.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          this.nZg.setTextColor(com.tencent.mm.plugin.card.d.l.Vy(this.nTp.bPi().hiu));
          this.nZg.setOnClickListener(this);
          if (TextUtils.isEmpty(((yg)localObject1).nUs)) {
            break label1086;
          }
          this.nZh.setVisibility(0);
          this.nZh.setText(((yg)localObject1).nUs);
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((yg)localObject1).nUt))
      {
        this.nZi.setVisibility(0);
        this.nZi.setText(((yg)localObject1).nUt);
      }
      localObject1 = this.nZc.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(2131165963);
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(2131165963);
      this.nZc.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.nZb.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cc.a.fromDPToPix(this, 54);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cc.a.fromDPToPix(this, 54);
      this.nZb.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = getResources().getDimensionPixelSize(2131165963);
      n.a(this.nZc, this.nTp.bPi().hhs, i, 2131233400, true);
      this.nZe.setPadding(0, com.tencent.mm.cc.a.fromDPToPix(this, 10), 0, com.tencent.mm.cc.a.fromDPToPix(this, 30));
      am.bQt().a(this);
      if (!this.nTp.bPc()) {
        break label1134;
      }
      am.bQv().a(this);
      if (am.bQv().isEmpty()) {
        break label1111;
      }
      am.bQv().bPA();
      AppMethodBeat.o(113038);
      return;
      setMMTitle(getString(2131756819, new Object[] { getString(2131756930) }));
      break;
      label1007:
      i = com.tencent.mm.plugin.card.d.l.Vy(this.nTp.bPi().hiu);
      findViewById(2131297770).setBackgroundColor(i);
      n.a(this, this.nTp);
      break label411;
      label1045:
      this.nYZ.setText(this.nTp.bPi().nVK);
      this.nZa.setText(this.nTp.bPi().title);
      break label511;
      label1086:
      this.nZh.setVisibility(0);
      this.nZh.setText(getString(2131756931));
    }
    label1111:
    ac.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
    am.bQv().Uv(this.nTp.bPm());
    label1134:
    AppMethodBeat.o(113038);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113050);
    if ((paramView.getId() == 2131297876) || (paramView.getId() == 2131297871))
    {
      if (!this.nTp.bPb()) {
        break label74;
      }
      paramView = new j.b();
      com.tencent.mm.plugin.card.d.b.a(this, paramView.nUh, paramView.nUi, false, this.nTp);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(113050);
      return;
      label74:
      paramView = this.nTp.bPi().EkT;
      if ((!com.tencent.mm.plugin.card.d.b.a(this.nTp.bPm(), paramView, this.nYW, this.nYX)) && (paramView != null) && (!TextUtils.isEmpty(paramView.url)))
      {
        com.tencent.mm.plugin.card.d.b.a(this, com.tencent.mm.plugin.card.d.l.S(paramView.url, paramView.Els), 1);
        h.wUl.f(11941, new Object[] { Integer.valueOf(9), this.nTp.bPm(), this.nTp.bPn(), "", paramView.title });
        if (com.tencent.mm.plugin.card.d.l.a(paramView, this.nTp.bPm()))
        {
          com.tencent.mm.plugin.card.d.l.VD(this.nTp.bPm());
          com.tencent.mm.plugin.card.d.b.b(this, this.nTp.bPi().nVK);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113037);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
    setResult(0);
    this.nTp = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    this.fwc = getIntent().getIntExtra("key_from_scene", 3);
    this.nYW = getIntent().getIntExtra("key_previous_scene", 3);
    this.nYV = getIntent().getStringExtra("key_mark_user");
    this.nYX = getIntent().getIntExtra("key_from_appbrand_type", 0);
    if ((this.nTp == null) || (this.nTp.bPi() == null) || (this.nTp.bPj() == null))
    {
      ac.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113037);
      return;
    }
    initView();
    am.bQo().G("", "", 3);
    AppMethodBeat.o(113037);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113041);
    a locala = this.nYY;
    locala.aS(locala.nYS);
    com.tencent.mm.plugin.card.d.l.T(locala.jas);
    com.tencent.mm.plugin.card.d.l.T(locala.nYK);
    locala.nYR = null;
    locala.nTt = null;
    am.bQt().c(this);
    am.bQt().b(this);
    if (this.nTp.bPc())
    {
      am.bQv().b(this);
      am.bQv().bPB();
    }
    this.njY.cancel();
    super.onDestroy();
    AppMethodBeat.o(113041);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113042);
    if (paramInt == 4)
    {
      ac.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
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
    am.bQt().a(this, false);
    super.onPause();
    AppMethodBeat.o(113040);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113039);
    this.nYY.bQT();
    am.bQt().a(this, true);
    super.onResume();
    AppMethodBeat.o(113039);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113049);
    this.nYY.bQT();
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