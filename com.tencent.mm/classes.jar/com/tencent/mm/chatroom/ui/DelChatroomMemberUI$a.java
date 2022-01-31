package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.LinkedList;
import java.util.List;

final class DelChatroomMemberUI$a
  extends BaseAdapter
{
  List<ad> egm;
  
  DelChatroomMemberUI$a(DelChatroomMemberUI paramDelChatroomMemberUI)
  {
    AppMethodBeat.i(104090);
    this.egm = new LinkedList();
    AppMethodBeat.o(104090);
  }
  
  public final String c(ad paramad)
  {
    AppMethodBeat.i(104095);
    if (!bo.isNullOrNil(paramad.field_conRemark)) {}
    for (Object localObject2 = paramad.field_conRemark;; localObject2 = DelChatroomMemberUI.b(this.egi, paramad.field_username))
    {
      Object localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = paramad.field_conRemark;
      }
      localObject2 = localObject1;
      if (bo.isNullOrNil((String)localObject1)) {
        localObject2 = paramad.Oe();
      }
      AppMethodBeat.o(104095);
      return localObject2;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(104092);
    int i = this.egm.size();
    AppMethodBeat.o(104092);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(104093);
    Object localObject = this.egm.get(paramInt);
    AppMethodBeat.o(104093);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104094);
    if (paramView == null)
    {
      paramView = View.inflate(this.egi, 2130969024, null);
      paramViewGroup = new DelChatroomMemberUI.b(this.egi);
      paramViewGroup.egq = ((ImageView)paramView.findViewById(2131822425));
      paramViewGroup.egr = ((TextView)paramView.findViewById(2131822427));
      paramViewGroup.egs = ((TextView)paramView.findViewById(2131822426));
      paramViewGroup.egs.setOnClickListener(new DelChatroomMemberUI.a.1(this));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.egs.setTag(Integer.valueOf(paramInt));
      ad localad = (ad)getItem(paramInt);
      String str = c(localad);
      paramViewGroup.egr.setText(str);
      j.b(this.egi, str, paramViewGroup.egr.getTextSize());
      a.b.c(paramViewGroup.egq, localad.field_username);
      AppMethodBeat.o(104094);
      return paramView;
      paramViewGroup = (DelChatroomMemberUI.b)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI.a
 * JD-Core Version:    0.7.0.1
 */