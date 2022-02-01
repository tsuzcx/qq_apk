import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopFeedParserHelper;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;

public class kok
  extends TroopFeedViewFactory.ViewProvider
{
  public kok(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
    this.jdField_a_of_type_Int = 3;
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView2 = paramView;
    if (paramView == null) {
      localView2 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext).inflate(2130903683, null);
    }
    kol localkol = (kol)localView2.getTag();
    if (localkol == null)
    {
      localkol = new kol(this);
      localkol.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView2.findViewById(2131298829));
      localkol.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView2.findViewById(2131297001));
      localkol.b = ((TextView)localView2.findViewById(2131296744));
      localkol.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView2.findViewById(2131299302));
      localView2.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory);
      localView2.setTag(localkol);
    }
    for (;;)
    {
      localkol.jdField_a_of_type_Int = paramInt;
      localkol.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localkol.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localkol.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localkol.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localkol.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localkol.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localkol.b.setVisibility(0);
      localkol.b.setSingleLine(false);
      localkol.b.setMaxLines(2);
      localkol.b.setText("");
      localkol.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localkol.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839429);
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (StringUtil.b(paramTroopFeedItem.picPath)) {
          break label1168;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = AIOUtils.a(61.0F, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getResources());
          URLDrawable localURLDrawable = URLDrawable.getDrawable(paramTroopFeedItem.picPath, paramInt, paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if (((paramTroopFeedItem.type != 5) || (paramTroopFeedItem.type != 19) || (paramTroopFeedItem.type != 99)) && (!StringUtil.b(paramTroopFeedItem.publishUin)) && (!StringUtil.b(paramTroopFeedItem.feedTime)))
          {
            paramView = str + " " + paramTroopFeedItem.publishUin;
            ((TextView)localkol.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296683)).setText(paramTroopFeedItem.publishUin);
            try
            {
              str = " 发表于 " + TroopFeedParserHelper.a(Long.parseLong(paramTroopFeedItem.feedTime));
              ((TextView)localkol.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131299303)).setText(str);
              str = paramView + str;
              paramView = str;
              paramInt = 1;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              paramInt = 0;
              continue;
              if ((paramTroopFeedItem.type != 5) && (paramTroopFeedItem.type != 19)) {
                continue;
              }
              localkol.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
              localkol.b.setText(paramTroopFeedItem.content);
              localkol.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
              localkol.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
              paramView = paramView + " " + paramTroopFeedItem.content;
              continue;
              if ((paramTroopFeedItem.type != 133) && (paramTroopFeedItem.type != 18) && (paramTroopFeedItem.type != 0)) {
                continue;
              }
              localkol.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
              if (paramInt == 0) {
                continue;
              }
              localkol.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localkol.b.setVisibility(8);
              continue;
              if (paramTroopFeedItem.type != 12) {
                continue;
              }
              localkol.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839435);
              if (paramInt == 0) {
                continue;
              }
              localkol.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localkol.b.setVisibility(8);
              continue;
              if ((paramTroopFeedItem.type != 10) && (paramTroopFeedItem.type != 132)) {
                continue;
              }
              localkol.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
              localkol.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
              localkol.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839434);
              if (paramInt == 0) {
                continue;
              }
              localkol.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localkol.b.setVisibility(8);
              continue;
              if (paramTroopFeedItem.orginType != 99) {
                continue;
              }
              localkol.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
              localkol.b.setText(paramTroopFeedItem.content);
              localkol.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
              localkol.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
              paramView = paramView + " " + paramTroopFeedItem.content;
              continue;
              continue;
            }
            if (paramTroopFeedItem.type == 131)
            {
              localkol.jdField_a_of_type_AndroidWidgetImageView.setImageResource(FileManagerUtil.b(paramTroopFeedItem.title));
              if (paramInt == 0) {
                continue;
              }
              localkol.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localkol.b.setVisibility(8);
              paramTroopFeedItem = paramView;
              if (!paramBoolean) {
                paramTroopFeedItem = paramView + " 两指向左横向滑动查看下一条通知";
              }
              localView2.setContentDescription(paramTroopFeedItem);
              if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_b_of_type_Boolean)
              {
                localView2.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_Koj);
                localView2.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_Koj);
              }
              return localView2;
              if (paramTroopFeedItem.type == 132)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.c == null) {
                  this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.c = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839432);
                }
                paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.c;
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839429);
              }
              paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localView1 = paramView;
          continue;
          paramInt = 0;
          paramView = localNumberFormatException;
          continue;
        }
        label1168:
        View localView1 = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kok
 * JD-Core Version:    0.7.0.1
 */