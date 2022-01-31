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
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI
  extends MMActivity
  implements View.OnClickListener, c.a, d.a
{
  private final String TAG = "MicroMsg.CardConsumeCodeUI";
  private int ejF = 3;
  private com.tencent.mm.plugin.card.base.b klk;
  private String kqB;
  private int kqC = 3;
  private int kqD = 0;
  private a kqE;
  private TextView kqF;
  private TextView kqG;
  private LinearLayout kqH;
  private ImageView kqI;
  private View kqJ;
  private LinearLayout kqK;
  private View kqL;
  private TextView kqM;
  private TextView kqN;
  private TextView kqO;
  private Vibrator kqP;
  private boolean kqQ = false;
  
  public final void HB(String paramString)
  {
    AppMethodBeat.i(88112);
    ab.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
    if (this.kqQ)
    {
      ab.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
      AppMethodBeat.o(88112);
      return;
    }
    ab.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
    this.kqQ = true;
    Intent localIntent = new Intent(this, CardConsumeSuccessUI.class);
    localIntent.putExtra("KEY_CARD_ID", this.klk.bbh());
    localIntent.putExtra("KEY_CARD_CONSUMED_JSON", paramString);
    localIntent.putExtra("KEY_CARD_COLOR", this.klk.bbd().color);
    localIntent.putExtra("key_stastic_scene", this.ejF);
    localIntent.putExtra("key_from_scene", 0);
    startActivity(localIntent);
    AppMethodBeat.o(88112);
  }
  
  public final void Hy(String paramString)
  {
    AppMethodBeat.i(88114);
    com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    AppMethodBeat.o(88114);
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(88110);
    this.kqP.vibrate(300L);
    AppMethodBeat.o(88110);
  }
  
  public final void bbD()
  {
    AppMethodBeat.i(88111);
    ab.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
    finish();
    AppMethodBeat.o(88111);
  }
  
  public final void bbx()
  {
    AppMethodBeat.i(88113);
    this.kqE.bcI();
    AppMethodBeat.o(88113);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(88109);
    ab.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
    if ((paramb != null) && (paramb.bbh() != null) && (paramb.bbh().equals(this.klk.bbh())))
    {
      this.klk = paramb;
      this.kqE.klk = this.klk;
      this.kqE.bcI();
    }
    AppMethodBeat.o(88109);
  }
  
  public int getLayoutId()
  {
    return 2130968922;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88101);
    Object localObject1;
    label410:
    int i;
    if (this.klk.baL())
    {
      if (!TextUtils.isEmpty(this.klk.bbd().knv)) {
        setMMTitle(getString(2131297887, new Object[] { this.klk.bbd().knv }));
      }
    }
    else
    {
      setBackBtn(new CardConsumeCodeUI.1(this));
      if (this.kqE == null)
      {
        this.kqE = new a(this, getContentView());
        localObject1 = this.kqE;
        ((a)localObject1).kqy = ((a)localObject1).jpX.getWindow().getAttributes().screenBrightness;
        localObject1 = this.kqE;
        ((a)localObject1).kqr = ((TextView)((a)localObject1).iCk.findViewById(2131822043));
        ((a)localObject1).kqs = ((TextView)((a)localObject1).iCk.findViewById(2131822036));
        ((a)localObject1).kqt = ((CheckBox)((a)localObject1).iCk.findViewById(2131822047));
        ((a)localObject1).kqt.setChecked(true);
        ((a)localObject1).kqt.setOnClickListener(((a)localObject1).gMO);
        if (((a)localObject1).kqy < 0.8F) {
          ((a)localObject1).aG(0.8F);
        }
        this.kqE.kqx = new CardConsumeCodeUI.2(this);
      }
      this.kqE.klk = this.klk;
      this.kqE.kqw = true;
      Object localObject2;
      if (this.klk.baK())
      {
        localObject1 = this.kqE;
        localObject2 = this.kqB;
        ((a)localObject1).kqv = 1;
        ((a)localObject1).kqu = ((String)localObject2);
      }
      this.kqP = ((Vibrator)getSystemService("vibrator"));
      this.kqF = ((TextView)findViewById(2131822031));
      this.kqG = ((TextView)findViewById(2131820680));
      this.kqH = ((LinearLayout)findViewById(2131822032));
      this.kqI = ((ImageView)findViewById(2131822033));
      this.kqJ = findViewById(2131822034);
      this.kqK = ((LinearLayout)findViewById(2131822035));
      if (!this.klk.baL()) {
        break label1006;
      }
      findViewById(2131822029).setBackgroundColor(getResources().getColor(2131689824));
      m.d(this);
      if ((!this.klk.baL()) || (TextUtils.isEmpty(this.klk.bbd().kmm))) {
        break label1044;
      }
      this.kqH.setVisibility(0);
      this.kqF.setVisibility(8);
      this.kqG.setVisibility(8);
      this.kqJ.setVisibility(8);
      i = getResources().getDimensionPixelSize(2131428163);
      m.a(this.kqI, this.klk.bbd().kmm, i, 2130839758, true);
      label510:
      if (this.klk.bbd().wGD != null)
      {
        localObject1 = this.klk.bbd().wGD;
        if (!TextUtils.isEmpty(((uo)localObject1).title))
        {
          if (this.kqL == null) {
            this.kqL = ((ViewStub)findViewById(2131822044)).inflate();
          }
          this.kqL.setOnClickListener(this);
          this.kqM = ((TextView)this.kqL.findViewById(2131822315));
          this.kqN = ((TextView)this.kqL.findViewById(2131822314));
          this.kqO = ((TextView)this.kqL.findViewById(2131822316));
          this.kqM.setVisibility(0);
          this.kqM.setText(((uo)localObject1).title);
          localObject2 = getResources().getDrawable(2130838108);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Drawable)localObject2).setColorFilter(com.tencent.mm.plugin.card.d.l.IB(this.klk.bbd().color), PorterDuff.Mode.SRC_IN);
          this.kqM.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          this.kqM.setTextColor(com.tencent.mm.plugin.card.d.l.IB(this.klk.bbd().color));
          this.kqM.setOnClickListener(this);
          if (TextUtils.isEmpty(((uo)localObject1).kmn)) {
            break label1085;
          }
          this.kqN.setVisibility(0);
          this.kqN.setText(((uo)localObject1).kmn);
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((uo)localObject1).kmo))
      {
        this.kqO.setVisibility(0);
        this.kqO.setText(((uo)localObject1).kmo);
      }
      localObject1 = this.kqI.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(2131428164);
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(2131428164);
      this.kqI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.kqH.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(this, 54);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.fromDPToPix(this, 54);
      this.kqH.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = getResources().getDimensionPixelSize(2131428164);
      m.a(this.kqI, this.klk.bbd().kmm, i, 2130839758, true);
      this.kqK.setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this, 10), 0, com.tencent.mm.cb.a.fromDPToPix(this, 30));
      am.bco().a(this);
      if (!this.klk.baY()) {
        break label1133;
      }
      am.bcq().a(this);
      if (am.bcq().isEmpty()) {
        break label1110;
      }
      am.bcq().bbv();
      AppMethodBeat.o(88101);
      return;
      setMMTitle(getString(2131297887, new Object[] { getString(2131297988) }));
      break;
      label1006:
      i = com.tencent.mm.plugin.card.d.l.IB(this.klk.bbd().color);
      findViewById(2131822029).setBackgroundColor(i);
      m.a(this, this.klk);
      break label410;
      label1044:
      this.kqF.setText(this.klk.bbd().knw);
      this.kqG.setText(this.klk.bbd().title);
      break label510;
      label1085:
      this.kqN.setVisibility(0);
      this.kqN.setText(getString(2131297989));
    }
    label1110:
    ab.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
    am.bcq().Hz(this.klk.bbh());
    label1133:
    AppMethodBeat.o(88101);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(88116);
    if ((paramView.getId() == 2131822315) || (paramView.getId() == 2131822045))
    {
      if (!this.klk.baX()) {
        break label74;
      }
      paramView = new j.b();
      com.tencent.mm.plugin.card.d.b.a(this, paramView.kmb, paramView.kmc, false, this.klk);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(88116);
      return;
      label74:
      paramView = this.klk.bbd().wGD;
      if ((!com.tencent.mm.plugin.card.d.b.a(this.klk.bbh(), paramView, this.kqC, this.kqD)) && (paramView != null) && (!TextUtils.isEmpty(paramView.url)))
      {
        com.tencent.mm.plugin.card.d.b.a(this, com.tencent.mm.plugin.card.d.l.H(paramView.url, paramView.wGZ), 1);
        h.qsU.e(11941, new Object[] { Integer.valueOf(9), this.klk.bbh(), this.klk.bbi(), "", paramView.title });
        if (com.tencent.mm.plugin.card.d.l.a(paramView, this.klk.bbh()))
        {
          com.tencent.mm.plugin.card.d.l.IG(this.klk.bbh());
          com.tencent.mm.plugin.card.d.b.b(this, this.klk.bbd().knw);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88100);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
    setResult(0);
    this.klk = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    this.ejF = getIntent().getIntExtra("key_from_scene", 3);
    this.kqC = getIntent().getIntExtra("key_previous_scene", 3);
    this.kqB = getIntent().getStringExtra("key_mark_user");
    this.kqD = getIntent().getIntExtra("key_from_appbrand_type", 0);
    if ((this.klk == null) || (this.klk.bbd() == null) || (this.klk.bbe() == null))
    {
      ab.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(88100);
      return;
    }
    initView();
    am.bcj().w("", "", 3);
    AppMethodBeat.o(88100);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88106);
    a locala = this.kqE;
    locala.aG(locala.kqy);
    com.tencent.mm.plugin.card.d.l.I(locala.gMJ);
    com.tencent.mm.plugin.card.d.l.I(locala.kqq);
    locala.kqx = null;
    locala.jpX = null;
    am.bco().c(this);
    am.bco().b(this);
    if (this.klk.baY())
    {
      am.bcq().b(this);
      am.bcq().bbw();
    }
    this.kqP.cancel();
    super.onDestroy();
    AppMethodBeat.o(88106);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(88108);
    if (paramInt == 4)
    {
      ab.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
      setResult(-1);
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(88108);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(88105);
    am.bco().a(this, false);
    super.onPause();
    AppMethodBeat.o(88105);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(88104);
    this.kqE.bcI();
    am.bco().a(this, true);
    super.onResume();
    AppMethodBeat.o(88104);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(88115);
    this.kqE.bcI();
    AppMethodBeat.o(88115);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI
 * JD-Core Version:    0.7.0.1
 */