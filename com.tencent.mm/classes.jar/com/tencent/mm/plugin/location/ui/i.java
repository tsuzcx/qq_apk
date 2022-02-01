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
import com.tencent.mm.bh.c;
import com.tencent.mm.bh.d;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public final class i
  implements com.tencent.mm.ak.g, d
{
  private Activity activity;
  private List<String> dom;
  Button uaN;
  public VolumeMeter uaO;
  RelativeLayout uaP;
  private boolean uaQ;
  private String uaR;
  String uaS;
  private String uaT;
  boolean uaU;
  int uaV;
  private long uaW;
  long uaX;
  au uaY;
  au uaZ;
  private au uba;
  public c ubb;
  public a ubc;
  final au ubd;
  private boolean ube;
  
  public i(Activity paramActivity, Button paramButton)
  {
    AppMethodBeat.i(55940);
    this.uaQ = true;
    this.dom = new LinkedList();
    this.uaU = false;
    this.uaV = 0;
    this.uaW = 500L;
    this.uaX = 0L;
    this.uaY = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55932);
        ac.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
        i.this.cXy();
        AppMethodBeat.o(55932);
        return false;
      }
    }, false);
    this.uaZ = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55933);
        ac.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
        i.a(i.this);
        AppMethodBeat.o(55933);
        return false;
      }
    }, false);
    this.uba = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55934);
        i.this.display();
        AppMethodBeat.o(55934);
        return false;
      }
    }, false);
    this.ubd = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55936);
        if (i.this.uaV == 3) {}
        for (int i = i.this.ubb.aIM();; i = i.this.ubb.aIN())
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
          locali.uaO.setVolume(f2 / 100.0F);
          locali.uaO.invalidate();
          AppMethodBeat.o(55936);
          return true;
          if (bs.isNullOrNil(i.this.uaS))
          {
            AppMethodBeat.o(55936);
            return false;
          }
        }
      }
    }, true);
    this.ube = true;
    this.activity = paramActivity;
    this.uaN = paramButton;
    this.uaP = ((RelativeLayout)this.activity.findViewById(2131306632));
    this.uaP.setVisibility(8);
    this.uaO = ((VolumeMeter)this.uaP.findViewById(2131306633));
    this.uaO.setArchView(this.uaN);
    paramActivity = this.uaO;
    if (paramActivity.ubL == null) {
      paramActivity.ubL = new ao("VolumeMeter_handler");
    }
    this.ubb = com.tencent.mm.bh.g.hXX;
    if (this.ubb == null) {
      ac.e("MicroMsg.TalkMgr", "cannot get talkroom server");
    }
    AppMethodBeat.o(55940);
  }
  
  public static void cXz()
  {
    AppMethodBeat.i(55944);
    vt localvt = new vt();
    localvt.dyB.dyE = true;
    com.tencent.mm.sdk.b.a.GpY.l(localvt);
    com.tencent.mm.plugin.audio.c.a.bCr();
    AppMethodBeat.o(55944);
  }
  
  public final void DD(String paramString)
  {
    AppMethodBeat.i(55949);
    ac.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[] { paramString });
    this.uaS = paramString;
    display();
    if (!bs.isNullOrNil(paramString))
    {
      bc.aF(ai.getContext(), 2131764376);
      this.ubd.au(100L, 100L);
      AppMethodBeat.o(55949);
      return;
    }
    this.ubd.stopTimer();
    AppMethodBeat.o(55949);
  }
  
  public final void aIR()
  {
    AppMethodBeat.i(55945);
    this.uaQ = false;
    this.uaN.setEnabled(true);
    display();
    AppMethodBeat.o(55945);
  }
  
  public final void aIS()
  {
    AppMethodBeat.i(55947);
    if (this.uaV != 1)
    {
      AppMethodBeat.o(55947);
      return;
    }
    this.uaV = 5;
    if (bs.aO(this.uaX) < this.uaW)
    {
      ac.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
      au localau = this.uaY;
      long l = this.uaW - bs.aO(this.uaX);
      localau.au(l, l);
      AppMethodBeat.o(55947);
      return;
    }
    cXy();
    AppMethodBeat.o(55947);
  }
  
  public final void aIT() {}
  
  public final void aIU()
  {
    AppMethodBeat.i(55951);
    display();
    AppMethodBeat.o(55951);
  }
  
  public final void aIV()
  {
    AppMethodBeat.i(55952);
    display();
    AppMethodBeat.o(55952);
  }
  
  public final void aIW() {}
  
  public final void bv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55950);
    ac.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    if (this.uaQ)
    {
      AppMethodBeat.o(55950);
      return;
    }
    AppMethodBeat.o(55950);
  }
  
  public final void cXx()
  {
    AppMethodBeat.i(55941);
    this.uaT = this.activity.getIntent().getStringExtra("map_talker_name");
    this.ubb.a(this);
    ac.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[] { this.uaT });
    final String str = this.uaT;
    this.uaR = str;
    List localList;
    if (!bs.isNullOrNil(this.uaR))
    {
      if (!w.sQ(str)) {
        break label153;
      }
      localList = com.tencent.mm.model.q.vZ(str);
      if (localList != null) {
        break label145;
      }
      ar.a.hnw.aJ(str, "");
    }
    for (;;)
    {
      new ao(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55937);
          i.this.ubb.ap(str, 1);
          AppMethodBeat.o(55937);
        }
      });
      this.uaN.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(55939);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(55939);
            return false;
            i.this.uaU = true;
            i.this.uaP.setVisibility(0);
            i.this.uaO.reset();
            paramAnonymousView = i.this.uaO;
            if (!paramAnonymousView.ubH)
            {
              paramAnonymousView.hDs = true;
              paramAnonymousView.cXF();
            }
            i.this.uaN.setPressed(true);
            if (i.this.uaU)
            {
              bc.a(ai.getContext(), 2131764377, new bc.a()
              {
                public final void onCompletion()
                {
                  AppMethodBeat.i(55938);
                  ac.i("MicroMsg.TalkMgr", "play press sound end");
                  AppMethodBeat.o(55938);
                }
              });
              i.this.uaV = 1;
              ac.i("MicroMsg.TalkMgr", "micBtn pressed down");
              i.this.uaX = bs.Gn();
              i.this.ubb.aIO();
              i.this.display();
              continue;
              if (i.this.uaU)
              {
                continue;
                i.this.uaN.setPressed(false);
                i.this.uaP.setVisibility(8);
                i.this.uaO.reset();
                i.this.uaO.hDs = false;
                if (i.this.uaU)
                {
                  i.this.uaU = false;
                  if (i.this.uaV == 5)
                  {
                    ac.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                    i.this.uaY.stopTimer();
                    i.this.uaZ.stopTimer();
                  }
                  i.this.uaV = 0;
                  i.this.ubd.stopTimer();
                  i.this.ubb.aIP();
                  bc.aF(ai.getContext(), 2131764380);
                  i.this.display();
                  if (i.this.ubc != null) {
                    i.this.ubc.cXv();
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
      this.dom = localList;
      continue;
      label153:
      this.dom.clear();
      this.dom.add(str);
      this.dom.add(u.axw());
    }
  }
  
  final void cXy()
  {
    AppMethodBeat.i(55942);
    if (this.uaV != 5)
    {
      AppMethodBeat.o(55942);
      return;
    }
    this.uaY.stopTimer();
    display();
    bc.a(ai.getContext(), 2131764373, new bc.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(55935);
        i.this.uaZ.stopTimer();
        i.a(i.this);
        AppMethodBeat.o(55935);
      }
    });
    this.uaZ.au(1000L, 1000L);
    AppMethodBeat.o(55942);
  }
  
  final void display()
  {
    AppMethodBeat.i(55943);
    if (this.uaQ)
    {
      AppMethodBeat.o(55943);
      return;
    }
    if (com.tencent.mm.bh.g.hXX.aIQ())
    {
      ac.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
      if (this.ubc != null)
      {
        this.ubc.ajW(null);
        this.ubc.cXv();
      }
    }
    switch (this.uaV)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55943);
      return;
      ac.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[] { this.uaS });
      if (this.ubc != null)
      {
        if (!bs.isNullOrNil(this.uaS))
        {
          this.ubc.ajW(this.uaS);
          AppMethodBeat.o(55943);
          return;
        }
        this.ubc.ajW(null);
        AppMethodBeat.o(55943);
        return;
        ac.d("MicroMsg.TalkMgr", "seize, state seizing");
        if (this.ubc != null)
        {
          this.ubc.cXw();
          AppMethodBeat.o(55943);
          return;
          ac.d("MicroMsg.TalkMgr", "seize, state success or prepare");
          if (this.ubc != null)
          {
            this.ubc.cXu();
            AppMethodBeat.o(55943);
            return;
            ac.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[] { this.uaS });
            if ((this.ubc != null) && (!bs.isNullOrNil(this.uaS)))
            {
              this.ubc.ajX(this.uaS);
              AppMethodBeat.o(55943);
              return;
              ac.d("MicroMsg.TalkMgr", "seize time out");
            }
          }
        }
      }
    }
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn) {}
  
  public final void pF(int paramInt)
  {
    AppMethodBeat.i(55948);
    ac.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.uaV != 3)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
    for (this.uaV = 4;; this.uaV = 2)
    {
      display();
      bc.a(ai.getContext(), null);
      AppMethodBeat.o(55948);
      return;
      if (this.uaV != 1)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
  }
  
  public final void q(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55946);
    ac.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[] { paramString });
    com.tencent.mm.plugin.location.model.n.cWV().HA(3);
    this.activity.finish();
    AppMethodBeat.o(55946);
  }
  
  public static abstract interface a
  {
    public abstract void ajW(String paramString);
    
    public abstract void ajX(String paramString);
    
    public abstract void cXu();
    
    public abstract void cXv();
    
    public abstract void cXw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.i
 * JD-Core Version:    0.7.0.1
 */