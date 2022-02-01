package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.j.a;
import com.tencent.mm.am.j.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.masssend.model.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.x.a;
import com.tencent.mm.ui.y;
import junit.framework.Assert;

public class MassSendHistoryUI
  extends MMActivity
  implements j.a, j.b, SensorController.SensorEventCallBack
{
  private static SensorController xCV;
  private ListView KNX;
  private c KNY;
  private Button KNZ;
  private Button KOa;
  private MMPullDownView KOb;
  private LinearLayout KOc;
  private boolean KiQ;
  private com.tencent.mm.audio.a.a hls;
  private View vDA;
  private u.i vGU;
  private boolean xCR;
  
  public MassSendHistoryUI()
  {
    AppMethodBeat.i(26428);
    this.xCR = true;
    this.KiQ = false;
    this.vGU = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(26419);
        Object localObject1;
        Object localObject2;
        if (paramAnonymousMenuItem.getItemId() == 1)
        {
          localObject1 = (com.tencent.mm.plugin.masssend.model.a)MassSendHistoryUI.b(MassSendHistoryUI.this).getItem(paramAnonymousMenuItem.getGroupId());
          if (localObject1 == null)
          {
            AppMethodBeat.o(26419);
            return;
          }
          if (((com.tencent.mm.plugin.masssend.model.a)localObject1).fZM().equals(MassSendHistoryUI.b(MassSendHistoryUI.this).KNM)) {
            MassSendHistoryUI.h(MassSendHistoryUI.this);
          }
          paramAnonymousMenuItem = g.fZV();
          localObject1 = ((com.tencent.mm.plugin.masssend.model.a)localObject1).fZM();
          localObject2 = paramAnonymousMenuItem.omV.rawQuery("select * from massendinfo ORDER BY createtime DESC  limit 2", null);
          if (localObject2 != null)
          {
            if (((Cursor)localObject2).getCount() != 0) {
              break label153;
            }
            ((Cursor)localObject2).close();
          }
        }
        for (;;)
        {
          if (paramAnonymousMenuItem.omV.delete("massendinfo", "clientid= ?", new String[] { String.valueOf(localObject1) }) > 0) {
            paramAnonymousMenuItem.doNotify();
          }
          AppMethodBeat.o(26419);
          return;
          label153:
          com.tencent.mm.plugin.masssend.model.a locala;
          if (((Cursor)localObject2).getCount() == 1)
          {
            ((Cursor)localObject2).moveToFirst();
            locala = new com.tencent.mm.plugin.masssend.model.a();
            locala.convertFrom((Cursor)localObject2);
            ((Cursor)localObject2).close();
            localObject2 = new bb();
            ((bb)localObject2).setUsername("masssendapp");
            ((bb)localObject2).setContent(MMApplicationContext.getContext().getResources().getString(R.l.gBw));
            ((bb)localObject2).gR(locala.createTime);
            ((bb)localObject2).pI(0);
            ((bb)localObject2).pG(0);
            bh.bCz();
            com.tencent.mm.model.c.bzG().c((bb)localObject2, "masssendapp");
          }
          else
          {
            ((Cursor)localObject2).moveToPosition(1);
            locala = new com.tencent.mm.plugin.masssend.model.a();
            locala.convertFrom((Cursor)localObject2);
            ((Cursor)localObject2).close();
            localObject2 = new bb();
            ((bb)localObject2).setUsername("masssendapp");
            ((bb)localObject2).setContent(com.tencent.mm.plugin.masssend.model.b.a(locala));
            ((bb)localObject2).gR(locala.createTime);
            ((bb)localObject2).pI(0);
            ((bb)localObject2).pG(0);
            bh.bCz();
            com.tencent.mm.model.c.bzG().c((bb)localObject2, "masssendapp");
          }
        }
      }
    };
    AppMethodBeat.o(26428);
  }
  
  private boolean startPlay(String paramString)
  {
    AppMethodBeat.i(26438);
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      xCV.setSensorCallBack(this);
      paramString = g.fZV().aKS(paramString);
      bh.bCz();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (Util.isNullOrNil(paramString.fZN()))) {
        break;
      }
      aa.j(this, null);
      AppMethodBeat.o(26438);
      return false;
    }
    if (this.hls == null) {
      this.hls = new com.tencent.mm.audio.a.a(this);
    }
    this.hls.stop(false);
    if (this.hls.q(paramString.fZN(), this.xCR))
    {
      com.tencent.mm.plugin.audio.c.a.ahs("music").lN(this.xCR);
      this.hls.hvl = this;
      this.hls.hvk = this;
      AppMethodBeat.o(26438);
      return true;
    }
    Toast.makeText(this, getString(R.l.gze), 0).show();
    AppMethodBeat.o(26438);
    return false;
  }
  
  private void stopPlay()
  {
    AppMethodBeat.i(26439);
    xCV.removeSensorCallBack();
    this.hls.stop(false);
    this.KNY.aKW("");
    releaseWakeLock();
    AppMethodBeat.o(26439);
  }
  
  public final void atR()
  {
    AppMethodBeat.i(26441);
    stopPlay();
    AppMethodBeat.o(26441);
  }
  
  public int getLayoutId()
  {
    return R.i.glu;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26433);
    this.KiQ = getIntent().getBooleanExtra("finish_direct", false);
    Log.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.KiQ);
    this.KOc = ((LinearLayout)findViewById(R.h.fNV));
    this.KNX = ((ListView)findViewById(R.h.fNF));
    this.KNX.setTranscriptMode(0);
    this.KOb = ((MMPullDownView)findViewById(R.h.fNG));
    this.KOb.setOnTopLoadDataListener(new MMPullDownView.g()
    {
      public final boolean dsr()
      {
        int i = 0;
        AppMethodBeat.i(26420);
        if (MassSendHistoryUI.b(MassSendHistoryUI.this).dmY())
        {
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(0, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
        }
        c localc = MassSendHistoryUI.b(MassSendHistoryUI.this);
        if (localc.dmY()) {}
        for (;;)
        {
          Log.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:".concat(String.valueOf(i)));
          MassSendHistoryUI.b(MassSendHistoryUI.this).onNotifyChange(null, null);
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(i, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
          localc.wDI += 10;
          if (localc.wDI <= localc.lNX)
          {
            i = 10;
          }
          else
          {
            localc.wDI = localc.lNX;
            i = localc.lNX % 10;
          }
        }
      }
    });
    this.KOb.setTopViewVisible(true);
    this.KOb.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean dsq()
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
    this.KOb.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean dsp()
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
    this.KOb.setIsBottomShowAll(true);
    this.KNY = new c(this);
    this.KNY.a(new x.a()
    {
      public final void bWC()
      {
        AppMethodBeat.i(26423);
        MassSendHistoryUI.c(MassSendHistoryUI.this).setIsTopShowAll(MassSendHistoryUI.b(MassSendHistoryUI.this).dmY());
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
    this.vDA = findViewById(R.h.fNE);
    this.KNX.setAdapter(this.KNY);
    this.KNX.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26424);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        Log.v("MicroMsg.MassSendHistoryUI", "onItemClick");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(26424);
      }
    });
    this.KNX.setOnTouchListener(new MassSendHistoryUI.10(this));
    this.KNZ = ((Button)findViewById(R.h.fNU));
    this.KNZ.setOnClickListener(new MassSendHistoryUI.11(this));
    this.KOa = ((Button)findViewById(R.h.fNW));
    this.KOa.setOnClickListener(new MassSendHistoryUI.12(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26417);
        if (MassSendHistoryUI.g(MassSendHistoryUI.this)) {
          MassSendHistoryUI.this.finish();
        }
        for (;;)
        {
          AppMethodBeat.o(26417);
          return true;
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.addFlags(67108864);
          com.tencent.mm.plugin.masssend.a.pFn.n(paramAnonymousMenuItem, MassSendHistoryUI.this);
          MassSendHistoryUI.this.finish();
        }
      }
    });
    addIconOptionMenu(0, R.l.app_set, R.k.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26418);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Contact_User", "masssendapp");
        com.tencent.mm.plugin.masssend.a.dNP().c(paramAnonymousMenuItem, MassSendHistoryUI.this);
        AppMethodBeat.o(26418);
        return true;
      }
    });
    new l(this).a(this.KNX, this, this.vGU);
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
    setMMTitle(R.l.gNv);
    if (xCV == null) {
      xCV = new SensorController(getApplicationContext());
    }
    initView();
    this.hls = new com.tencent.mm.audio.a.a(this);
    this.hls.hvl = this;
    this.hls.hvk = this;
    this.KNY.KNN = new c.e()
    {
      public final String aKX(String paramAnonymousString)
      {
        AppMethodBeat.i(26416);
        bh.bCz();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          aa.j(MassSendHistoryUI.this, null);
          AppMethodBeat.o(26416);
          return "";
        }
        paramAnonymousString = Util.nullAsNil(paramAnonymousString);
        if ((MassSendHistoryUI.a(MassSendHistoryUI.this).isPlaying()) && (paramAnonymousString.equals(MassSendHistoryUI.b(MassSendHistoryUI.this).KNM)))
        {
          MassSendHistoryUI.gai();
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
      this.mController.cD(3, false);
    }
    AppMethodBeat.o(26429);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26435);
    Log.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((com.tencent.mm.plugin.masssend.model.a)this.KNY.getItem(paramView.position)).fZP().split(";");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramContextMenuInfo.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContextMenuInfo[i];
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzA().JE((String)localObject);
      if (localObject != null) {
        localStringBuilder.append(((au)localObject).aSV() + ";");
      }
      i += 1;
    }
    paramContextMenu.setHeaderTitle(localStringBuilder.toString());
    paramContextMenu.add(paramView.position, 1, 0, getString(R.l.gyo));
    AppMethodBeat.o(26435);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26432);
    stopPlay();
    this.KNY.fSd();
    super.onDestroy();
    AppMethodBeat.o(26432);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26434);
    if (paramInt == 4)
    {
      if (this.KiQ) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(26434);
        return true;
        paramKeyEvent = new Intent();
        paramKeyEvent.addFlags(67108864);
        com.tencent.mm.plugin.masssend.a.pFn.n(paramKeyEvent, this);
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
    g.fZV().remove(this.KNY);
    xCV.removeSensorCallBack();
    AppMethodBeat.o(26431);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26430);
    super.onResume();
    g.fZV().add(this.KNY);
    this.KNY.onNotifyChange(null, null);
    this.KNX.setSelection(this.KNY.getCount() - 1);
    AppMethodBeat.o(26430);
  }
  
  public void onSensorEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(26437);
    if (this.hls == null)
    {
      AppMethodBeat.o(26437);
      return;
    }
    if (!this.hls.isPlaying())
    {
      this.hls.ed(true);
      com.tencent.mm.plugin.audio.c.a.ahs("music").lN(true);
      this.xCR = true;
      AppMethodBeat.o(26437);
      return;
    }
    this.hls.ed(paramBoolean);
    com.tencent.mm.plugin.audio.c.a.ahs("music").lN(paramBoolean);
    this.xCR = paramBoolean;
    if (!paramBoolean)
    {
      if (startPlay(this.KNY.KNM))
      {
        this.KNY.aKW(this.KNY.KNM);
        AppMethodBeat.o(26437);
        return;
      }
      this.KNY.aKW("");
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
    this.KNX.setKeepScreenOn(false);
    AppMethodBeat.o(26436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI
 * JD-Core Version:    0.7.0.1
 */