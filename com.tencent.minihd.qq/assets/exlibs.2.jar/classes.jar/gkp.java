import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.app.BaseActivity;

public class gkp
  extends BaseAdapter
{
  private gkp(LinkShareActionSheetBuilder paramLinkShareActionSheetBuilder) {}
  
  public int getCount()
  {
    return 3;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2130904492, null);
    }
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131367821;
      j = 2130837969;
      paramInt = 2131367845;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131298904);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131298905);
      paramView.setImageResource(j);
      localTextView.setText(i);
      paramViewGroup.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(paramInt));
      return paramViewGroup;
      i = 2131367817;
      j = 2130837971;
      paramInt = 2131367843;
      continue;
      i = 2131367820;
      j = 2130837972;
      paramInt = 2131367844;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gkp
 * JD-Core Version:    0.7.0.1
 */