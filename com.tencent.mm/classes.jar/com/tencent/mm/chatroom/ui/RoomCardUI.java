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
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;

public class RoomCardUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private String fRo;
  private String fSH;
  private int fSI;
  private String fSJ;
  private boolean fSK;
  private boolean fSL;
  private String fSM;
  private String fSN;
  private long fSO;
  private p fSP;
  private TextView fSQ;
  private MMEditText fSR;
  private TextView fSS;
  private TextView fST;
  private ImageView fSU;
  private LinearLayout fSV;
  private LinearLayout fSW;
  private LinearLayout fSX;
  private LinearLayout fSY;
  private com.tencent.mm.ui.tools.h fSZ;
  private k.b fTa;
  private c fTb;
  private boolean fTc;
  
  public RoomCardUI()
  {
    AppMethodBeat.i(12704);
    this.fTb = new c() {};
    this.fTc = false;
    AppMethodBeat.o(12704);
  }
  
  private boolean Ze()
  {
    AppMethodBeat.i(12712);
    String str = this.fSR.getText().toString();
    if (bu.isNullOrNil(str))
    {
      if (bu.isNullOrNil(this.fSM))
      {
        AppMethodBeat.o(12712);
        return false;
      }
      AppMethodBeat.o(12712);
      return true;
    }
    if ((this.fSM == null) || (!this.fSM.equals(str)))
    {
      AppMethodBeat.o(12712);
      return true;
    }
    AppMethodBeat.o(12712);
    return false;
  }
  
  private void Zf()
  {
    AppMethodBeat.i(12713);
    if (Ze())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(12713);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(12713);
  }
  
  private void Zg()
  {
    AppMethodBeat.i(12718);
    Intent localIntent = new Intent();
    localIntent.putExtra("room_name", this.fSH);
    localIntent.putExtra("room_notice", this.fSM);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(12718);
  }
  
  private void e(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(12717);
    if ((this.fSP != null) && (this.fSP.isShowing())) {
      this.fSP.dismiss();
    }
    if ((this.fSP != null) && (this.fSP.isShowing())) {
      this.fSP.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
      this.fSM = this.fSR.getText().toString();
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 15L, 1L, true);
      Zg();
      AppMethodBeat.o(12717);
      return;
    }
    vs(paramString);
    ae.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(12717);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(12711);
    if ((!this.fSK) && (!this.fSL))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(12711);
      return;
    }
    if (Ze())
    {
      com.tencent.mm.ui.base.h.e(this, getString(2131762578), null, getString(2131762580), getString(2131762579), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  private void vs(String paramString)
  {
    AppMethodBeat.i(12719);
    ae.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[] { paramString });
    paramString = com.tencent.mm.h.a.uU(paramString);
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
    this.fSZ = new com.tencent.mm.ui.tools.h(this);
    getWindow().setSoftInputMode(48);
    this.fSZ.Lfj = new com.tencent.mm.ui.tools.g()
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
    }, null, s.b.JwA);
    enableOptionMenu(true);
    this.fSX = ((LinearLayout)findViewById(2131300723));
    this.fSY = ((LinearLayout)findViewById(2131304220));
    this.fSR = ((MMEditText)findViewById(2131302952));
    this.fSS = ((TextView)findViewById(2131302955));
    this.fST = ((TextView)findViewById(2131302954));
    this.fSV = ((LinearLayout)findViewById(2131304223));
    this.fSU = ((ImageView)findViewById(2131302953));
    this.fSW = ((LinearLayout)findViewById(2131304230));
    this.fSR.setText(this.fSM);
    Object localObject = (WindowManager)getSystemService("window");
    this.fSR.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 - 100);
    k.b(this.fSR, Integer.valueOf(31));
    this.fSQ = ((TextView)findViewById(2131301394));
    this.fSQ.setText(Integer.toString(com.tencent.mm.ui.tools.f.cU(280, this.fSM)));
    this.fSW.setVisibility(8);
    this.fSR.setCursorVisible(false);
    this.fSR.setFocusable(false);
    label424:
    String str;
    if ((!this.fSK) && (!this.fSL))
    {
      removeOptionMenu(0);
      this.fSY.setVisibility(0);
      this.fSR.setFocusable(false);
      this.fSR.setCursorVisible(false);
      this.fSR.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12697);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          RoomCardUI.a(RoomCardUI.this, RoomCardUI.b(RoomCardUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(12697);
          return true;
        }
      });
      if (this.fSO == 0L) {
        break label623;
      }
      this.fSS.setVisibility(0);
      this.fSS.setText(com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm", this.fSO));
      if (!bu.isNullOrNil(this.fSM)) {
        break label635;
      }
      this.fSR.setEnabled(true);
      this.fSR.setFocusableInTouchMode(true);
      this.fSR.setFocusable(true);
      this.fSX.setVisibility(8);
      this.fSR.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 + 100);
      this.fSR.requestFocus();
      this.fSR.setCursorVisible(true);
      updateOptionMenuText(0, getContext().getString(2131755779));
      Zf();
      this.fSR.performClick();
      showVKB();
      label537:
      localObject = w.zP(this.fSN);
      this.fST.setText(k.b(this, (CharSequence)localObject, this.fST.getTextSize()));
      localObject = this.fSU;
      str = this.fSN;
      if (!bu.isNullOrNil(str)) {
        break label646;
      }
      ((ImageView)localObject).setImageResource(2131231875);
    }
    for (;;)
    {
      this.fSR.addTextChangedListener(new a((byte)0));
      AppMethodBeat.o(12705);
      return;
      this.fSY.setVisibility(8);
      break;
      label623:
      this.fSS.setVisibility(8);
      break label424;
      label635:
      this.fSX.setVisibility(0);
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
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 0L, 1L, true);
    com.tencent.mm.kernel.g.ajQ().gDv.a(993, this);
    this.fRo = getIntent().getStringExtra("RoomInfo_Id");
    this.fSM = getIntent().getStringExtra("room_notice");
    this.fSN = getIntent().getStringExtra("room_notice_editor");
    this.fSO = getIntent().getLongExtra("room_notice_publish_time", 0L);
    this.fSH = getIntent().getStringExtra("room_name");
    this.fSI = getIntent().getIntExtra("room_member_count", 0);
    this.fSJ = getIntent().getStringExtra("room_owner_name");
    this.fSK = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fSL = getIntent().getBooleanExtra("Is_RoomManager", false);
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
    com.tencent.mm.kernel.g.ajQ().gDv.b(993, this);
    if ((this.fSP != null) && (this.fSP.isShowing())) {
      this.fSP.dismiss();
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
    this.fSZ.close();
    AppMethodBeat.o(12709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12707);
    super.onResume();
    this.fSZ.start();
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
    ae.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramn.getType()) });
    AppMethodBeat.o(12716);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(12708);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.fSZ.start();
    }
    AppMethodBeat.o(12708);
  }
  
  final class a
    implements TextWatcher
  {
    private int fTf = 280;
    private String fTg = "";
    private boolean fTh = false;
    
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