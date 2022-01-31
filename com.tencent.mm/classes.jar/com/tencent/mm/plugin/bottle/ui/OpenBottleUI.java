package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.h.a;
import com.tencent.mm.ah.h.b;
import com.tencent.mm.ay.e;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import junit.framework.Assert;

public class OpenBottleUI
  extends FrameLayout
  implements View.OnClickListener, h.a, h.b, m.b, SensorController.a
{
  static SensorController iah;
  bi bFH;
  private com.tencent.mm.f.a.a byN;
  BottleBeachUI hZZ;
  TextView iaa;
  LinearLayout iab;
  FrameLayout iac;
  ImageView iad;
  TextView iae;
  TextView iaf;
  TextView iag;
  ThrowBottleAnimUI iai;
  String iaj;
  private boolean iak = true;
  private bb ial;
  private long iam = -1L;
  private boolean ian;
  TextView iao;
  MMActivity iap;
  long iaq = 0L;
  private boolean iar = false;
  private boolean isDeleteCancel = false;
  
  public OpenBottleUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.hZZ = ((BottleBeachUI)paramContext);
    au.Hx();
    com.tencent.mm.model.c.Fw().a(this);
    if (iah == null) {
      iah = new SensorController(paramContext.getApplicationContext());
    }
    if (this.ial == null) {
      this.ial = new bb(paramContext.getApplicationContext());
    }
    au.Hx();
    paramContext = (Boolean)com.tencent.mm.model.c.Dz().get(26, Boolean.valueOf(false));
    this.ian = paramContext.booleanValue();
    if (!paramContext.booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      this.iak = bool;
      if (this.byN != null) {
        this.byN.aV(this.iak);
      }
      return;
    }
  }
  
  private void J(bi parambi)
  {
    if ((com.tencent.mm.r.a.bk(getContext())) || (com.tencent.mm.r.a.bi(this.hZZ)))
    {
      y.d("MM.Bottle_OpenBottleUI", "voip is running, can't use the feature");
      return;
    }
    boolean bool;
    if ((parambi != null) && (parambi.ctA()))
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((parambi != null) && (parambi.ctA()) && (!iah.uil))
      {
        iah.a(this);
        OpenBottleUI.5 local5 = new OpenBottleUI.5(this);
        if (!this.ial.W(local5)) {
          break label130;
        }
      }
    }
    label130:
    for (this.iam = 0L;; this.iam = -1L)
    {
      au.Hx();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bk.bl(parambi.field_imgPath))) {
        break label140;
      }
      s.gM(this.hZZ);
      return;
      bool = false;
      break;
    }
    label140:
    if (this.byN == null) {
      this.byN = new com.tencent.mm.f.a.a(this.hZZ);
    }
    ag.Zm("keep_app_silent");
    q.H(parambi);
    this.byN.stop(false);
    if ((parambi != null) && (this.byN.k(parambi.field_imgPath, this.iak)))
    {
      au.Hy().f(this.iak, false, false);
      this.byN.bBG = this;
      this.byN.bBF = this;
      this.iad.setBackgroundResource(R.a.bottle_voice_playing);
      ((AnimationDrawable)this.iad.getBackground()).start();
      return;
    }
    Toast.makeText(this.hZZ, this.hZZ.getString(R.l.chatting_play_err), 0).show();
  }
  
  static int oq(int paramInt)
  {
    if (paramInt <= 2) {
      return 100;
    }
    if (paramInt < 10) {
      return (paramInt - 2) * 8 + 100;
    }
    if (paramInt < 60) {
      return (paramInt / 10 + 7) * 8 + 100;
    }
    return 204;
  }
  
  private void stopPlay()
  {
    ag.Zn("keep_app_silent");
    axa();
    if ((this.iad.getBackground() instanceof AnimationDrawable))
    {
      ((AnimationDrawable)this.iad.getBackground()).stop();
      this.iad.setBackgroundResource(R.g.bottle_receiver_voice_node);
    }
    if (this.byN != null) {
      this.byN.stop(false);
    }
    setScreenEnable(true);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    y.d("MM.Bottle_OpenBottleUI", "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.e("MM.Bottle_OpenBottleUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    do
    {
      return;
      paramm = (String)paramObject;
    } while ((bk.bl(this.iaj)) || (!ad.aaZ(this.iaj).equals(ad.aaZ(paramm))));
    axb();
  }
  
  public final void axa()
  {
    if (iah != null) {
      iah.crJ();
    }
    this.ial.crK();
  }
  
  final void axb()
  {
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fw().abl(this.iaj);
    int i;
    if ((localObject != null) && (this.hZZ != null))
    {
      this.iaf.setText(this.hZZ.getString(R.l.bottle_open_contact_from, new Object[] { com.tencent.mm.plugin.bottle.a.c.b(this.hZZ, (ad)localObject) }));
      TextView localTextView = this.iaf;
      if (((ao)localObject).sex == 1)
      {
        i = R.k.ic_sex_male;
        localTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        this.iaf.setCompoundDrawablePadding(8);
        this.iag.setText(j.a(this.hZZ, ((ao)localObject).signature, this.iag.getTextSize()));
      }
    }
    else
    {
      localObject = ad.aaZ(this.iaj);
      if (!bk.bl((String)localObject)) {
        break label161;
      }
      localObject = this.iaj;
    }
    label161:
    for (;;)
    {
      a.b.a((ImageView)findViewById(R.h.bottle_open_avatar_iv), (String)localObject);
      return;
      i = R.k.ic_sex_female;
      break;
    }
  }
  
  public final boolean axc()
  {
    return (this.byN != null) && (this.byN.isPlaying()) && (!this.iak);
  }
  
  public final void eq(boolean paramBoolean)
  {
    boolean bool = true;
    if ((!this.bFH.ctA()) || (this.byN == null)) {}
    do
    {
      return;
      if (this.iar)
      {
        if (!paramBoolean) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          this.iar = paramBoolean;
          return;
        }
      }
      if ((!paramBoolean) && (this.iam != -1L) && (bk.cp(this.iam) > 400L))
      {
        this.iar = true;
        return;
      }
      this.iar = false;
      if ((bk.UZ() - this.iaq > 500L) && ((paramBoolean) || ((!paramBoolean) && (this.byN.isPlaying())))) {
        setScreenEnable(paramBoolean);
      }
      if (this.ian)
      {
        this.byN.aV(false);
        au.Hy().f(false, false, false);
        this.iak = false;
        return;
      }
      if (!this.byN.isPlaying())
      {
        this.byN.aV(true);
        au.Hy().f(true, false, false);
        this.iak = true;
        return;
      }
      this.byN.aV(paramBoolean);
      au.Hy().f(paramBoolean, false, false);
      this.iak = paramBoolean;
    } while (paramBoolean);
    J(this.bFH);
  }
  
  public void onClick(View paramView)
  {
    if (R.h.bottle_open_throw_back_btn == paramView.getId())
    {
      paramView = this.iai;
      paramView.ibi = this.bFH.ctA();
      paramView.setVisibility(0);
      paramView.hZZ.hYT = false;
      paramView.hZZ.ol(-1);
      paramView.axg();
      paramView.axe();
      paramView.axf();
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new e(this.iaj, 1));
      this.isDeleteCancel = false;
      paramView = this.hZZ;
      this.hZZ.getString(R.l.app_tip);
      paramView = com.tencent.mm.ui.base.h.b(paramView, this.hZZ.getString(R.l.app_waiting), true, new OpenBottleUI.2(this));
      com.tencent.mm.model.bd.a(this.iaj, new OpenBottleUI.3(this, paramView));
      au.Hx();
      com.tencent.mm.model.c.FB().abu(this.iaj);
      axa();
    }
    do
    {
      stopPlay();
      do
      {
        return;
        if (R.h.bottle_open_reply_btn == paramView.getId())
        {
          this.hZZ.ol(0);
          paramView = new Intent();
          paramView.putExtra("Chat_User", this.iaj);
          com.tencent.mm.plugin.bottle.a.eUR.e(paramView, this.hZZ);
          axa();
          break;
        }
      } while (R.h.bottle_open_voice_node_fl != paramView.getId());
    } while ((this.byN != null) && (this.byN.isPlaying()));
    J(this.bFH);
  }
  
  public final void onError()
  {
    y.v("MM.Bottle_OpenBottleUI", "voice play error");
    stopPlay();
  }
  
  public final void onPause()
  {
    au.Hy().yx();
    if ((this.bFH != null) && (this.bFH.ctA())) {
      axa();
    }
    if (this.byN != null)
    {
      if (this.byN.isPlaying()) {
        stopPlay();
      }
      this.byN.aV(true);
    }
  }
  
  void setScreenEnable(boolean paramBoolean)
  {
    this.iap.setScreenEnable(paramBoolean);
  }
  
  public final void ug()
  {
    y.v("MM.Bottle_OpenBottleUI", "voice play completion");
    stopPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.OpenBottleUI
 * JD-Core Version:    0.7.0.1
 */