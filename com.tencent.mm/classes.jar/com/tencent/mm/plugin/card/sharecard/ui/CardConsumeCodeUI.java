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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI
  extends MMActivity
  implements View.OnClickListener, c.a, d.a
{
  private final String TAG = "MicroMsg.CardConsumeCodeUI";
  private int fRv = 3;
  private Vibrator nQa;
  private com.tencent.mm.plugin.card.base.b oDm;
  private String oIR;
  private int oIS = 3;
  private int oIT = 0;
  private a oIU;
  private TextView oIV;
  private TextView oIW;
  private LinearLayout oIX;
  private ImageView oIY;
  private View oIZ;
  private LinearLayout oJa;
  private View oJb;
  private TextView oJc;
  private TextView oJd;
  private TextView oJe;
  private boolean oJf = false;
  
  public final void YU(String paramString)
  {
    AppMethodBeat.i(113048);
    com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    AppMethodBeat.o(113048);
  }
  
  public final void YX(String paramString)
  {
    AppMethodBeat.i(113046);
    ae.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
    if (this.oJf)
    {
      ae.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
      AppMethodBeat.o(113046);
      return;
    }
    ae.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
    this.oJf = true;
    Intent localIntent = new Intent(this, CardConsumeSuccessUI.class);
    localIntent.putExtra("KEY_CARD_ID", this.oDm.bVg());
    localIntent.putExtra("KEY_CARD_CONSUMED_JSON", paramString);
    localIntent.putExtra("KEY_CARD_COLOR", this.oDm.bVc().hDr);
    localIntent.putExtra("key_stastic_scene", this.fRv);
    localIntent.putExtra("key_from_scene", 0);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113046);
  }
  
  public final void bVB()
  {
    AppMethodBeat.i(113044);
    this.nQa.vibrate(300L);
    AppMethodBeat.o(113044);
  }
  
  public final void bVC()
  {
    AppMethodBeat.i(113045);
    ae.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
    finish();
    AppMethodBeat.o(113045);
  }
  
  public final void bVw()
  {
    AppMethodBeat.i(113047);
    this.oIU.bWN();
    AppMethodBeat.o(113047);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113043);
    ae.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
    if ((paramb != null) && (paramb.bVg() != null) && (paramb.bVg().equals(this.oDm.bVg())))
    {
      this.oDm = paramb;
      this.oIU.oDm = this.oDm;
      this.oIU.bWN();
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
    if (this.oDm.bUJ())
    {
      if (!TextUtils.isEmpty(this.oDm.bVc().oFF)) {
        setMMTitle(getString(2131756819, new Object[] { this.oDm.bVc().oFF }));
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
      if (this.oIU == null)
      {
        this.oIU = new a(this, getContentView());
        localObject1 = this.oIU;
        ((a)localObject1).oIO = ((a)localObject1).oDq.getWindow().getAttributes().screenBrightness;
        localObject1 = this.oIU;
        ((a)localObject1).oIH = ((TextView)((a)localObject1).iFK.findViewById(2131297865));
        ((a)localObject1).oII = ((TextView)((a)localObject1).iFK.findViewById(2131297873));
        ((a)localObject1).oIJ = ((CheckBox)((a)localObject1).iFK.findViewById(2131302965));
        ((a)localObject1).oIJ.setChecked(true);
        ((a)localObject1).oIJ.setOnClickListener(((a)localObject1).jwB);
        if (((a)localObject1).oIO < 0.8F) {
          ((a)localObject1).aV(0.8F);
        }
        this.oIU.oIN = new a.a()
        {
          public final void AH(int paramAnonymousInt)
          {
            AppMethodBeat.i(113036);
            am.bWo().U(CardConsumeCodeUI.a(CardConsumeCodeUI.this).bVg(), paramAnonymousInt, 1);
            AppMethodBeat.o(113036);
          }
        };
      }
      this.oIU.oDm = this.oDm;
      this.oIU.oIM = true;
      Object localObject2;
      if (this.oDm.bUI())
      {
        localObject1 = this.oIU;
        localObject2 = this.oIR;
        ((a)localObject1).oIL = 1;
        ((a)localObject1).oIK = ((String)localObject2);
      }
      this.nQa = ((Vibrator)getSystemService("vibrator"));
      this.oIV = ((TextView)findViewById(2131297507));
      this.oIW = ((TextView)findViewById(2131305902));
      this.oIX = ((LinearLayout)findViewById(2131296860));
      this.oIY = ((ImageView)findViewById(2131296859));
      this.oIZ = findViewById(2131298923);
      this.oJa = ((LinearLayout)findViewById(2131298398));
      if (!this.oDm.bUJ()) {
        break label1007;
      }
      findViewById(2131297770).setBackgroundColor(getResources().getColor(2131100084));
      n.d(this);
      if ((!this.oDm.bUJ()) || (TextUtils.isEmpty(this.oDm.bVc().hCp))) {
        break label1045;
      }
      this.oIX.setVisibility(0);
      this.oIV.setVisibility(8);
      this.oIW.setVisibility(8);
      this.oIZ.setVisibility(8);
      i = getResources().getDimensionPixelSize(2131165962);
      n.a(this.oIY, this.oDm.bVc().hCp, i, 2131233400, true);
      label511:
      if (this.oDm.bVc().GkB != null)
      {
        localObject1 = this.oDm.bVc().GkB;
        if (!TextUtils.isEmpty(((aai)localObject1).title))
        {
          if (this.oJb == null) {
            this.oJb = ((ViewStub)findViewById(2131297874)).inflate();
          }
          this.oJb.setOnClickListener(this);
          this.oJc = ((TextView)this.oJb.findViewById(2131297876));
          this.oJd = ((TextView)this.oJb.findViewById(2131297875));
          this.oJe = ((TextView)this.oJb.findViewById(2131297872));
          this.oJc.setVisibility(0);
          this.oJc.setText(((aai)localObject1).title);
          localObject2 = getResources().getDrawable(2131231436);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Drawable)localObject2).setColorFilter(com.tencent.mm.plugin.card.d.l.ZY(this.oDm.bVc().hDr), PorterDuff.Mode.SRC_IN);
          this.oJc.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          this.oJc.setTextColor(com.tencent.mm.plugin.card.d.l.ZY(this.oDm.bVc().hDr));
          this.oJc.setOnClickListener(this);
          if (TextUtils.isEmpty(((aai)localObject1).oEp)) {
            break label1086;
          }
          this.oJd.setVisibility(0);
          this.oJd.setText(((aai)localObject1).oEp);
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((aai)localObject1).oEq))
      {
        this.oJe.setVisibility(0);
        this.oJe.setText(((aai)localObject1).oEq);
      }
      localObject1 = this.oIY.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(2131165963);
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(2131165963);
      this.oIY.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.oIX.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(this, 54);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cb.a.fromDPToPix(this, 54);
      this.oIX.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = getResources().getDimensionPixelSize(2131165963);
      n.a(this.oIY, this.oDm.bVc().hCp, i, 2131233400, true);
      this.oJa.setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this, 10), 0, com.tencent.mm.cb.a.fromDPToPix(this, 30));
      am.bWn().a(this);
      if (!this.oDm.bUW()) {
        break label1134;
      }
      am.bWp().a(this);
      if (am.bWp().isEmpty()) {
        break label1111;
      }
      am.bWp().bVu();
      AppMethodBeat.o(113038);
      return;
      setMMTitle(getString(2131756819, new Object[] { getString(2131756930) }));
      break;
      label1007:
      i = com.tencent.mm.plugin.card.d.l.ZY(this.oDm.bVc().hDr);
      findViewById(2131297770).setBackgroundColor(i);
      n.a(this, this.oDm);
      break label411;
      label1045:
      this.oIV.setText(this.oDm.bVc().oFG);
      this.oIW.setText(this.oDm.bVc().title);
      break label511;
      label1086:
      this.oJd.setVisibility(0);
      this.oJd.setText(getString(2131756931));
    }
    label1111:
    ae.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
    am.bWp().YV(this.oDm.bVg());
    label1134:
    AppMethodBeat.o(113038);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113050);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((paramView.getId() == 2131297876) || (paramView.getId() == 2131297871))
    {
      if (!this.oDm.bUV()) {
        break label121;
      }
      paramView = new j.b();
      com.tencent.mm.plugin.card.d.b.a(this, paramView.oEe, paramView.oEf, false, this.oDm);
    }
    for (;;)
    {
      finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113050);
      return;
      label121:
      paramView = this.oDm.bVc().GkB;
      if ((!com.tencent.mm.plugin.card.d.b.a(this.oDm.bVg(), paramView, this.oIS, this.oIT)) && (paramView != null) && (!TextUtils.isEmpty(paramView.url)))
      {
        com.tencent.mm.plugin.card.d.b.a(this, com.tencent.mm.plugin.card.d.l.Z(paramView.url, paramView.GkZ), 1);
        g.yxI.f(11941, new Object[] { Integer.valueOf(9), this.oDm.bVg(), this.oDm.bVh(), "", paramView.title });
        if (com.tencent.mm.plugin.card.d.l.a(paramView, this.oDm.bVg()))
        {
          com.tencent.mm.plugin.card.d.l.aad(this.oDm.bVg());
          com.tencent.mm.plugin.card.d.b.b(this, this.oDm.bVc().oFG);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113037);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
    setResult(0);
    this.oDm = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    this.fRv = getIntent().getIntExtra("key_from_scene", 3);
    this.oIS = getIntent().getIntExtra("key_previous_scene", 3);
    this.oIR = getIntent().getStringExtra("key_mark_user");
    this.oIT = getIntent().getIntExtra("key_from_appbrand_type", 0);
    if ((this.oDm == null) || (this.oDm.bVc() == null) || (this.oDm.bVd() == null))
    {
      ae.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113037);
      return;
    }
    initView();
    am.bWi().H("", "", 3);
    AppMethodBeat.o(113037);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113041);
    a locala = this.oIU;
    locala.aV(locala.oIO);
    com.tencent.mm.plugin.card.d.l.U(locala.jww);
    com.tencent.mm.plugin.card.d.l.U(locala.oIG);
    locala.oIN = null;
    locala.oDq = null;
    am.bWn().c(this);
    am.bWn().b(this);
    if (this.oDm.bUW())
    {
      am.bWp().b(this);
      am.bWp().bVv();
    }
    this.nQa.cancel();
    super.onDestroy();
    AppMethodBeat.o(113041);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113042);
    if (paramInt == 4)
    {
      ae.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
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
    am.bWn().a(this, false);
    super.onPause();
    AppMethodBeat.o(113040);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113039);
    this.oIU.bWN();
    am.bWn().a(this, true);
    super.onResume();
    AppMethodBeat.o(113039);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113049);
    this.oIU.bWN();
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