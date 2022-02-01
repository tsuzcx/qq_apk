package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.ForwardUtils.SectionBase;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Pic;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Text;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dxz;
import dya;
import dyb;
import dyc;
import dyd;
import dye;
import dyf;
import dyg;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class ForwardHandlerActivity
  extends BaseActivity
{
  public static final String a = "send_data_line";
  private Activity a;
  protected final Handler a;
  public SessionInfo a;
  
  public ForwardHandlerActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  }
  
  private void a()
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "已发送", 100).a();
  }
  
  public static void a(Context paramContext)
  {
    dyg localdyg = new dyg();
    DialogUtil.a(paramContext, 233, paramContext.getString(2131367300), paramContext.getString(2131362124), 2131362047, 2131362047, localdyg, null).show();
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.length() > 3478)
    {
      QQToast.a(this, "字数超出限制", 1).b(getTitleBarHeight());
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((DataLineHandler)this.app.a(8)).a(paramString);
  }
  
  private void a(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "sendMultipleFile paths is null !!!!!!");
      }
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
        }
        i += 1;
      }
    }
    Object localObject = new dyd(this, paramArrayList);
    paramArrayList = paramArrayList.iterator();
    long l = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l += new File(str).length();
      }
    }
    if (l == 0L)
    {
      a(this);
      return;
    }
    if ((NetworkUtil.f(this)) && (!NetworkUtil.g(this)) && (l > 5242880L))
    {
      paramArrayList = new dye(this, (AsyncTask)localObject, paramInt);
      localObject = new dyf(this);
      DialogUtil.a(getActivity(), 230, getString(2131362060), getString(2131362061), 2131365736, 2131362063, paramArrayList, (DialogInterface.OnClickListener)localObject).show();
      return;
    }
    ((AsyncTask)localObject).execute(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  private boolean a(Intent paramIntent, int paramInt)
  {
    paramIntent = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (paramInt == 101) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent = a(paramIntent, bool);
      if (paramIntent == null) {
        break;
      }
      ((DataLineHandler)this.app.a(8)).a(paramIntent, false);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838220);
    localQQToast.c(2000);
    localQQToast.b(2131362107);
    localQQToast.a();
  }
  
  private void b(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = paramIntent.getStringExtra("phonenum");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int = paramIntent.getIntExtra("entrance", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.getStringExtra("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int = paramIntent.getIntExtra("add_friend_source_id", 10004);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent.getExtras().containsKey("forward_type"))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.app.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a)) {
        QQToast.a(this.app.a(), 2131363814, 0).b(getTitleBarHeight());
      }
    }
    else {
      return;
    }
    int i = paramIntent.getIntExtra("forward_type", 2147483647);
    if ((i == 1001) || (i == -4)) {
      a(this.app, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramIntent);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dya(this, paramIntent), 500L);
  }
  
  private void d(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("dataline_forward_type", -1);
    if (i == -1) {
      label14:
      return;
    }
    paramIntent.getLongExtra("req_share_id", 0L);
    if (paramIntent.getBooleanExtra("sendMultiple", false)) {
      if (i != 100) {
        break label1198;
      }
    }
    label1198:
    for (int k = 0;; k = 1)
    {
      Object localObject4;
      for (;;)
      {
        for (;;)
        {
          Object localObject1 = paramIntent.getStringArrayListExtra("dataline_forward_pathlist");
          if (localObject1 == null)
          {
            localObject4 = paramIntent.getExtras();
            localObject1 = null;
            paramIntent = (Intent)localObject1;
            if (localObject4 != null)
            {
              localObject4 = ((Bundle)localObject4).getParcelableArrayList("fileinfo_array");
              paramIntent = (Intent)localObject1;
              if (localObject4 == null) {}
            }
            try
            {
              paramIntent = (ArrayList)localObject4;
              if (paramIntent == null)
              {
                b();
                return;
              }
            }
            catch (ClassCastException paramIntent)
            {
              for (;;)
              {
                paramIntent = null;
              }
              localObject1 = new ArrayList();
              localObject4 = (DataLineHandler)this.app.a(8);
              paramIntent = paramIntent.iterator();
              while (paramIntent.hasNext())
              {
                localObject5 = a((ForwardFileInfo)paramIntent.next(), false);
                if (localObject5 != null) {
                  ((ArrayList)localObject1).add(localObject5);
                }
              }
              if (((ArrayList)localObject1).size() > 0)
              {
                ((DataLineHandler)localObject4).a((ArrayList)localObject1, false);
                return;
              }
              b();
              return;
            }
          }
          paramIntent = ((ArrayList)localObject1).iterator();
          int j;
          for (i = 0; paramIntent.hasNext(); i = j)
          {
            localObject4 = (String)paramIntent.next();
            if (localObject4 != null)
            {
              j = i;
              if (!((String)localObject4).equals("/")) {}
            }
            else
            {
              j = i;
              if (i == 0)
              {
                j = 1;
                b();
              }
              paramIntent.remove();
            }
          }
          if (!((ArrayList)localObject1).isEmpty())
          {
            a((ArrayList)localObject1, k);
            return;
          }
          if (i != 0) {
            break;
          }
          b();
          return;
          localObject4 = new ArrayList();
          if (a(paramIntent, i)) {
            break;
          }
          switch (i)
          {
          default: 
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_other");
            return;
          case 101: 
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_image");
            localObject1 = paramIntent.getStringExtra("dataline_forward_path");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label14;
            }
            localObject5 = ((String)localObject1).split(";");
            ((ArrayList)localObject4).clear();
            i = 0;
            if (i < localObject5.length) {
              try
              {
                localObject1 = URLDecoder.decode(localObject5[i], "UTF-8");
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  if ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://")))
                  {
                    a((String)localObject1);
                    ReportController.b(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                    if (QLog.isColorLevel()) {
                      QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                    }
                    i += 1;
                  }
                }
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break label14;
                }
                QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject5[i]);
                return;
              }
              catch (IllegalArgumentException localIllegalArgumentException1)
              {
                for (;;)
                {
                  localObject2 = localObject5[i];
                  continue;
                  ((ArrayList)localObject4).add(localObject2);
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqdataline", 2, "gotoQfavShareMsg|file path invalid. path=" + (String)localObject2);
                  }
                }
              }
            }
            break;
          }
        }
        if (((ArrayList)localObject4).isEmpty()) {
          break;
        }
        a((ArrayList)localObject4, 1);
        if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
          break;
        }
        if (((ArrayList)localObject4).size() > 1)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
          return;
        }
        if (((ArrayList)localObject4).size() != 1) {
          break;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
        return;
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_file");
        Object localObject2 = paramIntent.getStringExtra("dataline_forward_path");
        if ((localObject2 == null) || (((String)localObject2).equals("")))
        {
          b();
          return;
        }
        Object localObject5 = ((String)localObject2).split(";");
        ((ArrayList)localObject4).clear();
        i = 0;
        if (i < localObject5.length) {
          try
          {
            localObject2 = URLDecoder.decode(localObject5[i], "UTF-8");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              if ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
              {
                a((String)localObject2);
                i += 1;
              }
            }
          }
          catch (UnsupportedEncodingException paramIntent)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject5[i]);
            return;
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            for (;;)
            {
              Object localObject3 = localObject5[i];
              continue;
              ((ArrayList)localObject4).add(localObject3);
              continue;
              if (QLog.isColorLevel()) {
                QLog.e("qqdataline", 2, "shareFromMigSdk|file path invalid. path=" + localObject3);
              }
            }
          }
        }
      }
      if (((ArrayList)localObject4).isEmpty()) {
        break;
      }
      switch (FileManagerUtil.a((String)((ArrayList)localObject4).get(0)))
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        a((ArrayList)localObject4, i);
        if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
          break;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
        return;
        i = 1;
        continue;
        i = 3;
        continue;
        i = 2;
      }
      paramIntent = paramIntent.getStringExtra("dataline_forward_text");
      if ((paramIntent == null) || (paramIntent.length() <= 0)) {
        break;
      }
      if (Patterns.b.matcher(paramIntent).find()) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_link");
      }
      for (;;)
      {
        a(paramIntent);
        return;
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_forwardin_text");
      }
    }
  }
  
  DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean)
  {
    if (paramForwardFileInfo == null) {
      return null;
    }
    FileManagerEntity localFileManagerEntity = this.app.a().a(paramForwardFileInfo.b());
    int k = DataLineHandler.a(localFileManagerEntity);
    boolean bool = DataLineHandler.b(k);
    int j = DataLineHandler.a(paramForwardFileInfo.d(), paramBoolean);
    if (QLog.isDevelopLevel()) {
      QLog.i("qqBaseActivity", 4, "转发文件, name[" + paramForwardFileInfo.d() + "], LocalPath[" + paramForwardFileInfo.a() + "], FileSize[" + paramForwardFileInfo.d() + "], fileFrom[" + k + "], bSupportForward[" + bool + "], eFileType[" + j + "], " + paramForwardFileInfo.toString());
    }
    if (!bool) {
      return null;
    }
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (j == 1) {
        i = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = DataLineHandler.c(i);
    localDataLineMsgRecord.sessionid = 0L;
    localDataLineMsgRecord.filename = paramForwardFileInfo.d();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.d();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.b();
    localDataLineMsgRecord.fileFrom = k;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.f();
    if (localFileManagerEntity != null)
    {
      if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
        localDataLineMsgRecord.md5 = HexUtil.a(localFileManagerEntity.strFileMd5);
      }
      if (!TextUtils.isEmpty(localFileManagerEntity.peerUin)) {
        localDataLineMsgRecord.uOwnerUin = Long.parseLong(localFileManagerEntity.peerUin.replace("+", ""));
      }
      if (!TextUtils.isEmpty(paramForwardFileInfo.a())) {
        break label346;
      }
    }
    label346:
    for (localDataLineMsgRecord.path = paramForwardFileInfo.d();; localDataLineMsgRecord.path = paramForwardFileInfo.a())
    {
      return localDataLineMsgRecord;
      localDataLineMsgRecord.uOwnerUin = Long.parseLong(this.app.a());
      break;
    }
  }
  
  public void a(Intent paramIntent)
  {
    long l1 = 0L;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.app.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a)) {
      QQToast.a(this.app.a(), 2131363814, 0).b(getTitleBarHeight());
    }
    int i;
    Object localObject2;
    do
    {
      do
      {
        return;
        i = paramIntent.getIntExtra("forward_type", 2147483647);
      } while (i == 2147483647);
      paramIntent.removeExtra("forward_type");
      paramIntent.getExtras().remove("forward_type");
      localObject1 = paramIntent.getStringExtra("forward_filepath");
      switch (i)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      default: 
        return;
      case -3: 
      case 19: 
      case 20: 
        a(this.app, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramIntent);
        return;
      case -1: 
        paramIntent = paramIntent.getStringExtra("forward_text");
        if (!TextUtils.isEmpty(paramIntent)) {
          AnonymousChatHelper.a().a = true;
        }
        ChatActivityFacade.b(this.app, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
        return;
      case 0: 
        try
        {
          localObject2 = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
          if (paramIntent.getBooleanExtra("foward_editbar", false)) {
            break label439;
          }
          if ((localObject2 == null) || (((ForwardFileInfo)localObject2).d() != 3)) {
            break label417;
          }
          if ((!FileManagerUtil.a()) || (((ForwardFileInfo)localObject2).d() <= 5242880L)) {
            break label395;
          }
          FMDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131362469, 2131362465, new dyb(this, paramIntent, (String)localObject1, (ForwardFileInfo)localObject2));
          return;
        }
        catch (Exception paramIntent) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("qqBaseActivity", 2, "FORWARD_TYPE.FILE failed. " + paramIntent, paramIntent);
    return;
    label395:
    ChatActivityFacade.a(this.app, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (ForwardFileInfo)localObject2, false);
    return;
    label417:
    ChatActivityFacade.a(this.app, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (ForwardFileInfo)localObject2, false);
    return;
    label439:
    Object localObject1 = paramIntent.getParcelableArrayListExtra("fileinfo_array");
    long l2 = l1;
    if (localObject1 != null)
    {
      l2 = l1;
      if (((ArrayList)localObject1).size() > 0) {
        localObject2 = ((ArrayList)localObject1).iterator();
      }
    }
    for (;;)
    {
      l2 = l1;
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ForwardFileInfo)((Iterator)localObject2).next();
        if (((ForwardFileInfo)localObject3).d() == 3) {
          l1 += ((ForwardFileInfo)localObject3).d();
        }
      }
      else
      {
        if ((FileManagerUtil.a()) && (l2 > 5242880L))
        {
          FMDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131362469, 2131362465, new dyc(this, (ArrayList)localObject1, paramIntent));
          return;
        }
        if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ForwardFileInfo)((Iterator)localObject1).next();
          ChatActivityFacade.a(this.app, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, ((ForwardFileInfo)localObject2).a(), (ForwardFileInfo)localObject2, true);
        }
        boolean bool1 = paramIntent.getBooleanExtra("isFromShare", false);
        boolean bool2 = paramIntent.getBooleanExtra("sendMultiple", false);
        Object localObject4;
        if (bool1)
        {
          if (bool2) {
            break;
          }
          localObject2 = paramIntent.getStringExtra("forward_download_image_task_key");
          localObject3 = paramIntent.getStringExtra("forward_download_image_org_uin");
          i = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
          localObject4 = paramIntent.getStringExtra("forward_download_image_server_path");
          l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
          ChatActivityFacade.a(this.app, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject4, (String)localObject3, l1, i, (String)localObject2);
          return;
        }
        paramIntent.putExtra("FORWARD_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramIntent.putExtra("SENDER_TROOP_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        paramIntent.putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramIntent.putExtra("FORWARD_SELF_UIN", this.app.a());
        i = paramIntent.getIntExtra("BUSI_TYPE", 1009);
        int j = paramIntent.getIntExtra("forward_source_uin_type", -1);
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "report forward! forwardFilePath = " + (String)localObject1 + ",forwardSourceUinType = " + j);
        }
        if (localObject1 != null)
        {
          l1 = paramIntent.getLongExtra("forward_image_width", 0L);
          l2 = paramIntent.getLongExtra("forward_image_height", 0L);
          int k = paramIntent.getIntExtra("forward_image_type", 0);
          StatisticConstants.a(AppConstants.aL + "#" + l1 + "#" + l2 + "#" + k, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, j, this.app);
        }
        paramIntent = PicBusiManager.a(i, paramIntent);
        localObject1 = PicBusiManager.a(3, i);
        ((PicReq)localObject1).a(paramIntent);
        PicBusiManager.a((PicReq)localObject1, this.app);
        return;
        if (ChatActivityFacade.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1) == -1L) {
          break;
        }
        return;
        if (paramIntent.getBooleanExtra("isFromFavorites", false))
        {
          localObject4 = paramIntent.getExtras();
          if (localObject4 == null) {
            break;
          }
          paramIntent = ((Bundle)localObject4).getString("forward_latitude");
          localObject1 = ((Bundle)localObject4).getString("forward_longitude");
          localObject2 = ((Bundle)localObject4).getString("forward_location");
          localObject3 = ((Bundle)localObject4).getString("title");
          localObject4 = ((Bundle)localObject4).getString("summary");
          ChatActivityFacade.a(this.jdField_a_of_type_AndroidAppActivity, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, "");
          return;
        }
        localObject1 = paramIntent.getStringExtra("forward_latitude");
        localObject2 = paramIntent.getStringExtra("forward_longitude");
        paramIntent = paramIntent.getStringExtra("forward_location");
        ChatActivityFacade.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject2, paramIntent);
        return;
        localObject1 = paramIntent.getExtras().getParcelableArrayList("forward_composite").iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          switch (((ForwardUtils.SectionBase)localObject2).jdField_a_of_type_Int)
          {
          case 0: 
          default: 
            break;
          case -1: 
            if (!TextUtils.isEmpty(((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString)) {
              AnonymousChatHelper.a().a = true;
            }
            ChatActivityFacade.b(this.app, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString);
            break;
          case 1: 
            localObject3 = paramIntent.getStringExtra("forward_download_image_task_key");
            localObject4 = paramIntent.getStringExtra("forward_download_image_org_uin");
            i = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
            String str = paramIntent.getStringExtra("forward_download_image_server_path");
            l1 = paramIntent.getLongExtra("forward_download_image_item_id", -1L);
            ChatActivityFacade.a(this.app, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((ForwardUtils.Section_Pic)localObject2).b, str, (String)localObject4, l1, i, (String)localObject3);
          }
        }
        if (2 == MarketFaceItemBuilder.n) {
          ReportController.b(this.app, "CliOper", "", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          paramIntent = MarketFaceItemBuilder.a;
          AnonymousChatHelper.a().a = true;
          paramIntent.a(this.app, this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
          return;
          ReportController.b(this.app, "CliOper", "", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send_aio", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageObserver paramMessageObserver, Intent paramIntent)
  {
    try
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (QLog.isDevelopLevel()) {
        QLog.d("Fight", 4, "fight.test.AbsStructMsg.STRUCT_TYPE_MULTI_MSG = 35");
      }
      while (localAbsStructMsg != null)
      {
        if ((localAbsStructMsg instanceof StructMsgForImageShare))
        {
          String str = paramIntent.getStringExtra("share_comment_message");
          paramMessageObserver = str;
          if (TextUtils.isEmpty(str)) {
            paramMessageObserver = localAbsStructMsg.mCommentText;
          }
          if (!TextUtils.isEmpty(paramMessageObserver))
          {
            AnonymousChatHelper.a().a = true;
            ChatActivityFacade.b(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageObserver);
          }
          paramIntent.removeExtra("forward_type");
          paramIntent.removeExtra("res_share_id");
          return;
        }
        if (35 == localAbsStructMsg.mMsgServiceID)
        {
          paramMessageObserver = MultiMsgManager.a().a.iterator();
          do
          {
            if (!paramMessageObserver.hasNext()) {
              break;
            }
          } while (((ChatMessage)paramMessageObserver.next()).isSend());
        }
        for (paramMessageObserver = Boolean.valueOf(false);; paramMessageObserver = Boolean.valueOf(true))
        {
          if (paramMessageObserver.booleanValue())
          {
            MultiMsgManager.a().a(paramQQAppInterface, paramContext, paramSessionInfo, null, paramIntent, MultiMsgManager.a().a);
            break;
          }
          MultiMsgManager.a().b();
          MultiMsgManager.a().c();
          paramMessageObserver = ShareMsgHelper.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, localAbsStructMsg);
          MultiMsgManager.a().b("StructMsg save db ");
          MultiMsgManager.a().c();
          MultiMsgManager.a().a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, MultiMsgManager.a().a, MultiMsgManager.a().b, paramMessageObserver, null);
          break;
          ShareMsgHelper.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, localAbsStructMsg, null);
          break;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidAppActivity = this;
    paramBundle = getIntent();
    if (paramBundle.getBooleanExtra("send_data_line", false)) {
      d(paramBundle);
    }
    for (;;)
    {
      a();
      return true;
      b(paramBundle);
      c(paramBundle);
    }
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    runOnUiThread(new dxz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardHandlerActivity
 * JD-Core Version:    0.7.0.1
 */