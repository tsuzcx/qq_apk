import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.TroopCardXingquBuluo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.PBStringField;
import java.net.URL;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item3;

public class cco
  extends BaseAdapter
{
  public cco(TroopCardXingquBuluo paramTroopCardXingquBuluo) {}
  
  public int getCount()
  {
    if (TroopCardXingquBuluo.a(this.a) != null) {
      return TroopCardXingquBuluo.a(this.a).size();
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
      localObject1 = new ccq(null);
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2130903497, paramViewGroup, false);
      ((ccq)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298521));
      ((ccq)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298523));
      ((ccq)localObject1).b = ((TextView)paramView.findViewById(2131298525));
      ((ccq)localObject1).c = ((TextView)paramView.findViewById(2131298526));
      paramView.setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
    }
    for (;;)
    {
      localObject1 = (searchtab.Item3)TroopCardXingquBuluo.a(this.a).get(paramInt);
      int i = AIOUtils.a(56.0F, this.a.getResources());
      try
      {
        Object localObject2 = new URL(((searchtab.Item3)localObject1).str_img_url.get());
        localObject2 = URLDrawable.getDrawable(new URL("popularize", ((URL)localObject2).getAuthority(), ((URL)localObject2).getFile()), i, i);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        label183:
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((searchtab.Item3)localObject1).str_name.get());
        paramViewGroup.b.setText(((searchtab.Item3)localObject1).str_desc1.get());
        paramViewGroup.c.setText(((searchtab.Item3)localObject1).str_desc2.get());
        paramView.setOnClickListener(new ccp(this, paramInt));
        return paramView;
        paramViewGroup = (ccq)paramView.getTag();
      }
      catch (Exception localException)
      {
        break label183;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cco
 * JD-Core Version:    0.7.0.1
 */