import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.TroopCardGroup;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item1;

public class cce
  extends FacePreloadBaseAdapter
{
  public cce(TroopCardGroup paramTroopCardGroup, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    super(paramContext, paramQQAppInterface, paramListView, 1, true);
  }
  
  protected Object a(int paramInt)
  {
    searchtab.Item1 localItem1 = (searchtab.Item1)TroopCardGroup.a(this.a).get(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = String.valueOf(localItem1.uint64_group_code.get());
    localFaceInfo.jdField_a_of_type_Int = 4;
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if (TroopCardGroup.a(this.a) != null) {
      return TroopCardGroup.a(this.a).size();
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
    searchtab.Item1 localItem1 = (searchtab.Item1)TroopCardGroup.a(this.a).get(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new ccg(this, null);
      localView = LayoutInflater.from(this.a.getContext()).inflate(2130903494, paramViewGroup, false);
      paramView.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298512));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298517));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298515));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298516));
      paramView.c = ((TextView)localView.findViewById(2131298518));
      paramView.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298514));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      if (TextUtils.isEmpty(localItem1.str_img_url.get())) {
        break label318;
      }
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(localItem1.str_img_url.get(), null));
      label176:
      if (!TextUtils.isEmpty(localItem1.str_loc.get())) {
        break label372;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      label199:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localItem1.str_name.get());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localItem1.uint32_mem_cnt.get()));
      paramViewGroup.c.setText(localItem1.str_loc.get());
      if (TextUtils.isEmpty(localItem1.str_oper_desc.get())) {
        break label383;
      }
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(localItem1.str_oper_desc.get());
    }
    for (;;)
    {
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(paramInt));
      localView.setOnClickListener(new ccf(this, paramInt));
      return localView;
      paramViewGroup = (ccg)paramView.getTag();
      localView = paramView;
      break;
      label318:
      if (localItem1.uint64_group_code.get() <= 0L) {
        break label176;
      }
      paramViewGroup.jdField_b_of_type_JavaLangString = String.valueOf(localItem1.uint64_group_code.get());
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(4, String.valueOf(localItem1.uint64_group_code.get())));
      break label176;
      label372:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break label199;
      label383:
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText("");
      if (QLog.isColorLevel()) {
        QLog.d("TroopCardGroup", 2, "TroopCardGroup str_oper_desc is empty");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cce
 * JD-Core Version:    0.7.0.1
 */