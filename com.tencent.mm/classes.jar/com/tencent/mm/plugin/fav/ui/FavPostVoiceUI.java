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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.w;
import java.util.LinkedList;

public class FavPostVoiceUI
  extends MMBaseActivity
{
  private static final int[] gcA = { 2130837689, 2130837690, 2130837691, 2130837692, 2130837693, 2130837694, 2130837695 };
  private static final int[] mwW = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private long duration;
  private final ap gcG;
  private int iiX;
  private long lvI;
  private Button mwJ;
  private boolean mwK;
  private boolean mwL;
  private long mwM;
  private Toast mwN;
  private View mwO;
  private View mwP;
  private ImageView mwQ;
  private View mwR;
  private View mwS;
  private TextView mwT;
  private View mwU;
  private j mwV;
  private final ak mwX;
  private final ap mwY;
  boolean mwZ;
  private String path;
  
  public FavPostVoiceUI()
  {
    AppMethodBeat.i(74050);
    this.mwM = -1L;
    this.gcG = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        int j = 0;
        AppMethodBeat.i(74041);
        j localj = FavPostVoiceUI.a(FavPostVoiceUI.this);
        int i;
        if (localj.status == 1)
        {
          i = localj.ckV.getMaxAmplitude();
          if (i > j.ckX) {
            j.ckX = i;
          }
          i = i * 100 / j.ckX;
        }
        for (;;)
        {
          if (j < FavPostVoiceUI.gcA.length)
          {
            if ((i >= FavPostVoiceUI.bxB()[j]) && (i < FavPostVoiceUI.bxB()[(j + 1)])) {
              FavPostVoiceUI.b(FavPostVoiceUI.this).setBackgroundResource(FavPostVoiceUI.gcA[j]);
            }
          }
          else
          {
            AppMethodBeat.o(74041);
            return true;
            i = 0;
            continue;
          }
          j += 1;
        }
      }
    }, true);
    this.mwX = new FavPostVoiceUI.6(this);
    this.mwY = new ap(new FavPostVoiceUI.7(this), true);
    this.mwZ = false;
    AppMethodBeat.o(74050);
  }
  
  private void bxA()
  {
    AppMethodBeat.i(74060);
    if (this.mwZ)
    {
      AppMethodBeat.o(74060);
      return;
    }
    this.mwZ = true;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(300L);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener(new FavPostVoiceUI.8(this));
    findViewById(2131824070).setVisibility(8);
    findViewById(2131824080).setVisibility(8);
    this.mwU.setVisibility(8);
    this.mwU.startAnimation(localAlphaAnimation);
    findViewById(2131824070).startAnimation(localAlphaAnimation);
    findViewById(2131824080).startAnimation(localTranslateAnimation);
    AppMethodBeat.o(74060);
  }
  
  private j bxw()
  {
    AppMethodBeat.i(74052);
    Object localObject = c.a.elP;
    localObject = new j();
    ((j)localObject).ckW = new FavPostVoiceUI.4(this);
    AppMethodBeat.o(74052);
    return localObject;
  }
  
  private void bxx()
  {
    long l = 0L;
    AppMethodBeat.i(74053);
    if (!this.mwK)
    {
      AppMethodBeat.o(74053);
      return;
    }
    this.mwJ.setKeepScreenOn(true);
    this.mwJ.setBackgroundResource(2130840129);
    this.mwJ.setText(2131299781);
    this.mwV.Et();
    int i;
    label81:
    String str;
    if (this.lvI == 0L)
    {
      this.duration = l;
      if (this.duration >= 800L) {
        break label163;
      }
      i = 1;
      this.gcG.stopTimer();
      this.mwY.stopTimer();
      if (i != 0) {
        break label295;
      }
      str = this.path;
      i = (int)this.duration;
      if (!bo.isNullOrNil(str)) {
        break label168;
      }
      ab.e("MicroMsg.FavPostLogic", "postVoice path null");
      label126:
      setResult(-1);
      finish();
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      this.mwK = false;
      AppMethodBeat.o(74053);
      return;
      l = bo.av(this.lvI);
      break;
      label163:
      i = 0;
      break label81;
      label168:
      g localg = new g();
      localg.field_type = 3;
      localg.field_sourceType = 6;
      h.E(localg);
      aca localaca = new aca();
      localaca.anE(str);
      localaca.MH(i);
      localaca.pz(true);
      localaca.MI(localg.field_type);
      localaca.anA("amr");
      localg.field_favProto.wVc.add(localaca);
      b.B(localg);
      com.tencent.mm.plugin.report.service.h.qsU.e(10648, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      break label126;
      label295:
      bxz();
      this.mwJ.setEnabled(false);
      this.mwJ.setBackgroundResource(2130840128);
      this.mwP.setVisibility(0);
      this.mwO.setVisibility(8);
      this.mwX.sendEmptyMessageDelayed(0, 500L);
    }
  }
  
  private void bxz()
  {
    AppMethodBeat.i(74055);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(this.path);
    if (localb.exists()) {
      localb.delete();
    }
    AppMethodBeat.o(74055);
  }
  
  public final void bxy()
  {
    AppMethodBeat.i(74054);
    this.mwO.setVisibility(0);
    this.mwP.setVisibility(8);
    this.mwS.setVisibility(8);
    this.mwR.setVisibility(0);
    this.mwT.setText(2131299676);
    this.mwJ.setBackgroundResource(2130840130);
    this.mwJ.setText(2131299781);
    this.mwQ.setVisibility(4);
    this.mwK = false;
    AppMethodBeat.o(74054);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74051);
    super.onCreate(paramBundle);
    setContentView(w.hM(this).inflate(2130969556, null));
    this.mwQ = ((ImageView)findViewById(2131824074));
    this.mwR = findViewById(2131824072);
    this.mwS = findViewById(2131824076);
    this.mwO = findViewById(2131824071);
    this.mwP = findViewById(2131824079);
    this.mwT = ((TextView)findViewById(2131824075));
    this.mwU = findViewById(2131824069);
    findViewById(2131824070).setVisibility(8);
    this.mwU.setVisibility(8);
    findViewById(2131824070).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(74042);
        FavPostVoiceUI.c(FavPostVoiceUI.this);
        AppMethodBeat.o(74042);
        return false;
      }
    });
    findViewById(2131824080).setVisibility(8);
    this.mwV = bxw();
    this.mwJ = ((Button)findViewById(2131824081));
    this.mwJ.setOnTouchListener(new FavPostVoiceUI.5(this));
    bxy();
    paramBundle = com.tencent.mm.plugin.fav.a.b.bwf();
    Object localObject = new com.tencent.mm.vfs.b(paramBundle);
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    do
    {
      localObject = paramBundle + "/" + System.currentTimeMillis();
    } while (new com.tencent.mm.vfs.b((String)localObject).exists());
    this.path = ((String)localObject);
    this.mwT.post(new FavPostVoiceUI.3(this));
    AppMethodBeat.o(74051);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74056);
    super.onDestroy();
    AppMethodBeat.o(74056);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74059);
    if (4 == paramInt)
    {
      bxA();
      AppMethodBeat.o(74059);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(74059);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74058);
    super.onPause();
    bxx();
    AppMethodBeat.o(74058);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74057);
    super.onResume();
    AppMethodBeat.o(74057);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI
 * JD-Core Version:    0.7.0.1
 */