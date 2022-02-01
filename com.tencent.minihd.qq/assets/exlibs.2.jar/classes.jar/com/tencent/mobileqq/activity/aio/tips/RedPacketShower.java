package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.PortalShower;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class RedPacketShower
  extends PortalManager.PortalShower
  implements View.OnClickListener, GrayTipsTask, TipsBarTask
{
  private static final String jdField_a_of_type_JavaLangString = RedPacketShower.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopAioTips jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
  private String b;
  
  public RedPacketShower(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, TipsManager paramTipsManager, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      return 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
      return 2;
    }
    return -1;
  }
  
  public int a()
  {
    return 9;
  }
  
  public View a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null))
    {
      this.b = ((String)paramVarArgs[0]);
      TipsBar localTipsBar = new TipsBar(this.jdField_a_of_type_AndroidAppActivity);
      localTipsBar.setTipsText(this.b);
      localTipsBar.setBarType(4);
      localTipsBar.setOnClickListener(this);
      if ((paramVarArgs[1] != null) && ((paramVarArgs[1] instanceof Bitmap)))
      {
        Object localObject = (Bitmap)paramVarArgs[1];
        paramVarArgs = this.jdField_a_of_type_AndroidAppActivity.getResources();
        localObject = new BitmapDrawable(paramVarArgs, (Bitmap)localObject);
        int i = AIOUtils.a(26.0F, paramVarArgs);
        localTipsBar.setTipsIcon((Drawable)localObject, i, i);
      }
      return localTipsBar;
    }
    return null;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null))
    {
      paramVarArgs = (String)paramVarArgs[0];
      MessageRecord localMessageRecord = MessageRecordFactory.a(-1044);
      long l = MessageCache.a();
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localMessageRecord.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramVarArgs, l, -1044, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
      localMessageRecord.isread = true;
      return localMessageRecord;
    }
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 9))
    {
      paramVarArgs = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(74);
      if (paramVarArgs != null) {
        paramVarArgs.b(this, 4);
      }
    }
  }
  
  public void a(TroopAioTips paramTroopAioTips)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = paramTroopAioTips;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showGrayTips(): msg=" + paramString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "showResult(): uinType not disscussion or troop,just return");
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord.msgtype == -1044)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageRecord.msgtype, localMessageRecord.uniseq);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "find MSG_TYPE_RED_PACKET_TIPS msg");
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { paramString });
  }
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showTip(): msg=" + paramString + ", bmp=" + paramBitmap);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "showTip(): uinType not disscussion or troop,just return");
      }
      return false;
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
      if ((localObject1 != null) && (((HotChatManager)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "showTip(): hotChat not support ,just return");
        }
        return false;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "showTip(): troop is anonymous, just return");
        }
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
        if ((i == 0) || (i == 2) || (i == 5) || (i == 3) || (i == 1) || (i == 4))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "showTip(): hide mTroopTips, type =" + i);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
        }
      }
    }
    if (paramString != null)
    {
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(74);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject2 = new StringBuilder().append("");
      if (localPortalManager != null)
      {
        localObject1 = Integer.valueOf(localPortalManager.a());
        localObject2 = localObject1;
        String str1 = "" + c();
        String str2 = "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        if (localPortalManager == null) {
          break label456;
        }
        localObject1 = localPortalManager.b();
        label399:
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004FF7", "0X8004FF7", 0, 0, (String)localObject2, str1, str2, (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { paramString, paramBitmap });
      }
    }
    for (;;)
    {
      return true;
      localObject1 = String.valueOf(-1);
      break;
      label456:
      localObject1 = String.valueOf(-1);
      break label399;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() == 9) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      }
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 65;
  }
  
  public void onClick(View paramView)
  {
    paramView = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(74);
    if (paramView != null)
    {
      int i = c();
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      paramView.a(this.jdField_a_of_type_AndroidAppActivity, false, 4, new String[] { String.valueOf(i), str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.RedPacketShower
 * JD-Core Version:    0.7.0.1
 */