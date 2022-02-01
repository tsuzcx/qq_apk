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
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI
  extends MMActivity
  implements View.OnClickListener, c.a, d.a
{
  private final String TAG = "MicroMsg.CardConsumeCodeUI";
  private int gwE = 3;
  private com.tencent.mm.plugin.card.base.b pQV;
  private String pWF;
  private int pWG = 3;
  private int pWH = 0;
  private a pWI;
  private TextView pWJ;
  private TextView pWK;
  private LinearLayout pWL;
  private ImageView pWM;
  private View pWN;
  private LinearLayout pWO;
  private View pWP;
  private TextView pWQ;
  private TextView pWR;
  private TextView pWS;
  private boolean pWT = false;
  private Vibrator paT;
  
  public final void aiZ(String paramString)
  {
    AppMethodBeat.i(113048);
    com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    AppMethodBeat.o(113048);
  }
  
  public final void ajc(String paramString)
  {
    AppMethodBeat.i(113046);
    Log.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
    if (this.pWT)
    {
      Log.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
      AppMethodBeat.o(113046);
      return;
    }
    Log.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
    this.pWT = true;
    Intent localIntent = new Intent(this, CardConsumeSuccessUI.class);
    localIntent.putExtra("KEY_CARD_ID", this.pQV.csU());
    localIntent.putExtra("KEY_CARD_CONSUMED_JSON", paramString);
    localIntent.putExtra("KEY_CARD_COLOR", this.pQV.csQ().ixw);
    localIntent.putExtra("key_stastic_scene", this.gwE);
    localIntent.putExtra("key_from_scene", 0);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113046);
  }
  
  public final void ctk()
  {
    AppMethodBeat.i(113047);
    this.pWI.cuE();
    AppMethodBeat.o(113047);
  }
  
  public final void ctp()
  {
    AppMethodBeat.i(113044);
    this.paT.vibrate(300L);
    AppMethodBeat.o(113044);
  }
  
  public final void ctq()
  {
    AppMethodBeat.i(113045);
    Log.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
    finish();
    AppMethodBeat.o(113045);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113043);
    Log.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
    if ((paramb != null) && (paramb.csU() != null) && (paramb.csU().equals(this.pQV.csU())))
    {
      this.pQV = paramb;
      this.pWI.pQV = this.pQV;
      this.pWI.cuE();
    }
    AppMethodBeat.o(113043);
  }
  
  public int getLayoutId()
  {
    return 2131493351;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113038);
    Object localObject1;
    label411:
    int i;
    if (this.pQV.csx())
    {
      if (!TextUtils.isEmpty(this.pQV.csQ().pTn)) {
        setMMTitle(getString(2131756984, new Object[] { this.pQV.csQ().pTn }));
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
      if (this.pWI == null)
      {
        this.pWI = new a(this, getContentView());
        localObject1 = this.pWI;
        ((a)localObject1).pWC = ((a)localObject1).pQZ.getWindow().getAttributes().screenBrightness;
        localObject1 = this.pWI;
        ((a)localObject1).pWv = ((TextView)((a)localObject1).jBN.findViewById(2131298181));
        ((a)localObject1).pWw = ((TextView)((a)localObject1).jBN.findViewById(2131298190));
        ((a)localObject1).pWx = ((CheckBox)((a)localObject1).jBN.findViewById(2131305552));
        ((a)localObject1).pWx.setChecked(true);
        ((a)localObject1).pWx.setOnClickListener(((a)localObject1).kuO);
        if (((a)localObject1).pWC < 0.8F) {
          ((a)localObject1).bc(0.8F);
        }
        this.pWI.pWB = new a.a()
        {
          public final void Em(int paramAnonymousInt)
          {
            AppMethodBeat.i(113036);
            am.cuc().V(CardConsumeCodeUI.a(CardConsumeCodeUI.this).csU(), paramAnonymousInt, 1);
            AppMethodBeat.o(113036);
          }
        };
      }
      this.pWI.pQV = this.pQV;
      this.pWI.pWA = true;
      Object localObject2;
      if (this.pQV.csw())
      {
        localObject1 = this.pWI;
        localObject2 = this.pWF;
        ((a)localObject1).pWz = 1;
        ((a)localObject1).pWy = ((String)localObject2);
      }
      this.paT = ((Vibrator)getSystemService("vibrator"));
      this.pWJ = ((TextView)findViewById(2131297733));
      this.pWK = ((TextView)findViewById(2131309195));
      this.pWL = ((LinearLayout)findViewById(2131296953));
      this.pWM = ((ImageView)findViewById(2131296952));
      this.pWN = findViewById(2131299407);
      this.pWO = ((LinearLayout)findViewById(2131298807));
      if (!this.pQV.csx()) {
        break label1007;
      }
      findViewById(2131298084).setBackgroundColor(getResources().getColor(2131100115));
      n.d(this);
      if ((!this.pQV.csx()) || (TextUtils.isEmpty(this.pQV.csQ().iwv))) {
        break label1045;
      }
      this.pWL.setVisibility(0);
      this.pWJ.setVisibility(8);
      this.pWK.setVisibility(8);
      this.pWN.setVisibility(8);
      i = getResources().getDimensionPixelSize(2131165994);
      n.a(this.pWM, this.pQV.csQ().iwv, i, 2131234198, true);
      label511:
      if (this.pQV.csQ().Lfe != null)
      {
        localObject1 = this.pQV.csQ().Lfe;
        if (!TextUtils.isEmpty(((abz)localObject1).title))
        {
          if (this.pWP == null) {
            this.pWP = ((ViewStub)findViewById(2131298191)).inflate();
          }
          this.pWP.setOnClickListener(this);
          this.pWQ = ((TextView)this.pWP.findViewById(2131298193));
          this.pWR = ((TextView)this.pWP.findViewById(2131298192));
          this.pWS = ((TextView)this.pWP.findViewById(2131298189));
          this.pWQ.setVisibility(0);
          this.pWQ.setText(((abz)localObject1).title);
          localObject2 = getResources().getDrawable(2131231500);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Drawable)localObject2).setColorFilter(com.tencent.mm.plugin.card.d.l.ake(this.pQV.csQ().ixw), PorterDuff.Mode.SRC_IN);
          this.pWQ.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          this.pWQ.setTextColor(com.tencent.mm.plugin.card.d.l.ake(this.pQV.csQ().ixw));
          this.pWQ.setOnClickListener(this);
          if (TextUtils.isEmpty(((abz)localObject1).pRY)) {
            break label1086;
          }
          this.pWR.setVisibility(0);
          this.pWR.setText(((abz)localObject1).pRY);
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((abz)localObject1).pRZ))
      {
        this.pWS.setVisibility(0);
        this.pWS.setText(((abz)localObject1).pRZ);
      }
      localObject1 = this.pWM.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(2131165995);
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(2131165995);
      this.pWM.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.pWL.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(this, 54);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.fromDPToPix(this, 54);
      this.pWL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = getResources().getDimensionPixelSize(2131165995);
      n.a(this.pWM, this.pQV.csQ().iwv, i, 2131234198, true);
      this.pWO.setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this, 10), 0, com.tencent.mm.cb.a.fromDPToPix(this, 30));
      am.cub().a(this);
      if (!this.pQV.csK()) {
        break label1134;
      }
      am.cud().a(this);
      if (am.cud().isEmpty()) {
        break label1111;
      }
      am.cud().cti();
      AppMethodBeat.o(113038);
      return;
      setMMTitle(getString(2131756984, new Object[] { getString(2131757100) }));
      break;
      label1007:
      i = com.tencent.mm.plugin.card.d.l.ake(this.pQV.csQ().ixw);
      findViewById(2131298084).setBackgroundColor(i);
      n.a(this, this.pQV);
      break label411;
      label1045:
      this.pWJ.setText(this.pQV.csQ().gTG);
      this.pWK.setText(this.pQV.csQ().title);
      break label511;
      label1086:
      this.pWR.setVisibility(0);
      this.pWR.setText(getString(2131757101));
    }
    label1111:
    Log.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
    am.cud().aja(this.pQV.csU());
    label1134:
    AppMethodBeat.o(113038);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113050);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((paramView.getId() == 2131298193) || (paramView.getId() == 2131298188))
    {
      if (!this.pQV.csJ()) {
        break label121;
      }
      paramView = new j.b();
      com.tencent.mm.plugin.card.d.b.a(this, paramView.pRN, paramView.pRO, false, this.pQV);
    }
    for (;;)
    {
      finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113050);
      return;
      label121:
      paramView = this.pQV.csQ().Lfe;
      if ((!com.tencent.mm.plugin.card.d.b.a(this.pQV.csU(), paramView, this.pWG, this.pWH)) && (paramView != null) && (!TextUtils.isEmpty(paramView.url)))
      {
        com.tencent.mm.plugin.card.d.b.a(this, com.tencent.mm.plugin.card.d.l.Y(paramView.url, paramView.LfD), 1);
        h.CyF.a(11941, new Object[] { Integer.valueOf(9), this.pQV.csU(), this.pQV.csV(), "", paramView.title });
        if (com.tencent.mm.plugin.card.d.l.a(paramView, this.pQV.csU()))
        {
          com.tencent.mm.plugin.card.d.l.akj(this.pQV.csU());
          com.tencent.mm.plugin.card.d.b.b(this, this.pQV.csQ().gTG);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113037);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
    setResult(0);
    this.pQV = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    this.gwE = getIntent().getIntExtra("key_from_scene", 3);
    this.pWG = getIntent().getIntExtra("key_previous_scene", 3);
    this.pWF = getIntent().getStringExtra("key_mark_user");
    this.pWH = getIntent().getIntExtra("key_from_appbrand_type", 0);
    if ((this.pQV == null) || (this.pQV.csQ() == null) || (this.pQV.csR() == null))
    {
      Log.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113037);
      return;
    }
    initView();
    am.ctW().G("", "", 3);
    AppMethodBeat.o(113037);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113041);
    a locala = this.pWI;
    locala.bc(locala.pWC);
    com.tencent.mm.plugin.card.d.l.Z(locala.kuJ);
    com.tencent.mm.plugin.card.d.l.Z(locala.pWu);
    locala.pWB = null;
    locala.pQZ = null;
    am.cub().c(this);
    am.cub().b(this);
    if (this.pQV.csK())
    {
      am.cud().b(this);
      am.cud().ctj();
    }
    this.paT.cancel();
    super.onDestroy();
    AppMethodBeat.o(113041);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113042);
    if (paramInt == 4)
    {
      Log.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
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
    am.cub().a(this, false);
    super.onPause();
    AppMethodBeat.o(113040);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113039);
    this.pWI.cuE();
    am.cub().a(this, true);
    super.onResume();
    AppMethodBeat.o(113039);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113049);
    this.pWI.cuE();
    AppMethodBeat.o(113049);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI
 * JD-Core Version:    0.7.0.1
 */