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
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.h.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
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
  private static SensorController pyv;
  private com.tencent.mm.audio.a.a cXd;
  private View nYl;
  private n.e obh;
  private boolean pyr;
  private ListView vHS;
  private c vHT;
  private Button vHU;
  private Button vHV;
  private MMPullDownView vHW;
  private LinearLayout vHX;
  private boolean vgw;
  
  public MassSendHistoryUI()
  {
    AppMethodBeat.i(26428);
    this.pyr = true;
    this.vgw = false;
    this.obh = new n.e()
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
          if (((com.tencent.mm.plugin.masssend.a.a)localObject1).dkK().equals(MassSendHistoryUI.b(MassSendHistoryUI.this).vHH)) {
            MassSendHistoryUI.h(MassSendHistoryUI.this);
          }
          paramAnonymousMenuItem = com.tencent.mm.plugin.masssend.a.h.dkT();
          localObject1 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).dkK();
          localObject2 = paramAnonymousMenuItem.hHS.a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
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
          if (paramAnonymousMenuItem.hHS.delete("massendinfo", "clientid= ?", new String[] { String.valueOf(localObject1) }) > 0) {
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
            localObject2 = new at();
            ((at)localObject2).setUsername("masssendapp");
            ((at)localObject2).setContent(aj.getContext().getResources().getString(2131757722));
            ((at)localObject2).qu(locala.createTime);
            ((at)localObject2).kr(0);
            ((at)localObject2).kp(0);
            ba.aBQ();
            com.tencent.mm.model.c.azv().a((at)localObject2, "masssendapp");
          }
          else
          {
            ((Cursor)localObject2).moveToPosition(1);
            locala = new com.tencent.mm.plugin.masssend.a.a();
            locala.convertFrom((Cursor)localObject2);
            ((Cursor)localObject2).close();
            localObject2 = new at();
            ((at)localObject2).setUsername("masssendapp");
            ((at)localObject2).setContent(com.tencent.mm.plugin.masssend.a.b.a(locala));
            ((at)localObject2).qu(locala.createTime);
            ((at)localObject2).kr(0);
            ((at)localObject2).kp(0);
            ba.aBQ();
            com.tencent.mm.model.c.azv().a((at)localObject2, "masssendapp");
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
      pyv.a(this);
      paramString = com.tencent.mm.plugin.masssend.a.h.dkT().apl(paramString);
      ba.aBQ();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bt.isNullOrNil(paramString.dkL()))) {
        break;
      }
      t.g(this, null);
      AppMethodBeat.o(26438);
      return false;
    }
    if (this.cXd == null) {
      this.cXd = new com.tencent.mm.audio.a.a(this);
    }
    this.cXd.stop(false);
    if (this.cXd.n(paramString.dkL(), this.pyr))
    {
      com.tencent.mm.plugin.audio.c.a.VK("music").iq(this.pyr);
      this.cXd.dfZ = this;
      this.cXd.dfY = this;
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
    pyv.flC();
    this.cXd.stop(false);
    this.vHT.app("");
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
    this.vgw = getIntent().getBooleanExtra("finish_direct", false);
    ad.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.vgw);
    this.vHX = ((LinearLayout)findViewById(2131302189));
    this.vHS = ((ListView)findViewById(2131302172));
    this.vHS.setTranscriptMode(0);
    this.vHW = ((MMPullDownView)findViewById(2131302173));
    this.vHW.setOnTopLoadDataListener(new MMPullDownView.g()
    {
      public final boolean cbd()
      {
        int i = 0;
        AppMethodBeat.i(26420);
        if (MassSendHistoryUI.b(MassSendHistoryUI.this).bXb())
        {
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(0, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
        }
        c localc = MassSendHistoryUI.b(MassSendHistoryUI.this);
        if (localc.bXb()) {}
        for (;;)
        {
          ad.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:".concat(String.valueOf(i)));
          MassSendHistoryUI.b(MassSendHistoryUI.this).a(null, null);
          MassSendHistoryUI.d(MassSendHistoryUI.this).setSelectionFromTop(i, MassSendHistoryUI.c(MassSendHistoryUI.this).getTopHeight());
          AppMethodBeat.o(26420);
          return true;
          localc.oIZ += 10;
          if (localc.oIZ <= localc.fTM)
          {
            i = 10;
          }
          else
          {
            localc.oIZ = localc.fTM;
            i = localc.fTM % 10;
          }
        }
      }
    });
    this.vHW.setTopViewVisible(true);
    this.vHW.setAtBottomCallBack(new MMPullDownView.c()
    {
      public final boolean cbc()
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
    this.vHW.setAtTopCallBack(new MMPullDownView.d()
    {
      public final boolean cbb()
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
    this.vHW.setIsBottomShowAll(true);
    this.vHT = new c(this);
    this.vHT.a(new r.a()
    {
      public final void aSs()
      {
        AppMethodBeat.i(26423);
        MassSendHistoryUI.c(MassSendHistoryUI.this).setIsTopShowAll(MassSendHistoryUI.b(MassSendHistoryUI.this).bXb());
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
    this.nYl = findViewById(2131302171);
    this.vHS.setAdapter(this.vHT);
    this.vHS.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26424);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        ad.v("MicroMsg.MassSendHistoryUI", "onItemClick");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(26424);
      }
    });
    this.vHS.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(26425);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        ad.v("MicroMsg.MassSendHistoryUI", "onTouch");
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(26425);
        return false;
      }
    });
    this.vHU = ((Button)findViewById(2131302188));
    this.vHU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26426);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class);
        paramAnonymousView = MassSendHistoryUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26426);
      }
    });
    this.vHV = ((Button)findViewById(2131302190));
    this.vHV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26427);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class);
        paramAnonymousView = MassSendHistoryUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
          com.tencent.mm.plugin.masssend.a.iRG.p(paramAnonymousMenuItem, MassSendHistoryUI.this);
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
        com.tencent.mm.plugin.masssend.a.iRG.c(paramAnonymousMenuItem, MassSendHistoryUI.this);
        AppMethodBeat.o(26418);
        return true;
      }
    });
    new l(this).a(this.vHS, this, this.obh);
    AppMethodBeat.o(26433);
  }
  
  public final void kn(boolean paramBoolean)
  {
    AppMethodBeat.i(26437);
    if (this.cXd == null)
    {
      AppMethodBeat.o(26437);
      return;
    }
    if (!this.cXd.isPlaying())
    {
      this.cXd.cm(true);
      com.tencent.mm.plugin.audio.c.a.VK("music").iq(true);
      this.pyr = true;
      AppMethodBeat.o(26437);
      return;
    }
    this.cXd.cm(paramBoolean);
    com.tencent.mm.plugin.audio.c.a.VK("music").iq(paramBoolean);
    this.pyr = paramBoolean;
    if (!paramBoolean)
    {
      if (startPlay(this.vHT.vHH))
      {
        this.vHT.app(this.vHT.vHH);
        AppMethodBeat.o(26437);
        return;
      }
      this.vHT.app("");
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
    if (pyv == null) {
      pyv = new SensorController(getApplicationContext());
    }
    initView();
    this.cXd = new com.tencent.mm.audio.a.a(this);
    this.cXd.dfZ = this;
    this.cXd.dfY = this;
    this.vHT.vHI = new c.e()
    {
      public final String apq(String paramAnonymousString)
      {
        AppMethodBeat.i(26416);
        ba.aBQ();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          t.g(MassSendHistoryUI.this, null);
          AppMethodBeat.o(26416);
          return "";
        }
        paramAnonymousString = bt.nullAsNil(paramAnonymousString);
        if ((MassSendHistoryUI.a(MassSendHistoryUI.this).isPlaying()) && (paramAnonymousString.equals(MassSendHistoryUI.b(MassSendHistoryUI.this).vHH)))
        {
          MassSendHistoryUI.dlf();
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
      this.mController.be(3, false);
    }
    AppMethodBeat.o(26429);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26435);
    ad.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((com.tencent.mm.plugin.masssend.a.a)this.vHT.getItem(paramView.position)).dkN().split(";");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramContextMenuInfo.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContextMenuInfo[i];
      ba.aBQ();
      localObject = com.tencent.mm.model.c.azp().Bf((String)localObject);
      if (localObject != null) {
        localStringBuilder.append(((am)localObject).adv() + ";");
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
    this.vHT.det();
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
      if (this.vgw) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(26434);
        return true;
        paramKeyEvent = new Intent();
        paramKeyEvent.addFlags(67108864);
        com.tencent.mm.plugin.masssend.a.iRG.p(paramKeyEvent, this);
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
    com.tencent.mm.plugin.masssend.a.h.dkT().remove(this.vHT);
    pyv.flC();
    AppMethodBeat.o(26431);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26430);
    super.onResume();
    com.tencent.mm.plugin.masssend.a.h.dkT().add(this.vHT);
    this.vHT.a(null, null);
    this.vHS.setSelection(this.vHT.getCount() - 1);
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
    this.vHS.setKeepScreenOn(false);
    AppMethodBeat.o(26436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI
 * JD-Core Version:    0.7.0.1
 */