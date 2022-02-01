package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class RoomCardUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String fvZ;
  private TextView fxA;
  private ImageView fxB;
  private LinearLayout fxC;
  private LinearLayout fxD;
  private LinearLayout fxE;
  private LinearLayout fxF;
  private com.tencent.mm.ui.tools.h fxG;
  private j.b fxH;
  private c fxI;
  private boolean fxJ;
  private String fxo;
  private int fxp;
  private String fxq;
  private boolean fxr;
  private boolean fxs;
  private String fxt;
  private String fxu;
  private long fxv;
  private p fxw;
  private TextView fxx;
  private MMEditText fxy;
  private TextView fxz;
  
  public RoomCardUI()
  {
    AppMethodBeat.i(12704);
    this.fxI = new c() {};
    this.fxJ = false;
    AppMethodBeat.o(12704);
  }
  
  private boolean WB()
  {
    AppMethodBeat.i(12712);
    String str = this.fxy.getText().toString();
    if (bs.isNullOrNil(str))
    {
      if (bs.isNullOrNil(this.fxt))
      {
        AppMethodBeat.o(12712);
        return false;
      }
      AppMethodBeat.o(12712);
      return true;
    }
    if ((this.fxt == null) || (!this.fxt.equals(str)))
    {
      AppMethodBeat.o(12712);
      return true;
    }
    AppMethodBeat.o(12712);
    return false;
  }
  
  private void WC()
  {
    AppMethodBeat.i(12713);
    if (WB())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(12713);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(12713);
  }
  
  private void WD()
  {
    AppMethodBeat.i(12718);
    Intent localIntent = new Intent();
    localIntent.putExtra("room_name", this.fxo);
    localIntent.putExtra("room_notice", this.fxt);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(12718);
  }
  
  private void e(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(12717);
    if ((this.fxw != null) && (this.fxw.isShowing())) {
      this.fxw.dismiss();
    }
    if ((this.fxw != null) && (this.fxw.isShowing())) {
      this.fxw.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
      this.fxt = this.fxy.getText().toString();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 15L, 1L, true);
      WD();
      AppMethodBeat.o(12717);
      return;
    }
    sh(paramString);
    ac.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(12717);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(12711);
    if ((!this.fxr) && (!this.fxs))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(12711);
      return;
    }
    if (WB())
    {
      com.tencent.mm.ui.base.h.d(this, getString(2131762578), null, getString(2131762580), getString(2131762579), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(12701);
          RoomCardUI.this.setResult(0);
          RoomCardUI.this.finish();
          AppMethodBeat.o(12701);
        }
      });
      AppMethodBeat.o(12711);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(12711);
  }
  
  private void sh(String paramString)
  {
    AppMethodBeat.i(12719);
    ac.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[] { paramString });
    paramString = com.tencent.mm.h.a.rM(paramString);
    if (paramString != null) {
      paramString.a(this, new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(12695);
          RoomCardUI.this.finish();
          AppMethodBeat.o(12695);
        }
      });
    }
    AppMethodBeat.o(12719);
  }
  
  public int getLayoutId()
  {
    return 2131495272;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12705);
    setMMTitle(2131762661);
    getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101179)));
    this.fxG = new com.tencent.mm.ui.tools.h(this);
    getWindow().setSoftInputMode(48);
    this.fxG.IRL = new com.tencent.mm.ui.tools.g()
    {
      public final void u(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(12691);
        if (paramAnonymousInt > 0)
        {
          localViewGroup = (ViewGroup)RoomCardUI.this.findViewById(2131304376);
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
        ViewGroup localViewGroup = (ViewGroup)RoomCardUI.this.findViewById(2131304376);
        ViewGroup.LayoutParams localLayoutParams = localViewGroup.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        localViewGroup.requestLayout();
        AppMethodBeat.o(12691);
      }
    };
    addTextOptionMenu(0, getString(2131755721), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12696);
        if (paramAnonymousMenuItem.getTitle().equals(RoomCardUI.this.getString(2131755779))) {
          RoomCardUI.a(RoomCardUI.this);
        }
        RoomCardUI.b(RoomCardUI.this).setEnabled(true);
        RoomCardUI.b(RoomCardUI.this).setFocusableInTouchMode(true);
        RoomCardUI.b(RoomCardUI.this).setFocusable(true);
        RoomCardUI.b(RoomCardUI.this).setCursorVisible(true);
        RoomCardUI.this.updateOptionMenuText(0, RoomCardUI.this.getString(2131755779));
        RoomCardUI.this.enableOptionMenu(false);
        RoomCardUI.this.showVKB();
        RoomCardUI.b(RoomCardUI.this).setSelection(RoomCardUI.b(RoomCardUI.this).getText().toString().length());
        AppMethodBeat.o(12696);
        return true;
      }
    }, null, s.b.Hom);
    enableOptionMenu(true);
    this.fxE = ((LinearLayout)findViewById(2131300723));
    this.fxF = ((LinearLayout)findViewById(2131304220));
    this.fxy = ((MMEditText)findViewById(2131302952));
    this.fxz = ((TextView)findViewById(2131302955));
    this.fxA = ((TextView)findViewById(2131302954));
    this.fxC = ((LinearLayout)findViewById(2131304223));
    this.fxB = ((ImageView)findViewById(2131302953));
    this.fxD = ((LinearLayout)findViewById(2131304230));
    this.fxy.setText(this.fxt);
    Object localObject = (WindowManager)getSystemService("window");
    this.fxy.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 - 100);
    com.tencent.mm.pluginsdk.ui.span.k.b(this.fxy, Integer.valueOf(31));
    this.fxx = ((TextView)findViewById(2131301394));
    this.fxx.setText(Integer.toString(f.cM(280, this.fxt)));
    this.fxD.setVisibility(8);
    this.fxy.setCursorVisible(false);
    this.fxy.setFocusable(false);
    label424:
    String str;
    if ((!this.fxr) && (!this.fxs))
    {
      removeOptionMenu(0);
      this.fxF.setVisibility(0);
      this.fxy.setFocusable(false);
      this.fxy.setCursorVisible(false);
      this.fxy.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12697);
          RoomCardUI.a(RoomCardUI.this, RoomCardUI.b(RoomCardUI.this));
          AppMethodBeat.o(12697);
          return true;
        }
      });
      if (this.fxv == 0L) {
        break label623;
      }
      this.fxz.setVisibility(0);
      this.fxz.setText(com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm", this.fxv));
      if (!bs.isNullOrNil(this.fxt)) {
        break label635;
      }
      this.fxy.setEnabled(true);
      this.fxy.setFocusableInTouchMode(true);
      this.fxy.setFocusable(true);
      this.fxE.setVisibility(8);
      this.fxy.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 + 100);
      this.fxy.requestFocus();
      this.fxy.setCursorVisible(true);
      updateOptionMenuText(0, getContext().getString(2131755779));
      WC();
      this.fxy.performClick();
      showVKB();
      label537:
      localObject = v.wk(this.fxu);
      this.fxA.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject, this.fxA.getTextSize()));
      localObject = this.fxB;
      str = this.fxu;
      if (!bs.isNullOrNil(str)) {
        break label646;
      }
      ((ImageView)localObject).setImageResource(2131231875);
    }
    for (;;)
    {
      this.fxy.addTextChangedListener(new a((byte)0));
      AppMethodBeat.o(12705);
      return;
      this.fxF.setVisibility(8);
      break;
      label623:
      this.fxz.setVisibility(8);
      break label424;
      label635:
      this.fxE.setVisibility(0);
      break label537;
      label646:
      a.b.c((ImageView)localObject, str);
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
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 0L, 1L, true);
    com.tencent.mm.kernel.g.agQ().ghe.a(993, this);
    this.fvZ = getIntent().getStringExtra("RoomInfo_Id");
    this.fxt = getIntent().getStringExtra("room_notice");
    this.fxu = getIntent().getStringExtra("room_notice_editor");
    this.fxv = getIntent().getLongExtra("room_notice_publish_time", 0L);
    this.fxo = getIntent().getStringExtra("room_name");
    this.fxp = getIntent().getIntExtra("room_member_count", 0);
    this.fxq = getIntent().getStringExtra("room_owner_name");
    this.fxr = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fxs = getIntent().getBooleanExtra("Is_RoomManager", false);
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12700);
        RoomCardUI.c(RoomCardUI.this);
        AppMethodBeat.o(12700);
        return true;
      }
    });
    AppMethodBeat.o(12706);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12710);
    super.onDestroy();
    com.tencent.mm.kernel.g.agQ().ghe.b(993, this);
    if ((this.fxw != null) && (this.fxw.isShowing())) {
      this.fxw.dismiss();
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
    this.fxG.close();
    AppMethodBeat.o(12709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12707);
    super.onResume();
    this.fxG.start();
    AppMethodBeat.o(12707);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12716);
    if (paramn.getType() == 993)
    {
      e(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(12716);
      return;
    }
    ac.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramn.getType()) });
    AppMethodBeat.o(12716);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(12708);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.fxG.start();
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(12708);
  }
  
  final class a
    implements TextWatcher
  {
    private int fxM = 280;
    private String fxN = "";
    private boolean fxO = false;
    
    private a() {}
    
    public final void afterTextChanged(Editable paramEditable) {}
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(12703);
      RoomCardUI.d(RoomCardUI.this);
      AppMethodBeat.o(12703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI
 * JD-Core Version:    0.7.0.1
 */