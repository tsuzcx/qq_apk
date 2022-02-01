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
import com.tencent.mm.ak.i.a;
import com.tencent.mm.ak.i.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.s;
import junit.framework.Assert;

public class MassSendHistoryUI
  extends MMActivity
  implements i.a, i.b, SensorController.a
{
  private static SensorController oUL;
  private com.tencent.mm.audio.a.a cLP;
  private n.d nAc;
  private View nwN;
  private boolean oUH;
  private ListView uES;
  private c uET;
  private Button uEU;
  private Button uEV;
  private MMPullDownView uEW;
  private LinearLayout uEX;
  private boolean udM;
  
  public MassSendHistoryUI()
  {
    AppMethodBeat.i(26428);
    this.oUH = true;
    this.udM = false;
    this.nAc = new n.d()
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
          if (((com.tencent.mm.plugin.masssend.a.a)localObject1).dbq().equals(MassSendHistoryUI.b(MassSendHistoryUI.this).uEH)) {
            MassSendHistoryUI.h(MassSendHistoryUI.this);
          }
          paramAnonymousMenuItem = com.tencent.mm.plugin.masssend.a.h.dbz();
          localObject1 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).dbq();
          localObject2 = paramAnonymousMenuItem.hpA.a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
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
          if (paramAnonymousMenuItem.hpA.delete("massendinfo", "clientid= ?", new String[] { String.valueOf(localObject1) }) > 0) {
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
            localObject2 = new ap();
            ((ap)localObject2).setUsername("masssendapp");
            ((ap)localObject2).setContent(com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getString(2131757722));
            ((ap)localObject2).ou(locala.createTime);
            ((ap)localObject2).jT(0);
            ((ap)localObject2).jR(0);
            az.ayM();
            com.tencent.mm.model.c.awG().a((ap)localObject2, "masssendapp");
          }
          else
          {
            ((Cursor)localObject2).moveToPosition(1);
            locala = new com.tencent.mm.plugin.masssend.a.a();
            locala.convertFrom((Cursor)localObject2);
            ((Cursor)localObject2).close();
            localObject2 = new ap();
            ((ap)localObject2).setUsername("masssendapp");
            ((ap)localObject2).setContent(b.a(locala));
            ((ap)localObject2).ou(locala.createTime);
            ((ap)localObject2).jT(0);
            ((ap)localObject2).jR(0);
            az.ayM();
            com.tencent.mm.model.c.awG().a((ap)localObject2, "masssendapp");
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
      oUL.a(this);
      paramString = com.tencent.mm.plugin.masssend.a.h.dbz().aky(paramString);
      az.ayM();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bs.isNullOrNil(paramString.dbr()))) {
        break;
      }
      t.g(this, null);
      AppMethodBeat.o(26438);
      return false;
    }
    if (this.cLP == null) {
      this.cLP = new com.tencent.mm.audio.a.a(this);
    }
    this.cLP.stop(false);
    if (this.cLP.n(paramString.dbr(), this.oUH))
    {
      com.tencent.mm.plugin.audio.c.a.Sm("music").ih(this.oUH);
      this.cLP.cUJ = this;
      this.cLP.cUI = this;
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
    oUL.eVS();
    this.cLP.stop(false);
    this.uET.akC("");
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
    this.udM = getIntent().getBooleanExtra("finish_direct", false);
    ac.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.udM);
    this.uEX = ((LinearLayout)findViewById(2131302189));
    this.uES = ((ListView)findViewById(2131302172));
    this.uES.setTranscriptMode(0);
    this.uEW = ((MMPullDownView)findViewById(2131302173));
    this.uEW.setOnTopLoadDataListener(new MMPullDownView.g()
    {
      public final boolean bWA()
      {
        int i = 0;
        AppMethodBeat.i(26420);
        if (MassSendHistoryUI.b(MassSendHistoryUI.this).bSw())
        {
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(0, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
        }
        c localc = MassSendHistoryUI.b(MassSendHistoryUI.this);
        if (localc.bSw()) {}
        for (;;)
        {
          ac.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:".concat(String.valueOf(i)));
          MassSendHistoryUI.b(MassSendHistoryUI.this).a(null, null);
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(i, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
          localc.ofG += 10;
          if (localc.ofG <= localc.fAw)
          {
            i = 10;
          }
          else
          {
            localc.ofG = localc.fAw;
            i = localc.fAw % 10;
          }
        }
      }
    });
    this.uEW.setTopViewVisible(true);
    this.uEW.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean bWz()
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
    this.uEW.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean bWy()
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
    this.uEW.setIsBottomShowAll(true);
    this.uET = new c(this);
    this.uET.a(new r.a()
    {
      public final void aPg()
      {
        AppMethodBeat.i(26423);
        MassSendHistoryUI.c(MassSendHistoryUI.this).setIsTopShowAll(MassSendHistoryUI.b(MassSendHistoryUI.this).bSw());
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
    this.nwN = findViewById(2131302171);
    this.uES.setAdapter(this.uET);
    this.uES.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26424);
        ac.v("MicroMsg.MassSendHistoryUI", "onItemClick");
        AppMethodBeat.o(26424);
      }
    });
    this.uES.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(26425);
        ac.v("MicroMsg.MassSendHistoryUI", "onTouch");
        AppMethodBeat.o(26425);
        return false;
      }
    });
    this.uEU = ((Button)findViewById(2131302188));
    this.uEU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26426);
        Object localObject = new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class);
        paramAnonymousView = MassSendHistoryUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26426);
      }
    });
    this.uEV = ((Button)findViewById(2131302190));
    this.uEV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26427);
        Object localObject = new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class);
        paramAnonymousView = MassSendHistoryUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
          com.tencent.mm.plugin.masssend.a.iyx.p(paramAnonymousMenuItem, MassSendHistoryUI.this);
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
        com.tencent.mm.plugin.masssend.a.iyx.c(paramAnonymousMenuItem, MassSendHistoryUI.this);
        AppMethodBeat.o(26418);
        return true;
      }
    });
    new com.tencent.mm.ui.tools.l(this).a(this.uES, this, this.nAc);
    AppMethodBeat.o(26433);
  }
  
  public final void kc(boolean paramBoolean)
  {
    AppMethodBeat.i(26437);
    if (this.cLP == null)
    {
      AppMethodBeat.o(26437);
      return;
    }
    if (!this.cLP.isPlaying())
    {
      this.cLP.cl(true);
      com.tencent.mm.plugin.audio.c.a.Sm("music").ih(true);
      this.oUH = true;
      AppMethodBeat.o(26437);
      return;
    }
    this.cLP.cl(paramBoolean);
    com.tencent.mm.plugin.audio.c.a.Sm("music").ih(paramBoolean);
    this.oUH = paramBoolean;
    if (!paramBoolean)
    {
      if (startPlay(this.uET.uEH))
      {
        this.uET.akC(this.uET.uEH);
        AppMethodBeat.o(26437);
        return;
      }
      this.uET.akC("");
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
    if (oUL == null) {
      oUL = new SensorController(getApplicationContext());
    }
    initView();
    this.cLP = new com.tencent.mm.audio.a.a(this);
    this.cLP.cUJ = this;
    this.cLP.cUI = this;
    this.uET.uEI = new c.e()
    {
      public final String akD(String paramAnonymousString)
      {
        AppMethodBeat.i(26416);
        az.ayM();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          t.g(MassSendHistoryUI.this, null);
          AppMethodBeat.o(26416);
          return "";
        }
        paramAnonymousString = bs.nullAsNil(paramAnonymousString);
        if ((MassSendHistoryUI.a(MassSendHistoryUI.this).isPlaying()) && (paramAnonymousString.equals(MassSendHistoryUI.b(MassSendHistoryUI.this).uEH)))
        {
          MassSendHistoryUI.dbL();
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
      this.mController.aX(3, false);
    }
    AppMethodBeat.o(26429);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26435);
    ac.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((com.tencent.mm.plugin.masssend.a.a)this.uET.getItem(paramView.position)).dbt().split(";");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramContextMenuInfo.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContextMenuInfo[i];
      az.ayM();
      localObject = com.tencent.mm.model.c.awB().aNt((String)localObject);
      if (localObject != null) {
        localStringBuilder.append(((com.tencent.mm.storage.ai)localObject).aaS() + ";");
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
    this.uET.cVi();
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
      if (this.udM) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(26434);
        return true;
        paramKeyEvent = new Intent();
        paramKeyEvent.addFlags(67108864);
        com.tencent.mm.plugin.masssend.a.iyx.p(paramKeyEvent, this);
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
    com.tencent.mm.plugin.masssend.a.h.dbz().remove(this.uET);
    oUL.eVS();
    AppMethodBeat.o(26431);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26430);
    super.onResume();
    com.tencent.mm.plugin.masssend.a.h.dbz().add(this.uET);
    this.uET.a(null, null);
    this.uES.setSelection(this.uET.getCount() - 1);
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
    this.uES.setKeepScreenOn(false);
    AppMethodBeat.o(26436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI
 * JD-Core Version:    0.7.0.1
 */