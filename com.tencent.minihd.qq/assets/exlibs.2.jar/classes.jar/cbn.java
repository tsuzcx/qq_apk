import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.SearchResultAdapter;
import com.tencent.widget.XListView;
import java.util.List;

public class cbn
  implements TextWatcher
{
  private cbn(PoiMapActivity paramPoiMapActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (TextUtils.isEmpty(paramEditable))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.a.b.setVisibility(8);
      this.a.jdField_a_of_type_JavaUtilList.clear();
      this.a.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
    }
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    } while (!this.a.f);
    this.a.a(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cbn
 * JD-Core Version:    0.7.0.1
 */