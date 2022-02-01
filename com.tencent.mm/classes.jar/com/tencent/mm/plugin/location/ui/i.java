package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.bh.c;
import com.tencent.mm.bh.d;
import com.tencent.mm.bh.g;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.location.model.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.List;

public final class i
  implements f, d
{
  private Activity activity;
  private List<String> dBf;
  Button vpH;
  public VolumeMeter vpI;
  RelativeLayout vpJ;
  private boolean vpK;
  private String vpL;
  String vpM;
  private String vpN;
  boolean vpO;
  int vpP;
  private long vpQ;
  long vpR;
  aw vpS;
  aw vpT;
  private aw vpU;
  public c vpV;
  public a vpW;
  final aw vpX;
  private boolean vpY;
  
  public i(Activity paramActivity, Button paramButton)
  {
    AppMethodBeat.i(55940);
    this.vpK = true;
    this.dBf = new LinkedList();
    this.vpO = false;
    this.vpP = 0;
    this.vpQ = 500L;
    this.vpR = 0L;
    this.vpS = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55932);
        ae.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
        i.this.djJ();
        AppMethodBeat.o(55932);
        return false;
      }
    }, false);
    this.vpT = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55933);
        ae.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
        i.a(i.this);
        AppMethodBeat.o(55933);
        return false;
      }
    }, false);
    this.vpU = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55934);
        i.this.display();
        AppMethodBeat.o(55934);
        return false;
      }
    }, false);
    this.vpX = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55936);
        if (i.this.vpP == 3) {}
        for (int i = i.this.vpV.aMt();; i = i.this.vpV.aMu())
        {
          i locali = i.this;
          float f2 = i;
          float f1 = f2;
          if (f2 < 10.0F) {
            f1 = 10.0F;
          }
          f2 = f1;
          if (f1 > 100.0F) {
            f2 = 100.0F;
          }
          locali.vpI.setVolume(f2 / 100.0F);
          locali.vpI.invalidate();
          AppMethodBeat.o(55936);
          return true;
          if (bu.isNullOrNil(i.this.vpM))
          {
            AppMethodBeat.o(55936);
            return false;
          }
        }
      }
    }, true);
    this.vpY = true;
    this.activity = paramActivity;
    this.vpH = paramButton;
    this.vpJ = ((RelativeLayout)this.activity.findViewById(2131306632));
    this.vpJ.setVisibility(8);
    this.vpI = ((VolumeMeter)this.vpJ.findViewById(2131306633));
    this.vpI.setArchView(this.vpH);
    paramActivity = this.vpI;
    if (paramActivity.vqF == null) {
      paramActivity.vqF = new aq("VolumeMeter_handler");
    }
    this.vpV = g.iun;
    if (this.vpV == null) {
      ae.e("MicroMsg.TalkMgr", "cannot get talkroom server");
    }
    AppMethodBeat.o(55940);
  }
  
  public static void djK()
  {
    AppMethodBeat.i(55944);
    wq localwq = new wq();
    localwq.dMc.dMf = true;
    com.tencent.mm.sdk.b.a.IvT.l(localwq);
    com.tencent.mm.plugin.audio.c.a.bHs();
    AppMethodBeat.o(55944);
  }
  
  public final void Hk(String paramString)
  {
    AppMethodBeat.i(55949);
    ae.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[] { paramString });
    this.vpM = paramString;
    display();
    if (!bu.isNullOrNil(paramString))
    {
      be.aI(ak.getContext(), 2131764376);
      this.vpX.ay(100L, 100L);
      AppMethodBeat.o(55949);
      return;
    }
    this.vpX.stopTimer();
    AppMethodBeat.o(55949);
  }
  
  public final void aMA() {}
  
  public final void aMB()
  {
    AppMethodBeat.i(55951);
    display();
    AppMethodBeat.o(55951);
  }
  
  public final void aMC()
  {
    AppMethodBeat.i(55952);
    display();
    AppMethodBeat.o(55952);
  }
  
  public final void aMD() {}
  
  public final void aMy()
  {
    AppMethodBeat.i(55945);
    this.vpK = false;
    this.vpH.setEnabled(true);
    display();
    AppMethodBeat.o(55945);
  }
  
  public final void aMz()
  {
    AppMethodBeat.i(55947);
    if (this.vpP != 1)
    {
      AppMethodBeat.o(55947);
      return;
    }
    this.vpP = 5;
    if (bu.aO(this.vpR) < this.vpQ)
    {
      ae.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
      aw localaw = this.vpS;
      long l = this.vpQ - bu.aO(this.vpR);
      localaw.ay(l, l);
      AppMethodBeat.o(55947);
      return;
    }
    djJ();
    AppMethodBeat.o(55947);
  }
  
  public final void bw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55950);
    ae.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    if (this.vpK)
    {
      AppMethodBeat.o(55950);
      return;
    }
    AppMethodBeat.o(55950);
  }
  
  final void display()
  {
    AppMethodBeat.i(55943);
    if (this.vpK)
    {
      AppMethodBeat.o(55943);
      return;
    }
    if (g.iun.aMx())
    {
      ae.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
      if (this.vpW != null)
      {
        this.vpW.apO(null);
        this.vpW.djG();
      }
    }
    switch (this.vpP)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55943);
      return;
      ae.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[] { this.vpM });
      if (this.vpW != null)
      {
        if (!bu.isNullOrNil(this.vpM))
        {
          this.vpW.apO(this.vpM);
          AppMethodBeat.o(55943);
          return;
        }
        this.vpW.apO(null);
        AppMethodBeat.o(55943);
        return;
        ae.d("MicroMsg.TalkMgr", "seize, state seizing");
        if (this.vpW != null)
        {
          this.vpW.djH();
          AppMethodBeat.o(55943);
          return;
          ae.d("MicroMsg.TalkMgr", "seize, state success or prepare");
          if (this.vpW != null)
          {
            this.vpW.djF();
            AppMethodBeat.o(55943);
            return;
            ae.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[] { this.vpM });
            if ((this.vpW != null) && (!bu.isNullOrNil(this.vpM)))
            {
              this.vpW.apP(this.vpM);
              AppMethodBeat.o(55943);
              return;
              ae.d("MicroMsg.TalkMgr", "seize time out");
            }
          }
        }
      }
    }
  }
  
  public final void djI()
  {
    AppMethodBeat.i(55941);
    this.vpN = this.activity.getIntent().getStringExtra("map_talker_name");
    this.vpV.a(this);
    ae.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[] { this.vpN });
    final String str = this.vpN;
    this.vpL = str;
    List localList;
    if (!bu.isNullOrNil(this.vpL))
    {
      if (!x.wb(str)) {
        break label153;
      }
      localList = r.zA(str);
      if (localList != null) {
        break label145;
      }
      au.a.hIG.aJ(str, "");
    }
    for (;;)
    {
      new aq(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55937);
          i.this.vpV.as(str, 1);
          AppMethodBeat.o(55937);
        }
      });
      this.vpH.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(55939);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/TalkMgr$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/location/ui/TalkMgr$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(55939);
            return false;
            i.this.vpO = true;
            i.this.vpJ.setVisibility(0);
            i.this.vpI.reset();
            paramAnonymousView = i.this.vpI;
            if (!paramAnonymousView.vqB)
            {
              paramAnonymousView.hYP = true;
              paramAnonymousView.djQ();
            }
            i.this.vpH.setPressed(true);
            if (i.this.vpO)
            {
              be.a(ak.getContext(), 2131764377, new be.a()
              {
                public final void onCompletion()
                {
                  AppMethodBeat.i(55938);
                  ae.i("MicroMsg.TalkMgr", "play press sound end");
                  AppMethodBeat.o(55938);
                }
              });
              i.this.vpP = 1;
              ae.i("MicroMsg.TalkMgr", "micBtn pressed down");
              i.this.vpR = bu.HQ();
              i.this.vpV.aMv();
              i.this.display();
              continue;
              if (i.this.vpO)
              {
                continue;
                i.this.vpH.setPressed(false);
                i.this.vpJ.setVisibility(8);
                i.this.vpI.reset();
                i.this.vpI.hYP = false;
                if (i.this.vpO)
                {
                  i.this.vpO = false;
                  if (i.this.vpP == 5)
                  {
                    ae.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                    i.this.vpS.stopTimer();
                    i.this.vpT.stopTimer();
                  }
                  i.this.vpP = 0;
                  i.this.vpX.stopTimer();
                  i.this.vpV.aMw();
                  be.aI(ak.getContext(), 2131764380);
                  i.this.display();
                  if (i.this.vpW != null) {
                    i.this.vpW.djG();
                  }
                }
              }
            }
          }
        }
      });
      AppMethodBeat.o(55941);
      return;
      label145:
      this.dBf = localList;
      continue;
      label153:
      this.dBf.clear();
      this.dBf.add(str);
      this.dBf.add(v.aAC());
    }
  }
  
  final void djJ()
  {
    AppMethodBeat.i(55942);
    if (this.vpP != 5)
    {
      AppMethodBeat.o(55942);
      return;
    }
    this.vpS.stopTimer();
    display();
    be.a(ak.getContext(), 2131764373, new be.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(55935);
        i.this.vpT.stopTimer();
        i.a(i.this);
        AppMethodBeat.o(55935);
      }
    });
    this.vpT.ay(1000L, 1000L);
    AppMethodBeat.o(55942);
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn) {}
  
  public final void qk(int paramInt)
  {
    AppMethodBeat.i(55948);
    ae.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.vpP != 3)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
    for (this.vpP = 4;; this.vpP = 2)
    {
      display();
      be.a(ak.getContext(), null);
      AppMethodBeat.o(55948);
      return;
      if (this.vpP != 1)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
  }
  
  public final void s(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55946);
    ae.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[] { paramString });
    com.tencent.mm.plugin.location.model.n.djg().Jv(3);
    this.activity.finish();
    AppMethodBeat.o(55946);
  }
  
  public static abstract interface a
  {
    public abstract void apO(String paramString);
    
    public abstract void apP(String paramString);
    
    public abstract void djF();
    
    public abstract void djG();
    
    public abstract void djH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.i
 * JD-Core Version:    0.7.0.1
 */