import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.PanelAdapter;
import com.tencent.mobileqq.activity.aio.PanelAdapter.ViewHolder;

public class fpg
  extends LinearLayout
{
  public int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  
  public fpg(PanelAdapter paramPanelAdapter, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    int k = paramPanelAdapter.a();
    int m = paramPanelAdapter.b();
    int i = 0;
    while (i < m)
    {
      paramAttributeSet = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      localLayoutParams.weight = 1.0F;
      paramAttributeSet.setOrientation(0);
      paramAttributeSet.setPadding(paramPanelAdapter.b, 0, paramPanelAdapter.b, 0);
      int j = 0;
      while (j < k)
      {
        Object localObject = new LinearLayout.LayoutParams(-2, -2);
        if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
          this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
        }
        RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2130903157, null);
        paramAttributeSet.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
        if (j != k - 1)
        {
          localObject = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
          paramAttributeSet.addView(new View(paramPanelAdapter.a), (ViewGroup.LayoutParams)localObject);
        }
        localObject = new PanelAdapter.ViewHolder();
        ((PanelAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localRelativeLayout.findViewById(2131297135));
        ((PanelAdapter.ViewHolder)localObject).b = ((ImageView)localRelativeLayout.findViewById(2131297137));
        ((PanelAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localRelativeLayout.findViewById(2131297136));
        localRelativeLayout.setTag(localObject);
        j += 1;
      }
      addView(paramAttributeSet, localLayoutParams);
      i += 1;
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if (localObject != null)
      {
        localObject = (PanelAdapter.ViewHolder)((View)localObject).getTag();
        if ((localObject != null) && (((PanelAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView != null)) {
          ((PanelAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fpg
 * JD-Core Version:    0.7.0.1
 */