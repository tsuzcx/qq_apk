import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.TroopCardSameCity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBStringField;
import java.net.URL;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item2;

public class cck
  extends BaseAdapter
{
  public cck(TroopCardSameCity paramTroopCardSameCity) {}
  
  public int getCount()
  {
    if (TroopCardSameCity.a(this.a) != null) {
      return TroopCardSameCity.a(this.a).size();
    }
    return 0;
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
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new ccm(null);
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2130903496, paramViewGroup, false);
      ((ccm)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298521));
      ((ccm)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298523));
      ((ccm)localObject1).b = ((TextView)paramView.findViewById(2131298524));
      paramView.setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
    }
    for (;;)
    {
      localObject1 = (searchtab.Item2)TroopCardSameCity.a(this.a).get(paramInt);
      try
      {
        Object localObject2 = new URL(((searchtab.Item2)localObject1).str_img_url.get());
        localObject2 = URLDrawable.getDrawable(new URL("popularize", ((URL)localObject2).getAuthority(), ((URL)localObject2).getFile()), null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        label152:
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((searchtab.Item2)localObject1).str_name.get());
        paramViewGroup.b.setText(((searchtab.Item2)localObject1).str_desc.get());
        paramView.setOnClickListener(new ccl(this, paramInt));
        return paramView;
        paramViewGroup = (ccm)paramView.getTag();
      }
      catch (Exception localException)
      {
        break label152;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cck
 * JD-Core Version:    0.7.0.1
 */