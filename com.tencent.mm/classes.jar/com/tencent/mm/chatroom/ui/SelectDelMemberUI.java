package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.q.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectDelMemberUI
  extends SelectMemberUI
{
  private int egU;
  
  private void Km()
  {
    AppMethodBeat.i(104394);
    if (this.ejG.size() > 0)
    {
      updateOptionMenuText(1, getString(2131298951) + "(" + this.ejG.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(104394);
      return;
    }
    updateOptionMenuText(1, getString(2131298951));
    enableOptionMenu(1, false);
    AppMethodBeat.o(104394);
  }
  
  protected final void Kj()
  {
    AppMethodBeat.i(104388);
    super.Kj();
    this.egU = getIntent().getIntExtra("room_member_count", 0);
    AppMethodBeat.o(104388);
  }
  
  public final boolean Kk()
  {
    return true;
  }
  
  protected final HashSet<String> Kn()
  {
    AppMethodBeat.i(104391);
    HashSet localHashSet = super.Kn();
    if (Ks().ara(r.Zn()))
    {
      AppMethodBeat.o(104391);
      return localHashSet;
    }
    Iterator localIterator = Ks().afx().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((Ks().aqW(str)) || (Ks().ara(str))) {
        localHashSet.add(str);
      }
    }
    AppMethodBeat.o(104391);
    return localHashSet;
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(104393);
    super.a(paramView, paramInt, paramLong);
    ((SelectMemberUI.c)paramView.getTag()).ejV.performClick();
    AppMethodBeat.o(104393);
  }
  
  public void finish()
  {
    AppMethodBeat.i(104390);
    hideVKB();
    super.finish();
    AppMethodBeat.o(104390);
  }
  
  public void initView()
  {
    AppMethodBeat.i(104389);
    super.initView();
    setMMTitle(getString(2131302785) + "(" + this.egU + ")");
    addTextOptionMenu(1, getString(2131298951), new SelectDelMemberUI.1(this), null, q.b.zbz);
    Km();
    AppMethodBeat.o(104389);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void v(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(104392);
    super.v(paramInt, paramBoolean);
    Km();
    AppMethodBeat.o(104392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelMemberUI
 * JD-Core Version:    0.7.0.1
 */