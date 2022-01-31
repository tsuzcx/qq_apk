package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.chatroom.ui.a.e;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class RoomManagerPreference
  extends Preference
{
  private List<ad> dtG = new LinkedList();
  
  public RoomManagerPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoomManagerPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    ((TextView)paramView.findViewById(a.e.title)).setText(getTitle());
    ImageView localImageView1 = (ImageView)paramView.findViewById(a.e.icon1);
    ImageView localImageView2 = (ImageView)paramView.findViewById(a.e.icon2);
    paramView = (ImageView)paramView.findViewById(a.e.icon3);
    localImageView1.setVisibility(4);
    localImageView2.setVisibility(4);
    paramView.setVisibility(4);
    int i = 0;
    if (i < this.dtG.size())
    {
      if (i == 0)
      {
        a.b.a(localImageView1, ((ad)this.dtG.get(0)).field_username, 0.15F, false);
        localImageView1.setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        if (1 == i)
        {
          a.b.a(localImageView2, ((ad)this.dtG.get(1)).field_username, 0.15F, false);
          localImageView2.setVisibility(0);
        }
        else if (2 == i)
        {
          paramView.setVisibility(0);
          a.b.a(paramView, ((ad)this.dtG.get(2)).field_username, 0.15F, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.preference.RoomManagerPreference
 * JD-Core Version:    0.7.0.1
 */