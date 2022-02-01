import com.tencent.biz.addContactTroopView.AddContactTroopHandler;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler.IGetPopClassAndSearchCB;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

public class cbw
  extends SosoInterface.OnLocationListener
{
  public cbw(AddContactTroopHandler paramAddContactTroopHandler, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString, AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB1, AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB2)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0) {}
    try
    {
      paramSosoLbsInfo = AddContactTroopHandler.a(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler, paramSosoLbsInfo);
      AddContactTroopHandler.a(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler, paramSosoLbsInfo, this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB);
      AddContactTroopHandler.b(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler, paramSosoLbsInfo, this.b);
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB.b();
      this.b.b();
    }
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB.b();
    this.b.b();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cbw
 * JD-Core Version:    0.7.0.1
 */