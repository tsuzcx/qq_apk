package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import java.util.LinkedList;
import java.util.List;

final class DelChatroomMemberUI$a
  extends BaseAdapter
{
  List<ad> doQ = new LinkedList();
  
  DelChatroomMemberUI$a(DelChatroomMemberUI paramDelChatroomMemberUI) {}
  
  public final String c(ad paramad)
  {
    if (!bk.bl(paramad.field_conRemark)) {}
    for (Object localObject2 = paramad.field_conRemark;; localObject2 = DelChatroomMemberUI.b(this.doM, paramad.field_username))
    {
      Object localObject1 = localObject2;
      if (bk.bl((String)localObject2)) {
        localObject1 = paramad.field_conRemark;
      }
      localObject2 = localObject1;
      if (bk.bl((String)localObject1)) {
        localObject2 = paramad.Bp();
      }
      return localObject2;
    }
  }
  
  public final int getCount()
  {
    return this.doQ.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.doQ.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.doM, a.f.chatroom_delete_contact_item, null);
      paramViewGroup = new DelChatroomMemberUI.b(this.doM);
      paramViewGroup.doU = ((ImageView)paramView.findViewById(a.e.chatroom_contact_item_avatar));
      paramViewGroup.doV = ((TextView)paramView.findViewById(a.e.chatroom_contact_nick_tv));
      paramViewGroup.doW = ((TextView)paramView.findViewById(a.e.chatroom_contact_delect_tv));
      paramViewGroup.doW.setOnClickListener(new DelChatroomMemberUI.a.1(this));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.doW.setTag(Integer.valueOf(paramInt));
      ad localad = (ad)getItem(paramInt);
      String str = c(localad);
      paramViewGroup.doV.setText(str);
      j.a(this.doM, str, paramViewGroup.doV.getTextSize());
      a.b.a(paramViewGroup.doU, localad.field_username);
      return paramView;
      paramViewGroup = (DelChatroomMemberUI.b)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI.a
 * JD-Core Version:    0.7.0.1
 */