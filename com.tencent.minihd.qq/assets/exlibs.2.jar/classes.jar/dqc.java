import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;

public class dqc
  extends Handler
{
  public dqc(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    Object localObject3;
    Object localObject2;
    do
    {
      Object localObject4;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          Object localObject1;
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                    if (paramMessage.what == 1)
                                    {
                                      this.a.d();
                                      return;
                                    }
                                    if (paramMessage.what == 6)
                                    {
                                      if (QLog.isColorLevel()) {
                                        QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_TROOP_MEMBER_CARD");
                                      }
                                      if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_JavaLangString))
                                      {
                                        this.a.a(9, this.a.app.c(), true);
                                        return;
                                      }
                                      this.a.a(9, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_JavaLangString, true);
                                      return;
                                    }
                                  } while (paramMessage.what == 12);
                                  if (paramMessage.what != 5) {
                                    break;
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_INFO");
                                  }
                                  this.a.a(5, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString, true);
                                  this.a.y();
                                  this.a.a(true);
                                  this.a.f();
                                  this.a.a(this.a.jdField_c_of_type_JavaUtilList);
                                } while ((this.a.av != 1) || (this.a.jdField_b_of_type_JavaUtilList == null) || (this.a.jdField_b_of_type_JavaUtilList.size() < ChatSettingForTroop.a(this.a)));
                                paramMessage = (ImageView)this.a.jdField_b_of_type_JavaUtilList.get(ChatSettingForTroop.a(this.a) - 1);
                              } while ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()));
                              paramMessage.setVisibility(8);
                              return;
                              if (paramMessage.what == 2)
                              {
                                switch (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_Int)
                                {
                                default: 
                                  localObject1 = "";
                                  paramMessage = "";
                                }
                                for (;;)
                                {
                                  localObject3 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[10];
                                  if (localObject3 == null) {
                                    break;
                                  }
                                  ((FormSimpleItem)((View)localObject3).findViewById(2131300632)).setRightText((CharSequence)localObject1);
                                  ((TextView)((View)localObject3).findViewById(2131297125)).setText(paramMessage);
                                  return;
                                  localObject1 = this.a.getString(2131368179);
                                  paramMessage = this.a.getString(2131363796);
                                  continue;
                                  localObject1 = this.a.getString(2131363788);
                                  paramMessage = this.a.getString(2131363798);
                                  continue;
                                  localObject1 = this.a.getString(2131368181);
                                  paramMessage = this.a.getString(2131363799);
                                  continue;
                                  localObject1 = this.a.getString(2131363787);
                                  paramMessage = this.a.getString(2131363797);
                                }
                              }
                            } while (paramMessage.what == 3);
                            if (paramMessage.what == 4)
                            {
                              paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[1];
                              localObject1 = this.a;
                              i = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_Int;
                              if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i != 0) {}
                              for (bool = true;; bool = false)
                              {
                                ((ChatSettingForTroop)localObject1).a(paramMessage, i, bool);
                                return;
                              }
                            }
                            if (paramMessage.what != 8) {
                              break;
                            }
                            paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[2];
                          } while (paramMessage == null);
                          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k != 0)
                          {
                            ReportController.b(this.a.app, "CliOper", "", "", "Grp", "files_hotpoint", 0, 0, "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "");
                            if (QLog.isDevelopLevel()) {
                              QLog.d("files_hotpoint", 4, "troopUin :" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
                            }
                            if (ChatSettingForTroop.a(this.a) != null) {}
                          }
                          try
                          {
                            long l = Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c).longValue();
                            ChatSettingForTroop.a(this.a, TroopFileManager.a(this.a.app, l));
                            if (ChatSettingForTroop.a(this.a) != null) {
                              ChatSettingForTroop.a(this.a).a(3, 0, 1);
                            }
                            localObject1 = this.a;
                            i = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.j;
                            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k != 0)
                            {
                              bool = true;
                              ((ChatSettingForTroop)localObject1).a(paramMessage, i, bool);
                              return;
                            }
                          }
                          catch (NumberFormatException localNumberFormatException)
                          {
                            for (;;)
                            {
                              if (QLog.isDevelopLevel())
                              {
                                QLog.e("Q.chatopttroop", 4, "NumberFormatException");
                                continue;
                                bool = false;
                              }
                            }
                          }
                        } while (paramMessage.what == 7);
                        if (paramMessage.what != 9) {
                          break;
                        }
                        paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[0];
                      } while (paramMessage == null);
                      localObject2 = this.a;
                      i = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l;
                      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l != 0) {}
                      for (bool = true;; bool = false)
                      {
                        ((ChatSettingForTroop)localObject2).a(paramMessage, i, bool);
                        this.a.a(paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l);
                        return;
                      }
                      if (paramMessage.what != 15) {
                        break;
                      }
                      localObject2 = (View)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get((Long)paramMessage.obj);
                    } while (localObject2 == null);
                    localObject3 = this.a;
                    if (paramMessage.arg1 != 0) {}
                    for (bool = true;; bool = false)
                    {
                      ((ChatSettingForTroop)localObject3).a((View)localObject2, 0, bool);
                      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (paramMessage.arg1 <= 0)) {
                        break;
                      }
                      ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "Exp_data_appEntry_new", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "", "" + ((View)localObject2).getTag());
                      return;
                    }
                    if (paramMessage.what != 10) {
                      break;
                    }
                    paramMessage = paramMessage.getData();
                    localObject2 = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
                    int i = paramMessage.getInt("newSeq");
                    int j = paramMessage.getInt("CMD_TYPE");
                    paramMessage = new ArrayList();
                    if (localObject2 != null)
                    {
                      localObject2 = ((List)localObject2).iterator();
                      while (((Iterator)localObject2).hasNext())
                      {
                        localObject3 = (String)((Iterator)localObject2).next();
                        localObject4 = new AvatarWallAdapter.AvatarInfo();
                        ((AvatarWallAdapter.AvatarInfo)localObject4).b = ((String)localObject3);
                        ((AvatarWallAdapter.AvatarInfo)localObject4).c = "AVATAR_URL_STR";
                        paramMessage.add(localObject4);
                      }
                    }
                    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null) {
                      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramMessage, i, j);
                    }
                  } while (ChatSettingForTroop.b(this.a));
                  ChatSettingForTroop.a(this.a, true);
                  this.a.x();
                  return;
                  if (paramMessage.what != 11) {
                    break;
                  }
                } while (!(paramMessage.obj instanceof String));
                paramMessage = (String)paramMessage.obj;
              } while (this.a.jdField_a_of_type_AndroidWidgetTextView == null);
              if ((this.a.jdField_b_of_type_AndroidViewView != null) && (this.a.jdField_b_of_type_AndroidViewView.getVisibility() == 8)) {
                this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
              }
              this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
              return;
              if (paramMessage.what == 14)
              {
                this.a.x();
                return;
              }
              if (paramMessage.what == 13)
              {
                paramMessage = (ArrayList)paramMessage.obj;
                ChatSettingForTroop.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e(), paramMessage);
                this.a.a("Grp", "Clk_invite_new", "0");
                return;
              }
              if (paramMessage.what != 16) {
                break;
              }
            } while (!ChatSettingForTroop.c(this.a));
            paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[19];
            localObject2 = this.a;
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m != 0) {}
            for (bool = true;; bool = false)
            {
              ((ChatSettingForTroop)localObject2).a(paramMessage, 0, bool);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.chatopttroop", 2, "群活动小红点: " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
              return;
            }
          } while (paramMessage.what != 17);
          localObject3 = (JSONObject)paramMessage.obj;
          paramMessage = ((JSONObject)localObject3).optString("tab_name");
          localObject2 = ((JSONObject)localObject3).optString("name");
          localObject3 = ((JSONObject)localObject3).optString("content");
          if ((TextUtils.isEmpty(paramMessage)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
            break;
          }
        } while (this.a.jdField_c_of_type_Boolean);
        localObject4 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[19];
      } while (localObject4 == null);
      if (((View)localObject4).getVisibility() != 0) {
        ((View)localObject4).setVisibility(0);
      }
      ChatSettingForTroop.b(this.a, true);
      ChatSettingForTroop localChatSettingForTroop = this.a;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localChatSettingForTroop.a((View)localObject4, 0, bool);
        this.a.a((View)localObject4, HttpUtil.d((String)localObject2), HttpUtil.d((String)localObject3), paramMessage);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, "NullExcption: 群活动数据: name = " + (String)localObject2 + ", content = " + (String)localObject3 + ", tabName = " + paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dqc
 * JD-Core Version:    0.7.0.1
 */