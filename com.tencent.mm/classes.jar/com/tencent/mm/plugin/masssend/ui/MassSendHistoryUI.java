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
import com.tencent.mm.al.i.a;
import com.tencent.mm.al.i.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.q.a;
import com.tencent.mm.ui.r;
import junit.framework.Assert;

public class MassSendHistoryUI
  extends MMActivity
  implements i.a, i.b, SensorController.a
{
  private static SensorController orl;
  private com.tencent.mm.audio.a.a cOu;
  private View mUv;
  private n.d mXD;
  private boolean orh;
  private boolean sVA;
  private ListView twA;
  private c twB;
  private Button twC;
  private Button twD;
  private MMPullDownView twE;
  private LinearLayout twF;
  
  public MassSendHistoryUI()
  {
    AppMethodBeat.i(26428);
    this.orh = true;
    this.sVA = false;
    this.mXD = new n.d()
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
          if (((com.tencent.mm.plugin.masssend.a.a)localObject1).cNJ().equals(MassSendHistoryUI.b(MassSendHistoryUI.this).twp)) {
            MassSendHistoryUI.h(MassSendHistoryUI.this);
          }
          paramAnonymousMenuItem = com.tencent.mm.plugin.masssend.a.h.cNS();
          localObject1 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).cNJ();
          localObject2 = paramAnonymousMenuItem.gPa.a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
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
          if (paramAnonymousMenuItem.gPa.delete("massendinfo", "clientid= ?", new String[] { String.valueOf(localObject1) }) > 0) {
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
            localObject2 = new am();
            ((am)localObject2).setUsername("masssendapp");
            ((am)localObject2).setContent(aj.getContext().getResources().getString(2131757722));
            ((am)localObject2).kS(locala.createTime);
            ((am)localObject2).jV(0);
            ((am)localObject2).jT(0);
            az.arV();
            com.tencent.mm.model.c.apR().a((am)localObject2, "masssendapp");
          }
          else
          {
            ((Cursor)localObject2).moveToPosition(1);
            locala = new com.tencent.mm.plugin.masssend.a.a();
            locala.convertFrom((Cursor)localObject2);
            ((Cursor)localObject2).close();
            localObject2 = new am();
            ((am)localObject2).setUsername("masssendapp");
            ((am)localObject2).setContent(b.a(locala));
            ((am)localObject2).kS(locala.createTime);
            ((am)localObject2).jV(0);
            ((am)localObject2).jT(0);
            az.arV();
            com.tencent.mm.model.c.apR().a((am)localObject2, "masssendapp");
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
      orl.a(this);
      paramString = com.tencent.mm.plugin.masssend.a.h.cNS().afE(paramString);
      az.arV();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bt.isNullOrNil(paramString.cNK()))) {
        break;
      }
      t.g(this, null);
      AppMethodBeat.o(26438);
      return false;
    }
    if (this.cOu == null) {
      this.cOu = new com.tencent.mm.audio.a.a(this);
    }
    this.cOu.stop(false);
    if (this.cOu.n(paramString.cNK(), this.orh))
    {
      com.tencent.mm.plugin.audio.c.a.Od("music").hJ(this.orh);
      this.cOu.cXn = this;
      this.cOu.cXm = this;
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
    orl.eGx();
    this.cOu.stop(false);
    this.twB.afI("");
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
    this.sVA = getIntent().getBooleanExtra("finish_direct", false);
    ad.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.sVA);
    this.twF = ((LinearLayout)findViewById(2131302189));
    this.twA = ((ListView)findViewById(2131302172));
    this.twA.setTranscriptMode(0);
    this.twE = ((MMPullDownView)findViewById(2131302173));
    this.twE.setOnTopLoadDataListener(new MMPullDownView.g()
    {
      public final boolean bPk()
      {
        int i = 0;
        AppMethodBeat.i(26420);
        if (MassSendHistoryUI.b(MassSendHistoryUI.this).bLj())
        {
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(0, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
        }
        c localc = MassSendHistoryUI.b(MassSendHistoryUI.this);
        if (localc.bLj()) {}
        for (;;)
        {
          ad.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:".concat(String.valueOf(i)));
          MassSendHistoryUI.b(MassSendHistoryUI.this).a(null, null);
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(i, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
          localc.nCF += 10;
          if (localc.nCF <= localc.fwP)
          {
            i = 10;
          }
          else
          {
            localc.nCF = localc.fwP;
            i = localc.fwP % 10;
          }
        }
      }
    });
    this.twE.setTopViewVisible(true);
    this.twE.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean bPj()
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
    this.twE.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean bPi()
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
    this.twE.setIsBottomShowAll(true);
    this.twB = new c(this);
    this.twB.a(new q.a()
    {
      public final void aIp()
      {
        AppMethodBeat.i(26423);
        MassSendHistoryUI.c(MassSendHistoryUI.this).setIsTopShowAll(MassSendHistoryUI.b(MassSendHistoryUI.this).bLj());
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
    this.mUv = findViewById(2131302171);
    this.twA.setAdapter(this.twB);
    this.twA.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26424);
        ad.v("MicroMsg.MassSendHistoryUI", "onItemClick");
        AppMethodBeat.o(26424);
      }
    });
    this.twA.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(26425);
        ad.v("MicroMsg.MassSendHistoryUI", "onTouch");
        AppMethodBeat.o(26425);
        return false;
      }
    });
    this.twC = ((Button)findViewById(2131302188));
    this.twC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26426);
        Object localObject = new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class);
        paramAnonymousView = MassSendHistoryUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26426);
      }
    });
    this.twD = ((Button)findViewById(2131302190));
    this.twD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26427);
        Object localObject = new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class);
        paramAnonymousView = MassSendHistoryUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
          com.tencent.mm.plugin.masssend.a.hYt.p(paramAnonymousMenuItem, MassSendHistoryUI.this);
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
        com.tencent.mm.plugin.masssend.a.hYt.c(paramAnonymousMenuItem, MassSendHistoryUI.this);
        AppMethodBeat.o(26418);
        return true;
      }
    });
    new com.tencent.mm.ui.tools.l(this).a(this.twA, this, this.mXD);
    AppMethodBeat.o(26433);
  }
  
  public final void jz(boolean paramBoolean)
  {
    AppMethodBeat.i(26437);
    if (this.cOu == null)
    {
      AppMethodBeat.o(26437);
      return;
    }
    if (!this.cOu.isPlaying())
    {
      this.cOu.cj(true);
      com.tencent.mm.plugin.audio.c.a.Od("music").hJ(true);
      this.orh = true;
      AppMethodBeat.o(26437);
      return;
    }
    this.cOu.cj(paramBoolean);
    com.tencent.mm.plugin.audio.c.a.Od("music").hJ(paramBoolean);
    this.orh = paramBoolean;
    if (!paramBoolean)
    {
      if (startPlay(this.twB.twp))
      {
        this.twB.afI(this.twB.twp);
        AppMethodBeat.o(26437);
        return;
      }
      this.twB.afI("");
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
    if (orl == null) {
      orl = new SensorController(getApplicationContext());
    }
    initView();
    this.cOu = new com.tencent.mm.audio.a.a(this);
    this.cOu.cXn = this;
    this.cOu.cXm = this;
    this.twB.twq = new c.e()
    {
      public final String afJ(String paramAnonymousString)
      {
        AppMethodBeat.i(26416);
        az.arV();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          t.g(MassSendHistoryUI.this, null);
          AppMethodBeat.o(26416);
          return "";
        }
        paramAnonymousString = bt.nullAsNil(paramAnonymousString);
        if ((MassSendHistoryUI.a(MassSendHistoryUI.this).isPlaying()) && (paramAnonymousString.equals(MassSendHistoryUI.b(MassSendHistoryUI.this).twp)))
        {
          MassSendHistoryUI.cOd();
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
      this.mController.aT(3, false);
    }
    AppMethodBeat.o(26429);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26435);
    ad.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((com.tencent.mm.plugin.masssend.a.a)this.twB.getItem(paramView.position)).cNM().split(";");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramContextMenuInfo.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContextMenuInfo[i];
      az.arV();
      localObject = com.tencent.mm.model.c.apM().aHY((String)localObject);
      if (localObject != null) {
        localStringBuilder.append(((af)localObject).ZX() + ";");
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
    this.twB.cHX();
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
      if (this.sVA) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(26434);
        return true;
        paramKeyEvent = new Intent();
        paramKeyEvent.addFlags(67108864);
        com.tencent.mm.plugin.masssend.a.hYt.p(paramKeyEvent, this);
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
    com.tencent.mm.plugin.masssend.a.h.cNS().remove(this.twB);
    orl.eGx();
    AppMethodBeat.o(26431);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26430);
    super.onResume();
    com.tencent.mm.plugin.masssend.a.h.cNS().add(this.twB);
    this.twB.a(null, null);
    this.twA.setSelection(this.twB.getCount() - 1);
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
    this.twA.setKeepScreenOn(false);
    AppMethodBeat.o(26436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI
 * JD-Core Version:    0.7.0.1
 */