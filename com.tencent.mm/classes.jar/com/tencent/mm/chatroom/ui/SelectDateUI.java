package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

public class SelectDateUI
  extends MMActivity
  implements com.tencent.mm.chatroom.a.a
{
  private long doI = -1L;
  private p dpF = null;
  private DayPickerView drI;
  private String drJ;
  private HashMap<String, com.tencent.mm.chatroom.c.a> drK;
  private TextView drL;
  private ah mHandler;
  
  public final void a(com.tencent.mm.chatroom.c.a parama)
  {
    if (parama == null)
    {
      y.e("MicroMsg.SelectDateUI", "null == calendarDay");
      return;
    }
    y.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", new Object[] { Long.valueOf(parama.dmJ), Integer.valueOf(parama.day), Integer.valueOf(parama.month), Integer.valueOf(parama.year) });
    long l = parama.bIt;
    y.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", new Object[] { Long.valueOf(l) });
    d.e(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.drJ).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", l));
  }
  
  protected final int getLayoutId()
  {
    return a.f.select_date_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(a.e.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    setMMTitle(a.i.room_search_chatting_content);
    this.drI = ((DayPickerView)findViewById(a.e.pickerView));
    this.drL = ((TextView)findViewById(a.e.search_nothing_hint));
    this.drK = new HashMap();
    this.mHandler = new ah(getMainLooper());
    this.drJ = getIntent().getStringExtra("detail_username");
    e.post(new SelectDateUI.1(this), "prepare_data");
    setBackBtn(new SelectDateUI.2(this));
  }
  
  public final long xg()
  {
    return System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDateUI
 * JD-Core Version:    0.7.0.1
 */