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
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

public class SelectDateUI
  extends MMActivity
  implements com.tencent.mm.chatroom.a.a
{
  private long fNI = -1L;
  private p fQJ = null;
  private DayPickerView fSZ;
  private String fTa;
  private HashMap<String, com.tencent.mm.chatroom.d.a> fTb;
  private TextView fTc;
  private ap mHandler;
  
  public final long Yc()
  {
    AppMethodBeat.i(12924);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(12924);
    return l;
  }
  
  public final void a(com.tencent.mm.chatroom.d.a parama)
  {
    AppMethodBeat.i(12925);
    if (parama == null)
    {
      ad.e("MicroMsg.SelectDateUI", "null == calendarDay");
      AppMethodBeat.o(12925);
      return;
    }
    ad.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", new Object[] { Long.valueOf(parama.fKH), Integer.valueOf(parama.fKG), Integer.valueOf(parama.month), Integer.valueOf(parama.year) });
    long l = parama.msgId;
    ad.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", new Object[] { Long.valueOf(l) });
    d.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.fTa).putExtra("finish_direct", true).putExtra("from_date_search", true).putExtra("msg_local_id", l));
    AppMethodBeat.o(12925);
  }
  
  public int getLayoutId()
  {
    return 2131495342;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12923);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setMMTitle(2131762696);
    this.fSZ = ((DayPickerView)findViewById(2131303265));
    this.fTc = ((TextView)findViewById(2131304436));
    this.fTb = new HashMap();
    this.mHandler = new ap(getMainLooper());
    this.fTa = getIntent().getStringExtra("detail_username");
    b.c(new Runnable()
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
              SelectDateUI.e(SelectDateUI.this).setText(SelectDateUI.this.getString(2131757279));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDateUI
 * JD-Core Version:    0.7.0.1
 */