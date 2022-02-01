package com.tencent.mm.plugin.masssend.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.l;
import junit.framework.Assert;

public class MassSendHistoryUI
  extends MMActivity
  implements k.a, k.b, SensorController.SensorEventCallBack
{
  private static SensorController qUq;
  private com.tencent.mm.audio.a.a doD;
  private View poS;
  private o.g pso;
  private boolean qUm;
  private boolean yMq;
  private ListView zoc;
  private c zod;
  private Button zoe;
  private Button zof;
  private MMPullDownView zog;
  private LinearLayout zoh;
  
  public MassSendHistoryUI()
  {
    AppMethodBeat.i(26428);
    this.qUm = true;
    this.yMq = false;
    this.pso = new MassSendHistoryUI.4(this);
    AppMethodBeat.o(26428);
  }
  
  private boolean startPlay(String paramString)
  {
    AppMethodBeat.i(26438);
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      qUq.setSensorCallBack(this);
      paramString = h.ehF().aDL(paramString);
      bg.aVF();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (Util.isNullOrNil(paramString.ehx()))) {
        break;
      }
      u.g(this, null);
      AppMethodBeat.o(26438);
      return false;
    }
    if (this.doD == null) {
      this.doD = new com.tencent.mm.audio.a.a(this);
    }
    this.doD.stop(false);
    if (this.doD.n(paramString.ehx(), this.qUm))
    {
      com.tencent.mm.plugin.audio.c.a.agr("music").jp(this.qUm);
      this.doD.dyn = this;
      this.doD.dym = this;
      AppMethodBeat.o(26438);
      return true;
    }
    Toast.makeText(this, getString(2131757488), 0).show();
    AppMethodBeat.o(26438);
    return false;
  }
  
  private void stopPlay()
  {
    AppMethodBeat.i(26439);
    qUq.removeSensorCallBack();
    this.doD.stop(false);
    this.zod.aDP("");
    releaseWakeLock();
    AppMethodBeat.o(26439);
  }
  
  public int getLayoutId()
  {
    return 2131495464;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26433);
    this.yMq = getIntent().getBooleanExtra("finish_direct", false);
    Log.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.yMq);
    this.zoh = ((LinearLayout)findViewById(2131304531));
    this.zoc = ((ListView)findViewById(2131304514));
    this.zoc.setTranscriptMode(0);
    this.zog = ((MMPullDownView)findViewById(2131304515));
    this.zog.setOnTopLoadDataListener(new MMPullDownView.g()
    {
      public final boolean cAm()
      {
        int i = 0;
        AppMethodBeat.i(26420);
        if (MassSendHistoryUI.b(MassSendHistoryUI.this).cwg())
        {
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(0, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
        }
        c localc = MassSendHistoryUI.b(MassSendHistoryUI.this);
        if (localc.cwg()) {}
        for (;;)
        {
          Log.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:".concat(String.valueOf(i)));
          MassSendHistoryUI.b(MassSendHistoryUI.this).onNotifyChange(null, null);
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(i, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
          localc.qdp += 10;
          if (localc.qdp <= localc.gAZ)
          {
            i = 10;
          }
          else
          {
            localc.qdp = localc.gAZ;
            i = localc.gAZ % 10;
          }
        }
      }
    });
    this.zog.setTopViewVisible(true);
    this.zog.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean cAl()
      {
        AppMethodBeat.i(26421);
        if ((MassSendHistoryUI.d(MassSendHistoryUI.this).getChildAt(MassSendHistoryUI.d(MassSendHistoryUI.this).getChildCount() - 1).getBottom() <= MassSendHistoryUI.d(MassSendHistoryUI.this).getHeight()) && (MassSendHistoryUI.d(MassSendHistoryUI.this).getLastVisiblePosition() == MassSendHistoryUI.d(MassSendHistoryUI.this).getAdapter().getCount() - 1))
        {
          AppMethodBeat.o(26421);
          return true;
        }
        AppMethodBeat.o(26421);
        return false;
      }
    });
    this.zog.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean cAk()
      {
        AppMethodBeat.i(26422);
        View localView = MassSendHistoryUI.d(MassSendHistoryUI.this).getChildAt(MassSendHistoryUI.d(MassSendHistoryUI.this).getFirstVisiblePosition());
        if ((localView != null) && (localView.getTop() == 0))
        {
          AppMethodBeat.o(26422);
          return true;
        }
        AppMethodBeat.o(26422);
        return false;
      }
    });
    this.zog.setIsBottomShowAll(true);
    this.zod = new c(this);
    this.zod.a(new s.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(26423);
        MassSendHistoryUI.c(MassSendHistoryUI.this).setIsTopShowAll(MassSendHistoryUI.b(MassSendHistoryUI.this).cwg());
        if (MassSendHistoryUI.b(MassSendHistoryUI.this).getCount() == 0)
        {
          MassSendHistoryUI.c(MassSendHistoryUI.this).setVisibility(8);
          MassSendHistoryUI.e(MassSendHistoryUI.this).setVisibility(0);
          MassSendHistoryUI.f(MassSendHistoryUI.this).setVisibility(8);
          AppMethodBeat.o(26423);
          return;
        }
        MassSendHistoryUI.c(MassSendHistoryUI.this).setVisibility(0);
        MassSendHistoryUI.e(MassSendHistoryUI.this).setVisibility(8);
        MassSendHistoryUI.f(MassSendHistoryUI.this).setVisibility(0);
        AppMethodBeat.o(26423);
      }
    });
    this.poS = findViewById(2131304513);
    this.zoc.setAdapter(this.zod);
    this.zoc.setOnItemClickListener(new MassSendHistoryUI.9(this));
    this.zoc.setOnTouchListener(new MassSendHistoryUI.10(this));
    this.zoe = ((Button)findViewById(2131304530));
    this.zoe.setOnClickListener(new MassSendHistoryUI.11(this));
    this.zof = ((Button)findViewById(2131304532));
    this.zof.setOnClickListener(new MassSendHistoryUI.12(this));
    setBackBtn(new MassSendHistoryUI.2(this));
    addIconOptionMenu(0, 2131755981, 2131689513, new MassSendHistoryUI.3(this));
    new l(this).a(this.zoc, this, this.pso);
    AppMethodBeat.o(26433);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(26440);
    stopPlay();
    AppMethodBeat.o(26440);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26429);
    super.onCreate(paramBundle);
    setMMTitle(2131762964);
    if (qUq == null) {
      qUq = new SensorController(getApplicationContext());
    }
    initView();
    this.doD = new com.tencent.mm.audio.a.a(this);
    this.doD.dyn = this;
    this.doD.dym = this;
    this.zod.znS = new c.e()
    {
      public final String aDQ(String paramAnonymousString)
      {
        AppMethodBeat.i(26416);
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          u.g(MassSendHistoryUI.this, null);
          AppMethodBeat.o(26416);
          return "";
        }
        paramAnonymousString = Util.nullAsNil(paramAnonymousString);
        if ((MassSendHistoryUI.a(MassSendHistoryUI.this).isPlaying()) && (paramAnonymousString.equals(MassSendHistoryUI.b(MassSendHistoryUI.this).znR)))
        {
          MassSendHistoryUI.ehS();
          MassSendHistoryUI.this.releaseWakeLock();
          MassSendHistoryUI.a(MassSendHistoryUI.this).stop(false);
          AppMethodBeat.o(26416);
          return "";
        }
        if (MassSendHistoryUI.a(MassSendHistoryUI.this, paramAnonymousString))
        {
          AppMethodBeat.o(26416);
          return paramAnonymousString;
        }
        AppMethodBeat.o(26416);
        return "";
      }
    };
    if (this.mController != null) {
      this.mController.bF(3, false);
    }
    AppMethodBeat.o(26429);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26435);
    Log.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((com.tencent.mm.plugin.masssend.a.a)this.zod.getItem(paramView.position)).ehz().split(";");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramContextMenuInfo.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContextMenuInfo[i];
      bg.aVF();
      localObject = com.tencent.mm.model.c.aSN().Kn((String)localObject);
      if (localObject != null) {
        localStringBuilder.append(((as)localObject).arJ() + ";");
      }
      i += 1;
    }
    paramContextMenu.setHeaderTitle(localStringBuilder.toString());
    paramContextMenu.add(paramView.position, 1, 0, getString(2131757433));
    AppMethodBeat.o(26435);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26432);
    stopPlay();
    this.zod.ebf();
    super.onDestroy();
    AppMethodBeat.o(26432);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(26441);
    stopPlay();
    AppMethodBeat.o(26441);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26434);
    if (paramInt == 4)
    {
      if (this.yMq) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(26434);
        return true;
        paramKeyEvent = new Intent();
        paramKeyEvent.addFlags(67108864);
        com.tencent.mm.plugin.masssend.a.jRt.o(paramKeyEvent, this);
        finish();
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(26434);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26431);
    super.onPause();
    h.ehF().remove(this.zod);
    qUq.removeSensorCallBack();
    AppMethodBeat.o(26431);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26430);
    super.onResume();
    h.ehF().add(this.zod);
    this.zod.onNotifyChange(null, null);
    this.zoc.setSelection(this.zod.getCount() - 1);
    AppMethodBeat.o(26430);
  }
  
  public void onSensorEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(26437);
    if (this.doD == null)
    {
      AppMethodBeat.o(26437);
      return;
    }
    if (!this.doD.isPlaying())
    {
      this.doD.cU(true);
      com.tencent.mm.plugin.audio.c.a.agr("music").jp(true);
      this.qUm = true;
      AppMethodBeat.o(26437);
      return;
    }
    this.doD.cU(paramBoolean);
    com.tencent.mm.plugin.audio.c.a.agr("music").jp(paramBoolean);
    this.qUm = paramBoolean;
    if (!paramBoolean)
    {
      if (startPlay(this.zod.znR))
      {
        this.zod.aDP(this.zod.znR);
        AppMethodBeat.o(26437);
        return;
      }
      this.zod.aDP("");
    }
    AppMethodBeat.o(26437);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void releaseWakeLock()
  {
    AppMethodBeat.i(26436);
    this.zoc.setKeepScreenOn(false);
    AppMethodBeat.o(26436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI
 * JD-Core Version:    0.7.0.1
 */