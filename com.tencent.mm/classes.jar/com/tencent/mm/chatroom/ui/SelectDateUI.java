package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

public class SelectDateUI
  extends MMActivity
  implements com.tencent.mm.chatroom.a.a
{
  private long ege = -1L;
  private p ehb = null;
  private DayPickerView ejq;
  private String ejr;
  private HashMap<String, com.tencent.mm.chatroom.c.a> ejs;
  private TextView ejt;
  private ak mHandler;
  
  public final long Jy()
  {
    AppMethodBeat.i(104383);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(104383);
    return l;
  }
  
  public final void a(com.tencent.mm.chatroom.c.a parama)
  {
    AppMethodBeat.i(104384);
    if (parama == null)
    {
      ab.e("MicroMsg.SelectDateUI", "null == calendarDay");
      AppMethodBeat.o(104384);
      return;
    }
    ab.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", new Object[] { Long.valueOf(parama.eem), Integer.valueOf(parama.eel), Integer.valueOf(parama.month), Integer.valueOf(parama.year) });
    long l = parama.cpO;
    ab.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", new Object[] { Long.valueOf(l) });
    com.tencent.mm.bq.d.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.ejr).putExtra("finish_direct", true).putExtra("from_date_search", true).putExtra("msg_local_id", l));
    AppMethodBeat.o(104384);
  }
  
  public int getLayoutId()
  {
    return 2130970647;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104382);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131820956), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setMMTitle(2131302784);
    this.ejq = ((DayPickerView)findViewById(2131827532));
    this.ejt = ((TextView)findViewById(2131821515));
    this.ejs = new HashMap();
    this.mHandler = new ak(getMainLooper());
    this.ejr = getIntent().getStringExtra("detail_username");
    com.tencent.mm.sdk.g.d.post(new SelectDateUI.1(this), "prepare_data");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(104381);
        SelectDateUI.this.finish();
        AppMethodBeat.o(104381);
        return true;
      }
    });
    AppMethodBeat.o(104382);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDateUI
 * JD-Core Version:    0.7.0.1
 */