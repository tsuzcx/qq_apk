package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.o;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.a.a;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.List;

@com.tencent.mm.ui.base.a(1)
public class BottleBeachUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.ah.f, m.a.a, m.b
{
  private View hYI;
  private FrameLayout hYJ;
  private ThrowBottleUI hYK;
  private PickBottleUI hYL;
  private OpenBottleUI hYM;
  private BallonImageView hYN;
  private LightHouseImageView hYO;
  private ImageView hYP;
  private MoonImageView hYQ;
  private ImageView hYR;
  private int hYS = 0;
  boolean hYT = true;
  private ImageView hYU;
  private ImageView hYV;
  private ImageView hYW;
  private TextView hYX;
  private d hYY;
  private b hYZ;
  private boolean hZa = true;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private void awQ()
  {
    boolean bool = this.hZa;
    fullScreenNoTitleBar(bool);
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      this.hZa = bool;
      return;
    }
  }
  
  private void awR()
  {
    if (this.hYX == null)
    {
      this.hYX = ((TextView)findViewById(R.h.bottle_list_unread_tv));
      this.hYX.setBackgroundResource(com.tencent.mm.ui.tools.q.hh(this.mController.uMN));
    }
    int i = com.tencent.mm.plugin.bottle.a.c.awH();
    this.hYX.setText(String.valueOf(i));
    TextView localTextView = this.hYX;
    if (i > 0) {}
    for (i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  private void oj(int paramInt)
  {
    if (paramInt > 0) {}
    for (String str = this.mController.uMN.getString(paramInt);; str = null)
    {
      if (this.hYY == null) {
        this.hYY = new d(this);
      }
      this.hYY.cancel();
      if (str != null)
      {
        this.hYY.setDuration(0);
        this.hYY.setText(str);
        this.hYY.show();
      }
      return;
    }
  }
  
  private void q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.v("MM.UI.BottleUI", "set frame visible");
    if (this.hYJ == null) {
      this.hYJ = ((FrameLayout)findViewById(R.h.bottle_float_frame_container));
    }
    this.hYI.setVisibility(paramInt1);
    if (paramInt1 == 0)
    {
      awR();
      this.hYR.setVisibility(8);
      XM();
    }
    Object localObject;
    if ((paramInt2 == 0) && (this.hYK == null))
    {
      this.hYK = ((ThrowBottleUI)View.inflate(this, R.i.bottle_throw, null));
      this.hYJ.addView(this.hYK);
      localObject = this.hYK;
      ((ThrowBottleUI)localObject).ibo = new ToneGenerator(1, 60);
      ((ThrowBottleUI)localObject).ibr = ((Vibrator)((ThrowBottleUI)localObject).hZZ.getSystemService("vibrator"));
      ((ThrowBottleUI)localObject).ibu = ((ImageView)((ThrowBottleUI)localObject).findViewById(R.h.bottle_record_volumn_hint));
      ((ThrowBottleUI)localObject).ibv = ((TextView)((ThrowBottleUI)localObject).findViewById(R.h.bottle_audio_status_img));
      ((ThrowBottleUI)localObject).ibv.setVisibility(8);
      ((ThrowBottleUI)localObject).ibw = ((ImageView)((ThrowBottleUI)localObject).findViewById(R.h.bottle_record_text_hint));
      ((ThrowBottleUI)localObject).ibx = ((MMEditText)((ThrowBottleUI)localObject).findViewById(R.h.bottle_throw_edittext));
      ((ThrowBottleUI)localObject).iby = ((ThrowBottleUI)localObject).findViewById(R.h.bottle_throw_bottom_margin_view);
      ((ThrowBottleUI)localObject).ibB = ((ThrowBottleFooter)((ThrowBottleUI)localObject).findViewById(R.h.bottle_throw_footer));
      ((ThrowBottleUI)localObject).iaw = ((ImageView)((ThrowBottleUI)localObject).hZZ.findViewById(R.h.bottle_close_frame_btn));
      ((ThrowBottleUI)localObject).ibA = ((ImageButton)((ThrowBottleUI)localObject).findViewById(R.h.bottle_attach_btn));
      ((ThrowBottleUI)localObject).ibA.setOnClickListener((View.OnClickListener)localObject);
      ((ThrowBottleUI)localObject).ibz = ((Button)((ThrowBottleUI)localObject).findViewById(R.h.bottle_throw_btn));
      ((ThrowBottleUI)localObject).ibz.setOnTouchListener(new ThrowBottleUI.2((ThrowBottleUI)localObject));
      ((ThrowBottleUI)localObject).setOnClickListener((View.OnClickListener)localObject);
      if (((ThrowBottleUI)localObject).ibE == null)
      {
        ((ThrowBottleUI)localObject).ibE = ((LinearLayout.LayoutParams)((ThrowBottleUI)localObject).ibx.getLayoutParams());
        ((ThrowBottleUI)localObject).ibG = ((ThrowBottleUI)localObject).ibE.topMargin;
      }
      ((ThrowBottleUI)localObject).ibB.setOnLayoutChangeListener(new ThrowBottleUI.1((ThrowBottleUI)localObject));
    }
    if (this.hYK != null) {
      this.hYK.setVisibility(paramInt2);
    }
    if ((paramInt3 == 0) && (this.hYL == null))
    {
      this.hYL = ((PickBottleUI)View.inflate(this, R.i.bottle_pick, null));
      this.hYJ.addView(this.hYL);
      this.hYL.initView();
    }
    if (this.hYL != null) {
      this.hYL.setVisibility(paramInt3);
    }
    if (paramInt3 == 0)
    {
      this.hYL.setDensity(com.tencent.mm.cb.a.getDensity(this));
      localObject = this.hYL;
      ((PickBottleUI)localObject).iav.setVisibility(8);
      ((PickBottleUI)localObject).iau.C(2147483647, -1, -1);
      ((PickBottleUI)localObject).iaw.setVisibility(8);
      ((PickBottleUI)localObject).hZZ.hYT = false;
      ((PickBottleUI)localObject).handler.postDelayed(((PickBottleUI)localObject).iay, 1000L);
    }
    if ((paramInt4 == 0) && (this.hYM == null))
    {
      this.hYM = ((OpenBottleUI)View.inflate(this, R.i.bottle_open, null));
      this.hYJ.addView(this.hYM);
      localObject = this.hYM;
      ((Button)((OpenBottleUI)localObject).findViewById(R.h.bottle_open_throw_back_btn)).setOnClickListener((View.OnClickListener)localObject);
      ((Button)((OpenBottleUI)localObject).findViewById(R.h.bottle_open_reply_btn)).setOnClickListener((View.OnClickListener)localObject);
      ((OpenBottleUI)localObject).iap = this;
    }
    if (this.hYM != null) {
      this.hYM.setVisibility(paramInt4);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    awR();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.bottle_beach;
  }
  
  protected final void initView()
  {
    int j = 8;
    setMMTitle(R.l.bottle_beach_title);
    ta(getResources().getColor(R.e.transparent));
    addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, new BottleBeachUI.2(this));
    setBackBtn(new BottleBeachUI.3(this));
    boolean bool = bk.crU();
    Object localObject;
    if (this.hYN == null)
    {
      localObject = (FrameLayout)findViewById(R.h.bottle_beach_bg_fl);
      ((FrameLayout)((FrameLayout)localObject).getParent()).removeView((View)localObject);
      ((FrameLayout)getWindow().getDecorView()).addView((View)localObject, 0);
      if (bool)
      {
        i = R.g.bottle_day_bg;
        ((FrameLayout)localObject).setBackgroundResource(i);
        ((FrameLayout)localObject).setVisibility(0);
        this.hYN = ((BallonImageView)findViewById(R.h.bottle_ballon_iv));
        this.hYO = ((LightHouseImageView)findViewById(R.h.bottle_light_house_iv));
        this.hYP = ((ImageView)findViewById(R.h.bottle_star_iv));
        this.hYQ = ((MoonImageView)findViewById(R.h.bottle_moon_iv));
      }
    }
    else
    {
      localObject = this.hYN;
      if (!bool) {
        break label371;
      }
      i = 0;
      label195:
      ((BallonImageView)localObject).setVisibility(i);
      localObject = this.hYO;
      if (!bool) {
        break label377;
      }
      i = 8;
      label214:
      ((LightHouseImageView)localObject).setVisibility(i);
      this.hYQ.hYP = this.hYP;
      localObject = this.hYQ;
      if (!bool) {
        break label382;
      }
    }
    label371:
    label377:
    label382:
    for (int i = j;; i = 0)
    {
      ((MoonImageView)localObject).setVisibility(i);
      this.hYI = findViewById(R.h.bottle_board_frame);
      this.hYI.setOnClickListener(new BottleBeachUI.4(this));
      this.hYU = ((ImageView)findViewById(R.h.bottle_opt_throw_tv));
      this.hYV = ((ImageView)findViewById(R.h.bottle_opt_pick_tv));
      this.hYW = ((ImageView)findViewById(R.h.bottle_opt_list_tv));
      this.hYU.setOnClickListener(this);
      this.hYV.setOnClickListener(this);
      this.hYW.setOnClickListener(this);
      this.hYR = ((ImageView)findViewById(R.h.bottle_close_frame_btn));
      this.hYR.setOnClickListener(this);
      return;
      i = R.g.bottle_night_bg;
      break;
      i = 8;
      break label195;
      i = 0;
      break label214;
    }
  }
  
  public final void lm(String paramString)
  {
    if (this.hYL != null)
    {
      Object localObject = this.hYL;
      if (((PickBottleUI)localObject).iav != null)
      {
        localObject = ((PickBottleUI)localObject).iav;
        if (paramString.equals(((PickedBottleImageView)localObject).hYr))
        {
          ((PickedBottleImageView)localObject).iconBitmap = com.tencent.mm.ai.m.f(((PickedBottleImageView)localObject).hYr, ((PickedBottleImageView)localObject).iconUrl, R.g.nosdcard_headimg);
          ((PickedBottleImageView)localObject).update();
          ((PickedBottleImageView)localObject).invalidate();
        }
      }
    }
  }
  
  public final void ok(int paramInt)
  {
    if (this.hYZ == null) {
      this.hYZ = new b(this);
    }
    b localb = this.hYZ;
    String str = getString(paramInt);
    localb.flb.setText(str);
    this.hYZ.show();
  }
  
  public final void ol(int paramInt)
  {
    this.hYS = paramInt;
    oj(0);
    if (this.hZa) {
      awQ();
    }
    switch (paramInt)
    {
    default: 
      q(8, 8, 8, 8);
      return;
    case 0: 
      this.hYT = true;
      q(0, 8, 8, 8);
      return;
    case 1: 
      q(8, 0, 8, 8);
      return;
    case 2: 
      q(8, 8, 0, 8);
      return;
    }
    q(8, 8, 8, 0);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (R.h.bottle_opt_throw_tv == i) {
      if (com.tencent.mm.plugin.bottle.a.c.awF() > 0) {
        ol(1);
      }
    }
    do
    {
      return;
      ok(R.l.bottle_cannot_throw);
      return;
      if (R.h.bottle_opt_pick_tv == i)
      {
        if (com.tencent.mm.plugin.bottle.a.c.awG() > 0)
        {
          ol(2);
          return;
        }
        ok(R.l.bottle_cannot_pick);
        return;
      }
      if (R.h.bottle_opt_list_tv == i)
      {
        if (!this.hZa) {
          awQ();
        }
        paramView = new Intent();
        paramView.setClass(this, BottleConversationUI.class);
        paramView.putExtra("conversation_from", "from_beach");
        startActivity(paramView);
        return;
      }
      if (R.h.bottle_close_frame_btn == i)
      {
        if (this.hYS == 3)
        {
          this.hYM.onPause();
          this.hYM.axa();
        }
        ol(0);
        q(0, 8, 8, 8);
        return;
      }
    } while (R.h.bottle_picked_result_img != i);
    Object localObject = ((PickedBottleImageView)paramView).getBottleTalker();
    paramView = ((PickedBottleImageView)paramView).getRealUserName();
    if ((paramView != null) && (paramView.length() > 0))
    {
      ol(0);
      au.Hx();
      localObject = com.tencent.mm.model.c.Fw().abl(paramView);
      if ((localObject != null) && ((int)((com.tencent.mm.n.a)localObject).dBe != 0) && (com.tencent.mm.n.a.gR(((ao)localObject).field_type)))
      {
        paramView = new Intent();
        paramView.putExtra("Contact_User", ((ao)localObject).field_username);
        if (((ad)localObject).cua())
        {
          com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, ((ao)localObject).field_username + ",25");
          paramView.putExtra("Contact_Scene", 25);
        }
        com.tencent.mm.plugin.bottle.a.eUR.d(paramView, this.mController.uMN);
        return;
      }
      paramView = new com.tencent.mm.plugin.messenger.a.f(paramView);
      au.Dk().a(paramView, 0);
      localObject = this.mController.uMN;
      getString(R.l.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(R.l.address_searching), true, new BottleBeachUI.5(this, paramView));
      return;
    }
    if (localObject != null)
    {
      ol(3);
      paramView = this.hYM;
      if (paramView.iai == null)
      {
        paramView.iai = ((ThrowBottleAnimUI)paramView.hZZ.findViewById(R.h.bottle_throw_anim_lo1));
        paramView.iai.setOnThrowEndListener(new OpenBottleUI.1(paramView));
      }
      if (paramView.iaa == null)
      {
        paramView.iaa = ((TextView)paramView.findViewById(R.h.bottle_open_text_container));
        paramView.iab = ((LinearLayout)paramView.findViewById(R.h.bottle_open_voice_container));
        paramView.iac = ((FrameLayout)paramView.findViewById(R.h.bottle_open_voice_node_fl));
        paramView.iad = ((ImageView)paramView.findViewById(R.h.bottle_open_voice_anim_iv));
        paramView.iae = ((TextView)paramView.findViewById(R.h.bottle_open_voice_length_tv));
        paramView.iaf = ((TextView)paramView.findViewById(R.h.bottle_open_contact_from_tv));
        paramView.iag = ((TextView)paramView.findViewById(R.h.bottle_open_contact_signature_tv));
        paramView.iac.setOnClickListener(paramView);
      }
      paramView.iaj = ((String)localObject);
      y.d("MM.Bottle_OpenBottleUI", (String)localObject);
      au.Hx();
      paramView.bFH = com.tencent.mm.model.c.Fy().HA((String)localObject);
      if (paramView.bFH.ctA())
      {
        paramView.iaa.setVisibility(8);
        paramView.iab.setVisibility(0);
        float f = com.tencent.mm.modelvoice.q.E(paramView.bFH);
        paramView.iac.setMinimumWidth(com.tencent.mm.cb.a.fromDPToPix(paramView.hZZ, OpenBottleUI.oq((int)f)));
        paramView.iae.setText(paramView.hZZ.getString(R.l.fmt_time_length, new Object[] { Integer.valueOf((int)f) }));
        OpenBottleUI.iah.a(paramView);
        if (paramView.bFH != null)
        {
          f = com.tencent.mm.modelvoice.q.ck(new n(paramView.bFH.field_content).time);
          localObject = paramView.iac;
          paramView.getResources().getString(R.l.bottle_voice_play_btn_text);
          ((FrameLayout)localObject).setContentDescription(String.format("%d", new Object[] { Integer.valueOf((int)f) }));
        }
      }
      for (;;)
      {
        paramView.axb();
        if (paramView.iao != null) {
          break;
        }
        paramView.iao = ((TextView)paramView.findViewById(R.h.expose_bottle));
        paramView.iao.setOnClickListener(new OpenBottleUI.4(paramView));
        return;
        paramView.iaa.setVisibility(0);
        paramView.iab.setVisibility(8);
        localObject = paramView.bFH;
        paramView.iaa.setText(((cs)localObject).field_content);
        j.h(paramView.iaa, 1);
      }
    }
    ol(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!com.tencent.mm.model.q.GA())
    {
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.f(11, 1));
    }
    initView();
    au.Dk().a(152, this);
    au.Dk().a(new com.tencent.mm.plugin.bottle.a.d(), 0);
  }
  
  public void onDestroy()
  {
    Object localObject;
    if (this.hYK != null)
    {
      localObject = this.hYK;
      ((ThrowBottleUI)localObject).ibn = null;
      ((ThrowBottleUI)localObject).ibq = null;
      if (((ThrowBottleUI)localObject).ibr != null)
      {
        ((ThrowBottleUI)localObject).ibr.cancel();
        ((ThrowBottleUI)localObject).ibr = null;
      }
      if (((ThrowBottleUI)localObject).ibs != null) {
        ((ThrowBottleUI)localObject).ibs.release();
      }
      ((ThrowBottleUI)localObject).ibs = null;
      ((ThrowBottleUI)localObject).ibt = null;
      ((ThrowBottleUI)localObject).hZZ = null;
      if (((ThrowBottleUI)localObject).ibo != null) {
        ((ThrowBottleUI)localObject).ibo.release();
      }
      this.hYK = null;
    }
    if (this.hYL != null)
    {
      localObject = this.hYL;
      ((PickBottleUI)localObject).handler.removeCallbacks(((PickBottleUI)localObject).iay);
      ((PickBottleUI)localObject).handler.removeCallbacks(((PickBottleUI)localObject).iaz);
      ((PickBottleUI)localObject).hZZ = null;
      ((PickBottleUI)localObject).iau = null;
      ((PickBottleUI)localObject).iav = null;
      this.hYL = null;
    }
    if (this.hYY != null)
    {
      this.hYY.cancel();
      this.hYY.context = null;
      this.hYY = null;
    }
    if (this.hYM != null)
    {
      localObject = this.hYM;
      if ((((OpenBottleUI)localObject).bFH != null) && (((OpenBottleUI)localObject).bFH.ctA())) {
        ((OpenBottleUI)localObject).axa();
      }
      ((OpenBottleUI)localObject).hZZ = null;
      if (((OpenBottleUI)localObject).iai != null)
      {
        ((OpenBottleUI)localObject).iai.release();
        ((OpenBottleUI)localObject).iai = null;
      }
      OpenBottleUI.iah = null;
      au.Hx();
      com.tencent.mm.model.c.Fw().b((m.b)localObject);
      this.hYM = null;
    }
    this.hYN = null;
    this.hYO = null;
    this.hYQ = null;
    if (this.hYZ != null)
    {
      this.hYZ.dismiss();
      this.hYZ = null;
    }
    au.Dk().b(152, this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      if (!this.hYT) {
        return true;
      }
      if (this.hYS == 0)
      {
        finish();
        return true;
      }
      ol(0);
      return true;
    }
    if (this.hYS == 3)
    {
      y.v("MM.UI.BottleUI", "on key dwon");
      if ((paramInt == 25) && (this.hYM.axc()))
      {
        au.Hy().gr(0);
        return true;
      }
      if ((paramInt == 24) && (this.hYM.axc()))
      {
        au.Hy().gq(0);
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if ((this.hYS == 1) && (this.hYK != null)) {
      this.hYK.axk();
    }
    if ((this.hYS == 3) && (this.hYM != null)) {
      this.hYM.onPause();
    }
    if (au.DK())
    {
      au.Hx();
      com.tencent.mm.model.c.FB().b(this);
      au.Dk().b(106, this);
    }
    z.MI().egE.remove(this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MM.UI.BottleUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (paramArrayOfInt[0] == 0);
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new BottleBeachUI.6(this), null);
  }
  
  protected void onResume()
  {
    super.onResume();
    awR();
    this.mController.uMz.postDelayed(new BottleBeachUI.1(this), 1000L);
    if ((this.hYS == 3) && (this.hYM != null))
    {
      OpenBottleUI localOpenBottleUI = this.hYM;
      if ((localOpenBottleUI.bFH != null) && (localOpenBottleUI.bFH.ctA())) {
        OpenBottleUI.iah.a(localOpenBottleUI);
      }
      localOpenBottleUI.setScreenEnable(true);
      localOpenBottleUI.iaq = bk.UZ();
    }
    au.Hx();
    com.tencent.mm.model.c.FB().a(this);
    z.MI().egE.add(this);
    au.Dk().a(106, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MM.UI.BottleUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramInt2 == -2002) && (this.hYS == 0)) {
      ok(R.l.bottle_banby_expose);
    }
    Intent localIntent;
    do
    {
      do
      {
        return;
        switch (paramm.getType())
        {
        default: 
          oj(R.l.bottle_get_count_err);
          return;
        case 152: 
          awR();
          return;
        }
        y.i("MM.UI.BottleUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
      } while (com.tencent.mm.plugin.bottle.a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString));
      if ((paramInt1 == 4) && (paramInt2 == -4))
      {
        com.tencent.mm.ui.base.h.h(this.mController.uMN, R.l.address_not_found, R.l.app_tip);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Toast.makeText(this.mController.uMN, this.mController.uMN.getString(R.l.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        return;
      }
      paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bhH();
      paramm = aa.a(paramString.sQs);
      o.JQ().h(paramm, aa.a(paramString.svJ));
      localIntent = new Intent();
      com.tencent.mm.pluginsdk.ui.tools.c.a(localIntent, paramString, 25);
    } while (bk.pm(paramm).length() <= 0);
    if ((paramString.tpg & 0x8) > 0) {
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, paramm + ",25");
    }
    com.tencent.mm.plugin.bottle.a.eUR.d(localIntent, this.mController.uMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleBeachUI
 * JD-Core Version:    0.7.0.1
 */