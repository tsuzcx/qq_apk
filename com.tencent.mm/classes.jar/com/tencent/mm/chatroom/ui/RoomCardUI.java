package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.MMEditText;

public class RoomCardUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private String gwx;
  private String gxP;
  private int gxQ;
  private String gxR;
  private boolean gxS;
  private boolean gxT;
  private String gxU;
  private String gxV;
  private long gxW;
  private com.tencent.mm.ui.base.q gxX;
  private TextView gxY;
  private MMEditText gxZ;
  private TextView gya;
  private TextView gyb;
  private ImageView gyc;
  private LinearLayout gyd;
  private LinearLayout gye;
  private LinearLayout gyf;
  private LinearLayout gyg;
  private com.tencent.mm.ui.tools.h gyh;
  private k.b gyi;
  private IListener gyj;
  private boolean gyk;
  
  public RoomCardUI()
  {
    AppMethodBeat.i(12704);
    this.gyj = new RoomCardUI.4(this);
    this.gyk = false;
    AppMethodBeat.o(12704);
  }
  
  private void DJ(String paramString)
  {
    AppMethodBeat.i(12719);
    Log.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[] { paramString });
    paramString = com.tencent.mm.h.a.Dk(paramString);
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
  
  private boolean amR()
  {
    AppMethodBeat.i(12712);
    String str = this.gxZ.getText().toString();
    if (Util.isNullOrNil(str))
    {
      if (Util.isNullOrNil(this.gxU))
      {
        AppMethodBeat.o(12712);
        return false;
      }
      AppMethodBeat.o(12712);
      return true;
    }
    if ((this.gxU == null) || (!this.gxU.equals(str)))
    {
      AppMethodBeat.o(12712);
      return true;
    }
    AppMethodBeat.o(12712);
    return false;
  }
  
  private void amS()
  {
    AppMethodBeat.i(12713);
    if (amR())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(12713);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(12713);
  }
  
  private void amT()
  {
    AppMethodBeat.i(12718);
    Intent localIntent = new Intent();
    localIntent.putExtra("room_name", this.gxP);
    localIntent.putExtra("room_notice", this.gxU);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(12718);
  }
  
  private void e(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(12717);
    if ((this.gxX != null) && (this.gxX.isShowing())) {
      this.gxX.dismiss();
    }
    if ((this.gxX != null) && (this.gxX.isShowing())) {
      this.gxX.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
      this.gxU = this.gxZ.getText().toString();
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 15L, 1L, true);
      amT();
      AppMethodBeat.o(12717);
      return;
    }
    DJ(paramString);
    Log.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(12717);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(12711);
    if ((!this.gxS) && (!this.gxT))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(12711);
      return;
    }
    if (amR())
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131764656), null, getString(2131764658), getString(2131764657), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public int getLayoutId()
  {
    return 2131496122;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12705);
    setMMTitle(2131764744);
    getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101424)));
    this.gyh = new com.tencent.mm.ui.tools.h(this);
    getWindow().setSoftInputMode(48);
    this.gyh.Quk = new RoomCardUI.1(this);
    addTextOptionMenu(0, getString(2131755792), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12696);
        if (paramAnonymousMenuItem.getTitle().equals(RoomCardUI.this.getString(2131755858))) {
          RoomCardUI.a(RoomCardUI.this);
        }
        RoomCardUI.b(RoomCardUI.this).setEnabled(true);
        RoomCardUI.b(RoomCardUI.this).setFocusableInTouchMode(true);
        RoomCardUI.b(RoomCardUI.this).setFocusable(true);
        RoomCardUI.b(RoomCardUI.this).setCursorVisible(true);
        RoomCardUI.this.updateOptionMenuText(0, RoomCardUI.this.getString(2131755858));
        RoomCardUI.this.enableOptionMenu(false);
        RoomCardUI.this.showVKB();
        RoomCardUI.b(RoomCardUI.this).setSelection(RoomCardUI.b(RoomCardUI.this).getText().toString().length());
        AppMethodBeat.o(12696);
        return true;
      }
    }, null, t.b.OGU);
    enableOptionMenu(true);
    this.gyf = ((LinearLayout)findViewById(2131302299));
    this.gyg = ((LinearLayout)findViewById(2131307138));
    this.gxZ = ((MMEditText)findViewById(2131305539));
    this.gya = ((TextView)findViewById(2131305542));
    this.gyb = ((TextView)findViewById(2131305541));
    this.gyd = ((LinearLayout)findViewById(2131307141));
    this.gyc = ((ImageView)findViewById(2131305540));
    this.gye = ((LinearLayout)findViewById(2131307148));
    this.gxZ.setText(this.gxU);
    Object localObject1 = (WindowManager)getSystemService("window");
    this.gxZ.setMinHeight(((WindowManager)localObject1).getDefaultDisplay().getHeight() * 2 / 3 - 100);
    Object localObject2 = com.tencent.mm.pluginsdk.ui.span.t.Ao(true);
    ((Bundle)localObject2).putInt("geta8key_scene", 31);
    com.tencent.mm.pluginsdk.ui.span.l.a(this.gxZ, localObject2, com.tencent.mm.pluginsdk.ui.span.l.Krf);
    this.gxY = ((TextView)findViewById(2131303149));
    this.gxY.setText(Integer.toString(com.tencent.mm.ui.tools.f.dp(280, this.gxU)));
    this.gye.setVisibility(8);
    this.gxZ.setCursorVisible(false);
    this.gxZ.setFocusable(false);
    if ((!this.gxS) && (!this.gxT))
    {
      removeOptionMenu(0);
      this.gyg.setVisibility(0);
      this.gxZ.setFocusable(false);
      this.gxZ.setCursorVisible(false);
      this.gxZ.setOnLongClickListener(new RoomCardUI.7(this));
      if (this.gxW == 0L) {
        break label636;
      }
      this.gya.setVisibility(0);
      this.gya.setText(com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm", this.gxW));
      label437:
      if (!Util.isNullOrNil(this.gxU)) {
        break label648;
      }
      this.gxZ.setEnabled(true);
      this.gxZ.setFocusableInTouchMode(true);
      this.gxZ.setFocusable(true);
      this.gyf.setVisibility(8);
      this.gxZ.setMinHeight(((WindowManager)localObject1).getDefaultDisplay().getHeight() * 2 / 3 + 100);
      this.gxZ.requestFocus();
      this.gxZ.setCursorVisible(true);
      updateOptionMenuText(0, getContext().getString(2131755858));
      amS();
      this.gxZ.performClick();
      showVKB();
      label550:
      localObject1 = aa.getDisplayName(this.gxV);
      this.gyb.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject1, this.gyb.getTextSize()));
      localObject1 = this.gyc;
      localObject2 = this.gxV;
      if (!Util.isNullOrNil((String)localObject2)) {
        break label659;
      }
      ((ImageView)localObject1).setImageResource(2131231957);
    }
    for (;;)
    {
      this.gxZ.addTextChangedListener(new RoomCardUI.a(this, (byte)0));
      AppMethodBeat.o(12705);
      return;
      this.gyg.setVisibility(8);
      break;
      label636:
      this.gya.setVisibility(8);
      break label437;
      label648:
      this.gyf.setVisibility(0);
      break label550;
      label659:
      a.b.c((ImageView)localObject1, (String)localObject2);
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
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 0L, 1L, true);
    g.aAg().hqi.a(993, this);
    this.gwx = getIntent().getStringExtra("RoomInfo_Id");
    this.gxU = getIntent().getStringExtra("room_notice");
    this.gxV = getIntent().getStringExtra("room_notice_editor");
    this.gxW = getIntent().getLongExtra("room_notice_publish_time", 0L);
    this.gxP = getIntent().getStringExtra("room_name");
    this.gxQ = getIntent().getIntExtra("room_member_count", 0);
    this.gxR = getIntent().getStringExtra("room_owner_name");
    this.gxS = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.gxT = getIntent().getBooleanExtra("Is_RoomManager", false);
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
    g.aAg().hqi.b(993, this);
    if ((this.gxX != null) && (this.gxX.isShowing())) {
      this.gxX.dismiss();
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
    this.gyh.close();
    AppMethodBeat.o(12709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12707);
    super.onResume();
    this.gyh.start();
    AppMethodBeat.o(12707);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
      this.gyh.start();
    }
    AppMethodBeat.o(12708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI
 * JD-Core Version:    0.7.0.1
 */