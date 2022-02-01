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
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.c.a;
import com.tencent.mm.plugin.card.b.d.a;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI
  extends MMActivity
  implements View.OnClickListener, c.a, d.a
{
  private final String TAG = "MicroMsg.CardConsumeCodeUI";
  private int jaR = 3;
  private Vibrator rqC;
  private com.tencent.mm.plugin.card.base.b tmU;
  private String tsC;
  private int tsD = 3;
  private int tsE = 0;
  private a tsF;
  private TextView tsG;
  private TextView tsH;
  private LinearLayout tsI;
  private ImageView tsJ;
  private View tsK;
  private LinearLayout tsL;
  private View tsM;
  private TextView tsN;
  private TextView tsO;
  private TextView tsP;
  private boolean tsQ = false;
  
  public final void aqM(String paramString)
  {
    AppMethodBeat.i(113048);
    com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    AppMethodBeat.o(113048);
  }
  
  public final void aqP(String paramString)
  {
    AppMethodBeat.i(113046);
    Log.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
    if (this.tsQ)
    {
      Log.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
      AppMethodBeat.o(113046);
      return;
    }
    Log.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
    this.tsQ = true;
    Intent localIntent = new Intent(this, CardConsumeSuccessUI.class);
    localIntent.putExtra("KEY_CARD_ID", this.tmU.cGw());
    localIntent.putExtra("KEY_CARD_CONSUMED_JSON", paramString);
    localIntent.putExtra("KEY_CARD_COLOR", this.tmU.cGs().lmL);
    localIntent.putExtra("key_stastic_scene", this.jaR);
    localIntent.putExtra("key_from_scene", 0);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113046);
  }
  
  public final void cGM()
  {
    AppMethodBeat.i(113047);
    this.tsF.cIg();
    AppMethodBeat.o(113047);
  }
  
  public final void cGR()
  {
    AppMethodBeat.i(113044);
    this.rqC.vibrate(300L);
    AppMethodBeat.o(113044);
  }
  
  public final void cGS()
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
    if ((paramb != null) && (paramb.cGw() != null) && (paramb.cGw().equals(this.tmU.cGw())))
    {
      this.tmU = paramb;
      this.tsF.tmU = this.tmU;
      this.tsF.cIg();
    }
    AppMethodBeat.o(113043);
  }
  
  public int getLayoutId()
  {
    return a.e.thT;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113038);
    Object localObject1;
    label412:
    int i;
    if (this.tmU.cFY())
    {
      if (!TextUtils.isEmpty(this.tmU.cGs().tpo)) {
        setMMTitle(getString(a.g.tjU, new Object[] { this.tmU.cGs().tpo }));
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
      if (this.tsF == null)
      {
        this.tsF = new a(this, getContentView());
        localObject1 = this.tsF;
        ((a)localObject1).tsz = ((a)localObject1).tmY.getWindow().getAttributes().screenBrightness;
        localObject1 = this.tsF;
        ((a)localObject1).tss = ((TextView)((a)localObject1).mrI.findViewById(a.d.tcX));
        ((a)localObject1).tst = ((TextView)((a)localObject1).mrI.findViewById(a.d.tdd));
        ((a)localObject1).tsu = ((CheckBox)((a)localObject1).mrI.findViewById(a.d.tgm));
        ((a)localObject1).tsu.setChecked(true);
        ((a)localObject1).tsu.setOnClickListener(((a)localObject1).nmC);
        if (((a)localObject1).tsz < 0.8F) {
          ((a)localObject1).bb(0.8F);
        }
        this.tsF.tsy = new a.a()
        {
          public final void HN(int paramAnonymousInt)
          {
            AppMethodBeat.i(113036);
            am.cHE().X(CardConsumeCodeUI.a(CardConsumeCodeUI.this).cGw(), paramAnonymousInt, 1);
            AppMethodBeat.o(113036);
          }
        };
      }
      this.tsF.tmU = this.tmU;
      this.tsF.tsx = true;
      Object localObject2;
      if (this.tmU.cFX())
      {
        localObject1 = this.tsF;
        localObject2 = this.tsC;
        ((a)localObject1).tsw = 1;
        ((a)localObject1).tsv = ((String)localObject2);
      }
      this.rqC = ((Vibrator)getSystemService("vibrator"));
      this.tsG = ((TextView)findViewById(a.d.taR));
      this.tsH = ((TextView)findViewById(a.d.title));
      this.tsI = ((LinearLayout)findViewById(a.d.taG));
      this.tsJ = ((ImageView)findViewById(a.d.taF));
      this.tsK = findViewById(a.d.dash_line);
      this.tsL = ((LinearLayout)findViewById(a.d.tfg));
      if (!this.tmU.cFY()) {
        break label1009;
      }
      findViewById(a.d.tbH).setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.sZs));
      n.e(this);
      if ((!this.tmU.cFY()) || (TextUtils.isEmpty(this.tmU.cGs().llI))) {
        break label1047;
      }
      this.tsI.setVisibility(0);
      this.tsG.setVisibility(8);
      this.tsH.setVisibility(8);
      this.tsK.setVisibility(8);
      i = getResources().getDimensionPixelSize(a.b.sZF);
      n.a(this.tsJ, this.tmU.cGs().llI, i, a.c.my_card_package_defaultlogo, true);
      label512:
      if (this.tmU.cGs().Sgs != null)
      {
        localObject1 = this.tmU.cGs().Sgs;
        if (!TextUtils.isEmpty(((acg)localObject1).title))
        {
          if (this.tsM == null) {
            this.tsM = ((ViewStub)findViewById(a.d.tde)).inflate();
          }
          this.tsM.setOnClickListener(this);
          this.tsN = ((TextView)this.tsM.findViewById(a.d.tdg));
          this.tsO = ((TextView)this.tsM.findViewById(a.d.tdf));
          this.tsP = ((TextView)this.tsM.findViewById(a.d.tdc));
          this.tsN.setVisibility(0);
          this.tsN.setText(((acg)localObject1).title);
          localObject2 = getResources().getDrawable(a.c.tad);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Drawable)localObject2).setColorFilter(com.tencent.mm.plugin.card.d.l.arR(this.tmU.cGs().lmL), PorterDuff.Mode.SRC_IN);
          this.tsN.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          this.tsN.setTextColor(com.tencent.mm.plugin.card.d.l.arR(this.tmU.cGs().lmL));
          this.tsN.setOnClickListener(this);
          if (TextUtils.isEmpty(((acg)localObject1).tnY)) {
            break label1088;
          }
          this.tsO.setVisibility(0);
          this.tsO.setText(((acg)localObject1).tnY);
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((acg)localObject1).tnZ))
      {
        this.tsP.setVisibility(0);
        this.tsP.setText(((acg)localObject1).tnZ);
      }
      localObject1 = this.tsJ.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(a.b.sZG);
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(a.b.sZG);
      this.tsJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.tsI.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.fromDPToPix(this, 54);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.ci.a.fromDPToPix(this, 54);
      this.tsI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = getResources().getDimensionPixelSize(a.b.sZG);
      n.a(this.tsJ, this.tmU.cGs().llI, i, a.c.my_card_package_defaultlogo, true);
      this.tsL.setPadding(0, com.tencent.mm.ci.a.fromDPToPix(this, 10), 0, com.tencent.mm.ci.a.fromDPToPix(this, 30));
      am.cHD().a(this);
      if (!this.tmU.cGl()) {
        break label1136;
      }
      am.cHF().a(this);
      if (am.cHF().isEmpty()) {
        break label1113;
      }
      am.cHF().cGK();
      AppMethodBeat.o(113038);
      return;
      setMMTitle(getString(a.g.tjU, new Object[] { getString(a.g.tiT) }));
      break;
      label1009:
      i = com.tencent.mm.plugin.card.d.l.arR(this.tmU.cGs().lmL);
      findViewById(a.d.tbH).setBackgroundColor(i);
      n.a(this, this.tmU);
      break label412;
      label1047:
      this.tsG.setText(this.tmU.cGs().jEi);
      this.tsH.setText(this.tmU.cGs().title);
      break label512;
      label1088:
      this.tsO.setVisibility(0);
      this.tsO.setText(getString(a.g.tkX));
    }
    label1113:
    Log.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
    am.cHF().aqN(this.tmU.cGw());
    label1136:
    AppMethodBeat.o(113038);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113050);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((paramView.getId() == a.d.tdg) || (paramView.getId() == a.d.tdb))
    {
      if (!this.tmU.cGk()) {
        break label121;
      }
      paramView = new j.b();
      com.tencent.mm.plugin.card.d.b.a(this, paramView.tnN, paramView.tnO, false, this.tmU);
    }
    for (;;)
    {
      finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113050);
      return;
      label121:
      paramView = this.tmU.cGs().Sgs;
      if ((!com.tencent.mm.plugin.card.d.b.a(this.tmU.cGw(), paramView, this.tsD, this.tsE)) && (paramView != null) && (!TextUtils.isEmpty(paramView.url)))
      {
        com.tencent.mm.plugin.card.d.b.a(this, com.tencent.mm.plugin.card.d.l.Z(paramView.url, paramView.SgR), 1);
        h.IzE.a(11941, new Object[] { Integer.valueOf(9), this.tmU.cGw(), this.tmU.cGx(), "", paramView.title });
        if (com.tencent.mm.plugin.card.d.l.a(paramView, this.tmU.cGw()))
        {
          com.tencent.mm.plugin.card.d.l.arW(this.tmU.cGw());
          com.tencent.mm.plugin.card.d.b.b(this, this.tmU.cGs().jEi);
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
    this.tmU = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    this.jaR = getIntent().getIntExtra("key_from_scene", 3);
    this.tsD = getIntent().getIntExtra("key_previous_scene", 3);
    this.tsC = getIntent().getStringExtra("key_mark_user");
    this.tsE = getIntent().getIntExtra("key_from_appbrand_type", 0);
    if ((this.tmU == null) || (this.tmU.cGs() == null) || (this.tmU.cGt() == null))
    {
      Log.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113037);
      return;
    }
    initView();
    am.cHy().K("", "", 3);
    AppMethodBeat.o(113037);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113041);
    a locala = this.tsF;
    locala.bb(locala.tsz);
    com.tencent.mm.plugin.card.d.l.X(locala.nmx);
    com.tencent.mm.plugin.card.d.l.X(locala.tsr);
    locala.tsy = null;
    locala.tmY = null;
    am.cHD().c(this);
    am.cHD().b(this);
    if (this.tmU.cGl())
    {
      am.cHF().b(this);
      am.cHF().cGL();
    }
    this.rqC.cancel();
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
    am.cHD().a(this, false);
    super.onPause();
    AppMethodBeat.o(113040);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113039);
    this.tsF.cIg();
    am.cHD().a(this, true);
    super.onResume();
    AppMethodBeat.o(113039);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113049);
    this.tsF.cIg();
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