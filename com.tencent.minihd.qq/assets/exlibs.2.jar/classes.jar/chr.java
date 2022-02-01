import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;

public class chr
  implements BounceScrollView.OnScrollChangedListener
{
  public chr(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY() > 50.0F * this.a.jdField_a_of_type_Float) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setOverScrollMode(2);
    }
    for (;;)
    {
      this.a.b(paramInt2);
      AccountDetailActivity.a(this.a, paramInt2);
      return;
      this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setOverScrollMode(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     chr
 * JD-Core Version:    0.7.0.1
 */