import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class jef
  implements Runnable
{
  public jef(MagicfaceActionManager paramMagicfaceActionManager, int paramInt) {}
  
  public void run()
  {
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c;
      if (bool1) {
        return;
      }
      MagicfaceActionManager.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      localObject1 = null;
      if (this.jdField_a_of_type_Int != 0) {
        break label274;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.a("send.xml");
      if (QLog.isColorLevel()) {
        QLog.d(MagicfaceActionManager.jdField_a_of_type_JavaLangString, 2, "func doAction. step 1");
      }
      if (localObject1 == null) {
        break label245;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder.a((String)localObject1);
      if (this.jdField_a_of_type_Int == 1) {
        MagicfaceActionManager.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      }
      MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager, this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder.a((String)localObject1);
      MagicfaceActionManager.d(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_JavaUtilList.iterator();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1;
        Object localObject1;
        Action localAction;
        boolean bool2;
        label245:
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceActionManager", 2, "doaction=Exception=" + localException.toString());
        }
        label274:
        label298:
        return;
        label380:
        if (bool1)
        {
          bool1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b;
          if (!bool1) {}
        }
      }
    }
    finally
    {
      if (!QLog.isColorLevel()) {
        break label414;
      }
      QLog.d("MagicfaceActionManager", 2, "func doAction, 【magic end】");
      label414:
      MagicfaceActionManager.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager, this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData);
    }
    if (((Iterator)localObject1).hasNext())
    {
      localAction = (Action)((Iterator)localObject1).next();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction = localAction;
      localAction.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager;
      localAction.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
      bool1 = localAction.a();
      bool2 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b;
      if (!bool2) {
        break label298;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func doAction, 【magic end】");
      }
      MagicfaceActionManager.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager, this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData);
      return;
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.a("receive.xml");
      break;
      if (!localAction.c) {
        break label380;
      }
      MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jef
 * JD-Core Version:    0.7.0.1
 */