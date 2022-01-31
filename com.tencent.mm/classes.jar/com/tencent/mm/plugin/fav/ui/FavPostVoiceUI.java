package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.f.b.j;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.LinkedList;

public class FavPostVoiceUI
  extends MMBaseActivity
{
  private static final int[] eMV = { n.d.amp1, n.d.amp2, n.d.amp3, n.d.amp4, n.d.amp5, n.d.amp6, n.d.amp7 };
  private static final int[] ibm = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private long duration;
  private final am eNb = new am(new am.a()
  {
    public final boolean tC()
    {
      int j = 0;
      j localj = FavPostVoiceUI.a(FavPostVoiceUI.this);
      int i;
      if (localj.status == 1)
      {
        i = localj.bEj.getMaxAmplitude();
        if (i > j.bEl) {
          j.bEl = i;
        }
        i = i * 100 / j.bEl;
      }
      for (;;)
      {
        if (j < FavPostVoiceUI.eMV.length)
        {
          if ((i >= FavPostVoiceUI.aRm()[j]) && (i < FavPostVoiceUI.aRm()[(j + 1)])) {
            FavPostVoiceUI.b(FavPostVoiceUI.this).setBackgroundResource(FavPostVoiceUI.eMV[j]);
          }
        }
        else
        {
          return true;
          i = 0;
          continue;
        }
        j += 1;
      }
    }
  }, true);
  private int gHS;
  private boolean ibC;
  private boolean ibD;
  private final am ibI = new am(new FavPostVoiceUI.7(this), true);
  private final ah ibJ = new FavPostVoiceUI.6(this);
  private long ibp = -1L;
  private Toast ibq;
  private ImageView ibu;
  private long jlU;
  private Button kcg;
  private View kch;
  private View kci;
  private View kcj;
  private View kck;
  private TextView kcl;
  private View kcm;
  private j kcn;
  boolean kco = false;
  private String path;
  
  private j aRh()
  {
    Object localObject = b.a.dub;
    localObject = new j();
    ((j)localObject).bEk = new FavPostVoiceUI.4(this);
    return localObject;
  }
  
  private void aRi()
  {
    long l = 0L;
    if (!this.ibC) {
      return;
    }
    this.kcg.setKeepScreenOn(true);
    this.kcg.setBackgroundResource(n.d.record_shape_normal);
    this.kcg.setText(n.i.favorite_press_talk_to_fav);
    this.kcn.uh();
    int i;
    label73:
    String str;
    if (this.jlU == 0L)
    {
      this.duration = l;
      if (this.duration >= 800L) {
        break label150;
      }
      i = 1;
      this.eNb.stopTimer();
      this.ibI.stopTimer();
      if (i != 0) {
        break label281;
      }
      str = this.path;
      i = (int)this.duration;
      if (!bk.bl(str)) {
        break label155;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FavPostLogic", "postVoice path null");
      label118:
      setResult(-1);
      finish();
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      this.ibC = false;
      return;
      l = bk.cp(this.jlU);
      break;
      label150:
      i = 0;
      break label73;
      label155:
      g localg = new g();
      localg.field_type = 3;
      localg.field_sourceType = 6;
      h.D(localg);
      xv localxv = new xv();
      localxv.XI(str);
      localxv.EG(i);
      localxv.mk(true);
      localxv.EH(localg.field_type);
      localxv.XE("amr");
      localg.field_favProto.sXc.add(localxv);
      b.B(localg);
      com.tencent.mm.plugin.report.service.h.nFQ.f(10648, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      break label118;
      label281:
      aRk();
      this.kcg.setEnabled(false);
      this.kcg.setBackgroundResource(n.d.record_shape_disable);
      this.kci.setVisibility(0);
      this.kch.setVisibility(8);
      this.ibJ.sendEmptyMessageDelayed(0, 500L);
    }
  }
  
  private void aRk()
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(this.path);
    if (localb.exists()) {
      localb.delete();
    }
  }
  
  private void aRl()
  {
    if (this.kco) {
      return;
    }
    this.kco = true;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(300L);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener(new FavPostVoiceUI.8(this));
    findViewById(n.e.voice_rcd_hint).setVisibility(8);
    findViewById(n.e.fav_post_voice_footer).setVisibility(8);
    this.kcm.setVisibility(8);
    this.kcm.startAnimation(localAlphaAnimation);
    findViewById(n.e.voice_rcd_hint).startAnimation(localAlphaAnimation);
    findViewById(n.e.fav_post_voice_footer).startAnimation(localTranslateAnimation);
  }
  
  public final void aRj()
  {
    this.kch.setVisibility(0);
    this.kci.setVisibility(8);
    this.kck.setVisibility(8);
    this.kcj.setVisibility(0);
    this.kcl.setText(n.i.fav_press_talk_start_record);
    this.kcg.setBackgroundResource(n.d.record_shape_press);
    this.kcg.setText(n.i.favorite_press_talk_to_fav);
    this.ibu.setVisibility(4);
    this.ibC = false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(com.tencent.mm.ui.y.gt(this).inflate(n.f.fav_post_voice, null));
    this.ibu = ((ImageView)findViewById(n.e.voice_rcd_hint_anim));
    this.kcj = findViewById(n.e.voice_rcd_hint_anim_area);
    this.kck = findViewById(n.e.voice_rcd_hint_cancel_area);
    this.kch = findViewById(n.e.voice_rcd_hint_rcding);
    this.kci = findViewById(n.e.voice_rcd_hint_tooshort);
    this.kcl = ((TextView)findViewById(n.e.voice_rcd_hint_word));
    this.kcm = findViewById(n.e.voice_rcd_hint_bg);
    findViewById(n.e.voice_rcd_hint).setVisibility(8);
    this.kcm.setVisibility(8);
    findViewById(n.e.voice_rcd_hint).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        FavPostVoiceUI.c(FavPostVoiceUI.this);
        return false;
      }
    });
    findViewById(n.e.fav_post_voice_footer).setVisibility(8);
    this.kcn = aRh();
    this.kcg = ((Button)findViewById(n.e.fav_post_voice_btn));
    this.kcg.setOnTouchListener(new FavPostVoiceUI.5(this));
    aRj();
    paramBundle = com.tencent.mm.plugin.fav.a.b.aPR();
    Object localObject = new com.tencent.mm.vfs.b(paramBundle);
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    do
    {
      localObject = paramBundle + "/" + System.currentTimeMillis();
    } while (new com.tencent.mm.vfs.b((String)localObject).exists());
    this.path = ((String)localObject);
    this.kcl.post(new FavPostVoiceUI.3(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt)
    {
      aRl();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    aRi();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI
 * JD-Core Version:    0.7.0.1
 */