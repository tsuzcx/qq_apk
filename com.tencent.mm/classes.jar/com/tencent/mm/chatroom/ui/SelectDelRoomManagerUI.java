package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectDelRoomManagerUI
  extends SelectMemberUI
{
  private boolean ejn;
  private List<String> ejy;
  
  public SelectDelRoomManagerUI()
  {
    AppMethodBeat.i(104398);
    this.ejn = false;
    this.ejy = new ArrayList();
    AppMethodBeat.o(104398);
  }
  
  private void Km()
  {
    AppMethodBeat.i(104405);
    if (this.ejG.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(104405);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(104405);
  }
  
  protected final void Kj()
  {
    AppMethodBeat.i(104399);
    super.Kj();
    Object localObject1 = getIntent().getStringExtra("RoomManagers");
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.ejy.add(localObject2);
        i += 1;
      }
    }
    this.ejn = true;
    AppMethodBeat.o(104399);
  }
  
  public final boolean Kk()
  {
    return true;
  }
  
  protected final boolean Ko()
  {
    return false;
  }
  
  protected final BaseAdapter Kp()
  {
    AppMethodBeat.i(104403);
    BaseAdapter localBaseAdapter = super.Kp();
    AppMethodBeat.o(104403);
    return localBaseAdapter;
  }
  
  protected final List<String> Kq()
  {
    return this.ejy;
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(104402);
    super.a(paramView, paramInt, paramLong);
    ((SelectMemberUI.c)paramView.getTag()).ejV.performClick();
    AppMethodBeat.o(104402);
  }
  
  public void finish()
  {
    AppMethodBeat.i(104401);
    hideVKB();
    super.finish();
    AppMethodBeat.o(104401);
  }
  
  public void initView()
  {
    AppMethodBeat.i(104400);
    super.initView();
    String str;
    label42:
    SelectDelRoomManagerUI.1 local1;
    if (this.ejn)
    {
      str = getString(2131302787);
      setMMTitle(str);
      if (!this.ejn) {
        break label91;
      }
      str = getString(2131298951);
      local1 = new SelectDelRoomManagerUI.1(this);
      if (!this.ejn) {
        break label101;
      }
    }
    label91:
    label101:
    for (q.b localb = q.b.zbz;; localb = q.b.zby)
    {
      addTextOptionMenu(1, str, local1, null, localb);
      Km();
      AppMethodBeat.o(104400);
      return;
      str = getString(2131302786);
      break;
      str = getString(2131296964);
      break label42;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void v(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(104404);
    super.v(paramInt, paramBoolean);
    Km();
    AppMethodBeat.o(104404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */