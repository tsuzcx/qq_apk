package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ManagerRoomByWeworkUI$3
  implements View.OnClickListener
{
  ManagerRoomByWeworkUI$3(ManagerRoomByWeworkUI paramManagerRoomByWeworkUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(217224);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    ae.i("MicroMsg.ManagerRoomByWeworkUI", "select_group_ll click");
    ManagerRoomByWeworkUI.e(this.fRW);
    if (ManagerRoomByWeworkUI.f(this.fRW).fSb == 5)
    {
      t.makeText(this.fRW, 2131766408, 0).show();
      a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(217224);
      return;
    }
    paramView = new Intent();
    paramView.setClassName(this.fRW, "com.tencent.mm.ui.contact.GroupCardSelectUI");
    paramView.putExtra("group_select_type", true);
    paramView.putExtra("group_select_need_result", true);
    paramView.putExtra("group_select_only_need_self_owner", true);
    localObject = new ArrayList();
    Iterator localIterator = ManagerRoomByWeworkUI.g(this.fRW).iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localObject).add(((an)localIterator.next()).field_username);
    }
    paramView.putStringArrayListExtra("group_select_block_chatroom", (ArrayList)localObject);
    paramView.putExtra("group_select_chatroom_max_num", r.aAx());
    this.fRW.startActivityForResult(paramView, 0);
    a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(217224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI.3
 * JD-Core Version:    0.7.0.1
 */