package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import java.util.ArrayList;
import lbr;
import lbt;

public class FriendChooser$GridViewAdapter
  extends AgentBaseAdapter
{
  protected FriendChooser$GridViewAdapter(FriendChooser paramFriendChooser) {}
  
  public int getCount()
  {
    return this.a.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.c.size())) {
      return this.a.c.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Friend localFriend = (Friend)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new lbt();
      paramView = this.a.getLayoutInflater().inflate(2130903349, null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131296567));
      paramView.setTag(paramViewGroup);
    }
    Bitmap localBitmap;
    for (;;)
    {
      if ((localFriend.d == null) || ("".equals(localFriend.d))) {
        localFriend.d = QZonePortraitData.a(this.a.a(), localFriend.a);
      }
      localBitmap = ImageLoader.a().a(localFriend.d);
      if (localBitmap != null) {
        break;
      }
      paramViewGroup.a.setImageResource(2130838406);
      paramViewGroup = paramViewGroup.a;
      ImageLoader.a().a(localFriend.d, new lbr(this, paramViewGroup));
      return paramView;
      paramViewGroup = (lbt)paramView.getTag();
    }
    paramViewGroup.a.setImageBitmap(localBitmap);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */