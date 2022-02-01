package com.tencent.mm.chatroom.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class RoomCardUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String fss;
  private String ftH;
  private int ftI;
  private String ftJ;
  private boolean ftK;
  private boolean ftL;
  private String ftM;
  private String ftN;
  private long ftO;
  private p ftP;
  private TextView ftQ;
  private MMEditText ftR;
  private TextView ftS;
  private TextView ftT;
  private ImageView ftU;
  private LinearLayout ftV;
  private LinearLayout ftW;
  private LinearLayout ftX;
  private LinearLayout ftY;
  private com.tencent.mm.ui.tools.h ftZ;
  private j.b fua;
  private c fub;
  private boolean fuc;
  
  public RoomCardUI()
  {
    AppMethodBeat.i(12704);
    this.fub = new c() {};
    this.fuc = false;
    AppMethodBeat.o(12704);
  }
  
  private boolean VD()
  {
    AppMethodBeat.i(12712);
    String str = this.ftR.getText().toString();
    if (bt.isNullOrNil(str))
    {
      if (bt.isNullOrNil(this.ftM))
      {
        AppMethodBeat.o(12712);
        return false;
      }
      AppMethodBeat.o(12712);
      return true;
    }
    if ((this.ftM == null) || (!this.ftM.equals(str)))
    {
      AppMethodBeat.o(12712);
      return true;
    }
    AppMethodBeat.o(12712);
    return false;
  }
  
  private void VE()
  {
    AppMethodBeat.i(12713);
    if (VD())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(12713);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(12713);
  }
  
  private void VF()
  {
    AppMethodBeat.i(12718);
    Intent localIntent = new Intent();
    localIntent.putExtra("room_name", this.ftH);
    localIntent.putExtra("room_notice", this.ftM);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(12718);
  }
  
  private void e(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(12717);
    if ((this.ftP != null) && (this.ftP.isShowing())) {
      this.ftP.dismiss();
    }
    if ((this.ftP != null) && (this.ftP.isShowing())) {
      this.ftP.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
      this.ftM = this.ftR.getText().toString();
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 15L, 1L, true);
      VF();
      AppMethodBeat.o(12717);
      return;
    }
    oV(paramString);
    ad.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(12717);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(12711);
    if ((!this.ftK) && (!this.ftL))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(12711);
      return;
    }
    if (VD())
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
  
  private void oV(String paramString)
  {
    AppMethodBeat.i(12719);
    ad.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[] { paramString });
    paramString = com.tencent.mm.h.a.oG(paramString);
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
    this.ftZ = new com.tencent.mm.ui.tools.h(this);
    getWindow().setSoftInputMode(48);
    this.ftZ.Hro = new com.tencent.mm.ui.tools.g()
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
    }, null, r.b.FOB);
    enableOptionMenu(true);
    this.ftX = ((LinearLayout)findViewById(2131300723));
    this.ftY = ((LinearLayout)findViewById(2131304220));
    this.ftR = ((MMEditText)findViewById(2131302952));
    this.ftS = ((TextView)findViewById(2131302955));
    this.ftT = ((TextView)findViewById(2131302954));
    this.ftV = ((LinearLayout)findViewById(2131304223));
    this.ftU = ((ImageView)findViewById(2131302953));
    this.ftW = ((LinearLayout)findViewById(2131304230));
    this.ftR.setText(this.ftM);
    Object localObject = (WindowManager)getSystemService("window");
    this.ftR.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 - 100);
    k.b(this.ftR, Integer.valueOf(31));
    this.ftQ = ((TextView)findViewById(2131301394));
    this.ftQ.setText(Integer.toString(f.cJ(280, this.ftM)));
    this.ftW.setVisibility(8);
    this.ftR.setCursorVisible(false);
    this.ftR.setFocusable(false);
    label424:
    String str;
    if ((!this.ftK) && (!this.ftL))
    {
      removeOptionMenu(0);
      this.ftY.setVisibility(0);
      this.ftR.setFocusable(false);
      this.ftR.setCursorVisible(false);
      this.ftR.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12697);
          RoomCardUI.a(RoomCardUI.this, RoomCardUI.b(RoomCardUI.this));
          AppMethodBeat.o(12697);
          return true;
        }
      });
      if (this.ftO == 0L) {
        break label623;
      }
      this.ftS.setVisibility(0);
      this.ftS.setText(com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm", this.ftO));
      if (!bt.isNullOrNil(this.ftM)) {
        break label635;
      }
      this.ftR.setEnabled(true);
      this.ftR.setFocusableInTouchMode(true);
      this.ftR.setFocusable(true);
      this.ftX.setVisibility(8);
      this.ftR.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 + 100);
      this.ftR.requestFocus();
      this.ftR.setCursorVisible(true);
      updateOptionMenuText(0, getContext().getString(2131755779));
      VE();
      this.ftR.performClick();
      showVKB();
      label537:
      localObject = v.sh(this.ftN);
      this.ftT.setText(k.b(this, (CharSequence)localObject, this.ftT.getTextSize()));
      localObject = this.ftU;
      str = this.ftN;
      if (!bt.isNullOrNil(str)) {
        break label646;
      }
      ((ImageView)localObject).setImageResource(2131231875);
    }
    for (;;)
    {
      this.ftR.addTextChangedListener(new a((byte)0));
      AppMethodBeat.o(12705);
      return;
      this.ftY.setVisibility(8);
      break;
      label623:
      this.ftS.setVisibility(8);
      break label424;
      label635:
      this.ftX.setVisibility(0);
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
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 0L, 1L, true);
    com.tencent.mm.kernel.g.afA().gcy.a(993, this);
    this.fss = getIntent().getStringExtra("RoomInfo_Id");
    this.ftM = getIntent().getStringExtra("room_notice");
    this.ftN = getIntent().getStringExtra("room_notice_editor");
    this.ftO = getIntent().getLongExtra("room_notice_publish_time", 0L);
    this.ftH = getIntent().getStringExtra("room_name");
    this.ftI = getIntent().getIntExtra("room_member_count", 0);
    this.ftJ = getIntent().getStringExtra("room_owner_name");
    this.ftK = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.ftL = getIntent().getBooleanExtra("Is_RoomManager", false);
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
    com.tencent.mm.kernel.g.afA().gcy.b(993, this);
    if ((this.ftP != null) && (this.ftP.isShowing())) {
      this.ftP.dismiss();
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
    this.ftZ.close();
    AppMethodBeat.o(12709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12707);
    super.onResume();
    this.ftZ.start();
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
    ad.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramn.getType()) });
    AppMethodBeat.o(12716);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(12708);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.ftZ.start();
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(12708);
  }
  
  final class a
    implements TextWatcher
  {
    private int fuf = 280;
    private String fug = "";
    private boolean fuh = false;
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI
 * JD-Core Version:    0.7.0.1
 */