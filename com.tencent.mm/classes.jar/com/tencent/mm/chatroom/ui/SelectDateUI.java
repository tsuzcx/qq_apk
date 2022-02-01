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
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import java.util.HashMap;

public class SelectDateUI
  extends MMActivity
  implements com.tencent.mm.chatroom.a.a
{
  private DayPickerView gAm;
  private String gAn;
  private HashMap<String, com.tencent.mm.chatroom.d.a> gAo;
  private TextView gAp;
  private long guZ = -1L;
  private q gxX = null;
  private MMHandler mHandler;
  
  public final void a(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12925);
    if (parama == null)
    {
      Log.e("MicroMsg.SelectDateUI", "null == calendarDay");
      AppMethodBeat.o(12925);
      return;
    }
    Log.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", new Object[] { Long.valueOf(parama.grW), Integer.valueOf(parama.grV), Integer.valueOf(parama.month), Integer.valueOf(parama.year) });
    long l = parama.msgId;
    Log.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", new Object[] { Long.valueOf(l) });
    c.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.gAn).putExtra("finish_direct", true).putExtra("from_date_search", true).putExtra("msg_local_id", l));
    AppMethodBeat.o(12925);
  }
  
  public final long alZ()
  {
    AppMethodBeat.i(12924);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(12924);
    return l;
  }
  
  public int getLayoutId()
  {
    return 2131496203;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12923);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296366), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setMMTitle(2131764779);
    this.gAm = ((DayPickerView)findViewById(2131305937));
    this.gAp = ((TextView)findViewById(2131307411));
    this.gAo = new HashMap();
    this.mHandler = new MMHandler(getMainLooper());
    this.gAn = getIntent().getStringExtra("detail_username");
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12921);
        SelectDateUI.a(SelectDateUI.this);
        SelectDateUI.f(SelectDateUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(12920);
            DayPickerView localDayPickerView = SelectDateUI.c(SelectDateUI.this);
            if (SelectDateUI.b(SelectDateUI.this) == -1L) {}
            for (long l = System.currentTimeMillis() * 1000L;; l = SelectDateUI.b(SelectDateUI.this))
            {
              localDayPickerView.setBeginDate(l);
              SelectDateUI.c(SelectDateUI.this).a(SelectDateUI.this, SelectDateUI.d(SelectDateUI.this).values());
              if (SelectDateUI.d(SelectDateUI.this).size() != 0) {
                break;
              }
              SelectDateUI.e(SelectDateUI.this).setVisibility(0);
              SelectDateUI.c(SelectDateUI.this).setVisibility(8);
              SelectDateUI.e(SelectDateUI.this).setText(SelectDateUI.this.getString(2131757493));
              AppMethodBeat.o(12920);
              return;
            }
            SelectDateUI.e(SelectDateUI.this).setVisibility(8);
            SelectDateUI.c(SelectDateUI.this).setVisibility(0);
            AppMethodBeat.o(12920);
          }
        });
        AppMethodBeat.o(12921);
      }
    }, "prepare_data");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12922);
        SelectDateUI.this.finish();
        AppMethodBeat.o(12922);
        return true;
      }
    });
    AppMethodBeat.o(12923);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDateUI
 * JD-Core Version:    0.7.0.1
 */