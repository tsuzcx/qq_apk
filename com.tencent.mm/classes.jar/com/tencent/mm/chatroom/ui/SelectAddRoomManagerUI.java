package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.q.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectAddRoomManagerUI
  extends SelectMemberUI
{
  private boolean ejn;
  private HashSet<String> ejo;
  
  public SelectAddRoomManagerUI()
  {
    AppMethodBeat.i(104371);
    this.ejn = false;
    this.ejo = new HashSet();
    AppMethodBeat.o(104371);
  }
  
  private void Km()
  {
    AppMethodBeat.i(104377);
    if (this.ejG.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(104377);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(104377);
  }
  
  protected final void Kj()
  {
    AppMethodBeat.i(104372);
    super.Kj();
    this.ejn = false;
    Iterator localIterator = this.efi.afx().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.efi.aqW(str)) {
        this.ejo.add(str);
      }
    }
    AppMethodBeat.o(104372);
  }
  
  public final boolean Kk()
  {
    return true;
  }
  
  protected final HashSet<String> Kl()
  {
    return this.ejo;
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(104376);
    super.a(paramView, paramInt, paramLong);
    paramView = (SelectMemberUI.c)paramView.getTag();
    String str = paramView.ejR.contact.Of();
    ab.d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", new Object[] { paramView.ejR.contact.field_username, str, paramView.ejR.contact.Oe() });
    paramView.ejV.performClick();
    AppMethodBeat.o(104376);
  }
  
  public void finish()
  {
    AppMethodBeat.i(104375);
    hideVKB();
    super.finish();
    AppMethodBeat.o(104375);
  }
  
  public void initView()
  {
    AppMethodBeat.i(104373);
    super.initView();
    String str;
    label42:
    SelectAddRoomManagerUI.1 local1;
    if (this.ejn)
    {
      str = getString(2131302787);
      setMMTitle(str);
      if (!this.ejn) {
        break label91;
      }
      str = getString(2131298951);
      local1 = new SelectAddRoomManagerUI.1(this);
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
      AppMethodBeat.o(104373);
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
    AppMethodBeat.i(104374);
    super.v(paramInt, paramBoolean);
    Km();
    AppMethodBeat.o(104374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */