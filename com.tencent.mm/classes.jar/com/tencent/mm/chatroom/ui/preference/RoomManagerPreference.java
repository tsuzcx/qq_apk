package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.chatroom.ui.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class RoomManagerPreference
  extends Preference
{
  private List<au> lCU;
  
  public RoomManagerPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13014);
    this.lCU = new LinkedList();
    AppMethodBeat.o(13014);
  }
  
  public RoomManagerPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13013);
    this.lCU = new LinkedList();
    AppMethodBeat.o(13013);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(13015);
    super.onBindView(paramView);
    ((TextView)paramView.findViewById(a.e.title)).setText(getTitle());
    ImageView localImageView1 = (ImageView)paramView.findViewById(a.e.lEQ);
    ImageView localImageView2 = (ImageView)paramView.findViewById(a.e.lER);
    paramView = (ImageView)paramView.findViewById(a.e.lES);
    localImageView1.setVisibility(4);
    localImageView2.setVisibility(4);
    paramView.setVisibility(4);
    int i = 0;
    if (i < this.lCU.size())
    {
      if (i == 0)
      {
        a.b.a(localImageView1, ((au)this.lCU.get(0)).field_username, 0.15F, false);
        localImageView1.setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        if (1 == i)
        {
          a.b.a(localImageView2, ((au)this.lCU.get(1)).field_username, 0.15F, false);
          localImageView2.setVisibility(0);
        }
        else if (2 == i)
        {
          paramView.setVisibility(0);
          a.b.a(paramView, ((au)this.lCU.get(2)).field_username, 0.15F, false);
        }
      }
    }
    AppMethodBeat.o(13015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.preference.RoomManagerPreference
 * JD-Core Version:    0.7.0.1
 */