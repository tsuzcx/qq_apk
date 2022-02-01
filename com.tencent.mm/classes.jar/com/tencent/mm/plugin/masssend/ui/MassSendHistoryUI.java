package com.tencent.mm.plugin.masssend.ui;

import android.app.Activity;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.l;
import junit.framework.Assert;

public class MassSendHistoryUI
  extends MMActivity
  implements h.a, h.b, SensorController.a
{
  private static SensorController pEZ;
  private com.tencent.mm.audio.a.a cYa;
  private View odU;
  private n.e ogY;
  private boolean pEV;
  private ListView vTW;
  private c vTX;
  private Button vTY;
  private Button vTZ;
  private MMPullDownView vUa;
  private LinearLayout vUb;
  private boolean vsD;
  
  public MassSendHistoryUI()
  {
    AppMethodBeat.i(26428);
    this.pEV = true;
    this.vsD = false;
    this.ogY = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(26419);
        Object localObject1;
        Object localObject2;
        if (paramAnonymousMenuItem.getItemId() == 1)
        {
          localObject1 = (com.tencent.mm.plugin.masssend.a.a)MassSendHistoryUI.b(MassSendHistoryUI.this).getItem(paramAnonymousMenuItem.getGroupId());
          if (localObject1 == null)
          {
            AppMethodBeat.o(26419);
            return;
          }
          if (((com.tencent.mm.plugin.masssend.a.a)localObject1).dnK().equals(MassSendHistoryUI.b(MassSendHistoryUI.this).vTL)) {
            MassSendHistoryUI.h(MassSendHistoryUI.this);
          }
          paramAnonymousMenuItem = com.tencent.mm.plugin.masssend.a.h.dnT();
          localObject1 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).dnK();
          localObject2 = paramAnonymousMenuItem.hKK.a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
          if (localObject2 != null)
          {
            if (((Cursor)localObject2).getCount() != 0) {
              break label154;
            }
            ((Cursor)localObject2).close();
          }
        }
        for (;;)
        {
          if (paramAnonymousMenuItem.hKK.delete("massendinfo", "clientid= ?", new String[] { String.valueOf(localObject1) }) > 0) {
            paramAnonymousMenuItem.doNotify();
          }
          AppMethodBeat.o(26419);
          return;
          label154:
          com.tencent.mm.plugin.masssend.a.a locala;
          if (((Cursor)localObject2).getCount() == 1)
          {
            ((Cursor)localObject2).moveToFirst();
            locala = new com.tencent.mm.plugin.masssend.a.a();
            locala.convertFrom((Cursor)localObject2);
            ((Cursor)localObject2).close();
            localObject2 = new au();
            ((au)localObject2).setUsername("masssendapp");
            ((au)localObject2).setContent(ak.getContext().getResources().getString(2131757722));
            ((au)localObject2).qH(locala.createTime);
            ((au)localObject2).kt(0);
            ((au)localObject2).kr(0);
            bc.aCg();
            com.tencent.mm.model.c.azL().a((au)localObject2, "masssendapp");
          }
          else
          {
            ((Cursor)localObject2).moveToPosition(1);
            locala = new com.tencent.mm.plugin.masssend.a.a();
            locala.convertFrom((Cursor)localObject2);
            ((Cursor)localObject2).close();
            localObject2 = new au();
            ((au)localObject2).setUsername("masssendapp");
            ((au)localObject2).setContent(com.tencent.mm.plugin.masssend.a.b.a(locala));
            ((au)localObject2).qH(locala.createTime);
            ((au)localObject2).kt(0);
            ((au)localObject2).kr(0);
            bc.aCg();
            com.tencent.mm.model.c.azL().a((au)localObject2, "masssendapp");
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
      pEZ.a(this);
      paramString = com.tencent.mm.plugin.masssend.a.h.dnT().aqq(paramString);
      bc.aCg();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bu.isNullOrNil(paramString.dnL()))) {
        break;
      }
      t.g(this, null);
      AppMethodBeat.o(26438);
      return false;
    }
    if (this.cYa == null) {
      this.cYa = new com.tencent.mm.audio.a.a(this);
    }
    this.cYa.stop(false);
    if (this.cYa.n(paramString.dnL(), this.pEV))
    {
      com.tencent.mm.plugin.audio.c.a.Ww("music").io(this.pEV);
      this.cYa.dhb = this;
      this.cYa.dha = this;
      AppMethodBeat.o(26438);
      return true;
    }
    Toast.makeText(this, getString(2131757274), 0).show();
    AppMethodBeat.o(26438);
    return false;
  }
  
  private void stopPlay()
  {
    AppMethodBeat.i(26439);
    pEZ.fpx();
    this.cYa.stop(false);
    this.vTX.aqu("");
    releaseWakeLock();
    AppMethodBeat.o(26439);
  }
  
  public int getLayoutId()
  {
    return 2131494735;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26433);
    this.vsD = getIntent().getBooleanExtra("finish_direct", false);
    ae.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.vsD);
    this.vUb = ((LinearLayout)findViewById(2131302189));
    this.vTW = ((ListView)findViewById(2131302172));
    this.vTW.setTranscriptMode(0);
    this.vUa = ((MMPullDownView)findViewById(2131302173));
    this.vUa.setOnTopLoadDataListener(new MMPullDownView.g()
    {
      public final boolean ccs()
      {
        int i = 0;
        AppMethodBeat.i(26420);
        if (MassSendHistoryUI.b(MassSendHistoryUI.this).bYq())
        {
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(0, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
        }
        c localc = MassSendHistoryUI.b(MassSendHistoryUI.this);
        if (localc.bYq()) {}
        for (;;)
        {
          ae.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:".concat(String.valueOf(i)));
          MassSendHistoryUI.b(MassSendHistoryUI.this).a(null, null);
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(i, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
          localc.oPB += 10;
          if (localc.oPB <= localc.fVS)
          {
            i = 10;
          }
          else
          {
            localc.oPB = localc.fVS;
            i = localc.fVS % 10;
          }
        }
      }
    });
    this.vUa.setTopViewVisible(true);
    this.vUa.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean ccr()
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
    this.vUa.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean ccq()
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
    this.vUa.setIsBottomShowAll(true);
    this.vTX = new c(this);
    this.vTX.a(new r.a()
    {
      public final void aSR()
      {
        AppMethodBeat.i(26423);
        MassSendHistoryUI.c(MassSendHistoryUI.this).setIsTopShowAll(MassSendHistoryUI.b(MassSendHistoryUI.this).bYq());
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
    this.odU = findViewById(2131302171);
    this.vTW.setAdapter(this.vTX);
    this.vTW.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26424);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        ae.v("MicroMsg.MassSendHistoryUI", "onItemClick");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(26424);
      }
    });
    this.vTW.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(26425);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        ae.v("MicroMsg.MassSendHistoryUI", "onTouch");
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(26425);
        return false;
      }
    });
    this.vTY = ((Button)findViewById(2131302188));
    this.vTY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26426);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class);
        paramAnonymousView = MassSendHistoryUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26426);
      }
    });
    this.vTZ = ((Button)findViewById(2131302190));
    this.vTZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26427);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class);
        paramAnonymousView = MassSendHistoryUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26427);
      }
    });
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
          com.tencent.mm.plugin.masssend.a.iUz.p(paramAnonymousMenuItem, MassSendHistoryUI.this);
          MassSendHistoryUI.this.finish();
        }
      }
    });
    addIconOptionMenu(0, 2131755889, 2131689511, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26418);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Contact_User", "masssendapp");
        com.tencent.mm.plugin.masssend.a.iUz.c(paramAnonymousMenuItem, MassSendHistoryUI.this);
        AppMethodBeat.o(26418);
        return true;
      }
    });
    new l(this).a(this.vTW, this, this.ogY);
    AppMethodBeat.o(26433);
  }
  
  public final void km(boolean paramBoolean)
  {
    AppMethodBeat.i(26437);
    if (this.cYa == null)
    {
      AppMethodBeat.o(26437);
      return;
    }
    if (!this.cYa.isPlaying())
    {
      this.cYa.cm(true);
      com.tencent.mm.plugin.audio.c.a.Ww("music").io(true);
      this.pEV = true;
      AppMethodBeat.o(26437);
      return;
    }
    this.cYa.cm(paramBoolean);
    com.tencent.mm.plugin.audio.c.a.Ww("music").io(paramBoolean);
    this.pEV = paramBoolean;
    if (!paramBoolean)
    {
      if (startPlay(this.vTX.vTL))
      {
        this.vTX.aqu(this.vTX.vTL);
        AppMethodBeat.o(26437);
        return;
      }
      this.vTX.aqu("");
    }
    AppMethodBeat.o(26437);
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
    setMMTitle(2131761177);
    if (pEZ == null) {
      pEZ = new SensorController(getApplicationContext());
    }
    initView();
    this.cYa = new com.tencent.mm.audio.a.a(this);
    this.cYa.dhb = this;
    this.cYa.dha = this;
    this.vTX.vTM = new c.e()
    {
      public final String aqv(String paramAnonymousString)
      {
        AppMethodBeat.i(26416);
        bc.aCg();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          t.g(MassSendHistoryUI.this, null);
          AppMethodBeat.o(26416);
          return "";
        }
        paramAnonymousString = bu.nullAsNil(paramAnonymousString);
        if ((MassSendHistoryUI.a(MassSendHistoryUI.this).isPlaying()) && (paramAnonymousString.equals(MassSendHistoryUI.b(MassSendHistoryUI.this).vTL)))
        {
          MassSendHistoryUI.dof();
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
      this.mController.bk(3, false);
    }
    AppMethodBeat.o(26429);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26435);
    ae.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((com.tencent.mm.plugin.masssend.a.a)this.vTX.getItem(paramView.position)).dnN().split(";");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramContextMenuInfo.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContextMenuInfo[i];
      bc.aCg();
      localObject = com.tencent.mm.model.c.azF().BH((String)localObject);
      if (localObject != null) {
        localStringBuilder.append(((an)localObject).adG() + ";");
      }
      i += 1;
    }
    paramContextMenu.setHeaderTitle(localStringBuilder.toString());
    paramContextMenu.add(paramView.position, 1, 0, getString(2131757221));
    AppMethodBeat.o(26435);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26432);
    stopPlay();
    this.vTX.dhl();
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
      if (this.vsD) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(26434);
        return true;
        paramKeyEvent = new Intent();
        paramKeyEvent.addFlags(67108864);
        com.tencent.mm.plugin.masssend.a.iUz.p(paramKeyEvent, this);
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
    com.tencent.mm.plugin.masssend.a.h.dnT().remove(this.vTX);
    pEZ.fpx();
    AppMethodBeat.o(26431);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26430);
    super.onResume();
    com.tencent.mm.plugin.masssend.a.h.dnT().add(this.vTX);
    this.vTX.a(null, null);
    this.vTW.setSelection(this.vTX.getCount() - 1);
    AppMethodBeat.o(26430);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void releaseWakeLock()
  {
    AppMethodBeat.i(26436);
    this.vTW.setKeepScreenOn(false);
    AppMethodBeat.o(26436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI
 * JD-Core Version:    0.7.0.1
 */