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
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;

public class RoomCardUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private String fPi;
  private String fQB;
  private int fQC;
  private String fQD;
  private boolean fQE;
  private boolean fQF;
  private String fQG;
  private String fQH;
  private long fQI;
  private p fQJ;
  private TextView fQK;
  private MMEditText fQL;
  private TextView fQM;
  private TextView fQN;
  private ImageView fQO;
  private LinearLayout fQP;
  private LinearLayout fQQ;
  private LinearLayout fQR;
  private LinearLayout fQS;
  private com.tencent.mm.ui.tools.h fQT;
  private k.b fQU;
  private c fQV;
  private boolean fQW;
  
  public RoomCardUI()
  {
    AppMethodBeat.i(12704);
    this.fQV = new c() {};
    this.fQW = false;
    AppMethodBeat.o(12704);
  }
  
  private boolean YV()
  {
    AppMethodBeat.i(12712);
    String str = this.fQL.getText().toString();
    if (bt.isNullOrNil(str))
    {
      if (bt.isNullOrNil(this.fQG))
      {
        AppMethodBeat.o(12712);
        return false;
      }
      AppMethodBeat.o(12712);
      return true;
    }
    if ((this.fQG == null) || (!this.fQG.equals(str)))
    {
      AppMethodBeat.o(12712);
      return true;
    }
    AppMethodBeat.o(12712);
    return false;
  }
  
  private void YW()
  {
    AppMethodBeat.i(12713);
    if (YV())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(12713);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(12713);
  }
  
  private void YX()
  {
    AppMethodBeat.i(12718);
    Intent localIntent = new Intent();
    localIntent.putExtra("room_name", this.fQB);
    localIntent.putExtra("room_notice", this.fQG);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(12718);
  }
  
  private void e(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(12717);
    if ((this.fQJ != null) && (this.fQJ.isShowing())) {
      this.fQJ.dismiss();
    }
    if ((this.fQJ != null) && (this.fQJ.isShowing())) {
      this.fQJ.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
      this.fQG = this.fQL.getText().toString();
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 15L, 1L, true);
      YX();
      AppMethodBeat.o(12717);
      return;
    }
    uW(paramString);
    ad.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(12717);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(12711);
    if ((!this.fQE) && (!this.fQF))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(12711);
      return;
    }
    if (YV())
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
  
  private void uW(String paramString)
  {
    AppMethodBeat.i(12719);
    ad.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[] { paramString });
    paramString = com.tencent.mm.h.a.uz(paramString);
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
    this.fQT = new com.tencent.mm.ui.tools.h(this);
    getWindow().setSoftInputMode(48);
    this.fQT.KIP = new com.tencent.mm.ui.tools.g()
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
    }, null, s.b.JbS);
    enableOptionMenu(true);
    this.fQR = ((LinearLayout)findViewById(2131300723));
    this.fQS = ((LinearLayout)findViewById(2131304220));
    this.fQL = ((MMEditText)findViewById(2131302952));
    this.fQM = ((TextView)findViewById(2131302955));
    this.fQN = ((TextView)findViewById(2131302954));
    this.fQP = ((LinearLayout)findViewById(2131304223));
    this.fQO = ((ImageView)findViewById(2131302953));
    this.fQQ = ((LinearLayout)findViewById(2131304230));
    this.fQL.setText(this.fQG);
    Object localObject = (WindowManager)getSystemService("window");
    this.fQL.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 - 100);
    k.b(this.fQL, Integer.valueOf(31));
    this.fQK = ((TextView)findViewById(2131301394));
    this.fQK.setText(Integer.toString(com.tencent.mm.ui.tools.f.cU(280, this.fQG)));
    this.fQQ.setVisibility(8);
    this.fQL.setCursorVisible(false);
    this.fQL.setFocusable(false);
    label424:
    String str;
    if ((!this.fQE) && (!this.fQF))
    {
      removeOptionMenu(0);
      this.fQS.setVisibility(0);
      this.fQL.setFocusable(false);
      this.fQL.setCursorVisible(false);
      this.fQL.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(12697);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          RoomCardUI.a(RoomCardUI.this, RoomCardUI.b(RoomCardUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(12697);
          return true;
        }
      });
      if (this.fQI == 0L) {
        break label623;
      }
      this.fQM.setVisibility(0);
      this.fQM.setText(com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm", this.fQI));
      if (!bt.isNullOrNil(this.fQG)) {
        break label635;
      }
      this.fQL.setEnabled(true);
      this.fQL.setFocusableInTouchMode(true);
      this.fQL.setFocusable(true);
      this.fQR.setVisibility(8);
      this.fQL.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 + 100);
      this.fQL.requestFocus();
      this.fQL.setCursorVisible(true);
      updateOptionMenuText(0, getContext().getString(2131755779));
      YW();
      this.fQL.performClick();
      showVKB();
      label537:
      localObject = v.zf(this.fQH);
      this.fQN.setText(k.b(this, (CharSequence)localObject, this.fQN.getTextSize()));
      localObject = this.fQO;
      str = this.fQH;
      if (!bt.isNullOrNil(str)) {
        break label646;
      }
      ((ImageView)localObject).setImageResource(2131231875);
    }
    for (;;)
    {
      this.fQL.addTextChangedListener(new a((byte)0));
      AppMethodBeat.o(12705);
      return;
      this.fQS.setVisibility(8);
      break;
      label623:
      this.fQM.setVisibility(8);
      break label424;
      label635:
      this.fQR.setVisibility(0);
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
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 0L, 1L, true);
    com.tencent.mm.kernel.g.ajB().gAO.a(993, this);
    this.fPi = getIntent().getStringExtra("RoomInfo_Id");
    this.fQG = getIntent().getStringExtra("room_notice");
    this.fQH = getIntent().getStringExtra("room_notice_editor");
    this.fQI = getIntent().getLongExtra("room_notice_publish_time", 0L);
    this.fQB = getIntent().getStringExtra("room_name");
    this.fQC = getIntent().getIntExtra("room_member_count", 0);
    this.fQD = getIntent().getStringExtra("room_owner_name");
    this.fQE = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fQF = getIntent().getBooleanExtra("Is_RoomManager", false);
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
    com.tencent.mm.kernel.g.ajB().gAO.b(993, this);
    if ((this.fQJ != null) && (this.fQJ.isShowing())) {
      this.fQJ.dismiss();
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
    this.fQT.close();
    AppMethodBeat.o(12709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12707);
    super.onResume();
    this.fQT.start();
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
      this.fQT.start();
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(12708);
  }
  
  final class a
    implements TextWatcher
  {
    private int fQZ = 280;
    private String fRa = "";
    private boolean fRb = false;
    
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