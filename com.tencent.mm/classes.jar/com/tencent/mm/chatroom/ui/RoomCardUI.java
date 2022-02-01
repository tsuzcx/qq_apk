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
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rn;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.d.ac;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.x;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.ui.y.b;

public class RoomCardUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private k.b lKA;
  private IListener lKB;
  private boolean lKC;
  private String lKh;
  private int lKi;
  private String lKj;
  private boolean lKk;
  private boolean lKl;
  private String lKm;
  private String lKn;
  private long lKo;
  private w lKp;
  private TextView lKq;
  private MMEditText lKr;
  private TextView lKs;
  private TextView lKt;
  private ImageView lKu;
  private LinearLayout lKv;
  private LinearLayout lKw;
  private LinearLayout lKx;
  private LinearLayout lKy;
  private com.tencent.mm.ui.tools.i lKz;
  private String lyn;
  
  public RoomCardUI()
  {
    AppMethodBeat.i(12704);
    this.lKB = new IListener(com.tencent.mm.app.f.hfK) {};
    this.lKC = false;
    AppMethodBeat.o(12704);
  }
  
  private void Dg(String paramString)
  {
    AppMethodBeat.i(12719);
    Log.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[] { paramString });
    paramString = com.tencent.mm.broadcast.a.CH(paramString);
    if (paramString != null) {
      paramString.a(this, new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(241475);
          RoomCardUI.this.finish();
          AppMethodBeat.o(241475);
        }
      });
    }
    AppMethodBeat.o(12719);
  }
  
  private boolean aMT()
  {
    AppMethodBeat.i(12712);
    String str = this.lKr.getText().toString();
    if (Util.isNullOrNil(str))
    {
      if (Util.isNullOrNil(this.lKm))
      {
        AppMethodBeat.o(12712);
        return false;
      }
      AppMethodBeat.o(12712);
      return true;
    }
    if ((this.lKm == null) || (!this.lKm.equals(str)))
    {
      AppMethodBeat.o(12712);
      return true;
    }
    AppMethodBeat.o(12712);
    return false;
  }
  
  private void aMU()
  {
    AppMethodBeat.i(12713);
    if (aMT())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(12713);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(12713);
  }
  
  private void aMV()
  {
    AppMethodBeat.i(12718);
    Intent localIntent = new Intent();
    localIntent.putExtra("room_name", this.lKh);
    localIntent.putExtra("room_notice", this.lKm);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(12718);
  }
  
  private void f(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(12717);
    if ((this.lKp != null) && (this.lKp.isShowing())) {
      this.lKp.dismiss();
    }
    if ((this.lKp != null) && (this.lKp.isShowing())) {
      this.lKp.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
      this.lKm = this.lKr.getText().toString();
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 15L, 1L, true);
      aMV();
      AppMethodBeat.o(12717);
      return;
    }
    Dg(paramString);
    Log.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(12717);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(12711);
    if ((!this.lKk) && (!this.lKl))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(12711);
      return;
    }
    if (aMT())
    {
      new g.a(this).bDE(getString(a.i.lHW)).aEX(a.i.lHY).b(new g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(241809);
          RoomCardUI.a(RoomCardUI.this, 10);
          AppMethodBeat.o(241809);
        }
      }).bDJ(getString(a.i.lHX)).a(new g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(241813);
          RoomCardUI.this.setResult(0);
          RoomCardUI.this.finish();
          RoomCardUI.a(RoomCardUI.this, 11);
          AppMethodBeat.o(241813);
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
    return a.f.lGt;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12705);
    setMMTitle(a.i.lIB);
    setNavigationbarColor(getResources().getColor(a.b.white));
    getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.b.white)));
    this.lKz = new com.tencent.mm.ui.tools.i(this);
    getWindow().setSoftInputMode(48);
    this.lKz.afIL = new com.tencent.mm.ui.tools.h()
    {
      public final void onKeyboardHeightChanged(int paramAnonymousInt, boolean paramAnonymousBoolean)
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
        RoomCardUI.this.updateOptionMenuStyle(0, y.b.adEJ);
        RoomCardUI.this.enableOptionMenu(false);
        RoomCardUI.a(RoomCardUI.this).requestFocus();
        RoomCardUI.a(RoomCardUI.this).setSelection(RoomCardUI.a(RoomCardUI.this).getText().toString().length());
        RoomCardUI.this.showVKB();
        RoomCardUI.a(RoomCardUI.this, 3);
        AppMethodBeat.o(12696);
        return true;
      }
    }, null, y.b.adEL);
    enableOptionMenu(true);
    this.lKx = ((LinearLayout)findViewById(a.e.lEO));
    this.lKy = ((LinearLayout)findViewById(a.e.lFo));
    this.lKr = ((MMEditText)findViewById(a.e.lFi));
    this.lKs = ((TextView)findViewById(a.e.notice_publish_time));
    this.lKt = ((TextView)findViewById(a.e.lFk));
    this.lKv = ((LinearLayout)findViewById(a.e.lFp));
    this.lKu = ((ImageView)findViewById(a.e.lFj));
    this.lKw = ((LinearLayout)findViewById(a.e.lFq));
    this.lKr.setText(this.lKm);
    Object localObject1 = (WindowManager)getSystemService("window");
    this.lKr.setMinHeight(((WindowManager)localObject1).getDefaultDisplay().getHeight() * 2 / 3 - 100);
    com.tencent.mm.kernel.h.baF();
    Object localObject2 = x.aq(true, com.tencent.mm.modelappbrand.a.KG(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.lyn).field_username));
    ((Bundle)localObject2).putInt("geta8key_scene", 31);
    com.tencent.mm.pluginsdk.ui.span.p.a(this.lKr, localObject2, com.tencent.mm.pluginsdk.ui.span.p.YoF);
    this.lKq = ((TextView)findViewById(a.e.lEW));
    this.lKq.setText(Integer.toString(g.ej(280, this.lKm)));
    this.lKw.setVisibility(8);
    this.lKr.setCursorVisible(false);
    this.lKr.setFocusable(false);
    if ((!this.lKk) && (!this.lKl))
    {
      removeOptionMenu(0);
      this.lKy.setVisibility(0);
      this.lKr.setFocusable(false);
      this.lKr.setCursorVisible(false);
      this.lKr.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12697);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          RoomCardUI.a(RoomCardUI.this, RoomCardUI.a(RoomCardUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(12697);
          return true;
        }
      });
      if (this.lKo == 0L) {
        break label708;
      }
      this.lKs.setVisibility(0);
      this.lKs.setText(com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm", this.lKo));
      label484:
      if (!Util.isNullOrNil(this.lKm)) {
        break label720;
      }
      this.lKr.setEnabled(true);
      this.lKr.setFocusableInTouchMode(true);
      this.lKr.setFocusable(true);
      this.lKx.setVisibility(8);
      this.lKr.setMinHeight(((WindowManager)localObject1).getDefaultDisplay().getHeight() * 2 / 3 + 100);
      this.lKr.requestFocus();
      this.lKr.setCursorVisible(true);
      updateOptionMenuText(0, getContext().getString(a.i.app_finish));
      updateOptionMenuStyle(0, y.b.adEJ);
      aMU();
      this.lKr.performClick();
      showVKB();
      label605:
      localObject1 = aa.getDisplayName(this.lKn);
      this.lKt.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject1, this.lKt.getTextSize()));
      localObject1 = this.lKu;
      localObject2 = this.lKn;
      if (!Util.isNullOrNil((String)localObject2)) {
        break label731;
      }
      ((ImageView)localObject1).setImageResource(a.d.default_avatar);
    }
    for (;;)
    {
      this.lKr.addTextChangedListener(new a((byte)0));
      com.tencent.threadpool.h.ahAA.bo(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(241481);
          RoomCardUI.a(RoomCardUI.this, 4);
          RoomCardUI.b(RoomCardUI.this, RoomCardUI.this.getIntent().getIntExtra("from_scene", 0));
          RoomCardUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(241776);
              v.It(RoomCardUI.c(RoomCardUI.this));
              AppMethodBeat.o(241776);
            }
          });
          AppMethodBeat.o(241481);
        }
      });
      AppMethodBeat.o(12705);
      return;
      this.lKy.setVisibility(8);
      break;
      label708:
      this.lKs.setVisibility(8);
      break label484;
      label720:
      this.lKx.setVisibility(0);
      break label605;
      label731:
      com.tencent.mm.pluginsdk.ui.a.b.g((ImageView)localObject1, (String)localObject2);
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
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 0L, 1L, true);
    com.tencent.mm.kernel.h.baD().mCm.a(993, this);
    this.lyn = getIntent().getStringExtra("RoomInfo_Id");
    this.lKm = getIntent().getStringExtra("room_notice");
    this.lKn = getIntent().getStringExtra("room_notice_editor");
    this.lKo = getIntent().getLongExtra("room_notice_publish_time", 0L);
    this.lKh = getIntent().getStringExtra("room_name");
    this.lKi = getIntent().getIntExtra("room_member_count", 0);
    this.lKj = getIntent().getStringExtra("room_owner_name");
    this.lKk = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.lKl = getIntent().getBooleanExtra("Is_RoomManager", false);
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(241817);
        RoomCardUI.d(RoomCardUI.this);
        AppMethodBeat.o(241817);
        return true;
      }
    });
    AppMethodBeat.o(12706);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12710);
    super.onDestroy();
    com.tencent.mm.kernel.h.baD().mCm.b(993, this);
    if ((this.lKp != null) && (this.lKp.isShowing())) {
      this.lKp.dismiss();
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
    this.lKz.close();
    AppMethodBeat.o(12709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12707);
    super.onResume();
    this.lKz.start();
    AppMethodBeat.o(12707);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(12716);
    if (paramp.getType() == 993)
    {
      f(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(12716);
      return;
    }
    Log.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramp.getType()) });
    AppMethodBeat.o(12716);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(12708);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.lKz.start();
    }
    AppMethodBeat.o(12708);
  }
  
  final class a
    implements TextWatcher
  {
    private int lKG = 280;
    private String lKH = "";
    private boolean lKI = false;
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI
 * JD-Core Version:    0.7.0.1
 */