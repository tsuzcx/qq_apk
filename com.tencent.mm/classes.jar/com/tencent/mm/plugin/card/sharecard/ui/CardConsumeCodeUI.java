package com.tencent.mm.plugin.card.sharecard.ui;

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
import com.tencent.mm.plugin.card.c.d;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.mgr.b.a;
import com.tencent.mm.plugin.card.mgr.c;
import com.tencent.mm.plugin.card.mgr.c.a;
import com.tencent.mm.plugin.card.mgr.i;
import com.tencent.mm.plugin.card.mgr.i.b;
import com.tencent.mm.plugin.card.mgr.k;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI
  extends MMActivity
  implements View.OnClickListener, b.a, c.a
{
  private final String TAG = "MicroMsg.CardConsumeCodeUI";
  private int lCR = 3;
  private Vibrator uAL;
  private com.tencent.mm.plugin.card.base.b wru;
  private String wwZ;
  private int wxa = 3;
  private int wxb = 0;
  private a wxc;
  private TextView wxd;
  private TextView wxe;
  private LinearLayout wxf;
  private ImageView wxg;
  private View wxh;
  private LinearLayout wxi;
  private View wxj;
  private TextView wxk;
  private TextView wxl;
  private TextView wxm;
  private boolean wxn = false;
  
  public final void akr(String paramString)
  {
    AppMethodBeat.i(113048);
    d.a(this, paramString, true);
    AppMethodBeat.o(113048);
  }
  
  public final void aku(String paramString)
  {
    AppMethodBeat.i(113046);
    Log.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
    if (this.wxn)
    {
      Log.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
      AppMethodBeat.o(113046);
      return;
    }
    Log.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
    this.wxn = true;
    Intent localIntent = new Intent(this, CardConsumeSuccessUI.class);
    localIntent.putExtra("KEY_CARD_ID", this.wru.djO());
    localIntent.putExtra("KEY_CARD_CONSUMED_JSON", paramString);
    localIntent.putExtra("KEY_CARD_COLOR", this.wru.djK().nRQ);
    localIntent.putExtra("key_stastic_scene", this.lCR);
    localIntent.putExtra("key_from_scene", 0);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(113046);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113043);
    Log.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
    if ((paramb != null) && (paramb.djO() != null) && (paramb.djO().equals(this.wru.djO())))
    {
      this.wru = paramb;
      this.wxc.wru = this.wru;
      this.wxc.dlx();
    }
    AppMethodBeat.o(113043);
  }
  
  public final void dkd()
  {
    AppMethodBeat.i(113047);
    this.wxc.dlx();
    AppMethodBeat.o(113047);
  }
  
  public final void dki()
  {
    AppMethodBeat.i(113044);
    this.uAL.vibrate(300L);
    AppMethodBeat.o(113044);
  }
  
  public final void dkj()
  {
    AppMethodBeat.i(113045);
    Log.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
    finish();
    AppMethodBeat.o(113045);
  }
  
  public int getLayoutId()
  {
    return a.e.wms;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113038);
    Object localObject1;
    label412:
    int i;
    if (this.wru.djq())
    {
      if (!TextUtils.isEmpty(this.wru.djK().wtN)) {
        setMMTitle(getString(a.g.wor, new Object[] { this.wru.djK().wtN }));
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
      if (this.wxc == null)
      {
        this.wxc = new a(this, getContentView());
        localObject1 = this.wxc;
        ((a)localObject1).wwW = ((a)localObject1).wry.getWindow().getAttributes().screenBrightness;
        localObject1 = this.wxc;
        ((a)localObject1).wwP = ((TextView)((a)localObject1).plc.findViewById(a.d.whl));
        ((a)localObject1).wwQ = ((TextView)((a)localObject1).plc.findViewById(a.d.whr));
        ((a)localObject1).wwR = ((CheckBox)((a)localObject1).plc.findViewById(a.d.wkI));
        ((a)localObject1).wwR.setChecked(true);
        ((a)localObject1).wwR.setOnClickListener(((a)localObject1).qjL);
        if (((a)localObject1).wwW < 0.8F) {
          ((a)localObject1).ce(0.8F);
        }
        this.wxc.wwV = new a.a()
        {
          public final void Io(int paramAnonymousInt)
          {
            AppMethodBeat.i(113036);
            am.dkV().ab(CardConsumeCodeUI.a(CardConsumeCodeUI.this).djO(), paramAnonymousInt, 1);
            AppMethodBeat.o(113036);
          }
        };
      }
      this.wxc.wru = this.wru;
      this.wxc.wwU = true;
      Object localObject2;
      if (this.wru.djp())
      {
        localObject1 = this.wxc;
        localObject2 = this.wwZ;
        ((a)localObject1).wwT = 1;
        ((a)localObject1).wwS = ((String)localObject2);
      }
      this.uAL = ((Vibrator)getSystemService("vibrator"));
      this.wxd = ((TextView)findViewById(a.d.wfb));
      this.wxe = ((TextView)findViewById(a.d.title));
      this.wxf = ((LinearLayout)findViewById(a.d.weQ));
      this.wxg = ((ImageView)findViewById(a.d.weP));
      this.wxh = findViewById(a.d.wjT);
      this.wxi = ((LinearLayout)findViewById(a.d.wjx));
      if (!this.wru.djq()) {
        break label1009;
      }
      findViewById(a.d.wfU).setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.wdB));
      n.f(this);
      if ((!this.wru.djq()) || (TextUtils.isEmpty(this.wru.djK().nQG))) {
        break label1047;
      }
      this.wxf.setVisibility(0);
      this.wxd.setVisibility(8);
      this.wxe.setVisibility(8);
      this.wxh.setVisibility(8);
      i = getResources().getDimensionPixelSize(a.b.wdM);
      n.a(this.wxg, this.wru.djK().nQG, i, a.c.my_card_package_defaultlogo, true);
      label512:
      if (this.wru.djK().Zen != null)
      {
        localObject1 = this.wru.djK().Zen;
        if (!TextUtils.isEmpty(((aek)localObject1).title))
        {
          if (this.wxj == null) {
            this.wxj = ((ViewStub)findViewById(a.d.whs)).inflate();
          }
          this.wxj.setOnClickListener(this);
          this.wxk = ((TextView)this.wxj.findViewById(a.d.whu));
          this.wxl = ((TextView)this.wxj.findViewById(a.d.wht));
          this.wxm = ((TextView)this.wxj.findViewById(a.d.whq));
          this.wxk.setVisibility(0);
          this.wxk.setText(((aek)localObject1).title);
          localObject2 = getResources().getDrawable(a.c.wel);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Drawable)localObject2).setColorFilter(l.alv(this.wru.djK().nRQ), PorterDuff.Mode.SRC_IN);
          this.wxk.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          this.wxk.setTextColor(l.alv(this.wru.djK().nRQ));
          this.wxk.setOnClickListener(this);
          if (TextUtils.isEmpty(((aek)localObject1).wsz)) {
            break label1088;
          }
          this.wxl.setVisibility(0);
          this.wxl.setText(((aek)localObject1).wsz);
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((aek)localObject1).wsA))
      {
        this.wxm.setVisibility(0);
        this.wxm.setText(((aek)localObject1).wsA);
      }
      localObject1 = this.wxg.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(a.b.wdN);
      ((ViewGroup.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(a.b.wdN);
      this.wxg.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.wxf.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.fromDPToPix(this, 54);
      ((ViewGroup.LayoutParams)localObject1).width = com.tencent.mm.cd.a.fromDPToPix(this, 54);
      this.wxf.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = getResources().getDimensionPixelSize(a.b.wdN);
      n.a(this.wxg, this.wru.djK().nQG, i, a.c.my_card_package_defaultlogo, true);
      this.wxi.setPadding(0, com.tencent.mm.cd.a.fromDPToPix(this, 10), 0, com.tencent.mm.cd.a.fromDPToPix(this, 30));
      am.dkU().a(this);
      if (!this.wru.djD()) {
        break label1136;
      }
      am.dkW().a(this);
      if (am.dkW().isEmpty()) {
        break label1113;
      }
      am.dkW().dkb();
      AppMethodBeat.o(113038);
      return;
      setMMTitle(getString(a.g.wor, new Object[] { getString(a.g.wnq) }));
      break;
      label1009:
      i = l.alv(this.wru.djK().nRQ);
      findViewById(a.d.wfU).setBackgroundColor(i);
      n.a(this, this.wru);
      break label412;
      label1047:
      this.wxd.setText(this.wru.djK().mee);
      this.wxe.setText(this.wru.djK().title);
      break label512;
      label1088:
      this.wxl.setVisibility(0);
      this.wxl.setText(getString(a.g.wpw));
    }
    label1113:
    Log.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
    am.dkW().aks(this.wru.djO());
    label1136:
    AppMethodBeat.o(113038);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113050);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((paramView.getId() == a.d.whu) || (paramView.getId() == a.d.whp))
    {
      if (!this.wru.djC()) {
        break label121;
      }
      paramView = new i.b();
      com.tencent.mm.plugin.card.c.b.a(this, paramView.wso, paramView.wsp, false, this.wru);
    }
    for (;;)
    {
      finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113050);
      return;
      label121:
      paramView = this.wru.djK().Zen;
      if ((!com.tencent.mm.plugin.card.c.b.a(this.wru.djO(), paramView, this.wxa, this.wxb)) && (paramView != null) && (!TextUtils.isEmpty(paramView.url)))
      {
        com.tencent.mm.plugin.card.c.b.a(this, l.ad(paramView.url, paramView.ZeU), 1);
        h.OAn.b(11941, new Object[] { Integer.valueOf(9), this.wru.djO(), this.wru.djP(), "", paramView.title });
        if (l.a(paramView, this.wru.djO()))
        {
          l.alA(this.wru.djO());
          com.tencent.mm.plugin.card.c.b.a(this, this.wru.djK().mee);
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
    this.wru = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    this.lCR = getIntent().getIntExtra("key_from_scene", 3);
    this.wxa = getIntent().getIntExtra("key_previous_scene", 3);
    this.wwZ = getIntent().getStringExtra("key_mark_user");
    this.wxb = getIntent().getIntExtra("key_from_appbrand_type", 0);
    if ((this.wru == null) || (this.wru.djK() == null) || (this.wru.djL() == null))
    {
      Log.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
      finish();
      AppMethodBeat.o(113037);
      return;
    }
    initView();
    am.dkP().R("", "", 3);
    AppMethodBeat.o(113037);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113041);
    a locala = this.wxc;
    locala.ce(locala.wwW);
    l.ah(locala.qjG);
    l.ah(locala.wwO);
    locala.wwV = null;
    locala.wry = null;
    am.dkU().c(this);
    am.dkU().b(this);
    if (this.wru.djD())
    {
      am.dkW().b(this);
      am.dkW().dkc();
    }
    this.uAL.cancel();
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
    am.dkU().a(this, false);
    super.onPause();
    AppMethodBeat.o(113040);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113039);
    this.wxc.dlx();
    am.dkU().a(this, true);
    super.onResume();
    AppMethodBeat.o(113039);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113049);
    this.wxc.dlx();
    AppMethodBeat.o(113049);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI
 * JD-Core Version:    0.7.0.1
 */