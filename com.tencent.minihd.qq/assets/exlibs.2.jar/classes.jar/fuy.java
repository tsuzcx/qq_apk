import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.MagicFaceDownloadListener;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class fuy
  implements MagicFaceDownloadListener
{
  public fuy(MarketFaceItemBuilder paramMarketFaceItemBuilder) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    label16:
    Object localObject1;
    Emoticon localEmoticon;
    boolean bool;
    label156:
    Object localObject2;
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())
    {
      return;
    }
    else
    {
      localObject1 = ((EmoticonManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramEmoticonPackage.epId).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localEmoticon = (Emoticon)((Iterator)localObject1).next();
        localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)((Iterator)localObject1).next();
            if ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
            {
              localObject1 = localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if ((localHolder.jdField_a_of_type_Boolean) && (localHolder.e.hasWindowFocus()))
              {
                bool = true;
                localObject2 = Boolean.valueOf(bool);
                localHolder.jdField_a_of_type_Boolean = false;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((((Boolean)localObject2).booleanValue()) && (localObject1 != null))
      {
        localObject1 = ((ChatMessage)localObject1).senderuin;
        ((ChatActivity)this.a.jdField_b_of_type_AndroidContentContext).runOnUiThread(new fuz(this, localEmoticon, (String)localObject1));
      }
      localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label16;
      }
      localObject2 = (MarketFaceItemBuilder.Holder)((Iterator)localObject1).next();
      if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (!paramEmoticonPackage.epId.equals(((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))) {
        break;
      }
      ((ChatActivity)this.a.jdField_b_of_type_AndroidContentContext).runOnUiThread(new fva(this));
      this.a.jdField_a_of_type_JavaUtilList.remove(localObject2);
      return;
      bool = false;
      break label156;
      localObject1 = null;
      localObject2 = Boolean.valueOf(false);
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)localIterator.next();
      if ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "Download magic Emoji fail!");
        }
        ((ChatActivity)this.a.jdField_b_of_type_AndroidContentContext).runOnUiThread(new fvb(this, localHolder));
        this.a.jdField_a_of_type_JavaUtilList.remove(localHolder);
      }
    }
  }
  
  public void c(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fuy
 * JD-Core Version:    0.7.0.1
 */