package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class RoomCardUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private String jaK;
  private String jhR;
  private int jhS;
  private String jhT;
  private boolean jhU;
  private boolean jhV;
  private String jhW;
  private String jhX;
  private long jhY;
  private s jhZ;
  private TextView jia;
  private MMEditText jib;
  private TextView jic;
  private TextView jid;
  private ImageView jie;
  private LinearLayout jif;
  private LinearLayout jig;
  private LinearLayout jih;
  private LinearLayout jii;
  private com.tencent.mm.ui.tools.i jij;
  private k.b jik;
  private IListener jil;
  private boolean jim;
  
  public RoomCardUI()
  {
    AppMethodBeat.i(12704);
    this.jil = new RoomCardUI.5(this);
    this.jim = false;
    AppMethodBeat.o(12704);
  }
  
  private void KA(String paramString)
  {
    AppMethodBeat.i(12719);
    Log.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[] { paramString });
    paramString = com.tencent.mm.h.a.Kb(paramString);
    if (paramString != null) {
      paramString.a(this, new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(194518);
          RoomCardUI.this.finish();
          AppMethodBeat.o(194518);
        }
      });
    }
    AppMethodBeat.o(12719);
  }
  
  private boolean asS()
  {
    AppMethodBeat.i(12712);
    String str = this.jib.getText().toString();
    if (Util.isNullOrNil(str))
    {
      if (Util.isNullOrNil(this.jhW))
      {
        AppMethodBeat.o(12712);
        return false;
      }
      AppMethodBeat.o(12712);
      return true;
    }
    if ((this.jhW == null) || (!this.jhW.equals(str)))
    {
      AppMethodBeat.o(12712);
      return true;
    }
    AppMethodBeat.o(12712);
    return false;
  }
  
  private void asT()
  {
    AppMethodBeat.i(12713);
    if (asS())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(12713);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(12713);
  }
  
  private void asU()
  {
    AppMethodBeat.i(12718);
    Intent localIntent = new Intent();
    localIntent.putExtra("room_name", this.jhR);
    localIntent.putExtra("room_notice", this.jhW);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(12718);
  }
  
  private void e(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(12717);
    if ((this.jhZ != null) && (this.jhZ.isShowing())) {
      this.jhZ.dismiss();
    }
    if ((this.jhZ != null) && (this.jhZ.isShowing())) {
      this.jhZ.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
      this.jhW = this.jib.getText().toString();
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 15L, 1L, true);
      asU();
      AppMethodBeat.o(12717);
      return;
    }
    KA(paramString);
    Log.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(12717);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(12711);
    if ((!this.jhU) && (!this.jhV))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(12711);
      return;
    }
    if (asS())
    {
      new f.a(this).bBl(getString(a.i.jfK)).ayp(a.i.jfM).b(new f.c()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(187115);
          RoomCardUI.a(RoomCardUI.this, 10);
          AppMethodBeat.o(187115);
        }
      }).bBq(getString(a.i.jfL)).a(new f.c()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(192069);
          RoomCardUI.this.setResult(0);
          RoomCardUI.this.finish();
          RoomCardUI.a(RoomCardUI.this, 11);
          AppMethodBeat.o(192069);
        }
      }).show();
      AppMethodBeat.o(12711);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(12711);
  }
  
  public int getLayoutId()
  {
    return a.f.jej;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12705);
    setMMTitle(a.i.jgo);
    setNavigationbarColor(getResources().getColor(a.b.white));
    getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.b.white)));
    this.jij = new com.tencent.mm.ui.tools.i(this);
    getWindow().setSoftInputMode(48);
    this.jij.XSx = new com.tencent.mm.ui.tools.h()
    {
      public final void A(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(12691);
        if (paramAnonymousInt > 0)
        {
          localViewGroup = (ViewGroup)RoomCardUI.this.findViewById(a.e.scroll_view);
          localLayoutParams = localViewGroup.getLayoutParams();
          if (-1 == localLayoutParams.height)
          {
            localLayoutParams.width = -1;
            localLayoutParams.height = (localViewGroup.getHeight() - paramAnonymousInt);
            localViewGroup.requestLayout();
          }
          AppMethodBeat.o(12691);
          return;
        }
        ViewGroup localViewGroup = (ViewGroup)RoomCardUI.this.findViewById(a.e.scroll_view);
        ViewGroup.LayoutParams localLayoutParams = localViewGroup.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        localViewGroup.requestLayout();
        AppMethodBeat.o(12691);
      }
    };
    addTextOptionMenu(0, getString(a.i.app_edit), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12696);
        if (paramAnonymousMenuItem.getTitle().equals(RoomCardUI.this.getString(a.i.app_finish)))
        {
          RoomCardUI.this.hideVKB();
          RoomCardUI.a(RoomCardUI.this).clearFocus();
          RoomCardUI.b(RoomCardUI.this);
          RoomCardUI.a(RoomCardUI.this, 5);
          AppMethodBeat.o(12696);
          return true;
        }
        RoomCardUI.a(RoomCardUI.this).setEnabled(true);
        RoomCardUI.a(RoomCardUI.this).setFocusableInTouchMode(true);
        RoomCardUI.a(RoomCardUI.this).setFocusable(true);
        RoomCardUI.a(RoomCardUI.this).setCursorVisible(true);
        RoomCardUI.this.updateOptionMenuText(0, RoomCardUI.this.getString(a.i.app_finish));
        RoomCardUI.this.updateOptionMenuStyle(0, w.b.Wao);
        RoomCardUI.this.enableOptionMenu(false);
        RoomCardUI.a(RoomCardUI.this).requestFocus();
        RoomCardUI.a(RoomCardUI.this).setSelection(RoomCardUI.a(RoomCardUI.this).getText().toString().length());
        RoomCardUI.this.showVKB();
        RoomCardUI.a(RoomCardUI.this, 3);
        AppMethodBeat.o(12696);
        return true;
      }
    }, null, w.b.Waq);
    enableOptionMenu(true);
    this.jih = ((LinearLayout)findViewById(a.e.jcI));
    this.jii = ((LinearLayout)findViewById(a.e.jdg));
    this.jib = ((MMEditText)findViewById(a.e.jda));
    this.jic = ((TextView)findViewById(a.e.notice_publish_time));
    this.jid = ((TextView)findViewById(a.e.jdc));
    this.jif = ((LinearLayout)findViewById(a.e.jdh));
    this.jie = ((ImageView)findViewById(a.e.jdb));
    this.jig = ((LinearLayout)findViewById(a.e.jdi));
    this.jib.setText(this.jhW);
    Object localObject1 = (WindowManager)getSystemService("window");
    this.jib.setMinHeight(((WindowManager)localObject1).getDefaultDisplay().getHeight() * 2 / 3 - 100);
    com.tencent.mm.kernel.h.aHH();
    Object localObject2 = com.tencent.mm.pluginsdk.ui.span.t.ap(true, com.tencent.mm.modelappbrand.a.SF(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.jaK).field_username));
    ((Bundle)localObject2).putInt("geta8key_scene", 31);
    l.a(this.jib, localObject2, l.Rsm);
    this.jia = ((TextView)findViewById(a.e.jcQ));
    this.jia.setText(Integer.toString(g.dq(280, this.jhW)));
    this.jig.setVisibility(8);
    this.jib.setCursorVisible(false);
    this.jib.setFocusable(false);
    if ((!this.jhU) && (!this.jhV))
    {
      removeOptionMenu(0);
      this.jii.setVisibility(0);
      this.jib.setFocusable(false);
      this.jib.setCursorVisible(false);
      this.jib.setOnLongClickListener(new RoomCardUI.8(this));
      if (this.jhY == 0L) {
        break label708;
      }
      this.jic.setVisibility(0);
      this.jic.setText(f.formatTime("yyyy-MM-dd HH:mm", this.jhY));
      label484:
      if (!Util.isNullOrNil(this.jhW)) {
        break label720;
      }
      this.jib.setEnabled(true);
      this.jib.setFocusableInTouchMode(true);
      this.jib.setFocusable(true);
      this.jih.setVisibility(8);
      this.jib.setMinHeight(((WindowManager)localObject1).getDefaultDisplay().getHeight() * 2 / 3 + 100);
      this.jib.requestFocus();
      this.jib.setCursorVisible(true);
      updateOptionMenuText(0, getContext().getString(a.i.app_finish));
      updateOptionMenuStyle(0, w.b.Wao);
      asT();
      this.jib.performClick();
      showVKB();
      label605:
      localObject1 = aa.PJ(this.jhX);
      this.jid.setText(l.b(this, (CharSequence)localObject1, this.jid.getTextSize()));
      localObject1 = this.jie;
      localObject2 = this.jhX;
      if (!Util.isNullOrNil((String)localObject2)) {
        break label731;
      }
      ((ImageView)localObject1).setImageResource(a.d.default_avatar);
    }
    for (;;)
    {
      this.jib.addTextChangedListener(new a((byte)0));
      com.tencent.e.h.ZvG.bg(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188378);
          RoomCardUI.a(RoomCardUI.this, 4);
          RoomCardUI.b(RoomCardUI.this, RoomCardUI.this.getIntent().getIntExtra("from_scene", 0));
          RoomCardUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186692);
              v.PA(RoomCardUI.c(RoomCardUI.this));
              AppMethodBeat.o(186692);
            }
          });
          AppMethodBeat.o(188378);
        }
      });
      AppMethodBeat.o(12705);
      return;
      this.jii.setVisibility(8);
      break;
      label708:
      this.jic.setVisibility(8);
      break label484;
      label720:
      this.jih.setVisibility(0);
      break label605;
      label731:
      com.tencent.mm.pluginsdk.ui.a.b.c((ImageView)localObject1, (String)localObject2);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(12715);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(12715);
      return;
    }
    AppMethodBeat.o(12715);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12706);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 0L, 1L, true);
    com.tencent.mm.kernel.h.aHF().kcd.a(993, this);
    this.jaK = getIntent().getStringExtra("RoomInfo_Id");
    this.jhW = getIntent().getStringExtra("room_notice");
    this.jhX = getIntent().getStringExtra("room_notice_editor");
    this.jhY = getIntent().getLongExtra("room_notice_publish_time", 0L);
    this.jhR = getIntent().getStringExtra("room_name");
    this.jhS = getIntent().getIntExtra("room_member_count", 0);
    this.jhT = getIntent().getStringExtra("room_owner_name");
    this.jhU = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.jhV = getIntent().getBooleanExtra("Is_RoomManager", false);
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(187266);
        RoomCardUI.d(RoomCardUI.this);
        AppMethodBeat.o(187266);
        return true;
      }
    });
    AppMethodBeat.o(12706);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12710);
    super.onDestroy();
    com.tencent.mm.kernel.h.aHF().kcd.b(993, this);
    if ((this.jhZ != null) && (this.jhZ.isShowing())) {
      this.jhZ.dismiss();
    }
    AppMethodBeat.o(12710);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(12714);
    super.onKeyDown(paramInt, paramKeyEvent);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      goBack();
      AppMethodBeat.o(12714);
      return true;
    }
    AppMethodBeat.o(12714);
    return false;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12709);
    super.onPause();
    this.jij.close();
    AppMethodBeat.o(12709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12707);
    super.onResume();
    this.jij.start();
    AppMethodBeat.o(12707);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(12716);
    if (paramq.getType() == 993)
    {
      e(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(12716);
      return;
    }
    Log.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramq.getType()) });
    AppMethodBeat.o(12716);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(12708);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jij.start();
    }
    AppMethodBeat.o(12708);
  }
  
  final class a
    implements TextWatcher
  {
    private int jiq = 280;
    private String jir = "";
    private boolean jis = false;
    
    private a() {}
    
    public final void afterTextChanged(Editable paramEditable) {}
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(12703);
      RoomCardUI.e(RoomCardUI.this);
      AppMethodBeat.o(12703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI
 * JD-Core Version:    0.7.0.1
 */