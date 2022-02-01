import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.emosm.EmosmPb.BqAssocInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class igt
  implements EmosmHandler.EmosmHandlerListener
{
  public igt(EmotionPreviewLayout paramEmotionPreviewLayout, EmosmHandler paramEmosmHandler) {}
  
  public void a(boolean paramBoolean, int paramInt, EmosmResp paramEmosmResp)
  {
    if (paramInt == 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(this);
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.b != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.b.equals(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString()))) {}
    }
    else
    {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      Iterator localIterator = paramEmosmResp.data.iterator();
      paramInt = 1;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          EmosmPb.BqAssocInfo localBqAssocInfo = (EmosmPb.BqAssocInfo)localIterator.next();
          EmoticonKeywordForCloud localEmoticonKeywordForCloud = new EmoticonKeywordForCloud();
          localEmoticonKeywordForCloud.loadedType = 0;
          localEmoticonKeywordForCloud.epId = String.valueOf(localBqAssocInfo.u32_tab_id.get());
          localEmoticonKeywordForCloud.eId = localBqAssocInfo.str_item_id.get();
          localEmoticonKeywordForCloud.name = localBqAssocInfo.str_item_name.get();
          localEmoticonKeywordForCloud.encryptKey = localBqAssocInfo.str_item_key.get();
          if ((!TextUtils.isEmpty(localEmoticonKeywordForCloud.epId)) && (!TextUtils.isEmpty(localEmoticonKeywordForCloud.eId)) && (!TextUtils.isEmpty(localEmoticonKeywordForCloud.encryptKey)))
          {
            paramEmosmResp = localBqAssocInfo.rpt_str_item_keyword.get();
            if ((paramEmosmResp != null) && (paramEmosmResp.size() > 0))
            {
              paramEmosmResp = paramEmosmResp.toString();
              label239:
              localEmoticonKeywordForCloud.keyword = paramEmosmResp;
              localEmoticonKeywordForCloud.keywords = paramEmosmResp;
              if (localBqAssocInfo.i32_tab_ringtype.get() <= 3) {
                break label437;
              }
              paramBoolean = true;
              label265:
              localEmoticonKeywordForCloud.isSound = paramBoolean;
              localEmoticonKeywordForCloud.jobType = 0;
              localEmoticonKeywordForCloud.width = 200;
              localEmoticonKeywordForCloud.height = 200;
              localEmoticonKeywordForCloud._index = (localBqAssocInfo.u32_tab_id.get() + EmotionPreviewLayout.f);
              localEmoticonKeywordForCloud.type = localBqAssocInfo.i32_tab_type.get();
              paramInt += 1;
              localEmoticonKeywordForCloud.valid = true;
              localArrayList.add(localEmoticonKeywordForCloud);
              if (localArrayList.size() + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.e < EmotionPreviewLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout)) {
                break label442;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler.removeMessages(10000);
      if (1 == paramInt)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.e > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
          return;
          paramEmosmResp = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
          break label239;
          label437:
          paramBoolean = false;
          break label265;
          label442:
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler, 10000));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler, 10001, localArrayList));
      return;
      continue;
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     igt
 * JD-Core Version:    0.7.0.1
 */